// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field.contenttype.parser;


// Referenced classes of package org.apache.james.mime4j.field.contenttype.parser:
//            Token

public class ParseException extends org.apache.james.mime4j.field.ParseException
{

    public Token currentToken;
    protected String eol;
    public int expectedTokenSequences[][];
    protected boolean specialConstructor;
    public String tokenImage[];

    public ParseException()
    {
        super("Cannot parse field");
        eol = System.getProperty("line.separator", "\n");
        specialConstructor = false;
    }

    public ParseException(String s)
    {
        super(s);
        eol = System.getProperty("line.separator", "\n");
        specialConstructor = false;
    }

    public ParseException(Token token, int ai[][], String as[])
    {
        super("");
        eol = System.getProperty("line.separator", "\n");
        specialConstructor = true;
        currentToken = token;
        expectedTokenSequences = ai;
        tokenImage = as;
    }

    protected String add_escapes(String s)
    {
        StringBuffer stringbuffer;
        int i;
        stringbuffer = new StringBuffer();
        i = 0;
_L12:
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_291;
        }
        s.charAt(i);
        JVM INSTR lookupswitch 9: default 108
    //                   0: 193
    //                   8: 202
    //                   9: 212
    //                   10: 222
    //                   12: 232
    //                   13: 242
    //                   34: 252
    //                   39: 262
    //                   92: 272;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_272;
_L3:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        char c = s.charAt(i);
        if (c < ' ' || c > '~')
        {
            String s1 = (new StringBuilder()).append("0000").append(Integer.toString(c, 16)).toString();
            stringbuffer.append((new StringBuilder()).append("\\u").append(s1.substring(s1.length() - 4, s1.length())).toString());
        } else
        {
            stringbuffer.append(c);
        }
_L13:
        i++;
        if (true) goto _L12; else goto _L11
_L11:
        stringbuffer.append("\\b");
          goto _L13
_L4:
        stringbuffer.append("\\t");
          goto _L13
_L5:
        stringbuffer.append("\\n");
          goto _L13
_L6:
        stringbuffer.append("\\f");
          goto _L13
_L7:
        stringbuffer.append("\\r");
          goto _L13
_L8:
        stringbuffer.append("\\\"");
          goto _L13
_L9:
        stringbuffer.append("\\'");
          goto _L13
        stringbuffer.append("\\\\");
          goto _L13
        return stringbuffer.toString();
    }

    public String getMessage()
    {
        if (!specialConstructor)
        {
            return super.getMessage();
        }
        StringBuffer stringbuffer = new StringBuffer();
        int k = 0;
        for (int i = 0; i < expectedTokenSequences.length;)
        {
            int l = k;
            if (k < expectedTokenSequences[i].length)
            {
                l = expectedTokenSequences[i].length;
            }
            for (k = 0; k < expectedTokenSequences[i].length; k++)
            {
                stringbuffer.append(tokenImage[expectedTokenSequences[i][k]]).append(" ");
            }

            if (expectedTokenSequences[i][expectedTokenSequences[i].length - 1] != 0)
            {
                stringbuffer.append("...");
            }
            stringbuffer.append(eol).append("    ");
            i++;
            k = l;
        }

        String s = "Encountered \"";
        Token token = currentToken.next;
        int j = 0;
        do
        {
label0:
            {
                String s1 = s;
                if (j < k)
                {
                    s1 = s;
                    if (j != 0)
                    {
                        s1 = (new StringBuilder()).append(s).append(" ").toString();
                    }
                    if (token.kind != 0)
                    {
                        break label0;
                    }
                    s1 = (new StringBuilder()).append(s1).append(tokenImage[0]).toString();
                }
                s = (new StringBuilder()).append(s1).append("\" at line ").append(currentToken.next.beginLine).append(", column ").append(currentToken.next.beginColumn).toString();
                s = (new StringBuilder()).append(s).append(".").append(eol).toString();
                if (expectedTokenSequences.length == 1)
                {
                    s = (new StringBuilder()).append(s).append("Was expecting:").append(eol).append("    ").toString();
                } else
                {
                    s = (new StringBuilder()).append(s).append("Was expecting one of:").append(eol).append("    ").toString();
                }
                return (new StringBuilder()).append(s).append(stringbuffer.toString()).toString();
            }
            s = (new StringBuilder()).append(s1).append(add_escapes(token.image)).toString();
            token = token.next;
            j++;
        } while (true);
    }
}
