// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import com.igexin.sdk.data.BasicDataManager;

// Referenced classes of package com.igexin.sdk:
//            CallbackListener, SdkService

class this._cls0
    implements CallbackListener
{

    final SdkService this$0;

    public void exceptionHandler(Exception exception)
    {
    }

    public void getCallbackData(Object obj)
    {
        obj = (String)obj;
        BasicDataManager.vcid = ((String) (obj));
        BasicDataManager.updateVcidValue(1, "vcid", ((String) (obj)));
        BasicDataManager.lastBindAppTime = System.currentTimeMillis();
        BasicDataManager.updateDBValue(3, "lastBindAppTime", String.valueOf(BasicDataManager.lastBindAppTime));
        SdkService.access$200(SdkService.this, 1, "vcid", ((String) (obj)));
        BasicDataManager.saveVcidToFile(((String) (obj)));
    }

    aManager()
    {
        this$0 = SdkService.this;
        super();
    }
}
