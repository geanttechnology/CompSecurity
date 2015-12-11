// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aja extends rs
{

    protected sc a;
    private final Fragment b;
    private Activity c;
    private final List d = new ArrayList();

    public aja(Fragment fragment)
    {
        b = fragment;
    }

    public static void a(aja aja1, Activity activity)
    {
        aja1.a(activity);
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
            akg akg = anf.a(c).c(sb.a(c));
            a.a(new aiz(b, akg));
            aix aix1;
            for (Iterator iterator = d.iterator(); iterator.hasNext(); ((aiz)a()).a(aix1))
            {
                aix1 = (aix)iterator.next();
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
