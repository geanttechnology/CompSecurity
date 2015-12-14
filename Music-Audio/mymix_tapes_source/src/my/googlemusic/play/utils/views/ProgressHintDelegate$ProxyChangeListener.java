// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.widget.SeekBar;

// Referenced classes of package my.googlemusic.play.utils.views:
//            ProgressHintDelegate

private static class <init>
    implements android.widget.xyChangeListener
{

    private android.widget.xyChangeListener.mInternalListener mExternalListener;
    private android.widget.xyChangeListener.mInternalListener mInternalListener;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (mInternalListener != null)
        {
            mInternalListener.sChanged(seekbar, i, flag);
        }
        if (mExternalListener != null)
        {
            mExternalListener.sChanged(seekbar, i, flag);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
        if (mInternalListener != null)
        {
            mInternalListener.ackingTouch(seekbar);
        }
        if (mExternalListener != null)
        {
            mExternalListener.ackingTouch(seekbar);
        }
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (mInternalListener != null)
        {
            mInternalListener.ckingTouch(seekbar);
        }
        if (mExternalListener != null)
        {
            mExternalListener.ckingTouch(seekbar);
        }
    }

    public void setExternalListener(android.widget.xyChangeListener xychangelistener)
    {
        mExternalListener = xychangelistener;
    }

    public void setInternalListener(android.widget.xyChangeListener xychangelistener)
    {
        mInternalListener = xychangelistener;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
