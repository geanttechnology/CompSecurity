// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.alternates;

import eic;
import f;

public abstract class Hypothesis
{

    private eic mSpans;
    private final String mText;

    private Hypothesis(CharSequence charsequence)
    {
        mText = charsequence.toString();
    }

    Hypothesis(CharSequence charsequence, _cls1 _pcls1)
    {
        this(charsequence);
    }

    public static Hypothesis fromAlternateSpanProtos(CharSequence charsequence, Iterable iterable)
    {
        if (iterable == null)
        {
            return fromText(charsequence);
        } else
        {
            return new AlternateSpanProtoBasedHypothesis(charsequence, iterable);
        }
    }

    public static Hypothesis fromSpans(CharSequence charsequence, Iterable iterable)
    {
        if (iterable == null)
        {
            return fromText(charsequence);
        } else
        {
            return new SpanBasedHypothesis(charsequence, iterable);
        }
    }

    public static Hypothesis fromText(CharSequence charsequence)
    {
        return new TextOnlyHypothesis(charsequence);
    }

    protected abstract eic computeSpans();

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Hypothesis)
        {
            obj = (Hypothesis)obj;
            flag = flag1;
            if (f.a(mText, ((Hypothesis) (obj)).mText))
            {
                flag = flag1;
                if (f.a(getSpans(), ((Hypothesis) (obj)).getSpans()))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public abstract int getSpanCount();

    public final eic getSpans()
    {
        if (mSpans == null)
        {
            mSpans = computeSpans();
        }
        return mSpans;
    }

    public final String getText()
    {
        return mText;
    }

    public int hashCode()
    {
        return f.a(new Object[] {
            mText, getSpans()
        });
    }

    public String toString()
    {
        return (new StringBuilder("Hypothesis: [")).append(mText).append("] with ").append(getSpanCount()).append(" span(s)").toString();
    }

    private class AlternateSpanProtoBasedHypothesis extends Hypothesis
    {

        private final eic mAlternateSpans;

        private int getOffsetUtf16(byte abyte0[], int i)
        {
            int j;
            int k;
            j = 0;
            k = 0;
_L9:
            if (j >= i || j >= abyte0.length) goto _L2; else goto _L1
_L1:
            int l;
            l = abyte0[j] & 0xff;
            if (l >>> 7 == 0)
            {
                k++;
                j++;
                continue; /* Loop/switch isn't completed */
            }
            if (l >>> 5 != 6) goto _L4; else goto _L3
_L3:
            if (j + 1 < i) goto _L5; else goto _L2
_L2:
            return k;
_L5:
            j += 2;
            k++;
            continue; /* Loop/switch isn't completed */
_L4:
            if (l >>> 4 != 14)
            {
                break; /* Loop/switch isn't completed */
            }
            if (j + 2 < i)
            {
                j += 3;
                k++;
                continue; /* Loop/switch isn't completed */
            }
            if (true) goto _L2; else goto _L6
_L6:
            if (l >>> 3 != 30)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j + 3 >= i) goto _L2; else goto _L7
_L7:
            j += 4;
            k += 2;
            if (true) goto _L9; else goto _L8
_L8:
        }

        private byte[] getTextAsUtf8()
        {
            byte abyte0[];
            try
            {
                abyte0 = getText().getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw a.b(unsupportedencodingexception);
            }
            return abyte0;
        }

        protected final eic computeSpans()
        {
            eie eie1 = eic.h();
            eus eus1;
            eie eie2;
            int j;
            int k;
            for (Iterator iterator = mAlternateSpans.iterator(); iterator.hasNext(); eie1.b(new Span(j, k, eus1.a, eus1.b, eie2.a())))
            {
                eus1 = (eus)iterator.next();
                byte abyte0[] = getTextAsUtf8();
                j = getOffsetUtf16(abyte0, eus1.a);
                k = getOffsetUtf16(abyte0, eus1.a + eus1.b);
                eie2 = eic.h();
                for (int i = 0; i < eus1.c.size(); i++)
                {
                    eie2.b(((euq)eus1.c.get(i)).a);
                }

            }

            return eie1.a();
        }

        public final int getSpanCount()
        {
            return mAlternateSpans.size();
        }

        public AlternateSpanProtoBasedHypothesis(CharSequence charsequence, Iterable iterable)
        {
            super(charsequence, null);
            mAlternateSpans = eic.a(iterable);
        }

        private class Span
        {

            public final eic mAlternates;
            public final int mUtf16End;
            public final int mUtf16Start;
            public final int mUtf8Length;
            public final int mUtf8Start;

            public boolean equals(Object obj)
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (obj instanceof Span)
                {
                    obj = (Span)obj;
                    flag = flag1;
                    if (mUtf16Start == ((Span) (obj)).mUtf16Start)
                    {
                        flag = flag1;
                        if (mUtf16End == ((Span) (obj)).mUtf16End)
                        {
                            flag = flag1;
                            if (mUtf8Start == ((Span) (obj)).mUtf8Start)
                            {
                                flag = flag1;
                                if (mUtf8Length == ((Span) (obj)).mUtf8Length)
                                {
                                    flag = flag1;
                                    if (f.a(mAlternates, ((Span) (obj)).mAlternates))
                                    {
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return flag;
            }

            public int hashCode()
            {
                return f.a(new Object[] {
                    Integer.valueOf(mUtf16Start), Integer.valueOf(mUtf16End), Integer.valueOf(mUtf8Start), Integer.valueOf(mUtf8Length), mAlternates
                });
            }

            public String toString()
            {
                return f.a(this).a("mUtf16Start", mUtf16Start).a("mUtf16End", mUtf16End).a("mUtf8Start", mUtf8Start).a("mUtf8Length", mUtf8Length).a("mAlternates", mAlternates).toString();
            }

            public Span withAlternates(eic eic1)
            {
                return new Span(mUtf16Start, mUtf16End, mUtf8Start, mUtf8Length, eic1);
            }

            public Span(int i, int j, int k, int l, eic eic1)
            {
                mUtf16Start = i;
                mUtf16End = j;
                mUtf8Start = k;
                mUtf8Length = l;
                mAlternates = eic1;
            }
        }

    }


    private class SpanBasedHypothesis extends Hypothesis
    {

        private final eic mSpans;

        protected final eic computeSpans()
        {
            return mSpans;
        }

        public final int getSpanCount()
        {
            return mSpans.size();
        }

        public SpanBasedHypothesis(CharSequence charsequence, Iterable iterable)
        {
            super(charsequence, null);
            mSpans = eic.a(iterable);
        }
    }


    private class TextOnlyHypothesis extends Hypothesis
    {

        protected final eic computeSpans()
        {
            return eic.g();
        }

        public final int getSpanCount()
        {
            return 0;
        }

        public TextOnlyHypothesis(CharSequence charsequence)
        {
            super(charsequence, null);
        }
    }

}
