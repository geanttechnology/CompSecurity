// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;
import com.comcast.cim.cmasl.utils.i18n.Iso629Util;

// Referenced classes of package com.comcast.cim.android.view.common:
//            SelectionListDialogFragment

public class SAPSelectionListDialogFragment extends SelectionListDialogFragment
{

    public SAPSelectionListDialogFragment(int i, View view, SelectionListDialogFragment.OnSelectionChangedListener onselectionchangedlistener, android.content.DialogInterface.OnCancelListener oncancellistener, android.content.DialogInterface.OnKeyListener onkeylistener, int j)
    {
        super(i, view, onselectionchangedlistener, oncancellistener, onkeylistener, j);
        isToggleable = false;
        cancelOnSelectionChanged = true;
    }

    protected String getDisplayText(String s)
    {
        String s1 = Iso629Util.getDisplayNameForLanguageCode(s);
        if (s1 != null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    protected int getHeaderSummaryTextId()
    {
        return com.comcast.cim.android.R.string.sap_dialog_summary;
    }

    protected int getHeaderTitleTextId()
    {
        return com.comcast.cim.android.R.string.sap_dialog_title;
    }
}
