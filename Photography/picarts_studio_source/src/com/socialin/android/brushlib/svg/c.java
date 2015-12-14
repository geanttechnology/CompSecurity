// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.svg;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Referenced classes of package com.socialin.android.brushlib.svg:
//            NodeBean, NodeAttributeBean, SvgBean, GradientBean

public final class c
{

    private int a;
    private int b;
    private float c;
    private Paint d;
    private float e;
    private float f;
    private StringTokenizer g;
    private String h;
    private short i;
    private short j;
    private SvgBean k;

    public c()
    {
        a = 0;
        b = 0;
        c = 255F;
        d = null;
        e = 0.0F;
        f = 0.0F;
        g = null;
        h = null;
        i = 0;
        j = 0;
        k = null;
    }

    private float a()
    {
        for (h = g.nextToken(); ",".equals(h) || " ".equals(h); h = g.nextToken()) { }
        if ("-".equals(h))
        {
            return -1F * Float.parseFloat(g.nextToken());
        } else
        {
            return Float.parseFloat(h);
        }
    }

    private void a(Node node)
    {
        Object obj;
        int l;
        obj = node.getNodeName();
        l = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 60
    //                   -916589195: 228
    //                   103: 180
    //                   3433509: 196
    //                   763377263: 212;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        l;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 244
    //                   1 515
    //                   2 2525
    //                   3 3086;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        if (node.hasChildNodes())
        {
            node = node.getChildNodes();
            int k2 = node.getLength();
            for (l = 0; l < k2; l++)
            {
                obj = node.item(l);
                String s = ((Node) (obj)).getNodeName();
                if (!"#text".equals(s) && !"stop".equals(s))
                {
                    a(((Node) (obj)));
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L3:
        if (((String) (obj)).equals("g"))
        {
            l = 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (((String) (obj)).equals("path"))
        {
            l = 1;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (((String) (obj)).equals("radialGradient"))
        {
            l = 2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (((String) (obj)).equals("linearGradient"))
        {
            l = 3;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        h = ((Element)node).getAttribute("style");
        a = h.indexOf("stroke:");
        if (a >= 0)
        {
            h = h.substring(a + 7);
            h = h.trim();
            int i1 = h.indexOf(';');
            if (i1 > 0)
            {
                h = h.substring(0, i1);
            }
        }
        a = h.indexOf("fill:");
        if (a >= 0)
        {
            h = h.substring(a + 5);
            h = h.trim();
            if (h.startsWith("#"))
            {
                int j1 = h.indexOf(';');
                if (j1 > 0)
                {
                    h = h.substring(0, j1);
                }
                b = Color.parseColor(h);
            }
            if (h.startsWith("none"))
            {
                b = 0;
                d.setStyle(android.graphics.Paint.Style.STROKE);
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
        NodeBean nodebean;
        NodeAttributeBean nodeattributebean;
        obj = new Path();
        ((Path) (obj)).setFillType(android.graphics.Path.FillType.EVEN_ODD);
        d = new Paint();
        if ("".equals(((Element)node).getAttribute("opacity")))
        {
            f1 = c;
        } else
        {
            f1 = Float.parseFloat(((Element)node).getAttribute("opacity"));
        }
        nodebean = new NodeBean();
        h = ((Element)node).getAttribute("style");
        a = h.indexOf("stroke:");
        if (a >= 0)
        {
            h = h.substring(a + 7);
            h = h.trim();
            int k1 = h.indexOf(';');
            if (k1 > 0)
            {
                h = h.substring(0, k1);
            }
            b = Color.parseColor(h);
        }
        a = h.indexOf("fill:");
        if (a >= 0)
        {
            h = h.substring(a + 5);
            h = h.trim();
            if (h.startsWith("#"))
            {
                int l1 = h.indexOf(';');
                if (l1 > 0)
                {
                    h = h.substring(0, l1);
                }
                b = Color.parseColor(h);
            }
            if (h.startsWith("none"))
            {
                b = 0;
                d.setStyle(android.graphics.Paint.Style.STROKE);
            }
            if (h.startsWith("url(#"))
            {
                h = h.substring(a, h.indexOf(")"));
                h = h.substring(1);
                nodebean.setShader(h);
            }
        }
        h = ((Element)node).getAttribute("fill");
        a = h.indexOf("url(");
        if (a >= 0)
        {
            h = h.substring(4, h.indexOf(")"));
            if (h.startsWith("#"))
            {
                h = h.substring(1);
                nodebean.setShader(h);
            }
        }
        h = ((Element)node).getAttribute("stroke");
        h = h.trim();
        if (!"".equals(h))
        {
            nodebean.setStrokeColor(Color.parseColor(h));
        }
        h = ((Element)node).getAttribute("changeable");
        h = h.trim();
        if (!"".equals(h))
        {
            nodebean.setChangable("1".equals(h));
        }
        h = ((Element)node).getAttribute("stroke-width");
        h = h.trim();
        if (!"".equals(h))
        {
            d.setStrokeWidth(Float.parseFloat(h));
        }
        h = ((Element)node).getAttribute("stroke-linecap");
        h = h.trim();
        if (!"".equals(h))
        {
            if ("round".equals(h))
            {
                d.setStrokeCap(android.graphics.Paint.Cap.ROUND);
            }
            if ("butt".equals(h))
            {
                d.setStrokeCap(android.graphics.Paint.Cap.BUTT);
            }
            if ("square".equals(h))
            {
                d.setStrokeCap(android.graphics.Paint.Cap.SQUARE);
            }
        }
        h = ((Element)node).getAttribute("stroke-linejoin");
        h = h.trim();
        if (!"".equals(h))
        {
            if ("round".equals(h))
            {
                d.setStrokeJoin(android.graphics.Paint.Join.ROUND);
            }
            if ("miter".equals(h))
            {
                d.setStrokeJoin(android.graphics.Paint.Join.MITER);
            }
            if ("bevel".equals(h))
            {
                d.setStrokeJoin(android.graphics.Paint.Join.BEVEL);
            }
        }
        h = ((Element)node).getAttribute("d");
        g = new StringTokenizer(h, " ,MmLlCczArSsHhVvDdEeFfGgJjQqTtz-", true);
_L26:
        if (!g.hasMoreElements()) goto _L12; else goto _L11
_L11:
        nodeattributebean = new NodeAttributeBean();
        h = g.nextToken();
        h.charAt(0);
        JVM INSTR lookupswitch 12: default 1500
    //                   67: 1811
    //                   72: 2118
    //                   76: 1691
    //                   77: 1571
    //                   83: 2304
    //                   86: 2211
    //                   99: 1924
    //                   104: 2162
    //                   108: 1743
    //                   109: 1623
    //                   115: 2387
    //                   118: 2255;
           goto _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L13:
        float f4;
        float f7;
        float f10;
        float f13;
        float f16;
        float f17;
        if (f1 > 0.0F && f1 < 255F)
        {
            nodebean.setOpacity((int)(255F * f1));
        } else
        {
            nodebean.setOpacity((int)f1);
        }
        d.setColor(b);
        nodebean.setPaint(d);
        nodebean.addToNodeAttributeBeanList(nodeattributebean);
          goto _L26
_L17:
        f4 = a();
        f7 = a();
        e = f4;
        f = f7;
        ((Path) (obj)).moveTo(f4, f7);
        nodeattributebean.setCommand(1);
        nodeattributebean.setFx(f4);
        nodeattributebean.setFy(f7);
          goto _L13
_L23:
        f7 = a();
        f4 = a();
        f7 += e;
        f4 += f;
        e = f7;
        f = f4;
        ((Path) (obj)).moveTo(f7, f4);
        nodeattributebean.setCommand(1);
        nodeattributebean.setFx(f7);
        nodeattributebean.setFy(f4);
          goto _L13
_L16:
        f4 = a();
        f7 = a();
        e = f4;
        f = f7;
        ((Path) (obj)).lineTo(f4, f7);
        nodeattributebean.setCommand(2);
        nodeattributebean.setFx(f4);
        nodeattributebean.setFy(f7);
          goto _L13
_L22:
        f7 = a();
        f4 = a();
        f7 += e;
        f4 += f;
        e = f7;
        f = f4;
        ((Path) (obj)).lineTo(f7, f4);
        nodeattributebean.setCommand(2);
        nodeattributebean.setFx(f7);
        nodeattributebean.setFy(f4);
          goto _L13
_L14:
        f4 = a();
        f7 = a();
        f10 = a();
        f13 = a();
        f16 = a();
        f17 = a();
        ((Path) (obj)).cubicTo(f4, f7, f10, f13, f16, f17);
        nodeattributebean.setCommand(3);
        nodeattributebean.setFx(f4);
        nodeattributebean.setFy(f7);
        nodeattributebean.setFx1(f10);
        nodeattributebean.setFy1(f13);
        nodeattributebean.setFx2(f16);
        nodeattributebean.setFy2(f17);
        e = f16;
        f = f17;
          goto _L13
_L20:
        f7 = a();
        f13 = a();
        f17 = a();
        f16 = a();
        f10 = a();
        f4 = a();
        f7 = e + f7;
        f13 += f;
        f17 += e;
        f16 += f;
        f10 += e;
        f4 += f;
        ((Path) (obj)).cubicTo(e + f7, f + f13, e + f17, f + f16, e + f10, f + f4);
        nodeattributebean.setCommand(3);
        nodeattributebean.setFx(f7);
        nodeattributebean.setFy(f13);
        nodeattributebean.setFx1(f17);
        nodeattributebean.setFy1(f16);
        nodeattributebean.setFx2(f10);
        nodeattributebean.setFy2(f4);
        e = f10;
        f = f4;
          goto _L13
_L15:
        f4 = a();
        e = f4;
        ((Path) (obj)).lineTo(f4, f);
        nodeattributebean.setCommand(2);
        nodeattributebean.setFx(f4);
        nodeattributebean.setFy(f);
          goto _L13
_L21:
        f4 = a() + e;
        e = f4;
        ((Path) (obj)).lineTo(f4, f);
        nodeattributebean.setCommand(2);
        nodeattributebean.setFx(f4);
        nodeattributebean.setFy(f);
          goto _L13
_L19:
        f4 = a();
        f = f4;
        ((Path) (obj)).lineTo(e, f4);
        nodeattributebean.setCommand(2);
        nodeattributebean.setFx(e);
        nodeattributebean.setFy(f4);
          goto _L13
_L25:
        f4 = a() + f;
        f = f4;
        ((Path) (obj)).lineTo(e, f4);
        nodeattributebean.setCommand(2);
        nodeattributebean.setFx(e);
        nodeattributebean.setFy(f4);
          goto _L13
_L18:
        f4 = a();
        f7 = a();
        f10 = a();
        f13 = a();
        ((Path) (obj)).quadTo(f4, f7, f10, f13);
        nodeattributebean.setCommand(4);
        nodeattributebean.setFx(f4);
        nodeattributebean.setFy(f7);
        nodeattributebean.setFx1(f10);
        nodeattributebean.setFy1(f13);
        e = f10;
        f = f13;
          goto _L13
_L24:
        f7 = a();
        f13 = a();
        f10 = a();
        f4 = a();
        f7 += e;
        f13 += f;
        f10 += e;
        f4 += f;
        ((Path) (obj)).quadTo(f7, f13, f10, f4);
        nodeattributebean.setCommand(4);
        nodeattributebean.setFx(f7);
        nodeattributebean.setFy(f13);
        nodeattributebean.setFx1(f10);
        nodeattributebean.setFy1(f4);
        e = f10;
        f = f4;
          goto _L13
_L12:
        k.addToNodeList(nodebean);
        continue; /* Loop/switch isn't completed */
_L9:
        int ai[] = null;
        float af[] = null;
        if (node.hasChildNodes())
        {
            NodeList nodelist = node.getChildNodes();
            int j3 = nodelist.getLength();
            int i2 = 0;
            int ai2[] = new int[(j3 - 1) / 2];
            float af2[] = new float[(j3 - 1) / 2];
            int l2 = 0;
            do
            {
                ai = ai2;
                af = af2;
                if (l2 >= j3)
                {
                    break;
                }
                ai = nodelist.item(l2);
                if (!"#text".equals(ai.getNodeName()))
                {
                    af2[i2] = Float.parseFloat(((Element)ai).getAttribute("offset"));
                    h = ((Element)ai).getAttribute("style");
                    a = h.indexOf("stop-color:");
                    if (a >= 0)
                    {
                        h = h.substring(a + 11);
                        h = h.trim();
                        int l3 = h.indexOf(';');
                        if (l3 > 0)
                        {
                            h = h.substring(0, l3);
                        }
                        ai2[i2] = Color.parseColor(h);
                    }
                    i2++;
                }
                l2++;
            } while (true);
        }
        GradientBean gradientbean = new GradientBean(Float.parseFloat(((Element)node).getAttribute("cx")), Float.parseFloat(((Element)node).getAttribute("cy")), 0.0F, 0.0F, Float.parseFloat(((Element)node).getAttribute("r")), ai, af, 2);
        h = ((Element)node).getAttribute("gradientTransform");
        a = h.indexOf("matrix(");
        if (a >= 0)
        {
            h = h.substring(a + 7);
            StringTokenizer stringtokenizer = new StringTokenizer(h, " ,)");
            h = stringtokenizer.nextToken();
            float f2 = Float.parseFloat(h);
            h = stringtokenizer.nextToken();
            float f5 = Float.parseFloat(h);
            h = stringtokenizer.nextToken();
            float f8 = Float.parseFloat(h);
            h = stringtokenizer.nextToken();
            float f11 = Float.parseFloat(h);
            h = stringtokenizer.nextToken();
            float f14 = Float.parseFloat(h);
            h = stringtokenizer.nextToken();
            gradientbean.setGradientTransformMatrix(new float[] {
                f2, f8, f14, f5, f11, Float.parseFloat(h), 0.0F, 0.0F, 1.0F
            });
        }
        h = ((Element)node).getAttribute("id");
        k.addToGradientCollection(h, gradientbean);
        continue; /* Loop/switch isn't completed */
_L10:
        int ai1[] = null;
        float af1[] = null;
        if (node.hasChildNodes())
        {
            NodeList nodelist1 = node.getChildNodes();
            int k3 = nodelist1.getLength();
            int ai3[] = new int[(k3 - 1) / 2];
            float af3[] = new float[(k3 - 1) / 2];
            int j2 = 0;
            int i3 = 0;
            do
            {
                ai1 = ai3;
                af1 = af3;
                if (i3 >= k3)
                {
                    break;
                }
                ai1 = nodelist1.item(i3);
                if (!"#text".equals(ai1.getNodeName()))
                {
                    af3[j2] = Float.parseFloat(((Element)ai1).getAttribute("offset"));
                    h = ((Element)ai1).getAttribute("style");
                    a = h.indexOf("stop-color:");
                    if (a >= 0)
                    {
                        h = h.substring(a + 11);
                        h = h.trim();
                        int i4 = h.indexOf(';');
                        if (i4 > 0)
                        {
                            h = h.substring(0, i4);
                        }
                        ai3[j2] = Color.parseColor(h);
                    }
                    j2++;
                }
                i3++;
            } while (true);
        }
        GradientBean gradientbean1 = new GradientBean(Float.parseFloat(((Element)node).getAttribute("x1")), Float.parseFloat(((Element)node).getAttribute("y1")), Float.parseFloat(((Element)node).getAttribute("x2")), Float.parseFloat(((Element)node).getAttribute("y2")), 0.0F, ai1, af1, 1);
        h = ((Element)node).getAttribute("gradientTransform");
        a = h.indexOf("matrix(");
        if (a >= 0)
        {
            h = h.substring(a + 7);
            StringTokenizer stringtokenizer1 = new StringTokenizer(h, " ,)");
            h = stringtokenizer1.nextToken();
            float f3 = Float.parseFloat(h);
            h = stringtokenizer1.nextToken();
            float f6 = Float.parseFloat(h);
            h = stringtokenizer1.nextToken();
            float f9 = Float.parseFloat(h);
            h = stringtokenizer1.nextToken();
            float f12 = Float.parseFloat(h);
            h = stringtokenizer1.nextToken();
            float f15 = Float.parseFloat(h);
            h = stringtokenizer1.nextToken();
            gradientbean1.setGradientTransformMatrix(new float[] {
                f3, f9, f15, f6, f12, Float.parseFloat(h), 0.0F, 0.0F, 1.0F
            });
        }
        h = ((Element)node).getAttribute("id");
        k.addToGradientCollection(h, gradientbean1);
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
        a = s.indexOf("px");
        if (a >= 0)
        {
            s = s.substring(0, a);
            node = s;
            if (s.indexOf(".") > 0)
            {
                node = s.substring(0, s.indexOf("."));
            }
            i = (short)Integer.parseInt(node);
        } else
        {
            a = s.indexOf("inch");
            if (a >= 0)
            {
                i = (short)Integer.parseInt(s.substring(0, a));
                i = (short)(i * 120);
            }
        }
        a = s1.indexOf("px");
        if (a < 0) goto _L4; else goto _L3
_L3:
        s = s1.substring(0, a);
        node = s;
        if (s.indexOf(".") > 0)
        {
            node = s.substring(0, s.indexOf("."));
        }
        j = (short)Integer.parseInt(node);
_L6:
        return;
_L4:
        a = s1.indexOf("inch");
        if (a >= 0)
        {
            j = (short)Integer.parseInt(s1.substring(0, a));
            j = (short)(j * 120);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (node.hasChildNodes())
        {
            node = node.getChildNodes();
            int i1 = node.getLength();
            int l = 0;
            while (l < i1) 
            {
                b(node.item(l));
                l++;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean a(InputStream inputstream, SvgBean svgbean)
    {
        k = svgbean;
        inputstream = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputstream).getDocumentElement();
        b(inputstream);
        svgbean.setOriginalHeight(j);
        svgbean.setOriginalWidth(i);
        svgbean.setCurrentHeight(j);
        svgbean.setCurrentWidth(i);
        a(((Node) (inputstream)));
        return true;
        inputstream;
_L2:
        (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage());
        return false;
        inputstream;
        continue; /* Loop/switch isn't completed */
        inputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
