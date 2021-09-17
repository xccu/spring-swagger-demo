
package com.example.demo.swagger.controller;

import com.example.demo.swagger.entity.User;
import com.example.demo.swagger.service.UserService;
import com.example.demo.swagger.vo.ResultListVO;
import com.example.demo.swagger.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//访问网址：
//http://localhost:8080/swagger-ui.html#/

@RestController
@Api(value = "UserController", tags = { "用户接口" })
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    @ApiOperation(value = "根据Id获取用户")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数")})
    public ResultVO getUser(@ApiParam("用户id") @RequestParam("id") int id) {
        ResultVO vo = new ResultVO();
        User user =userService.getUser(id);
        vo.setUser(user);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

    @GetMapping("/all")
    @ApiOperation(value = "根据Id获取用户")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数")})
    public ResultListVO getAll() {
        ResultListVO vo = new ResultListVO();
        List<User> users =userService.getUsers();
        vo.setUsers(users);
        vo.setCode(200);
        vo.setErrorMsg("");
        return vo;
    }

   /* @ApiOperation(value = "添加一部电影")
    @PostMapping("/addFilm")
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, response = Film.class,message = "缺少参数") })
    public ResultVO addFilm(@ApiParam("电影名称") @RequestParam("filmName") String filmName,
                               @ApiParam(value = "分数", allowEmptyValue = true) @RequestParam("score") Short score,
                               @ApiParam("发布时间") @RequestParam(value = "publishTime",required = false) String publishTime,
                               @ApiParam("创建者id") @RequestParam("creatorId") Long creatorId) {

        if (Objects.isNull(filmName) || Objects.isNull(score) || Objects.isNull(publishTime) || StringUtils
                .isEmpty(creatorId)) {
            return new ResultVO(ResultVO.failed, "参数错误");
        }

        Film filmPOM = new Film();
        filmPOM.setFilmName(filmName);
        filmPOM.setScore(score);
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date publishTimeDate = null;

        try {
            publishTimeDate = simpleDateFormat.parse(publishTime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        filmPOM.setPublishTime(publishTimeDate);
        filmPOM.setCreatorId(creatorId);
        Boolean result = filmService.addFilm(filmPOM);

        if (result) {
            return new ResultVO(CommonConstants.SUCCESSMSG);
        }

        return new ResultVO(CommonConstants.FAILD_MSG);

    }


    *//**

     * 根据电影名更新

     *

     * @return

     *//*

    @PostMapping("/updateScore")

    @ApiOperation(value = "根据电影名修改分数")

    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),

            @ApiResponse(code = 1002, message = "缺少参数") })

    public ResultVO updateFilmScore(@ApiParam("电影名称") @RequestParam("fileName") String fileName,

                                       @ApiParam("分数") @RequestParam("score") Short score) {

        if (StringUtils.isEmpty(fileName) || Objects.isNull(score)) {

            return CommonConstants.getErrorResultVO();

        }

        filmService.updateScoreByName(fileName, score);

        return CommonConstants.getSuccessResultVO();

    }

    *//**

     * 根据电影名删除电影

     *

     * @param request

     * @return

     *//*

    @PostMapping("/delFilm")

    @ApiOperation(value = "根据电影名删除电影")

    @ApiImplicitParams({ @ApiImplicitParam(name = "filmName",

            value = "电影名",

            dataType = "String",

            paramType = "query",

            required = true), @ApiImplicitParam(name = "id", value = "电影id", dataType = "int", paramType = "query") })

    public ResultVO deleteFilmByNameOrId(HttpServletRequest request) {

        //电影名

        String filmName = request.getParameter("filmName");

        //电影id

        Long filmId = Long.parseLong(request.getParameter("id"));

        filmService.deleteFilmOrId(filmName,filmId);

        return CommonConstants.getSuccessResultVO();

    }

    *//**

     * 根据id获取电影

     *

     * @param id

     * @return

     *//*

    @PostMapping("/{id}")

    @ApiOperation("根据id获取电影")

    @ApiImplicitParam(name = "id", value = "电影id", dataType = "long", paramType = "path", required = true)

    public ResultVO getFilmById(@PathVariable Long id) {

        if (Objects.isNull(id)) {

            return CommonConstants.getLessParamResultVO();

        }

        Film film = filmService.getFilmById(id);

        if (Objects.nonNull(film)) {

            return new ResultVO(film);

        }

        return CommonConstants.getErrorResultVO();

    }

    *//**

     * 修改整个电影

     *

     * @param film

     * @return

     *//*

    @PostMapping("/insertFilm")

    @ApiOperation("插入一部电影")

    public ResultVO insertFilm(@ApiParam("电影实体对象") @RequestBody Film film) {

        if (Objects.isNull(film)) {

            return CommonConstants.getLessParamResultVO();

        }

        Boolean isSuccess = filmService.insertFilm(film);

        if (isSuccess) {

            return CommonConstants.getSuccessResultVO();

        }

        return CommonConstants.getErrorResultVO();

    }*/

}


