// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.x;

import android.content.Intent;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public final class b
    implements t
{

    public b()
    {
    }

    public final l serialize(Object obj, Type type, s s)
    {
        return new r(((Intent)obj).toUri(1));
    }
}
