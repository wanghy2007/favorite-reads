'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {books: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/books'}).done(response => {
            this.setState({books: response.entity._embedded.books});
        });
    }

    render() {
        return (
            <BookList books={this.state.books}/>
        );
    }
}

class BookList extends React.Component {
    render() {
        const books = this.props.books.map(book =>
            <Book key={book._links.self.href} book={book}/>
        );
        return (
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                    </tr>
                </thead>
                <tbody>
                    {books}
                </tbody>
            </table>
        );
    }
}

class Book extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.book.title}</td>
            </tr>
        );
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
