// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.view:
//            RGBConvertView

class a extends android.view.rtView.SavedState
{

    public static final android.os.vertView.SavedState.a CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new RGBConvertView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new RGBConvertView.SavedState[i];
        }

    };
    private SparseArray a;

    static SparseArray a(a a1)
    {
        return a1.a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.oParcel(parcel, i);
        parcel.writeTypedList((List)a.get(0));
        parcel.writeTypedList((List)a.get(1));
        parcel.writeTypedList((List)a.get(2));
        parcel.writeTypedList((List)a.get(3));
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        a = new SparseArray(4);
        a.put(0, new ArrayList());
        a.put(1, new ArrayList());
        a.put(2, new ArrayList());
        a.put(3, new ArrayList());
        parcel.readTypedList((List)a.get(0), Point.CREATOR);
        parcel.readTypedList((List)a.get(1), Point.CREATOR);
        parcel.readTypedList((List)a.get(2), Point.CREATOR);
        parcel.readTypedList((List)a.get(3), Point.CREATOR);
    }

    public a(Parcelable parcelable, RGBConvertView rgbconvertview)
    {
        super(parcelable);
        a = RGBConvertView.a(rgbconvertview);
    }
}
