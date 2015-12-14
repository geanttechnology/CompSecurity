// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.TransformingItem;

// Referenced classes of package com.picsart.studio.editor.view:
//            SvgCropView2

class a extends android.view.pView2.SavedState
{

    public static final android.os.ropView2.SavedState.a CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SvgCropView2.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new SvgCropView2.SavedState[i];
        }

    };
    private SvgItem a;

    static SvgItem a(a a1)
    {
        return a1.a;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.eToParcel(parcel, i);
        parcel.writeParcelable(a, i);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        a = (SvgItem)parcel.readParcelable(com/picsart/studio/editor/item/TransformingItem.getClassLoader());
    }

    public a(Parcelable parcelable, SvgCropView2 svgcropview2)
    {
        super(parcelable);
        a = SvgCropView2.a(svgcropview2);
    }
}
