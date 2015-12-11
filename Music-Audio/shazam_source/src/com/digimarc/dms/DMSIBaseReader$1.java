// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSIBaseReader

static class ILES
{

    static final int $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[];

    static 
    {
        $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES = new int[ILES.values().length];
        try
        {
            $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[ILES.LOW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[ILES.MEDIUM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[ILES.HIGH.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$digimarc$dms$DMSIBase$DMS_PROFILES[ILES.IDLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
