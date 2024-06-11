import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html'
})
export class LoginComponent {
  user: User = { username: '', password: '' };

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.user).subscribe(
      response => {
        localStorage.setItem('token', response.token);
        this.router.navigate(['/transactions']);
      },
      error => {
        alert('Invalid username or password');
      }
    );
  }
}
