// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.analytics.Variable;
import com.bitstrips.imoji.api.BSAuthExchangeTokensResponse;
import com.bitstrips.imoji.api.BSAuthService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.AnnouncerData;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.services.CrashlyticsService;
import com.bitstrips.imoji.ui.adapters.ImojiPagerAdapter;
import com.bitstrips.imoji.ui.tasks.GetImojiImageTask;
import com.bitstrips.imoji.ui.views.FashionAnnouncerView;
import com.bitstrips.imoji.util.FileUtil;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.imoji.util.ToastUtils;
import com.bitstrips.outfitbuilder.services.OBAssetsPreloaderIntentService;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserTabLayout, IntentCreatorService, LoginActivity, ShareImageDialogFragment, 
//            WelcomeDialogFragment, ImageLoader, ImojisPreloader

public class ImojiBrowserActivity extends AppCompatActivity
    implements ImagesGridViewsWrapper.ImojiClickListener, WelcomeDialogFragment.DialogFragmentActivity, com.bitstrips.imoji.services.B4MService.ReplyFriendsListener, com.bitstrips.imoji.ui.views.FashionAnnouncerView.FashionAnnouncerViewListener, com.bitstrips.imoji.ui.adapters.FavouriteAdapter.FavouriteClickListener
{

    public static final int ADDITIONAL_SHARES_UNTIL_RATING_REPROMPT = 2;
    public static final int DAYS_TO_REMINDER = 2;
    private static final String DEEP_LINK_AVATAR_BUILDER = "avatar";
    private static final String DEEP_LINK_BITSHOP = "bitshop";
    private static final String DEEP_LINK_CATALOG = "catalog";
    private static final String DEEP_LINK_SETTINGS = "settings";
    private static final int DISABLED_MENU_ITEM_ALPHA = 128;
    private static final int ENABLED_MENU_ITEM_ALPHA = 255;
    public static final String EXTRA_IS_NEW_USER = "isNewUser";
    public static final String EXTRA_SCHEME_HOST = "schemeHost";
    public static final int INITIAL_SHARES_BEFORE_RATING = 3;
    public static final String INVITE_IMOJI_TEMPLATE_ID = "3822";
    protected static final int OUTFIT_BUILDER_REQUEST_CODE = 8;
    private static final String TAG = "ImojiBrowser";
    AnalyticsService analytics;
    B4MService b4mService;
    BitstripsService bitstripsService;
    BSAuthService bsAuthService;
    CrashlyticsService crashlyticsService;
    private boolean dataSetChangedWhilePaused;
    private AlertDialog errorDialog;
    FacebookService facebookService;
    private FashionAnnouncerView fashionAnnouncerView;
    FileUtil fileUtil;
    FloaterServiceManager floaterServiceManager;
    ImageLoader imageLoader;
    protected ImojiPagerAdapter imojiPagerAdapter;
    ImojisPreloader imojisPreloader;
    IntentCreatorService intentCreatorService;
    protected boolean isPaused;
    private GetImojiImageTask mImojiImageTask;
    private boolean newUserHasSeenInviteFlow;
    PreferenceUtils preferenceUtils;
    RecentImojiesManager recentImojiesManager;
    private boolean returnAsResult;
    private boolean savingAvatar;
    private int sharesRemainingBeforeRatingPrompt;
    private long startTime;
    ImojiBrowserTabLayout tabLayout;
    TemplatesManager templatesManager;
    private Toolbar toolbar;
    protected ViewPager viewPager;

    public ImojiBrowserActivity()
    {
        returnAsResult = false;
        sharesRemainingBeforeRatingPrompt = 3;
        isPaused = false;
        dataSetChangedWhilePaused = false;
        newUserHasSeenInviteFlow = false;
        savingAvatar = false;
    }

    private void checkShareMode()
    {
        String s = getIntent().getAction();
        if (s != null && isSelectionAction(s))
        {
            returnAsResult = true;
            return;
        } else
        {
            returnAsResult = false;
            return;
        }
    }

    private void clearCache()
    {
        (new AsyncTask() {

            final ImojiBrowserActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                avoid = getExternalCacheDir();
                if (avoid != null) goto _L2; else goto _L1
_L1:
                return null;
_L2:
                if ((avoid = avoid.listFiles()) != null)
                {
                    int j = avoid.length;
                    int i = 0;
                    while (i < j) 
                    {
                        Void void1 = avoid[i];
                        if (void1.isFile() && void1.getName().endsWith(".png"))
                        {
                            void1.delete();
                        }
                        i++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = ImojiBrowserActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    private void clearPreferences()
    {
        preferenceUtils.putString(0x7f06003a, null);
        preferenceUtils.putBoolean(0x7f06008a, false);
        preferenceUtils.putBoolean(0x7f06009e, false);
        preferenceUtils.putString(0x7f06002a, null);
        AnnouncerData announcerdata = templatesManager.getFashionAnnouncerData();
        templatesManager.setAnnouncerSeen(announcerdata, false);
    }

    private void createTabs()
    {
        Templates templates = templatesManager.getTemplates();
        imojiPagerAdapter = new ImojiPagerAdapter(getSupportFragmentManager(), this, templates);
        viewPager = (ViewPager)findViewById(0x7f0b008f);
        tabLayout = (ImojiBrowserTabLayout)findViewById(0x7f0b008e);
    }

    private void customizeActionBar()
    {
        if (b4mService.isReplyMode())
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(getString(0x7f0600b7));
            return;
        } else
        {
            setTitle("");
            toolbar.setLogo(0x7f0200ab);
            return;
        }
    }

    private void decrementSharesRemainingBeforeRatingPrompt()
    {
        int i = preferenceUtils.getInt(0x7f0600db, sharesRemainingBeforeRatingPrompt).intValue();
        preferenceUtils.putInt(0x7f0600db, Integer.valueOf(i - 1).intValue());
    }

    private void exchangeTokens()
    {
        int i = getResources().getInteger(0x7f0c0003);
        bsAuthService.exchangeTokens(facebookService.getToken(), i, new Callback() {

            final ImojiBrowserActivity this$0;

            public void failure(RetrofitError retrofiterror)
            {
                if (retrofiterror != null && retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() == 404)
                {
                    showExchangeTokenErrorToastAndLogOut();
                    return;
                } else
                {
                    getAvatarInfo();
                    return;
                }
            }

            public void success(BSAuthExchangeTokensResponse bsauthexchangetokensresponse, Response response)
            {
                bsauthexchangetokensresponse = bsauthexchangetokensresponse.getAccessToken();
                if (TextUtils.isEmpty(bsauthexchangetokensresponse))
                {
                    crashlyticsService.log("BSAuth returning empty tokens for users/exchange_tokens");
                    logout();
                    return;
                } else
                {
                    preferenceUtils.putString(0x7f06003a, bsauthexchangetokensresponse);
                    preferenceUtils.putBoolean(0x7f06008a, true);
                    getAvatarInfo();
                    return;
                }
            }

            public volatile void success(Object obj, Response response)
            {
                success((BSAuthExchangeTokensResponse)obj, response);
            }

            
            {
                this$0 = ImojiBrowserActivity.this;
                super();
            }
        });
    }

    private void finishWithResultData(File file)
    {
        if (file.exists())
        {
            File file1 = fileUtil.saveImojiForAttachment(file);
            Intent intent = new Intent();
            intent.setType("image/png");
            if (file1 != null)
            {
                file = file1;
            }
            intent.setData(Uri.fromFile(file));
            setResult(-1, intent);
        }
        finish();
    }

    private void getAvatarInfo()
    {
        String s = facebookService.getToken();
        String s1 = preferenceUtils.getString(0x7f06003a, "");
        if (TextUtils.isEmpty(s) && TextUtils.isEmpty(s1))
        {
            logout();
            return;
        } else
        {
            String s2 = getString(0x7f060017);
            final boolean savingAvatarAtTimeOfCall = savingAvatar;
            bitstripsService.getAvatarInfo(s, s1, s2, new Callback() {

                final ImojiBrowserActivity this$0;
                final boolean val$savingAvatarAtTimeOfCall;
                final Activity val$self;

                public void failure(RetrofitError retrofiterror)
                {
                    retrofiterror = preferenceUtils.getString(0x7f06002a, null);
                    if ("b4m".equals("production") && TextUtils.isEmpty(retrofiterror))
                    {
                        logout();
                    } else
                    if (retrofiterror != null)
                    {
                        if (isFloaterPrefEnabled())
                        {
                            floaterServiceManager.startFloaterService();
                        }
                        imojisPreloader.load();
                        return;
                    }
                }

                public void success(AvatarInfo avatarinfo, Response response)
                {
                    response = preferenceUtils.getString(0x7f06002a, null);
                    avatarinfo.saveToPreferences(preferenceUtils);
                    if (TextUtils.isEmpty(avatarinfo.getId()))
                    {
                        intentCreatorService.goToLoginActivity(self);
                    } else
                    {
                        if (!avatarinfo.getIsDressed() && !savingAvatarAtTimeOfCall)
                        {
                            goToOutfitBuilder();
                            return;
                        }
                        if (avatarinfo.getId() != null)
                        {
                            com.bitstrips.outfitbuilder.models.OBAvatarData obavatardata = AvatarInfo.getAvatarDataFromPreferences(preferenceUtils);
                            OBAssetsPreloaderIntentService.startActionFetchAvatarDependentAssets(getApplicationContext(), obavatardata, templatesManager.getCatalogForData(obavatardata));
                        }
                        if (response == null || !response.equals(avatarinfo.getId()) || !response.equals(imojisPreloader.getLastPreloadedAvatarId()))
                        {
                            templatesManager.resetAllImojisCachedImageUrl();
                            if (isFloaterPrefEnabled())
                            {
                                floaterServiceManager.restartFloaterService();
                            }
                            if (response != null)
                            {
                                imojisPreloader.load();
                            }
                            if (!isPaused && !isFinishing())
                            {
                                imojiPagerAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                    }
                }

                public volatile void success(Object obj, Response response)
                {
                    success((AvatarInfo)obj, response);
                }

            
            {
                this$0 = ImojiBrowserActivity.this;
                self = activity;
                savingAvatarAtTimeOfCall = flag;
                super();
            }
            });
            return;
        }
    }

    private Date getReminderDate()
    {
        Object obj1 = null;
        String s = preferenceUtils.getString(0x7f0600ce, null);
        Object obj = obj1;
        if (s != null)
        {
            obj = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            try
            {
                obj = ((DateFormat) (obj)).parse(s);
            }
            catch (ParseException parseexception)
            {
                obj = obj1;
                if ("release".equals("debug"))
                {
                    Log.e("ImojiBrowser", (new StringBuilder()).append("Rating: Error parsing reminder date: ").append(s).toString(), parseexception);
                    return null;
                }
            }
        }
        return ((Date) (obj));
    }

    private void goToOutfitBuilder()
    {
        viewPager.setAdapter(null);
        hideAnnouncer(templatesManager.getFashionAnnouncerData());
        intentCreatorService.goToOutfitBuilder(this, 8, false);
    }

    private void goToViewPagerOnboardingAsync(final Activity activity)
    {
        (new AsyncTask() {

            final ImojiBrowserActivity this$0;
            final Activity val$activity;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                intentCreatorService.goToBitmojiForMessengerOnboarding(activity);
            }

            
            {
                this$0 = ImojiBrowserActivity.this;
                activity = activity1;
                super();
            }
        }).execute(new Void[0]);
    }

    private void handleDeepLinkingSchemeRedirection()
    {
        String s;
        byte byte0;
        s = getIntent().getStringExtra("schemeHost");
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 68
    //                   -1405959847: 141
    //                   -102233725: 155
    //                   555704345: 127
    //                   1434631203: 169;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_169;
_L6:
        switch (byte0)
        {
        default:
            Log.d("ImojiBrowser", (new StringBuilder()).append("Unhandled scheme: ").append(s).toString());
            return;

        case 0: // '\0'
            goToOutfitBuilder();
            return;

        case 1: // '\001'
            intentCreatorService.goToAvatarBuilderEdit(this);
            return;

        case 2: // '\002'
            intentCreatorService.goToBitshop(this);
            return;

        case 3: // '\003'
            intentCreatorService.goToSettings(this);
            break;
        }
        break MISSING_BLOCK_LABEL_214;
_L4:
        if (s.equals("catalog"))
        {
            byte0 = 0;
        }
          goto _L6
_L2:
        if (s.equals("avatar"))
        {
            byte0 = 1;
        }
          goto _L6
_L3:
        if (s.equals("bitshop"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("settings"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    private void handleFirstLaunch()
    {
        if (getIntent().getBooleanExtra("isNewUser", false) && !newUserHasSeenInviteFlow)
        {
            showInviteFlow();
            newUserHasSeenInviteFlow = true;
        } else
        if (isFirstLaunch())
        {
            analytics.sendEvent(Category.INITIAL_LAUNCH, Action.LAUNCH, null);
            showWelcomeDialog();
            setNotFirstLaunch();
            return;
        }
    }

    private void hideAnnouncer(AnnouncerData announcerdata)
    {
        if (announcerdata != null)
        {
            switch (announcerdata.getAnnouncerType())
            {
            default:
                return;

            case 0: // '\0'
                break;
            }
            if (fashionAnnouncerView != null)
            {
                fashionAnnouncerView.removeListener(this);
                fashionAnnouncerView.setVisibility(8);
                highlightMenuItem(null);
                return;
            }
        }
    }

    private void highlightMenuItem(MenuItem menuitem)
    {
        char c1 = '\377';
        Object obj = toolbar.getMenu();
        int i = 0;
        while (i < ((Menu) (obj)).size()) 
        {
            MenuItem menuitem1 = ((Menu) (obj)).getItem(i);
            Boolean boolean1;
            Drawable drawable;
            boolean flag;
            if (menuitem == null || menuitem1 == menuitem)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            boolean1 = Boolean.valueOf(flag);
            drawable = menuitem1.getIcon();
            menuitem1.setEnabled(boolean1.booleanValue());
            if (drawable != null)
            {
                char c;
                if (boolean1.booleanValue())
                {
                    c = '\377';
                } else
                {
                    c = '\200';
                }
                drawable.setAlpha(c);
            }
            i++;
        }
        obj = toolbar.getOverflowIcon();
        if (menuitem == null)
        {
            i = c1;
        } else
        {
            i = 128;
        }
        ((Drawable) (obj)).setAlpha(i);
    }

    private boolean isFirstLaunch()
    {
        return preferenceUtils.getBoolean(0x7f060081, true);
    }

    private boolean isFloaterPrefEnabled()
    {
        if (android.os.Build.VERSION.SDK_INT > 21)
        {
            return false;
        } else
        {
            return preferenceUtils.getBoolean(0x7f060083, true);
        }
    }

    private boolean isSelectionAction(String s)
    {
        return s.equals("android.intent.action.GET_CONTENT") || s.equals("android.intent.action.PICK");
    }

    private void onDataSetChange()
    {
        if (isFinishing() || isPaused)
        {
            dataSetChangedWhilePaused = true;
            return;
        } else
        {
            imojiPagerAdapter.notifyDataSetChanged();
            return;
        }
    }

    private void onFileReady(File file, Imoji imoji, Category category)
    {
        if (file != null)
        {
            String s = imoji.getTemplateId();
            long l = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            analytics.sendTiming(category, Variable.TIME_TO_SELECT, l, s);
            if (returnAsResult)
            {
                if (b4mService.isReplyMode())
                {
                    if (intentCreatorService.createFacebookMessengerIntent(this, Uri.fromFile(file), imoji.getTemplateId()))
                    {
                        analytics.sendEvent(category, Action.REPLY_SHARE, imoji.getTemplateId());
                        return;
                    }
                } else
                {
                    Action action = Action.ATTACH;
                    finishWithResultData(file);
                    addToRecent(imoji.getTemplateId(), true);
                    analytics.sendEvent(category, action, s);
                    decrementSharesRemainingBeforeRatingPrompt();
                    analytics.incrementTotalShareCount(preferenceUtils);
                    return;
                }
            } else
            {
                shareFile(file, imoji, category);
                return;
            }
        }
    }

    private boolean ratingPromptShouldBeDisplayed()
    {
        boolean flag1 = true;
        if (preferenceUtils.getBoolean(0x7f0600c9, false))
        {
            return false;
        }
        sharesRemainingBeforeRatingPrompt = preferenceUtils.getInt(0x7f0600db, sharesRemainingBeforeRatingPrompt).intValue();
        Date date;
        boolean flag;
        if (sharesRemainingBeforeRatingPrompt <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        date = getReminderDate();
        if (date != null)
        {
            if ((new Date()).after(date) && flag)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            return flag;
        } else
        {
            return flag;
        }
    }

    private void resetSharesRemainingBeforeRatingPrompt()
    {
        sharesRemainingBeforeRatingPrompt = 2;
        preferenceUtils.putInt(0x7f0600db, sharesRemainingBeforeRatingPrompt);
    }

    private void returnToLogin()
    {
        startActivity(new Intent(getApplicationContext(), com/bitstrips/imoji/ui/LoginActivity));
    }

    private void sendFeedbackEmail()
    {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "tickets@bitmoji.uservoice.com", null));
        intent.putExtra("android.intent.extra.SUBJECT", String.format(Locale.US, "%s v%s", new Object[] {
            getString(0x7f06006b), "2.1.390"
        }));
        intent.putExtra("android.intent.extra.TEXT", String.format(Locale.US, "Device: %s %s %s\nOS: %d\n\n%s:\n\n", new Object[] {
            Build.MANUFACTURER, Build.MODEL, Build.PRODUCT, Integer.valueOf(android.os.Build.VERSION.SDK_INT), getString(0x7f060064)
        }));
        startActivity(intent);
    }

    private void sendNoShareThroughFloaterEvent()
    {
        String s = getIntent().getStringExtra("targetProcess");
        if (s != null)
        {
            long l = TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
            analytics.sendTiming(Category.FLOATER, Variable.ABANDONED, l, s);
        }
    }

    private void setNotFirstLaunch()
    {
        preferenceUtils.putBoolean(0x7f060081, false);
    }

    private void setRatingOptOutToTrue()
    {
        preferenceUtils.putBoolean(0x7f0600c9, true);
    }

    private void setReminderDateForRatingPrompt()
    {
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).add(5, 2);
        obj = ((Calendar) (obj)).getTime();
        obj = (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(((Date) (obj)));
        preferenceUtils.putString(0x7f0600ce, ((String) (obj)));
    }

    private boolean shouldShowAnnouncer(AnnouncerData announcerdata)
    {
        while (announcerdata == null || !announcerdata.getEnabled() || preferenceUtils.getBoolean(announcerdata.getPreferenceString(), false)) 
        {
            return false;
        }
        return true;
    }

    private void showExchangeTokenErrorToastAndLogOut()
    {
        if (isPaused || isFinishing())
        {
            return;
        } else
        {
            ToastUtils.showLonger(this, getString(0x7f060072));
            logout();
            return;
        }
    }

    private void showInviteFlow()
    {
        intentCreatorService.goToInviteActivity(this, true);
    }

    private void showRatingDialog()
    {
        if (isPaused || isFinishing())
        {
            return;
        } else
        {
            (new android.app.AlertDialog.Builder(this)).setMessage(0x7f0600c6).setTitle(0x7f0600c7).setPositiveButton(0x7f0600c8, new android.content.DialogInterface.OnClickListener() {

                final ImojiBrowserActivity this$0;
                final Activity val$activity;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    analytics.sendEvent(Category.RATING, Action.RATE_NOW, null);
                    setRatingOptOutToTrue();
                    intentCreatorService.goToGooglePlayStore("com.bitstrips.imoji", activity);
                }

            
            {
                this$0 = ImojiBrowserActivity.this;
                activity = activity1;
                super();
            }
            }).setNegativeButton(0x7f0600ad, new android.content.DialogInterface.OnClickListener() {

                final ImojiBrowserActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    analytics.sendEvent(Category.RATING, Action.NO_THANKS, null);
                    setRatingOptOutToTrue();
                }

            
            {
                this$0 = ImojiBrowserActivity.this;
                super();
            }
            }).setNeutralButton(0x7f0600cd, new android.content.DialogInterface.OnClickListener() {

                final ImojiBrowserActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    analytics.sendEvent(Category.RATING, Action.REMIND_ME, null);
                    resetSharesRemainingBeforeRatingPrompt();
                    setReminderDateForRatingPrompt();
                }

            
            {
                this$0 = ImojiBrowserActivity.this;
                super();
            }
            }).setCancelable(false).show();
            return;
        }
    }

    private void showShareImageDialog(Intent intent, File file, Imoji imoji, Category category)
    {
        if (isPaused || isFinishing())
        {
            return;
        }
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        Object obj = getSupportFragmentManager().findFragmentByTag("shareDialog");
        if (obj != null)
        {
            fragmenttransaction.remove(((android.support.v4.app.Fragment) (obj)));
        }
        fragmenttransaction.addToBackStack(null);
        obj = new ShareImageDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ShareImageDialogFragment.INTENT_KEY, intent);
        bundle.putString(ShareImageDialogFragment.FILE_PATH_KEY, file.getAbsolutePath());
        bundle.putParcelable(ShareImageDialogFragment.IMOJI_KEY, imoji);
        bundle.putSerializable(ShareImageDialogFragment.CATEGORY_KEY, category);
        ((DialogFragment) (obj)).setArguments(bundle);
        ((DialogFragment) (obj)).show(fragmenttransaction, "shareDialog");
    }

    private void showWelcomeDialog()
    {
        if (isPaused || isFinishing())
        {
            return;
        }
        if ("b4m".equals("production"))
        {
            goToViewPagerOnboardingAsync(this);
            return;
        }
        setRequestedOrientation(1);
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentByTag("dialog");
        if (fragment != null)
        {
            fragmenttransaction.remove(fragment);
        }
        fragmenttransaction.addToBackStack(null);
        (new WelcomeDialogFragment()).show(fragmenttransaction, "dialog");
    }

    private void trackFirstDay()
    {
        if (preferenceUtils.getString(0x7f060080, null) == null)
        {
            Object obj = new Date();
            obj = (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(((Date) (obj)));
            preferenceUtils.putString(0x7f060080, ((String) (obj)));
        }
    }

    private void unbindDrawables(View view)
    {
        if (view != null)
        {
            if (view.getBackground() != null)
            {
                view.getBackground().setCallback(null);
            }
            if ((view instanceof ViewGroup) && !(view instanceof AdapterView))
            {
                for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++)
                {
                    unbindDrawables(((ViewGroup)view).getChildAt(i));
                }

                ((ViewGroup)view).removeAllViews();
                return;
            }
        }
    }

    private void updateTemplates()
    {
        com.bitstrips.imoji.manager.TemplatesManager.SuccessCallback successcallback = new com.bitstrips.imoji.manager.TemplatesManager.SuccessCallback() {

            final ImojiBrowserActivity this$0;

            public void success(Templates templates, Response response)
            {
                imojiPagerAdapter.updateTemplates(templates);
                onDataSetChange();
            }

            public volatile void success(Object obj, Response response)
            {
                success((Templates)obj, response);
            }

            
            {
                this$0 = ImojiBrowserActivity.this;
                super();
            }
        };
        templatesManager.updateTemplates(successcallback);
    }

    protected void addToRecent(String s, final boolean updateBrowser)
    {
        recentImojiesManager.addRecentTemplateId(s, new com.bitstrips.imoji.manager.RecentImojiesManager.Callback() {

            final ImojiBrowserActivity this$0;
            final boolean val$updateBrowser;

            public void success()
            {
                if (updateBrowser)
                {
                    onDataSetChange();
                }
            }

            
            {
                this$0 = ImojiBrowserActivity.this;
                updateBrowser = flag;
                super();
            }
        });
    }

    protected Category getCategory(int i)
    {
        int j = viewPager.getCurrentItem();
        String s = ((ImojiPagerAdapter)viewPager.getAdapter()).getTabSupertag(j).toString();
        if (s.equals("recent"))
        {
            if (i == 0x7f0b00b2)
            {
                return Category.POPULAR;
            }
            if (i == 0x7f0b00b4)
            {
                return Category.PURCHASED;
            }
        }
        return Category.valueOf(s.toUpperCase(Locale.US));
    }

    protected void initView()
    {
        if (templatesManager.getTemplates() == null)
        {
            logout();
            return;
        } else
        {
            createTabs();
            return;
        }
    }

    public void logout()
    {
        floaterServiceManager.stopFloaterService();
        analytics.sendEvent(Category.AUTH, Action.LOGOUT, null);
        facebookService.logout();
        templatesManager.resetAllImojisCachedImageUrl();
        clearPreferences();
        returnToLogin();
        finish();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1)
        {
            if (j == -1)
            {
                logout();
            }
        } else
        if (i == 8 && j == -1)
        {
            getAvatarInfo();
            return;
        }
    }

    public void onClick(Imoji imoji)
    {
        if (imoji.isUnpurchased())
        {
            intentCreatorService.goToBitshop(this, imoji.getUniversalPackId());
            return;
        }
        if (mImojiImageTask != null)
        {
            mImojiImageTask.cancel(true);
        }
        mImojiImageTask = new GetImojiImageTask(this, imageLoader, templatesManager) {

            final ImojiBrowserActivity this$0;

            protected void onPostExecute(File file)
            {
                Category category = Category.getCategoryFromString((String)imoji.getSupertags().get(0));
                onFileReady(file, imoji, category);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((File)obj);
            }

            
            {
                this$0 = ImojiBrowserActivity.this;
                super(activity, imageloader, templatesmanager);
            }
        };
        mImojiImageTask.execute(new Imoji[] {
            imoji
        });
    }

    public void onClick(File file, Imoji imoji, int i)
    {
        if (imoji.isUnpurchased())
        {
            intentCreatorService.goToBitshop(this, imoji.getUniversalPackId());
            return;
        } else
        {
            onFileReady(file, imoji, getCategory(i));
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ((InjectorApplication)getApplication()).inject(this);
        b4mService.configureWithIntent(getIntent());
        setActivityLayout();
        toolbar = (Toolbar)findViewById(0x7f0b0074);
        setSupportActionBar(toolbar);
        customizeActionBar();
        initView();
        if (b4mService.isReplyMode())
        {
            b4mService.addReplyFriendListener(this);
            b4mService.getReplyFriends(this);
        }
        bundle = getIntent().getDataString();
        if (bundle != null && bundle.equals(getString(0x7f0600a6)))
        {
            logout();
        } else
        {
            handleDeepLinkingSchemeRedirection();
            bundle = templatesManager.getFashionAnnouncerData();
            if (bundle != null)
            {
                fashionAnnouncerView = (FashionAnnouncerView)findViewById(bundle.getViewId());
            }
            if (shouldShowAnnouncer(bundle))
            {
                showAnnouncer(bundle);
                return;
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuinflater = getMenuInflater();
        if (b4mService.isReplyMode())
        {
            menuinflater.inflate(0x7f0e0006, menu);
        } else
        {
            menuinflater.inflate(0x7f0e0005, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (b4mService.isReplyMode())
        {
            b4mService.removeReplyListener(this);
            b4mService.resetReplyMode();
        }
        if (errorDialog != null)
        {
            errorDialog.dismiss();
            errorDialog = null;
        }
        unbindDrawables(findViewById(0x7f0b008e));
        unbindDrawables(findViewById(0x7f0b008f));
        clearCache();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        setRequestedOrientation(4);
    }

    public void onFashionAnnouncerCloseTouch(AnnouncerData announcerdata)
    {
        hideAnnouncer(announcerdata);
    }

    public void onFashionAnnouncerLoaded(AnnouncerData announcerdata)
    {
        fashionAnnouncerView.setVisibility(0);
        fashionAnnouncerView.setNotchPosition(toolbar.findViewById(0x7f0b0117));
        highlightMenuItem(toolbar.getMenu().findItem(0x7f0b0117));
        templatesManager.setAnnouncerSeen(announcerdata, true);
    }

    public void onFashionAnnouncerTouch(AnnouncerData announcerdata)
    {
        hideAnnouncer(announcerdata);
        goToOutfitBuilder();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            intentCreatorService.backToMessengerIntent(this);
            return true;

        case 2131427606: 
            intentCreatorService.goToAvatarBuilderEdit(this);
            return true;

        case 2131427607: 
            goToOutfitBuilder();
            return true;

        case 2131427608: 
            intentCreatorService.goToBitshop(this);
            return true;

        case 2131427609: 
            intentCreatorService.goToInviteActivity(this, false);
            return true;

        case 2131427612: 
            intentCreatorService.goToSettings(this);
            return true;

        case 2131427610: 
            sendFeedbackEmail();
            return true;

        case 2131427613: 
            intentCreatorService.goToSupportPage(this);
            return true;

        case 2131427611: 
            showRatingDialog();
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        isPaused = true;
        facebookService.logDeactivate(this);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (!getResources().getBoolean(0x7f080007))
        {
            MenuItem menuitem = menu.findItem(0x7f0b0118);
            if (menuitem != null)
            {
                menuitem.setVisible(false);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void onReplyFriendsFailure(String s)
    {
        Log.e("ImojiBrowser", (new StringBuilder()).append("Error fetching friend avatars: ").append(s).toString());
        if (isFinishing())
        {
            return;
        } else
        {
            initView();
            return;
        }
    }

    public void onReplyFriendsSuccess(String s)
    {
        if (isFinishing())
        {
            return;
        } else
        {
            initView();
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        isPaused = false;
        handleFirstLaunch();
        checkShareMode();
        if (TextUtils.isEmpty(preferenceUtils.getString(0x7f06003a, "")))
        {
            exchangeTokens();
        } else
        {
            getAvatarInfo();
        }
        trackFirstDay();
        facebookService.logActivate(this);
        if (dataSetChangedWhilePaused && !isFinishing())
        {
            dataSetChangedWhilePaused = false;
            imojiPagerAdapter.notifyDataSetChanged();
        }
    }

    protected void onStart()
    {
        super.onStart();
        analytics.reportStart(this);
        startTime = System.nanoTime();
        if (viewPager.getAdapter() == null)
        {
            viewPager.setAdapter(imojiPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
        if (ratingPromptShouldBeDisplayed())
        {
            showRatingDialog();
        }
        updateTemplates();
        if ("b4m".equals("production"))
        {
            intentCreatorService.displayUpgradeDialog(this);
        }
    }

    protected void onStop()
    {
        super.onStop();
        sendNoShareThroughFloaterEvent();
        analytics.reportStop(this);
    }

    protected void setActivityLayout()
    {
        setContentView(0x7f030020);
    }

    protected void shareFile(File file, Imoji imoji, Category category)
    {
        Object obj = Uri.fromFile(file);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", ((android.os.Parcelable) (obj)));
        intent.setType("image/png");
        obj = getIntent().getStringExtra("targetProcess");
        if (obj != null)
        {
            analytics.incrementTotalShareCount(preferenceUtils);
            analytics.sendEvent(category, Action.SHARE, imoji.getTemplateId());
            analytics.sendEvent(Category.FLOATER, Action.SHARE, ((String) (obj)));
            addToRecent(imoji.getTemplateId(), true);
            intent.setPackage(((String) (obj)));
            intent.addFlags(0x10000000);
            getIntent().removeExtra("targetProcess");
            startActivity(intent);
        } else
        {
            analytics.sendEvent(category, Action.PREVIEW, imoji.getTemplateId());
            showShareImageDialog(intent, file, imoji, category);
        }
        decrementSharesRemainingBeforeRatingPrompt();
    }

    public void showAnnouncer(AnnouncerData announcerdata)
    {
        if (announcerdata != null)
        {
            switch (announcerdata.getAnnouncerType())
            {
            default:
                return;

            case 0: // '\0'
                break;
            }
            if (fashionAnnouncerView != null)
            {
                String s = preferenceUtils.getString(0x7f06002a, "");
                fashionAnnouncerView.addListener(this);
                fashionAnnouncerView.load(announcerdata, s);
                return;
            }
        }
    }









}
