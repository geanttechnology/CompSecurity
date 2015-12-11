// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.text.Editable;
import android.text.TextWatcher;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            LocationsAutocompleteServiceWrapper, LocationAutocompleteClient

class this._cls0
    implements TextWatcher
{

    final LocationsAutocompleteServiceWrapper this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        i = 1;
        if (!Strings.notEmpty(charsequence) || charsequence.length() < 1)
        {
            i = 0;
        }
        if (i != 0)
        {
            if (LocationsAutocompleteServiceWrapper.access$100(LocationsAutocompleteServiceWrapper.this).isAutocomplete())
            {
                createLocationsWithAutocomplete(Strings.toString(charsequence));
            }
            return;
        } else
        {
            reloadAndShowDefaultList();
            return;
        }
    }

    ()
    {
        this$0 = LocationsAutocompleteServiceWrapper.this;
        super();
    }
}
