// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.IOException;

final class cjo
    implements Runnable
{

    private final Uri a;
    private cjh b;

    cjo(cjh cjh1, Uri uri)
    {
        b = cjh1;
        super();
        a = (Uri)b.a(uri);
    }

    public final void run()
    {
        asn asn1 = new asn((art)cjh.m(b).b_(), new arx(a), new arq(1024));
        try
        {
            asn1.f();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }
}
