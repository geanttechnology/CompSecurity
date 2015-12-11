// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// Referenced classes of package org.jsoup.parser:
//            CharacterReader, Tokeniser, ParseErrorList, Token

abstract class TreeBuilder
{

    protected String baseUri;
    protected Token currentToken;
    protected Document doc;
    protected ParseErrorList errors;
    CharacterReader reader;
    protected DescendableLinkedList stack;
    Tokeniser tokeniser;

    TreeBuilder()
    {
    }

    protected Element currentElement()
    {
        return (Element)stack.getLast();
    }

    protected void initialiseParse(String s, String s1, ParseErrorList parseerrorlist)
    {
        Validate.notNull(s, "String input must not be null");
        Validate.notNull(s1, "BaseURI must not be null");
        doc = new Document(s1);
        reader = new CharacterReader(s);
        errors = parseerrorlist;
        tokeniser = new Tokeniser(reader, parseerrorlist);
        stack = new DescendableLinkedList();
        baseUri = s1;
    }

    Document parse(String s, String s1)
    {
        return parse(s, s1, ParseErrorList.noTracking());
    }

    Document parse(String s, String s1, ParseErrorList parseerrorlist)
    {
        initialiseParse(s, s1, parseerrorlist);
        runParser();
        return doc;
    }

    protected abstract boolean process(Token token);

    protected void runParser()
    {
        Token token;
        do
        {
            token = tokeniser.read();
            process(token);
        } while (token.type != Token.TokenType.EOF);
    }
}
