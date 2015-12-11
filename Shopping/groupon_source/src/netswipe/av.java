// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageButton;

// Referenced classes of package netswipe:
//            ao, au, dc

class av extends ImageButton
{

    final au a;

    public av(au au1, Context context, Bitmap bitmap, float f, boolean flag, int i, int j)
    {
        a = au1;
        super(context);
        ao.a(this, a(context.getResources(), i, j));
        setPadding(0, 0, 0, 0);
        setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        au1 = new android.widget.LinearLayout.LayoutParams(0, au.a(au1));
        au1.weight = f;
        if (flag)
        {
            i = dc.a(context, 1);
            au1.rightMargin = i;
            au1.leftMargin = i;
        }
        setLayoutParams(au1);
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        setImageBitmap(bitmap);
    }

    public av(au au1, Context context, Bitmap bitmap, boolean flag, int i, int j)
    {
        a = au1;
        super(context);
        ao.a(this, a(context.getResources(), i, j));
        setPadding(0, 0, 0, 0);
        setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        au1 = new android.widget.RelativeLayout.LayoutParams(-1, au.a(au1));
        if (flag)
        {
            i = dc.a(context, 1);
            au1.rightMargin = i;
            au1.leftMargin = i;
        }
        setLayoutParams(au1);
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        setImageBitmap(bitmap);
    }

    private PaintDrawable a(int i, int j, int k)
    {
        PaintDrawable paintdrawable = new PaintDrawable(i);
        paintdrawable.setCornerRadii(new float[] {
            (float)j, (float)j, (float)k, (float)k, 0.0F, 0.0F, 0.0F, 0.0F
        });
        return paintdrawable;
    }

    private StateListDrawable a(Resources resources, int i, int j)
    {
        resources = new StateListDrawable();
        PaintDrawable paintdrawable = a(0xccffffff, i, j);
        resources.addState(new int[] {
            0x10100a7
        }, paintdrawable);
        paintdrawable = a(0xccffffff, i, j);
        resources.addState(new int[] {
            0x101009c
        }, paintdrawable);
        paintdrawable = a(0x1effffff, i, j);
        resources.addState(new int[] {
            0xfefeff62
        }, paintdrawable);
        paintdrawable = a(0x7fffffff, i, j);
        resources.addState(new int[0], paintdrawable);
        return resources;
    }
}
