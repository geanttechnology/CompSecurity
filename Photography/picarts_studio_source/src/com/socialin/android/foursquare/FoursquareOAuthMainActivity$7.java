// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.foursquare;

import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.foursquare:
//            FoursquareOAuthMainActivity

final class a
    implements Runnable
{

    private FoursquareOAuthMainActivity a;

    public final void run()
    {
        ((TextView)a.findViewById(0x7f10053c)).setText(FoursquareOAuthMainActivity.e(a));
        ((ImageView)a.findViewById(0x7f10053d)).setImageResource(0x7f02048f);
    }

    (FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        a = foursquareoauthmainactivity;
        super();
    }
}
