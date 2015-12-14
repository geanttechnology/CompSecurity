// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;


public class SimpleStatusMachine
{
    public static interface OnStatusChangeListener
    {

        public abstract void onStatusChanged(int i, int j);

        public abstract void onStatusUpdated(int i);
    }


    public static final int INVALID_STATUS = -1;
    private int currentStatus;
    private OnStatusChangeListener mStatusListener;
    private int previousStatus;

    public SimpleStatusMachine()
    {
        currentStatus = -1;
        previousStatus = -1;
    }

    public int getCurrentStatus()
    {
        return currentStatus;
    }

    public int getPreviousStatus()
    {
        return previousStatus;
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onstatuschangelistener)
    {
        mStatusListener = onstatuschangelistener;
    }

    public void setStatus(int i)
    {
        if (i != currentStatus)
        {
            previousStatus = currentStatus;
            currentStatus = i;
            if (mStatusListener != null)
            {
                mStatusListener.onStatusChanged(previousStatus, currentStatus);
            }
        } else
        if (mStatusListener != null)
        {
            mStatusListener.onStatusUpdated(i);
            return;
        }
    }
}
