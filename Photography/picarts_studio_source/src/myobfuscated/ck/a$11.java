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
    private boolean c;
    private JSONArray d;
    private a e;

    public final void a(Object obj, boolean flag, n n, long l1)
    {
        obj = e.getActivity();
        if (obj == null || ((Activity) (obj)).isFinishing())
        {
            return;
        }
        obj = e;
        Observer observer = a;
        String s = b;
        JSONArray jsonarray;
        c c1;
        boolean flag1;
        if (!c)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        jsonarray = d;
        c1 = myobfuscated.ck.a.a(e);
        e.getActivity().getApplicationContext();
        myobfuscated.ck.a.a(((a) (obj)), flag, observer, n, s, l1, flag1, jsonarray, c1.j());
    }

    (a a1, Observer observer, String s, boolean flag, JSONArray jsonarray)
    {
        e = a1;
        a = observer;
        b = s;
        c = flag;
        d = jsonarray;
        super();
    }
}
