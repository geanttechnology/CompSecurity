// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.common.product.a;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.i;
import com.target.mothership.model.product.interfaces.ProductLimitedAvailability;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.util.o;
import com.target.ui.common.e;
import com.target.ui.util.SpannableStringUtils;
import com.target.ui.util.al;
import com.target.ui.view.AisleBadgeView;

public class PdpHeaderView extends RelativeLayout
{
    static class Views extends com.target.ui.view.a
    {

        AisleBadgeView aisleBadge;
        ImageView calloutImage;
        TextView onlineAvailability;
        ImageView onlineIcon;
        View registryContainer;
        ImageView registryImage;
        TextView registryTitle;
        TextView storeAvailability;
        TextView storeName;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();
    }


    private a mListener;
    private Views mViews;

    public PdpHeaderView(Context context)
    {
        super(context);
        a();
    }

    public PdpHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public PdpHeaderView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a();
    }

    private SpannableStringBuilder a(ProductLimitedAvailability productlimitedavailability)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (productlimitedavailability.a())
        {
            productlimitedavailability = String.format(a(0x7f09037f), new Object[] {
                Integer.valueOf(productlimitedavailability.b())
            });
        } else
        {
            productlimitedavailability = String.format(a(0x7f0903ec), new Object[] {
                Integer.valueOf(productlimitedavailability.b())
            });
        }
        spannablestringbuilder.append(SpannableStringUtils.a(productlimitedavailability.toString(), getResources().getColor(0x7f0f00e9)));
        return spannablestringbuilder;
    }

    private SpannableStringBuilder a(e e1)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        c c1 = e1.i();
        if (c1.equals(c.STORE_ONLY) || c1.equals(c.UNKNOWN) || c1.equals(c.NOT_AVAILABLE))
        {
            spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f0903e5), getResources().getColor(0x7f0f00e9)));
            return spannablestringbuilder;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$target$mothership$common$product$InventoryStatus[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$InventoryStatus = new int[i.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.InStock.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OutOfStock.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.NotSoldInThisStore.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.LimitedStock.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.OnBackorder.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$InventoryStatus[i.PreOrder.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.mothership.common.product.InventoryStatus[e1.g().ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            return spannablestringbuilder;

        case 1: // '\001'
        case 5: // '\005'
        case 6: // '\006'
            spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f0900db), getResources().getColor(0x7f0f00ec)));
            return spannablestringbuilder;

        case 2: // '\002'
            spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f0903f0), getResources().getColor(0x7f0f00e9)));
            break;
        }
        return spannablestringbuilder;
    }

    static a a(PdpHeaderView pdpheaderview)
    {
        return pdpheaderview.mListener;
    }

    private String a(int j)
    {
        return getResources().getString(j);
    }

    private void a()
    {
        inflate(getContext(), 0x7f03018c, this);
        mViews = new Views(this);
        mViews.aisleBadge.setOnClickListener(new android.view.View.OnClickListener() {

            final PdpHeaderView this$0;

            public void onClick(View view)
            {
                if (com.target.ui.view.product.PdpHeaderView.a(PdpHeaderView.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.view.product.PdpHeaderView.a(PdpHeaderView.this).a();
                    return;
                }
            }

            
            {
                this$0 = PdpHeaderView.this;
                super();
            }
        });
    }

    private void a(com.target.mothership.common.product.a a1)
    {
        if (a1.equals(com.target.mothership.common.product.a.NEW_AT_TARGET))
        {
            mViews.calloutImage.setImageResource(0x7f020190);
            al.b(mViews.calloutImage);
        } else
        if (a1.equals(com.target.mothership.common.product.a.ONLY_AT_TARGET))
        {
            mViews.calloutImage.setImageResource(0x7f02018e);
            al.b(mViews.calloutImage);
        } else
        {
            al.c(mViews.calloutImage);
        }
        al.c(mViews.registryContainer);
    }

    private void a(i j)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        _cls2..SwitchMap.com.target.mothership.common.product.InventoryStatus[j.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 49
    //                   2 140
    //                   3 166
    //                   4 192;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_192;
_L1:
        return;
_L2:
        spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f0900db), getResources().getColor(0x7f0f00ec)));
_L6:
        spannablestringbuilder.append(" ").append(SpannableStringUtils.a(a(0x7f0900d8), getResources().getColor(0x7f0f00f3))).append(" ");
        if (o.g(spannablestringbuilder.toString()))
        {
            mViews.storeAvailability.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            al.b(mViews.storeAvailability);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f0903f0), getResources().getColor(0x7f0f00e9)));
          goto _L6
_L4:
        spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f0903e5), getResources().getColor(0x7f0f00e9)));
          goto _L6
        spannablestringbuilder.append(SpannableStringUtils.a(a(0x7f090380), getResources().getColor(0x7f0f00e9)));
          goto _L6
    }

    private void a(RegistryDetails registrydetails)
    {
        mViews.registryTitle.setText(registrydetails.a());
        al.a(mViews.registryContainer, new View[] {
            mViews.calloutImage
        });
    }

    private void a(com.target.ui.view.DepartmentBadgeView.a a1, String s)
    {
        if (s == null && a1 == null)
        {
            al.d(mViews.aisleBadge);
            return;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        mViews.aisleBadge.setAisle(s);
_L4:
        al.a(mViews.aisleBadge, new View[] {
            mViews.onlineIcon
        });
        return;
_L2:
        if (a1 != null)
        {
            mViews.aisleBadge.setDepartment(a1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setOnlineAvailability(e e1)
    {
        SpannableStringBuilder spannablestringbuilder;
        if (e1.h().b())
        {
            spannablestringbuilder = a((ProductLimitedAvailability)e1.h().c());
        } else
        {
            SpannableStringBuilder spannablestringbuilder1 = a(e1);
            spannablestringbuilder = spannablestringbuilder1;
            if (!o.g(spannablestringbuilder1.toString()))
            {
                return;
            }
        }
        spannablestringbuilder.append(" ").append(a(0x7f09046f));
        mViews.onlineAvailability.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
        al.b(mViews.onlineAvailability);
        if (!e1.d().b())
        {
            al.a(mViews.onlineIcon, new View[] {
                mViews.aisleBadge
            });
        }
    }

    private void setStoreName(String s)
    {
        if (s == null)
        {
            al.a(new View[] {
                mViews.storeName, mViews.storeAvailability
            });
            return;
        } else
        {
            mViews.storeName.setText(s);
            al.b(mViews.storeName);
            return;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

    public void setDisplayOptions(e e1)
    {
        if (e1.e().b())
        {
            a((RegistryDetails)e1.e().c());
        } else
        {
            a(e1.a());
        }
        setStoreName((String)e1.c().d());
        setOnlineAvailability(e1);
        if (!e1.b().b() && !e1.d().b())
        {
            return;
        } else
        {
            a((com.target.ui.view.DepartmentBadgeView.a)e1.b().d(), (String)e1.d().d());
            a(e1.f());
            return;
        }
    }
}
