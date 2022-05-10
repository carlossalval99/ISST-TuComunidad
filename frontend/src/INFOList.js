import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class INFOList extends Component {

    constructor(props) {
        super(props);
        this.state = {info: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/infos')
            .then(response => response.json())
            .then(data => this.setState({info: data}));
    }

    async remove(idinfo) {
        await fetch(`/infos/${idinfo}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedINFOs = [...this.state.info].filter(i => i.idinfo !== idinfo);
            this.setState({info: updatedINFOs});
        });
    }

    render() {
        

        const infoList = this.state.info.map(info => {
            return <tr key={info.idinfo}>
                <td style={{whiteSpace: 'nowrap'}}>{info.idinfo}</td>
                <td>{info.tema}</td>
                <td>{info.contenido}</td>
                <td>{info.vecino}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/infos/" + info.idinfo}>Editar</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(info.idinfo)}>Eliminar</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
          <div>
            <AppNavbar />
            <Container fluid>
              <div className="float-right">
              <h3>TABLÓN DE INFORMACIÓN</h3>
                <Button color="success" tag={Link} to="/infos/new">
                  Añadir publicación
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
                    <th width="15%">Nº</th>
                    <th width="15%">Tema</th>
                    <th width="30%">Publicación</th>
                    <th width="15%">Vecino</th>
                    <th width="15%">Acciones</th>
                  </tr>
                </thead>
                <tbody>{infoList}</tbody>
              </Table>
            </Container>
          </div>
        );
    }
}

export default INFOList;