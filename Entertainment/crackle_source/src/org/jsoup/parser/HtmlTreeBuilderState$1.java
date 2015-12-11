// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;

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
            token = token.asDoctype();
            DocumentType documenttype = new DocumentType(token._mth100(), token.Identifier(), token.Identifier(), htmltreebuilder.getBaseUri());
            htmltreebuilder.getDocument().appendChild(documenttype);
            if (token.irks())
            {
                htmltreebuilder.getDocument().quirksMode(org.jsoup.nodes.rks);
            }
            htmltreebuilder.transition(BeforeHtml);
            return true;
        } else
        {
            htmltreebuilder.transition(BeforeHtml);
            return htmltreebuilder.process(token);
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
