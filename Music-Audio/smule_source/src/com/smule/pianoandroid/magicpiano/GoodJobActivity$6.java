// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.pianoandroid.f.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity, r, ae

class c
    implements Runnable
{

    final String a;
    final String b;
    final String c;
    final GoodJobActivity d;

    public void run()
    {
        d.a = new r(d, a, b);
        if (a.equals("perform_android"))
        {
            com.smule.pianoandroid.magicpiano.ae.a(c).a(d.getFragmentManager(), GoodJobActivity.d(), d.a);
        } else
        if (a.equals("play_android") && com.smule.pianoandroid.f.a.a(d).a())
        {
            d.a.execute(new String[] {
                d.getString(0x7f0c01e1)
            });
            return;
        }
    }

    _cls9(GoodJobActivity goodjobactivity, String s, String s1, String s2)
    {
        d = goodjobactivity;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
