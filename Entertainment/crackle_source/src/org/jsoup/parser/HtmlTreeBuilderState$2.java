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
        htmltreebuilder.insert("html");
        htmltreebuilder.transition(BeforeHead);
        return htmltreebuilder.process(token);
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (token.isDoctype())
        {
            htmltreebuilder.error(this);
            return false;
        }
        if (!token.isComment()) goto _L2; else goto _L1
_L1:
        htmltreebuilder.insert(token.asComment());
_L4:
        return true;
_L2:
        if (HtmlTreeBuilderState.access$100(token))
        {
            return true;
        }
        if (!token.isStartTag() || !token.asStartTag()._mth100().equals("html"))
        {
            break; /* Loop/switch isn't completed */
        }
        htmltreebuilder.insert(token.asStartTag());
        htmltreebuilder.transition(BeforeHead);
        if (true) goto _L4; else goto _L3
_L3:
        if (token.isEndTag() && StringUtil.in(token.asEndTag().BeforeHead(), new String[] {
    "head", "body", "html", "br"
}))
        {
            return anythingElse(token, htmltreebuilder);
        }
        if (token.isEndTag())
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
