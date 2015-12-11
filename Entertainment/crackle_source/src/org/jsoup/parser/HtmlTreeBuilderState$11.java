// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, Token, HtmlTreeBuilder

static final class it> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (token.isEndTag() && token.asEndTag().it>().equals("caption"))
        {
            if (!htmltreebuilder.inTableScope(token.asEndTag().cope()))
            {
                htmltreebuilder.error(this);
                return false;
            }
            htmltreebuilder.generateImpliedEndTags();
            if (!htmltreebuilder.currentElement().nodeName().equals("caption"))
            {
                htmltreebuilder.error(this);
            }
            htmltreebuilder.popStackToClose("caption");
            htmltreebuilder.clearFormattingElementsToLastMarker();
            htmltreebuilder.transition(InTable);
        } else
        if (token.isStartTag() && StringUtil.in(token.asStartTag().InTable(), new String[] {
    "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"
}) || token.isEndTag() && token.asEndTag().InTable().equals("table"))
        {
            htmltreebuilder.error(this);
            if (htmltreebuilder.process(new InTable("caption")))
            {
                return htmltreebuilder.process(token);
            }
        } else
        if (token.isEndTag() && StringUtil.in(token.asEndTag().InTable(), new String[] {
    "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"
}))
        {
            htmltreebuilder.error(this);
            return false;
        } else
        {
            return htmltreebuilder.process(token, InBody);
        }
        return true;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
