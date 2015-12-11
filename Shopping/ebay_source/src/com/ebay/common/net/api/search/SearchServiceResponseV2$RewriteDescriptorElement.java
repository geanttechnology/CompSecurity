// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class  extends com.ebay.nautilus.kernel.util.
{

    final expansionResult expansionResult;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 5: default 56
    //                   -1077049240: 147
    //                   3357091: 117
    //                   3575610: 162
    //                   954925063: 102
    //                   1862736958: 132;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_162;
_L7:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new lement(SearchServiceResponseV2.this, expansionResult.);

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteDescriptorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    expansionResult.rewriteDescriptor.mode = SearchExpansion.ExpansionResult.RewriteMode.valueOf(s3.toUpperCase(Locale.US));
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorElement.this;
                super();
            }
            };

        case 2: // '\002'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteDescriptorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if ("promoted_full".equals(s3))
                    {
                        expansionResult.rewriteDescriptor.isPromoted = true;
                        return;
                    } else
                    {
                        expansionResult.rewriteDescriptor.isPromoted = false;
                        return;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorElement.this;
                super();
            }
            };

        case 3: // '\003'
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final SearchServiceResponseV2.RewriteDescriptorElement this$1;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    expansionResult.rewriteDescriptor.isRecourseType = flag;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorElement.this;
                super();
            }
            };

        case 4: // '\004'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteDescriptorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    expansionResult.rewriteDescriptor.type = SearchExpansion.ExpansionResult.RewriteType.valueOf(s3.toUpperCase(Locale.US));
                    if ("spell_check".equals(s3) || "category_constraint".equals(s3) || "spell_auto_correct".equals(s3))
                    {
                        expansionResult.isRecoursable = true;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorElement.this;
                super();
            }
            };
        }
_L5:
        if (s1.equals("message"))
        {
            byte0 = 0;
        }
          goto _L7
_L3:
        if (s1.equals("mode"))
        {
            byte0 = 1;
        }
          goto _L7
_L6:
        if (s1.equals("promotedToMainResults"))
        {
            byte0 = 2;
        }
          goto _L7
_L2:
        if (s1.equals("recourseType"))
        {
            byte0 = 3;
        }
          goto _L7
        if (s1.equals("type"))
        {
            byte0 = 4;
        }
          goto _L7
    }

    public _cls4.this._cls1(_cls4.this._cls1 _pcls1)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        expansionResult = _pcls1;
        expansionResult. = new ();
    }
}
