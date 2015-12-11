// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IssLogger
{
    public static final class Field extends Enum
    {

        private static final Field $VALUES[];
        public static final Field DataSet;
        public static final Field IsFallback;
        public static final Field IsMidquery;
        public static final Field IsNonPrefix;
        public static final Field IsRobot;
        public static final Field IsSpellCorrected;
        public static final Field IsXcat;
        public static final Field Marketplace;
        public static final Field Pos;
        public static final Field Prefix;
        public static final Field RequestId;
        public static final Field ServiceName;
        public static final Field Size;
        public static final Field Source;
        public static final Field SourceSearchAlias;
        public static final Field Suffix;
        public static final Field Suggestion;
        public static final Field TargetSearchAlias;
        public static final Field UserAction;
        public static final Field Weblabs;
        public static final Field XcatPos;
        public static final Field XcatSize;

        public static Field valueOf(String s)
        {
            return (Field)Enum.valueOf(com/amazon/retailsearch/metrics/IssLogger$Field, s);
        }

        public static Field[] values()
        {
            return (Field[])$VALUES.clone();
        }

        static 
        {
            DataSet = new Field("DataSet", 0);
            Marketplace = new Field("Marketplace", 1);
            SourceSearchAlias = new Field("SourceSearchAlias", 2);
            TargetSearchAlias = new Field("TargetSearchAlias", 3);
            ServiceName = new Field("ServiceName", 4);
            Source = new Field("Source", 5);
            UserAction = new Field("UserAction", 6);
            Pos = new Field("Pos", 7);
            XcatPos = new Field("XcatPos", 8);
            Size = new Field("Size", 9);
            XcatSize = new Field("XcatSize", 10);
            IsSpellCorrected = new Field("IsSpellCorrected", 11);
            IsXcat = new Field("IsXcat", 12);
            IsFallback = new Field("IsFallback", 13);
            IsMidquery = new Field("IsMidquery", 14);
            IsNonPrefix = new Field("IsNonPrefix", 15);
            IsRobot = new Field("IsRobot", 16);
            Weblabs = new Field("Weblabs", 17);
            Prefix = new Field("Prefix", 18);
            Suffix = new Field("Suffix", 19);
            Suggestion = new Field("Suggestion", 20);
            RequestId = new Field("RequestId", 21);
            $VALUES = (new Field[] {
                DataSet, Marketplace, SourceSearchAlias, TargetSearchAlias, ServiceName, Source, UserAction, Pos, XcatPos, Size, 
                XcatSize, IsSpellCorrected, IsXcat, IsFallback, IsMidquery, IsNonPrefix, IsRobot, Weblabs, Prefix, Suffix, 
                Suggestion, RequestId
            });
        }

        private Field(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UserAction extends Enum
    {

        private static final UserAction $VALUES[];
        public static final UserAction explicit_acceptance;
        public static final UserAction implicit_acceptance;
        public static final UserAction mismatch;
        public static final UserAction rejection;
        public static final UserAction zero_impression;

        public static UserAction valueOf(String s)
        {
            return (UserAction)Enum.valueOf(com/amazon/retailsearch/metrics/IssLogger$UserAction, s);
        }

        public static UserAction[] values()
        {
            return (UserAction[])$VALUES.clone();
        }

        static 
        {
            explicit_acceptance = new UserAction("explicit_acceptance", 0);
            implicit_acceptance = new UserAction("implicit_acceptance", 1);
            rejection = new UserAction("rejection", 2);
            mismatch = new UserAction("mismatch", 3);
            zero_impression = new UserAction("zero_impression", 4);
            $VALUES = (new UserAction[] {
                explicit_acceptance, implicit_acceptance, rejection, mismatch, zero_impression
            });
        }

        private UserAction(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String ISS_ACCEPTANCE_FALLBACK = "fb";
    private static final String ISS_ACCEPTANCE_RECENT = "sh";
    private static final String ISS_ACCEPTANCE_REGULAR = "i";
    private static final String ISS_ACCEPTANCE_SPELL_CORRECTED = "sc";
    private static final String ISS_ACCEPTANCE_XCAT = "c";
    private static final String REF_TAG_DELIMITER = "_";
    private static final String REF_TAG_IMPLICIT_ACCEPTANCE = "nb_sb_noss_1";
    private static final String REF_TAG_ISS_PREFIX = "nb_sb_ss";
    private static final String REF_TAG_NO_SUGGESTIONS = "nb_sb_noss";
    private static final String REF_TAG_TEXT_SEARCH_NO_MATCH = "nb_sb_noss_2";
    private Map dataMap;
    private SearchBoxLogger searchBoxLogger;

    public IssLogger()
    {
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        dataMap = new HashMap();
        RetailSearchDaggerGraphController.inject(this);
        set(Field.DataSet, "Prod");
        set(Field.Marketplace, 1);
        set(Field.SourceSearchAlias, "aps");
        set(Field.TargetSearchAlias, "aps");
        set(Field.ServiceName, "ISS");
        set(Field.Source, "mobile-app");
        set(Field.UserAction, UserAction.explicit_acceptance.name());
        set(Field.Pos, 0);
        set(Field.XcatPos, 0);
        set(Field.Size, 0);
        set(Field.XcatSize, 0);
        set(Field.IsSpellCorrected, false);
        set(Field.IsXcat, false);
        set(Field.IsFallback, false);
        set(Field.IsMidquery, false);
        set(Field.IsNonPrefix, false);
        set(Field.IsRobot, false);
        set(Field.Weblabs, "");
        set(Field.Prefix, "");
        set(Field.Suffix, "");
        set(Field.Suggestion, "");
        set(Field.RequestId, "");
    }

    public IssLogger(Map map)
    {
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        dataMap = new HashMap();
        RetailSearchDaggerGraphController.inject(this);
        dataMap = map;
    }

    private static void addSelectRefTagAcceptanceTypes(List list, RetailSearchSuggestionRow retailsearchsuggestionrow)
    {
        boolean flag2 = true;
        com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestiontype = retailsearchsuggestionrow.getSuggestionType();
        boolean flag;
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.PAST_SEARCHES == suggestiontype || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED == suggestiontype)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            list.add("sh");
        } else
        {
            boolean flag1;
            if (!retailsearchsuggestionrow.isXcat() && !retailsearchsuggestionrow.isSpellCorrected() && !retailsearchsuggestionrow.isFallBack())
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                list.add("i");
                return;
            }
            if (retailsearchsuggestionrow.isXcat())
            {
                list.add("c");
            }
            if (retailsearchsuggestionrow.isSpellCorrected())
            {
                list.add("sc");
            }
            if (retailsearchsuggestionrow.isFallBack())
            {
                list.add("fb");
                return;
            }
        }
    }

    private static void addSelectRefTagIndex(List list, List list1, RetailSearchSuggestionRow retailsearchsuggestionrow, int i)
    {
        if (!retailsearchsuggestionrow.isXcat())
        {
            list.add(Integer.toString(i));
            return;
        }
        retailsearchsuggestionrow = retailsearchsuggestionrow.getSuggestion();
        int j = 0;
        list1 = list1.iterator();
        do
        {
            if (!list1.hasNext())
            {
                break;
            }
            RetailSearchSuggestionRow retailsearchsuggestionrow1 = (RetailSearchSuggestionRow)list1.next();
            if (!retailsearchsuggestionrow1.isIconRow())
            {
                boolean flag;
                if (!retailsearchsuggestionrow1.isXcat() && !retailsearchsuggestionrow1.isFallBack() && !retailsearchsuggestionrow1.isSpellCorrected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (retailsearchsuggestionrow.equals(retailsearchsuggestionrow1.getSuggestion()) && flag)
                {
                    list.add(Integer.toString(j));
                    return;
                }
                j++;
            }
        } while (true);
        list.add(Integer.toString(i));
    }

    public static String computeSelectRefTag(List list, int i, String s)
    {
        if (list != null && list.size() != 0 && i >= 0 && list.size() > i)
        {
            int k = i;
            RetailSearchSuggestionRow retailsearchsuggestionrow = (RetailSearchSuggestionRow)list.get(k);
            if (retailsearchsuggestionrow != null && !retailsearchsuggestionrow.isIconRow())
            {
                for (int j = 0; j < i;)
                {
                    int l = k;
                    if (((RetailSearchSuggestionRow)list.get(j)).isIconRow())
                    {
                        l = k - 1;
                    }
                    j++;
                    k = l;
                }

                ArrayList arraylist = new ArrayList(4);
                arraylist.add("nb_sb_ss");
                addSelectRefTagAcceptanceTypes(arraylist, retailsearchsuggestionrow);
                addSelectRefTagIndex(arraylist, list, retailsearchsuggestionrow, k);
                if (s != null)
                {
                    i = s.length();
                } else
                {
                    i = 0;
                }
                arraylist.add(Integer.toString(i));
                return TextUtils.join("_", arraylist);
            }
        }
        return null;
    }

    public static String computeSubmitQueryRefTag(List list, String s)
    {
        if (list == null || TextUtils.isEmpty(s))
        {
            return null;
        }
        if (list.size() == 0)
        {
            return "nb_sb_noss";
        }
        for (list = list.iterator(); list.hasNext();)
        {
            RetailSearchSuggestionRow retailsearchsuggestionrow = (RetailSearchSuggestionRow)list.next();
            String s1 = retailsearchsuggestionrow.getSuggestion();
            if (s1 != null && !retailsearchsuggestionrow.isIconRow() && s1.equals(s.toLowerCase()))
            {
                return "nb_sb_noss_1";
            }
        }

        return "nb_sb_noss_2";
    }

    public static Map createLogData(RetailSearchSuggestionRow retailsearchsuggestionrow, String s, String s1, String s2, String s3)
    {
        if (retailsearchsuggestionrow == null || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3))
        {
            return null;
        }
        IssLogger isslogger = new IssLogger();
        SearchRealm searchrealm = SearchConfiguration.getConfiguration().getRealm();
        if (searchrealm != null)
        {
            isslogger.set(Field.Marketplace, searchrealm.getMarketplaceId());
        }
        if (!TextUtils.isEmpty(s))
        {
            isslogger.set(Field.SourceSearchAlias, s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            isslogger.set(Field.TargetSearchAlias, s1);
        }
        s = retailsearchsuggestionrow.getSuggestionType();
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION.equals(s) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.equals(s))
        {
            isslogger.set(Field.UserAction, UserAction.explicit_acceptance.name());
            isslogger.set(Field.Pos, retailsearchsuggestionrow.getPos());
            isslogger.set(Field.XcatPos, retailsearchsuggestionrow.getXcatPos());
            s1 = Field.IsSpellCorrected;
            boolean flag;
            if (retailsearchsuggestionrow.isSpellCorrected())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            isslogger.set(s1, s);
            s1 = Field.IsXcat;
            if (retailsearchsuggestionrow.isXcat())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            isslogger.set(s1, s);
            s1 = Field.IsFallback;
            if (retailsearchsuggestionrow.isFallBack())
            {
                s = "1";
            } else
            {
                s = "0";
            }
            isslogger.set(s1, s);
            s = Field.IsNonPrefix;
            if (!s2.startsWith(s3))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isslogger.set(s, flag);
            isslogger.set(Field.Suggestion, s2);
        } else
        {
            isslogger.set(Field.UserAction, UserAction.rejection.name());
        }
        isslogger.set(Field.Size, retailsearchsuggestionrow.getA9SuggestionSize());
        isslogger.set(Field.XcatSize, retailsearchsuggestionrow.getXcatSize());
        isslogger.set(Field.Prefix, s3);
        return isslogger.getIssEngagementData();
    }

    public static Map createLogData(List list, String s, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        IssLogger isslogger = new IssLogger();
        SearchRealm searchrealm = SearchConfiguration.getConfiguration().getRealm();
        if (searchrealm != null)
        {
            isslogger.set(Field.Marketplace, searchrealm.getMarketplaceId());
        }
        if (!TextUtils.isEmpty(s))
        {
            isslogger.set(Field.SourceSearchAlias, s);
        }
        boolean flag = false;
        int l = 0;
        boolean flag1 = false;
        int j = 0;
        boolean flag6 = false;
        boolean flag4 = false;
        boolean flag2 = false;
        int k = 0;
        boolean flag3 = false;
        int i = 0;
        int i1 = ((flag) ? 1 : 0);
        boolean flag5 = flag6;
        int j1 = ((flag1) ? 1 : 0);
        int k1 = ((flag2) ? 1 : 0);
        int l1 = ((flag3) ? 1 : 0);
        if (list != null)
        {
            i1 = ((flag) ? 1 : 0);
            flag5 = flag6;
            j1 = ((flag1) ? 1 : 0);
            k1 = ((flag2) ? 1 : 0);
            l1 = ((flag3) ? 1 : 0);
            if (list.size() > 0)
            {
                list = list.iterator();
                do
                {
                    i1 = l;
                    flag5 = flag4;
                    j1 = j;
                    k1 = k;
                    l1 = i;
                    if (!list.hasNext())
                    {
                        break;
                    }
                    s = (RetailSearchSuggestionRow)list.next();
                    com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType suggestiontype = s.getSuggestionType();
                    if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION == suggestiontype || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED == suggestiontype)
                    {
                        k1 = 1;
                        l1 = k + 1;
                        j1 = i;
                        if (s.isXcat())
                        {
                            j1 = i + 1;
                        }
                        i1 = j;
                        if (l1 == 1)
                        {
                            if (!s1.equals(s.getQuery()))
                            {
                                i1 = 1;
                            } else
                            {
                                i1 = 0;
                            }
                        }
                        l = k1;
                        j = i1;
                        k = l1;
                        i = j1;
                        if (i1 == 0)
                        {
                            l = k1;
                            j = i1;
                            k = l1;
                            i = j1;
                            if (!flag4)
                            {
                                flag4 = s.getSuggestion().equals(s1.toLowerCase());
                                l = k1;
                                j = i1;
                                k = l1;
                                i = j1;
                            }
                        }
                    }
                } while (true);
            }
        }
        isslogger.set(Field.Prefix, s1);
        if (i1 == 0)
        {
            isslogger.set(Field.UserAction, UserAction.zero_impression.name());
        } else
        if (j1 != 0)
        {
            isslogger.set(Field.UserAction, UserAction.mismatch.name());
            isslogger.set(Field.Prefix, "");
        } else
        if (flag5)
        {
            isslogger.set(Field.UserAction, UserAction.implicit_acceptance.name());
            isslogger.set(Field.Suggestion, s1);
        } else
        {
            isslogger.set(Field.UserAction, UserAction.rejection.name());
        }
        isslogger.set(Field.Size, k1);
        isslogger.set(Field.XcatSize, l1);
        return isslogger.getIssEngagementData();
    }

    public Map getIssEngagementData()
    {
        return dataMap;
    }

    public IssLogger set(Field field, int i)
    {
        dataMap.put(field.name(), String.valueOf(i));
        return this;
    }

    public IssLogger set(Field field, String s)
    {
        Map map = dataMap;
        String s1 = field.name();
        field = s;
        if (s == null)
        {
            field = "";
        }
        map.put(s1, field);
        return this;
    }

    public IssLogger set(Field field, boolean flag)
    {
        Map map = dataMap;
        String s = field.name();
        if (flag)
        {
            field = "1";
        } else
        {
            field = "0";
        }
        map.put(s, field);
        return this;
    }

    public IssLogger setRequestId(String s)
    {
        set(Field.RequestId, s);
        return this;
    }

    public void submitLog()
    {
        searchBoxLogger.searchSuggestionsEngagment(dataMap);
        dataMap = null;
    }
}
