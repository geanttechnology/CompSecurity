// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.apps.youtube.kids.ui.TimeBar;

public final class adw extends cva
{

    private aea listener;
    private final View loadingSpinner = findViewById(0x7f1000cd);
    private android.view.View.OnClickListener onPauseClick;
    private android.view.View.OnClickListener onPlayClick;
    private android.view.View.OnClickListener onReplayClick;
    private final View pauseButton = findViewById(0x7f1000d2);
    private final View playButton = findViewById(0x7f1000d1);
    private final View replayButton = findViewById(0x7f1000ce);
    private cuv state;
    private final TimeBar timeBar = (TimeBar)findViewById(0x7f1000d3);

    public adw(Context context)
    {
        super(context);
        onReplayClick = new adx(this);
        onPlayClick = new ady(this);
        onPauseClick = new adz(this);
        state = cuv.a;
        LayoutInflater.from(context).inflate(0x7f040059, this);
        playButton.setOnClickListener(onPlayClick);
        pauseButton.setOnClickListener(onPauseClick);
        replayButton.setOnClickListener(onReplayClick);
        timeBar.a = new aeb(this, null);
    }

    public final cvd generateLayoutParams()
    {
        return new cvd(-1, -1);
    }

    public final View getView()
    {
        return this;
    }

    public final void onActivityDestroy()
    {
        listener.onDestroy();
    }

    public final void resetTime()
    {
        timeBar.a();
    }

    public final void setControlsState(cuv cuv1)
    {
        boolean flag1 = true;
        if (state != cuv1)
        {
            state = cuv1;
            boolean flag;
            if (cuv1 == cuv.c || cuv1 == cuv.g)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showPausedState(flag);
            if (cuv1 == cuv.d)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            showLoadingSpinner(flag);
        }
    }

    public final void setListener(aea aea1)
    {
        listener = aea1;
    }

    public final void setTimes(int i, int j)
    {
        timeBar.a(i, j, i);
    }

    public final void showLoadingSpinner(boolean flag)
    {
        View view = loadingSpinner;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public final void showPausedState(boolean flag)
    {
        byte byte0 = 8;
        View view = playButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        view = pauseButton;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        view.setVisibility(i);
    }

    public final void showReplay(boolean flag)
    {
        View view = replayButton;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }


}
