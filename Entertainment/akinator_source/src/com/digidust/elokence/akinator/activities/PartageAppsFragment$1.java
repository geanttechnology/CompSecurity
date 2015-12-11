// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PartageAppsFragment, AkActivity

class this._cls0
    implements android.widget.kListener
{

    final PartageAppsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        PartageAppsFragment.access$000(PartageAppsFragment.this).disableAdOneTime();
        adapterview = (ResolveInfo)PartageAppsFragment.access$100(PartageAppsFragment.this).get(i);
        PartageAppsFragment.access$202(PartageAppsFragment.this, true);
        AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
        adapterview = ((ResolveInfo) (adapterview)).activityInfo;
        adapterview = new ComponentName(((ActivityInfo) (adapterview)).applicationInfo.packageName, ((ActivityInfo) (adapterview)).name);
        PartageAppsFragment.access$300(PartageAppsFragment.this).setComponent(adapterview);
        if (adapterview.getPackageName().contains("facebook") && PartageAppsFragment.access$400(PartageAppsFragment.this) != null)
        {
            view = new ShareDialog(PartageAppsFragment.access$000(PartageAppsFragment.this));
            if (ShareDialog.canShow(com/facebook/share/model/ShareLinkContent))
            {
                view.show(((com.facebook.share.model.er)(new com.facebook.share.model.er()).setContentTitle(PartageAppsFragment.access$400(PartageAppsFragment.this)).setContentDescription(TraductionFactory.sharedInstance().getTraductionFromToken("AKINATOR_LE_GENIE_DU_WEB_QUI_LIT_DANS_VOS_PENSEES")).setContentUrl(Uri.parse(getResources().getString(0x7f07005f)))).setImageUrl(Uri.parse("http://www.akinator.com/icone-mobile.png")).build());
            }
        } else
        {
            PartageAppsFragment.access$000(PartageAppsFragment.this).startActivity(PartageAppsFragment.access$300(PartageAppsFragment.this));
        }
        if (adapterview.getPackageName().contains("facebook"))
        {
            MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_fb");
        } else
        if (adapterview.getPackageName().contains("twitter"))
        {
            MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_twitter");
        }
        if (PartageAppsFragment.access$500(PartageAppsFragment.this) != -1)
        {
            if (PartageAppsFragment.access$500(PartageAppsFragment.this) == 0)
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_bd");
            } else
            if (PartageAppsFragment.access$500(PartageAppsFragment.this) == 1)
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_character");
            } else
            if (PartageAppsFragment.access$500(PartageAppsFragment.this) == 2)
            {
                MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_badge");
            }
        }
        if (PartageAppsFragment.access$600(PartageAppsFragment.this))
        {
            MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_unguessed");
        }
        hide();
    }

    Binder()
    {
        this$0 = PartageAppsFragment.this;
        super();
    }
}
