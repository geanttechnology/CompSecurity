// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, Token, HtmlTreeBuilder

static final class it> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (token.isComment())
        {
            htmltreebuilder.insert(token.asComment());
        } else
        {
            if (token.isDoctype() || HtmlTreeBuilderState.access$100(token) || token.isStartTag() && token.asStartTag()._mth100().equals("html"))
            {
                return htmltreebuilder.process(token, InBody);
            }
            if (!token.isEOF())
            {
                if (token.isStartTag() && token.asStartTag().InBody().equals("noframes"))
                {
                    return htmltreebuilder.process(token, InHead);
                } else
                {
                    htmltreebuilder.error(this);
                    return false;
                }
            }
        }
        return true;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
