// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.IOException;
import java.net.URL;

public class cio
{

    public static final String a = cio.getSimpleName();
    public final ciz b;
    public final ciz c;
    public final cip d;
    public final cin e = new cin(this);
    public final cis f = new cis();
    public final civ g;
    public final ciw h;
    public String i;
    public cix j;
    public boolean k;
    public boolean l;
    public Thread m;
    public Thread n;

    public cio(URL url, ciz ciz, URL url1, ciz ciz1, cip cip1)
    {
        i = null;
        j = null;
        k = false;
        l = false;
        m = null;
        n = null;
        b = ciz;
        c = ciz1;
        Object obj = cip1;
        if (cip1.a.a > 32)
        {
            obj = new ciq();
            ((ciq) (obj)).a.a = 32;
            obj = ((ciq) (obj)).a(cip1.a.b, cip1.a.c).a();
            cip1 = a;
            int i1 = ((cip) (obj)).a.a;
            Log.e(cip1, (new StringBuilder(98)).append("options.numSlices: ").append(i1).append(" is too large.  It is trimmed to MAX_ALLOWED_NUM_SLICES: 32").toString());
        }
        d = ((cip) (obj));
        if (!((cip) (obj)).a.f && ((cip) (obj)).a.g == 1)
        {
            throw new IOException("None of the tasks is enabled.");
        } else
        {
            g = new civ(url, ciz, ((cip) (obj)).a.a, e, this);
            g.f = ((cip) (obj)).a.h;
            h = new ciw(url1, ciz1, ((cip) (obj)).a.a, e, this);
            h.f = ((cip) (obj)).a.i;
            return;
        }
    }

    public final void a()
    {
        g.h = true;
    }

    public final void b()
    {
        h.h = true;
    }

}
