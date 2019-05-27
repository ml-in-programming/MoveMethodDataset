A dataset for the evaluation of Move Method recommendation algorithms. 

This repository is structured the following way:

-> <project_name> --- main folder with all data about this project

    -> <project_name> --- git submodule with a link to the actual repository
   
    -> patches - a folder containing patch to apply and physically move methods in project
   
    -> *.csv --- files describing the move method refactorings data 
       (see https://github.com/ml-in-programming/MoveMethodGenerator/)
   
    -> log --- log of the tool that generates possible relocations

-> print_statistics.py --- a python script that outputs statistics of the dataset (how many methods were moved)
