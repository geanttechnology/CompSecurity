// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Arrays;

// Referenced classes of package com.google.common.base:
//            Predicate, Preconditions

public abstract class CharMatcher
    implements Predicate
{
    private static class And extends CharMatcher
    {

        final CharMatcher first;
        final CharMatcher second;

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return first.matches(c) && second.matches(c);
        }

        CharMatcher withToString(String s)
        {
            return new And(first, second, s);
        }

        And(CharMatcher charmatcher, CharMatcher charmatcher1)
        {
            this(charmatcher, charmatcher1, (new StringBuilder()).append("CharMatcher.and(").append(charmatcher).append(", ").append(charmatcher1).append(")").toString());
        }

        And(CharMatcher charmatcher, CharMatcher charmatcher1, String s)
        {
            super(s);
            first = (CharMatcher)Preconditions.checkNotNull(charmatcher);
            second = (CharMatcher)Preconditions.checkNotNull(charmatcher1);
        }
    }

    static abstract class FastMatcher extends CharMatcher
    {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public CharMatcher negate()
        {
            return new NegatedFastMatcher(this);
        }

        FastMatcher()
        {
        }

        FastMatcher(String s)
        {
            super(s);
        }
    }

    static final class NegatedFastMatcher extends NegatedMatcher
    {

        CharMatcher withToString(String s)
        {
            return new NegatedFastMatcher(s, original);
        }

        NegatedFastMatcher(CharMatcher charmatcher)
        {
            super(charmatcher);
        }

        NegatedFastMatcher(String s, CharMatcher charmatcher)
        {
            super(s, charmatcher);
        }
    }

    private static class NegatedMatcher extends CharMatcher
    {

        final CharMatcher original;

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return !original.matches(c);
        }

        public boolean matchesAllOf(CharSequence charsequence)
        {
            return original.matchesNoneOf(charsequence);
        }

        public boolean matchesNoneOf(CharSequence charsequence)
        {
            return original.matchesAllOf(charsequence);
        }

        public CharMatcher negate()
        {
            return original;
        }

        CharMatcher withToString(String s)
        {
            return new NegatedMatcher(s, original);
        }

        NegatedMatcher(CharMatcher charmatcher)
        {
            this((new StringBuilder()).append(charmatcher).append(".negate()").toString(), charmatcher);
        }

        NegatedMatcher(String s, CharMatcher charmatcher)
        {
            super(s);
            original = charmatcher;
        }
    }

    private static class Or extends CharMatcher
    {

        final CharMatcher first;
        final CharMatcher second;

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return first.matches(c) || second.matches(c);
        }

        CharMatcher withToString(String s)
        {
            return new Or(first, second, s);
        }

        Or(CharMatcher charmatcher, CharMatcher charmatcher1)
        {
            this(charmatcher, charmatcher1, (new StringBuilder()).append("CharMatcher.or(").append(charmatcher).append(", ").append(charmatcher1).append(")").toString());
        }

        Or(CharMatcher charmatcher, CharMatcher charmatcher1, String s)
        {
            super(s);
            first = (CharMatcher)Preconditions.checkNotNull(charmatcher);
            second = (CharMatcher)Preconditions.checkNotNull(charmatcher1);
        }
    }

    private static class RangesMatcher extends CharMatcher
    {

        private final char rangeEnds[];
        private final char rangeStarts[];

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            int i = Arrays.binarySearch(rangeStarts, c);
            if (i < 0)
            {
                if ((i = ~i - 1) < 0 || c > rangeEnds[i])
                {
                    return false;
                }
            }
            return true;
        }

        RangesMatcher(String s, char ac[], char ac1[])
        {
            super(s);
            rangeStarts = ac;
            rangeEnds = ac1;
            int i;
            boolean flag;
            if (ac.length == ac1.length)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            i = 0;
            while (i < ac.length) 
            {
                if (ac[i] <= ac1[i])
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Preconditions.checkArgument(flag);
                if (i + 1 < ac.length)
                {
                    if (ac1[i] < ac[i + 1])
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Preconditions.checkArgument(flag);
                }
                i++;
            }
        }
    }


    public static final CharMatcher ANY = new FastMatcher("CharMatcher.ANY") {

        public CharMatcher and(CharMatcher charmatcher)
        {
            return (CharMatcher)Preconditions.checkNotNull(charmatcher);
        }

        public int indexIn(CharSequence charsequence)
        {
            return charsequence.length() != 0 ? 0 : -1;
        }

        public int indexIn(CharSequence charsequence, int j)
        {
            int l = charsequence.length();
            Preconditions.checkPositionIndex(j, l);
            int k = j;
            if (j == l)
            {
                k = -1;
            }
            return k;
        }

        public boolean matches(char c)
        {
            return true;
        }

        public boolean matchesAllOf(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return true;
        }

        public boolean matchesNoneOf(CharSequence charsequence)
        {
            return charsequence.length() == 0;
        }

        public CharMatcher negate()
        {
            return NONE;
        }

        public CharMatcher or(CharMatcher charmatcher)
        {
            Preconditions.checkNotNull(charmatcher);
            return this;
        }

        public String removeFrom(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return "";
        }

        public String replaceFrom(CharSequence charsequence, char c)
        {
            charsequence = new char[charsequence.length()];
            Arrays.fill(charsequence, c);
            return new String(charsequence);
        }

    };
    public static final CharMatcher ASCII = inRange('\0', '\177', "CharMatcher.ASCII");
    public static final CharMatcher BREAKING_WHITESPACE = new CharMatcher() {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            switch (c)
            {
            default:
                if (c < '\u2000' || c > '\u200A')
                {
                    break;
                }
                // fall through

            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 32: // ' '
            case 133: 
            case 5760: 
            case 8232: 
            case 8233: 
            case 8287: 
            case 12288: 
                return true;

            case 8199: 
                return false;
            }
            return false;
        }

        public String toString()
        {
            return "CharMatcher.BREAKING_WHITESPACE";
        }

    };
    public static final CharMatcher DIGIT;
    public static final CharMatcher INVISIBLE = new RangesMatcher("CharMatcher.INVISIBLE", "\000\177\255\u0600\u06DD\u070F\u1680\u180E\u2000\u2028\u205F\u206A\u3000\uD800\uFEFF\uFFF9\uFFFA".toCharArray(), " \240\255\u0604\u06DD\u070F\u1680\u180E\u200F\u202F\u2064\u206F\u3000\uF8FF\uFEFF\uFFF9\uFFFB".toCharArray());
    public static final CharMatcher JAVA_DIGIT = new CharMatcher("CharMatcher.JAVA_DIGIT") {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isDigit(c);
        }

    };
    public static final CharMatcher JAVA_ISO_CONTROL = inRange('\0', '\037').or(inRange('\177', '\237')).withToString("CharMatcher.JAVA_ISO_CONTROL");
    public static final CharMatcher JAVA_LETTER = new CharMatcher("CharMatcher.JAVA_LETTER") {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isLetter(c);
        }

    };
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = new CharMatcher("CharMatcher.JAVA_LETTER_OR_DIGIT") {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isLetterOrDigit(c);
        }

    };
    public static final CharMatcher JAVA_LOWER_CASE = new CharMatcher("CharMatcher.JAVA_LOWER_CASE") {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isLowerCase(c);
        }

    };
    public static final CharMatcher JAVA_UPPER_CASE = new CharMatcher("CharMatcher.JAVA_UPPER_CASE") {

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isUpperCase(c);
        }

    };
    private static final String NINES;
    public static final CharMatcher NONE = new FastMatcher("CharMatcher.NONE") {

        public CharMatcher and(CharMatcher charmatcher)
        {
            Preconditions.checkNotNull(charmatcher);
            return this;
        }

        public int indexIn(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return -1;
        }

        public int indexIn(CharSequence charsequence, int j)
        {
            Preconditions.checkPositionIndex(j, charsequence.length());
            return -1;
        }

        public boolean matches(char c)
        {
            return false;
        }

        public boolean matchesAllOf(CharSequence charsequence)
        {
            return charsequence.length() == 0;
        }

        public boolean matchesNoneOf(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return true;
        }

        public CharMatcher negate()
        {
            return ANY;
        }

        public CharMatcher or(CharMatcher charmatcher)
        {
            return (CharMatcher)Preconditions.checkNotNull(charmatcher);
        }

        public String removeFrom(CharSequence charsequence)
        {
            return charsequence.toString();
        }

        public String replaceFrom(CharSequence charsequence, char c)
        {
            return charsequence.toString();
        }

    };
    public static final CharMatcher SINGLE_WIDTH = new RangesMatcher("CharMatcher.SINGLE_WIDTH", "\000\u05BE\u05D0\u05F3\u0600\u0750\u0E00\u1E00\u2100\uFB50\uFE70\uFF61".toCharArray(), "\u04F9\u05BE\u05EA\u05F4\u06FF\u077F\u0E7F\u20AF\u213A\uFDFF\uFEFF\uFFDC".toCharArray());
    public static final CharMatcher WHITESPACE = new FastMatcher("WHITESPACE") {

        public boolean matches(char c)
        {
            return "\t\u3000\n\t\t\t\u202F\t\t\u2001\u2006\t\t\t\t\t\u180E\t\u2029\t\t\t\u2000\u2005\u200A\t\t\t\r\t\t\u2028\u1680\t\240\t\u2004\u2009\t\t\t\f\u205F\t\t \t\t\u2003\u2008\t\t\t\013\205\t\t\t\t\t\t\u2002\u2007\t".charAt(0xcdaacadf * c >>> 26) == c;
        }

    };
    final String description;

    protected CharMatcher()
    {
        description = super.toString();
    }

    CharMatcher(String s)
    {
        description = s;
    }

    public static CharMatcher anyOf(CharSequence charsequence)
    {
        int i = 0;
        StringBuilder stringbuilder;
        switch (charsequence.length())
        {
        default:
            charsequence = charsequence.toString().toCharArray();
            Arrays.sort(charsequence);
            stringbuilder = new StringBuilder("CharMatcher.anyOf(\"");
            for (int j = charsequence.length; i < j; i++)
            {
                stringbuilder.append(showCharacter(charsequence[i]));
            }

            break;

        case 0: // '\0'
            return NONE;

        case 1: // '\001'
            return is(charsequence.charAt(0));

        case 2: // '\002'
            return isEither(charsequence.charAt(0), charsequence.charAt(1));
        }
        stringbuilder.append("\")");
        return new CharMatcher(stringbuilder.toString(), charsequence) {

            final char val$chars[];

            public volatile boolean apply(Object obj)
            {
                return apply((Character)obj);
            }

            public boolean matches(char c)
            {
                return Arrays.binarySearch(chars, c) >= 0;
            }

            
            {
                chars = ac;
                super(s);
            }
        };
    }

    public static CharMatcher inRange(char c, char c1)
    {
        boolean flag;
        if (c1 >= c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        return inRange(c, c1, (new StringBuilder()).append("CharMatcher.inRange('").append(showCharacter(c)).append("', '").append(showCharacter(c1)).append("')").toString());
    }

    static CharMatcher inRange(char c, char c1, String s)
    {
        return new FastMatcher(s, c, c1) {

            final char val$endInclusive;
            final char val$startInclusive;

            public boolean matches(char c2)
            {
                return startInclusive <= c2 && c2 <= endInclusive;
            }

            
            {
                startInclusive = c;
                endInclusive = c1;
                super(s);
            }
        };
    }

    public static CharMatcher is(char c)
    {
        return new FastMatcher((new StringBuilder()).append("CharMatcher.is('").append(showCharacter(c)).append("')").toString(), c) {

            final char val$match;

            public CharMatcher and(CharMatcher charmatcher)
            {
                if (charmatcher.matches(match))
                {
                    return this;
                } else
                {
                    return NONE;
                }
            }

            public boolean matches(char c1)
            {
                return c1 == match;
            }

            public CharMatcher negate()
            {
                return isNot(match);
            }

            public CharMatcher or(CharMatcher charmatcher)
            {
                if (charmatcher.matches(match))
                {
                    return charmatcher;
                } else
                {
                    return super.or(charmatcher);
                }
            }

            public String replaceFrom(CharSequence charsequence, char c1)
            {
                return charsequence.toString().replace(match, c1);
            }

            
            {
                match = c;
                super(s);
            }
        };
    }

    private static CharMatcher isEither(char c, char c1)
    {
        return new FastMatcher((new StringBuilder()).append("CharMatcher.anyOf(\"").append(showCharacter(c)).append(showCharacter(c1)).append("\")").toString(), c, c1) {

            final char val$match1;
            final char val$match2;

            public boolean matches(char c2)
            {
                return c2 == match1 || c2 == match2;
            }

            
            {
                match1 = c;
                match2 = c1;
                super(s);
            }
        };
    }

    public static CharMatcher isNot(char c)
    {
        return new FastMatcher((new StringBuilder()).append("CharMatcher.isNot('").append(showCharacter(c)).append("')").toString(), c) {

            final char val$match;

            public CharMatcher and(CharMatcher charmatcher)
            {
                CharMatcher charmatcher1 = charmatcher;
                if (charmatcher.matches(match))
                {
                    charmatcher1 = super.and(charmatcher);
                }
                return charmatcher1;
            }

            public boolean matches(char c1)
            {
                return c1 != match;
            }

            public CharMatcher negate()
            {
                return is(match);
            }

            public CharMatcher or(CharMatcher charmatcher)
            {
                Object obj = this;
                if (charmatcher.matches(match))
                {
                    obj = ANY;
                }
                return ((CharMatcher) (obj));
            }

            
            {
                match = c;
                super(s);
            }
        };
    }

    public static CharMatcher noneOf(CharSequence charsequence)
    {
        return anyOf(charsequence).negate();
    }

    private static String showCharacter(char c)
    {
        char ac[] = new char[6];
        char[] _tmp = ac;
        ac[0] = '\\';
        ac[1] = 'u';
        ac[2] = '\0';
        ac[3] = '\0';
        ac[4] = '\0';
        ac[5] = '\0';
        boolean flag = false;
        char c1 = c;
        for (c = flag; c < '\004'; c++)
        {
            ac[5 - c] = "0123456789ABCDEF".charAt(c1 & 0xf);
            c1 >>= '\004';
        }

        return String.copyValueOf(ac);
    }

    public CharMatcher and(CharMatcher charmatcher)
    {
        return new And(this, (CharMatcher)Preconditions.checkNotNull(charmatcher));
    }

    public boolean apply(Character character)
    {
        return matches(character.charValue());
    }

    public volatile boolean apply(Object obj)
    {
        return apply((Character)obj);
    }

    public int indexIn(CharSequence charsequence)
    {
        int j = charsequence.length();
        for (int i = 0; i < j; i++)
        {
            if (matches(charsequence.charAt(i)))
            {
                return i;
            }
        }

        return -1;
    }

    public int indexIn(CharSequence charsequence, int i)
    {
        int j = charsequence.length();
        Preconditions.checkPositionIndex(i, j);
        for (; i < j; i++)
        {
            if (matches(charsequence.charAt(i)))
            {
                return i;
            }
        }

        return -1;
    }

    public abstract boolean matches(char c);

    public boolean matchesAllOf(CharSequence charsequence)
    {
        for (int i = charsequence.length() - 1; i >= 0; i--)
        {
            if (!matches(charsequence.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public boolean matchesNoneOf(CharSequence charsequence)
    {
        return indexIn(charsequence) == -1;
    }

    public CharMatcher negate()
    {
        return new NegatedMatcher(this);
    }

    public CharMatcher or(CharMatcher charmatcher)
    {
        return new Or(this, (CharMatcher)Preconditions.checkNotNull(charmatcher));
    }

    public String removeFrom(CharSequence charsequence)
    {
        int i;
        int j;
        charsequence = charsequence.toString();
        i = indexIn(charsequence);
        if (i == -1)
        {
            return charsequence;
        }
        charsequence = charsequence.toCharArray();
        j = 1;
_L2:
        i++;
        do
        {
label0:
            {
                if (i == charsequence.length)
                {
                    return new String(charsequence, 0, i - j);
                }
                if (!matches(charsequence[i]))
                {
                    break label0;
                }
                j++;
            }
            if (true)
            {
                continue;
            }
            charsequence[i - j] = charsequence[i];
            i++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String replaceFrom(CharSequence charsequence, char c)
    {
        charsequence = charsequence.toString();
        int i = indexIn(charsequence);
        if (i == -1)
        {
            return charsequence;
        }
        charsequence = charsequence.toCharArray();
        charsequence[i] = c;
        for (i++; i < charsequence.length; i++)
        {
            if (matches(charsequence[i]))
            {
                charsequence[i] = c;
            }
        }

        return new String(charsequence);
    }

    public String retainFrom(CharSequence charsequence)
    {
        return negate().removeFrom(charsequence);
    }

    public String toString()
    {
        return description;
    }

    CharMatcher withToString(String s)
    {
        throw new UnsupportedOperationException();
    }

    static 
    {
        StringBuilder stringbuilder = new StringBuilder("0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".length());
        for (int i = 0; i < "0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".length(); i++)
        {
            stringbuilder.append((char)("0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".charAt(i) + 9));
        }

        NINES = stringbuilder.toString();
        DIGIT = new RangesMatcher("CharMatcher.DIGIT", "0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".toCharArray(), NINES.toCharArray());
    }
}
