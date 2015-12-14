// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.foursquare;

import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.foursquare:
//            FoursquareOAuthMainActivity

final class a
    implements d
{

    private FoursquareOAuthMainActivity a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        FoursquareOAuthMainActivity.c(a, "Wrong access token.");
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (String)obj;
        FoursquareOAuthMainActivity.b(a, ((String) (obj)));
    }

    (FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        a = foursquareoauthmainactivity;
        super();
    }
}
