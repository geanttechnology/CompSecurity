// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.picsart.studio.editor.view:
//            CropEditorView

class i extends android.view.orView.SavedState
{

    public static final android.os.itorView.SavedState.i CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new CropEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int j)
        {
            return new CropEditorView.SavedState[j];
        }

    };
    private RectF a;
    private RectF b;
    private float c;
    private int d;
    private float e;
    private boolean f;
    private float g;
    private boolean h;
    private int i;

    static RectF a(i j)
    {
        return j.a;
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

    static float e(d d1)
    {
        return d1.e;
    }

    static boolean f(e e1)
    {
        return e1.f;
    }

    static float g(f f1)
    {
        return f1.g;
    }

    static boolean h(g g1)
    {
        return g1.h;
    }

    static int i(h h1)
    {
        return h1.i;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        boolean flag = true;
        super.oParcel(parcel, j);
        parcel.writeParcelable(a, j);
        parcel.writeParcelable(b, j);
        parcel.writeFloat(c);
        parcel.writeInt(d);
        parcel.writeFloat(e);
        if (f)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeFloat(g);
        if (h)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeInt(i);
    }


    public _cls1(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        a = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
        b = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
        c = parcel.readFloat();
        d = parcel.readInt();
        e = parcel.readFloat();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
        g = parcel.readFloat();
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        h = flag;
        i = parcel.readInt();
    }

    public i(Parcelable parcelable, CropEditorView cropeditorview)
    {
        super(parcelable);
        a = CropEditorView.b(cropeditorview);
        b = CropEditorView.k(cropeditorview);
        c = CropEditorView.h(cropeditorview);
        d = CropEditorView.r(cropeditorview);
        e = CropEditorView.z(cropeditorview);
        f = CropEditorView.A(cropeditorview);
        g = CropEditorView.l(cropeditorview);
        h = CropEditorView.y(cropeditorview);
        i = cropeditorview.s;
    }
}
