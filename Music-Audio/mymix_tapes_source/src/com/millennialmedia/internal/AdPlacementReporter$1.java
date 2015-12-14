// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;


// Referenced classes of package com.millennialmedia.internal:
//            AdPlacementReporter

static class loadState
{

    static final int $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[];

    static 
    {
        $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState = new int[loadState.values().length];
        try
        {
            $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[loadState.IDLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[loadState.UPLOADING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[loadState.ERROR_NETWORK_UNAVAILABLE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[loadState.ERROR_SENDING_TO_SERVER.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
