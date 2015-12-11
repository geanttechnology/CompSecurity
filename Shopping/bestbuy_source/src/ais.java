// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ais extends rs
{

    protected sc a;
    private final Fragment b;
    private Activity c;
    private final List d = new ArrayList();

    public ais(Fragment fragment)
    {
        b = fragment;
    }

    public static void a(ais ais1, Activity activity)
    {
        ais1.a(activity);
    }

    private void a(Activity activity)
    {
        c = activity;
        i();
    }

    protected void a(sc sc1)
    {
        a = sc1;
        i();
    }

    public void i()
    {
        if (c == null || a == null || a() != null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        try
        {
            aiv.a(c);
            aju aju = anf.a(c).b(sb.a(c));
            a.a(new air(b, aju));
            aiw aiw1;
            for (Iterator iterator = d.iterator(); iterator.hasNext(); ((air)a()).a(aiw1))
            {
                aiw1 = (aiw)iterator.next();
            }

        }
        catch (RemoteException remoteexception)
        {
            throw new anl(remoteexception);
        }
        catch (ps ps1)
        {
            return;
        }
        d.clear();
    }
}
