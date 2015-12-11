// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.Toast;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class val.Message
    implements Runnable
{

    final FacebookHelperActivity this$0;
    final String val$Message;

    public void run()
    {
        Toast.makeText(getThis().getApplicationContext(), val$Message, 1).show();
    }

    ()
    {
        this$0 = final_facebookhelperactivity;
        val$Message = String.this;
        super();
    }
}
