package crud_redis_ntnh_18036971.repository;

import crud_redis_ntnh_18036971.entity.Employee;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class EmployeeRepository {
    //private HashOperations hashOperations;
    //private ListOperations listOperations;
    private SetOperations setOperations;

    private RedisTemplate redisTemplate;

    public EmployeeRepository( RedisTemplate redisTemplate) {
        this.setOperations = redisTemplate.opsForSet();
        this.redisTemplate = redisTemplate;
    }
    public void saveEmployee(Employee employee){

        //listOperations.leftPush("EMPLOYEE", employee.getId(), employee);
        setOperations.add("EMPLOYEE", employee.getId(), employee);
    }
    public Set<Employee> findAll(){

        //return listOperations.size("EMPLOYEE");
        return setOperations.members("EMPLOYEE");
    }
    public Employee findById(Integer id) {

        return (Employee) setOperations.pop("EMPLOYEE", id);
    }
    public void update(Employee employee){
        saveEmployee(employee);
    }
    public void delete(Employee employee){
        setOperations.remove("EMPLOYEE",1,employee);
    }
}
