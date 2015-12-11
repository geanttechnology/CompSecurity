// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.groupon.models.Place;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.LoggingUtils;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.ner
{

    final GlobalSearchFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        int i;
        if (flag)
        {
            GlobalSearchFragment.access$400(GlobalSearchFragment.this).switchToSearchModeLocationSearch();
            GlobalSearchFragment.access$000(GlobalSearchFragment.this).logClick("", "location_box_click", "global_search", "");
            if (Strings.equalsIgnoreCase(Strings.toString(GlobalSearchFragment.access$500(GlobalSearchFragment.this).getText()), CURRENT_LOCATION))
            {
                GlobalSearchFragment.access$500(GlobalSearchFragment.this).setText("");
            }
            GlobalSearchFragment.access$600(GlobalSearchFragment.this).searchLocation(Strings.toString(GlobalSearchFragment.access$500(GlobalSearchFragment.this).getText()));
        } else
        {
            GlobalSearchFragment.access$500(GlobalSearchFragment.this).setText(GlobalSearchFragment.access$600(GlobalSearchFragment.this).getTopListSearchLocation().value);
        }
        view = GlobalSearchFragment.access$700(GlobalSearchFragment.this);
        if (flag)
        {
            i = 0x7f020260;
        } else
        {
            i = 0x7f020262;
        }
        view.setImageResource(i);
    }

    eWrapper()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
