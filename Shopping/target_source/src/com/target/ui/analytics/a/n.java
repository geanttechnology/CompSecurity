// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import com.target.mothership.model.common.a.j;
import com.target.mothership.services.x;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            c, i, q

public class n extends c
{

    private static final int PRIMARY_REASON_INDEX = 0;
    private final x mError;
    private final j mReason;

    private n(x x1, j j1)
    {
        mError = x1;
        mReason = j1;
    }

    public static n a(x x1)
    {
        return new n(x1, null);
    }

    public static n a(x x1, j j1)
    {
        return new n(x1, j1);
    }

    public static n a(x x1, List list)
    {
        if (list == null || list.isEmpty())
        {
            return new n(x1, null);
        } else
        {
            return new n(x1, (j)list.get(0));
        }
    }

    protected Map b()
    {
        a a1 = new a();
        com.target.ui.analytics.a.i.a(a1, "errorMessage", com.target.ui.analytics.a.i.a(mError, mReason));
        com.target.ui.analytics.a.i.a(a1, "statusCode", String.valueOf(mError.b()));
        return a1;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected q i()
    {
        return q.ErrorReceived;
    }
}
