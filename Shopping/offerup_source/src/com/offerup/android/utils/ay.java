// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.app.t;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.widget.ShareDialog;
import com.offerup.android.c.a;
import com.offerup.android.g.ae;

// Referenced classes of package com.offerup.android.utils:
//            as

public final class ay
{

    private t a;

    public ay(t t1)
    {
        a = t1;
    }

    private void e()
    {
        if (a.useNewAppInvites)
        {
            ae ae1 = new ae();
            a.getSupportFragmentManager().a().a(null).a(ae1, "app_invite_fragment").b();
            return;
        } else
        {
            a(a.getString(0x7f0901e8), a.getString(0x7f0901ea), a.getString(0x7f0901e9));
            return;
        }
    }

    public final void a()
    {
        com.offerup.android.tracker.a.b("ou_navdrawer_invitefriend_click");
        e();
    }

    public final void a(Uri uri)
    {
        uri = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentUrl(uri)).build();
        ShareDialog.show(a, uri);
    }

    public final void a(String s)
    {
        if (a.useItemShareSheet)
        {
            ae ae1 = new ae();
            Bundle bundle = new Bundle();
            bundle.putParcelable("uri", Uri.parse(s));
            ae1.setArguments(bundle);
            a.getSupportFragmentManager().a().a(null).a(ae1, "share_sheet_fragment").b();
            return;
        } else
        {
            a(a.getString(0x7f090137), a.getString(0x7f090138), s);
            return;
        }
    }

    public final void a(String s, String s1)
    {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", s1);
        a.startActivity(intent);
    }

    public final void a(String s, String s1, String s2)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", s1);
        s1 = new android.support.v4.g.a();
        s1.put("utm_campaign", "si");
        s1.put("utm_medium", "id");
        s1.put("utm_source", "ad");
        intent.putExtra("android.intent.extra.TEXT", com.offerup.android.utils.as.a(s2, s1).toString());
        a.startActivity(Intent.createChooser(intent, s));
    }

    public final void b()
    {
        com.offerup.android.tracker.a.b("ou_actionbar_invitefriend_click");
        e();
    }

    public final void b(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            String s1 = android.provider.Telephony.Sms.getDefaultSmsPackage(a);
            Intent intent1 = new Intent("android.intent.action.SEND");
            intent1.setType("text/plain");
            intent1.putExtra("android.intent.extra.TEXT", s);
            if (s1 != null)
            {
                intent1.setPackage(s1);
            }
            a.startActivity(intent1);
            return;
        } else
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setType("vnd.android-dir/mms-sms");
            intent.putExtra("sms_body", s);
            a.startActivity(intent);
            return;
        }
    }

    public final void c()
    {
        com.offerup.android.tracker.a.b("ou_account_appshare_click");
        e();
    }

    public final void d()
    {
        if (AppInviteDialog.canShow())
        {
            com.facebook.share.model.AppInviteContent appinvitecontent = (new com.facebook.share.model.AppInviteContent.Builder()).setApplinkUrl(a.getString(0x7f09010d)).setPreviewImageUrl(a.getString(0x7f090111)).build();
            AppInviteDialog.show(a, appinvitecontent);
        }
    }
}
