// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.actionbarsherlock.internal.nineoldandroids.animation:
//            AnimatorSet, Animator

class mAnimatorSet
    implements mAnimatorSet
{

    private AnimatorSet mAnimatorSet;
    final AnimatorSet this$0;

    public void onAnimationCancel(Animator animator)
    {
        if (!mTerminated && AnimatorSet.access$000(AnimatorSet.this).size() == 0 && mListeners != null)
        {
            int j = mListeners.size();
            for (int i = 0; i < j; i++)
            {
                ((this._cls0)mListeners.get(i)).ationCancel(mAnimatorSet);
            }

        }
    }

    public void onAnimationEnd(Animator animator)
    {
        animator.removeListener(this);
        AnimatorSet.access$000(AnimatorSet.this).remove(animator);
        ((this._cls0)AnimatorSet.access$100(mAnimatorSet).get(animator)).mAnimatorSet = true;
        if (mTerminated) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        animator = AnimatorSet.access$200(mAnimatorSet);
        j = animator.size();
        i = 0;
_L5:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        if (((mAnimatorSet)animator.get(i)).mAnimatorSet) goto _L4; else goto _L3
_L3:
        i = 0;
_L6:
        if (i != 0)
        {
            if (mListeners != null)
            {
                animator = (ArrayList)mListeners.clone();
                int k = animator.size();
                for (i = 0; i < k; i++)
                {
                    ((mAnimatorSet)animator.get(i)).ationEnd(mAnimatorSet);
                }

            }
            AnimatorSet.access$302(mAnimatorSet, false);
        }
          goto _L2
_L4:
        i++;
          goto _L5
_L2:
        return;
        i = 1;
          goto _L6
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (AnimatorSet animatorset1)
    {
        this$0 = AnimatorSet.this;
        super();
        mAnimatorSet = animatorset1;
    }
}
