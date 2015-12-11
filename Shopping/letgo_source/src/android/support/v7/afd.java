// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Set;

// Referenced classes of package android.support.v7:
//            afa, afy, afc

public final class afd extends afa
{

    private final afy a = new afy();

    public afd()
    {
    }

    public void a(String s, afa afa1)
    {
        Object obj = afa1;
        if (afa1 == null)
        {
            obj = afc.a;
        }
        a.put(s, obj);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof afd) && ((afd)obj).a.equals(a);
    }

    public int hashCode()
    {
        return a.hashCode();
    }

    public Set o()
    {
        return a.entrySet();
    }
}
