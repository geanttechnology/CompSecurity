// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, TreeBuilder, Token, HtmlTreeBuilder

static final class it> extends HtmlTreeBuilderState
{

    private boolean anythingElse(Token token, TreeBuilder treebuilder)
    {
        if (treebuilder.process(new it>("colgroup")))
        {
            return treebuilder.process(token);
        } else
        {
            return true;
        }
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (HtmlTreeBuilderState.access$100(token))
        {
            htmltreebuilder.insert(token.asCharacter());
        } else
        {
            switch (.SwitchMap.org.jsoup.parser.Token.TokenType[token.type.pe()])
            {
            case 5: // '\005'
            default:
                return anythingElse(token, htmltreebuilder);

            case 1: // '\001'
                htmltreebuilder.insert(token.asComment());
                return true;

            case 2: // '\002'
                htmltreebuilder.error(this);
                return true;

            case 3: // '\003'
                it> it> = token.asStartTag();
                String s = it>.anythingElse();
                if (s.equals("html"))
                {
                    return htmltreebuilder.process(token, InBody);
                }
                if (s.equals("col"))
                {
                    htmltreebuilder.insertEmpty(it>);
                    return true;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }

            case 4: // '\004'
                if (token.asEndTag().anythingElse().equals("colgroup"))
                {
                    if (htmltreebuilder.currentElement().nodeName().equals("html"))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    } else
                    {
                        htmltreebuilder.pop();
                        htmltreebuilder.transition(InTable);
                        return true;
                    }
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }

            case 6: // '\006'
                break;
            }
            if (!htmltreebuilder.currentElement().nodeName().equals("html"))
            {
                return anythingElse(token, htmltreebuilder);
            }
        }
        return true;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
