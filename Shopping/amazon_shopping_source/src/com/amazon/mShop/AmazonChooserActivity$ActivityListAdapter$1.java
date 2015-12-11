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

class val.appIcon
    implements Runnable
{

    final this._cls1 this$1;
    final ImageView val$appIcon;
    final String val$packageName;
    final ResolveInfo val$resolveInfo;

    public void run()
    {
        final Drawable defaultIcon = val$resolveInfo.loadIcon(cess._mth200(this._cls1.this));
        if (defaultIcon != null)
        {
            ackageIconMap.put(val$packageName, defaultIcon);
            runOnUiThread(new Runnable() {

                final AmazonChooserActivity.ActivityListAdapter._cls1 this$2;
                final Drawable val$defaultIcon;

                public void run()
                {
                    appIcon.setImageDrawable(defaultIcon);
                    if (AmazonChooserActivity.ActivityListAdapter.access$300(this$1))
                    {
                        notifyDataSetChanged();
                        AmazonChooserActivity.ActivityListAdapter.access$302(this$1, false);
                    }
                }

            
            {
                this$2 = AmazonChooserActivity.ActivityListAdapter._cls1.this;
                defaultIcon = drawable;
                super();
            }
            });
        }
    }

    _cls1.val.defaultIcon()
    {
        this$1 = final_defaulticon;
        val$resolveInfo = resolveinfo;
        val$packageName = s;
        val$appIcon = ImageView.this;
        super();
    }
}
