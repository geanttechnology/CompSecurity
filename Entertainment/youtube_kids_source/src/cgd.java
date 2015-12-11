// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

final class cgd
    implements android.os.Parcelable.Creator
{

    cgd()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        cge cge1 = cge.values()[parcel.readInt()];
        cgn cgn1 = cgn.values()[parcel.readInt()];
        String s = parcel.readString();
        if (cge1 == cge.a)
        {
            return new cgc((cgr)parcel.readParcelable(cgr.getClassLoader()), s, (cgb)parcel.readParcelable(cgb.getClassLoader()), (cgj)parcel.readSerializable(), cgn1);
        } else
        {
            return new cgc((cgv)parcel.readSerializable(), s);
        }
    }

    public final Object[] newArray(int i)
    {
        return new cgc[i];
    }
}
