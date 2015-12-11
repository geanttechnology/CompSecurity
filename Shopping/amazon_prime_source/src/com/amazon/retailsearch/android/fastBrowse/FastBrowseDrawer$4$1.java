// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseDrawer, RefinementsLoader

class this._cls1
    implements inementResultListener
{

    final eGNOMenu this$1;

    public void onError(Exception exception)
    {
        FastBrowseDrawer.access$900().error("Failed to refetch refinements", exception);
    }

    public void onResult(SearchResult searchresult)
    {
        if (searchresult == null || searchresult.getRefinements() == null || searchresult.getRefinements().getDepartments() == null)
        {
            FastBrowseDrawer.access$1100(_fld0);
        } else
        {
            FastBrowseDrawer.access$1002(_fld0, searchresult);
            searchresult = FastBrowseDrawer.access$1000(_fld0).getRefinements().getDepartments().getCategories();
            java.util.List list = FastBrowseDrawer.access$1000(_fld0).getRefinements().getDepartments().getAncestry();
            FastBrowseDrawer.access$1200(_fld0, list, searchresult, null, null);
            FastBrowseDrawer.access$1100(_fld0);
            if (searchresult == null)
            {
                platform.invokeLater(new Runnable() {

                    final FastBrowseDrawer._cls4._cls1 this$2;

                    public void run()
                    {
                        closeGNOMenu();
                    }

            
            {
                this$2 = FastBrowseDrawer._cls4._cls1.this;
                super();
            }
                });
                return;
            }
        }
    }

    l.browseUrl()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/fastBrowse/FastBrowseDrawer$4

/* anonymous class */
    class FastBrowseDrawer._cls4
        implements Runnable
    {

        final FastBrowseDrawer this$0;
        final String val$browseUrl;

        public void run()
        {
            (new RefinementsLoader(new FastBrowseDrawer._cls4._cls1(), browseUrl)).getRefinements();
        }

            
            {
                this$0 = final_fastbrowsedrawer;
                browseUrl = String.this;
                super();
            }
    }

}
