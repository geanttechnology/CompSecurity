// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.EbayCurrency;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PriceView extends AppCompatEditText
{
    protected class PriceDecimalKeyListener extends DigitsKeyListener
    {

        private final char decimalSeparator;
        private final char digits[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        private final char digitsAndSeparator[] = {
            '\0', '.', '0', '1', '2', '3', '4', '5', '6', '7', 
            '8', '9'
        };
        private final int fractionDigits;
        private final char nothing[] = new char[0];
        final PriceView this$0;

        protected char[] getAcceptedChars()
        {
            char ac[] = nothing;
            Object obj;
            if (fractionDigits == 0)
            {
                obj = digits;
            } else
            {
                String s = getText().toString();
                int i;
                if (textWithoutSelection == null)
                {
                    PriceView priceview;
                    if (getSelectionStart() != getSelectionEnd())
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    priceview = PriceView.this;
                    if (i != 0)
                    {
                        obj = (new StringBuilder()).append(s.substring(0, getSelectionStart())).append(s.substring(getSelectionEnd(), s.length())).toString();
                    } else
                    {
                        obj = null;
                    }
                    priceview.textWithoutSelection = ((String) (obj));
                }
                obj = s;
                if (textWithoutSelection != null)
                {
                    obj = textWithoutSelection;
                }
                i = ((String) (obj)).indexOf(decimalSeparator);
                if (i == -1)
                {
                    return digitsAndSeparator;
                }
                if (((String) (obj)).length() - i <= fractionDigits)
                {
                    return digits;
                }
                obj = ac;
                if (getSelectionStart() <= i)
                {
                    return digits;
                }
            }
            return ((char []) (obj));
        }

        public int getInputType()
        {
            return 8194;
        }

        public PriceDecimalKeyListener()
        {
            this$0 = PriceView.this;
            super();
            DecimalFormat decimalformat = currency.getDecimalFormat(false);
            fractionDigits = decimalformat.getMaximumFractionDigits();
            char c;
            if (currency == null)
            {
                c = '.';
            } else
            {
                c = decimalformat.getDecimalFormatSymbols().getMonetaryDecimalSeparator();
            }
            decimalSeparator = c;
            digitsAndSeparator[0] = decimalSeparator;
        }
    }

    protected static class PriceState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public PriceState createFromParcel(Parcel parcel)
            {
                return new PriceState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public PriceState[] newArray(int i)
            {
                return new PriceState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public Double amount;
        public EbayCurrency currency;
        public int currencySymbolPadding;
        public boolean isPrefill;
        public boolean showCurrencySymbolAlways;
        public boolean showHintTextForZero;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(currency, i);
            if (showHintTextForZero)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (showCurrencySymbolAlways)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (isPrefill)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            parcel.writeInt(currencySymbolPadding);
            if (amount == null)
            {
                parcel.writeInt(0);
                return;
            } else
            {
                parcel.writeInt(1);
                parcel.writeDouble(amount.doubleValue());
                return;
            }
        }


        private PriceState(Parcel parcel)
        {
            boolean flag1 = true;
            super(parcel);
            currency = (EbayCurrency)parcel.readParcelable(com/ebay/nautilus/domain/EbayCurrency.getClassLoader());
            boolean flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showHintTextForZero = flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showCurrencySymbolAlways = flag;
            if (parcel.readInt() == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            isPrefill = flag;
            currencySymbolPadding = parcel.readInt();
            if (parcel.readInt() == 0)
            {
                parcel = null;
            } else
            {
                parcel = Double.valueOf(parcel.readDouble());
            }
            amount = parcel;
        }


        PriceState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    protected class PriceTextWatcher
        implements TextWatcher
    {

        private final char decimalSeparator;
        final PriceView this$0;

        public void afterTextChanged(Editable editable)
        {
            if (!isSettingPrice)
            {
                isPrefill = false;
            }
            textWithoutSelection = null;
            int i;
            if (decimalSeparator != '.')
            {
                if ((i = editable.length() - 1) >= 0 && editable.charAt(i) == '.')
                {
                    editable = (new StringBuilder()).append(editable.toString().substring(0, i)).append(decimalSeparator).toString();
                    setText(editable);
                    setSelection(length());
                    return;
                }
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public PriceTextWatcher()
        {
            this$0 = PriceView.this;
            super();
            char c;
            if (currency == null)
            {
                c = '.';
            } else
            {
                c = currency.getDecimalFormat(false).getDecimalFormatSymbols().getMonetaryDecimalSeparator();
            }
            decimalSeparator = c;
        }
    }


    private static final String DEFAULT_CURRENCY_CODE = "USD";
    private static final int DEFAULT_CURRENCY_SYMBOL_PADDING = 4;
    private static final boolean DEFAULT_HINT_TEXT_FOR_ZERO = false;
    private static final boolean DEFAULT_SHOW_SYMBOL_ALWAYS = false;
    protected EbayCurrency currency;
    protected int currencySymbolPadding;
    protected boolean isPrefill;
    protected boolean isSettingPrice;
    protected boolean showHintTextForZero;
    protected boolean showSymbolAlways;
    protected String symbol;
    private final Paint symbolPaint = new Paint(1);
    protected String textWithoutSelection;

    public PriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        currencySymbolPadding = 4;
        showHintTextForZero = false;
        showSymbolAlways = false;
        isPrefill = false;
        isSettingPrice = false;
        textWithoutSelection = null;
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.PriceView);
        currencySymbolPadding = context.getDimensionPixelOffset(1, 4);
        showHintTextForZero = context.getBoolean(2, false);
        showSymbolAlways = context.getBoolean(0, false);
        String s = context.getString(3);
        context.recycle();
        setInputType(8194);
        setImeOptions(0x10000000);
        setSelectAllOnFocus(attributeset.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "selectAllOnFocus", true));
        symbolPaint.setTextSize(getTextSize());
        symbolPaint.setColor(getCurrentHintTextColor());
        context = s;
        if (s == null)
        {
            context = "USD";
        }
        setCurrency(context);
    }

    public void clear()
    {
        isPrefill = false;
        setText(null);
    }

    public int getCompoundPaddingLeft()
    {
        int i = super.getCompoundPaddingLeft();
        if (getText().length() == 0 && !showSymbolAlways || !currency.isSymbolOnLeft())
        {
            return i;
        } else
        {
            return i + (int)Layout.getDesiredWidth(symbol, getPaint()) + currencySymbolPadding;
        }
    }

    public int getCompoundPaddingRight()
    {
        int i = super.getCompoundPaddingRight();
        if (getText().length() == 0 && !showSymbolAlways || currency.isSymbolOnLeft())
        {
            return i;
        } else
        {
            return i + (int)Layout.getDesiredWidth(symbol, getPaint()) + currencySymbolPadding;
        }
    }

    public double getPrice()
    {
        Double double1 = getPriceAsBoxedDouble();
        if (double1 == null)
        {
            return 0.0D;
        } else
        {
            return double1.doubleValue();
        }
    }

    public Double getPriceAsBoxedDouble()
    {
        return EbayCurrencyUtil.parseUserInput(currency, getText().toString());
    }

    public String getPriceAsString()
    {
        Double double1 = getPriceAsBoxedDouble();
        if (double1 == null)
        {
            return null;
        } else
        {
            return double1.toString();
        }
    }

    public boolean isEmpty()
    {
        return getText().toString().trim().length() == 0;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        boolean flag;
        if (getText().length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (showSymbolAlways || !flag)
        {
            canvas.save();
            float f1 = getBaseline();
            float f;
            if (currency.isSymbolOnLeft())
            {
                f = getPaddingLeft() + getScrollX();
            } else
            {
                Object obj;
                int i;
                if (flag)
                {
                    obj = getHint();
                } else
                {
                    obj = getText();
                }
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    i = 0;
                } else
                {
                    i = (int)Layout.getDesiredWidth(((CharSequence) (obj)), getPaint());
                }
                f = getPaddingLeft() + i + currencySymbolPadding;
            }
            canvas.drawText(symbol, f, f1, symbolPaint);
            canvas.restore();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        isSettingPrice = true;
        parcelable = (PriceState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        currency = ((PriceState) (parcelable)).currency;
        symbol = currency.getSymbol();
        showHintTextForZero = ((PriceState) (parcelable)).showHintTextForZero;
        showSymbolAlways = ((PriceState) (parcelable)).showCurrencySymbolAlways;
        isPrefill = ((PriceState) (parcelable)).isPrefill;
        setPriceInternal(((PriceState) (parcelable)).amount);
        setKeyListener(new PriceDecimalKeyListener());
        addTextChangedListener(new PriceTextWatcher());
        setSelection(length());
        isSettingPrice = false;
    }

    public Parcelable onSaveInstanceState()
    {
        PriceState pricestate = new PriceState(super.onSaveInstanceState());
        pricestate.currency = currency;
        pricestate.showHintTextForZero = showHintTextForZero;
        pricestate.showCurrencySymbolAlways = showSymbolAlways;
        pricestate.isPrefill = isPrefill;
        pricestate.amount = getPriceAsBoxedDouble();
        return pricestate;
    }

    public boolean onTextContextMenuItem(int i)
    {
        boolean flag = super.onTextContextMenuItem(i);
        if (i == 0x1020022)
        {
            isPrefill = false;
            String s = getText().toString();
            String s1 = EbayCurrencyUtil.formatUserInput(currency, EbayCurrencyUtil.parseUserInput(currency, s), 0);
            if (!TextUtils.equals(s, s1))
            {
                setText(s1);
                setSelection(length());
            }
        }
        return flag;
    }

    public void setCurrency(String s)
    {
        currency = EbayCurrency.getInstance(s);
        symbol = currency.getSymbol();
        setKeyListener(new PriceDecimalKeyListener());
        addTextChangedListener(new PriceTextWatcher());
    }

    public void setCurrencySymbolPadding(int i)
    {
        currencySymbolPadding = i;
        invalidate();
    }

    public void setPrice(Double double1)
    {
        isSettingPrice = true;
        isPrefill = true;
        setPriceInternal(double1);
        setSelection(length());
        isSettingPrice = false;
    }

    public void setPrice(String s)
    {
        isSettingPrice = true;
        isPrefill = true;
        setPriceInternal(EbayCurrencyUtil.parseApiValue(s));
        setSelection(length());
        isSettingPrice = false;
    }

    protected void setPriceInternal(Double double1)
    {
        if (double1 == null || showHintTextForZero && currency.isInsignificant(double1.doubleValue()))
        {
            setText(null);
            return;
        }
        byte byte0;
        if (isPrefill)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        setText(EbayCurrencyUtil.formatUserInput(currency, Double.valueOf(double1.doubleValue()), byte0));
    }

    public void setPriceRaw(String s)
    {
        isSettingPrice = true;
        setText(s);
        setSelection(length());
        isSettingPrice = false;
    }

    public void setShowCurrencySymbolAlways(boolean flag)
    {
        showSymbolAlways = flag;
        invalidate();
    }

    public void setShowHintTextForZero(boolean flag)
    {
        showHintTextForZero = flag;
        if (getPrice() == 0.0D)
        {
            setText(null);
        }
    }
}
