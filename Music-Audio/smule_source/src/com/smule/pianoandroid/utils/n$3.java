// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import java.util.Comparator;

// Referenced classes of package com.smule.pianoandroid.utils:
//            n

final class 
    implements Comparator
{

    public int a(java.util.Entry entry, java.util.Entry entry1)
    {
        return ((Comparable)entry.getValue()).compareTo(entry1.getValue());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((java.util.Entry)obj, (java.util.Entry)obj1);
    }

    ()
    {
    }
}
