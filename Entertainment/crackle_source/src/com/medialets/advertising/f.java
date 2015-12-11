// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.view.View;

// Referenced classes of package com.medialets.advertising:
//            i, s

final class f
    implements android.view.View.OnClickListener
{

    private i a;

    f(i j)
    {
        a = j;
        super();
    }

    public final void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   296: 49
    //                   297: 89
    //                   304: 78
    //                   305: 67;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (!i.a(a))
        {
            a.dismiss();
            return;
        }
          goto _L1
_L5:
        i.b(a).goForward();
        return;
_L4:
        i.b(a).goBack();
        return;
_L3:
        i.b(a).reload();
        return;
    }
}
