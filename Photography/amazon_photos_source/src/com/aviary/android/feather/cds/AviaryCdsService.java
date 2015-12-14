// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amazon.gallery.framework.aspect.AviaryCdsAspect;
import com.aviary.android.feather.cds.billing.util.IabException;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Inventory;
import com.aviary.android.feather.cds.json.CdsContentParser;
import com.aviary.android.feather.cds.json.CdsManifestParser;
import com.aviary.android.feather.cds.json.CdsMessageContentParser;
import com.aviary.android.feather.common.AviaryIntent;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import com.aviary.android.feather.common.threading.ThreadPool;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.BatteryUtils;
import com.aviary.android.feather.common.utils.ConnectionUtils;
import com.aviary.android.feather.common.utils.DateTimeUtils;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.SDKUtils;
import com.aviary.android.feather.common.utils.ScreenUtils;
import com.aviary.android.feather.common.utils.StringUtils;
import com.aviary.android.feather.common.utils.os.AviaryIntentService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.http.message.BasicNameValuePair;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.Factory;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsReceiver, CdsUtils, RestoreAllHelper, IAPWrapper, 
//            AviaryCdsAssetsDownloaderService

public final class AviaryCdsService extends AviaryIntentService
    implements com.aviary.android.feather.cds.billing.util.IabHelper.OnIabSetupFinishedListener
{
    public static class RestoreException extends Exception
    {

        static final int CODE_DOWNLOAD_REQUEST_ERROR = 8;
        static final int CODE_ERROR_CURSOR_EMPTY = 2;
        static final int CODE_ERROR_IAB_EXCEPTION = 1;
        static final int CODE_HTTP_EXCEPTION = 4;
        static final int CODE_ICON_ERROR = 7;
        static final int CODE_JSON_EXCEPTION = 3;
        static final int CODE_RESTORE_OWNED_ERROR = 6;
        static final int CODE_UNKNOWN_ERROR = 5;
        private static final long serialVersionUID = 1L;
        private int code;

        public int getCode()
        {
            return code;
        }

        public String getLocalizedMessage()
        {
            String s;
            if (getCause() != null)
            {
                s = getCause().getLocalizedMessage();
            } else
            {
                s = super.getLocalizedMessage();
            }
            return (new StringBuilder()).append(s).append(" (ErrorCode: ").append(code).append(")").toString();
        }

        public RestoreException(int i, String s)
        {
            super(s);
            code = i;
        }

        RestoreException(int i, Throwable throwable)
        {
            super(throwable);
            code = i;
        }
    }


    public static final String CONTENT_GROUP_NAME = "content-group-name";
    public static final String CONTENT_GROUP_UPDATE_TIME = "content-group-update-time";
    private static final String CONTENT_PATH = "/content?";
    public static final String KEY_ACTION = "action";
    public static final String KEY_DATA = "data";
    public static final String KEY_ENTRY_ID = "entryId";
    public static final String KEY_IDENTIFIER = "identifier";
    private static final String MANIFEST_PATH = "/manifest?";
    private static final int MAX_RETRY_COUNT = 1;
    public static final long MINIMUM_TIME_DIFF = 0x1b77400L;
    private static final Object M_WRITE_DISK_LOCK = new Object();
    private static final String PREF_LAST_EXECUTION_TIME = "last-execution-time";
    private static final long RETRY_DELAY_TIME = 15000L;
    private static final String SERVER_ROOT_PRODUCTION = "http://cd.aviary.com/v1";
    private static final String SERVER_ROOT_STAGING = "http://cd-lb.aviary.com/v1";
    private static final String SERVER_ROOT_TEST = "http://cd-test.aviary.com:1338/v1";
    private static final ThreadPool THREAD_POOL = new ThreadPool(10, 10);
    private static final org.aspectj.lang.JoinPoint.StaticPart ajc$tjp_0;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private static String mApiKey;
    private static String mApiKeySecret;
    private static String mBillingPublicKey;
    private static boolean mDebugVersion;
    private static String mFormFactor;
    private static long mLastUpdateDateTime = 0L;
    private static String mResolution;
    private static String mServerRoot;
    private static int sTryAgainCount = 1;
    private String mContentGroup;
    private String mCountry;
    private IabResult mIabResult;
    private final Object mIapObjectLock = new Object();
    private IAPWrapper mIapWrapper;
    private String mLanguage;
    private final Locale mLocale = Locale.getDefault();
    private SharedPreferences mPreferences;

    public AviaryCdsService()
    {
        super("AviaryCdsService");
    }

    public static void addAlarm(Context context, long l, Intent intent)
    {
        logger.info("addAlarm: %d", new Object[] {
            Long.valueOf(l)
        });
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(l));
        intent = PendingIntent.getService(context, 0, intent, 0x8000000);
        ((AlarmManager)context.getSystemService("alarm")).set(0, calendar.getTimeInMillis(), intent);
    }

    private static void ajc$preClinit()
    {
        Factory factory = new Factory("AviaryCdsService.java", com/aviary/android/feather/cds/AviaryCdsService);
        ajc$tjp_0 = factory.makeSJP("method-execution", factory.makeMethodSig("2", "handleKeys", "com.aviary.android.feather.cds.AviaryCdsService", "android.content.Intent", "intent", "", "void"), 601);
    }

    private void cancelAlarms()
    {
        Context context = getBaseContext();
        AlarmManager alarmmanager = (AlarmManager)getBaseContext().getSystemService("alarm");
        Intent intent = new Intent(context, com/aviary/android/feather/cds/AviaryCdsService);
        intent.setAction("aviary.intent.action.CDS_DOWNLOAD_START");
        alarmmanager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0x8000000));
        alarmmanager.cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, com/aviary/android/feather/cds/AviaryCdsReceiver), 0x8000000));
    }

    private void checkProviderExists(Context context)
        throws AssertionError
    {
        context = getContentResolver().getType(PackageManagerUtils.getCDSProviderContentUri(context, null));
        if (context == null)
        {
            LoggerFactory.printDeveloperError("'AviaryCdsProvider' not found. Did you forget to include it in your AndroidManifest.xml file?");
        }
        Assert.assertNotNull(context);
    }

    private com.aviary.android.feather.common.threading.ThreadPool.Job createDownloadJob()
    {
        return new com.aviary.android.feather.common.threading.ThreadPool.Job() {

            final AviaryCdsService this$0;

            public transient InputStream run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, String as[])
                throws Exception
            {
                return IOUtils.download(as[0], null);
            }

            public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
                throws Exception
            {
                return run(worker, (String[])aobj);
            }

            
            {
                this$0 = AviaryCdsService.this;
                super();
            }
        };
    }

    private com.aviary.android.feather.common.threading.ThreadPool.Job createDownloadJob(final Context context, boolean flag)
    {
        if (!flag)
        {
            return createDownloadJob();
        } else
        {
            return new com.aviary.android.feather.common.threading.ThreadPool.Job() {

                WeakReference mContext;
                final AviaryCdsService this$0;
                final Context val$context;

                public transient InputStream run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, String as[])
                    throws Exception
                {
                    if (!AviaryCdsService.isConnected((Context)mContext.get()))
                    {
                        throw new IOException("Could not run the Job without wifi connection");
                    } else
                    {
                        return IOUtils.download(as[0], null);
                    }
                }

                public volatile Object run(com.aviary.android.feather.common.threading.ThreadPool.Worker worker, Object aobj[])
                    throws Exception
                {
                    return run(worker, (String[])aobj);
                }

            
            {
                this$0 = AviaryCdsService.this;
                context = context1;
                super();
                mContext = new WeakReference(context);
            }
            };
        }
    }

    private String getApiKey()
    {
        if (mApiKey == null)
        {
            mApiKey = SDKUtils.getApiKey(getBaseContext());
        }
        return mApiKey;
    }

    private String getContentURL(String s)
    {
        StringBuilder stringbuilder = new StringBuilder(mServerRoot);
        stringbuilder.append("/content?").append("versionKey=").append(s);
        if (hasLanguageParam())
        {
            stringbuilder.append("&language=");
            stringbuilder.append(getLanguage());
        }
        if (mDebugVersion)
        {
            stringbuilder.append("&staging=2");
        }
        return stringbuilder.toString();
    }

    private String getContentURL(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder(mServerRoot);
        stringbuilder.append("/content?").append("formatListId=").append(s1).append("&identifier=").append(s);
        if (hasLanguageParam())
        {
            stringbuilder.append("&language=").append(getLanguage());
        }
        if (mDebugVersion)
        {
            stringbuilder.append("&staging=2");
        }
        return stringbuilder.toString();
    }

    private String getFormFactor()
    {
        if (mFormFactor == null)
        {
            String s;
            if (ScreenUtils.isTablet(getBaseContext()))
            {
                s = "tablet";
            } else
            {
                s = "phone";
            }
            mFormFactor = s;
        }
        return mFormFactor;
    }

    private String getManifestURL()
    {
        return (new StringBuilder()).append(mServerRoot).append("/manifest?").toString();
    }

    private List getManifestURLParams(String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("apiKey", getApiKey()));
        arraylist.add(new BasicNameValuePair("formFactor", getFormFactor()));
        arraylist.add(new BasicNameValuePair("osVersion", String.valueOf(android.os.Build.VERSION.SDK_INT)));
        arraylist.add(new BasicNameValuePair("platform", "android"));
        arraylist.add(new BasicNameValuePair("resolution", getResolution()));
        arraylist.add(new BasicNameValuePair("sdkVersion", "3.6.2"));
        arraylist.add(new BasicNameValuePair("contentGroup", getContentGroup()));
        if (hasCountryParam())
        {
            arraylist.add(new BasicNameValuePair("country", getCountry()));
        }
        if (hasLanguageParam())
        {
            arraylist.add(new BasicNameValuePair("language", getLanguage()));
        }
        if (s != null)
        {
            arraylist.add(new BasicNameValuePair("versionKey", s));
        }
        return arraylist;
    }

    private String getResolution()
    {
        if (mResolution == null)
        {
            mResolution = CdsUtils.getResolution(getBaseContext());
        }
        return mResolution;
    }

    private void handleKeys(Intent intent)
    {
        JoinPoint joinpoint = Factory.makeJP(ajc$tjp_0, this, this, intent);
        AviaryCdsAspect.aspectOf().invokeHandleKeys((new AjcClosure1(new Object[] {
            this, intent, joinpoint
        })).linkClosureAndJoinPoint(0x11010));
    }

    static final void handleKeys_aroundBody0(AviaryCdsService aviarycdsservice, Intent intent, JoinPoint joinpoint)
    {
        if (mApiKeySecret == null && intent != null)
        {
            mApiKeySecret = intent.getStringExtra("extra-api-key-secret");
        }
        if (mBillingPublicKey == null && intent != null)
        {
            mBillingPublicKey = intent.getStringExtra("extra-billing-public-key");
        }
        if ((TextUtils.isEmpty(mApiKeySecret) || TextUtils.isEmpty(mBillingPublicKey)) && PackageManagerUtils.isStandalone(aviarycdsservice.getBaseContext()))
        {
            aviarycdsservice = SDKUtils.getKeys(aviarycdsservice.getBaseContext());
            mApiKeySecret = aviarycdsservice[1];
            mBillingPublicKey = aviarycdsservice[2];
        }
    }

    static boolean isConnected(Context context)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (context != null)
        {
            flag = flag1;
            if (ConnectionUtils.isConnected(context, false, new int[] {
    1, 6
}))
            {
                flag = true;
            }
        }
        return flag;
    }

    private void onAddNewJsonContent(Context context, CdsContentParser cdscontentparser, int i, int j, String s)
        throws AssertionError
    {
        logger.info(">> onAddNewJsonContent");
        Assert.assertNotNull(cdscontentparser);
        ContentValues contentvalues;
        boolean flag;
        if (cdscontentparser.getCode() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("Invalid Error Code", flag);
        if (!TextUtils.isEmpty(cdscontentparser.getIdentifier()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("Identifier is null", flag);
        logger.log("adding: %s", new Object[] {
            cdscontentparser.getDisplayName()
        });
        if (CdsUtils.getPackByIdentifier(context, cdscontentparser.getIdentifier(), new String[] {
    "pack_id"
}) == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("pack already exists in the database", flag);
        context = new ArrayList();
        contentvalues = new ContentValues();
        contentvalues.put("pack_identifier", cdscontentparser.getIdentifier());
        contentvalues.put("pack_type", cdscontentparser.getPackType());
        contentvalues.put("pack_versionKey", cdscontentparser.getVersionKey());
        contentvalues.put("pack_displayOrder", Integer.valueOf(i));
        contentvalues.put("pack_visible", Integer.valueOf(j));
        context.add(contentvalues);
        contentvalues = new ContentValues();
        contentvalues.put("content_previewURL", (new StringBuilder()).append(s).append(cdscontentparser.getPreviewURL()).toString());
        contentvalues.put("content_previewVersion", cdscontentparser.getPreviewVersion());
        contentvalues.put("content_contentURL", (new StringBuilder()).append(s).append(cdscontentparser.getContentURL()).toString());
        contentvalues.put("content_contentVersion", cdscontentparser.getContentVersion());
        contentvalues.put("content_iconUrl", (new StringBuilder()).append(s).append(cdscontentparser.getIconURL()).toString());
        contentvalues.put("content_iconVersion", cdscontentparser.getIconVersion());
        if (cdscontentparser.isFree())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        contentvalues.put("content_isFree", Integer.valueOf(i));
        contentvalues.put("content_purchased", Integer.valueOf(0));
        contentvalues.put("content_iconNeedDownload", Integer.valueOf(1));
        contentvalues.put("content_displayName", cdscontentparser.getDisplayName());
        contentvalues.put("content_displayDescription", cdscontentparser.getDisplayDescription());
        contentvalues.put("content_numItems", Integer.valueOf(cdscontentparser.getItems().size()));
        contentvalues.put("content_author", cdscontentparser.getAuthor());
        contentvalues.put("content_authorHyperlink", cdscontentparser.getAuthorHyperlink());
        contentvalues.put("content_socialMediaString", cdscontentparser.getSocialMediaString());
        contentvalues.put("content_shopBackgroundColor", cdscontentparser.getShopBackgroundColor());
        if (!TextUtils.isEmpty(cdscontentparser.getFeatureImageURL()))
        {
            contentvalues.put("content_featureImageURL", (new StringBuilder()).append(s).append(cdscontentparser.getFeatureImageURL()).toString());
            contentvalues.put("content_featureImageVersion", cdscontentparser.getFeatureImageVersion());
        }
        if (!TextUtils.isEmpty(cdscontentparser.getDetailImageURL()))
        {
            contentvalues.put("content_detailImageURL", (new StringBuilder()).append(s).append(cdscontentparser.getDetailImageURL()).toString());
            contentvalues.put("content_detailImageVersion", cdscontentparser.getDetailImageVersion());
        }
        context.add(contentvalues);
        ContentValues contentvalues1;
        for (cdscontentparser = cdscontentparser.getItems().iterator(); cdscontentparser.hasNext(); context.add(contentvalues1))
        {
            s = (com.aviary.android.feather.cds.json.CdsContentParser.ContentItem)cdscontentparser.next();
            contentvalues1 = new ContentValues();
            contentvalues1.put("item_identifier", s.getIdentifier());
            contentvalues1.put("item_displayName", s.getDisplayName());
            if (s.getOptions() != null)
            {
                contentvalues1.put("item_options", s.getOptions());
            }
        }

        context = (ContentValues[])context.toArray(new ContentValues[context.size()]);
        if (getContentResolver().bulkInsert(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "bulk/insertPackContentAndItems"), context) > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
    }

    private void onAddNewJsonContent(Context context, InputStream inputstream, int i, int j, String s)
        throws JSONException, IOException, AssertionError
    {
        CdsContentParser cdscontentparser = new CdsContentParser();
        if (cdscontentparser.parse(inputstream) != 0)
        {
            throw new JSONException(cdscontentparser.getStatus());
        } else
        {
            onAddNewJsonContent(context, cdscontentparser, i, j, s);
            return;
        }
    }

    private void onAddNewMessageContent(Context context, InputStream inputstream, String s, String s1)
        throws JSONException, IOException, AssertionError
    {
        logger.info(">> onAddNewMessageContent");
        CdsMessageContentParser cdsmessagecontentparser = new CdsMessageContentParser();
        if (cdsmessagecontentparser.parse(inputstream) != 0)
        {
            throw new JSONException(cdsmessagecontentparser.getStatus());
        }
        long l = cdsmessagecontentparser.getBeginDate();
        long l1 = cdsmessagecontentparser.getEndDate();
        if (l1 < System.currentTimeMillis())
        {
            logger.warn("message already expired. Skipping..");
            logger.verbose("beginDate: %d", new Object[] {
                Long.valueOf(l)
            });
            logger.verbose("endDate: %d", new Object[] {
                Long.valueOf(l1)
            });
        } else
        if (CdsUtils.getMessageByIdentifier(context, cdsmessagecontentparser.getIdentifier(), new String[] {
    "msg_id"
}) == null)
        {
            inputstream = new ContentValues();
            inputstream.put("msg_identifier", cdsmessagecontentparser.getIdentifier());
            inputstream.put("msg_versionKey", cdsmessagecontentparser.getVersionKey());
            inputstream.put("msg_type", s);
            s = new ContentValues();
            int i;
            boolean flag;
            if (cdsmessagecontentparser.isSplitButton())
            {
                context = cdsmessagecontentparser.getActionButtonText();
            } else
            {
                context = null;
            }
            s.put("msgcnt_actionButton", context);
            s.put("msgcnt_beginDate", DateTimeUtils.toSqlDateTime(cdsmessagecontentparser.getBeginDate()));
            s.put("msgcnt_contentIdentifier", cdsmessagecontentparser.getContentIdentifier());
            s.put("msgcnt_contentURL", (new StringBuilder()).append(s1).append(cdsmessagecontentparser.getContentURL()).toString());
            s.put("msgcnt_dismissButton", cdsmessagecontentparser.getDismissButtonText());
            s.put("msgcnt_endDate", DateTimeUtils.toSqlDateTime(cdsmessagecontentparser.getEndDate()));
            s.put("msgcnt_layoutStyle", cdsmessagecontentparser.getLayoutStyle());
            s.put("msgcnt_paragraph", cdsmessagecontentparser.getParagraph());
            if (cdsmessagecontentparser.isShowNewBanner())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            s.put("msgcnt_showNewBanner", Integer.valueOf(i));
            s.put("msgcnt_title", cdsmessagecontentparser.getTitle());
            if (getContentResolver().bulkInsert(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "bulk/insertMessageAndContent"), new ContentValues[] {
    inputstream, s
}) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Assert.assertTrue(flag);
            return;
        }
    }

    private boolean onChangePackVisibility(long l, int i)
    {
        logger.info(">> onChangePackVisibility: %d, visibility: %d", new Object[] {
            Long.valueOf(l), Integer.valueOf(i)
        });
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("pack_visible", Integer.valueOf(i));
        return getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(l).append("/update").toString()), contentvalues, null, null) > 0;
    }

    private void onClearPermissions(Context context)
    {
        logger.info(">> onClearPermissions");
        ArrayList arraylist = new ArrayList();
        onUpdatePermissions(context, arraylist, StringUtils.hashCode(arraylist));
    }

    private void onDownloadStart(boolean flag)
        throws IOException, JSONException
    {
        InputStream inputstream;
        Context context;
        logger.info(">> onDownloadStart (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        long l = System.currentTimeMillis();
        logger.log("time passed: %s", new Object[] {
            DurationFormatUtils.formatDurationHMS(l - mLastUpdateDateTime)
        });
        if (l - mLastUpdateDateTime < 7000L)
        {
            logger.warn("wait at least 7secs before start downloading again");
            return;
        }
        context = getBaseContext();
        if (context == null)
        {
            logger.error("invalid context");
            return;
        }
        inputstream = downloadManifest(context, flag);
        onParseManifest(context, inputstream, flag);
        IOUtils.closeSilently(inputstream);
        return;
        Exception exception;
        exception;
        IOUtils.closeSilently(inputstream);
        throw exception;
    }

    private boolean onHideUnavailablePacks(CdsManifestParser cdsmanifestparser)
    {
        Cursor cursor;
        logger.info(">> onHideUnavailablePacks");
        if (!cdsmanifestparser.hasContent() || !cdsmanifestparser.hasEnabledPacks())
        {
            break MISSING_BLOCK_LABEL_235;
        }
        cursor = CdsUtils.getPacksList(getBaseContext(), new String[] {
            "pack_id", "pack_identifier", "pack_type"
        }, "pack_visible=1", null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_235;
        }
_L2:
        PacksColumns.PackCursorWrapper packcursorwrapper;
        if (!cursor.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        packcursorwrapper = PacksColumns.PackCursorWrapper.create(cursor);
        if (packcursorwrapper == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (cdsmanifestparser.containsEnabledPack(packcursorwrapper.getIdentifier()))
        {
            continue; /* Loop/switch isn't completed */
        }
        logger.warn("%s need to be hidden", new Object[] {
            packcursorwrapper.getIdentifier()
        });
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("pack_visible", Integer.valueOf(0));
        if (getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/update").toString()), contentvalues, null, null) > 0)
        {
            CdsUtils.notifyPackContentUpdate(getBaseContext(), packcursorwrapper.getId());
            CdsUtils.notifyPacksContentUpdated(getBaseContext(), packcursorwrapper.getPackType());
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_217;
        cdsmanifestparser;
        IOUtils.closeSilently(cursor);
        throw cdsmanifestparser;
        logger.error("failed to update entry. result = 0");
        if (true) goto _L2; else goto _L1
_L1:
        IOUtils.closeSilently(cursor);
        return true;
    }

    private void onParseManifest(Context context, InputStream inputstream, boolean flag)
        throws JSONException, IOException
    {
        logger.info(">> onParseManifest (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        CdsManifestParser cdsmanifestparser = new CdsManifestParser();
        if (cdsmanifestparser.parse(inputstream) != 0)
        {
            throw new JSONException(cdsmanifestparser.getStatus());
        }
        boolean flag2 = false;
        logger.log("new versionKey: %s", new Object[] {
            cdsmanifestparser.getVersionKey()
        });
        logger.log("assetsBaseURL: %s", new Object[] {
            cdsmanifestparser.getAssetsBaseURL()
        });
        logger.log("has content: %b", new Object[] {
            Boolean.valueOf(cdsmanifestparser.hasContent())
        });
        logger.log("hasPacks: %b", new Object[] {
            Boolean.valueOf(cdsmanifestparser.hasEnabledPacks())
        });
        logger.log("hasDeletedPacks: %b", new Object[] {
            Boolean.valueOf(cdsmanifestparser.hasDeletedPacks())
        });
        long l1 = System.currentTimeMillis();
        onUpdatePermissions(context, cdsmanifestparser.getPermissions(), cdsmanifestparser.getPermissionsKey());
        if (cdsmanifestparser.hasContent())
        {
            boolean flag1;
            long l;
            if (!onParsePacks(cdsmanifestparser, flag))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            l = System.currentTimeMillis();
            logger.warn("*** parse packs completed (%dms): %b ***", new Object[] {
                Long.valueOf(l - l1), Boolean.valueOf(flag2)
            });
            if (!onRageRemovePacks(cdsmanifestparser))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 |= flag1;
            l1 = System.currentTimeMillis();
            logger.warn("*** hard remove packs completed (%dms): %b ***", new Object[] {
                Long.valueOf(l1 - l), Boolean.valueOf(flag2)
            });
            if (!onParseMessages(cdsmanifestparser, flag))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 |= flag1;
            l = System.currentTimeMillis();
            logger.warn("*** parse messages completed (%dms): %b ***", new Object[] {
                Long.valueOf(l - l1), Boolean.valueOf(flag2)
            });
        } else
        {
            logger.log("manifest has no content");
        }
        l1 = System.currentTimeMillis();
        logger.error("hasException: %b", new Object[] {
            Boolean.valueOf(flag2)
        });
        if (flag2)
        {
            logger.error("something went wrong, don't update the version key");
        } else
        {
            onUpdateVersionKey(cdsmanifestparser);
            mLastUpdateDateTime = System.currentTimeMillis();
        }
        if (cdsmanifestparser.hasContent())
        {
            onHideUnavailablePacks(cdsmanifestparser);
            l = System.currentTimeMillis();
            logger.warn("*** hide unavailable packs completed (%dms): %b ***", new Object[] {
                Long.valueOf(l - l1), Boolean.valueOf(flag2)
            });
            onRemoveUnavailableMessages(cdsmanifestparser);
            l1 = System.currentTimeMillis();
            logger.warn("*** remove unavailable messages completed (%dms): %b ***", new Object[] {
                Long.valueOf(l1 - l), Boolean.valueOf(flag2)
            });
        }
        l = System.currentTimeMillis();
        onRestorePacksIcons(cdsmanifestparser.getAssetsBaseURL(), flag);
        l1 = System.currentTimeMillis();
        logger.warn("*** download pack icons completed (%dms)***", new Object[] {
            Long.valueOf(l1 - l)
        });
        CdsUtils.notifyDownloadComplete(getBaseContext());
    }

    private boolean onParseMessages(CdsManifestParser cdsmanifestparser, boolean flag)
    {
        logger.info(">> onParseMessages (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        if (!cdsmanifestparser.hasMessages()) goto _L2; else goto _L1
_L1:
        final AtomicBoolean hasException;
        final AtomicInteger files;
        final HashMap notificationMap;
        HashMap hashmap;
        Iterator iterator;
        final String assetBaseUrl;
        files = new AtomicInteger(0);
        hasException = new AtomicBoolean(false);
        hashmap = cdsmanifestparser.getMessages();
        iterator = hashmap.keySet().iterator();
        notificationMap = new HashMap();
        assetBaseUrl = cdsmanifestparser.getAssetsBaseURL();
_L11:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        final String key;
        Iterator iterator1;
        key = (String)iterator.next();
        logger.log("checking: %s", new Object[] {
            key
        });
        iterator1 = ((List)hashmap.get(key)).iterator();
_L6:
        com.aviary.android.feather.common.threading.ThreadPool.Job job;
        String s1;
        com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem manifestpackitem;
        do
        {
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            manifestpackitem = (com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem)iterator1.next();
        } while (manifestpackitem == null);
        logger.log("checking message: %s", new Object[] {
            manifestpackitem.getIdentifier()
        });
        final MessageColumns.MessageCursorWrapper currentMessage = CdsUtils.getMessageByIdentifier(getBaseContext(), manifestpackitem.getIdentifier(), new String[] {
            "msg_id", "msg_identifier", "msg_versionKey"
        });
        job = null;
        cdsmanifestparser = null;
        s1 = getContentURL(manifestpackitem.getVersionKey());
        if (currentMessage == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (currentMessage.getVersionKey() == null)
        {
            logger.error("message has no versionKey!!!");
            continue; /* Loop/switch isn't completed */
        }
        if (!currentMessage.getVersionKey().equals(manifestpackitem.getVersionKey()))
        {
            logger.log("need to update the message: %s", new Object[] {
                currentMessage.getIdentifier()
            });
            job = createDownloadJob(this, flag);
            cdsmanifestparser = new FutureListener() {

                final AviaryCdsService this$0;
                final String val$assetBaseUrl;
                final MessageColumns.MessageCursorWrapper val$currentMessage;
                final AtomicInteger val$files;
                final AtomicBoolean val$hasException;
                final String val$key;
                final HashMap val$notificationMap;

                public void onFutureDone(Future future)
                {
                    if (!future.hasException()) goto _L2; else goto _L1
_L1:
                    AviaryCdsService.logger.error("future hasException: %s", new Object[] {
                        future.getException()
                    });
                    hasException.set(true);
_L3:
                    synchronized (files)
                    {
                        int j = files.decrementAndGet();
                        AviaryCdsService.logger.log("completed.. remaining tasks %d", new Object[] {
                            Integer.valueOf(j)
                        });
                        files.notify();
                    }
                    return;
_L2:
                    future = (InputStream)future.get();
                    onUpdateMessageContent(getBaseContext(), future, currentMessage, key, assetBaseUrl);
                    notificationMap.put(key, Boolean.valueOf(true));
                    IOUtils.closeSilently(future);
                      goto _L3
                    Object obj;
                    obj;
                    AviaryCdsService.logger.error("onUpdateMessageContent failed: %s", new Object[] {
                        ((Throwable) (obj)).getMessage()
                    });
                    hasException.set(true);
                    IOUtils.closeSilently(future);
                      goto _L3
                    obj;
                    IOUtils.closeSilently(future);
                    throw obj;
                    exception;
                    future;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = AviaryCdsService.this;
                hasException = atomicboolean;
                currentMessage = messagecursorwrapper;
                key = s;
                assetBaseUrl = s1;
                notificationMap = hashmap;
                files = atomicinteger;
                super();
            }
            };
        }
_L7:
        if (job != null && cdsmanifestparser != null)
        {
            files.incrementAndGet();
            THREAD_POOL.submit(job, cdsmanifestparser, new String[] {
                s1
            });
        }
        if (true) goto _L6; else goto _L5
_L5:
        job = createDownloadJob(this, flag);
        cdsmanifestparser = new FutureListener() {

            final AviaryCdsService this$0;
            final String val$assetBaseUrl;
            final AtomicInteger val$files;
            final AtomicBoolean val$hasException;
            final String val$key;
            final HashMap val$notificationMap;

            public void onFutureDone(Future future)
            {
                if (!future.hasException()) goto _L2; else goto _L1
_L1:
                AviaryCdsService.logger.error("future hasException: %s", new Object[] {
                    future.getException()
                });
                hasException.set(true);
_L3:
                synchronized (files)
                {
                    int j = files.decrementAndGet();
                    AviaryCdsService.logger.log("completed. remaining tasks: %d", new Object[] {
                        Integer.valueOf(j)
                    });
                    files.notify();
                }
                return;
_L2:
                future = (InputStream)future.get();
                onAddNewMessageContent(getBaseContext(), future, key, assetBaseUrl);
                notificationMap.put(key, Boolean.valueOf(true));
                IOUtils.closeSilently(future);
                  goto _L3
                Object obj;
                obj;
                AviaryCdsService.logger.error("onAddNewMessageContent failed: %s", new Object[] {
                    ((Throwable) (obj)).getMessage()
                });
                hasException.set(true);
                IOUtils.closeSilently(future);
                  goto _L3
                obj;
                IOUtils.closeSilently(future);
                throw obj;
                exception;
                future;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = AviaryCdsService.this;
                hasException = atomicboolean;
                key = s;
                assetBaseUrl = s1;
                notificationMap = hashmap;
                files = atomicinteger;
                super();
            }
        };
          goto _L7
_L4:
        files;
        JVM INSTR monitorenter ;
        logger.log("waiting..");
_L8:
        int i = files.get();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        files.wait();
          goto _L8
        cdsmanifestparser;
        cdsmanifestparser.printStackTrace();
          goto _L8
        cdsmanifestparser;
        files;
        JVM INSTR monitorexit ;
        throw cdsmanifestparser;
        files;
        JVM INSTR monitorexit ;
        if (notificationMap.size() > 0)
        {
            String s;
            for (cdsmanifestparser = notificationMap.keySet().iterator(); cdsmanifestparser.hasNext(); CdsUtils.notifyMessagesContentUpdated(getBaseContext(), s))
            {
                s = (String)cdsmanifestparser.next();
            }

        }
        logger.log("finished download messages (hasException: %b)", new Object[] {
            Boolean.valueOf(hasException.get())
        });
        return !hasException.get();
_L2:
        return true;
        if (true) goto _L6; else goto _L9
_L9:
        if (true) goto _L11; else goto _L10
_L10:
    }

    private boolean onParsePacks(CdsManifestParser cdsmanifestparser, boolean flag)
    {
        final AtomicBoolean hasException;
        final AtomicInteger files;
        final HashMap notificationMap;
        Context context;
        final String assetBaseUrl;
        logger.info(">> onParsePacks");
        context = getBaseContext();
        files = new AtomicInteger(0);
        hasException = new AtomicBoolean(false);
        notificationMap = new HashMap();
        assetBaseUrl = cdsmanifestparser.getAssetsBaseURL();
        if (!cdsmanifestparser.hasContent()) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        Iterator iterator;
        hashmap = cdsmanifestparser.getEnabledPacks();
        iterator = hashmap.keySet().iterator();
_L13:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        Iterator iterator1;
        final int order;
        cdsmanifestparser = (String)iterator.next();
        logger.log("processing: %s", new Object[] {
            cdsmanifestparser
        });
        iterator1 = ((List)hashmap.get(cdsmanifestparser)).iterator();
        order = 0;
_L6:
        com.aviary.android.feather.common.threading.ThreadPool.Job job;
        Object obj;
        Object obj1;
        final String packUrl;
        final PacksColumns.PackCursorWrapper currentPack;
        com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem manifestpackitem;
        do
        {
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            manifestpackitem = (com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem)iterator1.next();
        } while (manifestpackitem == null);
        logger.info("processing item: %s", new Object[] {
            manifestpackitem.getIdentifier()
        });
        currentPack = CdsUtils.getPackByIdentifier(context, manifestpackitem.getIdentifier(), null);
        packUrl = getContentURL(manifestpackitem.getVersionKey());
        obj = null;
        obj1 = null;
        if (currentPack != null)
        {
            break; /* Loop/switch isn't completed */
        }
        job = createDownloadJob(this, flag);
        cdsmanifestparser = new FutureListener() {

            final AviaryCdsService this$0;
            final String val$assetBaseUrl;
            final AtomicInteger val$files;
            final AtomicBoolean val$hasException;
            final int val$order;
            final String val$packUrl;

            public void onFutureDone(Future future)
            {
                if (!future.hasException()) goto _L2; else goto _L1
_L1:
                AviaryCdsService.logger.error("future hasException: %s", new Object[] {
                    future.getException()
                });
                hasException.set(true);
_L3:
                synchronized (files)
                {
                    int k = files.decrementAndGet();
                    AviaryCdsService.logger.log("completed. remaining tasks: %d ", new Object[] {
                        Integer.valueOf(k)
                    });
                    files.notify();
                }
                return;
_L2:
                future = (InputStream)future.get();
                onAddNewJsonContent(getBaseContext(), future, order, 1, assetBaseUrl);
                IOUtils.closeSilently(future);
                  goto _L3
                Object obj2;
                obj2;
                AviaryCdsService.logger.error("onParseJsonContent failed: '%s' for packUrl: %s", new Object[] {
                    ((Throwable) (obj2)).getMessage(), packUrl
                });
                hasException.set(true);
                IOUtils.closeSilently(future);
                  goto _L3
                obj2;
                IOUtils.closeSilently(future);
                throw obj2;
                exception;
                future;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = AviaryCdsService.this;
                hasException = atomicboolean;
                order = i;
                assetBaseUrl = s;
                packUrl = s1;
                files = atomicinteger;
                super();
            }
        };
_L9:
        int i = order + 1;
        order = i;
        if (job != null)
        {
            order = i;
            if (cdsmanifestparser != null)
            {
                files.incrementAndGet();
                THREAD_POOL.submit(job, cdsmanifestparser, new String[] {
                    packUrl
                });
                order = i;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!currentPack.getVersionKey().equals(manifestpackitem.getVersionKey()) || currentPack.getDisplayOrder() != order) goto _L8; else goto _L7
_L7:
        cdsmanifestparser = obj1;
        job = obj;
        if (currentPack.getVisible() == 1) goto _L9; else goto _L8
_L8:
        logger.log("need to update %s ( versionKey, displayOrder or visibility changed )", new Object[] {
            currentPack.getIdentifier()
        });
        if (!currentPack.getVersionKey().equals(manifestpackitem.getVersionKey()))
        {
            logger.warn("%s need to be updated", new Object[] {
                manifestpackitem.getIdentifier()
            });
            job = createDownloadJob(this, flag);
            cdsmanifestparser = new FutureListener() {

                final AviaryCdsService this$0;
                final String val$assetBaseUrl;
                final PacksColumns.PackCursorWrapper val$currentPack;
                final AtomicInteger val$files;
                final AtomicBoolean val$hasException;
                final HashMap val$notificationMap;
                final int val$order;

                public void onFutureDone(Future future)
                {
                    if (!future.hasException()) goto _L2; else goto _L1
_L1:
                    AviaryCdsService.logger.error("future hasException: %s", new Object[] {
                        future.getException()
                    });
                    hasException.set(true);
_L3:
                    synchronized (files)
                    {
                        int k = files.decrementAndGet();
                        AviaryCdsService.logger.log("completed. remaining tasks: %d", new Object[] {
                            Integer.valueOf(k)
                        });
                        files.notify();
                    }
                    return;
_L2:
                    future = (InputStream)future.get();
                    onUpdateJsonContent(getBaseContext(), future, currentPack, order, assetBaseUrl);
                    notificationMap.put(currentPack.getPackType(), Boolean.valueOf(true));
                    IOUtils.closeSilently(future);
                      goto _L3
                    Object obj2;
                    obj2;
                    AviaryCdsService.logger.error("onUpdateJsonContent failed: %s", new Object[] {
                        ((Throwable) (obj2)).getMessage()
                    });
                    hasException.set(true);
                    IOUtils.closeSilently(future);
                      goto _L3
                    obj2;
                    IOUtils.closeSilently(future);
                    throw obj2;
                    exception;
                    future;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = AviaryCdsService.this;
                hasException = atomicboolean;
                currentPack = packcursorwrapper;
                order = i;
                assetBaseUrl = s;
                notificationMap = hashmap;
                files = atomicinteger;
                super();
            }
            };
        } else
        {
            boolean flag2 = false;
            boolean flag1 = flag2;
            if (currentPack.getDisplayOrder() != order)
            {
                if (onUpdatePackDisplayOrder(currentPack.getId(), order))
                {
                    flag1 = true;
                } else
                {
                    logger.warn("onUpdatePackDisplayOrder failed. %s", new Object[] {
                        currentPack.getIdentifier()
                    });
                    flag1 = flag2;
                }
            }
            flag2 = flag1;
            if (currentPack.getVisible() != 1)
            {
                if (onChangePackVisibility(currentPack.getId(), 1))
                {
                    flag2 = true;
                } else
                {
                    logger.warn("onSetPackVisible failed. %s", new Object[] {
                        currentPack.getIdentifier()
                    });
                    flag2 = flag1;
                }
            }
            cdsmanifestparser = obj1;
            job = obj;
            if (flag2)
            {
                CdsUtils.notifyPackContentUpdate(getBaseContext(), currentPack.getId());
                notificationMap.put(currentPack.getPackType(), Boolean.valueOf(true));
                cdsmanifestparser = obj1;
                job = obj;
            }
        }
          goto _L9
_L2:
        logger.warn("manifest has no packs");
_L4:
        files;
        JVM INSTR monitorenter ;
        logger.log("waiting..");
_L10:
        int j = files.get();
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_663;
        }
        files.wait();
          goto _L10
        cdsmanifestparser;
        cdsmanifestparser.printStackTrace();
          goto _L10
        cdsmanifestparser;
        files;
        JVM INSTR monitorexit ;
        throw cdsmanifestparser;
        files;
        JVM INSTR monitorexit ;
        if (notificationMap.size() > 0)
        {
            String s;
            for (cdsmanifestparser = notificationMap.keySet().iterator(); cdsmanifestparser.hasNext(); CdsUtils.notifyPacksContentUpdated(getBaseContext(), s))
            {
                s = (String)cdsmanifestparser.next();
            }

        }
        if (!hasException.get())
        {
            return true;
        }
        return false;
        if (true) goto _L6; else goto _L11
_L11:
        if (true) goto _L13; else goto _L12
_L12:
    }

    private boolean onRageRemovePacks(CdsManifestParser cdsmanifestparser)
    {
label0:
        {
            logger.info(">> onRageRemovePacks");
            if (!cdsmanifestparser.hasContent() || !cdsmanifestparser.hasDeletedPacks())
            {
                break label0;
            }
            cdsmanifestparser = cdsmanifestparser.getDeletedPacks().iterator();
            Object obj;
            PacksColumns.PackCursorWrapper packcursorwrapper;
            do
            {
                do
                {
                    if (!cdsmanifestparser.hasNext())
                    {
                        break label0;
                    }
                    obj = (com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem)cdsmanifestparser.next();
                } while (obj == null);
                logger.warn("%s need to be hard removed", new Object[] {
                    ((com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem) (obj)).getIdentifier()
                });
                packcursorwrapper = CdsUtils.getPackByIdentifier(getBaseContext(), ((com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem) (obj)).getIdentifier(), null);
            } while (packcursorwrapper == null);
            int i = getContentResolver().delete(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/remove").toString()), null, null);
            if (i > 0)
            {
                logger.log("removed %s, now remove its contents", new Object[] {
                    ((com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem) (obj)).getIdentifier()
                });
                if (i > 0)
                {
                    CdsUtils.notifyPackContentUpdate(getBaseContext(), packcursorwrapper.getId());
                    CdsUtils.notifyPacksContentUpdated(getBaseContext(), packcursorwrapper.getPackType());
                }
                cdsmanifestparser = CdsUtils.getPackRootContent(((com.aviary.android.feather.cds.json.CdsManifestParser.ManifestPackItem) (obj)).getIdentifier());
                obj = new File(getFilesDir(), cdsmanifestparser);
                logger.log("folder to remove: %s", new Object[] {
                    cdsmanifestparser
                });
                boolean flag = IOUtils.deleteQuietly(((File) (obj)));
                logger.log("deleted: %b", new Object[] {
                    Boolean.valueOf(flag)
                });
                return true;
            } else
            {
                logger.error("failed to remove entry. result = 0");
                return false;
            }
        }
        return true;
    }

    private void onRemoveUnavailableMessages(CdsManifestParser cdsmanifestparser)
    {
        Cursor cursor;
        logger.info(">> onRemoveUnavailableMessages");
        if (!cdsmanifestparser.hasContent())
        {
            break MISSING_BLOCK_LABEL_390;
        }
        cursor = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "message/list"), null, null, null, null);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_390;
        }
_L2:
        MessageColumns.MessageCursorWrapper messagecursorwrapper;
        if (!cursor.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        messagecursorwrapper = MessageColumns.MessageCursorWrapper.create(cursor);
        if (messagecursorwrapper == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (cdsmanifestparser.containsMessage(messagecursorwrapper.getIdentifier()))
        {
            continue; /* Loop/switch isn't completed */
        }
        logger.warn("%s need to be removed", new Object[] {
            messagecursorwrapper.getIdentifier()
        });
        String s;
        Object obj;
        s = null;
        obj = null;
        Cursor cursor1 = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("message/id/").append(messagecursorwrapper.getId()).append("/content").toString()), new String[] {
            "msgcnt_id", "msgcnt_messageId", "msgcnt_contentPath"
        }, null, null, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        s = obj;
        if (cursor1.moveToFirst())
        {
            s = MessageContentColumn.MessageContentCursorWrapper.create(cursor1).getContentPath();
        }
        IOUtils.closeSilently(cursor1);
        int i;
        i = getContentResolver().delete(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("message/id/").append(messagecursorwrapper.getId()).append("/remove").toString()), null, null);
        logger.log("contentPath: %s", new Object[] {
            s
        });
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        logger.log("trying to delete.. %s", new Object[] {
            s
        });
        boolean flag = IOUtils.deleteQuietly(new File(s));
        logger.log("deleted content path: %b", new Object[] {
            Boolean.valueOf(flag)
        });
        CdsUtils.notifyMessagesContentUpdated(getBaseContext(), messagecursorwrapper.getMessageType());
        continue; /* Loop/switch isn't completed */
        cdsmanifestparser;
        IOUtils.closeSilently(cursor);
        throw cdsmanifestparser;
        cdsmanifestparser;
        IOUtils.closeSilently(cursor1);
        throw cdsmanifestparser;
        logger.error("failed to remove message entry. result = 0");
        if (true) goto _L2; else goto _L1
_L1:
        IOUtils.closeSilently(cursor);
    }

    private void onRestoreAllUserItems(String s, boolean flag)
    {
        logger.info(">> onRestoreAllUserItems (%s, wifiOnly: %b)", new Object[] {
            s, Boolean.valueOf(flag)
        });
        AviaryCds.PackType packtype = null;
        if (s != null)
        {
            packtype = AviaryCds.PackType.fromString(s);
        }
        s = new RestoreAllHelper(this, packtype, flag);
        s.restoreAll();
        s.dispose();
    }

    private boolean onRestorePacksIcons(String s, boolean flag)
    {
        final AtomicInteger files;
        final AtomicBoolean hasException;
        Cursor cursor;
        logger.info(">> onRestorePacksIcons (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        files = new AtomicInteger(0);
        hasException = new AtomicBoolean(false);
        cursor = getBaseContext().getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "pack/content/list"), null, null, null, null);
        if (cursor == null) goto _L2; else goto _L1
_L1:
        logger.log("cursor.size: %d", new Object[] {
            Integer.valueOf(cursor.getCount())
        });
_L5:
        if (cursor.moveToNext())
        {
            final Object pack = PacksColumns.PackCursorWrapper.create(cursor);
            PacksContentColumns.ContentCursorWrapper contentcursorwrapper = PacksContentColumns.ContentCursorWrapper.create(cursor);
            if (pack != null && contentcursorwrapper != null)
            {
                ((PacksColumns.PackCursorWrapper) (pack)).setContent(contentcursorwrapper);
                boolean flag1;
                if (((PacksColumns.PackCursorWrapper) (pack)).getContent().getIconPath() == null || ((PacksColumns.PackCursorWrapper) (pack)).getContent().getIconNeedDownload() > 0)
                {
                    flag1 = true;
                } else
                if (!(new File(((PacksColumns.PackCursorWrapper) (pack)).getContent().getIconPath())).exists())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    logger.log("%s need to download icon", new Object[] {
                        ((PacksColumns.PackCursorWrapper) (pack)).getIdentifier()
                    });
                    Object obj = ((PacksColumns.PackCursorWrapper) (pack)).getContent().getIconURL();
                    String s1 = ((String) (obj));
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        s1 = ((String) (obj));
                        if (!((String) (obj)).startsWith("http://"))
                        {
                            s1 = ((String) (obj));
                            if (!((String) (obj)).startsWith("https://"))
                            {
                                s1 = ((String) (obj));
                                if (!((String) (obj)).startsWith("file://"))
                                {
                                    s1 = (new StringBuilder()).append(s).append(((String) (obj))).toString();
                                }
                            }
                        }
                    }
                    logger.log("iconUrl: %s", new Object[] {
                        s1
                    });
                    final Uri iconUri = Uri.parse(s1);
                    obj = createDownloadJob(this, flag);
                    pack = new FutureListener() {

                        final AviaryCdsService this$0;
                        final AtomicInteger val$files;
                        final AtomicBoolean val$hasException;
                        final Uri val$iconUri;
                        final PacksColumns.PackCursorWrapper val$pack;

                        public void onFutureDone(Future future)
                        {
                            if (!future.hasException()) goto _L2; else goto _L1
_L1:
                            AviaryCdsService.logger.error("error: %s", new Object[] {
                                future.getException()
                            });
                            hasException.set(true);
_L5:
                            synchronized (files)
                            {
                                int j = files.decrementAndGet();
                                AviaryCdsService.logger.log("completed. remaining tasks: %d", new Object[] {
                                    Integer.valueOf(j)
                                });
                                files.notify();
                            }
                            return;
_L2:
                            Future future1;
                            Future future2;
                            future2 = null;
                            future1 = null;
                            future = (InputStream)future.get();
                            future1 = future;
                            future2 = future;
                            File file = new File((new StringBuilder()).append(getBaseContext().getFilesDir()).append("/").append(CdsUtils.getPackIconPath(pack.getIdentifier())).toString());
                            future1 = future;
                            future2 = future;
                            int k = onUpdatePackIcon(pack.getContent().getId(), pack.getId(), file, iconUri.getLastPathSegment(), future);
                            if (k <= 0) goto _L4; else goto _L3
_L3:
                            future1 = future;
                            future2 = future;
                            CdsUtils.notifyPackContentUpdate(getBaseContext(), pack.getId());
                            future1 = future;
                            future2 = future;
                            CdsUtils.notifyPacksContentUpdated(getBaseContext(), pack.getPackType());
_L6:
                            IOUtils.closeSilently(future);
                              goto _L5
_L4:
                            future1 = future;
                            future2 = future;
                            AviaryCdsService.logger.error("onUpdatedPackIcon result: %d", new Object[] {
                                Integer.valueOf(k)
                            });
                            future1 = future;
                            future2 = future;
                            hasException.set(true);
                              goto _L6
                            future;
                            future2 = future1;
                            AviaryCdsService.logger.error("failed to update icon");
                            future2 = future1;
                            future.printStackTrace();
                            future2 = future1;
                            hasException.set(true);
                            IOUtils.closeSilently(future1);
                              goto _L5
                            future;
                            IOUtils.closeSilently(future2);
                            throw future;
                            exception;
                            future;
                            JVM INSTR monitorexit ;
                            throw exception;
                        }

            
            {
                this$0 = AviaryCdsService.this;
                hasException = atomicboolean;
                pack = packcursorwrapper;
                iconUri = uri;
                files = atomicinteger;
                super();
            }
                    };
                    files.incrementAndGet();
                    THREAD_POOL.submit(((com.aviary.android.feather.common.threading.ThreadPool.Job) (obj)), ((FutureListener) (pack)), new String[] {
                        s1
                    });
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        IOUtils.closeSilently(cursor);
_L2:
        files;
        JVM INSTR monitorenter ;
        logger.log("waiting..");
_L3:
        int i = files.get();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_440;
        }
        files.wait();
          goto _L3
        s;
        s.printStackTrace();
          goto _L3
        s;
        files;
        JVM INSTR monitorexit ;
        throw s;
        files;
        JVM INSTR monitorexit ;
        if (!hasException.get())
        {
            return true;
        }
        return false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void onUpdateJsonContent(Context context, InputStream inputstream, PacksColumns.PackCursorWrapper packcursorwrapper, int i, String s)
        throws IOException, JSONException, AssertionError
    {
        logger.info(">> onUpdateJsonContent: %s", new Object[] {
            packcursorwrapper.getIdentifier()
        });
        CdsContentParser cdscontentparser = new CdsContentParser();
        if (cdscontentparser.parse(inputstream) != 0)
        {
            throw new AssertionFailedError((new StringBuilder()).append("parser failure: ").append(cdscontentparser.getStatus()).toString());
        }
        logger.log("%s == %s", new Object[] {
            cdscontentparser.getVersionKey(), packcursorwrapper.getVersionKey()
        });
        if (cdscontentparser.getVersionKey().equals(packcursorwrapper.getVersionKey()))
        {
            break MISSING_BLOCK_LABEL_1233;
        }
        inputstream = context.getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/content").toString()), new String[] {
            "content_id", "content_packId", "content_iconVersion", "content_previewVersion", "content_contentVersion", "content_featureImageVersion", "content_detailImageVersion", "content_previewPath"
        }, null, null, null);
        Assert.assertNotNull("currentCursor is null", inputstream);
        Assert.assertTrue("currentCursor.moveToFirst failed", inputstream.moveToFirst());
        long l = inputstream.getLong(0);
        inputstream.getLong(1);
        Object obj = inputstream.getString(2);
        String s1 = inputstream.getString(3);
        String s2 = inputstream.getString(4);
        String s3 = inputstream.getString(5);
        String s4 = inputstream.getString(6);
        context = inputstream.getString(7);
        IOUtils.closeSilently(inputstream);
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if (!cdscontentparser.getIconVersion().equals(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!cdscontentparser.getPreviewVersion().equals(s1))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!cdscontentparser.getContentVersion().equals(s2))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!cdscontentparser.getFeatureImageVersion().equals(s3))
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (!cdscontentparser.getDetailImageVersion().equals(s4))
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        inputstream = new ContentValues();
        inputstream.put("pack_versionKey", cdscontentparser.getVersionKey());
        inputstream.put("pack_displayOrder", Integer.valueOf(i));
        inputstream.put("pack_visible", Integer.valueOf(1));
        obj = new ContentValues();
        ((ContentValues) (obj)).put("content_displayName", cdscontentparser.getDisplayName());
        ((ContentValues) (obj)).put("content_displayDescription", cdscontentparser.getDisplayDescription());
        if (cdscontentparser.isFree())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        ((ContentValues) (obj)).put("content_isFree", Integer.valueOf(i));
        ((ContentValues) (obj)).put("content_numItems", Integer.valueOf(cdscontentparser.getItems().size()));
        ((ContentValues) (obj)).put("content_shopBackgroundColor", cdscontentparser.getShopBackgroundColor());
        if (flag)
        {
            ((ContentValues) (obj)).put("content_iconVersion", cdscontentparser.getIconVersion());
            ((ContentValues) (obj)).put("content_iconUrl", (new StringBuilder()).append(s).append(cdscontentparser.getIconURL()).toString());
            ((ContentValues) (obj)).put("content_iconNeedDownload", Integer.valueOf(1));
        }
        if (flag1)
        {
            logger.log("need to remove the previews");
            if (!TextUtils.isEmpty(context))
            {
                try
                {
                    logger.log("trying to delete previews");
                    IOUtils.cleanDirectory(new File(context));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    logger.error("error while deleting previews");
                    context.printStackTrace();
                }
            }
            ((ContentValues) (obj)).put("content_previewVersion", cdscontentparser.getPreviewVersion());
            ((ContentValues) (obj)).put("content_previewURL", (new StringBuilder()).append(s).append(cdscontentparser.getPreviewURL()).toString());
            ((ContentValues) (obj)).putNull("content_previewPath");
            ((ContentValues) (obj)).put("content_previewNeedDownload", Integer.valueOf(1));
        }
        if (flag2)
        {
            ((ContentValues) (obj)).put("content_contentVersion", cdscontentparser.getContentVersion());
            ((ContentValues) (obj)).put("content_contentURL", (new StringBuilder()).append(s).append(cdscontentparser.getContentURL()).toString());
            ((ContentValues) (obj)).put("content_contentNeedDownload", Integer.valueOf(1));
        }
        if (flag3 && !TextUtils.isEmpty(cdscontentparser.getFeatureImageURL()))
        {
            ((ContentValues) (obj)).put("content_featureImageVersion", cdscontentparser.getFeatureImageVersion());
            ((ContentValues) (obj)).put("content_featureImageURL", (new StringBuilder()).append(s).append(cdscontentparser.getFeatureImageURL()).toString());
        }
        if (flag4 && !TextUtils.isEmpty(cdscontentparser.getDetailImageURL()))
        {
            ((ContentValues) (obj)).put("content_detailImageVersion", cdscontentparser.getDetailImageVersion());
            ((ContentValues) (obj)).put("content_detailImageURL", (new StringBuilder()).append(s).append(cdscontentparser.getDetailImageURL()).toString());
        }
        s = new ArrayList();
        s.add(ContentProviderOperation.newUpdate(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/update").toString())).withValues(inputstream).build());
        s.add(ContentProviderOperation.newUpdate(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(packcursorwrapper.getId()).append("/content/id/").append(l).append("/update").toString())).withValues(((ContentValues) (obj))).build());
        inputstream = PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), null);
        context = null;
        logger.log("authority: %s - %s", new Object[] {
            inputstream, inputstream.getAuthority()
        });
        inputstream = getContentResolver().applyBatch(inputstream.getAuthority(), s);
        context = inputstream;
_L1:
        Assert.assertNotNull("batch result is null", context);
        boolean flag5;
        if (context.length == 2)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        Assert.assertTrue("batch result size != 2", flag5);
        if (context[0] != null && ((ContentProviderResult) (context[0])).count.intValue() > 0)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        Assert.assertTrue(flag5);
        if (context[1] != null && ((ContentProviderResult) (context[1])).count.intValue() > 0)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        Assert.assertTrue(flag5);
        CdsUtils.notifyPackContentUpdate(getBaseContext(), packcursorwrapper.getId());
        return;
        inputstream;
        inputstream.printStackTrace();
          goto _L1
        inputstream;
        inputstream.printStackTrace();
          goto _L1
        logger.warn("versionKey identical");
        return;
    }

    private void onUpdateMessageContent(Context context, InputStream inputstream, MessageColumns.MessageCursorWrapper messagecursorwrapper, String s, String s1)
        throws JSONException, IOException, AssertionError
    {
        boolean flag;
        logger.info(">> onUpdateMessageContent: %s", new Object[] {
            messagecursorwrapper.getIdentifier()
        });
        CdsMessageContentParser cdsmessagecontentparser = new CdsMessageContentParser();
        if (cdsmessagecontentparser.parse(inputstream) != 0)
        {
            throw new JSONException(cdsmessagecontentparser.getStatus());
        }
        if (cdsmessagecontentparser.getVersionKey().equals(messagecursorwrapper.getVersionKey()))
        {
            logger.warn("versionKey identical");
            return;
        }
        inputstream = CdsUtils.getMessageByIdentifier(context, cdsmessagecontentparser.getIdentifier(), new String[] {
            "msg_id"
        });
        ContentValues contentvalues;
        int i;
        if (inputstream != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("currentMessageContent is null", flag);
        contentvalues = new ContentValues();
        contentvalues.put("msg_identifier", cdsmessagecontentparser.getIdentifier());
        contentvalues.put("msg_versionKey", cdsmessagecontentparser.getVersionKey());
        contentvalues.put("msg_type", s);
        s = new ContentValues();
        if (cdsmessagecontentparser.isSplitButton())
        {
            context = cdsmessagecontentparser.getActionButtonText();
        } else
        {
            context = null;
        }
        s.put("msgcnt_actionButton", context);
        s.put("msgcnt_beginDate", DateTimeUtils.toSqlDateTime(cdsmessagecontentparser.getBeginDate()));
        s.put("msgcnt_contentIdentifier", cdsmessagecontentparser.getContentIdentifier());
        s.put("msgcnt_contentURL", (new StringBuilder()).append(s1).append(cdsmessagecontentparser.getContentURL()).toString());
        s.put("msgcnt_dismissButton", cdsmessagecontentparser.getDismissButtonText());
        s.put("msgcnt_endDate", DateTimeUtils.toSqlDateTime(cdsmessagecontentparser.getEndDate()));
        s.put("msgcnt_layoutStyle", cdsmessagecontentparser.getLayoutStyle());
        s.put("msgcnt_paragraph", cdsmessagecontentparser.getParagraph());
        if (cdsmessagecontentparser.isShowNewBanner())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s.put("msgcnt_showNewBanner", Integer.valueOf(i));
        s.put("msgcnt_title", cdsmessagecontentparser.getTitle());
        context = new Bundle();
        context.putLong("messageId", messagecursorwrapper.getId());
        context.putLong("messageContentId", inputstream.getId());
        context.putParcelable("messageValues", contentvalues);
        context.putParcelable("messageContentValues", s);
        s1 = new ArrayList();
        s1.add(ContentProviderOperation.newUpdate(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("message/id/").append(messagecursorwrapper.getId()).append("/update").toString())).withValues(contentvalues).build());
        s1.add(ContentProviderOperation.newUpdate(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("message/id/").append(messagecursorwrapper.getId()).append("/content/id/").append(inputstream.getId()).append("/update").toString())).withValues(s).build());
        inputstream = PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), null);
        context = null;
        logger.log("authority: %s - %s", new Object[] {
            inputstream, inputstream.getAuthority()
        });
        inputstream = getContentResolver().applyBatch(inputstream.getAuthority(), s1);
        context = inputstream;
_L1:
        Assert.assertNotNull("batch result is null", context);
        if (context.length == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("batch result size != 2", flag);
        if (context[0] != null && ((ContentProviderResult) (context[0])).count.intValue() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        if (context[1] != null && ((ContentProviderResult) (context[1])).count.intValue() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        CdsUtils.notifyMessageContentUpdate(getBaseContext(), messagecursorwrapper.getId());
        return;
        inputstream;
        inputstream.printStackTrace();
          goto _L1
        inputstream;
        inputstream.printStackTrace();
          goto _L1
    }

    private boolean onUpdatePackDisplayOrder(long l, int i)
    {
        logger.info(">> onUpdatePackDisplayOrder: %d, displayOrder: %d", new Object[] {
            Long.valueOf(l), Integer.valueOf(i)
        });
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("pack_displayOrder", Integer.valueOf(i));
        return getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(l).append("/update").toString()), contentvalues, null, null) > 0;
    }

    private int onUpdatePackIcon(long l, long l1, File file, String s, InputStream inputstream)
        throws IOException, AssertionError
    {
        logger.info("onUpdatePackIcon(%d - %d): %s", new Object[] {
            Long.valueOf(l1), Long.valueOf(l), s
        });
        Assert.assertNotNull("iconDir is null", file);
        synchronized (M_WRITE_DISK_LOCK)
        {
            file.mkdirs();
            IOUtils.createNoMediaFile(file);
        }
        Assert.assertTrue("iconDir is not a valid directory", file.isDirectory());
        int i;
        boolean flag;
        if (s != null)
        {
            file = new File(file, s);
        } else
        {
            file = File.createTempFile("icon-", ".png", file);
        }
        logger.log("saving icon to: %s", new Object[] {
            file.getAbsolutePath()
        });
        obj = new FileOutputStream(file, true);
        synchronized (M_WRITE_DISK_LOCK)
        {
            IOUtils.copyFile(inputstream, ((java.io.OutputStream) (obj)));
        }
        IOUtils.closeSilently(((java.io.Closeable) (obj)));
        s = new ContentValues();
        s.put("content_iconPath", file.getAbsolutePath());
        s.put("content_iconNeedDownload", Integer.valueOf(0));
        i = getContentResolver().update(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), (new StringBuilder()).append("pack/id/").append(l1).append("/content/id/").append(l).append("/update").toString()), s, null, null);
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue("!(result > 0)", flag);
        return i;
        file;
        obj;
        JVM INSTR monitorexit ;
        throw file;
        file;
        s;
        JVM INSTR monitorexit ;
        throw file;
    }

    private void onUpdatePermissions(Context context, List list, String s)
    {
        logger.info(">> onUpdatePermissions: %s (%s)", new Object[] {
            list, s
        });
        boolean flag = true;
        boolean flag1 = true;
        Object obj = getContentResolver().query(PackageManagerUtils.getCDSProviderContentUri(context, "permissions/list"), null, null, null, null);
        if (obj != null)
        {
            flag = flag1;
            if (((Cursor) (obj)).moveToFirst())
            {
                Object obj1 = PermissionColumns.CursorWrapper.create(((Cursor) (obj)));
                flag = flag1;
                if (obj1 != null)
                {
                    logger.log("old permissions: %s - %s", new Object[] {
                        ((PermissionColumns.CursorWrapper) (obj1)).getValue(), ((PermissionColumns.CursorWrapper) (obj1)).getHashCode()
                    });
                    obj1 = ((PermissionColumns.CursorWrapper) (obj1)).getHashCode();
                    flag = flag1;
                    if (obj1 != null)
                    {
                        if (!s.equals(obj1))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                }
            }
            IOUtils.closeSilently(((Cursor) (obj)));
        }
        logger.log("permissions need update? %b", new Object[] {
            Boolean.valueOf(flag)
        });
        if (flag)
        {
            obj = StringUtils.join(list, ",");
            logger.log("permissionString: '%s'", new Object[] {
                obj
            });
            obj1 = new ContentValues();
            ((ContentValues) (obj1)).put("perm_value", ((String) (obj)));
            ((ContentValues) (obj1)).put("perm_hash", s);
            if (getContentResolver().insert(PackageManagerUtils.getCDSProviderContentUri(context, "permissions/replace"), ((ContentValues) (obj1))) != null)
            {
                CdsUtils.notifyPermissionsUpdated(context);
            }
        }
        if (list.contains(AviaryCds.Permission.kill.name()))
        {
            list = new Intent("aviary.intent.action.KILL");
            list.setPackage(context.getPackageName());
            context.sendBroadcast(list);
            throw new IllegalStateException("application has been banned!");
        } else
        {
            return;
        }
    }

    private boolean onUpdateVersionKey(CdsManifestParser cdsmanifestparser)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (cdsmanifestparser == null)
                    {
                        break label0;
                    }
                    if (cdsmanifestparser.hasContent())
                    {
                        if (cdsmanifestparser.getVersionKey() == null || cdsmanifestparser.getVersionKey().length() <= 0 || cdsmanifestparser.getAssetsBaseURL() == null || cdsmanifestparser.getAssetsBaseURL().length() <= 0)
                        {
                            break label1;
                        }
                        logger.log("** adding the new versionKey: %s", new Object[] {
                            cdsmanifestparser.getVersionKey()
                        });
                        ContentValues contentvalues = new ContentValues();
                        contentvalues.put("version_versionKey", cdsmanifestparser.getVersionKey());
                        contentvalues.put("version_assetsBaseURL", cdsmanifestparser.getAssetsBaseURL());
                        cdsmanifestparser = getContentResolver().insert(PackageManagerUtils.getCDSProviderContentUri(getBaseContext(), "manifestVersion/insert"), contentvalues);
                        logger.log("updated manifest version: %s", new Object[] {
                            cdsmanifestparser
                        });
                        if (cdsmanifestparser == null)
                        {
                            break label2;
                        }
                    }
                    return true;
                }
                return false;
            }
            logger.error("versionKey or assetsBaseUrl is null");
            return false;
        }
        return false;
    }

    private void throwIfNotConnected(Context context)
        throws IOException
    {
        if (!isConnected(context))
        {
            throw new IOException("NotConnected");
        } else
        {
            return;
        }
    }

    CdsManifestParser downloadAndParseManifest(boolean flag)
        throws RestoreException
    {
        Object obj;
        Object obj1;
        logger.info(">> downloadAndParseManifest (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        int i;
        try
        {
            obj = downloadManifest(getBaseContext(), flag);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            throw new RestoreException(4, ((Throwable) (obj)));
        }
        obj1 = new CdsManifestParser();
        i = ((CdsManifestParser) (obj1)).parse(((InputStream) (obj)));
        IOUtils.closeSilently(((java.io.Closeable) (obj)));
        if (i != 0)
        {
            throw new RestoreException(3, ((CdsManifestParser) (obj1)).getStatus());
        } else
        {
            return ((CdsManifestParser) (obj1));
        }
        obj1;
        ((Exception) (obj1)).printStackTrace();
        throw new RestoreException(3, ((Throwable) (obj1)));
        obj1;
        IOUtils.closeSilently(((java.io.Closeable) (obj)));
        throw obj1;
    }

    InputStream downloadManifest(Context context, boolean flag)
        throws IOException
    {
        String s = getManifestURL();
        Object obj = CdsUtils.getManifestVersion(context);
        if (obj != null && ((VersionColumns.VersionCursorWrapper) (obj)).getVersionKey() != null)
        {
            logger.log("current versionKey: %s", new Object[] {
                ((VersionColumns.VersionCursorWrapper) (obj)).getVersionKey()
            });
            obj = getManifestURLParams(((VersionColumns.VersionCursorWrapper) (obj)).getVersionKey());
        } else
        {
            obj = getManifestURLParams(null);
        }
        CdsUtils.addSignature(((List) (obj)), mApiKeySecret);
        if (mDebugVersion)
        {
            ((List) (obj)).add(new BasicNameValuePair("staging", "2"));
        }
        if (flag)
        {
            throwIfNotConnected(context);
        }
        return IOUtils.download(s, ((List) (obj)));
    }

    boolean downloadPackIcon(Context context, String s, boolean flag, PacksColumns.PackCursorWrapper packcursorwrapper)
        throws IOException, AssertionError
    {
        String s1;
        Object obj;
        File file;
        Assert.assertNotNull("Pack is null", packcursorwrapper);
        Assert.assertNotNull("Pack content is null", packcursorwrapper.getContent());
        logger.info("downloadPackIcon: %s", new Object[] {
            packcursorwrapper.getIdentifier()
        });
        obj = packcursorwrapper.getContent().getIconURL();
        s1 = ((String) (obj));
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s1 = ((String) (obj));
            if (!((String) (obj)).startsWith("http://"))
            {
                s1 = ((String) (obj));
                if (!((String) (obj)).startsWith("https://"))
                {
                    s1 = ((String) (obj));
                    if (!((String) (obj)).startsWith("file://"))
                    {
                        s1 = (new StringBuilder()).append(s).append(((String) (obj))).toString();
                    }
                }
            }
        }
        s = packcursorwrapper.getContent().getIconPath();
        logger.log("iconUrl: %s", new Object[] {
            s1
        });
        logger.log("iconPath: %s", new Object[] {
            s
        });
        if (s != null && !flag && (new File(s)).exists())
        {
            return true;
        }
        obj = Uri.parse(s1);
        file = new File((new StringBuilder()).append(context.getFilesDir()).append("/").append(CdsUtils.getPackIconPath(packcursorwrapper.getIdentifier())).toString());
        context = null;
        s = IOUtils.download(s1, null);
        context = s;
        int i = onUpdatePackIcon(packcursorwrapper.getContent().getId(), packcursorwrapper.getId(), file, ((Uri) (obj)).getLastPathSegment(), s);
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IOUtils.closeSilently(s);
        return flag;
        s;
        IOUtils.closeSilently(context);
        throw s;
    }

    public String getContentGroup()
    {
        if (mContentGroup == null)
        {
            if (mPreferences != null)
            {
                long l = mPreferences.getLong("content-group-update-time", 0L);
                mContentGroup = mPreferences.getString("content-group-name", "A");
                if (System.currentTimeMillis() - l > 0x5265c00L)
                {
                    logger.log("need to update contentgroup!");
                    int i = (int)(Math.random() * 10D);
                    logger.log("content group rand: %d", new Object[] {
                        Integer.valueOf(i)
                    });
                    mContentGroup = new String(new char[] {
                        (char)(i + 65)
                    });
                    android.content.SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putLong("content-group-update-time", System.currentTimeMillis());
                    editor.putString("content-group-name", mContentGroup);
                    editor.apply();
                } else
                {
                    logger.log("using old content group: %s", new Object[] {
                        mContentGroup
                    });
                }
            } else
            {
                mContentGroup = "A";
            }
        }
        if (mContentGroup == null || !mContentGroup.matches("[A-J]"))
        {
            logger.warn("content group doesn't match the regex");
            mContentGroup = "A";
        }
        logger.verbose("contentGroup: %s", new Object[] {
            mContentGroup
        });
        return mContentGroup;
    }

    public String getCountry()
    {
        if (mCountry == null)
        {
            String s1 = mLocale.getCountry();
            String s = s1;
            if (!CdsUtils.CDS_SUPPORTED_COUNTRIES.contains(s1))
            {
                s = "";
            }
            mCountry = s;
        }
        return mCountry;
    }

    IAPWrapper getIAPInstance()
    {
        return mIapWrapper;
    }

    public String getLanguage()
    {
        if (mLanguage == null)
        {
            String s1 = mLocale.getLanguage();
            String s = s1;
            if (!CdsUtils.CDS_SUPPORTED_LANGUAGES.contains(s1))
            {
                s = "";
            }
            mLanguage = s;
        }
        return mLanguage;
    }

    public boolean hasCountryParam()
    {
        return !"".equals(getCountry());
    }

    public boolean hasLanguageParam()
    {
        return !"".equals(getLanguage());
    }

    public void onCreate()
    {
        logger.info("onCreate");
        logger.warn("** StrictMode OFF **");
        mPreferences = getBaseContext().getSharedPreferences("aviary-cds-service", 4);
        super.onCreate();
    }

    public void onDestroy()
    {
        logger.info("onDestroy");
        if (mIapWrapper != null)
        {
            mIapWrapper.dispose();
            mIapWrapper = null;
        }
        super.onDestroy();
    }

    protected void onHandleIntent(Intent intent)
    {
        Object obj;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        obj = intent.getAction();
        boolean flag1 = intent.getBooleanExtra("EXTRA_DOWNLOAD_EXTRA_ASSETS", false);
        flag4 = intent.getBooleanExtra("EXTRA_LAZY_EXECUTION", false);
        flag5 = intent.getBooleanExtra("EXTRA_EXECUTE_WIFI_ONLY", false);
        flag6 = intent.getBooleanExtra("EXTRA_EXECUTE_PLUGGED_ONLY", true);
        logger.verbose("action: %s", new Object[] {
            obj
        });
        logger.verbose("lazy: %b", new Object[] {
            Boolean.valueOf(flag4)
        });
        logger.verbose("wifiOnly: %b", new Object[] {
            Boolean.valueOf(flag5)
        });
        logger.verbose("pluggedOnly: %b", new Object[] {
            Boolean.valueOf(flag6)
        });
        logger.verbose("downloadExtraAssets: %b", new Object[] {
            Boolean.valueOf(flag1)
        });
        if (!flag4) goto _L2; else goto _L1
_L1:
        logger.error("LAZY Execution..");
        if (intent.getBooleanExtra("EXTRA_WIFI_CONNECTED", false)) goto _L4; else goto _L3
_L3:
        logger.error("Not Connected. Stopping..");
_L14:
        return;
_L4:
        if (flag6)
        {
            if (!BatteryUtils.isCharging(getBaseContext(), intent))
            {
                logger.error("Phone not Charging. Stopping..");
                return;
            }
        } else
        {
            logger.verbose("Skip phone charging check", new Object[0]);
        }
        long l = System.currentTimeMillis();
        long l1 = l - mPreferences.getLong("last-execution-time", 0L);
        logger.log("time passed: %s", new Object[] {
            DurationFormatUtils.formatDurationHMS(l1)
        });
        if (l1 < 0x1b77400L)
        {
            logger.verbose("Service already started. Stopping..", new Object[0]);
            return;
        }
        android.content.SharedPreferences.Editor editor = mPreferences.edit();
        editor.putLong("last-execution-time", l);
        editor.apply();
_L2:
        boolean flag;
        if (mServerRoot == null)
        {
            boolean flag2 = SDKUtils.getCDSDebug(getBaseContext());
            logger.warn("cds_debug: %b", new Object[] {
                Boolean.valueOf(flag2)
            });
            if (flag2)
            {
                mServerRoot = "http://cd-lb.aviary.com/v1";
                mDebugVersion = true;
            } else
            {
                mServerRoot = "http://cd.aviary.com/v1";
                mDebugVersion = false;
            }
            logger.log((new StringBuilder()).append("debug: ").append(mDebugVersion).toString());
            logger.log((new StringBuilder()).append("root: ").append(mServerRoot).toString());
        }
        logger.info("handleIntent: %s", new Object[] {
            obj
        });
        cancelAlarms();
        flag = false;
        handleKeys(intent);
        checkProviderExists(this);
        if (TextUtils.isEmpty(mApiKeySecret))
        {
            LoggerFactory.printDeveloperError("API-SECRET not found. Did you forget to pass the AviaryIntent.EXTRA_API_KEY_SECRET ?");
            onClearPermissions(this);
            throw new IllegalStateException("Missing required api key secret");
        }
        if ("aviary.intent.action.CDS_RESTORE_USER_ITEMS".equals(obj) || "aviary.intent.action.CDS_RESTORE_OWNED_PACKS".equals(obj))
        {
            if (TextUtils.isEmpty(mBillingPublicKey))
            {
                LoggerFactory.printDeveloperError("Did you forget to pass the AviaryIntent.EXTRA_BILLING_PUBLIC_KEY?");
            }
            mIabResult = null;
            mIapWrapper = IAPWrapper.createNew(this, mBillingPublicKey);
            mIapWrapper.startSetup(this);
        }
        if (!"aviary.intent.action.CDS_DOWNLOAD_START".equals(obj)) goto _L6; else goto _L5
_L5:
        onDownloadStart(flag5);
        int i = ((flag) ? 1 : 0);
        if (!intent.getBooleanExtra("EXTRA_DOWNLOAD_EXTRA_ASSETS", false)) goto _L8; else goto _L7
_L7:
        i = ((flag) ? 1 : 0);
        if (!ApiHelper.AT_LEAST_14) goto _L8; else goto _L9
_L9:
        if (!flag5) goto _L11; else goto _L10
_L10:
        boolean flag3 = isConnected(this);
_L15:
        if (flag3) goto _L13; else goto _L12
_L12:
        logger.verbose("Skipping extra assets download b/c there's no wifi connection", new Object[0]);
        return;
        obj;
        if (!flag4)
        {
            i = 1;
        } else
        {
            i = 0;
        }
_L8:
        if (i != 0)
        {
            logger.error("exception handled, let's try again");
            clearServiceQueue();
            intent = new Intent(intent);
            i = sTryAgainCount;
            sTryAgainCount = i - 1;
            Object obj1;
            if (i > 0)
            {
                addAlarm(getBaseContext(), System.currentTimeMillis() + 15000L, intent);
                logger.warn("adding alarm, try again: %d", new Object[] {
                    Integer.valueOf(sTryAgainCount)
                });
                return;
            } else
            {
                logger.warn("try again reset, no more tries: %d", new Object[] {
                    Integer.valueOf(sTryAgainCount)
                });
                sTryAgainCount = 1;
                return;
            }
        }
          goto _L14
_L11:
        flag3 = true;
          goto _L15
_L13:
        logger.info("Ok, now download extra assets");
        i = intent.getIntExtra("EXTRA_MAX_ITEMS", -1);
        obj = AviaryIntent.createCommonIntent(this, "aviary.intent.action.CDS_DOWNLOAD_EXTRA_ASSETS", com/aviary/android/feather/cds/AviaryCdsAssetsDownloaderService);
        ((Intent) (obj)).putExtra("EXTRA_EXECUTE_WIFI_ONLY", flag5);
        ((Intent) (obj)).putExtra("EXTRA_MAX_ITEMS", i);
        startService(((Intent) (obj)));
        i = ((flag) ? 1 : 0);
          goto _L8
_L6:
        if (!"aviary.intent.action.CDS_RESTORE_USER_ITEMS".equals(obj))
        {
            break MISSING_BLOCK_LABEL_877;
        }
        onRestoreAllUserItems(intent.getStringExtra("type"), flag5);
        i = ((flag) ? 1 : 0);
          goto _L8
        obj;
        logger.error("exception not handled");
        ((JSONException) (obj)).printStackTrace();
        i = ((flag) ? 1 : 0);
          goto _L8
        i = ((flag) ? 1 : 0);
        if (!"aviary.intent.action.CDS_RESTORE_OWNED_PACKS".equals(obj)) goto _L8; else goto _L16
_L16:
        onRestoreOwnedPacks(intent.getStringExtra("type"), flag5);
        i = ((flag) ? 1 : 0);
          goto _L8
        obj1;
        logger.error("exception not handled");
        ((Exception) (obj1)).printStackTrace();
        i = ((flag) ? 1 : 0);
          goto _L8
_L18:
        i = 0;
          goto _L8
        obj1;
        logger.error("exception not handled");
        ((Throwable) (obj1)).printStackTrace();
        i = ((flag) ? 1 : 0);
          goto _L8
        AssertionError assertionerror;
        assertionerror;
        if (flag4) goto _L18; else goto _L17
_L17:
        i = 1;
          goto _L8
    }

    public void onIabSetupFinished(IabResult iabresult)
    {
        logger.info("onIabSetupFinished: %s", new Object[] {
            iabresult
        });
        synchronized (mIapObjectLock)
        {
            mIabResult = iabresult;
            mIapObjectLock.notifyAll();
        }
        return;
        iabresult;
        obj;
        JVM INSTR monitorexit ;
        throw iabresult;
    }

    List onRestoreMissingPacks(CdsManifestParser cdsmanifestparser, Iterator iterator, boolean flag)
    {
        final AtomicInteger files;
        final List exceptions;
        final String assetBaseUrl;
        final String packUrl;
        logger.info(">> onRestoreMissingPacks (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        Object obj1 = getBaseContext();
        files = new AtomicInteger(0);
        exceptions = Collections.synchronizedList(new ArrayList());
        assetBaseUrl = cdsmanifestparser.getAssetsBaseURL();
        Object obj = new StringBuilder();
        packUrl = new ArrayList();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            packUrl.add(s1);
            ((StringBuilder) (obj)).append("'").append(s1).append("'");
            if (iterator.hasNext())
            {
                ((StringBuilder) (obj)).append(",");
            }
        } while (true);
        logger.log("legacy packs size: %d", new Object[] {
            Integer.valueOf(packUrl.size())
        });
        iterator = ((Context) (obj1)).getContentResolver();
        obj1 = PackageManagerUtils.getCDSProviderContentUri(((Context) (obj1)), "pack/content/list");
        obj = (new StringBuilder()).append("pack_identifier IN (").append(((StringBuilder) (obj)).toString()).append(")").toString();
        iterator = iterator.query(((Uri) (obj1)), new String[] {
            "pack_identifier"
        }, ((String) (obj)), null, null);
        if (iterator == null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        logger.log("cursor size: %d", new Object[] {
            Integer.valueOf(iterator.getCount())
        });
        String s;
        for (; iterator.moveToNext(); packUrl.remove(s))
        {
            s = iterator.getString(0);
            logger.log("remove '%s' from the legacy array", new Object[] {
                s
            });
        }

        break MISSING_BLOCK_LABEL_325;
        cdsmanifestparser;
        IOUtils.closeSilently(iterator);
        throw cdsmanifestparser;
        IOUtils.closeSilently(iterator);
        com.aviary.android.feather.common.threading.ThreadPool.Job job;
        final String identifier;
        for (iterator = packUrl.iterator(); iterator.hasNext(); THREAD_POOL.submit(job, identifier, new String[] {
    packUrl
}))
        {
            identifier = (String)iterator.next();
            logger.log("download content for: %s", new Object[] {
                identifier
            });
            packUrl = getContentURL(identifier, cdsmanifestparser.getFormatListId());
            job = createDownloadJob(this, flag);
            identifier = new FutureListener() {

                final AviaryCdsService this$0;
                final String val$assetBaseUrl;
                final List val$exceptions;
                final AtomicInteger val$files;
                final String val$identifier;
                final String val$packUrl;

                public void onFutureDone(Future future)
                {
                    if (!future.hasException()) goto _L2; else goto _L1
_L1:
                    exceptions.add(new RestoreException(4, future.getException()));
_L3:
                    synchronized (files)
                    {
                        int j = files.decrementAndGet();
                        AviaryCdsService.logger.log("completed. remaining tasks: %d", new Object[] {
                            Integer.valueOf(j)
                        });
                        files.notify();
                    }
                    return;
_L2:
                    future = (InputStream)future.get();
                    CdsContentParser cdscontentparser;
                    cdscontentparser = new CdsContentParser();
                    if (cdscontentparser.parse(future) == 0)
                    {
                        break MISSING_BLOCK_LABEL_159;
                    }
                    exceptions.add(new RestoreException(3, (new StringBuilder()).append(identifier).append(": ").append(cdscontentparser.getStatus()).toString()));
_L4:
                    IOUtils.closeSilently(future);
                      goto _L3
                    onAddNewJsonContent(getBaseContext(), cdscontentparser, 10000, 0, assetBaseUrl);
                    AviaryCdsService.logger.log("restored: %s", new Object[] {
                        identifier
                    });
                      goto _L4
                    Object obj2;
                    obj2;
                    AviaryCdsService.logger.error((new StringBuilder()).append("onAddNewJsonContent failed on '%s'").append(packUrl).toString());
                    ((Throwable) (obj2)).printStackTrace();
                    exceptions.add(new RestoreException(5, ((Throwable) (obj2))));
                    IOUtils.closeSilently(future);
                      goto _L3
                    obj2;
                    IOUtils.closeSilently(future);
                    throw obj2;
                    exception;
                    future;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = AviaryCdsService.this;
                exceptions = list;
                identifier = s;
                assetBaseUrl = s1;
                packUrl = s2;
                files = atomicinteger;
                super();
            }
            };
            files.incrementAndGet();
        }

        files;
        JVM INSTR monitorenter ;
        logger.log("waiting..");
_L1:
        int i = files.get();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_492;
        }
        files.wait();
          goto _L1
        cdsmanifestparser;
        cdsmanifestparser.printStackTrace();
          goto _L1
        cdsmanifestparser;
        files;
        JVM INSTR monitorexit ;
        throw cdsmanifestparser;
        files;
        JVM INSTR monitorexit ;
        return exceptions;
    }

    List onRestoreOwnedPacks(CdsManifestParser cdsmanifestparser, String s, boolean flag)
        throws RestoreException
    {
        List list1;
        logger.info(">> onRestoreOwnedPacks (wifiOnly: %b)", new Object[] {
            Boolean.valueOf(flag)
        });
        list1 = Collections.synchronizedList(new ArrayList());
        if (mIapWrapper != null) goto _L2; else goto _L1
_L1:
        return list1;
_L2:
        Object obj = mIapObjectLock;
        obj;
        JVM INSTR monitorenter ;
        IabResult iabresult = mIabResult;
        if (iabresult != null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        mIapObjectLock.wait(2000L);
        obj;
        JVM INSTR monitorexit ;
        if (mIabResult == null)
        {
            throw new RestoreException(1, "in-app service returned null");
        }
        break MISSING_BLOCK_LABEL_119;
        cdsmanifestparser;
        cdsmanifestparser.printStackTrace();
        throw new RestoreException(1, "in-app service timeout error");
        cdsmanifestparser;
        obj;
        JVM INSTR monitorexit ;
        throw cdsmanifestparser;
        if (!mIabResult.isSuccess())
        {
            break MISSING_BLOCK_LABEL_228;
        }
        List list;
        try
        {
            list = mIapWrapper.queryPurchases().getAllOwnedSkus();
        }
        // Misplaced declaration of an exception variable
        catch (CdsManifestParser cdsmanifestparser)
        {
            cdsmanifestparser.printStackTrace();
            throw new RestoreException(1, cdsmanifestparser);
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        CdsUtils.filterSkuByPackType(list, s);
        logger.log("owned items: %d", new Object[] {
            Integer.valueOf(list.size())
        });
        if (list.size() <= 0) goto _L1; else goto _L3
_L3:
        list1.addAll(onRestoreMissingPacks(cdsmanifestparser, list.iterator(), flag));
        return list1;
        logger.error("iabresult: %s", new Object[] {
            mIabResult
        });
        throw new RestoreException(1, "in-app service failed");
    }

    void onRestoreOwnedPacks(String s, boolean flag)
        throws RestoreException
    {
        logger.info(">> onRestoreOwnedPacks: %s, wifiOnly: %b", new Object[] {
            s, Boolean.valueOf(flag)
        });
        int i = 0;
        try
        {
            CdsManifestParser cdsmanifestparser = downloadAndParseManifest(flag);
            onRestoreOwnedPacks(cdsmanifestparser, s, flag);
            onRestorePacksIcons(cdsmanifestparser.getAssetsBaseURL(), flag);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            i = 1;
        }
        CdsUtils.notifyDownloadMissingPacksCompleted(getBaseContext(), s, i);
    }

    static 
    {
        ajc$preClinit();
        logger = LoggerFactory.getLogger("AviaryCdsService", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }







    private class AjcClosure1 extends AroundClosure
    {

        public Object run(Object aobj[])
        {
            aobj = super.state;
            AviaryCdsService.handleKeys_aroundBody0((AviaryCdsService)aobj[0], (Intent)aobj[1], (JoinPoint)aobj[2]);
            return null;
        }

        public AjcClosure1(Object aobj[])
        {
            super(aobj);
        }
    }

}
