// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvConfig

class this._cls0
    implements ndler
{

    final CvConfig this$0;

    public void onSuccess(Object obj)
    {
        CvConfig.access$000(CvConfig.this).i(new Object[] {
            "Config loaded successfully"
        });
        CvConfig.access$902(CvConfig.this, System.currentTimeMillis());
        CvConfig.access$502(CvConfig.this, CvConfig.access$900(CvConfig.this) + 0x1b77400L);
        finishLoading.onSuccess(obj);
    }

    ndler()
    {
        this$0 = CvConfig.this;
        super();
    }
}
