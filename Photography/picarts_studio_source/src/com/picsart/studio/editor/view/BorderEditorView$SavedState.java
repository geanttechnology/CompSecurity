// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.utils.UserSavedState;

public class h extends UserSavedState
{

    public static final android.os.itorView.SavedState.h CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new BorderEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new BorderEditorView.SavedState[i];
        }

    };
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private _cls1 g;
    private float h;

    static float a(h h1, float f1)
    {
        h1.h = f1;
        return f1;
    }

    static int a(h h1)
    {
        return h1.b;
    }

    static int a(b b1, int i)
    {
        b1.b = i;
        return i;
    }

    static b a(b b1, b b2)
    {
        b1.g = b2;
        return b2;
    }

    static int b(g g1)
    {
        return g1.c;
    }

    static int b(c c1, int i)
    {
        c1.c = i;
        return i;
    }

    static int c(c c1)
    {
        return c1.d;
    }

    static int c(d d1, int i)
    {
        d1.d = i;
        return i;
    }

    static int d(d d1)
    {
        return d1.e;
    }

    static int d(e e1, int i)
    {
        e1.e = i;
        return i;
    }

    static int e(e e1)
    {
        return e1.f;
    }

    static int e(f f1, int i)
    {
        f1.f = i;
        return i;
    }

    static f f(f f1)
    {
        return f1.g;
    }

    static float g(g g1)
    {
        return g1.h;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeInt(b);
        parcel.writeInt(c);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeInt(f);
        parcel.writeSerializable(g);
        parcel.writeFloat(h);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        b = parcel.readInt();
        c = parcel.readInt();
        d = parcel.readInt();
        e = parcel.readInt();
        f = parcel.readInt();
        g = (g)parcel.readSerializable();
        h = parcel.readFloat();
    }

    public h(Parcelable parcelable)
    {
        super(parcelable);
    }
}
