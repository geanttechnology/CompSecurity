// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.svg;

import android.graphics.Color;
import android.graphics.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Referenced classes of package com.socialin.android.photo.svg:
//            NodeBean, NodeAttributeBean, SvgBean, GradientBean

public final class a
{

    private int a;
    private int b;
    private float c;
    private float d;
    private float e;
    private StringTokenizer f;
    private String g;
    private float h;
    private float i;
    private SvgBean j;

    public a()
    {
        a = 0;
        b = 0;
        c = 255F;
        d = 0.0F;
        e = 0.0F;
        f = null;
        g = null;
        h = 0.0F;
        i = 0.0F;
        j = null;
    }

    private float a()
    {
        for (g = f.nextToken(); ",".equals(g) || " ".equals(g); g = f.nextToken()) { }
        if ("-".equals(g))
        {
            return -1F * Float.parseFloat(f.nextToken());
        } else
        {
            return Float.parseFloat(g);
        }
    }

    private void a(Node node)
    {
        Object obj;
        Object obj1;
        int k;
        obj = new NodeBean();
        obj1 = node.getNodeName();
        k = -1;
        ((String) (obj1)).hashCode();
        JVM INSTR lookupswitch 4: default 68
    //                   -916589195: 236
    //                   103: 188
    //                   3433509: 204
    //                   763377263: 220;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        k;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 252
    //                   1 521
    //                   2 2440
    //                   3 3090;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        if (node.hasChildNodes())
        {
            node = node.getChildNodes();
            int j2 = node.getLength();
            for (k = 0; k < j2; k++)
            {
                obj = node.item(k);
                obj1 = ((Node) (obj)).getNodeName();
                if (!"#text".equals(obj1) && !"stop".equals(obj1))
                {
                    a(((Node) (obj)));
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L3:
        if (((String) (obj1)).equals("g"))
        {
            k = 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (((String) (obj1)).equals("path"))
        {
            k = 1;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (((String) (obj1)).equals("radialGradient"))
        {
            k = 2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (((String) (obj1)).equals("linearGradient"))
        {
            k = 3;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        g = ((Element)node).getAttribute("style");
        a = g.indexOf("stroke:");
        if (a >= 0)
        {
            g = g.substring(a + 7);
            g = g.trim();
            int l = g.indexOf(';');
            if (l > 0)
            {
                g = g.substring(0, l);
            }
        }
        a = g.indexOf("fill:");
        if (a >= 0)
        {
            g = g.substring(a + 5);
            g = g.trim();
            if (g.startsWith("#"))
            {
                int i1 = g.indexOf(';');
                if (i1 > 0)
                {
                    g = g.substring(0, i1);
                }
                b = Color.parseColor(g);
            }
            if (g.startsWith("none"))
            {
                b = 0;
                ((NodeBean) (obj)).setStyle(android.graphics.Paint.Style.STROKE);
            }
        }
        if ("".equals(((Element)node).getAttribute("opacity")))
        {
            c = 255F;
        } else
        {
            c = Float.parseFloat(((Element)node).getAttribute("opacity"));
        }
        continue; /* Loop/switch isn't completed */
_L8:
        float f1;
        Object obj2;
        obj1 = new Path();
        ((Path) (obj1)).setFillType(android.graphics.Path.FillType.EVEN_ODD);
        if ("".equals(((Element)node).getAttribute("opacity")))
        {
            f1 = c;
        } else
        {
            f1 = Float.parseFloat(((Element)node).getAttribute("opacity"));
        }
        ((NodeBean) (obj)).setPath(((Path) (obj1)));
        obj2 = ((Element)node).getAttribute("blurRadius");
        if (!"".equals(obj2))
        {
            ((NodeBean) (obj)).setBlurRadius(Float.parseFloat(((String) (obj2))));
        }
        g = ((Element)node).getAttribute("style");
        a = g.indexOf("stroke:");
        if (a >= 0)
        {
            g = g.substring(a + 7);
            g = g.trim();
            int j1 = g.indexOf(';');
            if (j1 > 0)
            {
                g = g.substring(0, j1);
            }
            b = Color.parseColor(g);
        }
        a = g.indexOf("fill:");
        if (a >= 0)
        {
            g = g.substring(a + 5);
            g = g.trim();
            if (g.startsWith("#"))
            {
                int k1 = g.indexOf(';');
                if (k1 > 0)
                {
                    g = g.substring(0, k1);
                }
                b = Color.parseColor(g);
            }
            if (g.startsWith("none"))
            {
                b = 0;
                ((NodeBean) (obj)).setStyle(android.graphics.Paint.Style.STROKE);
            }
            if (g.startsWith("url(#"))
            {
                g = g.substring(a, g.indexOf(")"));
                g = g.substring(1);
                ((NodeBean) (obj)).setShader(g);
            }
        }
        g = ((Element)node).getAttribute("fill");
        a = g.indexOf("url(");
        if (a >= 0)
        {
            g = g.substring(4, g.indexOf(")"));
            if (g.startsWith("#"))
            {
                g = g.substring(1);
                ((NodeBean) (obj)).setShader(g);
            }
        }
        g = ((Element)node).getAttribute("stroke");
        g = g.trim();
        if (!"".equals(g))
        {
            ((NodeBean) (obj)).setStrokeColor(Color.parseColor(g));
        }
        g = ((Element)node).getAttribute("stroke-width");
        g = g.trim();
        if (!"".equals(g))
        {
            ((NodeBean) (obj)).setStrokeWidth(Float.parseFloat(g));
        }
        g = ((Element)node).getAttribute("stroke-linecap");
        g = g.trim();
        if (!"".equals(g))
        {
            if ("round".equals(g))
            {
                ((NodeBean) (obj)).setStrokeCap(android.graphics.Paint.Cap.ROUND);
            }
            if ("butt".equals(g))
            {
                ((NodeBean) (obj)).setStrokeCap(android.graphics.Paint.Cap.BUTT);
            }
            if ("square".equals(g))
            {
                ((NodeBean) (obj)).setStrokeCap(android.graphics.Paint.Cap.SQUARE);
            }
        }
        g = ((Element)node).getAttribute("stroke-linejoin");
        g = g.trim();
        if (!"".equals(g))
        {
            if ("round".equals(g))
            {
                ((NodeBean) (obj)).setStrokeJoin(android.graphics.Paint.Join.ROUND);
            }
            if ("miter".equals(g))
            {
                ((NodeBean) (obj)).setStrokeJoin(android.graphics.Paint.Join.MITER);
            }
            if ("bevel".equals(g))
            {
                ((NodeBean) (obj)).setStrokeJoin(android.graphics.Paint.Join.BEVEL);
            }
        }
        g = ((Element)node).getAttribute("d");
        f = new StringTokenizer(g, " ,MmLlCczArSsHhVvDdEeFfGgJjQqTtz-", true);
_L26:
        if (!f.hasMoreElements()) goto _L12; else goto _L11
_L11:
        obj2 = new NodeAttributeBean();
        g = f.nextToken();
        g.charAt(0);
        JVM INSTR lookupswitch 12: default 1456
    //                   67: 1756
    //                   72: 2033
    //                   76: 1636
    //                   77: 1516
    //                   83: 2219
    //                   86: 2126
    //                   99: 1869
    //                   104: 2077
    //                   108: 1688
    //                   109: 1568
    //                   115: 2302
    //                   118: 2170;
           goto _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L13:
        float f4;
        float f7;
        float f10;
        float f13;
        float f14;
        float f15;
        if (f1 > 0.0F && f1 < 255F)
        {
            ((NodeBean) (obj)).setOpacity((int)(255F * f1));
        } else
        {
            ((NodeBean) (obj)).setOpacity((int)f1);
        }
        ((NodeBean) (obj)).setColor(b);
        ((NodeBean) (obj)).addToNodeAttributeBeanList(((NodeAttributeBean) (obj2)));
          goto _L26
_L17:
        f4 = a();
        f7 = a();
        d = f4;
        e = f7;
        ((Path) (obj1)).moveTo(f4, f7);
        ((NodeAttributeBean) (obj2)).setCommand(1);
        ((NodeAttributeBean) (obj2)).setFx(f4);
        ((NodeAttributeBean) (obj2)).setFy(f7);
          goto _L13
_L23:
        f7 = a();
        f4 = a();
        f7 += d;
        f4 += e;
        d = f7;
        e = f4;
        ((Path) (obj1)).moveTo(f7, f4);
        ((NodeAttributeBean) (obj2)).setCommand(1);
        ((NodeAttributeBean) (obj2)).setFx(f7);
        ((NodeAttributeBean) (obj2)).setFy(f4);
          goto _L13
_L16:
        f4 = a();
        f7 = a();
        d = f4;
        e = f7;
        ((Path) (obj1)).lineTo(f4, f7);
        ((NodeAttributeBean) (obj2)).setCommand(2);
        ((NodeAttributeBean) (obj2)).setFx(f4);
        ((NodeAttributeBean) (obj2)).setFy(f7);
          goto _L13
_L22:
        f7 = a();
        f4 = a();
        f7 += d;
        f4 += e;
        d = f7;
        e = f4;
        ((Path) (obj1)).lineTo(f7, f4);
        ((NodeAttributeBean) (obj2)).setCommand(2);
        ((NodeAttributeBean) (obj2)).setFx(f7);
        ((NodeAttributeBean) (obj2)).setFy(f4);
          goto _L13
_L14:
        f4 = a();
        f7 = a();
        f10 = a();
        f13 = a();
        f14 = a();
        f15 = a();
        ((Path) (obj1)).cubicTo(f4, f7, f10, f13, f14, f15);
        ((NodeAttributeBean) (obj2)).setCommand(4);
        ((NodeAttributeBean) (obj2)).setFx(f4);
        ((NodeAttributeBean) (obj2)).setFy(f7);
        ((NodeAttributeBean) (obj2)).setFx1(f10);
        ((NodeAttributeBean) (obj2)).setFy1(f13);
        ((NodeAttributeBean) (obj2)).setFx2(f14);
        ((NodeAttributeBean) (obj2)).setFy2(f15);
        d = f14;
        e = f15;
          goto _L13
_L20:
        f7 = a();
        f13 = a();
        f15 = a();
        f14 = a();
        f10 = a();
        f4 = a();
        f7 += d;
        f13 += e;
        f15 += d;
        f14 += e;
        f10 += d;
        f4 += e;
        ((Path) (obj1)).cubicTo(f7, f13, f15, f14, f10, f4);
        ((NodeAttributeBean) (obj2)).setCommand(4);
        ((NodeAttributeBean) (obj2)).setFx(f7);
        ((NodeAttributeBean) (obj2)).setFy(f13);
        ((NodeAttributeBean) (obj2)).setFx1(f15);
        ((NodeAttributeBean) (obj2)).setFy1(f14);
        ((NodeAttributeBean) (obj2)).setFx2(f10);
        ((NodeAttributeBean) (obj2)).setFy2(f4);
        d = f10;
        e = f4;
          goto _L13
_L15:
        f4 = a();
        d = f4;
        ((Path) (obj1)).lineTo(f4, e);
        ((NodeAttributeBean) (obj2)).setCommand(2);
        ((NodeAttributeBean) (obj2)).setFx(f4);
        ((NodeAttributeBean) (obj2)).setFy(e);
          goto _L13
_L21:
        f4 = a() + d;
        d = f4;
        ((Path) (obj1)).lineTo(f4, e);
        ((NodeAttributeBean) (obj2)).setCommand(2);
        ((NodeAttributeBean) (obj2)).setFx(f4);
        ((NodeAttributeBean) (obj2)).setFy(e);
          goto _L13
_L19:
        f4 = a();
        e = f4;
        ((Path) (obj1)).lineTo(d, f4);
        ((NodeAttributeBean) (obj2)).setCommand(2);
        ((NodeAttributeBean) (obj2)).setFx(d);
        ((NodeAttributeBean) (obj2)).setFy(f4);
          goto _L13
_L25:
        f4 = a() + e;
        e = f4;
        ((Path) (obj1)).lineTo(d, f4);
        ((NodeAttributeBean) (obj2)).setCommand(2);
        ((NodeAttributeBean) (obj2)).setFx(d);
        ((NodeAttributeBean) (obj2)).setFy(f4);
          goto _L13
_L18:
        f4 = a();
        f7 = a();
        f10 = a();
        f13 = a();
        ((Path) (obj1)).quadTo(f4, f7, f10, f13);
        d = f10;
        e = f13;
        ((NodeAttributeBean) (obj2)).setCommand(3);
        ((NodeAttributeBean) (obj2)).setFx(f4);
        ((NodeAttributeBean) (obj2)).setFy(f7);
        ((NodeAttributeBean) (obj2)).setFx1(f10);
        ((NodeAttributeBean) (obj2)).setFy1(f13);
          goto _L13
_L24:
        f7 = a();
        f13 = a();
        f10 = a();
        f4 = a();
        f7 += d;
        f13 += e;
        f10 += d;
        f4 += e;
        ((Path) (obj1)).quadTo(f7, f13, f10, f4);
        ((NodeAttributeBean) (obj2)).setCommand(3);
        ((NodeAttributeBean) (obj2)).setFx(f7);
        ((NodeAttributeBean) (obj2)).setFy(f13);
        ((NodeAttributeBean) (obj2)).setFx1(f10);
        ((NodeAttributeBean) (obj2)).setFy1(f4);
        d = f10;
        e = f4;
          goto _L13
_L12:
        j.addToNodeList(((NodeBean) (obj)));
        continue; /* Loop/switch isn't completed */
_L9:
        int ai[] = null;
        float af[] = null;
        if (node.hasChildNodes())
        {
            NodeList nodelist = node.getChildNodes();
            int i3 = nodelist.getLength();
            int l1 = 0;
            int ai2[] = new int[(i3 - 1) / 2];
            float af2[] = new float[(i3 - 1) / 2];
            int k2 = 0;
            do
            {
                ai = ai2;
                af = af2;
                if (k2 >= i3)
                {
                    break;
                }
                ai = nodelist.item(k2);
                if (!"#text".equals(ai.getNodeName()))
                {
                    af2[l1] = Float.parseFloat(((Element)ai).getAttribute("offset"));
                    g = ((Element)ai).getAttribute("style");
                    a = g.indexOf("stop-color:");
                    if (a >= 0)
                    {
                        g = g.substring(a + 11);
                        g = g.trim();
                        int k3 = g.indexOf(';');
                        if (k3 > 0)
                        {
                            g = g.substring(0, k3);
                        }
                        ai2[l1] = Color.parseColor(g);
                    }
                    g = ((Element)ai).getAttribute("style");
                    a = g.indexOf("stop-opacity:");
                    if (a >= 0)
                    {
                        g = g.substring(a + 13);
                        g = g.trim();
                        int l3 = g.indexOf(';');
                        if (l3 > 0)
                        {
                            g = g.substring(0, l3);
                        }
                        l3 = Math.round(Float.parseFloat(g) * 255F);
                        ai2[l1] = ai2[l1] & 0xffffff;
                        ai2[l1] = l3 << 24 | ai2[l1];
                    }
                    l1++;
                }
                k2++;
            } while (true);
        }
        GradientBean gradientbean = new GradientBean(Float.parseFloat(((Element)node).getAttribute("cx")), Float.parseFloat(((Element)node).getAttribute("cy")), 0.0F, 0.0F, Float.parseFloat(((Element)node).getAttribute("r")), ai, af, 2);
        g = ((Element)node).getAttribute("gradientTransform");
        a = g.indexOf("matrix(");
        if (a >= 0)
        {
            g = g.substring(a + 7);
            StringTokenizer stringtokenizer = new StringTokenizer(g, " ,)");
            float f2 = Float.parseFloat(stringtokenizer.nextToken());
            float f5 = Float.parseFloat(stringtokenizer.nextToken());
            float f8 = Float.parseFloat(stringtokenizer.nextToken());
            float f11 = Float.parseFloat(stringtokenizer.nextToken());
            gradientbean.setGradientTransformMatrix(new float[] {
                f2, f8, Float.parseFloat(stringtokenizer.nextToken()), f5, f11, Float.parseFloat(stringtokenizer.nextToken()), 0.0F, 0.0F, 1.0F
            });
        }
        g = ((Element)node).getAttribute("id");
        j.addToGradientCollection(g, gradientbean);
        continue; /* Loop/switch isn't completed */
_L10:
        int ai1[] = null;
        float af1[] = null;
        if (node.hasChildNodes())
        {
            NodeList nodelist1 = node.getChildNodes();
            int j3 = nodelist1.getLength();
            int ai3[] = new int[(j3 - 1) / 2];
            float af3[] = new float[(j3 - 1) / 2];
            int i2 = 0;
            int l2 = 0;
            do
            {
                ai1 = ai3;
                af1 = af3;
                if (l2 >= j3)
                {
                    break;
                }
                ai1 = nodelist1.item(l2);
                if (!"#text".equals(ai1.getNodeName()))
                {
                    af3[i2] = Float.parseFloat(((Element)ai1).getAttribute("offset"));
                    g = ((Element)ai1).getAttribute("style");
                    a = g.indexOf("stop-color:");
                    if (a >= 0)
                    {
                        g = g.substring(a + 11);
                        g = g.trim();
                        int i4 = g.indexOf(';');
                        if (i4 > 0)
                        {
                            g = g.substring(0, i4);
                        }
                        ai3[i2] = Color.parseColor(g);
                    }
                    g = ((Element)ai1).getAttribute("style");
                    a = g.indexOf("stop-opacity:");
                    if (a >= 0)
                    {
                        g = g.substring(a + 13);
                        g = g.trim();
                        int j4 = g.indexOf(';');
                        if (j4 > 0)
                        {
                            g = g.substring(0, j4);
                        }
                        j4 = Math.round(Float.parseFloat(g) * 255F);
                        ai3[i2] = ai3[i2] & 0xffffff;
                        ai3[i2] = j4 << 24 | ai3[i2];
                    }
                    i2++;
                }
                l2++;
            } while (true);
        }
        GradientBean gradientbean1 = new GradientBean(Float.parseFloat(((Element)node).getAttribute("x1")), Float.parseFloat(((Element)node).getAttribute("y1")), Float.parseFloat(((Element)node).getAttribute("x2")), Float.parseFloat(((Element)node).getAttribute("y2")), 0.0F, ai1, af1, 1);
        g = ((Element)node).getAttribute("gradientTransform");
        a = g.indexOf("matrix(");
        if (a >= 0)
        {
            g = g.substring(a + 7);
            StringTokenizer stringtokenizer1 = new StringTokenizer(g, " ,)");
            float f3 = Float.parseFloat(stringtokenizer1.nextToken());
            float f6 = Float.parseFloat(stringtokenizer1.nextToken());
            float f9 = Float.parseFloat(stringtokenizer1.nextToken());
            float f12 = Float.parseFloat(stringtokenizer1.nextToken());
            gradientbean1.setGradientTransformMatrix(new float[] {
                f3, f9, Float.parseFloat(stringtokenizer1.nextToken()), f6, f12, Float.parseFloat(stringtokenizer1.nextToken()), 0.0F, 0.0F, 1.0F
            });
        }
        g = ((Element)node).getAttribute("id");
        j.addToGradientCollection(g, gradientbean1);
        if (true) goto _L6; else goto _L27
_L27:
        return;
        if (true) goto _L1; else goto _L28
_L28:
    }

    private void b(Node node)
    {
        if (!"svg".equals(node.getNodeName())) goto _L2; else goto _L1
_L1:
        String s1;
        String s = ((Element)node).getAttribute("width");
        s1 = ((Element)node).getAttribute("height");
        g = ((Element)node).getAttribute("dist");
        g = g.trim();
        try
        {
            j.setDistance(Float.parseFloat(g));
        }
        catch (NumberFormatException numberformatexception)
        {
            (new StringBuilder("Exception on parsing dist: ")).append(numberformatexception.getMessage());
        }
        g = ((Element)node).getAttribute("pDist");
        g = g.trim();
        try
        {
            j.setPerpendicularDistance(Float.parseFloat(g));
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            (new StringBuilder("Exception on parsing pDist: ")).append(node.getMessage());
        }
        a = s.indexOf("px");
        if (a >= 0)
        {
            s = s.substring(0, a);
            try
            {
                h = Float.parseFloat(s);
            }
            // Misplaced declaration of an exception variable
            catch (Node node)
            {
                h = 0.0F;
            }
            node = s;
            if (s.indexOf(".") > 0)
            {
                node = s.substring(0, s.indexOf("."));
            }
            h = Short.parseShort(node);
        } else
        {
            a = s.indexOf("inch");
            if (a >= 0)
            {
                h = Short.parseShort(s.substring(0, a));
                h = h * 120F;
            }
        }
        a = s1.indexOf("px");
        if (a < 0) goto _L4; else goto _L3
_L3:
        s = s1.substring(0, a);
        try
        {
            i = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (Node node)
        {
            i = 0.0F;
        }
        node = s;
        if (s.indexOf(".") > 0)
        {
            node = s.substring(0, s.indexOf("."));
        }
        i = Short.parseShort(node);
_L6:
        return;
_L4:
        a = s1.indexOf("inch");
        if (a >= 0)
        {
            i = Short.parseShort(s1.substring(0, a));
            i = i * 120F;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (node.hasChildNodes())
        {
            node = node.getChildNodes();
            int l = node.getLength();
            int k = 0;
            while (k < l) 
            {
                b(node.item(k));
                k++;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean a(InputStream inputstream, SvgBean svgbean)
    {
        j = svgbean;
        inputstream = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputstream).getDocumentElement();
        b(inputstream);
        svgbean.setOriginalHeight(i);
        svgbean.setOriginalWidth(h);
        a(((Node) (inputstream)));
        return true;
        inputstream;
_L2:
        (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage());
        return false;
        inputstream;
        continue; /* Loop/switch isn't completed */
        inputstream;
        continue; /* Loop/switch isn't completed */
        inputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
