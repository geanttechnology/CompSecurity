// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import java.util.Arrays;

public final class e
{

    public final Uri a;

    public e(Uri uri)
    {
        a = uri;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof e)
        {
            if (this == obj)
            {
                return true;
            }
            if (((e)obj).hashCode() == hashCode())
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            a
        });
    }
}
