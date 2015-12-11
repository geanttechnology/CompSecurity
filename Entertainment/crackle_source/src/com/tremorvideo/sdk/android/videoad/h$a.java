// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import com.tremorvideo.sdk.android.richmedia.a.h;
import java.util.ArrayList;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            h

private class a
    implements Runnable
{

    ArrayList a;
    final com.tremorvideo.sdk.android.videoad.h b;
    private int c;
    private android.widget.tiveLayout.LayoutParams d;
    private h e;

    public void run()
    {
        if (c != 1) goto _L2; else goto _L1
_L1:
        if (d != null && e != null)
        {
            b.b(d, e);
        }
_L4:
        return;
_L2:
        if (c != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (a == null) goto _L4; else goto _L3
_L3:
        b.b(a);
        return;
        if (c != 3 || e == null) goto _L4; else goto _L5
_L5:
        b.b(e);
        return;
    }

    public h(com.tremorvideo.sdk.android.videoad.h h1, int i, android.widget.tiveLayout.LayoutParams layoutparams, h h2, ArrayList arraylist)
    {
        b = h1;
        super();
        c = i;
        d = layoutparams;
        e = h2;
        a = arraylist;
    }
}
