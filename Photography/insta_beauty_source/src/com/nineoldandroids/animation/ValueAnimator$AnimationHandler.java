// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

// Referenced classes of package com.nineoldandroids.animation:
//            ValueAnimator

class <init> extends Handler
{

    public void handleMessage(Message message)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        arraylist = (ArrayList)ValueAnimator.access$000().get();
        arraylist1 = (ArrayList)ValueAnimator.access$100().get();
        message.what;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 49
    //                   1 163;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        message = (ArrayList)ValueAnimator.access$200().get();
        Object obj;
        ValueAnimator valueanimator1;
        int i;
        int k;
        int l;
        int i1;
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
            l = i;
            if (message.size() <= 0)
            {
                break;
            }
            ArrayList arraylist2 = (ArrayList)message.clone();
            message.clear();
            l = arraylist2.size();
            int j = 0;
            while (j < l) 
            {
                ValueAnimator valueanimator = (ValueAnimator)arraylist2.get(j);
                if (ValueAnimator.access$300(valueanimator) == 0L)
                {
                    ValueAnimator.access$400(valueanimator);
                } else
                {
                    arraylist1.add(valueanimator);
                }
                j++;
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L3:
        l = 1;
        l1 = AnimationUtils.currentAnimationTimeMillis();
        obj = (ArrayList)ValueAnimator.access$500().get();
        message = (ArrayList)ValueAnimator.access$600().get();
        k = arraylist1.size();
        for (i = 0; i < k; i++)
        {
            valueanimator1 = (ValueAnimator)arraylist1.get(i);
            if (ValueAnimator.access$700(valueanimator1, l1))
            {
                ((ArrayList) (obj)).add(valueanimator1);
            }
        }

        k = ((ArrayList) (obj)).size();
        if (k > 0)
        {
            for (i = 0; i < k; i++)
            {
                valueanimator1 = (ValueAnimator)((ArrayList) (obj)).get(i);
                ValueAnimator.access$400(valueanimator1);
                ValueAnimator.access$802(valueanimator1, true);
                arraylist1.remove(valueanimator1);
            }

            ((ArrayList) (obj)).clear();
        }
        i = arraylist.size();
        k = 0;
        while (k < i) 
        {
            obj = (ValueAnimator)arraylist.get(k);
            if (((ValueAnimator) (obj)).animationFrame(l1))
            {
                message.add(obj);
            }
            if (arraylist.size() == i)
            {
                i1 = k + 1;
                k = i;
                i = i1;
            } else
            {
                message.remove(obj);
                i1 = i - 1;
                i = k;
                k = i1;
            }
            i1 = k;
            k = i;
            i = i1;
        }
        if (message.size() > 0)
        {
            for (i = 0; i < message.size(); i++)
            {
                ValueAnimator.access$900((ValueAnimator)message.get(i));
            }

            message.clear();
        }
        if (l != 0 && (!arraylist.isEmpty() || !arraylist1.isEmpty()))
        {
            sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.access$1000() - (AnimationUtils.currentAnimationTimeMillis() - l1)));
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
