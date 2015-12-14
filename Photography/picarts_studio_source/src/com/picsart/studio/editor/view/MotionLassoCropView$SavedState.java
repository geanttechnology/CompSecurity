// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.utils.HandleDrawable;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.photo.motion.MotionLassoDrawable;
import myobfuscated.cn.a;

// Referenced classes of package com.picsart.studio.editor.view:
//            MotionLassoCropView

public class g extends UserSavedState
{

    public static final android.os.CropView.SavedState.g CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new MotionLassoCropView.SavedState(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new MotionLassoCropView.SavedState[i];
        }

    };
    private int b;
    private boolean c;
    private boolean d;
    private MotionLassoDrawable e;
    private HandleDrawable f;
    private HandleDrawable g;

    static int a(g g1)
    {
        return g1.b;
    }

    static boolean b(b b1)
    {
        return b1.c;
    }

    static MotionLassoDrawable c(c c1)
    {
        return c1.e;
    }

    static HandleDrawable d(e e1)
    {
        return e1.f;
    }

    static HandleDrawable e(f f1)
    {
        return f1.g;
    }

    static boolean f(g g1)
    {
        return g1.d;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.writeToParcel(parcel, i);
        parcel.writeInt(b);
        int j;
        if (c)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (d)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeParcelable(e, i);
        parcel.writeParcelable(f, i);
        parcel.writeParcelable(g, i);
    }


    public _cls1(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        b = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        d = flag;
        e = (MotionLassoDrawable)parcel.readParcelable(myobfuscated/cn/a.getClassLoader());
        f = (HandleDrawable)parcel.readParcelable(com/picsart/studio/editor/utils/HandleDrawable.getClassLoader());
        g = (HandleDrawable)parcel.readParcelable(com/picsart/studio/editor/utils/HandleDrawable.getClassLoader());
    }

    public g(Parcelable parcelable, MotionLassoCropView motionlassocropview)
    {
        super(parcelable);
        b = motionlassocropview.l;
        c = motionlassocropview.o;
        d = com.picsart.studio.editor.view.MotionLassoCropView.a(motionlassocropview);
        e = motionlassocropview.q;
        f = MotionLassoCropView.b(motionlassocropview);
        g = MotionLassoCropView.c(motionlassocropview);
    }
}
