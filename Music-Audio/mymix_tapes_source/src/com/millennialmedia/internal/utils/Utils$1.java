// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.content.Context;
import android.widget.Toast;

// Referenced classes of package com.millennialmedia.internal.utils:
//            Utils

static final class val.message
    implements Runnable
{

    final Context val$context;
    final String val$message;

    public void run()
    {
        Toast.makeText(val$context, val$message, 0).show();
    }

    (Context context1, String s)
    {
        val$context = context1;
        val$message = s;
        super();
    }
}
