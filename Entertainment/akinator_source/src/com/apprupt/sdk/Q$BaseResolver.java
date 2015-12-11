// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            Q

private class <init>
    implements <init>
{

    private final completion completion;
    private final completion promise;
    final Q this$0;

    public void fail(Throwable throwable)
    {
        fail(throwable, null);
    }

    public void fail(Throwable throwable, Object obj)
    {
        Object obj1 = throwable;
        if (throwable == null)
        {
            obj1 = new Exception("Unknown error!");
        }
        promise.esolve(((Throwable) (obj1)), obj, completion);
    }

    public void resolve(Object obj)
    {
        promise.esolve(null, obj, completion);
    }

    private ( ,  1)
    {
        this$0 = Q.this;
        super();
        promise = ;
        completion = 1;
    }

    completion(completion completion1, completion completion2, completion completion3)
    {
        this(completion1, completion2);
    }
}
