

public interface TerritoryFinals {

	// all of the points of each polygon is stored here because they wont change
	// throughout the program
	final Double[][] points = {
			// x //y //x //y //x //y //x //y
			{ 250.0, 60.0, 350.0, 50.0, 450.0, 20.0, 550.0, 150.0, 490.0, 215.0, 400.0, 250.0, },
			
			//2
			/*beta*/{ 400.0, 250.0, 490.0, 215.0, 575.0, 300.0, 510.0, 370.0, 450.0, 400.0, 350.0, 400.0},
					
			//3
			/*C*/{510.0, 370.0, 575.0, 300.0, 620.0, 350.0, 630.0, 375.0, 575.0, 390.0},
					
			//4
			/*delta*/{490.0, 215.0, 550.0, 150.0, 725.0, 300.0, 675.0, 325.0, 650.0, 300.0,
					625.0, 310.0, 650.0, 340.0, 620.0, 350.0},
					
			//5
			/*echo*/{100.0, 250.0, 100.0, 260.0, 110.0, 300.0, 100.0, 340.0, 200.0, 485.0, 250.0,
					400.0, 210.0, 360.0, 210.0, 350.0, 220.0, 350.0, 220.0, 320.0, 160.0, 320.0, 180.0, 280.0,
					180.0, 270.0, 170.0, 250.0},
					
			//6
			/*fox trot*/{190.0, 150.0, 170.0, 180.0, 170.0, 250.0, 180.0, 270.0, 180.0, 280.0,
					160.0, 320.0, 220.0, 320.0, 220.0, 350.0, 260.0, 350.0, 260.0, 150.0},
					
			//7
			/*golf*/{260.0, 150.0, 260.0, 350.0, 290.0, 350.0, 290.0, 320.0, 400.0, 250.0, 320.0, 150.0},
					
			//8
			/*L*/{740.0, 30.0, 860.0, 20.0, 900.0, 100.0, 800.0, 140.0, 740.0, 100.0},
					
			//9
			/*M*/{860.0, 20.0, 1060.0, 60.0, 1100.0, 130.0, 1030.0, 150.0, 950.0, 200.0,
				960.0, 120.0, 900.0, 100.0},
					
			//10
			/*November*/{750.0, 190.0, 800.0, 140.0, 900.0, 100.0, 960.0, 120.0, 950.0, 200.0, 880.0, 260.0},
					
			//11
			/*O*/{1100.0, 130.0, 1030.0, 150.0, 950.0, 200.0, 880.0, 260.0, 1090.0, 280.0},
					
			//12
			/*Papa*/{940.0, 375.0, 880.0, 260.0, 1043.0, 275.0, 1025.0, 315.0, 1050.0, 320.0},
					
			//13
			/*Q*/{825.0, 300.0, 880.0, 260.0, 940.0, 375.0, 825.0, 380.0},
					
			//14
			/*R*/{1043.0, 275.0, 1025.0, 315.0, 1050.0, 320.0, 1078.0, 340.0, 1090.0, 280.0},
					
			//15
			/*Sierra*/{1078.0, 340.0, 1050.0, 320.0, 940.0, 375.0, 1064.0, 420.0},
					
			//16
			/*T*/{200.0, 485.0, 250.0, 400.0, 350.0, 400.0, 350.0, 600.0, 300.0, 600.0, 300.0, 585.0},
					
			//17
			/*Uniform*/{350.0, 600.0, 350.0, 400.0, 510.0, 370.0, 500.0, 575.0, 400.0, 575.0, 400.0, 600.0},
					
			//18
			/*Victor*/{500.0, 575.0, 510.0, 370.0, 575.0, 390.0, 650.0, 520.0, 635.0, 575.0},
					
			//19
			/*Whiskey*/{400.0, 575.0, 635.0, 575.0, 725.0, 790.0, 690.0, 825.0, 640.0, 810.0,
						565.0, 650.0, 515.0, 610.0, 400.0, 600.0}
	};
	Double[][] labelPoints = {
			{415.0, 124.16666666666667},//a
			{462.5, 322.5},//b
			{582.0, 357.0},//c
			{623.125, 286.25},//d
			{172.14285714285714, 323.92857142857144},//e
			{201.0, 262.0},//f
			{303.3333333333333, 261.6666666666667},//g
			{808.0, 78.0},//l
			{980.0, 111.42857142857143},//m
			{873.3333333333334, 168.33333333333334},//n
			{1010.0, 204.0},//o
			{987.6, 309.0},//p
			{867.5, 328.75},//q
			{1048.2, 306.0},//r
			{1033.0, 363.75},//sierra
			{291.6666666666667, 511.6666666666667},//tango
			{418.3333333333333, 520.0},//unifrom
			{574.0, 486.0},//victor
			{600.25, 679.375}//whiskey
};
	
	boolean[][] adjacency = {
			//can beta attack golf? tango?
		
		
				//alpha
				//alpha** beta  char  delta  echo  fox   golf   L	  M		No     O	 Papa	Q	  R		 S		T		U	V		Whiskey
				{false, true, false, true, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false},
				
				//beta
				//alpha beta** char  delta  echo  fox   golf   L	  M		 No       O	   Papa	  Q	     R		 S		T		U	V	  Whiskey
				{true, false, true, true, false, false, true, false, false, false, false, false, false, false, false, true, true, true, false},
				
				//c
				//alpha  beta  char** delta  echo   fox   golf   L	     M		No     O	Papa	 Q	    R	  S		 T		U	  V	   Whiskey
				{false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false},
				
				//delta
				//alpha beta char  delta**  echo  fox   golf   L	  M		No     O	 Papa	Q	  R		 S		T		U	V		Whiskey
				{true, true, true, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false},
				
				//echo
				//alpha  beta  char   delta  echo   fox    golf   L	     M		No     O	 Papa	 Q	    R		S	  T		 U	    V	 Whiskey
				{false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false, false},
				
				//fox
				//alpha  beta  char  delta   echo  fox    golf   L	    M		No     O	 Papa	Q	  R		 S		T		U	   V	 Whiskey
				{false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false},
				
				//golf
				//alpha  beta  char  delta  echo    fox   golf   L	  M		No     O	 Papa	Q	  R		 S		T		U	V		Whiskey
				{true, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false},
				
				//l
				//alpha beta  char   delta  echo   fox     golf   L	     M		No     O	 Papa	Q	    R		S	  T		U	    V	  Whiskey
				{true, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false},
				
				//M
				//alpha  beta  char  delta  echo  fox   golf   L	  M		No     O	 Papa	Q	  R		 S		T		U	V		Whiskey
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
				
				//November
				//alpha  beta  char   delta  echo    fox   golf    L	  M		No     O   Papa	  Q	    R	   S		T	  U	     V	  Whiskey
				{false, false, false, false, false, false, false, true, true, false, true, true, true, false, false, false, false, false, false},
				
				//o
				//alpha  beta  char  delta   echo    fox   golf     L	  M		No     O	Papa	Q	  R		 S		T	 U	   V	  Whiskey
				{false, false, false, false, false, false, false, false, true, true, false, true, true, true, false, false, false, false, false},
				
				//Papa
				//alpha  beta  char   delta  echo    fox   golf   L	      M		 No     O	 Papa	 Q	   R	  S	  T	    U	     V		Whiskey
				{false, false, false, false, false, false, false, false, false, true, true, false, true, true, true, false, false, false, false},
				
				//Q
				//alpha  beta  char   delta  echo    fox   golf   L	      M		No     O	Papa	 Q	   R	 S		T	  U	     V		Whiskey
				{false, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, true, false},
				
				//R
				//alpha  beta  char   delta  echo    fox   golf    L	  M		No     O	 Papa	  Q	    R	  S		T	   U	   V	Whiskey
				{false, false, false, false, false, false, false, false, false, false, true, true, false, false, true, false, false, false, false},
				
				//Sierra
				//alpha  beta  char   delta  echo   fox     golf   L	  M		No     O	 Papa	Q	  R		 S		T		U	   V   Whiskey
				{false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true},
				
				//T
				//alpha  beta  char  delta   echo  fox     golf   L	     M		No     O	 Papa	Q	    R		 S		T	  U	    V		Whiskey
				{false, true, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false},
				
				//Uniform
				//alpha  beta  char  delta  echo    fox   golf   L	     M		No     O	 Papa	 Q	    R		S	 T	   U	   V	Whiskey
				{false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true},
				
				//Victor
				//alpha beta  char  delta  echo    fox    golf   L	    M		No     O	 Papa	Q	   R	   S	  T		U	  V	   Whiskey
				{false, true, true, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, true},
				
				//Whiskey
				//alpha  beta  char   delta   echo  fox     golf   L	  M		 No     O	   Papa	  Q	     R		 S	  T	     U	    V	 Whiskey
				{false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true, false}
	};
	
	final Double[][] textBoxPoints = {
			
	};

	// final boolean[][] adjacent = {

}
