// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            ck

final class cg
    implements Comparator
{

    cg()
    {
    }

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (ck)obj;
        obj1 = (ck)obj1;
        return ((ck) (obj)).b - ((ck) (obj1)).b;
    }
}
