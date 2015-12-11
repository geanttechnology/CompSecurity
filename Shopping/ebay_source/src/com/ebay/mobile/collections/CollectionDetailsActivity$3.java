// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.kernel.util.NumberUtil;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDetailsActivity, CollectionDetailsPageHeaderViewModel

class this._cls0
    implements com.ebay.mobile.common.view.this._cls0
{

    final CollectionDetailsActivity this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        String s;
        Authentication authentication;
        String s2;
        authentication = CollectionDetailsActivity.access$1100(CollectionDetailsActivity.this).getCurrentUser();
        long l;
        if (authentication != null)
        {
            s = authentication.iafToken;
        } else
        {
            s = null;
        }
        s2 = CollectionDetailsActivity.access$1100(CollectionDetailsActivity.this).getCurrentCountry().getSiteGlobalId();
        getResources().getString(0x7f070127);
        view.getId();
        JVM INSTR tableswitch 2131755309 2131755311: default 80
    //                   2131755309 113
    //                   2131755310 250
    //                   2131755311 434;
           goto _L1 _L2 _L3 _L4
_L1:
        l = NumberUtil.safeParseLong((String)view.getTag()).longValue();
        ItemViewActivity.StartActivity(CollectionDetailsActivity.this, l, com.ebay.common.nown);
_L6:
        return;
_L2:
        CollectionDetailsActivity.access$1402(CollectionDetailsActivity.this, (TextView)view);
        if (CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this) != null)
        {
            if (authentication == null)
            {
                view = SignInModalActivity.getIntentForSignIn(getTrackingEventName(), CollectionDetailsActivity.this);
                startActivityForResult(view, 65);
                return;
            }
            if (getResources().getString(0x7f070127).equals(CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this).getText()))
            {
                CollectionDetailsActivity.access$1300(CollectionDetailsActivity.this).followCollection(CollectionDetailsActivity.access$1000(), s2);
                CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this).setEnabled(false);
                return;
            } else
            {
                CollectionDetailsActivity.access$1300(CollectionDetailsActivity.this).deleteFollow(FollowType.COLLECTION, CollectionDetailsActivity.access$1000(), s);
                CollectionDetailsActivity.access$1400(CollectionDetailsActivity.this).setEnabled(false);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        view = new Intent("android.intent.action.SEND");
        view.setType("text/plain");
        if (CollectionDetailsActivity.access$1500(CollectionDetailsActivity.this) != null && CollectionDetailsActivity.access$1600(CollectionDetailsActivity.this) != null)
        {
            viewmodel = CollectionDetailsActivity.access$1500(CollectionDetailsActivity.this).replace("  ", " ").replace(" ", "-").toLowerCase(Locale.getDefault());
            viewmodel = String.format("http://www.%s/cln/%s/%s/%s", new Object[] {
                MyApp.getPrefs().getCurrentSite().getDomain(), CollectionDetailsActivity.access$1600(CollectionDetailsActivity.this), Uri.encode(viewmodel), CollectionDetailsActivity.access$1000()
            });
            Resources resources = getResources();
            String s1 = resources.getString(0x7f070282);
            view.putExtra("android.intent.extra.SUBJECT", s1);
            view.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(s1).append(" ").append(viewmodel).toString());
            startActivity(Intent.createChooser(view, resources.getString(0x7f0704ef)));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        view = (CollectionDetailsPageHeaderViewModel)viewmodel;
        if (view != null && ((CollectionDetailsPageHeaderViewModel) (view)).collection != null && ((CollectionDetailsPageHeaderViewModel) (view)).collection.creator != null && ((CollectionDetailsPageHeaderViewModel) (view)).collection.creator.rIdentifier != null)
        {
            view = ((CollectionDetailsPageHeaderViewModel) (view)).collection.creator.rIdentifier.username;
            if (view != null)
            {
                UserDetailActivity.StartActivity(CollectionDetailsActivity.this, null, view, null, null, false, true, false, false, null, false, null);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ifier()
    {
        this$0 = CollectionDetailsActivity.this;
        super();
    }
}
