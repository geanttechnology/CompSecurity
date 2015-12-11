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
import org.codehaus.jackson.JsonFactory;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class AbstractSyncManagerProcess
{

    protected Context context;
    DaoPagination daoPagination;
    protected String dbChannel;
    protected JsonFactory jsonFactory;
    protected ObjectMapperWrapper mapper;

    public AbstractSyncManagerProcess(Context context1, String s)
    {
        context = context1;
        dbChannel = s;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public void doDatabaseWorkOnNetworkError(UniversalInfo universalinfo)
        throws Exception
    {
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return new Object[0];
    }

    public abstract String getSyncUrl(UniversalInfo universalinfo);

    public abstract boolean isThrowingErrorOnException();

    public abstract long lastUpdated()
        throws Exception;

    public void startDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        Pagination pagination = new Pagination();
        pagination.setChannel(dbChannel);
        daoPagination.create(pagination);
        triggerDatabaseTask(inputstream, obj, universalinfo);
    }

    public abstract void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception;

    public abstract Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception;

    public InputStream triggerSync(UniversalInfo universalinfo)
        throws Exception
    {
        try
        {
            universalinfo = (InputStream)(new SyncHttp(context, java/io/InputStream, getSyncUrl(universalinfo), getSyncQueryParams(universalinfo))).call();
        }
        // Misplaced declaration of an exception variable
        catch (UniversalInfo universalinfo)
        {
            throw universalinfo;
        }
        return universalinfo;
    }
}
