package com.volcengine;

import android.content.Context;
import com.volcengine.mars.update.AbsAppCommonContext;
import com.volcengine.mars.update.DeviceWrapper;
import java.util.HashMap;
import java.util.Map;

public class AppCommonContextImpl extends AbsAppCommonContext {
    private static final String PRIVATE_QINGDAO_BOE = "https://poc-api.vemarsdev.com/v1/gray_release/package";

    @Override
    public Context getContext() {
        return BaseApplication.getInstance();
    }

    @Override
    public String getStringAppName() {
        return "升级SDK Demo";
    }

    @Override
    public String getChannel() {
//        return isDebugApk() ? "local_test" : "release";
        return "beta";
    }

    @Override
    public String getDeviceId() {
        DeviceWrapper deviceService = new DeviceWrapper();
        return deviceService.getDeviceID();
    }

    @Override
    public int getUpdateVersionCode() {
//        return Integer.parseInt(AppUtils.getVersionName(sBaseContext));

        return 1580;
    }

    @Override
    public String getManifestVersionName() {
        return "1.5.8";
    }

    @Override
    public String getCity() {
        return "Shanghai";
    }

    @Override
    public String getPackageName(){
        return "com.volcengine.update";
    }

    @Override
    public Map<String, String> getCustomKV() {
        Map<String, String> customMap = new HashMap<>();
        customMap.put("user_id", "0000001");
        customMap.put("user_department", "deppon-delivery");
        customMap.put("user_role", "CTO");
        return customMap;
    }
    /**把下面这个注释还原就从BOE环境切换到了POC环境*/
    @Override
    public String getCustomUrl() {
        return PUBLIC_BOE;              //这个是BOE的下发端
        return PRIVATE_QINGDAO_BOE;    //这个是青岛机房POC的下发端
    }
}
