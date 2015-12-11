// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.client.Session;
import co.vine.android.client.VineAccountHelper;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widgets.PromptDialogSupportFragment;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            SettingsFragment, VineLoggingException, StartActivity, Settings

class this._cls0 extends AppSessionListener
{

    final SettingsFragment this$0;

    public void onClearCacheComplete(String s, int i, String s1)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        try
        {
            SettingsFragment.access$000(SettingsFragment.this).setText(Util.formatFileSize(getResources(), Util.getCacheSize(getActivity())));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            CrashUtil.logException(s);
        }
        getActivity().setResult(1);
    }

    public void onConnectFacebookComplete(String s, int i, String s1)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        if (i != 200)
        {
            Util.showCenteredToast(getActivity(), 0x7f0e00ca);
            SettingsFragment.access$1700(SettingsFragment.this).setText(0x7f0e01f1);
            return;
        } else
        {
            SettingsFragment.access$1800(SettingsFragment.this);
            return;
        }
    }

    public void onConnectTwitterComplete(String s, int i, String s1, String s2, String s3, String s4, long l)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        s = (TextView)getView().findViewById(0x7f0a0204);
        TextView textview = (TextView)getView().findViewById(0x7f0a0203);
        if (i == 200 && l > 0L && !TextUtils.isEmpty(s3) && !TextUtils.isEmpty(s4))
        {
            textview.setText(0x7f0e01db);
            s.setText((new StringBuilder()).append('@').append(s2).toString());
            VineAccountHelper.saveTwitterInfo(getActivity(), SettingsFragment.access$2200(SettingsFragment.this).getActiveSession().getLoginEmail(), s2, s3, s4, l);
            SettingsFragment.access$2302(SettingsFragment.this, true);
            s = SettingsFragment.access$2400(SettingsFragment.this).edit();
            s.n("settings_twitter_connected", true);
            s.n();
            return;
        }
        textview.setText(0x7f0e01d8);
        s.setText(0x7f0e01d9);
        SettingsFragment.access$2302(SettingsFragment.this, false);
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = getResources().getString(0x7f0e01e9);
        }
        Util.showCenteredToast(getActivity(), s);
    }

    public void onDeactivateAccountComplete(String s, int i, String s1, boolean flag)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        if (flag)
        {
            SettingsFragment.access$2200(SettingsFragment.this).logout(SettingsFragment.access$2200(SettingsFragment.this).getActiveSession());
            i = 0x7f0e01cc;
            SLog.d("User account successfully deactivated");
        } else
        {
            i = 0x7f0e01cb;
            SLog.d("User account deactivation failed");
        }
        Util.showCenteredToast(getActivity(), i);
    }

    public void onDisconnectTwitterComplete(String s, int i, String s1)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        s = (TextView)getView().findViewById(0x7f0a0204);
        TextView textview = (TextView)getView().findViewById(0x7f0a0203);
        if (i == 200)
        {
            textview.setText(0x7f0e01d8);
            s.setText(0x7f0e01d9);
            VineAccountHelper.removeTwitterInfo(getActivity(), SettingsFragment.access$2200(SettingsFragment.this).getActiveSession().getLoginEmail());
            SettingsFragment.access$2302(SettingsFragment.this, false);
            SettingsFragment.access$1900(SettingsFragment.this).n("settings_twitter_connected", false);
            SettingsFragment.access$1900(SettingsFragment.this)._mth0();
            return;
        }
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = getResources().getString(0x7f0e01ea);
        }
        Util.showCenteredToast(getActivity(), s);
    }

    public void onGetEditionsComplete(int i, ArrayList arraylist)
    {
        if (i == 200)
        {
            SettingsFragment.access$2602(SettingsFragment.this, true);
        }
    }

    public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
    {
        if (vineuser != null)
        {
            SettingsFragment.access$702(SettingsFragment.this, vineuser.isEmailVerified());
            SettingsFragment.access$1002(SettingsFragment.this, vineuser.isPhoneVerified());
            SettingsFragment.access$2500(SettingsFragment.this);
        }
    }

    public void onLogoutComplete(String s)
    {
        if (getActivity() == null || getActivity().isFinishing())
        {
            return;
        }
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        StartActivity.toStart(getActivity());
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        hashmap = (UrlImage)hashmap.get(SettingsFragment.access$1400(SettingsFragment.this));
        if (hashmap != null && hashmap.isValid())
        {
            SettingsFragment.access$1500(SettingsFragment.this).setImageDrawable(new RecyclableBitmapDrawable(SettingsFragment.access$1500(SettingsFragment.this).getResources(), ((UrlImage) (hashmap)).bitmap));
        }
    }

    public void onRequestEmailVerificationComplete(String s, int i, String s1, String s2)
    {
        if (i == 200)
        {
            s = PromptDialogSupportFragment.newInstance(10);
            s.setTargetFragment(SettingsFragment.this, 0);
            s.setNeutralButton(0x104000a).setMessage(0x7f0e0082).show(getActivity().getSupportFragmentManager());
            return;
        }
        if (s1 == null)
        {
            s1 = getString(0x7f0e0105);
        }
        Util.showCenteredToast(getActivity(), s1);
    }

    public void onUpdateEditionComplete(String s, int i, String s1, String s2)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        if (i == 200)
        {
            SettingsFragment.access$1202(SettingsFragment.this, s2);
            SettingsFragment.access$2102(SettingsFragment.this, s2);
        }
    }

    public void onUpdateProfileComplete(String s, int i, String s1, String s2)
    {
        if (SettingsFragment.access$1600(SettingsFragment.this) != null)
        {
            SettingsFragment.access$1600(SettingsFragment.this).dismiss();
        }
        s = getActivity();
        if (i == 200)
        {
            s1 = SettingsFragment.access$1900(SettingsFragment.this);
            if (!TextUtils.isEmpty(s2))
            {
                SettingsFragment.access$1900(SettingsFragment.this).("settings_profile_avatar_url", s2);
            }
            s1.("settings_profile_name", SettingsFragment.access$100(SettingsFragment.this));
            s1.("settings_profile_description", SettingsFragment.access$200(SettingsFragment.this));
            s1.("settings_profile_location", SettingsFragment.access$300(SettingsFragment.this));
            s1.("settings_profile_email", SettingsFragment.access$400(SettingsFragment.this));
            s1.("settings_profile_phone", SettingsFragment.access$900(SettingsFragment.this));
            if (SettingsFragment.access$2000(SettingsFragment.this) < 0 || SettingsFragment.access$2000(SettingsFragment.this) >= Settings.PROFILE_BACKGROUND_COLORS.length)
            {
                SettingsFragment.access$2002(SettingsFragment.this, 0);
            }
            s1._mth0("profile_background", Settings.PROFILE_BACKGROUND_COLORS[SettingsFragment.access$2000(SettingsFragment.this)]);
            s1._mth0("color_index", SettingsFragment.access$2000(SettingsFragment.this));
            s1._mth0();
            if (s != null)
            {
                s.finish();
            }
            Util.changeProfileColor(s);
            return;
        }
        if (TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, 0x7f0e0258);
            return;
        } else
        {
            Util.showCenteredToast(s, s1);
            return;
        }
    }

    t()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
