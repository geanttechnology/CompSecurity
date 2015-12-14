// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            FacebookScreen

class this._cls0
    implements Runnable
{

    final FacebookScreen this$0;

    public void run()
    {
        if (!FacebookScreen.access$1300(FacebookScreen.this).isShowing())
        {
            FacebookScreen.access$1400(FacebookScreen.this).show();
        }
    }

    ssDialog()
    {
        this$0 = FacebookScreen.this;
        super();
    }
}
