// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.widget.TextView;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            MobileScreen

class this._cls0
    implements Runnable
{

    final MobileScreen this$0;

    public void run()
    {
        if (isResumed())
        {
            MobileScreen.access$200(MobileScreen.this).setText("");
        }
    }

    ()
    {
        this$0 = MobileScreen.this;
        super();
    }
}
