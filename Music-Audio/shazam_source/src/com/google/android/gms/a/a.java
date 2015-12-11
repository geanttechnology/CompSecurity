// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.a;

import android.net.Uri;
import java.util.Arrays;

public final class a
{

    private final Uri a;

    public a(Uri uri)
    {
        a = uri;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof a)
        {
            return a.equals(((a)obj).a);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            a
        });
    }

    public final String toString()
    {
        return a.toString();
    }
}
