// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package android.support.v7:
//            oy

static class d
{

    private final String a;
    private final URL b;
    private final ArrayList c;
    private final String d;

    public String a()
    {
        return a;
    }

    public URL b()
    {
        return b;
    }

    public ArrayList c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public (String s, URL url, ArrayList arraylist, String s1)
    {
        a = s;
        b = url;
        if (arraylist == null)
        {
            c = new ArrayList();
        } else
        {
            c = arraylist;
        }
        d = s1;
    }
}
