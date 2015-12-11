// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class PaginationResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
{

    public int totalEntries;
    public int totalPages;

    public PaginationResultElement()
    {
        totalPages = 0;
        totalEntries = 0;
    }

    public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("TotalNumberOfEntries".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final PaginationResultElement this$0;

                protected void setValue(int i)
                    throws SAXException
                {
                    totalEntries = i;
                }

            
            {
                this$0 = PaginationResultElement.this;
                super();
            }
            };
        }
        if ("TotalNumberOfPages".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final PaginationResultElement this$0;

                protected void setValue(int i)
                    throws SAXException
                {
                    totalPages = i;
                }

            
            {
                this$0 = PaginationResultElement.this;
                super();
            }
            };
        } else
        {
            return super.get(s, s1, s2, attributes);
        }
    }
}
