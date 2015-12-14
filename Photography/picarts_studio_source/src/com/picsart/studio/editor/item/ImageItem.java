// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.gizmo.DefaultGizmo;
import com.picsart.studio.editor.gizmo.Gizmo;
import com.socialin.android.util.d;
import com.socialin.android.util.w;
import java.io.File;
import java.util.List;
import java.util.UUID;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.item:
//            BrushEditableItem

public class ImageItem extends BrushEditableItem
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new ImageItem(parcel);
        }

        public final volatile Object[] newArray(int k)
        {
            return new ImageItem[k];
        }

    };
    public Bitmap h;
    public String i;
    public int j;
    private String s;
    private Paint t;

    protected ImageItem()
    {
        t = new Paint(2);
        m = -1;
    }

    protected ImageItem(Parcel parcel)
    {
        super(parcel);
        t = new Paint(2);
        s = parcel.readString();
        m = parcel.readInt();
        j = parcel.readInt();
        h = w.g(s);
        o();
        p();
        b();
    }

    public static ImageItem a(Bitmap bitmap)
    {
        return (new ImageItem()).b(bitmap);
    }

    public static ImageItem h()
    {
        return new ImageItem();
    }

    private void p()
    {
        if (s != null)
        {
            i = (new File(s)).getName();
        }
    }

    public final Gizmo a(Resources resources)
    {
        return DefaultGizmo.a(resources, this);
    }

    public final ImageItem a(Bitmap bitmap, String s1)
    {
        b(bitmap);
        s = (new StringBuilder()).append(s1).append("/").append(UUID.randomUUID()).append(".raw").toString();
        try
        {
            w.a(bitmap, s);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            System.gc();
        }
        p();
        return this;
    }

    public final ImageItem b(Bitmap bitmap)
    {
        h = bitmap;
        o();
        return this;
    }

    public final void b(Canvas canvas)
    {
        if (h != null && !h.isRecycled())
        {
            t.setAlpha(Color.alpha(m));
            Paint paint = t;
            boolean flag;
            if (r().e() != 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            paint.setAntiAlias(flag);
            if (b == null && l != 1)
            {
                t.setXfermode(d.a(l));
            } else
            {
                t.setXfermode(null);
            }
            canvas.drawBitmap(h, 0.0F, 0.0F, t);
        }
    }

    public final boolean c()
    {
        return false;
    }

    public final List h_()
    {
        return m.h();
    }

    public final float i()
    {
        if (h != null)
        {
            return (float)h.getWidth();
        } else
        {
            return 0.0F;
        }
    }

    public final float j()
    {
        if (h != null)
        {
            return (float)h.getHeight();
        } else
        {
            return 0.0F;
        }
    }

    public void writeToParcel(Parcel parcel, int k)
    {
        super.writeToParcel(parcel, k);
        parcel.writeString(s);
        parcel.writeInt(m);
        parcel.writeInt(j);
    }

}
