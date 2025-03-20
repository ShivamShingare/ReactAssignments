import React, { Component } from 'react';

class Form extends Component {
  // Initializing state in the constructor
  constructor(props) {
    super(props);
    // State to hold form data
    this.state = {
      name: '',
      email: ''
    };
  }

  // Handle change for the name field
  handleNameChange = (event) => {
    this.setState({ name: event.target.value });
  };

  // Handle change for the email field
  handleEmailChange = (event) => {
    this.setState({ email: event.target.value });
  };

  // Handle form submission
  handleSubmit = (event) => {
    event.preventDefault(); // Prevent the default form submission
    // You can process or display the form data
    console.log('Form submitted:', this.state.name, this.state.email);
  };

  render() {
    return (
      <div>
        <h1>Form Example</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name:</label>
            <input
              type="text"
              value={this.state.name}
              onChange={this.handleNameChange} // Update name in state
            />
          </div>
          <div>
            <label>Email:</label>
            <input
              type="email"
              value={this.state.email}
              onChange={this.handleEmailChange} // Update email in state
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Form;
