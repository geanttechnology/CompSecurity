// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.foursquare;

import android.content.Intent;
import android.view.View;
import com.socialin.android.d;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.foursquare:
//            FoursquareOAuthMainActivity

final class a
    implements android.view.AuthMainActivity._cls2
{

    private FoursquareOAuthMainActivity a;

    public final void onClick(View view)
    {
        if (!Utils.a(a))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        view = new Intent();
        view.setClassName(a.getPackageName(), Class.forName("com.picsart.studio.activity.MapActivity").getName());
        view.putExtra("onlyFoursquare", true);
        a.startActivityForResult(view, 1);
        return;
        view;
        d.a(FoursquareOAuthMainActivity.a(), view);
        return;
    }

    (FoursquareOAuthMainActivity foursquareoauthmainactivity)
    {
        a = foursquareoauthmainactivity;
        super();
    }
}
