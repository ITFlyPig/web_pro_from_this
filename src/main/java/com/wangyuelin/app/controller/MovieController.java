package com.wangyuelin.app.controller;

import com.wangyuelin.app.bean.HomeMovieBean;
import com.wangyuelin.app.bean.HomeMovieResp;
import com.wangyuelin.app.bean.MovieTagBean;
import com.wangyuelin.app.service.itf.IMovie;
import com.wangyuelin.app.utils.Constant;
import com.wangyuelin.app.utils.MovieTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @outhor wangyuelin
 * @create 2018-06-25 下午4:11
 */
@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private IMovie iMovie;

    @RequestMapping("/getHomeMovie")
    @ResponseBody
    public HomeMovieResp getHomeMovies() {
        HomeMovieResp resp = new HomeMovieResp();
        resp.setCode(Constant.RespCode.SUCCESS);
        resp.setMsg(Constant.MSG.SUCCESS);

        Map<String, List<HomeMovieBean>> movieMap = getHomeMovieByTag(MovieTag.ZUIXIN);
        if (movieMap != null) {
            resp.setData(new ArrayList<Map<String, List<HomeMovieBean>>>());
            resp.getData().add(movieMap);

        }
        return resp;

    }


    /**
     * 据tag查询电影
     * @param tag
     * @return
     */
    public Map<String, List<HomeMovieBean>> getHomeMovieByTag(MovieTag tag) {
        if (tag == null) {
            return null;
        }
        List<HomeMovieBean> movies = iMovie.getMoviesByNum(12);
        if (movies == null) {
            return null;
        }
        HashMap<String, List<HomeMovieBean>> tagMovie = new HashMap<String, List<HomeMovieBean>>();
        tagMovie.put(tag.getTagStr(), movies);
        return tagMovie;

    }

}