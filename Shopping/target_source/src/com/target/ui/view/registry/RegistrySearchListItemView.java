// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.target.mothership.common.registries.c;
import com.target.mothership.model.registries.interfaces.RegistrySearchSummary;
import com.target.mothership.util.o;
import com.target.ui.util.af;
import com.target.ui.util.al;
import com.target.ui.util.d.d;
import com.target.ui.view.a;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class RegistrySearchListItemView extends FrameLayout
{
    static class Views extends a
    {

        TextView mRegistrantCityAndState;
        TextView mRegistrantCreatedDate;
        TextView mRegistrantName;
        TextView mRegistryName;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private Views mViews;

    public RegistrySearchListItemView(Context context)
    {
        super(context);
        a();
    }

    public RegistrySearchListItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public RegistrySearchListItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private String a(RegistrySearchSummary registrysearchsummary)
    {
        registrysearchsummary = registrysearchsummary.d();
        if (registrysearchsummary == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("MM/dd/yyyy", Locale.US)).format(registrysearchsummary);
        }
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301e1, this);
        mViews = new Views(this);
    }

    private String b(RegistrySearchSummary registrysearchsummary)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(registrysearchsummary.e());
        stringbuilder.append(",");
        stringbuilder.append(" ");
        stringbuilder.append(registrysearchsummary.f());
        return stringbuilder.toString();
    }

    private String c(RegistrySearchSummary registrysearchsummary)
    {
        if (registrysearchsummary.g().equals(c.UNKNOWN))
        {
            return "";
        } else
        {
            return String.format(getResources().getString(0x7f0904bb), new Object[] {
                registrysearchsummary.g().toString().toLowerCase()
            });
        }
    }

    public void setItemData(RegistrySearchSummary registrysearchsummary)
    {
        if (registrysearchsummary == null)
        {
            return;
        }
        mViews.mRegistrantName.setText(d.a(registrysearchsummary.h()));
        String s = c(registrysearchsummary);
        if (o.g(s))
        {
            mViews.mRegistryName.setText(af.a(s));
            al.b(mViews.mRegistryName);
        } else
        {
            al.c(mViews.mRegistryName);
        }
        s = a(registrysearchsummary);
        if (o.g(s))
        {
            mViews.mRegistrantCreatedDate.setText(s);
            al.b(mViews.mRegistrantCreatedDate);
        } else
        {
            al.c(mViews.mRegistrantCreatedDate);
        }
        registrysearchsummary = b(registrysearchsummary);
        if (o.g(registrysearchsummary))
        {
            mViews.mRegistrantCityAndState.setText(registrysearchsummary);
            al.b(mViews.mRegistryName);
            return;
        } else
        {
            al.c(mViews.mRegistryName);
            return;
        }
    }
}
