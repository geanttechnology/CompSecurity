// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.animation.Animation;
import android.widget.ImageView;

public final class blp
    implements bhv
{

    private final ImageView a;
    private final blr b;
    private final blt c;
    private final Animation d;

    public blp(ImageView imageview, blr blr1, blt blt1)
    {
        a = (ImageView)b.a(imageview);
        b = (blr)b.a(blr1);
        c = blt1;
        imageview.setImageBitmap(null);
        imageview.setAnimation(null);
        d = blr1.a();
        if (blr1.a() != null)
        {
            d.setAnimationListener(new blq(this));
        }
        imageview.setTag(0x7f100006, this);
    }

    protected final void a()
    {
        if (a.getTag(0x7f100006) != this)
        {
            return;
        }
        a.invalidate();
        if (c != null)
        {
            Object obj = c;
            obj = a;
        }
        bln.b(a);
    }

    public final void a(Object obj, Exception exception)
    {
        if (a.getTag(0x7f100006) == this)
        {
            if (c != null)
            {
                c.a(a);
            }
            bln.a(a);
        }
    }

    public final void a(Object obj, Object obj1)
    {
label0:
        {
            obj = (Uri)obj;
            obj1 = (Bitmap)obj1;
            if (a.getTag(0x7f100006) == this)
            {
                b.a(a, ((Bitmap) (obj1)));
                if (c != null)
                {
                    c.a(a, ((Bitmap) (obj1)));
                }
                bln.a(a, ((Bitmap) (obj1)));
                if (!((Uri) (obj)).equals(a.getTag(0x7f100007)) && d != null)
                {
                    break label0;
                }
                a();
            }
            return;
        }
        a.setTag(0x7f100007, obj);
        d.reset();
        a.startAnimation(d);
    }
}
