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
        htmltreebuilder.error(this);
        return false;
    }

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        boolean flag = false;
        .SwitchMap.org.jsoup.parser.Token.TokenType[token.type.pe()];
        JVM INSTR tableswitch 1 6: default 52
    //                   1 95
    //                   2 106
    //                   3 113
    //                   4 372
    //                   5 63
    //                   6 562;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_562;
_L1:
        flag = anythingElse(token, htmltreebuilder);
_L9:
        return flag;
_L6:
        token = token.asCharacter();
        if (token.anythingElse().equals(HtmlTreeBuilderState.access$400()))
        {
            htmltreebuilder.error(this);
            return false;
        }
        htmltreebuilder.insert(token);
_L8:
        return true;
_L2:
        htmltreebuilder.insert(token.asComment());
          goto _L8
_L3:
        htmltreebuilder.error(this);
        return false;
_L4:
        it> it>;
        String s1;
        it> = token.asStartTag();
        s1 = it>._mth400();
        if (s1.equals("html"))
        {
            return htmltreebuilder.process(it>, InBody);
        }
        if (s1.equals("option"))
        {
            htmltreebuilder.process(new InBody("option"));
            htmltreebuilder.insert(it>);
        } else
        {
label0:
            {
                if (!s1.equals("optgroup"))
                {
                    break label0;
                }
                if (htmltreebuilder.currentElement().nodeName().equals("option"))
                {
                    htmltreebuilder.process(new lement("option"));
                } else
                if (htmltreebuilder.currentElement().nodeName().equals("optgroup"))
                {
                    htmltreebuilder.process(new lement("optgroup"));
                }
                htmltreebuilder.insert(it>);
            }
        }
          goto _L8
        if (s1.equals("select"))
        {
            htmltreebuilder.error(this);
            return htmltreebuilder.process(new lement("select"));
        }
        if (StringUtil.in(s1, new String[] {
    "input", "keygen", "textarea"
}))
        {
            htmltreebuilder.error(this);
            if (htmltreebuilder.inSelectScope("select"))
            {
                htmltreebuilder.process(new Scope("select"));
                return htmltreebuilder.process(it>);
            }
        } else
        if (s1.equals("script"))
        {
            return htmltreebuilder.process(token, InHead);
        } else
        {
            return anythingElse(token, htmltreebuilder);
        }
          goto _L9
_L5:
        String s = token.asEndTag().anythingElse();
        if (s.equals("optgroup"))
        {
            if (htmltreebuilder.currentElement().nodeName().equals("option") && htmltreebuilder.aboveOnStack(htmltreebuilder.currentElement()) != null && htmltreebuilder.aboveOnStack(htmltreebuilder.currentElement()).nodeName().equals("optgroup"))
            {
                htmltreebuilder.process(new lement("option"));
            }
            if (htmltreebuilder.currentElement().nodeName().equals("optgroup"))
            {
                htmltreebuilder.pop();
            } else
            {
                htmltreebuilder.error(this);
            }
        } else
        if (s.equals("option"))
        {
            if (htmltreebuilder.currentElement().nodeName().equals("option"))
            {
                htmltreebuilder.pop();
            } else
            {
                htmltreebuilder.error(this);
            }
        } else
        if (s.equals("select"))
        {
            if (!htmltreebuilder.inSelectScope(s))
            {
                htmltreebuilder.error(this);
                return false;
            }
            htmltreebuilder.popStackToClose(s);
            htmltreebuilder.resetInsertionMode();
        } else
        {
            return anythingElse(token, htmltreebuilder);
        }
          goto _L8
        if (!htmltreebuilder.currentElement().nodeName().equals("html"))
        {
            htmltreebuilder.error(this);
        }
          goto _L8
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
