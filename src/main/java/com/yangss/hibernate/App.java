package com.yangss.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yangss.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		//读取配置文件  
        Configuration cfg = new Configuration().configure();  
        SessionFactory factory = cfg.buildSessionFactory();  
          
        Session session = null;  
        try{  
            session = factory.openSession();  
            //开启事务  
            session.beginTransaction();  
             
            Date date = new Date();
            Student student = new Student();  
            student.setName("yangss");
            student.setSex(1);
            student.setAge(26);
            student.setIdcard("141122199209140036");
            student.setCreateTime(date);
            student.setUpdateTime(date);
              
            session.save(student);  
            //提交事务  
            session.getTransaction().commit();  
              
        }catch(Exception e){  
            e.printStackTrace();  
            //回滚事务  
            session.getTransaction().rollback();  
        }finally{  
            if(session != null){  
                if(session.isOpen()){  
                    //关闭session  
                    session.close();  
                }  
            }  
        }  
    }
}
