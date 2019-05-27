import os
import csv


num_of_methods = 0
num_ok = 0

manual_methods = 0
num_manual = 0

num_no_info = 0


def process_no_info(dirname):
    patches_folder = os.path.join(dirname, 'patches')
    log_file = os.path.join(dirname, 'log')

    if os.path.isfile(log_file):
        global num_no_info
        print(dirname.split('/')[-1] + " UNKNOWN")
        num_no_info += 1
        return
    
    global num_manual
    num_manual += 1
    
    global manual_methods
    manual_methods += len(os.listdir(patches_folder))
    print(dirname.split('/')[-1] + " " + str(len(os.listdir(patches_folder))) + " MANUALLY")


def process_project(dirname):
    moved_methods_name = 'moved-methods.csv'
    moved_methods_path = os.path.join(dirname, moved_methods_name)
    if not os.path.isfile(moved_methods_path):
        process_no_info(dirname)
        return
        
    result = -1
    with open(moved_methods_path) as moved_methods_file:
      csv_reader = csv.reader(moved_methods_file, delimiter=',')
      for _ in csv_reader:
          result += 1
    print(dirname.split('/')[-1] + " " + str(result))
    global num_of_methods
    num_of_methods += result
    
    global num_ok
    num_ok += 1


def main():
    for filename in os.listdir():
        if not os.path.isdir(filename) or filename == '.git':
            continue
    
        process_project(filename)

    print('Partially processed projects:', num_no_info)
    print()
    
    print('Projects with manually moved methods:', num_manual) 
    print('Manually moved methods:', manual_methods)
    print()

    print('Automatically processed projects:', num_ok)
    print('Automatically moved methods:', num_of_methods)


if __name__ == '__main__':
    main()

