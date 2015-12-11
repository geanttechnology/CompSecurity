// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.EditText;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.gment._cls7
{

    final GlobalSearchFragment this$0;

    public void onClick(View view)
    {
        GlobalSearchFragment.access$600(GlobalSearchFragment.this).searchLocation(Strings.toString(GlobalSearchFragment.access$500(GlobalSearchFragment.this).getText()));
    }

    eWrapper()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
