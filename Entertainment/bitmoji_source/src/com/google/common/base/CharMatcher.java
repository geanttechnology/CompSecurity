// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;

// Referenced classes of package com.google.common.base:
//            Predicate, SmallCharMatcher, Preconditions, Platform

public abstract class CharMatcher
    implements Predicate
{
    private static final class And extends CharMatcher
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

        void setBits(BitSet bitset)
        {
            BitSet bitset1 = new BitSet();
            first.setBits(bitset1);
            BitSet bitset2 = new BitSet();
            second.setBits(bitset2);
            bitset1.and(bitset2);
            bitset.or(bitset1);
        }

        public String toString()
        {
            String s = String.valueOf(first);
            String s1 = String.valueOf(second);
            return (new StringBuilder(String.valueOf(s).length() + 19 + String.valueOf(s1).length())).append("CharMatcher.and(").append(s).append(", ").append(s1).append(")").toString();
        }

        And(CharMatcher charmatcher, CharMatcher charmatcher1)
        {
            first = (CharMatcher)Preconditions.checkNotNull(charmatcher);
            second = (CharMatcher)Preconditions.checkNotNull(charmatcher1);
        }
    }

    private static final class Any extends NamedFastMatcher
    {

        static final Any INSTANCE = new Any();

        public CharMatcher and(CharMatcher charmatcher)
        {
            return (CharMatcher)Preconditions.checkNotNull(charmatcher);
        }

        public String collapseFrom(CharSequence charsequence, char c)
        {
            if (charsequence.length() == 0)
            {
                return "";
            } else
            {
                return String.valueOf(c);
            }
        }

        public int countIn(CharSequence charsequence)
        {
            return charsequence.length();
        }

        public int indexIn(CharSequence charsequence)
        {
            return charsequence.length() != 0 ? 0 : -1;
        }

        public int indexIn(CharSequence charsequence, int i)
        {
            int k = charsequence.length();
            Preconditions.checkPositionIndex(i, k);
            int j = i;
            if (i == k)
            {
                j = -1;
            }
            return j;
        }

        public int lastIndexIn(CharSequence charsequence)
        {
            return charsequence.length() - 1;
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
            return none();
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

        public String replaceFrom(CharSequence charsequence, CharSequence charsequence1)
        {
            StringBuilder stringbuilder = new StringBuilder(charsequence.length() * charsequence1.length());
            for (int i = 0; i < charsequence.length(); i++)
            {
                stringbuilder.append(charsequence1);
            }

            return stringbuilder.toString();
        }

        public String trimFrom(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return "";
        }


        private Any()
        {
            super("CharMatcher.any()");
        }
    }

    private static final class AnyOf extends CharMatcher
    {

        private final char chars[];

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Arrays.binarySearch(chars, c) >= 0;
        }

        void setBits(BitSet bitset)
        {
            char ac[] = chars;
            int j = ac.length;
            for (int i = 0; i < j; i++)
            {
                bitset.set(ac[i]);
            }

        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder("CharMatcher.anyOf(\"");
            char ac[] = chars;
            int j = ac.length;
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(CharMatcher.showCharacter(ac[i]));
            }

            stringbuilder.append("\")");
            return stringbuilder.toString();
        }

        public AnyOf(CharSequence charsequence)
        {
            chars = charsequence.toString().toCharArray();
            Arrays.sort(chars);
        }
    }

    private static final class Ascii extends NamedFastMatcher
    {

        static final Ascii INSTANCE = new Ascii();

        public boolean matches(char c)
        {
            return c <= '\177';
        }


        Ascii()
        {
            super("CharMatcher.ascii()");
        }
    }

    private static final class BitSetMatcher extends NamedFastMatcher
    {

        private final BitSet table;

        public boolean matches(char c)
        {
            return table.get(c);
        }

        void setBits(BitSet bitset)
        {
            bitset.or(table);
        }

        private BitSetMatcher(BitSet bitset, String s)
        {
            super(s);
            s = bitset;
            if (bitset.length() + 64 < bitset.size())
            {
                s = (BitSet)bitset.clone();
            }
            table = s;
        }

    }

    private static final class BreakingWhitespace extends CharMatcher
    {

        static final CharMatcher INSTANCE = new BreakingWhitespace();

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
            return "CharMatcher.breakingWhitespace()";
        }


        private BreakingWhitespace()
        {
        }
    }

    private static final class Digit extends RangesMatcher
    {

        static final Digit INSTANCE = new Digit();
        private static final String ZEROES = "0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10";

        private static char[] nines()
        {
            char ac[] = new char["0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".length()];
            for (int i = 0; i < "0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".length(); i++)
            {
                ac[i] = (char)("0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".charAt(i) + 9);
            }

            return ac;
        }

        private static char[] zeroes()
        {
            return "0\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".toCharArray();
        }


        private Digit()
        {
            super("CharMatcher.digit()", zeroes(), nines());
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

        public final CharMatcher precomputed()
        {
            return this;
        }

        FastMatcher()
        {
        }
    }

    private static final class ForPredicate extends CharMatcher
    {

        private final Predicate predicate;

        public boolean apply(Character character)
        {
            return predicate.apply(Preconditions.checkNotNull(character));
        }

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return predicate.apply(Character.valueOf(c));
        }

        public String toString()
        {
            String s = String.valueOf(predicate);
            return (new StringBuilder(String.valueOf(s).length() + 26)).append("CharMatcher.forPredicate(").append(s).append(")").toString();
        }

        ForPredicate(Predicate predicate1)
        {
            predicate = (Predicate)Preconditions.checkNotNull(predicate1);
        }
    }

    private static final class InRange extends FastMatcher
    {

        private final char endInclusive;
        private final char startInclusive;

        public boolean matches(char c)
        {
            return startInclusive <= c && c <= endInclusive;
        }

        void setBits(BitSet bitset)
        {
            bitset.set(startInclusive, endInclusive + 1);
        }

        public String toString()
        {
            String s = CharMatcher.showCharacter(startInclusive);
            String s1 = CharMatcher.showCharacter(endInclusive);
            return (new StringBuilder(String.valueOf(s).length() + 27 + String.valueOf(s1).length())).append("CharMatcher.inRange('").append(s).append("', '").append(s1).append("')").toString();
        }

        InRange(char c, char c1)
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
            startInclusive = c;
            endInclusive = c1;
        }
    }

    private static final class Invisible extends RangesMatcher
    {

        static final Invisible INSTANCE = new Invisible();
        private static final String RANGE_ENDS = " \240\255\u0604\u061C\u06DD\u070F\u1680\u180E\u200F\u202F\u2064\u2066\u2067\u2068\u2069\u206F\u3000\uF8FF\uFEFF\uFFF9\uFFFB";
        private static final String RANGE_STARTS = "\000\177\255\u0600\u061C\u06DD\u070F\u1680\u180E\u2000\u2028\u205F\u2066\u2067\u2068\u2069\u206A\u3000\uD800\uFEFF\uFFF9\uFFFA";


        private Invisible()
        {
            super("CharMatcher.invisible()", "\000\177\255\u0600\u061C\u06DD\u070F\u1680\u180E\u2000\u2028\u205F\u2066\u2067\u2068\u2069\u206A\u3000\uD800\uFEFF\uFFF9\uFFFA".toCharArray(), " \240\255\u0604\u061C\u06DD\u070F\u1680\u180E\u200F\u202F\u2064\u2066\u2067\u2068\u2069\u206F\u3000\uF8FF\uFEFF\uFFF9\uFFFB".toCharArray());
        }
    }

    private static final class Is extends FastMatcher
    {

        private final char match;

        public CharMatcher and(CharMatcher charmatcher)
        {
            if (charmatcher.matches(match))
            {
                return this;
            } else
            {
                return none();
            }
        }

        public boolean matches(char c)
        {
            return c == match;
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

        public String replaceFrom(CharSequence charsequence, char c)
        {
            return charsequence.toString().replace(match, c);
        }

        void setBits(BitSet bitset)
        {
            bitset.set(match);
        }

        public String toString()
        {
            String s = CharMatcher.showCharacter(match);
            return (new StringBuilder(String.valueOf(s).length() + 18)).append("CharMatcher.is('").append(s).append("')").toString();
        }

        Is(char c)
        {
            match = c;
        }
    }

    private static final class IsEither extends FastMatcher
    {

        private final char match1;
        private final char match2;

        public boolean matches(char c)
        {
            return c == match1 || c == match2;
        }

        void setBits(BitSet bitset)
        {
            bitset.set(match1);
            bitset.set(match2);
        }

        public String toString()
        {
            String s = CharMatcher.showCharacter(match1);
            String s1 = CharMatcher.showCharacter(match2);
            return (new StringBuilder(String.valueOf(s).length() + 21 + String.valueOf(s1).length())).append("CharMatcher.anyOf(\"").append(s).append(s1).append("\")").toString();
        }

        IsEither(char c, char c1)
        {
            match1 = c;
            match2 = c1;
        }
    }

    private static final class IsNot extends FastMatcher
    {

        private final char match;

        public CharMatcher and(CharMatcher charmatcher)
        {
            CharMatcher charmatcher1 = charmatcher;
            if (charmatcher.matches(match))
            {
                charmatcher1 = super.and(charmatcher);
            }
            return charmatcher1;
        }

        public boolean matches(char c)
        {
            return c != match;
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
                obj = any();
            }
            return ((CharMatcher) (obj));
        }

        void setBits(BitSet bitset)
        {
            bitset.set(0, match);
            bitset.set(match + 1, 0x10000);
        }

        public String toString()
        {
            String s = CharMatcher.showCharacter(match);
            return (new StringBuilder(String.valueOf(s).length() + 21)).append("CharMatcher.isNot('").append(s).append("')").toString();
        }

        IsNot(char c)
        {
            match = c;
        }
    }

    private static final class JavaDigit extends CharMatcher
    {

        static final JavaDigit INSTANCE = new JavaDigit();

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isDigit(c);
        }

        public String toString()
        {
            return "CharMatcher.javaDigit()";
        }


        private JavaDigit()
        {
        }
    }

    private static final class JavaIsoControl extends NamedFastMatcher
    {

        static final JavaIsoControl INSTANCE = new JavaIsoControl();

        public boolean matches(char c)
        {
            return c <= '\037' || c >= '\177' && c <= '\237';
        }


        private JavaIsoControl()
        {
            super("CharMatcher.javaIsoControl()");
        }
    }

    private static final class JavaLetter extends CharMatcher
    {

        static final JavaLetter INSTANCE = new JavaLetter();

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isLetter(c);
        }

        public String toString()
        {
            return "CharMatcher.javaLetter()";
        }


        private JavaLetter()
        {
        }
    }

    private static final class JavaLetterOrDigit extends CharMatcher
    {

        static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isLetterOrDigit(c);
        }

        public String toString()
        {
            return "CharMatcher.javaLetterOrDigit()";
        }


        private JavaLetterOrDigit()
        {
        }
    }

    private static final class JavaLowerCase extends CharMatcher
    {

        static final JavaLowerCase INSTANCE = new JavaLowerCase();

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isLowerCase(c);
        }

        public String toString()
        {
            return "CharMatcher.javaLowerCase()";
        }


        private JavaLowerCase()
        {
        }
    }

    private static final class JavaUpperCase extends CharMatcher
    {

        static final JavaUpperCase INSTANCE = new JavaUpperCase();

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public boolean matches(char c)
        {
            return Character.isUpperCase(c);
        }

        public String toString()
        {
            return "CharMatcher.javaUpperCase()";
        }


        private JavaUpperCase()
        {
        }
    }

    static abstract class NamedFastMatcher extends FastMatcher
    {

        private final String description;

        public final String toString()
        {
            return description;
        }

        NamedFastMatcher(String s)
        {
            description = (String)Preconditions.checkNotNull(s);
        }
    }

    private static class Negated extends CharMatcher
    {

        final CharMatcher original;

        public volatile boolean apply(Object obj)
        {
            return apply((Character)obj);
        }

        public int countIn(CharSequence charsequence)
        {
            return charsequence.length() - original.countIn(charsequence);
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

        void setBits(BitSet bitset)
        {
            BitSet bitset1 = new BitSet();
            original.setBits(bitset1);
            bitset1.flip(0, 0x10000);
            bitset.or(bitset1);
        }

        public String toString()
        {
            String s = String.valueOf(original);
            return (new StringBuilder(String.valueOf(s).length() + 9)).append(s).append(".negate()").toString();
        }

        Negated(CharMatcher charmatcher)
        {
            original = (CharMatcher)Preconditions.checkNotNull(charmatcher);
        }
    }

    static class NegatedFastMatcher extends Negated
    {

        public final CharMatcher precomputed()
        {
            return this;
        }

        NegatedFastMatcher(CharMatcher charmatcher)
        {
            super(charmatcher);
        }
    }

    private static final class None extends NamedFastMatcher
    {

        static final None INSTANCE = new None();

        public CharMatcher and(CharMatcher charmatcher)
        {
            Preconditions.checkNotNull(charmatcher);
            return this;
        }

        public String collapseFrom(CharSequence charsequence, char c)
        {
            return charsequence.toString();
        }

        public int countIn(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return 0;
        }

        public int indexIn(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
            return -1;
        }

        public int indexIn(CharSequence charsequence, int i)
        {
            Preconditions.checkPositionIndex(i, charsequence.length());
            return -1;
        }

        public int lastIndexIn(CharSequence charsequence)
        {
            Preconditions.checkNotNull(charsequence);
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
            return any();
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

        public String replaceFrom(CharSequence charsequence, CharSequence charsequence1)
        {
            Preconditions.checkNotNull(charsequence1);
            return charsequence.toString();
        }

        public String trimFrom(CharSequence charsequence)
        {
            return charsequence.toString();
        }

        public String trimLeadingFrom(CharSequence charsequence)
        {
            return charsequence.toString();
        }

        public String trimTrailingFrom(CharSequence charsequence)
        {
            return charsequence.toString();
        }


        private None()
        {
            super("CharMatcher.none()");
        }
    }

    private static final class Or extends CharMatcher
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

        void setBits(BitSet bitset)
        {
            first.setBits(bitset);
            second.setBits(bitset);
        }

        public String toString()
        {
            String s = String.valueOf(first);
            String s1 = String.valueOf(second);
            return (new StringBuilder(String.valueOf(s).length() + 18 + String.valueOf(s1).length())).append("CharMatcher.or(").append(s).append(", ").append(s1).append(")").toString();
        }

        Or(CharMatcher charmatcher, CharMatcher charmatcher1)
        {
            first = (CharMatcher)Preconditions.checkNotNull(charmatcher);
            second = (CharMatcher)Preconditions.checkNotNull(charmatcher1);
        }
    }

    private static class RangesMatcher extends CharMatcher
    {

        private final String description;
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

        public String toString()
        {
            return description;
        }

        RangesMatcher(String s, char ac[], char ac1[])
        {
            description = s;
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

    private static final class SingleWidth extends RangesMatcher
    {

        static final SingleWidth INSTANCE = new SingleWidth();


        private SingleWidth()
        {
            super("CharMatcher.singleWidth()", "\000\u05BE\u05D0\u05F3\u0600\u0750\u0E00\u1E00\u2100\uFB50\uFE70\uFF61".toCharArray(), "\u04F9\u05BE\u05EA\u05F4\u06FF\u077F\u0E7F\u20AF\u213A\uFDFF\uFEFF\uFFDC".toCharArray());
        }
    }

    static final class Whitespace extends NamedFastMatcher
    {

        static final Whitespace INSTANCE = new Whitespace();
        static final int MULTIPLIER = 0x6449bf0a;
        static final int SHIFT = Integer.numberOfLeadingZeros("\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length() - 1);
        static final String TABLE = "\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000";

        public boolean matches(char c)
        {
            return "\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(0x6449bf0a * c >>> SHIFT) == c;
        }

        void setBits(BitSet bitset)
        {
            for (int i = 0; i < "\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".length(); i++)
            {
                bitset.set("\u2002\u3000\r\205\u200A\u2005\u2000\u3000\u2029\013\u3000\u2008\u2003\u205F\u3000\u1680\t \u2006\u2001\u202F\240\f\u2009\u3000\u2004\u3000\u3000\u2028\n\u2007\u3000".charAt(i));
            }

        }


        Whitespace()
        {
            super("CharMatcher.whitespace()");
        }
    }


    public static final CharMatcher ANY = any();
    public static final CharMatcher ASCII = ascii();
    public static final CharMatcher BREAKING_WHITESPACE = breakingWhitespace();
    public static final CharMatcher DIGIT = digit();
    private static final int DISTINCT_CHARS = 0x10000;
    public static final CharMatcher INVISIBLE = invisible();
    public static final CharMatcher JAVA_DIGIT = javaDigit();
    public static final CharMatcher JAVA_ISO_CONTROL = javaIsoControl();
    public static final CharMatcher JAVA_LETTER = javaLetter();
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
    public static final CharMatcher JAVA_LOWER_CASE = javaLowerCase();
    public static final CharMatcher JAVA_UPPER_CASE = javaUpperCase();
    public static final CharMatcher NONE = none();
    public static final CharMatcher SINGLE_WIDTH = singleWidth();
    public static final CharMatcher WHITESPACE = whitespace();

    protected CharMatcher()
    {
    }

    public static CharMatcher any()
    {
        return Any.INSTANCE;
    }

    public static CharMatcher anyOf(CharSequence charsequence)
    {
        switch (charsequence.length())
        {
        default:
            return new AnyOf(charsequence);

        case 0: // '\0'
            return none();

        case 1: // '\001'
            return is(charsequence.charAt(0));

        case 2: // '\002'
            return isEither(charsequence.charAt(0), charsequence.charAt(1));
        }
    }

    public static CharMatcher ascii()
    {
        return Ascii.INSTANCE;
    }

    public static CharMatcher breakingWhitespace()
    {
        return BreakingWhitespace.INSTANCE;
    }

    public static CharMatcher digit()
    {
        return Digit.INSTANCE;
    }

    private String finishCollapseFrom(CharSequence charsequence, int i, int j, char c, StringBuilder stringbuilder, boolean flag)
    {
        boolean flag1 = flag;
        while (i < j) 
        {
            char c1 = charsequence.charAt(i);
            if (matches(c1))
            {
                flag = flag1;
                if (!flag1)
                {
                    stringbuilder.append(c);
                    flag = true;
                }
            } else
            {
                stringbuilder.append(c1);
                flag = false;
            }
            i++;
            flag1 = flag;
        }
        return stringbuilder.toString();
    }

    public static CharMatcher forPredicate(Predicate predicate)
    {
        if (predicate instanceof CharMatcher)
        {
            return (CharMatcher)predicate;
        } else
        {
            return new ForPredicate(predicate);
        }
    }

    public static CharMatcher inRange(char c, char c1)
    {
        return new InRange(c, c1);
    }

    public static CharMatcher invisible()
    {
        return Invisible.INSTANCE;
    }

    public static CharMatcher is(char c)
    {
        return new Is(c);
    }

    private static IsEither isEither(char c, char c1)
    {
        return new IsEither(c, c1);
    }

    public static CharMatcher isNot(char c)
    {
        return new IsNot(c);
    }

    private static boolean isSmall(int i, int j)
    {
        return i <= 1023 && j > i * 4 * 16;
    }

    public static CharMatcher javaDigit()
    {
        return JavaDigit.INSTANCE;
    }

    public static CharMatcher javaIsoControl()
    {
        return JavaIsoControl.INSTANCE;
    }

    public static CharMatcher javaLetter()
    {
        return JavaLetter.INSTANCE;
    }

    public static CharMatcher javaLetterOrDigit()
    {
        return JavaLetterOrDigit.INSTANCE;
    }

    public static CharMatcher javaLowerCase()
    {
        return JavaLowerCase.INSTANCE;
    }

    public static CharMatcher javaUpperCase()
    {
        return JavaUpperCase.INSTANCE;
    }

    public static CharMatcher none()
    {
        return None.INSTANCE;
    }

    public static CharMatcher noneOf(CharSequence charsequence)
    {
        return anyOf(charsequence).negate();
    }

    private static CharMatcher precomputedPositive(int i, BitSet bitset, String s)
    {
        switch (i)
        {
        default:
            if (isSmall(i, bitset.length()))
            {
                return SmallCharMatcher.from(bitset, s);
            } else
            {
                return new BitSetMatcher(bitset, s);
            }

        case 0: // '\0'
            return none();

        case 1: // '\001'
            return is((char)bitset.nextSetBit(0));

        case 2: // '\002'
            char c = (char)bitset.nextSetBit(0);
            return isEither(c, (char)bitset.nextSetBit(c + 1));
        }
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

    public static CharMatcher singleWidth()
    {
        return SingleWidth.INSTANCE;
    }

    public static CharMatcher whitespace()
    {
        return Whitespace.INSTANCE;
    }

    public CharMatcher and(CharMatcher charmatcher)
    {
        return new And(this, charmatcher);
    }

    public boolean apply(Character character)
    {
        return matches(character.charValue());
    }

    public volatile boolean apply(Object obj)
    {
        return apply((Character)obj);
    }

    public String collapseFrom(CharSequence charsequence, char c)
    {
label0:
        {
            int k = charsequence.length();
            int i = 0;
            do
            {
                if (i >= k)
                {
                    break label0;
                }
                char c1 = charsequence.charAt(i);
                int j = i;
                if (matches(c1))
                {
                    if (c1 != c || i != k - 1 && matches(charsequence.charAt(i + 1)))
                    {
                        break;
                    }
                    j = i + 1;
                }
                i = j + 1;
            } while (true);
            return finishCollapseFrom(charsequence, i + 1, k, c, (new StringBuilder(k)).append(charsequence.subSequence(0, i)).append(c), true);
        }
        return charsequence.toString();
    }

    public int countIn(CharSequence charsequence)
    {
        int j = 0;
        for (int i = 0; i < charsequence.length();)
        {
            int k = j;
            if (matches(charsequence.charAt(i)))
            {
                k = j + 1;
            }
            i++;
            j = k;
        }

        return j;
    }

    public int indexIn(CharSequence charsequence)
    {
        return indexIn(charsequence, 0);
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

    public int lastIndexIn(CharSequence charsequence)
    {
        for (int i = charsequence.length() - 1; i >= 0; i--)
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

    public boolean matchesAnyOf(CharSequence charsequence)
    {
        return !matchesNoneOf(charsequence);
    }

    public boolean matchesNoneOf(CharSequence charsequence)
    {
        return indexIn(charsequence) == -1;
    }

    public CharMatcher negate()
    {
        return new Negated(this);
    }

    public CharMatcher or(CharMatcher charmatcher)
    {
        return new Or(this, charmatcher);
    }

    public CharMatcher precomputed()
    {
        return Platform.precomputeCharMatcher(this);
    }

    CharMatcher precomputedInternal()
    {
        BitSet bitset = new BitSet();
        setBits(bitset);
        int i = bitset.cardinality();
        if (i * 2 <= 0x10000)
        {
            return precomputedPositive(i, bitset, toString());
        }
        bitset.flip(0, 0x10000);
        String s1 = toString();
        String s;
        if (s1.endsWith(".negate()"))
        {
            s = s1.substring(0, s1.length() - ".negate()".length());
        } else
        {
            s = String.valueOf(s1);
            String s2 = String.valueOf(".negate()");
            if (s2.length() != 0)
            {
                s = s.concat(s2);
            } else
            {
                s = new String(s);
            }
        }
        return new NegatedFastMatcher(s1) {

            final CharMatcher this$0;
            final String val$description;

            public String toString()
            {
                return description;
            }

            
            {
                this$0 = CharMatcher.this;
                description = s;
                super(final_charmatcher1);
            }
        };
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

    public String replaceFrom(CharSequence charsequence, CharSequence charsequence1)
    {
        int i = charsequence1.length();
        if (i == 0)
        {
            charsequence = removeFrom(charsequence);
        } else
        {
            if (i == 1)
            {
                return replaceFrom(charsequence, charsequence1.charAt(0));
            }
            String s = charsequence.toString();
            i = indexIn(s);
            charsequence = s;
            if (i != -1)
            {
                int i1 = s.length();
                charsequence = new StringBuilder((i1 * 3) / 2 + 16);
                int j = 0;
                int k;
                int l;
                do
                {
                    charsequence.append(s, j, i);
                    charsequence.append(charsequence1);
                    k = i + 1;
                    l = indexIn(s, k);
                    j = k;
                    i = l;
                } while (l != -1);
                charsequence.append(s, k, i1);
                return charsequence.toString();
            }
        }
        return charsequence;
    }

    public String retainFrom(CharSequence charsequence)
    {
        return negate().removeFrom(charsequence);
    }

    void setBits(BitSet bitset)
    {
        for (int i = 65535; i >= 0; i--)
        {
            if (matches((char)i))
            {
                bitset.set(i);
            }
        }

    }

    public String toString()
    {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charsequence, char c)
    {
        int l = charsequence.length();
        int i = 0;
        int k = l - 1;
        int j;
        do
        {
            j = k;
            if (i >= l)
            {
                break;
            }
            j = k;
            if (!matches(charsequence.charAt(i)))
            {
                break;
            }
            i++;
        } while (true);
        for (; j > i && matches(charsequence.charAt(j)); j--) { }
        if (i == 0 && j == l - 1)
        {
            return collapseFrom(charsequence, c);
        } else
        {
            return finishCollapseFrom(charsequence, i, j + 1, c, new StringBuilder((j + 1) - i), false);
        }
    }

    public String trimFrom(CharSequence charsequence)
    {
        int i;
        int j;
        j = charsequence.length();
        i = 0;
_L3:
        if (i < j && matches(charsequence.charAt(i))) goto _L2; else goto _L1
_L1:
        j--;
_L4:
        if (j <= i || !matches(charsequence.charAt(j)))
        {
            return charsequence.subSequence(i, j + 1).toString();
        }
        break MISSING_BLOCK_LABEL_74;
_L2:
        i++;
          goto _L3
        j--;
          goto _L4
    }

    public String trimLeadingFrom(CharSequence charsequence)
    {
        int j = charsequence.length();
        for (int i = 0; i < j; i++)
        {
            if (!matches(charsequence.charAt(i)))
            {
                return charsequence.subSequence(i, j).toString();
            }
        }

        return "";
    }

    public String trimTrailingFrom(CharSequence charsequence)
    {
        for (int i = charsequence.length() - 1; i >= 0; i--)
        {
            if (!matches(charsequence.charAt(i)))
            {
                return charsequence.subSequence(0, i + 1).toString();
            }
        }

        return "";
    }


}
