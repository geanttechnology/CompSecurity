// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.view.View;
import com.groupon.v3.view.param.DealCardClickInfo;

public interface DealCallbacks
{

    public abstract void onDealBound(DealCardClickInfo dealcardclickinfo);

    public abstract void onDealClick(View view, DealCardClickInfo dealcardclickinfo);
}
