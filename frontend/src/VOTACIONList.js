import React, { Component } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import AppNavbar from "./AppNavbar";
import { Link } from "react-router-dom";

class VOTACIONList extends Component {
  constructor(props) {
    super(props);
    this.state = { votacion: [] };
    this.remove = this.remove.bind(this);
    this.disableAF = false;
    this.disableEC = false;
  }
  componentDidMount() {
    fetch("/votacions")
      .then((response) => response.json())
      .then((data) => this.setState({ votacion: data }));
  }
   componentDidUpdate() {
    fetch("/votacions")
      .then((response) => response.json())
      .then((data) => this.setState({ votacion: data }));
  }

  async remove(idvotacion) {
    await fetch(`/votacions/${idvotacion}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then(() => {
      let updatedVOTACIONES = [...this.state.votacion].filter(
        (i) => i.idvotacion !== idvotacion
      );
      this.setState({ votacion: updatedVOTACIONES });
    });
  }

  async sumar(idvotacion) {

      if(this.disableAF ||  this.disableEC){
          await fetch(`/votacions/${idvotacion}/incrementa`, {
      method: "POST", 
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
      }
      this.disableAF = true;
      this.disableEC = false;

    await fetch(`/votacions/${idvotacion}/incrementa`, {
      method: "POST", 
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })/*.then(() => {
      let updatedVOTACIONES = [...this.state.votacion].filter(
        (i) => i.idvotacion !== idvotacion
      );
      this.setState({ votacion: updatedVOTACIONES }); //PREGUNTAR QUE HAY QUE CAMBIAR
    });*/
  }
  async restar(idvotacion) {

      if(this.disableAF ||  this.disableEC) {
          await fetch(`/votacions/${idvotacion}/resta`, {
      method: "POST", // RESTAR UNO
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
      }
      
      this.disableAF = false;
      this.disableEC = true;
    await fetch(`/votacions/${idvotacion}/resta`, {
      method: "POST", // RESTAR UNO
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })/*.then(() => {
      let updatedVOTACIONES = [...this.state.votacion].filter(
        (i) => i.idvotacion !== idvotacion
      );
      this.setState({ votacion: updatedVOTACIONES }); //PREGUNTAR QUE HAY QUE CAMBIAR
    });*/
  }

  

  render() {
    const votacionList = this.state.votacion.map((votacion) => {
      return (
        <tr key={votacion.idvotacion}>
          <td>{votacion.fechayhoralimite}</td>
          <td>{votacion.tema}</td>
          
          <td>
            <ButtonGroup>
              <Button
                size="sm"
                color="primary"
                disabled = {this.disableAF}
                onClick={() => this.sumar(votacion.idvotacion)}
              >
                Votar a Favor
              </Button>
              <Button
                size="sm"
                color="danger"
                disabled = {this.disableEC}
                onClick={() => this.restar(votacion.idvotacion)}
              >
                Votar en Contra
              </Button>
            </ButtonGroup>
            <p>{votacion.votos}</p>
          </td>

          <td>
            <ButtonGroup>
              <Button
                size="sm"
                color="primary"
                tag={Link}
                to={"/votacions/" + votacion.idvotacion}
              >
                Edit
              </Button>
              <Button
                size="sm"
                color="danger"
                onClick={() => this.remove(votacion.idvotacion)}
              >
                Delete
              </Button>
            </ButtonGroup>

          </td>
        </tr>
      );
    });

    return (
      <>
        <div>
          <AppNavbar />
          <h3>VOTACIONES DISPONIBLES</h3>
        </div>
        <div>
          <Container fluid>
            <div className="float-right">
              <Button color="success" tag={Link} to="/votacions/new">
                Añadir Votación
              </Button>
            </div>

            <Table
                className="mt-4"
                style={{
                  borderBottom: "solid 3px black",
                  background: "grey",
                  color: "white",
                  fontWeight: "bold",
                }}
              >
              <thead>
                <tr>
                  <th width="15%">Fecha y Hora límite</th>
                  <th width="30%">Tema</th>
                  <th width="30%">Votar</th>
                  <th width="15%">Acciones</th>
                </tr>
              </thead>
              <tbody>{votacionList}</tbody>
            </Table>
          </Container>
        </div>
      </>
    );
  }
}

export default VOTACIONList;
