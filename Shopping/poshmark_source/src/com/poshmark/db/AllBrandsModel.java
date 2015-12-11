// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import com.poshmark.data_model.models.PMData;
import java.util.ArrayList;
import java.util.List;

public class AllBrandsModel extends PMData
{
    public class LastUpdateDTM
    {

        final AllBrandsModel this$0;
        public String updated_at;

        public LastUpdateDTM()
        {
            this$0 = AllBrandsModel.this;
            super();
        }
    }


    public List data;
    public LastUpdateDTM meta;

    public AllBrandsModel()
    {
        data = new ArrayList();
    }
}
