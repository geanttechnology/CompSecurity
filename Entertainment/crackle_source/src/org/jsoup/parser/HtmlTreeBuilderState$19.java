// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.nodes.Element;

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
        if (token.isStartTag())
        {
            token = token.asStartTag();
            String s = token._mth100();
            if (s.equals("html"))
            {
                return htmltreebuilder.process(token, InBody);
            }
            if (s.equals("frameset"))
            {
                htmltreebuilder.insert(token);
            } else
            if (s.equals("frame"))
            {
                htmltreebuilder.insertEmpty(token);
            } else
            if (s.equals("noframes"))
            {
                return htmltreebuilder.process(token, InHead);
            } else
            {
                htmltreebuilder.error(this);
                return false;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!token.isEndTag() || !token.asEndTag().InHead().equals("frameset"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (htmltreebuilder.currentElement().nodeName().equals("html"))
        {
            htmltreebuilder.error(this);
            return false;
        }
        htmltreebuilder.pop();
        if (!htmltreebuilder.isFragmentParsing() && !htmltreebuilder.currentElement().nodeName().equals("frameset"))
        {
            htmltreebuilder.transition(AfterFrameset);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (token.isEOF())
        {
            if (!htmltreebuilder.currentElement().nodeName().equals("html"))
            {
                htmltreebuilder.error(this);
                return true;
            }
        } else
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
