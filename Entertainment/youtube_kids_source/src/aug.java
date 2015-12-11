// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import java.io.IOException;
import java.util.Map;

public class aug
{

    public aug()
    {
    }

    public awl a(awi awi1)
    {
        return awi1.b(new auj(this));
    }

    public awl a(awi awi1, String s)
    {
        return awi1.b(new auk(this, s));
    }

    public awl a(awi awi1, String s, LaunchOptions launchoptions)
    {
        return awi1.b(new aui(this, s, launchoptions));
    }

    public awl a(awi awi1, String s, String s1)
    {
        return awi1.b(new auh(this, s, s1));
    }

    public void a(awi awi1, double d)
    {
        try
        {
            awi1 = (azh)awi1.a(aud.a);
            if (Double.isInfinite(d) || Double.isNaN(d))
            {
                throw new IllegalArgumentException((new StringBuilder("Volume cannot be ")).append(d).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (awi awi1)
        {
            throw new IOException("service error");
        }
        ((azq)awi1.i()).a(d, ((azh) (awi1)).h, ((azh) (awi1)).f);
        return;
    }

    public void a(awi awi1, String s, auo auo)
    {
        azh azh1;
        try
        {
            azh1 = (azh)awi1.a(aud.a);
            a.j(s);
            azh1.a(s);
        }
        // Misplaced declaration of an exception variable
        catch (awi awi1)
        {
            throw new IOException("service error");
        }
        if (auo == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        synchronized (azh1.d)
        {
            azh1.d.put(s, auo);
        }
        ((azq)azh1.i()).b(s);
        return;
        s;
        awi1;
        JVM INSTR monitorexit ;
        throw s;
    }
}
