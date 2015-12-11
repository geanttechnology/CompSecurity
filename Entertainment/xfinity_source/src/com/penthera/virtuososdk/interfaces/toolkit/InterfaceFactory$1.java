// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.interfaces.toolkit;

import android.os.Parcel;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;

// Referenced classes of package com.penthera.virtuososdk.interfaces.toolkit:
//            InterfaceFactory, VirtuosoIdentifier, VirtuosoContainerCollection, VirtuosoFolderCollection, 
//            VirtuosoFile, VirtuosoHLSFile

class ction
    implements android.os.faces.toolkit.InterfaceFactory._cls1
{

    public IVirtuosoIdentifier createFromParcel(Parcel parcel)
    {
        int i = parcel.dataPosition();
        int j = parcel.readInt();
        parcel.setDataPosition(i);
        switch (j)
        {
        default:
            return new VirtuosoIdentifier(parcel);

        case 3: // '\003'
            return new VirtuosoContainerCollection(parcel);

        case 2: // '\002'
            return new VirtuosoFolderCollection(parcel);

        case 1: // '\001'
            return new VirtuosoFile(parcel);

        case 4: // '\004'
            return new VirtuosoHLSFile(parcel);
        }
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public IVirtuosoIdentifier[] newArray(int i)
    {
        return new IVirtuosoIdentifier[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    ction()
    {
    }
}
