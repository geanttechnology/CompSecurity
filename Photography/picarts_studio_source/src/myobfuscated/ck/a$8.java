// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import java.util.Observer;
import myobfuscated.cm.l;
import myobfuscated.cm.n;
import org.json.JSONArray;

// Referenced classes of package myobfuscated.ck:
//            a, c

final class it>
    implements l
{

    private Observer a;
    private String b;
    private a c;

    public final void a(Object obj, boolean flag, n n, long l1)
    {
        obj = c.getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        } else
        {
            obj = c;
            Observer observer = a;
            String s = b;
            JSONArray jsonarray = new JSONArray();
            c c1 = myobfuscated.ck.a.a(c);
            c.getActivity().getApplicationContext();
            myobfuscated.ck.a.a(((a) (obj)), flag, observer, n, s, l1, true, jsonarray, c1.j());
            return;
        }
    }

    (a a1, Observer observer, String s)
    {
        c = a1;
        a = observer;
        b = s;
        super();
    }
}
