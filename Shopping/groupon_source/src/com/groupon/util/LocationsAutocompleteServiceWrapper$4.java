// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.widget.Toast;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            Function1, LocationsAutocompleteServiceWrapper

class val.locationKeyword
    implements Function1
{

    final LocationsAutocompleteServiceWrapper this$0;
    final String val$locationKeyword;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (list == null)
        {
            Toast.makeText(LocationsAutocompleteServiceWrapper.access$400(LocationsAutocompleteServiceWrapper.this).getApplicationContext(), LocationsAutocompleteServiceWrapper.access$400(LocationsAutocompleteServiceWrapper.this).getString(0x7f080155), 1).show();
        }
        populateLocationSuggestionsList(list, val$locationKeyword);
    }

    ()
    {
        this$0 = final_locationsautocompleteservicewrapper;
        val$locationKeyword = String.this;
        super();
    }
}
