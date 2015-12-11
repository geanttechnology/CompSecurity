// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.b;

import com.target.mothership.services.p;
import com.target.mothership.services.q;
import com.target.mothership.services.x;
import com.target.mothership.services.y;

// Referenced classes of package com.target.mothership.b:
//            c

public class a
    implements p
{

    private boolean mHasError;
    private c mMockServer;

    public a(c c1, boolean flag)
    {
        mMockServer = c1;
        mHasError = flag;
    }

    public void a(com.target.mothership.services.f.a.b.b b, q q1, String s)
    {
        if (!mHasError)
        {
            q1.a(mMockServer.a(), true, b);
            return;
        } else
        {
            q1.a(x.a("").b(mMockServer.a().a()).a(), b);
            return;
        }
    }

    public void a(String s)
        throws IllegalArgumentException
    {
    }
}
