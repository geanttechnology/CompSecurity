// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

// Referenced classes of package com.google.android.gms.location.places.personalized:
//            PlaceAliasResult, PlaceUserData

public final class PlaceAliasResultCreator
    implements android.os.Parcelable.Creator
{

    public PlaceAliasResultCreator()
    {
    }

    static void writeToParcel(PlaceAliasResult placealiasresult, Parcel parcel, int i)
    {
        int j = SafeParcelWriter.beginVariableData(parcel, 20293);
        SafeParcelWriter.writeParcelable(parcel, 1, placealiasresult.mStatus, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, placealiasresult.mVersionCode);
        SafeParcelWriter.writeParcelable(parcel, 2, placealiasresult.mPlaceUserData, i, false);
        SafeParcelWriter.finishVariableData(parcel, j);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        int j = SafeParcelReader.validateObjectHeader(parcel);
        Status status = null;
        int i = 0;
        PlaceUserData placeuserdata = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    SafeParcelReader.skipUnknownField(parcel, k);
                    break;

                case 1: // '\001'
                    status = (Status)SafeParcelReader.createParcelable(parcel, k, Status.CREATOR);
                    break;

                case 1000: 
                    i = SafeParcelReader.readInt(parcel, k);
                    break;

                case 2: // '\002'
                    placeuserdata = (PlaceUserData)SafeParcelReader.createParcelable(parcel, k, PlaceUserData.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new PlaceAliasResult(i, status, placeuserdata);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new PlaceAliasResult[i];
    }
}
