// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, Token, HtmlTreeBuilder

static final class nit> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (!token.isCharacter()) goto _L2; else goto _L1
_L1:
        htmltreebuilder.insert(token.asCharacter());
_L4:
        return true;
_L2:
        if (token.isEOF())
        {
            htmltreebuilder.error(this);
            htmltreebuilder.pop();
            htmltreebuilder.transition(htmltreebuilder.originalState());
            return htmltreebuilder.process(token);
        }
        if (token.isEndTag())
        {
            htmltreebuilder.pop();
            htmltreebuilder.transition(htmltreebuilder.originalState());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
