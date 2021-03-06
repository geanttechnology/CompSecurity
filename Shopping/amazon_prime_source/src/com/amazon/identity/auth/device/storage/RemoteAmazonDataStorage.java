// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            AccountTransaction, MAPInformationProviderHelpers

public class RemoteAmazonDataStorage
{
    private static final class SelectionContentProviderInfo
    {

        public final String selection;
        public final String selectionArgs[];

        private static void addValueToSelection(LinkedHashMap linkedhashmap, List list, String s, String s1)
        {
            if (s1 == null)
            {
                return;
            } else
            {
                linkedhashmap.put(s, "?");
                list.add(s1);
                return;
            }
        }

        public static SelectionContentProviderInfo create(Collection collection)
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            ArrayList arraylist = new ArrayList();
            addValueToSelection(linkedhashmap, arraylist, "bulk_data", ParcelUtils.listOfMapOfStringsToString(collection));
            return new SelectionContentProviderInfo(JSONHelpers.toJsonString(linkedhashmap), (String[])arraylist.toArray(new String[0]));
        }

        public static SelectionContentProviderInfo create$86a8b1c(String s, String s1, Date date)
        {
            LinkedHashMap linkedhashmap = new LinkedHashMap();
            ArrayList arraylist = new ArrayList();
            addValueToSelection(linkedhashmap, arraylist, "directedId", s);
            addValueToSelection(linkedhashmap, arraylist, "key", s1);
            addValueToSelection(linkedhashmap, arraylist, "value", null);
            addValueToSelection(linkedhashmap, arraylist, "namespace", null);
            addValueToSelection(linkedhashmap, arraylist, "timestamp_key", TimeUtil.serialize(date));
            return new SelectionContentProviderInfo(JSONHelpers.toJsonString(linkedhashmap), (String[])arraylist.toArray(new String[0]));
        }

        private SelectionContentProviderInfo(String s, String as[])
        {
            selection = s;
            selectionArgs = as;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/RemoteAmazonDataStorage.getName();
    private final Context mContext;
    private final RemoteMapInfo mProviderInfo;
    private final SecureContentResolver mSecureContentResolver;

    public RemoteAmazonDataStorage(Context context, RemoteMapInfo remotemapinfo)
    {
        mContext = context;
        mSecureContentResolver = new SecureContentResolver(context);
        mProviderInfo = remotemapinfo;
    }

    private Collection getBulkDataFromUri(final Uri getBulkDataUri)
        throws RemoteMAPException
    {
        return (Collection)mSecureContentResolver.acquireContentProviderClient(getBulkDataUri, new ContentProviderClientCallback() {

            final RemoteAmazonDataStorage this$0;
            final Uri val$getBulkDataUri;

            public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                return useContentProviderClient(contentproviderclient);
            }

            public Collection useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                contentproviderclient = contentproviderclient.query(getBulkDataUri, (String[])MAPInformationProviderHelpers.QUERY_BULK_DATA_COLUMNS.toArray(new String[0]), null, null, null);
                if (contentproviderclient == null)
                {
                    return null;
                }
                Object obj;
                boolean flag;
                obj = new LinkedList();
                flag = contentproviderclient.moveToFirst();
                if (!flag)
                {
                    DBHelpers.closeCursor(contentproviderclient);
                    return ((Collection) (obj));
                }
_L4:
                HashMap hashmap;
                Iterator iterator;
                hashmap = new HashMap();
                iterator = MAPInformationProviderHelpers.QUERY_BULK_DATA_COLUMNS.iterator();
_L2:
                String s;
                String s1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_134;
                    }
                    s = (String)iterator.next();
                    s1 = DBHelpers.getString(contentproviderclient, s);
                } while (s == null);
                hashmap.put(s, s1);
                if (true) goto _L2; else goto _L1
_L1:
                obj;
                DBHelpers.closeCursor(contentproviderclient);
                throw obj;
                ((Collection) (obj)).add(hashmap);
                flag = contentproviderclient.moveToNext();
                if (!flag)
                {
                    DBHelpers.closeCursor(contentproviderclient);
                    return ((Collection) (obj));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = RemoteAmazonDataStorage.this;
                getBulkDataUri = uri;
                super();
            }
        });
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, Date date)
    {
        String s1 = accounttransaction.getDirectedId();
        if (s == null || s1 == null || date == null)
        {
            return false;
        }
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        hashmap.put("display_name", s);
        hashmap.put("directedId", s1);
        arraylist.add(hashmap);
        HashMap hashmap2;
        for (s = accounttransaction.getUserData().entrySet().iterator(); s.hasNext(); arraylist.add(hashmap2))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)s.next();
            hashmap2 = new HashMap();
            hashmap2.put("userdata_account", s1);
            hashmap2.put("userdata_key", entry.getKey());
            hashmap2.put("userdata_value", entry.getValue());
        }

        HashMap hashmap1;
        for (s = accounttransaction.getTokens().entrySet().iterator(); s.hasNext(); arraylist.add(hashmap1))
        {
            accounttransaction = (java.util.Map.Entry)s.next();
            hashmap1 = new HashMap();
            hashmap1.put("token_account", s1);
            hashmap1.put("token_key", accounttransaction.getKey());
            hashmap1.put("token_value", accounttransaction.getValue());
        }

        long l = date.getTime();
        for (s = arraylist.iterator(); s.hasNext(); accounttransaction.put("deleted_key", "false"))
        {
            accounttransaction = (Map)s.next();
            accounttransaction.put("timestamp_key", String.valueOf(l));
        }

        return setBulkData(arraylist);
    }

    public boolean clearBulkData(Collection collection)
    {
        Uri uri = MAPInformationProviderHelpers.getBulkDataUri(mProviderInfo.getProviderAuthority());
        collection = SelectionContentProviderInfo.create(collection);
        int i;
        boolean flag;
        try
        {
            i = mSecureContentResolver.delete(uri, ((SelectionContentProviderInfo) (collection)).selection, ((SelectionContentProviderInfo) (collection)).selectionArgs);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            MAPLog.i(TAG, String.format("clear bulk data was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }), collection);
            return false;
        }
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            String.format("clear bulk data was successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            });
            return flag;
        } else
        {
            MAPLog.i(TAG, String.format("clear bulk data was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }));
            return flag;
        }
    }

    public boolean expireToken(String s, String s1, Date date)
    {
        Uri uri = MAPInformationProviderHelpers.getTokensUri(mProviderInfo.getProviderAuthority());
        s = SelectionContentProviderInfo.create._mth86a8b1c(s, s1, date);
        int i = mContext.getContentResolver().delete(uri, ((SelectionContentProviderInfo) (s)).selection, ((SelectionContentProviderInfo) (s)).selectionArgs);
        String.format("Expired %s tokens from package %s", new Object[] {
            Integer.valueOf(i), mProviderInfo.getPackageName()
        });
        return i != 0;
    }

    public Collection getAllData()
        throws RemoteMAPException
    {
        return getBulkDataFromUri(MAPInformationProviderHelpers.getAllDataUri(mProviderInfo.getProviderAuthority()));
    }

    public Collection getAllDeletedData()
        throws RemoteMAPException
    {
        return getBulkDataFromUri(MAPInformationProviderHelpers.getAllDeletedDataUri(mProviderInfo.getProviderAuthority()));
    }

    public boolean removeAccount(String s, Date date)
    {
        Uri uri = MAPInformationProviderHelpers.getAccountUri(mProviderInfo.getProviderAuthority());
        s = SelectionContentProviderInfo.create._mth86a8b1c(s, null, date);
        int i;
        try
        {
            i = mSecureContentResolver.delete(uri, ((SelectionContentProviderInfo) (s)).selection, ((SelectionContentProviderInfo) (s)).selectionArgs);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.i(TAG, String.format("Failed to remove accounts from package %s", new Object[] {
                mProviderInfo.getPackageName()
            }), s);
            return false;
        }
        String.format("Removed %s accounts from package %s", new Object[] {
            Integer.valueOf(i), mProviderInfo.getPackageName()
        });
        return i != 0;
    }

    public boolean setBulkData(Collection collection)
    {
        Uri uri = MAPInformationProviderHelpers.getBulkDataUri(mProviderInfo.getProviderAuthority());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("bulk_data", ParcelUtils.listOfMapOfStringsToString(collection));
        boolean flag;
        try
        {
            collection = mSecureContentResolver.insert(uri, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            MAPLog.i(TAG, String.format("set bulk data was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }), collection);
            return false;
        }
        if (collection != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            String.format("set bulk data was successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            });
            return flag;
        } else
        {
            MAPLog.i(TAG, String.format("set bulk data was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }));
            return flag;
        }
    }

    public boolean setDeviceData(String s, String s1, String s2, Date date)
    {
        Uri uri = MAPInformationProviderHelpers.getDeviceDataUri(mProviderInfo.getProviderAuthority());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("namespace", s);
        contentvalues.put("key", s1);
        contentvalues.put("value", s2);
        if (date != null)
        {
            contentvalues.put("timestamp_key", Long.valueOf(date.getTime()));
        }
        boolean flag;
        if (mContext.getContentResolver().insert(uri, contentvalues) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            String.format("set device data was successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            });
            return flag;
        } else
        {
            MAPLog.i(TAG, String.format("set device daya was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }));
            return flag;
        }
    }

    public boolean setToken(String s, String s1, String s2, Date date)
    {
        Uri uri = MAPInformationProviderHelpers.getTokensUri(mProviderInfo.getProviderAuthority());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("directedId", s);
        contentvalues.put("key", s1);
        contentvalues.put("value", s2);
        if (date != null)
        {
            contentvalues.put("timestamp_key", Long.valueOf(date.getTime()));
        }
        boolean flag;
        if (mContext.getContentResolver().insert(uri, contentvalues) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            String.format("set token was successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            });
            return flag;
        } else
        {
            MAPLog.i(TAG, String.format("set token was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }));
            return flag;
        }
    }

    public boolean setUserData(String s, String s1, String s2, Date date)
    {
        Uri uri = MAPInformationProviderHelpers.getUserdataUri(mProviderInfo.getProviderAuthority());
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("directedId", s);
        contentvalues.put("key", s1);
        contentvalues.put("value", s2);
        if (date != null)
        {
            contentvalues.put("timestamp_key", Long.valueOf(date.getTime()));
        }
        boolean flag;
        if (mContext.getContentResolver().insert(uri, contentvalues) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            String.format("set userdata was successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            });
            return flag;
        } else
        {
            MAPLog.i(TAG, String.format("set userdata was not successful with package %s.", new Object[] {
                mProviderInfo.getPackageName()
            }));
            return flag;
        }
    }

}
