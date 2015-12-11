// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class gi
{

    public static Address a(Context context, double d, double d1)
    {
        context = (new Geocoder(context, Locale.US)).getFromLocation(d, d1, 1).iterator();
_L1:
        Address address;
        boolean flag;
        do
        {
            if (!context.hasNext())
            {
                break MISSING_BLOCK_LABEL_78;
            }
            address = (Address)context.next();
        } while (address.getCountryCode() == null);
        flag = address.getCountryCode().equals("US");
        if (flag)
        {
            return address;
        }
          goto _L1
        context;
        context.printStackTrace();
        throw context;
        return null;
    }

    public static Address a(Context context, String s)
    {
        Iterator iterator = (new Geocoder(context, Locale.US)).getFromLocationName(s, 1).iterator();
_L1:
        Address address;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        address = (Address)iterator.next();
        context = address.getCountryCode();
        s = context;
        if (context == null)
        {
            try
            {
                s = address.getAddressLine(1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                try
                {
                    s.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                    throw context;
                }
                s = context;
            }
        }
        context = address;
        if (s.equals("US"))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (s.equals("USA"))
        {
            return address;
        }
          goto _L1
        context = null;
        return context;
    }

    public static Address b(Context context, String s)
    {
        Iterator iterator = (new Geocoder(context, Locale.US)).getFromLocationName(s, 1).iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Address address;
        address = (Address)iterator.next();
        s = address.getCountryCode();
        Object obj = s;
        boolean flag;
        if (s == null)
        {
            try
            {
                obj = address.getAddressLine(1);
            }
            catch (Exception exception)
            {
                try
                {
                    exception.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                    throw context;
                }
                exception = s;
            }
        }
        s = address;
        if (((String) (obj)).equals("US"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        flag = ((String) (obj)).equals("USA");
        if (!flag) goto _L4; else goto _L3
_L3:
        s = address;
_L6:
        obj = s;
        if (s != null)
        {
            obj = a(context, s.getLatitude(), s.getLongitude());
        }
        return ((Address) (obj));
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
