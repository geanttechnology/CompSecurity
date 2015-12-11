// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.x;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            xo, xk, xp, abo, 
//            xf, xn, vq

public class xq
    implements Runnable
{

    private final Context a;
    private final xp b;
    private final xo c;
    private final xf d;
    private final xk e;

    public xq(Context context, xf xf1, xp xp1)
    {
        this(context, xf1, xp1, new xo(), new xk());
    }

    xq(Context context, xf xf1, xp xp1, xo xo1, xk xk1)
    {
        x.a(context);
        x.a(xp1);
        a = context;
        d = xf1;
        b = xp1;
        c = xo1;
        e = xk1;
    }

    public xq(Context context, xf xf1, xp xp1, String s)
    {
        this(context, xf1, xp1, new xo(), new xk());
        e.a(s);
    }

    void a()
    {
        xn xn1;
        if (!b())
        {
            b.a(xp.a.a);
            return;
        }
        abo.d("NetworkLoader: Starting to load resource from Network.");
        xn1 = c.a();
        String s = e.a(d.a());
        java.io.InputStream inputstream = xn1.a(s);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        vq.a(inputstream, bytearrayoutputstream);
        b.a(bytearrayoutputstream.toByteArray());
        xn1.a();
        abo.d("NetworkLoader: Resource loaded.");
        return;
        Object obj;
        obj;
        abo.a((new StringBuilder()).append("NetworkLoader: No data is retrieved from the given url: ").append(s).toString());
        b.a(xp.a.c);
        xn1.a();
        return;
        obj;
        abo.a((new StringBuilder()).append("NetworkLoader: Error when loading resource from url: ").append(s).append(" ").append(((IOException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
        b.a(xp.a.b);
        xn1.a();
        return;
        obj;
        abo.a((new StringBuilder()).append("NetworkLoader: Error when parsing downloaded resources from url: ").append(s).append(" ").append(((IOException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
        b.a(xp.a.c);
        xn1.a();
        return;
        Exception exception;
        exception;
        xn1.a();
        throw exception;
    }

    boolean a(String s)
    {
        return a.getPackageManager().checkPermission(s, a.getPackageName()) == 0;
    }

    boolean b()
    {
        if (!a("android.permission.INTERNET"))
        {
            abo.a("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
            return false;
        }
        if (!a("android.permission.ACCESS_NETWORK_STATE"))
        {
            abo.a("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
            return false;
        }
        NetworkInfo networkinfo = ((ConnectivityManager)a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            abo.b("NetworkLoader: No network connectivity - Offline");
            return false;
        } else
        {
            return true;
        }
    }

    public void run()
    {
        a();
    }
}
