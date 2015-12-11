// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import com.smule.pianoandroid.utils.i;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class a
    implements Runnable
{

    final ap a;

    public void run()
    {
        if (com.smule.pianoandroid.magicpiano.ap.i(a) != null)
        {
            Intent intent = new Intent();
            intent.putExtra(i.a, com.smule.pianoandroid.magicpiano.ap.i(a));
            a.setResult(216, intent);
        }
        a.finish();
    }

    (ap ap1)
    {
        a = ap1;
        super();
    }
}
