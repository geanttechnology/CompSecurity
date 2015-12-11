// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;


// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebChromeClient

static class A
{

    static final int $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[];

    static 
    {
        $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = new int[android.webkit.l.values().length];
        try
        {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.l.ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.l.DEBUG.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.l.LOG.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.l.TIP.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[android.webkit.l.WARNING.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
