// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.List;

public class AnswerResponse
{
    public static class LabeledAnswer
    {

        public long id;
        public String impression;
        public String label;
        public List labeledItems;

        public LabeledAnswer()
        {
        }
    }

    public static class LabeledItem
    {

        public long id;
        public EbaySearchListItem item;
        public String label;
        public String tracking;
        public String typeLabel;

        public LabeledItem()
        {
        }
    }


    public List labeledAnswers;

    public AnswerResponse()
    {
    }
}
