// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvMediation, SimpleJSON, CvSDK, CvValueExchange

class this._cls0
    implements this._cls0
{

    final CvMediation this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
        CvMediation.access$300()._mth300(new Object[] {
            "Processing order config..."
        });
        obj = (SimpleJSON)obj;
        CvSDK.valueExchange.configure(((SimpleJSON) (obj)).getJSONObject("valueExchange"));
        _pcls0.olve(obj);
    }

    e()
    {
        this$0 = CvMediation.this;
        super();
    }
}
