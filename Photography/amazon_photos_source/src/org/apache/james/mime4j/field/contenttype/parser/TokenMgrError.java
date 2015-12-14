// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.field.contenttype.parser;


public class TokenMgrError extends Error
{

    int errorCode;

    public TokenMgrError()
    {
    }

    public TokenMgrError(String s, int i)
    {
        super(s);
        errorCode = i;
    }

    public TokenMgrError(boolean flag, int i, int j, int k, String s, char c, int l)
    {
        this(LexicalError(flag, i, j, k, s, c), l);
    }

    protected static String LexicalError(boolean flag, int i, int j, int k, String s, char c)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("Lexical error at line ").append(j).append(", column ").append(k).append(".  Encountered: ");
        String s1;
        if (flag)
        {
            s1 = "<EOF> ";
        } else
        {
            s1 = (new StringBuilder()).append("\"").append(addEscapes(String.valueOf(c))).append("\"").append(" (").append(c).append("), ").toString();
        }
        return stringbuilder.append(s1).append("after : \"").append(addEscapes(s)).append("\"").toString();
    }

    protected static final String addEscapes(String s)
    {
        StringBuffer stringbuffer;
        int i;
        stringbuffer = new StringBuffer();
        i = 0;
_L12:
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_287;
        }
        s.charAt(i);
        JVM INSTR lookupswitch 9: default 108
    //                   0: 189
    //                   8: 198
    //                   9: 208
    //                   10: 218
    //                   12: 228
    //                   13: 238
    //                   34: 248
    //                   39: 258
    //                   92: 268;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_268;
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
        return super.getMessage();
    }
}
