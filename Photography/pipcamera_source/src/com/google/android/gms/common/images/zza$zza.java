// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.zzt;

final class uri
{

    public final Uri uri;

    public boolean equals(Object obj)
    {
        if (!(obj instanceof uri))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        } else
        {
            return zzt.equal(((ual)obj).uri, uri);
        }
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            uri
        });
    }

    public (Uri uri1)
    {
        uri = uri1;
    }
}
