// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Parcel;

// Referenced classes of package android.support.v7:
//            an, al

public class ak
{
    static class a
        implements android.os.Parcelable.Creator
    {

        final al a;

        public Object createFromParcel(Parcel parcel)
        {
            return a.a(parcel, null);
        }

        public Object[] newArray(int i)
        {
            return a.a(i);
        }

        public a(al al1)
        {
            a = al1;
        }
    }


    public static android.os.Parcelable.Creator a(al al)
    {
        if (android.os.Build.VERSION.SDK_INT >= 13)
        {
            return an.a(al);
        } else
        {
            return new a(al);
        }
    }
}
