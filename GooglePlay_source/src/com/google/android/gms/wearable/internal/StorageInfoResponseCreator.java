// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            StorageInfoResponse, PackageStorageInfo

public final class StorageInfoResponseCreator
    implements android.os.Parcelable.Creator
{

    public StorageInfoResponseCreator()
    {
    }

    static void writeToParcel$3afab916(StorageInfoResponse storageinforesponse, Parcel parcel)
    {
        int i = SafeParcelWriter.beginVariableData(parcel, 20293);
        SafeParcelWriter.writeInt(parcel, 1, storageinforesponse.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, storageinforesponse.statusCode);
        SafeParcelWriter.writeLong(parcel, 3, storageinforesponse.totalSizeBytes);
        SafeParcelWriter.writeTypedList(parcel, 4, storageinforesponse.packageStorageInfo, false);
        SafeParcelWriter.finishVariableData(parcel, i);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        int i = 0;
        int k = SafeParcelReader.validateObjectHeader(parcel);
        long l1 = 0L;
        java.util.ArrayList arraylist = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                default:
                    SafeParcelReader.skipUnknownField(parcel, l);
                    break;

                case 1: // '\001'
                    j = SafeParcelReader.readInt(parcel, l);
                    break;

                case 2: // '\002'
                    i = SafeParcelReader.readInt(parcel, l);
                    break;

                case 3: // '\003'
                    l1 = SafeParcelReader.readLong(parcel, l);
                    break;

                case 4: // '\004'
                    arraylist = SafeParcelReader.createTypedList(parcel, l, PackageStorageInfo.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new StorageInfoResponse(j, i, l1, arraylist);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new StorageInfoResponse[i];
    }
}
