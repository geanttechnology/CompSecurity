// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.core.BarcodeScannerModel;
import com.jumio.netverify.sdk.core.ModelTemplate;

public final class hg
    implements android.os.Parcelable.Creator
{

    public hg()
    {
    }

    public final BarcodeScannerModel a(Parcel parcel)
    {
        if (BarcodeScannerModel.b() == null)
        {
            BarcodeScannerModel.a(new BarcodeScannerModel(null));
        }
        ModelTemplate.a(BarcodeScannerModel.b(), parcel);
        return BarcodeScannerModel.b();
    }

    public final BarcodeScannerModel[] a(int i)
    {
        return new BarcodeScannerModel[i];
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return a(i);
    }
}
