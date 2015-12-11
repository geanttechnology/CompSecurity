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

        public static RowType valueOf(String s)
        {
            return (RowType)Enum.valueOf(com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType, s);
        }

        public static RowType[] values()
        {
            return (RowType[])$VALUES.clone();
        }

        static 
        {
            SUGGESTION = new RowType("SUGGESTION", 0);
            ICON = new RowType("ICON", 1);
            $VALUES = (new RowType[] {
                SUGGESTION, ICON
            });
        }

        private RowType(String s, int i)
        {
            super(s, i);
        }
    }


    private int a9SuggestionSize;
    private String deleteUrl;
    private String department;
    private boolean hasSnap;
    private String intentData;
    private boolean isFallBack;
    private boolean isFlowEnabled;
    private boolean isSpellCorrected;
    private boolean isXcat;
    private String pastSearchId;
    private int pos;
    private String query;
    private RowType rowType;
    private boolean showBarcode;
    private boolean showVisualScan;
    private String suggestion;
    private com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestionType;
    private boolean voiceEnabled;
    private int xcatPos;
    private int xcatSize;

    public RetailSearchSuggestionRow()
    {
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

    public String getIntentData()
    {
        return intentData;
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

    public boolean isSpellCorrected()
    {
        return isSpellCorrected;
    }

    public boolean isXcat()
    {
        return isXcat;
    }

    public void setA9SuggestionSize(int i)
    {
        a9SuggestionSize = i;
    }

    public void setDeleteUrl(String s)
    {
        deleteUrl = s;
    }

    public void setDepartment(String s)
    {
        department = s;
    }

    public void setFallBack(boolean flag)
    {
        isFallBack = flag;
    }

    public void setFlowEnabled(boolean flag)
    {
        isFlowEnabled = flag;
    }

    public void setHasSnap(boolean flag)
    {
        hasSnap = flag;
    }

    public void setIntentData(String s)
    {
        intentData = s;
    }

    public void setPastSearchId(String s)
    {
        pastSearchId = s;
    }

    public void setPos(int i)
    {
        pos = i;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setRowType(RowType rowtype)
    {
        rowType = rowtype;
    }

    public void setShowBarcode(boolean flag)
    {
        showBarcode = flag;
    }

    public void setShowVisualScan(boolean flag)
    {
        showVisualScan = flag;
    }

    public void setSpellCorrected(boolean flag)
    {
        isSpellCorrected = flag;
    }

    public void setSuggestion(String s)
    {
        suggestion = s;
    }

    public void setSuggestionType(com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestiontype)
    {
        suggestionType = suggestiontype;
    }

    public void setVoiceEnabled(boolean flag)
    {
        voiceEnabled = flag;
    }

    public void setXcat(boolean flag)
    {
        isXcat = flag;
    }

    public void setXcatPos(int i)
    {
        xcatPos = i;
    }

    public void setXcatSize(int i)
    {
        xcatSize = i;
    }

    public boolean showBarcode()
    {
        return showBarcode;
    }

    public boolean showVisualScan()
    {
        return showVisualScan;
    }

    public boolean voiceEnabled()
    {
        return voiceEnabled;
    }
}
