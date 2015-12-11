// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.mygroupons;

import android.app.Application;
import android.content.Context;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.MyGrouponsUpdateEvent;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.GrouponPaginatedSyncManager;
import com.groupon.manager.SyncManagerUtils;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.country.Country;
import com.groupon.models.groupons.GrouponsResponse;
import com.groupon.models.nst.GrouponPaginationImpressionExtraInfo;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ApiRequestUtil;
import com.groupon.util.IOUtils;
import com.groupon.util.ImageUrl;
import com.groupon.util.MutableInteger;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.groupon.view.UrlImageView;
import com.squareup.otto.Bus;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import roboguice.util.Strings;

public abstract class BaseMyGrouponsPaginatedSyncManager extends GrouponPaginatedSyncManager
{
    public class GrouponDeserializer extends StreamingJsonDeserializer
    {

        private MutableInteger grouponsCount;
        final BaseMyGrouponsPaginatedSyncManager this$0;

        public MyGrouponItem deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException
        {
            deserializationcontext = (MyGrouponItem)internalMapper.readValue(jsonparser, com/groupon/db/models/mygroupons/MyGrouponItem);
            deserializationcontext.afterJsonDeserializationPostProcessor();
            deserializationcontext.category = grouponCategory;
            if (!Strings.isEmpty(((MyGrouponItem) (deserializationcontext)).remoteId)) goto _L2; else goto _L1
_L1:
            deserializationcontext.remoteId = String.format("%s_%d", new Object[] {
                "groupon_item_internal_id", Integer.valueOf(grouponsCount.get())
            });
            if (Strings.equals(((MyGrouponItem) (deserializationcontext)).status, "failed"))
            {
                grouponItemDao.save(deserializationcontext);
            }
_L3:
            jsonparser = new MyGrouponItemSummary(deserializationcontext);
            grouponItemSummaryDao.save(jsonparser);
            jsonparser = ((MyGrouponItem) (deserializationcontext)).sidebarImageUrl;
            if (!Strings.notEmpty(jsonparser))
            {
                break MISSING_BLOCK_LABEL_185;
            }
_L4:
            UrlImageView.prefetch((Application)
// JavaClassFileOutputException: get_constant: invalid tag

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public GrouponDeserializer(MutableInteger mutableinteger)
        {
            this$0 = BaseMyGrouponsPaginatedSyncManager.this;
            super();
            grouponsCount = mutableinteger;
        }
    }


    public static final int GROUPONS_DEFAULT_PAGE_SIZE = 20;
    public static final String GROUPONS_WITH_OFFSET_AND_LIMIT_URL = "https:/users/%1$s/groupons?offset=%2$s&limit=%3$s";
    public static final String MY_GROUPONS_PAGINATION = "mygroupons_pagination";
    public static final String PARAM_SORT_ATTRIBUTE = "sort_attribute";
    public static final String PARAM_SORT_ORDER = "sort_order";
    public static final String PARAM_TYPE = "type";
    public static final String SORT_ATTRIBUTE_EXPIRES_AT = "expires_at";
    public static final String SORT_ATTRIBUTE_PURCHASED_AT = "purchased_at";
    public static final String SORT_ORDER_ASCENDING = "ascending";
    public static final String SORT_ORDER_DESCENDING = "descending";
    public static final String TYPE_ALL = "all";
    public static final String TYPE_AVAILABLE = "available";
    public static final String TYPE_USABLE = "usable";
    private CurrentCountryManager currentCountryManager;
    private Bus globalBus;
    protected String grouponCategory;
    protected DaoMyGrouponItem grouponItemDao;
    protected DaoMyGrouponItemSummary grouponItemSummaryDao;
    private ObjectMapperWrapper internalMapper;
    protected Logger logger;
    private LoginService loginService;
    protected DaoPagination paginationDao;

    public BaseMyGrouponsPaginatedSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, String s)
    {
        GrouponPaginatedSyncManager(context, pausablethreadpoolexecutor);
        grouponCategory = s;
        setFirstPageSize(20);
        setSubsequencePageSize(20);
    }

    public BaseMyGrouponsPaginatedSyncManager(Context context, String s)
    {
        GrouponPaginatedSyncManager(context);
        grouponCategory = s;
        setFirstPageSize(20);
        setSubsequencePageSize(20);
    }

    protected abstract void appendCategoryRelatedParams(List list);

    protected ObjectMapper createSyncManager(MutableInteger mutableinteger)
    {
        ObjectMapper objectmapper = new ObjectMapper();
        SimpleModule simplemodule = new SimpleModule("GrouponDeserializerModule", new Version(1, 0, 0, null));
        simplemodule.addDeserializer(com/groupon/db/models/mygroupons/MyGrouponItem, new GrouponDeserializer(mutableinteger));
        objectmapper.registerModule(simplemodule);
        return objectmapper;
    }

    protected volatile void doSync(Object obj, int i, int j)
        throws Exception
    {
        doSync((Void)obj, i, j);
    }

    protected void doSync(final Void inputStream, final int offset, int i)
        throws Exception
    {
        final MutableInteger grouponsCount;
        final ObjectMapper mapper;
        if (!loginService.isLoggedIn())
        {
            return;
        }
        logPaginationImpresion(offset);
        inputStream = new ArrayList();
        inputStream.addAll(Arrays.asList(new String[] {
            "include_purchased_gifts", "true"
        }));
        appendCategoryRelatedParams(inputStream);
        inputStream.addAll(ApiRequestUtil.generateGETGrouponsParameters(currentCountryManager.getCurrentCountry().isJapan(), currentCountryManager.getCurrentCountry().isUSACompatible()));
        grouponsCount = String.format("https:/users/%1$s/groupons?offset=%2$s&limit=%3$s", new Object[] {
            loginService.getUserId(), Integer.valueOf(offset), Integer.valueOf(i)
        });
        inputStream = (InputStream)(new SyncHttp(context, java/io/InputStream, grouponsCount, inputStream.toArray())).call();
        grouponsCount = new MutableInteger(0);
        mapper = createSyncManager(grouponsCount);
        grouponsCount.set(0);
        grouponItemDao.callBatchTasks(new Callable() {

            final BaseMyGrouponsPaginatedSyncManager this$0;
            final MutableInteger val$grouponsCount;
            final InputStream val$inputStream;
            final ObjectMapper val$mapper;
            final int val$offset;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                SyncManagerUtils.deleteRecordsForChannel(paginationDao, grouponCategory);
                if (offset == 0)
                {
                    grouponItemDao.deleteRecordsForCategory(grouponCategory);
                    grouponItemSummaryDao.deleteRecordsForCategory(grouponCategory);
                }
                Pagination pagination = ((GrouponsResponse)mapper.readValue(inputStream, com/groupon/models/groupons/GrouponsResponse)).pagination;
                if (pagination != null)
                {
                    pagination.setChannel(grouponCategory);
                    pagination.setCurrentOffset(offset);
                    pagination.setNextOffset(offset + grouponsCount.get());
                    boolean flag;
                    if (grouponsCount.get() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    pagination.setHasMorePages(flag);
                    paginationDao.create(pagination);
                }
                return null;
            }

            
            {
                this$0 = BaseMyGrouponsPaginatedSyncManager.this;
                offset = i;
                mapper = objectmapper;
                inputStream = inputstream;
                grouponsCount = mutableinteger;
                super();
            }
        });
        globalBus.post(new MyGrouponsUpdateEvent(grouponCategory, grouponsCount.get()));
        IOUtils.close(inputStream);
        return;
        Exception exception;
        exception;
        IOUtils.close(inputStream);
        throw exception;
    }

    protected int getNextOffset()
        throws Exception
    {
        Pagination pagination = (Pagination)paginationDao.queryForFirstEq("channel", grouponCategory);
        if (pagination != null)
        {
            return pagination.getNextOffset();
        } else
        {
            return 0;
        }
    }

    public void init()
    {
    }

    protected long lastUpdated()
        throws Exception
    {
        return 0L;
    }

    protected void logPaginationImpresion(int i)
    {
        logger.logImpression("", "mygroupons_pagination", "mygroupons", Strings.toString(Integer.valueOf(i / 15 + 1)), new GrouponPaginationImpressionExtraInfo(grouponCategory));
    }


}
