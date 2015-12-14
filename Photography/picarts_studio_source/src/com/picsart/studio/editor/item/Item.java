// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.item;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.gizmo.Gizmo;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.item:
//            b, d, c

public abstract class Item
    implements Parcelable
{

    public boolean k;
    protected int l;
    protected int m;
    public d n;
    protected c o;
    public b p;

    protected Item()
    {
        k = true;
        d(-1);
        b(-1);
    }

    protected Item(Parcel parcel)
    {
        boolean flag = true;
        super();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        k = flag;
        d(parcel.readInt());
        b(parcel.readInt());
    }

    public abstract Gizmo a(Resources resources);

    public abstract void a(Canvas canvas);

    public final void a(com.picsart.studio.editor.gizmo.Gizmo.Action action)
    {
        if (p != null)
        {
            p.a(this, action);
        }
    }

    public final void a(c c1)
    {
        o = c1;
    }

    public abstract boolean a(Camera camera, float f, float f1);

    public final void b(int i)
    {
        m = i;
        o();
    }

    public final void c(int i)
    {
        b(Color.argb(i, Color.red(m), Color.green(m), Color.blue(m)));
    }

    public abstract boolean c();

    public final void d(int i)
    {
        l = i;
        o();
    }

    public int describeContents()
    {
        return 0;
    }

    public abstract List h_();

    public final int k()
    {
        return m;
    }

    public final int l()
    {
        return Color.alpha(m);
    }

    public final int m()
    {
        return (int)(((float)Color.alpha(m) / 255F) * 100F);
    }

    public final int n()
    {
        return l;
    }

    public final void o()
    {
        if (n != null)
        {
            n.a(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (k)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(l);
        parcel.writeInt(m);
    }
}
