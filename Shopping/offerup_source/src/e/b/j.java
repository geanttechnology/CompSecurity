// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.b;

import java.util.HashSet;
import java.util.Set;

final class j
{

    static final Set a;

    static 
    {
        HashSet hashset = new HashSet();
        hashset.add(java/lang/Boolean);
        hashset.add(java/lang/Character);
        hashset.add(java/lang/Byte);
        hashset.add(java/lang/Short);
        hashset.add(java/lang/Integer);
        hashset.add(java/lang/Long);
        hashset.add(java/lang/Float);
        hashset.add(java/lang/Double);
        a = hashset;
    }
}
