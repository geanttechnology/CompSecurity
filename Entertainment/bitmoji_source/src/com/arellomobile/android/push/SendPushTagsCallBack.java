// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import com.arellomobile.android.push.exception.PushWooshException;
import java.util.Map;

public interface SendPushTagsCallBack
{

    public abstract void onSentTagsError(PushWooshException pushwooshexception);

    public abstract void onSentTagsSuccess(Map map);

    public abstract void taskStarted();
}
