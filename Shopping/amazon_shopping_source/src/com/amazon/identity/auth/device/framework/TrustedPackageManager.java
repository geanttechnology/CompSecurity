// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Process;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            TrustedAppUtils

public class TrustedPackageManager
{

    private static final String TAG = com/amazon/identity/auth/device/framework/TrustedPackageManager.getName();
    private final String mMyPackageName;
    private final PackageManager mPackageManager;
    private volatile Set mTrustedCerts;

    public TrustedPackageManager(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context cannot be null");
        } else
        {
            mMyPackageName = context.getPackageName();
            mPackageManager = context.getPackageManager();
            mTrustedCerts = TrustedAppUtils.getTrustedCerts(context);
            return;
        }
    }

    TrustedPackageManager(String s, PackageManager packagemanager, Set set)
    {
        mMyPackageName = s;
        mPackageManager = packagemanager;
        mTrustedCerts = set;
    }

    private int checkSignature(String s)
    {
        boolean flag = false;
        if (!UnitTestUtils.isRunningInUnitTest()) goto _L2; else goto _L1
_L1:
        int i = checkSignatureWithRetry(s);
_L4:
        return i;
_L2:
        i = ((flag) ? 1 : 0);
        if (mMyPackageName.equals(s)) goto _L4; else goto _L3
_L3:
        int j;
        j = checkSignatureWithRetry(s);
        i = ((flag) ? 1 : 0);
        if (j == 0) goto _L4; else goto _L5
_L5:
        if (mTrustedCerts == null)
        {
            return -3;
        }
        i = ((flag) ? 1 : 0);
        if (hasAtLeastOneTrustedSignature(s)) goto _L4; else goto _L6
_L6:
        MAPLog.e(TAG, String.format("Package: %s and Package: %s are not matching the signature for result: %d. The trusted app check also failed.", new Object[] {
            mMyPackageName, s, Integer.valueOf(j)
        }));
        return -3;
        s;
        return -4;
    }

    private int checkSignatureWithRetry(String s)
    {
        int i;
        try
        {
            i = mPackageManager.checkSignatures(mMyPackageName, s);
        }
        catch (Exception exception)
        {
            logPackageManagerException(exception);
            return mPackageManager.checkSignatures(mMyPackageName, s);
        }
        return i;
    }

    private int checkSignaturesWithRetry(int i, int j)
    {
        int k;
        try
        {
            k = mPackageManager.checkSignatures(i, j);
        }
        catch (Exception exception)
        {
            logPackageManagerException(exception);
            return mPackageManager.checkSignatures(i, j);
        }
        return k;
    }

    private boolean containsAtLeastOneTrustedSignature(Signature asignature[])
    {
        Set set = mTrustedCerts;
        if (set != null)
        {
            int j = asignature.length;
            int i = 0;
            while (i < j) 
            {
                if (set.contains(asignature[i]))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private List getInstalledPackagesWithRetry$22f3aa59()
    {
        List list;
        try
        {
            list = mPackageManager.getInstalledPackages(64);
        }
        catch (Exception exception)
        {
            logPackageManagerException(exception);
            return mPackageManager.getInstalledPackages(64);
        }
        return list;
    }

    private PackageInfo getPackageInfoWithRetry(String s, int i)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = mPackageManager.getPackageInfo(s, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        catch (Exception exception)
        {
            logPackageManagerException(exception);
            return mPackageManager.getPackageInfo(s, i);
        }
        return packageinfo;
    }

    private boolean hasAtLeastOneTrustedSignature(String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return containsAtLeastOneTrustedSignature(getPackageInfoWithRetry(s, 64).signatures);
    }

    private void logPackageManagerException(Exception exception)
    {
        MAPLog.w(TAG, "PackageManager call failed; retrying", exception);
        MetricsHelper.increasePeriodicCounter("PackageManagerError", new String[0]);
    }

    public ProviderInfo getAmazonOwnedContentProvider(Uri uri, int i)
    {
        Object obj;
        try
        {
            obj = mPackageManager.resolveContentProvider(uri.getAuthority(), i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logPackageManagerException(((Exception) (obj)));
            uri = mPackageManager.resolveContentProvider(uri.getAuthority(), i);
            continue; /* Loop/switch isn't completed */
        }
        uri = ((Uri) (obj));
_L6:
        if (uri != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((ProviderInfo) (obj));
_L2:
        obj = uri;
        if (isTrustedPackage(((ProviderInfo) (uri)).packageName)) goto _L4; else goto _L3
_L3:
        MAPLog.e(TAG, String.format("Package %s is not an amazon signed package.", new Object[] {
            ((ProviderInfo) (uri)).packageName
        }));
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public PackageInfo getPackageInfoForTrustedPackage(String s, int i)
        throws android.content.pm.PackageManager.NameNotFoundException, SecurityException
    {
        int j = checkSignature(s);
        if (j == 0)
        {
            return getPackageInfoWithRetry(s, i);
        }
        if (j == -4)
        {
            throw new android.content.pm.PackageManager.NameNotFoundException();
        } else
        {
            throw new SecurityException((new StringBuilder()).append(s).append(" is not trusted").toString());
        }
    }

    public XmlResourceParser getParserForPackage(PackageItemInfo packageiteminfo, String s)
    {
        if (packageiteminfo == null)
        {
            MAPLog.e(TAG, "PackageItemInfo cannot be null in getParserForPackage");
            return null;
        } else
        {
            return packageiteminfo.loadXmlMetaData(mPackageManager, "com.amazon.dcp.sso.AccountSubAuthenticator");
        }
    }

    public Resources getResourcesForApplication(String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        Resources resources = null;
        if (isTrustedPackage(s))
        {
            try
            {
                resources = mPackageManager.getResourcesForApplication(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw s;
            }
            catch (Exception exception)
            {
                logPackageManagerException(exception);
                return mPackageManager.getResourcesForApplication(s);
            }
        }
        return resources;
    }

    public ServiceInfo getServiceInfo(ComponentName componentname, int i)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        Object obj;
        try
        {
            obj = mPackageManager.getServiceInfo(componentname, i);
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            throw componentname;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logPackageManagerException(((Exception) (obj)));
            componentname = mPackageManager.getServiceInfo(componentname, i);
            continue; /* Loop/switch isn't completed */
        }
        componentname = ((ComponentName) (obj));
_L6:
        if (componentname != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((ServiceInfo) (obj));
_L2:
        obj = componentname;
        if (isTrustedPackage(((ServiceInfo) (componentname)).packageName)) goto _L4; else goto _L3
_L3:
        MAPLog.e(TAG, "Cannot get ServiceInfo from package %s since it is not signed with the Amazon Cert.", new Object[] {
            ((ServiceInfo) (componentname)).packageName
        });
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Set getTrustedInstalledPackages()
    {
        Object obj = getInstalledPackagesWithRetry$22f3aa59();
        if (mTrustedCerts == null)
        {
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                PackageInfo packageinfo = (PackageInfo)iterator.next();
                if (!mMyPackageName.equals(packageinfo.packageName))
                {
                    continue;
                }
                mTrustedCerts = new HashSet(Arrays.asList(packageinfo.signatures));
                break;
            } while (true);
            if (mTrustedCerts == null)
            {
                MAPLog.e(TAG, "Couldn't find own package in PackageManager. No packages will be trusted.");
            }
        }
        HashSet hashset = new HashSet();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            PackageInfo packageinfo1 = (PackageInfo)((Iterator) (obj)).next();
            if (containsAtLeastOneTrustedSignature(packageinfo1.signatures))
            {
                hashset.add(packageinfo1.packageName);
            }
        } while (true);
        return hashset;
    }

    public boolean hasHandleDeviceMessagePermission(String s)
    {
        int i;
        try
        {
            i = mPackageManager.checkPermission("com.amazon.dcp.messaging.permission.HANDLE_DEVICE_MESSAGE", s);
        }
        catch (Exception exception)
        {
            logPackageManagerException(exception);
            i = mPackageManager.checkPermission("com.amazon.dcp.messaging.permission.HANDLE_DEVICE_MESSAGE", s);
        }
        return i == 0;
    }

    public boolean isTrustedPackage(String s)
    {
        return checkSignature(s) == 0;
    }

    public boolean isTrustedUid(int i)
    {
        int k = Process.myUid();
        if (!UnitTestUtils.isRunningInUnitTest()) goto _L2; else goto _L1
_L1:
        if (checkSignaturesWithRetry(i, k) != 0) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L5:
        return flag1;
_L4:
        return false;
_L2:
        Object obj;
        int j;
        int l;
        int i1;
        if (i == k)
        {
            return true;
        }
        l = checkSignaturesWithRetry(i, k);
        if (l == 0)
        {
            return true;
        }
        if (mTrustedCerts == null)
        {
            return false;
        }
        try
        {
            obj = mPackageManager.getPackagesForUid(i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logPackageManagerException(((Exception) (obj)));
            obj = mPackageManager.getPackagesForUid(i);
        }
        if (obj == null)
        {
            MAPLog.e(TAG, (new StringBuilder("Package name not found for uid : ")).append(i).toString());
            return false;
        }
        flag1 = false;
        i1 = obj.length;
        j = 0;
_L6:
        String s;
        boolean flag;
        flag = flag1;
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        s = obj[j];
        flag = hasAtLeastOneTrustedSignature(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        flag = true;
        flag1 = flag;
        if (!flag)
        {
            MAPLog.e(TAG, String.format("Other uid %d %s and my uid %d are do not have matching signatures (result: %d). The trusted app check also failed.", new Object[] {
                Integer.valueOf(i), Arrays.toString(((Object []) (obj))), Integer.valueOf(k), Integer.valueOf(l)
            }));
            return flag;
        }
          goto _L5
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        MAPLog.e(TAG, (new StringBuilder("Package name not found ")).append(s).toString());
        j++;
          goto _L6
    }

    public List queryIntentActivities(Intent intent, int i)
    {
        Object obj = mPackageManager.queryIntentActivities(intent, i);
        intent = ((Intent) (obj));
_L2:
        obj = new ArrayList();
        intent = intent.iterator();
        do
        {
            if (!intent.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)intent.next();
            if (isTrustedPackage(resolveinfo.activityInfo.packageName))
            {
                ((List) (obj)).add(resolveinfo);
            }
        } while (true);
        break; /* Loop/switch isn't completed */
        obj;
        logPackageManagerException(((Exception) (obj)));
        intent = mPackageManager.queryIntentActivities(intent, i);
        if (true) goto _L2; else goto _L1
_L1:
        return ((List) (obj));
    }

    public List queryIntentServices(Intent intent, int i)
    {
        Object obj = mPackageManager.queryIntentServices(intent, i);
        intent = ((Intent) (obj));
_L2:
        obj = new ArrayList();
        intent = intent.iterator();
        do
        {
            if (!intent.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)intent.next();
            if (isTrustedPackage(resolveinfo.serviceInfo.packageName) || hasHandleDeviceMessagePermission(resolveinfo.serviceInfo.packageName))
            {
                ((List) (obj)).add(resolveinfo);
            }
        } while (true);
        break; /* Loop/switch isn't completed */
        obj;
        logPackageManagerException(((Exception) (obj)));
        intent = mPackageManager.queryIntentServices(intent, i);
        if (true) goto _L2; else goto _L1
_L1:
        return ((List) (obj));
    }

    public List queryTrustedContentProviders()
    {
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = getTrustedInstalledPackages().iterator();
_L4:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        obj = getPackageInfoWithRetry(((String) (obj)), 8);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ProviderInfo aproviderinfo[];
        int j;
        if (((PackageInfo) (obj)).providers == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        aproviderinfo = ((PackageInfo) (obj)).providers;
        j = aproviderinfo.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist.add(aproviderinfo[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        MAPLog.w(TAG, "Caught NameNotFoundException querying for package that existed a moment ago", namenotfoundexception);
        if (true) goto _L4; else goto _L3
_L3:
        return arraylist;
    }

}
