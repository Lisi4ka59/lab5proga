package commands;

public class HelpCommand implements Command{
    @Override
    public void execute() {
        System.out.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update_id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id {id} : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script {file_name} : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                remove_first : удалить первый элемент из коллекции
                remove_head : вывести первый элемент коллекции и удалить его
                add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                print_descending : вывести элементы коллекции в порядке убывания
                print_unique_standard_of_living : вывести уникальные значения поля standardOfLiving всех элементов в коллекции
                print_field_ascending_standard_of_living : вывести значения поля standardOfLiving всех элементов в порядке возрастания""");
    }
}
