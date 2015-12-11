// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;

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
    public static final SearchableOrderedMetadataField zzanQ;
    public static final SearchableMetadataField zzanR;

    public SearchableField()
    {
    }

    static 
    {
        TITLE = zznd.zzanp;
        MIME_TYPE = zznd.zzang;
        TRASHED = zznd.zzanq;
        PARENTS = zznd.zzanl;
        zzanQ = zznf.zzanF;
        STARRED = zznd.zzann;
        MODIFIED_DATE = zznf.zzanD;
        LAST_VIEWED_BY_ME = zznf.zzanC;
        IS_PINNED = zznd.zzamY;
        zzanR = zznd.zzamL;
    }
}
