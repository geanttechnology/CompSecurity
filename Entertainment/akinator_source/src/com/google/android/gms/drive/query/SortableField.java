// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;

public class SortableField
{

    public static final SortableMetadataField CREATED_DATE;
    public static final SortableMetadataField LAST_VIEWED_BY_ME;
    public static final SortableMetadataField MODIFIED_BY_ME_DATE;
    public static final SortableMetadataField MODIFIED_DATE;
    public static final SortableMetadataField QUOTA_USED;
    public static final SortableMetadataField SHARED_WITH_ME_DATE;
    public static final SortableMetadataField TITLE;
    public static final SortableMetadataField zzanU;

    public SortableField()
    {
    }

    static 
    {
        TITLE = zznd.zzanp;
        CREATED_DATE = zznf.zzanB;
        MODIFIED_DATE = zznf.zzanD;
        MODIFIED_BY_ME_DATE = zznf.zzanE;
        LAST_VIEWED_BY_ME = zznf.zzanC;
        SHARED_WITH_ME_DATE = zznf.zzanF;
        QUOTA_USED = zznd.zzanm;
        zzanU = zznf.zzanG;
    }
}
