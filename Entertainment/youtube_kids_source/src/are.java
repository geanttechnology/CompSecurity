// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;

public class are
    implements clr
{

    public final com.google.android.libraries.youtube.media.player.drm.WidevineHelper.Listener a;
    public boolean b;
    public int c;
    public boolean d;

    public are(com.google.android.libraries.youtube.media.player.drm.WidevineHelper.Listener listener)
    {
        c = -1;
        a = (com.google.android.libraries.youtube.media.player.drm.WidevineHelper.Listener)b.a(listener);
    }

    public ara a(Uri uri, clj clj, Looper looper, Handler handler, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            return com.google.android.libraries.youtube.media.player.drm.WidevineHelper.V18CompatibilityLayer.createWidevineDrmSessionManager18$1c66caf5(uri, clj, looper, handler, this, b(), s);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public void a()
    {
        if (b() == 1 && d)
        {
            bmo.e("HD Entitlement received");
            b = true;
            a.onHdEntitlementReceived();
        }
    }

    public void a(bwp bwp1)
    {
        b.a(bwp1);
        boolean flag;
        if (bwp1.a.b != null)
        {
            flag = bwp1.a.b.z;
        } else
        {
            flag = false;
        }
        d = flag;
        b = false;
    }

    public void a(Exception exception)
    {
        a.onDrmError(exception);
    }

    public int b()
    {
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            return -1;
        }
        if (c == -1)
        {
            c = com.google.android.libraries.youtube.media.player.drm.WidevineHelper.V18CompatibilityLayer.getWidevineSecurityLevel();
        }
        return c;
    }

    public boolean c()
    {
        return b;
    }
}
