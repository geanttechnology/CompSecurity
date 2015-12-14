// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import android.net.Uri;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.UriUtil;

public final class RangedUri
{

    private final String baseUri;
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(String s, String s1, long l, long l1)
    {
        boolean flag;
        if (s != null || s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        baseUri = s;
        referenceUri = s1;
        start = l;
        length = l1;
    }

    public RangedUri attemptMerge(RangedUri rangeduri)
    {
        long l = -1L;
        if (rangeduri != null && getUriString().equals(rangeduri.getUriString()))
        {
            if (length != -1L && start + length == rangeduri.start)
            {
                String s = baseUri;
                String s2 = referenceUri;
                long l1 = start;
                if (rangeduri.length != -1L)
                {
                    l = length + rangeduri.length;
                }
                return new RangedUri(s, s2, l1, l);
            }
            if (rangeduri.length != -1L && rangeduri.start + rangeduri.length == start)
            {
                String s1 = baseUri;
                String s3 = referenceUri;
                long l2 = rangeduri.start;
                if (length != -1L)
                {
                    l = rangeduri.length + length;
                }
                return new RangedUri(s1, s3, l2, l);
            }
        }
        return null;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (RangedUri)obj;
            if (start != ((RangedUri) (obj)).start || length != ((RangedUri) (obj)).length || !getUriString().equals(((RangedUri) (obj)).getUriString()))
            {
                return false;
            }
        }
        return true;
    }

    public Uri getUri()
    {
        return UriUtil.resolveToUri(baseUri, referenceUri);
    }

    public String getUriString()
    {
        return UriUtil.resolve(baseUri, referenceUri);
    }

    public int hashCode()
    {
        if (hashCode == 0)
        {
            hashCode = (((int)start + 527) * 31 + (int)length) * 31 + getUriString().hashCode();
        }
        return hashCode;
    }
}
