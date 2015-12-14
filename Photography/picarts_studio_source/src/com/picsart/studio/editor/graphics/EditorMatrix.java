// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.graphics;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;

public class EditorMatrix extends Matrix
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new EditorMatrix(parcel, (byte)0);
        }

        public final volatile Object[] newArray(int i)
        {
            return new EditorMatrix[i];
        }

    };

    public EditorMatrix()
    {
    }

    private EditorMatrix(Parcel parcel)
    {
        float af[] = new float[9];
        parcel.readFloatArray(af);
        setValues(af);
    }

    EditorMatrix(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        float af[] = new float[9];
        getValues(af);
        parcel.writeFloatArray(af);
    }

}
