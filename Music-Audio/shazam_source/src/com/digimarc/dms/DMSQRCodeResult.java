// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.dms.barcodereader.QRCodeResolver;
import java.io.UnsupportedEncodingException;

public class DMSQRCodeResult extends QRCodeResolver
{

    protected String mCode;

    public DMSQRCodeResult(String s)
    {
        super(s);
        mCode = s;
    }

    private boolean isMultiByte(char c)
    {
        return Character.toString(c).getBytes("UTF-8").length == 1;
    }

    public boolean containsMultiByte()
    {
        char ac[];
        int i;
        int j;
        boolean flag;
        ac = mCode.toCharArray();
        j = ac.length;
        i = 0;
        flag = false;
_L2:
        char c;
        boolean flag1;
        flag1 = flag;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        c = ac[i];
        flag1 = isMultiByte(c);
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L2; else goto _L1
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        flag1 = flag;
_L1:
        return flag1;
    }

    public String getCode()
    {
        return mCode;
    }
}
