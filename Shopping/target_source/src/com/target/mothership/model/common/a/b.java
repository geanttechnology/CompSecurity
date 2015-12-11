// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.common.a;

import com.target.mothership.services.x;
import java.util.List;

// Referenced classes of package com.target.mothership.model.common.a:
//            f, j

public abstract class b
    implements f
{

    private x mCause;
    private j mReason;
    private List mReasons;

    public b()
    {
    }

    public void a(j j)
    {
        mReason = j;
    }

    public void a(x x)
    {
        mCause = x;
    }

    public void a(List list)
    {
        mReasons = list;
    }

    public x d()
    {
        return mCause;
    }

    public j e()
    {
        return mReason;
    }

    public List f()
    {
        return mReasons;
    }
}
