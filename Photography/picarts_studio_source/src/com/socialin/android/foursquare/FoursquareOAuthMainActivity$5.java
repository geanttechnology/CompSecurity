// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.foursquare;

import com.socialin.android.util.an;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.foursquare:
//            FoursquareOAuthMainActivity

final class a extends an
{

    private FoursquareOAuthMainActivity a;

    protected final Object doInBackground(Object aobj[])
    {
        FoursquareOAuthMainActivity.c(a);
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Void)obj;
        m.b(a, FoursquareOAuthMainActivity.d(a));
        super.onPostExecute(obj);
    }

    (FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        a = foursquareoauthmainactivity;
        super();
    }
}
