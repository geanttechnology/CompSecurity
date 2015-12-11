// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.StringUtil;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, HtmlTreeBuilder, TreeBuilder, Token

static final class it> extends HtmlTreeBuilderState
{

    private boolean anythingElse(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        return htmltreebuilder.process(token, InTable);
    }

    private boolean handleMissingTr(Token token, TreeBuilder treebuilder)
    {
        if (treebuilder.process(new InTable("tr")))
        {
            return treebuilder.process(token);
        } else
        {
            return false;
        }
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        if (!token.isStartTag()) goto _L2; else goto _L1
_L1:
        InTable intable;
        String s1;
        intable = token.asStartTag();
        s1 = intable.InTable();
        if (!StringUtil.in(s1, new String[] {
            "th", "td"
        })) goto _L4; else goto _L3
_L3:
        htmltreebuilder.clearStackToTableRowContext();
        htmltreebuilder.insert(intable);
        htmltreebuilder.transition(InCell);
        htmltreebuilder.insertMarkerToFormattingElements();
_L6:
        return true;
_L4:
        if (StringUtil.in(s1, new String[] {
    "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"
}))
        {
            return handleMissingTr(token, htmltreebuilder);
        } else
        {
            return anythingElse(token, htmltreebuilder);
        }
_L2:
        if (token.isEndTag())
        {
            String s = token.asEndTag().anythingElse();
            if (s.equals("tr"))
            {
                if (!htmltreebuilder.inTableScope(s))
                {
                    htmltreebuilder.error(this);
                    return false;
                }
                htmltreebuilder.clearStackToTableRowContext();
                htmltreebuilder.pop();
                htmltreebuilder.transition(InTableBody);
            } else
            {
                if (s.equals("table"))
                {
                    return handleMissingTr(token, htmltreebuilder);
                }
                if (StringUtil.in(s, new String[] {
    "tbody", "tfoot", "thead"
}))
                {
                    if (!htmltreebuilder.inTableScope(s))
                    {
                        htmltreebuilder.error(this);
                        return false;
                    } else
                    {
                        htmltreebuilder.process(new cope("tr"));
                        return htmltreebuilder.process(token);
                    }
                }
                if (StringUtil.in(s, new String[] {
    "body", "caption", "col", "colgroup", "html", "td", "th"
}))
                {
                    htmltreebuilder.error(this);
                    return false;
                } else
                {
                    return anythingElse(token, htmltreebuilder);
                }
            }
        } else
        {
            return anythingElse(token, htmltreebuilder);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
