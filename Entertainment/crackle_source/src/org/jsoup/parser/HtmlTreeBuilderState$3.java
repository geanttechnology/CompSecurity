// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, Token, HtmlTreeBuilder

static final class nit> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (HtmlTreeBuilderState.access$100(token))
        {
            return true;
        }
        if (token.isComment())
        {
            htmltreebuilder.insert(token.asComment());
            return true;
        }
        if (token.isDoctype())
        {
            htmltreebuilder.error(this);
            return false;
        }
        if (token.isStartTag() && token.asStartTag()._mth100().equals("html"))
        {
            return InBody.process(token, htmltreebuilder);
        }
        if (token.isStartTag() && token.asStartTag().ocess().equals("head"))
        {
            htmltreebuilder.setHeadElement(htmltreebuilder.insert(token.asStartTag()));
            htmltreebuilder.transition(InHead);
            return true;
        }
        if (token.isEndTag() && StringUtil.in(token.asEndTag().InHead(), new String[] {
    "head", "body", "html", "br"
}))
        {
            htmltreebuilder.process(new ("head"));
            return htmltreebuilder.process(token);
        }
        if (token.isEndTag())
        {
            htmltreebuilder.error(this);
            return false;
        } else
        {
            htmltreebuilder.process(new ("head"));
            return htmltreebuilder.process(token);
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
