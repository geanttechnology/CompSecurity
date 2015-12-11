// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.externalwidgets;

import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidget;
import com.amazon.retailsearch.android.api.display.externalwidgets.ExternalSearchWidgetName;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;

public class ExternalWidgetUtils
{

    private static RetailSearchLogger retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();

    public ExternalWidgetUtils()
    {
    }

    public static String getWidgetNameAsString(ExternalSearchWidget externalsearchwidget)
    {
        String s;
        s = "";
        if (externalsearchwidget == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (externalsearchwidget.getWidgetName() != null)
        {
            try
            {
                externalsearchwidget = externalsearchwidget.getWidgetName().toString();
            }
            // Misplaced declaration of an exception variable
            catch (ExternalSearchWidget externalsearchwidget)
            {
                retailSearchLogger.error("Unable to get widget name as string", externalsearchwidget);
                externalsearchwidget = s;
            }
            return externalsearchwidget;
        }
        return "";
    }

}
