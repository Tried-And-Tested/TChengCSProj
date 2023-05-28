import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JLabel;

class cheng_p8
{
	private static int wide = 700;
	private static int high = 350;
	private static int inwide = 350;
	private static int inhigh = 330;
	private static String sortFileName ="";
	private static String searchFileName ="";

	private static int[] sortVals; // values from sort data
	private static int[] searchVals; // values form search data
	private static int[] arrayVals; // values for array
	private static int[] mergeSortTpdVals; // values for merge sort
	private static int[] selSortVals; // return of selection sort
	private static cheng_BinarySearchTree BtsInstance = new cheng_BinarySearchTree();
	private static TreeSet<Integer> treeSetVals =new TreeSet<>(); // used in tree set calls
	private static HashSet<Integer> hashSetVals =new HashSet<>(); // used in hash set calls
	private static PriorityQueue<Integer> priorityQueueVals = new PriorityQueue<>(); // used in priority queue calls
	private static ArrayList<Integer> arrayListVals = new ArrayList<>(); // used in array list calls
	private static ArrayList<Integer> sortedArrayListVals = new ArrayList<>(); // used in sorted array list calls
	private static boolean sortInt=false;
	private static boolean BTSbool = false;
	private static boolean Treebool = false;
	private static boolean Prioritybool = false;
	private static boolean hashbool = false;
	private static boolean ArrayLbool =false;
	private static boolean SortArraybool = false;
	private static boolean Arraybool = false;
	private static boolean mergebool =false;
	private static boolean haspressed = false;

	static JButton sortIntsButton, addToBtsButton, addToTreeSetButton, addToPriorityQueueButton, addToHashSetButton;
	static JButton addToArrayListButton, addToSortedArrayListButton, addToArrayButton, mergeSortIntsButton, mergeSortInts2Button;
	static JButton quickSortIntsButton, searchSortedIntsButton, searchBtsButton, searchTreeSetButton, searchPriorityQueueButton;
	static JButton searchHashSetButton, searchArrayListButton, searchSortedArrayListButton, searchArrayButton, searchMergeSortIntsButton;
	static JButton searchMergeSortInts2Button, searchQuickSortIntsButton;

	static JLabel sortIntsLabel, addToBtsButtonLabel, addToTreeSetLabel, addToPriorityQueueLabel, addToHashSetLabel, addToArrayListLabel;
	static JLabel addToSortedArrayListLabel, addToArrayLabel, mergeSortIntsLabel, mergeSortIntsInts2Label, quickSortIntsLabel, searchSortedIntsLabel;
	static JLabel searchTreeSetLabel, searchBtsLabel, searchPriorityQueueLabel, searchHashSetLabel, searchArrayListLabel, searchSortedArrayListLabel;
	static JLabel searchArrayLabel, searchMergeSortIntsLabel, searchMergeSortInts2Label, searchQuickSortIntsLabel;

	private static void readData(String filename, boolean readSortVals){
		String strong ="";
		ArrayList<String> holdArray = new ArrayList<>();
				try{
			BufferedReader reader  = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while((strong=reader.readLine()) != null){
				holdArray.add(strong);
			}
			reader.close();
			if(readSortVals){
				sortVals = new int[holdArray.size()];
				mergeSortTpdVals = new int[holdArray.size()];
				for(int i=0; i<holdArray.size();i++){
					sortVals[i] = Integer.valueOf(holdArray.get(i));
					mergeSortTpdVals[i] = Integer.valueOf(holdArray.get(i));
				}
			}
			else{
				searchVals = new int[holdArray.size()];
				for(int i=0; i<holdArray.size();i++){
					searchVals[i] = Integer.valueOf(holdArray.get(i));
	
				}
			}
		}
		catch(Exception e){
			System.out.println("Something went wrong :" + e.toString());
			System.out.println(e.toString());
			e.printStackTrace();
            System.exit(0);
		}
	}

	private static void selectionSort(int[] list){
		System.out.println("list.length = " + list.length);
		for (int j = 0; j < list.length - 1; j++){
			int minIndex = j;
			for (int k = j + 1; k < list.length; k++){
				if (list[k]<list[minIndex]){
					minIndex = k;
				}
			}
			int temp = list[j];
			list[j] = list[minIndex];
			list[minIndex] = temp;
		}
  	}

	// add to methods
	private static void addToTreeSet(){
		for(int i : sortVals){
			treeSetVals.add(i);
		}
	}

	private static void addToArray(){
		arrayVals = new int[sortVals.length];
		for(int i=0; i<sortVals.length;i++){
			arrayVals[i] = sortVals[i];
		}
	}

	private static void addToBTS(){
		for(int i : sortVals){
			BtsInstance.insertNode(new Node(i,null));
		}
	}

	private static void addToArrayList(){
		for(int i : sortVals){
			arrayListVals.add(i);
		}
	}
	
	private static void addToSortedArrayList(){
		for(int i : sortVals){
			sortedArrayListVals.add(i);
		}
		Collections.sort(sortedArrayListVals);
	}

	private static void addToHash(){
		for(int i: sortVals){
			hashSetVals.add(i);
		}
	}

	private static void addToPriorityQueue(){
		for(int i : sortVals){
			priorityQueueVals.add(i);
		}
	}

	// merge sort methods
	private static void mergeSortTpD(){
		int[] workArray;
		workArray = mergeSortTpdVals.clone();
		TopDownSplitMerge(workArray, 0 ,mergeSortTpdVals.length, mergeSortTpdVals);
	}

	private static void TopDownSplitMerge(int[] arrayA, int beg, int end, int[] arrayB){
		if((end-beg)<=1){
			return;
		}
		int mid = (beg+end)/2;
		TopDownSplitMerge(arrayB, beg, mid, arrayA);
		TopDownSplitMerge(arrayB, mid, end, arrayA);
		BottomUpMerge(arrayA, beg, mid, end, arrayB);
	}

	private static void BottomUpMerge(int[] arrayA, int left, int right, int end, int[] arrayB){
		int l =left;
		int r =right;
		for(int k = left; k<end;k++){
			if((l<right) && ((r>=end) || (arrayA[l]<=arrayA[r]))){
				arrayB[k] = arrayA[l];
				l++;
			}
			else{
				arrayB[k] = arrayA[r];
				r++;
			}
		}
	}

	// search methods
	private static int searchPriority(){
		int check =0;
		for(int i : searchVals){
			if(priorityQueueVals.contains(i)){
				check++;
			}
		}
		return check;
	}
	
	private static int searchArrayList(){
		int check =0;
		for(int i : searchVals){
			if(arrayListVals.contains(i)){
				check++;
			}
		}
		return check;
	}
	
	private static int searchInts(){
		int check =0;
		for(int i : searchVals){
			int bot=0;
			int top=selSortVals.length-1;
			while(bot<=top){
				int mid = (bot+top)/2;
				if(i < selSortVals[mid]){
					top  = mid-1;
				}
				else{
					if(i > selSortVals[mid]){
						bot = mid+1;
					}
					else{
						check++;
						break;
					}
				}
			}
		}
		return check;
	}

	private static int searchSortedArrayList(){
		int check =0;
		for(int i : searchVals){
			if(Collections.binarySearch(sortedArrayListVals, i) > -1){
				check++;
			}
		}
		return check;
	}

	private static int searchTreeSet(){
		int check =0;
		for(int i : searchVals){
			if(treeSetVals.contains(i)){
				check++;
			}
		}
		return check;
	}

	private static int searchArray(){
		int check =0;
		for(int i =0; i<searchVals.length;i++){
			for(int x=0; x<arrayVals.length;x++){
				if(arrayVals[x] == searchVals[i]){
					check++;
					break;
				}
			}
		}
		return check;
	}

	private static int searchBTS(){
		int check =0;
		for(int i : searchVals){
			if(BtsInstance.getNode(BtsInstance.getRoot(), i) != null){
				check++;
			}
		}
		return check;
	}

	private static int searchHash(){
		int check =0;
		for(int i : searchVals){
			if(hashSetVals.contains(i)){
				check++;
			}
		}
		return check;
	}

	private static int searchMergeSort(){
		int check =0;
		for(int i : searchVals){
			int bot=0;
			int top=mergeSortTpdVals.length-1;
			while(bot<=top){
				int mid = (bot+top)/2;
				if(i < mergeSortTpdVals[mid]){
					top  = mid-1;
				}
				else{
					if(i > mergeSortTpdVals[mid]){
						bot = mid+1;
					}
					else{
						check++;
						break;
					}
				}
			}
		}
		return check;
	}
	public static void main (String[] args){
		
		if(args.length != 2){
			System.out.println("wrong input");
			System.exit(0);
		}

		// create the window and specify the size and what to do when the window is closed
		javax.swing.JFrame f = new javax.swing.JFrame();
		f.setPreferredSize(new java.awt.Dimension(wide, high));
		f.setMinimumSize(new java.awt.Dimension(wide, high));
		f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

		// create the menu bar
		javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
		
		// create the two menus
		javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");

		// add the menu items to the bar
		menuBar.add(fileMenu);
		
		// create the menu items for the two menus
		javax.swing.JMenuItem fileExit = new javax.swing.JMenuItem("Exit");
		javax.swing.JMenuItem ReadSortFile = new javax.swing.JMenuItem("Read Sort File");
        javax.swing.JMenuItem ReadSearchFile = new javax.swing.JMenuItem("Read Search File");

		fileMenu.add(ReadSortFile);
		fileMenu.add(ReadSearchFile);
        fileMenu.add(fileExit);

		// create the action listeners for the menu items
		MenuItemActionListener fileMenuItemExitActionListener = new MenuItemActionListener(fileExit);
		MenuItemActionListener fileMenuItemReadSearchFileListener = new MenuItemActionListener(ReadSearchFile);
		MenuItemActionListener fileMenuItemReadSortFileListener = new MenuItemActionListener(ReadSortFile);

		// add the listeners to the menu items
		fileExit.addActionListener(fileMenuItemExitActionListener);
		ReadSearchFile.addActionListener(fileMenuItemReadSearchFileListener);
		ReadSortFile.addActionListener(fileMenuItemReadSortFileListener);

		//create the main panel
		javax.swing.JPanel MainPanel = new javax.swing.JPanel();
		MainPanel.setLayout(new java.awt.BorderLayout());
		MainPanel.setPreferredSize(new java.awt.Dimension(wide, high));
		MainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225,0,0,225),2));

		// create the stuff needed for the left and right panels
		java.awt.GridBagConstraints LeftButtonPanelConstraints = new java.awt.GridBagConstraints();
		java.awt.GridBagConstraints RightButtonPanelConstraints = new java.awt.GridBagConstraints();
		java.awt.GridBagLayout leftGridBagLayout = new java.awt.GridBagLayout();
		java.awt.GridBagLayout rightGridBagLayout = new java.awt.GridBagLayout();

		//create the left panel
		javax.swing.JPanel LeftPanel = new javax.swing.JPanel();
		LeftPanel.setPreferredSize(new java.awt.Dimension(inwide,inhigh));
		LeftPanel.setLayout(leftGridBagLayout);
		LeftPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,225,0,225),2));

		// create the right panel
		javax.swing.JPanel RightPanel = new javax.swing.JPanel();
		RightPanel.setPreferredSize(new java.awt.Dimension(inwide,inhigh));
		RightPanel.setLayout(rightGridBagLayout);
		RightPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,0,225,225),2));

		// create main button panel
		javax.swing.JPanel MainButtonPanel = new javax.swing.JPanel();
		MainButtonPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225,225,0,225),5));
		javax.swing.BoxLayout BoxLayout = new javax.swing.BoxLayout(MainButtonPanel, javax.swing.BoxLayout.X_AXIS);
		MainButtonPanel.setLayout(BoxLayout);

		// add the panels and bar to the main panel
		f.setContentPane(MainPanel);
		MainPanel.add(menuBar, java.awt.BorderLayout.NORTH);
		MainPanel.add(MainButtonPanel,java.awt.BorderLayout.CENTER);
		MainButtonPanel.add(LeftPanel,java.awt.BorderLayout.WEST);
		MainButtonPanel.add(RightPanel,java.awt.BorderLayout.EAST);

		// create the buttons for the left side
		sortIntsButton = new javax.swing.JButton("sort ints");
		sortIntsLabel = new javax.swing.JLabel("no results");

		addToBtsButton = new javax.swing.JButton("add to Binary Search Tree");
		addToBtsButtonLabel = new javax.swing.JLabel("no results");

		addToTreeSetButton = new javax.swing.JButton("add to treeset");
		addToTreeSetLabel = new javax.swing.JLabel("no results");

		addToPriorityQueueButton = new javax.swing.JButton("add to priority queue");
		addToPriorityQueueLabel = new javax.swing.JLabel("no results");

		addToHashSetButton = new javax.swing.JButton("add to hashset");
		addToHashSetLabel = new javax.swing.JLabel("no results");

		addToArrayListButton = new javax.swing.JButton("add to array list");
		addToArrayListLabel = new javax.swing.JLabel("no results");

		addToSortedArrayListButton = new javax.swing.JButton("add to sorted array list");
		addToSortedArrayListLabel = new javax.swing.JLabel("no results");

		addToArrayButton = new javax.swing.JButton("add to array");
		addToArrayLabel = new javax.swing.JLabel("no results");

		mergeSortIntsButton = new javax.swing.JButton("merge sort ints TPD");
		mergeSortIntsLabel = new javax.swing.JLabel("no results");

		mergeSortInts2Button = new javax.swing.JButton("merge2 sort ints");
		mergeSortIntsInts2Label = new javax.swing.JLabel("no results");

		quickSortIntsButton = new javax.swing.JButton("quick sort ints"); 
		quickSortIntsLabel = new javax.swing.JLabel("no results");

		// create the buttons for the right side
		searchSortedIntsButton = new javax.swing.JButton("search sorted ints");
		searchSortedIntsLabel = new javax.swing.JLabel("no results");

		searchBtsButton = new javax.swing.JButton("search Binary Search Tree");
		searchBtsLabel = new javax.swing.JLabel("no results");

		searchTreeSetButton = new javax.swing.JButton("search treeset");
		searchTreeSetLabel = new javax.swing.JLabel("no results");

		searchPriorityQueueButton = new javax.swing.JButton("search priority queue");
		searchPriorityQueueLabel = new javax.swing.JLabel("no results");

		searchHashSetButton = new javax.swing.JButton("search hashset");
		searchHashSetLabel = new javax.swing.JLabel("no results");

		searchArrayListButton = new javax.swing.JButton("search array list");
		searchArrayListLabel = new javax.swing.JLabel("no results");

		searchSortedArrayListButton = new javax.swing.JButton("search sorted array list");
		searchSortedArrayListLabel = new javax.swing.JLabel("no results");

		searchArrayButton = new javax.swing.JButton("search array");
		searchArrayLabel = new javax.swing.JLabel("no results");

		searchMergeSortIntsButton = new javax.swing.JButton("search merge sort ints");
		searchMergeSortIntsLabel = new javax.swing.JLabel("no results");

		searchMergeSortInts2Button = new javax.swing.JButton("search merge2 sort ints");
		searchMergeSortInts2Label = new javax.swing.JLabel("no results");

		searchQuickSortIntsButton = new javax.swing.JButton("search quick sort ints");
		searchQuickSortIntsLabel = new javax.swing.JLabel("no results");


		// create the frames for the buttons on the left
		LeftButtonPanelConstraints.weightx =1;
		LeftButtonPanelConstraints.weighty =1;
		LeftButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
		LeftButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		
		// sort ints button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =0;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(sortIntsButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =0;
		LeftButtonPanelConstraints.gridwidth =java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(sortIntsLabel, LeftButtonPanelConstraints);

		// add to BTS button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =1;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToBtsButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =1;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToBtsButtonLabel, LeftButtonPanelConstraints);

		// add to Tree Set button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =2;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToTreeSetButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =2;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToTreeSetLabel, LeftButtonPanelConstraints);

		// add to priority queue button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =3;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToPriorityQueueButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =3;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToPriorityQueueLabel, LeftButtonPanelConstraints);

		// add to hashset button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =4;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToHashSetButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =4;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToHashSetLabel, LeftButtonPanelConstraints);

		// add to arraylist button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =5;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToArrayListButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =5;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToArrayListLabel, LeftButtonPanelConstraints);

		// add to sorted arraylist button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =6;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToSortedArrayListButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =6;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToSortedArrayListLabel, LeftButtonPanelConstraints);

		// add to array button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =7;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(addToArrayButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =7;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(addToArrayLabel, LeftButtonPanelConstraints);

		// merge sort ints button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =8;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(mergeSortIntsButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =8;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(mergeSortIntsLabel, LeftButtonPanelConstraints);

		// merge2 sort ints button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =9;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(mergeSortInts2Button, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =9;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(mergeSortIntsInts2Label, LeftButtonPanelConstraints);

		// quick sort ints button and label
		LeftButtonPanelConstraints.gridx =0;
		LeftButtonPanelConstraints.gridy =10;
		LeftButtonPanelConstraints.gridwidth =1;
		leftGridBagLayout.setConstraints(quickSortIntsButton, LeftButtonPanelConstraints);

		LeftButtonPanelConstraints.gridx =1;
		LeftButtonPanelConstraints.gridy =10;
		LeftButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		leftGridBagLayout.setConstraints(quickSortIntsLabel, LeftButtonPanelConstraints);

		// add the buttons to the left
		LeftPanel.add(sortIntsButton);
		LeftPanel.add(sortIntsLabel);
		LeftPanel.add(addToBtsButton);
		LeftPanel.add(addToBtsButtonLabel);
		LeftPanel.add(addToTreeSetButton);
		LeftPanel.add(addToTreeSetLabel);
		LeftPanel.add(addToPriorityQueueButton);
		LeftPanel.add(addToPriorityQueueLabel);
		LeftPanel.add(addToHashSetButton);
		LeftPanel.add(addToHashSetLabel);
		LeftPanel.add(addToArrayListButton);
		LeftPanel.add(addToArrayListLabel);
		LeftPanel.add(addToSortedArrayListButton);
		LeftPanel.add(addToSortedArrayListLabel);
		LeftPanel.add(addToArrayButton);
		LeftPanel.add(addToArrayLabel);
		LeftPanel.add(mergeSortIntsButton);
		LeftPanel.add(mergeSortIntsLabel);
		//LeftPanel.add(mergeSortInts2Button);
		//LeftPanel.add(mergeSortIntsInts2Label);
		//LeftPanel.add(quickSortIntsButton);
		//LeftPanel.add(quickSortIntsLabel);

		// create the frames for the buttons on the right
		RightButtonPanelConstraints.weightx =1;
		RightButtonPanelConstraints.weighty =1;
		RightButtonPanelConstraints.fill = java.awt.GridBagConstraints.NONE;
		RightButtonPanelConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		
		// sort ints button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =0;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchSortedIntsButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =0;
		RightButtonPanelConstraints.gridwidth =java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchSortedIntsLabel, RightButtonPanelConstraints);

		// add to BTS button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =1;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchBtsButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =1;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchBtsLabel, RightButtonPanelConstraints);

		// add to Tree Set button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =2;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchTreeSetButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =2;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchTreeSetLabel, RightButtonPanelConstraints);

		// add to priority queue button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =3;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchPriorityQueueButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =3;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchPriorityQueueLabel, RightButtonPanelConstraints);

		// add to hashset button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =4;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchHashSetButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =4;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchHashSetLabel, RightButtonPanelConstraints);

		// add to arraylist button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =5;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchArrayListButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =5;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchArrayListLabel, RightButtonPanelConstraints);

		// add to sorted arraylist button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =6;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchSortedArrayListButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =6;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchSortedArrayListLabel, RightButtonPanelConstraints);

		// add to array button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =7;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchArrayButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =7;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchArrayLabel, RightButtonPanelConstraints);

		// merge sort ints button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =8;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchMergeSortIntsButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =8;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchMergeSortIntsLabel, RightButtonPanelConstraints);

		// merge2 sort ints button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =9;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchMergeSortInts2Button, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =9;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchMergeSortInts2Label, RightButtonPanelConstraints);

		// quick sort ints button and label
		RightButtonPanelConstraints.gridx =0;
		RightButtonPanelConstraints.gridy =10;
		RightButtonPanelConstraints.gridwidth =1;
		rightGridBagLayout.setConstraints(searchQuickSortIntsButton, RightButtonPanelConstraints);

		RightButtonPanelConstraints.gridx =1;
		RightButtonPanelConstraints.gridy =10;
		RightButtonPanelConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		rightGridBagLayout.setConstraints(searchQuickSortIntsLabel, RightButtonPanelConstraints);

		// add the buttons to the left
		RightPanel.add(searchSortedIntsButton);
		RightPanel.add(searchSortedIntsLabel);
		RightPanel.add(searchBtsButton);
		RightPanel.add(searchBtsLabel);
		RightPanel.add(searchTreeSetButton);
		RightPanel.add(searchTreeSetLabel);
		RightPanel.add(searchPriorityQueueButton);
		RightPanel.add(searchPriorityQueueLabel);
		RightPanel.add(searchHashSetButton);
		RightPanel.add(searchHashSetLabel);
		RightPanel.add(searchArrayListButton);
		RightPanel.add(searchArrayListLabel);
		RightPanel.add(searchSortedArrayListButton);
		RightPanel.add(searchSortedArrayListLabel);
		RightPanel.add(searchArrayButton);
		RightPanel.add(searchArrayLabel);
		RightPanel.add(searchMergeSortIntsButton);
		RightPanel.add(searchMergeSortIntsLabel);
		//RightPanel.add(searchMergeSortInts2Button);
		//RightPanel.add(searchMergeSortInts2Label);
		//RightPanel.add(searchQuickSortIntsButton);
		//RightPanel.add(searchQuickSortIntsLabel);

		// create the button action listeners
		ButtonActionListener sortIntsListener = new ButtonActionListener(sortIntsButton);
		ButtonActionListener addtoBtsListener  = new ButtonActionListener(addToBtsButton);
		ButtonActionListener addtoTreeListener = new ButtonActionListener(addToTreeSetButton);
		ButtonActionListener addtoPriorityListener = new ButtonActionListener(addToPriorityQueueButton);
		ButtonActionListener addtoHashListener = new ButtonActionListener(addToHashSetButton);
		ButtonActionListener addtoArrayListListener = new ButtonActionListener(addToArrayListButton);
		ButtonActionListener addtoSortedArrayListener = new ButtonActionListener(addToSortedArrayListButton);
		ButtonActionListener addtoArrayListener = new ButtonActionListener(addToArrayButton);
		ButtonActionListener mergeSortIntsListener = new ButtonActionListener(mergeSortIntsButton);
		ButtonActionListener mergeSortInts2Listener  = new ButtonActionListener(mergeSortInts2Button);
		ButtonActionListener quickSortIntsListener = new ButtonActionListener(quickSortIntsButton);
		
		ButtonActionListener searchSortedIntsListener = new ButtonActionListener(searchSortedIntsButton);
		ButtonActionListener searchBtsListener = new ButtonActionListener(searchBtsButton);
		ButtonActionListener searchTreeListener = new ButtonActionListener(searchTreeSetButton);
		ButtonActionListener searchPriorityListener = new ButtonActionListener(searchPriorityQueueButton);
		ButtonActionListener searchHashListener = new ButtonActionListener(searchHashSetButton);
		ButtonActionListener searchArrayListListener = new ButtonActionListener(searchArrayListButton);
		ButtonActionListener searchSortedArrayListListener = new ButtonActionListener(searchSortedArrayListButton);
		ButtonActionListener searchArrayListener = new ButtonActionListener(searchArrayButton);
		ButtonActionListener searchMergeSortListener =  new ButtonActionListener(searchMergeSortIntsButton);
		ButtonActionListener searchMergeSort2Listener = new ButtonActionListener(searchMergeSortInts2Button);
		ButtonActionListener searchQuickSortListener = new ButtonActionListener(searchQuickSortIntsButton);
		
		// add the listener to buttons
		sortIntsButton.addActionListener(sortIntsListener);
		addToBtsButton.addActionListener(addtoBtsListener);
		addToTreeSetButton.addActionListener(addtoTreeListener);
		addToPriorityQueueButton.addActionListener(addtoPriorityListener);
		addToHashSetButton.addActionListener(addtoHashListener);
		addToArrayListButton.addActionListener(addtoArrayListListener);
		addToSortedArrayListButton.addActionListener(addtoSortedArrayListener);
		addToArrayButton.addActionListener(addtoArrayListener);
		mergeSortIntsButton.addActionListener(mergeSortIntsListener);
		mergeSortInts2Button.addActionListener(mergeSortInts2Listener);
		quickSortIntsButton.addActionListener(quickSortIntsListener);

		searchSortedIntsButton.addActionListener(searchSortedIntsListener);
		searchBtsButton.addActionListener(searchBtsListener);
		searchTreeSetButton.addActionListener(searchTreeListener);
		searchPriorityQueueButton.addActionListener(searchPriorityListener);
		searchHashSetButton.addActionListener(searchHashListener);
		searchArrayListButton.addActionListener(searchArrayListListener);
		searchSortedArrayListButton.addActionListener(searchSortedArrayListListener);
		searchArrayButton.addActionListener(searchArrayListener);
		searchMergeSortIntsButton.addActionListener(searchMergeSortListener);
		searchMergeSortInts2Button.addActionListener(searchMergeSort2Listener);
		searchQuickSortIntsButton.addActionListener(searchQuickSortListener);
		
		// disable all buttons till later
		sortIntsButton.setEnabled(false);
		addToBtsButton.setEnabled(false);
		addToTreeSetButton.setEnabled(false);
		addToPriorityQueueButton.setEnabled(false);
		addToHashSetButton.setEnabled(false);
		addToArrayListButton.setEnabled(false);
		addToSortedArrayListButton.setEnabled(false);
		addToArrayButton.setEnabled(false);
		mergeSortIntsButton.setEnabled(false);
		mergeSortInts2Button.setEnabled(false);
		quickSortIntsButton.setEnabled(false);

		searchSortedIntsButton.setEnabled(false);
		searchBtsButton.setEnabled(false);
		searchTreeSetButton.setEnabled(false);
		searchPriorityQueueButton.setEnabled(false);
		searchHashSetButton.setEnabled(false);
		searchArrayListButton.setEnabled(false);
		searchSortedArrayListButton.setEnabled(false);
		searchArrayButton.setEnabled(false);
		searchMergeSortIntsButton.setEnabled(false);
		searchMergeSortInts2Button.setEnabled(false);
		searchQuickSortIntsButton.setEnabled(false);

		sortFileName = args[0];
		searchFileName = args[1];

		// validate the frame and put it on the screen
		f.validate();
		f.setVisible(true);
	}

	// action listener for the buttons
	static class ButtonActionListener implements java.awt.event.ActionListener{
		// the button associated with the action listener, so that we can
		// share this one class with multiple buttons
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b){
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			String option = b.getText().toLowerCase().toLowerCase();
			System.out.println("action performed on " + b.getText() + " button");
			switch(option){
				case "sort ints":
				long t1=System.currentTimeMillis();
				selSortVals = new int[sortVals.length];
				for(int i = 0; i<sortVals.length;i++){
					selSortVals[i] = sortVals[i];
				}
				selectionSort(selSortVals);
				long t2= System.currentTimeMillis();
				String timelab1 = String.valueOf(t2-t1 + "ms");
				sortIntsLabel.setText(timelab1);
				sortInt = true;
				if(haspressed){
					searchSortedIntsButton.setEnabled(true);
				}
				break;

				case "add to binary search tree":
				long t3 = System.currentTimeMillis();
				addToBTS();
				long t4= System.currentTimeMillis();
				String timelab2 = String.valueOf(t4-t3 + "ms");
				addToBtsButtonLabel.setText(timelab2);
				BTSbool = true;
				if(haspressed){
					searchBtsButton.setEnabled(true);
				}
				break;

				case "add to treeset":
				long t5=System.currentTimeMillis();
				addToTreeSet();
				long t6= System.currentTimeMillis();
				String timelab3 = String.valueOf(t6-t5 + "ms");
				addToTreeSetLabel.setText(timelab3);
				Treebool =true;
				if(haspressed){
					searchTreeSetButton.setEnabled(true);
				}
				break;

				case "add to priority queue":
				long t7=System.currentTimeMillis();
				addToPriorityQueue();
				long t8= System.currentTimeMillis();
				String timelab4 = String.valueOf(t8-t7 + "ms");
				addToPriorityQueueLabel.setText(timelab4);
				Prioritybool = true;
				if(haspressed){
					searchPriorityQueueButton.setEnabled(true);
				}
				break;

				case "add to hashset":
				long t9=System.currentTimeMillis();
				addToHash();
				long t10= System.currentTimeMillis();
				String timelab5 = String.valueOf(t10-t9 + "ms");
				addToHashSetLabel.setText(timelab5);
				hashbool = true;
				if(haspressed){
					searchHashSetButton.setEnabled(true);
				}
				break;

				case "add to array list":
				long t11=System.currentTimeMillis();
				addToArrayList();
				long t12= System.currentTimeMillis();
				String timelab6 = String.valueOf(t12-t11 + "ms");
				addToArrayListLabel.setText(timelab6);
				ArrayLbool = true;
				if(haspressed){
					searchArrayListButton.setEnabled(true);
				}
				break;

				case "add to sorted array list":
				long t13 = System.currentTimeMillis();
				addToSortedArrayList();
				long t14= System.currentTimeMillis();
				String timelab7 = String.valueOf(t14-t13 + "ms");
				addToSortedArrayListLabel.setText(timelab7);
				SortArraybool = true;
				if(haspressed){
					searchSortedArrayListButton.setEnabled(true);
				}
				break;

				case "add to array":
				long t15 = System.currentTimeMillis();
				addToArray();
				long t16= System.currentTimeMillis();
				String timelab8 = String.valueOf(t16-t15 + "ms");
				addToArrayLabel.setText(timelab8);
				Arraybool = true;
				if(haspressed){
					searchArrayButton.setEnabled(true);
				}
				break;

				case "merge sort ints tpd":
				long t17 = System.currentTimeMillis();
				mergeSortTpD();
				long t18= System.currentTimeMillis();
				String timelab9 = String.valueOf(t18-t17 + "ms");
				mergeSortIntsLabel.setText(timelab9);
				mergebool = true;
				if(haspressed){
					searchMergeSortIntsButton.setEnabled(true);
				}
				break;

				case "merge2 sort ints":
				System.out.println("done");
				break;

				case "quick sort ints":
				System.out.println("done");
				break;

				case "search sorted ints":
				long s1 = System.currentTimeMillis();
				int s = searchInts();
				long s2 = System.currentTimeMillis();
				String searchlab1 = String.valueOf(s2 - s1);
				searchSortedIntsLabel.setText(s + "\\" + searchlab1 + "ms");
				break;

				case "search binary search tree":
				long s3 = System.currentTimeMillis();
				int b = searchBTS();
				long s4 = System.currentTimeMillis();
				String searchlab2 = String.valueOf(s4 - s3);
				searchBtsLabel.setText(b + "\\" + searchlab2 + "ms");
				break;

				case "search treeset":
				long s5 = System.currentTimeMillis();
				int t = searchTreeSet();
				long s6 = System.currentTimeMillis();
				String searchlab3 = String.valueOf(s6 - s5);
				searchTreeSetLabel.setText(t + "\\" + searchlab3 + "ms");
				break;

				case "search priority queue":
				long s7 = System.currentTimeMillis();
				int p = searchPriority();
				long s8 = System.currentTimeMillis();
				String searchlab4 = String.valueOf(s8 - s7);
				searchPriorityQueueLabel.setText(p + "\\" + searchlab4 + "ms");
				break;

				case "search hashset":
				long s9 = System.currentTimeMillis();
				int h = searchHash();
				long s10 = System.currentTimeMillis();
				String searchlab5 = String.valueOf(s10 - s9);
				searchHashSetLabel.setText(h + "\\" + searchlab5 + "ms");
				break;

				case "search array list":
				long s11 = System.currentTimeMillis();
				int al = searchArrayList();
				long s12 = System.currentTimeMillis();
				String searchlab6 = String.valueOf(s12 - s11);
				searchArrayListLabel.setText(al + "\\" + searchlab6 + "ms");
				break;

				case "search sorted array list":
				long s13 = System.currentTimeMillis();
				int sa = searchSortedArrayList();
				long s14 = System.currentTimeMillis();
				String searchlab7 = String.valueOf(s14 - s13);
				searchSortedArrayListLabel.setText(sa + "\\" + searchlab7 + "ms");
				break;

				case "search array":
				long s15 = System.currentTimeMillis();
				int a = searchArray();
				long s16 = System.currentTimeMillis();
				String searchlab8 = String.valueOf(s16 - s15);
				searchArrayLabel.setText(a + "\\" + searchlab8 + "ms");
				break;

				case "search merge sort ints":
				long s17 = System.currentTimeMillis();
				int m = searchMergeSort();
				long s18 = System.currentTimeMillis();
				String searchlab9 = String.valueOf(s18 - s17);
				searchMergeSortIntsLabel.setText(m + "\\" + searchlab9 + "ms");
				
				break;

				case "search merge2 sort ints":
				System.out.println("done");
				break;

				case "search quick sort ints":
				System.out.println("done");
				break;
			}			
		}
	}
	
	// action listener for the menu items
	static class MenuItemActionListener implements java.awt.event.ActionListener{
		// the menu item associated with the action listener, so that we can
		// share this one class with multiple menu items
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m){
			this.m = m;
		}
		public void actionPerformed(java.awt.event.ActionEvent e){
			// if exit is selected from the file menu, exit the program
			String action = m.getText().toLowerCase();
			System.out.println("Action performed on " + action);
			switch(action){

				case "exit":
				System.out.println("Action performed on Exit button");
				System.exit(0);
				break;

				// set left buttons to the condition of read sort file
				case "read sort file":
					sortIntsButton.setEnabled(true);
					addToBtsButton.setEnabled(true);
					addToTreeSetButton.setEnabled(true);
					addToPriorityQueueButton.setEnabled(true);
					addToHashSetButton.setEnabled(true);
					addToArrayListButton.setEnabled(true);
					addToSortedArrayListButton.setEnabled(true);
					addToArrayButton.setEnabled(true);
					mergeSortIntsButton.setEnabled(true);
					mergeSortInts2Button.setEnabled(true);
					quickSortIntsButton.setEnabled(true);
					readData(sortFileName, true);
				break;

				// set right buttons to the condition of read search file
				case "read search file":
					haspressed = true;
					readData(searchFileName, false);
					if(sortInt){
						searchSortedIntsButton.setEnabled(true);
					}
					if(BTSbool){
						searchBtsButton.setEnabled(true);
					}
					if(Treebool){
						searchTreeSetButton.setEnabled(true);
					}
					if(Prioritybool){
						searchPriorityQueueButton.setEnabled(true);
					}
					if(hashbool){
						searchHashSetButton.setEnabled(true);
					}
					if(ArrayLbool){
						searchArrayListButton.setEnabled(true);
					}
					if(SortArraybool){
						searchSortedArrayListButton.setEnabled(true);
					}
					if(Arraybool){
						searchArrayButton.setEnabled(true);
					}
					if(mergebool){
						searchMergeSortIntsButton.setEnabled(true);
					}
				break;
			}
		}
	}
}