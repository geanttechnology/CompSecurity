// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.utils.UserSavedState;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

public class d extends UserSavedState
{

    public static final android.os.itorView.SavedState.d CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new EditorView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new EditorView.SavedState[i];
        }

    };
    private Camera b;
    private int c;
    private int d;

    static Camera a(d d1)
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
        b = (Camera)parcel.readParcelable(com/picsart/studio/editor/Camera.getClassLoader());
        c = parcel.readInt();
        d = parcel.readInt();
    }

    public d(Parcelable parcelable, EditorView editorview)
    {
        super(parcelable);
        b = editorview.c;
        c = editorview.g;
        d = editorview.h;
    }
}
