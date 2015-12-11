// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.digidust.elokence.akinator.factories.AkGameFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements android.view.ener
{

    final HomeActivity this$0;

    public void onClick(View view)
    {
        try
        {
            view = new Intent("android.intent.action.VIEW", Uri.parse(AkGameFactory.sharedInstance().getHomeBannerUrl()));
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
