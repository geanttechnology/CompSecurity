// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.Process;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.service:
//            VineService, VineServiceResponder

private class mMessenger
    implements Runnable
{

    private final int mActionCode;
    private final Bundle mBundle;
    private final Messenger mMessenger;
    private final VineServiceResponder mResponder;
    private final int mStartId;
    final VineService this$0;

    public void run()
    {
        Object obj;
        Process.setThreadPriority(10);
        obj = executeAction(mActionCode, mBundle);
        ((Bundle) (obj)).getInt("executionCode");
        JVM INSTR tableswitch 2 4: default 52
    //                   2 120
    //                   3 371
    //                   4 348;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_371;
_L6:
        int i = ((Bundle) (obj)).getInt("statusCode");
        obj = ((Bundle) (obj)).getString("reasonPhrase");
        Bundle bundle;
        if (mResponder != null)
        {
            obj = new <init>(VineService.this, mResponder, mActionCode, i, ((String) (obj)), mBundle, mStartId);
        } else
        if (mMessenger != null)
        {
            obj = new Runnable(VineService.this, mMessenger, mActionCode, i, ((String) (obj)), mBundle, mStartId);
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            VineService.access$200(VineService.this).post(((Runnable) (obj)));
        }
        return;
_L2:
        SLog.d("Session key was invalid. Refreshing session key and then will try again");
        obj = executeAction(1000, mBundle);
        switch (((Bundle) (obj)).getInt("executionCode"))
        {
        default:
            SLog.d((new StringBuilder()).append("Session key successfully refreshed. Trying original action of ").append(mActionCode).append(" again").toString());
            bundle = executeAction(mActionCode, mBundle);
            switch (bundle.getInt("executionCode"))
            {
            default:
                obj = bundle;
                if (VineService.access$100())
                {
                    mBundle.putBoolean("refresh_session", true);
                    SLog.d("Session key refresh and retry complete.");
                    obj = bundle;
                }
                break;

            case 2: // '\002'
                SLog.d("Session key is still invalid. Aborting.");
                mBundle.putBoolean("logged_out", true);
                obj = bundle;
                break;

            case 3: // '\003'
                SLog.d("Session was logged out.");
                mBundle.putBoolean("logged_out", true);
                obj = bundle;
                break;
            }
            break;

        case 2: // '\002'
            SLog.d("Session key could not be refreshed. Aborting.");
            mBundle.putBoolean("logged_out", true);
            break;

        case 3: // '\003'
            SLog.d("Session was logged out.");
            mBundle.putBoolean("logged_out", true);
            break;
        }
        if (true) goto _L6; else goto _L5
_L5:
_L4:
        SLog.d("Captcha triggered");
        mBundle.putString("captcha_url", ((Bundle) (obj)).getString("captcha_url"));
          goto _L6
        SLog.d("Session was logged out.");
        mBundle.putBoolean("logged_out", true);
          goto _L6
    }

    public Runnable(int i, int j, Bundle bundle, VineServiceResponder vineserviceresponder, Messenger messenger)
    {
        this$0 = VineService.this;
        super();
        mStartId = i;
        mActionCode = j;
        mBundle = bundle;
        mResponder = vineserviceresponder;
        mMessenger = messenger;
    }
}
