// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Map;

final class akl
    implements cfx
{

    private cgw a;
    private ako b;
    private akj c;

    akl(akj akj1, cgw cgw1, ako ako)
    {
        c = akj1;
        a = cgw1;
        b = ako;
        super();
    }

    public final void a(int i)
    {
        Object obj = akj.a(c, i);
        akj.a(c).a("Could not find cloud screen corresponding to DIAL device %s, %s", new Object[] {
            a, obj
        });
        ame ame1 = c.f;
        if (ame1 == null || !ame1.h() || !((als)ame1).a.equals(a))
        {
            akj.a(c);
            obj = String.valueOf(a);
            (new StringBuilder(String.valueOf(obj).length() + 86)).append("Connection to DIAL device ").append(((String) (obj))).append(" was canceled in the meantime. Will not move to error state.");
            return;
        } else
        {
            akj.a(c, false);
            akj.g(c).a(((alu) (obj)));
            return;
        }
    }

    public final void a(Uri uri)
    {
        akj.a(c);
        String s = String.valueOf(a);
        (new StringBuilder(String.valueOf(s).length() + 48)).append("Successfully launched YouTube TV on DIAL device ").append(s);
        if (uri != null)
        {
            akj.i(c).put(a.g, uri);
        }
    }

    public final void a(cgc cgc1)
    {
        akj.a(c).a("Found corresponding cloud screen %s for DIAL device %s", new Object[] {
            cgc1, a
        });
        akj.a(c, a, cgc1);
        ame ame1 = c.f;
        if (ame1 == null || !ame1.h() || !((als)ame1).a.equals(a))
        {
            akj.a(c);
            cgc1 = String.valueOf(a);
            (new StringBuilder(String.valueOf(cgc1).length() + 70)).append("Connection to DIAL device ").append(cgc1).append(" was canceled. Will not connect to the cloud");
        } else
        {
            akj.a(c, false);
            amj amj1 = c.i();
            if (!cgc1.equals(akj.c(c)) || amj1 != amj.b && amj1 != amj.a)
            {
                akj.a(c, cgc1, b);
                return;
            }
        }
    }
}
