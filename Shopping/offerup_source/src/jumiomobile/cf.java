// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Button;
import com.jumio.mobile.sdk.environment.Environment;

// Referenced classes of package jumiomobile:
//            bg, mh, cg, bp

public class cf
{

    public static ColorStateList a()
    {
        return new ColorStateList(new int[][] {
            new int[] {
                0x10100a7
            }, new int[] {
                0x101009c
            }, new int[] {
                0xfefeff62
            }, new int[0]
        }, new int[] {
            0xe6ffffff, 0xe6ffffff, 0x99ffffff, 0xe6ffffff
        });
    }

    public static Drawable a(Context context, int i)
    {
        float f = bg.a(context, 1.0F);
        float f1 = bg.a(context, 2.0F);
        int j = (int)bg.a(context, 10F);
        Object obj = new RoundRectShape(new float[] {
            f1, f1, f1, f1, f1, f1, f1, f1
        }, null, null);
        context = new ShapeDrawable(((android.graphics.drawable.shapes.Shape) (obj)));
        context.setPadding(j, j, j, j);
        context.getPaint().setStyle(android.graphics.Paint.Style.FILL);
        context.getPaint().setColor(i);
        obj = new ShapeDrawable(((android.graphics.drawable.shapes.Shape) (obj)));
        ((ShapeDrawable) (obj)).getPaint().setColor(0x40000000);
        context = new LayerDrawable(new Drawable[] {
            obj, context
        });
        context.setLayerInset(0, 0, (int)f, 0, 0);
        context.setLayerInset(1, 0, 0, 0, (int)f);
        return context;
    }

    public static StateListDrawable a(Context context, int i, int j)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        android.graphics.drawable.NinePatchDrawable ninepatchdrawable = mh.c(context.getResources(), j);
        statelistdrawable.addState(new int[] {
            0x10100a7
        }, ninepatchdrawable);
        context = mh.c(context.getResources(), i);
        statelistdrawable.addState(new int[] {
            0x101009e
        }, context);
        statelistdrawable.addState(new int[0], context);
        return statelistdrawable;
    }

    public static StateListDrawable a(Context context, ColorStateList colorstatelist)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        int ai[] = new int[1];
        ai[0] = 0x10100a7;
        Drawable drawable = b(context, colorstatelist.getColorForState(ai, 0xffcccccc));
        statelistdrawable.addState(ai, drawable);
        statelistdrawable.addState(new int[] {
            0x101009c
        }, drawable);
        ai = new int[1];
        ai[0] = 0xfefeff62;
        statelistdrawable.addState(ai, b(context, colorstatelist.getColorForState(ai, 0)));
        context = b(context, colorstatelist.getDefaultColor());
        statelistdrawable.addState(new int[0], context);
        return statelistdrawable;
    }

    public static cg a(Context context, int i, ColorStateList colorstatelist, int j, ColorStateList colorstatelist1)
    {
        cg cg1 = new cg();
        context = context.getTheme().obtainStyledAttributes(new int[] {
            i, j
        });
        cg1.a = context.getColorStateList(0);
        if (cg1.a == null)
        {
            i = context.getColor(0, 0);
            if (i != 0)
            {
                cg1.a = ColorStateList.valueOf(i);
            } else
            {
                cg1.a = colorstatelist;
            }
        }
        try
        {
            cg1.c = context.getDrawable(1);
        }
        // Misplaced declaration of an exception variable
        catch (ColorStateList colorstatelist)
        {
            cg1.c = null;
        }
        if (cg1.c == null)
        {
            cg1.b = context.getColorStateList(1);
            if (cg1.b == null)
            {
                i = context.getColor(1, 0);
                if (i != 0)
                {
                    cg1.b = ColorStateList.valueOf(i);
                } else
                {
                    cg1.b = colorstatelist1;
                }
            }
        }
        context.recycle();
        return cg1;
    }

    public static void a(Context context, Button button, cg cg1)
    {
        if (cg1.c != null)
        {
            context = cg1.c;
        } else
        if (Environment.isLollipop())
        {
            context = d(context, cg1.b.getDefaultColor());
        } else
        {
            context = b(context, cg1.b);
        }
        bp.a(button, context);
        button.setTextColor(cg1.a);
    }

    public static ColorStateList b()
    {
        int ai[] = {
            0x10100a7
        };
        int ai1[] = new int[0];
        return new ColorStateList(new int[][] {
            ai, new int[] {
                0x101009c
            }, new int[] {
                0xfefeff62
            }, ai1
        }, new int[] {
            0xff708c0a, 0xff708c0a, 0x4d97be0d, 0xff97be0d
        });
    }

    public static Drawable b(Context context, int i)
    {
        int j = (int)bg.a(context, 10F);
        context = new ShapeDrawable(new RectShape());
        context.setPadding(j, j, j, j);
        context.getPaint().setStyle(android.graphics.Paint.Style.FILL);
        context.getPaint().setColor(i);
        return context;
    }

    public static StateListDrawable b(Context context, ColorStateList colorstatelist)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        int ai[] = new int[1];
        ai[0] = 0x10100a7;
        Drawable drawable = a(context, colorstatelist.getColorForState(ai, 0xff708c0a));
        statelistdrawable.addState(ai, drawable);
        statelistdrawable.addState(new int[] {
            0x101009c
        }, drawable);
        ai = new int[1];
        ai[0] = 0xfefeff62;
        statelistdrawable.addState(ai, a(context, colorstatelist.getColorForState(ai, 0x4d97be0d)));
        context = a(context, colorstatelist.getDefaultColor());
        statelistdrawable.addState(new int[0], context);
        return statelistdrawable;
    }

    public static ColorStateList c()
    {
        return new ColorStateList(new int[][] {
            new int[] {
                0x10100a7
            }, new int[] {
                0x101009c
            }, new int[] {
                0xfefeff62
            }, new int[0]
        }, new int[] {
            0xff333333, 0xff333333, 0x4d676767, 0xff676767
        });
    }

    public static Drawable c(Context context, int i)
    {
        ShapeDrawable shapedrawable = new ShapeDrawable(new RectShape());
        shapedrawable.getPaint().setColor(i);
        shapedrawable.getPaint().setStyle(android.graphics.Paint.Style.STROKE);
        shapedrawable.getPaint().setStrokeWidth(bg.a(context, 1.0F));
        return shapedrawable;
    }

    public static ColorStateList d()
    {
        return new ColorStateList(new int[][] {
            new int[] {
                0x10100a7
            }, new int[] {
                0x101009c
            }, new int[] {
                0xfefeff62
            }, new int[0]
        }, new int[] {
            0xff8b0a0a, 0xff8b0a0a, 0x4dbe0d0d, 0xffbe0d0d
        });
    }

    public static Drawable d(Context context, int i)
    {
        ColorDrawable colordrawable = new ColorDrawable(i);
        context = context.obtainStyledAttributes(new int[] {
            0x101030e
        });
        Drawable drawable = context.getDrawable(0);
        context.recycle();
        return new LayerDrawable(new Drawable[] {
            colordrawable, drawable
        });
    }

    public static ColorStateList e()
    {
        return new ColorStateList(new int[][] {
            new int[] {
                0x10100a7
            }, new int[] {
                0xfefeff62
            }, new int[0]
        }, new int[] {
            0xffcccccc, 0, 0
        });
    }
}
