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

final class t>
    implements l
{

    private Observer a;
    private String b;
    private JSONArray c;
    private a d;

    public final void a(Object obj, boolean flag, n n, long l1)
    {
        obj = d.getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        } else
        {
            obj = d;
            Observer observer = a;
            String s = b;
            JSONArray jsonarray = c;
            c c1 = myobfuscated.ck.a.a(d);
            d.getActivity().getApplicationContext();
            myobfuscated.ck.a.a(((a) (obj)), flag, observer, n, s, l1, true, jsonarray, c1.j());
            return;
        }
    }

    (a a1, Observer observer, String s, JSONArray jsonarray)
    {
        d = a1;
        a = observer;
        b = s;
        c = jsonarray;
        super();
    }
}
