// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import org.jsoup.helper.Validate;

class CharacterReader
{

    static final char EOF = 65535;
    private final String input;
    private final int length;
    private int mark;
    private int pos;

    CharacterReader(String s)
    {
        pos = 0;
        mark = 0;
        Validate.notNull(s);
        s = s.replaceAll("\r\n?", "\n");
        input = s;
        length = s.length();
    }

    void advance()
    {
        pos = pos + 1;
    }

    char consume()
    {
        char c;
        if (isEmpty())
        {
            c = '\uFFFF';
        } else
        {
            c = input.charAt(pos);
        }
        pos = pos + 1;
        return c;
    }

    String consumeAsString()
    {
        String s = input;
        int i = pos;
        int j = pos;
        pos = j + 1;
        return s.substring(i, j);
    }

    String consumeDigitSequence()
    {
        int i = pos;
        do
        {
            if (isEmpty())
            {
                break;
            }
            char c = input.charAt(pos);
            if (c < '0' || c > '9')
            {
                break;
            }
            pos = pos + 1;
        } while (true);
        return input.substring(i, pos);
    }

    String consumeHexSequence()
    {
        int i = pos;
        do
        {
            if (isEmpty())
            {
                break;
            }
            char c = input.charAt(pos);
            if ((c < '0' || c > '9') && (c < 'A' || c > 'F') && (c < 'a' || c > 'f'))
            {
                break;
            }
            pos = pos + 1;
        } while (true);
        return input.substring(i, pos);
    }

    String consumeLetterSequence()
    {
        int i = pos;
        do
        {
            if (isEmpty())
            {
                break;
            }
            char c = input.charAt(pos);
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'))
            {
                break;
            }
            pos = pos + 1;
        } while (true);
        return input.substring(i, pos);
    }

    String consumeLetterThenDigitSequence()
    {
        int i = pos;
        do
        {
            if (isEmpty())
            {
                break;
            }
            char c = input.charAt(pos);
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'))
            {
                break;
            }
            pos = pos + 1;
        } while (true);
        do
        {
            if (isEmpty())
            {
                break;
            }
            char c1 = input.charAt(pos);
            if (c1 < '0' || c1 > '9')
            {
                break;
            }
            pos = pos + 1;
        } while (true);
        return input.substring(i, pos);
    }

    String consumeTo(char c)
    {
        c = input.indexOf(c, pos);
        if (c != '\uFFFF')
        {
            String s = input.substring(pos, c);
            pos = pos + s.length();
            return s;
        } else
        {
            return consumeToEnd();
        }
    }

    String consumeTo(String s)
    {
        int i = input.indexOf(s, pos);
        if (i != -1)
        {
            s = input.substring(pos, i);
            pos = pos + s.length();
            return s;
        } else
        {
            return consumeToEnd();
        }
    }

    transient String consumeToAny(char ac[])
    {
        int j = pos;
_L7:
        if (isEmpty()) goto _L2; else goto _L1
_L1:
        int i;
        char c;
        int k;
        c = input.charAt(pos);
        k = ac.length;
        i = 0;
_L5:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        if (ac[i] != c) goto _L3; else goto _L2
_L2:
        if (pos > j)
        {
            return input.substring(j, pos);
        } else
        {
            return "";
        }
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        pos = pos + 1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    String consumeToEnd()
    {
        String s = input.substring(pos, input.length());
        pos = input.length();
        return s;
    }

    boolean containsIgnoreCase(String s)
    {
        String s1 = s.toLowerCase();
        s = s.toUpperCase();
        return input.indexOf(s1, pos) > -1 || input.indexOf(s, pos) > -1;
    }

    char current()
    {
        if (isEmpty())
        {
            return '\uFFFF';
        } else
        {
            return input.charAt(pos);
        }
    }

    boolean isEmpty()
    {
        return pos >= length;
    }

    void mark()
    {
        mark = pos;
    }

    boolean matchConsume(String s)
    {
        if (matches(s))
        {
            pos = pos + s.length();
            return true;
        } else
        {
            return false;
        }
    }

    boolean matchConsumeIgnoreCase(String s)
    {
        if (matchesIgnoreCase(s))
        {
            pos = pos + s.length();
            return true;
        } else
        {
            return false;
        }
    }

    boolean matches(char c)
    {
        return !isEmpty() && input.charAt(pos) == c;
    }

    boolean matches(String s)
    {
        return input.startsWith(s, pos);
    }

    transient boolean matchesAny(char ac[])
    {
        if (!isEmpty())
        {
            char c = input.charAt(pos);
            int j = ac.length;
            int i = 0;
            while (i < j) 
            {
                if (ac[i] == c)
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    boolean matchesDigit()
    {
        char c;
        if (!isEmpty())
        {
            if ((c = input.charAt(pos)) >= '0' && c <= '9')
            {
                return true;
            }
        }
        return false;
    }

    boolean matchesIgnoreCase(String s)
    {
        return input.regionMatches(true, pos, s, 0, s.length());
    }

    boolean matchesLetter()
    {
        char c;
        if (!isEmpty())
        {
            if ((c = input.charAt(pos)) >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
            {
                return true;
            }
        }
        return false;
    }

    int pos()
    {
        return pos;
    }

    void rewindToMark()
    {
        pos = mark;
    }

    public String toString()
    {
        return input.substring(pos);
    }

    void unconsume()
    {
        pos = pos - 1;
    }
}
