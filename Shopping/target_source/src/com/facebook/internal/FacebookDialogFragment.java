// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.f;
import com.facebook.i;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.facebook.internal:
//            k, q, o, g

public class FacebookDialogFragment extends DialogFragment
    implements TraceFieldInterface
{

    private Dialog a;

    public FacebookDialogFragment()
    {
    }

    private void a(Bundle bundle)
    {
        f f1 = getActivity();
        Intent intent = new Intent();
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        intent.putExtras(bundle1);
        f1.setResult(-1, intent);
        f1.finish();
    }

    private void a(Bundle bundle, com.facebook.f f1)
    {
        f f2 = getActivity();
        bundle = k.a(f2.getIntent(), bundle, f1);
        byte byte0;
        if (f1 == null)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        f2.setResult(byte0, bundle);
        f2.finish();
    }

    static void a(FacebookDialogFragment facebookdialogfragment, Bundle bundle)
    {
        facebookdialogfragment.a(bundle);
    }

    static void a(FacebookDialogFragment facebookdialogfragment, Bundle bundle, com.facebook.f f1)
    {
        facebookdialogfragment.a(bundle, f1);
    }

    public void a(Dialog dialog)
    {
        a = dialog;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (a instanceof q)
        {
            ((q)a).d();
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("FacebookDialogFragment");
        TraceMachine.enterMethod(_nr_trace, "FacebookDialogFragment#onCreate", null);
_L3:
        super.onCreate(bundle);
        if (a != null)
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = getActivity();
        Bundle bundle1 = k.c(bundle.getIntent());
        class _cls1
            implements q.c
        {

            final FacebookDialogFragment a;

            public void a(Bundle bundle2, com.facebook.f f1)
            {
                FacebookDialogFragment.a(a, bundle2, f1);
            }

            
            {
                a = FacebookDialogFragment.this;
                super();
            }
        }

        Object obj;
        if (!bundle1.getBoolean("is_fallback", false))
        {
            obj = bundle1.getString("action");
            bundle1 = bundle1.getBundle("params");
            if (o.a(((String) (obj))))
            {
                o.a("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                bundle.finish();
                TraceMachine.exitMethod();
                return;
            }
            break MISSING_BLOCK_LABEL_97;
        }
        obj = bundle1.getString("url");
        if (o.a(((String) (obj))))
        {
            o.a("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
            bundle.finish();
            TraceMachine.exitMethod();
            return;
        }
        bundle = new g(bundle, ((String) (obj)), String.format("fb%s://bridge/", new Object[] {
            i.i()
        }));
        bundle.a(new q.c() {

            final FacebookDialogFragment a;

            public void a(Bundle bundle2, com.facebook.f f1)
            {
                FacebookDialogFragment.a(a, bundle2);
            }

            
            {
                a = FacebookDialogFragment.this;
                super();
            }
        });
          goto _L1
        obj;
        TraceMachine.enterMethod(null, "FacebookDialogFragment#onCreate", null);
        if (true) goto _L3; else goto _L2
        bundle = (new q.a(bundle, ((String) (obj)), bundle1)).a(new _cls1()).a();
_L5:
        a = bundle;
_L2:
        TraceMachine.exitMethod();
        return;
_L1:
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        if (a == null)
        {
            a(((Bundle) (null)), ((com.facebook.f) (null)));
            setShowsDialog(false);
        }
        return a;
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
}
