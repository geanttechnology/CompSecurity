// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            c

class a
    implements android.view..OnClickListener
{

    final c a;

    public void onClick(View view)
    {
        a.dismiss();
        if (a.c != null)
        {
            a.c.run();
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
