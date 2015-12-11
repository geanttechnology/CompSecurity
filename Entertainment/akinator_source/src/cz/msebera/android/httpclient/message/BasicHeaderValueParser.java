// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.message:
//            HeaderValueParser, ParserCursor, BasicHeaderElement, BasicNameValuePair

public class BasicHeaderValueParser
    implements HeaderValueParser
{

    private static final char ALL_DELIMITERS[] = {
        ';', ','
    };
    public static final BasicHeaderValueParser DEFAULT = new BasicHeaderValueParser();
    private static final char ELEM_DELIMITER = 44;
    public static final BasicHeaderValueParser INSTANCE = new BasicHeaderValueParser();
    private static final char PARAM_DELIMITER = 59;

    public BasicHeaderValueParser()
    {
    }

    private static boolean isOneOf(char c, char ac[])
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (ac == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = ac.length;
        i = 0;
_L7:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L3
_L3:
        if (c != ac[i]) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static HeaderElement[] parseElements(String s, HeaderValueParser headervalueparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (headervalueparser == null)
        {
            headervalueparser = INSTANCE;
        }
        return headervalueparser.parseElements(chararraybuffer, s);
    }

    public static HeaderElement parseHeaderElement(String s, HeaderValueParser headervalueparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (headervalueparser == null)
        {
            headervalueparser = INSTANCE;
        }
        return headervalueparser.parseHeaderElement(chararraybuffer, s);
    }

    public static NameValuePair parseNameValuePair(String s, HeaderValueParser headervalueparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (headervalueparser == null)
        {
            headervalueparser = INSTANCE;
        }
        return headervalueparser.parseNameValuePair(chararraybuffer, s);
    }

    public static NameValuePair[] parseParameters(String s, HeaderValueParser headervalueparser)
        throws ParseException
    {
        Args.notNull(s, "Value");
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(s.length());
        chararraybuffer.append(s);
        s = new ParserCursor(0, s.length());
        if (headervalueparser == null)
        {
            headervalueparser = INSTANCE;
        }
        return headervalueparser.parseParameters(chararraybuffer, s);
    }

    protected HeaderElement createHeaderElement(String s, String s1, NameValuePair anamevaluepair[])
    {
        return new BasicHeaderElement(s, s1, anamevaluepair);
    }

    protected NameValuePair createNameValuePair(String s, String s1)
    {
        return new BasicNameValuePair(s, s1);
    }

    public HeaderElement[] parseElements(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
    {
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        ArrayList arraylist = new ArrayList();
        do
        {
            if (parsercursor.atEnd())
            {
                break;
            }
            HeaderElement headerelement = parseHeaderElement(chararraybuffer, parsercursor);
            if (headerelement.getName().length() != 0 || headerelement.getValue() != null)
            {
                arraylist.add(headerelement);
            }
        } while (true);
        return (HeaderElement[])arraylist.toArray(new HeaderElement[arraylist.size()]);
    }

    public HeaderElement parseHeaderElement(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
    {
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        NameValuePair namevaluepair = parseNameValuePair(chararraybuffer, parsercursor);
        Object obj = null;
        NameValuePair anamevaluepair[] = obj;
        if (!parsercursor.atEnd())
        {
            anamevaluepair = obj;
            if (chararraybuffer.charAt(parsercursor.getPos() - 1) != ',')
            {
                anamevaluepair = parseParameters(chararraybuffer, parsercursor);
            }
        }
        return createHeaderElement(namevaluepair.getName(), namevaluepair.getValue(), anamevaluepair);
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
    {
        return parseNameValuePair(chararraybuffer, parsercursor, ALL_DELIMITERS);
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer chararraybuffer, ParserCursor parsercursor, char ac[])
    {
        int i;
        int k;
        int l;
        int j2;
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        k = 0;
        i = parsercursor.getPos();
        l = parsercursor.getPos();
        j2 = parsercursor.getUpperBound();
_L2:
        String s;
        boolean flag;
        flag = k;
        if (i < j2)
        {
            char c = chararraybuffer.charAt(i);
            if (c == '=')
            {
                flag = k;
            } else
            {
label0:
                {
                    if (!isOneOf(c, ac))
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
        }
        if (i == j2)
        {
            flag = true;
            s = chararraybuffer.substringTrimmed(l, j2);
        } else
        {
            s = chararraybuffer.substringTrimmed(l, i);
            i++;
        }
        if (flag)
        {
            parsercursor.updatePos(i);
            return createNameValuePair(s, null);
        }
        break; /* Loop/switch isn't completed */
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        int i1;
        int k1;
        int i2;
        i1 = i;
        i2 = 0;
        k1 = 0;
_L4:
        char c1;
        int j;
        boolean flag1;
label1:
        {
            flag1 = flag;
            if (i < j2)
            {
                c1 = chararraybuffer.charAt(i);
                k = i2;
                if (c1 == '"')
                {
                    k = i2;
                    if (k1 == 0)
                    {
                        if (i2 == 0)
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                    }
                }
                if (k != 0 || k1 != 0 || !isOneOf(c1, ac))
                {
                    break label1;
                }
                flag1 = true;
            }
            k1 = i;
            j = i1;
            do
            {
                k = k1;
                if (j >= k1)
                {
                    break;
                }
                k = k1;
                if (!HTTP.isWhitespace(chararraybuffer.charAt(j)))
                {
                    break;
                }
                j++;
            } while (true);
            break MISSING_BLOCK_LABEL_325;
        }
        if (k1 == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = false;
_L5:
        i++;
        k1 = ((flag1) ? 1 : 0);
        i2 = k;
        if (true) goto _L4; else goto _L3
_L3:
        if (k != 0 && c1 == '\\')
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        for (; k > j && HTTP.isWhitespace(chararraybuffer.charAt(k - 1)); k--) { }
        int l1 = j;
        int j1 = k;
        if (k - j >= 2)
        {
            l1 = j;
            j1 = k;
            if (chararraybuffer.charAt(j) == '"')
            {
                l1 = j;
                j1 = k;
                if (chararraybuffer.charAt(k - 1) == '"')
                {
                    l1 = j + 1;
                    j1 = k - 1;
                }
            }
        }
        chararraybuffer = chararraybuffer.substring(l1, j1);
        j = i;
        if (flag1)
        {
            j = i + 1;
        }
        parsercursor.updatePos(j);
        return createNameValuePair(s, chararraybuffer);
    }

    public NameValuePair[] parseParameters(CharArrayBuffer chararraybuffer, ParserCursor parsercursor)
    {
        Args.notNull(chararraybuffer, "Char array buffer");
        Args.notNull(parsercursor, "Parser cursor");
        int i = parsercursor.getPos();
        for (int j = parsercursor.getUpperBound(); i < j && HTTP.isWhitespace(chararraybuffer.charAt(i)); i++) { }
        parsercursor.updatePos(i);
        if (parsercursor.atEnd())
        {
            return new NameValuePair[0];
        }
        ArrayList arraylist = new ArrayList();
        do
        {
            if (parsercursor.atEnd())
            {
                break;
            }
            arraylist.add(parseNameValuePair(chararraybuffer, parsercursor));
        } while (chararraybuffer.charAt(parsercursor.getPos() - 1) != ',');
        return (NameValuePair[])arraylist.toArray(new NameValuePair[arraylist.size()]);
    }

}
