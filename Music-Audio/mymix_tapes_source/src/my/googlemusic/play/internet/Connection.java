// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

// Referenced classes of package my.googlemusic.play.internet:
//            RequestCreator

public class Connection
{

    static Connection singleton = null;
    final Context context;

    private Connection(Context context1)
    {
        if (context1 == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            context = context1.getApplicationContext();
            return;
        }
    }

    private String capitalize(String s)
    {
        String s1;
        if (s == null || s.length() == 0)
        {
            s1 = "";
        } else
        {
            char c = s.charAt(0);
            s1 = s;
            if (!Character.isUpperCase(c))
            {
                return (new StringBuilder()).append(Character.toUpperCase(c)).append(s.substring(1)).toString();
            }
        }
        return s1;
    }

    public static Connection with(Context context1)
    {
        if (singleton == null)
        {
            singleton = new Connection(context1);
        }
        return singleton;
    }

    public String getDeviceName()
    {
        String s = Build.MANUFACTURER;
        String s1 = Build.MODEL;
        if (s1.startsWith(s))
        {
            return capitalize(s1);
        } else
        {
            return (new StringBuilder()).append(capitalize(s)).append(" ").append(s1).toString();
        }
    }

    public boolean isConnected()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting();
    }

    public RequestCreator request(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return new RequestCreator(this, s1);
    }

}
