# F1 Racing Insights App

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-Compose%20&%20MVVM-blue)](https://developer.android.com/)

## Overview

F1 Racing Insights is a modern Android app built with Jetpack Compose, designed to deliver real-time Formula 1 data, driver stats, and race schedules. Users can explore top drivers, upcoming sessions, and circuit details with an engaging, expressive UI. The app follows a single-activity, multi-screen architecture and integrates external links for education and social media.

Key highlights:
- Dynamic auto-sliding driver carousel.
- Upcoming race session info with local timezone formatting.
- Navigation to detailed race/circuit views.
- Material 3 expressive loading indicators.
- External integrations (Instagram, education blog).

This project was developed as an assignment, using mock APIs for demo purposes. It's production-ready with minor tweaks for live data.

## Features

- **Driver Leaderboard Slider**: Auto-advances every 3 seconds through top drivers (focus on position 1: name, wins, points).
- **Upcoming Session Card**: Displays next session name, date, and time (local TZ); clickable to detail screen.
- **Education & Social Cards**: Links to F1 beginner guides and Instagram (@boxbox_club).
- **Detail Screen**: Static circuit facts, race info (round, name, times).
- **Loading States**: M3 expressive circular indicators during API calls.
- **Edge-to-Edge UI**: Dynamic status bar blending with slider colors (orange/black).
- **Error Handling**: Graceful fallbacks for no upcoming races.

## Tech Stack

| Category       | Technologies/Tools                          |
|----------------|---------------------------------------------|
| **UI**         | Jetpack Compose, Material 3 (Expressive APIs), Navigation Compose |
| **Architecture**| MVVM (ViewModels, StateFlow), Single Activity |
| **Networking** | Retrofit, Gson, OkHttp (mock APIs)          |
| **Data**       | Kotlin Data Classes, Coroutines             |
| **Utils**      | Time formatting (SimpleDateFormat)          |
| **Testing**    | Unit tests ready (JUnit, but not implemented) |

- **Min SDK**: 24
- **Target SDK**: 34
- **Kotlin**: 1.9+
- **Compose Compiler**: 1.5.4

## Screenshots

![Home Screen](screenshots/home_screen.png)  
*Home Screen: Driver slider, session info, education/social cards.*

![Detail Screen](screenshots/detail_screen.png)  
*Detail Screen: Race/circuit details with facts.*

*(Add actual screenshots to `/screenshots` folder for GitHub rendering.)*

## Setup & Installation

### Prerequisites
- Android Studio (Hedgehog or later)
- SDK 34 installed
- Emulator/Device with API 24+

### Steps
1. **Clone the Repo**:
   ```
   git clone https://github.com/yourusername/f1-racing-insights.git
   cd f1-racing-insights
   ```

2. **Open in Android Studio**:
   - Import as Gradle project.
   - Sync Gradle (ensure internet for deps).

3. **Add Drawables**:
   - Place images (e.g., `f1_top_slider_driver_img.png`) in `res/drawable/`.
   - Update R.drawable references if needed.

4. **Run the App**:
   - Select emulator/device.
   - Click Run (Shift + F10).
   - APIs use mock endpoints—no keys needed.

### Mock APIs
- Drivers: `https://mocki.io/v1/e8616da8-220c-4aab-a670-ab2d43224ecb` (wrapped as `{"drivers": [...]}`)
- Schedule: `https://mocki.io/v1/9086a3f1-f02b-4d24-8dd3-b63582f45e67` (wrapped as `{"schedule": [...]}`)

For production, replace with official F1 API (e.g., Ergast).

## Usage

1. **Launch App**: Opens HomeScreen with loading spinner.
2. **Browse Slider**: Auto-scrolls top driver (e.g., Lando Norris) and "Follow Us" promo.
3. **Session Card**: Tap green "DateTimeBox" to navigate to DetailScreen (shows race/circuit facts).
4. **Education Card**: Tap for beginner guide blog.
5. **Instagram Banner**: Tap red "F1 25" card for @boxbox_club.
6. **Back Navigation**: Standard Compose Nav (up gesture or back button).

Note: As of Nov 2025, mock data may show no upcoming races—use static fallback.

## Project Structure

```
app/
├── src/main/java/com/example/f1app/
│   ├── MainActivity.kt
│   ├── data/models/          # Data classes (Driver, Schedule, etc.)
│   ├── data/network/         # Retrofit setup (F1ApiService, RetrofitClient)
│   ├── ui/screens/           # Screens (HomeScreen, DetailScreen)
│   ├── ui/components/        # Reusables (AutoSlidingSlider, Cards)
│   ├── ui/viewmodels/        # ViewModels (HomeViewModel, DetailViewModel)
│   ├── ui/theme/             # Compose Theme
│   └── utils/                # Helpers (TimeUtils)
└── res/                      # Drawables, strings
```

## Contributing

1. Fork the repo.
2. Create a feature branch (`git checkout -b feature/amazing-feature`).
3. Commit changes (`git commit -m 'Add amazing feature'`).
4. Push to branch (`git push origin feature/amazing-feature`).
5. Open Pull Request.

- Follow Kotlin/Compose style guides.
- Add tests for new features.
- Update README for changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Built with ❤️ using xAI's Grok for code guidance.
- Mock APIs: Mocki.io
- Design inspo: Figma prototype (link in original assignment).
- External links: BoxBox Club blog & Instagram.

---

*Last Updated: November 06, 2025*  
Questions? Open an issue! 🚀
