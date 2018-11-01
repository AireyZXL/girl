package com.imooc.gril.controller;

import com.imooc.gril.domain.Girl;
import com.imooc.gril.domain.Result;
import com.imooc.gril.repository.GirlRepository;
import com.imooc.gril.service.GirlService;
import com.imooc.gril.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> grilList() {
        System.out.println("griList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age,
                        @RequestParam("money") Double money) {

        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);

        return girlRepository.save(girl);
    }

    @PostMapping(value = "/girlsbyentity")
    public Object girlByEntity(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());

        return girlRepository.save(girl);
    }


    /**
     * 表单校验
     *
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/girlsO")
    public Result<Girl> girlAddOtherWay(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }


        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());


        return ResultUtil.success(girlRepository.save(girl));
    }


    /**
     * 查询一个女生
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }


    /**
     * 更新一个女生
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl grilUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl gril = new Girl();
        gril.setAge(age);
        gril.setId(id);
        gril.setCupSize(cupSize);

        return girlRepository.save(gril);
    }

    /**
     * 删除一个女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void insertTwo() {
        girlService.insertTwo();
    }

}
