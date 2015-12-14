// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.photo.motion.MotionDrawer;

// Referenced classes of package com.picsart.studio.editor.view:
//            MotionView

public class b extends vedState
{

    public static final android.os.tionView.SavedState.b CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new MotionView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new MotionView.SavedState[i];
        }

    };
    private MotionDrawer b;

    static MotionDrawer a(vedState vedstate)
    {
        return vedstate.b;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(b, i);
    }


    public _cls1(Parcel parcel)
    {
        super(parcel);
        b = (MotionDrawer)parcel.readParcelable(com/socialin/android/photo/motion/MotionDrawer.getClassLoader());
    }

    public b(Parcelable parcelable, MotionView motionview)
    {
        super(parcelable, motionview);
        b = MotionView.a(motionview);
    }
}
