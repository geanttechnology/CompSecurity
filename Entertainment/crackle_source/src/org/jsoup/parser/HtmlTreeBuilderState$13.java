// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, HtmlTreeBuilder, Token

static final class it> extends HtmlTreeBuilderState
{

    private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        return htmltreebuilder.process(token, InTable);
    }

    private boolean exitTableBody(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (!htmltreebuilder.inTableScope("tbody") && !htmltreebuilder.inTableScope("thead") && !htmltreebuilder.inScope("tfoot"))
        {
            htmltreebuilder.error(this);
            return false;
        } else
        {
            htmltreebuilder.clearStackToTableBodyContext();
            htmltreebuilder.process(new ckToTableBodyContext(htmltreebuilder.currentElement().nodeName()));
            return htmltreebuilder.process(token);
        }
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        .SwitchMap.org.jsoup.parser.Token.TokenType[token.type.pe()];
        JVM INSTR tableswitch 3 4: default 32
    //                   3 39
    //                   4 183;
           goto _L1 _L2 _L3
_L1:
        return anythingElse(token, htmltreebuilder);
_L2:
        Object obj;
        String s;
        obj = token.asStartTag();
        s = ((anythingElse) (obj)).anythingElse();
        if (!s.equals("tr")) goto _L5; else goto _L4
_L4:
        htmltreebuilder.clearStackToTableBodyContext();
        htmltreebuilder.insert(((ckToTableBodyContext) (obj)));
        htmltreebuilder.transition(InRow);
_L7:
        return true;
_L5:
        if (StringUtil.in(s, new String[] {
    "th", "td"
}))
        {
            htmltreebuilder.error(this);
            htmltreebuilder.process(new InRow("tr"));
            return htmltreebuilder.process(((Token) (obj)));
        }
        if (StringUtil.in(s, new String[] {
    "caption", "col", "colgroup", "tbody", "tfoot", "thead"
}))
        {
            return exitTableBody(token, htmltreebuilder);
        } else
        {
            return anythingElse(token, htmltreebuilder);
        }
_L3:
        obj = token.asEndTag().anythingElse();
        if (!StringUtil.in(((String) (obj)), new String[] {
    "tbody", "tfoot", "thead"
}))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!htmltreebuilder.inTableScope(((String) (obj))))
        {
            htmltreebuilder.error(this);
            return false;
        }
        htmltreebuilder.clearStackToTableBodyContext();
        htmltreebuilder.pop();
        htmltreebuilder.transition(InTable);
        if (true) goto _L7; else goto _L6
_L6:
        if (((String) (obj)).equals("table"))
        {
            return exitTableBody(token, htmltreebuilder);
        }
        if (StringUtil.in(((String) (obj)), new String[] {
    "body", "caption", "col", "colgroup", "html", "td", "th", "tr"
}))
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
