### Ревью данного кода по SOLID.
https://github.com/killkuruzzza/OOPSeminar4/tree/main/src/main/java/ru/gb/oseminar

---
Single Responsibility - противоречий нет

Open-Closed - нет

Liskov Substitution - нет

Interface Segregation - нет

---

Dependency Inversion - классы должны зависеть от абстракций

1. Высокий класс StudentController напрямую зависит от классов низкого уровня DataService, StudentGroupService, StudentView. При удалении этих сервисов у нас будут проблемы. Для их решения нам придется модифицировать StudentController, что будет также нарушать Open-Closed принцип и это может добавить новых проблем.
Предлагаю заменить строчки с жесткой прямой зависимостью, перенаправив (инверсировав) ее на новые интерфейсы. (15 строка)

        private final StudentService dataService = new StudentService(); 
        private final StudentGroupService studentGroupService = new StudentGroupService();
        private final StudentView studentView = new StudentView();

Заменить на:

    private final UserService<Student> dataService;
    private final IStudentGroupService iStudentGroupService;
    private final UserView userView;

    public StudentController(UserService<Student> dataService, IStudentGroupService iStudentGroupService, UserView userView) {
        this.dataService = dataService;
        this.iStudentGroupService = iStudentGroupService;
        this.userView = userView;
    }

А также добавить недостающий интерфейс IStudentGroupService. Также мы получаем возможность использовать другие интерфейсы, тем самым добавляя расширяемость/поддерживаемость программы.

2. Класс StudentService зависит от ArrayList, но вдруг мы захотим использовать LinkedList или свой класс? (13 строка)

    public StudentService() {
    this.students = new ArrayList<>();
    }

Заменить на:

    public StudentService(List<Student> students) {
        this.students = students;
    }

3. StudyView также принимает logger напрямую. Можно добавить его в конструктор для более гибкой настройки логгера. (11 строка)

        Logger logger = Logger.getLogger(StudentView.class.getName());

Заменить на:

    Logger logger;

    public StudentView(Logger logger) {
        this.logger = logger;
    }

4. StudentGroupService напрямую зависит от StudentGroup (16 строка)

        public void createStudentGroup(Teacher teacher, List<Student> students) {
        this.studentGroup = new StudentGroup(teacher, students);
        }

Заменить на:

        public void createStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
        }