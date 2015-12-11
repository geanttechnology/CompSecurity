// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


// Referenced classes of package com.amazon.identity.auth.device.utils:
//            EnvironmentUtils

static class vironment
{

    static final int $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[];

    static 
    {
        $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment = new int[vironment.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[vironment.prod.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[vironment.pre_prod.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$utils$EnvironmentUtils$Environment[vironment.devo.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
