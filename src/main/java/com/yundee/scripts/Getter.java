package com.yundee.scripts;

import com.yundee.utils.HttpUtils;

public class Getter {
    public String GetList(){
        return HttpUtils.list();
    }
}
