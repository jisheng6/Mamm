package com.example.adminjs.mamm.model;

import com.example.adminjs.mamm.MyApp;
import com.example.adminjs.mamm.bean.Bean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2017/12/6.
 */

public class MoldelImpl {
    public void getData(final ModelCallBack callBack){
        Map<String, String> map = new HashMap<>();
        map.put("key","71e58b5b2f930eaf1f937407acde08fe");
        map.put("num","10");
        MyApp.inters.get(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }

    public interface ModelCallBack {
        public void success(Bean bean);
    }
}
