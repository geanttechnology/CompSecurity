// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajc extends rs
{

    protected sc a;
    private final ViewGroup b;
    private final Context c;
    private final StreetViewPanoramaOptions d;
    private final List e = new ArrayList();

    public ajc(ViewGroup viewgroup, Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        b = viewgroup;
        c = context;
        d = streetviewpanoramaoptions;
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
            akj akj = anf.a(c).a(sb.a(c), d);
            a.a(new ajb(b, akj));
            aix aix1;
            for (Iterator iterator = e.iterator(); iterator.hasNext(); ((ajb)a()).a(aix1))
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
        e.clear();
    }
}
