// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.externalwidgets;

import android.view.View;

// Referenced classes of package com.amazon.retailsearch.android.api.display.externalwidgets:
//            ExternalSearchWidgetName, ExternalSearchWidgetStateAccessor

public interface ExternalSearchWidget
{

    public abstract View getView();

    public abstract ExternalSearchWidgetName getWidgetName();

    public abstract void onAddedToSlot();

    public abstract void onRemovedFromSlot();

    public abstract boolean shouldDisplay(ExternalSearchWidgetStateAccessor externalsearchwidgetstateaccessor);
}
