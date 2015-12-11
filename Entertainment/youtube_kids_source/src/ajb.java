// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class ajb
{

    final amd a;
    final boolean b;
    boolean c;
    private final aly d;

    public ajb(amd amd1, aly aly1, boolean flag)
    {
        c = false;
        d = aly1;
        a = amd1;
        b = flag;
    }

    public final void a()
    {
        boolean flag = c;
        (new StringBuilder(40)).append("unselect route, is user initiated: ").append(flag).toString();
        flag = b;
        a.a(c);
        c = false;
    }

    public final void a(ame ame1)
    {
        Object obj = String.valueOf(ame1.a());
        boolean flag;
        if (((String) (obj)).length() != 0)
        {
            "select route ".concat(((String) (obj)));
        } else
        {
            new String("select route ");
        }
        flag = b;
        obj = d;
        ame1 = new ajc(this, ame1);
        b.a(ame1);
        if (((aly) (obj)).d != null)
        {
            ((aly) (obj)).d.a = true;
            obj.d = null;
        }
        if (((aly) (obj)).c != null)
        {
            Object obj1 = ((aly) (obj)).c.a();
            String s = ((rx) (obj1)).d();
            if (!TextUtils.isEmpty(s))
            {
                int j = ((aly) (obj)).c.b();
                int i = j;
                if (Math.abs(j - ((rx) (obj1)).f.o()) < 1500)
                {
                    i = 0;
                }
                obj1 = (new alx()).a(s).b(((rx) (obj1)).c()).a(((rx) (obj1)).e());
                obj1.b = i;
                obj1.c = ((aly) (obj)).c.c();
                obj.d = bhx.a(new alz(((aly) (obj)), ((alx) (obj1)).a(), ame1));
                ((aly) (obj)).a.a(s, ctx.a, "", "", -1, -1, ((aly) (obj)).d);
                return;
            }
        }
        ((aly) (obj)).b.b("No available player source, will connect to TV without videoId");
        ame1.a(null, alw.f);
    }
}
