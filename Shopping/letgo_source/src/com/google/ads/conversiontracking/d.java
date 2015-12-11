// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.google.ads.conversiontracking:
//            m, n, l

public class d
{
    static class a extends ContextWrapper
    {

        private final b a;
        private final c b;

        public PackageManager getPackageManager()
        {
            return a;
        }

        public Resources getResources()
        {
            return b;
        }

        public a(Context context)
        {
            super(context);
            a = new b(context);
            b = new c(context.getResources());
        }
    }

    static class b extends PackageManager
    {

        private final Context a;
        private final PackageManager b;

        public void addPackageToPreferred(String s)
        {
            b.addPackageToPreferred(s);
        }

        public boolean addPermission(PermissionInfo permissioninfo)
        {
            return b.addPermission(permissioninfo);
        }

        public boolean addPermissionAsync(PermissionInfo permissioninfo)
        {
            return b.addPermissionAsync(permissioninfo);
        }

        public void addPreferredActivity(IntentFilter intentfilter, int i, ComponentName acomponentname[], ComponentName componentname)
        {
            b.addPreferredActivity(intentfilter, i, acomponentname, componentname);
        }

        public String[] canonicalToCurrentPackageNames(String as[])
        {
            return b.canonicalToCurrentPackageNames(as);
        }

        public int checkPermission(String s, String s1)
        {
            return b.checkPermission(s, s1);
        }

        public int checkSignatures(int i, int j)
        {
            return b.checkSignatures(i, j);
        }

        public int checkSignatures(String s, String s1)
        {
            return b.checkSignatures(s, s1);
        }

        public void clearPackagePreferredActivities(String s)
        {
            b.clearPackagePreferredActivities(s);
        }

        public String[] currentToCanonicalPackageNames(String as[])
        {
            return b.currentToCanonicalPackageNames(as);
        }

        public void extendVerificationTimeout(int i, int j, long l1)
        {
            b.extendVerificationTimeout(i, j, l1);
        }

        public Drawable getActivityIcon(ComponentName componentname)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getActivityIcon(componentname);
        }

        public Drawable getActivityIcon(Intent intent)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getActivityIcon(intent);
        }

        public ActivityInfo getActivityInfo(ComponentName componentname, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getActivityInfo(componentname, i);
        }

        public Drawable getActivityLogo(ComponentName componentname)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getActivityLogo(componentname);
        }

        public Drawable getActivityLogo(Intent intent)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getActivityLogo(intent);
        }

        public List getAllPermissionGroups(int i)
        {
            return b.getAllPermissionGroups(i);
        }

        public int getApplicationEnabledSetting(String s)
        {
            return b.getApplicationEnabledSetting(s);
        }

        public Drawable getApplicationIcon(ApplicationInfo applicationinfo)
        {
            return b.getApplicationIcon(applicationinfo);
        }

        public Drawable getApplicationIcon(String s)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getApplicationIcon(s);
        }

        public ApplicationInfo getApplicationInfo(String s, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            ApplicationInfo applicationinfo = b.getApplicationInfo(s, i);
            if (s.equals(a.getPackageName()) && (i & 0x80) == 128)
            {
                if (applicationinfo.metaData == null)
                {
                    applicationinfo.metaData = new Bundle();
                }
                applicationinfo.metaData.putInt("com.google.android.gms.version", 0x41f6b8);
            }
            return applicationinfo;
        }

        public CharSequence getApplicationLabel(ApplicationInfo applicationinfo)
        {
            return b.getApplicationLabel(applicationinfo);
        }

        public Drawable getApplicationLogo(ApplicationInfo applicationinfo)
        {
            return b.getApplicationLogo(applicationinfo);
        }

        public Drawable getApplicationLogo(String s)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getApplicationLogo(s);
        }

        public int getComponentEnabledSetting(ComponentName componentname)
        {
            return b.getComponentEnabledSetting(componentname);
        }

        public Drawable getDefaultActivityIcon()
        {
            return b.getDefaultActivityIcon();
        }

        public Drawable getDrawable(String s, int i, ApplicationInfo applicationinfo)
        {
            return b.getDrawable(s, i, applicationinfo);
        }

        public List getInstalledApplications(int i)
        {
            return b.getInstalledApplications(i);
        }

        public List getInstalledPackages(int i)
        {
            return b.getInstalledPackages(i);
        }

        public String getInstallerPackageName(String s)
        {
            return b.getInstallerPackageName(s);
        }

        public InstrumentationInfo getInstrumentationInfo(ComponentName componentname, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getInstrumentationInfo(componentname, i);
        }

        public Intent getLaunchIntentForPackage(String s)
        {
            return b.getLaunchIntentForPackage(s);
        }

        public String getNameForUid(int i)
        {
            return b.getNameForUid(i);
        }

        public int[] getPackageGids(String s)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getPackageGids(s);
        }

        public PackageInfo getPackageInfo(String s, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getPackageInfo(s, i);
        }

        public String[] getPackagesForUid(int i)
        {
            return b.getPackagesForUid(i);
        }

        public List getPackagesHoldingPermissions(String as[], int i)
        {
            return b.getPackagesHoldingPermissions(as, i);
        }

        public PermissionGroupInfo getPermissionGroupInfo(String s, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getPermissionGroupInfo(s, i);
        }

        public PermissionInfo getPermissionInfo(String s, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getPermissionInfo(s, i);
        }

        public int getPreferredActivities(List list, List list1, String s)
        {
            return b.getPreferredActivities(list, list1, s);
        }

        public List getPreferredPackages(int i)
        {
            return b.getPreferredPackages(i);
        }

        public ProviderInfo getProviderInfo(ComponentName componentname, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getProviderInfo(componentname, i);
        }

        public ActivityInfo getReceiverInfo(ComponentName componentname, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getReceiverInfo(componentname, i);
        }

        public Resources getResourcesForActivity(ComponentName componentname)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getResourcesForActivity(componentname);
        }

        public Resources getResourcesForApplication(ApplicationInfo applicationinfo)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getResourcesForApplication(applicationinfo);
        }

        public Resources getResourcesForApplication(String s)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getResourcesForApplication(s);
        }

        public ServiceInfo getServiceInfo(ComponentName componentname, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.getServiceInfo(componentname, i);
        }

        public FeatureInfo[] getSystemAvailableFeatures()
        {
            return b.getSystemAvailableFeatures();
        }

        public String[] getSystemSharedLibraryNames()
        {
            return b.getSystemSharedLibraryNames();
        }

        public CharSequence getText(String s, int i, ApplicationInfo applicationinfo)
        {
            return b.getText(s, i, applicationinfo);
        }

        public XmlResourceParser getXml(String s, int i, ApplicationInfo applicationinfo)
        {
            return b.getXml(s, i, applicationinfo);
        }

        public boolean hasSystemFeature(String s)
        {
            return b.hasSystemFeature(s);
        }

        public boolean isSafeMode()
        {
            return b.isSafeMode();
        }

        public List queryBroadcastReceivers(Intent intent, int i)
        {
            return b.queryBroadcastReceivers(intent, i);
        }

        public List queryContentProviders(String s, int i, int j)
        {
            return b.queryContentProviders(s, i, j);
        }

        public List queryInstrumentation(String s, int i)
        {
            return b.queryInstrumentation(s, i);
        }

        public List queryIntentActivities(Intent intent, int i)
        {
            return b.queryIntentActivities(intent, i);
        }

        public List queryIntentActivityOptions(ComponentName componentname, Intent aintent[], Intent intent, int i)
        {
            return b.queryIntentActivityOptions(componentname, aintent, intent, i);
        }

        public List queryIntentContentProviders(Intent intent, int i)
        {
            return b.queryIntentContentProviders(intent, i);
        }

        public List queryIntentServices(Intent intent, int i)
        {
            return b.queryIntentServices(intent, i);
        }

        public List queryPermissionsByGroup(String s, int i)
            throws android.content.pm.PackageManager.NameNotFoundException
        {
            return b.queryPermissionsByGroup(s, i);
        }

        public void removePackageFromPreferred(String s)
        {
            b.removePackageFromPreferred(s);
        }

        public void removePermission(String s)
        {
            b.removePermission(s);
        }

        public ResolveInfo resolveActivity(Intent intent, int i)
        {
            return b.resolveActivity(intent, i);
        }

        public ProviderInfo resolveContentProvider(String s, int i)
        {
            return b.resolveContentProvider(s, i);
        }

        public ResolveInfo resolveService(Intent intent, int i)
        {
            return b.resolveService(intent, i);
        }

        public void setApplicationEnabledSetting(String s, int i, int j)
        {
            b.setApplicationEnabledSetting(s, i, j);
        }

        public void setComponentEnabledSetting(ComponentName componentname, int i, int j)
        {
            b.setComponentEnabledSetting(componentname, i, j);
        }

        public void setInstallerPackageName(String s, String s1)
        {
            b.setInstallerPackageName(s, s1);
        }

        public void verifyPendingInstall(int i, int j)
        {
            b.verifyPendingInstall(i, j);
        }

        public b(Context context)
        {
            a = context;
            b = context.getPackageManager();
        }
    }

    static class c extends Resources
    {

        public String getString(int i)
        {
            return "";
        }

        public c(Resources resources)
        {
            super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        }
    }


    private Context a;

    public d(Context context)
    {
        a = new a(context);
    }

    public l.a a()
    {
        l.a a1 = l.a(a);
        return a1;
        Object obj;
        obj;
_L2:
        return null;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
