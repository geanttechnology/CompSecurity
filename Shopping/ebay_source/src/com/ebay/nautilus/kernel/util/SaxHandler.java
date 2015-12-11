// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Xml;
import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.ext.DefaultHandler2;

public final class SaxHandler extends DefaultHandler2
{
    public static abstract class BooleanElement extends TextElement
    {

        protected abstract void setValue(boolean flag)
            throws SAXException;

        public void text(String s)
            throws SAXException
        {
            setValue(Boolean.parseBoolean(s));
        }

        public BooleanElement()
        {
        }
    }

    public static abstract class DoubleElement extends TextElement
    {

        protected abstract void setValue(double d)
            throws SAXException;

        public void text(String s)
            throws SAXException
        {
            try
            {
                setValue(Double.parseDouble(s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        public DoubleElement()
        {
        }
    }

    public static class Element
    {

        private static final Element reuseElement = new Element();

        public void endElement()
            throws SAXException
        {
        }

        public Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            return reuseElement;
        }

        public boolean isTextElement()
        {
            return false;
        }

        public void text(String s)
            throws SAXException
        {
        }


        public Element()
        {
        }
    }

    public static abstract class FloatElement extends TextElement
    {

        protected abstract void setValue(float f)
            throws SAXException;

        public void text(String s)
            throws SAXException
        {
            try
            {
                setValue(Float.parseFloat(s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        public FloatElement()
        {
        }
    }

    public static abstract class IntegerElement extends TextElement
    {

        protected abstract void setValue(int i)
            throws SAXException;

        public void text(String s)
            throws SAXException
        {
            try
            {
                setValue(Integer.parseInt(s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        public IntegerElement()
        {
        }
    }

    private static final class Item
    {

        private Item child;
        public Element element;
        public final Item parent;

        public final Item get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            s = element.get(s, s1, s2, attributes);
            if (s == null)
            {
                throw new SAXNotRecognizedException(s1);
            }
            if (child != null)
            {
                child.element = s;
            } else
            {
                child = new Item(this, s);
            }
            return child;
        }

        public Item(Item item, Element element1)
        {
            parent = item;
            element = element1;
            child = null;
        }
    }

    public static abstract class LongElement extends TextElement
    {

        protected abstract void setValue(long l)
            throws SAXException;

        public void text(String s)
            throws SAXException
        {
            try
            {
                setValue(Long.parseLong(s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        public LongElement()
        {
        }
    }

    public static abstract class TextElement extends Element
    {

        public Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            throw new SAXNotRecognizedException(s1);
        }

        public boolean isTextElement()
        {
            return true;
        }

        public abstract void text(String s)
            throws SAXException;

        public TextElement()
        {
        }
    }

    public static abstract class UrlElement extends TextElement
    {

        protected abstract void setValue(URL url)
            throws SAXException;

        public void text(String s)
            throws SAXException
        {
            try
            {
                setValue(new URL(s));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

        public UrlElement()
        {
        }
    }


    private final StringBuilder characterBuilder = new StringBuilder();
    private Item currentItem;
    private final Element root;

    public SaxHandler(Element element)
    {
        currentItem = null;
        root = element;
        if (element == null)
        {
            throw new IllegalArgumentException("root");
        } else
        {
            return;
        }
    }

    public static void parseXml(InputStream inputstream, Element element)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            element = new SaxHandler(element);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
        element.parse(inputstream, android.util.Xml.Encoding.UTF_8);
        inputstream.close();
        return;
        element;
        inputstream.close();
        throw element;
    }

    public static void parseXml(byte abyte0[], Element element)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        parseXml(((InputStream) (new DirectByteArrayInputStream(abyte0))), element);
    }

    public void characters(char ac[], int i, int j)
        throws SAXException
    {
        if (currentItem != null && currentItem.element.isTextElement())
        {
            characterBuilder.append(ac, i, j);
        }
        super.characters(ac, i, j);
    }

    public void endElement(String s, String s1, String s2)
        throws SAXException
    {
        if (characterBuilder.length() != 0)
        {
            currentItem.element.text(characterBuilder.toString());
            characterBuilder.delete(0, characterBuilder.length());
        }
        currentItem.element.endElement();
        currentItem = currentItem.parent;
        super.endElement(s, s1, s2);
    }

    public final void parse(InputStream inputstream, android.util.Xml.Encoding encoding)
        throws IOException, SAXException
    {
        try
        {
            Xml.parse(inputstream, encoding, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.util.Xml.Encoding encoding)
        {
            inputstream = encoding.getLocalizedMessage();
        }
        if (inputstream != null)
        {
            inputstream = new IOException(inputstream);
        } else
        {
            inputstream = new IOException();
        }
        inputstream.initCause(encoding);
        throw inputstream;
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (characterBuilder.length() != 0)
        {
            currentItem.element.text(characterBuilder.toString());
            characterBuilder.delete(0, characterBuilder.length());
        }
        if (currentItem == null)
        {
            currentItem = new Item(null, root);
        } else
        {
            currentItem = currentItem.get(s, s1, s2, attributes);
        }
        super.startElement(s, s1, s2, attributes);
    }
}
