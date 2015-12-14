// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.Toolbar;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            GallerySimpleToolbar, GalleryNavigationSetting

public class AndroidSimpleToolbar
    implements GallerySimpleToolbar
{

    private final Toolbar toolbar;

    public AndroidSimpleToolbar(Toolbar toolbar1)
    {
        toolbar = toolbar1;
        toolbar.setBackgroundColor(toolbar1.getContext().getResources().getColor(0x7f0900ab));
    }

    public void setNavigationOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        toolbar.setNavigationOnClickListener(onclicklistener);
    }

    public void setNavigationSetting(GalleryNavigationSetting gallerynavigationsetting)
    {
        if (GalleryNavigationSetting.BACK == gallerynavigationsetting)
        {
            toolbar.setNavigationIcon(0x7f020013);
        }
        toolbar.setNavigationContentDescription(0x7f0e0003);
    }

    public void setTitle(CharSequence charsequence)
    {
        toolbar.setTitle(charsequence);
    }
}
