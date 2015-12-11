// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.utils;

import android.util.Pair;
import com.google.android.speech.alternates.Hypothesis;
import eic;
import eie;
import eut;
import ewh;
import ewi;
import ewj;
import ewk;
import ewl;

public class RecognizedText
{

    private static final boolean DBG = false;
    private static final double HIGH_CONFIDENCE_PARTIAL_THRESHOLD = 0.90000000000000002D;
    private static final String TAG = "VS.RecognizedText";
    private eic mAllHypotheses;
    private final StringBuilder mStable = new StringBuilder();

    public RecognizedText()
    {
    }

    private eic extractHypotheses(ewk ewk1)
    {
        eie eie1 = eic.h();
        if (ewk1.h)
        {
            ewk1 = ewk1.i;
            for (int i = 0; i < ewk1.d(); i++)
            {
                eie1.b(extractHypothesis(ewk1.a(i)));
            }

        }
        return eie1.a();
    }

    private Hypothesis extractHypothesis(ewh ewh1)
    {
        String s;
        if (ewh1.a)
        {
            s = ewh1.b;
        } else
        {
            s = "";
        }
        if (ewh1.f)
        {
            ewh1 = ewh1.g.a;
        } else
        {
            ewh1 = null;
        }
        return Hypothesis.fromAlternateSpanProtos(s, ewh1);
    }

    private void updateStableResults(ewk ewk1)
    {
        if (ewk1.d)
        {
            ewk1 = ewk1.e;
            if (ewk1.d() > 0)
            {
                ewk1 = ewk1.a(0);
                if (((ewh) (ewk1)).a)
                {
                    mStable.append(((ewh) (ewk1)).b);
                }
            }
        }
    }

    public String getStableForErrorReporting()
    {
        return mStable.toString();
    }

    public boolean hasCompletedRecognition()
    {
        return mAllHypotheses != null;
    }

    public eic updateFinal(ewk ewk1)
    {
        mAllHypotheses = extractHypotheses(ewk1);
        mStable.delete(0, mStable.length());
        if (mAllHypotheses.size() > 0)
        {
            mStable.append(((Hypothesis)mAllHypotheses.get(0)).getText());
        }
        return mAllHypotheses;
    }

    public Pair updateInProgress(ewk ewk1)
    {
        Object obj2 = null;
        Object obj = null;
        boolean flag = false;
        updateStableResults(ewk1);
        Object obj1;
        if (ewk1.f)
        {
            ewj ewj1 = ewk1.g;
            int j = ewj1.d();
            int i = 0;
            ewk1 = null;
            do
            {
                obj2 = obj;
                obj1 = ewk1;
                if (i >= j)
                {
                    break;
                }
                ewi ewi1 = ewj1.a(i);
                boolean flag1 = flag;
                obj2 = obj;
                Object obj3 = ewk1;
                if (ewi1.a)
                {
                    if (!flag && ewi1.c && ewi1.d >= 0.90000000000000002D)
                    {
                        obj1 = obj;
                        if (obj == null)
                        {
                            obj1 = new StringBuilder(mStable);
                        }
                        ((StringBuilder) (obj1)).append(ewi1.b);
                        obj3 = ewk1;
                        obj2 = obj1;
                        flag1 = flag;
                    } else
                    {
                        obj1 = ewk1;
                        if (ewk1 == null)
                        {
                            obj1 = new StringBuilder();
                        }
                        ((StringBuilder) (obj1)).append(ewi1.b);
                        flag1 = true;
                        obj2 = obj;
                        obj3 = obj1;
                    }
                }
                i++;
                flag = flag1;
                obj = obj2;
                ewk1 = ((ewk) (obj3));
            } while (true);
        } else
        {
            obj1 = null;
        }
        if (obj2 == null)
        {
            ewk1 = mStable.toString();
        } else
        {
            ewk1 = ((StringBuilder) (obj2)).toString();
        }
        if (obj1 == null)
        {
            obj = "";
        } else
        {
            obj = ((StringBuilder) (obj1)).toString();
        }
        return Pair.create(ewk1, obj);
    }
}
