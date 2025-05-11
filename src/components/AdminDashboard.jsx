// components/AdminDashboard.jsx

import Profile from './Profile';
import Feedback from './Feedback';
import EmployeeManager from './EmployeeManager';

function AdminDashboard({ setRole, user }) {
  return (
    <div className="container">
      <div className="card">
        <h1>Admin Dashboard</h1>
        <p>Welcome {user ? user.username : 'Admin'}</p>
        <button onClick={() => setRole(null)}>Logout</button>
      </div>

      <Profile role="admin" />

      <EmployeeManager />

      <div className="card">
        <h2>Employee Feedback</h2>
        <Feedback viewOnly />
      </div>
    </div>
  );
}

export default AdminDashboard;
