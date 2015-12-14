// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.picsart.studio.editor.view:
//            PerspectiveView

class d extends UserSavedState
{

    public static final android.os.tiveView.SavedState.e CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new PerspectiveView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new PerspectiveView.SavedState[i];
        }

    };
    private float b;
    private float c;
    private Mode d;
    private boolean e;

    static float a(d d1)
    {
        return d1.b;
    }

    static float b(b b1)
    {
        return b1.c;
    }

    static Mode c(c c1)
    {
        return c1.d;
    }

    static boolean d(d d1)
    {
        return d1.e;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(b);
        parcel.writeFloat(c);
        parcel.writeSerializable(d);
        if (e)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    protected _cls1(Parcel parcel)
    {
        super(parcel);
        b = parcel.readFloat();
        c = parcel.readFloat();
        d = (Mode)parcel.readSerializable();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }

    protected e(Parcelable parcelable, PerspectiveView perspectiveview)
    {
        super(parcelable);
        b = PerspectiveView.d(perspectiveview);
        c = PerspectiveView.b(perspectiveview);
        d = PerspectiveView.a(perspectiveview);
    }
}
