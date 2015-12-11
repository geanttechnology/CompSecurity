// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import com.igexin.sdk.data.BasicDataManager;
import com.igexin.sdk.data.ConfigDataManager;
import com.igexin.sdk.data.DynamicConfig;

// Referenced classes of package com.igexin.sdk:
//            CallbackListener, SdkService

class this._cls0
    implements CallbackListener
{

    final SdkService this$0;

    public void exceptionHandler(Exception exception)
    {
        SdkService.access$100(SdkService.this);
    }

    public void getCallbackData(Object obj)
    {
        obj = (DynamicConfig)obj;
        ConfigDataManager.setEncryptEnable(((DynamicConfig) (obj)).isEncrypt());
        ConfigDataManager.setDownloadUrl(((DynamicConfig) (obj)).getDownloadUrl());
        ConfigDataManager.setMasterAppID(((DynamicConfig) (obj)).getMasterAppID());
        ConfigDataManager.setMasterPkgName(((DynamicConfig) (obj)).getMasterPkgName());
        ConfigDataManager.setMasterServiceAction(((DynamicConfig) (obj)).getMasterServiceAction());
        ConfigDataManager.write(((DynamicConfig) (obj)));
        BasicDataManager.lastGetConfigTime = System.currentTimeMillis();
        BasicDataManager.updateDBValue(4, "lastGetConfigTime", String.valueOf(BasicDataManager.lastGetConfigTime));
        SdkService.access$000(SdkService.this);
        SdkService.access$100(SdkService.this);
    }

    aManager()
    {
        this$0 = SdkService.this;
        super();
    }
}
