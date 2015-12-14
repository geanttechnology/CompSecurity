// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.ChildApplicationHelpers;
import com.amazon.identity.auth.device.CommonInfoGenerator;
import com.amazon.identity.auth.device.framework.MAPInitTasks;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.LambortishClock;
import com.amazon.identity.auth.device.storage.LocalDataStorage;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit

public abstract class MAPInformationProvider extends ContentProvider
{
    private static class SelectionInfo
    {

        private static final SelectionInfo EMPTY_SELECTION_INFO = new SelectionInfo(null, null, null, null, null, null, null, null);
        public final Collection bulkData;
        public final String directedId;
        public final String displayName;
        public final String key;
        public final String namespace;
        public final Date timestamp;
        public final Bundle userdata;
        public final String value;

        public static SelectionInfo parseSelection(ContentValues contentvalues)
        {
            String s = contentvalues.getAsString("directedId");
            String s1 = contentvalues.getAsString("key");
            String s2 = contentvalues.getAsString("value");
            String s3 = contentvalues.getAsString("namespace");
            String s4 = contentvalues.getAsString("display_name");
            String s5 = contentvalues.getAsString("userdata_bundle_key");
            Object obj = contentvalues.getAsLong("timestamp_key");
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = new Date(((Long) (obj)).longValue());
            }
            return new SelectionInfo(s, s1, s2, s3, s4, s5, ((Date) (obj)), contentvalues.getAsString("bulk_data"));
        }

        public static SelectionInfo parseSelection(String s, String as[])
        {
            if (s == null)
            {
                String as1[];
                String as2[];
                int i;
                try
                {
                    return EMPTY_SELECTION_INFO;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MAPLog.e(MAPInformationProvider.TAG, (new StringBuilder("Format not valid. Error: ")).append(s.getMessage()).toString());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MAPLog.e(MAPInformationProvider.TAG, "Format was not valid JSON");
                }
                return null;
            }
            if (as != null) goto _L2; else goto _L1
_L1:
            as1 = new String[0];
_L4:
            s = new JSONObject(String.format(s.replace("\"?\"", "%s"), (Object[])as1));
            s = new SelectionInfo(JSONHelpers.getStringOrDefault(s, "directedId", null), JSONHelpers.getStringOrDefault(s, "key", null), JSONHelpers.getStringOrDefault(s, "value", null), JSONHelpers.getStringOrDefault(s, "namespace", null), JSONHelpers.getStringOrDefault(s, "display_name", null), JSONHelpers.getStringOrDefault(s, "userdata_bundle_key", null), TimeUtil.deserialize(JSONHelpers.getStringOrDefault(s, "timestamp_key", null)), JSONHelpers.getStringOrDefault(s, "bulk_data", null));
            return s;
_L2:
            as2 = new String[as.length];
            i = 0;
_L5:
            as1 = as2;
            if (i >= as.length) goto _L4; else goto _L3
_L3:
            as2[i] = JSONObject.quote(as[i]);
            i++;
              goto _L5
        }


        public SelectionInfo(String s, String s1, String s2, String s3, String s4, String s5, Date date, 
                String s6)
        {
            directedId = s;
            key = s1;
            value = s2;
            namespace = s3;
            displayName = s4;
            userdata = ParcelUtils.stringToBundle(s5);
            timestamp = date;
            bulkData = ParcelUtils.stringToListOfMapOfStrings(s6);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/api/MAPInformationProvider.getName();
    public static final String TOKEN_PROVIDER_AUTHORITY_PREFIX = "com.amazon.identity.auth.device.MapInfoProvider.";
    volatile BuildInfo mBuildInfo;
    private Context mContext;
    private boolean mInitialized;
    private LambortishClock mLambortishClock;
    private LocalDataStorage mLocalDataStorage;

    public MAPInformationProvider()
    {
        mInitialized = false;
    }

    private void commonValidation(Uri uri)
    {
        SecurityHelpers.checkCaller(mContext);
        if (!uri.getAuthority().startsWith("com.amazon.identity.auth.device.MapInfoProvider."))
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown supported authority ")).append(uri.getAuthority()).toString());
        } else
        {
            return;
        }
    }

    private SelectionInfo getSelectionInfo(Uri uri, String s, String as[])
    {
        commonValidation(uri);
        uri = SelectionInfo.parseSelection(s, as);
        if (uri == null)
        {
            throw new IllegalArgumentException("Invalid selection");
        } else
        {
            return uri;
        }
    }

    private void initializeDataStore()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mInitialized;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        MAPInit.getInstance(mContext).initialize();
        mContext = ServiceWrappingContext.create(mContext);
        mLocalDataStorage = (LocalDataStorage)mContext.getSystemService("sso_local_datastorage");
        mLambortishClock = LambortishClock.getInstance(mContext);
        mInitialized = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void markBulkDataTimestampsSeen(Collection collection)
    {
        Date date;
        for (collection = collection.iterator(); collection.hasNext(); mLambortishClock.markDateSeen(date))
        {
            date = TimeUtil.deserialize((String)((Map)collection.next()).get("timestamp_key"));
        }

    }

    private boolean setValue(Uri uri, ContentValues contentvalues)
    {
        commonValidation(uri);
        contentvalues = SelectionInfo.parseSelection(contentvalues);
        if (contentvalues == null)
        {
            throw new IllegalArgumentException("Invalid selection");
        }
        uri = uri.getPath();
        if ("/accounts".equals(uri))
        {
            if (((SelectionInfo) (contentvalues)).displayName != null && ((SelectionInfo) (contentvalues)).directedId != null && ((SelectionInfo) (contentvalues)).timestamp != null)
            {
                mLambortishClock.markDateSeen(((SelectionInfo) (contentvalues)).timestamp);
                return mLocalDataStorage.addAccount(((SelectionInfo) (contentvalues)).displayName, new AccountTransaction(((SelectionInfo) (contentvalues)).directedId, BundleUtils.toStringStringMap(((SelectionInfo) (contentvalues)).userdata), null), ((SelectionInfo) (contentvalues)).timestamp, true);
            }
        } else
        if ("/userdata".equals(uri))
        {
            if (((SelectionInfo) (contentvalues)).directedId != null && ((SelectionInfo) (contentvalues)).key != null && ((SelectionInfo) (contentvalues)).timestamp != null)
            {
                mLambortishClock.markDateSeen(((SelectionInfo) (contentvalues)).timestamp);
                return mLocalDataStorage.setUserData(((SelectionInfo) (contentvalues)).directedId, ((SelectionInfo) (contentvalues)).key, ((SelectionInfo) (contentvalues)).value, ((SelectionInfo) (contentvalues)).timestamp, true);
            }
        } else
        if ("/tokens".equals(uri))
        {
            if (((SelectionInfo) (contentvalues)).directedId != null && ((SelectionInfo) (contentvalues)).key != null && ((SelectionInfo) (contentvalues)).timestamp != null)
            {
                mLambortishClock.markDateSeen(((SelectionInfo) (contentvalues)).timestamp);
                return mLocalDataStorage.setToken(((SelectionInfo) (contentvalues)).directedId, ((SelectionInfo) (contentvalues)).key, ((SelectionInfo) (contentvalues)).value, ((SelectionInfo) (contentvalues)).timestamp, true);
            }
        } else
        if ("/device_data".equals(uri))
        {
            if (((SelectionInfo) (contentvalues)).namespace != null && ((SelectionInfo) (contentvalues)).key != null && ((SelectionInfo) (contentvalues)).timestamp != null)
            {
                mLambortishClock.markDateSeen(((SelectionInfo) (contentvalues)).timestamp);
                return mLocalDataStorage.setDeviceData(((SelectionInfo) (contentvalues)).namespace, ((SelectionInfo) (contentvalues)).key, ((SelectionInfo) (contentvalues)).value, ((SelectionInfo) (contentvalues)).timestamp, true);
            }
        } else
        if ("/bulk_data".equals(uri) && ((SelectionInfo) (contentvalues)).bulkData != null)
        {
            markBulkDataTimestampsSeen(((SelectionInfo) (contentvalues)).bulkData);
            return mLocalDataStorage.setBulkData(((SelectionInfo) (contentvalues)).bulkData);
        }
        return false;
    }

    private transient Cursor toQueryCursor(String as[], String as1[])
    {
        ArrayList arraylist = new ArrayList();
        int j = as1.length;
        for (int i = 0; i < j; i++)
        {
            String s = as1[i];
            HashMap hashmap = new HashMap();
            hashmap.put("value", s);
            arraylist.add(hashmap);
        }

        return DBHelpers.populateCursor(as, arraylist);
    }

    public final int delete(Uri uri, String s, String as[])
    {
        SecurityHelpers.checkCaller(mContext);
        initializeDataStore();
        s = getSelectionInfo(uri, s, as);
        uri = uri.getPath();
        if (!"/accounts".equals(uri)) goto _L2; else goto _L1
_L1:
        if (((SelectionInfo) (s)).directedId == null || ((SelectionInfo) (s)).timestamp == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        mLambortishClock.markDateSeen(((SelectionInfo) (s)).timestamp);
        if (!mLocalDataStorage.removeAccount(((SelectionInfo) (s)).directedId, ((SelectionInfo) (s)).timestamp, true)) goto _L4; else goto _L3
_L3:
        return 1;
_L4:
        return 0;
_L2:
        if (!"/tokens".equals(uri))
        {
            break; /* Loop/switch isn't completed */
        }
        if (((SelectionInfo) (s)).directedId == null || ((SelectionInfo) (s)).key == null || ((SelectionInfo) (s)).timestamp == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        mLambortishClock.markDateSeen(((SelectionInfo) (s)).timestamp);
        if (!mLocalDataStorage.expireToken(((SelectionInfo) (s)).directedId, ((SelectionInfo) (s)).key, ((SelectionInfo) (s)).timestamp, true))
        {
            return 0;
        }
        if (true) goto _L3; else goto _L5
_L5:
        if (!"/bulk_data".equals(uri) || ((SelectionInfo) (s)).bulkData == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        markBulkDataTimestampsSeen(((SelectionInfo) (s)).bulkData);
        if (mLocalDataStorage.clearBulkData(((SelectionInfo) (s)).bulkData)) goto _L3; else goto _L6
_L6:
        return 0;
        return 0;
    }

    public String getDsnOverrideForChildDeviceType()
    {
        String s = TAG;
        return null;
    }

    public String getOverrideChildDeviceType()
    {
        String s = TAG;
        return null;
    }

    public final String getType(Uri uri)
    {
        throw new UnsupportedOperationException("getType currently not supported");
    }

    public final Uri insert(Uri uri, ContentValues contentvalues)
    {
        SecurityHelpers.checkCaller(mContext);
        initializeDataStore();
        if (setValue(uri, contentvalues))
        {
            return uri;
        } else
        {
            return null;
        }
    }

    public boolean onCreate()
    {
        if (mContext == null)
        {
            mContext = getContext();
        }
        return true;
    }

    public final Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        SecurityHelpers.checkCaller(mContext);
        s = getSelectionInfo(uri, s, as1);
        uri = uri.getPath();
        if ("/map_info".equals(uri))
        {
            MAPInit.getInstance(mContext).initialize();
            uri = mBuildInfo;
            s = uri;
            if (uri == null)
            {
                s = BuildInfo.getBuildInfo();
                mBuildInfo = s;
            }
            s1 = new HashMap();
            s1.put("map_major_version", Integer.toString(((BuildInfo) (s)).mMajorVersion));
            s1.put("map_minor_version", Integer.toString(((BuildInfo) (s)).mMinorVersion));
            uri = null;
            if (ChildApplicationHelpers.isOverridingDeviceAttributes(mContext, mContext.getPackageName()))
            {
                uri = TAG;
                uri = getOverrideChildDeviceType();
            } else
            {
                as1 = TAG;
            }
            as1 = uri;
            if (TextUtils.isEmpty(uri))
            {
                as1 = DeviceTypeHelpers.getDeviceTypeForCurrentProcessFromMetadata(mContext);
            }
            s1.put("current_device_type", as1);
            if (ChildApplicationHelpers.isOverridingDeviceAttributes(mContext, mContext.getPackageName()))
            {
                uri = getDsnOverrideForChildDeviceType();
            } else
            {
                uri = null;
            }
            s1.put("dsn_override", uri);
            s1.put("map_sw_version", Integer.toString(((BuildInfo) (s)).mMapSWVersion));
            s1.put("map_brazil_version", ((BuildInfo) (s)).mBrazilVersion);
            s1.put("map_init_version", Integer.toString(MAPInitTasks.getMAPInitVersion(mContext)));
            return DBHelpers.populateCursor(as, s1);
        }
        initializeDataStore();
        if ("/accounts".equals(uri))
        {
            return toQueryCursor(as, (String[])mLocalDataStorage.getAccounts().toArray(new String[0]));
        }
        if ("/userdata".equals(uri))
        {
            if (((SelectionInfo) (s)).directedId != null && ((SelectionInfo) (s)).key != null)
            {
                return toQueryCursor(as, new String[] {
                    mLocalDataStorage.getUserData(((SelectionInfo) (s)).directedId, ((SelectionInfo) (s)).key)
                });
            }
        } else
        if ("/tokens".equals(uri))
        {
            if (((SelectionInfo) (s)).directedId != null && ((SelectionInfo) (s)).key != null)
            {
                return toQueryCursor(as, new String[] {
                    mLocalDataStorage.getToken(((SelectionInfo) (s)).directedId, ((SelectionInfo) (s)).key)
                });
            }
        } else
        if ("/device_data".equals(uri))
        {
            if (((SelectionInfo) (s)).namespace != null && ((SelectionInfo) (s)).key != null)
            {
                return toQueryCursor(as, new String[] {
                    mLocalDataStorage.getDeviceData(((SelectionInfo) (s)).namespace, ((SelectionInfo) (s)).key)
                });
            }
        } else
        {
            if ("/all_data".equals(uri))
            {
                return DBHelpers.populateCursor(as, mLocalDataStorage.getSnapShotOfData());
            }
            if ("/all_deleted_data".equals(uri))
            {
                return DBHelpers.populateCursor(as, mLocalDataStorage.getAllNonDirtyDeletedData());
            }
            if ("/generate_common_info".equals(uri))
            {
                CommonInfoGenerator.getInstance(mContext).generateCommonInfo();
                return toQueryCursor(as, new String[] {
                    Integer.toString(1)
                });
            }
        }
        return null;
    }

    public final int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        SecurityHelpers.checkCaller(mContext);
        initializeDataStore();
        return !setValue(uri, contentvalues) ? 0 : 1;
    }


}
