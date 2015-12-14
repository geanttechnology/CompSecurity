// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class FoldersBottomSheet
{

    private final int BOTTOM_SHEET_ANIM_DURATION = 250;
    private final LinearLayout bottomSheet;
    private final Button button;
    private final String pluralForm;
    private final String singularForm;

    public FoldersBottomSheet(Activity activity, android.view.View.OnClickListener onclicklistener)
    {
        bottomSheet = (LinearLayout)activity.findViewById(0x7f0c0154);
        button = (Button)bottomSheet.findViewById(0x7f0c0146);
        button.setOnClickListener(onclicklistener);
        singularForm = activity.getResources().getString(0x7f0e01ba);
        pluralForm = activity.getResources().getString(0x7f0e01bb);
    }

    public void toggle(boolean flag)
    {
        AnimatorListenerAdapter animatorlisteneradapter;
        int i;
        if (flag)
        {
            i = 0;
            animatorlisteneradapter = new AnimatorListenerAdapter() {

                final FoldersBottomSheet this$0;

                public void onAnimationStart(Animator animator)
                {
                    bottomSheet.setVisibility(0);
                }

            
            {
                this$0 = FoldersBottomSheet.this;
                super();
            }
            };
        } else
        {
            i = bottomSheet.getHeight();
            animatorlisteneradapter = new AnimatorListenerAdapter() {

                final FoldersBottomSheet this$0;

                public void onAnimationEnd(Animator animator)
                {
                    bottomSheet.setVisibility(8);
                }

            
            {
                this$0 = FoldersBottomSheet.this;
                super();
            }
            };
        }
        bottomSheet.animate().translationY(i).setDuration(250L).setInterpolator(new DecelerateInterpolator()).setListener(animatorlisteneradapter);
    }

    public void updateView(int i)
    {
        Button button1 = button;
        String s;
        if (i > 1)
        {
            s = pluralForm;
        } else
        {
            s = singularForm;
        }
        button1.setText(s);
    }

}
