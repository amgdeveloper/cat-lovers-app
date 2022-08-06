
# Image detail viewer

## Description

This is an example Android application that shows a list with some items (description and thumbnail) and when tapping on an element shows the details of that item. The data being displayed is fetched from a JSON file stored in the assets which is parsed.

# Architecture

The project follows Clean Architecture design and it has been structured taking into account Android Official documentation, i.e. (ui, data and model). Additionally I decided to create another layer for the use cases. MVVM has been used to communicate the UI with the data layer, accessing through the use cases.

It has been decided to use a Single Activity app with two fragments (list and detail) due to it integrates better with Jetpack's navigation library and after reading some documentation I had the impression that in a near future Google will encourage using this architecture even though it's not officially mentioned.

## Libraries used

- Dagger Hilt
- ViewModel
- Coroutines
- Navigation
- Picasso
- Gson