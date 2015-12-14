// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;

// Referenced classes of package com.mopub.common:
//            ClientMetadata, SharedPreferencesHelper

public class GpsHelper
{

    public static final String ADVERTISING_ID_KEY = "advertisingId";
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
    private static String sAdvertisingIdClientClassName = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static String sPlayServicesUtilClassName = "com.google.android.gms.common.GooglePlayServicesUtil";

    public GpsHelper()
    {
    }

    public static void fetchAdvertisingInfoAsync(Context context, GpsHelperListener gpshelperlistener)
    {
        boolean flag = isPlayServicesAvailable(context);
        if (flag && !isClientMetadataPopulated(context))
        {
            internalFetchAdvertisingInfoAsync(context, gpshelperlistener);
        } else
        {
            if (gpshelperlistener != null)
            {
                gpshelperlistener.onFetchAdInfoCompleted();
            }
            if (flag)
            {
                internalFetchAdvertisingInfoAsync(context, null);
                return;
            }
        }
    }

    public static AdvertisingInfo fetchAdvertisingInfoSync(Context context)
    {
        if (context == null)
        {
            return null;
        }
        try
        {
            context = ((Context) (MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(sAdvertisingIdClientClassName)).addParam(android/content/Context, context).execute()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
        return new AdvertisingInfo(reflectedGetAdvertisingId(context, null), reflectedIsLimitAdTrackingEnabled(context, false));
    }

    private static void internalFetchAdvertisingInfoAsync(Context context, GpsHelperListener gpshelperlistener)
    {
        if (!Reflection.classFound(sAdvertisingIdClientClassName))
        {
            if (gpshelperlistener != null)
            {
                gpshelperlistener.onFetchAdInfoCompleted();
            }
        } else
        {
            try
            {
                AsyncTasks.safeExecuteOnExecutor(new FetchAdvertisingInfoTask(context, gpshelperlistener), new Void[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                MoPubLog.d("Error executing FetchAdvertisingInfoTask", context);
            }
            if (gpshelperlistener != null)
            {
                gpshelperlistener.onFetchAdInfoCompleted();
                return;
            }
        }
    }

    static boolean isClientMetadataPopulated(Context context)
    {
        return ClientMetadata.getInstance(context).isAdvertisingInfoSet();
    }

    public static boolean isLimitAdTrackingEnabled(Context context)
    {
        boolean flag = false;
        if (isPlayServicesAvailable(context))
        {
            flag = SharedPreferencesHelper.getSharedPreferences(context).getBoolean("isLimitAdTrackingEnabled", false);
        }
        return flag;
    }

    public static boolean isPlayServicesAvailable(Context context)
    {
        int i;
        try
        {
            context = ((Context) (MethodBuilderFactory.create(null, "isGooglePlayServicesAvailable").setStatic(Class.forName(sPlayServicesUtilClassName)).addParam(android/content/Context, context).execute()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        i = ((Integer)context).intValue();
        if (i == 0)
        {
            return true;
        }
        return false;
    }

    static String reflectedGetAdvertisingId(Object obj, String s)
    {
        try
        {
            obj = (String)MethodBuilderFactory.create(obj, "getId").execute();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return s;
        }
        return ((String) (obj));
    }

    static boolean reflectedIsLimitAdTrackingEnabled(Object obj, boolean flag)
    {
        boolean flag1;
        try
        {
            obj = (Boolean)MethodBuilderFactory.create(obj, "isLimitAdTrackingEnabled").execute();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return flag;
        }
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        flag1 = ((Boolean) (obj)).booleanValue();
        return flag1;
    }

    public static void setClassNamesForTesting()
    {
        sPlayServicesUtilClassName = "java.lang.Class";
        sAdvertisingIdClientClassName = "java.lang.Class";
    }

    static void updateClientMetadata(Context context, Object obj)
    {
        String s = reflectedGetAdvertisingId(obj, null);
        boolean flag = reflectedIsLimitAdTrackingEnabled(obj, false);
        ClientMetadata.getInstance(context).setAdvertisingInfo(s, flag);
    }



    private class GpsHelperListener
    {

        public abstract void onFetchAdInfoCompleted();
    }


    private class AdvertisingInfo
    {

        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String s, boolean flag)
        {
            advertisingId = s;
            limitAdTracking = flag;
        }
    }


    private class FetchAdvertisingInfoTask extends AsyncTask
    {

        private WeakReference mContextWeakReference;
        private WeakReference mGpsHelperListenerWeakReference;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (Context)mContextWeakReference.get();
            if (avoid == null)
            {
                return null;
            }
            Object obj = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.sAdvertisingIdClientClassName)).addParam(android/content/Context, avoid).execute();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            GpsHelper.updateClientMetadata(avoid, obj);
            return null;
            avoid;
            MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            void1 = (GpsHelperListener)mGpsHelperListenerWeakReference.get();
            if (void1 != null)
            {
                void1.onFetchAdInfoCompleted();
            }
        }

        public FetchAdvertisingInfoTask(Context context, GpsHelperListener gpshelperlistener)
        {
            mContextWeakReference = new WeakReference(context);
            mGpsHelperListenerWeakReference = new WeakReference(gpshelperlistener);
        }
    }

}
