// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            FavoriteDealTypeItem

private class callback
    implements Function1
{

    private final Function1 callback;
    private final execute newState;
    final FavoriteDealTypeItem this$0;

    public void execute(Boolean boolean1)
    {
        Object obj;
        if (newState != ress)
        {
            FavoriteDealTypeItem favoritedealtypeitem;
            if (newState == newState)
            {
                obj = "turn_heart_on";
            } else
            {
                obj = "turn_heart_off";
            }
            Ln.d(String.format("DEALTYPES: cat=%s, action=%s, label=%s, value=%d", new Object[] {
                "deal_types", obj, "page", Integer.valueOf(getHostPageValue())
            }), new Object[0]);
            FavoriteDealTypeItem.access$100(FavoriteDealTypeItem.this).logGeneralEvent("deal_types", ((String) (obj)), "page", getHostPageValue(), Logger.NULL_NST_FIELD);
        }
        favoritedealtypeitem = FavoriteDealTypeItem.this;
        if (boolean1.booleanValue())
        {
            obj = newState;
        } else
        if (newState == newState)
        {
            obj = newState;
        } else
        {
            obj = newState;
        }
        favoritedealtypeitem.setState(((newState) (obj)));
        if (callback != null)
        {
            callback.execute(boolean1);
        }
        showPopupWindowIfNecessary();
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Boolean)obj);
    }

    public ( , Function1 function1)
    {
        this$0 = FavoriteDealTypeItem.this;
        super();
        newState = ;
        callback = function1;
    }
}
