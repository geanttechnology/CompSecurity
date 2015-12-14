// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import com.amazon.gallery.framework.model.collectionfilter.CollectionFilterType;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AlbumInfoActivity

static class ctionFilterType
{

    static final int $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType[];

    static 
    {
        $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType = new int[CollectionFilterType.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType[CollectionFilterType.FOLDER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$framework$model$collectionfilter$CollectionFilterType[CollectionFilterType.UNKNOWN.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
