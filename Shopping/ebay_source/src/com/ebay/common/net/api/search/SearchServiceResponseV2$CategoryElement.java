// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class category extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.common.model.search.t category;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 6: default 64
    //                   -1989025848: 159
    //                   -1490976132: 189
    //                   3355: 114
    //                   3373707: 129
    //                   102865796: 174
    //                   696548518: 144;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_189;
_L8:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.CategoryElement this$1;

                protected void setValue(long l)
                    throws SAXException
                {
                    category.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.CategoryElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(category.name))
                    {
                        category.name = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
            };

        case 2: // '\002'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.CategoryElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    category.name = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
            };

        case 3: // '\003'
            return new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

                final SearchServiceResponseV2.CategoryElement this$1;

                public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s3, String s4, String s5, Attributes attributes1)
                    throws SAXException
                {
                    if ("id".equals(s4))
                    {
                        return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                            final _cls4 this$2;

                            protected void setValue(long l)
                                throws SAXException
                            {
                                category.parentId = l;
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        };
                    } else
                    {
                        return super.get(s3, s4, s5, attributes1);
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
            };

        case 4: // '\004'
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV2.CategoryElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    category.level = i;
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
            };

        case 5: // '\005'
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final SearchServiceResponseV2.CategoryElement this$1;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    category.isLeaf = flag;
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
            };
        }
_L4:
        if (s1.equals("id"))
        {
            byte0 = 0;
        }
          goto _L8
_L5:
        if (s1.equals("name"))
        {
            byte0 = 1;
        }
          goto _L8
_L7:
        if (s1.equals("localizedName"))
        {
            byte0 = 2;
        }
          goto _L8
_L2:
        if (s1.equals("parentCategory"))
        {
            byte0 = 3;
        }
          goto _L8
_L6:
        if (s1.equals("level"))
        {
            byte0 = 4;
        }
          goto _L8
        if (s1.equals("leafCategory"))
        {
            byte0 = 5;
        }
          goto _L8
    }


    public _cls6.this._cls1(com.ebay.common.model.search.t t)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        category = t;
    }
}
