// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.amazon.mShop.util:
//            UIUtils

static final class val.message
    implements Runnable
{

    final Context val$context;
    final String val$message;

    public void run()
    {
        Toast toast = Toast.makeText(val$context, val$message, 0);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    (Context context1, String s)
    {
        val$context = context1;
        val$message = s;
        super();
    }
}
