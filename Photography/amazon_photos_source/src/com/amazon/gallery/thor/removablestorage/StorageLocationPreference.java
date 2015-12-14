// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.removablestorage;

import android.text.TextUtils;

public final class StorageLocationPreference extends Enum
{

    private static final StorageLocationPreference $VALUES[];
    public static final StorageLocationPreference UNSPECIFIED;
    public static final StorageLocationPreference USE_INTERNAL;
    public static final StorageLocationPreference USE_REMOVABLE;

    private StorageLocationPreference(String s, int i)
    {
        super(s, i);
    }

    public static StorageLocationPreference fromString(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return UNSPECIFIED;
        } else
        {
            return valueOf(s);
        }
    }

    public static StorageLocationPreference valueOf(String s)
    {
        return (StorageLocationPreference)Enum.valueOf(com/amazon/gallery/thor/removablestorage/StorageLocationPreference, s);
    }

    public static StorageLocationPreference[] values()
    {
        return (StorageLocationPreference[])$VALUES.clone();
    }

    static 
    {
        USE_INTERNAL = new StorageLocationPreference("USE_INTERNAL", 0);
        USE_REMOVABLE = new StorageLocationPreference("USE_REMOVABLE", 1);
        UNSPECIFIED = new StorageLocationPreference("UNSPECIFIED", 2);
        $VALUES = (new StorageLocationPreference[] {
            USE_INTERNAL, USE_REMOVABLE, UNSPECIFIED
        });
    }
}
