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
        if (!HtmlTreeBuilderState.access$100(token)) goto _L2; else goto _L1
_L1:
        htmltreebuilder.insert(token.asCharacter());
_L4:
        return true;
_L2:
        if (token.isComment())
        {
            htmltreebuilder.insert(token.asComment());
            continue; /* Loop/switch isn't completed */
        }
        if (token.isDoctype())
        {
            htmltreebuilder.error(this);
            return false;
        }
        if (token.isStartTag() && token.asStartTag()._mth100().equals("html"))
        {
            return htmltreebuilder.process(token, InBody);
        }
        if (!token.isEndTag() || !token.asEndTag().InBody().equals("html"))
        {
            break; /* Loop/switch isn't completed */
        }
        htmltreebuilder.transition(AfterAfterFrameset);
        if (true) goto _L4; else goto _L3
_L3:
        if (token.isStartTag() && token.asStartTag().AfterAfterFrameset().equals("noframes"))
        {
            return htmltreebuilder.process(token, InHead);
        }
        if (!token.isEOF())
        {
            htmltreebuilder.error(this);
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
