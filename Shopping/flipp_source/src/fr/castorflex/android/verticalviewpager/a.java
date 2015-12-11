// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import java.util.Comparator;

// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            e

final class a
    implements Comparator
{

    a()
    {
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (e)obj;
        obj1 = (e)obj1;
        return ((e) (obj)).b - ((e) (obj1)).b;
    }
}
