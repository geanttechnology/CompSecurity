// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package netswipe:
//            cu

class cv
    implements Runnable
{

    final cu a;

    cv(cu cu1)
    {
        a = cu1;
        super();
    }

    public void run()
    {
        try
        {
            if (a.b != null)
            {
                a.b.abort();
            }
        }
        catch (Exception exception) { }
        cu.a(a, true);
    }
}
