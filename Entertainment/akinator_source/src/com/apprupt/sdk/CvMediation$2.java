// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvMediation, Q, SimpleJSON

class val.json
    implements Runnable
{

    final CvMediation this$0;
    final SimpleJSON val$json;
    final long val$ts;

    public void run()
    {
        if (val$ts > CvMediation.access$100(CvMediation.this))
        {
            CvMediation.access$102(CvMediation.this, val$ts);
    /* block-local class not found */
    class _cls2 {}

    /* block-local class not found */
    class _cls1 {}

            CvMediation.access$202(CvMediation.this, Q.take(val$json).then(configureAdapters).then(configureOrder).then(configureValueExchange).success(new _cls2()).failure(new _cls1()));
        }
    }

    _cls1()
    {
        this$0 = final_cvmediation;
        val$ts = l;
        val$json = SimpleJSON.this;
        super();
    }
}
