// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.picsart.studio.editor.view:
//            TiltShiftEditorView

class i extends UserSavedState
{

    public static final android.os.itorView.SavedState.i CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new TiltShiftEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int j)
        {
            return new TiltShiftEditorView.SavedState[j];
        }

    };
    private com.picsart.studio.editor.fragment. b;
    private byte c;
    private byte d;
    private RectF e;
    private float f;
    private float g;
    private float h;
    private int i;

    static com.picsart.studio.editor.fragment. a(i j)
    {
        return j.b;
    }

    static byte b(b b1)
    {
        return b1.c;
    }

    static byte c(c c1)
    {
        return c1.d;
    }

    static RectF d(d d1)
    {
        return d1.e;
    }

    static float e(e e1)
    {
        return e1.f;
    }

    static float f(f f1)
    {
        return f1.g;
    }

    static float g(g g1)
    {
        return g1.h;
    }

    static int h(h h1)
    {
        return h1.i;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        super.writeToParcel(parcel, j);
        parcel.writeString(b.name());
        parcel.writeByte(c);
        parcel.writeByte(d);
        parcel.writeParcelable(e, j);
        parcel.writeFloat(f);
        parcel.writeFloat(g);
        parcel.writeFloat(h);
        parcel.writeInt(i);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        b = com.picsart.studio.editor.fragment..valueOf(parcel.readString());
        c = parcel.readByte();
        d = parcel.readByte();
        e = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
        f = parcel.readFloat();
        g = parcel.readFloat();
        h = parcel.readFloat();
        i = parcel.readInt();
    }

    public i(Parcelable parcelable, TiltShiftEditorView tiltshifteditorview)
    {
        boolean flag = true;
        super(parcelable);
        b = TiltShiftEditorView.i(tiltshifteditorview);
        byte byte0;
        if (TiltShiftEditorView.q(tiltshifteditorview))
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        c = byte0;
        if (TiltShiftEditorView.j(tiltshifteditorview))
        {
            byte0 = flag;
        } else
        {
            byte0 = 0;
        }
        d = byte0;
        e = TiltShiftEditorView.c(tiltshifteditorview);
        f = TiltShiftEditorView.e(tiltshifteditorview);
        g = TiltShiftEditorView.f(tiltshifteditorview);
        h = TiltShiftEditorView.b(tiltshifteditorview);
        i = tiltshifteditorview.l;
    }
}
