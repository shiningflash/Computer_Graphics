# Computer_Graphics

**Java binding for OpenGL (JOGL)** is an open source library for binding OpenGL graphics in Java. Since 2010, it has been an independent open source project under a BSD license. It is the reference implementation for Java Bindings for OpenGL. JOGL allows access to most OpenGL features available to C language programs through the use of the Java Native Interface (JNI). It offers access to both the standard GL* functions along with the GLU* functions; however the OpenGL Utility Toolkit (GLUT) library is not available for window-system related calls, as Java has its own windowing systems: Abstract Window Toolkit (AWT), Swing, and some extensions. Therefore, JOGL is an excellent choice to demonstrate the basic graphical rendering methodologies and transformations. Throughout the semester we will use JOGL to implement the basic rendering techniques. 

**Installing JOGL:**
Make sure that the Java Development Kit(JDK) is installed in your system.
Make sure that a preferred IDE is installed. We will use Eclipse for our demonstration. 
Copy the necessary JOGL library files to your machine. You will find the files in the folder under the name “jogamp-all-platforms”. The location is as follows: (tsr->Faculty_Initital->CSE423 Computer Graphics Lab->Lab01)
Open the Eclipse IDE. 
Go to window->preferences->java->buildPath->userLibrary
Create a new user library name it JOGL (or something else)
Add the following jars to it (you can find these jars in jogamp-all-platforms->jars)
```
1. gluegen-rt.jar
2. gluegen-rt-native-windows-amd64.jar
3. jogl-all.jar
4. jogl-all-native-windows-amd64.jar
```
If you are on a windows machine use jars like "gluegen-rt-native-windows-amd64.jar" and if you are on a 32 bit machine use jars like "gluegen-rt-native-linux-i586.jar"

Frome now on for every project you create goto project->properties->javaBuildPath->libraries->addLibrary->userLibrary-> add the library you just created

--------------------------------------------------

#### Here are some preview 

Line Draw Preview
![view_line](https://user-images.githubusercontent.com/35567854/70389661-b3ef4480-19ec-11ea-9d27-b739fe92b5a7.PNG)
-----------------
Mid Point Circle Preview
![view_circle_](https://user-images.githubusercontent.com/35567854/70389665-b487db00-19ec-11ea-813a-92698b7fb0f7.PNG)
-----------------
Special Mid Point Circle with Line Inside
![view_circle](https://user-images.githubusercontent.com/35567854/70389664-b487db00-19ec-11ea-8e42-1198a7122c66.PNG)
-----------------
Symmetric Star Preview
![view_star](https://user-images.githubusercontent.com/35567854/70389662-b3ef4480-19ec-11ea-8cf4-9b6aa861bf11.PNG)
-----------------
Special Symbol Preview
![view_symbol](https://user-images.githubusercontent.com/35567854/70389663-b487db00-19ec-11ea-903f-0ed8bef40efe.PNG)
-----------------
Line Clipping Window Preview
![view_clipped_line](https://user-images.githubusercontent.com/35567854/70389660-b3ef4480-19ec-11ea-9fcd-3da11ef95320.PNG)

etc....
