// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.error;


public class AmazonErrorInfo
{

    private AmazonErrorBox.AmazonErrorBoxActionListener mActionListener;
    private String mButtonText;
    private int mErrorId;
    private String mErrorMessage;

    public AmazonErrorInfo()
    {
        mErrorId = 0;
        mActionListener = null;
        mErrorMessage = null;
        mButtonText = null;
    }

    public AmazonErrorInfo(int i, AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener, String s, String s1)
    {
        mErrorId = 0;
        mActionListener = null;
        mErrorMessage = null;
        mButtonText = null;
        mErrorId = i;
        mActionListener = amazonerrorboxactionlistener;
        mErrorMessage = s;
        mButtonText = s1;
    }

    public String getActionButtonText()
    {
        return mButtonText;
    }

    public AmazonErrorBox.AmazonErrorBoxActionListener getActionListener()
    {
        return mActionListener;
    }

    public int getErrorId()
    {
        return mErrorId;
    }

    public String getMessage()
    {
        return mErrorMessage;
    }

    public void setActionButtonText(String s)
    {
        mButtonText = s;
    }

    public void setActionListener(AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener)
    {
        mActionListener = amazonerrorboxactionlistener;
    }

    public void setErrorId(int i)
    {
        mErrorId = i;
    }

    public void setMessage(String s)
    {
        mErrorMessage = s;
    }
}
