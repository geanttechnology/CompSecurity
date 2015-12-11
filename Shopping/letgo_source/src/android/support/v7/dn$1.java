// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.abtnprojects.ambatana.b;

// Referenced classes of package android.support.v7:
//            ct, dn, aqo, cu

class a
    implements ct
{

    final dn a;

    public cu a(cu cu1)
        throws Exception
    {
        aqo.a("Bitmap rotated, will generate thumbnail", new Object[0]);
        android.graphics.Bitmap bitmap = ((b)cu1.e()).a;
        int i = ((b)cu1.e()).b;
        return dn.a(a, bitmap, i);
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }

    a.b(dn dn1)
    {
        a = dn1;
        super();
    }
}
