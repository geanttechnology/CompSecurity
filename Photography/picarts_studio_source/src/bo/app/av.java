// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bo.app;

import myobfuscated.e.b;
import myobfuscated.i.a;
import org.json.JSONException;

// Referenced classes of package bo.app:
//            bi, ao, br, bs, 
//            ct

public final class av
    implements b
{

    final ao a;

    public av(ao ao1)
    {
        a = ao1;
        super();
    }

    public final void trigger(Object obj)
    {
        obj = (bi)obj;
        br br1 = ao.j(a);
        if (br1.b(((Throwable) (obj))))
        {
            myobfuscated.i.a.b(bo.app.br.a, "Not logging duplicate database exception.");
            return;
        }
        try
        {
            br1.a(bo.app.ct.a(((bi) (obj)), br1.b.c()));
            return;
        }
        catch (JSONException jsonexception)
        {
            try
            {
                myobfuscated.i.a.c(bo.app.br.a, String.format("Failed to create database exception event from %s.", new Object[] {
                    obj
                }), jsonexception);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                myobfuscated.i.a.c(bo.app.ao.a(), "Failed to log the database exception.", ((Throwable) (obj)));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        myobfuscated.i.a.c(bo.app.br.a, "Failed to log error.", ((Throwable) (obj)));
        return;
    }
}
