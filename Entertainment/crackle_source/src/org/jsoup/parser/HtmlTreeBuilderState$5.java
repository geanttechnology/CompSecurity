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
        htmltreebuilder.error(this);
        htmltreebuilder.process(new ("noscript"));
        return htmltreebuilder.process(token);
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (!token.isDoctype()) goto _L2; else goto _L1
_L1:
        htmltreebuilder.error(this);
_L4:
        return true;
_L2:
        if (token.isStartTag() && token.asStartTag().().equals("html"))
        {
            return htmltreebuilder.process(token, InBody);
        }
        if (!token.isEndTag() || !token.asEndTag().InBody().equals("noscript"))
        {
            break; /* Loop/switch isn't completed */
        }
        htmltreebuilder.pop();
        htmltreebuilder.transition(InHead);
        if (true) goto _L4; else goto _L3
_L3:
        if (HtmlTreeBuilderState.access$100(token) || token.isComment() || token.isStartTag() && StringUtil.in(token.asStartTag()._mth100(), new String[] {
    "basefont", "bgsound", "link", "meta", "noframes", "style"
}))
        {
            return htmltreebuilder.process(token, InHead);
        }
        if (token.isEndTag() && token.asEndTag().InHead().equals("br"))
        {
            return anythingElse(token, htmltreebuilder);
        }
        if (token.isStartTag() && StringUtil.in(token.asStartTag().anythingElse(), new String[] {
    "head", "noscript"
}) || token.isEndTag())
        {
            htmltreebuilder.error(this);
            return false;
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
