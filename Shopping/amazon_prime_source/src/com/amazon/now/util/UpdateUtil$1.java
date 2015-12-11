// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;


// Referenced classes of package com.amazon.now.util:
//            UpdateUtil

static class pStore
{

    static final int $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[];

    static 
    {
        $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore = new int[pStore.values().length];
        try
        {
            $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[pStore.GOOGLE_PLAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[pStore.AMAZON_APP_STORE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[pStore.OTHER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
