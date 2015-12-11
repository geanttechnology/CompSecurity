// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.service.PendingAction;
import co.vine.android.util.Util;
import co.vine.android.util.image.UrlImage;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ReshareFragment, CaptchaRequestHelper

class  extends AppSessionListener
{

    final ReshareFragment this$0;

    public void onCaptchaRequired(String s, String s1, PendingAction pendingaction)
    {
        ReshareFragment.access$500(ReshareFragment.this).onCaptchaRequired(getActivity(), s, pendingaction.actionCode, pendingaction.bundle, s1);
    }

    public void onConnectFacebookComplete(String s, int i, String s1)
    {
        if (ReshareFragment.access$200(ReshareFragment.this) != null)
        {
            ReshareFragment.access$200(ReshareFragment.this).dismiss();
        }
        if (i != 200)
        {
            Util.showCenteredToast(getActivity(), 0x7f0e00ca);
            getActivity().finish();
        }
    }

    public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
    {
        if (ReshareFragment.access$200(ReshareFragment.this) != null)
        {
            ReshareFragment.access$200(ReshareFragment.this).dismiss();
        }
        if (i == 200)
        {
            if (l > 0L && !TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
            {
                VineAccountHelper.saveTwitterInfo(getActivity(), mAppController.getActiveSession().getLoginEmail(), s2, s3, s4, l);
                s = Util.getDefaultSharedPrefs(getActivity()).edit();
                s.ean("settings_twitter_connected", true);
                s.ean();
            }
            return;
        } else
        {
            Util.showCenteredToast(getActivity(), s1);
            getActivity().finish();
            return;
        }
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        hashmap = (UrlImage)hashmap.get(ReshareFragment.access$300(ReshareFragment.this));
        if (hashmap != null && hashmap.isValid())
        {
            ReshareFragment.access$400(ReshareFragment.this, ((UrlImage) (hashmap)).bitmap);
        }
    }

    public void onSharePostComplete(String s, int i, String s1)
    {
        if (ReshareFragment.access$000(ReshareFragment.this) != null)
        {
            ReshareFragment.access$000(ReshareFragment.this).dismiss();
        }
        if (i != 200)
        {
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(getActivity(), getString(0x7f0e00cc, new Object[] {
                    s1
                }));
            }
            return;
        }
        if (!"facebook".equals(ReshareFragment.access$100(ReshareFragment.this))) goto _L2; else goto _L1
_L1:
        Util.showCenteredToast(getActivity(), 0x7f0e0205);
_L4:
        getActivity().finish();
        return;
_L2:
        if ("twitter".equals(ReshareFragment.access$100(ReshareFragment.this)))
        {
            Util.showCenteredToast(getActivity(), 0x7f0e0213);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = ReshareFragment.this;
        super();
    }
}
