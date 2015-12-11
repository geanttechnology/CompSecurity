// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.search;

import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.d;
import com.target.ui.util.v;

// Referenced classes of package com.target.ui.model.search:
//            a

public class b
    implements a
{

    private String mAisle;
    private CategoryId mCategoryId;
    private String mCategoryName;
    private d mDepartment;
    private EndecaId mEndecaId;
    private final String mQuery;

    public b(String s)
    {
        mQuery = s;
    }

    public String a()
    {
        return mQuery;
    }

    public void a(CategoryId categoryid)
    {
        mCategoryId = categoryid;
    }

    public void a(EndecaId endecaid)
    {
        mEndecaId = endecaid;
    }

    public void a(d d1)
    {
        mDepartment = d1;
    }

    public void a(String s)
    {
        mCategoryName = s;
    }

    public d b()
    {
        return mDepartment;
    }

    public String c()
    {
        return mCategoryName;
    }

    public e d()
    {
        return v.a(mAisle);
    }

    public e e()
    {
        return v.a(mCategoryId);
    }

    public e f()
    {
        return v.a(mEndecaId);
    }
}
