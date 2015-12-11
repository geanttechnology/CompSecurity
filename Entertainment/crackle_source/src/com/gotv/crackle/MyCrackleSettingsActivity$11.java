// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.gotv.crackle:
//            MyCrackleSettingsActivity

class val.alertNewMoviesAndShows
    implements android.view.._cls11
{

    final MyCrackleSettingsActivity this$0;
    final CheckBox val$alertNewMoviesAndShows;

    public void onClick(View view)
    {
        view = val$alertNewMoviesAndShows;
        boolean flag;
        if (!val$alertNewMoviesAndShows.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
    }

    ()
    {
        this$0 = final_mycracklesettingsactivity;
        val$alertNewMoviesAndShows = CheckBox.this;
        super();
    }
}
