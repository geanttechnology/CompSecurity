// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            io, jz

final class der extends ir
{

    public Character a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        }
        jx1 = jx1.h();
        if (jx1.length() != 1)
        {
            throw new io((new StringBuilder()).append("Expecting character, got: ").append(jx1).toString());
        } else
        {
            return Character.valueOf(jx1.charAt(0));
        }
    }

    public void a(jz jz1, Character character)
    {
        if (character == null)
        {
            character = null;
        } else
        {
            character = String.valueOf(character);
        }
        jz1.b(character);
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (Character)obj);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    der()
    {
    }
}
