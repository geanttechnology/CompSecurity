// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.adapter.mygroupons.MyGrouponsCardEndlessAdapter;
import com.groupon.db.events.MyGrouponsUpdateEvent;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.loader.MyGrouponsListLoader;
import commonlib.adapter.JavaAdapter;
import commonlib.loader.ListLoaderCallbacks;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

protected static class isEditOrderEnabled extends ListLoaderCallbacks
{

    private BaseMyGrouponsFragment baseMyGrouponsFragment;
    private String grouponCategory;
    private boolean isEditOrderEnabled;

    private void setGrouponsSelectable(List list)
    {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            MyGrouponItemSummary mygrouponitemsummary = (MyGrouponItemSummary)iterator.next();
            String s;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (Strings.notEmpty(mygrouponitemsummary.availability))
            {
                list = mygrouponitemsummary.availability;
            } else
            {
                list = mygrouponitemsummary.purchaseStatus;
            }
            s = mygrouponitemsummary.status;
            flag2 = mygrouponitemsummary.remoteId.startsWith("groupon_item_internal_id");
            if (Strings.equalsIgnoreCase(list, "refunded") && Strings.equalsIgnoreCase(s, "succeeded"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (isEditOrderEnabled && Strings.equals(mygrouponitemsummary.status, "failed"))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1 || !flag2 && !Strings.equalsIgnoreCase(list, "pending") && !Strings.equalsIgnoreCase(s, "pending") && !Strings.equalsIgnoreCase(s, "failed") && !flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            mygrouponitemsummary.isSelectable = flag2;
        }
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        bundle = new MyGrouponsListLoader(com/groupon/db/models/mygroupons/MyGrouponItemSummary, com/groupon/db/events/MyGrouponsUpdateEvent, baseMyGrouponsFragment.getActivity(), grouponCategory);
        bundle.setForceDownload(baseMyGrouponsFragment.isForceDownload());
        return bundle;
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (list != null)
        {
            setGrouponsSelectable(list);
            baseMyGrouponsFragment.onFinishedLoading(list);
        }
    }

    public void onLoaderReset(Loader loader)
    {
        super.onLoaderReset(loader);
        baseMyGrouponsFragment.myGrouponsCardEndlessAdapter.setTotalSize(0);
        baseMyGrouponsFragment.myGrouponsCardEndlessAdapter.enableAppending(true);
    }

    public (BaseMyGrouponsFragment basemygrouponsfragment, JavaAdapter javaadapter, String s, boolean flag)
    {
        super(javaadapter);
        baseMyGrouponsFragment = basemygrouponsfragment;
        grouponCategory = s;
        isEditOrderEnabled = flag;
    }
}
