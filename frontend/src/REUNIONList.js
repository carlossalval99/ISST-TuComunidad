import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class REUNIONList extends Component {

    constructor(props) {
        super(props);
        this.state = {reunion: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/reunions')
            .then(response => response.json())
            .then(data => this.setState({reunion: data}));
    }

    async remove(idreunion) {
        await fetch(`/reunions/${idreunion}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedREUNIONs = [...this.state.reunion].filter(i => i.idreunion !== idreunion);
            this.setState({reunion: updatedREUNIONs});
        });
    }

    render() {
        

        const reunionList = this.state.reunion.sort((a,b)=>a.fechayhora > b.fechayhora ? 1 : -1).map(reunion => {
            return <tr key={reunion.idreunion}>
                <td style={{whiteSpace: 'nowrap'}}>{reunion.idreunion}</td>
                <td>{reunion.fechayhora}</td>
                <td>{reunion.descripcion}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/reunions/" + reunion.idreunion}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(reunion.idreunion)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
          <div>
            <AppNavbar />
            <Container fluid>
              <div className="float-right">
              <h3>REUNIONES</h3>
                <Button color="success" tag={Link} to="/reunions/new">
                  Añadir reunión
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
                    <th width="30%">Nº</th>
                    <th width="30%">Fecha y hora</th>
                    <th width="30%">Detalles de la reunion</th>
                  </tr>
                </thead>
                <tbody>{reunionList}</tbody>
              </Table>
            </Container>
          </div>
        );
    }
}

export default REUNIONList;