// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;


public class mTutorialPhase
{

    public String mEventType;
    public String mId;
    public String mMessageId;
    public int mPitch;
    public float mTime;
    public String mTrack;
    public int mTutorialPhase;
    public int mValue;
    public int mVelocity;
    public boolean mWait;

    public String toString()
    {
        return (new StringBuilder()).append("{\"time\":").append(mTime).append(", ").append("\"eventType\":").append(mEventType).append(", ").append("\"pitch\":").append(mPitch).append(", ").append("\"velocity\":").append(mVelocity).append(", ").append("\"track\":").append(mTrack).append(", ").append("\"wait\":").append(mWait).append(", ").append("\"id\":").append(mId).append(", ").append("\"value\":").append(mValue).append(", ").append("\"messageId\":").append(mMessageId).append(", ").append("\"tutorialPhase\":").append(mTutorialPhase).append("}").toString();
    }

    public ()
    {
        mEventType = "";
        mPitch = -1;
        mVelocity = -1;
        mTrack = "";
        mWait = false;
        mId = "";
        mValue = -1;
        mMessageId = "";
        mTutorialPhase = -1;
    }
}
