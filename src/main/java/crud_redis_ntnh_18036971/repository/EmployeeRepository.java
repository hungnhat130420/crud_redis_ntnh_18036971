package crud_redis_ntnh_18036971.repository;

import crud_redis_ntnh_18036971.entity.Employee;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    //private HashOperations hashOperations;
    private ListOperations listOperations;

    private RedisTemplate redisTemplate;

    public EmployeeRepository( RedisTemplate redisTemplate) {
        this.listOperations = redisTemplate.opsForList();
        this.redisTemplate = redisTemplate;
    }
    public void saveEmployee(Employee employee){

        listOperations.leftPush("EMPLOYEE", employee.getId(), employee);
    }
    public Long findAll(){

        return listOperations.size("EMPLOYEE");
    }
    public Employee findById(Integer id){

        return (Employee) listOperations.index("EMPLOYEE", id);
    }

    public void update(Employee employee){
        saveEmployee(employee);
    }
    public void delete(Employee employee){
        listOperations.remove("EMPLOYEE",1,employee);
    }
}
