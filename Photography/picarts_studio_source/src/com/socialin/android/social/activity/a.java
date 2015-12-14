// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.social.activity;

import android.content.res.Resources;
import myobfuscated.cq.b;

// Referenced classes of package com.socialin.android.social.activity:
//            SocialMainActivity

final class a
{

    Class a;
    int b;
    int c;
    String d;
    private int e;
    private SocialMainActivity f;

    public a(SocialMainActivity socialmainactivity, int i)
    {
        f = socialmainactivity;
        super();
        b = 0;
        e = i;
        if (e == 0)
        {
            a = myobfuscated/bv/a;
            c = 0x7f02021a;
            d = f.getResources().getString(0x7f0802cd);
            b = 10;
        } else
        {
            if (e == 1)
            {
                a = myobfuscated/cq/b;
                c = 0x7f0205b9;
                d = f.getResources().getString(0x7f080321);
                return;
            }
            if (e == 2)
            {
                a = myobfuscated/cq/a;
                c = 0x7f02023f;
                d = f.getResources().getString(0x7f0802d9);
                return;
            }
        }
    }
}
