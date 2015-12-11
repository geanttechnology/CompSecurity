// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.net.Uri;
import java.util.Map;

public final class aco
    implements bqe
{

    private static final acq e = new acp();
    private final Map a;
    private final Activity b;
    private final bxy c;
    private final cpz d;

    public aco(Map map, Activity activity, bxy bxy1, cpz cpz1)
    {
        a = (Map)b.a(map);
        b = (Activity)b.a(activity);
        c = (bxy)b.a(bxy1);
        d = (cpz)b.a(cpz1);
    }

    public aco(Map map, Activity activity, cpz cpz1)
    {
        this(map, activity, new bxy(), cpz1);
    }

    private void a(dpd adpd[])
    {
        if (adpd != null && adpd.length != 0)
        {
            int j = adpd.length;
            int i = 0;
            while (i < j) 
            {
                dpd dpd1 = adpd[i];
                if (dpd1 != null && dpd1.b != null)
                {
                    Object obj = d;
                    obj = cpz.a("kidsactivityendpointlogging", 0x323467f);
                    ((cqd) (obj)).a(Uri.parse(dpd1.b));
                    obj.d = false;
                    d.a(((cqd) (obj)), cni.b);
                }
                i++;
            }
        }
    }

    public static byte[] b(dre dre1)
    {
        if (dre1 != null && dre1.a != null)
        {
            return dre1.a;
        } else
        {
            return bqd.a;
        }
    }

    public final void a(dre dre1)
    {
        acq acq1 = null;
        if (dre1.e != null)
        {
            acq1 = (acq)a.get(eda);
        } else
        if (dre1.c != null)
        {
            acq1 = (acq)a.get(dfu);
        }
        if (acq1 == null)
        {
            acq1 = e;
        } else
        {
            a(dre1.b);
        }
        acq1.a(dre1, b);
    }

    public final void a(dxa dxa1, Object obj)
    {
        obj = (bxx)c.a.get(a.a(dxa1));
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((bxx) (obj)).a(dxa1, null);
_L4:
        if (obj != null)
        {
            try
            {
                a(dxa1.c);
                ((bxw) (obj)).a();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (dxa dxa1)
            {
                bmo.b("Attempted to resolve unknown ServiceEndpoint", dxa1);
            }
            break MISSING_BLOCK_LABEL_67;
        }
        throw new bxz("Unknown ServiceData encountered");
        return;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
