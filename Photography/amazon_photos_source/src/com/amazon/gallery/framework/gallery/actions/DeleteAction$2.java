// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.gallery.framework.model.tags.TagType;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

static class A
{

    static final int $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$model$tags$TagType = new int[TagType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALBUM.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.FOLDER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.LOCAL_FOLDER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$tags$TagType[TagType.ALL.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
