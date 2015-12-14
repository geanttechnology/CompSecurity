// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.picsart.studio.editor.view:
//            SquareFitEditorView

class f extends android.view.orView.SavedState
{

    public static final android.os.itorView.SavedState.f CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SquareFitEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new SquareFitEditorView.SavedState[i];
        }

    };
    private com.picsart.studio.editor.fragment. a;
    private RectF b;
    private float c;
    private int d;
    private Bitmap e;
    private int f;

    static com.picsart.studio.editor.fragment. a(f f1)
    {
        return f1.a;
    }

    static RectF b(a a1)
    {
        return a1.b;
    }

    static float c(b b1)
    {
        return b1.c;
    }

    static int d(c c1)
    {
        return c1.d;
    }

    static Bitmap e(d d1)
    {
        return d1.e;
    }

    static int f(e e1)
    {
        return e1.f;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.el(parcel, i);
        parcel.writeString(a.name());
        parcel.writeParcelable(b, i);
        parcel.writeFloat(c);
        parcel.writeInt(d);
        parcel.writeParcelable(e, i);
        parcel.writeInt(f);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        a = com.picsart.studio.editor.fragment..valueOf(parcel.readString());
        b = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
        c = parcel.readFloat();
        d = parcel.readInt();
        e = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
        f = parcel.readInt();
    }

    public f(Parcelable parcelable, SquareFitEditorView squarefiteditorview)
    {
        super(parcelable);
        a = SquareFitEditorView.o(squarefiteditorview);
        b = SquareFitEditorView.b(squarefiteditorview);
        c = SquareFitEditorView.a(squarefiteditorview);
        d = SquareFitEditorView.p(squarefiteditorview);
        e = SquareFitEditorView.q(squarefiteditorview);
        f = squarefiteditorview.l;
    }
}
