// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.CharsetUtil;
import org.apache.james.mime4j.util.ContentUtil;

// Referenced classes of package org.apache.james.mime4j.stream:
//            ParserCursor, RawField, NameValuePair, RawBody

public class RawFieldParser
{

    static final BitSet COLON = INIT_BITSET(new int[] {
        58
    });
    public static final RawFieldParser DEFAULT = new RawFieldParser();
    static final BitSet EQUAL_OR_SEMICOLON = INIT_BITSET(new int[] {
        61, 59
    });
    static final BitSet SEMICOLON = INIT_BITSET(new int[] {
        59
    });

    public RawFieldParser()
    {
    }

    public static transient BitSet INIT_BITSET(int ai[])
    {
        BitSet bitset = new BitSet(ai.length);
        for (int i = 0; i < ai.length; i++)
        {
            bitset.set(ai[i]);
        }

        return bitset;
    }

    public void copyContent(ByteSequence bytesequence, ParserCursor parsercursor, BitSet bitset, StringBuilder stringbuilder)
    {
        int j = parsercursor.getPos();
        int i = parsercursor.getPos();
        int k = parsercursor.getUpperBound();
        do
        {
            char c;
label0:
            {
                if (i < k)
                {
                    c = (char)(bytesequence.byteAt(i) & 0xff);
                    if ((bitset == null || !bitset.get(c)) && !CharsetUtil.isWhitespace(c) && c != '(')
                    {
                        break label0;
                    }
                }
                parsercursor.updatePos(j);
                return;
            }
            j++;
            stringbuilder.append(c);
            i++;
        } while (true);
    }

    public void copyQuotedContent(ByteSequence bytesequence, ParserCursor parsercursor, StringBuilder stringbuilder)
    {
        if (!parsercursor.atEnd()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        int i1;
        i = parsercursor.getPos();
        j = parsercursor.getPos();
        i1 = parsercursor.getUpperBound();
        if ((char)(bytesequence.byteAt(i) & 0xff) != '"') goto _L1; else goto _L3
_L3:
        int k;
        int l;
        i++;
        l = 0;
        k = j + 1;
_L8:
        j = i;
        if (k >= i1) goto _L5; else goto _L4
_L4:
        char c = (char)(bytesequence.byteAt(k) & 0xff);
        if (l == 0) goto _L7; else goto _L6
_L6:
        if (c != '"' && c != '\\')
        {
            stringbuilder.append('\\');
        }
        stringbuilder.append(c);
        j = 0;
_L9:
        k++;
        i++;
        l = j;
          goto _L8
_L7:
        if (c != '"')
        {
            break MISSING_BLOCK_LABEL_160;
        }
        j = i + 1;
_L5:
        parsercursor.updatePos(j);
        return;
        if (c == '\\')
        {
            j = 1;
        } else
        {
            j = l;
            if (c != '\r')
            {
                j = l;
                if (c != '\n')
                {
                    stringbuilder.append(c);
                    j = l;
                }
            }
        }
          goto _L9
    }

    public RawField parseField(ByteSequence bytesequence)
        throws MimeException
    {
        if (bytesequence == null)
        {
            return null;
        }
        ParserCursor parsercursor = new ParserCursor(0, bytesequence.length());
        String s = parseToken(bytesequence, parsercursor, COLON);
        if (parsercursor.atEnd())
        {
            throw new MimeException((new StringBuilder()).append("Invalid MIME field: no name/value separator found: ").append(bytesequence.toString()).toString());
        } else
        {
            return new RawField(bytesequence, parsercursor.getPos(), s, null);
        }
    }

    public NameValuePair parseParameter(ByteSequence bytesequence, ParserCursor parsercursor)
    {
        String s = parseToken(bytesequence, parsercursor, EQUAL_OR_SEMICOLON);
        if (parsercursor.atEnd())
        {
            return new NameValuePair(s, null);
        }
        byte byte0 = bytesequence.byteAt(parsercursor.getPos());
        parsercursor.updatePos(parsercursor.getPos() + 1);
        if (byte0 == 59)
        {
            return new NameValuePair(s, null);
        }
        bytesequence = parseValue(bytesequence, parsercursor, SEMICOLON);
        if (!parsercursor.atEnd())
        {
            parsercursor.updatePos(parsercursor.getPos() + 1);
        }
        return new NameValuePair(s, bytesequence);
    }

    public List parseParameters(ByteSequence bytesequence, ParserCursor parsercursor)
    {
        ArrayList arraylist = new ArrayList();
        skipWhiteSpace(bytesequence, parsercursor);
        for (; !parsercursor.atEnd(); arraylist.add(parseParameter(bytesequence, parsercursor))) { }
        return arraylist;
    }

    public RawBody parseRawBody(RawField rawfield)
    {
        ByteSequence bytesequence1 = rawfield.getRaw();
        int i = rawfield.getDelimiterIdx() + 1;
        ByteSequence bytesequence = bytesequence1;
        if (bytesequence1 == null)
        {
            rawfield = rawfield.getBody();
            if (rawfield == null)
            {
                return new RawBody("", null);
            }
            bytesequence = ContentUtil.encode(rawfield);
            i = 0;
        }
        return parseRawBody(bytesequence, new ParserCursor(i, bytesequence.length()));
    }

    public RawBody parseRawBody(ByteSequence bytesequence, ParserCursor parsercursor)
    {
        String s = parseToken(bytesequence, parsercursor, SEMICOLON);
        if (parsercursor.atEnd())
        {
            return new RawBody(s, new ArrayList());
        } else
        {
            parsercursor.updatePos(parsercursor.getPos() + 1);
            return new RawBody(s, parseParameters(bytesequence, parsercursor));
        }
    }

    public String parseToken(ByteSequence bytesequence, ParserCursor parsercursor, BitSet bitset)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = false;
        do
        {
            char c;
label0:
            {
                if (!parsercursor.atEnd())
                {
                    c = (char)(bytesequence.byteAt(parsercursor.getPos()) & 0xff);
                    if (bitset == null || !bitset.get(c))
                    {
                        break label0;
                    }
                }
                return stringbuilder.toString();
            }
            if (CharsetUtil.isWhitespace(c))
            {
                skipWhiteSpace(bytesequence, parsercursor);
                flag = true;
            } else
            if (c == '(')
            {
                skipComment(bytesequence, parsercursor);
            } else
            {
                if (stringbuilder.length() > 0 && flag)
                {
                    stringbuilder.append(' ');
                }
                copyContent(bytesequence, parsercursor, bitset, stringbuilder);
                flag = false;
            }
        } while (true);
    }

    public String parseValue(ByteSequence bytesequence, ParserCursor parsercursor, BitSet bitset)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = false;
        do
        {
            char c;
label0:
            {
                if (!parsercursor.atEnd())
                {
                    c = (char)(bytesequence.byteAt(parsercursor.getPos()) & 0xff);
                    if (bitset == null || !bitset.get(c))
                    {
                        break label0;
                    }
                }
                return stringbuilder.toString();
            }
            if (CharsetUtil.isWhitespace(c))
            {
                skipWhiteSpace(bytesequence, parsercursor);
                flag = true;
            } else
            if (c == '(')
            {
                skipComment(bytesequence, parsercursor);
            } else
            if (c == '"')
            {
                if (stringbuilder.length() > 0 && flag)
                {
                    stringbuilder.append(' ');
                }
                copyQuotedContent(bytesequence, parsercursor, stringbuilder);
                flag = false;
            } else
            {
                if (stringbuilder.length() > 0 && flag)
                {
                    stringbuilder.append(' ');
                }
                copyContent(bytesequence, parsercursor, bitset, stringbuilder);
                flag = false;
            }
        } while (true);
    }

    public void skipAllWhiteSpace(ByteSequence bytesequence, ParserCursor parsercursor)
    {
        do
        {
            if (parsercursor.atEnd())
            {
                break;
            }
            char c = (char)(bytesequence.byteAt(parsercursor.getPos()) & 0xff);
            if (CharsetUtil.isWhitespace(c))
            {
                skipWhiteSpace(bytesequence, parsercursor);
                continue;
            }
            if (c != '(')
            {
                break;
            }
            skipComment(bytesequence, parsercursor);
        } while (true);
    }

    public void skipComment(ByteSequence bytesequence, ParserCursor parsercursor)
    {
        if (!parsercursor.atEnd()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        int k1;
        i = parsercursor.getPos();
        j = parsercursor.getPos();
        k1 = parsercursor.getUpperBound();
        if ((char)(bytesequence.byteAt(i) & 0xff) != '(') goto _L1; else goto _L3
_L3:
        int l;
        int i1;
        int j1;
        i++;
        i1 = 1;
        j1 = 0;
        l = j + 1;
_L11:
        j = i;
        if (l >= k1) goto _L5; else goto _L4
_L4:
        char c = (char)(bytesequence.byteAt(l) & 0xff);
        if (j1 == 0) goto _L7; else goto _L6
_L6:
        int k;
        j = 0;
        k = i1;
_L9:
        if (k > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i + 1;
_L5:
        parsercursor.updatePos(j);
        return;
_L7:
        if (c == '\\')
        {
            j = 1;
            k = i1;
        } else
        if (c == '(')
        {
            k = i1 + 1;
            j = j1;
        } else
        {
            j = j1;
            k = i1;
            if (c == ')')
            {
                k = i1 - 1;
                j = j1;
            }
        }
        if (true) goto _L9; else goto _L8
_L8:
        l++;
        i++;
        j1 = j;
        i1 = k;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void skipWhiteSpace(ByteSequence bytesequence, ParserCursor parsercursor)
    {
        int j = parsercursor.getPos();
        int i = parsercursor.getPos();
        int k = parsercursor.getUpperBound();
        do
        {
            if (i >= k || !CharsetUtil.isWhitespace((char)(bytesequence.byteAt(i) & 0xff)))
            {
                parsercursor.updatePos(j);
                return;
            }
            j++;
            i++;
        } while (true);
    }

}
