// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry;
import com.amazon.retailsearch.android.ui.results.layout.entry.ContentRowEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            LayoutElement

class StackLayoutState
{

    private int asinEntryGroupIndex;
    private HashMap asinGroupMap;
    private int atfImagesLoadedCount;
    private String entryAsin;
    private final List mainContent;
    private int nextPosition;
    private final List pendingContent;
    private int productCount;
    private LayoutElement productRow;
    private int productRowCount;
    private final List products;
    private boolean relatedSearchesExists;
    private ModelViewEntry resultsCount;
    private int startingPosition;
    private int startingProductRowCount;
    private int startingSize;

    StackLayoutState()
    {
        this(0, 0, 0, 0, 0, 0, 0, ((List) (new ArrayList(8))), null, ((List) (new ArrayList())), ((List) (new ArrayList())), false, null);
    }

    StackLayoutState(int i, int j, int k, int l, int i1, int j1, int k1, 
            List list, LayoutElement layoutelement, List list1, List list2, boolean flag, ModelViewEntry modelviewentry)
    {
        startingSize = i;
        startingPosition = j;
        nextPosition = k;
        startingProductRowCount = l;
        productRowCount = i1;
        productCount = j1;
        atfImagesLoadedCount = k1;
        products = new ArrayList(list);
        productRow = layoutelement;
        mainContent = new ArrayList(list1);
        pendingContent = new ArrayList(list2);
        relatedSearchesExists = flag;
        asinGroupMap = new HashMap();
        resultsCount = modelviewentry;
    }

    public StackLayoutState(StackLayoutState stacklayoutstate)
    {
        int i = stacklayoutstate.startingSize;
        int j = stacklayoutstate.startingPosition;
        int k = stacklayoutstate.nextPosition;
        int l = stacklayoutstate.startingProductRowCount;
        int i1 = stacklayoutstate.productRowCount;
        int j1 = stacklayoutstate.productCount;
        int k1 = stacklayoutstate.atfImagesLoadedCount;
        ArrayList arraylist = new ArrayList(stacklayoutstate.products);
        LayoutElement layoutelement;
        if (stacklayoutstate.productRow != null)
        {
            layoutelement = copyProductRow(stacklayoutstate.productRow);
        } else
        {
            layoutelement = null;
        }
        this(i, j, k, l, i1, j1, k1, ((List) (arraylist)), layoutelement, ((List) (new ArrayList(stacklayoutstate.mainContent))), ((List) (new ArrayList(stacklayoutstate.pendingContent))), stacklayoutstate.relatedSearchesExists, stacklayoutstate.resultsCount);
    }

    private static LayoutElement copyProductRow(LayoutElement layoutelement)
    {
        return new LayoutElement(new ContentRowEntry((ContentRowEntry)layoutelement.getEntry()), layoutelement.getSection(), layoutelement.getRequestedPosition(), layoutelement.getPriority(), layoutelement.getSpan(), new ArrayList(layoutelement.getLoaders()), layoutelement.getPosition(), layoutelement.getLayoutElementModel(), layoutelement.isShownInSplitView());
    }

    public HashMap getAsinGroupMap()
    {
        return asinGroupMap;
    }

    int getAtfImagesLoadedCount()
    {
        return atfImagesLoadedCount;
    }

    protected String getEntryAsin()
    {
        return entryAsin;
    }

    int getEntryGroupIndex()
    {
        return asinEntryGroupIndex;
    }

    List getMainContent()
    {
        return mainContent;
    }

    int getNextPosition()
    {
        return nextPosition;
    }

    List getPendingContent()
    {
        return pendingContent;
    }

    int getProductCount()
    {
        return productCount;
    }

    LayoutElement getProductRow()
    {
        return productRow;
    }

    int getProductRowCount()
    {
        return productRowCount;
    }

    List getProducts()
    {
        return products;
    }

    boolean getRelatedSearchesExists()
    {
        return relatedSearchesExists;
    }

    protected ModelViewEntry getResultsCount()
    {
        return resultsCount;
    }

    int getStartingPosition()
    {
        return startingPosition;
    }

    int getStartingProductRowCount()
    {
        return startingProductRowCount;
    }

    int getStartingSize()
    {
        return startingSize;
    }

    void setAtfImagesLoadedCount(int i)
    {
        atfImagesLoadedCount = i;
    }

    protected void setEntryAsin(String s)
    {
        entryAsin = s;
    }

    void setEntryGroupIndex(int i)
    {
        asinEntryGroupIndex = i;
    }

    void setNextPosition(int i)
    {
        nextPosition = i;
    }

    void setProductCount(int i)
    {
        productCount = i;
    }

    void setProductRow(LayoutElement layoutelement)
    {
        productRow = layoutelement;
    }

    void setProductRowCount(int i)
    {
        productRowCount = i;
    }

    void setRelatedSearchesExists(boolean flag)
    {
        relatedSearchesExists = flag;
    }

    protected void setResultsCount(ModelViewEntry modelviewentry)
    {
        resultsCount = modelviewentry;
    }

    void setStartingPosition(int i)
    {
        startingPosition = i;
    }

    void setStartingProductRowCount(int i)
    {
        startingProductRowCount = i;
    }

    void setStartingSize(int i)
    {
        startingSize = i;
    }
}
