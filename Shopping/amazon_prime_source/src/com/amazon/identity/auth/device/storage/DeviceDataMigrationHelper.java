// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import com.amazon.identity.auth.device.credentials.AnonymousAccountCredentials;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LocalKeyValueStore

class DeviceDataMigrationHelper
{
    public static class DeviceDataUnit
    {

        final Map mData;
        final String mNamespace;

        public DeviceDataUnit(String s, Map map)
        {
            if (s == null || map == null)
            {
                throw new IllegalArgumentException("namespace and data should not be null!");
            } else
            {
                mNamespace = s;
                mData = map;
                return;
            }
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/DeviceDataMigrationHelper.getName();
    private ServiceWrappingContext mContext;
    private String mDeviceDataNamespaces[];

    public DeviceDataMigrationHelper(ServiceWrappingContext servicewrappingcontext)
    {
        mContext = servicewrappingcontext;
        mDeviceDataNamespaces = (new String[] {
            "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth", "dcp.third.party.device.state", "dcp.only.protected.store", AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "device.metadata"
        });
    }

    public void clearAllDeviceDataInSharedPreference(Context context)
    {
        MAPLog.i(TAG, "Start cleaning device data in shared preferences");
        context = (new StringBuilder()).append(context.getFilesDir().getParent()).append("/shared_prefs/").toString();
        String as[] = mDeviceDataNamespaces;
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s = as[i];
            try
            {
                (new LocalKeyValueStore(mContext, s)).clearStore();
                if (!(new File(context, (new StringBuilder()).append(s).append(".xml").toString())).delete())
                {
                    MAPLog.e(TAG, "Cannot delete the shared preferences file");
                }
            }
            catch (Exception exception)
            {
                MAPLog.e(TAG, "Unexpected exception happens when trying delete the shared preferences file", exception);
            }
            i++;
        }
        MAPLog.i(TAG, "Successfully cleaned device data in shared preferences");
    }

    public List getAllDeviceData()
    {
        ArrayList arraylist = new ArrayList();
        String as[] = mDeviceDataNamespaces;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            arraylist.add(new DeviceDataUnit(s, (new LocalKeyValueStore(mContext, s)).dumpAllData()));
        }

        return arraylist;
    }

}
