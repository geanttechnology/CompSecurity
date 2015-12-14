// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import com.amazon.gallery.framework.model.media.EditType;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            EditMediaItemAction

static class 
{

    static final int $SwitchMap$com$amazon$gallery$framework$model$media$EditType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$model$media$EditType = new int[EditType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.LOCAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.CLOUD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.UNIFIED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
