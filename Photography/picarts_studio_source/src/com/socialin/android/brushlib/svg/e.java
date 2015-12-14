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

public final class e
{

    public Path a;
    public short b;
    public short c;
    private int d;
    private boolean e;
    private int f;
    private float g;
    private float h;
    private StringTokenizer i;
    private String j;
    private String k;

    public e()
    {
        d = 0;
        b = 0;
        c = 0;
        k = null;
    }

    private float a()
    {
        for (j = i.nextToken(); j.equals(",") || j.equals(" "); j = i.nextToken()) { }
        if (j.equals("-"))
        {
            return -1F * Float.parseFloat(i.nextToken());
        } else
        {
            return Float.parseFloat(j);
        }
    }

    private void a(Node node)
    {
        Object obj;
        String s;
        int l;
        obj = new Paint();
        ((Paint) (obj)).setColor(f);
        ((Paint) (obj)).setAntiAlias(true);
        s = node.getNodeName();
        l = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 92
    //                   -1656480802: 218
    //                   103: 250
    //                   3433509: 266
    //                   3496420: 202
    //                   561938880: 234;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        l;
        JVM INSTR tableswitch 0 4: default 128
    //                   0 282
    //                   1 282
    //                   2 282
    //                   3 311
    //                   4 565;
           goto _L7 _L8 _L8 _L8 _L9 _L10
_L7:
        if (node.hasChildNodes())
        {
            node = node.getChildNodes();
            int i2 = node.getLength();
            for (l = 0; l < i2; l++)
            {
                obj = node.item(l);
                if (!((Node) (obj)).getNodeName().equals("#text"))
                {
                    a(((Node) (obj)));
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L5:
        if (s.equals("rect"))
        {
            l = 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("ellipse"))
        {
            l = 1;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("polyline"))
        {
            l = 2;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("g"))
        {
            l = 3;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s.equals("path"))
        {
            l = 4;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (e)
        {
            ((Paint) (obj)).setStyle(android.graphics.Paint.Style.FILL);
        } else
        {
            ((Paint) (obj)).setStyle(android.graphics.Paint.Style.STROKE);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        j = ((Element)node).getAttribute("style");
        d = j.indexOf("stroke:");
        if (d >= 0)
        {
            j = j.substring(d + 7);
            j = j.trim();
            int i1 = j.indexOf(';');
            if (i1 > 0)
            {
                j = j.substring(0, i1);
            }
            f = Color.parseColor(j);
            ((Paint) (obj)).setColor(f);
            e = false;
        }
        d = j.indexOf("fill:");
        if (d >= 0)
        {
            j = j.substring(d + 5);
            j = j.trim();
            if (j.startsWith("#"))
            {
                int j1 = j.indexOf(';');
                if (j1 > 0)
                {
                    j = j.substring(0, j1);
                }
                f = Color.parseColor(j);
            }
            if (j.startsWith("none"))
            {
                f = 0;
            }
            e = true;
            ((Paint) (obj)).setColor(f);
        }
        if (true) goto _L7; else goto _L11
_L10:
        if (k == null) goto _L13; else goto _L12
_L12:
        j = ((Element)node).getAttribute(k);
        j = j.trim();
        if (!j.equals("true")) goto _L11; else goto _L14
_L14:
        a = new Path();
        a.setFillType(android.graphics.Path.FillType.EVEN_ODD);
_L31:
        j = ((Element)node).getAttribute("style");
        d = j.indexOf("stroke:");
        if (d >= 0)
        {
            j = j.substring(d + 7);
            j = j.trim();
            int k1 = j.indexOf(';');
            if (k1 > 0)
            {
                j = j.substring(0, k1);
            }
            f = Color.parseColor(j);
            ((Paint) (obj)).setColor(f);
            e = false;
        }
        d = j.indexOf("fill:");
        if (d >= 0)
        {
            j = j.substring(d + 5);
            j = j.trim();
            if (j.startsWith("#"))
            {
                int l1 = j.indexOf(';');
                if (l1 > 0)
                {
                    j = j.substring(0, l1);
                }
                f = Color.parseColor(j);
            }
            if (j.startsWith("none"))
            {
                f = 0;
            }
            e = true;
            ((Paint) (obj)).setColor(f);
        }
        j = ((Element)node).getAttribute("d");
        i = new StringTokenizer(j, " ,MmLlCczArSsHhVvDdEeFfGgJjQqTtz-", true);
_L30:
        if (!i.hasMoreElements()) goto _L7; else goto _L15
_L15:
        j = i.nextToken();
        j.charAt(0);
        JVM INSTR lookupswitch 12: default 1052
    //                   67: 1055
    //                   72: 1407
    //                   76: 1223
    //                   77: 1145
    //                   83: 1517
    //                   86: 1462
    //                   99: 1301
    //                   104: 1432
    //                   108: 1255
    //                   109: 1177
    //                   115: 1567
    //                   118: 1487;
           goto _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28
_L17:
        float f1 = a();
        float f13 = a();
        float f21 = a();
        float f25 = a();
        float f29 = a();
        float f32 = a();
        a.cubicTo(f1, f13, f21, f25, f29, f32);
        g = f29;
        h = f32;
_L16:
        if (true) goto _L30; else goto _L29
_L29:
_L13:
        a = new Path();
        a.setFillType(android.graphics.Path.FillType.EVEN_ODD);
          goto _L31
_L20:
        float f2 = a();
        float f14 = a();
        g = f2;
        h = f14;
        a.moveTo(f2, f14);
          goto _L30
_L26:
        float f15 = a();
        float f3 = a();
        f15 += g;
        f3 += h;
        g = f15;
        h = f3;
        a.moveTo(f15, f3);
          goto _L30
_L19:
        float f4 = a();
        float f16 = a();
        g = f4;
        h = f16;
        a.lineTo(f4, f16);
          goto _L30
_L25:
        float f17 = a();
        float f5 = a();
        f17 += g;
        f5 += h;
        g = f17;
        h = f5;
        a.lineTo(f17, f5);
          goto _L30
_L23:
        float f6 = a();
        float f18 = a();
        float f22 = a();
        float f26 = a();
        float f30 = a();
        float f33 = a();
        a.cubicTo(f6 + g, f18 + h, f22 + g, f26 + h, g + f30, h + f33);
        g = g + f30;
        h = h + f33;
          goto _L30
_L18:
        float f7 = a();
        g = f7;
        a.lineTo(f7, h);
          goto _L30
_L24:
        float f8 = a() + g;
        g = f8;
        a.lineTo(f8, h);
          goto _L30
_L22:
        float f9 = a();
        h = f9;
        a.lineTo(g, f9);
          goto _L30
_L28:
        float f10 = a() + h;
        h = f10;
        a.lineTo(g, f10);
          goto _L30
_L21:
        float f11 = a();
        float f19 = a();
        float f23 = a();
        float f27 = a();
        a.quadTo(f11, f19, f23, f27);
        g = f23;
        h = f27;
          goto _L30
_L27:
        float f12 = a();
        float f20 = a();
        float f34 = a();
        float f31 = a();
        float f24 = g;
        float f28 = h;
        f34 += g;
        f31 += h;
        a.quadTo(f12 + f24, f20 + f28, f34, f31);
        g = f34;
        h = f31;
          goto _L30
_L11:
        return;
        if (true) goto _L1; else goto _L32
_L32:
    }

    private void b(Node node)
    {
        if (!node.getNodeName().equals("svg")) goto _L2; else goto _L1
_L1:
        String s1;
        String s = ((Element)node).getAttribute("width");
        s1 = ((Element)node).getAttribute("height");
        d = s.indexOf("px");
        if (d >= 0)
        {
            s = s.substring(0, d);
            node = s;
            if (s.indexOf(".") > 0)
            {
                node = s.substring(0, s.indexOf("."));
            }
            b = (short)Integer.parseInt(node);
        } else
        {
            d = s.indexOf("inch");
            if (d >= 0)
            {
                b = (short)Integer.parseInt(s.substring(0, d));
                b = (short)(b * 120);
            }
        }
        d = s1.indexOf("px");
        if (d < 0) goto _L4; else goto _L3
_L3:
        s = s1.substring(0, d);
        node = s;
        if (s.indexOf(".") > 0)
        {
            node = s.substring(0, s.indexOf("."));
        }
        c = (short)Integer.parseInt(node);
_L6:
        return;
_L4:
        d = s1.indexOf("inch");
        if (d >= 0)
        {
            c = (short)Integer.parseInt(s1.substring(0, d));
            c = (short)(c * 120);
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

    public final void a(InputStream inputstream, String s)
    {
        k = s;
        e = false;
        f = 0;
        g = 0.0F;
        h = 0.0F;
        try
        {
            inputstream = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputstream).getDocumentElement();
            b(inputstream);
            a(((Node) (inputstream)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        (new StringBuilder("Got unexpected exception: ")).append(inputstream.getMessage());
    }
}
