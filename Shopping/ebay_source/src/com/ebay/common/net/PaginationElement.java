// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import java.lang.reflect.Field;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public final class PaginationElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
{
    private static final class IntegerElement extends com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement
    {

        protected final Field field;
        protected final Object object;

        protected void setValue(int i)
            throws SAXException
        {
            try
            {
                field.setInt(object, i);
                return;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                throw new SAXNotSupportedException(illegalargumentexception.getLocalizedMessage());
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new SAXNotSupportedException(illegalaccessexception.getLocalizedMessage());
            }
        }

        public IntegerElement(Object obj, Field field1)
        {
            object = obj;
            field = field1;
        }
    }


    public int totalEntries;

    public PaginationElement()
    {
        totalEntries = 0;
    }

    public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        Field afield[] = com/ebay/common/net/PaginationElement.getDeclaredFields();
        int j = afield.length;
        for (int i = 0; i < j; i++)
        {
            Field field = afield[i];
            if (field.getName().equals(s1))
            {
                s = field.getType();
                if (s.equals(Integer.TYPE))
                {
                    return new IntegerElement(this, field);
                } else
                {
                    throw new SAXNotRecognizedException((new StringBuilder()).append("type ").append(s.getSimpleName()).append(" not supported for ").append(s1).toString());
                }
            }
        }

        return super.get(s, s1, s2, attributes);
    }
}
