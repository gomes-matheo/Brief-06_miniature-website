# Brief-06_miniature-website
Social network example (Simplon exercise)


## Classes :
- User (contains the basis for any users)
  - Attributes : String username, String password, String mail, int id, List<User> followed, List<Post> posts
- Post (contains the basis of any post)
  - Attributes : int id, User owner, Post parent, String content, Date createdAt, boolean isDraft

## Controllers :
  ### User =>
- Register (method : POST, to create a new user)
- Login (method : POST, to log in using an existing user)

  ### Posts =>
- GetFeed (method : GET, to get the feed)
- GetUsersPosts (method : GET, to get a specified user posts)
- SendMessage (method : POST, to send a message)
- LikePost (method : POST, to like a post)
- AddComment (method : POST, to comment a post)


## JSP Structure :
- index.jsp
