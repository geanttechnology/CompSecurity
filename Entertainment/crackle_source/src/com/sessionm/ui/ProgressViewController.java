// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sessionm.api.ext.Config;
import com.sessionm.core.Drawables;
import com.sessionm.core.i;
import java.util.Map;

public class ProgressViewController
{
    public static interface Listener
    {

        public abstract void onCancel();

        public abstract void onReloadStarted();
    }

    public static final class ReloadPromptState extends Enum
    {

        private static final ReloadPromptState $VALUES[];
        public static final ReloadPromptState LOADING;
        public static final ReloadPromptState RELOAD;
        public static final ReloadPromptState UNAVAILABLE;

        public static ReloadPromptState valueOf(String s)
        {
            return (ReloadPromptState)Enum.valueOf(com/sessionm/ui/ProgressViewController$ReloadPromptState, s);
        }

        public static ReloadPromptState[] values()
        {
            return (ReloadPromptState[])$VALUES.clone();
        }

        static 
        {
            LOADING = new ReloadPromptState("LOADING", 0);
            RELOAD = new ReloadPromptState("RELOAD", 1);
            UNAVAILABLE = new ReloadPromptState("UNAVAILABLE", 2);
            $VALUES = (new ReloadPromptState[] {
                LOADING, RELOAD, UNAVAILABLE
            });
        }

        private ReloadPromptState(String s, int j)
        {
            super(s, j);
        }
    }


    private static final int BUTTON_PADDING = 150;
    private static final String CANNOT_CONNECT = "Cannot Connect";
    private static final int DURATION = 100;
    private static final String LOADING = "Loading";
    private static final String OKAY = "Okay";
    private static final String RETRY = "Retry";
    private static final String TEMPORARILY_UNAVAILABLE = "Temporarily Unavailable";
    private final Activity activity;
    private ScrollView containerLayout;
    private final Listener listener;
    private AnimationDrawable loadingAnimation;
    private TextView loadingTextView;
    private ImageView logoImageView;
    private ReloadPromptState reloadPromptState;
    private Button retryOkayButton;
    private boolean showCloseButton;
    private final ViewGroup viewParent;

    public ProgressViewController(Activity activity1, ViewGroup viewgroup, Listener listener1, boolean flag)
    {
        showCloseButton = true;
        activity = activity1;
        viewParent = viewgroup;
        listener = listener1;
        showCloseButton = flag;
    }

    public ProgressViewController(Activity activity1, Listener listener1)
    {
        showCloseButton = true;
        activity = activity1;
        viewParent = null;
        listener = listener1;
    }

    private String getLabel(Config config, String s)
    {
        return getValueOrDefault(config.getTransitionButtonMap(), s);
    }

    private String getMessage(Config config, String s)
    {
        return getValueOrDefault(config.getTransitionMessageMap(), s);
    }

    private String getValueOrDefault(Map map, String s)
    {
label0:
        {
            if (map == null)
            {
                return s;
            }
            String s1 = (String)map.get(s);
            if (s1 != null)
            {
                map = s1;
                if (!s1.equals(""))
                {
                    break label0;
                }
            }
            map = s;
        }
        return map;
    }

    public void dismiss()
    {
        if (containerLayout == null)
        {
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(activity, 0x10a0001);
            animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                final ProgressViewController this$0;

                public void onAnimationEnd(Animation animation1)
                {
                    if (containerLayout == null)
                    {
                        return;
                    } else
                    {
                        activity.runOnUiThread(new Runnable() {

                            final _cls3 this$1;

                            public void run()
                            {
                                ViewGroup viewgroup = (ViewGroup)containerLayout.getParent();
                                if (viewgroup != null)
                                {
                                    viewgroup.removeView(containerLayout);
                                }
                                containerLayout.removeAllViews();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        return;
                    }
                }

                public void onAnimationRepeat(Animation animation1)
                {
                }

                public void onAnimationStart(Animation animation1)
                {
                }

            
            {
                this$0 = ProgressViewController.this;
                super();
            }
            });
            containerLayout.startAnimation(animation);
            return;
        }
    }

    public boolean isPresented()
    {
        return containerLayout != null;
    }

    public boolean isReloadPromptState()
    {
        return reloadPromptState == ReloadPromptState.RELOAD;
    }

    public void present(ReloadPromptState reloadpromptstate)
    {
        Object obj;
        RelativeLayout relativelayout;
        LinearLayout linearlayout;
        Config config;
label0:
        {
            if (containerLayout != null)
            {
                return;
            }
            containerLayout = new ScrollView(activity);
            containerLayout.setFillViewport(true);
            containerLayout.setBackgroundColor(-1);
            containerLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            relativelayout = new RelativeLayout(activity);
            relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13, -1);
            linearlayout = new LinearLayout(activity);
            linearlayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            linearlayout.setOrientation(1);
            config = Config.getInstance();
            String s = config.getTransitionViewTitle();
            if (s != null)
            {
                obj = s;
                if (!s.equals(""))
                {
                    break label0;
                }
            }
            obj = "REWARDS\nPowered by mPOINTS";
        }
        String as[] = ((String) (obj)).split("[\r\n]+");
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 1;
        TextView textview = new TextView(activity);
        if (as.length > 0)
        {
            obj = as[0];
        } else
        {
            obj = "";
        }
        textview.setText(((CharSequence) (obj)));
        textview.setLayoutParams(layoutparams);
        textview.setTextSize(40F);
        textview.setTextColor(Color.rgb(31, 31, 31));
        textview.setMaxLines(3);
        textview.setPadding(50, 0, 50, 0);
        linearlayout.addView(textview);
        if (as.length > 1)
        {
            obj = new TextView(activity);
            ((TextView) (obj)).setText(as[1]);
            ((TextView) (obj)).setTextColor(Color.rgb(41, 41, 41));
            ((TextView) (obj)).setTextSize(20F);
            ((TextView) (obj)).setMaxLines(3);
            ((TextView) (obj)).setPadding(50, 0, 50, 0);
            ((TextView) (obj)).setLayoutParams(layoutparams);
            linearlayout.addView(((View) (obj)));
        }
        logoImageView = new ImageView(activity);
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.gravity = 1;
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(0, 50, 0, 0);
        logoImageView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        linearlayout.addView(logoImageView);
        if (config.getTransitionViewLoader() == null)
        {
            loadingAnimation = new AnimationDrawable();
            loadingAnimation.addFrame(Drawables.ay.e(activity), 100);
            loadingAnimation.addFrame(Drawables.az.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aA.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aB.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aC.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aD.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aE.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aF.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aG.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aH.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aI.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aJ.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aK.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aL.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aM.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aN.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aO.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aP.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aQ.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aR.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aS.e(activity), 100);
            loadingAnimation.addFrame(Drawables.aT.e(activity), 100);
            loadingAnimation.setOneShot(false);
        } else
        {
            loadingAnimation = config.getTransitionViewLoader();
        }
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.gravity = 1;
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(0, 70, 0, 20);
        loadingTextView = new TextView(activity);
        loadingTextView.setTextSize(20F);
        loadingTextView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        loadingTextView.setTextColor(Color.rgb(41, 41, 41));
        loadingTextView.setMaxLines(2);
        linearlayout.addView(loadingTextView);
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.gravity = 1;
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(0, 50, 0, 50);
        retryOkayButton = new Button(activity);
        retryOkayButton.setPadding(150, 4, 150, 5);
        retryOkayButton.setBackgroundColor(Color.rgb(189, 195, 199));
        retryOkayButton.setTextColor(Color.rgb(41, 41, 41));
        retryOkayButton.setTextSize(28F);
        retryOkayButton.setSingleLine(true);
        retryOkayButton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        retryOkayButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ProgressViewController this$0;

            public void onClick(View view)
            {
                activity.runOnUiThread(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        if (reloadPromptState == ReloadPromptState.UNAVAILABLE)
                        {
                            listener.onCancel();
                            return;
                        } else
                        {
                            setReloadPropmptState(ReloadPromptState.LOADING);
                            listener.onReloadStarted();
                            return;
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = ProgressViewController.this;
                super();
            }
        });
        linearlayout.addView(retryOkayButton);
        relativelayout.addView(linearlayout);
        containerLayout.addView(relativelayout);
        if (showCloseButton)
        {
            obj = i.d(activity);
            ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final ProgressViewController this$0;

                public void onClick(View view)
                {
                    if (listener != null)
                    {
                        listener.onCancel();
                    }
                }

            
            {
                this$0 = ProgressViewController.this;
                super();
            }
            });
            relativelayout.addView(((View) (obj)));
        }
        setReloadPropmptState(reloadpromptstate);
        if (viewParent != null)
        {
            viewParent.addView(containerLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        } else
        {
            activity.addContentView(containerLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        }
    }

    public void setReloadPropmptState(ReloadPromptState reloadpromptstate)
    {
        if (containerLayout == null || reloadpromptstate == reloadPromptState)
        {
            return;
        }
        reloadPromptState = reloadpromptstate;
        Config config = Config.getInstance();
        if (reloadpromptstate == ReloadPromptState.RELOAD)
        {
            android.graphics.drawable.BitmapDrawable bitmapdrawable = config.getTransitionViewErrorIcon();
            reloadpromptstate = bitmapdrawable;
            if (bitmapdrawable == null)
            {
                reloadpromptstate = Drawables.ax.e(activity);
            }
            if (android.os.Build.VERSION.SDK_INT > 16)
            {
                logoImageView.setBackground(reloadpromptstate);
            } else
            {
                logoImageView.setBackgroundDrawable(reloadpromptstate);
            }
            loadingAnimation.stop();
            loadingTextView.setText(getMessage(config, "Cannot Connect"));
            loadingTextView.setVisibility(0);
            retryOkayButton.setText(getLabel(config, "Retry"));
            retryOkayButton.setVisibility(0);
            return;
        }
        if (reloadpromptstate == ReloadPromptState.UNAVAILABLE)
        {
            android.graphics.drawable.BitmapDrawable bitmapdrawable1 = config.getTransitionViewErrorIcon();
            reloadpromptstate = bitmapdrawable1;
            if (bitmapdrawable1 == null)
            {
                reloadpromptstate = Drawables.ax.e(activity);
            }
            if (android.os.Build.VERSION.SDK_INT > 16)
            {
                logoImageView.setBackground(reloadpromptstate);
            } else
            {
                logoImageView.setBackgroundDrawable(reloadpromptstate);
            }
            loadingAnimation.stop();
            loadingTextView.setText(getMessage(config, "Temporarily Unavailable"));
            loadingTextView.setVisibility(0);
            retryOkayButton.setText(getLabel(config, "Okay"));
            retryOkayButton.setVisibility(0);
            return;
        }
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            logoImageView.setBackground(loadingAnimation);
        } else
        {
            logoImageView.setBackgroundDrawable(loadingAnimation);
        }
        loadingAnimation.start();
        if (!i.m(14))
        {
            loadingAnimation.stop();
            logoImageView.post(new Runnable() {

                final ProgressViewController this$0;

                public void run()
                {
                    loadingAnimation.start();
                }

            
            {
                this$0 = ProgressViewController.this;
                super();
            }
            });
        }
        loadingTextView.setText(String.format("%s...", new Object[] {
            getMessage(config, "Loading")
        }));
        loadingTextView.setVisibility(0);
        retryOkayButton.setVisibility(4);
    }





}
