// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.app.Fragment;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s, t

public class ba extends f
{

    public static final long LOAD_TIME_INSTANTANEOUS = 0L;
    private static final String TAG = com/target/ui/analytics/a/ba.getSimpleName();
    private final long mLoadTimeMS;
    private final s mScreen;

    private ba(long l, Fragment fragment)
    {
        mLoadTimeMS = l;
        mScreen = b(fragment);
    }

    public static ba a(long l, Fragment fragment)
    {
        return new ba(l, fragment);
    }

    public static ba a(Fragment fragment)
    {
        return new ba(0L, fragment);
    }

    private s b(Fragment fragment)
    {
        if (fragment == null)
        {
            return s.Unknown;
        } else
        {
            return t.a(fragment.getClass());
        }
    }

    protected s c()
    {
        return mScreen;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected Long i()
    {
        return Long.valueOf(mLoadTimeMS);
    }

}
