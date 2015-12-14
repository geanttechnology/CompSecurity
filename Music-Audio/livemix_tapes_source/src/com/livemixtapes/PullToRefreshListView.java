// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PullToRefreshListView extends ListView
    implements android.widget.AbsListView.OnScrollListener
{
    private class HeaderAnimationListener
        implements android.view.animation.Animation.AnimationListener
    {

        private int height;
        private State stateAtAnimationStart;
        final PullToRefreshListView this$0;
        private int translation;

        public void onAnimationEnd(Animation animation)
        {
            animation = PullToRefreshListView.this;
            int i;
            if (stateAtAnimationStart == State.REFRESHING)
            {
                i = 0;
            } else
            {
                i = -PullToRefreshListView.measuredHeaderHeight - headerContainer.getTop();
            }
            animation.setHeaderPadding(i);
            setSelection(0);
            animation = getLayoutParams();
            animation.height = height;
            setLayoutParams(animation);
            if (scrollbarEnabled)
            {
                setVerticalScrollBarEnabled(true);
            }
            if (bounceBackHeader)
            {
                bounceBackHeader = false;
                postDelayed(new Runnable() {

                    final HeaderAnimationListener this$1;

                    public void run()
                    {
                        resetHeader();
                    }

            
            {
                this$1 = HeaderAnimationListener.this;
                super();
            }
                }, 100L);
            } else
            if (stateAtAnimationStart != State.REFRESHING)
            {
                setState(State.PULL_TO_REFRESH);
                return;
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            stateAtAnimationStart = state;
            animation = getLayoutParams();
            height = ((android.view.ViewGroup.LayoutParams) (animation)).height;
            animation.height = getHeight() - translation;
            setLayoutParams(animation);
            if (scrollbarEnabled)
            {
                setVerticalScrollBarEnabled(false);
            }
        }


        public HeaderAnimationListener(int i)
        {
            this$0 = PullToRefreshListView.this;
            super();
            translation = i;
        }
    }

    public static interface OnBottomReachedListener
    {

        public abstract void onBottomReached();
    }

    public static interface OnRefreshListener
    {

        public abstract void onRefresh();
    }

    private class PTROnGlobalLayoutListener
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final PullToRefreshListView this$0;

        public void onGlobalLayout()
        {
            int i = header.getHeight();
            if (i > 0)
            {
                PullToRefreshListView.measuredHeaderHeight = i;
                if (PullToRefreshListView.measuredHeaderHeight > 0 && state != State.REFRESHING)
                {
                    setHeaderPadding(-PullToRefreshListView.measuredHeaderHeight);
                    requestLayout();
                }
            }
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

        private PTROnGlobalLayoutListener()
        {
            this$0 = PullToRefreshListView.this;
            super();
        }

        PTROnGlobalLayoutListener(PTROnGlobalLayoutListener ptrongloballayoutlistener)
        {
            this();
        }
    }

    private class PTROnItemClickListener
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PullToRefreshListView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            hasResetHeader = false;
            if (onItemClickListener != null && state == State.PULL_TO_REFRESH)
            {
                onItemClickListener.onItemClick(adapterview, view, i - getHeaderViewsCount(), l);
            }
        }

        private PTROnItemClickListener()
        {
            this$0 = PullToRefreshListView.this;
            super();
        }

        PTROnItemClickListener(PTROnItemClickListener ptronitemclicklistener)
        {
            this();
        }
    }

    private class PTROnItemLongClickListener
        implements android.widget.AdapterView.OnItemLongClickListener
    {

        final PullToRefreshListView this$0;

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
        {
            boolean flag1 = false;
            hasResetHeader = false;
            boolean flag = flag1;
            if (onItemLongClickListener != null)
            {
                flag = flag1;
                if (state == State.PULL_TO_REFRESH)
                {
                    flag = onItemLongClickListener.onItemLongClick(adapterview, view, i - getHeaderViewsCount(), l);
                }
            }
            return flag;
        }

        private PTROnItemLongClickListener()
        {
            this$0 = PullToRefreshListView.this;
            super();
        }

        PTROnItemLongClickListener(PTROnItemLongClickListener ptronitemlongclicklistener)
        {
            this();
        }
    }

    private static final class State extends Enum
    {

        private static final State ENUM$VALUES[];
        public static final State PULL_TO_REFRESH;
        public static final State REFRESHING;
        public static final State RELEASE_TO_REFRESH;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/livemixtapes/PullToRefreshListView$State, s);
        }

        public static State[] values()
        {
            State astate[] = ENUM$VALUES;
            int i = astate.length;
            State astate1[] = new State[i];
            System.arraycopy(astate, 0, astate1, 0, i);
            return astate1;
        }

        static 
        {
            PULL_TO_REFRESH = new State("PULL_TO_REFRESH", 0);
            RELEASE_TO_REFRESH = new State("RELEASE_TO_REFRESH", 1);
            REFRESHING = new State("REFRESHING", 2);
            ENUM$VALUES = (new State[] {
                PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static int $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State[];
    private static final int BOUNCE_ANIMATION_DELAY = 100;
    private static final int BOUNCE_ANIMATION_DURATION = 700;
    private static final float BOUNCE_OVERSHOOT_TENSION = 1.4F;
    private static final float PULL_RESISTANCE = 1.7F;
    private static final int ROTATE_ARROW_ANIMATION_DURATION = 250;
    private static int measuredHeaderHeight;
    private final int IDLE_DISTANCE;
    private boolean bounceBackHeader;
    private RotateAnimation flipAnimation;
    private boolean hasResetHeader;
    private RelativeLayout header;
    private LinearLayout headerContainer;
    private int headerPadding;
    private ImageView image;
    private long lastUpdated;
    private SimpleDateFormat lastUpdatedDateFormat;
    private String lastUpdatedText;
    private TextView lastUpdatedTextView;
    private boolean lockScrollWhileRefreshing;
    private float mScrollStartY;
    OnBottomReachedListener onBottomReachedListener;
    private android.widget.AdapterView.OnItemClickListener onItemClickListener;
    private android.widget.AdapterView.OnItemLongClickListener onItemLongClickListener;
    private OnRefreshListener onRefreshListener;
    private float previousY;
    private String pullToRefreshText;
    private String refreshingText;
    private String releaseToRefreshText;
    private RotateAnimation reverseFlipAnimation;
    private boolean scrollbarEnabled;
    private boolean showLastUpdatedText;
    private ProgressBar spinner;
    private State state;
    private TextView text;

    static int[] $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State()
    {
        int ai[] = $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[State.values().length];
        try
        {
            ai[State.PULL_TO_REFRESH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[State.REFRESHING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[State.RELEASE_TO_REFRESH.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State = ai;
        return ai;
    }

    public PullToRefreshListView(Context context)
    {
        super(context);
        lastUpdatedDateFormat = new SimpleDateFormat("dd/MM HH:mm");
        lastUpdated = -1L;
        IDLE_DISTANCE = 5;
        init();
    }

    public PullToRefreshListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        lastUpdatedDateFormat = new SimpleDateFormat("dd/MM HH:mm");
        lastUpdated = -1L;
        IDLE_DISTANCE = 5;
        init();
    }

    public PullToRefreshListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        lastUpdatedDateFormat = new SimpleDateFormat("dd/MM HH:mm");
        lastUpdated = -1L;
        IDLE_DISTANCE = 5;
        init();
    }

    private void bounceBackHeader()
    {
        TranslateAnimation translateanimation;
        int i;
        if (state == State.REFRESHING)
        {
            i = header.getHeight() - headerContainer.getHeight();
        } else
        {
            i = (-headerContainer.getHeight() - headerContainer.getTop()) + getPaddingTop();
        }
        translateanimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, 0.0F, 0, i);
        translateanimation.setDuration(700L);
        translateanimation.setFillEnabled(true);
        translateanimation.setFillAfter(false);
        translateanimation.setFillBefore(true);
        translateanimation.setInterpolator(new OvershootInterpolator(1.4F));
        translateanimation.setAnimationListener(new HeaderAnimationListener(i));
        startAnimation(translateanimation);
    }

    private void init()
    {
        setVerticalFadingEdgeEnabled(false);
        headerContainer = (LinearLayout)LayoutInflater.from(getContext()).inflate(0x7f030035, null);
        header = (RelativeLayout)headerContainer.findViewById(0x7f0800f7);
        text = (TextView)header.findViewById(0x7f0800fb);
        lastUpdatedTextView = (TextView)header.findViewById(0x7f0800fc);
        image = (ImageView)header.findViewById(0x7f0800f8);
        spinner = (ProgressBar)header.findViewById(0x7f0800f9);
        pullToRefreshText = getContext().getString(0x7f0a003d);
        releaseToRefreshText = getContext().getString(0x7f0a003e);
        refreshingText = getContext().getString(0x7f0a003f);
        lastUpdatedText = getContext().getString(0x7f0a0040);
        flipAnimation = new RotateAnimation(0.0F, -180F, 1, 0.5F, 1, 0.5F);
        flipAnimation.setInterpolator(new LinearInterpolator());
        flipAnimation.setDuration(250L);
        flipAnimation.setFillAfter(true);
        reverseFlipAnimation = new RotateAnimation(-180F, 0.0F, 1, 0.5F, 1, 0.5F);
        reverseFlipAnimation.setInterpolator(new LinearInterpolator());
        reverseFlipAnimation.setDuration(250L);
        reverseFlipAnimation.setFillAfter(true);
        addHeaderView(headerContainer);
        setState(State.PULL_TO_REFRESH);
        scrollbarEnabled = isVerticalScrollBarEnabled();
        header.getViewTreeObserver().addOnGlobalLayoutListener(new PTROnGlobalLayoutListener(null));
        super.setOnItemClickListener(new PTROnItemClickListener(null));
        super.setOnItemLongClickListener(new PTROnItemLongClickListener(null));
        setOnScrollListener(this);
    }

    private void resetHeader()
    {
        if (getFirstVisiblePosition() > 0)
        {
            setHeaderPadding(-header.getHeight());
            setState(State.PULL_TO_REFRESH);
            return;
        }
        if (getAnimation() != null && !getAnimation().hasEnded())
        {
            bounceBackHeader = true;
            return;
        } else
        {
            bounceBackHeader();
            return;
        }
    }

    private void setHeaderPadding(int i)
    {
        headerPadding = i;
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)header.getLayoutParams();
        marginlayoutparams.setMargins(0, Math.round(i), 0, 0);
        header.setLayoutParams(marginlayoutparams);
    }

    private void setState(State state1)
    {
        state = state1;
        $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State()[state1.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 41
    //                   2 134
    //                   3 162;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        spinner.setVisibility(4);
        image.setVisibility(0);
        text.setText(pullToRefreshText);
        if (showLastUpdatedText && lastUpdated != -1L)
        {
            lastUpdatedTextView.setVisibility(0);
            lastUpdatedTextView.setText(String.format(lastUpdatedText, new Object[] {
                lastUpdatedDateFormat.format(new Date(lastUpdated))
            }));
            return;
        }
          goto _L1
_L3:
        spinner.setVisibility(4);
        image.setVisibility(0);
        text.setText(releaseToRefreshText);
        return;
_L4:
        setUiRefreshing();
        lastUpdated = System.currentTimeMillis();
        if (onRefreshListener == null)
        {
            setState(State.PULL_TO_REFRESH);
            return;
        } else
        {
            onRefreshListener.onRefresh();
            return;
        }
    }

    private void setUiRefreshing()
    {
        spinner.setVisibility(0);
        image.clearAnimation();
        image.setVisibility(4);
        text.setText(refreshingText);
    }

    public OnBottomReachedListener getOnBottomReachedListener()
    {
        return onBottomReachedListener;
    }

    public boolean isRefreshing()
    {
        return state == State.REFRESHING;
    }

    public void onRefreshComplete()
    {
        state = State.PULL_TO_REFRESH;
        resetHeader();
        lastUpdated = System.currentTimeMillis();
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        abslistview = (PullToRefreshListView)abslistview;
        if (i + j == k && k > 0 && ((PullToRefreshListView) (abslistview)).onBottomReachedListener != null && (state != State.REFRESHING || getAnimation() == null || getAnimation().hasEnded()))
        {
            ((PullToRefreshListView) (abslistview)).onBottomReachedListener.onBottomReached();
        }
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (!hasResetHeader)
        {
            if (measuredHeaderHeight > 0 && state != State.REFRESHING)
            {
                setHeaderPadding(-measuredHeaderHeight);
            }
            hasResetHeader = true;
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (lockScrollWhileRefreshing && (state == State.REFRESHING || getAnimation() != null && !getAnimation().hasEnded()))
        {
            return true;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 68
    //                   0 74
    //                   1 110
    //                   2 196;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        return super.onTouchEvent(motionevent);
_L2:
        if (getFirstVisiblePosition() == 0)
        {
            previousY = motionevent.getY();
        } else
        {
            previousY = -1F;
        }
        mScrollStartY = motionevent.getY();
        break; /* Loop/switch isn't completed */
_L3:
        if (previousY != -1F && (state == State.RELEASE_TO_REFRESH || getFirstVisiblePosition() == 0))
        {
            switch ($SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State()[state.ordinal()])
            {
            case 1: // '\001'
                resetHeader();
                break;

            case 2: // '\002'
                setState(State.REFRESHING);
                bounceBackHeader();
                break;
            }
        }
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (previousY != -1F && getFirstVisiblePosition() == 0 && Math.abs(mScrollStartY - motionevent.getY()) > 5F)
        {
            float f2 = motionevent.getY();
            float f1 = f2 - previousY;
            float f = f1;
            if (f1 > 0.0F)
            {
                f = f1 / 1.7F;
            }
            previousY = f2;
            int i = Math.max(Math.round((float)headerPadding + f), -header.getHeight());
            if (i != headerPadding && state != State.REFRESHING)
            {
                setHeaderPadding(i);
                if (state == State.PULL_TO_REFRESH && headerPadding > 0)
                {
                    setState(State.RELEASE_TO_REFRESH);
                    image.clearAnimation();
                    image.startAnimation(flipAnimation);
                } else
                if (state == State.RELEASE_TO_REFRESH && headerPadding < 0)
                {
                    setState(State.PULL_TO_REFRESH);
                    image.clearAnimation();
                    image.startAnimation(reverseFlipAnimation);
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setLastUpdatedDateFormat(SimpleDateFormat simpledateformat)
    {
        lastUpdatedDateFormat = simpledateformat;
    }

    public void setLockScrollWhileRefreshing(boolean flag)
    {
        lockScrollWhileRefreshing = flag;
    }

    public void setOnBottomReachedListener(OnBottomReachedListener onbottomreachedlistener)
    {
        onBottomReachedListener = onbottomreachedlistener;
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        onItemClickListener = onitemclicklistener;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        onItemLongClickListener = onitemlongclicklistener;
    }

    public void setOnRefreshListener(OnRefreshListener onrefreshlistener)
    {
        onRefreshListener = onrefreshlistener;
    }

    public void setRefreshing()
    {
        state = State.REFRESHING;
        scrollTo(0, 0);
        setUiRefreshing();
        setHeaderPadding(0);
    }

    public void setShowLastUpdatedText(boolean flag)
    {
        showLastUpdatedText = flag;
        if (!flag)
        {
            lastUpdatedTextView.setVisibility(8);
        }
    }

    public void setTextPullToRefresh(String s)
    {
        pullToRefreshText = s;
        if (state == State.PULL_TO_REFRESH)
        {
            text.setText(s);
        }
    }

    public void setTextRefreshing(String s)
    {
        refreshingText = s;
        if (state == State.REFRESHING)
        {
            text.setText(s);
        }
    }

    public void setTextReleaseToRefresh(String s)
    {
        releaseToRefreshText = s;
        if (state == State.RELEASE_TO_REFRESH)
        {
            text.setText(s);
        }
    }














}
