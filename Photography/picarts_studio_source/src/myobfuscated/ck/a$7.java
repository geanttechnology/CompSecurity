// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.graphics.Point;
import myobfuscated.cj.b;
import myobfuscated.cj.c;
import myobfuscated.cm.e;
import org.json.JSONArray;

// Referenced classes of package myobfuscated.ck:
//            a, c

final class it>
    implements e
{

    private JSONArray a;
    private a b;

    public final void a(c c1, boolean flag, long l, boolean flag1)
    {
        if (flag)
        {
            Object obj = myobfuscated.ck.a.a(b).g;
            myobfuscated.ck.a.w(b).a(c1, ((String) (obj)));
            Object obj1 = b.getActivity();
            if (obj1 != null)
            {
                c1 = myobfuscated.ck.a.a(b).k.a(((String) (obj)));
                obj = ((Activity) (obj1)).getApplicationContext();
                int i = myobfuscated.ck.a.c(b).x;
                int j = myobfuscated.ck.a.c(b).y;
                boolean flag2 = myobfuscated.ck.a.M(b);
                myobfuscated.ck.c c2;
                if (!flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                obj1 = a;
                c2 = myobfuscated.ck.a.a(b);
                b.getActivity().getApplicationContext();
                myobfuscated.ay.e.a(((android.content.Context) (obj)), c1, i, j, flag2, true, l, flag1, ((JSONArray) (obj1)), c2.j());
            }
        }
        myobfuscated.ck.a.a(b).e = false;
        myobfuscated.ck.a.a(b).f = false;
        b.c(flag);
    }

    nt(a a1, JSONArray jsonarray)
    {
        b = a1;
        a = jsonarray;
        super();
    }
}
