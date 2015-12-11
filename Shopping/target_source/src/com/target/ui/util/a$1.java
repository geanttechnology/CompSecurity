// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.view.View;

// Referenced classes of package com.target.ui.util:
//            a

static final class 
    implements Runnable
{

    final Context val$context;
    final CharSequence val$message;
    final View val$view;

    public void run()
    {
        a.b(val$context, val$view, val$message);
    }

    (Context context1, View view1, CharSequence charsequence)
    {
        val$context = context1;
        val$view = view1;
        val$message = charsequence;
        super();
    }
}
