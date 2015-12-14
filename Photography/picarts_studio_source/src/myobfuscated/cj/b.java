// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cj;

import android.content.Context;
import android.os.Environment;
import java.util.ArrayList;
import myobfuscated.ay.e;

// Referenced classes of package myobfuscated.cj:
//            c

public final class b
{

    public String a;
    public String b;
    public c c;
    public c d;
    public Context e;
    public int f;
    private String g;

    public b(Context context)
    {
        b = null;
        c = null;
        d = null;
        e = context;
        g = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context.getString(0x7f0808fb)).append("/").toString();
        a = (new StringBuilder()).append(g).append(context.getString(0x7f08096c)).append("/").toString();
        (new StringBuilder()).append(g).append(context.getString(0x7f080959)).append("/");
        (new StringBuilder()).append(g).append(context.getString(0x7f080958)).append("/");
    }

    public final String a(String s)
    {
        return myobfuscated.ay.e.a(b, s);
    }

    public final c a()
    {
        if (d != null)
        {
            return d;
        } else
        {
            return c;
        }
    }

    public final void a(c c1, String s)
    {
        if (c1 != null)
        {
            ArrayList arraylist;
            if (d != null)
            {
                arraylist = d.a();
            } else
            {
                arraylist = new ArrayList();
            }
            arraylist.add(s);
            d = c1;
            d.d = arraylist;
            return;
        } else
        {
            d = null;
            return;
        }
    }
}
