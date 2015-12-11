// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.target.mothership.util.o;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            x

public class l extends x
{

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private List mPaymentInstructionList;
    private String mPlacedDateString;
    private List mShipmentList;

    public l()
    {
    }

    public Date I()
    {
        Date date = null;
        if (o.g(mPlacedDateString))
        {
            try
            {
                date = (new SimpleDateFormat("MM/dd/yyyy", Locale.US)).parse(mPlacedDateString);
            }
            catch (ParseException parseexception)
            {
                return null;
            }
        }
        return date;
    }

    public List J()
    {
        return mPaymentInstructionList;
    }

    public List K()
    {
        return mShipmentList;
    }
}
