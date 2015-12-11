// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;


// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class q
    implements ag
{

    q()
    {
    }

    public final Object a(String s)
    {
        return Double.valueOf(s);
    }

    public final String a(Object obj)
    {
        return ((Double)obj).toString();
    }
}
