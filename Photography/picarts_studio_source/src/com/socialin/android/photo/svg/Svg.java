// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.svg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Xfermode;
import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.d;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.svg:
//            a, SvgBean, NodeBean, NodeAttributeBean, 
//            GradientBean

public class Svg
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new Svg(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new Svg[i];
        }

    };
    private static final String b = com/socialin/android/photo/svg/Svg.getSimpleName();
    public String a;
    private SvgBean c;
    private Paint d;
    private Matrix e;
    private Matrix f;
    private float g;

    public Svg(Context context, int i)
    {
        c = null;
        d = new Paint();
        e = new Matrix();
        f = new Matrix();
        g = 1.0F;
        a a1 = new a();
        c = new SvgBean();
        a1.a(context.getResources().openRawResource(i), c);
        a = context.getResources().getResourceName(i);
    }

    public Svg(Parcel parcel)
    {
        c = null;
        d = new Paint();
        e = new Matrix();
        f = new Matrix();
        g = 1.0F;
        c = (SvgBean)parcel.readSerializable();
        g = parcel.readFloat();
    }

    public Svg(File file)
    {
        c = null;
        d = new Paint();
        e = new Matrix();
        f = new Matrix();
        g = 1.0F;
        a a1 = new a();
        c = new SvgBean();
        FileInputStream fileinputstream;
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            com.socialin.android.d.b(b, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(filenotfoundexception.getMessage()).toString()
            });
            filenotfoundexception = null;
        }
        if (!a1.a(fileinputstream, c))
        {
            file.delete();
            if (d.b)
            {
                com.socialin.android.d.b("wrong svg file");
            }
            return;
        } else
        {
            a = file.getName();
            return;
        }
    }

    public Svg(InputStream inputstream)
    {
        c = null;
        d = new Paint();
        e = new Matrix();
        f = new Matrix();
        g = 1.0F;
        a a1 = new a();
        c = new SvgBean();
        a1.a(inputstream, c);
    }

    public Svg(byte abyte0[])
    {
        this(((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    public final float a()
    {
        return c.getOriginalWidth() * g;
    }

    public final void a(float f1)
    {
        g = f1;
        Matrix matrix = new Matrix();
        matrix.setScale(f1, f1);
        for (Iterator iterator = c.getNodeList().iterator(); iterator.hasNext(); ((NodeBean)iterator.next()).getPath().transform(matrix)) { }
    }

    public final void a(Canvas canvas, int i, int j, boolean flag, boolean flag1, Xfermode xfermode, ColorFilter colorfilter)
    {
        GradientBean gradientbean;
        int ai[];
        Iterator iterator;
        f.setScale(g, g);
        gradientbean = null;
        ai = null;
        iterator = c.getNodeList().iterator();
_L6:
        NodeBean nodebean;
        Paint paint;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_1145;
        }
        nodebean = (NodeBean)iterator.next();
        paint = new Paint();
        d.reset();
        d.setColor(nodebean.getColor());
        d.setStrokeWidth(nodebean.getStrokeWidth());
        if (nodebean.getStrokeCap() != null)
        {
            d.setStrokeCap(nodebean.getStrokeCap());
        }
        if (nodebean.getStrokeJoin() != null)
        {
            d.setStrokeJoin(nodebean.getStrokeJoin());
        }
        if (nodebean.getPath() != null) goto _L2; else goto _L1
_L1:
        Path path;
        Iterator iterator1;
        path = new Path();
        path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        iterator1 = nodebean.getNodeAttributeBeanList().iterator();
_L4:
        if (iterator1.hasNext())
        {
            NodeAttributeBean nodeattributebean = (NodeAttributeBean)iterator1.next();
            switch (nodeattributebean.getCommand())
            {
            case 1: // '\001'
                path.moveTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                break;

            case 2: // '\002'
                path.lineTo(nodeattributebean.getFx(), nodeattributebean.getFy());
                break;

            case 4: // '\004'
                path.cubicTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1(), nodeattributebean.getFx2(), nodeattributebean.getFy2());
                break;

            case 3: // '\003'
                path.quadTo(nodeattributebean.getFx(), nodeattributebean.getFy(), nodeattributebean.getFx1(), nodeattributebean.getFy1());
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        path.transform(f);
        nodebean.setPath(path);
_L2:
        String s = nodebean.getShader();
        if (!s.equals("noShader"))
        {
            d.reset();
            gradientbean = c.getShader(s);
            ai = (int[])gradientbean.colors.clone();
            if (!flag)
            {
                if (!flag1)
                {
                    for (int k = 0; k < gradientbean.colors.length; k++)
                    {
                        int j3 = Color.red(gradientbean.colors[k]);
                        int j2 = Color.green(gradientbean.colors[k]);
                        int j1 = Color.blue(gradientbean.colors[k]);
                        int l3 = Color.red(j);
                        int l2 = Color.green(j);
                        int l1 = Color.blue(j);
                        float f1 = l3;
                        j3 = (int)((float)j3 * 0.3F + f1 * 0.7F);
                        f1 = l2;
                        j2 = (int)((float)j2 * 0.3F + 0.7F * f1);
                        f1 = l1;
                        j1 = (int)((float)j1 * 0.3F + 0.7F * f1);
                        gradientbean.colors[k] = Color.rgb(j3, j2, j1);
                    }

                } else
                {
                    for (int l = 0; l < gradientbean.colors.length; l++)
                    {
                        gradientbean.colors[l] = j;
                    }

                }
            }
            float f2;
            int i1;
            int k1;
            int i2;
            int k2;
            int i3;
            int k3;
            int i4;
            if (gradientbean.gradientTransformMatrix != null)
            {
                e.setValues(gradientbean.gradientTransformMatrix);
            } else
            {
                e.reset();
            }
            e.postConcat(f);
            if (gradientbean.gradientType == 1)
            {
                LinearGradient lineargradient = new LinearGradient(gradientbean.x, gradientbean.y, gradientbean.x1, gradientbean.y1, gradientbean.colors, gradientbean.positions, gradientbean.tile);
                lineargradient.setLocalMatrix(e);
                d.setShader(lineargradient);
            } else
            if (gradientbean.gradientType == 2)
            {
                RadialGradient radialgradient = new RadialGradient(gradientbean.x, gradientbean.y, gradientbean.r, gradientbean.colors, gradientbean.positions, gradientbean.tile);
                radialgradient.setLocalMatrix(e);
                d.setShader(radialgradient);
            }
        }
        i1 = d.getColor();
        if (!flag)
        {
            if (!flag1)
            {
                k3 = Color.red(i1);
                k2 = Color.green(i1);
                k1 = Color.blue(i1);
                i4 = Color.red(j);
                i3 = Color.green(j);
                i2 = Color.blue(j);
                f2 = i4;
                k3 = (int)((float)k3 * 0.3F + f2 * 0.7F);
                f2 = i3;
                k2 = (int)((float)k2 * 0.3F + 0.7F * f2);
                f2 = i2;
                k1 = (int)((float)k1 * 0.3F + 0.7F * f2);
                d.setColor(Color.rgb(k3, k2, k1));
            } else
            {
                d.setColor(j);
            }
        }
        d.setAntiAlias(true);
        d.setAlpha(nodebean.getOpacity());
        if (nodebean.isBlurred())
        {
            d.setMaskFilter(new BlurMaskFilter(nodebean.getBlurRadius(), android.graphics.BlurMaskFilter.Blur.NORMAL));
        }
        k1 = d.getAlpha();
        d.setAlpha((k1 * i) / 255);
        d.setXfermode(xfermode);
        d.setColorFilter(colorfilter);
        canvas.drawPath(nodebean.getPath(), d);
        if (nodebean.haveStrokeColor())
        {
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setColor(nodebean.getStrokeColor());
            paint.setStrokeWidth(d.getStrokeWidth());
            paint.setXfermode(xfermode);
            paint.setColorFilter(colorfilter);
            canvas.drawPath(nodebean.getPath(), paint);
        }
        if (ai != null)
        {
            gradientbean.colors = ai;
        }
        break MISSING_BLOCK_LABEL_1042;
        if (true) goto _L4; else goto _L3
_L3:
        d.setColor(i1);
        continue; /* Loop/switch isn't completed */
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final float b()
    {
        return c.getOriginalHeight() * g;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(c);
        parcel.writeFloat(g);
    }

}
