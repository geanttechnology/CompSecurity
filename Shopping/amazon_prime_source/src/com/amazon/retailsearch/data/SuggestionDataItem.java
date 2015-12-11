// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.retailsearch.util.Utils;

public class SuggestionDataItem
{
    public class SuggestionKey
    {

        private String keywords;
        private String searchAlias;
        final SuggestionDataItem this$0;

        public boolean equals(Object obj)
        {
            if (obj instanceof SuggestionKey)
            {
                if (Utils.isEqual(keywords, ((SuggestionKey) (obj = (SuggestionKey)obj)).getKeywords()) && Utils.isEqual(searchAlias, ((SuggestionKey) (obj)).getSearchAlias()))
                {
                    return true;
                }
            }
            return false;
        }

        public String getKeywords()
        {
            return keywords;
        }

        public String getSearchAlias()
        {
            return searchAlias;
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (keywords == null)
            {
                i = 0;
            } else
            {
                i = keywords.hashCode();
            }
            if (searchAlias != null)
            {
                j = searchAlias.hashCode();
            }
            return (i + 29) * 29 + j;
        }

        public SuggestionKey(String s, String s1)
        {
            this$0 = SuggestionDataItem.this;
            super();
            searchAlias = s;
            keywords = s1;
        }
    }

    public static final class SuggestionType extends Enum
    {

        private static final SuggestionType $VALUES[];
        public static final SuggestionType A9_SUGGESTION;
        public static final SuggestionType MERGED;
        public static final SuggestionType PAST_SEARCHES;

        public static SuggestionType valueOf(String s)
        {
            return (SuggestionType)Enum.valueOf(com/amazon/retailsearch/data/SuggestionDataItem$SuggestionType, s);
        }

        public static SuggestionType[] values()
        {
            return (SuggestionType[])$VALUES.clone();
        }

        static 
        {
            A9_SUGGESTION = new SuggestionType("A9_SUGGESTION", 0);
            PAST_SEARCHES = new SuggestionType("PAST_SEARCHES", 1);
            MERGED = new SuggestionType("MERGED", 2);
            $VALUES = (new SuggestionType[] {
                A9_SUGGESTION, PAST_SEARCHES, MERGED
            });
        }

        private SuggestionType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int PRIME = 29;
    private String deleteURL;
    private String departmentName;
    private String displayText;
    private String id;
    private boolean isFallback;
    private boolean isSpellCorrected;
    private boolean isXcat;
    private int pos;
    private String query;
    private String searchAlias;
    private String suggestion;
    private SuggestionType type;
    private int xcatPos;

    public SuggestionDataItem()
    {
    }

    public String getDeleteURL()
    {
        return deleteURL;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public String getDisplayText()
    {
        return displayText;
    }

    public String getId()
    {
        return id;
    }

    public SuggestionKey getKey()
    {
        return new SuggestionKey(searchAlias, suggestion);
    }

    public int getPos()
    {
        return pos;
    }

    public String getQuery()
    {
        return query;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public String getSuggestion()
    {
        return suggestion;
    }

    public SuggestionType getType()
    {
        return type;
    }

    public int getXcatPos()
    {
        return xcatPos;
    }

    public String isFallback()
    {
        if (isFallback)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public boolean isFallbackValue()
    {
        return isFallback;
    }

    public String isSpellCorrected()
    {
        if (isSpellCorrected)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public boolean isSpellCorrectedValue()
    {
        return isSpellCorrected;
    }

    public String isXcat()
    {
        if (isXcat)
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public boolean isXcatValue()
    {
        return isXcat;
    }

    public void setDeleteURL(String s)
    {
        deleteURL = s;
    }

    public void setDepartmentName(String s)
    {
        departmentName = s;
    }

    public void setDisplayText(String s)
    {
        displayText = s;
    }

    public void setFallback(boolean flag)
    {
        isFallback = flag;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setPos(int i)
    {
        pos = i;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setSearchAlias(String s)
    {
        searchAlias = s;
    }

    public void setSpellCorrected(boolean flag)
    {
        isSpellCorrected = flag;
    }

    public void setSuggestion(String s)
    {
        suggestion = s;
    }

    public void setType(SuggestionType suggestiontype)
    {
        type = suggestiontype;
    }

    public void setXcat(boolean flag)
    {
        isXcat = flag;
    }

    public void setXcatPos(int i)
    {
        xcatPos = i;
    }
}
