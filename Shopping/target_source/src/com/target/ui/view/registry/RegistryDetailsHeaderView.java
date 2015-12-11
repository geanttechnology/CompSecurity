// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.common.registries.RegistryAlternateId;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.util.d.d;
import com.target.ui.view.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RegistryDetailsHeaderView extends LinearLayout
{
    static class Views extends a
    {

        ImageView barcode;
        TextView dateCityState;
        TextView noOfItems;
        TextView registryId;
        TextView title;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private Views mViews;

    public RegistryDetailsHeaderView(Context context)
    {
        super(context);
        a();
    }

    public RegistryDetailsHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public RegistryDetailsHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private String a(int i)
    {
        if (i > 0)
        {
            return String.format(getContext().getString(0x7f0904a7), new Object[] {
                Integer.valueOf(i)
            });
        } else
        {
            return getContext().getString(0x7f0904a6);
        }
    }

    private String a(RegistryDetails registrydetails)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a(registrydetails.f()));
        stringbuilder.append(" ");
        stringbuilder.append("-");
        stringbuilder.append(" ");
        stringbuilder.append(registrydetails.d());
        stringbuilder.append(",");
        stringbuilder.append(" ");
        stringbuilder.append(registrydetails.e());
        return stringbuilder.toString();
    }

    private String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("MM/dd/yyyy", Locale.US)).format(date);
        }
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301d2, this);
        mViews = new Views(this);
    }

    private String b(RegistryDetails registrydetails)
    {
        if (!registrydetails.c().b())
        {
            return "";
        } else
        {
            return String.format(getContext().getString(0x7f0904a8), new Object[] {
                ((RegistryAlternateId)registrydetails.c().c()).a()
            });
        }
    }

    public void a(RegistryDetails registrydetails, Double double1, int i)
    {
        mViews.title.setText(d.a(registrydetails.h()));
        mViews.dateCityState.setText(a(registrydetails));
        mViews.noOfItems.setText(a(i));
        mViews.registryId.setText(b(registrydetails));
        registrydetails = (String)registrydetails.a(double1).d();
        if (o.g(registrydetails))
        {
            u.a(getContext()).a(registrydetails).b(0x7f0201ae).a(mViews.barcode);
            al.b(mViews.barcode);
            return;
        } else
        {
            al.c(mViews.barcode);
            return;
        }
    }
}
