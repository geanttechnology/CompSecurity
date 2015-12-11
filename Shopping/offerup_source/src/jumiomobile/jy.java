// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.jumio.netverify.sdk.core.vo.Country;

// Referenced classes of package jumiomobile:
//            ju, jz, jx, jv

class jy
    implements Runnable
{

    final ju a;

    private jy(ju ju1)
    {
        a = ju1;
        super();
    }

    jy(ju ju1, jv jv)
    {
        this(ju1);
    }

    public void run()
    {
        jz jz1;
        ju.c(a).a(ju.a(a), ju.b(a));
        jz1 = new jz(this);
        if (ju.a(a) != null)
        {
            ju.a(a).runOnUiThread(jz1);
            return;
        }
        try
        {
            (new Handler(Looper.getMainLooper())).post(jz1);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            ju.a(a, jx.b);
        }
        return;
    }
}
