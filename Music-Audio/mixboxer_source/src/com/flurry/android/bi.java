// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.AsyncTask;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            FlurryAds, aa, FlurryAdSize

final class bi extends AsyncTask
{

    private Context Q;
    private ViewGroup ag;
    private String dq;
    private FlurryAdSize dr;
    private boolean ds;
    private boolean dt;
    private FlurryAds du;

    public bi(FlurryAds flurryads, Context context, String s, FlurryAdSize flurryadsize)
    {
        du = flurryads;
        super();
        Q = context;
        dq = s;
        dr = flurryadsize;
    }

    public bi(FlurryAds flurryads, Context context, String s, FlurryAdSize flurryadsize, ViewGroup viewgroup, boolean flag, boolean flag1)
    {
        this(flurryads, context, s, flurryadsize);
        ag = viewgroup;
        ds = flag1;
        dt = flag;
    }

    private transient List Z()
    {
        List list;
        try
        {
            list = du.a(Q, dq, ag, false, dr);
            du.hk.a(Q, list);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return Collections.emptyList();
        }
        return list;
    }

    protected final volatile Object doInBackground(Object aobj[])
    {
        return Z();
    }

    protected final volatile void onPostExecute(Object obj)
    {
        if (dt && !ds)
        {
            du.g(Q, dq);
            return;
        }
        try
        {
            if (dt && ds)
            {
                du.a(Q, dq, ag);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Throwable) (obj)).printStackTrace();
        }
        return;
    }
}
