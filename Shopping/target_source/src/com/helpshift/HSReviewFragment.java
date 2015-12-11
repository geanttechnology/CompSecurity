// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.f;
import android.text.TextUtils;
import com.helpshift.i.e;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            i, o, l, s, 
//            x, HSConversation

public final class HSReviewFragment extends DialogFragment
    implements TraceFieldInterface
{

    private static i d;
    private final String a = "HelpShiftDebug";
    private l b;
    private s c;
    private boolean e;
    private String f;

    public HSReviewFragment()
    {
        e = true;
        f = "";
    }

    private Dialog a(f f1)
    {
        Object obj = new android.app.AlertDialog.Builder(f1);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(b.g.m);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).setTitle(b.g.n);
        ((AlertDialog) (obj)).setIcon(f1.getApplicationInfo().icon);
        ((AlertDialog) (obj)).setCanceledOnTouchOutside(false);
        ((AlertDialog) (obj)).setButton(-1, getResources().getString(b.g.o), new android.content.DialogInterface.OnClickListener() {

            final HSReviewFragment a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                try
                {
                    if (TextUtils.isEmpty(HSReviewFragment.a(a)))
                    {
                        HSReviewFragment.a(a, HSReviewFragment.b(a).q().optString("rurl", ""));
                    }
                    HSReviewFragment.a(a, HSReviewFragment.a(a).trim());
                    if (!TextUtils.isEmpty(HSReviewFragment.a(a)))
                    {
                        HSReviewFragment.b(a, HSReviewFragment.a(a));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    x.a("HelpShiftDebug", dialoginterface.getMessage());
                }
                o.b("reviewed");
                HSReviewFragment.a(a, t.b.a);
            }

            
            {
                a = HSReviewFragment.this;
                super();
            }
        });
        ((AlertDialog) (obj)).setButton(-3, getResources().getString(b.g.p), new android.content.DialogInterface.OnClickListener() {

            final HSReviewFragment a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                o.b("feedback");
                HSReviewFragment.a(a, t.b.b);
                if (!HSReviewFragment.b(a).J().booleanValue())
                {
                    dialoginterface = new Intent(a.getActivity(), com/helpshift/HSConversation);
                    dialoginterface.putExtra("decomp", true);
                    dialoginterface.putExtra("showInFullScreen", com.helpshift.i.e.a(a.getActivity()));
                    dialoginterface.putExtra("chatLaunchSource", "support");
                    dialoginterface.putExtra("isRoot", true);
                    a.getActivity().startActivity(dialoginterface);
                }
            }

            
            {
                a = HSReviewFragment.this;
                super();
            }
        });
        ((AlertDialog) (obj)).setButton(-2, getResources().getString(b.g.q), new android.content.DialogInterface.OnClickListener() {

            final HSReviewFragment a;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                o.b("later");
                HSReviewFragment.a(a, t.b.c);
            }

            
            {
                a = HSReviewFragment.this;
                super();
            }
        });
        return ((Dialog) (obj));
    }

    static String a(HSReviewFragment hsreviewfragment)
    {
        return hsreviewfragment.f;
    }

    static String a(HSReviewFragment hsreviewfragment, String s)
    {
        hsreviewfragment.f = s;
        return s;
    }

    static void a(HSReviewFragment hsreviewfragment, t.b b1)
    {
        hsreviewfragment.a(b1);
    }

    private void a(t.b b1)
    {
        if (d != null)
        {
            d.a(b1);
        }
        d = null;
    }

    private void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s.trim()));
            if (intent.resolveActivity(getActivity().getPackageManager()) != null)
            {
                getActivity().startActivity(intent);
            }
        }
    }

    static s b(HSReviewFragment hsreviewfragment)
    {
        return hsreviewfragment.c;
    }

    static void b(HSReviewFragment hsreviewfragment, String s)
    {
        hsreviewfragment.a(s);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        o.b("later");
        a(t.b.c);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        Bundle bundle1 = bundle.getIntent().getExtras();
        if (bundle1 != null)
        {
            e = bundle1.getBoolean("disableReview", true);
            f = bundle1.getString("rurl");
        }
        b = new l(bundle);
        c = b.a;
        return a(bundle);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (e)
        {
            b.k();
        }
        getActivity().finish();
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
