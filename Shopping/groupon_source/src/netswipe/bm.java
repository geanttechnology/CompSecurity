// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import com.jumio.netswipe.sdk.environment.Environment;
import java.util.ArrayList;

// Referenced classes of package netswipe:
//            bh, dc, aw, ba, 
//            ar, as, ap, ao, 
//            bp, cw, bo, cy, 
//            bn

public class bm extends TableLayout
    implements bh
{

    private bp a;
    private ba b;
    private aw c;
    private aw d;
    private Button e;

    public bm(Context context)
    {
        super(context);
        int i = dc.a(getContext(), 10);
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        setPadding(i, i, i, i);
    }

    static aw a(bm bm1)
    {
        return bm1.c;
    }

    static boolean a(bm bm1, View view)
    {
        return bm1.c(view);
    }

    static void b(bm bm1, View view)
    {
        bm1.d(view);
    }

    private boolean c(View view)
    {
        View view2 = view.focusSearch(130);
        View view1 = view2;
        if (view2 == null)
        {
            view1 = view.focusSearch(2);
        }
        if (view1 != null)
        {
            view1.requestFocus();
        }
        return view1 != null;
    }

    private void d(View view)
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < getChildCount())
                {
                    if (getChildAt(i) != view || i + 1 >= getChildCount())
                    {
                        break label0;
                    }
                    Object obj = getChildAt(i + 1);
                    if (((View) (obj)).getVisibility() == 0)
                    {
                        break label0;
                    }
                    ((View) (obj)).setVisibility(0);
                    if (obj instanceof aw)
                    {
                        obj = (aw)obj;
                        ((aw) (obj)).setShowDivider(true);
                        if (((aw) (obj)).getValueText().length() != 0)
                        {
                            ((aw) (obj)).b();
                        }
                        if ((view instanceof aw) && ((aw)view).getAutoFocusNextView())
                        {
                            c(view);
                        }
                        if (((aw) (obj)).getAutoShowNextView())
                        {
                            a(((View) (obj)));
                        }
                    }
                }
                return;
            }
            i++;
        } while (true);
    }

    public aw a(int i, int j, String s, String s1)
    {
        aw aw1 = new aw(getContext());
        aw1.setLabelId(i);
        aw1.setValueId(j);
        aw1.setLabelText(s);
        aw1.setValueHint(s1);
        aw1.setVisibility(4);
        aw1.setValidationCallback(this);
        addView(aw1);
        return aw1;
    }

    public void a()
    {
        b = new ba(getContext());
        b.setLabelText(ar.a(getContext(), "manual_entry_valid_through"));
        b.setValidationCallback(this);
        b.setVisibility(4);
        b.setTypeface(Environment.loadOcraFontTypeface(getContext()));
        addView(b);
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        int i = dc.a(getContext(), 10);
        e = new Button(getContext());
        android.widget.TableLayout.LayoutParams layoutparams = new android.widget.TableLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(0, i, 0, 0);
        e.setLayoutParams(layoutparams);
        e.setId(as.y);
        ao.a(e, ap.a(getResources()));
        e.setTextColor(-1);
        e.setTextSize(2, 20F);
        e.setOnClickListener(onclicklistener);
        e.setText(ar.a(getContext(), "manual_entry_button_finish"));
        e.setVisibility(4);
        e.setEnabled(false);
        addView(e);
    }

    public void a(View view)
    {
        if (view == a)
        {
            StringBuilder stringbuilder = new StringBuilder(a.getValueText());
            a(cw.b(stringbuilder));
            stringbuilder.delete(0, stringbuilder.length());
        }
        d(view);
        if (e != null && e.getVisibility() == 0)
        {
            e.setEnabled(d());
        }
    }

    public void a(NetswipeCardInformation netswipecardinformation)
    {
        int i = 0;
        while (i < getChildCount()) 
        {
            char ac[] = getChildAt(i);
            if (ac.equals(a))
            {
                netswipecardinformation.setCardNumber(new StringBuilder(a.getValueText()));
                netswipecardinformation.setCardNumberManuallyEntered(true);
            } else
            if (ac.equals(b))
            {
                ac = new char[2];
                b.getMonthText().getChars(0, 2, ac, 0);
                netswipecardinformation.setExpiryDateMonth(ac);
                ac = new char[2];
                b.getYearText().getChars(0, 2, ac, 0);
                netswipecardinformation.setExpiryDateYear(ac);
            } else
            if (ac.equals(c))
            {
                ac = new char[c.getValueText().length()];
                c.getValueText().getChars(0, c.getValueText().length(), ac, 0);
                netswipecardinformation.setCvvCode(ac);
            } else
            if (ac.equals(d))
            {
                ac = new char[d.getValueText().length()];
                d.getValueText().getChars(0, d.getValueText().length(), ac, 0);
                netswipecardinformation.setCardHolderName(ac);
            } else
            if (ac instanceof aw)
            {
                netswipecardinformation.setCustomField((String)ac.getTag(), ((aw)ac).getValueText().toString());
            }
            i++;
        }
    }

    public void a(CreditCardType creditcardtype)
    {
        if (c == null)
        {
            return;
        }
        aw aw1 = c;
        aw aw2 = c;
        aw2.getClass();
        aw1.a(new bo(this, aw2, creditcardtype));
        if (creditcardtype == CreditCardType.AMERICAN_EXPRESS)
        {
            c.setValueHint("****");
            c.setFilters(new InputFilter[] {
                new android.text.InputFilter.LengthFilter(4)
            });
            c.setValidationPattern("[0-9]{3,}");
            c.setAutoFocusNextView(false);
            return;
        } else
        {
            c.setValueHint("***");
            c.setFilters(new InputFilter[] {
                new android.text.InputFilter.LengthFilter(3)
            });
            c.setValidationPattern("[0-9]{3}");
            return;
        }
    }

    public void a(CharSequence charsequence)
    {
        if (d != null)
        {
            d.setValueText(charsequence);
        }
    }

    public void a(ArrayList arraylist)
    {
        a = new bp(getContext());
        a.setSupportedCreditCardTypes(arraylist);
        a.setLabelText(ar.a(getContext(), "manual_entry_credit_card"));
        a.setValidationCallback(this);
        a.setVisibility(4);
        a.setTypeface(Environment.loadOcraFontTypeface(getContext()));
        addView(a);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, ArrayList arraylist, android.view.View.OnClickListener onclicklistener, ArrayList arraylist1, 
            boolean flag4)
    {
        Object obj = Environment.loadOcraFontTypeface(getContext());
        if (flag)
        {
            a(arraylist1);
        }
        if (flag1)
        {
            a();
        }
        if (flag2)
        {
            b();
            c.setAutoShowNextView(flag4);
            arraylist1 = c;
            aw aw1;
            int i;
            int j;
            int k;
            if (!flag4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            arraylist1.setAutoFocusNextView(flag);
            aw1 = c;
            if (flag4)
            {
                arraylist1 = null;
            } else
            {
                arraylist1 = ((ArrayList) (obj));
            }
            aw1.setTypeface(arraylist1);
        }
        if (flag3)
        {
            c();
            d.setAutoShowNextView(flag4);
            arraylist1 = d;
            if (flag4)
            {
                obj = null;
            }
            arraylist1.setTypeface(((android.graphics.Typeface) (obj)));
        }
        if (arraylist != null)
        {
            for (i = 0; i < arraylist.size(); i++)
            {
                arraylist1 = (cy)arraylist.get(i);
                j = as.T;
                as.T = j + 1;
                k = as.T;
                as.T = k + 1;
                obj = a(j, k, arraylist1.b(), arraylist1.c());
                if (arraylist1.e() != -1)
                {
                    ((aw) (obj)).setInputType(arraylist1.e());
                }
                ((aw) (obj)).setValidationPattern(arraylist1.d());
                ((aw) (obj)).setTag(arraylist1.a());
                ((aw) (obj)).setAutoFocusNextView(false);
                ((aw) (obj)).setAutoShowNextView(true);
                if (i == 0)
                {
                    ((aw) (obj)).a(0, dc.a(getContext(), 10), 0, 0);
                }
            }

        }
        if (getChildCount() > 0)
        {
            getChildAt(0).setVisibility(0);
            getChildAt(0).post(new bn(this));
        }
        a(onclicklistener);
    }

    public void b()
    {
        c = a(as.P, as.Q, ar.a(getContext(), "manual_entry_cvv_cvc"), "***");
        c.setInputType(0);
        c.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        c.setTransformationMethod(PasswordTransformationMethod.getInstance());
        c.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(3)
        });
        c.setValidationPattern("[0-9]{3}");
        c.setValidationCallback(this);
    }

    public void b(View view)
    {
        e.setEnabled(false);
    }

    public void c()
    {
        d = a(as.R, as.S, ar.a(getContext(), "manual_entry_cardholder_name"), "");
        d.setAutoFocusNextView(false);
        d.setInputType(4096);
        d.setValidationPattern("^\\D{1,}$");
        d.setValidationCallback(this);
    }

    public boolean d()
    {
        int i;
        boolean flag;
        i = 0;
        flag = true;
_L8:
        boolean flag1 = flag;
        if (i >= getChildCount()) goto _L2; else goto _L1
_L1:
        View view = getChildAt(i);
        if (view.getVisibility() == 0) goto _L4; else goto _L3
_L3:
        flag = false;
_L6:
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
_L2:
        return flag1;
_L4:
        if (view instanceof bp)
        {
            flag = ((bp)view).a();
        } else
        if (view instanceof ba)
        {
            flag = ((ba)view).a();
        } else
        if (view instanceof aw)
        {
            flag = ((aw)view).a();
        }
        if (true) goto _L6; else goto _L5
_L5:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
