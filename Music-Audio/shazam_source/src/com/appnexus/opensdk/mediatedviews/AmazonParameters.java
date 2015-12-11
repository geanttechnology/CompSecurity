// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import org.json.JSONException;
import org.json.JSONObject;

class AmazonParameters
{

    public boolean a;
    public int b;
    public boolean c;
    public int d;

    public AmazonParameters(String s)
    {
        if (s == null || s.length() == 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        finally
        {
            return;
        }
        try
        {
            b = s.getInt("timeout");
            a = true;
        }
        catch (JSONException jsonexception) { }
        d = s.getInt("floor_price");
        c = true;
        return;
        s;
    }
}
