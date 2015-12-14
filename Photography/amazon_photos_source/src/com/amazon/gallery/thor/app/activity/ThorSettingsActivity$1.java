// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.view.View;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.kindle.activity.AdLaunchHelper;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorSettingsActivity

class val.navPane
    implements android.view..ThorSettingsActivity._cls1
{

    final ThorSettingsActivity this$0;
    final PhotosNavigationPane val$navPane;

    public void onClick(View view)
    {
        if (BuildFlavors.isFireOS4OrLater() && getIntent().hasExtra("com.amazon.photos.FROM_PHOTOS"))
        {
            val$navPane.open();
        } else
        {
            finish();
            if (AdLaunchHelper.isAdLaunch(getIntent()))
            {
                startActivity(new Intent("com.amazon.photos.LAUNCH_PHOTOS"));
                return;
            }
        }
    }

    A()
    {
        this$0 = final_thorsettingsactivity;
        val$navPane = PhotosNavigationPane.this;
        super();
    }
}
