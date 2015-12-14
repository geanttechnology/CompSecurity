// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cx;

import android.app.Activity;
import android.content.SharedPreferences;
import com.socialin.android.facebook.p;
import com.socialin.android.facebook.util.FacebookUtils;

// Referenced classes of package myobfuscated.cx:
//            a, b

final class it>
    implements p
{

    private a a;

    public final void a()
    {
        boolean flag = false;
        myobfuscated.cx.a.a(a);
        b b1 = a.a(0);
        b1.e = myobfuscated.cx.a.b(a);
        if (myobfuscated.cx.a.c(a) || FacebookUtils.canIPost())
        {
            flag = true;
        }
        b1.f = flag;
        myobfuscated.cx.a.d(a).edit().putBoolean(b1.a, true).apply();
        if (a.getActivity() != null && !a.getActivity().isFinishing())
        {
            myobfuscated.cx.a.e(a);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
