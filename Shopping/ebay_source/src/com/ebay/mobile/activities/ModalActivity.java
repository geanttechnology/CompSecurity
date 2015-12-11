// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

public class ModalActivity extends BaseActivity
{

    private static final int ANIMATION_DELAY = 200;
    private static final int ANIMATION_DURATION = 500;
    private static final float ANIMATION_SCALE_FULL = 1F;
    private static final float ANIMATION_SCALE_ZERO = 0F;
    public static final String EXTRA_SOURCE_VIEW_LOCATION = "source_view_location";
    public static final String EXTRA_USE_CANCEL_DONE_BUTTONS = "use_cancel_done_buttons";
    public static final String IS_CANCELABLE = "is_cancelable";
    public static final String IS_PARENT_ACTIVITY_MODAL = "is_parent_activity_modal";
    private float animateOutX;
    private float animateOutY;
    private ImageButton backButton;
    private TextView cancelButton;
    private ImageButton closeButton;
    private TextView doneButton;
    protected boolean isCancelable;
    private boolean isParentActivityModal;
    private boolean isTablet;
    private View modalBackground;
    private View modalMain;
    private int modalPosX;
    private int modalPosY;

    public ModalActivity()
    {
        modalBackground = null;
        modalMain = null;
        backButton = null;
        closeButton = null;
        cancelButton = null;
        doneButton = null;
        modalPosX = 0;
        modalPosY = 0;
        animateOutX = 0.0F;
        animateOutY = 0.0F;
        isParentActivityModal = false;
        isTablet = false;
        isCancelable = true;
    }

    private void animateIn()
    {
        AccelerateDecelerateInterpolator acceleratedecelerateinterpolator = new AccelerateDecelerateInterpolator();
        Object obj = findViewById(0x7f1003a0);
        ((View) (obj)).setPivotX(((View) (obj)).getWidth());
        ((View) (obj)).setPivotY(0.0F);
        ((View) (obj)).setScaleX(0.0F);
        ((View) (obj)).setScaleY(0.0F);
        int ai[] = getIntent().getIntArrayExtra("source_view_location");
        int ai1[] = new int[2];
        ((View) (obj)).getLocationOnScreen(ai1);
        if (ai != null)
        {
            ((View) (obj)).setTranslationX(ai[0] - ai1[0]);
            ((View) (obj)).setTranslationY(ai[1] - ai1[1]);
            animateOutX = ((View) (obj)).getX();
            animateOutY = ((View) (obj)).getY();
            obj = ((View) (obj)).animate();
            ((ViewPropertyAnimator) (obj)).setStartDelay(200L).setDuration(500L);
            ((ViewPropertyAnimator) (obj)).setInterpolator(acceleratedecelerateinterpolator);
            ((ViewPropertyAnimator) (obj)).scaleX(1.0F).scaleY(1.0F).x(modalPosX).y(modalPosY);
        } else
        {
            animateOutX = ((View) (obj)).getX();
            animateOutY = ((View) (obj)).getY();
            obj = ((View) (obj)).animate();
            ((ViewPropertyAnimator) (obj)).setStartDelay(200L).setDuration(500L);
            ((ViewPropertyAnimator) (obj)).setInterpolator(acceleratedecelerateinterpolator);
            ((ViewPropertyAnimator) (obj)).scaleX(1.0F).scaleY(1.0F);
        }
        if (isParentActivityModal)
        {
            return;
        } else
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofObject(modalBackground, "backgroundColor", new ArgbEvaluator(), new Object[] {
                Integer.valueOf(getResources().getColor(0x106000d)), Integer.valueOf(getResources().getColor(0x7f0d001c))
            });
            objectanimator.setDuration(500L).setStartDelay(200L);
            objectanimator.start();
            return;
        }
    }

    private void animateOut()
    {
        AccelerateDecelerateInterpolator acceleratedecelerateinterpolator = new AccelerateDecelerateInterpolator();
        ViewPropertyAnimator viewpropertyanimator = findViewById(0x7f1003a0).animate();
        viewpropertyanimator.setStartDelay(200L).setDuration(500L);
        viewpropertyanimator.setInterpolator(acceleratedecelerateinterpolator);
        viewpropertyanimator.scaleX(0.0F).scaleY(0.0F);
        viewpropertyanimator.x(animateOutX).y(animateOutY);
        viewpropertyanimator.setListener(new AnimatorListenerAdapter() {

            final ModalActivity this$0;

            public void onAnimationEnd(Animator animator)
            {
                finish();
            }

            
            {
                this$0 = ModalActivity.this;
                super();
            }
        });
        if (isParentActivityModal)
        {
            return;
        } else
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofObject(modalBackground, "backgroundColor", new ArgbEvaluator(), new Object[] {
                Integer.valueOf(getResources().getColor(0x7f0d001c)), Integer.valueOf(getResources().getColor(0x106000d))
            });
            objectanimator.setDuration(500L).setStartDelay(200L);
            objectanimator.start();
            return;
        }
    }

    private void setDefaultToolbarTitle()
    {
        CharSequence charsequence = getTitle();
        TextView textview = (TextView)findViewById(0x7f1003a5);
        if (charsequence != null && !charsequence.toString().isEmpty())
        {
            textview.setText(charsequence);
            return;
        } else
        {
            textview.setText("");
            return;
        }
    }

    public void finish()
    {
        if (isTablet)
        {
            animateOut();
            return;
        } else
        {
            super.finish();
            return;
        }
    }

    public View getContentView()
    {
        return findViewById(0x7f1003a9);
    }

    public void hideBackButton()
    {
        if (backButton != null)
        {
            backButton.setVisibility(8);
        }
    }

    public void hideCancelButton()
    {
        if (cancelButton != null)
        {
            cancelButton.setVisibility(8);
        }
    }

    public void hideCloseButton()
    {
        if (closeButton != null)
        {
            closeButton.setVisibility(8);
        }
    }

    public void hideDoneButton()
    {
        if (doneButton != null)
        {
            doneButton.setVisibility(8);
        }
    }

    public void onBackPressed()
    {
        if (!isCancelable)
        {
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onPostCreate(final Bundle modalMain)
    {
        super.onPostCreate(modalMain);
        if (modalMain != null)
        {
            isCancelable = modalMain.getBoolean("is_cancelable", false);
        }
        setCancelable(isCancelable);
        isTablet = getResources().getBoolean(0x7f0b0006);
        isParentActivityModal = getIntent().getBooleanExtra("is_parent_activity_modal", false);
        modalMain = findViewById(0x7f1003a0);
        ViewTreeObserver viewtreeobserver = modalMain.getViewTreeObserver();
        if (viewtreeobserver.isAlive())
        {
            viewtreeobserver.addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final ModalActivity this$0;
                final View val$modalMain;

                public void onGlobalLayout()
                {
                    modalMain.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    modalPosX = modalMain.getLeft();
                    modalPosY = modalMain.getTop();
                    if (isTablet)
                    {
                        animateIn();
                    }
                }

            
            {
                this$0 = ModalActivity.this;
                modalMain = view;
                super();
            }
            });
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_cancelable", isCancelable);
    }

    public void setBackButtonOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (backButton != null)
        {
            backButton.setOnClickListener(onclicklistener);
        }
    }

    public void setCancelButtonOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (cancelButton != null)
        {
            cancelButton.setOnClickListener(onclicklistener);
        }
    }

    public void setCancelable(boolean flag)
    {
        isCancelable = flag;
        android.view.View.OnClickListener onclicklistener;
        if (isCancelable)
        {
            onclicklistener = new android.view.View.OnClickListener() {

                final ModalActivity this$0;

                public void onClick(View view)
                {
                    onBackPressed();
                }

            
            {
                this$0 = ModalActivity.this;
                super();
            }
            };
        } else
        {
            onclicklistener = new android.view.View.OnClickListener() {

                final ModalActivity this$0;

                public void onClick(View view)
                {
                }

            
            {
                this$0 = ModalActivity.this;
                super();
            }
            };
        }
        modalBackground.setOnClickListener(onclicklistener);
    }

    public void setCloseButtonOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (closeButton != null)
        {
            closeButton.setOnClickListener(onclicklistener);
        }
    }

    public void setContentView(int i)
    {
        Object obj = getLayoutInflater().inflate(0x7f030164, null);
        View view = ((View) (obj)).findViewById(0x7f1003a9);
        getLayoutInflater().inflate(i, (ViewGroup)view, true);
        getWindow().setLayout(-1, -1);
        super.setContentView(((View) (obj)));
        modalBackground = findViewById(0x7f10039f);
        modalMain = findViewById(0x7f1003a0);
        modalMain.setOnClickListener(null);
        obj = new android.view.View.OnClickListener() {

            final ModalActivity this$0;

            public void onClick(View view1)
            {
                finish();
            }

            
            {
                this$0 = ModalActivity.this;
                super();
            }
        };
        backButton = (ImageButton)findViewById(0x7f1003a4);
        backButton.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        closeButton = (ImageButton)findViewById(0x7f1003a8);
        closeButton.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        cancelButton = (TextView)findViewById(0x7f1003a3);
        cancelButton.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        doneButton = (TextView)findViewById(0x7f1003a7);
        doneButton.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        setDefaultToolbarTitle();
        if (getIntent().getBooleanExtra("use_cancel_done_buttons", false))
        {
            showCancelDoneButtons();
            return;
        } else
        {
            showBackCloseButtons();
            return;
        }
    }

    public void setDoneButtonOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (doneButton != null)
        {
            doneButton.setOnClickListener(onclicklistener);
        }
    }

    public void setTitle(int i)
    {
        setToolbarTitle(i);
    }

    public void setTitle(CharSequence charsequence)
    {
        setToolbarTitle(charsequence);
    }

    public void setToolbarTitle(int i)
    {
        ((TextView)findViewById(0x7f1003a5)).setText(i);
    }

    public void setToolbarTitle(CharSequence charsequence)
    {
        ((TextView)findViewById(0x7f1003a5)).setText(charsequence);
    }

    public void showBackButton()
    {
        if (backButton != null)
        {
            backButton.setVisibility(0);
        }
    }

    public void showBackCloseButtons()
    {
        cancelButton.setVisibility(8);
        doneButton.setVisibility(8);
        backButton.setVisibility(0);
        closeButton.setVisibility(0);
    }

    public void showCancelButton()
    {
        if (cancelButton != null)
        {
            cancelButton.setVisibility(0);
        }
    }

    public void showCancelDoneButtons()
    {
        cancelButton.setVisibility(0);
        doneButton.setVisibility(0);
        backButton.setVisibility(8);
        closeButton.setVisibility(8);
    }

    public void showCloseButton()
    {
        if (closeButton != null)
        {
            closeButton.setVisibility(0);
        }
    }

    public void showDoneButton()
    {
        if (doneButton != null)
        {
            doneButton.setVisibility(0);
        }
    }

    public void startActivity(Intent intent)
    {
        if (!intent.hasExtra("is_parent_activity_modal"))
        {
            intent.putExtra("is_parent_activity_modal", true);
        }
        super.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i)
    {
        if (!intent.hasExtra("is_parent_activity_modal"))
        {
            intent.putExtra("is_parent_activity_modal", true);
        }
        super.startActivityForResult(intent, i);
    }


/*
    static int access$002(ModalActivity modalactivity, int i)
    {
        modalactivity.modalPosX = i;
        return i;
    }

*/


/*
    static int access$102(ModalActivity modalactivity, int i)
    {
        modalactivity.modalPosY = i;
        return i;
    }

*/



}
