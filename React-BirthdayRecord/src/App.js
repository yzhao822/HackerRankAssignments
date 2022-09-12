import React, { useState } from 'react'
import Radio from "./components/Radio"
import Table from "./components/Table"
import "h8k-components"

const title = "Birthday Records"

function App() {
  //Hooks can only be called inside the body of a function component
  const [sortTerm, setSortTerm] = useState('');
  
  return (
    <div>
      <h8k-navbar header={title}></h8k-navbar>
      <Radio setSortTerm={setSortTerm}/>
      <Table sortTerm={sortTerm}/>
    </div>
  )
}

export default App