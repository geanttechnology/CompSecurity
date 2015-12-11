// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.Pair;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.client.methods.HttpUriRequest;

public final class qm
    implements cnn, cqs, crc
{

    private static final Pair a = Pair.create("", "");
    private final bnx b;
    private final qs c;
    private final Context d;
    private final coh e;

    public qm(bnx bnx1, qs qs1, Context context, coh coh1)
    {
        b = (bnx)b.a(bnx1);
        c = (qs)b.a(qs1);
        d = (Context)b.a(context);
        e = (coh)b.a(coh1);
    }

    private Pair a(cpl cpl1)
    {
        b.b();
        if (!cpl1.a()) goto _L2; else goto _L1
_L1:
        cpl1 = (bnz)b.a(cpl1).get();
        if (!cpl1.a()) goto _L2; else goto _L3
_L3:
        if (!cpl1.a())
        {
            throw new IllegalStateException("Cannot call getAuthenticationHeaderInfo on an unsuccessful fetch.");
        }
          goto _L4
_L2:
        return a;
_L4:
        try
        {
            cpl1 = String.valueOf(((bnz) (cpl1)).a);
            if (cpl1.length() != 0)
            {
                cpl1 = "Bearer ".concat(cpl1);
            } else
            {
                cpl1 = new String("Bearer ");
            }
            return Pair.create("Authorization", cpl1);
        }
        // Misplaced declaration of an exception variable
        catch (cpl cpl1) { }
        // Misplaced declaration of an exception variable
        catch (cpl cpl1) { }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private cpl a(cqw cqw1)
    {
        cpl cpl1 = cqw1.j();
        cqw1 = cpl1;
        if (cpl1 == null)
        {
            cqw1 = c.b().b;
        }
        return cqw1;
    }

    public final void a(dnl dnl1, cqw cqw1)
    {
        cqw1 = a(cqw1);
        if (cqw1.b())
        {
            dnl1.b.a = cqw1.d();
        }
    }

    public final void a(Map map, cra cra1)
    {
        if (!a.e(d) || !e.g())
        {
            b.b(a.t(cra1.j_()));
        }
        cra1 = a(a(((cqw) (cra1))));
        if (cra1 != a)
        {
            map.put(((Pair) (cra1)).first, ((Pair) (cra1)).second);
        }
    }

    public final void a(HttpUriRequest httpurirequest)
    {
        Pair pair = a(c.b().b);
        if (pair != a)
        {
            httpurirequest.addHeader((String)pair.first, (String)pair.second);
        }
    }

}
