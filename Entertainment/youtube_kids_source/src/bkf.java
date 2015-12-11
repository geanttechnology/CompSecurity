// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import org.apache.http.client.methods.HttpUriRequest;

public abstract class bkf extends Enum
{

    public static final bkf a;
    public static final bkf b;
    public static final bkf c;
    public static final bkf d;
    public static final bkf e;
    private static bkf f;
    private static final bkf g[];

    bkf(String s, int i)
    {
        super(s, i);
    }

    public static bkf valueOf(String s)
    {
        return (bkf)Enum.valueOf(bkf, s);
    }

    public static bkf[] values()
    {
        return (bkf[])g.clone();
    }

    public abstract HttpUriRequest a(Uri uri);

    static 
    {
        f = new bkg("HEAD", 0);
        a = new bkh("GET", 1);
        b = new bki("POST", 2);
        c = new bkj("PUT", 3);
        d = new bkk("PATCH", 4);
        e = new bkl("DELETE", 5);
        g = (new bkf[] {
            f, a, b, c, d, e
        });
    }
}
