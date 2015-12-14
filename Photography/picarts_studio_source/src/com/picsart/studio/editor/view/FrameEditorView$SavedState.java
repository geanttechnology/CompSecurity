// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.picsart.studio.editor.view:
//            FrameEditorView

class b extends UserSavedState
{

    public static final android.os.itorView.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new FrameEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new FrameEditorView.SavedState[i];
        }

    };
    private TransformingItem b;

    static TransformingItem a(b b1)
    {
        return b1.b;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(b, i);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        b = (TransformingItem)parcel.readParcelable(com/picsart/studio/editor/item/TransformingItem.getClassLoader());
    }

    public b(Parcelable parcelable, FrameEditorView frameeditorview)
    {
        super(parcelable);
        b = FrameEditorView.b(frameeditorview);
    }
}
