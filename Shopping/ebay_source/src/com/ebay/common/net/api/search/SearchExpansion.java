// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchExpansion
{
    public static class ExpansionResult
    {

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

        public ExpansionResult()
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

    public static class ExpansionResult.RewriteDescriptor
    {

        public String displayMessage;
        public long id;
        public boolean isPromoted;
        public boolean isRecourseType;
        public ExpansionResult.RewriteMode mode;
        public Map parameters;
        public ExpansionResult.RewriteType type;
        public String userMessage;

        public ExpansionResult.RewriteDescriptor()
        {
        }
    }

    public static final class ExpansionResult.RewriteMode extends Enum
    {

        private static final ExpansionResult.RewriteMode $VALUES[];
        public static final ExpansionResult.RewriteMode AUTORUN;
        public static final ExpansionResult.RewriteMode RECOMMENDATION;

        public static ExpansionResult.RewriteMode valueOf(String s)
        {
            return (ExpansionResult.RewriteMode)Enum.valueOf(com/ebay/common/net/api/search/SearchExpansion$ExpansionResult$RewriteMode, s);
        }

        public static ExpansionResult.RewriteMode[] values()
        {
            return (ExpansionResult.RewriteMode[])$VALUES.clone();
        }

        static 
        {
            RECOMMENDATION = new ExpansionResult.RewriteMode("RECOMMENDATION", 0);
            AUTORUN = new ExpansionResult.RewriteMode("AUTORUN", 1);
            $VALUES = (new ExpansionResult.RewriteMode[] {
                RECOMMENDATION, AUTORUN
            });
        }

        private ExpansionResult.RewriteMode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ExpansionResult.RewriteType extends Enum
    {

        private static final ExpansionResult.RewriteType $VALUES[];
        public static final ExpansionResult.RewriteType CATEGORY_CONSTRAINT;
        public static final ExpansionResult.RewriteType FITMENT;
        public static final ExpansionResult.RewriteType KEYWORD_CONSTRAINT;
        public static final ExpansionResult.RewriteType QUERY_REWRITE;
        public static final ExpansionResult.RewriteType SITE_CONSTRAINT;
        public static final ExpansionResult.RewriteType SPELL_AUTO_CORRECT;
        public static final ExpansionResult.RewriteType SPELL_CHECK;
        public static final ExpansionResult.RewriteType VERSATILE;

        public static ExpansionResult.RewriteType valueOf(String s)
        {
            return (ExpansionResult.RewriteType)Enum.valueOf(com/ebay/common/net/api/search/SearchExpansion$ExpansionResult$RewriteType, s);
        }

        public static ExpansionResult.RewriteType[] values()
        {
            return (ExpansionResult.RewriteType[])$VALUES.clone();
        }

        static 
        {
            SPELL_CHECK = new ExpansionResult.RewriteType("SPELL_CHECK", 0);
            KEYWORD_CONSTRAINT = new ExpansionResult.RewriteType("KEYWORD_CONSTRAINT", 1);
            CATEGORY_CONSTRAINT = new ExpansionResult.RewriteType("CATEGORY_CONSTRAINT", 2);
            SITE_CONSTRAINT = new ExpansionResult.RewriteType("SITE_CONSTRAINT", 3);
            SPELL_AUTO_CORRECT = new ExpansionResult.RewriteType("SPELL_AUTO_CORRECT", 4);
            QUERY_REWRITE = new ExpansionResult.RewriteType("QUERY_REWRITE", 5);
            VERSATILE = new ExpansionResult.RewriteType("VERSATILE", 6);
            FITMENT = new ExpansionResult.RewriteType("FITMENT", 7);
            $VALUES = (new ExpansionResult.RewriteType[] {
                SPELL_CHECK, KEYWORD_CONSTRAINT, CATEGORY_CONSTRAINT, SITE_CONSTRAINT, SPELL_AUTO_CORRECT, QUERY_REWRITE, VERSATILE, FITMENT
            });
        }

        private ExpansionResult.RewriteType(String s, int i)
        {
            super(s, i);
        }
    }


    public ExpansionResult expansionResult;
    public String expansionType;

    public SearchExpansion()
    {
    }
}
