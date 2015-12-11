// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import java.lang.reflect.Field;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.common.net:
//            PaginationElement

private static final class field extends com.ebay.nautilus.kernel.util.
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

    public nt(Object obj, Field field1)
    {
        object = obj;
        field = field1;
    }
}
