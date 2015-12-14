// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.widget.TextView;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            AndroidNavigationUploadView

class val.text
    implements Runnable
{

    final AndroidNavigationUploadView this$0;
    final String val$text;
    final TextView val$view;

    public void run()
    {
        val$view.setText(val$text);
    }

    ()
    {
        this$0 = final_androidnavigationuploadview;
        val$view = textview;
        val$text = String.this;
        super();
    }
}
