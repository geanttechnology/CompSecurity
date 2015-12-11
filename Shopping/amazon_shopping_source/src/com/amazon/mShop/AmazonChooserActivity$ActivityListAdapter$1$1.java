// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.util.Map;

// Referenced classes of package com.amazon.mShop:
//            AmazonChooserActivity

class val.defaultIcon
    implements Runnable
{

    final is._cls1 this$2;
    final Drawable val$defaultIcon;

    public void run()
    {
        appIcon.setImageDrawable(val$defaultIcon);
        if (ss._mth300(_fld1))
        {
            fyDataSetChanged();
            ss._mth302(_fld1, false);
        }
    }

    l.appIcon()
    {
        this$2 = final_appicon;
        val$defaultIcon = Drawable.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/AmazonChooserActivity$ActivityListAdapter$1

/* anonymous class */
    class AmazonChooserActivity.ActivityListAdapter._cls1
        implements Runnable
    {

        final AmazonChooserActivity.ActivityListAdapter this$1;
        final ImageView val$appIcon;
        final String val$packageName;
        final ResolveInfo val$resolveInfo;

        public void run()
        {
            Drawable drawable = resolveInfo.loadIcon(AmazonChooserActivity.ActivityListAdapter.access$200(AmazonChooserActivity.ActivityListAdapter.this));
            if (drawable != null)
            {
                mPackageIconMap.put(packageName, drawable);
                runOnUiThread(drawable. new AmazonChooserActivity.ActivityListAdapter._cls1._cls1());
            }
        }

            
            {
                this$1 = final_activitylistadapter;
                resolveInfo = resolveinfo;
                packageName = s;
                appIcon = ImageView.this;
                super();
            }
    }

}
