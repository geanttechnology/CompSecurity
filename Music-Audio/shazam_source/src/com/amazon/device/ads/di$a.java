// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            dl, di, cn, ao, 
//            au, dh, dj, dk

protected static final class a
    implements dl
{

    private final di a;

    public final void a()
    {
        Object obj = a;
        if (b())
        {
            ((di) (obj)).b.d("Registering events must be done on a background thread.", null);
        } else
        {
            Object obj1 = ((di) (obj)).c.a();
            if (((b) (obj1)).e())
            {
                org.json.JSONArray jsonarray = ((di) (obj)).h.b();
                if (jsonarray != null)
                {
                    obj1 = new dh(((nit>) (obj1)), jsonarray);
                    obj = ((di) (obj)).d;
                    a(null, new dj[] {
                        obj1
                    }).a();
                    return;
                }
            }
        }
    }

    public (di di1)
    {
        a = di1;
    }
}
