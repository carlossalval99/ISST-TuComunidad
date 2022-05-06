import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import './Home.css';
import logoComVec from './logoComVec.png'

class Home extends Component {

    state= {
        form:{
            piso: '',
            contraseña: ''
        }
    }

    handleChange= async e=>{
        await this.setState({
            form:{
                ...this.state.form,
                [e.target.name]: e.target.value
            }
        });
    }

    iniciarSesion = async ()=>{
        await fetch(`/vecinos`, {
            method: "GET", 
            headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            }
        

    })
    .then((response) => response.json())
    .then((data) => console.log(data));

    }
    render() {
        return (
            <div>
                <img src={logoComVec}  className="logo"/>
            <div className= "containerPrincipal">
                <div className= "containerSecundario">
                    <div className= "form-group">
                        <label>Usuario:</label>
                        <br />
                        <input 
                        type="text" 
                        className="form-control" 
                        name="piso"
                        onChange={this.handleChange}
                        />
                        <label>Contraseña:</label>
                        <br />
                        <input type="password" 
                        className="form-control"
                         name="contraseña"
                         onChange={this.handleChange}
                        />
                        <br />

                <Container fluid>
                <Button color="link"><Link to="/infos">INICIAR SESION</Link></Button>
                </Container>
                </div>
            </div>
        </div>
        </div>
        );
    }
}

export default Home;