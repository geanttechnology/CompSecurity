// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;


public class RetailSearchSuggestionRow
{
    static final class RowType extends Enum
    {

        private static final RowType $VALUES[];
        public static final RowType ICON;
        public static final RowType SUGGESTION;
        private final int viewType;

        public static RowType valueOf(String s)
        {
            return (RowType)Enum.valueOf(com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType, s);
        }

        public static RowType[] values()
        {
            return (RowType[])$VALUES.clone();
        }

        public int getViewType()
        {
            return viewType;
        }

        static 
        {
            SUGGESTION = new RowType("SUGGESTION", 0, 1);
            ICON = new RowType("ICON", 1, 0);
            $VALUES = (new RowType[] {
                SUGGESTION, ICON
            });
        }

        private RowType(String s, int i, int j)
        {
            super(s, i);
            viewType = j;
        }
    }


    private final int a9SuggestionSize;
    private final String deleteUrl;
    private final String department;
    private final boolean hasSnap;
    private final boolean isFallBack;
    private final boolean isFlowEnabled;
    private final boolean isSpellCorrected;
    private final boolean isXcat;
    private final String pastSearchId;
    private final int pos;
    private final String query;
    private final RowType rowType;
    private final String searchAlias;
    private final boolean showBarcode;
    private final boolean showBarcodeIconForFlow;
    private final String suggestion;
    private final com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestionType;
    private final boolean voiceEnabled;
    private final int xcatPos;
    private final int xcatSize;

    public RetailSearchSuggestionRow(String s, String s1, String s2, String s3, String s4, String s5, int i, 
            int j, boolean flag, boolean flag1, boolean flag2, com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestiontype, int k, int l)
    {
        suggestion = s;
        searchAlias = s1;
        department = s2;
        deleteUrl = s3;
        pastSearchId = s4;
        query = s5;
        pos = i;
        xcatPos = j;
        isSpellCorrected = flag;
        isXcat = flag1;
        isFallBack = flag2;
        suggestionType = suggestiontype;
        xcatSize = k;
        a9SuggestionSize = l;
        rowType = RowType.SUGGESTION;
        showBarcodeIconForFlow = false;
        isFlowEnabled = false;
        hasSnap = false;
        showBarcode = false;
        voiceEnabled = false;
    }

    public RetailSearchSuggestionRow(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        voiceEnabled = flag;
        hasSnap = flag1;
        isFlowEnabled = flag2;
        showBarcodeIconForFlow = flag3;
        showBarcode = flag4;
        rowType = RowType.ICON;
        suggestionType = null;
        query = null;
        pastSearchId = null;
        deleteUrl = null;
        department = null;
        searchAlias = null;
        suggestion = null;
        pos = -1;
        xcatPos = -1;
        xcatSize = -1;
        a9SuggestionSize = -1;
        isFallBack = false;
        isXcat = false;
        isSpellCorrected = false;
    }

    public int getA9SuggestionSize()
    {
        return a9SuggestionSize;
    }

    public String getDeleteUrl()
    {
        return deleteUrl;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getPastSearchId()
    {
        return pastSearchId;
    }

    public int getPos()
    {
        return pos;
    }

    public String getQuery()
    {
        return query;
    }

    public RowType getRowType()
    {
        return rowType;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public String getSuggestion()
    {
        return suggestion;
    }

    public com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType getSuggestionType()
    {
        return suggestionType;
    }

    public int getXcatPos()
    {
        return xcatPos;
    }

    public int getXcatSize()
    {
        return xcatSize;
    }

    public boolean hasSnap()
    {
        return hasSnap;
    }

    public boolean isFallBack()
    {
        return isFallBack;
    }

    public boolean isFlowEnabled()
    {
        return isFlowEnabled;
    }

    public boolean isIconRow()
    {
        return rowType == RowType.ICON;
    }

    public boolean isSpellCorrected()
    {
        return isSpellCorrected;
    }

    public boolean isXcat()
    {
        return isXcat;
    }

    public boolean showBarcode()
    {
        return showBarcode;
    }

    public boolean showBarcodeIconForFlow()
    {
        return showBarcodeIconForFlow;
    }

    public boolean voiceEnabled()
    {
        return voiceEnabled;
    }
}
