// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.util.SparseIntArray;
import java.net.MalformedURLException;

public final class bpm
{

    private static final SparseIntArray a = new bpn();
    private static final SparseIntArray b = new bpo();
    private static final SparseIntArray c = new bpp();

    public static bvj a(dmn dmn1)
    {
        boolean flag = false;
        if (dmn1 == null)
        {
            return null;
        }
        bvl bvl1 = new bvl(a.get(dmn1.b, 0));
        if (dmn1.c != null)
        {
            dmp admp[] = dmn1.c;
            int k = admp.length;
            for (int i = 0; i < k; i++)
            {
                bvn bvn = a(admp[i]);
                if (bvn != null)
                {
                    bvl1.a(bvn);
                }
            }

        }
        if (dmn1.d != null)
        {
            dnd adnd[] = dmn1.d;
            int l = adnd.length;
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                bvv bvv1 = a(adnd[j]);
                if (bvv1 != null)
                {
                    bvl1.a(bvv1);
                }
            }

        }
        dmn1 = a(dmn1.e);
        if (dmn1 != null)
        {
            bvl1.a = dmn1;
        }
        return bvl1.a();
    }

    private static bvn a(dmp dmp1)
    {
        bvv bvv1 = null;
        if (dmp1 == null)
        {
            return null;
        }
        Object obj = bvv1;
        try
        {
            if (dmp1.c != null)
            {
                obj = a.q(dmp1.c);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bmo.c("Badly formed InfoCardAction link URL - ignoring");
            obj = bvv1;
        }
        obj = new bvp(b.get(dmp1.b, 0), ((android.net.Uri) (obj)), dmp1.d);
        if (dmp1.e != null && dmp1.e.length > 0)
        {
            dmp1 = dmp1.e;
            int j = dmp1.length;
            for (int i = 0; i < j; i++)
            {
                bvv1 = a(dmp1[i]);
                if (bvv1 != null)
                {
                    ((bvp) (obj)).a(bvv1.a);
                }
            }

        }
        return ((bvp) (obj)).a();
    }

    private static bvr a(dmr dmr1)
    {
        if (dmr1 == null)
        {
            return null;
        }
        bvt bvt1 = new bvt(dmr1.b, dmr1.d);
        bvt1.a = dmr1.f;
        bvt1.a(Math.max(0.0F, Math.min(5F, dmr1.g)));
        bvt1.d = dmr1.a;
        if (dmr1.e != null)
        {
            try
            {
                bvt1.c = a.q(dmr1.e);
            }
            catch (MalformedURLException malformedurlexception)
            {
                bmo.c("Badly formed rating image uri - ignoring");
            }
        }
        if (dmr1.c != null)
        {
            String s1 = dmr1.c.b;
            String s = s1;
            if (TextUtils.isEmpty(s1))
            {
                s = dmr1.c.c;
            }
            if (!TextUtils.isEmpty(s))
            {
                try
                {
                    bvt1.b = a.q(s);
                }
                // Misplaced declaration of an exception variable
                catch (dmr dmr1)
                {
                    bmo.c("Badly formed app icon - ignoring");
                }
            }
        }
        return bvt1.a();
    }

    private static bvv a(dnd dnd1)
    {
        if (dnd1 == null)
        {
            return null;
        }
        if (dnd1.c == null) goto _L2; else goto _L1
_L1:
        android.net.Uri uri = a.q(dnd1.c);
_L3:
        dnd1 = new bvv(c.get(dnd1.b, 0), uri);
_L4:
        return dnd1;
_L2:
        uri = null;
          goto _L3
        dnd1;
        bmo.c("Badly formed InfoCardTrackingEvent base URL - ignoring");
        dnd1 = null;
          goto _L4
    }

}
