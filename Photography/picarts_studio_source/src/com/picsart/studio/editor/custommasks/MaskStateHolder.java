// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.os.Parcel;
import android.os.Parcelable;

public class MaskStateHolder
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new MaskStateHolder(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int j)
        {
            return new MaskStateHolder[j];
        }

    };
    public int a;
    public int b;
    public boolean c;
    public int d;
    public int e;
    public String f;
    public float g;
    public boolean h;
    public boolean i;

    public MaskStateHolder()
    {
        a = -1;
        b = -1;
        c = true;
    }

    private MaskStateHolder(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        a = parcel.readInt();
        b = parcel.readInt();
        d = parcel.readInt();
        e = parcel.readInt();
        f = parcel.readString();
        g = parcel.readFloat();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        c = flag;
    }

    MaskStateHolder(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder("maskId: ")).append(a).append(" | categoryId: ").append(b).append(" | opacity: ").append(d).append(" | hue: ").append(e).append(" | blendMode: ").append(f).append("| rotation: ").append(g).append(" | isFlippedX: ").append(h).append(" | isFlippedY: ").append(i).append(" | isInDragMode: ").append(c).toString();
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        boolean flag = true;
        parcel.writeInt(a);
        parcel.writeInt(b);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeString(f);
        parcel.writeFloat(g);
        if (h)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (i)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (c)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
    }

}
