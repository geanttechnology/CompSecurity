// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.network.managers.ap;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            b

class a
    implements android.view..OnClickListener
{

    final b a;

    public void onClick(View view)
    {
        if (!ap.a().b())
        {
            a.a(null);
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
