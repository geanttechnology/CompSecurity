// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.c;

// Referenced classes of package android.support.v7:
//            ct, dn, aqo, cu, 
//            ig

class b
    implements ct
{

    final int a;
    final int b;
    final dn c;

    public cu a(cu cu1)
        throws Exception
    {
        aqo.a("Bitmap retrieved, will rotate", new Object[0]);
        android.graphics.Bitmap bitmap = ((c)cu1.e()).a;
        int i = ig.b(((c)cu1.e()).b);
        return dn.a(c, bitmap, a, b, i);
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }

    a.c(dn dn1, int i, int j)
    {
        c = dn1;
        a = i;
        b = j;
        super();
    }
}
