// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            JSONUtils

class Size
{

    private int height;
    private int width;

    public Size(int i, int j)
    {
        width = i;
        height = j;
    }

    public Size(String s)
    {
        boolean flag = false;
        boolean flag1 = false;
        int j = ((flag1) ? 1 : 0);
        int i = ((flag) ? 1 : 0);
        if (s != null)
        {
            s = s.split("x");
            j = ((flag1) ? 1 : 0);
            i = ((flag) ? 1 : 0);
            if (s != null)
            {
                j = ((flag1) ? 1 : 0);
                i = ((flag) ? 1 : 0);
                if (s.length == 2)
                {
                    i = Math.max(parseInt(s[0], 0), 0);
                    j = Math.max(parseInt(s[1], 0), 0);
                }
            }
        }
        width = i;
        height = j;
    }

    private static int parseInt(String s, int i)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setWidth(int i)
    {
        width = i;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject = new JSONObject();
        JSONUtils.put(jsonobject, "width", width);
        JSONUtils.put(jsonobject, "height", height);
        return jsonobject;
    }

    public String toString()
    {
        return (new StringBuilder()).append(width).append("x").append(height).toString();
    }
}
