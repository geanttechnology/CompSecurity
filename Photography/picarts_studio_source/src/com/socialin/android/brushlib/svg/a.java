// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Xfermode;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            c, SvgBean, NodeBean, NodeAttributeBean

public class a
{

    private static final String g = com/socialin/android/brushlib/svg/a.getSimpleName();
    int a;
    int b;
    Path c;
    Stroke d;
    Paint e;
    Path f;
    private SvgBean h;

    private a(Context context, String s)
    {
        Context context1;
        Context context2;
        c c1;
        context2 = null;
        context1 = null;
        super();
        h = null;
        a = 0;
        b = 0;
        c = new Path();
        d = Stroke.obtain();
        e = new Paint();
        f = new Path();
        c1 = new c();
        h = new SvgBean();
        context = context.getAssets().open(s);
        context1 = context;
        context2 = context;
        c1.a(context, h);
        context1 = context;
        context2 = context;
        a = h.getOriginalWidth();
        context1 = context;
        context2 = context;
        b = h.getOriginalHeight();
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
        }
_L2:
        e.setStyle(android.graphics.Paint.Style.FILL);
        e.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        e.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        e.setAntiAlias(true);
        a();
        return;
        context;
        context2 = context1;
        com.socialin.android.d.b(g, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        if (context1 != null)
        {
            try
            {
                context1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
                });
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        context;
        if (context2 != null)
        {
            try
            {
                context2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.socialin.android.d.b(g, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
                });
            }
        }
        throw context;
    }

    public static a a(Context context, String s)
    {
        if (context != null)
        {
            return new a(context, s);
        } else
        {
            return null;
        }
    }

    private void a()
    {
        Iterator iterator;
        c.rewind();
        iterator = h.getNodeList().iterator();
_L2:
        if (!iterator.hasNext())
        {
            break;
        }
        Iterator iterator1 = ((NodeBean)iterator.next()).getNodeAttributeBeanList().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                continue;
            }
            NodeAttributeBean nodeattributebean = (NodeAttributeBean)iterator1.next();
            switch (nodeattributebean.getCommand())
            {
            case 1: // '\001'
                c.moveTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                break;

            case 2: // '\002'
                c.lineTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                break;

            case 3: // '\003'
                c.cubicTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1(), nodeattributebean.getFx2(), nodeattributebean.getFy2());
                break;

            case 4: // '\004'
                c.quadTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1());
                break;
            }
        } while (true);
          goto _L1
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void a(Canvas canvas, Matrix matrix, int i, Xfermode xfermode)
    {
        c.transform(matrix, f);
        e.setColor(i);
        e.setXfermode(xfermode);
        e.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawPath(f, e);
    }

}
