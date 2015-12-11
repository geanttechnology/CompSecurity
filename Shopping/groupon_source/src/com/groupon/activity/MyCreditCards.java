// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Option;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.models.GenericAmount;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.country.CreditCard;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.GoogleWalletPaymentMethod;
import com.groupon.models.payment.PaymentMethodFactory;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.service.GoogleWalletService;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealUtils;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardItem;
import com.groupon.view.CreditCardItemBase;
import com.groupon.view.CreditCardItemNew;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class MyCreditCards extends GrouponActivity
{

    public static final int REQUEST_CODE = 10112;
    View addCardButton;
    TextView addCardDisplayName;
    TextView addCardIcon;
    ImageView addCardIconView;
    View addCardIntlContainer;
    LinearLayout addCardsContainer;
    View addCreditCardButton;
    TextView addPaymentCardTypes;
    ViewGroup alipayPaymentContainer;
    ViewGroup auEasyPayContainer;
    TextView bucksValue;
    ViewGroup cardContainer;
    String cartDealImageUrl;
    String cartUUID;
    Channel channel;
    TextView creditCardTypes;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    DealCardCompact dealCardCompact;
    protected List dealCreditCardPaymentMethods;
    String dealId;
    protected List dealNonCreditCardPaymentMethods;
    protected HashMap dealPaymentMethodsNameTypePairs;
    ViewGroup dotpayContainer;
    ViewGroup elvContainer;
    private GoogleWalletService googleWalletService;
    TextView grouponBucksBalance;
    GrouponCheckMark grouponBucksCheckMark;
    View grouponBucksContainer;
    ViewGroup idealContainer;
    private LayoutInflater inflater;
    private IntentFactory intentFactory;
    ViewGroup ipay88Container;
    boolean isCurrencyCodeUSD;
    boolean isGdtDeal;
    boolean isMarketRateDeal;
    boolean isShoppingCartFlow;
    private boolean isUSACompatible;
    ViewGroup isracardContainer;
    Integer itemsCount;
    ProgressBar loadingView;
    private LocalizedSharedPreferencesProvider localizedSharedPreferencesProvider;
    private LoggingUtils loggingUtils;
    ViewGroup maestroContainer;
    ViewGroup mastercardPePaymentContainer;
    String maxCartDiscount;
    TextView newCardHeader;
    Intent next;
    TextView noSavedCard;
    ViewGroup oneClickPaymentContainer;
    String optionId;
    private PaymentMethodFactory paymentMethodFactory;
    private List paymentMethods;
    ViewGroup paypalContainer;
    ViewGroup psePaymentContainer;
    ViewGroup redcompraPaymentContainer;
    View savedCardsContainer;
    TextView savedCardsHeader;
    ViewGroup sepaContainer;
    private StaticSupportInfoService staticSupportInfoService;
    Bundle storageConsentRequirements;
    private List supportedPaymentMethods;
    private UserManager userManager;
    ViewGroup visaPePaymentContainer;
    private VolatileBillingInfoProvider volatileBillingInfoProvider;
    ViewGroup webPayPaymentContainer;

    public MyCreditCards()
    {
        channel = Channel.UNKNOWN;
    }

    private void addCardItem(BillingRecord billingrecord)
    {
        if (!isUSACompatible && cardContainer.getChildCount() > 0)
        {
            inflater.inflate(0x7f0301ae, cardContainer);
        }
        createPaymentItem(cardContainer, billingrecord);
    }

    private void addGoogleWalletItem()
    {
        int i = 0;
        if (!isUSACompatible && cardContainer.getChildCount() > 0)
        {
            inflater.inflate(0x7f0301ae, cardContainer);
        }
        Object obj;
        AbstractPaymentMethod abstractpaymentmethod;
        if (isUSACompatible)
        {
            obj = new CreditCardItemNew(this);
        } else
        {
            obj = new CreditCardItem(this, null, currentCountryManager);
        }
        abstractpaymentmethod = paymentMethodFactory.createGoogleWalletPaymentMethod(null, null, 0, isUsingCredits());
        if (abstractpaymentmethod == null)
        {
            i = 8;
        }
        ((CreditCardItemBase) (obj)).setVisibility(i);
        createPaymentItem(abstractpaymentmethod, ((CreditCardItemBase) (obj)), cardContainer);
        logGoogleWalletImpression();
    }

    private void createPaymentItem(final AbstractPaymentMethod paymentMethod, final CreditCardItemBase cardView, final ViewGroup container)
    {
        if (paymentMethod != null && (Strings.equalsIgnoreCase("volatile", paymentMethod.getId()) || currentCountryManager.getCurrentCountry().isUSACompatible() || !paymentMethod.isNonRecurring()))
        {
            cardView.setCreditCard(paymentMethod);
            String s = paymentMethod.getFromPrefs();
            if (s != null && Strings.equalsIgnoreCase(paymentMethod.getId(), s))
            {
                cardView.setChecked(true);
            }
            container.addView(cardView);
            paymentMethods.add(paymentMethod);
            cardView.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCreditCards this$0;
                final CreditCardItemBase val$cardView;
                final ViewGroup val$container;
                final AbstractPaymentMethod val$paymentMethod;

                public void onClick(View view)
                {
                    paymentMethod.saveToPrefs();
                    if (isUSACompatible)
                    {
                        int i = 0;
                        do
                        {
label0:
                            {
                                if (i < container.getChildCount())
                                {
                                    view = container.getChildAt(i);
                                    if (!(view instanceof CreditCardItemBase))
                                    {
                                        break label0;
                                    }
                                    view = (CreditCardItemBase)view;
                                    if (!view.isChecked())
                                    {
                                        break label0;
                                    }
                                    view.setChecked(false);
                                }
                                ((CreditCardItemNew)cardView).setChecked(true, new AnimatorListenerAdapter() {

                                    final _cls8 this$1;

                                    public void onAnimationEnd(Animator animator)
                                    {
                                        onPaymentClick(paymentMethod);
                                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                                });
                                return;
                            }
                            i++;
                        } while (true);
                    } else
                    {
                        onPaymentClick(paymentMethod);
                        return;
                    }
                }

            
            {
                this$0 = MyCreditCards.this;
                paymentMethod = abstractpaymentmethod;
                container = viewgroup;
                cardView = creditcarditembase;
                super();
            }
            });
        }
    }

    private Map getAvailablePaymentMethods()
    {
        HashMap hashmap = new HashMap(17);
        hashmap.put("dotpay", getPaymentView(0x7f0200c1, 0x7f08013d, 0x7f08014b));
        hashmap.put("ideal", getPaymentView(0x7f0200ce, 0x7f0804e4, 0x7f08014b));
        hashmap.put("elv", getPaymentView(0x7f0200c5, 0x7f080484, 0));
        hashmap.put("sepadirectdebit", getPaymentView(0x7f0200e3, 0x7f08045e, 0));
        hashmap.put("isracard", getPaymentView(0x7f0200d2, 0x7f0804e7, 0));
        hashmap.put("auEasyPay", getPaymentView(0x7f0200c2, 0x7f08044e, 0x7f08014b));
        hashmap.put("ipay88", getPaymentView(0x7f0200cf, 0x7f0804e6, 0x7f08014b));
        hashmap.put("m-oneclick-cl", getPaymentView(0x7f0200eb, 0x7f0802c6, 0x7f08014b));
        hashmap.put("m-debit-cl", getPaymentView(0x7f0200e9, 0x7f08030a, 0x7f08014b));
        hashmap.put("m-webpay-cl", getPaymentView(0x7f0200ea, 0x7f080415, 0x7f08014b));
        hashmap.put("visanet-pe", getPaymentView(0x7f0200e7, 0x7f08047e, 0x7f08014b));
        hashmap.put("mastercard-pe", getPaymentView(0x7f0200da, 0x7f08046e, 0x7f08014b));
        hashmap.put("pse-mobile-co", getPaymentView(0x7f0200e0, 0x7f08050c, 0x7f08014b));
        hashmap.put("alipay", getPaymentView(0x7f0200b2, 0x7f080482, 0x7f08014b));
        String s;
        if (currentCountryManager.getCurrentCountry().acceptsPayment("maestro"))
        {
            s = "maestro";
        } else
        {
            s = "maestrouk";
        }
        hashmap.put(s, getPaymentView(0x7f0200d7, 0x7f080478, 0));
        if (currentCountryManager.getCurrentCountry().acceptsPayment("paypal"))
        {
            s = "paypal";
        } else
        {
            s = "paypal-mx";
        }
        hashmap.put(s, getPaymentView(0x7f0200de, 0x7f080443, 0x7f08014b));
        return hashmap;
    }

    private Map getAvailablePayments()
    {
        HashMap hashmap = new HashMap(17);
        hashmap.put("dotpay", dotpayContainer);
        hashmap.put("ideal", idealContainer);
        hashmap.put("elv", elvContainer);
        hashmap.put("sepadirectdebit", sepaContainer);
        hashmap.put("isracard", isracardContainer);
        if (auEasyPayContainer != null)
        {
            hashmap.put("auEasyPay", auEasyPayContainer);
        }
        hashmap.put("ipay88", ipay88Container);
        hashmap.put("m-oneclick-cl", oneClickPaymentContainer);
        hashmap.put("m-debit-cl", redcompraPaymentContainer);
        hashmap.put("m-webpay-cl", webPayPaymentContainer);
        hashmap.put("visanet-pe", visaPePaymentContainer);
        hashmap.put("mastercard-pe", mastercardPePaymentContainer);
        hashmap.put("pse-mobile-co", psePaymentContainer);
        hashmap.put("alipay", alipayPaymentContainer);
        String s;
        if (currentCountryManager.getCurrentCountry().acceptsPayment("maestro"))
        {
            s = "maestro";
        } else
        {
            s = "maestrouk";
        }
        hashmap.put(s, maestroContainer);
        if (currentCountryManager.getCurrentCountry().acceptsPayment("paypal"))
        {
            s = "paypal";
        } else
        {
            s = "paypal-mx";
        }
        hashmap.put(s, paypalContainer);
        return hashmap;
    }

    private SpannableString getGrouponBucksFormattedText(String s, GenericAmount genericamount)
    {
        String s1 = currencyFormatter.format(genericamount);
        String s2 = String.format(s, new Object[] {
            s1
        });
        s = new SpannableString(s2);
        int i = s2.indexOf(s1);
        int j = s1.length();
        s.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0e0004)), i, i + j, 0);
        if (genericamount.getAmount() == 0)
        {
            s = new SpannableString("");
        }
        return s;
    }

    private String getPaymentName(String s)
    {
        if (Strings.equalsIgnoreCase(s, "amex"))
        {
            return getString(0x7f080472);
        }
        if (currentCountryManager.getCurrentCountry().isBrazil() && Strings.equalsIgnoreCase(s, "mc"))
        {
            return getString(0x7f08046f);
        }
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible() && Strings.equalsIgnoreCase(s, "creditcard"))
        {
            return (new StringBuilder()).append(getString(0x7f08047e)).append(", ").append(getString(0x7f08046e)).toString();
        } else
        {
            return Strings.capitalize(s);
        }
    }

    private CreditCardItemBase getPaymentView(int i, int j, int k)
    {
        CreditCardItemNew creditcarditemnew = new CreditCardItemNew(this);
        creditcarditemnew.setIntlPaymentMethodData(i, j, k);
        return creditcarditemnew;
    }

    private void handleCreditCards(List list)
    {
        boolean flag = false;
        cardContainer.removeAllViews();
        boolean flag1 = currentCountryManager.getCurrentCountry().isUSACompatible();
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        if (!flag1 && volatileBillingInfoProvider.hasCreditCardDetails())
        {
            list = new BillingRecord();
            list.cardType = volatileBillingInfoProvider.getBillingRecordCardType();
            list.cardNumber = volatileBillingInfoProvider.getBillingRecordMaskedCardNumber();
            addCardItem(list);
        } else
        if (i > 0 && (flag1 || Strings.notEmpty(((BillingRecord)list.get(0)).billingRecordId)))
        {
            Ln.d("PAYMENT: %s cards", new Object[] {
                Integer.valueOf(i)
            });
            list = list.iterator();
            while (list.hasNext()) 
            {
                addCardItem((BillingRecord)list.next());
            }
        }
        if (dealId == null || isCurrencyCodeUSD)
        {
            flag = true;
        }
        if (googleWalletService.isGoogleWalletEnabled() && googleWalletService.shouldDisplayGoogleWallet(isGdtDeal, isMarketRateDeal, isShoppingCartFlow, flag))
        {
            addGoogleWalletItem();
        }
        if (!flag1 && newCardHeader != null)
        {
            if (cardContainer.getChildCount() == 0)
            {
                list = getString(0x7f08004e);
            } else
            {
                list = getString(0x7f08031a);
            }
            newCardHeader.setText(list);
        }
    }

    private void handleCredits(GenericAmount genericamount)
    {
label0:
        {
            if (genericamount != null)
            {
                String s = currencyFormatter.format(genericamount);
                Ln.d("PAYMENT: got credits: %s", new Object[] {
                    s
                });
                if (isUSACompatible)
                {
                    byte byte0;
                    if (currentCountryManager.getCurrentCountry().isUSACompatible())
                    {
                        bucksValue.setText(getGrouponBucksFormattedText(getString(0x7f08021d), genericamount));
                    } else
                    {
                        bucksValue.setText(0x7f0803fe);
                        grouponBucksBalance.setText(String.format(getString(0x7f080431), new Object[] {
                            s
                        }));
                    }
                    if (currentCountryManager.getCurrentCountry().isUSACompatible())
                    {
                        byte0 = 8;
                    } else
                    {
                        byte0 = 0;
                    }
                    grouponBucksBalance.setVisibility(byte0);
                    grouponBucksCheckMark.setVisibility(byte0);
                    grouponBucksCheckMark.setUncheckedStateVisibility(true);
                } else
                {
                    String s1;
                    if (currentCountryManager.getCurrentCountry().isUSACompatible())
                    {
                        s1 = getString(0x7f08021d);
                    } else
                    {
                        s1 = getString(0x7f08021c);
                    }
                    bucksValue.setText(getGrouponBucksFormattedText(s1, genericamount));
                }
                if (genericamount.getAmount() == 0 || isMarketRateDeal)
                {
                    break label0;
                }
                grouponBucksContainer.setVisibility(0);
            }
            return;
        }
        bucksValue.setVisibility(0);
    }

    private boolean isCountryWithCreditCards()
    {
        List list = currentCountryManager.getCurrentCountry().getCreditCards();
        return currentCountryManager.getCurrentCountry().isUSACompatible() || list != null && list.size() > 0;
    }

    private boolean isUsingCredits()
    {
        return localizedSharedPreferencesProvider.get().getBoolean("eagerlyApplyRewardPoints", true);
    }

    private void logGoogleWalletImpression()
    {
        String s;
        if (paymentMethods != null)
        {
            s = Strings.toString(Integer.valueOf(paymentMethods.size()));
        } else
        {
            s = "";
        }
        loggingUtils.logGoogleWalletPaymentImpression(channel, s);
    }

    private void onPaymentClick()
    {
        if (next != null)
        {
            getIntent().removeExtra("next");
            startActivity(next);
        } else
        {
            setResult(-1);
        }
        finish();
    }

    private void onPaymentClick(AbstractPaymentMethod abstractpaymentmethod)
    {
        if (!abstractpaymentmethod.isCreditCard())
        {
            abstractpaymentmethod.onClick();
        }
        if (abstractpaymentmethod.getBillingRecord() == null)
        {
            if (abstractpaymentmethod.is3DSecurePayment())
            {
                start3DSecurePayment(abstractpaymentmethod);
            } else
            {
                Intent intent = abstractpaymentmethod.getEditIntent();
                if (intent != null)
                {
                    startActivityForResult(intent.putExtra("next", next), 10102);
                } else
                {
                    onPaymentClick();
                }
            }
        } else
        {
            onPaymentClick();
        }
        if (abstractpaymentmethod instanceof GoogleWalletPaymentMethod)
        {
            loggingUtils.logGoogleWalletPaymentSelectedClick(channel, getClass().getSimpleName());
        }
    }

    private void refresh()
    {
        if (isUSACompatible)
        {
            addCardsContainer.removeAllViews();
        }
        paymentMethods = new ArrayList();
        Map map;
        Iterator iterator;
        if (isUSACompatible)
        {
            map = getAvailablePaymentMethods();
        } else
        {
            map = getAvailablePayments();
        }
        iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            final AbstractPaymentMethod paymentMethod = (String)iterator.next();
            View view;
            int i;
            if (dealNonCreditCardPaymentMethods == null || dealNonCreditCardPaymentMethods.contains(paymentMethod))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            view = (View)map.get(paymentMethod);
            if (i != 0)
            {
                paymentMethod = paymentMethodFactory.createPaymentMethod(paymentMethod);
            } else
            {
                paymentMethod = null;
            }
            if (paymentMethod != null)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
            if (paymentMethod != null)
            {
                paymentMethods.add(paymentMethod);
                if (isUSACompatible)
                {
                    addCardsContainer.addView(view);
                }
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final MyCreditCards this$0;
                    final AbstractPaymentMethod val$paymentMethod;

                    public void onClick(View view1)
                    {
                        onPaymentClick(paymentMethod);
                    }

            
            {
                this$0 = MyCreditCards.this;
                paymentMethod = abstractpaymentmethod;
                super();
            }
                });
            }
        } while (true);
        togglePaymentMethodsVisibility(supportedPaymentMethods);
        if (!isCountryWithCreditCards()) goto _L2; else goto _L1
_L1:
        cardContainer.setVisibility(8);
        addCardButton.setEnabled(false);
        if (isUSACompatible)
        {
            cardContainer.setVisibility(8);
        } else
        {
            savedCardsContainer.setVisibility(8);
        }
        loadingView.setVisibility(0);
_L4:
        grouponBucksContainer.setVisibility(8);
        updateBucksState();
        userManager.getUserData(false, true, new Function1() {

            final MyCreditCards this$0;

            public void execute(UserContainer usercontainer)
            {
                if (usercontainer != null)
                {
                    if (isCountryWithCreditCards())
                    {
                        List list = usercontainer.user.billingRecords;
                        handleCreditCards(list);
                    }
                    usercontainer = usercontainer.user.creditsAvailable;
                    handleCredits(usercontainer);
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((UserContainer)obj);
            }

            
            {
                this$0 = MyCreditCards.this;
                super();
            }
        }, new ReturningFunction1() {

            final MyCreditCards this$0;

            public Boolean execute(Exception exception)
            {
                grouponBucksContainer.setVisibility(8);
                return Boolean.valueOf(false);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = MyCreditCards.this;
                super();
            }
        }, new Function0() {

            final MyCreditCards this$0;

            public void execute()
            {
                byte byte0 = 8;
                if (isCountryWithCreditCards())
                {
                    loadingView.setVisibility(8);
                    addCardButton.setEnabled(true);
                    if (cardContainer.getChildCount() > 0)
                    {
                        byte0 = 0;
                    }
                    cardContainer.setVisibility(byte0);
                    if (!isUSACompatible)
                    {
                        savedCardsContainer.setVisibility(byte0);
                    }
                }
            }

            
            {
                this$0 = MyCreditCards.this;
                super();
            }
        }, null);
        return;
_L2:
        if (newCardHeader != null)
        {
            String s = getString(0x7f08004e);
            newCardHeader.setText(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setAvailablePaymentMethodListsForDeal()
    {
        if (dealPaymentMethodsNameTypePairs != null && dealPaymentMethodsNameTypePairs.size() > 0)
        {
            dealCreditCardPaymentMethods = new ArrayList();
            dealNonCreditCardPaymentMethods = new ArrayList();
            for (Iterator iterator = dealPaymentMethodsNameTypePairs.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                if (Strings.equalsIgnoreCase(dealPaymentMethodsNameTypePairs.get(s), "payment_method_type_credit_card"))
                {
                    dealCreditCardPaymentMethods.add(s);
                } else
                {
                    dealNonCreditCardPaymentMethods.add(s);
                }
            }

        }
    }

    private void setBucksState(boolean flag)
    {
        grouponBucksCheckMark.setChecked(flag, true);
    }

    private void setDealCardCompact(Deal deal)
    {
        dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, optionId));
    }

    private void start3DSecurePayment(AbstractPaymentMethod abstractpaymentmethod)
    {
        startActivityForResult(intentFactory.new3DSecurePaymentIntent(abstractpaymentmethod), 10102);
    }

    private void togglePaymentMethodsVisibility(List list)
    {
        boolean flag2 = false;
        if (currentCountryManager.getCurrentCountry().isJapan() && list != null)
        {
            boolean flag1 = false;
            boolean flag = false;
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                String s = (String)list.next();
                if (Strings.equalsIgnoreCase(s, "creditcard") || Strings.equalsIgnoreCase(s, "american_express") || Strings.equalsIgnoreCase(s, "jcb") || Strings.equalsIgnoreCase(s, "diners"))
                {
                    flag1 = true;
                } else
                if (Strings.equalsIgnoreCase(s, "aueasypay"))
                {
                    flag = true;
                }
            } while (true);
            list = addCardsContainer;
            int j;
            int k;
            if (flag1 || flag)
            {
                k = 0;
            } else
            {
                k = 8;
            }
            list.setVisibility(k);
            list = addCardButton;
            if (flag1)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            list.setVisibility(j);
            if (auEasyPayContainer != null)
            {
                list = auEasyPayContainer;
                int i;
                if (flag)
                {
                    i = ((flag2) ? 1 : 0);
                } else
                {
                    i = 8;
                }
                list.setVisibility(i);
            }
        }
    }

    private void updateBucksState()
    {
        Ln.d("CREDITS: update bucks state, lookup isUsingCredits: %s", new Object[] {
            Boolean.valueOf(isUsingCredits())
        });
        if (isUSACompatible)
        {
            setBucksState(isUsingCredits());
        }
    }

    private void updateViewsAfterDealLoad(Deal deal)
    {
        int i;
        if (itemsCount != null && itemsCount.intValue() > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (isUSACompatible && i == 0 && deal != null)
        {
            setDealCardCompact(deal);
        }
        if (!isUSACompatible)
        {
            if (savedCardsHeader != null)
            {
                savedCardsHeader.setText(getString(0x7f080119));
            }
            newCardHeader.setText(getString(0x7f08031a));
            Object obj;
            Country country;
            if (addCardIcon != null)
            {
                obj = addCardIcon;
                Object obj3;
                int l;
                if (currentCountryManager.getCurrentCountry().isJapan())
                {
                    i = 0x7f020242;
                } else
                {
                    i = 0x7f020142;
                }
                ((TextView) (obj)).setBackgroundResource(i);
            }
            if (addCardDisplayName != null && currentCountryManager.getCurrentCountry().isBrazil())
            {
                addCardDisplayName.setText(getString(0x7f080115));
            }
            country = currentCountryManager.getCurrentCountry();
            obj3 = null;
            obj = obj3;
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                if (dealId == null)
                {
                    if (next != null)
                    {
                        obj = next.getStringExtra("dealId");
                    } else
                    {
                        obj = null;
                    }
                } else
                {
                    obj = dealId;
                }
                dealId = ((String) (obj));
                if (optionId == null)
                {
                    if (next != null)
                    {
                        obj = next.getStringExtra("optionId");
                    } else
                    {
                        obj = null;
                    }
                } else
                {
                    obj = optionId;
                }
                optionId = ((String) (obj));
                if (channel == Channel.UNKNOWN)
                {
                    if (next != null)
                    {
                        obj = (Channel)next.getParcelableExtra("channel");
                    } else
                    {
                        obj = Channel.UNKNOWN;
                    }
                } else
                {
                    obj = channel;
                }
                channel = ((Channel) (obj));
                obj = obj3;
                if (deal != null)
                {
                    deal = deal.getOptions().iterator();
                    do
                    {
                        obj = obj3;
                        if (!deal.hasNext())
                        {
                            break;
                        }
                        obj = (Option)deal.next();
                    } while (!Strings.equals(((Option) (obj)).remoteId, optionId));
                }
            }
            supportedPaymentMethods = new ArrayList();
            if (obj != null)
            {
                deal = ((Option) (obj)).paymentMethods;
            } else
            {
                deal = null;
            }
            if (deal != null)
            {
                deal = deal.split(",");
                l = deal.length;
                for (i = 0; i < l; i++)
                {
                    obj = deal[i];
                    supportedPaymentMethods.add(getPaymentName(((String) (obj))));
                }

            } else
            if (dealCreditCardPaymentMethods != null && dealCreditCardPaymentMethods.size() > 0)
            {
                String s;
                for (deal = dealCreditCardPaymentMethods.iterator(); deal.hasNext(); supportedPaymentMethods.add(getPaymentName(s)))
                {
                    s = (String)deal.next();
                }

            } else
            {
                deal = country.getCreditCards();
                int j;
                int i1;
                if (deal == null)
                {
                    j = 0;
                } else
                {
                    j = deal.size();
                }
                for (i1 = 0; i1 < j; i1++)
                {
                    supportedPaymentMethods.add(getPaymentName(((CreditCard)deal.get(i1)).name));
                }

            }
            int j1 = supportedPaymentMethods.size();
            if (j1 > 0)
            {
                addPaymentCardTypes.setVisibility(0);
                deal = "";
                int k = 0;
                while (k < j1) 
                {
                    String s1 = (String)supportedPaymentMethods.get(k);
                    Object obj1 = deal;
                    if (!Strings.equalsIgnoreCase(s1, "aueasypay"))
                    {
                        obj1 = (new StringBuilder()).append(deal).append(Strings.capitalize(s1));
                        if (k < supportedPaymentMethods.size() - 1)
                        {
                            deal = ", ";
                        } else
                        {
                            deal = "";
                        }
                        obj1 = ((StringBuilder) (obj1)).append(deal).toString();
                    }
                    k++;
                    deal = ((Deal) (obj1));
                }
                Object obj2 = deal;
                if (deal.endsWith(", "))
                {
                    obj2 = deal.substring(0, deal.length() - 2);
                }
                addPaymentCardTypes.setText(((CharSequence) (obj2)));
            }
        }
    }

    protected CreditCardItemBase createPaymentItem(ViewGroup viewgroup, BillingRecord billingrecord)
    {
        AbstractPaymentMethod abstractpaymentmethod = null;
        boolean flag = false;
        Object obj = billingrecord.paymentType;
        int i;
        if (!Strings.notEmpty(obj))
        {
            obj = billingrecord.cardType;
        }
        if (dealPaymentMethodsNameTypePairs == null || dealPaymentMethodsNameTypePairs.containsKey(obj))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (isUSACompatible)
        {
            obj = new CreditCardItemNew(this);
        } else
        {
            obj = new CreditCardItem(this, null, currentCountryManager);
        }
        if (i != 0)
        {
            abstractpaymentmethod = paymentMethodFactory.createPaymentMethod(billingrecord);
        }
        if (abstractpaymentmethod != null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((CreditCardItemBase) (obj)).setVisibility(i);
        createPaymentItem(abstractpaymentmethod, ((CreditCardItemBase) (obj)), viewgroup);
        return ((CreditCardItemBase) (obj));
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f080046));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (10105 == i)
        {
            if (-1 == j)
            {
                refresh();
            }
        } else
        if (10102 == i && -1 == j)
        {
            if (next != null)
            {
                getIntent().removeExtra("next");
                startActivity(next);
                return;
            } else
            {
                refresh();
                return;
            }
        }
    }

    public void onBackPressed()
    {
        Ln.d("PAYMENT: back button", new Object[0]);
        setResult(-1);
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        int i;
        boolean flag;
        boolean flag1;
        if (isUSACompatible)
        {
            i = 0x7f03016c;
        } else
        {
            i = 0x7f03016b;
        }
        setContentView(i);
        if (itemsCount != null && itemsCount.intValue() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (dealId != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (dealCardCompact != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setAvailablePaymentMethodListsForDeal();
        if (i != 0)
        {
            TextView textview;
            if (isUSACompatible)
            {
                if (flag1)
                {
                    dealCardCompact.setShoppingCartInfo(itemsCount.intValue(), maxCartDiscount, cartDealImageUrl);
                } else
                {
                    dealCardCompact.setLoading(true);
                }
            }
            getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(dealId, flag1) {

                final MyCreditCards this$0;
                final boolean val$isCartExperience;

                public void onDealLoaded(Deal deal)
                {
                    updateViewsAfterDealLoad(deal);
                }

                public void onLoadFinished(Loader loader, Deal deal)
                {
                    boolean flag2 = false;
                    super.onLoadFinished(loader, deal);
                    if (isUSACompatible)
                    {
                        dealCardCompact.setLoading(false);
                        loader = dealCardCompact;
                        int j = ((flag2) ? 1 : 0);
                        if (deal == null)
                        {
                            if (isCartExperience)
                            {
                                j = ((flag2) ? 1 : 0);
                            } else
                            {
                                j = 8;
                            }
                        }
                        loader.setVisibility(j);
                    }
                }

                public volatile void onLoadFinished(Loader loader, Object obj)
                {
                    onLoadFinished(loader, (Deal)obj);
                }

            
            {
                this$0 = MyCreditCards.this;
                isCartExperience = flag;
                super(final_context, s);
            }
            });
        } else
        if (flag)
        {
            dealCardCompact.setVisibility(8);
            updateViewsAfterDealLoad(null);
        }
        if (savedCardsHeader != null)
        {
            bundle = Strings.toString(savedCardsHeader.getText());
            savedCardsHeader.setText(bundle);
        }
        bundle = Strings.toString(newCardHeader.getText());
        if (dealCreditCardPaymentMethods == null || dealCreditCardPaymentMethods.size() > 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        newCardHeader.setText(bundle);
        if (isCountryWithCreditCards() && i != 0)
        {
            addCardButton.setVisibility(0);
            if (addCardIcon != null)
            {
                bundle = addCardIcon;
                if (currentCountryManager.getCurrentCountry().isJapan())
                {
                    i = 0x7f020242;
                } else
                {
                    i = 0x7f020142;
                }
                bundle.setBackgroundResource(i);
            }
            if (addCardDisplayName != null && currentCountryManager.getCurrentCountry().isBrazil())
            {
                addCardDisplayName.setText(getString(0x7f080115));
            }
            addCardButton.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCreditCards this$0;

                public void onClick(View view)
                {
                    startActivityForResult(intentFactory.newEditCreditCardIntent(dealId, cartUUID, dealCreditCardPaymentMethods, channel, storageConsentRequirements), 10102);
                }

            
            {
                this$0 = MyCreditCards.this;
                super();
            }
            });
        } else
        {
            noSavedCard.setVisibility(8);
            addCardButton.setVisibility(8);
        }
        grouponBucksContainer.setFocusable(false);
        grouponBucksContainer.setFocusableInTouchMode(false);
        if (addCreditCardButton != null && creditCardTypes != null)
        {
            bundle = addCardsContainer;
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                i = 8;
            } else
            {
                i = 0;
            }
            bundle.setVisibility(i);
            bundle = addCreditCardButton;
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                i = 0;
            } else
            {
                i = 8;
            }
            bundle.setVisibility(i);
            addCreditCardButton.setOnClickListener(new android.view.View.OnClickListener() {

                final MyCreditCards this$0;

                public void onClick(View view)
                {
                    startActivityForResult(intentFactory.newEditCreditCardIntent(dealId, cartUUID, null, channel, storageConsentRequirements), 10102);
                }

            
            {
                this$0 = MyCreditCards.this;
                super();
            }
            });
            bundle = staticSupportInfoService.getSupportInfo(currentCountryManager.getCurrentCountry()).acceptedCreditCards;
            creditCardTypes.setText(bundle);
            textview = creditCardTypes;
            if (Strings.notEmpty(bundle))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            textview.setVisibility(i);
        }
        refresh();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        refresh();
    }







}
