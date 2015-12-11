// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.services.PackageService;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.outfitbuilder.OBCatalogActivity;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity, OnboardingActivity, BitshopActivity, B4MBitmojiBrowserActivity, 
//            ImojiBrowserActivity, InviteActivity, LoginActivity, RetrieveAvatarActivity, 
//            SettingsActivity, ImojiWebViewActivity, SignUpActivity

public class IntentCreatorService
{

    private static final String FACEBOOK_MESSENGER_PACKAGE_NAME = "com.facebook.orca";
    public static final String IMOJI_PACKAGE_NAME = "com.bitstrips.imoji";
    private static final String TAG = "IntentCreatorService";
    AnalyticsService analyticsService;
    B4MService b4MService;
    Context context;
    FacebookService facebookService;
    PackageService packageService;
    PreferenceUtils preferenceUtils;
    TemplatesManager templatesManager;

    public IntentCreatorService(Context context1)
    {
        ((InjectorApplication)context1).inject(this);
    }

    private void goToAvatarBuilder(Activity activity, boolean flag)
    {
        Intent intent = new Intent(activity, com/bitstrips/imoji/ui/AvatarBuilderActivity);
        String s = preferenceUtils.getString(0x7f06003a, "");
        intent.setData(Uri.parse((new StringBuilder()).append("file:///android_asset/imoji-web/").append(activity.getString(0x7f060025)).toString()));
        intent.putExtra("bsauthToken", s);
        intent.putExtra("fbToken", facebookService.getToken());
        intent.putExtra("newUser", flag);
        activity.startActivity(intent);
    }

    private void setExtras(Intent intent, Activity activity)
    {
        activity = activity.getIntent().getExtras();
        if (activity == null)
        {
            activity = new Bundle();
        }
        intent.putExtras(activity);
    }

    public void backToMessengerIntent(Activity activity)
    {
        activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage("com.facebook.orca"));
        activity.finish();
    }

    public boolean createFacebookMessengerIntent(Activity activity, Uri uri, String s)
    {
        if (packageService.isAppInstalled("com.facebook.orca"))
        {
            b4MService.shareToFacebookMessenger(activity, uri, s);
            return true;
        } else
        {
            return false;
        }
    }

    public void displayUpgradeDialog(final Activity activity)
    {
        String s = activity.getString(0x7f0600ee);
        (new android.app.AlertDialog.Builder(activity)).setTitle(0x7f060019).setMessage(s).setPositiveButton(0x7f0600ed, new android.content.DialogInterface.OnClickListener() {

            final IntentCreatorService this$0;
            final Activity val$activity;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (packageService.isAppInstalled("com.bitstrips.imoji"))
                {
                    packageService.launchApp("com.bitstrips.imoji");
                    return;
                } else
                {
                    goToGooglePlayStore("com.bitstrips.imoji", activity);
                    return;
                }
            }

            
            {
                this$0 = IntentCreatorService.this;
                activity = activity1;
                super();
            }
        }).setNegativeButton(0x7f06003d, new android.content.DialogInterface.OnClickListener() {

            final IntentCreatorService this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = IntentCreatorService.this;
                super();
            }
        }).show();
    }

    public void goToAvatarBuilderDesign(Activity activity)
    {
        goToAvatarBuilder(activity, true);
    }

    public void goToAvatarBuilderEdit(Activity activity)
    {
        goToAvatarBuilder(activity, false);
    }

    public void goToBitmojiForMessengerOnboarding(Activity activity)
    {
        activity.startActivity(new Intent(activity, com/bitstrips/imoji/ui/OnboardingActivity));
    }

    public void goToBitshop(Activity activity)
    {
        activity.startActivity(new Intent(activity, com/bitstrips/imoji/ui/BitshopActivity));
    }

    public void goToBitshop(Activity activity, int i)
    {
        Intent intent = new Intent(activity, com/bitstrips/imoji/ui/BitshopActivity);
        intent.putExtra("universal_pack_id", i);
        activity.startActivity(intent);
    }

    public void goToGooglePlayStore(String s, Activity activity)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString()));
        intent.addFlags(0x10000000);
        if (context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0)
        {
            try
            {
                activity.startActivity(intent);
                return;
            }
            catch (ActivityNotFoundException activitynotfoundexception) { }
        }
        intent.setData(Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(s).toString()));
        activity.startActivity(intent);
    }

    public void goToImojiBrowser(Activity activity)
    {
        Intent intent;
        Object obj;
        if ("b4m".equals("production"))
        {
            intent = new Intent(activity, com/bitstrips/imoji/ui/B4MBitmojiBrowserActivity);
        } else
        {
            intent = new Intent(activity, com/bitstrips/imoji/ui/ImojiBrowserActivity);
        }
        obj = activity.getIntent();
        intent.setAction(((Intent) (obj)).getAction());
        intent.setFlags(0x2000000);
        setExtras(intent, activity);
        obj = ((Intent) (obj)).getData();
        if (obj != null)
        {
            intent.putExtra("schemeHost", ((Uri) (obj)).getHost());
        }
        activity.startActivity(intent);
        activity.finish();
    }

    public void goToInviteActivity(Activity activity, boolean flag)
    {
        Intent intent = new Intent(activity, com/bitstrips/imoji/ui/InviteActivity);
        String s = preferenceUtils.getString(0x7f06002a, null);
        String s1 = preferenceUtils.getString(0x7f06003a, null);
        intent.putExtra("avatarId", s);
        intent.putExtra("bsauthToken", s1);
        intent.putExtra("isFirstShare", flag);
        activity.startActivity(intent);
    }

    public void goToLoginActivity(Activity activity)
    {
        activity.startActivity(new Intent(activity, com/bitstrips/imoji/ui/LoginActivity));
    }

    public void goToOutfitBuilder(Activity activity, int i, boolean flag)
    {
        Intent intent = new Intent(activity, com/bitstrips/outfitbuilder/OBCatalogActivity);
        com.bitstrips.outfitbuilder.models.OBAvatarData obavatardata = AvatarInfo.getAvatarDataFromPreferences(preferenceUtils);
        if (obavatardata != null)
        {
            templatesManager.setAnnouncerSeen(templatesManager.getFashionAnnouncerData(), true);
            com.bitstrips.outfitbuilder.models.OBCatalog obcatalog = templatesManager.getCatalogForData(obavatardata);
            intent.putExtra("avatarDataExtra", obavatardata);
            intent.putExtra("outfitCatalog", obcatalog);
            intent.putExtra("disableBackCatalog", flag);
            activity.startActivityForResult(intent, i);
        }
    }

    public void goToRetrieveAvatar(Activity activity)
    {
        activity.startActivityForResult(new Intent(activity, com/bitstrips/imoji/ui/RetrieveAvatarActivity), 3);
    }

    public void goToSettings(Activity activity)
    {
        activity.startActivityForResult(new Intent(activity, com/bitstrips/imoji/ui/SettingsActivity), 1);
    }

    public void goToSupportPage(Activity activity)
    {
        Intent intent = new Intent(activity, com/bitstrips/imoji/ui/ImojiWebViewActivity);
        intent.setData(Uri.parse(activity.getString(0x7f0600e6)));
        intent.putExtra("android.intent.extra.TITLE", activity.getString(0x7f06008c));
        activity.startActivity(intent);
    }

    public void promptUserToDownloadFacebookMessenger(final Activity currentActivity)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(currentActivity);
        builder.setMessage(0x7f060089);
        builder.setPositiveButton(0x7f060066, new android.content.DialogInterface.OnClickListener() {

            final IntentCreatorService this$0;
            final Activity val$currentActivity;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                analyticsService.sendEvent(Category.DOWNLOAD_FACEBOOK_MESSENGER, Action.YES_MESSENGER, null);
                goToGooglePlayStore("com.facebook.orca", currentActivity);
            }

            
            {
                this$0 = IntentCreatorService.this;
                currentActivity = activity;
                super();
            }
        });
        builder.setNegativeButton(currentActivity.getString(0x1040000), new android.content.DialogInterface.OnClickListener() {

            final IntentCreatorService this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                analyticsService.sendEvent(Category.DOWNLOAD_FACEBOOK_MESSENGER, Action.NO_MESSENGER, null);
            }

            
            {
                this$0 = IntentCreatorService.this;
                super();
            }
        });
        builder.show();
    }

    public void sendFacebookUserToSignup(final Activity activity)
    {
        final Intent intent = new Intent(activity, com/bitstrips/imoji/ui/SignUpActivity);
        intent.putExtra(activity.getString(0x7f06009d), true);
        facebookService.getUser(new com.bitstrips.imoji.auth.FacebookService.UserCallback() {

            final IntentCreatorService this$0;
            final Activity val$activity;
            final Intent val$intent;

            public void error()
            {
                activity.startActivityForResult(intent, 1);
            }

            public void success(JSONObject jsonobject)
            {
                intent.putExtra(activity.getString(0x7f06007c), jsonobject.optString("first_name"));
                intent.putExtra(activity.getString(0x7f06007d), jsonobject.optString("last_name"));
                activity.startActivityForResult(intent, 1);
            }

            
            {
                this$0 = IntentCreatorService.this;
                intent = intent1;
                activity = activity1;
                super();
            }
        });
    }
}
