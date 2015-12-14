// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.annotation.Annotation;

public abstract class ProgressHintDelegate
    implements android.widget.SeekBar.OnSeekBarChangeListener
{
    public static interface PopupStyle
        extends Annotation
    {
    }

    private static class ProxyChangeListener
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        private android.widget.SeekBar.OnSeekBarChangeListener mExternalListener;
        private android.widget.SeekBar.OnSeekBarChangeListener mInternalListener;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            if (mInternalListener != null)
            {
                mInternalListener.onProgressChanged(seekbar, i, flag);
            }
            if (mExternalListener != null)
            {
                mExternalListener.onProgressChanged(seekbar, i, flag);
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
            if (mInternalListener != null)
            {
                mInternalListener.onStartTrackingTouch(seekbar);
            }
            if (mExternalListener != null)
            {
                mExternalListener.onStartTrackingTouch(seekbar);
            }
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            if (mInternalListener != null)
            {
                mInternalListener.onStopTrackingTouch(seekbar);
            }
            if (mExternalListener != null)
            {
                mExternalListener.onStopTrackingTouch(seekbar);
            }
        }

        public void setExternalListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
        {
            mExternalListener = onseekbarchangelistener;
        }

        public void setInternalListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
        {
            mInternalListener = onseekbarchangelistener;
        }

        private ProxyChangeListener()
        {
        }

    }

    public static interface SeekBarHintAdapter
    {

        public abstract String getHint(SeekBar seekbar, int i);
    }

    public static interface SeekBarHintAttacher
    {

        public abstract void onAttached();
    }

    public static interface SeekBarHintDelegateHolder
    {

        public abstract ProgressHintDelegate getHintDelegate();
    }


    public static final SeekBarHintAdapter DEFAULT_HINT_ADAPTER = new SeekBarHintAdapter() {

        public String getHint(SeekBar seekbar, int i)
        {
            return String.valueOf(i);
        }

    };
    public static final int POPUP_FIXED = 1;
    public static final int POPUP_FOLLOW = 0;
    private Handler handler;
    private boolean isTracking;
    private ProxyChangeListener listener;
    private SeekBarHintAdapter mHintAdapter;
    private SeekBarHintAttacher mHintAttacher;
    protected PopupWindow mPopup;
    private boolean mPopupAlwaysShown;
    private int mPopupAnimStyle;
    private boolean mPopupDraggable;
    private int mPopupLayout;
    protected int mPopupOffset;
    protected int mPopupStyle;
    protected TextView mPopupTextView;
    protected View mPopupView;
    protected SeekBar mSeekBar;
    private android.view.View.OnTouchListener popupTouchProxy = new android.view.View.OnTouchListener() {

        final ProgressHintDelegate this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            view = getHintDragCoordinates(motionevent);
            view = MotionEvent.obtain(motionevent.getDownTime(), motionevent.getEventTime(), motionevent.getAction(), ((PointF) (view)).x, ((PointF) (view)).y, motionevent.getMetaState());
            return mSeekBar.dispatchTouchEvent(view);
        }

            
            {
                this$0 = ProgressHintDelegate.this;
                super();
            }
    };

    public ProgressHintDelegate(SeekBar seekbar, int i, int j, boolean flag, boolean flag1, int k, int l)
    {
        listener = new ProxyChangeListener();
        handler = new Handler();
        initDelegate(seekbar, i, j, flag, flag1, k, l, DEFAULT_HINT_ADAPTER);
    }

    public ProgressHintDelegate(SeekBar seekbar, AttributeSet attributeset, int i)
    {
        listener = new ProxyChangeListener();
        handler = new Handler();
        attributeset = seekbar.getContext().obtainStyledAttributes(attributeset, my.googlemusic.play.R.styleable.ProgressHint, i, 0x7f080137);
        i = attributeset.getResourceId(0, 0x7f030091);
        int j = (int)attributeset.getDimension(1, 0.0F);
        int k = attributeset.getInt(2, 0);
        int l = attributeset.getResourceId(3, 0x7f0800ae);
        boolean flag = attributeset.getBoolean(4, false);
        boolean flag1 = attributeset.getBoolean(5, false);
        attributeset.recycle();
        initDelegate(seekbar, i, j, flag, flag1, k, l, DEFAULT_HINT_ADAPTER);
    }

    private void attachSeekBar()
    {
        final android.view.ViewTreeObserver.OnGlobalLayoutListener layoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ProgressHintDelegate this$0;

            public void onGlobalLayout()
            {
                if (mSeekBar.getVisibility() != 0)
                {
                    hidePopup();
                    return;
                } else
                {
                    checkInitialState();
                    return;
                }
            }

            
            {
                this$0 = ProgressHintDelegate.this;
                super();
            }
        };
        mSeekBar.addOnAttachStateChangeListener(new android.view.View.OnAttachStateChangeListener() {

            final ProgressHintDelegate this$0;
            final android.view.ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

            public void onViewAttachedToWindow(View view)
            {
                mSeekBar.setOnSeekBarChangeListener(listener);
                mSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(layoutListener);
                if (mHintAttacher != null)
                {
                    mHintAttacher.onAttached();
                }
            }

            public void onViewDetachedFromWindow(View view)
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    mSeekBar.getViewTreeObserver().removeGlobalOnLayoutListener(layoutListener);
                } else
                {
                    mSeekBar.getViewTreeObserver().removeOnGlobalLayoutListener(layoutListener);
                }
                hidePopup();
            }

            
            {
                this$0 = ProgressHintDelegate.this;
                layoutListener = ongloballayoutlistener;
                super();
            }
        });
        listener.setInternalListener(this);
    }

    private void checkInitialState()
    {
        setPopupAlwaysShown(mPopupAlwaysShown);
        setPopupDraggable(mPopupDraggable);
    }

    private void initDelegate(SeekBar seekbar, int i, int j, boolean flag, boolean flag1, int k, int l, 
            SeekBarHintAdapter seekbarhintadapter)
    {
        mSeekBar = seekbar;
        mPopupLayout = i;
        mPopupOffset = j;
        mPopupAlwaysShown = flag;
        mPopupDraggable = flag1;
        mPopupStyle = k;
        mPopupAnimStyle = l;
        mHintAdapter = seekbarhintadapter;
        initHintPopup();
        attachSeekBar();
    }

    private void initHintPopup()
    {
        String s = null;
        if (mHintAdapter != null)
        {
            s = mHintAdapter.getHint(mSeekBar, mSeekBar.getProgress());
        }
        mPopupView = ((LayoutInflater)mSeekBar.getContext().getSystemService("layout_inflater")).inflate(mPopupLayout, null);
        mPopupView.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        mPopupTextView = (TextView)mPopupView.findViewById(0x1020014);
        TextView textview = mPopupTextView;
        if (s == null)
        {
            s = String.valueOf(mSeekBar.getProgress());
        }
        textview.setText(s);
        mPopup = new PopupWindow(mPopupView, -2, -2, false);
        mPopup.setAnimationStyle(mPopupAnimStyle);
    }

    private void showPopupInternally()
    {
        Point point = null;
        mPopupStyle;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 64
    //                   1 72;
           goto _L1 _L2 _L3
_L1:
        mPopup.showAtLocation(mSeekBar, 0, 0, 0);
        mPopup.update(mSeekBar, point.x, point.y, -1, -1);
        return;
_L2:
        point = getFollowHintOffset();
        continue; /* Loop/switch isn't completed */
_L3:
        point = getFixedHintOffset();
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected abstract Point getFixedHintOffset();

    protected abstract Point getFollowHintOffset();

    protected int getFollowPosition()
    {
        return getFollowPosition(mSeekBar.getProgress());
    }

    protected int getFollowPosition(int i)
    {
        return (int)((float)((mSeekBar.getWidth() - mSeekBar.getPaddingLeft() - mSeekBar.getPaddingRight()) * i) / (float)mSeekBar.getMax());
    }

    protected abstract PointF getHintDragCoordinates(MotionEvent motionevent);

    public int getPopupLayout()
    {
        return mPopupLayout;
    }

    public int getPopupStyle()
    {
        return mPopupStyle;
    }

    public View getPopupView()
    {
        return mPopupView;
    }

    public void hidePopup()
    {
        handler.removeCallbacksAndMessages(null);
        if (mPopup.isShowing())
        {
            mPopup.dismiss();
        }
    }

    public boolean isPopupAlwaysShown()
    {
        return mPopupAlwaysShown;
    }

    public boolean isPopupDraggable()
    {
        return mPopupDraggable;
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        seekbar = null;
        if (mHintAdapter != null)
        {
            seekbar = mHintAdapter.getHint(mSeekBar, i);
        }
        TextView textview = mPopupTextView;
        if (seekbar == null)
        {
            seekbar = String.valueOf(i);
        }
        textview.setText(seekbar);
        if (mPopupStyle == 0)
        {
            seekbar = getFollowHintOffset();
            mPopup.update(mSeekBar, ((Point) (seekbar)).x, ((Point) (seekbar)).y, -1, -1);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        isTracking = true;
        showPopupInternally();
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        isTracking = false;
        if (!mPopupAlwaysShown)
        {
            hidePopup();
        }
    }

    public void setHintAdapter(SeekBarHintAdapter seekbarhintadapter)
    {
        mHintAdapter = seekbarhintadapter;
        if (mPopupTextView != null)
        {
            mPopupTextView.setText(mHintAdapter.getHint(mSeekBar, mSeekBar.getProgress()));
        }
    }

    public void setHintAttacher(SeekBarHintAttacher seekbarhintattacher)
    {
        mHintAttacher = seekbarhintattacher;
    }

    public android.widget.SeekBar.OnSeekBarChangeListener setOnSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
    {
        if (onseekbarchangelistener instanceof ProxyChangeListener)
        {
            listener = (ProxyChangeListener)onseekbarchangelistener;
        } else
        {
            listener.setExternalListener(onseekbarchangelistener);
        }
        return listener;
    }

    public void setPopupAlwaysShown(boolean flag)
    {
        mPopupAlwaysShown = flag;
        if (flag)
        {
            showPopup();
        } else
        if (!isTracking)
        {
            hidePopup();
            return;
        }
    }

    public void setPopupDraggable(boolean flag)
    {
        mPopupDraggable = flag;
        if (mPopupView != null)
        {
            View view = mPopupView;
            android.view.View.OnTouchListener ontouchlistener;
            if (flag)
            {
                ontouchlistener = popupTouchProxy;
            } else
            {
                ontouchlistener = null;
            }
            view.setOnTouchListener(ontouchlistener);
        }
    }

    public void setPopupLayout(int i)
    {
        mPopupLayout = i;
        if (mPopup != null)
        {
            mPopup.dismiss();
        }
        initHintPopup();
        checkInitialState();
    }

    public void setPopupStyle(int i)
    {
        mPopupStyle = i;
        if (mPopupAlwaysShown)
        {
            showPopup();
        }
    }

    public void showPopup()
    {
        handler.post(new Runnable() {

            final ProgressHintDelegate this$0;

            public void run()
            {
                showPopupInternally();
            }

            
            {
                this$0 = ProgressHintDelegate.this;
                super();
            }
        });
    }





}
