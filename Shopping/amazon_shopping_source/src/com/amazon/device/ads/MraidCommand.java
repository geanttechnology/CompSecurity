// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.amazon.device.ads:
//            MraidView

abstract class MraidCommand
{

    protected Map mParams;
    protected MraidView mView;

    MraidCommand(Map map, MraidView mraidview)
    {
        mParams = map;
        mView = mraidview;
    }

    abstract void execute();

    protected boolean getBooleanFromParamsForKey(String s)
    {
        return "true".equals(mParams.get(s));
    }

    protected float getFloatFromParamsForKey(String s)
    {
        if ((String)mParams.get(s) == null)
        {
            return 0.0F;
        }
        float f;
        try
        {
            f = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 0.0F;
        }
        return f;
    }

    protected Integer[] getIntArrayFromParamsForKey(String s)
    {
        s = (String)mParams.get(s);
        if (s == null)
        {
            return null;
        }
        s = s.split(",");
        ArrayList arraylist = new ArrayList();
        int j = s.length;
        int i = 0;
        while (i < j) 
        {
            String s1 = s[i];
            try
            {
                arraylist.add(Integer.valueOf(Integer.parseInt(s1, 10)));
            }
            catch (NumberFormatException numberformatexception)
            {
                arraylist.add(Integer.valueOf(-1));
            }
            i++;
        }
        return (Integer[])arraylist.toArray(new Integer[arraylist.size()]);
    }

    protected int getIntFromParamsForKey(String s)
    {
        s = (String)mParams.get(s);
        if (s == null)
        {
            return -1;
        }
        int i;
        try
        {
            i = Integer.parseInt(s, 10);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return i;
    }

    protected String getStringFromParamsForKey(String s)
    {
        return (String)mParams.get(s);
    }
}
