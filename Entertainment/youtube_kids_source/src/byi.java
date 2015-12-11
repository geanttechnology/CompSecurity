// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.List;

public final class byi
    implements bjo
{

    private final String a;

    public byi(String s)
    {
        a = b.a(s, "pathSegment can't be empty");
    }

    public final boolean a(Object obj)
    {
        obj = (bzi)obj;
        return ((bzi) (obj)).a.getPathSegments() != null && ((bzi) (obj)).a.getPathSegments().contains(a);
    }
}
