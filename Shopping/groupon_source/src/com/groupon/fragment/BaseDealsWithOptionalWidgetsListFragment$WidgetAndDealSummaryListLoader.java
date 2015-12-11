// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.models.EndlessList;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealCardListLoader, BaseDealsWithOptionalWidgetsListFragment, DataTransformer

protected static class dataTransformer extends DealCardListLoader
{

    private DataTransformer dataTransformer;
    private String pagerChannel;
    private DaoWidgetSummary widgetDao;
    private boolean widgetsSupported;

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj;
        EndlessList endlesslist;
        Object obj1;
        try
        {
            endlesslist = (EndlessList)super.loadInBackground();
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        if (endlesslist == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (widgetsSupported && endlesslist.size() > 0)
        {
            obj = widgetDao.queryBuilder();
            obj1 = pagerChannel;
            ((QueryBuilder) (obj)).where().between("channel", obj1, (new StringBuilder()).append(((String) (obj1))).append("~").toString());
            obj = ((QueryBuilder) (obj)).prepare();
            obj = widgetDao.query(((com.j256.ormlite.stmt.PreparedQuery) (obj)));
        } else
        {
            obj = new ArrayList();
        }
        obj1 = new ArrayList();
        if (dataTransformer != null)
        {
            dataTransformer.transform(endlesslist, ((List) (obj)), ((List) (obj1)));
        }
        return new dataTransformer(endlesslist, ((List) (obj)), ((List) (obj1)));
        return null;
    }

    public (Class class1, Class class2, Context context, String s, String s1, boolean flag, DataTransformer datatransformer)
    {
        super(class1, class2, context, s);
        widgetsSupported = flag;
        pagerChannel = s1;
        dataTransformer = datatransformer;
    }
}
