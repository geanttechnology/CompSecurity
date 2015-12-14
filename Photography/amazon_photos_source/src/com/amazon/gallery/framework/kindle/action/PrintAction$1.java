// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            PrintAction

static class ion.ActionSource
{

    static final int $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[];
    static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource = new int[com.amazon.gallery.framework.gallery.actions.n.ActionSource.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[com.amazon.gallery.framework.gallery.actions.n.ActionSource.MULTISELECT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$gallery$actions$MediaItemAction$ActionSource[com.amazon.gallery.framework.gallery.actions.n.ActionSource.SINGLE_VIEW_HAB.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
