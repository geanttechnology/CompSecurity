// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bt;

import android.app.Activity;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.bt:
//            c

final class d extends com.socialin.android.net.d
{

    private String a;
    private String b;
    private Activity c;
    private c d;

    public d(c c1, Activity activity, String s, String s1)
    {
        d = c1;
        super();
        c = activity;
        a = s1;
        b = s;
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Integer)obj;
        super.onPostExecute(obj);
        (new StringBuilder("File downloaded result")).append(obj).append(";, path: ").append(a);
        if (c != null && !c.isFinishing())
        {
            m.b(c, myobfuscated.bt.c.c(d));
            myobfuscated.bt.c.a(d, ((Integer) (obj)), a, b);
        }
    }

    protected final void onPreExecute()
    {
        super.onPreExecute();
        if (c != null)
        {
            m.a(c, myobfuscated.bt.c.c(d));
        }
    }
}
