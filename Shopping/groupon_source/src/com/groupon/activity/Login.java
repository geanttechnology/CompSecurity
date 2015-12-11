// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.groupon.Channel;
import com.groupon.abtest.GoogleSignInAbTestHelper;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.fragment.LogInFragment;
import com.groupon.fragment.SignUpFragment;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.DealUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Tracking;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory, FacebookAppUtils

public class Login extends GrouponFragmentActivity
    implements com.groupon.fragment.TermsConditionsFragment.TermsConditionsListener
{
    protected class FragmentAdapter extends FragmentStatePagerAdapter
    {

        final Login this$0;

        public int getCount()
        {
            return 2;
        }

        public Fragment getItem(int i)
        {
            if (i == 0)
            {
                return logInFragment;
            } else
            {
                return signUpFragment;
            }
        }

        public CharSequence getPageTitle(int i)
        {
            if (i == 0)
            {
                return getString(0x7f08025a);
            } else
            {
                return getString(0x7f08025b);
            }
        }

        public FragmentAdapter(FragmentManager fragmentmanager)
        {
            this$0 = Login.this;
            super(fragmentmanager);
        }
    }


    public static final int REQUEST_CODE = 10110;
    private FragmentAdapter adapter;
    protected CallbackManager callbackManager;
    String cartDealImageUrl;
    Channel channel;
    DealCardCompact dealCardCompact;
    String dealId;
    private DeviceInfoUtil deviceInfoUtil;
    protected FacebookAppUtils facebookAppUtils;
    boolean fromOnboarding;
    private GoogleSignInAbTestHelper googleSignInAbTestHelper;
    PagerSlidingTabStrip indicator;
    private IntentFactory intentFactory;
    Boolean isComingFromCheckout;
    Integer itemsCount;
    private LogInFragment logInFragment;
    private LoginService loginService;
    String maxCartDiscount;
    Intent next;
    String optionId;
    GrouponViewPager pager;
    View rootView;
    boolean shouldGoToCarousel;
    private SignUpFragment signUpFragment;
    private Tracking tracking;

    public Login()
    {
    }

    private boolean shouldShowDealCard()
    {
        return isCheckoutFlow1408() && !googleSignInAbTestHelper.isGoogleLoginUSCA1508Enabled();
    }

    public Channel getChannel()
    {
        return channel;
    }

    public void getCity()
    {
        startActivityForResult(intentFactory.newSignUpDivisionSelector(), 10125);
    }

    public String getDealId()
    {
        return dealId;
    }

    public Boolean getIsComingFromCheckout()
    {
        return isComingFromCheckout;
    }

    public Intent getNext()
    {
        return next;
    }

    protected void handleDealCardVisibilityForMdpi()
    {
        if (rootView != null && !deviceInfoUtil.isTablet() && deviceInfoUtil.getDensityDpi() == 160)
        {
            rootView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final Login this$0;

                public void onGlobalLayout()
                {
                    DealCardCompact dealcardcompact = dealCardCompact;
                    byte byte0;
                    if (deviceInfoUtil.isKeyboardShown(rootView))
                    {
                        byte0 = 8;
                    } else
                    {
                        byte0 = 0;
                    }
                    dealcardcompact.setVisibility(byte0);
                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = Login.this;
                super();
            }
            });
        }
    }

    protected void initActionBar(Bundle bundle)
    {
        if (!shouldShowDealCard())
        {
            bundle = getSupportActionBar();
            boolean flag;
            if (!fromOnboarding)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ActionBarUtil.addCenteredLogo(bundle, flag);
            return;
        } else
        {
            super.initActionBar(bundle);
            return;
        }
    }

    protected boolean isCheckoutFlow1408()
    {
        return isComingFromCheckout != null && isComingFromCheckout.booleanValue() && currentCountryManager.getCurrentCountry().isUSACompatible();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i != 30000) goto _L2; else goto _L1
_L1:
        callbackManager.onActivityResult(i, j, intent);
_L4:
        return;
_L2:
        if (i == 40000)
        {
            logInFragment.onActivityResult(i, j, intent);
            return;
        }
        if (i == 40001)
        {
            signUpFragment.onActivityResult(i, j, intent);
            return;
        }
        if (i == 10153)
        {
            logInFragment.onActivityResult(i, j, intent);
            return;
        }
        if (i == 10154)
        {
            signUpFragment.onActivityResult(i, j, intent);
            return;
        }
        if (i != 10125 || j != -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = intent.getExtras();
        if (intent == null) goto _L4; else goto _L3
_L3:
        intent = (Division)intent.getParcelable("division_object");
        signUpFragment.setDivision(intent);
        return;
        if (j != -1 || fromOnboarding) goto _L4; else goto _L5
_L5:
        setResult(-1);
        finish();
        return;
    }

    public void onBackPressed()
    {
        if (fromOnboarding && next != null)
        {
            startActivity(next.putExtra("FROM_ONBOARDING", true));
            finish();
            return;
        }
        if (shouldGoToCarousel && next != null)
        {
            startActivity(next);
            finish();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj = FacebookSdk.getApplicationId();
        if (Strings.isEmpty(obj) || !((String) (obj)).equals(facebookAppUtils.getFacebookAppId()))
        {
            FacebookSdk.setApplicationId(facebookAppUtils.getFacebookAppId());
            FacebookSdk.sdkInitialize(getApplicationContext());
        }
        callbackManager = com.facebook.CallbackManager.Factory.create();
        int i;
        if (shouldShowDealCard())
        {
            i = 0x7f030020;
        } else
        {
            i = 0x7f03001f;
        }
        setContentView(i);
        adapter = new FragmentAdapter(getFragmentManager());
        pager.setAdapter(adapter);
        indicator.setShouldExpand(true);
        indicator.setViewPager(pager);
        if (next != null)
        {
            next.setExtrasClassLoader(getClassLoader());
            if (getIntent().getBooleanExtra("comingFromCheckout", false))
            {
                next.putExtra("comingFromCheckout", true);
            }
            if (getIntent().getBooleanExtra("isDeepLinked", false))
            {
                next.putExtra("isDeepLinked", true);
            }
            if (channel != null)
            {
                next.putExtra("channel", channel);
            }
        }
        obj = new Bundle();
        ((Bundle) (obj)).putBoolean("FROM_ONBOARDING", fromOnboarding);
        if (shouldShowDealCard())
        {
            ((Bundle) (obj)).putString("dealId", dealId);
            ((Bundle) (obj)).putBoolean("comingFromCheckout", isComingFromCheckout.booleanValue());
            ((Bundle) (obj)).putParcelable("channel", channel);
            boolean flag;
            if (itemsCount != null && itemsCount.intValue() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                dealCardCompact.setShoppingCartInfo(itemsCount.intValue(), maxCartDiscount, cartDealImageUrl);
            } else
            {
                dealCardCompact.setLoading(true);
                getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(((Bundle) (obj)), flag) {

                    final Login this$0;
                    final Bundle val$arguments;
                    final boolean val$isCartExperience;

                    public void onDealLoaded(Deal deal)
                    {
                        boolean flag1 = true;
                        if (deal != null)
                        {
                            if (optionId != null)
                            {
                                dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, optionId));
                            }
                            String s = dealCardCompact.getDiscountPercent();
                            if (!Strings.notEmpty(s))
                            {
                                s = "";
                            }
                            if (!deal.getDisplayOption("discount", true) || deal.derivedDiscountPercent <= 0)
                            {
                                flag1 = false;
                            }
                            arguments.putBoolean("should_display_discount", flag1);
                            arguments.putString("discount", s);
                            if (logInFragment.isAdded())
                            {
                                logInFragment.setLoginButtonText(s, flag1);
                            }
                            if (signUpFragment.isAdded())
                            {
                                signUpFragment.setSignUpButtonText(s, flag1);
                            }
                        }
                    }

                    public void onLoadFinished(Loader loader, Deal deal)
                    {
                        boolean flag1 = false;
                        super.onLoadFinished(loader, deal);
                        dealCardCompact.setLoading(false);
                        loader = dealCardCompact;
                        int j = ((flag1) ? 1 : 0);
                        if (deal == null)
                        {
                            if (isCartExperience)
                            {
                                j = ((flag1) ? 1 : 0);
                            } else
                            {
                                j = 8;
                            }
                        }
                        loader.setVisibility(j);
                    }

                    public volatile void onLoadFinished(Loader loader, Object obj1)
                    {
                        onLoadFinished(loader, (Deal)obj1);
                    }

            
            {
                this$0 = Login.this;
                arguments = bundle;
                isCartExperience = flag;
                super(final_context, final_s);
            }
                });
            }
            handleDealCardVisibilityForMdpi();
        }
        if (bundle != null)
        {
            logInFragment = (LogInFragment)getFragmentManager().getFragment(bundle, LogInFragment.TAG);
            signUpFragment = (SignUpFragment)getFragmentManager().getFragment(bundle, SignUpFragment.TAG);
        } else
        {
            logInFragment = new LogInFragment();
            signUpFragment = new SignUpFragment();
            logInFragment.setArguments(((Bundle) (obj)));
            signUpFragment.setArguments(((Bundle) (obj)));
        }
        logInFragment.setCallbackManager(callbackManager);
        signUpFragment.setCallbackManager(callbackManager);
        RoboGuice.getInjector(this).injectMembers(logInFragment);
        RoboGuice.getInjector(this).injectMembers(signUpFragment);
    }

    protected void onDestroy()
    {
        Tracking tracking1 = tracking;
        String s;
        if (loginService.isLoggedInViaEmail())
        {
            s = "username";
        } else
        if (loginService.isLoggedInViaFacebook())
        {
            s = "facebook";
        } else
        {
            s = "no";
        }
        tracking1.trackEvent("User", "login_succeeded", s, 1);
        if (!loginService.isLoggedIn())
        {
            logger.logClick("", "click_skip", "login/signup", "");
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c && shouldGoToCarousel && next != null)
        {
            startActivity(next);
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (loginService.isLoggedIn())
        {
            setResult(-1);
            logInFragment.onLoginSuccess(null);
            finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        getFragmentManager().putFragment(bundle, LogInFragment.TAG, logInFragment);
        getFragmentManager().putFragment(bundle, SignUpFragment.TAG, signUpFragment);
    }

    public void onTermsConditionsAccepted()
    {
        signUpFragment.onTermsConditionsAccepted();
    }



}
