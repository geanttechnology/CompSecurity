// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.DynamicLayout;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.utils.Maturity;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public abstract class AviaryOverlay extends RelativeLayout
    implements android.view.View.OnClickListener
{
    public static interface OnCloseListener
    {

        public abstract void onClose(AviaryOverlay aviaryoverlay);
    }


    protected static final boolean DEBUG_PAINT = false;
    public static final int ID_BLEMISH = 2;
    public static final int ID_BLEMISH_CLOSE = 4;
    public static final int ID_CANT_UNDO_ANYMORE = 6;
    public static final int ID_FRAMES = 3;
    public static final int ID_NONE = -1;
    public static final int ID_OVERLAYS = 7;
    public static final int ID_OVERLAYS_PINCH = 8;
    public static final int ID_STICKERS = 1;
    public static final int ID_UNDO_REDO = 5;
    private static final Object M_LOCK = new Object();
    protected static final CharSequence POSITION_CENTER = "center";
    protected static final CharSequence POSITION_LEFT = "left";
    protected static final CharSequence POSITION_RIGHT = "right";
    private static final String PREFERENCE_KEY = "overlay-";
    private static final String PREFERENCE_NAME = "aviary-overlays";
    protected static final String TAG_CLOSE_FROM_BACKGROUND = "background";
    protected static final String TAG_CLOSE_FROM_BACK_BUTTON = "back";
    protected static final String TAG_CLOSE_FROM_BUTTON = "button";
    protected static final boolean USE_CIRCLE = false;
    private static SharedPreferences mPreferences;
    private float alpha;
    protected Paint debugPaint;
    private Animator hideAnimation;
    private boolean inLayout;
    protected final com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private final int mActivationDelay;
    private boolean mActive;
    private final int mAnimationDuration;
    private final int mArrow;
    private final int mBackgroundAlpha;
    private int mBackgroundColor;
    private Button mCloseButton;
    protected OnCloseListener mCloseListener;
    protected final int mClosebuttonMargins;
    private final DisplayMetrics mMetrics;
    protected boolean mOrientationChanged;
    private final int mOriginalBackgroundColor;
    private final int mRipple;
    private final String mTagName;
    private final int mTextMargins;
    private final int mTextStyle;
    private final int mTitleMargins;
    private final int mTitleStyle;
    private boolean mVisible;
    private int overlayId;
    private Animator showAnimation;

    public AviaryOverlay(Context context, String s, int i, int j)
    {
        super(context);
        alpha = 0.0F;
        logger = LoggerFactory.getLogger(getClass().getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        Resources resources = context.getResources();
        overlayId = j;
        mTagName = s;
        context = context.getTheme().obtainStyledAttributes(i, com.aviary.android.feather.sdk.R.styleable.AviaryOverlay);
        mOriginalBackgroundColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_android_background, 0xff000000);
        mTitleStyle = context.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_titleStyle, 0x1030042);
        mTextStyle = context.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_textStyle, 0x1030044);
        mArrow = context.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_arrow, com.aviary.android.feather.sdk.R.drawable.aviary_overlay_blemish_arrow);
        mRipple = context.getResourceId(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_ripple, com.aviary.android.feather.sdk.R.drawable.aviary_overlay_ripple);
        mTextMargins = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_textMargins, 0);
        mTitleMargins = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_titleMargins, 0);
        mAnimationDuration = context.getInt(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_android_animationDuration, 250);
        mClosebuttonMargins = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_closeButtonMargins, 0);
        mActivationDelay = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryOverlay_aviary_activationDelay, 0);
        context.recycle();
        mBackgroundColor = mOriginalBackgroundColor;
        mBackgroundAlpha = Color.alpha(mOriginalBackgroundColor);
        mMetrics = resources.getDisplayMetrics();
        logger.log("background color: 0x%s", new Object[] {
            Integer.toHexString(mBackgroundColor)
        });
        logger.log("background alpha: %d", new Object[] {
            Integer.valueOf(mBackgroundAlpha)
        });
        setTag(getClass().getName());
        setVisibility(4);
        setHardwareAccelerated(true);
    }

    private DynamicLayout createHTMLTextLayout(CharSequence charsequence, int i, android.text.Layout.Alignment alignment, int j)
    {
        TextPaint textpaint = new TextPaint();
        textpaint.setAntiAlias(true);
        textpaint.setLinearText(true);
        textpaint.setFilterBitmap(true);
        TextAppearanceSpan textappearancespan = new TextAppearanceSpan(getContext(), j);
        charsequence = (SpannableStringBuilder)Html.fromHtml((String)charsequence);
        charsequence.setSpan(textappearancespan, 0, charsequence.length(), 0);
        return new DynamicLayout(charsequence, textpaint, i, alignment, 1.0F, 1.0F, true);
    }

    private DynamicLayout createTextLayout(CharSequence charsequence, int i, android.text.Layout.Alignment alignment, int j)
    {
        TextPaint textpaint = new TextPaint();
        textpaint.setAntiAlias(true);
        textpaint.setLinearText(true);
        textpaint.setFilterBitmap(true);
        TextAppearanceSpan textappearancespan = new TextAppearanceSpan(getContext(), j);
        charsequence = new SpannableString(charsequence);
        charsequence.setSpan(textappearancespan, 0, charsequence.length(), 0);
        return new DynamicLayout(charsequence, textpaint, i, alignment, 1.0F, 1.0F, true);
    }

    public static transient AviaryOverlay findOverlay(Context context, Class aclass[])
    {
        context = (ViewGroup)((Activity)context).getWindow().getDecorView();
        if (context != null)
        {
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                AviaryOverlay aviaryoverlay = (AviaryOverlay)context.findViewWithTag(aclass[i].getName());
                if (aviaryoverlay != null)
                {
                    return aviaryoverlay;
                }
            }

        }
        return null;
    }

    public static Bitmap getBitmapFromView(View view)
    {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable = view.getBackground();
        if (drawable != null)
        {
            drawable.draw(canvas);
        } else
        {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return bitmap;
    }

    static SharedPreferences getSharedPreferences(Context context)
    {
        synchronized (M_LOCK)
        {
            if (mPreferences == null)
            {
                mPreferences = context.getSharedPreferences("aviary-overlays", 0);
            }
        }
        return mPreferences;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void markAsViewed(Context context, int i)
    {
        markAsViewed(getSharedPreferences(context), i);
    }

    private static void markAsViewed(SharedPreferences sharedpreferences, int i)
    {
        if (i < 0)
        {
            return;
        } else
        {
            sharedpreferences = sharedpreferences.edit();
            sharedpreferences.putInt((new StringBuilder()).append("overlay-").append(i).toString(), 1);
            sharedpreferences.apply();
            return;
        }
    }

    public static void markAsViewed(IAviaryController iaviarycontroller, int i)
    {
        if (iaviarycontroller != null && iaviarycontroller.getBaseContext() != null)
        {
            markAsViewed(iaviarycontroller.getBaseContext(), i);
        }
    }

    private void postActivate()
    {
        if (mActivationDelay > 0)
        {
            Handler handler = getHandler();
            if (handler != null)
            {
                handler.postDelayed(new Runnable() {

                    final AviaryOverlay this$0;

                    public void run()
                    {
                        onActivate();
                    }

            
            {
                this$0 = AviaryOverlay.this;
                super();
            }
                }, mActivationDelay);
            }
            return;
        } else
        {
            onActivate();
            return;
        }
    }

    private boolean shouldShow()
    {
        SharedPreferences sharedpreferences;
        if (getContext() != null)
        {
            if (shouldShow(sharedpreferences = getSharedPreferences(getContext()), overlayId))
            {
                markAsViewed(sharedpreferences, overlayId);
                return true;
            }
        }
        return false;
    }

    public static boolean shouldShow(Context context, int i)
    {
        return shouldShow(getSharedPreferences(context), i);
    }

    private static boolean shouldShow(SharedPreferences sharedpreferences, int i)
    {
        return i <= -1 || !sharedpreferences.contains((new StringBuilder()).append("overlay-").append(i).toString());
    }

    public static boolean shouldShow(IAviaryController iaviarycontroller, int i)
    {
        if (!FeatherActivity.MATURITY.isKidsFriendly() && iaviarycontroller != null && iaviarycontroller.getBaseContext() != null)
        {
            return shouldShow(iaviarycontroller.getBaseContext(), i);
        } else
        {
            return false;
        }
    }

    protected transient void addCloseButton(int ai[])
    {
        if (mCloseButton == null)
        {
            mCloseButton = (Button)LayoutInflater.from(getContext()).inflate(com.aviary.android.feather.sdk.R.layout.aviary_overlay_close_button, this, false);
            mCloseButton.setOnClickListener(this);
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)generateDefaultLayoutParams();
            int j = ai.length;
            for (int i = 0; i < j; i++)
            {
                layoutparams.addRule(ai[i]);
            }

            layoutparams.setMargins(mClosebuttonMargins, mClosebuttonMargins, mClosebuttonMargins, mClosebuttonMargins);
            mCloseButton.setLayoutParams(layoutparams);
            mCloseButton.setVisibility(8);
            addView(mCloseButton);
        }
    }

    protected abstract void calculatePositions();

    public void dismiss()
    {
        inLayout = false;
        if (getParent() == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        logger.info("dismiss");
        ((ViewGroup)getParent()).removeView(this);
        return;
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        indexoutofboundsexception.printStackTrace();
        return;
    }

    protected abstract void doShow();

    protected void fadeIn()
    {
        if (showAnimation == null)
        {
            logger.info("fadeIn");
            showAnimation = generateInAnimation();
            showAnimation.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final AviaryOverlay this$0;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    mVisible = true;
                    inAnimationCompleted();
                    postActivate();
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                    setVisibility(0);
                }

            
            {
                this$0 = AviaryOverlay.this;
                super();
            }
            });
            showAnimation.start();
        }
    }

    protected void fadeOut(final String from)
    {
        if (hideAnimation == null)
        {
            logger.info("fadeOut");
            hideAnimation = generateHideAnimation();
            hideAnimation.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

                final AviaryOverlay this$0;
                final String val$from;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    if (from != null)
                    {
                        trackTutorialClosed(from);
                    }
                    dismiss();
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = AviaryOverlay.this;
                from = s;
                super();
            }
            });
            hideAnimation.start();
        }
    }

    Drawable generateArrow()
    {
        return getContext().getResources().getDrawable(mArrow);
    }

    Bitmap generateBitmap(DynamicLayout dynamiclayout)
    {
        Bitmap bitmap = Bitmap.createBitmap(dynamiclayout.getWidth(), dynamiclayout.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(0);
        dynamiclayout.draw(new Canvas(bitmap));
        return bitmap;
    }

    Drawable generateHTMLTextDrawable(Context context, CharSequence charsequence, int i, android.text.Layout.Alignment alignment)
    {
        charsequence = generateBitmap(generateHTMLTextLayout(charsequence, i, alignment));
        return new BitmapDrawable(context.getResources(), charsequence);
    }

    DynamicLayout generateHTMLTextLayout(CharSequence charsequence, int i, android.text.Layout.Alignment alignment)
    {
        return createHTMLTextLayout(charsequence, i, alignment, getTextStyle());
    }

    protected Animator generateHideAnimation()
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "alpha", new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(getAnimationDuration());
        return objectanimator;
    }

    protected Animator generateInAnimation()
    {
        AnimatorSet animatorset = new AnimatorSet();
        ((AnimatorSet)animatorset).playTogether(new Animator[] {
            ObjectAnimator.ofFloat(this, "alpha", new float[] {
                0.0F, 1.0F
            })
        });
        animatorset.setDuration(getAnimationDuration());
        return animatorset;
    }

    Drawable generateRipple()
    {
        return getContext().getResources().getDrawable(mRipple);
    }

    Drawable generateTextDrawable(Context context, CharSequence charsequence, int i, android.text.Layout.Alignment alignment)
    {
        charsequence = generateBitmap(generateTextLayout(charsequence, i, alignment));
        return new BitmapDrawable(context.getResources(), charsequence);
    }

    DynamicLayout generateTextLayout(CharSequence charsequence, int i, android.text.Layout.Alignment alignment)
    {
        return createTextLayout(charsequence, i, alignment, getTextStyle());
    }

    Drawable generateTitleDrawable(Context context, CharSequence charsequence, int i, android.text.Layout.Alignment alignment)
    {
        charsequence = generateBitmap(generateTitleLayout(charsequence, i, alignment));
        return new BitmapDrawable(context.getResources(), charsequence);
    }

    DynamicLayout generateTitleLayout(CharSequence charsequence, int i, android.text.Layout.Alignment alignment)
    {
        return createTextLayout(charsequence, i, alignment, getTitleStyle());
    }

    public float getAlpha()
    {
        return alpha;
    }

    public int getAnimationDuration()
    {
        return mAnimationDuration;
    }

    public int getBackgroundColor()
    {
        return mBackgroundColor;
    }

    public Button getCloseButton()
    {
        return mCloseButton;
    }

    DisplayMetrics getDisplayMetrics()
    {
        return mMetrics;
    }

    protected final int getOverlayId()
    {
        return overlayId;
    }

    public int getTextMargins()
    {
        return mTextMargins;
    }

    public int getTextStyle()
    {
        return mTextStyle;
    }

    public int getTitleMargins()
    {
        return mTitleMargins;
    }

    public int getTitleStyle()
    {
        return mTitleStyle;
    }

    protected final String getToolName()
    {
        return mTagName;
    }

    int[] getViewLocation(int i)
    {
        View view = ((FrameLayout)((Activity)(Activity)getContext()).getWindow().getDecorView()).findViewById(i);
        if (view == null)
        {
            return null;
        } else
        {
            int ai[] = new int[2];
            view.getLocationInWindow(ai);
            return ai;
        }
    }

    int[] getViewLocation(View view)
    {
        int ai[] = new int[2];
        view.getLocationInWindow(ai);
        return ai;
    }

    View getViewOfInterest(int i)
    {
        return ((FrameLayout)((Activity)(Activity)getContext()).getWindow().getDecorView()).findViewById(i);
    }

    public void hide()
    {
        hide(null);
    }

    public void hide(String s)
    {
        if (!isAttachedToParent())
        {
            return;
        } else
        {
            logger.info("hide");
            fadeOut(s);
            return;
        }
    }

    protected abstract void inAnimationCompleted();

    protected boolean isActive()
    {
        return mActive;
    }

    protected boolean isAttachedToParent()
    {
        return inLayout && getParent() != null;
    }

    protected boolean isVisible()
    {
        return mVisible;
    }

    protected void onActivate()
    {
        mActive = true;
    }

    public boolean onBackPressed()
    {
        if (isAttachedToParent())
        {
            logger.info("onBackPressed");
            hide("back");
            return true;
        } else
        {
            return false;
        }
    }

    public void onClick(View view)
    {
        logger.info((new StringBuilder()).append("onClick: ").append(view).toString());
        if (view == getCloseButton())
        {
            hide("button");
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        setAlpha(1.0F);
        mOrientationChanged = true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mOrientationChanged && flag)
        {
            calculatePositions();
            invalidate();
            mOrientationChanged = false;
        }
    }

    public abstract boolean onTouchEvent(MotionEvent motionevent);

    public void setAlpha(float f)
    {
        alpha = f;
        mBackgroundColor = Color.argb((int)((float)mBackgroundAlpha * f), 0, 0, 0);
        postInvalidate();
    }

    public void setHardwareAccelerated(boolean flag)
    {
        if (flag)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                if (isHardwareAccelerated())
                {
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY));
                    setLayerType(2, paint);
                    return;
                } else
                {
                    setLayerType(1, null);
                    return;
                }
            } else
            {
                setDrawingCacheEnabled(true);
                return;
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setLayerType(1, null);
            return;
        } else
        {
            setDrawingCacheEnabled(true);
            return;
        }
    }

    public void setOnCloseListener(OnCloseListener oncloselistener)
    {
        mCloseListener = oncloselistener;
    }

    public final boolean show()
    {
        return showDelayed(100L);
    }

    public boolean showDelayed(long l)
    {
        logger.info("show");
        ViewGroup viewgroup = (ViewGroup)((Activity)getContext()).getWindow().getDecorView();
        if (viewgroup != null && viewgroup.getHandler() != null)
        {
            if (shouldShow())
            {
                inLayout = true;
                viewgroup.addView(this, new android.view.ViewGroup.LayoutParams(-1, -1));
                viewgroup.getHandler().postDelayed(new Runnable() {

                    final AviaryOverlay this$0;

                    public void run()
                    {
                        calculatePositions();
                        trackTutorialOpened();
                        doShow();
                    }

            
            {
                this$0 = AviaryOverlay.this;
                super();
            }
                }, l);
                return true;
            }
            logger.log("don't show");
        } else
        {
            logger.warn("handler is null");
        }
        return false;
    }

    protected void trackTutorialClosed(String s)
    {
        if (getContext() != null && s != null)
        {
            AviaryTracker.getInstance(getContext()).tagEvent((new StringBuilder()).append(mTagName).append(": tutorial_closed").toString(), new String[] {
                "from", s
            });
        }
    }

    protected void trackTutorialOpened()
    {
        if (getContext() != null)
        {
            AviaryTracker.getInstance(getContext()).tagEvent((new StringBuilder()).append(mTagName).append(": tutorial_presented").toString());
        }
    }



/*
    static boolean access$002(AviaryOverlay aviaryoverlay, boolean flag)
    {
        aviaryoverlay.mVisible = flag;
        return flag;
    }

*/

}
