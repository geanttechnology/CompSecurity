// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.internal:
//            Utility

public final class NativeProtocol
{
    private static class KatanaAppInfo extends NativeAppInfo
    {

        protected String getPackage()
        {
            return "com.facebook.katana";
        }

        private KatanaAppInfo()
        {
        }

    }

    private static class MessengerAppInfo extends NativeAppInfo
    {

        protected String getPackage()
        {
            return "com.facebook.orca";
        }

        private MessengerAppInfo()
        {
        }

    }

    private static abstract class NativeAppInfo
    {

        private static final HashSet validAppSignatureHashes = buildAppSignatureHashes();
        private TreeSet availableVersions;

        private static HashSet buildAppSignatureHashes()
        {
            HashSet hashset = new HashSet();
            hashset.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashset.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashset.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            return hashset;
        }

        private void fetchAvailableVersions(boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (flag)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            if (availableVersions != null)
            {
                break MISSING_BLOCK_LABEL_21;
            }
            availableVersions = NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(this);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public TreeSet getAvailableVersions()
        {
            if (availableVersions == null)
            {
                fetchAvailableVersions(false);
            }
            return availableVersions;
        }

        protected abstract String getPackage();

        public boolean validateSignature(Context context, String s)
        {
            String s1;
            int i;
            s1 = Build.BRAND;
            i = context.getApplicationInfo().flags;
            if (!s1.startsWith("generic") || (i & 2) == 0) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            int j;
            int k;
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 64);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            context = ((PackageInfo) (context)).signatures;
            k = context.length;
            j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= k)
                    {
                        break label1;
                    }
                    s = Utility.sha1hash(context[j].toByteArray());
                    if (validAppSignatureHashes.contains(s))
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
            if (true) goto _L1; else goto _L3
_L3:
            return false;
        }



        private NativeAppInfo()
        {
        }

    }

    private static class WakizashiAppInfo extends NativeAppInfo
    {

        protected String getPackage()
        {
            return "com.facebook.wakizashi";
        }

        private WakizashiAppInfo()
        {
        }

    }


    private static final NativeAppInfo FACEBOOK_APP_INFO = new KatanaAppInfo();
    private static final List KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[] {
        Integer.valueOf(0x13354a2), Integer.valueOf(0x1335433), Integer.valueOf(0x13353e4), Integer.valueOf(0x13353c9), Integer.valueOf(0x133529d), Integer.valueOf(0x1335124), Integer.valueOf(0x13350ac), Integer.valueOf(0x1332d23), Integer.valueOf(0x1332b3a), Integer.valueOf(0x1332ac6), 
        Integer.valueOf(0x133060d)
    });
    private static Map actionToAppInfoMap = buildActionToAppInfoMap();
    private static List facebookAppInfoList = buildFacebookAppList();
    private static AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    private static Map buildActionToAppInfoMap()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new MessengerAppInfo());
        hashmap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
        hashmap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
        hashmap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
        hashmap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", facebookAppInfoList);
        hashmap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arraylist);
        hashmap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arraylist);
        return hashmap;
    }

    private static List buildFacebookAppList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(FACEBOOK_APP_INFO);
        arraylist.add(new WakizashiAppInfo());
        return arraylist;
    }

    private static Uri buildPlatformProviderVersionURI(NativeAppInfo nativeappinfo)
    {
        return Uri.parse((new StringBuilder()).append("content://").append(nativeappinfo.getPackage()).append(".provider.PlatformProvider/versions").toString());
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet treeset, int i, int ai[])
    {
        int j = ai.length - 1;
        treeset = treeset.descendingIterator();
        int k = -1;
        do
        {
            int l;
            int i1;
            int j1;
label0:
            {
                if (treeset.hasNext())
                {
                    j1 = ((Integer)treeset.next()).intValue();
                    i1 = Math.max(k, j1);
                    for (l = j; l >= 0 && ai[l] > j1; l--) { }
                    if (l >= 0)
                    {
                        break label0;
                    }
                }
                return -1;
            }
            k = i1;
            j = l;
            if (ai[l] == j1)
            {
                if (l % 2 == 0)
                {
                    i = Math.min(i1, i);
                } else
                {
                    i = -1;
                }
                return i;
            }
        } while (true);
    }

    public static Bundle createBundleForException(FacebookException facebookexception)
    {
        Bundle bundle;
        if (facebookexception == null)
        {
            bundle = null;
        } else
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("error_description", facebookexception.toString());
            bundle = bundle1;
            if (facebookexception instanceof FacebookOperationCanceledException)
            {
                bundle1.putString("error_type", "UserCanceled");
                return bundle1;
            }
        }
        return bundle;
    }

    public static Intent createPlatformServiceIntent(Context context)
    {
        for (Iterator iterator = facebookAppInfoList.iterator(); iterator.hasNext();)
        {
            Object obj = (NativeAppInfo)iterator.next();
            obj = validateServiceIntent(context, (new Intent("com.facebook.platform.PLATFORM_SERVICE")).setPackage(((NativeAppInfo) (obj)).getPackage()).addCategory("android.intent.category.DEFAULT"), ((NativeAppInfo) (obj)));
            if (obj != null)
            {
                return ((Intent) (obj));
            }
        }

        return null;
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookexception)
    {
        UUID uuid = getCallIdFromIntent(intent);
        if (uuid == null)
        {
            intent = null;
        } else
        {
            Intent intent1 = new Intent();
            intent1.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(intent));
            intent = new Bundle();
            intent.putString("action_id", uuid.toString());
            if (facebookexception != null)
            {
                intent.putBundle("error", createBundleForException(facebookexception));
            }
            intent1.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", intent);
            intent = intent1;
            if (bundle != null)
            {
                intent1.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
                return intent1;
            }
        }
        return intent;
    }

    public static Intent createProxyAuthIntent(Context context, String s, Collection collection, String s1, boolean flag, boolean flag1, DefaultAudience defaultaudience)
    {
        for (Iterator iterator = facebookAppInfoList.iterator(); iterator.hasNext();)
        {
            Object obj = (NativeAppInfo)iterator.next();
            Intent intent = (new Intent()).setClassName(((NativeAppInfo) (obj)).getPackage(), "com.facebook.katana.ProxyAuth").putExtra("client_id", s);
            if (!Utility.isNullOrEmpty(collection))
            {
                intent.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.isNullOrEmpty(s1))
            {
                intent.putExtra("e2e", s1);
            }
            intent.putExtra("response_type", "token,signed_request");
            intent.putExtra("return_scopes", "true");
            if (flag1)
            {
                intent.putExtra("default_audience", defaultaudience.getNativeProtocolAudience());
            }
            intent.putExtra("legacy_override", "v2.3");
            if (flag)
            {
                intent.putExtra("auth_type", "rerequest");
            }
            obj = validateActivityIntent(context, intent, ((NativeAppInfo) (obj)));
            if (obj != null)
            {
                return ((Intent) (obj));
            }
        }

        return null;
    }

    private static TreeSet fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo nativeappinfo)
    {
        NativeAppInfo nativeappinfo1;
        NativeAppInfo nativeappinfo2;
        Object obj;
        TreeSet treeset;
        ContentResolver contentresolver;
        Uri uri;
        treeset = new TreeSet();
        contentresolver = FacebookSdk.getApplicationContext().getContentResolver();
        uri = buildPlatformProviderVersionURI(nativeappinfo);
        nativeappinfo2 = null;
        obj = null;
        nativeappinfo1 = obj;
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveContentProvider((new StringBuilder()).append(nativeappinfo.getPackage()).append(".provider.PlatformProvider").toString(), 0) == null) goto _L2; else goto _L1
_L1:
        nativeappinfo1 = obj;
        nativeappinfo = contentresolver.query(uri, new String[] {
            "version"
        }, null, null, null);
        nativeappinfo2 = nativeappinfo;
        if (nativeappinfo == null) goto _L2; else goto _L3
_L3:
        nativeappinfo1 = nativeappinfo;
        nativeappinfo2 = nativeappinfo;
        if (!nativeappinfo.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        nativeappinfo1 = nativeappinfo;
        treeset.add(Integer.valueOf(nativeappinfo.getInt(nativeappinfo.getColumnIndex("version"))));
        if (true) goto _L3; else goto _L2
        nativeappinfo;
        if (nativeappinfo1 != null)
        {
            nativeappinfo1.close();
        }
        throw nativeappinfo;
_L2:
        if (nativeappinfo2 != null)
        {
            nativeappinfo2.close();
        }
        return treeset;
    }

    public static UUID getCallIdFromIntent(Intent intent)
    {
        if (intent != null)
        {
            int i = getProtocolVersionFromIntent(intent);
            Object obj = null;
            if (isVersionCompatibleWithBucketedIntent(i))
            {
                Bundle bundle = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                intent = obj;
                if (bundle != null)
                {
                    intent = bundle.getString("action_id");
                }
            } else
            {
                intent = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (intent != null)
            {
                try
                {
                    intent = UUID.fromString(intent);
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    return null;
                }
                return intent;
            }
        }
        return null;
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        }
        String s1 = bundle.getString("error_type");
        String s = s1;
        if (s1 == null)
        {
            s = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String s2 = bundle.getString("error_description");
        s1 = s2;
        if (s2 == null)
        {
            s1 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (s != null && s.equalsIgnoreCase("UserCanceled"))
        {
            return new FacebookOperationCanceledException(s1);
        } else
        {
            return new FacebookException(s1);
        }
    }

    private static int getLatestAvailableProtocolVersionForAppInfoList(List list, int ai[])
    {
        updateAllAvailableProtocolVersionsAsync();
        if (list == null)
        {
            return -1;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            int i = computeLatestAvailableVersionFromVersionSpec(((NativeAppInfo)list.next()).getAvailableVersions(), getLatestKnownVersion(), ai);
            if (i != -1)
            {
                return i;
            }
        }

        return -1;
    }

    public static int getLatestAvailableProtocolVersionForService(int i)
    {
        return getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[] {
            i
        });
    }

    public static final int getLatestKnownVersion()
    {
        return ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent)
    {
        if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)))
        {
            return intent.getExtras();
        } else
        {
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        }
    }

    public static int getProtocolVersionFromIntent(Intent intent)
    {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i)
    {
        return KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i)) && i >= 0x133529d;
    }

    public static void updateAllAvailableProtocolVersionsAsync()
    {
        if (!protocolVersionsAsyncUpdating.compareAndSet(false, true))
        {
            return;
        } else
        {
            FacebookSdk.getExecutor().execute(new Runnable() {

                public void run()
                {
                    for (Iterator iterator = NativeProtocol.facebookAppInfoList.iterator(); iterator.hasNext(); ((NativeAppInfo)iterator.next()).fetchAvailableVersions(true)) { }
                    break MISSING_BLOCK_LABEL_44;
                    Exception exception;
                    exception;
                    NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                    throw exception;
                    NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                    return;
                }

            });
            return;
        }
    }

    static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeappinfo)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            ResolveInfo resolveinfo = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveinfo == null)
            {
                return null;
            }
            if (!nativeappinfo.validateSignature(context, resolveinfo.activityInfo.packageName))
            {
                return null;
            }
        }
        return intent;
    }

    static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeappinfo)
    {
        if (intent == null)
        {
            intent = null;
        } else
        {
            ResolveInfo resolveinfo = context.getPackageManager().resolveService(intent, 0);
            if (resolveinfo == null)
            {
                return null;
            }
            if (!nativeappinfo.validateSignature(context, resolveinfo.serviceInfo.packageName))
            {
                return null;
            }
        }
        return intent;
    }




}
