// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import android.graphics.Path;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrawPath
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new DrawPath(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new DrawPath[i];
        }

    };
    public Path a;
    public List b;
    public boolean c;
    public float d;
    public float e;

    public DrawPath(Path path, boolean flag, float f, float f1)
    {
        b = new ArrayList();
        a = path;
        c = flag;
        d = f;
        e = f1;
    }

    public DrawPath(Parcel parcel)
    {
        b = new ArrayList();
        int j = parcel.readInt();
        a = new Path();
        if (j > 0)
        {
            PointF pointf = (PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader());
            b.add(pointf);
            a.moveTo(pointf.x, pointf.y);
            for (int i = 1; i < j; i += 2)
            {
                PointF pointf1 = (PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader());
                PointF pointf2 = (PointF)parcel.readParcelable(android/graphics/PointF.getClassLoader());
                a.quadTo(pointf1.x, pointf1.y, pointf2.x, pointf2.y);
                b.add(pointf1);
                b.add(pointf2);
            }

        }
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        d = parcel.readFloat();
        e = parcel.readFloat();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(b.size());
        for (Iterator iterator = b.iterator(); iterator.hasNext(); parcel.writeParcelable((PointF)iterator.next(), i)) { }
        if (c)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeFloat(d);
        parcel.writeFloat(e);
    }

}
