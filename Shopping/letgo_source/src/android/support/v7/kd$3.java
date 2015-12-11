// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.webkit.WebView;

// Referenced classes of package android.support.v7:
//            kd

class init> extends WebView
{

    final kd a;

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

    eption(kd kd1, Context context)
    {
        a = kd1;
        super(context);
    }
}
