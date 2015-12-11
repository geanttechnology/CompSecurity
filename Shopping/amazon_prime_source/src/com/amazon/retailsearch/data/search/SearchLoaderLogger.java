// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import android.view.View;
import com.amazon.retailsearch.android.api.log.LogEventHandler;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SearchLoaderLogger
{

    private boolean didLayoutChildren;
    private Set drewRows;
    private boolean isATFLogged;
    private boolean isParsingEnded;
    private boolean isSRDSLogged;
    private boolean isTrueATFLogged;
    private int lastRowHeight;
    private int listViewHeight;
    private int numOfColumns;
    private int numOfLatencyRows;
    private int numOfLoadedImages;
    private int numOfProducts;
    private RetailSearchLogger retailSearchLogger;
    private int rowsHeight;
    private LogEventHandler searchLogEventHandler;
    private LogEventHandler srdsLogEventHandler;
    private LogEventHandler trueSearchLogEventHandler;
    private Map viewTypesMap;

    public SearchLoaderLogger()
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        numOfColumns = 1;
        numOfLatencyRows = 0;
        numOfProducts = 0;
        numOfLoadedImages = 0;
        listViewHeight = 0;
        rowsHeight = 0;
        lastRowHeight = 0;
        didLayoutChildren = false;
        drewRows = new HashSet();
        viewTypesMap = new HashMap();
    }

    private void processTrueSearchLogging()
    {
        if (listViewHeight > 0)
        {
            int l = 0;
            int i;
            int k;
            if (numOfLatencyRows > 0)
            {
                i = numOfLatencyRows;
            } else
            {
                i = drewRows.size();
            }
            for (k = 0; k < i;)
            {
                int i1 = l;
                if (viewTypesMap.get(Integer.valueOf(k)) != null)
                {
                    i1 = l;
                    if (((Integer)viewTypesMap.get(Integer.valueOf(k))).intValue() == 1)
                    {
                        i1 = l + 1;
                    }
                }
                k++;
                l = i1;
            }

            if (numOfLatencyRows > 0 || isParsingEnded && l >= numOfLoadedImages && numOfLoadedImages >= numOfProducts)
            {
                int j = l * numOfColumns;
                if (j > numOfProducts)
                {
                    j = numOfProducts;
                }
                if (numOfLoadedImages >= j)
                {
                    retailSearchLogger.trueSearchATFReached(trueSearchLogEventHandler);
                    isTrueATFLogged = true;
                    return;
                }
            }
        }
    }

    private void reset()
    {
        isTrueATFLogged = false;
        numOfColumns = 1;
        numOfProducts = 0;
        numOfLoadedImages = 0;
        numOfLatencyRows = 0;
        listViewHeight = 0;
        rowsHeight = 0;
        lastRowHeight = 0;
        isParsingEnded = false;
        didLayoutChildren = false;
        drewRows.clear();
        viewTypesMap.clear();
    }

    public void addDrewRow(View view)
    {
        while (isTrueATFLogged || view.getId() == com.amazon.retailsearch.R.id.rs_search_spinner_container || view == null || drewRows.contains(view)) 
        {
            return;
        }
        lastRowHeight = view.getHeight();
        rowsHeight = rowsHeight + lastRowHeight;
        drewRows.add(view);
        if (numOfLatencyRows == 0 && rowsHeight > listViewHeight - lastRowHeight / 2)
        {
            numOfLatencyRows = drewRows.size();
        }
        processTrueSearchLogging();
    }

    public void addNumOfProducts(int i)
    {
        if (isTrueATFLogged)
        {
            return;
        } else
        {
            numOfProducts = numOfProducts + i;
            return;
        }
    }

    public void addViewType(int i, int j)
    {
        if (isTrueATFLogged)
        {
            return;
        } else
        {
            viewTypesMap.put(Integer.valueOf(i), Integer.valueOf(j));
            processTrueSearchLogging();
            return;
        }
    }

    public void completeSRDSLogging()
    {
        retailSearchLogger.searchSRDSCompleted(srdsLogEventHandler);
        isSRDSLogged = true;
        srdsLogEventHandler = null;
    }

    public void completeSearchLogging()
    {
        retailSearchLogger.searchATFReached(searchLogEventHandler);
        isATFLogged = true;
    }

    public void endParse()
    {
        if (isTrueATFLogged)
        {
            return;
        } else
        {
            isParsingEnded = true;
            processTrueSearchLogging();
            return;
        }
    }

    public LogEventHandler getSearchLogEventHandler()
    {
        return searchLogEventHandler;
    }

    public LogEventHandler getSrdsLogEventHandler()
    {
        return srdsLogEventHandler;
    }

    public void increaseLoadedImage()
    {
        if (isTrueATFLogged)
        {
            return;
        } else
        {
            numOfLoadedImages = numOfLoadedImages + 1;
            processTrueSearchLogging();
            return;
        }
    }

    public boolean isATFLogged()
    {
        return isATFLogged;
    }

    public void layoutChildren()
    {
        if (isTrueATFLogged)
        {
            return;
        } else
        {
            didLayoutChildren = true;
            rowsHeight = 0;
            lastRowHeight = 0;
            numOfLatencyRows = 0;
            drewRows.clear();
            return;
        }
    }

    public void setATFLogged(boolean flag)
    {
        isATFLogged = flag;
    }

    public void setListViewHeight(int i)
    {
        while (isTrueATFLogged || !didLayoutChildren) 
        {
            return;
        }
        listViewHeight = i;
    }

    public void setNumOfColumns(int i)
    {
        if (isTrueATFLogged)
        {
            return;
        } else
        {
            numOfColumns = i;
            return;
        }
    }

    public void setSearchLogEventHandler(LogEventHandler logeventhandler)
    {
        searchLogEventHandler = logeventhandler;
    }

    public void setSrdsLogEventHandler(LogEventHandler logeventhandler)
    {
        if (!isSRDSLogged)
        {
            srdsLogEventHandler = logeventhandler;
        }
    }

    public void setTrueSearchLogEventHandler(LogEventHandler logeventhandler)
    {
        trueSearchLogEventHandler = logeventhandler;
        reset();
    }
}
