// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.db.models.Business;
import com.groupon.db.models.Location;
import com.groupon.view.widgetcards.BusinessCardView;
import java.text.DecimalFormat;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            BusinessMapSlice

public class BusinessNonExactMatchCardListView extends BusinessCardView
{

    private TextView businessDistance;
    private TextView businessPhoneNumber;
    private TextView businessSpecial;
    private LinearLayout specials_title_container;

    public BusinessNonExactMatchCardListView(Context context)
    {
        this(context, null, 0);
    }

    public BusinessNonExactMatchCardListView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BusinessNonExactMatchCardListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        inflate(context, 0x7f03004c, this);
        onFinishInflate();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        businessDistance = (TextView)findViewById(0x7f10015f);
        businessPhoneNumber = (TextView)findViewById(0x7f100161);
        businessSpecial = (TextView)findViewById(0x7f10015c);
        specials_title_container = (LinearLayout)findViewById(0x7f100160);
        mapSlice.setShowMapPlaceholder(true);
    }

    public void setInfo(Business business)
    {
        String s;
        boolean flag1;
        super.setInfo(business);
        businessDistance.setText((new StringBuilder()).append(decimalFormat.format(business.distance)).append(getContext().getString(0x7f08047a)).toString());
        Object obj1 = business.getLocations();
        if (((List) (obj1)).size() > 0)
        {
            businessPhoneNumber.setText(((Location)((List) (obj1)).get(0)).phoneNumber);
        }
        Object obj;
        boolean flag;
        int i;
        int j;
        if (((List) (obj1)).size() > 0)
        {
            obj = ((Location)((List) (obj1)).get(0)).city;
        } else
        {
            obj = "";
        }
        if (((List) (obj1)).size() > 0)
        {
            obj1 = ((Location)((List) (obj1)).get(0)).streetAddress1;
        } else
        {
            obj1 = "";
        }
        if (Strings.notEmpty(obj) && Strings.notEmpty(obj1))
        {
            businessLocation.setText((new StringBuilder()).append(((String) (obj1))).append(", ").append(((String) (obj))).toString());
        } else
        if (Strings.notEmpty(obj))
        {
            businessLocation.setText(((CharSequence) (obj)));
        } else
        if (Strings.notEmpty(obj1))
        {
            businessLocation.setText(((CharSequence) (obj1)));
        }
        s = business.orderingListString;
        obj = null;
        flag1 = false;
        flag = false;
        obj1 = s.split("\\s+");
        obj = obj1;
_L2:
        if (obj != null)
        {
            j = obj.length;
            i = 0;
            do
            {
                flag1 = flag;
                if (i >= j)
                {
                    break;
                }
                if (obj[i].equals("specials"))
                {
                    flag = true;
                }
                i++;
            } while (true);
        }
        if (business.hasSpecials && (s == null || flag1))
        {
            businessSpecial.setText(business.firstSpecialName);
            return;
        } else
        {
            specials_title_container.setVisibility(8);
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
            mapSlice.setLocationWithImageSize((Location)business.get(0), 80, 80);
            return;
        } else
        {
            mapSlice.setLocation(null);
            return;
        }
    }
}
