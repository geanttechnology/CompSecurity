// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.db.models.Business;
import com.groupon.db.models.Special;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.loader.BusinessDetailLoaderCallbacks;
import com.groupon.loader.BusinessSpecialLoaderCallback;
import com.groupon.manager.BusinessDetailSyncManager;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.models.nst.MerchantPageSpecialIdMetadata;
import com.groupon.service.LoginService;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.ImageUrl;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ShareHelper;
import com.groupon.util.WebViewHelper;
import com.groupon.view.SpinnerButton;
import com.groupon.view.UrlImageView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class BusinessSpecialPage extends GrouponActivity
    implements commonlib.manager.SyncManager.SyncUiCallbacks
{

    private static final int ANIMATION_DURATION = 500;
    private BusinessDetailSyncManager businessDetailSyncManager;
    String businessId;
    WebView instructions;
    private IntentFactory intentFactory;
    boolean isClaimSpecialClicked;
    boolean isDeepLinked;
    private LoggingUtils loggingUtils;
    private LoginService loginService;
    private Handler mHandler;
    UrlImageView printable;
    ProgressBar progressBar;
    TextView promoCode;
    SpinnerButton specialButton;
    TextView specialDetail;
    RelativeLayout specialEmailSection;
    ImageView specialIcon;
    String specialId;
    TextView specialInfoText;
    LinearLayout specialLayout;
    TextView specialName;
    private Special specialObj;
    TextView specialSavedText;
    TextView specialTime;

    public BusinessSpecialPage()
    {
    }

    private void initLoader()
    {
        getLoaderManager().initLoader(0, null, new BusinessDetailLoaderCallbacks(this, businessId) {

            final BusinessSpecialPage this$0;

            public void onMerchantDetailLoaded(Business business)
            {
label0:
                {
                    if (business == null)
                    {
                        break label0;
                    }
                    business = business.getSpecials();
                    if (business == null)
                    {
                        break label0;
                    }
                    business = business.iterator();
                    Special special;
                    do
                    {
                        if (!business.hasNext())
                        {
                            break label0;
                        }
                        special = (Special)business.next();
                    } while (!Strings.equals(special.remoteId, specialId));
                    specialObj = special;
                    logData();
                    updateUI();
                }
            }

            
            {
                this$0 = BusinessSpecialPage.this;
                super(context, s);
            }
        });
    }

    private void logData()
    {
        if (specialObj.claimed)
        {
            loggingUtils.logPageView("", "merchant_specials_saved_page", new MerchantPageMerchantIdMetadata(businessId));
            return;
        } else
        {
            loggingUtils.logPageView("", "merchant_specials_page", new MerchantPageMerchantIdMetadata(businessId));
            return;
        }
    }

    private void openShareDialog()
    {
        if (specialObj != null)
        {
            loggingUtils.logClick("", "share_medium_click", "share_special", loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
            String s;
            String s1;
            if (Strings.notEmpty(specialObj.name))
            {
                s = specialObj.name;
            } else
            {
                s = "";
            }
            if (Strings.notEmpty(specialObj.derivedBusinessUrl))
            {
                s1 = specialObj.derivedBusinessUrl;
            } else
            {
                s1 = "";
            }
            (new ShareHelper(this, s, s1)).shareAndLog(s, s1);
        }
    }

    private void saveSpecial()
    {
        if (Strings.isEmpty(specialId))
        {
            return;
        } else
        {
            specialButton.startSpinning();
            (new AbstractRetryAsyncTask(this) {

                final BusinessSpecialPage this$0;

                public InputStream call()
                    throws Exception
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add("special_id");
                    arraylist.add(specialId);
                    String s = String.format("https:/users/%s/specials", new Object[] {
                        loginService.getConsumerId()
                    });
                    return (InputStream)(new SyncHttp(getApplicationContext(), java/io/InputStream, s)).nvps(arraylist.toArray()).method("POST").call();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                protected void onException(Exception exception)
                {
                    specialButton.stopSpinning();
                    super.onException(exception);
                }

                protected void onPreExecute()
                    throws Exception
                {
                    super.onPreExecute();
                }

                protected void onSuccess(InputStream inputstream)
                    throws Exception
                {
                    specialAnimation();
                    businessDetailSyncManager.requestSync(BusinessSpecialPage.this, null);
                    specialObj.claimed = true;
                    super.onSuccess(inputstream);
                }

                protected volatile void onSuccess(Object obj)
                    throws Exception
                {
                    onSuccess((InputStream)obj);
                }

            
            {
                this$0 = BusinessSpecialPage.this;
                super(context);
            }
            }).execute();
            return;
        }
    }

    private void secondAnimationSet()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(500L);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final BusinessSpecialPage this$0;

            public void onAnimationEnd(Animation animation)
            {
                specialSavedText.setAlpha(1.0F);
                specialEmailSection.setAlpha(1.0F);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                specialSavedText.setAlpha(1.0F);
                specialEmailSection.setAlpha(1.0F);
            }

            
            {
                this$0 = BusinessSpecialPage.this;
                super();
            }
        });
        specialSavedText.startAnimation(alphaanimation);
        specialEmailSection.startAnimation(alphaanimation);
    }

    private void setEmailSectionOnClick()
    {
        specialEmailSection.setOnClickListener(new android.view.View.OnClickListener() {

            final BusinessSpecialPage this$0;

            public void onClick(View view)
            {
                Object obj;
                String s;
                String s1;
                String s2;
                if (Strings.notEmpty(specialObj.name))
                {
                    view = specialObj.name;
                } else
                {
                    view = "";
                }
                if (Strings.notEmpty(specialObj.getDerivedBusinessName()))
                {
                    obj = specialObj.getDerivedBusinessName();
                } else
                {
                    obj = "";
                }
                if (Strings.notEmpty(specialObj.shortRecurringText))
                {
                    s = specialObj.shortRecurringText;
                } else
                {
                    s = "";
                }
                if (Strings.notEmpty(specialObj.derivedBusinessUrl))
                {
                    s1 = specialObj.derivedBusinessUrl;
                } else
                {
                    s1 = "";
                }
                s2 = String.format(getApplicationContext().getString(0x7f0803be), new Object[] {
                    view, obj
                });
                view = String.format(getApplicationContext().getString(0x7f080461), new Object[] {
                    obj, view, obj, s, s1
                });
                obj = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "", null));
                ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", s2);
                ((Intent) (obj)).putExtra("android.intent.extra.TEXT", view);
                loggingUtils.logClick("", "email_special_click", specialObj.remoteId, loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
                startActivity(Intent.createChooser(((Intent) (obj)), "Email Special"));
            }

            
            {
                this$0 = BusinessSpecialPage.this;
                super();
            }
        });
    }

    private void setInstructionsContainer()
    {
        String s = specialObj.redemptionMethod;
        instructions.setWebViewClient(new WebViewClient() {

            final BusinessSpecialPage this$0;

            public void onLoadResource(WebView webview, String s2)
            {
                loggingUtils.logClick("", "special_affiliate_click", specialObj.remoteId, "");
                super.onLoadResource(webview, s2);
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s2)
            {
                return true;
            }

            
            {
                this$0 = BusinessSpecialPage.this;
                super();
            }
        });
        WebViewHelper.addInAppUserAgent(instructions);
        Object obj1 = getResources();
        Object obj = (new StringBuilder()).append((int)TypedValue.applyDimension(1, 12F, ((Resources) (obj1)).getDisplayMetrics())).append("px").toString();
        obj1 = (new StringBuilder()).append((int)TypedValue.applyDimension(1, 14F, ((Resources) (obj1)).getDisplayMetrics())).append("px").toString();
        instructions.loadDataWithBaseURL(null, (new StringBuilder()).append(String.format("<style type=text/css>ol{padding-left: %s;} li{color:#75787b;} p{color:#75787b; font-size:%s}</style>", new Object[] {
            obj, obj1
        })).append(specialObj.instructionsHtml).toString(), "text/html", "utf-8", null);
        boolean flag = specialObj.claimed;
        obj = new MerchantPageSpecialIdMetadata(specialObj.remoteId);
        if (s.equals("promoCode"))
        {
            promoCode.setText(specialObj.redemptionUnit);
            promoCode.setVisibility(0);
            LoggingUtils loggingutils = loggingUtils;
            if (!flag)
            {
                s = "specials_promocode";
            } else
            {
                s = "specials_promocode_saved";
            }
            loggingutils.logImpression("", s, businessId, "", ((com.groupon.models.nst.JsonEncodedNSTField) (obj)));
        } else
        {
            if (s.equals("printable"))
            {
                printable.setImageUrl(specialObj.redemptionUnit);
                printable.setOnClickListener(new android.view.View.OnClickListener() {

                    final BusinessSpecialPage this$0;

                    public void onClick(View view)
                    {
                        view = new ArrayList(1);
                        view.add(new ImageUrl(specialObj.redemptionUnit));
                        startActivity(intentFactory.newDealImageCarouselIntent(view, 0, specialObj.remoteId, Channel.MERCHANT_SPECIAL, ""));
                    }

            
            {
                this$0 = BusinessSpecialPage.this;
                super();
            }
                });
                printable.setVisibility(0);
                LoggingUtils loggingutils1 = loggingUtils;
                if (!flag)
                {
                    s = "specials_printable";
                } else
                {
                    s = "specials_printable_saved";
                }
                loggingutils1.logImpression("", s, businessId, "", ((com.groupon.models.nst.JsonEncodedNSTField) (obj)));
                return;
            }
            if (s.equals("affiliateLink"))
            {
                LoggingUtils loggingutils2 = loggingUtils;
                if (!flag)
                {
                    s = "specials_affiliatelink";
                } else
                {
                    s = "specials_affiliatelink_saved";
                }
                loggingutils2.logImpression("", s, businessId, "", ((com.groupon.models.nst.JsonEncodedNSTField) (obj)));
                return;
            }
            if (s.equals("inPerson"))
            {
                LoggingUtils loggingutils3 = loggingUtils;
                String s1;
                if (!flag)
                {
                    s1 = "specials_inperson";
                } else
                {
                    s1 = "specials_inperson_saved";
                }
                loggingutils3.logImpression("", s1, businessId, "", ((com.groupon.models.nst.JsonEncodedNSTField) (obj)));
                return;
            }
        }
    }

    private void specialAnimation()
    {
        specialButton.stopSpinning();
        setOrAnimatePlusCheckIcon(specialIcon, true, true);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(500L);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final BusinessSpecialPage this$0;

            public void onAnimationEnd(Animation animation)
            {
                specialButton.setVisibility(8);
                specialInfoText.setVisibility(8);
                specialSavedText.setAlpha(0.0F);
                specialEmailSection.setAlpha(0.0F);
                specialSavedText.setVisibility(0);
                specialEmailSection.setVisibility(0);
                secondAnimationSet();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = BusinessSpecialPage.this;
                super();
            }
        });
        specialButton.startAnimation(alphaanimation);
        specialInfoText.startAnimation(alphaanimation);
        setEmailSectionOnClick();
    }

    private void updateUI()
    {
        progressBar.setVisibility(8);
        specialLayout.setVisibility(0);
        specialName.setText(specialObj.name);
        specialTime.setText(specialObj.shortRecurringText);
        specialDetail.setText(specialObj.descriptionText);
        if (isDeepLinked)
        {
            setDisplayToolbarTitle(false);
        } else
        if (!Strings.isEmpty(specialObj.getDerivedBusinessName()))
        {
            setDisplayToolbarTitle(true);
            setToolbarTitle((new StringBuilder()).append(specialObj.getDerivedBusinessName()).append(" ").append(getApplicationContext().getString(0x7f0803bb)).toString());
        } else
        {
            setDisplayToolbarTitle(true);
            setToolbarTitle(getApplicationContext().getString(0x7f0803bb));
        }
        if (specialObj.claimed)
        {
            specialButton.setVisibility(8);
            specialInfoText.setVisibility(8);
            specialSavedText.setVisibility(0);
            specialEmailSection.setVisibility(0);
            specialIcon.setImageResource(0x7f0202f0);
            setEmailSectionOnClick();
        } else
        {
            specialButton.setVisibility(0);
            specialInfoText.setVisibility(0);
            specialSavedText.setVisibility(8);
            specialEmailSection.setVisibility(8);
            specialIcon.setImageResource(0x7f0202ef);
            specialButton.setOnClickListener(new android.view.View.OnClickListener() {

                final BusinessSpecialPage this$0;

                public void onClick(View view)
                {
                    if (loginService.isLoggedIn())
                    {
                        loggingUtils.logClick("", "save_special_click", specialObj.remoteId, loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(businessId)));
                        saveSpecial();
                        return;
                    } else
                    {
                        startActivity(intentFactory.newSpecialIntent(specialId, businessId, true));
                        finish();
                        return;
                    }
                }

            
            {
                this$0 = BusinessSpecialPage.this;
                super();
            }
            });
        }
        setInstructionsContainer();
        if (isClaimSpecialClicked)
        {
            isClaimSpecialClicked = false;
            getIntent().putExtra("is_claim_special_clicked", false);
            saveSpecial();
        }
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    protected Intent getDeepLinkUpIntent()
    {
        Intent intent = NavUtils.getParentActivityIntent(this);
        intent.putExtra("business_id", businessId);
        intent.putExtra("is_list_offers", false);
        intent.putExtra("isDeepLinked", true);
        return intent;
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004a);
        if (isDeepLinked)
        {
            businessDetailSyncManager.setMerchantId(businessId);
            initLoader();
            businessDetailSyncManager.requestSync(this, null);
            return;
        } else
        {
            getLoaderManager().initLoader(0, null, new BusinessSpecialLoaderCallback(this, specialId) {

                final BusinessSpecialPage this$0;

                public void onBusinessSpecialLoaded(Special special)
                {
                    specialObj = special;
                    progressBar.postDelayed(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            updateUI();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, 500L);
                    logData();
                }

            
            {
                this$0 = BusinessSpecialPage.this;
                super(context, s);
            }
            });
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131755037 2131755037: default 24
    //                   2131755037 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        openShareDialog();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setOrAnimatePlusCheckIcon(final ImageView imageView, boolean flag, boolean flag1)
    {
        final int imageResId;
        if (flag)
        {
            imageResId = 0x7f0202f0;
        } else
        {
            imageResId = 0x7f0202ef;
        }
        if (imageView.getTag() != null && (imageView.getTag() instanceof Animator))
        {
            ((Animator)imageView.getTag()).end();
            imageView.setAlpha(1.0F);
        }
        if (flag1 && flag)
        {
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(imageView, View.ALPHA, new float[] {
                    0.0F
                }), ObjectAnimator.ofFloat(imageView, View.SCALE_Y, new float[] {
                    1.0F, 0.0F
                }), ObjectAnimator.ofFloat(imageView, View.SCALE_X, new float[] {
                    1.0F, 0.0F
                })
            });
            animatorset.setDuration(500L);
            animatorset.addListener(new AnimatorListenerAdapter() {

                final BusinessSpecialPage this$0;
                final int val$imageResId;
                final ImageView val$imageView;

                public void onAnimationEnd(Animator animator)
                {
                    imageView.setImageResource(imageResId);
                }

            
            {
                this$0 = BusinessSpecialPage.this;
                imageView = imageview;
                imageResId = i;
                super();
            }
            });
            AnimatorSet animatorset1 = new AnimatorSet();
            animatorset1.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(imageView, View.ALPHA, new float[] {
                    1.0F
                }), ObjectAnimator.ofFloat(imageView, View.SCALE_Y, new float[] {
                    0.0F, 1.0F
                }), ObjectAnimator.ofFloat(imageView, View.SCALE_X, new float[] {
                    0.0F, 1.0F
                })
            });
            animatorset1.setDuration(500L);
            AnimatorSet animatorset2 = new AnimatorSet();
            animatorset2.playSequentially(new Animator[] {
                animatorset, animatorset1
            });
            animatorset2.addListener(new AnimatorListenerAdapter() {

                final BusinessSpecialPage this$0;
                final ImageView val$imageView;

                public void onAnimationEnd(Animator animator)
                {
                    imageView.setTag(null);
                }

            
            {
                this$0 = BusinessSpecialPage.this;
                imageView = imageview;
                super();
            }
            });
            imageView.setTag(animatorset2);
            animatorset2.start();
            return;
        } else
        {
            mHandler.post(new Runnable() {

                final BusinessSpecialPage this$0;
                final int val$imageResId;
                final ImageView val$imageView;

                public void run()
                {
                    imageView.setImageResource(imageResId);
                }

            
            {
                this$0 = BusinessSpecialPage.this;
                imageView = imageview;
                imageResId = i;
                super();
            }
            });
            return;
        }
    }



/*
    static Special access$002(BusinessSpecialPage businessspecialpage, Special special)
    {
        businessspecialpage.specialObj = special;
        return special;
    }

*/









}
