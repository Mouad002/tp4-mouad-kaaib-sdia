import React, { useEffect, useState } from "react";

const ConferenceList = () => {
  const [conferences, setConferences] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Replace this URL with your conference service endpoint
    fetch("http://localhost:8888/conference-service/api/conferences")
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        setConferences(data['_embedded']['conferences']);
        setLoading(false);
      })
      .catch((err) => {
        console.error("Error fetching conferences:", err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p className="text-center mt-10 text-gray-500">Loading conferences...</p>;
  }

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold mb-4 text-center">🎤 Conferences</h1>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {conferences.map((conf) => (
          <div
            key={conf.id}
            className="bg-white rounded-2xl shadow-md p-4 hover:shadow-lg transition"
          >
            <h2 className="text-xl font-semibold text-blue-700">{conf.title}</h2>
            <p className="text-sm text-gray-600 mt-1">
              Type: <span className="font-medium">{conf.type}</span>
            </p>
            <p className="text-sm text-gray-600">Date: {conf.date}</p>
            <p className="text-sm text-gray-600">Duration: {conf.duration} hrs</p>
            <p className="text-sm text-gray-600">
              Registered: {conf.numberOfParticipants}
            </p>
            <p className="text-sm text-gray-600">Score: ⭐ {conf.score}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ConferenceList;
