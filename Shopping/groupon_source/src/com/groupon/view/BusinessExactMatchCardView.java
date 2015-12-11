// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.db.models.Business;
import com.groupon.db.models.Location;
import com.groupon.view.widgetcards.BusinessCardView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            BusinessMapSlice

public class BusinessExactMatchCardView extends BusinessCardView
{

    private ImageView businessIcon;
    private TextView businessSpecial;
    private TextView businessSpecialEmpty;

    public BusinessExactMatchCardView(Context context)
    {
        this(context, null, 0);
    }

    public BusinessExactMatchCardView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BusinessExactMatchCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03004b, this);
        onFinishInflate();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        businessIcon = (ImageView)findViewById(0x7f10015b);
        businessSpecial = (TextView)findViewById(0x7f10015c);
        businessSpecialEmpty = (TextView)findViewById(0x7f10015d);
    }

    public void setInfo(Business business)
    {
        Object obj1;
        String s;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        super.setInfo(business);
        s = getContext().getResources().getString(0x7f0804cb);
        Object obj;
        String s1;
        int i;
        int j;
        if (business.getLocations().size() > 0)
        {
            obj = ((Location)business.getLocations().get(0)).city;
        } else
        {
            obj = "";
        }
        if (business.getLocations().size() > 0)
        {
            obj1 = ((Location)business.getLocations().get(0)).streetAddress1;
        } else
        {
            obj1 = "";
        }
        s1 = (new StringBuilder()).append(decimalFormat.format(business.distance)).append(getContext().getString(0x7f08047a)).toString();
        if (Strings.notEmpty(obj) && Strings.notEmpty(obj1))
        {
            businessLocation.setText(String.format(s, new Object[] {
                (new StringBuilder()).append(((String) (obj1))).append(", ").append(((String) (obj))).toString(), s1
            }));
        } else
        if (Strings.notEmpty(obj))
        {
            businessLocation.setText(String.format(s, new Object[] {
                obj, s1
            }));
        } else
        if (Strings.notEmpty(obj1))
        {
            businessLocation.setText(String.format(s, new Object[] {
                obj1, s1
            }));
        } else
        {
            businessLocation.setText(s1);
        }
        s = business.orderingListString;
        obj = null;
        flag3 = false;
        flag = false;
        flag2 = false;
        flag1 = false;
        obj1 = s.split("\\s+");
        obj = obj1;
_L2:
        if (obj != null)
        {
            j = obj.length;
            i = 0;
            do
            {
                flag2 = flag1;
                flag3 = flag;
                if (i >= j)
                {
                    break;
                }
                obj1 = obj[i];
                if (((String) (obj1)).equals("specials"))
                {
                    flag2 = true;
                } else
                {
                    flag2 = flag;
                    if (((String) (obj1)).equals("deals"))
                    {
                        flag1 = true;
                        flag2 = flag;
                    }
                }
                i++;
                flag = flag2;
            } while (true);
        }
        if (business.hasSpecials && (s == null || flag3))
        {
            businessSpecial.setText(business.firstSpecialName);
            return;
        }
        if (business.hasDeals && (s == null || flag2))
        {
            businessIcon.setVisibility(8);
            businessSpecial.setVisibility(8);
            businessSpecialEmpty.setVisibility(0);
            businessSpecialEmpty.setText(0x7f08012d);
            return;
        } else
        {
            businessIcon.setVisibility(8);
            businessSpecial.setVisibility(8);
            businessSpecialEmpty.setVisibility(0);
            businessSpecialEmpty.setText(0x7f0802b1);
            return;
        }
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void setMapSliceImage(Business business)
    {
        business = business.getLocations();
        if (business.size() > 0)
        {
            mapSlice.setLocationWithImageSize((Location)business.get(0), 200, 80);
            return;
        } else
        {
            mapSlice.setLocation(null);
            return;
        }
    }
}
