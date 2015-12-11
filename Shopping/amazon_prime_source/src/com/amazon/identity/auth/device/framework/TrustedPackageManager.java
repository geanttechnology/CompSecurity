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
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Process;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            TrustedAppUtils, ServiceWrappingContext

public class TrustedPackageManager
{

    private static final String TAG = com/amazon/identity/auth/device/framework/TrustedPackageManager.getName();
    private final boolean mIsIsolatedApplication;
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
            mIsIsolatedApplication = PlatformUtils.isIsolatedApplication(ServiceWrappingContext.create(context));
            return;
        }
    }

    private int checkSignature(String s)
    {
        if (!mMyPackageName.equals(s) || UnitTestUtils.isRunningInUnitTest())
        {
            if (mIsIsolatedApplication)
            {
                return -3;
            }
            if (checkSignatureWithRetry(s) != 0)
            {
                if (mTrustedCerts == null)
                {
                    return -3;
                }
                boolean flag;
                try
                {
                    flag = hasAtLeastOneTrustedSignature(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return -4;
                }
                if (!flag)
                {
                    return -3;
                }
            }
        }
        return 0;
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

    private List getInstalledPackagesWithRetry$22f3aa59()
    {
        List list;
        try
        {
            list = mPackageManager.getInstalledPackages(0);
        }
        catch (Exception exception)
        {
            logPackageManagerException(exception);
            return mPackageManager.getInstalledPackages(0);
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
        Set set;
        boolean flag;
        boolean flag1;
        flag1 = false;
        s = getPackageInfoWithRetry(s, 64).signatures;
        set = mTrustedCerts;
        flag = flag1;
        if (set == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = s.length;
        i = 0;
_L7:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L3
_L3:
        if (!set.contains(s[i])) goto _L5; else goto _L4
_L4:
        flag = true;
_L2:
        return flag;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void logPackageManagerException(Exception exception)
    {
        MAPLog.w(TAG, "PackageManager call failed; retrying", exception);
        MetricsHelper.incrementCounter("PackageManagerError", new String[0]);
    }

    public ProviderInfo getAmazonOwnedContentProvider$14505999(Uri uri)
    {
        Object obj;
        try
        {
            obj = mPackageManager.resolveContentProvider(uri.getAuthority(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logPackageManagerException(((Exception) (obj)));
            uri = mPackageManager.resolveContentProvider(uri.getAuthority(), 0);
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
        MAPLog.e(TAG, String.format("Package %s does not qualify as a trusted package.", new Object[] {
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

    public XmlResourceParser getParserForPackage$6d908fab(PackageItemInfo packageiteminfo)
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

    public ServiceInfo getServiceInfo$42997c6b(ComponentName componentname)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        Object obj;
        try
        {
            obj = mPackageManager.getServiceInfo(componentname, 128);
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
            componentname = mPackageManager.getServiceInfo(componentname, 128);
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
        MAPLog.formattedError(TAG, "Cannot get ServiceInfo from package %s since it is not signed with the Amazon Cert.", new Object[] {
            ((ServiceInfo) (componentname)).packageName
        });
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Set getTrustedInstalledPackages()
    {
        Object obj = getInstalledPackagesWithRetry$22f3aa59();
        HashSet hashset = new HashSet();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            PackageInfo packageinfo = (PackageInfo)((Iterator) (obj)).next();
            if (isTrustedPackage(packageinfo.packageName))
            {
                hashset.add(packageinfo.packageName);
            }
        } while (true);
        return hashset;
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
        if (mIsIsolatedApplication)
        {
            return false;
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
            break MISSING_BLOCK_LABEL_168;
        }
        s = obj[j];
        flag = hasAtLeastOneTrustedSignature(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_251;
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

    public List queryIntentActivities$46e5b6ea(Intent intent)
    {
        Object obj = mPackageManager.queryIntentActivities(intent, 0);
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
        intent = mPackageManager.queryIntentActivities(intent, 0);
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
            if (isTrustedPackage(resolveinfo.serviceInfo.packageName))
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
        ProviderInfo providerinfo;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        providerinfo = aproviderinfo[i];
        if (providerinfo == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        arraylist.add(providerinfo);
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
