// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IAdManager;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.cookie.AndroidCookieStore;

// Referenced classes of package tv.freewheel.ad:
//            AdContext

public class AdManager
    implements IAdManager
{

    private static IAdManager instance;
    public String adManagerVersion;
    protected Location geoLocation;
    protected int networkId;
    protected String serverUrl;
    private int version;

    private AdManager(Context context, int i)
    {
        version = -1;
        adManagerVersion = "5.19.0-r10748-1501191104";
        serverUrl = "http://g1.v.fwmrm.net";
        networkId = 0;
        Logger.setLogLevel(i);
        AndroidCookieStore.initialize(context);
        Log.i("AdManager", (new StringBuilder()).append("Version:").append(adManagerVersion).toString());
    }

    public static IAdManager getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new AdManager(context, Logger.getLogLevel());
        }
        return instance;
    }

    public String getStringVersion()
    {
        return adManagerVersion;
    }

    public int getVersion()
    {
        if (version < 0)
        {
            version = 0x7fffffff;
            String as[] = adManagerVersion.split("-");
            if (as.length > 0)
            {
                String s = as[0];
                if (!s.equals("trunk"))
                {
                    version = 0;
                    String as1[] = s.split("\\.");
                    int j = as1.length;
                    int i = j;
                    if (j > 4)
                    {
                        i = 4;
                    }
                    j = 3;
                    int k = 0;
                    while (k < i) 
                    {
                        int i1 = 1;
                        for (int l = 0; l < j; l++)
                        {
                            i1 *= 256;
                        }

                        try
                        {
                            version = version + Integer.parseInt(as1[k]) * i1;
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            version = version + i1 * 9;
                        }
                        k++;
                        j--;
                    }
                }
            }
        }
        return version;
    }

    public IAdContext newContext()
    {
        return new AdContext(this);
    }

    public void setNetwork(int i)
    {
        if (networkId > 0)
        {
            return;
        } else
        {
            networkId = i;
            return;
        }
    }

    public void setServer(String s)
    {
        if (s.startsWith("/"))
        {
            serverUrl = s;
            return;
        }
        String s2 = "";
        String s1 = s2;
        if (!s.startsWith("http://"))
        {
            s1 = s2;
            if (!s.startsWith("https://"))
            {
                s1 = "http://";
            }
        }
        String as[] = s.split("\\?");
        if (as[0].endsWith("ad/p/1"))
        {
            s = "";
        } else
        if (as[0].endsWith("ad/p/"))
        {
            s = "1";
        } else
        if (as[0].endsWith("ad/p"))
        {
            s = "/1";
        } else
        if (as[0].endsWith("/"))
        {
            s = "ad/p/1";
        } else
        {
            s = "/ad/p/1";
        }
        s2 = "?";
        if (as.length > 1)
        {
            s2 = (new StringBuilder()).append("?").append(as[1]).toString();
        }
        serverUrl = (new StringBuilder()).append(s1).append(as[0]).append(s).append(s2).toString();
    }
}
