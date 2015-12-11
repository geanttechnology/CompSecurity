// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model;

import com.target.mothership.services.o;
import com.target.mothership.services.w;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model:
//            b

public class e extends w
{

    private b mHandler;

    public e(b b1)
    {
        if (b1 == null)
        {
            throw new IllegalArgumentException("response handler must not be null");
        } else
        {
            mHandler = b1;
            return;
        }
    }

    public String getTag()
    {
        return mHandler.a();
    }

    public void onError(x x)
    {
        mHandler.a(x, (o)getRequestRetryable().d());
    }

    public void onResult(Object obj)
    {
        mHandler.a(obj, getResponseCode(), (o)getRequestRetryable().d());
    }
}
