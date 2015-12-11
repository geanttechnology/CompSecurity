// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.app.Application;
import android.content.Context;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.manager.UniversalInfo;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.ImageUrl;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.view.UrlImageView;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class GrouponSyncManagerProcess extends AbstractSyncManagerProcess
{
    private static class GrouponContainer
    {

        public MyGrouponItem groupon;

        private GrouponContainer()
        {
        }
    }


    protected CurrentDivisionManager currentDivisionManager;
    protected DaoMyGrouponItem daoMyGrouponItem;
    private DaoMyGrouponItemSummary daoMyGrouponItemSummary;
    protected String grouponId;
    protected LocationService locationService;
    private LoginService loginService;

    public GrouponSyncManagerProcess(Context context, String s, String s1)
    {
        super(context, s1);
        this.context = context;
        grouponId = s;
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return String.format("https:/users/%s/groupons/%s", new Object[] {
            loginService.getUserId(), grouponId
        });
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoMyGrouponItem.getLastUpdatedByGrouponId(grouponId);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (GrouponContainer)obj;
        daoMyGrouponItem.removeMyGrouponItem(grouponId);
        daoMyGrouponItemSummary.removeMyGrouponItem(grouponId);
        inputstream = ((GrouponContainer) (inputstream)).groupon;
        daoMyGrouponItem.save(inputstream);
        obj = new MyGrouponItemSummary(inputstream);
        daoMyGrouponItemSummary.save(((MyGrouponItemSummary) (obj)));
        if (Strings.notEmpty(((MyGrouponItem) (inputstream)).sidebarImageUrl))
        {
            inputstream = ((MyGrouponItem) (inputstream)).sidebarImageUrl;
        } else
        {
            inputstream = ((MyGrouponItem) (inputstream)).url;
        }
        UrlImageView.prefetch((Application)context.getApplicationContext(), new ImageUrl(inputstream));
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        inputstream = (GrouponContainer)mapper.readValue(inputstream, com/groupon/manager/sync_process/GrouponSyncManagerProcess$GrouponContainer);
        ((GrouponContainer) (inputstream)).groupon.afterJsonDeserializationPostProcessor();
        return inputstream;
    }
}
