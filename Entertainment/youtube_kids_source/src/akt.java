// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.atomic.AtomicBoolean;

final class akt
{

    final ako a;
    AtomicBoolean b;
    int c;

    akt(ako ako, Integer integer)
    {
        b = new AtomicBoolean(false);
        a = ako;
        int i;
        if (integer == null)
        {
            i = 30;
        } else
        {
            i = integer.intValue();
        }
        c = i;
    }
}
