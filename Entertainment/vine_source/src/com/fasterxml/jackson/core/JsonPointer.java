// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.NumberInput;

public class JsonPointer
{

    protected static final JsonPointer EMPTY = new JsonPointer();
    protected final String _asString;
    protected final int _matchingElementIndex;
    protected final String _matchingPropertyName;
    protected final JsonPointer _nextSegment;

    protected JsonPointer()
    {
        _nextSegment = null;
        _matchingPropertyName = "";
        _matchingElementIndex = -1;
        _asString = "";
    }

    protected JsonPointer(String s, String s1, JsonPointer jsonpointer)
    {
        _asString = s;
        _nextSegment = jsonpointer;
        _matchingPropertyName = s1;
        _matchingElementIndex = _parseIndex(s1);
    }

    private static void _appendEscape(StringBuilder stringbuilder, char c)
    {
        if (c == '0')
        {
            c = '~';
        } else
        if (c == '1')
        {
            c = '/';
        } else
        {
            stringbuilder.append('~');
        }
        stringbuilder.append(c);
    }

    private static final int _parseIndex(String s)
    {
        int j = s.length();
        if (j != 0 && j <= 10) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int i = 0;
_L4:
        char c;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        c = s.charAt(i);
        if (c > '9' || c < '0') goto _L1; else goto _L3
_L3:
        i = i + 1 + 1;
          goto _L4
        if (j == 10 && NumberInput.parseLong(s) > 0x7fffffffL) goto _L1; else goto _L5
_L5:
        return NumberInput.parseInt(s);
    }

    protected static JsonPointer _parseQuotedTail(String s, int i)
    {
        int j = s.length();
        StringBuilder stringbuilder = new StringBuilder(Math.max(16, j));
        if (i > 2)
        {
            stringbuilder.append(s, 1, i - 1);
        }
        _appendEscape(stringbuilder, s.charAt(i));
        for (i++; i < j;)
        {
            char c = s.charAt(i);
            if (c == '/')
            {
                return new JsonPointer(s, stringbuilder.toString(), _parseTail(s.substring(i)));
            }
            i++;
            if (c == '~' && i < j)
            {
                _appendEscape(stringbuilder, s.charAt(i));
                i++;
            } else
            {
                stringbuilder.append(c);
            }
        }

        return new JsonPointer(s, stringbuilder.toString(), EMPTY);
    }

    protected static JsonPointer _parseTail(String s)
    {
        int j = s.length();
        for (int i = 1; i < j;)
        {
            char c = s.charAt(i);
            if (c == '/')
            {
                return new JsonPointer(s, s.substring(1, i), _parseTail(s.substring(i)));
            }
            i++;
            if (c == '~' && i < j)
            {
                return _parseQuotedTail(s, i);
            }
        }

        return new JsonPointer(s, s.substring(1), EMPTY);
    }

    public static JsonPointer compile(String s)
        throws IllegalArgumentException
    {
        if (s == null || s.length() == 0)
        {
            return EMPTY;
        }
        if (s.charAt(0) != '/')
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid input: JSON Pointer expression must start with '/': \"").append(s).append("\"").toString());
        } else
        {
            return _parseTail(s);
        }
    }

    public static JsonPointer valueOf(String s)
    {
        return compile(s);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof JsonPointer)
                {
                    return _asString.equals(((JsonPointer)obj)._asString);
                }
            }
        }
        return flag;
    }

    public int getMatchingIndex()
    {
        return _matchingElementIndex;
    }

    public String getMatchingProperty()
    {
        return _matchingPropertyName;
    }

    public int hashCode()
    {
        return _asString.hashCode();
    }

    public JsonPointer matchElement(int i)
    {
        if (i != _matchingElementIndex || i < 0)
        {
            return null;
        } else
        {
            return _nextSegment;
        }
    }

    public JsonPointer matchProperty(String s)
    {
        if (_nextSegment == null || !_matchingPropertyName.equals(s))
        {
            return null;
        } else
        {
            return _nextSegment;
        }
    }

    public boolean matches()
    {
        return _nextSegment == null;
    }

    public boolean mayMatchElement()
    {
        return _matchingElementIndex >= 0;
    }

    public boolean mayMatchProperty()
    {
        return _matchingPropertyName != null;
    }

    public JsonPointer tail()
    {
        return _nextSegment;
    }

    public String toString()
    {
        return _asString;
    }

}
