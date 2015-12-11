// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, HtmlTreeBuilder, Token

static final class nit> extends HtmlTreeBuilderState
{

    private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        htmltreebuilder.process(new ("body"));
        htmltreebuilder.framesetOk(true);
        return htmltreebuilder.process(token);
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (HtmlTreeBuilderState.access$100(token))
        {
            htmltreebuilder.insert(token.asCharacter());
        } else
        if (token.isComment())
        {
            htmltreebuilder.insert(token.asComment());
        } else
        if (token.isDoctype())
        {
            htmltreebuilder.error(this);
        } else
        if (token.isStartTag())
        {
              = token.asStartTag();
            String s = ._mth100();
            if (s.equals("html"))
            {
                return htmltreebuilder.process(token, InBody);
            }
            if (s.equals("body"))
            {
                htmltreebuilder.insert();
                htmltreebuilder.framesetOk(false);
                htmltreebuilder.transition(InBody);
            } else
            if (s.equals("frameset"))
            {
                htmltreebuilder.insert();
                htmltreebuilder.transition(InFrameset);
            } else
            if (StringUtil.in(s, new String[] {
    "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title"
}))
            {
                htmltreebuilder.error(this);
                org.jsoup.nodes.Element element = htmltreebuilder.getHeadElement();
                htmltreebuilder.push(element);
                htmltreebuilder.process(token, InHead);
                htmltreebuilder.removeFromStack(element);
            } else
            {
                if (s.equals("head"))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                anythingElse(token, htmltreebuilder);
            }
        } else
        if (token.isEndTag())
        {
            if (StringUtil.in(token.asEndTag().anythingElse(), new String[] {
    "body", "html"
}))
            {
                anythingElse(token, htmltreebuilder);
            } else
            {
                htmltreebuilder.error(this);
                return false;
            }
        } else
        {
            anythingElse(token, htmltreebuilder);
        }
        return true;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
