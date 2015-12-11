// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchExpansion

public static class isRecoursable
{
    public static class RewriteDescriptor
    {

        public String displayMessage;
        public long id;
        public boolean isPromoted;
        public boolean isRecourseType;
        public RewriteMode mode;
        public Map parameters;
        public RewriteType type;
        public String userMessage;

        public RewriteDescriptor()
        {
        }
    }

    public static final class RewriteMode extends Enum
    {

        private static final RewriteMode $VALUES[];
        public static final RewriteMode AUTORUN;
        public static final RewriteMode RECOMMENDATION;

        public static RewriteMode valueOf(String s)
        {
            return (RewriteMode)Enum.valueOf(com/ebay/common/net/api/search/SearchExpansion$ExpansionResult$RewriteMode, s);
        }

        public static RewriteMode[] values()
        {
            return (RewriteMode[])$VALUES.clone();
        }

        static 
        {
            RECOMMENDATION = new RewriteMode("RECOMMENDATION", 0);
            AUTORUN = new RewriteMode("AUTORUN", 1);
            $VALUES = (new RewriteMode[] {
                RECOMMENDATION, AUTORUN
            });
        }

        private RewriteMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class RewriteType extends Enum
    {

        private static final RewriteType $VALUES[];
        public static final RewriteType CATEGORY_CONSTRAINT;
        public static final RewriteType FITMENT;
        public static final RewriteType KEYWORD_CONSTRAINT;
        public static final RewriteType QUERY_REWRITE;
        public static final RewriteType SITE_CONSTRAINT;
        public static final RewriteType SPELL_AUTO_CORRECT;
        public static final RewriteType SPELL_CHECK;
        public static final RewriteType VERSATILE;

        public static RewriteType valueOf(String s)
        {
            return (RewriteType)Enum.valueOf(com/ebay/common/net/api/search/SearchExpansion$ExpansionResult$RewriteType, s);
        }

        public static RewriteType[] values()
        {
            return (RewriteType[])$VALUES.clone();
        }

        static 
        {
            SPELL_CHECK = new RewriteType("SPELL_CHECK", 0);
            KEYWORD_CONSTRAINT = new RewriteType("KEYWORD_CONSTRAINT", 1);
            CATEGORY_CONSTRAINT = new RewriteType("CATEGORY_CONSTRAINT", 2);
            SITE_CONSTRAINT = new RewriteType("SITE_CONSTRAINT", 3);
            SPELL_AUTO_CORRECT = new RewriteType("SPELL_AUTO_CORRECT", 4);
            QUERY_REWRITE = new RewriteType("QUERY_REWRITE", 5);
            VERSATILE = new RewriteType("VERSATILE", 6);
            FITMENT = new RewriteType("FITMENT", 7);
            $VALUES = (new RewriteType[] {
                SPELL_CHECK, KEYWORD_CONSTRAINT, CATEGORY_CONSTRAINT, SITE_CONSTRAINT, SPELL_AUTO_CORRECT, QUERY_REWRITE, VERSATILE, FITMENT
            });
        }

        private RewriteType(String s, int i)
        {
            super(s, i);
        }
    }


    public long abridgedMatchCount;
    public String instanceName;
    public boolean isAutoRun;
    public boolean isRecoursable;
    public long matchCount;
    public String metaAttributeNames[];
    public String metaAttributeValues[];
    public Map metaAttributes;
    public boolean promotedToPrimary;
    public String recoveryType;
    public RewriteDescriptor rewriteDescriptor;
    public ArrayList searchRecords;
    public List uvccCategories;
    public long uvccCategoryId;

    public RewriteType()
    {
        isAutoRun = false;
        promotedToPrimary = false;
        recoveryType = null;
        abridgedMatchCount = 0L;
        matchCount = 0L;
        metaAttributeNames = null;
        metaAttributeValues = null;
        metaAttributes = new HashMap();
        searchRecords = new ArrayList();
        uvccCategoryId = 0L;
        uvccCategories = null;
        rewriteDescriptor = null;
        isRecoursable = false;
    }
}
