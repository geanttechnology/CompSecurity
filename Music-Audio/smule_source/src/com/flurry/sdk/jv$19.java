// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            is, jv, jw, ia, 
//            ir

final class 
    implements is
{

    public ir a(ia ia, jw jw1)
    {
        jw1 = jw1.a();
        if (!java/lang/Enum.isAssignableFrom(jw1) || jw1 == java/lang/Enum)
        {
            return null;
        }
        ia = jw1;
        if (!jw1.isEnum())
        {
            ia = jw1.getSuperclass();
        }
        return new init>(ia);
    }

    ()
    {
    }
}
