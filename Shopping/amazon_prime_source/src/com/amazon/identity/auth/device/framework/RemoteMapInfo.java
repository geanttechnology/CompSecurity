// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.identity.auth.accounts.ChildApplicationHelpers;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.storage.MAPInformationProviderHelpers;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.IntegerHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext, RemoteMAPException, SecureContentResolver, CommonInfoGenerator, 
//            ContentProviderClientCallback

public class RemoteMapInfo
{

    private static final String TAG = com/amazon/identity/auth/device/framework/RemoteMapInfo.getName();
    private String mBrazilVersion;
    private final Context mContext;
    private String mDeviceType;
    private boolean mHasFetchedData;
    private Integer mMAPInitVersion;
    private Integer mMajorVersion;
    private Integer mMinorVersion;
    private String mOverrideDSN;
    private final String mPackageName;
    private Integer mPackageVersion;
    private final String mProviderAuthority;
    private RemoteMAPException mRemoteMapException;
    private Integer mSWVersion;

    public RemoteMapInfo(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mPackageName = mContext.getPackageName();
        mProviderAuthority = null;
        mHasFetchedData = false;
    }

    public RemoteMapInfo(Context context, ProviderInfo providerinfo)
    {
        mContext = ServiceWrappingContext.create(context);
        mPackageName = providerinfo.packageName;
        mProviderAuthority = providerinfo.authority;
        mHasFetchedData = false;
    }

    private void addToSbIfNotNull(StringBuilder stringbuilder, String s, Object obj)
    {
        if (obj == null)
        {
            return;
        } else
        {
            stringbuilder.append(s).append(" = ").append(obj).append(", ");
            return;
        }
    }

    public static int compare(RemoteMapInfo remotemapinfo, RemoteMapInfo remotemapinfo1)
    {
        if (remotemapinfo == null)
        {
            return remotemapinfo1 == null ? 0 : -1;
        } else
        {
            return remotemapinfo.compareLatest(remotemapinfo1);
        }
    }

    private void fetchVersionInfo()
        throws RemoteMAPException
    {
        this;
        JVM INSTR monitorenter ;
        final Uri mapVersionInfoUri;
        SecureContentResolver securecontentresolver;
        mHasFetchedData = true;
        mapVersionInfoUri = MAPInformationProviderHelpers.getMapVersionInfoUri(mProviderAuthority);
        securecontentresolver = new SecureContentResolver(mContext);
        securecontentresolver.acquireContentProviderClient(mapVersionInfoUri, new ContentProviderClientCallback() {

            final RemoteMapInfo this$0;
            final Uri val$mapVersionInfoUri;

            public Object useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                contentproviderclient = contentproviderclient.query(mapVersionInfoUri, (String[])MAPInformationProviderHelpers.QUERY_MAP_INFO_COLUMNS.toArray(new String[0]), null, null, null);
                if (contentproviderclient == null)
                {
                    break MISSING_BLOCK_LABEL_40;
                }
                if (contentproviderclient.moveToFirst())
                {
                    break MISSING_BLOCK_LABEL_71;
                }
                MAPLog.e(RemoteMapInfo.TAG, String.format("No version info returned from package %s.", new Object[] {
                    mPackageName
                }));
                DBHelpers.closeCursor(contentproviderclient);
                return null;
                mMajorVersion = StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_major_version"));
                mMinorVersion = StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_minor_version"));
                mSWVersion = StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_sw_version"));
                mBrazilVersion = DBHelpers.getString(contentproviderclient, "map_brazil_version");
                mDeviceType = DBHelpers.getString(contentproviderclient, "current_device_type");
                if (mDeviceType == null)
                {
                    MAPLog.formattedError(RemoteMapInfo.TAG, "Package %s has a null device type. Defaulting to the central device type", new Object[] {
                        getPackageName()
                    });
                    mDeviceType = Platform.getDeviceAttribute(mContext, DeviceAttribute.CentralDeviceType);
                }
                if (!DBHelpers.containsColumn(contentproviderclient, "dsn_override"))
                {
                    break MISSING_BLOCK_LABEL_249;
                }
                mOverrideDSN = DBHelpers.getString(contentproviderclient, "dsn_override");
_L1:
                mMAPInitVersion = StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_init_version"));
                DBHelpers.closeCursor(contentproviderclient);
                return null;
                MAPLog.formattedInfo(RemoteMapInfo.TAG, "Package %s does not provide a custom DSN override", new Object[] {
                    mPackageName
                });
                  goto _L1
                Exception exception;
                exception;
                DBHelpers.closeCursor(contentproviderclient);
                throw exception;
            }

            
            {
                this$0 = RemoteMapInfo.this;
                mapVersionInfoUri = uri;
                super();
            }
        });
        mRemoteMapException = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        MAPLog.e(TAG, (new StringBuilder("Failed to query ")).append(getPackageName()).toString(), ((Throwable) (obj)));
        MetricsHelper.incrementCounter((new StringBuilder("RemoteMapInfoFailure:")).append(getPackageName()).toString(), new String[0]);
        mRemoteMapException = new RemoteMAPException(((Throwable) (obj)));
        throw mRemoteMapException;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private void populateVersionInfo()
        throws RemoteMAPException
    {
        this;
        JVM INSTR monitorenter ;
        if (mRemoteMapException != null)
        {
            throw mRemoteMapException;
        }
        break MISSING_BLOCK_LABEL_19;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = mHasFetchedData;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_31;
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        fetchVersionInfo();
          goto _L1
    }

    public int compareLatest(RemoteMapInfo remotemapinfo)
    {
        int i;
        if (remotemapinfo == null)
        {
            i = 1;
        } else
        {
            int k;
            try
            {
                populateVersionInfo();
            }
            catch (RemoteMAPException remotemapexception) { }
            try
            {
                remotemapinfo.populateVersionInfo();
            }
            catch (RemoteMAPException remotemapexception1) { }
            k = IntegerHelpers.compare(mMajorVersion, remotemapinfo.mMajorVersion);
            i = k;
            if (k == 0)
            {
                int j = IntegerHelpers.compare(mMinorVersion, remotemapinfo.mMinorVersion);
                if (j != 0)
                {
                    return j;
                }
                String s = getPackageName();
                remotemapinfo = remotemapinfo.getPackageName();
                if (s == null)
                {
                    return remotemapinfo == null ? 0 : -1;
                }
                if (remotemapinfo == null)
                {
                    return 1;
                } else
                {
                    return s.compareTo(remotemapinfo);
                }
            }
        }
        return i;
    }

    public Integer fetchMAPInitVersion()
        throws RemoteMAPException
    {
        fetchVersionInfo();
        return mMAPInitVersion;
    }

    public int generateCommonInfo()
        throws RemoteMAPException
    {
        if (mProviderAuthority == null)
        {
            return CommonInfoGenerator.getInstance(mContext).generateCommonInfo();
        }
        Object obj = MAPInformationProviderHelpers.generateCommonInfoUri(mProviderAuthority);
        obj = StringConversionHelpers.toInteger(DBHelpers.querySingleResult$2dd5bf17(new SecureContentResolver(mContext), ((Uri) (obj)), "value"));
        if (obj == null)
        {
            throw new RemoteMAPException("Common info version String not a valid integer.");
        } else
        {
            return ((Integer) (obj)).intValue();
        }
    }

    public String getBrazilVersion()
        throws RemoteMAPException
    {
        populateVersionInfo();
        return mBrazilVersion;
    }

    public String getDeviceType()
        throws RemoteMAPException
    {
        this;
        JVM INSTR monitorenter ;
        if (mDeviceType == null) goto _L2; else goto _L1
_L1:
        String s = mDeviceType;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (ChildApplicationHelpers.isOverridingDeviceAttributes(mContext, getPackageName()))
        {
            populateVersionInfo();
            s = mDeviceType;
            continue; /* Loop/switch isn't completed */
        }
        mDeviceType = DeviceTypeHelpers.getDeviceTypeForAPackageFromMetadata(mContext, getPackageName());
        s = mDeviceType;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Integer getMajorVersion()
        throws RemoteMAPException
    {
        populateVersionInfo();
        return mMajorVersion;
    }

    public Integer getMinorVersion()
        throws RemoteMAPException
    {
        populateVersionInfo();
        return mMinorVersion;
    }

    public String getOverrideDSN()
        throws RemoteMAPException
    {
        if (!ChildApplicationHelpers.isOverridingDeviceAttributes(mContext, getPackageName()))
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorenter ;
        String s;
        populateVersionInfo();
        s = mOverrideDSN;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        return null;
    }

    public String getPackageName()
    {
        return mPackageName;
    }

    public Integer getPackageVersion()
    {
        this;
        JVM INSTR monitorenter ;
        Integer integer;
        if (mPackageVersion == null)
        {
            mPackageVersion = PackageUtils.getPackageVersion(mContext, getPackageName());
        }
        integer = mPackageVersion;
        this;
        JVM INSTR monitorexit ;
        return integer;
        Exception exception;
        exception;
        throw exception;
    }

    public String getProviderAuthority()
    {
        return mProviderAuthority;
    }

    public Integer getSWVersion()
        throws RemoteMAPException
    {
        populateVersionInfo();
        return mSWVersion;
    }

    public boolean isSelf()
    {
        return mContext.getPackageName().equals(getPackageName());
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("[");
        addToSbIfNotNull(stringbuilder, "PackageName", getPackageName());
        try
        {
            addToSbIfNotNull(stringbuilder, "DeviceType", getDeviceType());
            addToSbIfNotNull(stringbuilder, "MajorVersion", getMajorVersion());
            addToSbIfNotNull(stringbuilder, "MinorVersion", getMinorVersion());
            addToSbIfNotNull(stringbuilder, "SWVersion", getSWVersion());
            addToSbIfNotNull(stringbuilder, "BrazilVersion", getBrazilVersion());
        }
        catch (RemoteMAPException remotemapexception)
        {
            MAPLog.w(TAG, (new StringBuilder("Failed to query ")).append(getPackageName()).toString(), remotemapexception);
        }
        addToSbIfNotNull(stringbuilder, "MAPInitVersion", mMAPInitVersion);
        return stringbuilder.append("]").toString();
    }





/*
    static Integer access$202(RemoteMapInfo remotemapinfo, Integer integer)
    {
        remotemapinfo.mMajorVersion = integer;
        return integer;
    }

*/


/*
    static Integer access$302(RemoteMapInfo remotemapinfo, Integer integer)
    {
        remotemapinfo.mMinorVersion = integer;
        return integer;
    }

*/


/*
    static Integer access$402(RemoteMapInfo remotemapinfo, Integer integer)
    {
        remotemapinfo.mSWVersion = integer;
        return integer;
    }

*/


/*
    static String access$502(RemoteMapInfo remotemapinfo, String s)
    {
        remotemapinfo.mBrazilVersion = s;
        return s;
    }

*/



/*
    static String access$602(RemoteMapInfo remotemapinfo, String s)
    {
        remotemapinfo.mDeviceType = s;
        return s;
    }

*/



/*
    static String access$802(RemoteMapInfo remotemapinfo, String s)
    {
        remotemapinfo.mOverrideDSN = s;
        return s;
    }

*/


/*
    static Integer access$902(RemoteMapInfo remotemapinfo, Integer integer)
    {
        remotemapinfo.mMAPInitVersion = integer;
        return integer;
    }

*/
}
