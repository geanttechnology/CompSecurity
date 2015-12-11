// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.digidust.elokence.akinator.factories.AkConfigFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements android.view.ener
{

    final HomeActivity this$0;

    public void onClick(View view)
    {
        HomeActivity.access$200(HomeActivity.this).setVisibility(8);
        HomeActivity.access$300(HomeActivity.this).setVisibility(0);
        AkConfigFactory.sharedInstance().setHomeBannerOpened(false);
    }

    ()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
