// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.externalwidgets;

import android.view.ViewGroup;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidget;

public interface ExternalWidgetSlotController
{

    public abstract void addCandidateWidget(ExternalSearchWidget externalsearchwidget);

    public abstract void hide();

    public abstract void setWidgetContainer(ViewGroup viewgroup);

    public abstract void show();
}
