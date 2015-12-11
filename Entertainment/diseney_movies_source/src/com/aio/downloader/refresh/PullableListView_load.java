// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.refresh:
//            Pullable

public class PullableListView_load extends ListView
    implements Pullable
{
    public static interface OnLoadListener
    {

        public abstract void onLoad(PullableListView_load pullablelistview_load);
    }


    public static final int INIT = 0;
    public static final int LOADING = 1;
    public static final int NO_MORE_DATA = 2;
    private boolean autoLoad;
    private boolean canLoad;
    private boolean hasMoreData;
    private AnimationDrawable mLoadAnim;
    private ImageView mLoadingView;
    private View mLoadmoreView;
    private OnLoadListener mOnLoadListener;
    private TextView mStateTextView;
    private Context mcContext;
    private int state;
    private TextView tv_load_more;

    public PullableListView_load(Context context)
    {
        super(context);
        state = 0;
        canLoad = true;
        autoLoad = true;
        hasMoreData = true;
        init(context);
    }

    public PullableListView_load(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        state = 0;
        canLoad = true;
        autoLoad = true;
        hasMoreData = true;
        init(context);
    }

    public PullableListView_load(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        state = 0;
        canLoad = true;
        autoLoad = true;
        hasMoreData = true;
        init(context);
    }

    private void changeState(int i)
    {
        state = i;
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            mLoadAnim.stop();
            mLoadingView.setVisibility(4);
            tv_load_more.setText(0x7f0b0060);
            tv_load_more.setVisibility(0);
            mStateTextView.setVisibility(8);
            return;

        case 1: // '\001'
            mLoadingView.setVisibility(0);
            mLoadAnim.start();
            tv_load_more.setVisibility(8);
            mStateTextView.setVisibility(0);
            mStateTextView.setText(0x7f0b0061);
            return;

        case 2: // '\002'
            mLoadAnim.stop();
            break;
        }
        mLoadingView.setVisibility(4);
        mStateTextView.setText("No More Data");
    }

    private void checkLoad()
    {
        if (reachBottom() && mOnLoadListener != null && state != 1 && canLoad && autoLoad && hasMoreData)
        {
            load();
        }
    }

    private void init(Context context)
    {
        mLoadmoreView = LayoutInflater.from(context).inflate(0x7f03006c, null);
        mLoadingView = (ImageView)mLoadmoreView.findViewById(0x7f07028e);
        mLoadingView.setBackgroundResource(0x7f040015);
        mLoadAnim = (AnimationDrawable)mLoadingView.getBackground();
        mStateTextView = (TextView)mLoadmoreView.findViewById(0x7f070290);
        tv_load_more = (TextView)mLoadmoreView.findViewById(0x7f070291);
        tv_load_more.setOnClickListener(new android.view.View.OnClickListener() {

            final PullableListView_load this$0;

            public void onClick(View view)
            {
                if (state != 1 && hasMoreData)
                {
                    load();
                }
            }

            
            {
                this$0 = PullableListView_load.this;
                super();
            }
        });
        addFooterView(mLoadmoreView, null, false);
    }

    private void load()
    {
        changeState(1);
        mOnLoadListener.onLoad(this);
    }

    private boolean reachBottom()
    {
        while (getCount() == 0 || getLastVisiblePosition() == getCount() - 1 && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getTop() < getMeasuredHeight() && !canPullDown()) 
        {
            return true;
        }
        return false;
    }

    public boolean canPullDown()
    {
        if (getCount() != 0)
        {
            if (getFirstVisiblePosition() == 0)
            {
                int i;
                try
                {
                    i = getChildAt(0).getTop();
                }
                catch (Exception exception)
                {
                    return false;
                }
                if (i < 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public boolean canPullUp()
    {
        return false;
    }

    public void enableAutoLoad(boolean flag)
    {
        autoLoad = flag;
    }

    public void finishLoading()
    {
        changeState(0);
    }

    public boolean isHasMoreData()
    {
        return hasMoreData;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        checkLoad();
    }

    public void setHasMoreData(boolean flag)
    {
        hasMoreData = flag;
        if (!flag)
        {
            changeState(2);
            return;
        } else
        {
            changeState(0);
            return;
        }
    }

    public void setLoadmoreVisible(boolean flag)
    {
        if (flag)
        {
            if (getFooterViewsCount() == 0)
            {
                addFooterView(mLoadmoreView, null, false);
            }
            return;
        } else
        {
            removeFooterView(mLoadmoreView);
            return;
        }
    }

    public void setOnLoadListener(OnLoadListener onloadlistener)
    {
        mOnLoadListener = onloadlistener;
    }



}
