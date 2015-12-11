// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.adapter.GrouponLocationSelectionListAdapter;
import com.groupon.http.Http;
import com.groupon.models.place.GrouponIdContainer;
import com.groupon.models.place.PlaceContainer;

// Referenced classes of package com.groupon.activity:
//            GrouponLocationSelection

protected class this._cls0 extends Http
{

    final GrouponLocationSelection this$0;

    protected void onException(Exception exception)
    {
        super.onException(exception);
    }

    protected void onFinally()
    {
        super.onFinally();
        ((GrouponLocationSelectionListAdapter)getListAdapter()).setAllItemsEnabled(true);
        GrouponLocationSelection.access$300(GrouponLocationSelection.this, false);
    }

    protected void onSuccess(PlaceContainer placecontainer)
        throws Exception
    {
        placecontainer = placecontainer.groupon.id;
        GrouponLocationSelection.access$200(GrouponLocationSelection.this, placecontainer);
        setResult(-1);
        finish();
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((PlaceContainer)obj);
    }

    public ()
    {
        this$0 = GrouponLocationSelection.this;
        super(GrouponLocationSelection.this, com/groupon/models/place/PlaceContainer, GrouponLocationSelection.access$100(GrouponLocationSelection.this));
    }
}
