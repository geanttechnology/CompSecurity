// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.view.View;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationUploadView

class val.visibility
    implements Runnable
{

    final AndroidNavigationUploadView this$0;
    final View val$view;
    final int val$visibility;

    public void run()
    {
        val$view.setVisibility(val$visibility);
    }

    ()
    {
        this$0 = final_androidnavigationuploadview;
        val$view = view1;
        val$visibility = I.this;
        super();
    }
}
