// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.DialogInterface;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            CountryUtil, DialogManager

public class ThanksUIUtil
{

    private Context context;
    private CountryUtil countryUtil;
    private CurrentDivisionManager currentDivisionManager;
    private DialogManager dialogManager;

    public ThanksUIUtil(Context context1)
    {
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
    }

    public void showThanksForSubscriptionDialog(Country country, String s, final android.content.DialogInterface.OnCancelListener onCancelListener)
    {
        String s1 = country.shortName;
        String s2 = countryUtil.getDisplayName(s1);
        country = currentDivisionManager.getCurrentDivision();
        String s3;
        String s4;
        String s5;
        if (country.hasParent())
        {
            country = ((Division) (country)).parent.name;
        } else
        {
            country = ((Division) (country)).name;
        }
        s4 = context.getString(0x7f0800c2);
        s5 = context.getString(0x7f0803c4);
        s3 = context.getString(0x7f0803cd);
        if (Strings.equalsIgnoreCase("DE", s1))
        {
            country = String.format(s4, new Object[] {
                s
            });
        } else
        {
            country = String.format(s5, new Object[] {
                s2, country, s
            });
        }
        dialogManager.showAlertDialog(s3, country, Integer.valueOf(0x7f080139), new android.content.DialogInterface.OnClickListener() {

            final ThanksUIUtil this$0;
            final android.content.DialogInterface.OnCancelListener val$onCancelListener;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (onCancelListener != null)
                {
                    onCancelListener.onCancel(dialoginterface);
                }
            }

            
            {
                this$0 = ThanksUIUtil.this;
                onCancelListener = oncancellistener;
                super();
            }
        });
    }
}
