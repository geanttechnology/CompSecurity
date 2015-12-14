// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import java.lang.ref.WeakReference;

// Referenced classes of package com.mopub.common:
//            GpsHelper

private static class mGpsHelperListenerWeakReference extends AsyncTask
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
        Object obj = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").extWeakReference(Class.forName(GpsHelper.access$000())).extWeakReference(android/content/Context, avoid).extWeakReference();
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
        void1 = (onPostExecute)mGpsHelperListenerWeakReference.get();
        if (void1 != null)
        {
            void1.AdInfoCompleted();
        }
    }

    public _cls9(Context context, _cls9 _pcls9)
    {
        mContextWeakReference = new WeakReference(context);
        mGpsHelperListenerWeakReference = new WeakReference(_pcls9);
    }
}
