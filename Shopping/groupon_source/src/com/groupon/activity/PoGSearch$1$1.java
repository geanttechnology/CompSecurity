// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.groupon.models.Place;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.ViewUtils;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            PoGSearch

class val.hasFocus
    implements Runnable
{

    final is._cls0 this$1;
    final boolean val$hasFocus;

    public void run()
    {
        PoGSearch pogsearch = _fld0;
        boolean flag;
        if (!val$hasFocus)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ViewUtils.setSoftKeyboardState(pogsearch, flag, PoGSearch.access$000(_fld0));
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$hasFocus = Z.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/PoGSearch$1

/* anonymous class */
    class PoGSearch._cls1
        implements android.view.View.OnFocusChangeListener
    {

        final PoGSearch this$0;

        public void onFocusChange(View view, boolean flag)
        {
            int i;
            if (flag)
            {
                toggleFragment(PoGSearch.ViewState.LOCATION_AUTOCOMPLETE);
                if (Strings.equalsIgnoreCase(Strings.toString(PoGSearch.access$000(PoGSearch.this).getText()), locationsAutocompleteServiceWrapper.CURRENT_LOCATION))
                {
                    PoGSearch.access$000(PoGSearch.this).setText("");
                }
                locationsAutocompleteServiceWrapper.searchLocation(Strings.toString(PoGSearch.access$000(PoGSearch.this).getText()));
            } else
            if (locationContainer.getVisibility() == 0)
            {
                PoGSearch.access$000(PoGSearch.this).setText(locationsAutocompleteServiceWrapper.getTopListSearchLocation().value);
            }
            PoGSearch.access$000(PoGSearch.this).postDelayed(flag. new PoGSearch._cls1._cls1(), 500L);
            view = PoGSearch.access$100(PoGSearch.this);
            if (flag)
            {
                i = 0x7f020260;
            } else
            {
                i = 0x7f020262;
            }
            view.setImageResource(i);
        }

            
            {
                this$0 = PoGSearch.this;
                super();
            }
    }

}
