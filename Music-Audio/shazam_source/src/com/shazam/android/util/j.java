// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util;

import com.shazam.o.r;
import java.util.UUID;

public final class j
    implements r
{

    public j()
    {
    }

    public final String a()
    {
        return UUID.randomUUID().toString();
    }
}
