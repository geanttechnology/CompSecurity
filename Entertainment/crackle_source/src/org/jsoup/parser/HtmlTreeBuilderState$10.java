// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            HtmlTreeBuilderState, Token, HtmlTreeBuilder

static final class it> extends HtmlTreeBuilderState
{

    boolean process(Token token, HtmlTreeBuilder htmltreebuilder)
    {
        switch (.SwitchMap.org.jsoup.parser.Token.TokenType[token.type.pe()])
        {
        default:
            if (htmltreebuilder.getPendingTableCharacters().size() > 0)
            {
                for (Iterator iterator = htmltreebuilder.getPendingTableCharacters().iterator(); iterator.hasNext();)
                {
                    it> it> = (ngTableCharacters)iterator.next();
                    if (!HtmlTreeBuilderState.access$100(it>))
                    {
                        htmltreebuilder.error(this);
                        if (StringUtil.in(htmltreebuilder.currentElement().nodeName(), new String[] {
    "table", "tbody", "tfoot", "thead", "tr"
}))
                        {
                            htmltreebuilder.setFosterInserts(true);
                            htmltreebuilder.process(it>, InBody);
                            htmltreebuilder.setFosterInserts(false);
                        } else
                        {
                            htmltreebuilder.process(it>, InBody);
                        }
                    } else
                    {
                        htmltreebuilder.insert(it>);
                    }
                }

                break;
            }
            break;

        case 5: // '\005'
            token = token.asCharacter();
            if (token.InBody().equals(HtmlTreeBuilderState.access$400()))
            {
                htmltreebuilder.error(this);
                return false;
            } else
            {
                htmltreebuilder.getPendingTableCharacters().add(token);
                return true;
            }
        }
        break MISSING_BLOCK_LABEL_212;
        htmltreebuilder.newPendingTableCharacters();
        htmltreebuilder.transition(htmltreebuilder.originalState());
        return htmltreebuilder.process(token);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
