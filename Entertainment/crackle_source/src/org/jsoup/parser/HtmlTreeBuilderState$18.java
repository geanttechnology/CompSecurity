// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, HtmlTreeBuilder, Token

static final class it> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (HtmlTreeBuilderState.access$100(token))
        {
            return htmltreebuilder.process(token, InBody);
        }
        if (!token.isComment()) goto _L2; else goto _L1
_L1:
        htmltreebuilder.insert(token.asComment());
_L4:
        return true;
_L2:
        if (token.isDoctype())
        {
            htmltreebuilder.error(this);
            return false;
        }
        if (token.isStartTag() && token.asStartTag().InBody().equals("html"))
        {
            return htmltreebuilder.process(token, InBody);
        }
        if (!token.isEndTag() || !token.asEndTag().InBody().equals("html"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (htmltreebuilder.isFragmentParsing())
        {
            htmltreebuilder.error(this);
            return false;
        }
        htmltreebuilder.transition(AfterAfterBody);
        if (true) goto _L4; else goto _L3
_L3:
        if (token.isEOF()) goto _L4; else goto _L5
_L5:
        htmltreebuilder.error(this);
        htmltreebuilder.transition(InBody);
        return htmltreebuilder.process(token);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
