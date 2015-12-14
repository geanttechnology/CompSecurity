// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.helper.Sticker;
import com.picsart.studio.editor.utils.UserSavedState;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.view:
//            StickerEditorView

class g extends UserSavedState
{

    public static final android.os.itorView.SavedState.g CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new StickerEditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new StickerEditorView.SavedState[i];
        }

    };
    private List b;
    private Bitmap c;
    private int d;
    private int e;
    private int f;
    private float g;

    static List a(g g1)
    {
        return g1.b;
    }

    static Bitmap b(b b1)
    {
        return b1.c;
    }

    static int c(c c1)
    {
        return c1.d;
    }

    static int d(d d1)
    {
        return d1.e;
    }

    static int e(e e1)
    {
        return e1.f;
    }

    static float f(f f1)
    {
        return f1.g;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelableArray((Parcelable[])b.toArray(new Sticker[b.size()]), i);
        parcel.writeParcelable(c, i);
        parcel.writeInt(d);
        parcel.writeInt(e);
        parcel.writeInt(f);
        parcel.writeFloat(g);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        Parcelable aparcelable[] = parcel.readParcelableArray(com/picsart/studio/editor/helper/Sticker.getClassLoader());
        if (aparcelable == null || aparcelable.length == 0)
        {
            b = new ArrayList();
        } else
        {
            b = new ArrayList(aparcelable.length);
            int j = aparcelable.length;
            int i = 0;
            while (i < j) 
            {
                Parcelable parcelable = aparcelable[i];
                b.add((Sticker)parcelable);
                i++;
            }
        }
        c = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
        d = parcel.readInt();
        e = parcel.readInt();
        f = parcel.readInt();
        g = parcel.readFloat();
    }

    public g(Parcelable parcelable, StickerEditorView stickereditorview)
    {
        super(parcelable);
        b = StickerEditorView.a(stickereditorview);
        c = StickerEditorView.b(stickereditorview);
        d = StickerEditorView.c(stickereditorview);
        e = StickerEditorView.d(stickereditorview);
        f = StickerEditorView.e(stickereditorview);
        g = StickerEditorView.f(stickereditorview);
    }
}
