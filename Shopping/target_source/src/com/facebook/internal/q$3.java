// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.Context;
import android.webkit.WebView;

// Referenced classes of package com.facebook.internal:
//            q

class it> extends WebView
{

    final q a;

    public void onWindowFocusChanged(boolean flag)
    {
        try
        {
            super.onWindowFocusChanged(flag);
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            return;
        }
    }

    tion(q q1, Context context)
    {
        a = q1;
        super(context);
    }
}
