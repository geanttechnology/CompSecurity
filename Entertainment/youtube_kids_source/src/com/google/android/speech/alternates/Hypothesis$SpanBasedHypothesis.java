// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.alternates;

import eic;

// Referenced classes of package com.google.android.speech.alternates:
//            Hypothesis

final class mSpans extends Hypothesis
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

    public I(CharSequence charsequence, Iterable iterable)
    {
        super(charsequence, null);
        mSpans = eic.a(iterable);
    }
}
