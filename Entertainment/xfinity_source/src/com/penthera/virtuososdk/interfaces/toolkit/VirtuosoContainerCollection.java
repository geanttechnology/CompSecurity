// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.database.Cursor;
import android.os.Parcel;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            VirtuosoFolderCollection

class VirtuosoContainerCollection extends VirtuosoFolderCollection
{

    VirtuosoContainerCollection()
    {
        super(3);
    }

    VirtuosoContainerCollection(Cursor cursor)
    {
        super(cursor);
    }

    public VirtuosoContainerCollection(Parcel parcel)
    {
        super(parcel);
    }
}
