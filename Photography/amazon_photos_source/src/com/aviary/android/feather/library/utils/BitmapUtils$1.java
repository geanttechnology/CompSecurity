// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;


// Referenced classes of package com.aviary.android.feather.library.utils:
//            BitmapUtils

static class IP_MODE
{

    static final int $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[];
    static final int $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[];

    static 
    {
        $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION = new int[TATION.values().length];
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[TATION.ROTATE_NULL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[TATION.ROTATE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[TATION.ROTATE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$ROTATION[TATION.ROTATE_270.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE = new int[IP_MODE.values().length];
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[IP_MODE.None.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[IP_MODE.Horizontal.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[IP_MODE.Vertical.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$aviary$android$feather$library$utils$BitmapUtils$FLIP_MODE[IP_MODE.HorizontalVertical.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
