import React, { useEffect } from "react";
import { useState } from "react";


function Table({ sortTerm }) {
  const intialPeople = [
    {
      name: "Rhianna Johnson",
      birth: "11/30/2011",
    },
    {
      name: "Aiden Shaw",
      birth: "09/16/1992",
    },
    {
      name: "Trevon Floyd",
      birth: "01/16/1992",
    },
    {
      name: "Melanie Yates",
      birth: "12/12/2001",
    },
    {
      name: "Chris Andrews",
      birth: "02/09/1891",
    },
    {
      name: "Jacinda Miller",
      birth: "12/01/1982",
    },
    {
      name: "Will Davis",
      birth: "11/30/2011",
    },
    {
      name: "Eliza Baxter",
      birth: "10/31/1999",
    },
  ];

  //use a useState hook to track people
  const [people, setPeople] = useState(intialPeople);

  const sortByName = () => {

    let deepIntialPeople = [...intialPeople];
    deepIntialPeople = people.sort((a, b) => {
      return a.name.localeCompare(b.name);
    });
    setPeople([...deepIntialPeople]);
  };

  const sortByAge = () => {
    let deepIntialPeople = [...intialPeople];
    deepIntialPeople = deepIntialPeople.sort((a, b) => {
      return new Date(a.birth).getTime() - new Date(b.birth).getTime();
    });
    setPeople([...deepIntialPeople]);
  };

  //use useEffect to control the side effect, dependency array is sortTerm, everytime sortTerm value changes, it will run the code
  useEffect(() => {
    if (sortTerm === "sortByName") {
      sortByName();
    }
    if (sortTerm === "sortByAge") {
      sortByAge();
    }
  }, [sortTerm]);

  return (
    <div className="table-div">
      <div className="card w-50 mx-auto mt-20 pb-30">
        <table data-testid="table">
          <thead>
            <tr>
              <th className="course-name">Person Name</th>
              <th className="duration">Date of Birth</th>
            </tr>
          </thead>
          <tbody>
            {people.map((person, i) => {
              const { name, birth } = person;
              return (
                <tr key={i}>
                  <td>{name}</td>
                  <td>{birth}</td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default Table;








