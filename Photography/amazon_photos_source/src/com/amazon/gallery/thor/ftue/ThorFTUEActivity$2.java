// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.view.View;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            ThorFTUEActivity

class e
    implements android.view.r
{

    final ThorFTUEActivity this$0;
    final PhotosNavigationPane val$navPane;

    public void onClick(View view)
    {
        val$navPane.open();
    }

    e()
    {
        this$0 = final_thorftueactivity;
        val$navPane = PhotosNavigationPane.this;
        super();
    }
}
