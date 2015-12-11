// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseHandler, BaseProvider, AnalyticsListener, Constants, 
//            LocalyticsDao, DatapointHelper, ReflectionUtils, PushReceiver, 
//            ReferralUploader, LocalyticsManager, AnalyticsProvider, AnalyticsUploadHandler, 
//            BaseUploadThread

class AnalyticsHandler extends BaseHandler
{

    private static final int MESSAGE_CLOSE = 102;
    private static final int MESSAGE_DISABLE_PUSH = 112;
    private static final int MESSAGE_HANDLE_PUSH_REGISTRATION = 110;
    private static final int MESSAGE_OPEN = 101;
    private static final int MESSAGE_OPT_OUT = 108;
    private static final int MESSAGE_REGISTER_PUSH = 109;
    private static final int MESSAGE_SET_CUSTOM_DIMENSION = 107;
    private static final int MESSAGE_SET_IDENTIFIER = 105;
    private static final int MESSAGE_SET_LOCATION = 106;
    private static final int MESSAGE_SET_PUSH_REGID = 113;
    private static final int MESSAGE_SET_REFERRERID = 114;
    private static final int MESSAGE_TAG_EVENT = 103;
    private static final int MESSAGE_TAG_SCREEN = 104;
    private static final String PARAM_LOCALYTICS_REFERRER_TEST_MODE = "localytics_test_mode";
    private static final String PROJECTION_SET_CUSTOM_DIMENSION[] = {
        "custom_dimension_value"
    };
    private static final String PROJECTION_SET_IDENTIFIER[] = {
        "key", "value"
    };
    private static final String SELECTION_SET_CUSTOM_DIMENSION = String.format("%s = ?", new Object[] {
        "custom_dimension_key"
    });
    private static final String SELECTION_SET_IDENTIFIER = String.format("%s = ?", new Object[] {
        "key"
    });
    private static Location sLastLocation = null;
    private boolean mAppWasUpgraded;
    boolean mFirstSessionEver;
    boolean mReferrerTestModeEnabled;
    boolean mSentReferrerTestMode;
    private final List screenFlow = new ArrayList();

    AnalyticsHandler(LocalyticsDao localyticsdao, Looper looper)
    {
        super(localyticsdao, looper);
        mAppWasUpgraded = false;
        mFirstSessionEver = false;
        mReferrerTestModeEnabled = false;
        mSentReferrerTestMode = false;
        siloName = "Analytics";
        listeners = new AnalyticsListenersSet(null);
        queueMessage(obtainMessage(1));
    }

    private void _addLocationIDsAndCustomDimensions(JSONObject jsonobject, JSONObject jsonobject1, String s, String s1)
    {
        double d;
        double d1;
        if (sLastLocation == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        d = sLastLocation.getLatitude();
        d1 = sLastLocation.getLongitude();
        if (d == 0.0D || d1 == 0.0D)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        jsonobject.put("lat", d);
        jsonobject.put("lng", d1);
        jsonobject.put("cid", s);
        jsonobject.put("utp", s1);
        if (jsonobject1.length() > 0)
        {
            jsonobject.put("ids", jsonobject1);
        }
        jsonobject1 = mProvider.query("custom_dimensions", null, null, null, null);
        while (jsonobject1.moveToNext()) 
        {
            s = jsonobject1.getString(jsonobject1.getColumnIndexOrThrow("custom_dimension_key"));
            s1 = jsonobject1.getString(jsonobject1.getColumnIndexOrThrow("custom_dimension_value"));
            jsonobject.put(s.replace("custom_dimension_", "c"), s1);
        }
          goto _L1
        jsonobject;
_L3:
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        jsonobject1.close();
        throw jsonobject;
_L1:
        if (jsonobject1 != null)
        {
            try
            {
                jsonobject1.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        break; /* Loop/switch isn't completed */
        jsonobject;
        jsonobject1 = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void _close()
    {
        if (!_isSessionOpen())
        {
            Localytics.Log.w("Session was not open, so close is not possible.");
            return;
        } else
        {
            ((AnalyticsListener)listeners).localyticsSessionWillClose();
            _tagEvent("close");
            return;
        }
    }

    private void _dequeQueuedCloseSessionTag(boolean flag)
    {
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        Cursor cursor = mProvider.query("info", new String[] {
            "queued_close_session_blob", "queued_close_session_blob_upload_format"
        }, null, null, null);
        if (cursor.moveToFirst())
        {
            String s = cursor.getString(cursor.getColumnIndexOrThrow("queued_close_session_blob"));
            int i = cursor.getInt(cursor.getColumnIndexOrThrow("queued_close_session_blob_upload_format"));
            if (!TextUtils.isEmpty(s))
            {
                screenFlow.clear();
                contentvalues.put("blob", s);
                contentvalues.put("upload_format", Integer.valueOf(i));
                mProvider.insert("events", contentvalues);
                contentvalues.clear();
                mAppWasUpgraded = false;
                mFirstSessionEver = false;
            }
        }
        if (cursor != null)
        {
            cursor.close();
        }
        contentvalues.putNull("queued_close_session_blob");
        contentvalues.putNull("queued_close_session_blob_upload_format");
        contentvalues.put("last_session_close_time", Integer.valueOf(0));
        mProvider.update("info", contentvalues, null, null);
        return;
        Exception exception;
        exception;
        cursor = null;
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String _getCustomDimension(int i)
    {
        Object obj1 = null;
        if (i >= 0 && i <= 10) goto _L2; else goto _L1
_L1:
        obj1 = null;
_L6:
        return ((String) (obj1));
_L2:
        Object obj = getCustomDimensionAttributeKey(i);
        Cursor cursor = mProvider.query("custom_dimensions", PROJECTION_SET_CUSTOM_DIMENSION, SELECTION_SET_CUSTOM_DIMENSION, new String[] {
            obj
        }, null);
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        obj = cursor.getString(cursor.getColumnIndexOrThrow("custom_dimension_value"));
_L8:
        obj1 = obj;
        if (cursor == null) goto _L6; else goto _L5
_L5:
        cursor.close();
        return ((String) (obj));
        obj;
_L7:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
        obj;
        obj1 = cursor;
        if (true) goto _L7; else goto _L4
_L4:
        obj = null;
          goto _L8
    }

    private JSONObject _getIdentifiers()
    {
        JSONObject jsonobject = new JSONObject();
        Object obj = mProvider.query("identifiers", null, null, null, null);
        while (((Cursor) (obj)).moveToNext()) 
        {
            jsonobject.put(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("key")), ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("value")));
        }
          goto _L1
        Object obj1;
        obj1;
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return jsonobject;
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return jsonobject;
        obj;
        obj = null;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return jsonobject;
        obj1;
        if (true) goto _L3; else goto _L2
_L2:
        JSONException jsonexception;
        jsonexception;
        jsonexception = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void _handlePushRegistration(Intent intent)
    {
        String s = intent.getStringExtra("registration_id");
        if (_isPushDisabled())
        {
            Localytics.Log.v("GCM registered but push disabled: removing id");
            _setPushID(null);
        } else
        {
            if (intent.getStringExtra("error") != null)
            {
                Localytics.Log.v("GCM registration failed");
                return;
            }
            if (intent.getStringExtra("unregistered") != null)
            {
                Localytics.Log.v("GCM unregistered: removing id");
                _setPushID(null);
                return;
            }
            if (s != null)
            {
                Localytics.Log.v(String.format("GCM registered, new id: %s", new Object[] {
                    s
                }));
                _setPushID(s);
                return;
            }
        }
    }

    private boolean _isOptedOut()
    {
        Cursor cursor = mProvider.query("info", new String[] {
            "opt_out"
        }, null, null, null);
        int i;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        i = cursor.getInt(cursor.getColumnIndexOrThrow("opt_out"));
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return flag;
        if (cursor != null)
        {
            cursor.close();
        }
        return false;
        Exception exception;
        exception;
        cursor = null;
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean _isPushDisabled()
    {
        Object obj = mProvider.query("info", new String[] {
            "push_disabled"
        }, null, null, null);
        boolean flag = false;
_L2:
        int i;
        if (!((Cursor) (obj)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("push_disabled"));
        if (i == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L2; else goto _L1
_L1:
        boolean flag1;
        flag1 = flag;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
            flag1 = flag;
        }
_L4:
        return flag1;
        obj;
        obj = null;
        flag = false;
_L5:
        flag1 = flag;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((Cursor) (obj)).close();
        return flag;
        Exception exception;
        exception;
          goto _L5
    }

    private boolean _isSessionOpen()
    {
        Cursor cursor = mProvider.query("info", new String[] {
            "last_session_open_time", "last_session_close_time"
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        long l;
        long l1;
        l1 = cursor.getLong(cursor.getColumnIndexOrThrow("last_session_open_time"));
        l = cursor.getLong(cursor.getColumnIndexOrThrow("last_session_close_time"));
_L5:
        Exception exception;
        if (cursor != null)
        {
            cursor.close();
        }
        return l1 != 0L && l1 >= l;
        exception;
        cursor = null;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        l = 0L;
        l1 = 0L;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void _open()
    {
        Object obj1 = null;
        if (!_isSessionOpen()) goto _L2; else goto _L1
_L1:
        Localytics.Log.w("Session was already open");
_L8:
        return;
_L2:
        Cursor cursor = mProvider.query("info", new String[] {
            "last_session_close_time"
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        long l = cursor.getLong(cursor.getColumnIndexOrThrow("last_session_close_time"));
        if (System.currentTimeMillis() >= l + Constants.SESSION_EXPIRATION) goto _L6; else goto _L5
_L5:
        ((AnalyticsListener)listeners).localyticsSessionWillOpen(false, mAppWasUpgraded, true);
        Localytics.Log.v("Opening old closed session and reconnecting");
        _dequeQueuedCloseSessionTag(false);
        ((AnalyticsListener)listeners).localyticsSessionDidOpen(false, mAppWasUpgraded, true);
_L4:
        if (cursor == null) goto _L8; else goto _L7
_L7:
        cursor.close();
        return;
_L6:
        Object obj2;
        ((AnalyticsListener)listeners).localyticsSessionWillOpen(mFirstSessionEver, mAppWasUpgraded, false);
        Localytics.Log.v("Opening new session");
        _dequeQueuedCloseSessionTag(true);
        obj2 = DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext());
        if (obj2 != null) goto _L10; else goto _L9
_L9:
        _setFirstAdvertisingId(((String) (obj1)));
        _tagEvent("open");
        BaseProvider.deleteOldFiles(mLocalyticsDao.getAppContext());
        ((AnalyticsListener)listeners).localyticsSessionDidOpen(mFirstSessionEver, mAppWasUpgraded, false);
          goto _L4
        obj2;
        Object obj;
        obj1 = cursor;
        obj = obj2;
_L11:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        throw obj;
_L10:
        obj1 = ((DatapointHelper.AdvertisingInfo) (obj2)).id;
          goto _L9
        obj;
        obj1 = null;
          goto _L11
    }

    private void _registerPush(String s)
    {
        Object obj = null;
        if (!_isPushDisabled()) goto _L2; else goto _L1
_L1:
        Localytics.Log.v("Registering for GCM but push disabled");
_L6:
        return;
_L2:
        Cursor cursor = mProvider.query("info", new String[] {
            "sender_id", "registration_version", "registration_id"
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L4; else goto _L3
_L3:
        String s1;
        String s2;
        s2 = cursor.getString(cursor.getColumnIndexOrThrow("sender_id"));
        s1 = cursor.getString(cursor.getColumnIndexOrThrow("registration_version"));
        obj = cursor.getString(cursor.getColumnIndexOrThrow("registration_id"));
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
        if (!s.equals(s2))
        {
            _setPushID(s, null);
            obj = null;
        }
        s2 = DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext());
        if (!TextUtils.isEmpty(((CharSequence) (obj))) && s2.equals(s1)) goto _L6; else goto _L5
_L5:
        obj = mLocalyticsDao.getAppContext();
        obj = ReflectionUtils.tryInvokeStatic("com.google.android.gms.gcm.GoogleCloudMessaging", "getInstance", new Class[] {
            android/content/Context
        }, new Object[] {
            obj
        });
        if (obj == null) goto _L6; else goto _L7
_L7:
        PushReceiver.retrySenderId = s;
        s = (new String[] {
            s
        });
        ReflectionUtils.tryInvokeInstance(obj, "register", new Class[] {
            [Ljava/lang/String;
        }, new Object[] {
            s
        });
        return;
        s;
_L8:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        obj = cursor;
        if (true) goto _L8; else goto _L4
_L4:
        s1 = null;
        obj = null;
        s2 = null;
          goto _L9
    }

    private void _reuploadFirstSession(String s)
    {
        s = _replaceAttributionInFirstSession(s);
        if (!TextUtils.isEmpty(s))
        {
            (new ReferralUploader(this, s, mLocalyticsDao)).start();
        }
    }

    private void _setCustomDimension(int i, String s)
    {
        String s1 = getCustomDimensionAttributeKey(i);
        if (TextUtils.isEmpty(s))
        {
            mProvider.remove("custom_dimensions", String.format("%s = ?", new Object[] {
                "custom_dimension_key"
            }), new String[] {
                s1
            });
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("custom_dimension_key", s1);
            contentvalues.put("custom_dimension_value", s);
            if (mProvider.update("custom_dimensions", contentvalues, SELECTION_SET_CUSTOM_DIMENSION, new String[] {
    s1
}) == 0)
            {
                mProvider.insert("custom_dimensions", contentvalues);
                return;
            }
        }
    }

    private void _setFirstAdvertisingId(String s)
    {
        Cursor cursor = mProvider.query("info", new String[] {
            "first_advertising_id"
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        String s1 = cursor.getString(cursor.getColumnIndexOrThrow("first_advertising_id"));
_L5:
        if (cursor != null)
        {
            cursor.close();
        }
        if (!TextUtils.isEmpty(s1))
        {
            Localytics.Log.v("First advertising id has already been set before.");
            return;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("first_advertising_id", s);
            mProvider.update("info", contentvalues, null, null);
            return;
        }
        s;
        cursor = null;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        s;
        if (true) goto _L3; else goto _L2
_L2:
        s1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void _setIdentifier(String s, String s1)
    {
        String s2 = s1;
        if (s1 != null)
        {
            s2 = s1.trim();
        }
        if (TextUtils.isEmpty(s2))
        {
            mProvider.remove("identifiers", String.format("%s = ?", new Object[] {
                "key"
            }), new String[] {
                s
            });
        } else
        {
            s1 = new ContentValues();
            s1.put("key", s);
            s1.put("value", s2);
            if (mProvider.update("identifiers", s1, SELECTION_SET_IDENTIFIER, new String[] {
    s
}) == 0)
            {
                mProvider.insert("identifiers", s1);
            }
        }
        if (s.equals("customer_id"))
        {
            s = new ContentValues();
            if (TextUtils.isEmpty(s2))
            {
                s.put("customer_id", mLocalyticsDao.getInstallationId());
                s.put("user_type", "anonymous");
            } else
            {
                s.put("customer_id", s2);
                s.put("user_type", "known");
            }
            mProvider.update("info", s, null, null);
        }
    }

    private void _setOptedOut(boolean flag)
    {
        if (_isOptedOut() == flag)
        {
            return;
        }
        Object obj;
        if (flag)
        {
            obj = "opt_out";
        } else
        {
            obj = "opt_in";
        }
        _tagEvent(((String) (obj)));
        if (_isSessionOpen() && flag)
        {
            _close();
        }
        obj = new ContentValues();
        ((ContentValues) (obj)).put("opt_out", Boolean.valueOf(flag));
        mProvider.update("info", ((ContentValues) (obj)), null, null);
    }

    private void _setPushDisabled(int i)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("push_disabled", Integer.valueOf(i));
        mProvider.update("info", contentvalues, null, null);
    }

    private void _setPushID(String s)
    {
        ContentValues contentvalues = new ContentValues();
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        contentvalues.put("registration_id", s1);
        contentvalues.put("registration_version", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        mProvider.update("info", contentvalues, null, null);
    }

    private void _setPushID(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("sender_id", s);
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        contentvalues.put("registration_id", s);
        mProvider.update("info", contentvalues, null, null);
    }

    private void _setReferrerId(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        Cursor cursor = mProvider.query("info", new String[] {
            "play_attribution"
        }, null, null, null);
        if (cursor.moveToFirst() && TextUtils.isEmpty(cursor.getString(cursor.getColumnIndexOrThrow("play_attribution"))))
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("play_attribution", s);
            mProvider.update("info", contentvalues, null, null);
            Localytics.Log.i((new StringBuilder("[REFERRAL] _setReferrerId: ")).append(s).toString());
            _reuploadFirstSession(s);
        }
        if (cursor != null)
        {
            cursor.close();
        }
        return;
        s;
        cursor = null;
_L2:
        if (cursor != null)
        {
            cursor.close();
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void _tagEvent(String s)
    {
        _tagEvent(s, null, null);
    }

    private void _tagEvent(String s, Map map, Long long1)
    {
        Object obj;
        Object obj1;
        String s1;
        String s2;
        Object obj2;
        Object obj3;
        JSONObject jsonobject;
        Context context;
        JSONObject jsonobject1;
        Object obj4;
        int i;
        int j;
        int k;
        long l;
        long l1;
        long l2;
        boolean flag;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("dt", "h");
            jsonobject.put("u", UUID.randomUUID().toString());
            context = mLocalyticsDao.getAppContext();
            obj = (TelephonyManager)context.getSystemService("phone");
            jsonobject1 = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        obj1 = mProvider.query("info", null, null, null, null);
        if (!((Cursor) (obj1)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_1968;
        }
        jsonobject.put("pa", Math.round(((Cursor) (obj1)).getLong(((Cursor) (obj1)).getColumnIndexOrThrow("created_time")) / 1000L));
        j = ((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("next_header_number"));
        k = ((Cursor) (obj1)).getInt(((Cursor) (obj1)).getColumnIndexOrThrow("next_session_number"));
        s2 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("customer_id"));
        s1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("user_type"));
        obj2 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("current_session_uuid"));
        jsonobject.put("seq", j);
        jsonobject1.put("dt", "a");
        jsonobject1.put("au", mLocalyticsDao.getApiKey());
        obj3 = DatapointHelper.getAndroidIdHashOrNull(mLocalyticsDao.getAppContext());
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        jsonobject1.put("du", obj3);
        jsonobject1.put("lv", "androida_3.4.0");
        jsonobject1.put("av", DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext()));
        jsonobject1.put("dp", "Android");
        jsonobject1.put("dll", Locale.getDefault().getLanguage());
        jsonobject1.put("dlc", Locale.getDefault().getCountry());
        jsonobject1.put("nc", ((TelephonyManager) (obj)).getNetworkCountryIso());
        jsonobject1.put("dc", ((TelephonyManager) (obj)).getSimCountryIso());
        jsonobject1.put("dma", DatapointHelper.getManufacturer());
        jsonobject1.put("dmo", Build.MODEL);
        jsonobject1.put("dov", android.os.Build.VERSION.RELEASE);
        jsonobject1.put("nca", ((TelephonyManager) (obj)).getNetworkOperatorName());
        jsonobject1.put("dac", DatapointHelper.getNetworkType(((TelephonyManager) (obj)), mLocalyticsDao.getAppContext()));
        jsonobject1.put("iu", mLocalyticsDao.getInstallationId());
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("fb_attribution"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_523;
        }
        jsonobject1.put("fbat", obj);
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("registration_id"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_558;
        }
        jsonobject1.put("push", obj);
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("first_android_id"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_593;
        }
        jsonobject1.put("aid", obj);
        obj3 = DatapointHelper.getAndroidIdOrNull(mLocalyticsDao.getAppContext());
        obj = obj3;
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_621;
        }
        obj = JSONObject.NULL;
        jsonobject1.put("caid", obj);
        obj4 = DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext());
        if (obj4 == null) goto _L2; else goto _L1
_L1:
        if (!((DatapointHelper.AdvertisingInfo) (obj4)).limitAdTracking) goto _L2; else goto _L3
_L3:
        flag = true;
_L14:
        jsonobject1.put("lad", flag);
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("first_advertising_id"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_708;
        }
        jsonobject1.put("gadid", obj);
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_735;
        }
        if (((DatapointHelper.AdvertisingInfo) (obj4)).id != null)
        {
            jsonobject1.put("gcadid", ((DatapointHelper.AdvertisingInfo) (obj4)).id);
        }
        obj = TimeZone.getDefault();
        if (!((TimeZone) (obj)).inDaylightTime(Calendar.getInstance(((TimeZone) (obj))).getTime())) goto _L5; else goto _L4
_L4:
        i = ((TimeZone) (obj)).getRawOffset();
        i = ((TimeZone) (obj)).getDSTSavings() + i;
_L15:
        jsonobject1.put("tz", (long)i / 1000L);
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("package_name"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_824;
        }
        jsonobject1.put("pkg", obj);
        obj3 = DatapointHelper.getSerialNumberHashOrNull();
        obj = obj3;
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_843;
        }
        obj = JSONObject.NULL;
        jsonobject1.put("dms", obj);
        jsonobject1.put("dsdk", Integer.valueOf(Constants.CURRENT_API_LEVEL));
        obj = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndexOrThrow("play_attribution"));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_904;
        }
        jsonobject1.put("aurl", obj);
        l = ((Cursor) (obj1)).getLong(((Cursor) (obj1)).getColumnIndexOrThrow("last_session_open_time"));
        _updateHeaderForTestModeAttribution(((String) (obj)), jsonobject1, ((DatapointHelper.AdvertisingInfo) (obj4)), false);
        i = k;
        obj = obj2;
_L29:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_954;
        }
        ((Cursor) (obj1)).close();
        jsonobject.put("attrs", jsonobject1);
        jsonobject1 = _getIdentifiers();
        if (jsonobject1.length() > 0)
        {
            jsonobject.put("ids", jsonobject1);
        }
        obj1 = new ContentValues();
        obj2 = new ContentValues();
        ((ContentValues) (obj1)).put("next_header_number", Integer.valueOf(j + 1));
        obj3 = new JSONObject();
        l1 = System.currentTimeMillis();
        obj4 = UUID.randomUUID().toString();
        if (!"open".equals(s)) goto _L7; else goto _L6
_L6:
        ((JSONObject) (obj3)).put("dt", "s");
        ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
        ((JSONObject) (obj3)).put("u", obj4);
        l2 = l1 - l;
        if (l != 0L) goto _L9; else goto _L8
_L8:
        ((JSONObject) (obj3)).put("sl", 0.0D);
_L17:
        ((JSONObject) (obj3)).put("nth", i);
        _addLocationIDsAndCustomDimensions(((JSONObject) (obj3)), jsonobject1, s2, s1);
        obj = String.format("%s\n%s", new Object[] {
            jsonobject.toString(), ((JSONObject) (obj3)).toString()
        });
        ((ContentValues) (obj2)).put("blob", ((String) (obj)));
        ((ContentValues) (obj2)).put("upload_format", Integer.valueOf(AnalyticsProvider.EventsV3Columns.UploadFormat.V2.getValue()));
        ((ContentValues) (obj1)).put("last_session_open_time", Long.valueOf(l1));
        ((ContentValues) (obj1)).put("next_session_number", Integer.valueOf(i + 1));
        ((ContentValues) (obj1)).put("current_session_uuid", ((String) (obj4)));
        if (mFirstSessionEver)
        {
            ((ContentValues) (obj1)).put("first_open_event_blob", ((String) (obj)));
        }
_L18:
        mProvider.update("info", ((ContentValues) (obj1)), null, null);
        if (((ContentValues) (obj2)).size() > 0)
        {
            mProvider.insert("events", ((ContentValues) (obj2)));
        }
        if (Arrays.asList(new String[] {
            "open", "close", "opt_in", "opt_out"
        }).contains(s)) goto _L11; else goto _L10
_L10:
        obj = (AnalyticsListener)listeners;
        if (long1 != null) goto _L13; else goto _L12
_L12:
        l = 0L;
_L27:
        ((AnalyticsListener) (obj)).localyticsDidTagEvent(s, map, l);
_L11:
        return;
_L2:
        flag = false;
          goto _L14
_L5:
        i = ((TimeZone) (obj)).getRawOffset();
          goto _L15
        s;
        obj1 = null;
_L28:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1385;
        }
        ((Cursor) (obj1)).close();
        throw s;
_L9:
        if (l2 <= 0L) goto _L17; else goto _L16
_L16:
        ((JSONObject) (obj3)).put("sl", Math.round(l2 / 1000L));
          goto _L17
_L7:
label0:
        {
            if (!"close".equals(s))
            {
                break label0;
            }
            ((JSONObject) (obj3)).put("dt", "c");
            ((JSONObject) (obj3)).put("u", obj4);
            ((JSONObject) (obj3)).put("su", obj);
            ((JSONObject) (obj3)).put("ss", Math.round(l / 1000L));
            ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
            ((JSONObject) (obj3)).put("ctl", Math.round((l1 - l) / 1000L));
            obj = new JSONArray(screenFlow);
            if (((JSONArray) (obj)).length() > 0)
            {
                ((JSONObject) (obj3)).put("fl", obj);
            }
            _addLocationIDsAndCustomDimensions(((JSONObject) (obj3)), jsonobject1, s2, s1);
            ((ContentValues) (obj1)).put("last_session_close_time", Long.valueOf(l1));
            ((ContentValues) (obj1)).put("queued_close_session_blob", String.format("%s\n%s", new Object[] {
                jsonobject.toString(), ((JSONObject) (obj3)).toString()
            }));
            ((ContentValues) (obj1)).put("queued_close_session_blob_upload_format", Integer.valueOf(AnalyticsProvider.EventsV3Columns.UploadFormat.V2.getValue()));
        }
          goto _L18
        if (!"opt_in".equals(s) && !"opt_out".equals(s)) goto _L20; else goto _L19
_L19:
        ((JSONObject) (obj3)).put("dt", "o");
        ((JSONObject) (obj3)).put("u", mLocalyticsDao.getApiKey());
        if (!"opt_out".equals(s)) goto _L22; else goto _L21
_L21:
        obj = Boolean.TRUE.toString();
_L23:
        ((JSONObject) (obj3)).put("out", obj);
        ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
_L25:
        ((ContentValues) (obj2)).put("blob", String.format("%s\n%s", new Object[] {
            jsonobject.toString(), ((JSONObject) (obj3)).toString()
        }));
        ((ContentValues) (obj2)).put("upload_format", Integer.valueOf(AnalyticsProvider.EventsV3Columns.UploadFormat.V2.getValue()));
          goto _L18
_L22:
        obj = Boolean.FALSE.toString();
          goto _L23
_L20:
        ((JSONObject) (obj3)).put("dt", "e");
        ((JSONObject) (obj3)).put("ct", Math.round(l1 / 1000L));
        ((JSONObject) (obj3)).put("u", obj4);
        if (!_isSessionOpen())
        {
            obj = "";
        }
        ((JSONObject) (obj3)).put("su", obj);
        if (!s.startsWith(context.getPackageName()))
        {
            break MISSING_BLOCK_LABEL_1942;
        }
        ((JSONObject) (obj3)).put("n", s.substring(context.getPackageName().length() + 1, s.length()));
_L26:
        if (long1.longValue() != 0L)
        {
            ((JSONObject) (obj3)).put("v", long1);
        }
        _addLocationIDsAndCustomDimensions(((JSONObject) (obj3)), jsonobject1, s2, s1);
        if (map == null) goto _L25; else goto _L24
_L24:
        ((JSONObject) (obj3)).put("attrs", new JSONObject(map));
          goto _L25
        ((JSONObject) (obj3)).put("n", s);
          goto _L26
_L13:
        l = long1.longValue();
          goto _L27
        s;
          goto _L28
        l = 0L;
        s1 = "";
        s2 = "";
        obj = "";
        i = 0;
        j = 0;
          goto _L29
    }

    private void _tagScreen(String s)
    {
        if (_isSessionOpen())
        {
            if (screenFlow.size() == 0 || !s.equals(screenFlow.get(screenFlow.size() - 1)))
            {
                screenFlow.add(s);
            }
            return;
        } else
        {
            Localytics.Log.w("Screen not tagged because a session is not open");
            return;
        }
    }

    private void _updateHeaderForTestModeAttribution(String s, JSONObject jsonobject, DatapointHelper.AdvertisingInfo advertisinginfo, boolean flag)
    {
        if (mSentReferrerTestMode)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        if (!TextUtils.isEmpty(s))
        {
            s = URLDecoder.decode(s).split("[&]");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                String as[] = s[i].split("[=]");
                if (as.length > 1)
                {
                    String s1 = as[0].toLowerCase();
                    String s2 = as[1].toLowerCase();
                    boolean flag1;
                    if (s1.equals("localytics_test_mode") && (s2.equals("1") || s2.equals("true")))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    mReferrerTestModeEnabled = flag1;
                }
                i++;
            }
        }
        if (!flag && !mFirstSessionEver || !mReferrerTestModeEnabled)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        try
        {
            Localytics.Log.i("[REFERRAL] using fake id for attribution test mode");
            s = Long.toHexString((new SecureRandom()).nextLong());
            jsonobject.put("aid", s);
            jsonobject.put("du", DatapointHelper.getSha256_buggy(s));
            jsonobject.put("caid", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LocalyticsManager.throwOrLogError(org/json/JSONException, "Exception adding values to object");
            return;
        }
        if (advertisinginfo == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        s = UUID.randomUUID().toString();
        jsonobject.put("gadid", s);
        jsonobject.put("gcadid", s);
        mSentReferrerTestMode = true;
    }

    private String getCustomDimensionAttributeKey(int i)
    {
        if (i >= 0 && i <= 10)
        {
            return String.format("%s%s", new Object[] {
                "custom_dimension_", String.valueOf(i)
            });
        } else
        {
            return (String)LocalyticsManager.throwOrLogError(java/lang/IndexOutOfBoundsException, "Custom dimension index cannot exceed 10");
        }
    }

    protected void _deleteUploadedData(int i)
    {
        mProvider.remove("events", (new StringBuilder("_id <= ")).append(i).toString(), null);
    }

    protected TreeMap _getDataToUpload()
    {
        TreeMap treemap = new TreeMap();
        Cursor cursor = mProvider.query("events", null, null, null, "_id ASC");
        while (cursor.moveToNext() && treemap.size() < 100) 
        {
            treemap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id"))), cursor.getString(cursor.getColumnIndexOrThrow("blob")));
        }
          goto _L1
        Exception exception1;
        exception1;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        return treemap;
_L1:
        if (cursor != null)
        {
            cursor.close();
        }
        return treemap;
        Exception exception;
        exception;
        exception = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected int _getMaxRowToUpload()
    {
        Object obj = mProvider.query("events", new String[] {
            "_id"
        }, null, null, "_id ASC");
        if (!((Cursor) (obj)).moveToLast()) goto _L2; else goto _L1
_L1:
        int i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndexOrThrow("_id"));
_L5:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return i;
        obj;
        obj = null;
_L3:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return 0;
        Exception exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        i = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void _init()
    {
        if (mProvider == null)
        {
            mProvider = new AnalyticsProvider(siloName.toLowerCase(), mLocalyticsDao);
        }
        _initApiKey();
    }

    protected void _initApiKey()
    {
        Cursor cursor;
        Object obj;
        obj = DatapointHelper.getAppVersion(mLocalyticsDao.getAppContext());
        cursor = mProvider.query("info", new String[] {
            "app_version", "uuid", "next_session_number", "customer_id"
        }, null, null, null);
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        Localytics.Log.v(String.format("Loading details for API key %s", new Object[] {
            mLocalyticsDao.getApiKey()
        }));
        ContentValues contentvalues = new ContentValues();
        if (!cursor.getString(cursor.getColumnIndexOrThrow("app_version")).equals(obj))
        {
            contentvalues.put("app_version", ((String) (obj)));
            mAppWasUpgraded = true;
        }
        if (contentvalues.size() != 0)
        {
            mProvider.update("info", contentvalues, null, null);
        }
        boolean flag;
        if (cursor.getInt(cursor.getColumnIndexOrThrow("next_session_number")) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFirstSessionEver = flag;
        mLocalyticsDao.setInstallationId(cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
        obj = cursor.getString(cursor.getColumnIndexOrThrow("customer_id"));
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorenter ;
        if (mLocalyticsDao.getCustomerIdInMemory(true) == null)
        {
            mLocalyticsDao.setCustomerIdInMemory(((String) (obj)));
        }
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorexit ;
_L3:
        if (cursor != null)
        {
            cursor.close();
        }
        mLocalyticsDao.getCustomerIdInitiatedLatch().countDown();
        mProvider.vacuumIfNecessary();
        return;
        obj;
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception1;
        exception1;
        Exception exception;
        obj = cursor;
        exception = exception1;
_L4:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        mLocalyticsDao.getCustomerIdInitiatedLatch().countDown();
        throw exception;
_L2:
        String s;
        Localytics.Log.v(String.format("Performing first-time initialization for new API key %s", new Object[] {
            mLocalyticsDao.getApiKey()
        }));
        s = UUID.randomUUID().toString();
        mLocalyticsDao.setInstallationId(s);
        ContentValues contentvalues1 = new ContentValues();
        contentvalues1.put("api_key", mLocalyticsDao.getApiKey());
        contentvalues1.put("uuid", s);
        contentvalues1.put("created_time", Long.valueOf(System.currentTimeMillis()));
        contentvalues1.put("opt_out", Boolean.FALSE);
        contentvalues1.put("push_disabled", Boolean.FALSE);
        contentvalues1.put("customer_id", s);
        contentvalues1.put("user_type", "anonymous");
        contentvalues1.put("fb_attribution", DatapointHelper.getFBAttribution(mLocalyticsDao.getAppContext()));
        contentvalues1.put("first_android_id", DatapointHelper.getAndroidIdOrNull(mLocalyticsDao.getAppContext()));
        contentvalues1.put("package_name", mLocalyticsDao.getAppContext().getPackageName());
        contentvalues1.put("app_version", ((String) (obj)));
        contentvalues1.put("next_session_number", Integer.valueOf(1));
        contentvalues1.put("next_header_number", Integer.valueOf(1));
        contentvalues1.put("last_session_open_time", Integer.valueOf(0));
        contentvalues1.put("last_session_close_time", Integer.valueOf(0));
        mProvider.insert("info", contentvalues1);
        mFirstSessionEver = true;
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorenter ;
        if (mLocalyticsDao.getCustomerIdInMemory(true) == null)
        {
            mLocalyticsDao.setCustomerIdInMemory(s);
        }
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorexit ;
          goto _L3
        obj;
        com/localytics/android/LocalyticsManager;
        JVM INSTR monitorexit ;
        throw obj;
        exception;
        obj = null;
          goto _L4
    }

    protected void _onUploadCompleted(String s)
    {
        mProvider.vacuumIfNecessary();
    }

    String _replaceAttributionInFirstSession(String s)
    {
        Object obj1 = null;
        Object obj = mProvider.query("info", new String[] {
            "first_open_event_blob"
        }, null, null, null);
        if (!((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_166;
        }
        obj1 = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndexOrThrow("first_open_event_blob"));
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            break MISSING_BLOCK_LABEL_166;
        }
        obj1 = ((String) (obj1)).split("[\n]");
        JSONObject jsonobject = new JSONObject(obj1[0]);
        JSONObject jsonobject1 = (JSONObject)jsonobject.get("attrs");
        _updateHeaderForTestModeAttribution(s, jsonobject1, DatapointHelper.getAdvertisingInfo(mLocalyticsDao.getAppContext()), true);
        jsonobject1.put("aurl", s);
        s = String.format("%s\n%s", new Object[] {
            jsonobject.toString(), obj1[1]
        });
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return s;
        s;
        Localytics.Log.e("JSONException", s);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        return null;
        s;
        obj = obj1;
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    void closeSession()
    {
        queueMessage(obtainMessage(102));
    }

    String getCustomDimension(final int dimension)
    {
        return getString(new _cls15());
    }

    String getIdentifier(final String key)
    {
        return getString(new _cls17());
    }

    Map getIdentifiers()
    {
        return getMap(new _cls2());
    }

    String getPushRegistrationID()
    {
        return getString(new _cls16());
    }

    protected BaseUploadThread getUploadThread(TreeMap treemap, String s)
    {
        return new AnalyticsUploadHandler(this, treemap, s, mLocalyticsDao);
    }

    protected void handleMessageExtended(final Message event)
    {
        switch (event.what)
        {
        case 111: // 'o'
        default:
            super.handleMessageExtended(event);
            return;

        case 101: // 'e'
            Localytics.Log.d("Analytics handler received MESSAGE_OPEN");
            mProvider.runBatchTransaction(new _cls3());
            return;

        case 102: // 'f'
            Localytics.Log.d("Analytics handler received MESSAGE_CLOSE");
            mProvider.runBatchTransaction(new _cls4());
            return;

        case 103: // 'g'
            Localytics.Log.d("Analytics handler received MESSAGE_TAG_EVENT");
            Object aobj1[] = (Object[])(Object[])event.obj;
            event = (String)aobj1[0];
            final Map attributes = (Map)aobj1[1];
            final Long clv = (Long)aobj1[2];
            mProvider.runBatchTransaction(new _cls5());
            return;

        case 104: // 'h'
            Localytics.Log.d("Analytics handler received MESSAGE_TAG_SCREEN");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls6());
            return;

        case 107: // 'k'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_CUSTOM_DIMENSION");
            event = ((Message) ((Object[])(Object[])event.obj));
            final int dimension = ((Integer)event[0]).intValue();
            event = (String)event[1];
            mProvider.runBatchTransaction(new _cls7());
            return;

        case 105: // 'i'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_IDENTIFIER");
            Object aobj[] = (Object[])(Object[])event.obj;
            event = (String)aobj[0];
            final String value = (String)aobj[1];
            mProvider.runBatchTransaction(new _cls8());
            return;

        case 106: // 'j'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_LOCATION");
            sLastLocation = (Location)event.obj;
            return;

        case 113: // 'q'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_PUSH_REGID");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls9());
            return;

        case 112: // 'p'
            Localytics.Log.d("Analytics handler received MESSAGE_DISABLE_PUSH");
            final int disabled = event.arg1;
            mProvider.runBatchTransaction(new _cls10());
            return;

        case 108: // 'l'
            Localytics.Log.v("Analytics handler received MESSAGE_OPT_OUT");
            final boolean isOptingOut;
            if (event.arg1 != 0)
            {
                isOptingOut = true;
            } else
            {
                isOptingOut = false;
            }
            mProvider.runBatchTransaction(new _cls11());
            return;

        case 109: // 'm'
            Localytics.Log.d("Analytics handler received MESSAGE_REGISTER_PUSH");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls12());
            return;

        case 110: // 'n'
            Localytics.Log.d("Analytics handler received MESSAGE_HANDLE_PUSH_REGISTRATION");
            event = (Intent)event.obj;
            mProvider.runBatchTransaction(new _cls13());
            return;

        case 114: // 'r'
            Localytics.Log.d("Analytics handler received MESSAGE_SET_REFERRERID");
            event = (String)event.obj;
            mProvider.runBatchTransaction(new _cls14());
            return;
        }
    }

    void handleRegistration(Intent intent)
    {
        queueMessage(obtainMessage(110, intent));
    }

    boolean isOptedOut()
    {
        return getBool(new _cls18());
    }

    boolean isPushDisabled()
    {
        return getBool(new _cls1());
    }

    void openSession()
    {
        queueMessage(obtainMessage(101));
    }

    void registerPush(String s, long l)
    {
        queueMessageDelayed(obtainMessage(109, s), l);
    }

    void setCustomDimension(int i, String s)
    {
        if (i < 0 || i >= 10)
        {
            throw new IllegalArgumentException("Only valid dimensions are 0 - 9");
        } else
        {
            queueMessage(obtainMessage(107, ((Object) (new Object[] {
                Integer.valueOf(i), s
            }))));
            return;
        }
    }

    void setIdentifier(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("key cannot be null or empty");
        } else
        {
            queueMessage(obtainMessage(105, ((Object) (new Object[] {
                s, s1
            }))));
            return;
        }
    }

    void setLocation(Location location)
    {
        queueMessage(obtainMessage(106, new Location(location)));
    }

    void setOptedOut(boolean flag)
    {
        int i = 1;
        Localytics.Log.v(String.format("Requested opt-out state is %b", new Object[] {
            Boolean.valueOf(flag)
        }));
        if (!flag)
        {
            i = 0;
        }
        queueMessage(obtainMessage(108, i, 0));
    }

    void setPushDisabled(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        queueMessage(obtainMessage(112, i, 0));
    }

    void setPushRegistrationId(String s)
    {
        queueMessage(obtainMessage(113, s));
    }

    void setReferrerId(String s)
    {
        queueMessage(obtainMessage(114, s));
    }

    void setScreenFlow(List list)
    {
        screenFlow.addAll(0, list);
    }

    void tagEvent(String s, Map map, long l)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        if (map != null)
        {
            if (map.isEmpty())
            {
                LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes is empty.  Did the caller make an error?");
            }
            if (map.size() > 50)
            {
                LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, String.format("attributes size is %d, exceeding the maximum size of %d.  Did the caller make an error?", new Object[] {
                    Integer.valueOf(map.size()), Integer.valueOf(50)
                }));
            }
            Iterator iterator = map.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (java.util.Map.Entry)iterator.next();
                String s1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (String)((java.util.Map.Entry) (obj)).getValue();
                if (TextUtils.isEmpty(s1))
                {
                    LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty keys");
                }
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    LocalyticsManager.throwOrLogError(java/lang/IllegalArgumentException, "attributes cannot contain null or empty values");
                }
            } while (true);
        }
        queueMessage(obtainMessage(103, ((Object) (new Object[] {
            s, map, Long.valueOf(l)
        }))));
    }

    void tagScreen(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("event cannot be null or empty");
        } else
        {
            queueMessage(obtainMessage(104, s));
            return;
        }
    }



















    private class AnalyticsListenersSet extends BaseHandler.ListenersSet
        implements AnalyticsListener
    {

        final AnalyticsHandler this$0;

        public final void localyticsDidTagEvent(String s, Map map, long l)
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsDidTagEvent", new Class[] {
                java/lang/String, java/util/Map, Long.TYPE
            }, new Object[] {
                s, map, Long.valueOf(l)
            });
            this;
            JVM INSTR monitorexit ;
            return;
            s;
            throw s;
        }

        public final void localyticsSessionDidOpen(boolean flag, boolean flag1, boolean flag2)
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsSessionDidOpen", new Class[] {
                Boolean.TYPE, Boolean.TYPE, Boolean.TYPE
            }, new Object[] {
                Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
            });
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsSessionWillClose()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsSessionWillClose", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsSessionWillOpen(boolean flag, boolean flag1, boolean flag2)
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsSessionWillOpen", new Class[] {
                Boolean.TYPE, Boolean.TYPE, Boolean.TYPE
            }, new Object[] {
                Boolean.valueOf(flag), Boolean.valueOf(flag1), Boolean.valueOf(flag2)
            });
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private AnalyticsListenersSet()
        {
            this$0 = AnalyticsHandler.this;
            super(AnalyticsHandler.this);
        }

        AnalyticsListenersSet(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls15
        implements Callable
    {

        final AnalyticsHandler this$0;
        final int val$dimension;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            return _getCustomDimension(dimension);
        }

        _cls15()
        {
            this$0 = AnalyticsHandler.this;
            dimension = i;
            super();
        }
    }


    private class _cls17
        implements Callable
    {

        final AnalyticsHandler this$0;
        final String val$key;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            String s = null;
            Cursor cursor = mProvider.query("identifiers", AnalyticsHandler.PROJECTION_SET_IDENTIFIER, AnalyticsHandler.SELECTION_SET_IDENTIFIER, new String[] {
                key
            }, null);
            if (cursor.moveToFirst())
            {
                s = cursor.getString(cursor.getColumnIndexOrThrow("value"));
            }
            if (cursor != null)
            {
                cursor.close();
            }
            return s;
            Exception exception;
            exception;
            cursor = null;
_L2:
            if (cursor != null)
            {
                cursor.close();
            }
            throw exception;
            exception;
            if (true) goto _L2; else goto _L1
_L1:
        }

        _cls17()
        {
            this$0 = AnalyticsHandler.this;
            key = s;
            super();
        }
    }


    private class _cls2
        implements Callable
    {

        final AnalyticsHandler this$0;

        public volatile Object call()
        {
            return call();
        }

        public Map call()
        {
            HashMap hashmap = new HashMap();
            Cursor cursor = mProvider.query("identifiers", null, null, null, null);
            while (cursor.moveToNext()) 
            {
                hashmap.put(cursor.getString(cursor.getColumnIndexOrThrow("key")), cursor.getString(cursor.getColumnIndexOrThrow("value")));
            }
              goto _L1
            Exception exception1;
            exception1;
_L3:
            if (cursor != null)
            {
                cursor.close();
            }
            return hashmap;
_L1:
            if (cursor != null)
            {
                cursor.close();
            }
            return hashmap;
            Exception exception;
            exception;
            exception = null;
            if (true) goto _L3; else goto _L2
_L2:
        }

        _cls2()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls16
        implements Callable
    {

        final AnalyticsHandler this$0;

        public volatile Object call()
        {
            return call();
        }

        public String call()
        {
            Cursor cursor = mProvider.query("info", new String[] {
                "registration_id"
            }, null, null, null);
            if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
            Object obj = cursor.getString(cursor.getColumnIndexOrThrow("registration_id"));
_L5:
            if (cursor != null)
            {
                cursor.close();
            }
            return ((String) (obj));
            obj;
            obj = null;
_L3:
            if (obj != null)
            {
                ((Cursor) (obj)).close();
            }
            return null;
            obj;
            obj = cursor;
            if (true) goto _L3; else goto _L2
_L2:
            obj = null;
            if (true) goto _L5; else goto _L4
_L4:
        }

        _cls16()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final AnalyticsHandler this$0;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _open();
                return;
            }
        }

        _cls3()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final AnalyticsHandler this$0;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _close();
                return;
            }
        }

        _cls4()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final Map val$attributes;
        final Long val$clv;
        final String val$event;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _tagEvent(event, attributes, clv);
                return;
            }
        }

        _cls5()
        {
            this$0 = AnalyticsHandler.this;
            event = s;
            attributes = map;
            clv = long1;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$screen;

        public void run()
        {
            if (_isOptedOut())
            {
                Localytics.Log.d("Data collection is opted out");
                return;
            } else
            {
                _tagScreen(screen);
                return;
            }
        }

        _cls6()
        {
            this$0 = AnalyticsHandler.this;
            screen = s;
            super();
        }
    }


    private class _cls7
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final int val$dimension;
        final String val$value;

        public void run()
        {
            _setCustomDimension(dimension, value);
        }

        _cls7()
        {
            this$0 = AnalyticsHandler.this;
            dimension = i;
            value = s;
            super();
        }
    }


    private class _cls8
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$key;
        final String val$value;

        public void run()
        {
            _setIdentifier(key, value);
        }

        _cls8()
        {
            this$0 = AnalyticsHandler.this;
            key = s;
            value = s1;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$pushRegId;

        public void run()
        {
            if (_isPushDisabled())
            {
                Localytics.Log.v("Registering for GCM but push disabled");
                return;
            } else
            {
                _setPushID(pushRegId);
                return;
            }
        }

        _cls9()
        {
            this$0 = AnalyticsHandler.this;
            pushRegId = s;
            super();
        }
    }


    private class _cls10
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final int val$disabled;

        public void run()
        {
            _setPushDisabled(disabled);
        }

        _cls10()
        {
            this$0 = AnalyticsHandler.this;
            disabled = i;
            super();
        }
    }


    private class _cls11
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final boolean val$isOptingOut;

        public void run()
        {
            _setOptedOut(isOptingOut);
        }

        _cls11()
        {
            this$0 = AnalyticsHandler.this;
            isOptingOut = flag;
            super();
        }
    }


    private class _cls12
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$newSenderId;

        public void run()
        {
            _registerPush(newSenderId);
        }

        _cls12()
        {
            this$0 = AnalyticsHandler.this;
            newSenderId = s;
            super();
        }
    }


    private class _cls13
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final Intent val$intent;

        public void run()
        {
            _handlePushRegistration(intent);
        }

        _cls13()
        {
            this$0 = AnalyticsHandler.this;
            intent = intent1;
            super();
        }
    }


    private class _cls14
        implements Runnable
    {

        final AnalyticsHandler this$0;
        final String val$referrerId;

        public void run()
        {
            _setReferrerId(referrerId);
        }

        _cls14()
        {
            this$0 = AnalyticsHandler.this;
            referrerId = s;
            super();
        }
    }


    private class _cls18
        implements Callable
    {

        final AnalyticsHandler this$0;

        public Boolean call()
        {
            return Boolean.valueOf(_isOptedOut());
        }

        public volatile Object call()
        {
            return call();
        }

        _cls18()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }


    private class _cls1
        implements Callable
    {

        final AnalyticsHandler this$0;

        public Boolean call()
        {
            return Boolean.valueOf(_isPushDisabled());
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = AnalyticsHandler.this;
            super();
        }
    }

}
