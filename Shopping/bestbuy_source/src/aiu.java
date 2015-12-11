// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMapOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aiu extends rs
{

    protected sc a;
    private final ViewGroup b;
    private final Context c;
    private final GoogleMapOptions d;
    private final List e = new ArrayList();

    public aiu(ViewGroup viewgroup, Context context, GoogleMapOptions googlemapoptions)
    {
        b = viewgroup;
        c = context;
        d = googlemapoptions;
    }

    protected void a(sc sc1)
    {
        a = sc1;
        i();
    }

    public void i()
    {
        if (a == null || a() != null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        try
        {
            ajx ajx = anf.a(c).a(sb.a(c), d);
            a.a(new ait(b, ajx));
            aiw aiw1;
            for (Iterator iterator = e.iterator(); iterator.hasNext(); ((ait)a()).a(aiw1))
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
        e.clear();
    }
}
