import React, { Component } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import AppNavbar from "./AppNavbar";
import { Link } from "react-router-dom";

class RESERVAList extends Component {
  constructor(props) {
    super(props);
    this.state = { reserva: [] };
    this.remove = this.remove.bind(this);
  }

  componentDidMount() {
    fetch("/reunions")
      .then((response) => response.json())
      .then((data) => this.setState({ reserva: data }));
  }

  async remove(IdReservas) {
    await fetch(`/reservas/${IdReservas}`, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    }).then(() => {
      let updatedreservas = [...this.state.reserva].filter(
        (i) => i.IdReservas !== IdReservas
      );
      this.setState({ reserva: updatedreservas });
    });
  }

  

  

  render() {
    const RESERVAList = this.state.reserva.map((reserva) => {
      return (
        <tr key={reserva.IdReservas}>
          <td style={{ whiteSpace: "nowrap" }}>{reserva.IdReservas}</td>
          <td>{reserva.fechayhorareservada}</td>
          <td>{reserva.espacioreservado}</td>
          
          

          <td>
            <ButtonGroup>
              <Button
                size="sm"
                color="primary"
                tag={Link}
                to={"/reservas/" + reserva.IdReservas}
              >
                Edit
              </Button>
              <Button
                size="sm"
                color="danger"
                onClick={() => this.remove(reserva.IdReservas)}
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
          <h3>RESERVAS</h3>
        </div>
        <div>
          <Container fluid>
            <div className="float-right">
              <Button color="success" tag={Link} to="/reservas/new">
                Añadir Reserva
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
                  <th width="30%">IdReserva</th>
                  <th width="30%">Fecha y Hora Reservada</th>
                  <th width="30%">Espacio Reservado</th>
                  
                </tr>
              </thead>
              <tbody>{RESERVAList}</tbody>
            </Table>
          </Container>
        </div>
      </>
    );
  }
}

export default RESERVAList;
