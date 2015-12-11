// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.dvm;

import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.dvm:
//            d, b, a

public class c extends a
{

    private final com.target.mothership.model.dvm.a mDvmDataSource;

    public c()
    {
        if (b.a().m())
        {
            mDvmDataSource = new d();
            return;
        } else
        {
            mDvmDataSource = new com.target.mothership.model.dvm.b();
            return;
        }
    }

    public void a(DvmRemoteData dvmremotedata, h h)
    {
        mDvmDataSource.a(dvmremotedata, h);
    }

    public void a(String s, h h)
    {
        mDvmDataSource.a(s, h);
    }
}
