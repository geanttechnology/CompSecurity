// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.externalwidgets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.api.display.externalwidgets:
//            ExternalSearchWidgetName

public final class ExternalSearchWidgetSlot extends Enum
{

    private static final ExternalSearchWidgetSlot $VALUES[];
    public static final ExternalSearchWidgetSlot NAV_BAR_ABOVE_RIB;
    private final List widgetWhitelist;

    private ExternalSearchWidgetSlot(String s, int i, ExternalSearchWidgetName aexternalsearchwidgetname[])
    {
        super(s, i);
        widgetWhitelist = Collections.unmodifiableList(Arrays.asList(aexternalsearchwidgetname));
    }

    public static ExternalSearchWidgetSlot valueOf(String s)
    {
        return (ExternalSearchWidgetSlot)Enum.valueOf(com/amazon/retailsearch/android/api/display/externalwidgets/ExternalSearchWidgetSlot, s);
    }

    public static ExternalSearchWidgetSlot[] values()
    {
        return (ExternalSearchWidgetSlot[])$VALUES.clone();
    }

    public final List getWidgetWhitelist()
    {
        return widgetWhitelist;
    }

    static 
    {
        NAV_BAR_ABOVE_RIB = new ExternalSearchWidgetSlot("NAV_BAR_ABOVE_RIB", 0, new ExternalSearchWidgetName[] {
            ExternalSearchWidgetName.FRESH_NAV_BAR
        });
        $VALUES = (new ExternalSearchWidgetSlot[] {
            NAV_BAR_ABOVE_RIB
        });
    }
}
