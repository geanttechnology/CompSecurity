// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuffXfermode;
import android.os.Parcel;
import com.picsart.studio.editor.gizmo.DefaultGizmo;
import com.picsart.studio.editor.gizmo.Gizmo;
import com.socialin.android.photo.svg.Svg;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.item:
//            BrushEditableItem

public class SvgItem extends BrushEditableItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new SvgItem(parcel);
        }

        public final volatile Object[] newArray(int k)
        {
            return new SvgItem[k];
        }

    };
    public int h;
    public Svg i;
    public boolean j;
    private boolean s;

    protected SvgItem()
    {
        j = true;
        m = -1;
    }

    public SvgItem(Parcel parcel)
    {
        boolean flag1 = true;
        super(parcel);
        i = (Svg)parcel.readParcelable(com/socialin/android/photo/svg/Svg.getClassLoader());
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        s = flag;
        m = parcel.readInt();
        h = parcel.readInt();
        b();
    }

    public static SvgItem p()
    {
        return new SvgItem();
    }

    public final Gizmo a(Resources resources)
    {
        return DefaultGizmo.a(resources, this);
    }

    public final SvgItem a(Svg svg)
    {
        i = svg;
        float f;
        if (svg.a() != 0.0F)
        {
            f = 512F / svg.a();
        } else
        {
            f = 1.0F;
        }
        svg.a(f);
        o();
        return this;
    }

    public final void b(Canvas canvas)
    {
        if (i == null) goto _L2; else goto _L1
_L1:
        canvas.save();
        if (b != null || l == 1) goto _L4; else goto _L3
_L3:
        l;
        JVM INSTR tableswitch 0 6: default 72
    //                   0 125
    //                   1 111
    //                   2 167
    //                   3 139
    //                   4 153
    //                   5 181
    //                   6 195;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L5:
        Object obj = null;
_L14:
        i.a(canvas, Color.alpha(m), 0xff000000 | m, j, s, ((android.graphics.Xfermode) (obj)), null);
        canvas.restore();
_L2:
        return;
_L7:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN);
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN);
        continue; /* Loop/switch isn't completed */
_L10:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN);
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY);
        continue; /* Loop/switch isn't completed */
_L11:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.ADD);
        continue; /* Loop/switch isn't completed */
_L12:
        obj = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = null;
        if (true) goto _L14; else goto _L13
_L13:
    }

    public final void b(boolean flag)
    {
        s = flag;
        o();
    }

    public final boolean c()
    {
        return true;
    }

    public final List h_()
    {
        return m.h();
    }

    public final float i()
    {
        if (i == null)
        {
            return 0.0F;
        } else
        {
            return i.a();
        }
    }

    public final float j()
    {
        if (i == null)
        {
            return 0.0F;
        } else
        {
            return i.b();
        }
    }

    public final void q()
    {
        j = false;
        o();
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        boolean flag = true;
        super.writeToParcel(parcel, k);
        parcel.writeParcelable(i, k);
        if (j)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        if (s)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        parcel.writeInt(m);
        parcel.writeInt(h);
    }

}
