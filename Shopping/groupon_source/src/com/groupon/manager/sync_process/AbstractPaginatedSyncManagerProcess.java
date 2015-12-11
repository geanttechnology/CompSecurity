// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.Pagination;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.sql.SQLException;
import org.codehaus.jackson.JsonFactory;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class AbstractPaginatedSyncManagerProcess
{

    protected Context context;
    DaoPagination daoPagination;
    protected String dbChannel;
    protected JsonFactory jsonFactory;
    protected ObjectMapperWrapper mapper;

    public AbstractPaginatedSyncManagerProcess(Context context1, String s)
    {
        context = context1;
        dbChannel = s;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public void doDatabaseWorkOnNetworkError(UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
    }

    public abstract int getNextOffset()
        throws Exception;

    protected int getNextOffset(String s)
        throws SQLException
    {
        s = (Pagination)daoPagination.queryForFirstEq("channel", s);
        if (s != null)
        {
            return s.getNextOffset();
        } else
        {
            return 0;
        }
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo, int i, int j)
    {
        return new Object[0];
    }

    public abstract String getSyncUrl(UniversalInfo universalinfo, int i, int j);

    public abstract boolean isThrowingErrorOnException();

    public abstract long lastUpdated()
        throws Exception;

    protected void savePagination(String s, int i, Pagination pagination, int j)
        throws SQLException
    {
        pagination.setChannel(s);
        pagination.setCurrentOffset(i);
        pagination.setNextOffset(i + j);
        boolean flag;
        if (j > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        pagination.setHasMorePages(flag);
        daoPagination.create(pagination);
    }

    public abstract void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo, int i, int j)
        throws Exception;

    public abstract Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo, int i, int j)
        throws Exception;

    public InputStream triggerSync(UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
        try
        {
            universalinfo = (InputStream)(new SyncHttp(context, java/io/InputStream, getSyncUrl(universalinfo, i, j), getSyncQueryParams(universalinfo, i, j))).call();
        }
        // Misplaced declaration of an exception variable
        catch (UniversalInfo universalinfo)
        {
            throw universalinfo;
        }
        return universalinfo;
    }
}
