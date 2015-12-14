// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.view;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.socialin.android.photo.view:
//            StickerPreviewView

class d extends UserSavedState
{

    public static final android.os.eviewView.SavedState.d CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new StickerPreviewView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new StickerPreviewView.SavedState[i];
        }

    };
    private Bitmap b;
    private int c;
    private int d;

    static Bitmap a(d d1)
    {
        return d1.b;
    }

    static int b(b b1)
    {
        return b1.c;
    }

    static int c(c c1)
    {
        return c1.d;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(b, i);
        parcel.writeInt(c);
        parcel.writeInt(d);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        b = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
        c = parcel.readInt();
        d = parcel.readInt();
    }

    public d(Parcelable parcelable, StickerPreviewView stickerpreviewview)
    {
        super(parcelable);
        b = StickerPreviewView.a(stickerpreviewview);
        c = StickerPreviewView.b(stickerpreviewview);
        d = StickerPreviewView.c(stickerpreviewview).getAlpha();
    }
}
