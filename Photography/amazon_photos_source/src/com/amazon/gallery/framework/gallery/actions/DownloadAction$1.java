// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.gallery.thor.removablestorage.StorageLocationPreference;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DownloadAction

static class ence
{

    static final int $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[];

    static 
    {
        $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference = new int[StorageLocationPreference.values().length];
        try
        {
            $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[StorageLocationPreference.USE_REMOVABLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[StorageLocationPreference.USE_INTERNAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[StorageLocationPreference.UNSPECIFIED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
