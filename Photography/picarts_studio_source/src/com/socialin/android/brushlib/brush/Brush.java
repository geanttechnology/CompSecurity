// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.brush;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;

// Referenced classes of package com.socialin.android.brushlib.brush:
//            c, b, d, l, 
//            a, e, g, i, 
//            k, j, f

public abstract class Brush
{

    protected float a;
    protected com.socialin.android.brushlib.view.DrawingView.DrawingMode b;

    public Brush()
    {
        a = 1.0F;
        b = com.socialin.android.brushlib.view.DrawingView.DrawingMode.DRAW;
    }

    public static int a(int i1)
    {
        switch (i1)
        {
        case 0: // '\0'
        case 3: // '\003'
        case 9: // '\t'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        default:
            return 0x7f02054b;

        case 2: // '\002'
            return 0x7f020549;

        case 7: // '\007'
            return 0x7f02054c;

        case 1: // '\001'
            return 0x7f020552;

        case 4: // '\004'
            return 0x7f020548;

        case 8: // '\b'
            return 0x7f02054d;

        case 5: // '\005'
            return 0x7f020550;

        case 6: // '\006'
            return 0x7f02054f;

        case 22: // '\026'
            return 0x7f02071c;

        case 10: // '\n'
            return 0x7f02070d;

        case 11: // '\013'
            return 0x7f020718;

        case 12: // '\f'
            return 0x7f020719;

        case 13: // '\r'
            return 0x7f02071a;

        case 14: // '\016'
            return 0x7f02071b;

        case 15: // '\017'
            return 0x7f02071d;

        case 16: // '\020'
            return 0x7f02071e;

        case 17: // '\021'
            return 0x7f02071f;

        case 18: // '\022'
            return 0x7f020703;

        case 19: // '\023'
            return 0x7f020704;

        case 20: // '\024'
            return 0x7f020705;

        case 29: // '\035'
            return 0x7f02070b;

        case 30: // '\036'
            return 0x7f02070c;

        case 31: // '\037'
            return 0x7f02070e;

        case 32: // ' '
            return 0x7f02070f;

        case 33: // '!'
            return 0x7f020710;

        case 34: // '"'
            return 0x7f020711;

        case 35: // '#'
            return 0x7f020712;

        case 36: // '$'
            return 0x7f020713;

        case 37: // '%'
            return 0x7f020714;

        case 38: // '&'
            return 0x7f020715;

        case 39: // '\''
            return 0x7f020716;

        case 40: // '('
            return 0x7f020717;

        case 21: // '\025'
            return 0x7f020551;
        }
    }

    public static Brush a(Context context, int i1)
    {
        switch (i1)
        {
        case 3: // '\003'
        case 9: // '\t'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        default:
            return null;

        case 0: // '\0'
            return new c();

        case 2: // '\002'
            return new b();

        case 7: // '\007'
            return new d();

        case 1: // '\001'
            return new l();

        case 4: // '\004'
            return new a();

        case 8: // '\b'
            return new e();

        case 5: // '\005'
            return g.g();

        case 6: // '\006'
            return new i();

        case 10: // '\n'
            return k.a(context, "brushes/texture_01.ast", i1);

        case 11: // '\013'
            return k.a(context, "brushes/texture_02.ast", i1);

        case 12: // '\f'
            return k.a(context, "brushes/texture_03.ast", i1);

        case 13: // '\r'
            return k.a(context, "brushes/texture_04.ast", i1);

        case 14: // '\016'
            return k.a(context, "brushes/texture_05.ast", i1);

        case 15: // '\017'
            return k.a(context, "brushes/texture_07.ast", i1);

        case 16: // '\020'
            return k.a(context, "brushes/texture_08.ast", i1);

        case 17: // '\021'
            return k.a(context, "brushes/texture_09.ast", i1);

        case 18: // '\022'
            return k.a(context, "brushes/texture_10.ast", i1);

        case 19: // '\023'
            return k.a(context, "brushes/texture_11.ast", i1);

        case 20: // '\024'
            return k.a(context, "brushes/texture_12.ast", i1);

        case 29: // '\035'
            return k.a(context, "brushes/texture_18.ast", i1);

        case 30: // '\036'
            return k.a(context, "brushes/texture_19.ast", i1);

        case 31: // '\037'
            return k.a(context, "brushes/texture_20.ast", i1);

        case 32: // ' '
            return k.a(context, "brushes/texture_21.ast", i1);

        case 33: // '!'
            return k.a(context, "brushes/texture_22.ast", i1);

        case 34: // '"'
            return k.a(context, "brushes/texture_23.ast", i1);

        case 35: // '#'
            return k.a(context, "brushes/texture_24.ast", i1);

        case 36: // '$'
            return k.a(context, "brushes/texture_25.ast", i1);

        case 37: // '%'
            return k.a(context, "brushes/texture_26.ast", i1);

        case 38: // '&'
            return k.a(context, "brushes/texture_27.ast", i1);

        case 39: // '\''
            return k.a(context, "brushes/texture_28.ast", i1);

        case 40: // '('
            return k.a(context, "brushes/texture_29.ast", i1);

        case 21: // '\025'
            return new j();

        case 22: // '\026'
            return f.g();
        }
    }

    public final float a()
    {
        return a;
    }

    public void a(float f1)
    {
        a = f1;
    }

    public abstract void a(float f1, float f2, Stroke stroke, RectF rectf);

    public abstract void a(Xfermode xfermode);

    public abstract void a(Params params);

    public abstract void a(Stroke stroke, Canvas canvas);

    public final void a(com.socialin.android.brushlib.view.DrawingView.DrawingMode drawingmode)
    {
        b = drawingmode;
        a(((Xfermode) (drawingmode.xfermode)));
    }

    public final com.socialin.android.brushlib.view.DrawingView.DrawingMode b()
    {
        return b;
    }

    public abstract void b(Params params);

    public abstract int c();

    public Object clone()
    {
        return d();
    }

    public abstract Brush d();

    public String e()
    {
        return toString();
    }
}
