// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;

public abstract class PMData
{
    public class NextMaxID
    {

        String next_max_id;
        final PMData this$0;

        public NextMaxID()
        {
            this$0 = PMData.this;
            super();
        }
    }


    public static String DATA_COL = "item";
    public static String ID_COL = "_id";

    public PMData()
    {
    }

    public void append(PMData pmdata)
    {
    }

    public void createHashAndRemoveDups()
    {
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
    }

    public String getNextPageMaxValue()
    {
        return null;
    }

}
