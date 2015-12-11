// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;

// Referenced classes of package com.tapjoy:
//            TapjoyUtil, TapjoyConnectCore

public class TJCloseButton extends ImageButton
{
    public static final class ClosePosition extends Enum
    {

        private static final ClosePosition $VALUES[];
        public static final ClosePosition BOTTOM_CENTER;
        public static final ClosePosition BOTTOM_LEFT;
        public static final ClosePosition BOTTOM_RIGHT;
        public static final ClosePosition CENTER;
        public static final ClosePosition TOP_CENTER;
        public static final ClosePosition TOP_LEFT;
        public static final ClosePosition TOP_RIGHT;
        private final android.widget.RelativeLayout.LayoutParams layoutParameters = new android.widget.RelativeLayout.LayoutParams(-2, -2);

        public static ClosePosition valueOf(String s)
        {
            return (ClosePosition)Enum.valueOf(com/tapjoy/TJCloseButton$ClosePosition, s);
        }

        public static ClosePosition[] values()
        {
            return (ClosePosition[])$VALUES.clone();
        }

        final android.widget.RelativeLayout.LayoutParams getLayoutParams()
        {
            return layoutParameters;
        }

        static 
        {
            TOP_LEFT = new ClosePosition("TOP_LEFT", 0, new int[] {
                10, 9
            });
            TOP_CENTER = new ClosePosition("TOP_CENTER", 1, new int[] {
                10, 14
            });
            TOP_RIGHT = new ClosePosition("TOP_RIGHT", 2, new int[] {
                10, 11
            });
            CENTER = new ClosePosition("CENTER", 3, new int[] {
                13
            });
            BOTTOM_LEFT = new ClosePosition("BOTTOM_LEFT", 4, new int[] {
                12, 9
            });
            BOTTOM_CENTER = new ClosePosition("BOTTOM_CENTER", 5, new int[] {
                12, 14
            });
            BOTTOM_RIGHT = new ClosePosition("BOTTOM_RIGHT", 6, new int[] {
                12, 11
            });
            $VALUES = (new ClosePosition[] {
                TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
            });
        }

        private ClosePosition(String s, int i, int ai[])
        {
            super(s, i);
            int j = ai.length;
            for (i = 0; i < j; i++)
            {
                int k = ai[i];
                layoutParameters.addRule(k);
            }

            i = (int)(-10F * TapjoyConnectCore.getDeviceScreenDensityScale());
            layoutParameters.setMargins(0, i, i, 0);
        }
    }


    private ClosePosition a;

    public TJCloseButton(Context context)
    {
        this(context, ClosePosition.TOP_RIGHT);
    }

    public TJCloseButton(Context context, ClosePosition closeposition)
    {
        super(context);
        a = closeposition;
        setImageBitmap(TapjoyUtil.loadBitmapFromJar("tj_close_button.png", context));
        setBackgroundColor(0xffffff);
        setLayoutParams(a.getLayoutParams());
    }

    protected void onAttachedToWindow()
    {
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            setAlpha(0.0F);
            setVisibility(0);
            setClickable(false);
            (new Handler()).postDelayed(new Runnable() {

                final TJCloseButton a;

                public final void run()
                {
                    a.animate().alpha(1.0F).setDuration(500L).setListener(new android.animation.Animator.AnimatorListener(this) {

                        final _cls1 a;

                        public final void onAnimationCancel(Animator animator)
                        {
                            a.a.setClickable(true);
                        }

                        public final void onAnimationEnd(Animator animator)
                        {
                            a.a.setClickable(true);
                        }

                        public final void onAnimationRepeat(Animator animator)
                        {
                        }

                        public final void onAnimationStart(Animator animator)
                        {
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                a = TJCloseButton.this;
                super();
            }
            }, 2000L);
        }
    }
}
