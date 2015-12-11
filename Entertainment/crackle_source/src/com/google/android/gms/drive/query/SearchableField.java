// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fi;

public class SearchableField
{

    public static final MetadataField MIME_TYPE;
    public static final OrderedMetadataField MODIFIED_DATE;
    public static final CollectionMetadataField PARENTS;
    public static final MetadataField STARRED;
    public static final MetadataField TITLE;
    public static final MetadataField TRASHED;
    public static final OrderedMetadataField rM;

    public SearchableField()
    {
    }

    static 
    {
        TITLE = fh.TITLE;
        MIME_TYPE = fh.MIME_TYPE;
        TRASHED = fh.TRASHED;
        PARENTS = fh.PARENTS;
        rM = fi.rM;
        STARRED = fh.STARRED;
        MODIFIED_DATE = fi.rJ;
    }
}
