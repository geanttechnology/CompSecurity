// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Context;
import android.webkit.WebView;

// Referenced classes of package com.facebook.b:
//            v

final class text extends WebView
{

    final v a;

    public final void onWindowFocusChanged(boolean flag)
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

    text(v v1, Context context)
    {
        a = v1;
        super(context);
    }
}
