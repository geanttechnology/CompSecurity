// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Xfermode;
import com.socialin.android.d;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            c, SvgBean, NodeBean, NodeAttributeBean, 
//            GradientBean

public class ClipArtSvg
    implements Serializable
{

    public static final int CUBIC_TO = 3;
    public static final int LINE_TO = 2;
    public static final int MOVE_TO = 1;
    public static final int NONE = -256;
    public static final int QUAD_TO = 4;
    private static final String TAG = com/socialin/android/brushlib/svg/ClipArtSvg.getSimpleName();
    private static final long serialVersionUID = 1L;
    private int origHeight;
    private int origWidth;
    public SvgBean svgBean;
    private transient Path tmpPath;
    private transient RectF tmpRect;

    public ClipArtSvg(File file)
    {
        tmpPath = new Path();
        tmpRect = new RectF();
        c c1 = new c();
        svgBean = new SvgBean();
        FileInputStream fileinputstream;
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(filenotfoundexception.getMessage()).toString()
            });
            filenotfoundexception = null;
        }
        if (!c1.a(fileinputstream, svgBean))
        {
            file.delete();
            if (d.b)
            {
                d.b("wrong svg file");
            }
        }
        origWidth = svgBean.getOriginalWidth();
        origHeight = svgBean.getOriginalHeight();
    }

    public ClipArtSvg(InputStream inputstream)
    {
        tmpPath = new Path();
        tmpRect = new RectF();
        c c1 = new c();
        svgBean = new SvgBean();
        c1.a(inputstream, svgBean);
        origWidth = svgBean.getOriginalWidth();
        origHeight = svgBean.getOriginalHeight();
    }

    public ClipArtSvg(byte abyte0[])
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    public void drawSvg(Canvas canvas, int i, int j, boolean flag, Xfermode xfermode)
    {
        Path path = new Path();
        Matrix matrix = new Matrix();
        GradientBean gradientbean = null;
        int ai[] = null;
        Iterator iterator = svgBean.getNodeList().iterator();
        while (iterator.hasNext()) 
        {
            NodeBean nodebean = (NodeBean)iterator.next();
            Paint paint = new Paint();
            Paint paint1 = nodebean.getPaint();
            Object obj = nodebean.getNodeAttributeBeanList().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                NodeAttributeBean nodeattributebean = (NodeAttributeBean)((Iterator) (obj)).next();
                int k = nodeattributebean.getCommand();
                if (k == 1)
                {
                    path.moveTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                } else
                if (k == 2)
                {
                    path.lineTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                } else
                if (k == 3)
                {
                    path.cubicTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1(), nodeattributebean.getFx2(), nodeattributebean.getFy2());
                } else
                if (k == 4)
                {
                    path.quadTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1());
                }
            } while (true);
            obj = nodebean.getShader();
            if (!((String) (obj)).equals("noShader"))
            {
                paint1.reset();
                gradientbean = svgBean.getShader(((String) (obj)));
                ai = (int[])gradientbean.colors.clone();
                if (j != -256)
                {
                    if (!flag)
                    {
                        for (int l = 0; l < gradientbean.colors.length; l++)
                        {
                            int k3 = Color.red(gradientbean.colors[l]);
                            int k2 = Color.green(gradientbean.colors[l]);
                            int k1 = Color.blue(gradientbean.colors[l]);
                            int i4 = Color.red(j);
                            int i3 = Color.green(j);
                            int i2 = Color.blue(j);
                            float f = i4;
                            k3 = (int)((float)k3 * 0.3F + f * 0.7F);
                            f = i3;
                            k2 = (int)((float)k2 * 0.3F + 0.7F * f);
                            f = i2;
                            k1 = (int)((float)k1 * 0.3F + 0.7F * f);
                            gradientbean.colors[l] = Color.rgb(k3, k2, k1);
                        }

                    } else
                    {
                        for (int i1 = 0; i1 < gradientbean.colors.length; i1++)
                        {
                            gradientbean.colors[i1] = j;
                        }

                    }
                }
                if (gradientbean.gradientTransformMatrix != null)
                {
                    matrix.reset();
                    matrix.setValues(gradientbean.gradientTransformMatrix);
                }
                float f1;
                int j1;
                int l1;
                int j2;
                int l2;
                int j3;
                int l3;
                int j4;
                if (gradientbean.gradientType == 1)
                {
                    LinearGradient lineargradient = new LinearGradient(gradientbean.x, gradientbean.y, gradientbean.x1, gradientbean.y1, gradientbean.colors, gradientbean.positions, gradientbean.tile);
                    if (gradientbean.gradientTransformMatrix != null)
                    {
                        lineargradient.setLocalMatrix(matrix);
                    }
                    paint1.setShader(lineargradient);
                } else
                if (gradientbean.gradientType == 2)
                {
                    RadialGradient radialgradient = new RadialGradient(gradientbean.x, gradientbean.y, gradientbean.r, gradientbean.colors, gradientbean.positions, gradientbean.tile);
                    if (gradientbean.gradientTransformMatrix != null)
                    {
                        radialgradient.setLocalMatrix(matrix);
                    }
                    paint1.setShader(radialgradient);
                }
            }
            j1 = paint1.getColor();
            if (j != -256)
            {
                if (!flag)
                {
                    l3 = Color.red(j1);
                    l2 = Color.green(j1);
                    l1 = Color.blue(j1);
                    j4 = Color.red(j);
                    j3 = Color.green(j);
                    j2 = Color.blue(j);
                    f1 = j4;
                    l3 = (int)((float)l3 * 0.3F + f1 * 0.7F);
                    f1 = j3;
                    l2 = (int)((float)l2 * 0.3F + 0.7F * f1);
                    f1 = j2;
                    paint1.setColor(Color.rgb(l3, l2, (int)((float)l1 * 0.3F + 0.7F * f1)));
                } else
                {
                    paint1.setColor(j);
                }
            }
            paint1.setAntiAlias(true);
            paint1.setAlpha(nodebean.getOpacity());
            if (nodebean.isBlurred())
            {
                paint1.setMaskFilter(new BlurMaskFilter(nodebean.getBlurRadius(), android.graphics.BlurMaskFilter.Blur.NORMAL));
            }
            path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            paint1.setAlpha((paint1.getAlpha() * i) / 255);
            paint1.setXfermode(xfermode);
            canvas.drawPath(path, paint1);
            if (nodebean.getStrokeColor() != -256)
            {
                paint.setStyle(android.graphics.Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setColor(nodebean.getStrokeColor());
                paint.setStrokeWidth(paint1.getStrokeWidth());
                path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
                paint.setXfermode(xfermode);
                canvas.drawPath(path, paint);
            }
            if (ai != null)
            {
                gradientbean.colors = ai;
            }
            paint1.setColor(j1);
            path.rewind();
        }
    }

    public int getOrigHeight()
    {
        return origHeight;
    }

    public int getOrigWidth()
    {
        return origWidth;
    }

    public void getTransformedBounds(Matrix matrix, RectF rectf)
    {
        if (tmpRect == null)
        {
            tmpPath = new Path();
        }
        if (tmpRect == null)
        {
            tmpRect = new RectF();
        }
        RectF rectf1 = null;
        Path path = new Path();
        Matrix matrix1 = new Matrix();
        Iterator iterator = svgBean.getNodeList().iterator();
        Object obj = null;
        int ai[] = null;
        while (iterator.hasNext()) 
        {
            NodeBean nodebean = (NodeBean)iterator.next();
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
                int i = nodeattributebean.getCommand();
                if (i == 1)
                {
                    path.moveTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                } else
                if (i == 2)
                {
                    path.lineTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                } else
                if (i == 3)
                {
                    path.cubicTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1(), nodeattributebean.getFx2(), nodeattributebean.getFy2());
                } else
                if (i == 4)
                {
                    path.quadTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1());
                }
            } while (true);
            obj1 = nodebean.getShader();
            if (!((String) (obj1)).equals("noShader"))
            {
                paint1.reset();
                ai = svgBean.getShader(((String) (obj1)));
                obj = (int[])((GradientBean) (ai)).colors.clone();
                if (((GradientBean) (ai)).gradientTransformMatrix != null)
                {
                    matrix1.reset();
                    matrix1.setValues(((GradientBean) (ai)).gradientTransformMatrix);
                }
                int j;
                if (((GradientBean) (ai)).gradientType == 1)
                {
                    obj1 = new LinearGradient(((GradientBean) (ai)).x, ((GradientBean) (ai)).y, ((GradientBean) (ai)).x1, ((GradientBean) (ai)).y1, ((GradientBean) (ai)).colors, ((GradientBean) (ai)).positions, ((GradientBean) (ai)).tile);
                    if (((GradientBean) (ai)).gradientTransformMatrix != null)
                    {
                        ((LinearGradient) (obj1)).setLocalMatrix(matrix1);
                    }
                    paint1.setShader(((android.graphics.Shader) (obj1)));
                    int ai1[] = ((int []) (obj));
                    obj = ai;
                    ai = ai1;
                } else
                {
                    if (((GradientBean) (ai)).gradientType == 2)
                    {
                        RadialGradient radialgradient = new RadialGradient(((GradientBean) (ai)).x, ((GradientBean) (ai)).y, ((GradientBean) (ai)).r, ((GradientBean) (ai)).colors, ((GradientBean) (ai)).positions, ((GradientBean) (ai)).tile);
                        if (((GradientBean) (ai)).gradientTransformMatrix != null)
                        {
                            radialgradient.setLocalMatrix(matrix1);
                        }
                        paint1.setShader(radialgradient);
                    }
                    int ai2[] = ai;
                    ai = ((int []) (obj));
                    obj = ai2;
                }
            } else
            {
                int ai3[] = ai;
                ai = ((int []) (obj));
                obj = ai3;
            }
            j = paint1.getColor();
            paint1.setAntiAlias(true);
            paint1.setAlpha(nodebean.getOpacity());
            if (nodebean.isBlurred())
            {
                paint1.setMaskFilter(new BlurMaskFilter(nodebean.getBlurRadius(), android.graphics.BlurMaskFilter.Blur.NORMAL));
            }
            path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            paint1.setAlpha(255);
            paint1.setXfermode(null);
            path.transform(matrix);
            paint1.getFillPath(path, tmpPath);
            tmpPath.computeBounds(tmpRect, false);
            if (rectf1 == null)
            {
                rectf1 = new RectF(tmpRect);
            } else
            {
                rectf1.union(tmpRect);
            }
            if (nodebean.getStrokeColor() != -256)
            {
                paint.setStyle(android.graphics.Paint.Style.STROKE);
                paint.setAntiAlias(true);
                paint.setColor(nodebean.getStrokeColor());
                paint.setStrokeWidth(paint1.getStrokeWidth());
                path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
                paint.setXfermode(null);
                paint.getFillPath(path, tmpPath);
                tmpPath.computeBounds(tmpRect, false);
                rectf1.union(tmpRect);
            }
            if (ai != null)
            {
                obj.colors = ai;
            }
            paint1.setColor(j);
            path.rewind();
            ai1 = ((int []) (obj));
            obj = ai;
            ai = ai1;
        }
        rectf.set(rectf1);
    }

}
