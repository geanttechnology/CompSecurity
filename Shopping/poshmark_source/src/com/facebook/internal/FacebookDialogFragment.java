// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.facebook.internal:
//            NativeProtocol, WebDialog, Utility, FacebookWebFallbackDialog

public class FacebookDialogFragment extends DialogFragment
    implements TraceFieldInterface
{

    public static final String TAG = "FacebookDialogFragment";
    private Dialog dialog;

    public FacebookDialogFragment()
    {
    }

    private void onCompleteWebDialog(Bundle bundle, FacebookException facebookexception)
    {
        FragmentActivity fragmentactivity = getActivity();
        bundle = NativeProtocol.createProtocolResultIntent(fragmentactivity.getIntent(), bundle, facebookexception);
        byte byte0;
        if (facebookexception == null)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        fragmentactivity.setResult(byte0, bundle);
        fragmentactivity.finish();
    }

    private void onCompleteWebFallbackDialog(Bundle bundle)
    {
        FragmentActivity fragmentactivity = getActivity();
        Intent intent = new Intent();
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        intent.putExtras(bundle1);
        fragmentactivity.setResult(-1, intent);
        fragmentactivity.finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (dialog instanceof WebDialog)
        {
            ((WebDialog)dialog).resize();
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("FacebookDialogFragment");
        TraceMachine.enterMethod(_nr_trace, "FacebookDialogFragment#onCreate", null);
_L3:
        super.onCreate(bundle);
        if (dialog != null)
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = getActivity();
        Bundle bundle1 = NativeProtocol.getMethodArgumentsFromIntent(bundle.getIntent());
        class _cls1
            implements WebDialog.OnCompleteListener
        {

            final FacebookDialogFragment this$0;

            public void onComplete(Bundle bundle2, FacebookException facebookexception)
            {
                onCompleteWebDialog(bundle2, facebookexception);
            }

            
            {
                this$0 = FacebookDialogFragment.this;
                super();
            }
        }

        Object obj;
        if (!bundle1.getBoolean("is_fallback", false))
        {
            obj = bundle1.getString("action");
            bundle1 = bundle1.getBundle("params");
            if (Utility.isNullOrEmpty(((String) (obj))))
            {
                Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                bundle.finish();
                TraceMachine.exitMethod();
                return;
            }
            break MISSING_BLOCK_LABEL_97;
        }
        obj = bundle1.getString("url");
        if (Utility.isNullOrEmpty(((String) (obj))))
        {
            Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
            bundle.finish();
            TraceMachine.exitMethod();
            return;
        }
        bundle = new FacebookWebFallbackDialog(bundle, ((String) (obj)), String.format("fb%s://bridge/", new Object[] {
            FacebookSdk.getApplicationId()
        }));
        bundle.setOnCompleteListener(new WebDialog.OnCompleteListener() {

            final FacebookDialogFragment this$0;

            public void onComplete(Bundle bundle2, FacebookException facebookexception)
            {
                onCompleteWebFallbackDialog(bundle2);
            }

            
            {
                this$0 = FacebookDialogFragment.this;
                super();
            }
        });
          goto _L1
        obj;
        TraceMachine.enterMethod(null, "FacebookDialogFragment#onCreate", null);
        if (true) goto _L3; else goto _L2
        bundle = (new WebDialog.Builder(bundle, ((String) (obj)), bundle1)).setOnCompleteListener(new _cls1()).build();
_L5:
        dialog = bundle;
_L2:
        TraceMachine.exitMethod();
        return;
_L1:
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        if (dialog == null)
        {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        return dialog;
    }

    public void onDestroyView()
    {
        if (getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void setDialog(Dialog dialog1)
    {
        dialog = dialog1;
    }


}
