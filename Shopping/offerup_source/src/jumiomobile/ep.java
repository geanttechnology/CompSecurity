// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netswipe.sdk.core.InternalCardInformation;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.ArrayList;

// Referenced classes of package jumiomobile:
//            en, bf, ee, ey, 
//            eo, ei, ec, ed, 
//            cf, et, fs, er, 
//            es, fu, fw, fv, 
//            eq, cg

public class ep extends TableLayout
    implements en
{

    private et a;
    private ei b;
    private ee c;
    private ee d;
    private Button e;
    private cg f;

    public ep(Context context, cg cg)
    {
        super(context);
        int i = bf.a(getContext(), 10);
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        setPadding(i, i, i, i);
        f = cg;
    }

    static ee a(ep ep1)
    {
        return ep1.c;
    }

    static boolean a(ep ep1, View view)
    {
        return ep1.c(view);
    }

    static void b(ep ep1, View view)
    {
        ep1.d(view);
    }

    private boolean c(View view)
    {
label0:
        {
            View view1 = view;
            do
            {
                View view2 = view1.focusSearch(130);
                view = view2;
                if (view2 == null)
                {
                    view = view1.focusSearch(2);
                }
                if (view1 == view)
                {
                    view = null;
                }
                if (view == null)
                {
                    break label0;
                }
                if (view.getParent() != d || d.getValueText() == null)
                {
                    break;
                }
                view1 = view;
            } while (d.getValueText().length() != 0);
            view.requestFocus();
        }
        return view != null;
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
                    if ((obj instanceof ee) || (obj instanceof ey))
                    {
                        obj = (eo)obj;
                        ((eo) (obj)).setShowDivider(true);
                        if (((eo) (obj)).getValueText().length() != 0)
                        {
                            ((eo) (obj)).b();
                        }
                        if (((view instanceof ee) || (view instanceof ey)) && ((eo)view).getAutoFocusNextView())
                        {
                            c(view);
                        }
                        if (((eo) (obj)).getAutoShowNextView())
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

    public ee a(int i, int j, String s, String s1)
    {
        ee ee1 = new ee(getContext());
        ee1.setLabelId(i);
        ee1.setValueId(j);
        ee1.setLabelText(s);
        ee1.setValueHint(s1);
        ee1.setVisibility(4);
        ee1.setValidationCallback(this);
        addView(ee1);
        return ee1;
    }

    public ey a(int i, int j, String s, String s1, ArrayList arraylist, boolean flag, String s2)
    {
        s2 = new ey(getContext(), s1, flag, s2);
        s2.setLabelId(i);
        s2.setValueId(j);
        s2.setLabelText(s);
        s2.setValues(arraylist);
        s2.setValueHint(s1);
        s2.setVisibility(4);
        s2.setValidationCallback(this);
        addView(s2);
        return s2;
    }

    public void a()
    {
        b = new ei(getContext());
        b.setLabelText(ec.a(getContext(), "manual_entry_valid_through"));
        b.setValidationCallback(this);
        b.setVisibility(4);
        b.setTypeface(Environment.loadOcraFontTypeface(getContext()));
        addView(b);
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        int i = bf.a(getContext(), 10);
        e = new Button(getContext());
        android.widget.TableLayout.LayoutParams layoutparams = new android.widget.TableLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(0, i, 0, 0);
        e.setLayoutParams(layoutparams);
        e.setId(ed.u);
        cf.a(getContext(), e, f);
        e.setTextSize(2, 20F);
        e.setOnClickListener(onclicklistener);
        e.setText(ec.a(getContext(), "manual_entry_button_finish"));
        e.setVisibility(4);
        e.setEnabled(false);
        addView(e);
    }

    public void a(View view)
    {
        if (view == a)
        {
            StringBuilder stringbuilder = new StringBuilder(a.getValueText());
            a(fs.b(stringbuilder));
            stringbuilder.delete(0, stringbuilder.length());
        }
        d(view);
        if (e != null && e.getVisibility() == 0)
        {
            e.setEnabled(d());
        }
    }

    public void a(InternalCardInformation internalcardinformation)
    {
        int i = 0;
        while (i < getChildCount()) 
        {
            View view = getChildAt(i);
            if (view.equals(a))
            {
                internalcardinformation.a(new StringBuilder(a.getValueText()));
                internalcardinformation.b(true);
            } else
            if (view.equals(b))
            {
                internalcardinformation.e(new StringBuilder(b.getMonthText()));
                internalcardinformation.f(new StringBuilder(b.getYearText()));
            } else
            if (view.equals(c))
            {
                internalcardinformation.g(new StringBuilder(c.getValueText()));
            } else
            if (view.equals(d))
            {
                internalcardinformation.b(new StringBuilder(d.getValueText()));
            } else
            if ((view instanceof ee) || (view instanceof ey))
            {
                internalcardinformation.a((String)view.getTag(), ((eo)view).getValueText().toString());
            }
            i++;
        }
    }

    public void a(CreditCardType creditcardtype)
    {
        Object obj;
        Object obj1;
        byte byte0;
        if (c == null)
        {
            return;
        }
        obj = c;
        obj1 = c;
        obj1.getClass();
        ((ee) (obj)).a(new er(this, ((ee) (obj1)), creditcardtype));
        obj = "[0-9]{3}";
        byte0 = 3;
        obj1 = "manual_entry_cvv";
        es.a[creditcardtype.ordinal()];
        JVM INSTR tableswitch 1 8: default 104
    //                   1 170
    //                   2 170
    //                   3 170
    //                   4 177
    //                   5 184
    //                   6 191
    //                   7 213
    //                   8 213;
           goto _L1 _L2 _L2 _L2 _L3 _L4 _L5 _L6 _L6
_L1:
        creditcardtype = ((CreditCardType) (obj1));
_L8:
        c.setValueHint(ec.a(getContext(), "manual_entry_hint_security_code"));
        c.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(byte0)
        });
        c.setValidationPattern(((String) (obj)));
        c.setLabelText(ec.a(getContext(), creditcardtype));
        return;
_L2:
        creditcardtype = "manual_entry_cvv";
        continue; /* Loop/switch isn't completed */
_L3:
        creditcardtype = "manual_entry_cvc";
        continue; /* Loop/switch isn't completed */
_L4:
        creditcardtype = "manual_entry_cid";
        continue; /* Loop/switch isn't completed */
_L5:
        obj = "[0-9]{3,}";
        byte0 = 4;
        c.setAutoFocusNextView(false);
        creditcardtype = "manual_entry_cid";
        continue; /* Loop/switch isn't completed */
_L6:
        creditcardtype = "manual_entry_cav";
        if (true) goto _L8; else goto _L7
_L7:
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
        a = new et(getContext());
        a.setSupportedCreditCardTypes(arraylist);
        a.setLabelText(ec.a(getContext(), "manual_entry_credit_card"));
        a.setValidationCallback(this);
        a.setVisibility(4);
        a.setTypeface(Environment.loadOcraFontTypeface(getContext()));
        addView(a);
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, ArrayList arraylist, android.view.View.OnClickListener onclicklistener, ArrayList arraylist1, 
            boolean flag4)
    {
        int i;
        Environment.loadOcraFontTypeface(getContext());
        if (flag)
        {
            a(arraylist1);
        }
        if (flag1)
        {
            a();
            b.setAutoShowNextView(flag4);
            arraylist1 = b;
            int j;
            int l;
            if (!flag4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            arraylist1.setAutoFocusNextView(flag);
        }
        if (flag2)
        {
            b();
            c.setAutoShowNextView(flag4);
            arraylist1 = c;
            if (!flag4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            arraylist1.setAutoFocusNextView(flag);
        }
        if (flag3)
        {
            c();
            d.setAutoShowNextView(flag4);
        }
        if (arraylist == null) goto _L2; else goto _L1
_L1:
        i = ed.P;
        l = 0;
_L4:
        while (l < arraylist.size()) 
        {
            fu fu1 = (fu)arraylist.get(l);
            if ((fu1 instanceof fw) || (fu1 instanceof fv))
            {
                int k;
                if (fu1 instanceof fw)
                {
                    arraylist1 = (fw)fu1;
                    j = i + 1;
                    arraylist1 = a(i, j, fu1.b(), arraylist1.c(), arraylist1.d(), arraylist1.e(), arraylist1.f());
                    k++;
                } else
                {
                    fv fv1 = (fv)fu1;
                    k = i + 1;
                    arraylist1 = a(i, k, fu1.b(), fu1.c());
                    if (fv1.d() != -1)
                    {
                        ((ee)arraylist1).setInputType(fv1.d());
                    }
                    ((ee)arraylist1).setValidationPattern(fv1.e());
                    ((ee)arraylist1).c();
                    k++;
                }
                arraylist1.setTag(fu1.a());
                arraylist1.setAutoFocusNextView(false);
                arraylist1.setAutoShowNextView(true);
                i = k;
                if (l == 0)
                {
                    arraylist1.a(0, bf.a(getContext(), 10), 0, 0);
                    i = k;
                }
            }
            l++;
        }
_L2:
        if (getChildCount() > 0)
        {
            arraylist = getChildAt(0);
            arraylist.setVisibility(0);
            arraylist.post(new eq(this));
        }
        a(onclicklistener);
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(char ac[], char ac1[])
    {
        if (b != null)
        {
            b.a(ac, ac1);
        }
    }

    public void b()
    {
        c = a(ed.L, ed.M, ec.a(getContext(), "manual_entry_cvv"), "***");
        c.setInputType(0);
        c.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        c.setTransformationMethod(PasswordTransformationMethod.getInstance());
        c.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(3)
        });
        c.setValidationPattern("[0-9]{3}");
        c.setValidationCallback(this);
        c.setTypeface(Environment.loadOcraFontTypeface(getContext()));
        c.c();
    }

    public void b(View view)
    {
        e.setEnabled(false);
    }

    public void c()
    {
        d = a(ed.N, ed.O, ec.a(getContext(), "manual_entry_cardholder_name"), "");
        d.setAutoFocusNextView(false);
        d.setInputType(4096);
        d.setValidationPattern("^.+$");
        d.setValidationCallback(this);
        d.setFilters(new InputFilter[] {
            new android.text.InputFilter.AllCaps()
        });
        d.setInputType(4096);
        d.setTypeface(Environment.loadOcraFontTypeface(getContext()));
        d.c();
    }

    public boolean d()
    {
        int i;
        boolean flag;
        i = 0;
        flag = true;
_L7:
        boolean flag1 = flag;
        if (i >= getChildCount()) goto _L2; else goto _L1
_L1:
        View view = getChildAt(i);
        if (view.getVisibility() == 0) goto _L4; else goto _L3
_L3:
        flag = false;
_L5:
        flag1 = flag;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (view instanceof et)
        {
            flag = ((et)view).a();
        } else
        if (view instanceof ei)
        {
            flag = ((ei)view).a();
        } else
        if ((view instanceof ee) || (view instanceof ey))
        {
            flag = ((eo)view).a();
        }
        if (true) goto _L5; else goto _L2
_L2:
        return flag1;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
