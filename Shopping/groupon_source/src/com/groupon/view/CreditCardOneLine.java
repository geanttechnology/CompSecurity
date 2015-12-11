// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class CreditCardOneLine extends RelativeLayout
    implements TextWatcher, android.view.View.OnFocusChangeListener, android.view.View.OnTouchListener
{
    public static final class CreditCardState extends Enum
    {

        private static final CreditCardState $VALUES[];
        public static final CreditCardState CREDIT_CARD_NUMBER_EDIT;
        public static final CreditCardState CREDIT_CARD_OTHER_EDIT;

        public static CreditCardState valueOf(String s)
        {
            return (CreditCardState)Enum.valueOf(com/groupon/view/CreditCardOneLine$CreditCardState, s);
        }

        public static CreditCardState[] values()
        {
            return (CreditCardState[])$VALUES.clone();
        }

        static 
        {
            CREDIT_CARD_NUMBER_EDIT = new CreditCardState("CREDIT_CARD_NUMBER_EDIT", 0);
            CREDIT_CARD_OTHER_EDIT = new CreditCardState("CREDIT_CARD_OTHER_EDIT", 1);
            $VALUES = (new CreditCardState[] {
                CREDIT_CARD_NUMBER_EDIT, CREDIT_CARD_OTHER_EDIT
            });
        }

        private CreditCardState(String s, int i)
        {
            super(s, i);
        }
    }

    protected static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        protected String ccNumber;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(ccNumber);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            ccNumber = parcel.readString();
        }


        protected SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    public static final String AMERICAN_EXPRESS_CC_PREFIX_34 = "34";
    public static final String AMERICAN_EXPRESS_CC_PREFIX_37 = "37";
    public static final int YEARS_AHEAD = 15;
    private ImageView creditCardIcon;
    private EditText creditCardNumberView;
    public LinearLayout creditCardOneLineLayout;
    private EditText creditCardPlaceholder;
    private CurrentCountryManager currentCountryManager;
    private EditText cvvView;
    DogfoodHelper dogfoodHelper;
    private EditText expirationMonthView;
    private EditText expirationYearView;
    private String previousCC;
    private ArrayList yearsArray;

    public CreditCardOneLine(Context context)
    {
        this(context, null);
    }

    public CreditCardOneLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        yearsArray = new ArrayList();
        inflate(context, 0x7f0300b4, this);
        initializeView();
    }

    private String formatCardNumber(String s)
    {
        if (Strings.isEmpty(s))
        {
            return "";
        }
        s = getUnFormattedCreditCard(s);
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (i != 0 && i % 4 == 0)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append(s.charAt(i));
        }

        return stringbuilder.toString();
    }

    private void handleCreditCardMonthChanged(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!Strings.notEmpty(s) || s.length() >= 3) goto _L2; else goto _L1
_L1:
        char c;
        char c1;
        c1 = s.charAt(0);
        if (s.length() > 1)
        {
            c = s.charAt(1);
        } else
        {
            c = '\0';
        }
        if (c1 != '0') goto _L4; else goto _L3
_L3:
        stringbuilder.append(c1);
        if (c >= '1' && c <= '9')
        {
            stringbuilder.append(c);
        }
_L8:
        setText(expirationMonthView, stringbuilder.toString(), false);
        if (expirationMonthView.getText().length() >= 2)
        {
            focusView(expirationYearView, true);
        }
        if (Strings.isEmpty(stringbuilder.toString()))
        {
            expirationMonthView.setGravity(19);
        }
_L6:
        return;
_L4:
        if (c1 == '1')
        {
            stringbuilder.append(c1);
            if (c >= '0' && c <= '2')
            {
                stringbuilder.append(c);
            }
        } else
        {
            stringbuilder.append(0).append(c1);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!Strings.notEmpty(s) || expirationMonthView.getSelectionEnd() != expirationMonthView.getText().length()) goto _L6; else goto _L5
_L5:
        focusView(expirationYearView, false);
        setText(expirationMonthView, s.substring(0, 2), false);
        if (Strings.isEmpty(expirationYearView.getText().toString()))
        {
            expirationYearView.setText(Character.toString(s.charAt(s.length() - 1)));
            return;
        }
        expirationYearView.setSelection(expirationYearView.getText().length());
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void handleCreditCardNumberChanged(String s)
    {
        String s1;
        int j;
label0:
        {
            if (s.length() < 2 && currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                updateCardIcon(s);
            }
            if (Strings.notEmpty(s))
            {
                s1 = formatCardNumber(s);
                boolean flag;
                if (previousCC != null)
                {
                    if (previousCC.length() >= getUnFormattedCreditCard(s).length())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return;
        }
        if (getUnFormattedCreditCard(s).length() >= getCreditCardSize())
        {
            previousCC = "";
            setText(creditCardNumberView, s1, false, s1.length());
            s = expirationMonthView;
            byte byte0;
            if (expirationMonthView.getText().length() == 0)
            {
                byte0 = 19;
            } else
            {
                byte0 = 21;
            }
            s.setGravity(byte0);
            focusView(expirationMonthView, true);
            return;
        }
        if (Strings.isEmpty(previousCC))
        {
            previousCC = s;
        }
        s = creditCardNumberView.getText().toString();
        j = creditCardNumberView.getSelectionStart();
        if (j <= 0 || j > s1.length() || s1.charAt(j - 1) != ' ') goto _L2; else goto _L1
_L1:
        int i = j + 1;
_L4:
        EditText edittext = creditCardNumberView;
        j = i;
        if (i == s.length())
        {
            j = s.length();
        }
        setText(edittext, s1, false, j);
        return;
_L2:
        i = j;
        if (s.endsWith(" "))
        {
            i = j - 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void handleCreditCardYearChanged(String s)
    {
        if (!Strings.notEmpty(s)) goto _L2; else goto _L1
_L1:
        char c;
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        c = s.charAt(0);
        if (s.length() != 1) goto _L4; else goto _L3
_L3:
label0:
        {
            s = yearsArray.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break label0;
                }
            } while (c != getYearLastTwoDigits((String)s.next()).charAt(0));
            stringbuilder.append(c);
        }
_L5:
        setText(expirationYearView, stringbuilder.toString(), false);
        if (expirationYearView.getText().length() >= 2 && isExpirationMonthValid())
        {
            focusView(cvvView, true);
        }
        return;
_L4:
        if (isExpirationYearValid())
        {
            s = Integer.valueOf(s.trim());
        } else
        {
            s = String.valueOf(c);
        }
        stringbuilder.append(s);
        if (true) goto _L5; else goto _L2
_L2:
        focusView(expirationMonthView, true);
        return;
    }

    public void afterTextChanged(Editable editable)
    {
        if (getCurrentFocus() == null) goto _L2; else goto _L1
_L1:
        getCurrentFocus().getId();
        JVM INSTR tableswitch 2131755518 2131755521: default 44
    //                   2131755518 45
    //                   2131755519 54
    //                   2131755520 44
    //                   2131755521 63;
           goto _L2 _L3 _L4 _L2 _L5
_L2:
        return;
_L3:
        handleCreditCardNumberChanged(editable.toString());
        return;
_L4:
        handleCreditCardMonthChanged(editable.toString());
        return;
_L5:
        handleCreditCardYearChanged(editable.toString());
        return;
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (getCurrentFocus() != null && getCurrentFocus().getId() == 0x7f1001fe)
        {
            previousCC = getUnFormattedCreditCard(charsequence.toString());
        }
    }

    protected void changeState(CreditCardState creditcardstate)
    {
        if (creditcardstate.equals(CreditCardState.CREDIT_CARD_NUMBER_EDIT))
        {
            creditCardNumberView.setVisibility(0);
            creditCardPlaceholder.setVisibility(8);
            cvvView.setVisibility(8);
        } else
        if (creditcardstate.equals(CreditCardState.CREDIT_CARD_OTHER_EDIT))
        {
            creditCardNumberView.setVisibility(8);
            creditcardstate = getUnFormattedCreditCard(creditCardNumberView.getText().toString());
            EditText edittext = creditCardPlaceholder;
            if (creditcardstate.length() > 4)
            {
                creditcardstate = creditcardstate.substring(creditcardstate.length() - 4, creditcardstate.length());
            } else
            {
                creditcardstate = creditCardNumberView.getText().toString();
            }
            edittext.setText(creditcardstate);
            creditCardPlaceholder.setVisibility(0);
            cvvView.setVisibility(0);
            return;
        }
    }

    protected void focusView(View view, boolean flag)
    {
        view.requestFocus();
        InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
        if (flag)
        {
            inputmethodmanager.showSoftInput(view, 1);
            return;
        } else
        {
            inputmethodmanager.hideSoftInputFromInputMethod(view.getWindowToken(), 0);
            return;
        }
    }

    public String getCardNumber()
    {
        return getUnFormattedCreditCard(creditCardNumberView.getText().toString());
    }

    public EditText getCreditCardNumberView()
    {
        return creditCardNumberView;
    }

    protected int getCreditCardSize()
    {
        String s = creditCardNumberView.getText().toString();
        return !Strings.notEmpty(s) || s.length() < 2 || !s.startsWith("34") && !s.startsWith("37") ? 16 : 15;
    }

    protected View getCurrentFocus()
    {
        return ((Activity)getContext()).getCurrentFocus();
    }

    public String getCvv()
    {
        return cvvView.getText().toString();
    }

    public EditText getCvvView()
    {
        return cvvView;
    }

    public int getExpirationMonth()
    {
        return Integer.parseInt(expirationMonthView.getText().toString());
    }

    public EditText getExpirationMonthView()
    {
        return expirationMonthView;
    }

    public int getExpirationYear()
    {
        String s = expirationYearView.getText().toString();
        for (Iterator iterator = yearsArray.iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (Strings.equalsIgnoreCase(getYearLastTwoDigits(s1), s))
            {
                return Integer.parseInt(s1);
            }
        }

        return Calendar.getInstance().get(1);
    }

    public EditText getExpirationYearView()
    {
        return expirationYearView;
    }

    protected String getUnFormattedCreditCard(String s)
    {
        return s.trim().replace(" ", "");
    }

    protected String getYearLastTwoDigits(String s)
    {
        s = s.trim();
        if (Strings.notEmpty(s))
        {
            return s.substring(s.length() - 2, s.length());
        } else
        {
            return "";
        }
    }

    protected void initializeView()
    {
        for (int i = 0; i < 15; i++)
        {
            yearsArray.add(String.valueOf(Calendar.getInstance().get(1) + i));
        }

    }

    public boolean isCreditCardValid()
    {
        return Strings.notEmpty(creditCardNumberView.getText()) && getUnFormattedCreditCard(creditCardNumberView.getText().toString()).length() == getCreditCardSize();
    }

    public boolean isCvvRequired()
    {
        return cvvView.getVisibility() == 0;
    }

    public boolean isExpirationMonthValid()
    {
        boolean flag1 = false;
        String s;
        int i;
        boolean flag;
        try
        {
            s = expirationMonthView.getText().toString();
        }
        catch (NumberFormatException numberformatexception)
        {
            return false;
        }
        flag = flag1;
        if (!Strings.notEmpty(s))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        i = Integer.parseInt(s);
        flag = flag1;
        if (i <= 12)
        {
            flag = true;
        }
        return flag;
    }

    public boolean isExpirationYearValid()
    {
        int i;
        int j;
        int k;
        try
        {
            i = Integer.parseInt(expirationYearView.getText().toString());
            j = Integer.parseInt(getYearLastTwoDigits((String)yearsArray.get(0)));
            k = Integer.parseInt(getYearLastTwoDigits((String)yearsArray.get(yearsArray.size() - 1)));
        }
        catch (NumberFormatException numberformatexception)
        {
            return false;
        }
        return i >= j && i <= k;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (!isInEditMode())
        {
            RoboGuice.getInjector(getContext()).injectMembers(this);
        }
        dogfoodHelper.logHideViewId(0x7f1001fe);
        dogfoodHelper.logHideViewId(0x7f1001ff);
        dogfoodHelper.logHideViewId(0x7f100201);
        dogfoodHelper.logHideViewId(0x7f100203);
        dogfoodHelper.logHideViewId(0x7f100200);
        creditCardIcon = (ImageView)findViewById(0x7f1000c8);
        creditCardNumberView = (EditText)findViewById(0x7f1001fe);
        creditCardNumberView.addTextChangedListener(this);
        creditCardNumberView.setOnFocusChangeListener(this);
        creditCardPlaceholder = (EditText)findViewById(0x7f100200);
        creditCardPlaceholder.setOnTouchListener(this);
        expirationMonthView = (EditText)findViewById(0x7f1001ff);
        expirationMonthView.addTextChangedListener(this);
        expirationMonthView.setOnFocusChangeListener(this);
        expirationYearView = (EditText)findViewById(0x7f100201);
        expirationYearView.addTextChangedListener(this);
        expirationYearView.setOnFocusChangeListener(this);
        cvvView = (EditText)findViewById(0x7f100203);
        cvvView.addTextChangedListener(this);
        cvvView.setOnFocusChangeListener(this);
        updateCardIcon(getCardNumber());
    }

    public void onFocusChange(View view, boolean flag)
    {
        view.getId();
        JVM INSTR tableswitch 2131755518 2131755523: default 44
    //                   2131755518 45
    //                   2131755519 189
    //                   2131755520 44
    //                   2131755521 220
    //                   2131755522 44
    //                   2131755523 101;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L5
_L1:
        return;
_L2:
        if (Strings.notEmpty(creditCardNumberView.getText().toString()))
        {
            if (flag)
            {
                view = CreditCardState.CREDIT_CARD_NUMBER_EDIT;
            } else
            {
                view = CreditCardState.CREDIT_CARD_OTHER_EDIT;
            }
            changeState(view);
            creditCardNumberView.setSelection(creditCardNumberView.getText().length());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (flag)
        {
            changeState(CreditCardState.CREDIT_CARD_OTHER_EDIT);
            if (!isExpirationMonthValid() || !isExpirationYearValid())
            {
                cvvView.clearFocus();
                cvvView.setCursorVisible(false);
                focusView(expirationMonthView, true);
                return;
            }
            if (!cvvView.isCursorVisible())
            {
                cvvView.setCursorVisible(true);
            }
            cvvView.setSelection(cvvView.getText().length());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            changeState(CreditCardState.CREDIT_CARD_OTHER_EDIT);
            expirationMonthView.setSelection(expirationMonthView.getText().length());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (flag)
        {
            changeState(CreditCardState.CREDIT_CARD_OTHER_EDIT);
            expirationYearView.setSelection(expirationYearView.getText().length());
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof SavedState)
        {
            parcelable = (SavedState)parcelable;
            super.onRestoreInstanceState(parcelable.getSuperState());
            updateCardIcon(((SavedState) (parcelable)).ccNumber);
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.ccNumber = creditCardNumberView.getText().toString();
        return savedstate;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (getCurrentFocus() != null && getCurrentFocus().getId() == 0x7f1001ff)
        {
            charsequence = expirationMonthView;
            if (expirationMonthView.getText().length() == 0)
            {
                i = 19;
            } else
            {
                i = 21;
            }
            charsequence.setGravity(i);
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (view.getId() == 0x7f100200 && 1 == motionevent.getAction())
        {
            creditCardPlaceholder.setVisibility(8);
            creditCardNumberView.setVisibility(0);
            focusView(creditCardNumberView, true);
            creditCardNumberView.setSelection(creditCardNumberView.getText().length());
        }
        return false;
    }

    public void setCardNumber(String s)
    {
        handleCreditCardNumberChanged(s);
        if (isCreditCardValid())
        {
            changeState(CreditCardState.CREDIT_CARD_OTHER_EDIT);
        }
    }

    public void setCvv(String s)
    {
        cvvView.removeTextChangedListener(this);
        cvvView.setText(s);
        cvvView.addTextChangedListener(this);
    }

    public void setCvvVisibility(boolean flag)
    {
        EditText edittext = cvvView;
        int i;
        if (flag && creditCardPlaceholder.getVisibility() == 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        edittext.setVisibility(i);
    }

    public void setExpirationMonth(int i)
    {
        setText(expirationMonthView, String.valueOf(i), false);
    }

    public void setExpirationYear(int i)
    {
        setText(expirationYearView, String.valueOf(i), false);
    }

    protected void setText(EditText edittext, String s, boolean flag)
    {
        if (flag)
        {
            edittext.addTextChangedListener(this);
            edittext.setText(s);
            edittext.removeTextChangedListener(this);
        } else
        {
            edittext.removeTextChangedListener(this);
            edittext.setText(s);
            edittext.addTextChangedListener(this);
        }
        edittext.setSelection(edittext.getText().length());
    }

    protected void setText(EditText edittext, String s, boolean flag, int i)
    {
        setText(edittext, s, flag);
        edittext.setSelection(i);
    }

    protected void updateCardIcon(String s)
    {
        char c;
        if (s.length() >= 1)
        {
            c = s.charAt(0);
        } else
        {
            c = '0';
        }
        switch (c)
        {
        default:
            creditCardIcon.setImageDrawable(getResources().getDrawable(0x7f020209));
            return;

        case 50: // '2'
        case 53: // '5'
            creditCardIcon.setImageDrawable(getResources().getDrawable(0x7f0200d9));
            return;

        case 51: // '3'
            creditCardIcon.setImageDrawable(getResources().getDrawable(0x7f0200b5));
            return;

        case 52: // '4'
            creditCardIcon.setImageDrawable(getResources().getDrawable(0x7f0200e7));
            return;

        case 54: // '6'
            creditCardIcon.setImageDrawable(getResources().getDrawable(0x7f0200bf));
            break;
        }
    }
}
