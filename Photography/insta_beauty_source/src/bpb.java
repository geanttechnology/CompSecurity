// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.os.Handler;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class bpb
{

    public Map a;
    private ExecutorService b;
    private final Handler c = new Handler();

    public bpb()
    {
        a = new HashMap();
        b = Executors.newFixedThreadPool(5);
    }

    static Handler a(bpb bpb1)
    {
        return bpb1.c;
    }

    protected Drawable a(String s)
    {
        try
        {
            s = Drawable.createFromStream((new URL(s)).openStream(), "image.png");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public Drawable a(String s, bpf bpf)
    {
        if (a.containsKey(s))
        {
            SoftReference softreference = (SoftReference)a.get(s);
            if (softreference.get() != null)
            {
                return (Drawable)softreference.get();
            }
        }
        b.submit(new bpc(this, s, bpf));
        return null;
    }
}
