// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, Token, HtmlTreeBuilder

static final class it> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        boolean flag = false;
        if (token.isStartTag() && StringUtil.in(token.asStartTag().it>(), new String[] {
    "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th"
}))
        {
            htmltreebuilder.error(this);
            htmltreebuilder.process(new it>("select"));
            flag = htmltreebuilder.process(token);
        } else
        if (token.isEndTag() && StringUtil.in(token.asEndTag().it>(), new String[] {
    "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th"
}))
        {
            htmltreebuilder.error(this);
            if (htmltreebuilder.inTableScope(token.asEndTag().cope()))
            {
                htmltreebuilder.process(new cope("select"));
                return htmltreebuilder.process(token);
            }
        } else
        {
            return htmltreebuilder.process(token, InSelect);
        }
        return flag;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
