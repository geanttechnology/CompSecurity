// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.picsart.studio.editor.view:
//            FlipRotateEditorView

public class b extends UserSavedState
{

    public static final android.os.itorView.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new FlipRotateEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new FlipRotateEditorView.SavedState[i];
        }

    };
    private Matrix b;

    static Matrix a(b b1)
    {
        return b1.b;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        float af[] = new float[9];
        b.getValues(af);
        parcel.writeFloatArray(af);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        float af[] = new float[9];
        parcel.readFloatArray(af);
        b = new Matrix();
        b.setValues(af);
    }

    public b(Parcelable parcelable, FlipRotateEditorView fliprotateeditorview)
    {
        super(parcelable);
        b = FlipRotateEditorView.a(fliprotateeditorview);
    }
}
