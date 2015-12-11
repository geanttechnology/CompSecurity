// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class atn
    implements Comparator
{

    atn()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (ato)obj;
        obj1 = (ato)obj1;
        if (((ato) (obj)).c < ((ato) (obj1)).c)
        {
            return -1;
        }
        return ((ato) (obj1)).c >= ((ato) (obj)).c ? 0 : 1;
    }
}
