// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvConfig, Q

class this._cls0
    implements ndler
{

    final CvConfig this$0;

    public void onFailure(Throwable throwable, Object obj)
    {
        CvConfig.access$000(CvConfig.this).w(throwable, new Object[] {
            "Cannot load mCfg"
        });
        CvConfig.access$502(CvConfig.this, System.currentTimeMillis() + 0x927c0L);
    /* block-local class not found */
    class _cls1 {}

        Q.when(restoreConfig).then(parseConfig).failure(new _cls1()).success(finishLoading);
    }

    _cls1()
    {
        this$0 = CvConfig.this;
        super();
    }
}
