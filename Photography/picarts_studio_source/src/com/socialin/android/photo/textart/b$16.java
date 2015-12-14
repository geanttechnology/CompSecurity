// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.view.View;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextPreview, TextArtStyle

final class a
    implements android.view.OnClickListener
{

    private b a;

    public final void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131757748 2131757750: default 32
    //                   2131757748 77
    //                   2131757749 100
    //                   2131757750 54;
           goto _L1 _L2 _L3 _L4
_L1:
        b.b(a).setEnabled(true);
        b.a(a).invalidate();
        return;
_L4:
        b.a().setAlignment(21);
        b.a(a).setGravity(21);
        continue; /* Loop/switch isn't completed */
_L2:
        b.a().setAlignment(19);
        b.a(a).setGravity(19);
        continue; /* Loop/switch isn't completed */
_L3:
        b.a().setAlignment(17);
        b.a(a).setGravity(17);
        if (true) goto _L1; else goto _L5
_L5:
    }

    rtStyle(b b1)
    {
        a = b1;
        super();
    }
}
