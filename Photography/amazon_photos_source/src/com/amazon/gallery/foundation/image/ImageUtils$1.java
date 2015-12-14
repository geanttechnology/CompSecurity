// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.image;

import com.amazon.gallery.foundation.gfx.ScaleMode;

// Referenced classes of package com.amazon.gallery.foundation.image:
//            ImageUtils

static class 
{

    static final int $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode[];

    static 
    {
        $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode = new int[ScaleMode.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode[ScaleMode.SCALE_TO_FIT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$foundation$gfx$ScaleMode[ScaleMode.SCALE_TO_FILL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
