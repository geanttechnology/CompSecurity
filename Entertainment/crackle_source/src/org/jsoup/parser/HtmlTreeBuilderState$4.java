// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, TreeBuilder, Token, HtmlTreeBuilder, 
//            TokeniserState, Tokeniser

static final class nit> extends HtmlTreeBuilderState
{

    private boolean anythingElse(Token token, TreeBuilder treebuilder)
    {
        treebuilder.process(new nit>("head"));
        return treebuilder.process(token);
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (!HtmlTreeBuilderState.access$100(token)) goto _L2; else goto _L1
_L1:
        htmltreebuilder.insert(token.asCharacter());
_L4:
        return true;
_L2:
        switch (..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.()])
        {
        default:
            return anythingElse(token, htmltreebuilder);

        case 1: // '\001'
            htmltreebuilder.insert(token.asComment());
            return true;

        case 2: // '\002'
            htmltreebuilder.error(this);
            return false;

        case 3: // '\003'
            nit> nit> = token.asStartTag();
            String s = nit>.anythingElse();
            if (s.equals("html"))
            {
                return InBody.process(token, htmltreebuilder);
            }
            if (StringUtil.in(s, new String[] {
    "base", "basefont", "bgsound", "command", "link"
}))
            {
                token = htmltreebuilder.insertEmpty(nit>);
                if (s.equals("base") && token.hasAttr("href"))
                {
                    htmltreebuilder.maybeSetBaseUri(token);
                    return true;
                }
            } else
            {
                if (s.equals("meta"))
                {
                    htmltreebuilder.insertEmpty(nit>);
                    return true;
                }
                if (s.equals("title"))
                {
                    HtmlTreeBuilderState.access$200(nit>, htmltreebuilder);
                    return true;
                }
                if (StringUtil.in(s, new String[] {
    "noframes", "style"
}))
                {
                    HtmlTreeBuilderState.access$300(nit>, htmltreebuilder);
                    return true;
                }
                if (s.equals("noscript"))
                {
                    htmltreebuilder.insert(nit>);
                    htmltreebuilder.transition(InHeadNoscript);
                    return true;
                }
                if (s.equals("script"))
                {
                    htmltreebuilder.insert(nit>);
                    htmltreebuilder.tokeniser.transition(TokeniserState.ScriptData);
                    htmltreebuilder.markInsertionMode();
                    htmltreebuilder.transition(Text);
                    return true;
                }
                if (s.equals("head"))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
            }
            break;

        case 4: // '\004'
            String s1 = token.asEndTag().anythingElse();
            if (s1.equals("head"))
            {
                htmltreebuilder.pop();
                htmltreebuilder.transition(AfterHead);
                return true;
            }
            if (StringUtil.in(s1, new String[] {
    "body", "html", "br"
}))
            {
                return anythingElse(token, htmltreebuilder);
            } else
            {
                htmltreebuilder.error(this);
                return false;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
