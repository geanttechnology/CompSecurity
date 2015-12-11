// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.handler.e;

// Referenced classes of package com.target.mothership.model.coupons.a:
//            i

public class l
{

    private c mErrorCode;

    public l(String s)
    {
        mErrorCode = null;
        s = e.a(s);
        if (s == e.OK || s == e.QUEUED)
        {
            mErrorCode = null;
            return;
        } else
        {
            mErrorCode = i.a(s);
            return;
        }
    }

    public boolean a()
    {
        return mErrorCode != null;
    }

    public c b()
    {
        return mErrorCode;
    }
}
