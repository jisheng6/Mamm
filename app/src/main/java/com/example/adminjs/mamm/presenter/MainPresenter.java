package com.example.adminjs.mamm.presenter;

import com.example.adminjs.mamm.bean.Bean;
import com.example.adminjs.mamm.model.MoldelImpl;
import com.example.adminjs.mamm.view.MaView;

/**
 * Created by Adminjs on 2017/12/6.
 */

public class MainPresenter{
  private MaView view;
   private MoldelImpl moldel;
    public MainPresenter(MaView view) {
        this.view = view;
        this.moldel = new MoldelImpl();
    }

    public void get(){
        moldel.getData(new MoldelImpl.ModelCallBack() {
            @Override
            public void success(Bean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}
