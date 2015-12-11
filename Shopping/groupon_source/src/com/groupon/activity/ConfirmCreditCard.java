// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.ViewUtils;
import com.groupon.view.CreditCardIconHelper;
import com.groupon.view.PatternTextWatcher;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class ConfirmCreditCard extends GrouponActivity
    implements GrouponDialogListener
{
    private class CreditCardDialogTextWatcher
        implements TextWatcher
    {

        private PatternTextWatcher patternTextWatcher;
        final ConfirmCreditCard this$0;

        public void afterTextChanged(Editable editable)
        {
            patternTextWatcher.afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            patternTextWatcher.beforeTextChanged(charsequence, i, j, k);
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            if ("errorOn".equals(creditCardError.getTag()))
            {
                hideErrorOnDialog();
            }
            patternTextWatcher.onTextChanged(charsequence, i, j, k);
        }

        public CreditCardDialogTextWatcher(String s, String s1)
        {
            this$0 = ConfirmCreditCard.this;
            super();
            patternTextWatcher = new PatternTextWatcher(s, s1);
        }
    }


    private static final String CONFIRM_CREDIT_CARD_DIALOG = "confirm_credit_card_dialog";
    public static final String CREDIT_CARD_VALIDATION_FAILED = "failed";
    public static final int REQUEST_CODE = 1;
    public static final int RESULT_CANCELED = -1;
    public static final int RESULT_OK = 0;
    final String AMEX_CARD_PATTERN = "    -      - ";
    final String AMEX_CARD_TYPE = "american_express";
    final String AMEX_FINAL_VALIDATION = "(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)";
    final String NON_AMEX_FINAL_VALIDATION = "(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)";
    final String NON_AMEX_PATTERN = "    -    -    ";
    ImageView cardIcon;
    EditText cardNumberInputDigits;
    TextView cardNumberLastFourDigits;
    String cardValidationFailedError;
    TextView creditCardError;
    TextView creditCardInstructions;
    String creditCardLastDigits;
    String creditCardType;
    String creditCardValidationState;
    String dealId;
    private LayoutInflater inflater;
    String invalidInputLengthError;
    boolean isShippingAddressRequired;
    private Logger logger;

    public ConfirmCreditCard()
    {
    }

    private void addEditTextFormatting()
    {
        String s;
        String s1;
        StringBuilder stringbuilder;
        if ("american_express".equals(creditCardType))
        {
            s1 = "    -      - ";
            s = "(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)";
        } else
        {
            s1 = "    -    -    ";
            s = "(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)-(\\s|\\d)(\\s|\\d)(\\s|\\d)(\\s|\\d)";
        }
        stringbuilder = new StringBuilder();
        for (int i = 0; i < s1.length(); i++)
        {
            char c1 = s1.charAt(i);
            char c = c1;
            if (c1 == ' ')
            {
                c = '\u2007';
            }
            stringbuilder.append(c);
        }

        s1 = stringbuilder.toString();
        cardNumberInputDigits.setText(s1);
        cardNumberInputDigits.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ConfirmCreditCard this$0;

            public boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
            {
                return true;
            }

            
            {
                this$0 = ConfirmCreditCard.this;
                super();
            }
        });
        cardNumberInputDigits.requestFocus();
        cardNumberInputDigits.setSelection(0);
        cardNumberInputDigits.setRawInputType(2);
        cardNumberInputDigits.addTextChangedListener(new CreditCardDialogTextWatcher(s1, s));
    }

    private void hideErrorOnDialog()
    {
        creditCardError.setVisibility(8);
        cardNumberInputDigits.setBackgroundResource(0x7f0200ec);
        creditCardError.setTag(null);
    }

    private void hideKeyboard()
    {
        ViewUtils.forceShowKeyboard(this, false);
    }

    private void onDismiss()
    {
        logger.logClick("", "reenter_cc_cancel_click", "purchase_flow", dealId);
        setResult(-1, new Intent());
        finish();
    }

    private View setupCustomView()
    {
        View view = inflater.inflate(0x7f030069, null);
        cardNumberInputDigits = (EditText)view.findViewById(0x7f1001af);
        cardNumberLastFourDigits = (TextView)view.findViewById(0x7f1001b0);
        creditCardError = (TextView)view.findViewById(0x7f1001b1);
        cardIcon = (ImageView)view.findViewById(0x7f1001ad);
        if (!isShippingAddressRequired)
        {
            creditCardInstructions = (TextView)view.findViewById(0x7f1001ac);
            creditCardInstructions.setText(0x7f0800a6);
        }
        com.groupon.view.CreditCardIconHelper.CreditCardIconData creditcardicondata = CreditCardIconHelper.getCreditCardIconData(creditCardType);
        if (creditcardicondata != null && creditcardicondata.paymentIcon > 0)
        {
            cardIcon.setImageResource(creditcardicondata.paymentIcon);
        }
        addEditTextFormatting();
        cardNumberInputDigits.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ConfirmCreditCard this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 6)
                {
                    hideKeyboard();
                }
                return false;
            }

            
            {
                this$0 = ConfirmCreditCard.this;
                super();
            }
        });
        cardNumberLastFourDigits.setText(creditCardLastDigits);
        if ("failed".equals(creditCardValidationState))
        {
            showErrorOnDialog(cardValidationFailedError);
        }
        return view;
    }

    private void showErrorOnDialog(String s)
    {
        cardNumberInputDigits.requestFocus();
        creditCardError.setText(s);
        creditCardError.setVisibility(0);
        cardNumberInputDigits.setBackgroundResource(0x7f0200ed);
        creditCardError.setTag("errorOn");
    }

    private void showKeyboard()
    {
        ViewUtils.forceShowKeyboard(this, true);
    }

    private boolean valid()
    {
        Object obj;
        boolean flag;
        flag = true;
        obj = cardNumberInputDigits.getText();
        if (obj != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        obj = obj.toString().replaceAll("-", "").replaceAll("\\s", "");
        if (!"american_express".equals(creditCardType))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).length() == 11) goto _L4; else goto _L3
_L3:
        return false;
        if (((String) (obj)).length() == 12) goto _L4; else goto _L5
_L5:
        return false;
    }

    public void onConfirmClicked(DialogInterface dialoginterface)
    {
        logger.logClick("", "reenter_cc_confirm_click", "purchase_flow", dealId);
        if (!valid())
        {
            showErrorOnDialog(invalidInputLengthError);
            return;
        } else
        {
            dialoginterface.dismiss();
            dialoginterface = String.format("%s%s", new Object[] {
                cardNumberInputDigits.getText().toString().replaceAll("-", "").trim(), cardNumberLastFourDigits.getText().toString()
            });
            setResult(0, (new Intent()).putExtra("validationCardNumber", dialoginterface));
            hideKeyboard();
            finish();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new GrouponDialogFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("dialog_positive_button_text_res_id", 0x7f0800be);
        int i;
        if (isShippingAddressRequired)
        {
            i = 0x7f0800a9;
        } else
        {
            i = 0x7f0800a7;
        }
        bundle1.putInt("dialog_title_res_id", i);
        bundle1.putBoolean("dialog_positive_button_auto_dismiss", false);
        bundle.setArguments(bundle1);
        bundle.setCustomView(setupCustomView());
        GrouponDialogFragment.show(getFragmentManager(), bundle, "confirm_credit_card_dialog");
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "confirm_credit_card_dialog"))
        {
            onDismiss();
        }
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "confirm_credit_card_dialog"))
        {
            onConfirmClicked(dialoginterface);
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
        showKeyboard();
    }


}
