// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.model;

import com.perfectcorp.utility.e;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.perfectcorp.model:
//            c

public abstract class b
{

    public b()
    {
    }

    public static Object a(Class class1, String s)
    {
        Object obj = null;
        if (class1 != null && s != null) goto _L2; else goto _L1
_L1:
        if (class1 == null) goto _L4; else goto _L3
_L3:
        class1 = ((Class) (class1.newInstance()));
_L6:
        return class1;
        class1;
        e.e(new Object[] {
            class1
        });
_L4:
        class1 = null;
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        class1 = ((Class) (a(class1, (Element)DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(s.getBytes(Charset.defaultCharset()))).getElementsByTagName(class1.getSimpleName().toLowerCase(Locale.US)).item(0))));
        return class1;
        Exception exception;
        exception;
        class1 = obj;
        if (e.a)
        {
            e.a(new Object[] {
                exception, "; (", s, ")"
            });
            return null;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object a(Class class1, Element element)
    {
        Object obj;
        int i;
        int j;
        try
        {
            obj = class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            e.e(new Object[] {
                class1
            });
            return null;
        }
        if (element == null || class1 == null)
        {
            return obj;
        }
        class1 = class1.getFields();
        j = class1.length;
        i = 0;
_L2:
        Exception exception;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        exception = class1[i];
        int k = exception.getModifiers();
        if (Modifier.isPublic(k) && !Modifier.isStatic(k) && !Modifier.isTransient(k))
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s;
        Class class2;
        s = exception.getName();
        class2 = exception.getType();
        if (!com/perfectcorp/model/c.isAssignableFrom(class2))
        {
            break MISSING_BLOCK_LABEL_196;
        }
        exception.set(obj, class2.getConstructor(new Class[] {
            java/lang/String
        }).newInstance(new Object[] {
            element.getAttribute(s)
        }));
          goto _L3
        try
        {
            throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class2.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        if (e.a)
        {
            e.a(new Object[] {
                "Parse fail: fieldType: ", class2, "; fieldName:", s
            });
        }
          goto _L3
label0:
        {
            if (!class2.equals(java/lang/String))
            {
                break label0;
            }
            exception.set(obj, element.getTextContent());
        }
          goto _L3
label1:
        {
            if (!com/perfectcorp/model/b.isAssignableFrom(class2))
            {
                break label1;
            }
            exception.set(obj, a(class2, (Element)element.getElementsByTagName(s).item(0)));
        }
          goto _L3
label2:
        {
            if (!class2.equals(java/util/ArrayList))
            {
                break label2;
            }
            class3 = (Class)((ParameterizedType)exception.getGenericType()).getActualTypeArguments()[0];
            exception.set(obj, a(class3, element.getElementsByTagName(class3.getSimpleName().toLowerCase(Locale.US))));
        }
          goto _L3
        return obj;
          goto _L3
    }

    public static String a(b b1)
    {
        Object obj;
        try
        {
            obj = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            ((Document) (obj)).appendChild(a(b1, ((Document) (obj))));
            obj = new DOMSource(((Node) (obj)));
            StringWriter stringwriter = new StringWriter();
            StreamResult streamresult = new StreamResult(stringwriter);
            TransformerFactory.newInstance().newTransformer().transform(((javax.xml.transform.Source) (obj)), streamresult);
            obj = stringwriter.toString();
        }
        catch (Exception exception)
        {
            if (e.a)
            {
                e.a(new Object[] {
                    exception, "; ", b1.getClass()
                });
            }
            return null;
        }
        return ((String) (obj));
    }

    public static ArrayList a(Class class1, NodeList nodelist)
    {
        ArrayList arraylist = new ArrayList();
        if (nodelist == null || class1 == null || !com/perfectcorp/model/b.isAssignableFrom(class1))
        {
            return arraylist;
        }
        int i = 0;
        while (i < nodelist.getLength()) 
        {
            Object obj = nodelist.item(i);
            if (obj != null && ((Node) (obj)).getNodeType() == 1)
            {
                obj = (Element)obj;
                if (((Element) (obj)).getTagName().equalsIgnoreCase(class1.getSimpleName()))
                {
                    try
                    {
                        arraylist.add(a(class1, ((Element) (obj))));
                    }
                    catch (Exception exception)
                    {
                        if (e.a)
                        {
                            e.a(new Object[] {
                                exception, "; ", Integer.valueOf(i)
                            });
                        }
                    }
                }
            }
            i++;
        }
        return arraylist;
    }

    public static Element a(b b1, String s, Document document)
    {
        if (document != null && b1 != null) goto _L2; else goto _L1
_L1:
        Class class1;
        return null;
_L2:
        if ((class1 = b1.getClass()) == null) goto _L1; else goto _L3
_L3:
        Field afield[];
        int i;
        int j;
        s = document.createElement(s);
        afield = class1.getFields();
        if (afield == null)
        {
            return s;
        }
        j = afield.length;
        i = 0;
_L5:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        obj = afield[i];
        int k = ((Field) (obj)).getModifiers();
        if (Modifier.isPublic(k) && !Modifier.isStatic(k) && !Modifier.isTransient(k))
        {
            break; /* Loop/switch isn't completed */
        }
_L7:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        String s1;
        Class class2;
        s1 = ((Field) (obj)).getName();
        class2 = ((Field) (obj)).getType();
        Object obj1 = ((Field) (obj)).get(b1);
        if (obj1 == null) goto _L7; else goto _L6
_L6:
        if (!com/perfectcorp/model/c.isAssignableFrom(class2))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        s.setAttribute(s1, ((c)obj1).toString());
          goto _L7
        try
        {
            throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class2.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (e.a)
        {
            e.a(new Object[] {
                obj, "; ", class1, "; ", class2, " ", s1
            });
        }
          goto _L7
label0:
        {
            if (!class2.equals(java/lang/String))
            {
                break label0;
            }
            s.setTextContent((String)obj1);
        }
          goto _L7
label1:
        {
            if (!com/perfectcorp/model/b.isAssignableFrom(class2))
            {
                break label1;
            }
            s.appendChild(a((b)obj1, s1, document));
        }
          goto _L7
label2:
        {
            if (!class2.equals(java/util/ArrayList))
            {
                break label2;
            }
            a((ArrayList)((Field) (obj)).get(b1), ((Element) (s)));
        }
          goto _L7
        return s;
          goto _L7
    }

    public static Element a(b b1, Document document)
    {
        return a(b1, b1.getClass().getSimpleName().toLowerCase(Locale.US), document);
    }

    public static void a(ArrayList arraylist, Element element)
    {
_L2:
        return;
        if (arraylist == null || arraylist.isEmpty() || element == null || !com/perfectcorp/model/b.isAssignableFrom(arraylist.get(0).getClass())) goto _L2; else goto _L1
_L1:
        Document document = element.getOwnerDocument();
        if (document != null)
        {
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                element.appendChild(a((b)arraylist.next(), document));
            }
        }
        if (true) goto _L2; else goto _L3
_L3:
    }

    public String toString()
    {
        return a(this);
    }
}
