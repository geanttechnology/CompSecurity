// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.q;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.util.h.b;
import com.shazam.android.util.h.e;
import com.shazam.android.util.s;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.i.b.a.a;
import com.shazam.i.b.au.d;
import com.shazam.model.Factory;
import com.shazam.model.account.Account;
import java.util.List;

public class CheckEmailActivity extends AutoToolbarBaseAppCompatActivity
{
    private final class a
        implements com.shazam.g.b
    {

        final CheckEmailActivity a;

        private void a(int i, BeaconErrorCode beaconerrorcode)
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a).logEvent(com.shazam.android.activities.account.CheckEmailActivity.d(a), AccountLoginEventFactory.error(com.shazam.android.analytics.event.factory.AccountLoginEventFactory.AccountLoginProviderName.EMAIL, beaconerrorcode, "checkemail"));
            beaconerrorcode = CheckEmailActivity.g(a);
            com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
            a1.a = i;
            a1.h = 0x7f0300b6;
            beaconerrorcode.a(a1.a());
        }

        public final void onDataFailedToLoad()
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a, false);
            a(0x7f090071, BeaconErrorCode.FAILED);
        }

        public final void onDataFetched(Object obj)
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a, false);
            CheckEmailActivity.f(a);
        }

        public final void onUnauthorized()
        {
            a(0x7f09008a, BeaconErrorCode.UNAUTHORIZED);
            com.shazam.android.activities.b.b.b(a);
            a.finish();
        }

        private a()
        {
            a = CheckEmailActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b
        implements android.view.View.OnClickListener
    {

        final CheckEmailActivity a;
        private final Intent b;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a).logEvent(view, AccountLoginEventFactory.checkEmail());
            a.startActivity(b);
        }

        public b(Intent intent)
        {
            a = CheckEmailActivity.this;
            super();
            b = intent;
        }
    }

    private final class c
        implements android.content.DialogInterface.OnClickListener
    {

        final CheckEmailActivity a;
        private final List b;

        public final void onClick(DialogInterface dialoginterface, int i)
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a).logEvent(com.shazam.android.activities.account.CheckEmailActivity.d(a), AccountLoginEventFactory.checkEmail());
            dialoginterface = ((ResolveInfo)b.get(i)).activityInfo.packageName;
            a.startActivity(com.shazam.android.activities.account.CheckEmailActivity.e(a).getLaunchIntentForPackage(dialoginterface));
        }

        private c(List list)
        {
            a = CheckEmailActivity.this;
            super();
            b = list;
        }

        c(List list, byte byte0)
        {
            this(list);
        }
    }

    private final class d
        implements android.view.View.OnClickListener
    {

        final CheckEmailActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a).logEvent(view, AccountLoginEventFactory.sendAgain("checkemail"));
            view = CheckEmailActivity.c(a).a().email;
            view = (com.shazam.g.a)com.shazam.i.b.v.b.a(a.getSupportLoaderManager(), a).create(view);
            view.a(a. new a((byte)0));
            view.a();
            com.shazam.android.activities.account.CheckEmailActivity.a(a, true);
        }

        private d()
        {
            a = CheckEmailActivity.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }

    private final class e
        implements android.view.View.OnClickListener
    {

        final CheckEmailActivity a;

        public final void onClick(View view)
        {
            com.shazam.android.activities.account.CheckEmailActivity.a(a).logEvent(view, AccountLoginEventFactory.eventWithAction("ecdone"));
            a.startActivity(com.shazam.android.activities.account.CheckEmailActivity.b(a));
        }

        private e()
        {
            a = CheckEmailActivity.this;
            super();
        }

        e(byte byte0)
        {
            this();
        }
    }


    private final com.shazam.k.a a = com.shazam.i.b.a.a.a();
    private final s b = com.shazam.i.b.au.d.c();
    private final EventAnalyticsFromView c = com.shazam.i.b.g.b.a.b();
    private final EventAnalytics d = com.shazam.i.b.g.b.a.a();
    private PackageManager e;
    private ImageView f;

    public CheckEmailActivity()
    {
    }

    static EventAnalyticsFromView a(CheckEmailActivity checkemailactivity)
    {
        return checkemailactivity.c;
    }

    private void a()
    {
        View view = findViewById(0x7f1100b6);
        Object obj = findViewById(0x7f1100b7);
        View view1 = findViewById(0x7f1100b8);
        view.setAlpha(0.0F);
        ((View) (obj)).setTranslationY(com.shazam.android.util.h.b.a(20F));
        view1.setAlpha(0.0F);
        f.setAlpha(0.0F);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.setDuration(600L);
        animatorset.setStartDelay(100L);
        obj = ObjectAnimator.ofFloat(obj, "translationY", new float[] {
            0.0F
        });
        ((ObjectAnimator) (obj)).setInterpolator(new android.support.v4.view.b.b());
        animatorset.playSequentially(new Animator[] {
            ObjectAnimator.ofFloat(view, "alpha", new float[] {
                0.0F, 1.0F
            }), obj, ObjectAnimator.ofFloat(view, "alpha", new float[] {
                0.0F
            }), ObjectAnimator.ofFloat(view1, "alpha", new float[] {
                1.0F
            }), ObjectAnimator.ofFloat(f, "alpha", new float[] {
                1.0F
            })
        });
        animatorset.start();
    }

    private void a(Intent intent)
    {
        if (com.shazam.android.util.f.a.b(intent))
        {
            EventAnalytics eventanalytics = d;
            Object obj;
            if (getString(0x7f0901a7).equals(intent.getData().getScheme()))
            {
                obj = "web";
            } else
            {
                obj = "email";
            }
            eventanalytics.logEvent(AccountLoginEventFactory.confirm(((String) (obj))));
            obj = c();
            ((Intent) (obj)).setData(intent.getData());
            startActivity(((Intent) (obj)));
            finish();
            overridePendingTransition(0, 0);
        }
    }

    static void a(CheckEmailActivity checkemailactivity, List list)
    {
        (new android.app.AlertDialog.Builder(checkemailactivity)).setAdapter(new com.shazam.android.a.h.a(list, checkemailactivity.e), checkemailactivity. new c(list, (byte)0)).show();
    }

    static void a(CheckEmailActivity checkemailactivity, boolean flag)
    {
        checkemailactivity = (AnimatorViewFlipper)checkemailactivity.findViewById(0x7f1100b4);
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        checkemailactivity.setDisplayedChild(i);
    }

    private static Intent b()
    {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        return intent;
    }

    static Intent b(CheckEmailActivity checkemailactivity)
    {
        return checkemailactivity.c();
    }

    private Intent c()
    {
        Intent intent = com.shazam.android.activities.b.a.b(this, false);
        intent.addFlags(32768);
        return intent;
    }

    static com.shazam.k.a c(CheckEmailActivity checkemailactivity)
    {
        return checkemailactivity.a;
    }

    static ImageView d(CheckEmailActivity checkemailactivity)
    {
        return checkemailactivity.f;
    }

    static PackageManager e(CheckEmailActivity checkemailactivity)
    {
        return checkemailactivity.e;
    }

    static void f(CheckEmailActivity checkemailactivity)
    {
        checkemailactivity.a();
    }

    static s g(CheckEmailActivity checkemailactivity)
    {
        return checkemailactivity.b;
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        boolean flag1;
        flag1 = true;
        super.onCreate(bundle);
        setContentView(0x7f03001a);
        f = (ImageView)findViewById(0x7f1100b9);
        obj = (TextView)findViewById(0x7f1100b5);
        View view = findViewById(0x7f1100bc);
        View view1 = findViewById(0x7f1100bb);
        ((TextView) (obj)).setText(a.a().email);
        view.setOnClickListener(new d((byte)0));
        view1.setOnClickListener(new e((byte)0));
        e = getPackageManager();
        obj = b();
        obj = e.resolveActivity(((Intent) (obj)), 0x10000);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Intent intent;
        boolean flag;
        if ("android".equals(((ResolveInfo) (obj)).activityInfo.packageName) && ("com.android.internal.app.ResolverActivity".equals(((ResolveInfo) (obj)).activityInfo.name) || "com.android.internal.app.ResolverActivityEx".equals(((ResolveInfo) (obj)).activityInfo.name)) || ((ResolveInfo) (obj)).activityInfo.name.contains("com.android.internal."))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        if (obj == null) goto _L5; else goto _L4
_L4:
        intent = e.getLaunchIntentForPackage(((ResolveInfo) (obj)).activityInfo.packageName);
        f.setImageDrawable(com.shazam.android.util.h.e.a(e, ((ResolveInfo) (obj)).activityInfo));
        f.setOnClickListener(new b(intent));
_L6:
        a();
        if (bundle == null)
        {
            a(getIntent());
        }
        return;
_L5:
        obj = e.queryIntentActivities(b(), 0x10000);
        f.setImageResource(0x7f020137);
        if (com.shazam.o.b.b(((java.util.Collection) (obj))))
        {
            f.setOnClickListener(new android.view.View.OnClickListener(((List) (obj))) {

                final List a;
                final CheckEmailActivity b;

                public final void onClick(View view2)
                {
                    com.shazam.android.activities.account.CheckEmailActivity.a(b, a);
                }

            
            {
                b = CheckEmailActivity.this;
                a = list;
                super();
            }
            });
        }
        if (true) goto _L6; else goto _L2
_L2:
        obj = null;
        if (true) goto _L3; else goto _L7
_L7:
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        a(intent);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            q.a(this);
            break;
        }
        return true;
    }
}
