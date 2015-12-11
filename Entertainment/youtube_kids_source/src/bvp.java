// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public class bvp
{

    private int a;
    private Uri b;
    private String c;
    private List d;

    public bvp(int i, Uri uri, String s)
    {
        a = i;
        b = uri;
        c = s;
        d = new ArrayList();
    }

    public final bvn a()
    {
        return new bvn(a, b, c, d);
    }

    public final bvp a(Uri uri)
    {
        d.add(uri);
        return this;
    }
}
