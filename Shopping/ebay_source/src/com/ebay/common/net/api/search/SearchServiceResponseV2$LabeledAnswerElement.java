// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class dItems extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.net.api.search.wiremodel.wer labeledAnswer;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("id".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.LabeledAnswerElement this$1;

                public void setValue(long l)
                    throws SAXException
                {
                    labeledAnswer.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV2.LabeledAnswerElement.this;
                super();
            }
            };
        }
        if ("impression".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.LabeledAnswerElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    labeledAnswer.impression = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.LabeledAnswerElement.this;
                super();
            }
            };
        }
        if ("item".equals(s1))
        {
            s = new com.ebay.common.net.api.search.wiremodel.wer();
            labeledAnswer.wer.add(s);
            return new nit>(SearchServiceResponseV2.this, s);
        }
        if ("label".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.LabeledAnswerElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    labeledAnswer.label = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.LabeledAnswerElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    _cls3.this._cls1(com.ebay.common.net.api.search.wiremodel. )
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        labeledAnswer = ;
        .wer = new ArrayList();
    }
}
