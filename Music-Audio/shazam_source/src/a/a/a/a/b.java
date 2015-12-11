// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a.a.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.h;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.o;
import java.util.Iterator;

// Referenced classes of package a.a.a.a:
//            c, a

public final class b
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c, com.google.android.gms.wearable.c.b
{
    public static interface a
    {

        public abstract void a(a.a.a.a.a a1);
    }


    public static b b;
    public a a;
    private Context c;
    private c d;
    private Throwable e;
    private a.a.a.a.a f;

    private b()
    {
        d = null;
    }

    public b(Context context)
    {
        d = null;
        c = context;
        d = (new com.google.android.gms.common.api.c.a(context)).a(o.l).a(this).a(this).b();
        d.b();
    }

    public final void a(int j)
    {
    }

    public final void a(Bundle bundle)
    {
        o.a.a(d, this);
    }

    public final void a(ConnectionResult connectionresult)
    {
    }

    public final void a(e e1)
    {
        e1 = e1.iterator();
        do
        {
            if (!e1.hasNext())
            {
                break;
            }
            Object obj = (d)e1.next();
            if (((d) (obj)).c() == 1 && ((d) (obj)).b().b().getPath().contains("/EXCEPTION"))
            {
                obj = i.a(((d) (obj)).b());
                Throwable throwable = (Throwable)a.a.a.a.c.a(((i) (obj)).a().d("ex"));
                if (throwable != null)
                {
                    if (a != null)
                    {
                        a.a a1 = new a.a(throwable);
                        a1.b = ((i) (obj)).a().c("fingerprint");
                        a1.d = ((i) (obj)).a().c("manufacturer");
                        a1.c = ((i) (obj)).a().c("model");
                        a1.e = ((i) (obj)).a().c("product");
                        a1.g = ((i) (obj)).a().b("versionCode");
                        a1.f = ((i) (obj)).a().c("versionName");
                        f = new a.a.a.a.a(a1, (byte)0);
                        a.a(f);
                    }
                    e = throwable;
                }
            }
        } while (true);
    }
}
