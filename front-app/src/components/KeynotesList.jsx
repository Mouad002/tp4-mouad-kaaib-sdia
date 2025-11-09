// KeynotesTable.jsx
import { useEffect, useState } from "react";

export default function KeynotesList() {
  const [keynotes, setKeynotes] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8888/keynote-service/api/keynotes")
      .then((res) => res.json())
      .then((data) => {
        // Extract keynotes from _embedded object
        if (data._embedded && data._embedded.keynotes) {
          setKeynotes(data._embedded.keynotes);
        }
        setLoading(false);
      })
      .catch((err) => {
        console.error("Error fetching keynotes:", err);
        setLoading(false);
      });
  }, []);

  if (loading) return <p className="text-gray-500">Loading keynotes...</p>;

  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      <h1 className="text-2xl font-bold mb-4">Keynotes</h1>
      <div className="overflow-x-auto">
        <table className="min-w-full bg-white rounded shadow">
          <thead className="bg-gray-200">
            <tr>
              <th className="py-2 px-4 text-left">ID</th>
              <th className="py-2 px-4 text-left">First Name</th>
              <th className="py-2 px-4 text-left">Last Name</th>
              <th className="py-2 px-4 text-left">Email</th>
              <th className="py-2 px-4 text-left">Function</th>
            </tr>
          </thead>
          <tbody>
            {keynotes.map((k) => (
              <tr key={k.id} className="border-b hover:bg-gray-50">
                <td className="py-2 px-4">{k.id}</td>
                <td className="py-2 px-4">{k.firstName}</td>
                <td className="py-2 px-4">{k.lastName}</td>
                <td className="py-2 px-4">{k.email}</td>
                <td className="py-2 px-4">{k.function}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
