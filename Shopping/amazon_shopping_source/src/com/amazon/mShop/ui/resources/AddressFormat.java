// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui.resources;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.platform.Resources;
import com.amazon.rio.j2me.client.services.mShop.Address;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;
import java.util.Hashtable;

// Referenced classes of package com.amazon.mShop.ui.resources:
//            PaymentFormat

public class AddressFormat
{

    public AddressFormat()
    {
    }

    public static void appendAddress(Address address, StringBuffer stringbuffer, int i)
    {
        String s;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        s = com.amazon.mShop.platform.Platform.Factory.getInstance().getResources().getAddressFormat(address.getCountryCode());
        flag3 = true;
        flag5 = true;
        flag4 = true;
        flag1 = flag4;
        flag2 = flag3;
        flag = flag5;
        i;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 342
    //                   1 354
    //                   2 84
    //                   3 368;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        flag = flag5;
        flag2 = flag3;
        flag1 = flag4;
_L7:
        Hashtable hashtable = new Hashtable(10);
        if (flag2 && address.getName() != null)
        {
            hashtable.put("name", address.getName());
        }
        if (flag && address.getPhone() != null)
        {
            hashtable.put("phone", address.getPhone());
        }
        if (flag1 && address.getCountry() != null)
        {
            hashtable.put("country", address.getCountry());
        }
        if (address.getAddress1() != null)
        {
            hashtable.put("address1", address.getAddress1());
        }
        if (address.getAddress2() != null)
        {
            hashtable.put("address2", address.getAddress2());
        }
        if (address.getAddress3() != null)
        {
            hashtable.put("address3", address.getAddress3());
        }
        if (address.getCity() != null)
        {
            hashtable.put("city", address.getCity());
        }
        if (address.getState() != null)
        {
            hashtable.put("state", address.getState());
        }
        if (address.getZip() != null)
        {
            hashtable.put("zip", address.getZip());
        }
        if (address.getCounty() != null)
        {
            hashtable.put("county", address.getCounty());
        }
        formatCollapseSeparators(s, hashtable, stringbuffer);
        if (i == 0 || i == 3)
        {
            do
            {
                i = stringbuffer.indexOf("\n");
                if (i == -1)
                {
                    break;
                }
                stringbuffer.replace(i, i + 1, " ");
            } while (true);
        }
        break; /* Loop/switch isn't completed */
_L2:
        flag2 = false;
        flag = false;
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L3:
        flag = false;
        flag1 = flag4;
        flag2 = flag3;
        continue; /* Loop/switch isn't completed */
_L5:
        flag = false;
        flag1 = false;
        flag2 = flag3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String formatAddress(Address address, int i)
    {
        if (address != null)
        {
            StringBuffer stringbuffer = new StringBuffer(128);
            appendAddress(address, stringbuffer, i);
            if (stringbuffer.length() != 0)
            {
                return stringbuffer.toString();
            }
        }
        return null;
    }

    private static void formatCollapseSeparators(String s, Hashtable hashtable, StringBuffer stringbuffer)
    {
        String s1;
        int i;
        int k;
        s1 = null;
        i = 0;
        k = 0;
_L6:
        if (k >= s.length()) goto _L2; else goto _L1
_L1:
        int l = s.indexOf("{", k);
        if (l != -1) goto _L3; else goto _L2
_L2:
        int i1;
        return;
_L3:
        if ((i1 = s.indexOf("}", l + 1)) == -1) goto _L2; else goto _L4
_L4:
        int j;
label0:
        {
            String s2 = s.substring(k, l);
            k = getSeparatorWeight(s2);
            if (s1 != null)
            {
                j = i;
                if (k < i)
                {
                    break label0;
                }
            }
            s1 = s2;
            j = k;
        }
        String s4 = (String)hashtable.get(s.substring("{".length() + l, i1));
        String s3 = s1;
        if (s4 != null)
        {
            s3 = s1;
            if (s4.length() > 0)
            {
                s3 = s1;
                if (stringbuffer.length() > 0)
                {
                    stringbuffer.append(s1);
                    s3 = null;
                }
                stringbuffer.append(s4);
            }
        }
        k = i1 + "}".length();
        s1 = s3;
        i = j;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String formatOneClickAddress(Address address, PaymentMethod paymentmethod)
    {
        StringBuffer stringbuffer = new StringBuffer(128);
        appendAddress(address, stringbuffer, 1);
        if (paymentmethod != null)
        {
            stringbuffer.append("\n");
            PaymentFormat.appendPaymentMethod(paymentmethod, stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static int getSeparatorWeight(String s)
    {
        int i = 0;
        int j = 0;
        while (j < s.length()) 
        {
            char c = s.charAt(j);
            if (c == '\n')
            {
                i += 0x100000;
            } else
            if (Character.isWhitespace(c))
            {
                i++;
            } else
            {
                i += 1024;
            }
            j++;
        }
        return i;
    }
}
