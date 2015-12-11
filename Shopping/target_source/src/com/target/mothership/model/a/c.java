// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.a;

import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.d;

// Referenced classes of package com.target.mothership.model.a:
//            d, b, a

public class c extends a
{

    private static final String TAG = com/target/mothership/model/d/c.getSimpleName();
    private com.target.mothership.model.a.a mDepartmentAdjacencyDataSource;

    public c()
    {
        if (b.a().m())
        {
            mDepartmentAdjacencyDataSource = new com.target.mothership.model.a.d();
            return;
        } else
        {
            mDepartmentAdjacencyDataSource = new com.target.mothership.model.a.b();
            return;
        }
    }

    public void a(d d1)
    {
        mDepartmentAdjacencyDataSource.a(d1);
    }

}
