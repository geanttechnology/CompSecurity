// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            Animator, PropertyValuesHolder, TypeEvaluator

public class ValueAnimator extends Animator
{

    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    private static final long DEFAULT_FRAME_DELAY = 10L;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private static ThreadLocal sAnimationHandler = new ThreadLocal();
    private static final ThreadLocal sAnimations = new _cls1();
    private static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    private static final ThreadLocal sDelayedAnims = new _cls3();
    private static final ThreadLocal sEndingAnims = new _cls4();
    private static long sFrameDelay = 10L;
    private static final ThreadLocal sPendingAnimations = new _cls2();
    private static final ThreadLocal sReadyAnims = new _cls5();
    private float mCurrentFraction;
    private int mCurrentIteration;
    private long mDelayStartTime;
    private long mDuration;
    boolean mInitialized;
    private Interpolator mInterpolator;
    private boolean mPlayingBackwards;
    int mPlayingState;
    private int mRepeatCount;
    private int mRepeatMode;
    private boolean mRunning;
    long mSeekTime;
    private long mStartDelay;
    long mStartTime;
    private boolean mStarted;
    private boolean mStartedDelay;
    private ArrayList mUpdateListeners;
    PropertyValuesHolder mValues[];
    HashMap mValuesMap;

    public ValueAnimator()
    {
        mSeekTime = -1L;
        mPlayingBackwards = false;
        mCurrentIteration = 0;
        mCurrentFraction = 0.0F;
        mStartedDelay = false;
        mPlayingState = 0;
        mRunning = false;
        mStarted = false;
        mInitialized = false;
        mDuration = 300L;
        mStartDelay = 0L;
        mRepeatCount = 0;
        mRepeatMode = 1;
        mInterpolator = sDefaultInterpolator;
        mUpdateListeners = null;
    }

    public static void clearAllAnimations()
    {
        ((ArrayList)sAnimations.get()).clear();
        ((ArrayList)sPendingAnimations.get()).clear();
        ((ArrayList)sDelayedAnims.get()).clear();
    }

    private boolean delayedAnimationFrame(long l)
    {
        if (!mStartedDelay)
        {
            mStartedDelay = true;
            mDelayStartTime = l;
        } else
        {
            long l1 = l - mDelayStartTime;
            if (l1 > mStartDelay)
            {
                mStartTime = l - (l1 - mStartDelay);
                mPlayingState = 1;
                return true;
            }
        }
        return false;
    }

    private void endAnimation()
    {
        ((ArrayList)sAnimations.get()).remove(this);
        ((ArrayList)sPendingAnimations.get()).remove(this);
        ((ArrayList)sDelayedAnims.get()).remove(this);
        mPlayingState = 0;
        if (mRunning && mListeners != null)
        {
            ArrayList arraylist = (ArrayList)mListeners.clone();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                ((Animator.AnimatorListener)arraylist.get(i)).onAnimationEnd(this);
            }

        }
        mRunning = false;
        mStarted = false;
    }

    public static int getCurrentAnimationsCount()
    {
        return ((ArrayList)sAnimations.get()).size();
    }

    public static long getFrameDelay()
    {
        return sFrameDelay;
    }

    public static transient ValueAnimator ofFloat(float af[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setFloatValues(af);
        return valueanimator;
    }

    public static transient ValueAnimator ofInt(int ai[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setIntValues(ai);
        return valueanimator;
    }

    public static transient ValueAnimator ofObject(TypeEvaluator typeevaluator, Object aobj[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setObjectValues(aobj);
        valueanimator.setEvaluator(typeevaluator);
        return valueanimator;
    }

    public static transient ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder apropertyvaluesholder[])
    {
        ValueAnimator valueanimator = new ValueAnimator();
        valueanimator.setValues(apropertyvaluesholder);
        return valueanimator;
    }

    public static void setFrameDelay(long l)
    {
        sFrameDelay = l;
    }

    private void start(boolean flag)
    {
        if (Looper.myLooper() == null)
        {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        mPlayingBackwards = flag;
        mCurrentIteration = 0;
        mPlayingState = 0;
        mStarted = true;
        mStartedDelay = false;
        ((ArrayList)sPendingAnimations.get()).add(this);
        if (mStartDelay == 0L)
        {
            setCurrentPlayTime(getCurrentPlayTime());
            mPlayingState = 0;
            mRunning = true;
            if (mListeners != null)
            {
                ArrayList arraylist = (ArrayList)mListeners.clone();
                int j = arraylist.size();
                for (int i = 0; i < j; i++)
                {
                    ((Animator.AnimatorListener)arraylist.get(i)).onAnimationStart(this);
                }

            }
        }
        AnimationHandler animationhandler1 = (AnimationHandler)sAnimationHandler.get();
        AnimationHandler animationhandler = animationhandler1;
        if (animationhandler1 == null)
        {
            animationhandler = new AnimationHandler(null);
            sAnimationHandler.set(animationhandler);
        }
        animationhandler.sendEmptyMessage(0);
    }

    private void startAnimation()
    {
        initAnimation();
        ((ArrayList)sAnimations.get()).add(this);
        if (mStartDelay > 0L && mListeners != null)
        {
            ArrayList arraylist = (ArrayList)mListeners.clone();
            int j = arraylist.size();
            for (int i = 0; i < j; i++)
            {
                ((Animator.AnimatorListener)arraylist.get(i)).onAnimationStart(this);
            }

        }
    }

    public void addUpdateListener(AnimatorUpdateListener animatorupdatelistener)
    {
        if (mUpdateListeners == null)
        {
            mUpdateListeners = new ArrayList();
        }
        mUpdateListeners.add(animatorupdatelistener);
    }

    void animateValue(float f)
    {
        f = mInterpolator.getInterpolation(f);
        mCurrentFraction = f;
        int k = mValues.length;
        for (int i = 0; i < k; i++)
        {
            mValues[i].calculateValue(f);
        }

        if (mUpdateListeners != null)
        {
            int l = mUpdateListeners.size();
            for (int j = 0; j < l; j++)
            {
                ((AnimatorUpdateListener)mUpdateListeners.get(j)).onAnimationUpdate(this);
            }

        }
    }

    boolean animationFrame(long l)
    {
        boolean flag1 = false;
        if (mPlayingState == 0)
        {
            mPlayingState = 1;
            if (mSeekTime < 0L)
            {
                mStartTime = l;
            } else
            {
                mStartTime = l - mSeekTime;
                mSeekTime = -1L;
            }
        }
        switch (mPlayingState)
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            break;
        }
        float f;
        if (mDuration > 0L)
        {
            f = (float)(l - mStartTime) / (float)mDuration;
        } else
        {
            f = 1.0F;
        }
        boolean flag;
        if (f >= 1.0F)
        {
            if (mCurrentIteration < mRepeatCount || mRepeatCount == -1)
            {
                if (mListeners != null)
                {
                    int j = mListeners.size();
                    for (int i = 0; i < j; i++)
                    {
                        ((Animator.AnimatorListener)mListeners.get(i)).onAnimationRepeat(this);
                    }

                }
                if (mRepeatMode == 2)
                {
                    float f1;
                    if (mPlayingBackwards)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    mPlayingBackwards = flag;
                }
                mCurrentIteration = mCurrentIteration + (int)f;
                f %= 1.0F;
                mStartTime = mStartTime + mDuration;
                flag = flag1;
            } else
            {
                f = Math.min(f, 1.0F);
                flag = true;
            }
        } else
        {
            flag = flag1;
        }
        f1 = f;
        if (mPlayingBackwards)
        {
            f1 = 1.0F - f;
        }
        animateValue(f1);
        return flag;
    }

    public void cancel()
    {
        if (mPlayingState != 0 || ((ArrayList)sPendingAnimations.get()).contains(this) || ((ArrayList)sDelayedAnims.get()).contains(this))
        {
            if (mRunning && mListeners != null)
            {
                for (Iterator iterator = ((ArrayList)mListeners.clone()).iterator(); iterator.hasNext(); ((Animator.AnimatorListener)iterator.next()).onAnimationCancel(this)) { }
            }
            endAnimation();
        }
    }

    public volatile Animator clone()
    {
        return clone();
    }

    public ValueAnimator clone()
    {
        boolean flag = false;
        ValueAnimator valueanimator = (ValueAnimator)super.clone();
        if (mUpdateListeners != null)
        {
            ArrayList arraylist = mUpdateListeners;
            valueanimator.mUpdateListeners = new ArrayList();
            int k = arraylist.size();
            for (int i = 0; i < k; i++)
            {
                valueanimator.mUpdateListeners.add(arraylist.get(i));
            }

        }
        valueanimator.mSeekTime = -1L;
        valueanimator.mPlayingBackwards = false;
        valueanimator.mCurrentIteration = 0;
        valueanimator.mInitialized = false;
        valueanimator.mPlayingState = 0;
        valueanimator.mStartedDelay = false;
        PropertyValuesHolder apropertyvaluesholder[] = mValues;
        if (apropertyvaluesholder != null)
        {
            int l = apropertyvaluesholder.length;
            valueanimator.mValues = new PropertyValuesHolder[l];
            valueanimator.mValuesMap = new HashMap(l);
            for (int j = ((flag) ? 1 : 0); j < l; j++)
            {
                PropertyValuesHolder propertyvaluesholder = apropertyvaluesholder[j].clone();
                valueanimator.mValues[j] = propertyvaluesholder;
                valueanimator.mValuesMap.put(propertyvaluesholder.getPropertyName(), propertyvaluesholder);
            }

        }
        return valueanimator;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public void end()
    {
        if (!((ArrayList)sAnimations.get()).contains(this) && !((ArrayList)sPendingAnimations.get()).contains(this))
        {
            mStartedDelay = false;
            startAnimation();
        } else
        if (!mInitialized)
        {
            initAnimation();
        }
        if (mRepeatCount > 0 && (mRepeatCount & 1) == 1)
        {
            animateValue(0.0F);
        } else
        {
            animateValue(1.0F);
        }
        endAnimation();
    }

    public float getAnimatedFraction()
    {
        return mCurrentFraction;
    }

    public Object getAnimatedValue()
    {
        if (mValues != null && mValues.length > 0)
        {
            return mValues[0].getAnimatedValue();
        } else
        {
            return null;
        }
    }

    public Object getAnimatedValue(String s)
    {
        s = (PropertyValuesHolder)mValuesMap.get(s);
        if (s != null)
        {
            return s.getAnimatedValue();
        } else
        {
            return null;
        }
    }

    public long getCurrentPlayTime()
    {
        if (!mInitialized || mPlayingState == 0)
        {
            return 0L;
        } else
        {
            return AnimationUtils.currentAnimationTimeMillis() - mStartTime;
        }
    }

    public long getDuration()
    {
        return mDuration;
    }

    public Interpolator getInterpolator()
    {
        return mInterpolator;
    }

    public int getRepeatCount()
    {
        return mRepeatCount;
    }

    public int getRepeatMode()
    {
        return mRepeatMode;
    }

    public long getStartDelay()
    {
        return mStartDelay;
    }

    public PropertyValuesHolder[] getValues()
    {
        return mValues;
    }

    void initAnimation()
    {
        if (!mInitialized)
        {
            int j = mValues.length;
            for (int i = 0; i < j; i++)
            {
                mValues[i].init();
            }

            mInitialized = true;
        }
    }

    public boolean isRunning()
    {
        return mPlayingState == 1 || mRunning;
    }

    public boolean isStarted()
    {
        return mStarted;
    }

    public void removeAllUpdateListeners()
    {
        if (mUpdateListeners == null)
        {
            return;
        } else
        {
            mUpdateListeners.clear();
            mUpdateListeners = null;
            return;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorupdatelistener)
    {
        if (mUpdateListeners != null)
        {
            mUpdateListeners.remove(animatorupdatelistener);
            if (mUpdateListeners.size() == 0)
            {
                mUpdateListeners = null;
                return;
            }
        }
    }

    public void reverse()
    {
        boolean flag;
        if (!mPlayingBackwards)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mPlayingBackwards = flag;
        if (mPlayingState == 1)
        {
            long l = AnimationUtils.currentAnimationTimeMillis();
            long l1 = mStartTime;
            mStartTime = l - (mDuration - (l - l1));
            return;
        } else
        {
            start(true);
            return;
        }
    }

    public void setCurrentPlayTime(long l)
    {
        initAnimation();
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        if (mPlayingState != 1)
        {
            mSeekTime = l;
            mPlayingState = 2;
        }
        mStartTime = l1 - l;
        animationFrame(l1);
    }

    public volatile Animator setDuration(long l)
    {
        return setDuration(l);
    }

    public ValueAnimator setDuration(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Animators cannot have negative duration: ").append(l).toString());
        } else
        {
            mDuration = l;
            return this;
        }
    }

    public void setEvaluator(TypeEvaluator typeevaluator)
    {
        if (typeevaluator != null && mValues != null && mValues.length > 0)
        {
            mValues[0].setEvaluator(typeevaluator);
        }
    }

    public transient void setFloatValues(float af[])
    {
        if (af == null || af.length == 0)
        {
            return;
        }
        if (mValues == null || mValues.length == 0)
        {
            setValues(new PropertyValuesHolder[] {
                PropertyValuesHolder.ofFloat("", af)
            });
        } else
        {
            mValues[0].setFloatValues(af);
        }
        mInitialized = false;
    }

    public transient void setIntValues(int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            return;
        }
        if (mValues == null || mValues.length == 0)
        {
            setValues(new PropertyValuesHolder[] {
                PropertyValuesHolder.ofInt("", ai)
            });
        } else
        {
            mValues[0].setIntValues(ai);
        }
        mInitialized = false;
    }

    public void setInterpolator(Interpolator interpolator)
    {
        if (interpolator != null)
        {
            mInterpolator = interpolator;
            return;
        } else
        {
            mInterpolator = new LinearInterpolator();
            return;
        }
    }

    public transient void setObjectValues(Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            return;
        }
        if (mValues == null || mValues.length == 0)
        {
            setValues(new PropertyValuesHolder[] {
                PropertyValuesHolder.ofObject("", null, aobj)
            });
        } else
        {
            mValues[0].setObjectValues(aobj);
        }
        mInitialized = false;
    }

    public void setRepeatCount(int i)
    {
        mRepeatCount = i;
    }

    public void setRepeatMode(int i)
    {
        mRepeatMode = i;
    }

    public void setStartDelay(long l)
    {
        mStartDelay = l;
    }

    public transient void setValues(PropertyValuesHolder apropertyvaluesholder[])
    {
        int j = apropertyvaluesholder.length;
        mValues = apropertyvaluesholder;
        mValuesMap = new HashMap(j);
        for (int i = 0; i < j; i++)
        {
            PropertyValuesHolder propertyvaluesholder = apropertyvaluesholder[i];
            mValuesMap.put(propertyvaluesholder.getPropertyName(), propertyvaluesholder);
        }

        mInitialized = false;
    }

    public void start()
    {
        start(false);
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("ValueAnimator@").append(Integer.toHexString(hashCode())).toString();
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












/*
    static boolean access$802(ValueAnimator valueanimator, boolean flag)
    {
        valueanimator.mRunning = flag;
        return flag;
    }

*/


    private class AnimationHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            ArrayList arraylist;
            ArrayList arraylist1;
            arraylist = (ArrayList)ValueAnimator.sAnimations.get();
            arraylist1 = (ArrayList)ValueAnimator.sDelayedAnims.get();
            message.what;
            JVM INSTR tableswitch 0 1: default 48
        //                       0 49
        //                       1 163;
               goto _L1 _L2 _L3
_L1:
            return;
_L2:
            message = (ArrayList)ValueAnimator.sPendingAnimations.get();
            Object obj;
            ValueAnimator valueanimator1;
            int i;
            int j;
            int l;
            long l1;
            if (arraylist.size() > 0 || arraylist1.size() > 0)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            do
            {
                j = i;
                if (message.size() <= 0)
                {
                    break;
                }
                ArrayList arraylist2 = (ArrayList)message.clone();
                message.clear();
                int k = arraylist2.size();
                j = 0;
                while (j < k) 
                {
                    ValueAnimator valueanimator = (ValueAnimator)arraylist2.get(j);
                    if (valueanimator.mStartDelay == 0L)
                    {
                        valueanimator.startAnimation();
                    } else
                    {
                        arraylist1.add(valueanimator);
                    }
                    j++;
                }
            } while (true);
            break; /* Loop/switch isn't completed */
_L3:
            j = 1;
            l1 = AnimationUtils.currentAnimationTimeMillis();
            obj = (ArrayList)ValueAnimator.sReadyAnims.get();
            message = (ArrayList)ValueAnimator.sEndingAnims.get();
            l = arraylist1.size();
            for (i = 0; i < l; i++)
            {
                valueanimator1 = (ValueAnimator)arraylist1.get(i);
                if (valueanimator1.delayedAnimationFrame(l1))
                {
                    ((ArrayList) (obj)).add(valueanimator1);
                }
            }

            l = ((ArrayList) (obj)).size();
            if (l > 0)
            {
                for (i = 0; i < l; i++)
                {
                    valueanimator1 = (ValueAnimator)((ArrayList) (obj)).get(i);
                    valueanimator1.startAnimation();
                    valueanimator1.mRunning = true;
                    arraylist1.remove(valueanimator1);
                }

                ((ArrayList) (obj)).clear();
            }
            l = arraylist.size();
            for (i = 0; i < l;)
            {
                obj = (ValueAnimator)arraylist.get(i);
                if (((ValueAnimator) (obj)).animationFrame(l1))
                {
                    message.add(obj);
                }
                if (arraylist.size() == l)
                {
                    i++;
                } else
                {
                    l--;
                    message.remove(obj);
                }
            }

            if (message.size() > 0)
            {
                for (i = 0; i < message.size(); i++)
                {
                    ((ValueAnimator)message.get(i)).endAnimation();
                }

                message.clear();
            }
            if (j != 0 && (!arraylist.isEmpty() || !arraylist1.isEmpty()))
            {
                sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - l1)));
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        private AnimationHandler()
        {
        }

        AnimationHandler(_cls1 _pcls1)
        {
            this();
        }
    }


    private class AnimatorUpdateListener
    {

        public abstract void onAnimationUpdate(ValueAnimator valueanimator);
    }


    private class _cls1 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final ArrayList initialValue()
        {
            return new ArrayList();
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final ArrayList initialValue()
        {
            return new ArrayList();
        }

        _cls2()
        {
        }
    }


    private class _cls3 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final ArrayList initialValue()
        {
            return new ArrayList();
        }

        _cls3()
        {
        }
    }


    private class _cls4 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final ArrayList initialValue()
        {
            return new ArrayList();
        }

        _cls4()
        {
        }
    }


    private class _cls5 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final ArrayList initialValue()
        {
            return new ArrayList();
        }

        _cls5()
        {
        }
    }

}
