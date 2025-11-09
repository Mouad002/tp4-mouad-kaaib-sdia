import { Link, Outlet } from "react-router-dom";

const NavbarLayout = () => {
  return (
    <>
      <nav className="bg-blue-600 text-white px-6 py-3 flex justify-between items-center shadow-md">
        <h1 className="text-xl font-bold">Conference App</h1>
        <ul className="flex gap-6">
          <li>
            <Link to="/conferences" className="hover:text-gray-200">
              Conferences
            </Link>
          </li>
          <li>
            <Link to="/keynotes" className="hover:text-gray-200">
              Keynotes
            </Link>
          </li>
        </ul>
      </nav>

      <main className="p-6">
        <Outlet />
      </main>
    </>
  );
};

export default NavbarLayout;
