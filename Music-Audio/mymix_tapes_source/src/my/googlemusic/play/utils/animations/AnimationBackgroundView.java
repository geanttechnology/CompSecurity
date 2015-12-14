// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.animations;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class AnimationBackgroundView
{

    private boolean active;
    private List mAnimationList;
    private View mBackground;
    private View mBackgroundTransition;

    public AnimationBackgroundView(View view, View view1)
    {
        mBackground = view;
        mBackgroundTransition = view1;
        mAnimationList = getList();
    }

    private List getList()
    {
        mAnimationList = new ArrayList();
        mAnimationList.add(Integer.valueOf(0x7f020048));
        mAnimationList.add(Integer.valueOf(0x7f020049));
        mAnimationList.add(Integer.valueOf(0x7f02004a));
        mAnimationList.add(Integer.valueOf(0x7f02004b));
        mAnimationList.add(Integer.valueOf(0x7f02004c));
        return mAnimationList;
    }

    public void animatedBackground(int i, int j)
    {
        if (active)
        {
            mBackground.setBackgroundResource(((Integer)mAnimationList.get(i)).intValue());
            mBackgroundTransition.setVisibility(4);
            mBackgroundTransition.setBackgroundResource(((Integer)mAnimationList.get(j)).intValue());
            mBackgroundTransition.postDelayed(new _cls1(i, j), 3000L);
        }
    }

    public void setAnimationActive(Boolean boolean1)
    {
        active = boolean1.booleanValue();
    }


    /* member class not found */
    class _cls1 {}

}
