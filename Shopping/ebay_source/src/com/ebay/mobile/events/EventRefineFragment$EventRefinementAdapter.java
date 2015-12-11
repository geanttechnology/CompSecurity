// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.widget.PriceView;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.events:
//            EventRefineFragment

private class <init> extends com.ebay.mobile.common.<init>
    implements TextWatcher
{

    private static final int VIEW_TYPE_BUTTON = 0;
    private static final int VIEW_TYPE_PRICE = 2;
    private static final int VIEW_TYPE_REFINEMENT = 1;
    final EventRefineFragment this$0;

    private void showInvalidPriceDialog()
    {
        com.ebay.app.ntAdapter ntadapter = new com.ebay.app.ntAdapter();
        ntadapter.ntAdapter(getString(0x7f0703e0));
        ntadapter.ntAdapter(getString(0x7f0703df));
        ntadapter.on(0x7f070738);
        ntadapter.ent(1, getTargetFragment()).show(getFragmentManager(), getClass().getName());
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected com.ebay.mobile.common.<init> getDefaultFilterByRefinement()
    {
        for (Iterator iterator = refinements.iterator(); iterator.hasNext();)
        {
            Object obj = (com.ebay.mobile.common.refinements)iterator.next();
            if (obj instanceof refinements)
            {
                obj = (refinements)obj;
                if (((refinements) (obj)).entType == _FILTER)
                {
                    return ((com.ebay.mobile.common._FILTER) (obj));
                }
            }
        }

        return null;
    }

    protected com.ebay.mobile.common._FILTER getDefaultSortByRefinement()
    {
        for (Iterator iterator = refinements.iterator(); iterator.hasNext();)
        {
            Object obj = (com.ebay.mobile.common.refinements)iterator.next();
            if (obj instanceof refinements)
            {
                obj = (refinements)obj;
                if (((refinements) (obj)).entType == entType)
                {
                    return ((com.ebay.mobile.common.entType) (obj));
                }
            }
        }

        return null;
    }

    public int getItemViewType(int i)
    {
        boolean flag = true;
        com.ebay.mobile.common.entType enttype = (com.ebay.mobile.common.entType)refinements.get(i);
        if (enttype instanceof refinements)
        {
            i = 0;
        } else
        {
            if (enttype instanceof refinements)
            {
                return 2;
            }
            i = ((flag) ? 1 : 0);
            if (enttype instanceof refinements)
            {
                return 1;
            }
        }
        return i;
    }

    protected void getPriceRangeCategories()
    {
        refinements.clear();
        refinements.add(new refinements(getString(0x7f0703e2), EventRefineFragment.access$2400(EventRefineFragment.this)));
        refinements.add(new refinements(getString(0x7f0703e1), EventRefineFragment.access$2500(EventRefineFragment.this)));
        EventRefineFragment.access$900(EventRefineFragment.this).setVisibility(0);
        notifyDataSetChanged();
        EventRefineFragment.access$2202(EventRefineFragment.this, null);
    }

    protected void getSortCategories()
    {
        refinements.clear();
        if (EventRefineFragment.access$2300(EventRefineFragment.this).size() > 0)
        {
            Iterator iterator = EventRefineFragment.access$2300(EventRefineFragment.this).iterator();
            while (iterator.hasNext()) 
            {
                com.ebay.nautilus.domain.net.api.events.ged ged = (com.ebay.nautilus.domain.net.api.events.ged)iterator.next();
                String s;
                if (ged == com.ebay.nautilus.domain.net.api.events.ged)
                {
                    s = getString(0x7f0703ef);
                } else
                if (ged == com.ebay.nautilus.domain.net.api.events.hest)
                {
                    s = getString(0x7f070ade);
                } else
                {
                    s = getString(0x7f070add);
                }
                refinements.add(new refinements(s, ged));
            }
            EventRefineFragment.access$900(EventRefineFragment.this).setVisibility(0);
            notifyDataSetChanged();
            EventRefineFragment.access$2202(EventRefineFragment.this, null);
        }
    }

    public void onBindViewHolder(android.support.v7.widget.s._cls0 _pcls0, int i)
    {
        if (i < refinements.size())
        {
            this._cls0 _lcls0_1;
            switch (getItemViewType(i))
            {
            default:
                return;

            case 0: // '\0'
                ._mth500((._cls500)_pcls0).setOnClickListener(this);
                return;

            case 1: // '\001'
                this._cls0 _lcls0_2 = (._cls500)refinements.get(i);
                this._cls0 _lcls0 = (refinements)_pcls0;
                cess._mth100(_lcls0).setText(_lcls0_2.e());
                i = (int)getResources().getDimension(0x7f090141);
                if (_lcls0_2.velRefinement())
                {
                    cess._mth200(_lcls0).setText(_lcls0_2.ngIdentifier());
                    cess._mth200(_lcls0).setVisibility(0);
                    cess._mth200(_lcls0).setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f020193), null);
                    cess._mth100(_lcls0).setPadding(i * 2, 0, i * 2, 0);
                } else
                {
                    cess._mth200(_lcls0).setVisibility(0);
                    cess._mth200(_lcls0).setText(null);
                    String s = _lcls0_2.e();
                    if (_lcls0_2.entType == entType)
                    {
                        _pcls0 = EventRefineFragment.access$300(EventRefineFragment.this);
                    } else
                    {
                        _pcls0 = EventRefineFragment.access$400(EventRefineFragment.this);
                    }
                    if (s.equals(_pcls0))
                    {
                        _pcls0 = getResources().getDrawable(0x7f0201c3);
                    } else
                    {
                        _pcls0 = null;
                    }
                    cess._mth200(_lcls0).setCompoundDrawablesWithIntrinsicBounds(null, null, _pcls0, null);
                    cess._mth100(_lcls0).setPadding(i, 0, i, 0);
                }
                _lcls0.emView.setOnClickListener(this);
                return;

            case 2: // '\002'
                _lcls0_1 = (emView)refinements.get(i);
                _pcls0 = (refinements)_pcls0;
                ((refinements) (_pcls0)).xtView.setText(_lcls0_1.e());
                break;
            }
            if (Double.compare(_lcls0_1.e, -1D) != 0)
            {
                ((e) (_pcls0)).e.setText(String.valueOf(EbayCurrencyUtil.formatUserInput(EventRefineFragment.access$600(EventRefineFragment.this), Double.valueOf(_lcls0_1._fld0), 4)));
                return;
            }
            if (((this._cls0) (_pcls0))._fld0.getPriceAsBoxedDouble() != null)
            {
                ((this._cls0) (_pcls0))._fld0.clear();
                return;
            }
        }
    }

    public void onClick(View view)
    {
        int i = EventRefineFragment.access$700(EventRefineFragment.this).getChildPosition(view);
        view = (com.ebay.mobile.common.this._cls0)refinements.get(i);
        if (!(view instanceof refinements)) goto _L2; else goto _L1
_L1:
        view = (refinements)view;
        if (!view.velRefinement()) goto _L4; else goto _L3
_L3:
        EventRefineFragment.access$800(EventRefineFragment.this).setText(view.e());
        EventRefineFragment.access$900(EventRefineFragment.this).setVisibility(0);
        if (((this._cls0) (view)).entType != entType) goto _L6; else goto _L5
_L5:
        getSortCategories();
_L10:
        if (EventRefineFragment.access$1200(EventRefineFragment.this) != null)
        {
            EventRefineFragment.access$1300(EventRefineFragment.this).nRefinementSelected(view);
        }
_L8:
        return;
_L6:
        if (((nRefinementSelected) (view)).entType == LTER)
        {
            getPriceRangeCategories();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        EventRefineFragment.access$800(EventRefineFragment.this).setText(0x7f0708e1);
        if (((this._cls0) (view)).entType == entType)
        {
            EventRefineFragment.access$1002(EventRefineFragment.this, view.e());
        } else
        {
            EventRefineFragment.access$1102(EventRefineFragment.this, view.e());
        }
        resetRefinements();
        continue; /* Loop/switch isn't completed */
_L2:
        if (!(view instanceof resetRefinements)) goto _L8; else goto _L7
_L7:
        if (EventRefineFragment.access$1400(EventRefineFragment.this) != null)
        {
            EventRefineFragment.access$1500(EventRefineFragment.this).nResetPressed(getDefaultSortByRefinement(), getDefaultFilterByRefinement());
        }
        resetRefinements();
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public android.support.v7.widget.etRefinements onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return new (LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a1, viewgroup, false));

        case 1: // '\001'
            return new nit>(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a2, viewgroup, false));

        case 2: // '\002'
            viewgroup = new nit>(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0300a3, viewgroup, false));
            break;
        }
        ((nit>) (viewgroup)).nit>.addTextChangedListener(this);
        ((nit>) (viewgroup)).nit>.setCurrency(EventRefineFragment.access$600(EventRefineFragment.this));
        return viewgroup;
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        k = 0;
        boolean flag = false;
        j = 0;
        charsequence = refinements.iterator();
        while (charsequence.hasNext()) 
        {
            this._cls0 _lcls0 = (refinements)(com.ebay.mobile.common.refinements)charsequence.next();
            Object obj = EventRefineFragment.access$2800(EventRefineFragment.this).findViewHolderForPosition(j);
            boolean flag1 = flag;
            i = k;
            if (obj instanceof this._cls0)
            {
                obj = (this._cls0)obj;
                Double double1 = ((this._cls0) (obj))._fld0.getPriceAsBoxedDouble();
                if (double1 != null && double1.doubleValue() != _lcls0._fld0)
                {
                    _lcls0._fld0 = ((this._cls0) (obj))._fld0.getPrice();
                    flag1 = ((this._cls0) (obj)).xtView.getText().equals(getString(0x7f0703e2));
                    i = 1;
                } else
                {
                    flag1 = flag;
                    i = k;
                    if (double1 == null)
                    {
                        flag1 = flag;
                        i = k;
                        if (Double.compare(_lcls0.xtView, -1D) != 0)
                        {
                            _lcls0.xtView = -1D;
                            i = 1;
                            flag1 = flag;
                        }
                    }
                }
            }
            j++;
            flag = flag1;
            k = i;
        }
        if (k != 0)
        {
            validatePrice(flag);
        }
    }

    protected void resetRefinements()
    {
        refinements.clear();
        if (EventRefineFragment.access$1600(EventRefineFragment.this) != null)
        {
            refinements.add(new refinements(getString(0x7f070ad9), EventRefineFragment.access$1700(EventRefineFragment.this), this._fld0));
        }
        if (EventRefineFragment.access$1800(EventRefineFragment.this) != null)
        {
            refinements.add(new refinements(getString(0x7f070216), EventRefineFragment.access$1900(EventRefineFragment.this), _FILTER));
        }
        refinements.add(new refinements(getString(0x7f0707be), EventRefineFragment.access$2000(EventRefineFragment.this), LTER));
        refinements.add(new refinements(null));
        notifyDataSetChanged();
        EventRefineFragment.access$900(EventRefineFragment.this).setVisibility(8);
        EventRefineFragment.access$2202(EventRefineFragment.this, null);
    }

    public void validatePrice(boolean flag)
    {
label0:
        {
            this._cls0 _lcls0 = null;
            this._cls0 _lcls0_1 = null;
            Object obj2 = refinements.iterator();
            do
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                Object obj = (com.ebay.mobile.common.refinements)((Iterator) (obj2)).next();
                if (obj instanceof refinements)
                {
                    obj = (refinements)obj;
                    if (((refinements) (obj)).e().equals(getString(0x7f0703e2)))
                    {
                        _lcls0 = ((e) (obj));
                    } else
                    if (((e) (obj)).e().equals(getString(0x7f0703e1)))
                    {
                        _lcls0_1 = ((e) (obj));
                    }
                }
            } while (true);
            if (_lcls0 == null || _lcls0_1 == null)
            {
                break label0;
            }
            if (_lcls0.e > _lcls0_1.e && _lcls0_1.e > 0.0D)
            {
                if (!flag)
                {
                    break label0;
                }
                _lcls0.e = _lcls0_1.e;
                notifyDataSetChanged();
                showInvalidPriceDialog();
            }
            EventRefineFragment.access$2402(EventRefineFragment.this, _lcls0._fld0);
            EventRefineFragment.access$2502(EventRefineFragment.this, _lcls0_1._fld0);
            Object obj1 = null;
            obj2 = null;
            EventRefineFragment.access$2002(EventRefineFragment.this, "");
            if (Double.compare(EventRefineFragment.access$2400(EventRefineFragment.this), -1D) != 0)
            {
                obj1 = EbayCurrencyUtil.formatDisplay(EventRefineFragment.access$600(EventRefineFragment.this), EventRefineFragment.access$2400(EventRefineFragment.this), 2);
            }
            if (Double.compare(EventRefineFragment.access$2500(EventRefineFragment.this), -1D) != 0)
            {
                obj2 = EbayCurrencyUtil.formatDisplay(EventRefineFragment.access$600(EventRefineFragment.this), EventRefineFragment.access$2500(EventRefineFragment.this), 2);
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                EventRefineFragment.access$2002(EventRefineFragment.this, String.format(getString(0x7f0703e5), new Object[] {
                    obj1, obj2
                }));
            } else
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                EventRefineFragment.access$2002(EventRefineFragment.this, String.format(getString(0x7f0703e4), new Object[] {
                    obj1
                }));
            } else
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                EventRefineFragment.access$2002(EventRefineFragment.this, String.format(getString(0x7f0703e3), new Object[] {
                    obj2
                }));
            }
            if (EventRefineFragment.access$2600(EventRefineFragment.this) != null)
            {
                obj1 = EventRefineFragment.access$2700(EventRefineFragment.this);
                if (!flag)
                {
                    _lcls0 = _lcls0_1;
                }
                ((com.ebay.mobile.common.this._cls0) (obj1)).nRefinementSelected(_lcls0);
            }
        }
    }

    private r()
    {
        this$0 = EventRefineFragment.this;
        super(EventRefineFragment.this);
    }

    t>(t> t>)
    {
        this();
    }
}
