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
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.animation.DropDownAnimation;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.models.GenericAmount;
import com.groupon.models.country.Country;
import com.groupon.models.gift.GiftCode;
import com.groupon.models.user.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.GiftCodesService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealUtils;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.ReturningFunction1;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;
import com.groupon.view.SpinnerButton;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class GiftCodes extends GrouponActivity
{

    public static final int GIFTCODE_LENGTH_WITH_SPACES = 14;
    private static final int GIFT_CODE_LENGTH_JAPAN = 12;
    public static final int LENGTH_ADD_FIRST_SPACE = 5;
    public static final int LENGTH_ADD_SECOND_SPACE = 10;
    public static final int LENTGH_STOP_ADDING = 15;
    public static final int REQUEST_CODE = 10105;
    private static final String USE_GIFT_CARD = "use_gift_card";
    Button cancelButton;
    String cartDealImageUrl;
    Channel channel;
    EditText code;
    View codeContainer;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    DealCardCompact dealCardCompact;
    String dealId;
    private DialogManager dialogManager;
    String errorInvalidCode;
    String errorInvalidCodeGeneric;
    String errorInvalidPin;
    GrouponCheckMark giftCardCheckMark;
    View giftCardCheckMarkContainer;
    View giftCardContainer;
    EditText giftCardNumber;
    String giftCardNumberInvalid;
    private GiftCodesService giftCodesService;
    private boolean isUSACompatible;
    Integer itemsCount;
    String maxCartDiscount;
    String optionId;
    EditText pin;
    View pinContainer;
    private int pinHeight;
    TextView secureConnectionView;
    SpinnerButton submitButton;
    private boolean useGiftCard;

    public GiftCodes()
    {
        pinHeight = 0;
    }

    private void addGiftCode(String s)
    {
        String s1;
        if (isPinRequired() && pin != null)
        {
            s1 = Strings.toString(pin.getText());
        } else
        {
            s1 = null;
        }
        submitButton.startSpinning();
        giftCodesService.addGiftCode(s, s1, new Function1() {

            final GiftCodes this$0;

            public void execute(UserContainer usercontainer)
            {
                User user = usercontainer.user;
                boolean flag = currentCountryManager.getCurrentCountry().isJapan();
                Object obj;
                if (flag)
                {
                    obj = user.gift_code.point;
                } else
                {
                    obj = user.creditsAvailable;
                }
                Ln.d("CODES: new gift code success, now has %d credits", new Object[] {
                    Integer.valueOf(((GenericAmount) (obj)).getAmount())
                });
                obj = getString(0x7f08004b, new Object[] {
                    currencyFormatter.format(obj)
                });
                usercontainer = usercontainer.multiUsePromoCode;
                if (Strings.notEmpty(usercontainer))
                {
                    obj = new Intent();
                    setResult(-1, ((Intent) (obj)).putExtra("multi_use_promo_code", usercontainer));
                } else
                if (flag)
                {
                    showMessage(((String) (obj)));
                    usercontainer = new Intent();
                    setResult(-1, usercontainer.putExtra("gift_code", user.gift_code));
                } else
                {
                    showMessage(((String) (obj)));
                    setResult(-1);
                }
                finish();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((UserContainer)obj);
            }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
        }, new ReturningFunction1() {

            final GiftCodes this$0;

            public Boolean execute(Exception exception)
            {
                Ln.d("CODES: exception", new Object[0]);
                return Boolean.valueOf(true);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
        }, new Function0() {

            final GiftCodes this$0;

            public void execute()
            {
                submitButton.stopSpinning();
            }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
        });
    }

    private boolean isPinRequired()
    {
        int i = 0;
        if (currentCountryManager.getCurrentCountry().isUSACompatible()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        Object obj;
        int j;
        boolean flag1;
        if (giftCardCheckMark == null || !giftCardCheckMark.isChecked())
        {
            obj = code.getText().toString();
        } else
        {
            obj = giftCardNumber.getText().toString();
        }
        flag1 = false;
        flag = flag1;
        if (!Strings.notEmpty(obj))
        {
            continue;
        }
        flag = flag1;
        if (((String) (obj)).length() != 16)
        {
            continue;
        }
        flag1 = true;
        obj = ((String) (obj)).toCharArray();
        j = obj.length;
        do
        {
            flag = flag1;
            if (i >= j)
            {
                continue;
            }
            if (!Character.isDigit(obj[i]))
            {
                return false;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setDealCardCompact()
    {
        boolean flag;
label0:
        {
            if (isUSACompatible)
            {
                if (itemsCount != null && itemsCount.intValue() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                dealCardCompact.setShoppingCartInfo(itemsCount.intValue(), maxCartDiscount, cartDealImageUrl);
            }
            return;
        }
        dealCardCompact.setLoading(true);
        getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(dealId, flag) {

            final GiftCodes this$0;
            final boolean val$isCartExperience;

            public void onDealLoaded(Deal deal)
            {
                dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, optionId));
            }

            public void onLoadFinished(Loader loader, Deal deal)
            {
                boolean flag1 = false;
                super.onLoadFinished(loader, deal);
                dealCardCompact.setLoading(false);
                loader = dealCardCompact;
                int i = ((flag1) ? 1 : 0);
                if (deal == null)
                {
                    if (isCartExperience)
                    {
                        i = ((flag1) ? 1 : 0);
                    } else
                    {
                        i = 8;
                    }
                }
                loader.setVisibility(i);
            }

            public volatile void onLoadFinished(Loader loader, Object obj)
            {
                onLoadFinished(loader, (Deal)obj);
            }

            
            {
                this$0 = GiftCodes.this;
                isCartExperience = flag;
                super(final_context, s);
            }
        });
    }

    private void showInvalidGiftCodeDialog(String s)
    {
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(null, s, Integer.valueOf(0x104000a)), "generic_error_dialog");
    }

    private void showMessage(String s)
    {
        Toast.makeText(getApplicationContext(), s, 1).show();
    }

    private void startOver()
    {
        code.setText("");
        pin.setText("");
    }

    private void updatePinState()
    {
        int i = 0;
        if (!isUSACompatible)
        {
            if (pinHeight == 0)
            {
                pinContainer.measure(1000, 1000);
                pinHeight = pinContainer.getMeasuredHeight();
                pinContainer.getLayoutParams().height = 0;
                pinContainer.requestLayout();
            }
            View view = pinContainer;
            View view1 = pinContainer;
            if (isPinRequired())
            {
                i = pinHeight;
            }
            view.startAnimation(new DropDownAnimation(view1, i, 250));
        }
    }

    private boolean validateInput(String s)
    {
        boolean flag1 = true;
        boolean flag;
        if (giftCardCheckMark == null || !giftCardCheckMark.isChecked())
        {
            if (currentCountryManager.getCurrentCountry().isJapan() && code.getText().length() == 14)
            {
                s = s.replaceAll("\\s", "");
            }
            flag = flag1;
            if (!giftCodesService.isGiftCodeValid(s))
            {
                if (currentCountryManager.getCurrentCountry().isJapan())
                {
                    s = String.format(errorInvalidCode, new Object[] {
                        Integer.valueOf(12)
                    });
                } else
                {
                    s = errorInvalidCodeGeneric;
                }
                showInvalidGiftCodeDialog(s);
                flag = false;
            }
        } else
        {
            if (s.length() == 0)
            {
                showInvalidGiftCodeDialog(giftCardNumberInvalid);
                return false;
            }
            if (isPinRequired() && pin != null)
            {
                s = Strings.toString(pin.getText());
            } else
            {
                s = null;
            }
            flag = flag1;
            if (isPinRequired())
            {
                flag = flag1;
                if (!giftCodesService.validatePin(s))
                {
                    showInvalidGiftCodeDialog(errorInvalidPin);
                    return false;
                }
            }
        }
        return flag;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        if (isUSACompatible)
        {
            setToolbarTitle(getString(0x7f080148));
        }
    }

    public void onCreate(Bundle bundle)
    {
        float f1 = 1.0F;
        super.onCreate(bundle);
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        int i;
        if (isUSACompatible)
        {
            i = 0x7f0300fc;
        } else
        {
            i = 0x7f0300fb;
        }
        setContentView(i);
        if (isUSACompatible)
        {
            getWindow().setSoftInputMode(2);
            submitButton.setText(0x7f08033e);
            secureConnectionView.setVisibility(0);
            boolean flag;
            if (bundle != null && bundle.getBoolean("use_gift_card"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            useGiftCard = flag;
        }
        setDealCardCompact();
        submitButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GiftCodes this$0;

            public void onClick(View view)
            {
                if (giftCardCheckMark != null && giftCardCheckMark.isChecked())
                {
                    view = giftCardNumber.getText();
                } else
                {
                    view = code.getText();
                }
                view = Strings.toString(view);
                if (!validateInput(view))
                {
                    return;
                } else
                {
                    addGiftCode(view);
                    return;
                }
            }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
        });
        if (cancelButton != null)
        {
            cancelButton.setOnClickListener(new android.view.View.OnClickListener() {

                final GiftCodes this$0;

                public void onClick(View view)
                {
                    finish();
                }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
            });
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && giftCardCheckMark != null)
        {
            bundle = codeContainer;
            float f;
            if (useGiftCard)
            {
                f = 0.0F;
            } else
            {
                f = 1.0F;
            }
            bundle.setAlpha(f);
            bundle = giftCardContainer;
            if (useGiftCard)
            {
                f = 1.0F;
            } else
            {
                f = 0.0F;
            }
            bundle.setAlpha(f);
            bundle = pinContainer;
            if (useGiftCard)
            {
                f = f1;
            } else
            {
                f = 0.0F;
            }
            bundle.setScaleY(f);
            pinContainer.setPivotY(0.0F);
            bundle = giftCardContainer;
            if (useGiftCard)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            bundle.setVisibility(i);
            giftCardCheckMark.setUncheckedStateVisibility(true);
            giftCardCheckMark.setChecked(useGiftCard);
            giftCardCheckMark.setOnCheckedChangeListener(new com.groupon.view.GrouponCheckMark.OnCheckedChangeListener() {

                final GiftCodes this$0;

                public void onCheckedChanged(View view, boolean flag1)
                {
                    float f4 = 1.0F;
                    float f2;
                    float f3;
                    if (flag1)
                    {
                        f2 = 0.0F;
                    } else
                    {
                        f2 = 1.0F;
                    }
                    if (flag1)
                    {
                        f3 = 1.0F;
                    } else
                    {
                        f3 = 0.0F;
                    }
                    if (!flag1)
                    {
                        codeContainer.setVisibility(0);
                    }
                    if (flag1)
                    {
                        giftCardContainer.setVisibility(0);
                    }
                    codeContainer.animate().setDuration(200L).alpha(f2).setInterpolator(new DecelerateInterpolator()).setListener(flag1. new AnimatorListenerAdapter() {

                        final _cls3 this$1;
                        final boolean val$isChecked;

                        public void onAnimationEnd(Animator animator)
                        {
                            animator = codeContainer;
                            byte byte0;
                            if (isChecked)
                            {
                                byte0 = 8;
                            } else
                            {
                                byte0 = 0;
                            }
                            animator.setVisibility(byte0);
                        }

            
            {
                this$1 = final__pcls3;
                isChecked = Z.this;
                super();
            }
                    });
                    giftCardContainer.animate().setDuration(200L).alpha(f3).setInterpolator(new DecelerateInterpolator()).setListener(flag1. new AnimatorListenerAdapter() {

                        final _cls3 this$1;
                        final boolean val$isChecked;

                        public void onAnimationEnd(Animator animator)
                        {
                            animator = giftCardContainer;
                            int i;
                            if (isChecked)
                            {
                                i = 0;
                            } else
                            {
                                i = 8;
                            }
                            animator.setVisibility(i);
                        }

            
            {
                this$1 = final__pcls3;
                isChecked = Z.this;
                super();
            }
                    });
                    if (flag1)
                    {
                        f2 = f4;
                    } else
                    {
                        f2 = 0.0F;
                    }
                    pinContainer.animate().setDuration(200L).scaleY(f2).setInterpolator(new DecelerateInterpolator());
                    if (flag1)
                    {
                        giftCardNumber.requestFocus();
                        return;
                    } else
                    {
                        code.requestFocus();
                        return;
                    }
                }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
            });
            if (giftCardCheckMarkContainer != null)
            {
                giftCardCheckMarkContainer.setVisibility(0);
                giftCardCheckMarkContainer.setOnClickListener(new android.view.View.OnClickListener() {

                    final GiftCodes this$0;

                    public void onClick(View view)
                    {
                        giftCardCheckMark.toggle();
                    }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
                });
            }
        }
        code.addTextChangedListener(new TextWatcher() {

            final GiftCodes this$0;

            public void afterTextChanged(Editable editable)
            {
                updatePinState();
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                if (k != 0 || !currentCountryManager.getCurrentCountry().isJapan()) goto _L2; else goto _L1
_L1:
                charsequence = code.getText();
                j = charsequence.length();
                j;
                JVM INSTR lookupswitch 3: default 72
            //                           5: 73
            //                           10: 108
            //                           15: 143;
                   goto _L2 _L3 _L4 _L5
_L2:
                return;
_L3:
                code.setText(charsequence.insert(j - 1, " "));
                code.setSelection(j + 1);
                return;
_L4:
                code.setText(charsequence.insert(j - 1, " "));
                code.setSelection(j + 1);
                return;
_L5:
                code.setText(charsequence.delete(j - 1, j));
                code.setSelection(j - 1);
                return;
            }

            
            {
                this$0 = GiftCodes.this;
                super();
            }
        });
        startOver();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (isUSACompatible)
        {
            bundle.putBoolean("use_gift_card", giftCardCheckMark.isChecked());
        }
    }






}
