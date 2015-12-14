// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import com.socialin.android.brushlib.svg.GradientBean;
import com.socialin.android.brushlib.svg.NodeAttributeBean;
import com.socialin.android.brushlib.svg.NodeBean;
import com.socialin.android.brushlib.svg.SvgBean;
import com.socialin.android.brushlib.svg.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{

    public int a;
    public int b;
    public int c;
    private final List d = new ArrayList();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private int g;
    private int h;
    private Context i;

    public a(Context context, int j)
    {
        g = 255;
        h = 0;
        i = null;
        c = -256;
        a(context, j, c);
        h = j;
        i = context;
    }

    private void a(Context context, int j, int k)
    {
        Object obj;
        SvgBean svgbean;
        Matrix matrix;
        Iterator iterator;
        obj = new c();
        svgbean = new SvgBean();
        ((c) (obj)).a(context.getResources().openRawResource(j), svgbean);
        a = svgbean.getOriginalWidth();
        b = svgbean.getOriginalHeight();
        d.clear();
        e.clear();
        f.clear();
        matrix = new Matrix();
        obj = null;
        context = null;
        iterator = svgbean.getNodeList().iterator();
_L2:
label0:
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            NodeBean nodebean = (NodeBean)iterator.next();
            Path path = new Path();
            Paint paint = new Paint();
            Paint paint1 = nodebean.getPaint();
            Object obj1 = nodebean.getNodeAttributeBeanList().iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                NodeAttributeBean nodeattributebean = (NodeAttributeBean)((Iterator) (obj1)).next();
                j = nodeattributebean.getCommand();
                if (j == 1)
                {
                    path.moveTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                } else
                if (j == 2)
                {
                    path.lineTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                } else
                if (j == 3)
                {
                    path.cubicTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1(), nodeattributebean.getFx2(), nodeattributebean.getFy2());
                } else
                if (j == 4)
                {
                    path.quadTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1());
                }
            } while (true);
            obj1 = nodebean.getShader();
            if (((String) (obj1)).equals("noShader"))
            {
                break label0;
            }
            paint1.reset();
            obj1 = svgbean.getShader(((String) (obj1)));
            if (c == -256 || !nodebean.getChangable())
            {
                obj = (int[])((GradientBean) (obj1)).colors.clone();
            } else
            {
                for (j = 0; j < ((GradientBean) (obj1)).colors.length; j++)
                {
                    int l1 = Color.red(((GradientBean) (obj1)).colors[j]);
                    int j1 = Color.green(((GradientBean) (obj1)).colors[j]);
                    int l = Color.blue(((GradientBean) (obj1)).colors[j]);
                    int i2 = Color.red(k);
                    int k1 = Color.green(k);
                    int i1 = Color.blue(k);
                    float f1 = i2;
                    l1 = (int)((float)l1 * 0.3F + f1 * 0.7F);
                    f1 = k1;
                    j1 = (int)((float)j1 * 0.3F + 0.7F * f1);
                    f1 = i1;
                    l = (int)((float)l * 0.3F + 0.7F * f1);
                    ((GradientBean) (obj1)).colors[j] = Color.rgb(l1, j1, l);
                }

                obj = context;
            }
            if (((GradientBean) (obj1)).gradientTransformMatrix != null)
            {
                matrix.reset();
                matrix.setValues(((GradientBean) (obj1)).gradientTransformMatrix);
            }
            if (((GradientBean) (obj1)).gradientType == 1)
            {
                context = new LinearGradient(((GradientBean) (obj1)).x, ((GradientBean) (obj1)).y, ((GradientBean) (obj1)).x1, ((GradientBean) (obj1)).y1, ((GradientBean) (obj1)).colors, ((GradientBean) (obj1)).positions, ((GradientBean) (obj1)).tile);
                if (((GradientBean) (obj1)).gradientTransformMatrix != null)
                {
                    context.setLocalMatrix(matrix);
                }
                paint1.setShader(context);
                context = ((Context) (obj1));
            } else
            {
                if (((GradientBean) (obj1)).gradientType == 2)
                {
                    context = new RadialGradient(((GradientBean) (obj1)).x, ((GradientBean) (obj1)).y, ((GradientBean) (obj1)).r, ((GradientBean) (obj1)).colors, ((GradientBean) (obj1)).positions, ((GradientBean) (obj1)).tile);
                    if (((GradientBean) (obj1)).gradientTransformMatrix != null)
                    {
                        context.setLocalMatrix(matrix);
                    }
                    paint1.setShader(context);
                }
                context = ((Context) (obj1));
            }
        }
_L3:
        paint1.setAntiAlias(true);
        paint1.setAlpha(nodebean.getOpacity());
        path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        d.add(path);
        f.add(Boolean.valueOf(nodebean.getChangable()));
        e.add(paint1);
        if (nodebean.getStrokeColor() != -256)
        {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setColor(nodebean.getStrokeColor());
            paint.setStrokeWidth(paint1.getStrokeWidth());
            path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            d.add(path);
            f.add(Boolean.valueOf(nodebean.getChangable()));
            e.add(paint);
        }
        if (obj != null)
        {
            context.colors = ((int []) (obj));
        }
        obj1 = context;
        context = ((Context) (obj));
        obj = obj1;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Context context1 = context;
        context = ((Context) (obj));
        obj = context1;
          goto _L3
    }

    public final void a(int j)
    {
        c = j;
        a(i, h, c);
    }

    public final void a(Canvas canvas, Matrix matrix)
    {
        int k = d.size();
        if (matrix != null)
        {
            canvas.concat(matrix);
        }
        for (int j = 0; j < k; j++)
        {
            matrix = (Path)d.get(j);
            Paint paint = (Paint)e.get(j);
            boolean flag = ((Boolean)f.get(j)).booleanValue();
            int l = paint.getAlpha();
            int i1 = paint.getColor();
            paint.setAlpha((g * l) / 255);
            if (c != -256 && flag)
            {
                int j2 = Color.red(i1);
                int l1 = Color.green(i1);
                int j1 = Color.blue(i1);
                int k2 = Color.red(c);
                int i2 = Color.green(c);
                int k1 = Color.blue(c);
                float f1 = k2;
                j2 = (int)((float)j2 * 0.3F + f1 * 0.7F);
                f1 = i2;
                l1 = (int)((float)l1 * 0.3F + 0.7F * f1);
                f1 = k1;
                paint.setColor(Color.rgb(j2, l1, (int)((float)j1 * 0.3F + 0.7F * f1)));
            }
            canvas.drawPath(matrix, paint);
            paint.setAlpha(l);
            paint.setColor(i1);
        }

    }
}
