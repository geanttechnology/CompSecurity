// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            KeyframeSet, Keyframe, TypeEvaluator

class IntKeyframeSet extends KeyframeSet
{

    private int deltaValue;
    private boolean firstTime;
    private int firstValue;
    private int lastValue;

    public transient IntKeyframeSet(Keyframe.IntKeyframe aintkeyframe[])
    {
        super(aintkeyframe);
        firstTime = true;
    }

    public IntKeyframeSet clone()
    {
        ArrayList arraylist = mKeyframes;
        int j = mKeyframes.size();
        Keyframe.IntKeyframe aintkeyframe[] = new Keyframe.IntKeyframe[j];
        for (int i = 0; i < j; i++)
        {
            aintkeyframe[i] = (Keyframe.IntKeyframe)((Keyframe)arraylist.get(i)).clone();
        }

        return new IntKeyframeSet(aintkeyframe);
    }

    public volatile KeyframeSet clone()
    {
        return clone();
    }

    public volatile Object clone()
    {
        return clone();
    }

    public int getIntValue(float f)
    {
        int i = 1;
        if (mNumKeyframes == 2)
        {
            if (firstTime)
            {
                firstTime = false;
                firstValue = ((Keyframe.IntKeyframe)mKeyframes.get(0)).getIntValue();
                lastValue = ((Keyframe.IntKeyframe)mKeyframes.get(1)).getIntValue();
                deltaValue = lastValue - firstValue;
            }
            float f1 = f;
            if (mInterpolator != null)
            {
                f1 = mInterpolator.getInterpolation(f);
            }
            if (mEvaluator == null)
            {
                return firstValue + (int)((float)deltaValue * f1);
            } else
            {
                return ((Number)mEvaluator.evaluate(f1, Integer.valueOf(firstValue), Integer.valueOf(lastValue))).intValue();
            }
        }
        if (f <= 0.0F)
        {
            Object obj = (Keyframe.IntKeyframe)mKeyframes.get(0);
            Keyframe.IntKeyframe intkeyframe1 = (Keyframe.IntKeyframe)mKeyframes.get(1);
            i = ((Keyframe.IntKeyframe) (obj)).getIntValue();
            int j = intkeyframe1.getIntValue();
            float f5 = ((Keyframe.IntKeyframe) (obj)).getFraction();
            float f7 = intkeyframe1.getFraction();
            obj = intkeyframe1.getInterpolator();
            float f2 = f;
            if (obj != null)
            {
                f2 = ((Interpolator) (obj)).getInterpolation(f);
            }
            f = (f2 - f5) / (f7 - f5);
            if (mEvaluator == null)
            {
                return (int)(f * (float)(j - i)) + i;
            } else
            {
                return ((Number)mEvaluator.evaluate(f, Integer.valueOf(i), Integer.valueOf(j))).intValue();
            }
        }
        if (f >= 1.0F)
        {
            Object obj1 = (Keyframe.IntKeyframe)mKeyframes.get(mNumKeyframes - 2);
            Keyframe.IntKeyframe intkeyframe2 = (Keyframe.IntKeyframe)mKeyframes.get(mNumKeyframes - 1);
            i = ((Keyframe.IntKeyframe) (obj1)).getIntValue();
            int k = intkeyframe2.getIntValue();
            float f6 = ((Keyframe.IntKeyframe) (obj1)).getFraction();
            float f8 = intkeyframe2.getFraction();
            obj1 = intkeyframe2.getInterpolator();
            float f3 = f;
            if (obj1 != null)
            {
                f3 = ((Interpolator) (obj1)).getInterpolation(f);
            }
            f = (f3 - f6) / (f8 - f6);
            if (mEvaluator == null)
            {
                return (int)(f * (float)(k - i)) + i;
            } else
            {
                return ((Number)mEvaluator.evaluate(f, Integer.valueOf(i), Integer.valueOf(k))).intValue();
            }
        }
        Keyframe.IntKeyframe intkeyframe3;
        for (Keyframe.IntKeyframe intkeyframe = (Keyframe.IntKeyframe)mKeyframes.get(0); i < mNumKeyframes; intkeyframe = intkeyframe3)
        {
            intkeyframe3 = (Keyframe.IntKeyframe)mKeyframes.get(i);
            if (f < intkeyframe3.getFraction())
            {
                Interpolator interpolator = intkeyframe3.getInterpolator();
                float f4 = f;
                if (interpolator != null)
                {
                    f4 = interpolator.getInterpolation(f);
                }
                f = (f4 - intkeyframe.getFraction()) / (intkeyframe3.getFraction() - intkeyframe.getFraction());
                i = intkeyframe.getIntValue();
                int l = intkeyframe3.getIntValue();
                if (mEvaluator == null)
                {
                    return (int)((float)(l - i) * f) + i;
                } else
                {
                    return ((Number)mEvaluator.evaluate(f, Integer.valueOf(i), Integer.valueOf(l))).intValue();
                }
            }
            i++;
        }

        return ((Number)((Keyframe)mKeyframes.get(mNumKeyframes - 1)).getValue()).intValue();
    }

    public Object getValue(float f)
    {
        return Integer.valueOf(getIntValue(f));
    }
}
