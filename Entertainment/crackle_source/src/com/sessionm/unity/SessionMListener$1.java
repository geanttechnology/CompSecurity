// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.unity;


// Referenced classes of package com.sessionm.unity:
//            SessionMListener

static class 
{

    static final int $SwitchMap$com$sessionm$api$SessionM$ActivityType[];
    static final int $SwitchMap$com$sessionm$api$SessionM$State[];

    static 
    {
        $SwitchMap$com$sessionm$api$SessionM$State = new int[com.sessionm.api.es().length];
        try
        {
            $SwitchMap$com$sessionm$api$SessionM$State[com.sessionm.api.PED.nal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$sessionm$api$SessionM$State[com.sessionm.api.TED_ONLINE.nal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$sessionm$api$SessionM$State[com.sessionm.api.TED_OFFLINE.nal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$sessionm$api$SessionM$ActivityType = new int[com.sessionm.api.pe.values().length];
        try
        {
            $SwitchMap$com$sessionm$api$SessionM$ActivityType[com.sessionm.api.pe.ACHIEVEMENT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$sessionm$api$SessionM$ActivityType[com.sessionm.api.pe.PORTAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$sessionm$api$SessionM$ActivityType[com.sessionm.api.pe.INTERSTITIAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
