// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ad

class a
    implements android.view.OnClickListener
{

    final ad a;

    public void onClick(View view)
    {
        o.d(a, new Runnable() {

            final ad._cls6 a;

            public void run()
            {
                a.a.setResult(7);
                a.a.finish();
            }

            
            {
                a = ad._cls6.this;
                super();
            }
        });
    }

    _cls1.a(ad ad1)
    {
        a = ad1;
        super();
    }
}
