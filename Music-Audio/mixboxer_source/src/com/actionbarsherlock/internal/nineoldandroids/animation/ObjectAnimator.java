// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.HashMap;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            ValueAnimator, PropertyValuesHolder, TypeEvaluator, Animator

public final class ObjectAnimator extends ValueAnimator
{

    private static final boolean DBG = false;
    private String mPropertyName;
    private Object mTarget;

    public ObjectAnimator()
    {
    }

    private ObjectAnimator(Object obj, String s)
    {
        mTarget = obj;
        setPropertyName(s);
    }

    public static transient ObjectAnimator ofFloat(Object obj, String s, float af[])
    {
        obj = new ObjectAnimator(obj, s);
        ((ObjectAnimator) (obj)).setFloatValues(af);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofInt(Object obj, String s, int ai[])
    {
        obj = new ObjectAnimator(obj, s);
        ((ObjectAnimator) (obj)).setIntValues(ai);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofObject(Object obj, String s, TypeEvaluator typeevaluator, Object aobj[])
    {
        obj = new ObjectAnimator(obj, s);
        ((ObjectAnimator) (obj)).setObjectValues(aobj);
        ((ObjectAnimator) (obj)).setEvaluator(typeevaluator);
        return ((ObjectAnimator) (obj));
    }

    public static transient ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder apropertyvaluesholder[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.mTarget = obj;
        objectanimator.setValues(apropertyvaluesholder);
        return objectanimator;
    }

    final void animateValue(float f)
    {
        super.animateValue(f);
        int j = mValues.length;
        for (int i = 0; i < j; i++)
        {
            mValues[i].setAnimatedValue(mTarget);
        }

    }

    public final volatile Animator clone()
    {
        return clone();
    }

    public final ObjectAnimator clone()
    {
        return (ObjectAnimator)super.clone();
    }

    public final volatile ValueAnimator clone()
    {
        return clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final String getPropertyName()
    {
        return mPropertyName;
    }

    public final Object getTarget()
    {
        return mTarget;
    }

    final void initAnimation()
    {
        if (!mInitialized)
        {
            int j = mValues.length;
            for (int i = 0; i < j; i++)
            {
                mValues[i].setupSetterAndGetter(mTarget);
            }

            super.initAnimation();
        }
    }

    public final volatile Animator setDuration(long l)
    {
        return setDuration(l);
    }

    public final ObjectAnimator setDuration(long l)
    {
        super.setDuration(l);
        return this;
    }

    public final volatile ValueAnimator setDuration(long l)
    {
        return setDuration(l);
    }

    public final transient void setFloatValues(float af[])
    {
        if (mValues == null || mValues.length == 0)
        {
            setValues(new PropertyValuesHolder[] {
                PropertyValuesHolder.ofFloat(mPropertyName, af)
            });
            return;
        } else
        {
            super.setFloatValues(af);
            return;
        }
    }

    public final transient void setIntValues(int ai[])
    {
        if (mValues == null || mValues.length == 0)
        {
            setValues(new PropertyValuesHolder[] {
                PropertyValuesHolder.ofInt(mPropertyName, ai)
            });
            return;
        } else
        {
            super.setIntValues(ai);
            return;
        }
    }

    public final transient void setObjectValues(Object aobj[])
    {
        if (mValues == null || mValues.length == 0)
        {
            setValues(new PropertyValuesHolder[] {
                PropertyValuesHolder.ofObject(mPropertyName, null, aobj)
            });
            return;
        } else
        {
            super.setObjectValues(aobj);
            return;
        }
    }

    public final void setPropertyName(String s)
    {
        if (mValues != null)
        {
            PropertyValuesHolder propertyvaluesholder = mValues[0];
            String s1 = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setPropertyName(s);
            mValuesMap.remove(s1);
            mValuesMap.put(s, propertyvaluesholder);
        }
        mPropertyName = s;
        mInitialized = false;
    }

    public final void setTarget(Object obj)
    {
label0:
        {
            if (mTarget != obj)
            {
                Object obj1 = mTarget;
                mTarget = obj;
                if (obj1 == null || obj == null || obj1.getClass() != obj.getClass())
                {
                    break label0;
                }
            }
            return;
        }
        mInitialized = false;
    }

    public final void setupEndValues()
    {
        initAnimation();
        int j = mValues.length;
        for (int i = 0; i < j; i++)
        {
            mValues[i].setupEndValue(mTarget);
        }

    }

    public final void setupStartValues()
    {
        initAnimation();
        int j = mValues.length;
        for (int i = 0; i < j; i++)
        {
            mValues[i].setupStartValue(mTarget);
        }

    }

    public final void start()
    {
        super.start();
    }

    public final String toString()
    {
        String s = (new StringBuilder()).append("ObjectAnimator@").append(Integer.toHexString(hashCode())).append(", target ").append(mTarget).toString();
        String s1 = s;
        if (mValues != null)
        {
            int i = 0;
            do
            {
                s1 = s;
                if (i >= mValues.length)
                {
                    break;
                }
                s = (new StringBuilder()).append(s).append("\n    ").append(mValues[i].toString()).toString();
                i++;
            } while (true);
        }
        return s1;
    }
}
