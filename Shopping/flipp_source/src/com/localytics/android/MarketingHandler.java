// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ah;
import android.support.v4.app.bl;
import android.support.v4.app.bp;
import android.support.v4.app.bq;
import android.support.v4.app.bs;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseHandler, AnalyticsListener, Constants, TestModeButton, 
//            TestModeListView, LocalyticsDao, MarketingRulesAdapter, BaseProvider, 
//            MarketingMessage, LocalyticsManager, MarketingCondition, DatapointHelper, 
//            PushTrackingActivity, JsonHelper, MarketingDownloader, MarketingProvider, 
//            MarketingDialogFragment, BaseUploadThread

class MarketingHandler extends BaseHandler
    implements AnalyticsListener
{

    private static final String AB_ATTRIBUTE = "ab";
    private static final String ACTION_ATTRIBUTE = "Action";
    private static final String APP_CONTEXT_ATTRIBUTE = "App Context";
    private static final List AUGMENTED_BLACKOUT_TIMES_RULE;
    private static final List AUGMENTED_BLACKOUT_WEEKDAYS_RULE = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6)
    });
    private static final String CAMPAIGN_ID_ATTRIBUTE = "Campaign ID";
    private static final String CREATIVE_DISPLAYED_ATTRIBUTE = "Creative Displayed";
    private static final String CREATIVE_ID_ATTRIBUTE = "Creative ID";
    private static final String CREATIVE_TYPE_ATTRIBUTE = "Creative Type";
    private static final SimpleDateFormat DATE_SDF;
    private static final Map DEFAULT_FREQUENCY_CAPPING_RULE;
    private static final int GLOBAL_FREQUENCY_CAPPING_RULE_CAMPAIGN_ID = -1;
    private static final String GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS[];
    private static final String INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS[];
    private static final List JS_STRINGS_THAT_MEAN_NULL = Arrays.asList(new String[] {
        "undefined", "null", "nil", "\"\"", "''"
    });
    private static final int MESSAGE_HANDLE_PUSH_RECEIVED = 204;
    private static final int MESSAGE_MARKETING_MESSAGE_TRIGGER = 201;
    private static final int MESSAGE_SET_MARKETING_MESSAGE_AS_NOT_DISPLAYED = 205;
    private static final int MESSAGE_SHOW_MARKETING_TEST = 203;
    private static final String PROJECTION_MARKETING_RULE_RECORD[] = {
        "_id", "version"
    };
    private static final String PUSH_API_URL_TEMPLATE = "http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s";
    private static final String PUSH_NOTIFICATIONS_ENABLED_ATTRIBUTE = "Push Notifications Enabled";
    private static final String PUSH_OPENED_EVENT = "Localytics Push Opened";
    private static final String PUSH_RECEIVED_EVENT = "Localytics Push Received";
    private static final SimpleDateFormat TIME_SDF;
    private int lastMarketingMessagesHash;
    private boolean mCampaignDisplaying;
    Map mConfigurations;
    private ah mFragmentManager;
    private boolean sessionStartMarketingMessageShown;
    private MarketingRulesAdapter testCampaignsListAdapter;

    MarketingHandler(LocalyticsDao localyticsdao, Looper looper, Context context)
    {
        super(localyticsdao, looper);
        sessionStartMarketingMessageShown = true;
        testCampaignsListAdapter = null;
        lastMarketingMessagesHash = -1;
        mCampaignDisplaying = false;
        siloName = "In-app";
        listeners = new MessagingListenersSet(null);
        doesRetry = false;
        _createLocalyticsDirectory(context);
        queueMessage(obtainMessage(1));
    }

    private void __showMarketingTest()
    {
        while (mFragmentManager == null || mFragmentManager.a("marketing_test_mode_button") != null || mFragmentManager.a("marketing_test_mode_list") != null) 
        {
            return;
        }
        final TestModeButton button = TestModeButton.newInstance();
        final TestModeListView listView = TestModeListView.newInstance();
        final Context appContext = mLocalyticsDao.getAppContext();
        final MarketingRulesAdapter adapter = new MarketingRulesAdapter(appContext, this);
        listView.setAdapter(adapter);
        TreeMap treemap = new TreeMap();
        treemap.put(Integer.valueOf(9), new _cls10());
        button.setCallbacks(treemap);
        button.show(mFragmentManager, "marketing_test_mode_button");
        mFragmentManager.b();
        treemap = new TreeMap();
        treemap.put(Integer.valueOf(10), new _cls11());
        treemap.put(Integer.valueOf(12), new _cls12());
        treemap.put(Integer.valueOf(13), new _cls13());
        treemap.put(Integer.valueOf(14), new _cls14());
        treemap.put(Integer.valueOf(11), new _cls15());
        listView.setCallbacks(treemap);
    }

    private void _bindRuleToEvents(long l, List list)
    {
        mProvider.remove("marketing_ruleevent", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Long.toString(l)
        });
        ContentValues contentvalues;
        for (list = list.iterator(); list.hasNext(); mProvider.insert("marketing_ruleevent", contentvalues))
        {
            String s = (String)list.next();
            contentvalues = new ContentValues();
            contentvalues.put("event_name", s);
            contentvalues.put("rule_id_ref", Long.valueOf(l));
        }

    }

    private boolean _createLocalyticsDirectory(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        context = new File(stringbuilder.toString());
        return context.mkdirs() || context.isDirectory();
    }

    private boolean _decompressZipFile(String s, String s1, String s2)
    {
        s2 = new ZipInputStream(new FileInputStream((new StringBuilder()).append(s).append(File.separator).append(s2).toString()));
        s = s2;
        byte abyte0[] = new byte[8192];
_L6:
        s = s2;
        ZipEntry zipentry = s2.getNextEntry();
        if (zipentry == null) goto _L2; else goto _L1
_L1:
        s = s2;
        String s3 = (new StringBuilder()).append(s1).append(File.separator).append(zipentry.getName()).toString();
        s = s2;
        if (!zipentry.isDirectory()) goto _L4; else goto _L3
_L3:
        s = s2;
        if ((new File(s3)).mkdir()) goto _L6; else goto _L5
_L5:
        s = s2;
        Localytics.Log.w(String.format("Could not create directory %s", new Object[] {
            s3
        }));
          goto _L6
        s;
        s1 = s2;
        s2 = s;
_L10:
        s = s1;
        Localytics.Log.w("Caught IOException", s2);
        FileOutputStream fileoutputstream;
        int i;
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.w("Caught IOException", s);
                return false;
            }
        }
        return false;
_L4:
        s = s2;
        fileoutputstream = new FileOutputStream(s3);
_L8:
        s = s2;
        i = s2.read(abyte0, 0, 8192);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s = s2;
        fileoutputstream.write(abyte0, 0, i);
        if (true) goto _L8; else goto _L7
        s2;
        s1 = s;
        s = s2;
_L9:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.w("Caught IOException", s);
                return false;
            }
        }
        throw s;
_L7:
        s = s2;
        fileoutputstream.close();
        s = s2;
        s2.closeEntry();
          goto _L6
_L2:
        try
        {
            s2.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Localytics.Log.w("Caught IOException", s);
            return false;
        }
        return true;
        s;
        s1 = null;
          goto _L9
        s2;
        s1 = null;
          goto _L10
    }

    private void _destroyLocalMarketingMessage(MarketingMessage marketingmessage)
    {
        boolean flag = false;
        long al[];
        File file;
        String as[];
        int i;
        int j;
        int k;
        long l;
        try
        {
            j = _getRuleIdFromCampaignId(((Integer)marketingmessage.get("campaign_id")).intValue());
            al = _getConditionIdFromRuleId(j);
            k = al.length;
        }
        // Misplaced declaration of an exception variable
        catch (MarketingMessage marketingmessage)
        {
            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", marketingmessage);
            return;
        }
        i = 0;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        l = al[i];
        mProvider.remove("marketing_condition_values", String.format("%s = ?", new Object[] {
            "condition_id_ref"
        }), new String[] {
            Long.toString(l)
        });
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_37;
_L1:
        mProvider.remove("marketing_conditions", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Integer.toString(j)
        });
        mProvider.remove("marketing_ruleevent", String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Integer.toString(j)
        });
        mProvider.remove("marketing_rules", String.format("%s = ?", new Object[] {
            "_id"
        }), new String[] {
            Integer.toString(j)
        });
        marketingmessage = (String)marketingmessage.get("base_path");
        if (marketingmessage == null)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        file = new File(marketingmessage);
        if (!file.isDirectory()) goto _L4; else goto _L3
_L3:
        as = file.list();
        j = as.length;
        i = ((flag) ? 1 : 0);
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        (new File(file, as[i])).delete();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        if (!file.delete())
        {
            Localytics.Log.w(String.format("Delete %s failed.", new Object[] {
                marketingmessage
            }));
        }
        if (!(new File((new StringBuilder()).append(marketingmessage).append(".zip").toString())).delete())
        {
            Localytics.Log.w(String.format("Delete %s failed.", new Object[] {
                (new StringBuilder()).append(marketingmessage).append(".zip").toString()
            }));
        }
    }

    private boolean _doesCreativeExist(int i, boolean flag)
    {
        File file;
        if (flag)
        {
            file = new File((new StringBuilder()).append(_getZipFileDirPath()).append(File.separator).append(String.format("amp_rule_%d.zip", new Object[] {
                Integer.valueOf(i)
            })).toString());
        } else
        {
            file = new File((new StringBuilder()).append(_getUnzipFileDirPath(i)).append(File.separator).append("index.html").toString());
        }
        return file.exists();
    }

    private Set _getCampaignIdsFromFrequencyCappingQuery(String s)
    {
        return _getCampaignIdsFromFrequencyCappingQuery(s, null);
    }

    private Set _getCampaignIdsFromFrequencyCappingQuery(String s, String as[])
    {
        String s1;
        HashSet hashset;
        hashset = new HashSet();
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        s1 = null;
        s = mProvider.mDb.rawQuery(s, as);
_L2:
        s1 = s;
        if (!s.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        hashset.add(Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("campaign_id"))));
        if (true) goto _L2; else goto _L1
        s;
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
_L1:
        if (s != null)
        {
            s.close();
        }
        return hashset;
    }

    private long[] _getConditionIdFromRuleId(long l)
    {
        Object obj;
        obj = mProvider;
        String s = String.format("%s = ?", new Object[] {
            "rule_id_ref"
        });
        String s1 = Long.toString(l);
        obj = ((BaseProvider) (obj)).query("marketing_conditions", new String[] {
            "_id"
        }, s, new String[] {
            s1
        }, null);
        long al[] = new long[((Cursor) (obj)).getCount()];
        int i = 0;
_L2:
        if (!((Cursor) (obj)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        al[i] = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return al;
        Exception exception;
        exception;
        obj = null;
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private SparseArray _getJavaScriptClientCallbacks(final Map attributes)
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(3, new _cls20());
        sparsearray.put(5, new _cls21());
        final JSONObject jsonCustomDimensions = new JSONObject();
        int i = 0;
        while (i < 10) 
        {
            try
            {
                jsonCustomDimensions.put((new StringBuilder("c")).append(i).toString(), mLocalyticsDao.getCustomDimension(i));
            }
            catch (JSONException jsonexception)
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to get custom dimension");
            }
            i++;
        }
        sparsearray.put(6, new _cls22());
        sparsearray.put(7, new _cls23());
        sparsearray.put(8, new _cls24());
        return sparsearray;
    }

    private Vector _getMarketingConditionValues(int i)
    {
        Object obj1 = null;
        Object obj;
        obj = mProvider;
        String s = String.format("%s = ?", new Object[] {
            "condition_id_ref"
        });
        String s1 = Integer.toString(i);
        obj = ((BaseProvider) (obj)).query("marketing_condition_values", new String[] {
            "value"
        }, s, new String[] {
            s1
        }, null);
_L3:
        if (!((Cursor) (obj)).moveToNext()) goto _L2; else goto _L1
_L1:
        String s2 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("value"));
        Object obj2;
        obj2 = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj2 = new Vector();
        ((Vector) (obj2)).add(s2);
        obj1 = obj2;
          goto _L3
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
_L5:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((Vector) (obj1));
        obj;
        obj1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private Vector _getMarketingConditions(int i)
    {
        Object obj2 = null;
        Object obj = mProvider.query("marketing_conditions", null, String.format("%s = ?", new Object[] {
            "rule_id_ref"
        }), new String[] {
            Integer.toString(i)
        }, null);
_L3:
        if (!((Cursor) (obj)).moveToNext()) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        Vector vector;
        i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
        s = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("attribute_name"));
        s1 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("operator"));
        vector = _getMarketingConditionValues(i);
        Object obj1;
        obj1 = obj2;
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj1 = new Vector();
        obj2 = new MarketingCondition(s, s1, vector);
        ((MarketingCondition) (obj2)).setPackageName(mLocalyticsDao.getAppContext().getPackageName());
        ((Vector) (obj1)).add(obj2);
        obj2 = obj1;
          goto _L3
        obj2;
        obj1 = obj;
        obj = obj2;
_L5:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return ((Vector) (obj2));
        obj;
        obj1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private List _getMarketingMessageMaps(String s)
    {
        String s1;
        MarketingMessage marketingmessage;
        LinkedList linkedlist;
        int i;
        i = 0;
        linkedlist = new LinkedList();
        marketingmessage = null;
        s1 = marketingmessage;
        String s2 = Long.toString(mLocalyticsDao.getCurrentTimeMillis() / 1000L);
        s1 = marketingmessage;
        String s3 = String.format("SELECT * FROM %s AS r LEFT OUTER JOIN %s AS re ON r.%s=re.%s WHERE %s > ? AND %s = ? GROUP BY r.%s;", new Object[] {
            "marketing_rules", "marketing_ruleevent", "_id", "rule_id_ref", "expiration", "event_name", "_id"
        });
        s1 = marketingmessage;
        s = mProvider.mDb.rawQuery(s3, new String[] {
            s2, s
        });
_L2:
        s1 = s;
        if (i >= s.getCount())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        s.moveToPosition(i);
        s1 = s;
        marketingmessage = new MarketingMessage();
        s1 = s;
        marketingmessage.put("_id", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("_id"))));
        s1 = s;
        marketingmessage.put("campaign_id", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("campaign_id"))));
        s1 = s;
        marketingmessage.put("expiration", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("expiration"))));
        s1 = s;
        marketingmessage.put("display_seconds", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("display_seconds"))));
        s1 = s;
        marketingmessage.put("display_session", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("display_session"))));
        s1 = s;
        marketingmessage.put("version", s.getString(s.getColumnIndexOrThrow("version")));
        s1 = s;
        marketingmessage.put("phone_location", s.getString(s.getColumnIndexOrThrow("phone_location")));
        s1 = s;
        marketingmessage.put("phone_size_width", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("phone_size_width"))));
        s1 = s;
        marketingmessage.put("phone_size_height", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("phone_size_height"))));
        s1 = s;
        marketingmessage.put("tablet_location", s.getString(s.getColumnIndexOrThrow("tablet_location")));
        s1 = s;
        marketingmessage.put("tablet_size_width", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("tablet_size_width"))));
        s1 = s;
        marketingmessage.put("tablet_size_height", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("tablet_size_height"))));
        s1 = s;
        marketingmessage.put("time_to_display", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("time_to_display"))));
        s1 = s;
        marketingmessage.put("internet_required", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("internet_required"))));
        s1 = s;
        marketingmessage.put("ab_test", s.getString(s.getColumnIndexOrThrow("ab_test")));
        s1 = s;
        marketingmessage.put("rule_name_non_unique", s.getString(s.getColumnIndexOrThrow("rule_name_non_unique")));
        s1 = s;
        marketingmessage.put("location", s.getString(s.getColumnIndexOrThrow("location")));
        s1 = s;
        marketingmessage.put("devices", s.getString(s.getColumnIndexOrThrow("devices")));
        s1 = s;
        marketingmessage.put("control_group", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("control_group"))));
        s1 = s;
        marketingmessage.put("schema_version", Integer.valueOf(s.getInt(s.getColumnIndexOrThrow("schema_version"))));
        s1 = s;
        linkedlist.add(marketingmessage);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s != null)
        {
            s.close();
        }
        return linkedlist;
        s;
        if (s1 != null)
        {
            s1.close();
        }
        throw s;
    }

    private String _getRemoteFileURL(MarketingMessage marketingmessage)
    {
        String s = (String)marketingmessage.get("devices");
        if (s.compareTo("tablet") == 0)
        {
            return (String)marketingmessage.get("tablet_location");
        } else
        {
            s.compareTo("both");
            return (String)marketingmessage.get("phone_location");
        }
    }

    private int _getRuleIdFromCampaignId(int i)
    {
        Object obj;
        obj = mProvider;
        String s = String.format("%s = ?", new Object[] {
            "campaign_id"
        });
        String s1 = Integer.toString(i);
        obj = ((BaseProvider) (obj)).query("marketing_rules", new String[] {
            "_id"
        }, s, new String[] {
            s1
        }, null);
        if (!((Cursor) (obj)).moveToFirst()) goto _L2; else goto _L1
_L1:
        i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return i;
        Exception exception;
        exception;
        obj = null;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        i = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private String _getUnzipFileDirPath(int i)
    {
        Object obj;
label0:
        {
            obj = new StringBuilder();
            ((StringBuilder) (obj)).append(mLocalyticsDao.getAppContext().getFilesDir().getAbsolutePath());
            ((StringBuilder) (obj)).append(File.separator);
            ((StringBuilder) (obj)).append(".localytics");
            ((StringBuilder) (obj)).append(File.separator);
            ((StringBuilder) (obj)).append(mLocalyticsDao.getApiKey());
            ((StringBuilder) (obj)).append(File.separator);
            ((StringBuilder) (obj)).append(String.format("marketing_rule_%d", new Object[] {
                Integer.valueOf(i)
            }));
            String s = ((StringBuilder) (obj)).toString();
            File file = new File(s);
            if (file.exists())
            {
                obj = s;
                if (file.isDirectory())
                {
                    break label0;
                }
            }
            obj = s;
            if (!file.mkdirs())
            {
                Localytics.Log.w(String.format("Could not create the directory %s for saving the decompressed file.", new Object[] {
                    file.getAbsolutePath()
                }));
                obj = null;
            }
        }
        return ((String) (obj));
    }

    private String _getZipFileDirPath()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mLocalyticsDao.getAppContext().getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        stringbuilder.append(File.separator);
        stringbuilder.append(mLocalyticsDao.getApiKey());
        return stringbuilder.toString();
    }

    private void _handlePushReceived(Intent intent)
    {
        Object obj = intent.getExtras().getString("ll");
        if (obj != null) goto _L2; else goto _L1
_L1:
        Localytics.Log.w("Ignoring message that aren't from Localytics.");
_L4:
        return;
_L2:
        Object obj1;
        Object obj2;
        String s;
        int i;
        int j;
        boolean flag1;
        JSONObject jsonobject;
        String s1;
        String s2;
        HashMap hashmap;
        boolean flag;
        try
        {
            jsonobject = new JSONObject(((String) (obj)));
            j = jsonobject.getInt("ca");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Localytics.Log.w("Failed to get campaign id from payload, ignoring message");
            return;
        }
        s = intent.getExtras().getString("message");
        flag1 = mLocalyticsDao.isPushDisabled();
        if (!TextUtils.isEmpty(s))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!flag1 && i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s2 = jsonobject.getString("cr");
        s1 = jsonobject.optString("v", "1");
        obj = jsonobject.optString("t", null);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            if (i != 0)
            {
                obj = "Alert";
            } else
            {
                obj = "Silent";
            }
        }
        if (mLocalyticsDao.isAutoIntegrate())
        {
            if (mLocalyticsDao.isAppInForeground())
            {
                obj1 = "Foreground";
            } else
            {
                obj1 = "Background";
            }
        } else
        {
            obj1 = "Not Available";
        }
          goto _L3
_L6:
        hashmap = new HashMap();
        hashmap.put("Campaign ID", String.valueOf(j));
        hashmap.put("Creative ID", s2);
        hashmap.put("Creative Type", obj);
        hashmap.put("Creative Displayed", obj2);
label0:
        {
            if (flag1)
            {
                obj = "No";
            } else
            {
                obj = "Yes";
            }
            try
            {
                hashmap.put("Push Notifications Enabled", obj);
                hashmap.put("App Context", obj1);
                hashmap.put("Schema Version - Client", "3");
                hashmap.put("Schema Version - Server", s1);
                if (jsonobject.optInt("x", 0) == 0)
                {
                    mLocalyticsDao.tagEvent("Localytics Push Received", hashmap);
                    mLocalyticsDao.upload();
                }
            }
            catch (JSONException jsonexception)
            {
                Localytics.Log.w("Failed to get campaign id or creative id from payload");
            }
            if (flag)
            {
                break label0;
            }
            if (flag1)
            {
                Localytics.Log.w("Got push notification while push is disabled.");
            }
            if (i == 0)
            {
                Localytics.Log.w("Got push notification without a message.");
                return;
            }
        }
          goto _L4
        obj2 = mLocalyticsDao.getAppContext();
        jsonexception = "";
        i = DatapointHelper.getLocalyticsNotificationIcon(((Context) (obj2)));
        obj1 = ((Context) (obj2)).getPackageManager().getApplicationInfo(((Context) (obj2)).getPackageName(), 0);
        obj1 = ((Context) (obj2)).getPackageManager().getApplicationLabel(((android.content.pm.ApplicationInfo) (obj1)));
        jsonexception = ((JSONException) (obj1));
_L5:
        obj1 = new Intent(((Context) (obj2)), com/localytics/android/PushTrackingActivity);
        ((Intent) (obj1)).putExtras(intent);
        intent = PendingIntent.getActivity(((Context) (obj2)), 0, ((Intent) (obj1)), 0x8000000);
        jsonexception = (new bq(((Context) (obj2)))).a(i).a(jsonexception).b(s);
        jsonexception.d = intent;
        ((bq) (jsonexception)).B.defaults = -1;
        intent = ((bq) (jsonexception)).B;
        intent.flags = ((Notification) (intent)).flags | 1;
        intent = jsonexception.a((new bp()).a(s)).a();
        ((NotificationManager)((Context) (obj2)).getSystemService("notification")).notify(j, bl.a().a(intent));
        return;
        obj1;
        Localytics.Log.w("Failed to get application name, icon, or launch intent");
        if (true) goto _L5; else goto _L3
_L3:
        if (i != 0)
        {
            if (flag1)
            {
                obj2 = "No";
            } else
            {
                obj2 = "Yes";
            }
        } else
        {
            obj2 = "Not Applicable";
        }
          goto _L6
    }

    private boolean _isConnectingToInternet()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)mLocalyticsDao.getAppContext().getSystemService("connectivity");
        if (connectivitymanager != null)
        {
            NetworkInfo anetworkinfo[] = connectivitymanager.getAllNetworkInfo();
            if (anetworkinfo != null)
            {
                int j = anetworkinfo.length;
                for (int i = 0; i < j; i++)
                {
                    if (anetworkinfo[i].getState() == android.net.NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean _isMarketingMessageSatisfiedConditions(MarketingMessage marketingmessage, Map map)
    {
label0:
        {
            marketingmessage = _getMarketingConditions(_getRuleIdFromCampaignId(((Integer)marketingmessage.get("campaign_id")).intValue()));
            if (marketingmessage == null)
            {
                break label0;
            }
            marketingmessage = marketingmessage.iterator();
            do
            {
                if (!marketingmessage.hasNext())
                {
                    break label0;
                }
            } while (((MarketingCondition)marketingmessage.next()).isSatisfiedByAttributes(map));
            return false;
        }
        return true;
    }

    private ContentValues _parseMarketingMessage(MarketingMessage marketingmessage)
    {
        int i = 1;
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("campaign_id", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "campaign_id")));
        contentvalues.put("expiration", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "expiration")));
        contentvalues.put("display_seconds", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "display_seconds")));
        contentvalues.put("display_session", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "display_session")));
        contentvalues.put("version", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "version")));
        contentvalues.put("phone_location", JsonHelper.getSafeStringFromMap(marketingmessage, "phone_location"));
        Map map = JsonHelper.getSafeMapFromMap(marketingmessage, "phone_size");
        contentvalues.put("phone_size_width", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map, "width")));
        contentvalues.put("phone_size_height", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map, "height")));
        map = JsonHelper.getSafeMapFromMap(marketingmessage, "tablet_size");
        contentvalues.put("tablet_location", JsonHelper.getSafeStringFromMap(marketingmessage, "tablet_location"));
        contentvalues.put("tablet_size_width", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map, "width")));
        contentvalues.put("tablet_size_height", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(map, "height")));
        contentvalues.put("time_to_display", Integer.valueOf(1));
        if (!JsonHelper.getSafeBooleanFromMap(marketingmessage, "internet_required"))
        {
            i = 0;
        }
        contentvalues.put("internet_required", Integer.valueOf(i));
        contentvalues.put("ab_test", JsonHelper.getSafeStringFromMap(marketingmessage, "ab"));
        contentvalues.put("rule_name_non_unique", JsonHelper.getSafeStringFromMap(marketingmessage, "rule_name"));
        contentvalues.put("rule_name", UUID.randomUUID().toString());
        contentvalues.put("location", JsonHelper.getSafeStringFromMap(marketingmessage, "location"));
        contentvalues.put("devices", JsonHelper.getSafeStringFromMap(marketingmessage, "devices"));
        contentvalues.put("control_group", Integer.valueOf(JsonHelper.getSafeIntegerFromMap(marketingmessage, "control_group")));
        if (mConfigurations != null)
        {
            i = JsonHelper.getSafeIntegerFromMap(mConfigurations, "schema_version");
            if (i > 0)
            {
                contentvalues.put("schema_version", Integer.valueOf(i));
            }
        }
        return contentvalues;
    }

    private MarketingMessage _retrieveDisplayingCandidate(List list, Map map)
    {
label0:
        {
            Iterator iterator = list.iterator();
            list = null;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MarketingMessage marketingmessage = (MarketingMessage)iterator.next();
                boolean flag;
                if (((Integer)marketingmessage.get("internet_required")).intValue() == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if ((!flag || _isConnectingToInternet()) && _isMarketingMessageSatisfiedConditions(marketingmessage, map))
                {
                    list = marketingmessage;
                }
            } while (true);
            if (list != null)
            {
                map = list;
                if (_updateDisplayingCandidate(list))
                {
                    break label0;
                }
            }
            map = null;
        }
        return map;
    }

    private void _saveMarketingConditions(long l, List list)
    {
        if (list != null)
        {
            long al[] = _getConditionIdFromRuleId(l);
            int k = al.length;
            for (int i = 0; i < k; i++)
            {
                long l1 = al[i];
                mProvider.remove("marketing_condition_values", String.format("%s = ?", new Object[] {
                    "condition_id_ref"
                }), new String[] {
                    Long.toString(l1)
                });
            }

            mProvider.remove("marketing_conditions", String.format("%s = ?", new Object[] {
                "rule_id_ref"
            }), new String[] {
                Long.toString(l)
            });
            list = list.iterator();
            while (list.hasNext()) 
            {
                List list1 = (List)list.next();
                ContentValues contentvalues = new ContentValues();
                contentvalues.put("attribute_name", (String)list1.get(0));
                contentvalues.put("operator", (String)list1.get(1));
                contentvalues.put("rule_id_ref", Long.valueOf(l));
                long l2 = mProvider.insert("marketing_conditions", contentvalues);
                int j = 2;
                while (j < list1.size()) 
                {
                    ContentValues contentvalues1 = new ContentValues();
                    contentvalues1.put("value", JsonHelper.getSafeStringFromValue(list1.get(j)));
                    contentvalues1.put("condition_id_ref", Long.valueOf(l2));
                    mProvider.insert("marketing_condition_values", contentvalues1);
                    j++;
                }
            }
        }
    }

    private void _tagAmpActionEventForControlGroup(MarketingMessage marketingmessage)
    {
        TreeMap treemap = new TreeMap();
        String s = marketingmessage.get("campaign_id").toString();
        String s1 = marketingmessage.get("rule_name_non_unique").toString();
        String s2 = marketingmessage.get("schema_version").toString();
        marketingmessage = (String)marketingmessage.get("ab_test");
        if (!TextUtils.isEmpty(marketingmessage))
        {
            treemap.put("ampAB", marketingmessage);
        }
        treemap.put("ampAction", "control");
        treemap.put("type", "Control");
        treemap.put("ampCampaignId", s);
        treemap.put("ampCampaign", s1);
        treemap.put("Schema Version - Client", "3");
        treemap.put("Schema Version - Server", s2);
        mLocalyticsDao.tagEvent("ampView", treemap);
    }

    private int _timeStringToSeconds(String s)
    {
        int i;
        int j;
        try
        {
            s = s.split(":");
            i = Integer.valueOf(s[0]).intValue();
            j = Integer.valueOf(s[1]).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return j * 60 + i * 3600;
    }

    private boolean _updateDisplayingCandidate(MarketingMessage marketingmessage)
    {
        String s = null;
        int i = ((Integer)marketingmessage.get("_id")).intValue();
        String s2 = _getZipFileDirPath();
        String s1 = _getUnzipFileDirPath(i);
        boolean flag = _getRemoteFileURL(marketingmessage).endsWith(".zip");
        if (!_doesCreativeExist(i, flag))
        {
            String s3 = MarketingDownloader.getRemoteFileURL(marketingmessage);
            String s4 = MarketingDownloader.getLocalFileURL(i, flag, mLocalyticsDao.getAppContext(), mLocalyticsDao.getApiKey());
            if (!TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
            {
                MarketingDownloader.downloadFile(s3, s4, true, mLocalyticsDao.getProxy());
            }
        }
        if (flag)
        {
            if (_decompressZipFile(s2, s1, String.format("amp_rule_%d.zip", new Object[] {
    Integer.valueOf(i)
})))
            {
                s = (new StringBuilder("file://")).append(s1).append(File.separator).append("index.html").toString();
            }
        } else
        {
            s = (new StringBuilder("file://")).append(s1).append(File.separator).append("index.html").toString();
        }
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        s2 = (String)marketingmessage.get("devices");
        int j;
        if (s2.equals("tablet"))
        {
            j = ((Integer)marketingmessage.get("tablet_size_width")).intValue();
            i = ((Integer)marketingmessage.get("tablet_size_height")).intValue();
        } else
        {
            s2.equals("both");
            j = ((Integer)marketingmessage.get("phone_size_width")).intValue();
            i = ((Integer)marketingmessage.get("phone_size_height")).intValue();
        }
        marketingmessage.put("html_url", s);
        marketingmessage.put("base_path", s1);
        marketingmessage.put("display_width", Float.valueOf(j));
        marketingmessage.put("display_height", Float.valueOf(i));
        return true;
    }

    private void setMarketingMessageAsNotDisplayed(int i)
    {
        queueMessage(obtainMessage(205, Integer.valueOf(i)));
    }

    boolean _additionalFCDatesAndTimesRulesValidation(List list, SimpleDateFormat simpledateformat)
    {
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        list = list.iterator();
_L2:
        Map map;
        if (!list.hasNext())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        map = (Map)list.next();
        if (!simpledateformat.parse((String)map.get(Constants.START_KEY)).after(simpledateformat.parse((String)map.get(Constants.END_KEY)))) goto _L2; else goto _L1
_L1:
        throw new Exception();
        list;
        return false;
        return true;
    }

    boolean _additionalFCDisplayFrequencyRulesValidation(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            Map map;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                map = (Map)list.next();
            } while (((Integer)map.get(Constants.DAYS_KEY)).intValue() > 0 && ((Integer)map.get(Constants.COUNT_KEY)).intValue() > 0);
            return false;
        }
        return true;
    }

    boolean _additionalFCWeekdaysRulesValidation(List list)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            if (list.size() > 7)
            {
                return false;
            }
            list = list.iterator();
            Integer integer;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                integer = (Integer)list.next();
            } while (integer.intValue() >= 0 && integer.intValue() <= 6);
            return false;
        }
        return true;
    }

    Map _augmentBlackoutRule(Map map)
    {
        HashMap hashmap = new HashMap(map);
        boolean flag = map.containsKey(Constants.DATES_KEY);
        boolean flag1 = map.containsKey(Constants.WEEKDAYS_KEY);
        boolean flag2 = map.containsKey(Constants.TIMES_KEY);
        if ((flag || flag1) && !flag2)
        {
            hashmap.put(Constants.TIMES_KEY, new ArrayList(AUGMENTED_BLACKOUT_TIMES_RULE));
        } else
        if (flag2 && !flag && !flag1)
        {
            hashmap.put(Constants.WEEKDAYS_KEY, new ArrayList(AUGMENTED_BLACKOUT_WEEKDAYS_RULE));
            return hashmap;
        }
        return hashmap;
    }

    boolean _checkFrequencyCappingRuleArray(List list, String as[])
    {
        if (list != null)
        {
            if (list.size() <= 0)
            {
                return false;
            }
            if (as.length > 0)
            {
                int j = as.length;
                int i = 0;
                do
                {
                    if (i >= j)
                    {
                        break;
                    }
                    String s = as[i];
                    for (Iterator iterator = list.iterator(); iterator.hasNext();)
                    {
                        if (!((Map)iterator.next()).containsKey(s))
                        {
                            return false;
                        }
                    }

                    i++;
                } while (true);
            }
        }
        return true;
    }

    boolean _deleteFrequencyCappingRule(Integer integer)
    {
        try
        {
            mProvider.remove("frequency_capping_rules", String.format("%s = ?", new Object[] {
                "campaign_id"
            }), new String[] {
                String.valueOf(integer)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Integer integer)
        {
            return false;
        }
        return true;
    }

    protected void _deleteUploadedData(int i)
    {
    }

    List _filterMarketingMessagesDisqualifiedByFrequencyCappingRules(List list)
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); hashset.add((Integer)((MarketingMessage)iterator.next()).get("campaign_id"))) { }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getDisqualifiedCampaigns(FrequencyCappingFilter.MAX_COUNT, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getDisqualifiedCampaigns(FrequencyCappingFilter.FREQUENCY, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getDisqualifiedCampaigns(FrequencyCappingFilter.BLACKOUT, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getGloballyDisqualifiedCampaigns(FrequencyCappingFilter.FREQUENCY, hashset));
        }
        if (hashset.size() > 0)
        {
            hashset.removeAll(_getGloballyDisqualifiedCampaigns(FrequencyCappingFilter.BLACKOUT, hashset));
        }
        LinkedList linkedlist = new LinkedList();
        if (hashset.size() > 0)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                MarketingMessage marketingmessage = (MarketingMessage)list.next();
                if (hashset.contains(Integer.valueOf(((Integer)marketingmessage.get("campaign_id")).intValue())))
                {
                    linkedlist.add(marketingmessage);
                }
            } while (true);
        }
        return linkedlist;
    }

    protected TreeMap _getDataToUpload()
    {
        TreeMap treemap = new TreeMap();
        treemap.put(Integer.valueOf(0), "");
        return treemap;
    }

    Set _getDisqualifiedCampaigns(FrequencyCappingFilter frequencycappingfilter, Set set)
    {
        switch (_cls25..SwitchMap.com.localytics.android.MarketingHandler.FrequencyCappingFilter[frequencycappingfilter.ordinal()])
        {
        default:
            return new HashSet();

        case 1: // '\001'
            return _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT fc.%s FROM %s AS fc JOIN %s AS cd ON fc.%s=cd.%s WHERE cd.%s in (%s) GROUP BY fc.%s HAVING count(*) >= fc.%s;", new Object[] {
                "campaign_id", "frequency_capping_rules", "campaigns_displayed", "campaign_id", "campaign_id", "campaign_id", TextUtils.join(",", set), "campaign_id", "max_display_count"
            }));

        case 2: // '\002'
            return _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT DISTINCT fc.%s FROM %s AS fc JOIN %s AS df ON fc.%s=df.%s JOIN %s AS cd ON fc.%s=cd.%s WHERE (cd.%s BETWEEN datetime('%s','-'||df.%s||' days') AND datetime('%s')) AND fc.%s in (%s) GROUP BY df.%s HAVING count(cd.%s) >= df.%s;", new Object[] {
                "campaign_id", "frequency_capping_rules", "frequency_capping_display_frequencies", "_id", "frequency_id", "campaigns_displayed", "campaign_id", "campaign_id", "date", mLocalyticsDao.getTimeStringForSQLite(), 
                "days", mLocalyticsDao.getTimeStringForSQLite(), "campaign_id", TextUtils.join(",", set), "_id", "date", "count"
            }));

        case 3: // '\003'
            frequencycappingfilter = mLocalyticsDao.getCalendar();
            break;
        }
        int i = frequencycappingfilter.get(7);
        int j = (frequencycappingfilter.get(11) * 60 + frequencycappingfilter.get(12)) * 60 + frequencycappingfilter.get(13);
        frequencycappingfilter = _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT fc.%s FROM %s AS fc, %s AS d, %s AS t WHERE ((fc.%s=t.%s) AND (fc.%s=d.%s)) AND (d.%s=t.%s) AND (datetime('%s','localtime') BETWEEN d.%s and d.%s) AND (? BETWEEN t.%s AND t.%s) AND fc.%s IN (%s);", new Object[] {
            "campaign_id", "frequency_capping_rules", "frequency_capping_blackout_dates", "frequency_capping_blackout_times", "_id", "frequency_id", "_id", "frequency_id", "rule_group_id", "rule_group_id", 
            mLocalyticsDao.getTimeStringForSQLite(), "start", "end", "start", "end", "campaign_id", TextUtils.join(",", set)
        }), new String[] {
            String.valueOf(j)
        });
        frequencycappingfilter.addAll(_getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT fc.%s FROM %s AS fc, %s AS w, %s AS t WHERE ((fc.%s=t.%s) AND (fc.%s=w.%s)) AND (w.%s=t.%s) AND (w.%s=?)  AND (? BETWEEN t.%s AND t.%s) AND fc.%s IN (%s);", new Object[] {
            "campaign_id", "frequency_capping_rules", "frequency_capping_blackout_weekdays", "frequency_capping_blackout_times", "_id", "frequency_id", "_id", "frequency_id", "rule_group_id", "rule_group_id", 
            "day", "start", "end", "campaign_id", TextUtils.join(",", set)
        }), new String[] {
            String.valueOf(i - 1), String.valueOf(j)
        }));
        return frequencycappingfilter;
    }

    Set _getGloballyDisqualifiedCampaigns(FrequencyCappingFilter frequencycappingfilter, Set set)
    {
        Cursor cursor = mProvider.query("frequency_capping_rules", null, "campaign_id = ?", new String[] {
            "-1"
        }, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        int i = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
_L15:
        if (cursor != null)
        {
            cursor.close();
        }
        if (i == -1) goto _L4; else goto _L3
_L3:
        Object obj = cursor;
        int j = _cls25..SwitchMap.com.localytics.android.MarketingHandler.FrequencyCappingFilter[frequencycappingfilter.ordinal()];
        j;
        JVM INSTR tableswitch 2 3: default 112
    //                   2 152
    //                   3 338;
           goto _L5 _L6 _L7
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
_L4:
        frequencycappingfilter = new HashSet();
_L10:
        return frequencycappingfilter;
        frequencycappingfilter;
        cursor = null;
_L13:
        if (cursor != null)
        {
            cursor.close();
        }
        throw frequencycappingfilter;
_L6:
        obj = cursor;
        Cursor cursor1 = mProvider.mDb.rawQuery(String.format("SELECT df.%s FROM %s AS fc JOIN %s AS df ON fc.%s = df.%s JOIN %s AS cd WHERE cd.%s = 0 AND fc.%s = ? AND (cd.%s BETWEEN datetime('%s','-'||df.%s||' days') AND datetime('%s')) GROUP BY df.%s HAVING count(cd.%s) >= df.%s;", new Object[] {
            "_id", "frequency_capping_rules", "frequency_capping_display_frequencies", "_id", "frequency_id", "campaigns_displayed", "ignore_global", "campaign_id", "date", mLocalyticsDao.getTimeStringForSQLite(), 
            "days", mLocalyticsDao.getTimeStringForSQLite(), "_id", "date", "count"
        }), new String[] {
            "-1"
        });
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() <= 0) goto _L5; else goto _L8
_L8:
        obj = cursor1;
        set = _getIgnoresGlobalCampaigns(false, set);
        frequencycappingfilter = set;
        if (cursor1 == null) goto _L10; else goto _L9
_L9:
        cursor1.close();
        return set;
_L7:
        obj = cursor;
        frequencycappingfilter = mLocalyticsDao.getCalendar();
        obj = cursor;
        j = frequencycappingfilter.get(7);
        obj = cursor;
        int k = frequencycappingfilter.get(11);
        obj = cursor;
        int l = frequencycappingfilter.get(12);
        obj = cursor;
        k = frequencycappingfilter.get(13) + (k * 60 + l) * 60;
        obj = cursor;
        frequencycappingfilter = mProvider.mDb.rawQuery(String.format("SELECT * FROM %s AS d, %s AS t WHERE ((d.%s=?) AND (t.%s=?)) AND (d.%s=t.%s) AND (datetime('%s','localtime') BETWEEN d.%s and d.%s) AND (? BETWEEN t.%s AND t.%s);", new Object[] {
            "frequency_capping_blackout_dates", "frequency_capping_blackout_times", "frequency_id", "frequency_id", "rule_group_id", "rule_group_id", mLocalyticsDao.getTimeStringForSQLite(), "start", "end", "start", 
            "end"
        }), new String[] {
            String.valueOf(i), String.valueOf(i), String.valueOf(k)
        });
        obj = frequencycappingfilter;
        l = frequencycappingfilter.getCount();
        obj = frequencycappingfilter;
        frequencycappingfilter.close();
        obj = frequencycappingfilter;
        cursor1 = mProvider.mDb.rawQuery(String.format("SELECT * FROM %s AS w, %s AS t WHERE ((w.%s=?) AND (t.%s=?)) AND (w.%s=t.%s) AND (w.%s=?) AND (? BETWEEN t.%s AND t.%s);", new Object[] {
            "frequency_capping_blackout_weekdays", "frequency_capping_blackout_times", "frequency_id", "frequency_id", "rule_group_id", "rule_group_id", "day", "start", "end"
        }), new String[] {
            String.valueOf(i), String.valueOf(i), String.valueOf(j - 1), String.valueOf(k)
        });
        cursor = cursor1;
        obj = cursor1;
        if (cursor1.getCount() + l <= 0) goto _L5; else goto _L11
_L11:
        obj = cursor1;
        set = _getIgnoresGlobalCampaigns(false, set);
        frequencycappingfilter = set;
        if (cursor1 == null) goto _L10; else goto _L12
_L12:
        cursor1.close();
        return set;
        frequencycappingfilter;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw frequencycappingfilter;
        frequencycappingfilter;
          goto _L13
_L2:
        i = -1;
        if (true) goto _L15; else goto _L14
_L14:
    }

    Set _getIgnoresGlobalCampaigns(boolean flag, Set set)
    {
        int i = 1;
        if (!flag)
        {
            i = 0;
        }
        return _getCampaignIdsFromFrequencyCappingQuery(String.format("SELECT %s FROM %s WHERE %s = %s AND %s in (%s);", new Object[] {
            "campaign_id", "frequency_capping_rules", "ignore_global", Integer.valueOf(i), "campaign_id", TextUtils.join(",", set)
        }));
    }

    protected int _getMaxRowToUpload()
    {
        return 1;
    }

    MarketingMessage _getQualifiedMarketingMessageForTrigger(String s, Map map)
    {
        if (!Constants.isTestModeEnabled()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        String s1;
        s1 = s;
        if (!s.equals("open"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (sessionStartMarketingMessageShown || Constants.isTestModeEnabled())
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = "AMP Loaded";
        sessionStartMarketingMessageShown = true;
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        List list = _getMarketingMessageMaps(s1);
        s = list;
        if (list.size() == 0)
        {
            Context context = mLocalyticsDao.getAppContext();
            s = list;
            if (s1.startsWith(context.getPackageName()))
            {
                s = _getMarketingMessageMaps(s1.substring(context.getPackageName().length() + 1, s1.length()));
            }
        }
        return _retrieveDisplayingCandidate(_filterMarketingMessagesDisqualifiedByFrequencyCappingRules(s), map);
    }

    protected void _init()
    {
        mProvider = new MarketingProvider(siloName.toLowerCase(), mLocalyticsDao);
    }

    void _marketingTrigger(String s, Map map)
    {
label0:
        {
            s = _getQualifiedMarketingMessageForTrigger(s, map);
            if (s != null)
            {
                Integer integer = (Integer)s.get("campaign_id");
                Integer integer1 = (Integer)s.get("control_group");
                if (integer1 == null || integer1.intValue() != 1)
                {
                    break label0;
                }
                if (_setMarketingMessageAsDisplayed(integer.intValue()))
                {
                    _tagAmpActionEventForControlGroup(s);
                }
            }
            return;
        }
        _tryDisplayingInAppCampaign(s, map);
    }

    protected void _onUploadCompleted(String s)
    {
        int i;
        if (s != null)
        {
            i = s.hashCode();
        } else
        {
            i = lastMarketingMessagesHash;
        }
        if (i != lastMarketingMessagesHash)
        {
            try
            {
                s = JsonHelper.toMap(new JSONObject(s));
                _processConfigObject(s);
                _processMarketingObject(s);
                lastMarketingMessagesHash = i;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.w("JSONException", s);
            }
        }
        if (testCampaignsListAdapter != null)
        {
            (new _cls6()).start();
            testCampaignsListAdapter = null;
            return;
        } else
        {
            mLocalyticsDao.triggerInAppMessage("open");
            return;
        }
    }

    void _processConfigObject(Map map)
    {
        mConfigurations = (Map)map.get("config");
    }

    void _processMarketingObject(Map map)
    {
        Object obj = new ArrayList();
        Object obj1 = map.get("amp");
        if (obj1 != null)
        {
            for (obj1 = JsonHelper.toList((JSONArray)JsonHelper.toJSON(obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(new MarketingMessage((Map)((Iterator) (obj1)).next()))) { }
        }
        _removeDeactivatedMarketingMessages(((List) (obj)));
        _validateAndStoreFrequencyCappingRule(map, Integer.valueOf(-1));
        for (map = ((List) (obj)).iterator(); map.hasNext(); _validateAndStoreFrequencyCappingRule(((Map) (obj)), (Integer)((MarketingMessage) (obj)).get(Constants.CAMPAIGN_ID_KEY)))
        {
            obj = (MarketingMessage)map.next();
            _saveMarketingMessage(((MarketingMessage) (obj)));
        }

    }

    void _removeDeactivatedMarketingMessages(List list)
    {
        ArrayList arraylist;
        Vector vector;
        arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(Integer.valueOf(JsonHelper.getSafeIntegerFromMap((MarketingMessage)list.next(), "campaign_id")))) { }
        _deleteFrequencyCappingRule(Integer.valueOf(-1));
        vector = new Vector();
        list = mProvider.query("marketing_rules", null, null, null, null);
        int i = 0;
_L2:
        if (i >= list.getCount())
        {
            break; /* Loop/switch isn't completed */
        }
        list.moveToPosition(i);
        if (!arraylist.contains(Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("campaign_id")))))
        {
            MarketingMessage marketingmessage1 = new MarketingMessage();
            marketingmessage1.put("_id", Integer.valueOf(list.getColumnIndexOrThrow("_id")));
            marketingmessage1.put("campaign_id", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("campaign_id"))));
            marketingmessage1.put("expiration", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("expiration"))));
            marketingmessage1.put("display_seconds", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("display_seconds"))));
            marketingmessage1.put("display_session", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("display_session"))));
            marketingmessage1.put("version", list.getString(list.getColumnIndexOrThrow("version")));
            marketingmessage1.put("phone_location", list.getString(list.getColumnIndexOrThrow("phone_location")));
            marketingmessage1.put("phone_size_width", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("phone_size_width"))));
            marketingmessage1.put("phone_size_height", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("phone_size_height"))));
            marketingmessage1.put("tablet_location", list.getString(list.getColumnIndexOrThrow("tablet_location")));
            marketingmessage1.put("tablet_size_width", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("tablet_size_width"))));
            marketingmessage1.put("tablet_size_height", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("tablet_size_height"))));
            marketingmessage1.put("time_to_display", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("time_to_display"))));
            marketingmessage1.put("internet_required", Integer.valueOf(list.getInt(list.getColumnIndexOrThrow("internet_required"))));
            marketingmessage1.put("ab_test", list.getString(list.getColumnIndexOrThrow("ab_test")));
            marketingmessage1.put("rule_name_non_unique", list.getString(list.getColumnIndexOrThrow("rule_name_non_unique")));
            marketingmessage1.put("location", list.getString(list.getColumnIndexOrThrow("location")));
            marketingmessage1.put("devices", list.getString(list.getColumnIndexOrThrow("devices")));
            vector.add(marketingmessage1);
        }
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        list = null;
_L4:
        if (list != null)
        {
            list.close();
        }
        throw exception;
_L1:
        if (list != null)
        {
            list.close();
        }
        MarketingMessage marketingmessage;
        for (list = vector.iterator(); list.hasNext(); _deleteFrequencyCappingRule((Integer)marketingmessage.get("campaign_id")))
        {
            marketingmessage = (MarketingMessage)list.next();
            _destroyLocalMarketingMessage(marketingmessage);
        }

        mProvider.vacuumIfNecessary();
        return;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean _saveFrequencyCappingRule(Map map, Integer integer)
    {
        boolean flag1 = true;
        mProvider.mDb.beginTransaction();
        int i = (int)_saveFrequencyCappingRuleBase(map, integer);
        integer = (List)map.get(Constants.DISPLAY_FREQUENCIES_KEY);
        boolean flag;
        if (i > 0 && _saveFrequencyCappingRuleDisplayFrequency(integer, Integer.valueOf(i)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map = (List)map.get(Constants.BLACKOUT_RULES_KEY);
        if (!flag || !_saveFrequencyCappingRuleBlackout(map, Integer.valueOf(i)))
        {
            flag1 = false;
        }
        if (flag1)
        {
            mProvider.mDb.setTransactionSuccessful();
        }
        mProvider.mDb.endTransaction();
        return flag1;
    }

    long _saveFrequencyCappingRuleBase(Map map, Integer integer)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("campaign_id", integer);
        if (integer.intValue() != -1)
        {
            contentvalues.put("max_display_count", (Integer)map.get(Constants.MAX_DISPLAY_COUNT_KEY));
            contentvalues.put("ignore_global", (Integer)map.get(Constants.IGNORE_GLOBAL_KEY));
        } else
        {
            contentvalues.putNull("max_display_count");
            contentvalues.putNull("ignore_global");
        }
        return mProvider.mDb.replace("frequency_capping_rules", null, contentvalues);
    }

    boolean _saveFrequencyCappingRuleBlackout(List list, Integer integer)
    {
        if (list != null)
        {
            list = list.iterator();
            for (int i = 0; list.hasNext(); i++)
            {
                for (Map map = _augmentBlackoutRule((Map)list.next()); !_saveFrequencyCappingRuleBlackoutDates((List)map.get(Constants.DATES_KEY), integer, Integer.valueOf(i)) || !_saveFrequencyCappingRuleBlackoutWeekdays((List)map.get(Constants.WEEKDAYS_KEY), integer, Integer.valueOf(i)) || !_saveFrequencyCappingRuleBlackoutTimes((List)map.get(Constants.TIMES_KEY), integer, Integer.valueOf(i));)
                {
                    return false;
                }

            }

        }
        return true;
    }

    boolean _saveFrequencyCappingRuleBlackoutDates(List list, Integer integer, Integer integer1)
    {
        if (list != null)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                Map map = (Map)list.next();
                try
                {
                    mProvider.mDb.execSQL(String.format("INSERT INTO %s VALUES (?, ?, datetime(?,'start of day'), datetime(?,'start of day','1 day','-1 second'));", new Object[] {
                        "frequency_capping_blackout_dates"
                    }), new Object[] {
                        integer, integer1, map.get(Constants.START_KEY), map.get(Constants.END_KEY)
                    });
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    return false;
                }
            }

        }
        return true;
    }

    boolean _saveFrequencyCappingRuleBlackoutTimes(List list, Integer integer, Integer integer1)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            ContentValues contentvalues;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                Object obj = (Map)list.next();
                Integer integer2 = Integer.valueOf(_timeStringToSeconds((String)((Map) (obj)).get(Constants.START_KEY)));
                obj = Integer.valueOf(_timeStringToSeconds((String)((Map) (obj)).get(Constants.END_KEY)));
                if (integer2.intValue() == -1 || ((Integer) (obj)).intValue() == -1)
                {
                    return false;
                }
                contentvalues = new ContentValues();
                contentvalues.put("frequency_id", integer);
                contentvalues.put("rule_group_id", integer1);
                contentvalues.put("start", integer2);
                contentvalues.put("end", Integer.valueOf(((Integer) (obj)).intValue() + 59));
            } while (mProvider.insert("frequency_capping_blackout_times", contentvalues) > 0L);
            return false;
        }
        return true;
    }

    boolean _saveFrequencyCappingRuleBlackoutWeekdays(List list, Integer integer, Integer integer1)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            ContentValues contentvalues;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                Integer integer2 = (Integer)list.next();
                contentvalues = new ContentValues();
                contentvalues.put("frequency_id", integer);
                contentvalues.put("rule_group_id", integer1);
                contentvalues.put("day", integer2);
            } while (mProvider.insert("frequency_capping_blackout_weekdays", contentvalues) > 0L);
            return false;
        }
        return true;
    }

    boolean _saveFrequencyCappingRuleDisplayFrequency(List list, Integer integer)
    {
label0:
        {
            if (list == null)
            {
                break label0;
            }
            list = list.iterator();
            ContentValues contentvalues;
            do
            {
                if (!list.hasNext())
                {
                    break label0;
                }
                Map map = (Map)list.next();
                contentvalues = new ContentValues();
                contentvalues.put("frequency_id", integer);
                contentvalues.put("count", (Integer)map.get(Constants.COUNT_KEY));
                contentvalues.put("days", (Integer)map.get(Constants.DAYS_KEY));
            } while (mProvider.insert("frequency_capping_display_frequencies", contentvalues) > 0L);
            return false;
        }
        return true;
    }

    int _saveMarketingMessage(MarketingMessage marketingmessage)
    {
        Object obj2;
        int k;
        obj2 = null;
        if (!_validateMarketingMessage(marketingmessage))
        {
            return 0;
        }
        k = JsonHelper.getSafeIntegerFromMap(marketingmessage, "campaign_id");
        Object obj = mProvider.query("marketing_rules", PROJECTION_MARKETING_RULE_RECORD, String.format("%s = ?", new Object[] {
            "campaign_id"
        }), new String[] {
            Integer.toString(k)
        }, null);
        int i;
        int j;
        if (((Cursor) (obj)).moveToFirst())
        {
            j = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
            i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("version"));
            break MISSING_BLOCK_LABEL_105;
        }
          goto _L1
        marketingmessage;
        obj = null;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw marketingmessage;
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (j > 0)
        {
            Localytics.Log.w(String.format("Existing in-app rule already exists for this campaign\n\t campaignID = %d\n\t ruleID = %d", new Object[] {
                Integer.valueOf(k), Integer.valueOf(j)
            }));
            if (i >= JsonHelper.getSafeIntegerFromMap(marketingmessage, "version"))
            {
                Localytics.Log.w(String.format("No update needed. Campaign version has not been updated\n\t version: %d", new Object[] {
                    Integer.valueOf(i)
                }));
                return 0;
            }
            _destroyLocalMarketingMessage(marketingmessage);
        } else
        {
            Localytics.Log.w("In-app campaign not found. Creating a new one.");
        }
        obj = _parseMarketingMessage(marketingmessage);
        i = (int)mProvider.insert("marketing_rules", ((ContentValues) (obj)));
        if (i > 0)
        {
            _saveMarketingConditions(i, JsonHelper.getSafeListFromMap(marketingmessage, "conditions"));
            Object obj1;
            try
            {
                obj1 = JsonHelper.toList((JSONArray)JsonHelper.toJSON(marketingmessage.get("display_events")));
            }
            catch (JSONException jsonexception)
            {
                jsonexception = obj2;
            }
            if (obj1 != null)
            {
                _bindRuleToEvents(i, ((List) (obj1)));
            }
        }
        if (i > 0 && !Constants.isTestModeEnabled())
        {
            obj1 = MarketingDownloader.getRemoteFileURL(marketingmessage);
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                marketingmessage = MarketingDownloader.getLocalFileURL(i, ((String) (obj1)).endsWith(".zip"), mLocalyticsDao.getAppContext(), mLocalyticsDao.getApiKey());
            } else
            {
                marketingmessage = "";
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(marketingmessage))
            {
                Localytics.Log.v(String.format("Saving in-app message with remoteURL = %s and localUrl = %s", new Object[] {
                    obj1, marketingmessage
                }));
                MarketingDownloader.downloadFile(((String) (obj1)), marketingmessage, true, mLocalyticsDao.getProxy());
            }
        }
        return i;
        marketingmessage;
        if (true) goto _L2; else goto _L1
_L1:
        i = 0;
        j = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    boolean _setMarketingMessageAsDisplayed(int i)
    {
        Object obj;
        obj = mProvider;
        String s = String.format("%s = ?", new Object[] {
            "campaign_id"
        });
        obj = ((BaseProvider) (obj)).query("frequency_capping_rules", new String[] {
            "ignore_global"
        }, s, new String[] {
            String.valueOf(i)
        }, null);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_146;
        }
        int j = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("ignore_global"));
        mProvider.mDb.execSQL(String.format("INSERT INTO %s VALUES (?, datetime('%s'), ?);", new Object[] {
            "campaigns_displayed", mLocalyticsDao.getTimeStringForSQLite()
        }), new Integer[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return true;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return false;
        Exception exception;
        exception;
        obj = null;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    boolean _setMarketingMessageAsNotDisplayed(int i)
    {
        String s = String.valueOf(i);
        Object obj;
        obj = mProvider;
        String s1 = String.format("%s = ?", new Object[] {
            "campaign_id"
        });
        String s3 = String.format("%s DESC", new Object[] {
            "date"
        });
        obj = ((BaseProvider) (obj)).query("campaigns_displayed", new String[] {
            "date"
        }, s1, new String[] {
            s
        }, s3);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_174;
        }
        String s2 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("date"));
        i = mProvider.remove("campaigns_displayed", String.format("%s = ? AND %s = ?", new Object[] {
            "campaign_id", "date"
        }), new String[] {
            s, s2
        });
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return flag;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return false;
        Exception exception;
        exception;
        obj = null;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void _tryDisplayingInAppCampaign(final MarketingMessage marketingMessage, final Map jsCallbacks)
    {
        jsCallbacks = _getJavaScriptClientCallbacks(jsCallbacks);
        (new Handler(Looper.getMainLooper())).post(new _cls8());
    }

    boolean _validateAndStoreFrequencyCappingRule(Map map, Integer integer)
    {
        boolean flag1;
        flag1 = false;
        map = (Map)map.get(Constants.FREQUENCY_CAPPING_KEY);
        if (map == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (integer.intValue() == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!_validateFrequencyCappingRule(map, flag)) goto _L2; else goto _L3
_L3:
        flag = _saveFrequencyCappingRule(map, integer);
_L5:
        return flag;
_L2:
        flag = flag1;
        if (integer.intValue() != -1)
        {
            return _saveFrequencyCappingRule(new HashMap(DEFAULT_FREQUENCY_CAPPING_RULE), integer);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    boolean _validateFrequencyCappingRule(Map map, boolean flag)
    {
label0:
        {
            String as[];
            int j;
            if (flag)
            {
                as = GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS;
            } else
            {
                as = INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS;
            }
            j = as.length;
            for (int i = 0; i < j; i++)
            {
                if (!map.containsKey(as[i]))
                {
                    return false;
                }
            }

            Object obj = (List)map.get(Constants.DISPLAY_FREQUENCIES_KEY);
            if (!_checkFrequencyCappingRuleArray(((List) (obj)), new String[] {
    Constants.DAYS_KEY, Constants.COUNT_KEY
}))
            {
                return false;
            }
            if (!_additionalFCDisplayFrequencyRulesValidation(((List) (obj))))
            {
                return false;
            }
            map = (List)map.get(Constants.BLACKOUT_RULES_KEY);
            if (map == null)
            {
                break label0;
            }
            if (map.size() <= 0)
            {
                return false;
            }
            map = map.iterator();
            do
            {
                if (!map.hasNext())
                {
                    break label0;
                }
                obj = (Map)map.next();
                if (!((Map) (obj)).containsKey(Constants.TIMES_KEY) && !((Map) (obj)).containsKey(Constants.DATES_KEY) && !((Map) (obj)).containsKey(Constants.WEEKDAYS_KEY))
                {
                    return false;
                }
                List list = (List)((Map) (obj)).get(Constants.TIMES_KEY);
                if (!_checkFrequencyCappingRuleArray(list, new String[] {
    Constants.START_KEY, Constants.END_KEY
}))
                {
                    return false;
                }
                if (!_additionalFCDatesAndTimesRulesValidation(list, TIME_SDF))
                {
                    return false;
                }
                list = (List)((Map) (obj)).get(Constants.DATES_KEY);
                if (!_checkFrequencyCappingRuleArray(list, new String[] {
    Constants.START_KEY, Constants.END_KEY
}))
                {
                    return false;
                }
                if (!_additionalFCDatesAndTimesRulesValidation(list, DATE_SDF))
                {
                    return false;
                }
                obj = (List)((Map) (obj)).get(Constants.WEEKDAYS_KEY);
                if (obj != null && (((List) (obj)).size() <= 0 || ((List) (obj)).size() > 7))
                {
                    return false;
                }
            } while (_additionalFCWeekdaysRulesValidation(((List) (obj))));
            return false;
        }
        return true;
    }

    protected boolean _validateMarketingMessage(MarketingMessage marketingmessage)
    {
        int i = JsonHelper.getSafeIntegerFromMap(marketingmessage, "campaign_id");
        String s = JsonHelper.getSafeStringFromMap(marketingmessage, "rule_name");
        List list = JsonHelper.getSafeListFromMap(marketingmessage, "display_events");
        int j = JsonHelper.getSafeIntegerFromMap(marketingmessage, "expiration");
        marketingmessage = JsonHelper.getSafeStringFromMap(marketingmessage, "location");
        long l = mLocalyticsDao.getCurrentTimeMillis() / 1000L;
        return i != 0 && !TextUtils.isEmpty(s) && list != null && !TextUtils.isEmpty(marketingmessage) && ((long)j > l || Constants.isTestModeEnabled());
    }

    void dismissCurrentInAppMessage()
    {
        if (mFragmentManager != null) goto _L2; else goto _L1
_L1:
        android.support.v4.app.Fragment fragment;
        return;
_L2:
        if (!((fragment = mFragmentManager.a("marketing_dialog")) instanceof MarketingDialogFragment)) goto _L1; else goto _L3
_L3:
        ((MarketingDialogFragment)fragment).dismissCampaign();
        return;
        Exception exception;
        exception;
        LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", exception);
        return;
    }

    void displayMarketingMessage(String s, Map map, boolean flag)
    {
        int i = 1;
        if ("open".equals(s))
        {
            s = obtainMessage(201, ((Object) (new Object[] {
                s, null
            })));
            if (!flag)
            {
                i = 0;
            }
            queueMessageDelayed(s, (long)i * 10000L);
            return;
        } else
        {
            queueMessage(obtainMessage(201, ((Object) (new Object[] {
                s, map
            }))));
            return;
        }
    }

    SparseArray getDialogCallbacks()
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(1, new _cls16());
        sparsearray.put(2, new _cls17());
        sparsearray.put(16, new _cls18());
        sparsearray.put(17, new _cls19());
        return sparsearray;
    }

    Localytics.InAppMessageDismissButtonLocation getInAppDismissButtonLocation()
    {
        return MarketingDialogFragment.getInAppDismissButtonLocation();
    }

    List getMarketingMessages()
    {
        return getList(new _cls9());
    }

    protected BaseUploadThread getUploadThread(TreeMap treemap, String s)
    {
        return new MarketingDownloader(this, treemap, s, mLocalyticsDao);
    }

    protected void handleMessageExtended(final Message event)
    {
        switch (event.what)
        {
        case 202: 
        default:
            super.handleMessageExtended(event);
            return;

        case 201: 
            Localytics.Log.d("In-app handler received MESSAGE_INAPP_TRIGGER");
            Object aobj[] = (Object[])(Object[])event.obj;
            event = (String)aobj[0];
            final Map attributes = (Map)aobj[1];
            mProvider.runBatchTransaction(new _cls1());
            return;

        case 203: 
            Localytics.Log.d("In-app handler received MESSAGE_SHOW_INAPP_TEST");
            _upload(true, (String)event.obj);
            (new Handler(Looper.getMainLooper())).postDelayed(new _cls2(), 1000L);
            return;

        case 204: 
            Localytics.Log.d("In-app handler received MESSAGE_HANDLE_PUSH_RECEIVED");
            event = (Intent)event.obj;
            mProvider.runBatchTransaction(new _cls3());
            return;

        case 205: 
            Localytics.Log.d("Marketing handler received MESSAGE_SET_MARKETING_MESSAGE_AS_NOT_DISPLAYED");
            break;
        }
        final int campaignId = ((Integer)event.obj).intValue();
        mProvider.runBatchTransaction(new _cls4());
    }

    void handleNotificationReceived(Intent intent)
    {
        queueMessage(obtainMessage(204, intent));
    }

    void handlePushNotificationOpened(Intent intent)
    {
        if (intent != null && intent.getExtras() != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = intent.getExtras().getString("ll")) == null) goto _L1; else goto _L3
_L3:
        Object obj1;
        String s;
        String s1;
        String s2;
        try
        {
            obj = new JSONObject(((String) (obj)));
            s = ((JSONObject) (obj)).getString("ca");
            s1 = ((JSONObject) (obj)).getString("cr");
            s2 = ((JSONObject) (obj)).optString("v", "1");
            obj1 = ((JSONObject) (obj)).optString("t", null);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Localytics.Log.w("Failed to get campaign id or creative id from payload");
            return;
        }
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = "Alert";
        }
        if (s == null || s1 == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj1 = new HashMap();
        ((HashMap) (obj1)).put("Campaign ID", s);
        ((HashMap) (obj1)).put("Creative ID", s1);
        ((HashMap) (obj1)).put("Creative Type", obj);
        ((HashMap) (obj1)).put("Action", "Click");
        ((HashMap) (obj1)).put("Schema Version - Client", "3");
        ((HashMap) (obj1)).put("Schema Version - Server", s2);
        mLocalyticsDao.tagEvent("Localytics Push Opened", ((Map) (obj1)));
        intent.removeExtra("ll");
        return;
    }

    void handleTestModeIntent(final Intent campaign)
    {
        if (campaign == null)
        {
            throw new IllegalArgumentException("intent cannot be null");
        }
        Object obj = campaign.getData();
        if (obj != null && ((Uri) (obj)).getScheme() != null && ((Uri) (obj)).getScheme().equals((new StringBuilder("amp")).append(mLocalyticsDao.getApiKey()).toString()))
        {
            campaign = ((Uri) (obj)).getPath().substring(1);
            obj = ((Uri) (obj)).getHost();
            String as[] = campaign.split("[/]");
            if (as != null && as.length != 0 && !TextUtils.isEmpty(((CharSequence) (obj))) && ((String) (obj)).equalsIgnoreCase("testMode"))
            {
                if (as[0].equalsIgnoreCase("enabled"))
                {
                    mLocalyticsDao.setTestModeEnabled(true);
                    return;
                }
                if (as[0].equalsIgnoreCase("launch") && as[1].equalsIgnoreCase("push"))
                {
                    campaign = as[2];
                    final String creative = as[3];
                    final String customerID = mLocalyticsDao.getCustomerIdInMemory();
                    final Context appContext = mLocalyticsDao.getAppContext();
                    if (!TextUtils.isEmpty(campaign) && !TextUtils.isEmpty(creative))
                    {
                        (new _cls7()).execute(new Void[0]);
                        return;
                    }
                }
            }
        }
    }

    public void localyticsDidTagEvent(String s, Map map, long l)
    {
        mLocalyticsDao.triggerInAppMessage(s, map);
    }

    public void localyticsSessionDidOpen(boolean flag, boolean flag1, boolean flag2)
    {
        if (!flag2)
        {
            upload(mLocalyticsDao.getCustomerIdInMemory());
        }
        if (!Constants.isTestModeEnabled())
        {
            if (flag)
            {
                mLocalyticsDao.triggerInAppMessage("AMP First Run");
            }
            if (flag1)
            {
                mLocalyticsDao.triggerInAppMessage("AMP upgrade");
            }
            if (!flag2)
            {
                sessionStartMarketingMessageShown = false;
                mLocalyticsDao.triggerInAppMessage("open", null, true);
            }
        }
    }

    public void localyticsSessionWillClose()
    {
    }

    public void localyticsSessionWillOpen(boolean flag, boolean flag1, boolean flag2)
    {
    }

    void setDismissButtonImage(Bitmap bitmap)
    {
        MarketingDialogFragment.setDismissButtonImage(bitmap);
    }

    void setFragmentManager(ah ah1)
    {
        mFragmentManager = ah1;
    }

    void setInAppDismissButtonLocation(Localytics.InAppMessageDismissButtonLocation inappmessagedismissbuttonlocation)
    {
        MarketingDialogFragment.setInAppDismissButtonLocation(inappmessagedismissbuttonlocation);
    }

    boolean setMarketingMessageAsDisplayed(final int campaignId)
    {
        return getBool(new _cls5());
    }

    void showMarketingTest()
    {
        queueMessage(obtainMessage(203, mLocalyticsDao.getCustomerIdInMemory()));
    }

    static 
    {
        GLOBAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS = (new String[] {
            Constants.DISPLAY_FREQUENCIES_KEY
        });
        INDIVIDUAL_FREQUENCY_CAPPING_RULE_REQUIRED_KEYS = (new String[] {
            Constants.MAX_DISPLAY_COUNT_KEY, Constants.IGNORE_GLOBAL_KEY
        });
        TIME_SDF = new SimpleDateFormat("HH:mm");
        DATE_SDF = new SimpleDateFormat("yyyy-MM-dd");
        AUGMENTED_BLACKOUT_TIMES_RULE = new ArrayList();
        HashMap hashmap = new HashMap();
        hashmap.put("start", "00:00");
        hashmap.put("end", "23:59");
        AUGMENTED_BLACKOUT_TIMES_RULE.add(hashmap);
        hashmap = new HashMap();
        DEFAULT_FREQUENCY_CAPPING_RULE = hashmap;
        hashmap.put("max_display_count", Integer.valueOf(1));
        DEFAULT_FREQUENCY_CAPPING_RULE.put("ignore_global", Integer.valueOf(1));
        TIME_SDF.setLenient(false);
        DATE_SDF.setLenient(false);
    }








/*
    static boolean access$402(MarketingHandler marketinghandler, boolean flag)
    {
        marketinghandler.mCampaignDisplaying = flag;
        return flag;
    }

*/



/*
    static MarketingRulesAdapter access$602(MarketingHandler marketinghandler, MarketingRulesAdapter marketingrulesadapter)
    {
        marketinghandler.testCampaignsListAdapter = marketingrulesadapter;
        return marketingrulesadapter;
    }

*/




    private class MessagingListenersSet extends BaseHandler.ListenersSet
        implements MessagingListener
    {

        final MarketingHandler this$0;

        public final void localyticsDidDismissInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsDidDismissInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsDidDisplayInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsDidDisplayInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsWillDismissInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsWillDismissInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsWillDisplayInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsWillDisplayInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private MessagingListenersSet()
        {
            this$0 = MarketingHandler.this;
            super(MarketingHandler.this);
        }

        MessagingListenersSet(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls10 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final MarketingRulesAdapter val$adapter;
        final TestModeListView val$listView;

        Object call(Object aobj[])
        {
            adapter.updateDataSet();
            listView.show(mFragmentManager, "marketing_test_mode_list");
            mFragmentManager.b();
            return null;
        }

        _cls10()
        {
            this$0 = MarketingHandler.this;
            adapter = marketingrulesadapter;
            listView = testmodelistview;
            super();
        }
    }


    private class _cls11 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final TestModeButton val$button;

        Object call(Object aobj[])
        {
            button.show(mFragmentManager, "marketing_test_mode_button");
            mFragmentManager.b();
            return null;
        }

        _cls11()
        {
            this$0 = MarketingHandler.this;
            button = testmodebutton;
            super();
        }
    }


    private class _cls12 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final MarketingRulesAdapter val$adapter;

        Object call(Object aobj[])
        {
            mLocalyticsDao.tagEvent("Test Mode Update Data");
            testCampaignsListAdapter = adapter;
            upload(mLocalyticsDao.getCustomerIdInMemory());
            return null;
        }

        _cls12()
        {
            this$0 = MarketingHandler.this;
            adapter = marketingrulesadapter;
            super();
        }
    }


    private class _cls13 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final Context val$appContext;

        Object call(Object aobj[])
        {
            class _cls1 extends AsyncTask
            {

                final _cls13 this$1;

                protected volatile Object doInBackground(Object aobj1[])
                {
                    return doInBackground((Void[])aobj1);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return mLocalyticsDao.getPushRegistrationId();
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    if (!TextUtils.isEmpty(s))
                    {
                        if (DatapointHelper.getApiLevel() < 11)
                        {
                            ((ClipboardManager)appContext.getSystemService("clipboard")).setText(s);
                        } else
                        {
                            ((android.content.ClipboardManager)appContext.getSystemService("clipboard")).setText(s);
                        }
                        Toast.makeText(appContext, (new StringBuilder()).append(s).append(" has been copied to the clipboard.").toString(), 1).show();
                        return;
                    } else
                    {
                        Toast.makeText(appContext, "No push token found. Please check your integration.", 1).show();
                        return;
                    }
                }

                _cls1()
                {
                    this$1 = _cls13.this;
                    super();
                }
            }

            (new _cls1()).execute(new Void[0]);
            return null;
        }

        _cls13()
        {
            this$0 = MarketingHandler.this;
            appContext = context;
            super();
        }
    }


    private class _cls14 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final Context val$appContext;

        Object call(Object aobj[])
        {
            aobj = mLocalyticsDao.getInstallationId();
            if (!TextUtils.isEmpty(((CharSequence) (aobj))))
            {
                if (DatapointHelper.getApiLevel() < 11)
                {
                    ((ClipboardManager)appContext.getSystemService("clipboard")).setText(((CharSequence) (aobj)));
                } else
                {
                    ((android.content.ClipboardManager)appContext.getSystemService("clipboard")).setText(((CharSequence) (aobj)));
                }
                Toast.makeText(appContext, (new StringBuilder()).append(((String) (aobj))).append(" has been copied to the clipboard.").toString(), 1).show();
            } else
            {
                Toast.makeText(appContext, "No install id found. Please check your integration.", 1).show();
            }
            return null;
        }

        _cls14()
        {
            this$0 = MarketingHandler.this;
            appContext = context;
            super();
        }
    }


    private class _cls15 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final Context val$appContext;

        Object call(final Object marketingMessage[])
        {
            marketingMessage = (MarketingMessage)marketingMessage[0];
            class _cls1 extends AsyncTask
            {

                final _cls15 this$1;
                final MarketingMessage val$marketingMessage;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return ((Object) (doInBackground((MarketingMessage[])aobj)));
                }

                protected transient Object[] doInBackground(MarketingMessage amarketingmessage[])
                {
                    if (_updateDisplayingCandidate(amarketingmessage[0]))
                    {
                        amarketingmessage = amarketingmessage[0];
                    } else
                    {
                        amarketingmessage = null;
                    }
                    return (new Object[] {
                        amarketingmessage, _getJavaScriptClientCallbacks(null)
                    });
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Object[])obj);
                }

                protected void onPostExecute(Object aobj[])
                {
                    MarketingMessage marketingmessage = (MarketingMessage)aobj[0];
                    aobj = (SparseArray)aobj[1];
                    if (marketingmessage == null)
                    {
                        MarketingDialogFragment marketingdialogfragment;
                        try
                        {
                            Toast.makeText(appContext, "The downloaded campaign file is broken.", 0).show();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", ((Exception) (aobj)));
                        }
                        break MISSING_BLOCK_LABEL_182;
                    }
                    if (mFragmentManager != null && mFragmentManager.a((new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString()) == null)
                    {
                        marketingdialogfragment = MarketingDialogFragment.newInstance();
                        marketingdialogfragment.setRetainInstance(false);
                        marketingdialogfragment.setData(marketingmessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(((SparseArray) (aobj)))).show(mFragmentManager, (new StringBuilder("marketing_dialog")).append(marketingmessage.get("campaign_id")).toString());
                        mFragmentManager.b();
                        return;
                    }
                }

                protected void onPreExecute()
                {
                    int i = ((Integer)marketingMessage.get("_id")).intValue();
                    boolean flag = _getRemoteFileURL(marketingMessage).endsWith(".zip");
                    if (!_doesCreativeExist(i, flag))
                    {
                        Toast.makeText(appContext, "Downloading the campaign...\nIt'll be shown in few seconds.", 0).show();
                    }
                }

                _cls1()
                {
                    this$1 = _cls15.this;
                    marketingMessage = marketingmessage;
                    super();
                }
            }

            (new _cls1()).execute(new MarketingMessage[] {
                marketingMessage
            });
            return null;
        }

        _cls15()
        {
            this$0 = MarketingHandler.this;
            appContext = context;
            super();
        }
    }


    private class _cls20 extends MarketingCallable
    {

        final MarketingHandler this$0;

        Object call(Object aobj[])
        {
            String s;
            String s1;
            Object obj;
            long l1;
            s = (String)aobj[0];
            s1 = (String)aobj[1];
            obj = (String)aobj[2];
            l1 = 0L;
            aobj = new HashMap();
            if (TextUtils.isEmpty(s))
            {
                LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "event cannot be null or empty");
            }
            try
            {
                if (!TextUtils.isEmpty(s1) && !MarketingHandler.JS_STRINGS_THAT_MEAN_NULL.contains(s1))
                {
                    java.util.Map.Entry entry1;
                    for (Iterator iterator1 = JsonHelper.toMap(new JSONObject(s1)).entrySet().iterator(); iterator1.hasNext(); ((Map) (aobj)).put(entry1.getKey(), String.valueOf(entry1.getValue())))
                    {
                        entry1 = (java.util.Map.Entry)iterator1.next();
                    }

                }
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to parse the json object in tagEventNative");
                return null;
            }
            long l = Long.valueOf(((String) (obj))).longValue();
_L4:
            if (s1 != null)
            {
                if (((Map) (aobj)).isEmpty())
                {
                    Localytics.Log.w("attributes is empty.  Did the caller make an error?");
                }
                if (((Map) (aobj)).size() > 50)
                {
                    Localytics.Log.w(String.format("attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                        Integer.valueOf(((Map) (aobj)).size()), Integer.valueOf(50)
                    }));
                }
                Iterator iterator = ((Map) (aobj)).entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj1 = (java.util.Map.Entry)iterator.next();
                    obj = (String)((java.util.Map.Entry) (obj1)).getKey();
                    obj1 = String.valueOf(((java.util.Map.Entry) (obj1)).getValue());
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty keys");
                    }
                    if (TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty values");
                    }
                } while (true);
            }
            break; /* Loop/switch isn't completed */
            Exception exception;
            exception;
            l = l1;
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                continue; /* Loop/switch isn't completed */
            }
            l = l1;
            if (MarketingHandler.JS_STRINGS_THAT_MEAN_NULL.contains(obj))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = JsonHelper.toMap(new JSONObject(((String) (obj)))).entrySet().iterator();
_L2:
            l = l1;
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            ((Map) (aobj)).put(entry.getKey(), String.valueOf(entry.getValue()));
            if (true) goto _L2; else goto _L1
_L1:
            JSONException jsonexception;
            jsonexception;
            l = l1;
            if (true) goto _L4; else goto _L3
_L3:
            mLocalyticsDao.tagEvent(s, ((Map) (aobj)), l);
            return null;
        }

        _cls20()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls21 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final Map val$customerIDs;

        Object call(Object aobj[])
        {
            if (customerIDs.isEmpty())
            {
                return null;
            }
            try
            {
                aobj = new JSONObject();
                java.util.Map.Entry entry;
                for (Iterator iterator = customerIDs.entrySet().iterator(); iterator.hasNext(); ((JSONObject) (aobj)).put((String)entry.getKey(), entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to get identifiers");
                return null;
            }
            aobj = ((JSONObject) (aobj)).toString();
            return ((Object) (aobj));
        }

        _cls21()
        {
            this$0 = MarketingHandler.this;
            customerIDs = map;
            super();
        }
    }


    private class _cls22 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final JSONObject val$jsonCustomDimensions;

        Object call(Object aobj[])
        {
            return jsonCustomDimensions.toString();
        }

        _cls22()
        {
            this$0 = MarketingHandler.this;
            jsonCustomDimensions = jsonobject;
            super();
        }
    }


    private class _cls23 extends MarketingCallable
    {

        final MarketingHandler this$0;
        final Map val$attributes;

        Object call(Object aobj[])
        {
            if (attributes == null)
            {
                return null;
            }
            if (attributes.size() == 0)
            {
                return null;
            }
            try
            {
                aobj = new JSONObject();
                java.util.Map.Entry entry;
                for (Iterator iterator = attributes.entrySet().iterator(); iterator.hasNext(); ((JSONObject) (aobj)).put((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator.next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Localytics.Log.w("[JavaScriptClient]: Failed to get attributes");
                return null;
            }
            aobj = ((JSONObject) (aobj)).toString();
            return ((Object) (aobj));
        }

        _cls23()
        {
            this$0 = MarketingHandler.this;
            attributes = map;
            super();
        }
    }


    private class _cls24 extends MarketingCallable
    {

        final MarketingHandler this$0;

        Object call(Object aobj[])
        {
            int i = ((Integer)aobj[0]).intValue();
            aobj = (String)aobj[1];
            mLocalyticsDao.setCustomDimension(i, ((String) (aobj)));
            return null;
        }

        _cls24()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class FrequencyCappingFilter extends Enum
    {

        private static final FrequencyCappingFilter $VALUES[];
        public static final FrequencyCappingFilter BLACKOUT;
        public static final FrequencyCappingFilter FREQUENCY;
        public static final FrequencyCappingFilter MAX_COUNT;

        public static FrequencyCappingFilter valueOf(String s)
        {
            return (FrequencyCappingFilter)Enum.valueOf(com/localytics/android/MarketingHandler$FrequencyCappingFilter, s);
        }

        public static FrequencyCappingFilter[] values()
        {
            return (FrequencyCappingFilter[])$VALUES.clone();
        }

        static 
        {
            FREQUENCY = new FrequencyCappingFilter("FREQUENCY", 0);
            MAX_COUNT = new FrequencyCappingFilter("MAX_COUNT", 1);
            BLACKOUT = new FrequencyCappingFilter("BLACKOUT", 2);
            $VALUES = (new FrequencyCappingFilter[] {
                FREQUENCY, MAX_COUNT, BLACKOUT
            });
        }

        private FrequencyCappingFilter(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls25
    {

        static final int $SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter[];

        static 
        {
            $SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter = new int[FrequencyCappingFilter.values().length];
            try
            {
                $SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter[FrequencyCappingFilter.MAX_COUNT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter[FrequencyCappingFilter.FREQUENCY.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$localytics$android$MarketingHandler$FrequencyCappingFilter[FrequencyCappingFilter.BLACKOUT.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls6 extends Thread
    {

        final MarketingHandler this$0;
        final MarketingRulesAdapter val$adapter;

        public void run()
        {
            class _cls1
                implements Runnable
            {

                final _cls6 this$1;

                public void run()
                {
                    adapter.updateDataSet();
                    adapter.notifyDataSetChanged();
                }

                _cls1()
                {
                    this$1 = _cls6.this;
                    super();
                }
            }

            (new Handler(Looper.getMainLooper())).post(new _cls1());
        }

        _cls6()
        {
            this$0 = MarketingHandler.this;
            adapter = marketingrulesadapter;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final MarketingHandler this$0;
        final SparseArray val$jsCallbacks;
        final MarketingMessage val$marketingMessage;

        public void run()
        {
            if (mFragmentManager != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (mFragmentManager.a("marketing_dialog") != null || mCampaignDisplaying) goto _L1; else goto _L3
_L3:
            mCampaignDisplaying = true;
            class _cls1 extends AsyncTask
            {

                final _cls8 this$1;
                final int val$campaignId;

                protected transient Boolean doInBackground(Void avoid[])
                {
                    return Boolean.valueOf(setMarketingMessageAsDisplayed(campaignId));
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(Boolean boolean1)
                {
                    if (boolean1.booleanValue())
                    {
                        if (mFragmentManager != null)
                        {
                            MarketingDialogFragment.newInstance().setData(marketingMessage).setCallbacks(getDialogCallbacks()).setJavaScriptClient(new JavaScriptClient(jsCallbacks)).show(mFragmentManager, "marketing_dialog");
                            if (!Constants.isTestModeEnabled())
                            {
                                ((MessagingListener)listeners).localyticsWillDisplayInAppMessage();
                            }
                            mFragmentManager.b();
                        } else
                        {
                            setMarketingMessageAsNotDisplayed(campaignId);
                        }
                    }
                    mCampaignDisplaying = false;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Boolean)obj);
                }

                _cls1()
                {
                    this$1 = _cls8.this;
                    campaignId = i;
                    super();
                }
            }

            (new _cls1()).execute(new Void[0]);
            return;
            Exception exception;
            exception;
            LocalyticsManager.throwOrLogError(java/lang/RuntimeException, "Localytics library threw an uncaught exception", exception);
            return;
        }

        _cls8()
        {
            this$0 = MarketingHandler.this;
            marketingMessage = marketingmessage;
            jsCallbacks = sparsearray;
            super();
        }
    }


    private class _cls16 extends MarketingCallable
    {

        final MarketingHandler this$0;

        public Object call(Object aobj[])
        {
            ((MessagingListener)listeners).localyticsDidDismissInAppMessage();
            return null;
        }

        _cls16()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls17 extends MarketingCallable
    {

        final MarketingHandler this$0;

        public Object call(Object aobj[])
        {
            String s = (String)aobj[0];
            aobj = (Map)aobj[1];
            mLocalyticsDao.tagEvent(s, ((Map) (aobj)));
            return null;
        }

        _cls17()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls18 extends MarketingCallable
    {

        final MarketingHandler this$0;

        public Object call(Object aobj[])
        {
            ((MessagingListener)listeners).localyticsDidDisplayInAppMessage();
            return null;
        }

        _cls18()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls19 extends MarketingCallable
    {

        final MarketingHandler this$0;

        public Object call(Object aobj[])
        {
            ((MessagingListener)listeners).localyticsWillDismissInAppMessage();
            return null;
        }

        _cls19()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls9
        implements Callable
    {

        final MarketingHandler this$0;

        public volatile Object call()
        {
            return call();
        }

        public List call()
        {
            Cursor cursor;
            ArrayList arraylist;
            cursor = null;
            arraylist = new ArrayList();
            Cursor cursor1 = mProvider.query("marketing_rules", null, null, null, "campaign_id");
            cursor = cursor1;
            while (cursor.moveToNext()) 
            {
                MarketingMessage marketingmessage = new MarketingMessage();
                marketingmessage.put("_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))));
                marketingmessage.put("campaign_id", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("campaign_id"))));
                marketingmessage.put("expiration", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("expiration"))));
                marketingmessage.put("display_seconds", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_seconds"))));
                marketingmessage.put("display_session", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("display_session"))));
                marketingmessage.put("version", cursor.getString(cursor.getColumnIndexOrThrow("version")));
                marketingmessage.put("phone_location", cursor.getString(cursor.getColumnIndexOrThrow("phone_location")));
                marketingmessage.put("phone_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_width"))));
                marketingmessage.put("phone_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("phone_size_height"))));
                marketingmessage.put("tablet_location", cursor.getString(cursor.getColumnIndexOrThrow("tablet_location")));
                marketingmessage.put("tablet_size_width", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_width"))));
                marketingmessage.put("tablet_size_height", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("tablet_size_height"))));
                marketingmessage.put("time_to_display", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("time_to_display"))));
                marketingmessage.put("internet_required", Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("internet_required"))));
                marketingmessage.put("ab_test", cursor.getString(cursor.getColumnIndexOrThrow("ab_test")));
                marketingmessage.put("rule_name_non_unique", cursor.getString(cursor.getColumnIndexOrThrow("rule_name_non_unique")));
                marketingmessage.put("location", cursor.getString(cursor.getColumnIndexOrThrow("location")));
                marketingmessage.put("devices", cursor.getString(cursor.getColumnIndexOrThrow("devices")));
                marketingmessage.put("control_group", cursor.getString(cursor.getColumnIndexOrThrow("control_group")));
                marketingmessage.put("schema_version", cursor.getString(cursor.getColumnIndexOrThrow("schema_version")));
                arraylist.add(marketingmessage);
            }
              goto _L1
            Object obj;
            obj;
_L4:
            Exception exception;
            if (cursor != null)
            {
                cursor.close();
                return null;
            } else
            {
                return null;
            }
_L1:
            if (cursor != null)
            {
                cursor.close();
                return arraylist;
            } else
            {
                return arraylist;
            }
            obj;
_L3:
            if (cursor != null)
            {
                cursor.close();
            }
            throw obj;
            obj;
            if (true) goto _L3; else goto _L2
_L2:
            exception;
            exception = null;
              goto _L4
        }

        _cls9()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final MarketingHandler this$0;
        final Map val$attributes;
        final String val$event;

        public void run()
        {
            _marketingTrigger(event, attributes);
        }

        _cls1()
        {
            this$0 = MarketingHandler.this;
            event = s;
            attributes = map;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final MarketingHandler this$0;

        public void run()
        {
            __showMarketingTest();
        }

        _cls2()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MarketingHandler this$0;
        final Intent val$intent;

        public void run()
        {
            _handlePushReceived(intent);
        }

        _cls3()
        {
            this$0 = MarketingHandler.this;
            intent = intent1;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final MarketingHandler this$0;
        final int val$campaignId;

        public void run()
        {
            _setMarketingMessageAsNotDisplayed(campaignId);
        }

        _cls4()
        {
            this$0 = MarketingHandler.this;
            campaignId = i;
            super();
        }
    }


    private class _cls7 extends AsyncTask
    {

        final MarketingHandler this$0;
        final Context val$appContext;
        final String val$campaign;
        final String val$creative;
        final String val$customerID;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return mLocalyticsDao.getPushRegistrationId();
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(final String pushRegID)
        {
            class _cls1 extends AsyncTask
            {

                final _cls7 this$1;
                final String val$pushRegID;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    Object obj;
                    Object obj1;
                    Object obj2;
                    String s;
                    obj = null;
                    obj1 = null;
                    if (TextUtils.isEmpty(pushRegID))
                    {
                        break MISSING_BLOCK_LABEL_251;
                    }
                    obj2 = mLocalyticsDao.getInstallationId();
                    s = String.format("http://pushapi.localytics.com/push_test?platform=android&type=prod&campaign=%s&creative=%s&token=%s&install_id=%s&client_ts=%s", new Object[] {
                        campaign, creative, pushRegID, obj2, Long.toString(Math.round((double)mLocalyticsDao.getCurrentTimeMillis() / 1000D))
                    });
                    avoid = ((Void []) (obj));
                    java.net.Proxy proxy = mLocalyticsDao.getProxy();
                    avoid = ((Void []) (obj));
                    obj = (HttpURLConnection)BaseUploadThread.createURLConnection(new URL(s), proxy);
                    ((HttpURLConnection) (obj)).setConnectTimeout(5000);
                    ((HttpURLConnection) (obj)).setReadTimeout(5000);
                    ((HttpURLConnection) (obj)).setDoOutput(false);
                    ((HttpURLConnection) (obj)).setRequestProperty("x-install-id", ((String) (obj2)));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-app-id", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-client-version", "androida_3.4.0");
                    ((HttpURLConnection) (obj)).setRequestProperty("x-app-version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
                    ((HttpURLConnection) (obj)).setRequestProperty("x-customer-id", customerID);
                    ((HttpURLConnection) (obj)).getInputStream();
                    if (obj != null)
                    {
                        ((HttpURLConnection) (obj)).disconnect();
                    }
                    avoid = null;
_L2:
                    return avoid;
                    avoid;
                    obj = obj1;
                    obj1 = avoid;
_L5:
                    avoid = ((Void []) (obj));
                    obj2 = new StringBuilder("Unfortunately, something went wrong. Push test activation was unsuccessful.");
                    avoid = ((Void []) (obj));
                    if (!Localytics.isLoggingEnabled())
                    {
                        break MISSING_BLOCK_LABEL_309;
                    }
                    avoid = ((Void []) (obj));
                    if (!(obj1 instanceof FileNotFoundException))
                    {
                        break MISSING_BLOCK_LABEL_309;
                    }
                    avoid = ((Void []) (obj));
                    ((StringBuilder) (obj2)).append("\n\nCause:\nPush registration token has not yet been processed. Please wait a few minutes and try again.");
                    avoid = ((Void []) (obj));
                    Localytics.Log.e("Activating push test has failed", ((Throwable) (obj1)));
                    avoid = ((Void []) (obj));
                    obj1 = ((StringBuilder) (obj2)).toString();
                    avoid = ((Void []) (obj1));
                    if (obj == null) goto _L2; else goto _L1
_L1:
                    ((HttpURLConnection) (obj)).disconnect();
                    return ((String) (obj1));
                    Exception exception;
                    exception;
                    obj = avoid;
                    avoid = exception;
_L4:
                    if (obj != null)
                    {
                        ((HttpURLConnection) (obj)).disconnect();
                    }
                    throw avoid;
                    avoid;
                    if (true) goto _L4; else goto _L3
_L3:
                    exception;
                      goto _L5
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    if (s != null)
                    {
                        Toast.makeText(appContext, s, 1).show();
                    }
                }

                protected void onPreExecute()
                {
                    if (!TextUtils.isEmpty(pushRegID))
                    {
                        Toast.makeText(appContext, "Push Test Activated\nYou should receive a notification soon.", 1).show();
                        return;
                    } else
                    {
                        Toast.makeText(appContext, "App isn't registered with GCM to receive push notifications. Please make sure that Localytics.registerPush(<PROJECT_ID>) has been called.", 1).show();
                        return;
                    }
                }

                _cls1()
                {
                    this$1 = _cls7.this;
                    pushRegID = s;
                    super();
                }
            }

            (new _cls1()).execute(new Void[0]);
        }

        _cls7()
        {
            this$0 = MarketingHandler.this;
            appContext = context;
            campaign = s;
            creative = s1;
            customerID = s2;
            super();
        }
    }


    private class _cls5
        implements Callable
    {

        final MarketingHandler this$0;
        final int val$campaignId;

        public Boolean call()
        {
            return Boolean.valueOf(_setMarketingMessageAsDisplayed(campaignId));
        }

        public volatile Object call()
        {
            return call();
        }

        _cls5()
        {
            this$0 = MarketingHandler.this;
            campaignId = i;
            super();
        }
    }

}
