# bob-ross

Teaching the Joy of Clojure with the Joy of Painting.

## Prerequisites

Have the clojure CLI tools installed and running on your local machine.

## Lesson

In `src/bob_ross/core.clj`, you will find a bunch of function definitions that currently have no body.
To complete this lesson, you will need to write the code that solves the problem in each functions docstring.
Once you've finished each section, you can check your answers by running the related test case.

For each problem, you can use the `episodes` definition to access the CSV data in `resources/episodes.csv`.
This refers to a vector of maps, where each map looks like:

```clojure
{:CACTUS             "0"
 :RIVER              "1"
 :BARN               "0"
 :BOAT               "0"
 :MOUNTAINS          "0"
 :CIRRUS             "0"
 :CONIFER            "0"
 :HALF_OVAL_FRAME    "0"
 :TRIPLE_FRAME       "0"
 :DECIDUOUS          "1"
 :LAKES              "0"
 :FLOWERS            "0"
 :AURORA_BOREALIS    "0"
 :FIRE               "0"
 :PATH               "0"
 :FARM               "0"
 :TOMB_FRAME         "0"
 :FLORIDA_FRAME      "0"
 :BEACH              "0"
 :SNOWY_MOUNTAIN     "0"
 :PERSON             "0"
 :MILL               "0"
 :PORTRAIT           "0"
 :NIGHT              "0"
 :STEVE_ROSS         "0"
 :OVAL_FRAME         "0"
 :DOCK               "0"
 :ROCKS              "0"
 :BRIDGE             "0"
 :MOON               "0"
 :FOG                "0"
 :LAKE               "0"
 :CUMULUS            "0"
 :APPLE_FRAME        "0"
 :WATERFALL          "0"
 :CLOUDS             "0"
 :SUN                "0"
 :TREE               "1"
 :WINTER             "0"
 :GUEST              "0"
 :CLIFF              "0"
 :WINDOW_FRAME       "0"
 :CABIN              "0"
 :EPISODE            "S01E01"
 :TREES              "1"
 :SNOW               "0"
 :WINDMILL           "0"
 :GRASS              "1"
 :BUSHES             "1"
 :PALM_TREES         "0"
 :MOUNTAIN           "0"
 :SPLIT_FRAME        "0"
 :BUILDING           "0"
 :SEASHELL_FRAME     "0"
 :HILLS              "0"
 :WAVES              "0"
 :FRAMED             "0"
 :TITLE              "A WALK IN THE WOODS"
 :STRUCTURE          "0"
 :CIRCLE_FRAME       "0"
 :OCEAN              "0"
 :RECTANGULAR_FRAME  "0"
 :LIGHTHOUSE         "0"
 :DIANE_ANDRE        "0"
 :FENCE              "0"
 :DOUBLE_OVAL_FRAME  "0"
 :RECTANGLE_3D_FRAME "0"
 :HALF_CIRCLE_FRAME  "0"
 :WOOD_FRAMED        "0"}
```

Where `"0"/"1"` is the binary representation if an object was painted or not.

### Questions

#### First Episode Title

Using the episodes data, determine what the title of the first episode of __The Joy of Painting__.
Remember, the `episodes` reference is a faithful copy of the CSV, so order is preserved.
Once you've filled in the function, run this command to check your answer from the command line:

```shell
clj -M:test -i :first
```

#### Boat Episode Detection

Given the map representing an episode, determine if the episode featured a boat or not and return the appropriate boolean.
Once you've filled in the function, run this command to check your answer from the command line:

```shell
clj -M:test -i :second
```

#### Steve Ross Episode Count

Find the integer count of the number of episodes that featured Bob's son, Steve Ross.
Remember, there are a lot of ways of tackling the same problem.
Often times, it's easier to get code that works and than optimize it after the fact.
Once you've filled in the function, run this command to check your answer from the command line:

```shell
clj -M:test -i :third
```

As an additional challenge, write this function so it only has to iterate over a collection one time.

#### Finding Episodes by Subject

Find the episodes identifiers `S01E01` for every episode that contains the object referred to by the supplied keyword, e.g. `:TREE`.
Remember, if you are solving common problems between functions, it's often a good idea to create new functions with `defn` so you can reuse your code.

Once you've filled in the function, run this command to check your answer from the command line:

```shell
clj -M:test -i :fourth
```

As an additional challenge, update this function to accept either a keyword or a case-insensitive string.
To test your solution to the challenge, run this command:

```shell
clj -M:test -i :fourth-challenge
```

#### Finding Subjects By Episode

Given two integers representing the season number and the episode number, find the list of things painted in that episode.
If the numbers refer to an episode that doesn't exist, return the keyword `:not-found`.
Here are a few things to remember:

- All episodes are identified by their `:EPISODE`, which is always of the form: `S`, followed by exactly 2 integers representing the season, and then `E` followed by exactly 2 integers representing the episode number.
- The episode title is never painted on an original Bob Ross painting, so you may have to remove data from any episodes you find.

```shell
clj -M:test -i :fifth
```

### Additional Challenges

Once you've completed the above, take note of `src/bob_ross/server`.
This defines a simple HTTP server with exactly 2 endpoints.

```
GET "/v1/episodes/subject/:subject"
GET "/v1/episodes/season/:season/episode/:episode"
```

These endpoints will pull the data off of any incoming URIs, and pass them to the functions you wrote to solve the fourth and fifth questions respectively.

To test them, you can start the webserver with the following command:

```shell
clojure -M -m bob-ross.server
```

Then, you can use curl or Postman to send requests to `localhost:8080` to receive responses.

Once you have this up and working, make these updates to your code:

- Return a status 404 whenever the `subject`, `season`, or `episode` is invalid.
- Serve a route `v1/episodes/subjects` that responds with a list of every subject of a painting that's appeared on The Joy of Painting.
- Update `ross/find-subjects-by-episode` to build a lookup map so it doesn't have to search through every episodes on every call.

### Helpful Functions

There is great documentation with examples of the clojure programming language [online](https://clojuredocs.org/).
The following is a list of clojure functions that may help you solve these challenges:

- first
- keys
- vals
- filter
- count
- map
- str
- keyword
- clojure.string/upper-case
- dissoc
- reduce
- reduce-kv
- conj
- if
- when
- zipmap
