// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Entities;

// Referenced classes of package org.jsoup.parser:
//            TokeniserState, ParseErrorList, ParseError, CharacterReader, 
//            Token

class Tokeniser
{

    static final char replacementChar = 65533;
    private StringBuilder charBuffer;
    Token.Comment commentPending;
    StringBuilder dataBuffer;
    Token.Doctype doctypePending;
    private Token emitPending;
    private ParseErrorList errors;
    private boolean isEmitPending;
    private Token.StartTag lastStartTag;
    private CharacterReader reader;
    private boolean selfClosingFlagAcknowledged;
    private TokeniserState state;
    Token.Tag tagPending;

    Tokeniser(CharacterReader characterreader, ParseErrorList parseerrorlist)
    {
        state = TokeniserState.Data;
        isEmitPending = false;
        charBuffer = new StringBuilder();
        selfClosingFlagAcknowledged = true;
        reader = characterreader;
        errors = parseerrorlist;
    }

    private void characterReferenceError(String s)
    {
        if (errors.canAddError())
        {
            errors.add(new ParseError(reader.pos(), "Invalid character reference: %s", new Object[] {
                s
            }));
        }
    }

    private void error(String s)
    {
        if (errors.canAddError())
        {
            errors.add(new ParseError(reader.pos(), s));
        }
    }

    void acknowledgeSelfClosingFlag()
    {
        selfClosingFlagAcknowledged = true;
    }

    void advanceTransition(TokeniserState tokeniserstate)
    {
        reader.advance();
        state = tokeniserstate;
    }

    String appropriateEndTagName()
    {
        return lastStartTag.tagName;
    }

    Character consumeCharacterReference(Character character, boolean flag)
    {
        while (reader.isEmpty() || character != null && character.charValue() == reader.current() || reader.matchesAny(new char[] {
            '\t', '\n', '\f', ' ', '<', '&'
        })) 
        {
            return null;
        }
        reader.mark();
        if (reader.matchConsume("#"))
        {
            flag = reader.matchConsumeIgnoreCase("X");
            if (flag)
            {
                character = reader.consumeHexSequence();
            } else
            {
                character = reader.consumeDigitSequence();
            }
            if (character.length() == 0)
            {
                characterReferenceError("numeric reference with no numerals");
                reader.rewindToMark();
                return null;
            }
            if (!reader.matchConsume(";"))
            {
                characterReferenceError("missing semicolon");
            }
            byte byte0 = -1;
            int i;
            if (flag)
            {
                i = 16;
            } else
            {
                i = 10;
            }
            String s;
            boolean flag1;
            try
            {
                i = Integer.valueOf(character, i).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Character character)
            {
                i = byte0;
            }
            if (i == -1 || i >= 55296 && i <= 57343 || i > 0x10ffff)
            {
                characterReferenceError("character outside of valid range");
                return Character.valueOf('\uFFFD');
            } else
            {
                return Character.valueOf((char)i);
            }
        }
        character = reader.consumeLetterThenDigitSequence();
        s = new String(character);
        flag1 = reader.matches(';');
        for (i = 0; character.length() > 0 && i == 0;)
        {
            if (Entities.isNamedEntity(character))
            {
                i = 1;
            } else
            {
                character = character.substring(0, character.length() - 1);
                reader.unconsume();
            }
        }

        if (i == 0)
        {
            if (flag1)
            {
                characterReferenceError(String.format("invalid named referenece '%s'", new Object[] {
                    s
                }));
            }
            reader.rewindToMark();
            return null;
        }
        if (flag && (reader.matchesLetter() || reader.matchesDigit() || reader.matchesAny(new char[] {
    '=', '-', '_'
})))
        {
            reader.rewindToMark();
            return null;
        }
        if (!reader.matchConsume(";"))
        {
            characterReferenceError("missing semicolon");
        }
        return Entities.getCharacterByName(character);
    }

    void createCommentPending()
    {
        commentPending = new Token.Comment();
    }

    void createDoctypePending()
    {
        doctypePending = new Token.Doctype();
    }

    Token.Tag createTagPending(boolean flag)
    {
        Object obj;
        if (flag)
        {
            obj = new Token.StartTag();
        } else
        {
            obj = new Token.EndTag();
        }
        tagPending = ((Token.Tag) (obj));
        return tagPending;
    }

    void createTempBuffer()
    {
        dataBuffer = new StringBuilder();
    }

    boolean currentNodeInHtmlNS()
    {
        return true;
    }

    void emit(char c)
    {
        charBuffer.append(c);
    }

    void emit(String s)
    {
        charBuffer.append(s);
    }

    void emit(Token token)
    {
        Validate.isFalse(isEmitPending, "There is an unread token pending!");
        emitPending = token;
        isEmitPending = true;
        if (token.type == Token.TokenType.StartTag)
        {
            token = (Token.StartTag)token;
            lastStartTag = token;
            if (((Token.StartTag) (token)).selfClosing)
            {
                selfClosingFlagAcknowledged = false;
            }
        } else
        if (token.type == Token.TokenType.EndTag && ((Token.EndTag)token).attributes.size() > 0)
        {
            error("Attributes incorrectly present on end tag");
            return;
        }
    }

    void emitCommentPending()
    {
        emit(commentPending);
    }

    void emitDoctypePending()
    {
        emit(doctypePending);
    }

    void emitTagPending()
    {
        tagPending.finaliseTag();
        emit(tagPending);
    }

    void eofError(TokeniserState tokeniserstate)
    {
        if (errors.canAddError())
        {
            errors.add(new ParseError(reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[] {
                tokeniserstate
            }));
        }
    }

    void error(TokeniserState tokeniserstate)
    {
        if (errors.canAddError())
        {
            errors.add(new ParseError(reader.pos(), "Unexpected character '%s' in input state [%s]", new Object[] {
                Character.valueOf(reader.current()), tokeniserstate
            }));
        }
    }

    TokeniserState getState()
    {
        return state;
    }

    boolean isAppropriateEndTagToken()
    {
        if (lastStartTag == null)
        {
            return false;
        } else
        {
            return tagPending.tagName.equals(lastStartTag.tagName);
        }
    }

    Token read()
    {
        if (!selfClosingFlagAcknowledged)
        {
            error("Self closing flag not acknowledged");
            selfClosingFlagAcknowledged = true;
        }
        while (!isEmitPending) 
        {
            state.read(this, reader);
        }
        if (charBuffer.length() > 0)
        {
            String s = charBuffer.toString();
            charBuffer.delete(0, charBuffer.length());
            return new Token.Character(s);
        } else
        {
            isEmitPending = false;
            return emitPending;
        }
    }

    void transition(TokeniserState tokeniserstate)
    {
        state = tokeniserstate;
    }
}
