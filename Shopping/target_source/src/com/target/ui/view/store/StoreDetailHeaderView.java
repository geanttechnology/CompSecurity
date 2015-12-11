// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.h.c.e;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.Address;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.common.PhoneNumber;
import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.service.k;
import com.target.ui.util.ae;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class StoreDetailHeaderView extends LinearLayout
{
    public static interface a
    {

        public abstract void a();
    }


    private a mDetailsClickedListener;

    public StoreDetailHeaderView(Context context)
    {
        super(context);
        a();
    }

    public StoreDetailHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public StoreDetailHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private View a(String s, Spannable spannable, Integer integer, boolean flag, android.view.View.OnClickListener onclicklistener)
    {
        RelativeLayout relativelayout = (RelativeLayout)LayoutInflater.from(getContext()).inflate(0x7f0301fa, null);
        ((TextView)relativelayout.findViewById(0x7f1005c3)).setText(s);
        relativelayout.findViewById(0x7f1005c2).setVisibility(8);
        if (spannable != null)
        {
            ((TextView)relativelayout.findViewById(0x7f1005c4)).setText(spannable);
            relativelayout.findViewById(0x7f1005c4).setVisibility(0);
        }
        if (integer != null)
        {
            ((ImageView)relativelayout.findViewById(0x7f1005c5)).setImageResource(integer.intValue());
            if (onclicklistener != null)
            {
                relativelayout.setOnClickListener(onclicklistener);
            }
        }
        if (flag)
        {
            LayoutInflater.from(getContext()).inflate(0x7f0301f8, relativelayout, true);
        }
        return relativelayout;
    }

    static a a(StoreDetailHeaderView storedetailheaderview)
    {
        return storedetailheaderview.mDetailsClickedListener;
    }

    private void a(StoreIdentifier storeidentifier)
    {
        k.a().a(storeidentifier, new h() {

            final StoreDetailHeaderView this$0;

            public void a(RelevantStoreSummary relevantstoresummary)
            {
                final ImageView staticMap = (ImageView)findViewById(0x7f1005be);
                if (staticMap.getViewTreeObserver() == null)
                {
                    return;
                } else
                {
                    staticMap.getViewTreeObserver().addOnPreDrawListener(relevantstoresummary. new android.view.ViewTreeObserver.OnPreDrawListener() {

                        final _cls4 this$1;
                        final RelevantStoreSummary val$response;
                        final ImageView val$staticMap;

                        public boolean onPreDraw()
                        {
                            staticMap.getViewTreeObserver().removeOnPreDrawListener(this);
                            double d = (double)staticMap.getMeasuredWidth() / (double)staticMap.getMeasuredHeight();
                            u.a(getContext()).a((new StringBuilder()).append("http://maps.google.com/maps/api/staticmap?center=").append(response.getGeofence().getCenter().getLatitude()).append(",").append(response.getGeofence().getCenter().getLongitude()).append("&zoom=16&size=640x").append((int)(640D / d)).append("&sensor=false").toString()).a(staticMap, new e() {

                                final _cls1 this$2;

                                public void a()
                                {
                                    findViewById(0x7f1005bf).setVisibility(0);
                                }

                                public void b()
                                {
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            return false;
                        }

            
            {
                this$1 = final__pcls4;
                staticMap = imageview;
                response = RelevantStoreSummary.this;
                super();
            }
                    });
                    return;
                }
            }

            public void a(x x1)
            {
            }

            public volatile void a(Object obj)
            {
                a((RelevantStoreSummary)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = StoreDetailHeaderView.this;
                super();
            }
        });
    }

    public void a()
    {
        LayoutInflater.from(getContext()).inflate(0x7f0301f9, this, true);
    }

    public void a(final StoreDetail phoneNumber)
    {
        boolean flag = true;
        a(phoneNumber.getStoreId());
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f1005c0);
        linearlayout.removeAllViews();
        final Object navAddress;
        if (ae.a(phoneNumber))
        {
            navAddress = ae.a(phoneNumber, getContext());
            String s;
            SpannableString spannablestring;
            if (o.d(((String) (navAddress))))
            {
                navAddress = new SpannableStringBuilder(getContext().getString(0x7f0903ee, new Object[] {
                    navAddress
                }));
            } else
            {
                navAddress = new SpannableStringBuilder(o.h(getContext().getString(0x7f0903ed)));
            }
            ((SpannableStringBuilder) (navAddress)).setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0f00ec)), 0, 4, 17);
        } else
        {
            navAddress = new SpannableStringBuilder(getContext().getString(0x7f09026f));
            ((SpannableStringBuilder) (navAddress)).setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0f00eb)), 0, 6, 17);
        }
        linearlayout.addView(a(phoneNumber.a(), ((Spannable) (navAddress)), Integer.valueOf(0x7f020180), true, new android.view.View.OnClickListener() {

            final StoreDetailHeaderView this$0;

            public void onClick(View view)
            {
                if (StoreDetailHeaderView.a(StoreDetailHeaderView.this) != null)
                {
                    StoreDetailHeaderView.a(StoreDetailHeaderView.this).a();
                }
            }

            
            {
                this$0 = StoreDetailHeaderView.this;
                super();
            }
        }));
        navAddress = (new StringBuilder()).append((String)phoneNumber.b().getAddressLines().get(0)).append(", ").append(phoneNumber.b().getCity()).append(", ").append(phoneNumber.b().getStateOrProvince()).append(" ").append(phoneNumber.b().getPostalCode()).toString();
        s = (String)phoneNumber.b().getAddressLines().get(0);
        spannablestring = new SpannableString((new StringBuilder()).append(phoneNumber.b().getCity()).append(", ").append(phoneNumber.b().getStateOrProvince()).append(" ").append(phoneNumber.b().getPostalCode()).toString());
        if (phoneNumber.c().isEmpty())
        {
            flag = false;
        }
        linearlayout.addView(a(s, ((Spannable) (spannablestring)), Integer.valueOf(0x7f020173), flag, new android.view.View.OnClickListener() {

            final StoreDetailHeaderView this$0;
            final String val$navAddress;

            public void onClick(View view)
            {
                try
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://maps.google.com/maps?&daddr=").append(URLEncoder.encode(navAddress, "UTF-8")).toString()));
                    getContext().startActivity(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = StoreDetailHeaderView.this;
                navAddress = s;
                super();
            }
        }));
        if (!phoneNumber.c().isEmpty())
        {
            phoneNumber = ((PhoneNumber)phoneNumber.c().get(0)).a();
            linearlayout.addView(a(((String) (phoneNumber)), null, Integer.valueOf(0x7f020194), false, new android.view.View.OnClickListener() {

                final StoreDetailHeaderView this$0;
                final String val$phoneNumber;

                public void onClick(View view)
                {
                    view = new Intent("android.intent.action.DIAL");
                    view.setData(Uri.parse((new StringBuilder()).append("tel:").append(phoneNumber).toString()));
                    getContext().startActivity(view);
                }

            
            {
                this$0 = StoreDetailHeaderView.this;
                phoneNumber = s;
                super();
            }
            }));
        }
    }

    public void setDetailsClickedListener(a a1)
    {
        mDetailsClickedListener = a1;
    }
}
