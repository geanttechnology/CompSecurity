// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field.contenttype.parser;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// Referenced classes of package org.apache.james.mime4j.field.contenttype.parser:
//            ContentTypeParserConstants, SimpleCharStream, ContentTypeParserTokenManager, Token, 
//            ParseException

public class ContentTypeParser
    implements ContentTypeParserConstants
{

    private static int jj_la1_0[];
    private Vector jj_expentries;
    private int jj_expentry[];
    private int jj_gen;
    SimpleCharStream jj_input_stream;
    private int jj_kind;
    private final int jj_la1[] = new int[3];
    public Token jj_nt;
    private int jj_ntk;
    private List paramNames;
    private List paramValues;
    private String subtype;
    public Token token;
    public ContentTypeParserTokenManager token_source;
    private String type;

    public ContentTypeParser(Reader reader)
    {
        paramNames = new ArrayList();
        paramValues = new ArrayList();
        jj_expentries = new Vector();
        jj_kind = -1;
        jj_input_stream = new SimpleCharStream(reader, 1, 1);
        token_source = new ContentTypeParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 3; i++)
        {
            jj_la1[i] = -1;
        }

    }

    private final Token jj_consume_token(int i)
        throws ParseException
    {
        Token token1 = token;
        if (token1.next != null)
        {
            token = token.next;
        } else
        {
            Token token2 = token;
            Token token3 = token_source.getNextToken();
            token2.next = token3;
            token = token3;
        }
        jj_ntk = -1;
        if (token.kind == i)
        {
            jj_gen = jj_gen + 1;
            return token;
        } else
        {
            token = token1;
            jj_kind = i;
            throw generateParseException();
        }
    }

    private static void jj_la1_0()
    {
        jj_la1_0 = (new int[] {
            2, 16, 0x380000
        });
    }

    private final int jj_ntk()
    {
        Token token1 = token.next;
        jj_nt = token1;
        if (token1 == null)
        {
            Token token2 = token;
            Token token3 = token_source.getNextToken();
            token2.next = token3;
            int i = token3.kind;
            jj_ntk = i;
            return i;
        } else
        {
            int j = jj_nt.kind;
            jj_ntk = j;
            return j;
        }
    }

    public ParseException generateParseException()
    {
        jj_expentries.removeAllElements();
        Object obj = new boolean[24];
        for (int i = 0; i < 24; i++)
        {
            obj[i] = false;
        }

        if (jj_kind >= 0)
        {
            obj[jj_kind] = true;
            jj_kind = -1;
        }
        for (int j = 0; j < 3; j++)
        {
            if (jj_la1[j] != jj_gen)
            {
                continue;
            }
            for (int i1 = 0; i1 < 32; i1++)
            {
                if ((jj_la1_0[j] & 1 << i1) != 0)
                {
                    obj[i1] = true;
                }
            }

        }

        for (int k = 0; k < 24; k++)
        {
            if (obj[k])
            {
                jj_expentry = new int[1];
                jj_expentry[0] = k;
                jj_expentries.addElement(jj_expentry);
            }
        }

        obj = new int[jj_expentries.size()][];
        for (int l = 0; l < jj_expentries.size(); l++)
        {
            obj[l] = (int[])(int[])jj_expentries.elementAt(l);
        }

        return new ParseException(token, ((int [][]) (obj)), tokenImage);
    }

    public List getParamNames()
    {
        return paramNames;
    }

    public List getParamValues()
    {
        return paramValues;
    }

    public String getSubType()
    {
        return subtype;
    }

    public String getType()
    {
        return type;
    }

    public final void parameter()
        throws ParseException
    {
        Token token1 = jj_consume_token(21);
        jj_consume_token(5);
        String s = value();
        paramNames.add(token1.image);
        paramValues.add(s);
    }

    public final void parse()
        throws ParseException
    {
        Token token1 = jj_consume_token(21);
        jj_consume_token(3);
        Token token2 = jj_consume_token(21);
        type = token1.image;
        subtype = token2.image;
        do
        {
            int i;
            if (jj_ntk == -1)
            {
                i = jj_ntk();
            } else
            {
                i = jj_ntk;
            }
            switch (i)
            {
            default:
                jj_la1[1] = jj_gen;
                return;

            case 4: // '\004'
                jj_consume_token(4);
                break;
            }
            parameter();
        } while (true);
    }

    public final void parseAll()
        throws ParseException
    {
        parse();
        jj_consume_token(0);
    }

    public final String value()
        throws ParseException
    {
        int i;
        if (jj_ntk == -1)
        {
            i = jj_ntk();
        } else
        {
            i = jj_ntk;
        }
        i;
        JVM INSTR tableswitch 19 21: default 40
    //                   19 94
    //                   20 84
    //                   21 72;
           goto _L1 _L2 _L3 _L4
_L1:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
_L4:
        Token token1 = jj_consume_token(21);
_L6:
        return token1.image;
_L3:
        token1 = jj_consume_token(20);
        continue; /* Loop/switch isn't completed */
_L2:
        token1 = jj_consume_token(19);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        jj_la1_0();
    }
}
