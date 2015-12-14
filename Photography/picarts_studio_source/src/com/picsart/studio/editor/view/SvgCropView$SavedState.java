// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import myobfuscated.bk.a;

// Referenced classes of package com.picsart.studio.editor.view:
//            SvgCropView

class b extends android.view.opView.SavedState
{

    public static final android.os.CropView.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SvgCropView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new SvgCropView.SavedState[i];
        }

    };
    private int a;
    private int b;

    static int a(b b1)
    {
        return b1.a;
    }

    static int b(a a1)
    {
        return a1.b;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.teToParcel(parcel, i);
        parcel.writeInt(a);
        parcel.writeInt(b);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        a = parcel.readInt();
        b = parcel.readInt();
    }

    public b(Parcelable parcelable, SvgCropView svgcropview)
    {
        super(parcelable);
        a = com.picsart.studio.editor.view.SvgCropView.a(svgcropview);
        b = svgcropview.e.c;
    }
}
