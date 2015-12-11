// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.NetverifyModel;

public final class hj
    implements android.os.Parcelable.Creator
{

    public hj()
    {
    }

    public final NetverifyModel a(Parcel parcel)
    {
        if (NetverifyModel.b() == null)
        {
            NetverifyModel.a(new NetverifyModel(null));
        }
        ModelTemplate.a(NetverifyModel.b(), parcel);
        return NetverifyModel.b();
    }

    public final NetverifyModel[] a(int i)
    {
        return new NetverifyModel[i];
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
