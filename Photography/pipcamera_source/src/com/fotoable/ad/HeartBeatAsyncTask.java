// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import ji;
import jj;

// Referenced classes of package com.fotoable.ad:
//            StaticFlurryEvent

public class HeartBeatAsyncTask extends AsyncTask
{

    Context mContext;
    boolean mHasToken;

    public HeartBeatAsyncTask(Context context, boolean flag)
    {
        mHasToken = false;
        mContext = context;
        mHasToken = flag;
    }

    public static void beat(Context context, boolean flag)
    {
        (new HeartBeatAsyncTask(context, flag)).execute(new String[0]);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        if (!mHasToken)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        String s;
        s = "";
        as = "";
        if (!jj.b()) goto _L2; else goto _L1
_L1:
        s = jj.a().a(mContext);
        StaticFlurryEvent.logGCMEventWithKV("pushkey", "push_upload_token");
        StaticFlurryEvent.logEventUnique(mContext, "pushkey_Unique", "push_upload_token_Unique");
_L3:
        ji.a(mContext, s, as);
_L4:
        return "0";
_L2:
        as = jj.a().a(mContext);
          goto _L3
        try
        {
            ji.a(mContext);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Crashlytics.logException(as);
            as.printStackTrace();
        }
          goto _L4
    }
}
