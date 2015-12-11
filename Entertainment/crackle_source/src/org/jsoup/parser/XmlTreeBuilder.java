// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import java.util.Iterator;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

// Referenced classes of package org.jsoup.parser:
//            TreeBuilder, Tag, Tokeniser, Token, 
//            ParseErrorList

public class XmlTreeBuilder extends TreeBuilder
{

    public XmlTreeBuilder()
    {
    }

    private void insertNode(Node node)
    {
        currentElement().appendChild(node);
    }

    private void popStackToClose(Token.EndTag endtag)
    {
        String s = endtag.name();
        Object obj = null;
        Iterator iterator1 = stack.descendingIterator();
        do
        {
            endtag = obj;
            if (!iterator1.hasNext())
            {
                break;
            }
            endtag = (Element)iterator1.next();
        } while (!endtag.nodeName().equals(s));
        if (endtag != null)
        {
            Iterator iterator = stack.descendingIterator();
            while (iterator.hasNext()) 
            {
                if ((Element)iterator.next() == endtag)
                {
                    iterator.remove();
                    return;
                }
                iterator.remove();
            }
        }
    }

    protected void initialiseParse(String s, String s1, ParseErrorList parseerrorlist)
    {
        super.initialiseParse(s, s1, parseerrorlist);
        stack.add(doc);
    }

    Element insert(Token.StartTag starttag)
    {
        Tag tag = Tag.valueOf(starttag.name());
        Element element = new Element(tag, baseUri, starttag.attributes);
        insertNode(element);
        if (starttag.isSelfClosing())
        {
            tokeniser.acknowledgeSelfClosingFlag();
            if (!tag.isKnownTag())
            {
                tag.setSelfClosing();
            }
            return element;
        } else
        {
            stack.add(element);
            return element;
        }
    }

    void insert(Token.Character character)
    {
        insertNode(new TextNode(character.getData(), baseUri));
    }

    void insert(Token.Comment comment)
    {
        insertNode(new Comment(comment.getData(), baseUri));
    }

    void insert(Token.Doctype doctype)
    {
        insertNode(new DocumentType(doctype.getName(), doctype.getPublicIdentifier(), doctype.getSystemIdentifier(), baseUri));
    }

    protected boolean process(Token token)
    {
        static class _cls1
        {

            static final int $SwitchMap$org$jsoup$parser$Token$TokenType[];

            static 
            {
                $SwitchMap$org$jsoup$parser$Token$TokenType = new int[Token.TokenType.values().length];
                try
                {
                    $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$jsoup$parser$Token$TokenType[org.jsoup.parser.Token.TokenType.Comment.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.jsoup.parser.Token.TokenType[token.type.ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 75
    //                   2 87
    //                   3 98
    //                   4 109
    //                   5 120
    //                   6 73;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break; /* Loop/switch isn't completed */
_L1:
        Validate.fail((new StringBuilder()).append("Unexpected token type: ").append(token.type).toString());
_L9:
        return true;
_L2:
        insert(token.asStartTag());
        continue; /* Loop/switch isn't completed */
_L3:
        popStackToClose(token.asEndTag());
        continue; /* Loop/switch isn't completed */
_L4:
        insert(token.asComment());
        continue; /* Loop/switch isn't completed */
_L5:
        insert(token.asCharacter());
        continue; /* Loop/switch isn't completed */
_L6:
        insert(token.asDoctype());
        if (true) goto _L9; else goto _L8
_L8:
    }
}
