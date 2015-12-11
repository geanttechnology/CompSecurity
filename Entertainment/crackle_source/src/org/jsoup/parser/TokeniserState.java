// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            Tokeniser, CharacterReader

abstract class TokeniserState extends Enum
{

    private static final TokeniserState $VALUES[];
    public static final TokeniserState AfterAttributeName;
    public static final TokeniserState AfterAttributeValue_quoted;
    public static final TokeniserState AfterDoctypeName;
    public static final TokeniserState AfterDoctypePublicIdentifier;
    public static final TokeniserState AfterDoctypePublicKeyword;
    public static final TokeniserState AfterDoctypeSystemIdentifier;
    public static final TokeniserState AfterDoctypeSystemKeyword;
    public static final TokeniserState AttributeName;
    public static final TokeniserState AttributeValue_doubleQuoted;
    public static final TokeniserState AttributeValue_singleQuoted;
    public static final TokeniserState AttributeValue_unquoted;
    public static final TokeniserState BeforeAttributeName;
    public static final TokeniserState BeforeAttributeValue;
    public static final TokeniserState BeforeDoctypeName;
    public static final TokeniserState BeforeDoctypePublicIdentifier;
    public static final TokeniserState BeforeDoctypeSystemIdentifier;
    public static final TokeniserState BetweenDoctypePublicAndSystemIdentifiers;
    public static final TokeniserState BogusComment;
    public static final TokeniserState BogusDoctype;
    public static final TokeniserState CdataSection;
    public static final TokeniserState CharacterReferenceInData;
    public static final TokeniserState CharacterReferenceInRcdata;
    public static final TokeniserState Comment;
    public static final TokeniserState CommentEnd;
    public static final TokeniserState CommentEndBang;
    public static final TokeniserState CommentEndDash;
    public static final TokeniserState CommentStart;
    public static final TokeniserState CommentStartDash;
    public static final TokeniserState Data;
    public static final TokeniserState Doctype;
    public static final TokeniserState DoctypeName;
    public static final TokeniserState DoctypePublicIdentifier_doubleQuoted;
    public static final TokeniserState DoctypePublicIdentifier_singleQuoted;
    public static final TokeniserState DoctypeSystemIdentifier_doubleQuoted;
    public static final TokeniserState DoctypeSystemIdentifier_singleQuoted;
    public static final TokeniserState EndTagOpen;
    public static final TokeniserState MarkupDeclarationOpen;
    public static final TokeniserState PLAINTEXT;
    public static final TokeniserState RCDATAEndTagName;
    public static final TokeniserState RCDATAEndTagOpen;
    public static final TokeniserState Rawtext;
    public static final TokeniserState RawtextEndTagName;
    public static final TokeniserState RawtextEndTagOpen;
    public static final TokeniserState RawtextLessthanSign;
    public static final TokeniserState Rcdata;
    public static final TokeniserState RcdataLessthanSign;
    public static final TokeniserState ScriptData;
    public static final TokeniserState ScriptDataDoubleEscapeEnd;
    public static final TokeniserState ScriptDataDoubleEscapeStart;
    public static final TokeniserState ScriptDataDoubleEscaped;
    public static final TokeniserState ScriptDataDoubleEscapedDash;
    public static final TokeniserState ScriptDataDoubleEscapedDashDash;
    public static final TokeniserState ScriptDataDoubleEscapedLessthanSign;
    public static final TokeniserState ScriptDataEndTagName;
    public static final TokeniserState ScriptDataEndTagOpen;
    public static final TokeniserState ScriptDataEscapeStart;
    public static final TokeniserState ScriptDataEscapeStartDash;
    public static final TokeniserState ScriptDataEscaped;
    public static final TokeniserState ScriptDataEscapedDash;
    public static final TokeniserState ScriptDataEscapedDashDash;
    public static final TokeniserState ScriptDataEscapedEndTagName;
    public static final TokeniserState ScriptDataEscapedEndTagOpen;
    public static final TokeniserState ScriptDataEscapedLessthanSign;
    public static final TokeniserState ScriptDataLessthanSign;
    public static final TokeniserState SelfClosingStartTag;
    public static final TokeniserState TagName;
    public static final TokeniserState TagOpen;
    private static final char eof = 65535;
    private static final char nullChar = 0;
    private static final char replacementChar = 65533;
    private static final String replacementStr = String.valueOf('\uFFFD');

    private TokeniserState(String s, int i)
    {
        super(s, i);
    }


    public static TokeniserState valueOf(String s)
    {
        return (TokeniserState)Enum.valueOf(org/jsoup/parser/TokeniserState, s);
    }

    public static TokeniserState[] values()
    {
        return (TokeniserState[])$VALUES.clone();
    }

    abstract void read(Tokeniser tokeniser, CharacterReader characterreader);

    static 
    {
        Data = new TokeniserState("Data", 0) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    tokeniser.emit(characterreader.consumeToAny(new char[] {
                        '&', '<', '\0'
                    }));
                    return;

                case 38: // '&'
                    tokeniser.advanceTransition(CharacterReferenceInData);
                    return;

                case 60: // '<'
                    tokeniser.advanceTransition(TagOpen);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.emit(characterreader.consume());
                    return;

                case 65535: 
                    tokeniser.emit(new Token.EOF());
                    break;
                }
            }

        };
        CharacterReferenceInData = new TokeniserState("CharacterReferenceInData", 1) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                characterreader = tokeniser.consumeCharacterReference(null, false);
                if (characterreader == null)
                {
                    tokeniser.emit('&');
                } else
                {
                    tokeniser.emit(characterreader.charValue());
                }
                tokeniser.transition(Data);
            }

        };
        Rcdata = new TokeniserState("Rcdata", 2) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    tokeniser.emit(characterreader.consumeToAny(new char[] {
                        '&', '<', '\0'
                    }));
                    return;

                case 38: // '&'
                    tokeniser.advanceTransition(CharacterReferenceInRcdata);
                    return;

                case 60: // '<'
                    tokeniser.advanceTransition(RcdataLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.emit('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.emit(new Token.EOF());
                    break;
                }
            }

        };
        CharacterReferenceInRcdata = new TokeniserState("CharacterReferenceInRcdata", 3) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                characterreader = tokeniser.consumeCharacterReference(null, false);
                if (characterreader == null)
                {
                    tokeniser.emit('&');
                } else
                {
                    tokeniser.emit(characterreader.charValue());
                }
                tokeniser.transition(Rcdata);
            }

        };
        Rawtext = new TokeniserState("Rawtext", 4) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    tokeniser.emit(characterreader.consumeToAny(new char[] {
                        '<', '\0'
                    }));
                    return;

                case 60: // '<'
                    tokeniser.advanceTransition(RawtextLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.emit('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.emit(new Token.EOF());
                    break;
                }
            }

        };
        ScriptData = new TokeniserState("ScriptData", 5) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    tokeniser.emit(characterreader.consumeToAny(new char[] {
                        '<', '\0'
                    }));
                    return;

                case 60: // '<'
                    tokeniser.advanceTransition(ScriptDataLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.emit('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.emit(new Token.EOF());
                    break;
                }
            }

        };
        PLAINTEXT = new TokeniserState("PLAINTEXT", 6) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    tokeniser.emit(characterreader.consumeTo('\0'));
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.emit('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.emit(new Token.EOF());
                    break;
                }
            }

        };
        TagOpen = new TokeniserState("TagOpen", 7) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    if (characterreader.matchesLetter())
                    {
                        tokeniser.createTagPending(true);
                        tokeniser.transition(TagName);
                        return;
                    } else
                    {
                        tokeniser.error(this);
                        tokeniser.emit('<');
                        tokeniser.transition(Data);
                        return;
                    }

                case 33: // '!'
                    tokeniser.advanceTransition(MarkupDeclarationOpen);
                    return;

                case 47: // '/'
                    tokeniser.advanceTransition(EndTagOpen);
                    return;

                case 63: // '?'
                    tokeniser.advanceTransition(BogusComment);
                    return;
                }
            }

        };
        EndTagOpen = new TokeniserState("EndTagOpen", 8) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.isEmpty())
                {
                    tokeniser.eofError(this);
                    tokeniser.emit("</");
                    tokeniser.transition(Data);
                    return;
                }
                if (characterreader.matchesLetter())
                {
                    tokeniser.createTagPending(false);
                    tokeniser.transition(TagName);
                    return;
                }
                if (characterreader.matches('>'))
                {
                    tokeniser.error(this);
                    tokeniser.advanceTransition(Data);
                    return;
                } else
                {
                    tokeniser.error(this);
                    tokeniser.advanceTransition(BogusComment);
                    return;
                }
            }

        };
        TagName = new TokeniserState("TagName", 9) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                String s = characterreader.consumeToAny(new char[] {
                    '\t', '\n', '\f', ' ', '/', '>', '\0'
                }).toLowerCase();
                tokeniser.tagPending.appendTagName(s);
                switch (characterreader.consume())
                {
                default:
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BeforeAttributeName);
                    return;

                case 47: // '/'
                    tokeniser.transition(SelfClosingStartTag);
                    return;

                case 62: // '>'
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        RcdataLessthanSign = new TokeniserState("RcdataLessthanSign", 10) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matches('/'))
                {
                    tokeniser.createTempBuffer();
                    tokeniser.advanceTransition(RCDATAEndTagOpen);
                    return;
                }
                if (characterreader.matchesLetter() && !characterreader.containsIgnoreCase((new StringBuilder()).append("</").append(tokeniser.appropriateEndTagName()).toString()))
                {
                    tokeniser.tagPending = new Token.EndTag(tokeniser.appropriateEndTagName());
                    tokeniser.emitTagPending();
                    characterreader.unconsume();
                    tokeniser.transition(Data);
                    return;
                } else
                {
                    tokeniser.emit("<");
                    tokeniser.transition(Rcdata);
                    return;
                }
            }

        };
        RCDATAEndTagOpen = new TokeniserState("RCDATAEndTagOpen", 11) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    tokeniser.createTagPending(false);
                    tokeniser.tagPending.appendTagName(Character.toLowerCase(characterreader.current()));
                    tokeniser.dataBuffer.append(Character.toLowerCase(characterreader.current()));
                    tokeniser.advanceTransition(RCDATAEndTagName);
                    return;
                } else
                {
                    tokeniser.emit("</");
                    tokeniser.transition(Rcdata);
                    return;
                }
            }

        };
        RCDATAEndTagName = new TokeniserState("RCDATAEndTagName", 12) {

            private void anythingElse(Tokeniser tokeniser, CharacterReader characterreader)
            {
                tokeniser.emit((new StringBuilder()).append("</").append(tokeniser.dataBuffer.toString()).toString());
                tokeniser.transition(Rcdata);
            }

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.tagPending.appendTagName(characterreader.toLowerCase());
                    tokeniser.dataBuffer.append(characterreader);
                    return;
                }
                switch (characterreader.consume())
                {
                default:
                    anythingElse(tokeniser, characterreader);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    if (tokeniser.isAppropriateEndTagToken())
                    {
                        tokeniser.transition(BeforeAttributeName);
                        return;
                    } else
                    {
                        anythingElse(tokeniser, characterreader);
                        return;
                    }

                case 47: // '/'
                    if (tokeniser.isAppropriateEndTagToken())
                    {
                        tokeniser.transition(SelfClosingStartTag);
                        return;
                    } else
                    {
                        anythingElse(tokeniser, characterreader);
                        return;
                    }

                case 62: // '>'
                    break;
                }
                if (tokeniser.isAppropriateEndTagToken())
                {
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                } else
                {
                    anythingElse(tokeniser, characterreader);
                    return;
                }
            }

        };
        RawtextLessthanSign = new TokeniserState("RawtextLessthanSign", 13) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matches('/'))
                {
                    tokeniser.createTempBuffer();
                    tokeniser.advanceTransition(RawtextEndTagOpen);
                    return;
                } else
                {
                    tokeniser.emit('<');
                    tokeniser.transition(Rawtext);
                    return;
                }
            }

        };
        RawtextEndTagOpen = new TokeniserState("RawtextEndTagOpen", 14) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    tokeniser.createTagPending(false);
                    tokeniser.transition(RawtextEndTagName);
                    return;
                } else
                {
                    tokeniser.emit("</");
                    tokeniser.transition(Rawtext);
                    return;
                }
            }

        };
        RawtextEndTagName = new TokeniserState("RawtextEndTagName", 15) {

            private void anythingElse(Tokeniser tokeniser, CharacterReader characterreader)
            {
                tokeniser.emit((new StringBuilder()).append("</").append(tokeniser.dataBuffer.toString()).toString());
                tokeniser.transition(Rawtext);
            }

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.tagPending.appendTagName(characterreader.toLowerCase());
                    tokeniser.dataBuffer.append(characterreader);
                    return;
                }
                if (tokeniser.isAppropriateEndTagToken() && !characterreader.isEmpty())
                {
                    char c = characterreader.consume();
                    switch (c)
                    {
                    default:
                        tokeniser.dataBuffer.append(c);
                        anythingElse(tokeniser, characterreader);
                        return;

                    case 9: // '\t'
                    case 10: // '\n'
                    case 12: // '\f'
                    case 32: // ' '
                        tokeniser.transition(BeforeAttributeName);
                        return;

                    case 47: // '/'
                        tokeniser.transition(SelfClosingStartTag);
                        return;

                    case 62: // '>'
                        tokeniser.emitTagPending();
                        break;
                    }
                    tokeniser.transition(Data);
                    return;
                } else
                {
                    anythingElse(tokeniser, characterreader);
                    return;
                }
            }

        };
        ScriptDataLessthanSign = new TokeniserState("ScriptDataLessthanSign", 16) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.emit("<");
                    characterreader.unconsume();
                    tokeniser.transition(ScriptData);
                    return;

                case 47: // '/'
                    tokeniser.createTempBuffer();
                    tokeniser.transition(ScriptDataEndTagOpen);
                    return;

                case 33: // '!'
                    tokeniser.emit("<!");
                    tokeniser.transition(ScriptDataEscapeStart);
                    return;
                }
            }

        };
        ScriptDataEndTagOpen = new TokeniserState("ScriptDataEndTagOpen", 17) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    tokeniser.createTagPending(false);
                    tokeniser.transition(ScriptDataEndTagName);
                    return;
                } else
                {
                    tokeniser.emit("</");
                    tokeniser.transition(ScriptData);
                    return;
                }
            }

        };
        ScriptDataEndTagName = new TokeniserState("ScriptDataEndTagName", 18) {

            private void anythingElse(Tokeniser tokeniser, CharacterReader characterreader)
            {
                tokeniser.emit((new StringBuilder()).append("</").append(tokeniser.dataBuffer.toString()).toString());
                tokeniser.transition(ScriptData);
            }

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.tagPending.appendTagName(characterreader.toLowerCase());
                    tokeniser.dataBuffer.append(characterreader);
                    return;
                }
                if (tokeniser.isAppropriateEndTagToken() && !characterreader.isEmpty())
                {
                    char c = characterreader.consume();
                    switch (c)
                    {
                    default:
                        tokeniser.dataBuffer.append(c);
                        anythingElse(tokeniser, characterreader);
                        return;

                    case 9: // '\t'
                    case 10: // '\n'
                    case 12: // '\f'
                    case 32: // ' '
                        tokeniser.transition(BeforeAttributeName);
                        return;

                    case 47: // '/'
                        tokeniser.transition(SelfClosingStartTag);
                        return;

                    case 62: // '>'
                        tokeniser.emitTagPending();
                        break;
                    }
                    tokeniser.transition(Data);
                    return;
                } else
                {
                    anythingElse(tokeniser, characterreader);
                    return;
                }
            }

        };
        ScriptDataEscapeStart = new TokeniserState("ScriptDataEscapeStart", 19) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matches('-'))
                {
                    tokeniser.emit('-');
                    tokeniser.advanceTransition(ScriptDataEscapeStartDash);
                    return;
                } else
                {
                    tokeniser.transition(ScriptData);
                    return;
                }
            }

        };
        ScriptDataEscapeStartDash = new TokeniserState("ScriptDataEscapeStartDash", 20) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matches('-'))
                {
                    tokeniser.emit('-');
                    tokeniser.advanceTransition(ScriptDataEscapedDashDash);
                    return;
                } else
                {
                    tokeniser.transition(ScriptData);
                    return;
                }
            }

        };
        ScriptDataEscaped = new TokeniserState("ScriptDataEscaped", 21) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.isEmpty())
                {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                }
                switch (characterreader.current())
                {
                default:
                    tokeniser.emit(characterreader.consumeToAny(new char[] {
                        '-', '<', '\0'
                    }));
                    return;

                case 45: // '-'
                    tokeniser.emit('-');
                    tokeniser.advanceTransition(ScriptDataEscapedDash);
                    return;

                case 60: // '<'
                    tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.emit('\uFFFD');
                    return;
                }
            }

        };
        ScriptDataEscapedDash = new TokeniserState("ScriptDataEscapedDash", 22) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.isEmpty())
                {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                }
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataEscaped);
                    return;

                case 45: // '-'
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataEscapedDashDash);
                    return;

                case 60: // '<'
                    tokeniser.transition(ScriptDataEscapedLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.emit('\uFFFD');
                    tokeniser.transition(ScriptDataEscaped);
                    return;
                }
            }

        };
        ScriptDataEscapedDashDash = new TokeniserState("ScriptDataEscapedDashDash", 23) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.isEmpty())
                {
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                }
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataEscaped);
                    return;

                case 45: // '-'
                    tokeniser.emit(c);
                    return;

                case 60: // '<'
                    tokeniser.transition(ScriptDataEscapedLessthanSign);
                    return;

                case 62: // '>'
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptData);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.emit('\uFFFD');
                    tokeniser.transition(ScriptDataEscaped);
                    return;
                }
            }

        };
        ScriptDataEscapedLessthanSign = new TokeniserState("ScriptDataEscapedLessthanSign", 24) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    tokeniser.createTempBuffer();
                    tokeniser.dataBuffer.append(Character.toLowerCase(characterreader.current()));
                    tokeniser.emit((new StringBuilder()).append("<").append(characterreader.current()).toString());
                    tokeniser.advanceTransition(ScriptDataDoubleEscapeStart);
                    return;
                }
                if (characterreader.matches('/'))
                {
                    tokeniser.createTempBuffer();
                    tokeniser.advanceTransition(ScriptDataEscapedEndTagOpen);
                    return;
                } else
                {
                    tokeniser.emit('<');
                    tokeniser.transition(ScriptDataEscaped);
                    return;
                }
            }

        };
        ScriptDataEscapedEndTagOpen = new TokeniserState("ScriptDataEscapedEndTagOpen", 25) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    tokeniser.createTagPending(false);
                    tokeniser.tagPending.appendTagName(Character.toLowerCase(characterreader.current()));
                    tokeniser.dataBuffer.append(characterreader.current());
                    tokeniser.advanceTransition(ScriptDataEscapedEndTagName);
                    return;
                } else
                {
                    tokeniser.emit("</");
                    tokeniser.transition(ScriptDataEscaped);
                    return;
                }
            }

        };
        ScriptDataEscapedEndTagName = new TokeniserState("ScriptDataEscapedEndTagName", 26) {

            private void anythingElse(Tokeniser tokeniser, CharacterReader characterreader)
            {
                tokeniser.emit((new StringBuilder()).append("</").append(tokeniser.dataBuffer.toString()).toString());
                tokeniser.transition(ScriptDataEscaped);
            }

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.tagPending.appendTagName(characterreader.toLowerCase());
                    tokeniser.dataBuffer.append(characterreader);
                    return;
                }
                if (tokeniser.isAppropriateEndTagToken() && !characterreader.isEmpty())
                {
                    char c = characterreader.consume();
                    switch (c)
                    {
                    default:
                        tokeniser.dataBuffer.append(c);
                        anythingElse(tokeniser, characterreader);
                        return;

                    case 9: // '\t'
                    case 10: // '\n'
                    case 12: // '\f'
                    case 32: // ' '
                        tokeniser.transition(BeforeAttributeName);
                        return;

                    case 47: // '/'
                        tokeniser.transition(SelfClosingStartTag);
                        return;

                    case 62: // '>'
                        tokeniser.emitTagPending();
                        break;
                    }
                    tokeniser.transition(Data);
                    return;
                } else
                {
                    anythingElse(tokeniser, characterreader);
                    return;
                }
            }

        };
        ScriptDataDoubleEscapeStart = new TokeniserState("ScriptDataDoubleEscapeStart", 27) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.dataBuffer.append(characterreader.toLowerCase());
                    tokeniser.emit(characterreader);
                    return;
                }
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    characterreader.unconsume();
                    tokeniser.transition(ScriptDataEscaped);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                case 47: // '/'
                case 62: // '>'
                    break;
                }
                if (tokeniser.dataBuffer.toString().equals("script"))
                {
                    tokeniser.transition(ScriptDataDoubleEscaped);
                } else
                {
                    tokeniser.transition(ScriptDataEscaped);
                }
                tokeniser.emit(c);
            }

        };
        ScriptDataDoubleEscaped = new TokeniserState("ScriptDataDoubleEscaped", 28) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.current();
                switch (c)
                {
                default:
                    tokeniser.emit(characterreader.consumeToAny(new char[] {
                        '-', '<', '\0'
                    }));
                    return;

                case 45: // '-'
                    tokeniser.emit(c);
                    tokeniser.advanceTransition(ScriptDataDoubleEscapedDash);
                    return;

                case 60: // '<'
                    tokeniser.emit(c);
                    tokeniser.advanceTransition(ScriptDataDoubleEscapedLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.emit('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        ScriptDataDoubleEscapedDash = new TokeniserState("ScriptDataDoubleEscapedDash", 29) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;

                case 45: // '-'
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataDoubleEscapedDashDash);
                    return;

                case 60: // '<'
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.emit('\uFFFD');
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        ScriptDataDoubleEscapedDashDash = new TokeniserState("ScriptDataDoubleEscapedDashDash", 30) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;

                case 45: // '-'
                    tokeniser.emit(c);
                    return;

                case 60: // '<'
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
                    return;

                case 62: // '>'
                    tokeniser.emit(c);
                    tokeniser.transition(ScriptData);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.emit('\uFFFD');
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        ScriptDataDoubleEscapedLessthanSign = new TokeniserState("ScriptDataDoubleEscapedLessthanSign", 31) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matches('/'))
                {
                    tokeniser.emit('/');
                    tokeniser.createTempBuffer();
                    tokeniser.advanceTransition(ScriptDataDoubleEscapeEnd);
                    return;
                } else
                {
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;
                }
            }

        };
        ScriptDataDoubleEscapeEnd = new TokeniserState("ScriptDataDoubleEscapeEnd", 32) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.dataBuffer.append(characterreader.toLowerCase());
                    tokeniser.emit(characterreader);
                    return;
                }
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    characterreader.unconsume();
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                case 47: // '/'
                case 62: // '>'
                    break;
                }
                if (tokeniser.dataBuffer.toString().equals("script"))
                {
                    tokeniser.transition(ScriptDataEscaped);
                } else
                {
                    tokeniser.transition(ScriptDataDoubleEscaped);
                }
                tokeniser.emit(c);
            }

        };
        BeforeAttributeName = new TokeniserState("BeforeAttributeName", 33) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.tagPending.newAttribute();
                    characterreader.unconsume();
                    tokeniser.transition(AttributeName);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 47: // '/'
                    tokeniser.transition(SelfClosingStartTag);
                    return;

                case 62: // '>'
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    characterreader.unconsume();
                    tokeniser.transition(AttributeName);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                case 39: // '\''
                case 60: // '<'
                case 61: // '='
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    tokeniser.tagPending.appendAttributeName(c);
                    tokeniser.transition(AttributeName);
                    return;
                }
            }

        };
        AttributeName = new TokeniserState("AttributeName", 34) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                String s = characterreader.consumeToAny(new char[] {
                    '\t', '\n', '\f', ' ', '/', '=', '>', '\0', '"', '\'', 
                    '<'
                });
                tokeniser.tagPending.appendAttributeName(s.toLowerCase());
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(AfterAttributeName);
                    return;

                case 47: // '/'
                    tokeniser.transition(SelfClosingStartTag);
                    return;

                case 61: // '='
                    tokeniser.transition(BeforeAttributeValue);
                    return;

                case 62: // '>'
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                case 39: // '\''
                case 60: // '<'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName(c);
                    return;
                }
            }

        };
        AfterAttributeName = new TokeniserState("AfterAttributeName", 35) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.tagPending.newAttribute();
                    characterreader.unconsume();
                    tokeniser.transition(AttributeName);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 47: // '/'
                    tokeniser.transition(SelfClosingStartTag);
                    return;

                case 61: // '='
                    tokeniser.transition(BeforeAttributeValue);
                    return;

                case 62: // '>'
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName('\uFFFD');
                    tokeniser.transition(AttributeName);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                case 39: // '\''
                case 60: // '<'
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    tokeniser.tagPending.appendAttributeName(c);
                    tokeniser.transition(AttributeName);
                    return;
                }
            }

        };
        BeforeAttributeValue = new TokeniserState("BeforeAttributeValue", 36) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    characterreader.unconsume();
                    tokeniser.transition(AttributeValue_unquoted);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 34: // '"'
                    tokeniser.transition(AttributeValue_doubleQuoted);
                    return;

                case 38: // '&'
                    characterreader.unconsume();
                    tokeniser.transition(AttributeValue_unquoted);
                    return;

                case 39: // '\''
                    tokeniser.transition(AttributeValue_singleQuoted);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue('\uFFFD');
                    tokeniser.transition(AttributeValue_unquoted);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 60: // '<'
                case 61: // '='
                case 96: // '`'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(c);
                    tokeniser.transition(AttributeValue_unquoted);
                    return;
                }
            }

        };
        AttributeValue_doubleQuoted = new TokeniserState("AttributeValue_doubleQuoted", 37) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                String s = characterreader.consumeToAny(new char[] {
                    '"', '&', '\0'
                });
                if (s.length() > 0)
                {
                    tokeniser.tagPending.appendAttributeValue(s);
                }
                switch (characterreader.consume())
                {
                default:
                    return;

                case 34: // '"'
                    tokeniser.transition(AfterAttributeValue_quoted);
                    return;

                case 38: // '&'
                    characterreader = tokeniser.consumeCharacterReference(Character.valueOf('"'), true);
                    if (characterreader != null)
                    {
                        tokeniser.tagPending.appendAttributeValue(characterreader.charValue());
                        return;
                    } else
                    {
                        tokeniser.tagPending.appendAttributeValue('&');
                        return;
                    }

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                }
            }

        };
        AttributeValue_singleQuoted = new TokeniserState("AttributeValue_singleQuoted", 38) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                String s = characterreader.consumeToAny(new char[] {
                    '\'', '&', '\0'
                });
                if (s.length() > 0)
                {
                    tokeniser.tagPending.appendAttributeValue(s);
                }
                switch (characterreader.consume())
                {
                default:
                    return;

                case 39: // '\''
                    tokeniser.transition(AfterAttributeValue_quoted);
                    return;

                case 38: // '&'
                    characterreader = tokeniser.consumeCharacterReference(Character.valueOf('\''), true);
                    if (characterreader != null)
                    {
                        tokeniser.tagPending.appendAttributeValue(characterreader.charValue());
                        return;
                    } else
                    {
                        tokeniser.tagPending.appendAttributeValue('&');
                        return;
                    }

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                }
            }

        };
        AttributeValue_unquoted = new TokeniserState("AttributeValue_unquoted", 39) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                String s = characterreader.consumeToAny(new char[] {
                    '\t', '\n', '\f', ' ', '&', '>', '\0', '"', '\'', '<', 
                    '=', '`'
                });
                if (s.length() > 0)
                {
                    tokeniser.tagPending.appendAttributeValue(s);
                }
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BeforeAttributeName);
                    return;

                case 38: // '&'
                    characterreader = tokeniser.consumeCharacterReference(Character.valueOf('>'), true);
                    if (characterreader != null)
                    {
                        tokeniser.tagPending.appendAttributeValue(characterreader.charValue());
                        return;
                    } else
                    {
                        tokeniser.tagPending.appendAttributeValue('&');
                        return;
                    }

                case 62: // '>'
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                case 39: // '\''
                case 60: // '<'
                case 61: // '='
                case 96: // '`'
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(c);
                    return;
                }
            }

        };
        AfterAttributeValue_quoted = new TokeniserState("AfterAttributeValue_quoted", 40) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    characterreader.unconsume();
                    tokeniser.transition(BeforeAttributeName);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BeforeAttributeName);
                    return;

                case 47: // '/'
                    tokeniser.transition(SelfClosingStartTag);
                    return;

                case 62: // '>'
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        SelfClosingStartTag = new TokeniserState("SelfClosingStartTag", 41) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.transition(BeforeAttributeName);
                    return;

                case 62: // '>'
                    tokeniser.tagPending.selfClosing = true;
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        BogusComment = new TokeniserState("BogusComment", 42) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                characterreader.unconsume();
                Token.Comment comment = new Token.Comment();
                comment.data.append(characterreader.consumeTo('>'));
                tokeniser.emit(comment);
                tokeniser.advanceTransition(Data);
            }

        };
        MarkupDeclarationOpen = new TokeniserState("MarkupDeclarationOpen", 43) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchConsume("--"))
                {
                    tokeniser.createCommentPending();
                    tokeniser.transition(CommentStart);
                    return;
                }
                if (characterreader.matchConsumeIgnoreCase("DOCTYPE"))
                {
                    tokeniser.transition(Doctype);
                    return;
                }
                if (characterreader.matchConsume("[CDATA["))
                {
                    tokeniser.transition(CdataSection);
                    return;
                } else
                {
                    tokeniser.error(this);
                    tokeniser.advanceTransition(BogusComment);
                    return;
                }
            }

        };
        CommentStart = new TokeniserState("CommentStart", 44) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.commentPending.data.append(c);
                    tokeniser.transition(Comment);
                    return;

                case 45: // '-'
                    tokeniser.transition(CommentStartDash);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append('\uFFFD');
                    tokeniser.transition(Comment);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }

        };
        CommentStartDash = new TokeniserState("CommentStartDash", 45) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.commentPending.data.append(c);
                    tokeniser.transition(Comment);
                    return;

                case 45: // '-'
                    tokeniser.transition(CommentStartDash);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append('\uFFFD');
                    tokeniser.transition(Comment);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }

        };
        Comment = new TokeniserState("Comment", 46) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.current())
                {
                default:
                    tokeniser.commentPending.data.append(characterreader.consumeToAny(new char[] {
                        '-', '\0'
                    }));
                    return;

                case 45: // '-'
                    tokeniser.advanceTransition(CommentEndDash);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    characterreader.advance();
                    tokeniser.commentPending.data.append('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }

        };
        CommentEndDash = new TokeniserState("CommentEndDash", 47) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.commentPending.data.append('-').append(c);
                    tokeniser.transition(Comment);
                    return;

                case 45: // '-'
                    tokeniser.transition(CommentEnd);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append('-').append('\uFFFD');
                    tokeniser.transition(Comment);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }

        };
        CommentEnd = new TokeniserState("CommentEnd", 48) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append("--").append(c);
                    tokeniser.transition(Comment);
                    return;

                case 62: // '>'
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append("--").append('\uFFFD');
                    tokeniser.transition(Comment);
                    return;

                case 33: // '!'
                    tokeniser.error(this);
                    tokeniser.transition(CommentEndBang);
                    return;

                case 45: // '-'
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append('-');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }

        };
        CommentEndBang = new TokeniserState("CommentEndBang", 49) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.commentPending.data.append("--!").append(c);
                    tokeniser.transition(Comment);
                    return;

                case 45: // '-'
                    tokeniser.commentPending.data.append("--!");
                    tokeniser.transition(CommentEndDash);
                    return;

                case 62: // '>'
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append("--!").append('\uFFFD');
                    tokeniser.transition(Comment);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.emitCommentPending();
                tokeniser.transition(Data);
            }

        };
        Doctype = new TokeniserState("Doctype", 50) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.transition(BeforeDoctypeName);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BeforeDoctypeName);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        BeforeDoctypeName = new TokeniserState("BeforeDoctypeName", 51) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (!characterreader.matchesLetter()) goto _L2; else goto _L1
_L1:
                tokeniser.createDoctypePending();
                tokeniser.transition(DoctypeName);
_L4:
                return;
_L2:
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.name.append(c);
                    tokeniser.transition(DoctypeName);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    break;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.doctypePending.name.append('\uFFFD');
                    tokeniser.transition(DoctypeName);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break; /* Loop/switch isn't completed */
                }
                if (true) goto _L4; else goto _L3
_L3:
                tokeniser.createDoctypePending();
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
                return;
            }

        };
        DoctypeName = new TokeniserState("DoctypeName", 52) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.matchesLetter())
                {
                    characterreader = characterreader.consumeLetterSequence();
                    tokeniser.doctypePending.name.append(characterreader.toLowerCase());
                    return;
                }
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.doctypePending.name.append(c);
                    return;

                case 62: // '>'
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(AfterDoctypeName);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.doctypePending.name.append('\uFFFD');
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        AfterDoctypeName = new TokeniserState("AfterDoctypeName", 53) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                if (characterreader.isEmpty())
                {
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                }
                if (characterreader.matchesAny(new char[] {
            '\t', '\n', '\f', ' '
        }))
                {
                    characterreader.advance();
                    return;
                }
                if (characterreader.matches('>'))
                {
                    tokeniser.emitDoctypePending();
                    tokeniser.advanceTransition(Data);
                    return;
                }
                if (characterreader.matchConsumeIgnoreCase("PUBLIC"))
                {
                    tokeniser.transition(AfterDoctypePublicKeyword);
                    return;
                }
                if (characterreader.matchConsumeIgnoreCase("SYSTEM"))
                {
                    tokeniser.transition(AfterDoctypeSystemKeyword);
                    return;
                } else
                {
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.advanceTransition(BogusDoctype);
                    return;
                }
            }

        };
        AfterDoctypePublicKeyword = new TokeniserState("AfterDoctypePublicKeyword", 54) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BeforeDoctypePublicIdentifier);
                    return;

                case 34: // '"'
                    tokeniser.error(this);
                    tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                    return;

                case 39: // '\''
                    tokeniser.error(this);
                    tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        BeforeDoctypePublicIdentifier = new TokeniserState("BeforeDoctypePublicIdentifier", 55) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 34: // '"'
                    tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                    return;

                case 39: // '\''
                    tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        DoctypePublicIdentifier_doubleQuoted = new TokeniserState("DoctypePublicIdentifier_doubleQuoted", 56) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.doctypePending.publicIdentifier.append(c);
                    return;

                case 34: // '"'
                    tokeniser.transition(AfterDoctypePublicIdentifier);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.doctypePending.publicIdentifier.append('\uFFFD');
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        DoctypePublicIdentifier_singleQuoted = new TokeniserState("DoctypePublicIdentifier_singleQuoted", 57) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.doctypePending.publicIdentifier.append(c);
                    return;

                case 39: // '\''
                    tokeniser.transition(AfterDoctypePublicIdentifier);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.doctypePending.publicIdentifier.append('\uFFFD');
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        AfterDoctypePublicIdentifier = new TokeniserState("AfterDoctypePublicIdentifier", 58) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BetweenDoctypePublicAndSystemIdentifiers);
                    return;

                case 62: // '>'
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;

                case 39: // '\''
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        BetweenDoctypePublicAndSystemIdentifiers = new TokeniserState("BetweenDoctypePublicAndSystemIdentifiers", 59) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 62: // '>'
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;

                case 39: // '\''
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        AfterDoctypeSystemKeyword = new TokeniserState("AfterDoctypeSystemKeyword", 60) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    return;

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    tokeniser.transition(BeforeDoctypeSystemIdentifier);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 34: // '"'
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;

                case 39: // '\''
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        BeforeDoctypeSystemIdentifier = new TokeniserState("BeforeDoctypeSystemIdentifier", 61) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 34: // '"'
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;

                case 39: // '\''
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        DoctypeSystemIdentifier_doubleQuoted = new TokeniserState("DoctypeSystemIdentifier_doubleQuoted", 62) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.doctypePending.systemIdentifier.append(c);
                    return;

                case 34: // '"'
                    tokeniser.transition(AfterDoctypeSystemIdentifier);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.doctypePending.systemIdentifier.append('\uFFFD');
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        DoctypeSystemIdentifier_singleQuoted = new TokeniserState("DoctypeSystemIdentifier_singleQuoted", 63) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                char c = characterreader.consume();
                switch (c)
                {
                default:
                    tokeniser.doctypePending.systemIdentifier.append(c);
                    return;

                case 39: // '\''
                    tokeniser.transition(AfterDoctypeSystemIdentifier);
                    return;

                case 0: // '\0'
                    tokeniser.error(this);
                    tokeniser.doctypePending.systemIdentifier.append('\uFFFD');
                    return;

                case 62: // '>'
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        AfterDoctypeSystemIdentifier = new TokeniserState("AfterDoctypeSystemIdentifier", 64) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    tokeniser.error(this);
                    tokeniser.transition(BogusDoctype);
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 32: // ' '
                    return;

                case 62: // '>'
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.eofError(this);
                    break;
                }
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            }

        };
        BogusDoctype = new TokeniserState("BogusDoctype", 65) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                switch (characterreader.consume())
                {
                default:
                    return;

                case 62: // '>'
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;

                case 65535: 
                    tokeniser.emitDoctypePending();
                    break;
                }
                tokeniser.transition(Data);
            }

        };
        CdataSection = new TokeniserState("CdataSection", 66) {

            void read(Tokeniser tokeniser, CharacterReader characterreader)
            {
                tokeniser.emit(characterreader.consumeTo("]]>"));
                characterreader.matchConsume("]]>");
                tokeniser.transition(Data);
            }

        };
        $VALUES = (new TokeniserState[] {
            Data, CharacterReferenceInData, Rcdata, CharacterReferenceInRcdata, Rawtext, ScriptData, PLAINTEXT, TagOpen, EndTagOpen, TagName, 
            RcdataLessthanSign, RCDATAEndTagOpen, RCDATAEndTagName, RawtextLessthanSign, RawtextEndTagOpen, RawtextEndTagName, ScriptDataLessthanSign, ScriptDataEndTagOpen, ScriptDataEndTagName, ScriptDataEscapeStart, 
            ScriptDataEscapeStartDash, ScriptDataEscaped, ScriptDataEscapedDash, ScriptDataEscapedDashDash, ScriptDataEscapedLessthanSign, ScriptDataEscapedEndTagOpen, ScriptDataEscapedEndTagName, ScriptDataDoubleEscapeStart, ScriptDataDoubleEscaped, ScriptDataDoubleEscapedDash, 
            ScriptDataDoubleEscapedDashDash, ScriptDataDoubleEscapedLessthanSign, ScriptDataDoubleEscapeEnd, BeforeAttributeName, AttributeName, AfterAttributeName, BeforeAttributeValue, AttributeValue_doubleQuoted, AttributeValue_singleQuoted, AttributeValue_unquoted, 
            AfterAttributeValue_quoted, SelfClosingStartTag, BogusComment, MarkupDeclarationOpen, CommentStart, CommentStartDash, Comment, CommentEndDash, CommentEnd, CommentEndBang, 
            Doctype, BeforeDoctypeName, DoctypeName, AfterDoctypeName, AfterDoctypePublicKeyword, BeforeDoctypePublicIdentifier, DoctypePublicIdentifier_doubleQuoted, DoctypePublicIdentifier_singleQuoted, AfterDoctypePublicIdentifier, BetweenDoctypePublicAndSystemIdentifiers, 
            AfterDoctypeSystemKeyword, BeforeDoctypeSystemIdentifier, DoctypeSystemIdentifier_doubleQuoted, DoctypeSystemIdentifier_singleQuoted, AfterDoctypeSystemIdentifier, BogusDoctype, CdataSection
        });
    }

}
