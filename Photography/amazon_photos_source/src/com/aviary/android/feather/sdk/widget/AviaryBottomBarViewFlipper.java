// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ViewFlipper;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AviaryBottomBarViewFlipper extends ViewFlipper
    implements android.view.View.OnClickListener
{
    public static interface OnBottomBarItemClickListener
    {

        public abstract void onBottomBarItemClick(int i);
    }

    public static interface OnViewChangingStatusListener
    {

        public abstract void onCloseEnd();

        public abstract void onCloseStart();

        public abstract void onOpenEnd();

        public abstract void onOpenStart();
    }


    private OnBottomBarItemClickListener mBottomClickListener;
    private List mListeners;
    private View mLogo;

    public AviaryBottomBarViewFlipper(Context context)
    {
        super(context);
        mListeners = new ArrayList();
    }

    public AviaryBottomBarViewFlipper(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mListeners = new ArrayList();
    }

    public void addOnViewChangingStatusListener(OnViewChangingStatusListener onviewchangingstatuslistener)
    {
        mListeners.add(onviewchangingstatuslistener);
    }

    public boolean close()
    {
label0:
        {
            Animation animation;
label1:
            {
                if (getDisplayedChild() == 0)
                {
                    animation = getInAnimation();
                    if (animation == null)
                    {
                        break label0;
                    }
                    if (!animation.hasStarted() || animation.hasEnded())
                    {
                        break label1;
                    }
                }
                return false;
            }
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final AviaryBottomBarViewFlipper this$0;

                public void onAnimationEnd(Animation animation1)
                {
                    for (animation1 = mListeners.iterator(); animation1.hasNext(); ((OnViewChangingStatusListener)animation1.next()).onCloseEnd()) { }
                    getChildAt(0).setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                    getChildAt(1).setVisibility(0);
                    for (animation1 = mListeners.iterator(); animation1.hasNext(); ((OnViewChangingStatusListener)animation1.next()).onCloseStart()) { }
                }

            
            {
                this$0 = AviaryBottomBarViewFlipper.this;
                super();
            }
            });
        }
        setDisplayedChild(1);
        return true;
    }

    public ViewGroup getContentPanel()
    {
        return (ViewGroup)getChildAt(0);
    }

    public HListView getToolsListView()
    {
        return (HListView)findViewById(com.aviary.android.feather.sdk.R.id.aviary_tools_listview);
    }

    public void onClick(View view)
    {
        if (view != null)
        {
            int i = view.getId();
            if (mBottomClickListener != null)
            {
                mBottomClickListener.onBottomBarItemClick(i);
            }
        }
    }

    protected void onFinishInflate()
    {
        mLogo = findViewById(com.aviary.android.feather.sdk.R.id.aviary_white_logo);
        mLogo.setOnClickListener(this);
        super.onFinishInflate();
    }

    public boolean open()
    {
label0:
        {
            Animation animation;
label1:
            {
                if (getDisplayedChild() == 1)
                {
                    animation = getInAnimation();
                    if (animation == null)
                    {
                        break label0;
                    }
                    if (!animation.hasStarted() || animation.hasEnded())
                    {
                        break label1;
                    }
                }
                return false;
            }
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final AviaryBottomBarViewFlipper this$0;

                public void onAnimationEnd(Animation animation1)
                {
                    for (animation1 = mListeners.iterator(); animation1.hasNext(); ((OnViewChangingStatusListener)animation1.next()).onOpenEnd()) { }
                    getChildAt(1).setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                    getChildAt(0).setVisibility(0);
                    for (animation1 = mListeners.iterator(); animation1.hasNext(); ((OnViewChangingStatusListener)animation1.next()).onOpenStart()) { }
                }

            
            {
                this$0 = AviaryBottomBarViewFlipper.this;
                super();
            }
            });
        }
        setDisplayedChild(0);
        return true;
    }

    public boolean opened()
    {
        return getDisplayedChild() == 0;
    }

    public void removeOnViewChangingStatusListener(OnViewChangingStatusListener onviewchangingstatuslistener)
    {
        mListeners.remove(onviewchangingstatuslistener);
    }

    public void setOnBottomBarItemClickListener(OnBottomBarItemClickListener onbottombaritemclicklistener)
    {
        mBottomClickListener = onbottombaritemclicklistener;
    }

    public void toggleLogoVisibility(boolean flag)
    {
        if (flag)
        {
            findViewById(com.aviary.android.feather.sdk.R.id.aviary_white_logo).setVisibility(0);
            return;
        } else
        {
            findViewById(com.aviary.android.feather.sdk.R.id.aviary_white_logo).setVisibility(4);
            return;
        }
    }

}
