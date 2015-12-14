// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.kindle.activity.OnSortingChangedListener;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorActionBar, GalleryToolbar, GalleryNavigationSetting

public class ChooserActionBar extends ThorActionBar
{

    private BeanAwareActivity activity;
    private CharSequence title;

    public ChooserActionBar(BeanAwareActivity beanawareactivity, Toolbar toolbar)
    {
        super(null, beanawareactivity, false, toolbar);
        activity = beanawareactivity;
        title = beanawareactivity.getString(0x7f0e0059);
    }

    public void setTitle(CharSequence charsequence)
    {
        title = charsequence;
        toolbar.setTitle(charsequence);
    }

    public void setup(int i, int j, int k, OnSortingChangedListener onsortingchangedlistener)
    {
        toolbar.setTitle(activity.getString(0x7f0e0059));
        toolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final ChooserActionBar this$0;

            public void onClick(View view)
            {
                activity.onBackPressed();
            }

            
            {
                this$0 = ChooserActionBar.this;
                super();
            }
        });
    }

    protected void updateTitle(String s)
    {
    }

}
