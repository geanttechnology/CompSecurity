// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.res.TypedArray;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementLink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            SlideMenuClickListener, FastBrowseItem, FastBrowseListAdapter, RefinementsLoader

class this._cls1
    implements tResultListener
{

    final fresh this$1;

    public void onError(Exception exception)
    {
    }

    public void onResult(SearchResult searchresult)
    {
        if (searchresult == null || searchresult.getRefinements() == null || searchresult.getRefinements().getDepartments() == null)
        {
            SlideMenuClickListener.access$000(_fld0).recycle();
            onRefresh();
            return;
        }
        SlideMenuClickListener.access$102(_fld0, searchresult);
        searchresult = SlideMenuClickListener.access$100(_fld0).getRefinements().getDepartments().getCategories();
        Object obj = SlideMenuClickListener.access$100(_fld0).getRefinements().getDepartments().getAncestry();
        SlideMenuClickListener.access$200(_fld0).clear();
        SlideMenuClickListener.access$200(_fld0).add(new FastBrowseItem(SlideMenuClickListener.access$300(_fld0), "/s/browse/categories", "/s/browse/categories", SlideMenuClickListener.access$000(_fld0).getResourceId(0, -1)));
        if (obj != null)
        {
            RefinementLink refinementlink1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); SlideMenuClickListener.access$200(_fld0).add(new FastBrowseItem(refinementlink1.getText(), refinementlink1.getUrl(), refinementlink1.getBrowseUrl(), SlideMenuClickListener.access$000(_fld0).getResourceId(0, -1))))
            {
                refinementlink1 = (RefinementLink)((Iterator) (obj)).next();
            }

        }
        SlideMenuClickListener.access$400(_fld0).setCurrentLayer(SlideMenuClickListener.access$200(_fld0).size() - 1);
        if (SlideMenuClickListener.access$400(_fld0).getCurrentLayer() == 0)
        {
            ((FastBrowseItem)SlideMenuClickListener.access$200(_fld0).get(0)).setTitle(SlideMenuClickListener.access$500(_fld0));
        }
        if (searchresult != null)
        {
            RefinementLink refinementlink;
            for (searchresult = searchresult.iterator(); searchresult.hasNext(); SlideMenuClickListener.access$200(_fld0).add(new FastBrowseItem(refinementlink.getText(), refinementlink.getUrl(), refinementlink.getBrowseUrl(), SlideMenuClickListener.access$000(_fld0).getResourceId(0, -1))))
            {
                refinementlink = (RefinementLink)searchresult.next();
            }

        }
        SlideMenuClickListener.access$000(_fld0).recycle();
        onRefresh();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1

/* anonymous class */
    class SlideMenuClickListener._cls1
        implements Runnable
    {

        final SlideMenuClickListener this$0;

        public void run()
        {
            SlideMenuClickListener._cls1._cls1 _lcls1 = new SlideMenuClickListener._cls1._cls1();
            String s;
            if ("/s/browse/categories".equals(SlideMenuClickListener.access$600(SlideMenuClickListener.this)))
            {
                s = null;
            } else
            {
                s = SlideMenuClickListener.access$600(SlideMenuClickListener.this);
            }
            (new RefinementsLoader(_lcls1, s)).getRefinements();
        }

            
            {
                this$0 = SlideMenuClickListener.this;
                super();
            }
    }

}
