// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.view.ActionBarClearableEditText;
import roboguice.util.Strings;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

// Referenced classes of package com.groupon.activity:
//            Cities

private class <init>
    implements android.view.istener
{

    final Cities this$0;

    public void onFocusChange(View view, boolean flag)
    {
        int i = 0;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        if (!flag)
        {
            i = 8;
        }
        listView.setVisibility(byte0);
        autocompleteContainer.setVisibility(i);
        if (flag)
        {
            Cities.access$1400(Cities.this).searchLocation(Strings.toString(Cities.access$1300(Cities.this).getText()));
        }
    }

    private ()
    {
        this$0 = Cities.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
