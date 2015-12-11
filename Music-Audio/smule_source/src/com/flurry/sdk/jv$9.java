// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class er extends ir
{

    public StringBuffer a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        } else
        {
            return new StringBuffer(jx1.h());
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (StringBuffer)obj);
    }

    public void a(jz jz1, StringBuffer stringbuffer)
    {
        if (stringbuffer == null)
        {
            stringbuffer = null;
        } else
        {
            stringbuffer = stringbuffer.toString();
        }
        jz1.b(stringbuffer);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    er()
    {
    }
}
