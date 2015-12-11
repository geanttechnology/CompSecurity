// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;
import com.google.android.gms.common.internal.w;
import java.util.Iterator;
import java.util.List;

public final class lh
{

    private final Uri a;

    private lh(Uri uri)
    {
        a = uri;
    }

    public static lh a(String s, Uri uri)
    {
        s = (new android.net.Uri.Builder()).scheme("android-app").authority(s);
        if (uri != null)
        {
            s.appendPath(uri.getScheme());
            if (uri.getAuthority() != null)
            {
                s.appendPath(uri.getAuthority());
            }
            for (Iterator iterator = uri.getPathSegments().iterator(); iterator.hasNext(); s.appendPath((String)iterator.next())) { }
            s.encodedQuery(uri.getEncodedQuery()).encodedFragment(uri.getEncodedFragment());
        }
        return new lh(s.build());
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof lh)
        {
            return a.equals(((lh)obj).a);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            a
        });
    }

    public String toString()
    {
        return a.toString();
    }
}
