// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import com.groupon.db.GrouponOrmLiteHelper;
import java.sql.SQLException;
import javax.inject.Provider;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoProvider
    implements Provider
{

    private Application application;
    private Class clazz;
    private GrouponBaseDao dao;
    private GrouponOrmLiteHelper helper;

    public DaoProvider(Class class1)
    {
        clazz = class1;
    }

    public GrouponBaseDao get()
    {
        if (dao != null)
        {
            return dao;
        }
        GrouponBaseDao grouponbasedao;
        try
        {
            dao = (GrouponBaseDao)helper.getDao(clazz);
            dao.setApplication(application);
            grouponbasedao = dao;
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return grouponbasedao;
    }

    public volatile Object get()
    {
        return get();
    }
}
