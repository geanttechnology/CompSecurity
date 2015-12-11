// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            is, iu, ir, jw, 
//            ja, jf, ia

public final class jm
    implements is
{

    private final ja a;

    public jm(ja ja1)
    {
        a = ja1;
    }

    static ir a(ja ja1, ia ia, jw jw1, iu iu1)
    {
        iu1 = iu1.a();
        if (com/flurry/sdk/ir.isAssignableFrom(iu1))
        {
            return (ir)ja1.a(jw.b(iu1)).a();
        }
        if (com/flurry/sdk/is.isAssignableFrom(iu1))
        {
            return ((is)ja1.a(jw.b(iu1)).a()).a(ia, jw1);
        } else
        {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
        }
    }

    public ir a(ia ia, jw jw1)
    {
        iu iu1 = (iu)jw1.a().getAnnotation(com/flurry/sdk/iu);
        if (iu1 == null)
        {
            return null;
        } else
        {
            return a(a, ia, jw1, iu1);
        }
    }
}
