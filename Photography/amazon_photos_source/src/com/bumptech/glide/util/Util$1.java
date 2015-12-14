// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;


// Referenced classes of package com.bumptech.glide.util:
//            Util

static class 
{

    static final int $SwitchMap$android$graphics$Bitmap$Config[];

    static 
    {
        $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Config.values().length];
        try
        {
            $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Config.ALPHA_8.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Config.RGB_565.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Config.ARGB_4444.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Config.ARGB_8888.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
