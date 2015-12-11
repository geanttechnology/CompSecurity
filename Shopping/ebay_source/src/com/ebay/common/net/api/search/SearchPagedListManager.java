// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.dm.PagedListManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IoError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchParameters

public abstract class SearchPagedListManager extends PagedListManager
    implements SearchResult.SearchResultContentQuery
{

    protected List firstPage;
    private ResultStatus lastResultStatus;
    private int nextTrackableItemRank;
    protected SearchResult.SearchResultContentObserver observer;
    protected SearchParameters params;
    protected int totalCount;

    public SearchPagedListManager(int i, SearchParameters searchparameters)
    {
        super(i);
        firstPage = null;
        totalCount = 0;
        lastResultStatus = null;
        nextTrackableItemRank = 1;
        params = searchparameters;
    }

    public abstract void fill(ArrayList arraylist, int i)
        throws IOException, InterruptedException;

    public List getDataList()
    {
        if (getData() == null)
        {
            return Collections.emptyList();
        } else
        {
            return getData().getList();
        }
    }

    public int getHigestPageLoaded()
    {
        return getData().getPagesLoaded();
    }

    public ResultStatus getLastResultStatus()
    {
        return lastResultStatus;
    }

    protected ResultStatus getPage(int i, ArrayList arraylist)
        throws InterruptedException, IllegalStateException
    {
        ResultStatus resultstatus = ResultStatus.SUCCESS;
        try
        {
            lastResultStatus = null;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            return ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                new IoError(arraylist)
            });
        }
        if (i != 1) goto _L2; else goto _L1
_L1:
        totalNumberOfItems = -1;
        highestPageIndex = -1;
        query();
        if (totalNumberOfItems < 0 || highestPageIndex < 0)
        {
            throw new IllegalStateException("The implementation for query() must set both totalNumberOfItems and highestPageIndex");
        }
        if (firstPage != null && !firstPage.isEmpty())
        {
            arraylist.addAll(firstPage);
        }
_L4:
        return getLastResultStatus();
_L2:
        fill(arraylist, i);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public abstract int getPageSize();

    protected void handleLoadListResult(ListContent listcontent)
    {
        if (observer == null)
        {
            return;
        } else
        {
            observer.onSearchContentChanged(listcontent);
            return;
        }
    }

    public void loadPage(int i)
    {
        load(i);
    }

    public void onLoadStarted()
    {
    }

    public abstract void query()
        throws IOException, InterruptedException;

    protected void rerankTrackableRows(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                SrpListItem srplistitem = (SrpListItem)list.next();
                if (srplistitem.trackingRank != -1)
                {
                    int i = nextTrackableItemRank;
                    nextTrackableItemRank = i + 1;
                    srplistitem.trackingRank = i;
                }
            }
        }
    }

    public void setLastResultStatus(ResultStatus resultstatus)
    {
        lastResultStatus = resultstatus;
    }

    public void setObserver(SearchResult.SearchResultContentObserver searchresultcontentobserver)
    {
        observer = searchresultcontentobserver;
    }

    public void startQuery()
        throws InterruptedException
    {
        markDirty();
        loadInitialPageSynchronous();
    }
}
