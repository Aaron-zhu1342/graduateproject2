package org.com.Service;

import org.com.Entity.Borrow;
import org.com.Entity.User;
import org.com.Mapper.BookMapper;
import org.com.Mapper.BorrowMapper;
import org.com.Mapper.UserMapper;
import org.com.Service.Interface.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public String AddBookBorrowInfo(String user_name,int book_id,String temperature){
        User user = userMapper.QuerybyName(user_name);
        if (Integer.parseInt(user.getUser_book_num())<5) {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            Date time_start = new Date();
            long time_end_s =  time_start.getTime()+864000000;
            Date time_end = new Date();
            time_end.setTime(time_end_s);
            Borrow borrow = new Borrow(book_id, sdFormat.format(time_start.getTime()).toString(), sdFormat.format(time_end).toString(), user_name, temperature);

            int i = borrowMapper.AddBorrowBook_info(borrow);
            int count = Integer.parseInt(user.getUser_book_num());
            count = count +1;
            userMapper.UpdateUserBookNum(String.valueOf(count),user_name);
            bookMapper.UpdateBookStatus(book_id,"0");
            if (i != 0) return "200";
            else return "202";
        }else return "201";
    }

}
