// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.content.Intent;
import android.net.Uri;
import com.shazam.b.a.a;

public final class s
    implements a
{

    public s()
    {
    }

    public final Object a(Object obj)
    {
        return new Intent("android.intent.action.VIEW", (Uri)obj);
    }
}
