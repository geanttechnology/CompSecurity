// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.connectivity;


// Referenced classes of package com.amazon.gallery.framework.network.connectivity:
//            NetworkConnectivity

static class tworkOperationType
{

    static final int $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType = new int[tworkOperationType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.CMS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.PREFETCH_BACKGROUND.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.PREFETCH_FOREGROUND.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.POLLING_SYNC_FOREGROUND.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.METRICS_UPLOAD.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.WIFI_ONLY_UPLOAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.SYNC_BACKGROUND.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.DOWNLOAD_FOREGROUND.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.STATECHANGE_SYNC_FOREGROUND.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[tworkOperationType.MOBILE_UPLOAD.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
