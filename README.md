# smpl-draw-console
 Simple Draw Console

Description
This is a Simple Drawing Console Program using Java Programming Language.

This program has several function:
1. Create a new canvas
2. Draw in canvas using various commands
3. Quit

|Command 		|Description|
|----|----|
|C w h          | Create a new canvas of width w and height h.|
|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|
|               | horizontal or vertical lines are supported. Horizontal and vertical lines|
|               | will be drawn using the 'x' character.|
|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|
|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|
|               | using the 'x' character.|
|B x y c        | Fill the entire area connected to (x,y) with "colour" c. The|
|               | behaviour of this is the same as that of the "bucket fill" tool in paint|
|               | programs.|
|Q              | Quit|

__Build:__
To build and generate .jar file, run the following maven command in the project root directory:
$ mvn clean package

It will generate Simple-draw-console.jar in <project root>/target directory.

__Run Application:__
To running .jar application: 
$ java -jar Simple-draw-console.jar
