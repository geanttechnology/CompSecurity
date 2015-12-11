// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.f;


// Referenced classes of package com.target.ui.fragment.cardstream.f:
//            b

public static abstract class param
{

    public final int mutationType;
    public final Object param;

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (param)obj;
        if (mutationType != ((mutationType) (obj)).mutationType)
        {
            return false;
        }
        if (param == null) goto _L4; else goto _L3
_L3:
        if (param.equals(((param) (obj)).param)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((param) (obj)).param == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j = mutationType;
        int i;
        if (param != null)
        {
            i = param.hashCode();
        } else
        {
            i = 0;
        }
        return i + j * 31;
    }

    public (int i, Object obj)
    {
        mutationType = i;
        param = obj;
    }
}
