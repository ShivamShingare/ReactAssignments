import React , {Component} from "react";

class Counter extends Component{
    constructor (props){
        super(props);
        this.state = {
            count:0,
        };
    }

    increment = () =>{
        this.setState({count:this.state.count +1});
    };

    render(){
        return(
            <>
                <h1>Counter = {this.state.count}</h1>
                <button onClick = {this.increment}>Increment Counter</button>
            </>
        );
    }
       
    
}
export default Counter;