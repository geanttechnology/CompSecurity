// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.input;

import com.amazon.retailsearch.android.api.display.DisplayComponent;

// Referenced classes of package com.amazon.retailsearch.android.api.display.input:
//            SearchEntryListeners

public interface SearchEntry
    extends DisplayComponent, SearchEntryListeners
{
    public static class ViewInfo
    {

        private int coords[];
        private int height;
        private int width;

        public int[] getCoords()
        {
            return coords;
        }

        public int getHeight()
        {
            return height;
        }

        public int getWidth()
        {
            return width;
        }

        public void setCoords(int ai[])
        {
            coords = ai;
        }

        public void setHeight(int i)
        {
            height = i;
        }

        public void setWidth(int i)
        {
            width = i;
        }

        public ViewInfo()
        {
        }
    }


    public abstract void clearInputFocus();

    public abstract void dismissSearch();

    public abstract ViewInfo getSearchBoxInfo();

    public abstract android.view.ViewGroup.LayoutParams getViewLayoutParams();

    public abstract boolean hasFocus();

    public abstract void openSearch();

    public abstract void requestSearchBoxFocus();

    public abstract void setHint(String s);

    public abstract void setQuery(String s);

    public abstract void setSearchUri(String s);

    public abstract void setViewLayoutParams(android.view.ViewGroup.LayoutParams layoutparams);
}
