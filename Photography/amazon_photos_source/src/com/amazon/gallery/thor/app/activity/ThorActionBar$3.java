// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ThorActionBar, GalleryToolbar, GalleryNavigationSetting

class this._cls0
    implements android.view.ener
{

    final ThorActionBar this$0;

    private void defaultOnNavigationClickListener()
    {
        if (toolbar.getNavigationSetting() == GalleryNavigationSetting.BACK)
        {
            ThorActionBar.access$100(ThorActionBar.this).onBackPressed();
        } else
        if (ThorActionBar.access$200(ThorActionBar.this) != null)
        {
            ThorActionBar.access$200(ThorActionBar.this).open();
            return;
        }
    }

    public void onClick(View view)
    {
        defaultOnNavigationClickListener();
    }

    ity()
    {
        this$0 = ThorActionBar.this;
        super();
    }
}
