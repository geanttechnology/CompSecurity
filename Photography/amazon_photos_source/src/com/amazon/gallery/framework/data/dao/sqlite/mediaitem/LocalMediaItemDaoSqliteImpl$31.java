// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.model.media.GroupType;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

static class 
{

    static final int $SwitchMap$com$amazon$gallery$framework$model$media$GroupType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$model$media$GroupType = new int[GroupType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$GroupType[GroupType.LENTICULAR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$media$GroupType[GroupType.REWIND.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
