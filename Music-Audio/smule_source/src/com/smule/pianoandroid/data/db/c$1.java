// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.db;

import java.util.LinkedHashMap;

// Referenced classes of package com.smule.pianoandroid.data.db:
//            c

class a extends LinkedHashMap
{

    final c a;

    protected boolean removeEldestEntry(java.util.Entry entry)
    {
        return size() > 16;
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
