// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.StringMetadataField;
import com.google.android.gms.drive.metadata.internal.a;
import com.google.android.gms.drive.metadata.internal.e;

// Referenced classes of package com.google.android.gms.internal:
//            fj

public class fh
{

    public static final MetadataField MIME_TYPE = new StringMetadataField("mimeType");
    public static final CollectionMetadataField PARENTS = new e("parents");
    public static final MetadataField STARRED = new a("starred");
    public static final MetadataField TITLE = new StringMetadataField("title");
    public static final MetadataField TRASHED = new a("trashed") {

        protected Object b(DataHolder dataholder, int i, int j)
        {
            return e(dataholder, i, j);
        }

        protected Boolean e(DataHolder dataholder, int i, int j)
        {
            boolean flag;
            if (dataholder.getInteger(getName(), i, j) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Boolean.valueOf(flag);
        }

    };
    public static final MetadataField rG;
    public static final MetadataField rH = new a("isEditable");
    public static final MetadataField rI = new a("isPinned");

    static 
    {
        rG = fj.rN;
    }
}
