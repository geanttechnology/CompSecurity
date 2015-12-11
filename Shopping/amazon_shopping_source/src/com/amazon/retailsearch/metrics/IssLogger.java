// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.database.Cursor;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import java.util.HashMap;
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

    public static Map createLogData(Cursor cursor, int i, String s, String s1, String s2, String s3)
    {
        if (cursor == null || i < 0 || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3))
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
        cursor.moveToPosition(i);
        s = getCursorValue(cursor, "suggest_intent_extra_data", null);
        int l;
        if (com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION.name().equals(s) || com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
        {
            isslogger.set(Field.UserAction, UserAction.explicit_acceptance.name());
            isslogger.set(Field.Pos, getCursorValue(cursor, "suggest_log_pos", "0"));
            isslogger.set(Field.XcatPos, getCursorValue(cursor, "suggest_log_xcat_pos", "0"));
            isslogger.set(Field.IsSpellCorrected, getCursorValue(cursor, "suggest_log_is_spell_corrected", "0"));
            isslogger.set(Field.IsXcat, getCursorValue(cursor, "suggest_log_is_xcat", "0"));
            isslogger.set(Field.IsFallback, getCursorValue(cursor, "suggest_log_is_fallback", "0"));
            s = Field.IsNonPrefix;
            int j;
            int k;
            boolean flag;
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
        l = 0;
        i = 0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) 
        {
label0:
            {
                s = getCursorValue(cursor, "suggest_intent_extra_data", null);
                if (!com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION.name().equals(s))
                {
                    j = l;
                    k = i;
                    if (!com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
                    {
                        break label0;
                    }
                }
                l++;
                j = l;
                k = i;
                if (getCursorValue(cursor, "suggest_log_is_xcat", "0").equals("1"))
                {
                    k = i + 1;
                    j = l;
                }
            }
            cursor.moveToNext();
            l = j;
            i = k;
        }
        isslogger.set(Field.Size, l);
        isslogger.set(Field.XcatSize, i);
        isslogger.set(Field.Prefix, s3);
        return isslogger.getIssEngagementData();
    }

    public static Map createLogData(Cursor cursor, String s, String s1)
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
        int i1 = 0;
        int l = 0;
        int j1 = 0;
        int j = 0;
        boolean flag1 = false;
        boolean flag = false;
        int k1 = 0;
        int k = 0;
        int l1 = 0;
        int i = 0;
        if (cursor != null)
        {
            cursor.moveToFirst();
label0:
            do
            {
label1:
                {
                    i1 = l;
                    flag1 = flag;
                    j1 = j;
                    k1 = k;
                    l1 = i;
                    if (cursor.isAfterLast())
                    {
                        break label0;
                    }
                    s = getCursorValue(cursor, "suggest_intent_extra_data", null);
                    if (!com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.A9_SUGGESTION.name().equals(s))
                    {
                        flag1 = flag;
                        i1 = j;
                        j1 = k;
                        k1 = i;
                        if (!com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED.name().equals(s))
                        {
                            break label1;
                        }
                    }
                    l1 = 1;
                    int i2 = k + 1;
                    k = i;
                    if (getCursorValue(cursor, "suggest_log_is_xcat", "0").equals("1"))
                    {
                        k = i + 1;
                    }
                    if (i2 == 1)
                    {
                        if (!s1.equals(getCursorValue(cursor, "suggest_log_query", "")))
                        {
                            j = 1;
                        } else
                        {
                            j = 0;
                        }
                    }
                    l = l1;
                    flag1 = flag;
                    i1 = j;
                    j1 = i2;
                    k1 = k;
                    if (j == 0)
                    {
                        l = l1;
                        flag1 = flag;
                        i1 = j;
                        j1 = i2;
                        k1 = k;
                        if (!flag)
                        {
                            flag1 = getCursorValue(cursor, "suggest_text_1", "").contains(s1);
                            k1 = k;
                            j1 = i2;
                            i1 = j;
                            l = l1;
                        }
                    }
                }
                cursor.moveToNext();
                flag = flag1;
                j = i1;
                k = j1;
                i = k1;
            } while (true);
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
        if (flag1)
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

    public static String getCursorValue(Cursor cursor, String s, String s1)
    {
        int i;
        if (cursor != null && !TextUtils.isEmpty(s))
        {
            if ((i = cursor.getColumnIndex(s)) >= 0)
            {
                return cursor.getString(i);
            }
        }
        return s1;
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
