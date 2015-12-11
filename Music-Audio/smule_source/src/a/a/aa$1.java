// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.Map;

// Referenced classes of package a.a:
//            ed, aa, em, dm, 
//            el, ee, dx, dw, 
//            ae, dy

final class nit> extends ed
{

    final aa a;
    final aa b;

    public final void a()
    {
        if (a.f.b())
        {
            return;
        } else
        {
            dm dm1 = new dm(a);
            org.json.JSONObject jsonobject = a.x.a();
            dm1.a.put("metadata", jsonobject);
            (new ee(dm1, new dx((new dw(b.u.k(), "/android_v2/update_user_metadata")).a()), new dy(a.x))).run();
            return;
        }
    }

    .Map(aa aa1, aa aa2)
    {
        b = aa1;
        a = aa2;
        super();
    }
}
