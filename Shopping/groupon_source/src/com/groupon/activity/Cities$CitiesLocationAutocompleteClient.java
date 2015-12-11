// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.location.Location;
import android.text.Editable;
import android.widget.ListView;
import com.groupon.util.LocationAutocompleteClient;
import com.groupon.view.ActionBarClearableEditText;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            Cities

private class <init>
    implements LocationAutocompleteClient
{

    final Cities this$0;

    public boolean isAutocomplete()
    {
        return Cities.access$1300(Cities.this).hasFocus();
    }

    public boolean isTextEmpty()
    {
        return Cities.access$1300(Cities.this).getText().length() == 0;
    }

    public void locationReadyCallback(Location location)
    {
    }

    public void locationSearchReady(List list)
    {
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        autocompleteListView.setAdapter(new <init>(Cities.this, ((List) (obj))));
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
