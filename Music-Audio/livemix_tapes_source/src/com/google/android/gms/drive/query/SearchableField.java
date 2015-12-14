// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;

public class SearchableField
{

    public static final SearchableMetadataField IS_PINNED;
    public static final SearchableOrderedMetadataField LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField MIME_TYPE;
    public static final SearchableOrderedMetadataField MODIFIED_DATE;
    public static final SearchableCollectionMetadataField PARENTS;
    public static final SearchableMetadataField STARRED;
    public static final SearchableMetadataField TITLE;
    public static final SearchableMetadataField TRASHED;
    public static final SearchableOrderedMetadataField zzalr;
    public static final SearchableMetadataField zzals;

    public SearchableField()
    {
    }

    static 
    {
        TITLE = zzmb.zzakU;
        MIME_TYPE = zzmb.zzakL;
        TRASHED = zzmb.zzakV;
        PARENTS = zzmb.zzakQ;
        zzalr = zzmd.zzalh;
        STARRED = zzmb.zzakS;
        MODIFIED_DATE = zzmd.zzalf;
        LAST_VIEWED_BY_ME = zzmd.zzale;
        IS_PINNED = zzmb.zzakD;
        zzals = zzmb.zzakq;
    }
}
