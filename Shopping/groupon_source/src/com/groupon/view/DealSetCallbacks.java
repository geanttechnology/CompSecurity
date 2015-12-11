// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;

public interface DealSetCallbacks
{

    public abstract void onMemberClick(View view, DealSummary dealsummary);

    public abstract void onSubsetClick(WidgetSummary widgetsummary);
}
