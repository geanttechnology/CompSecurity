// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package android.support.design.widget:
//            f

public class c extends android.view.avior.SavedState
{

    public static final android.os.ehavior.SavedState.c CREATOR = new f();
    int a;
    float b;
    boolean c;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.(parcel, i);
        parcel.writeInt(a);
        parcel.writeFloat(b);
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }


    public (Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
        b = parcel.readFloat();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }

    public c(Parcelable parcelable)
    {
        super(parcelable);
    }
}
