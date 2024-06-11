import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  user: User = { username: '', password: '' };

  constructor(private authService: AuthService, private router: Router) {}

  register() {
    this.authService.register(this.user).subscribe(
      response => {
        this.router.navigate(['/login']);
      },
      error => {
        alert('Registration failed');
      }
    );
  }
}

