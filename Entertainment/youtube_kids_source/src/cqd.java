// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Map;

public final class cqd
{

    int a;
    String b;
    public Uri c;
    public boolean d;
    public long e;
    int f;
    public Map g;
    cqb h;
    cqt i;

    public cqd(int j, String s, int k)
    {
        d = false;
        h = cqb.a;
        i = cqt.a;
        a = j;
        b = s;
        f = k;
    }

    public final cqd a(Uri uri)
    {
        c = (Uri)b.a(uri);
        return this;
    }
}
