// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.text.TextUtils;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package myobfuscated.cy:
//            d

final class it>
    implements g
{

    private g a;
    private String b;

    public final void a(String s, m m)
    {
        if (a != null)
        {
            if (TextUtils.isEmpty(s))
            {
                s = b;
            }
            a.a(s, m);
        }
    }

    (g g1, String s)
    {
        a = g1;
        b = s;
        super();
    }
}
