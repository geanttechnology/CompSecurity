// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            w, v, s, af, 
//            p, ac, r, ab, 
//            ae, y, am, n, 
//            z

public final class ad
    implements w
{

    public ad()
    {
    }

    public final y a(p p1, Hashtable hashtable)
        throws v, s
    {
        ac ac1 = (new af(p1.c())).a();
        p1 = ac1.e();
        if (hashtable != null && ac1.e() != null)
        {
            hashtable = (ab)hashtable.get(r.h);
            if (hashtable != null)
            {
                for (int i = 0; i < ac1.e().length; i++)
                {
                    hashtable.a(ac1.e()[i]);
                }

            }
        }
        hashtable = (new ae()).a(ac1);
        p1 = new y(hashtable.b(), hashtable.a(), p1, n.a);
        if (hashtable.c() != null)
        {
            p1.a(z.c, hashtable.c());
        }
        if (hashtable.d() != null)
        {
            p1.a(z.d, hashtable.d().toString());
        }
        return p1;
    }

    public final void a()
    {
    }
}
