// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, HtmlTreeBuilder, Token

static final class it> extends HtmlTreeBuilderState
{

    private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        return htmltreebuilder.process(token, InBody);
    }

    private void closeCell(HtmlTreeBuilder htmltreebuilder)
    {
        if (htmltreebuilder.inTableScope("td"))
        {
            htmltreebuilder.process(new cope("td"));
            return;
        } else
        {
            htmltreebuilder.process(new cope("th"));
            return;
        }
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (token.isEndTag())
        {
            String s = token.asEndTag().cope();
            if (StringUtil.in(s, new String[] {
    "td", "th"
}))
            {
                if (!htmltreebuilder.inTableScope(s))
                {
                    htmltreebuilder.error(this);
                    htmltreebuilder.transition(InRow);
                    return false;
                }
                htmltreebuilder.generateImpliedEndTags();
                if (!htmltreebuilder.currentElement().nodeName().equals(s))
                {
                    htmltreebuilder.error(this);
                }
                htmltreebuilder.popStackToClose(s);
                htmltreebuilder.clearFormattingElementsToLastMarker();
                htmltreebuilder.transition(InRow);
                return true;
            }
            if (StringUtil.in(s, new String[] {
    "body", "caption", "col", "colgroup", "html"
}))
            {
                htmltreebuilder.error(this);
                return false;
            }
            if (StringUtil.in(s, new String[] {
    "table", "tbody", "tfoot", "thead", "tr"
}))
            {
                if (!htmltreebuilder.inTableScope(s))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    closeCell(htmltreebuilder);
                    return htmltreebuilder.process(token);
                }
            } else
            {
                return anythingElse(token, htmltreebuilder);
            }
        }
        if (token.isStartTag() && StringUtil.in(token.asStartTag().anythingElse(), new String[] {
    "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"
}))
        {
            if (!htmltreebuilder.inTableScope("td") && !htmltreebuilder.inTableScope("th"))
            {
                htmltreebuilder.error(this);
                return false;
            } else
            {
                closeCell(htmltreebuilder);
                return htmltreebuilder.process(token);
            }
        } else
        {
            return anythingElse(token, htmltreebuilder);
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
