// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            MraidBridge, MraidJavascriptCommand

static class tCommand
{

    static final int $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[];

    static 
    {
        $SwitchMap$com$mopub$mraid$MraidJavascriptCommand = new int[MraidJavascriptCommand.values().length];
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.CLOSE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.RESIZE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.EXPAND.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.USE_CUSTOM_CLOSE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.OPEN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.SET_ORIENTATION_PROPERTIES.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.PLAY_VIDEO.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.STORE_PICTURE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.CREATE_CALENDAR_EVENT.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$mopub$mraid$MraidJavascriptCommand[MraidJavascriptCommand.UNSPECIFIED.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
