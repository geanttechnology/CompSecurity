// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            HttpNetworkClient, HttpUrlConnectionNetworkClient, NetworkClient

class NetworkClientFactory
{

    NetworkClientFactory()
    {
    }

    public NetworkClient createNetworkClient()
    {
        if (getSdkVersion() < 8)
        {
            return new HttpNetworkClient();
        } else
        {
            return new HttpUrlConnectionNetworkClient();
        }
    }

    int getSdkVersion()
    {
        return android.os.Build.VERSION.SDK_INT;
    }
}
