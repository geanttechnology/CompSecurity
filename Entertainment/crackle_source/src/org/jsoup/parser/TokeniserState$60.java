// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            TokeniserState, CharacterReader, Tokeniser

static final class it> extends TokeniserState
{

    void read(Tokeniser tokeniser, CharacterReader characterreader)
    {
        switch (characterreader.consume())
        {
        default:
            tokeniser.error(this);
            tokeniser.doctypePending.eQuirks = true;
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
        tokeniser.doctypePending.eQuirks = true;
        tokeniser.emitDoctypePending();
        tokeniser.transition(Data);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
