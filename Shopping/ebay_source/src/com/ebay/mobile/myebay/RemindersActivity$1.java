// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.widget.Toast;

// Referenced classes of package com.ebay.mobile.myebay:
//            RemindersActivity

class this._cls0
    implements Runnable
{

    final RemindersActivity this$0;

    public void run()
    {
        String s = getString(0x7f07024c);
        Toast.makeText(RemindersActivity.this, s, 1).show();
    }

    ()
    {
        this$0 = RemindersActivity.this;
        super();
    }
}
