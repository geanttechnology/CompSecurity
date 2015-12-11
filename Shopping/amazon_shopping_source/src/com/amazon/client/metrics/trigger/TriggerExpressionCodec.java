// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.trigger;

import android.util.Log;

// Referenced classes of package com.amazon.client.metrics.trigger:
//            SimpleTriggerExpression, TriggerExpression

public class TriggerExpressionCodec
{

    private static final String TAG = "TriggerExpressionCodec";

    public TriggerExpressionCodec()
    {
    }

    public TriggerExpression deserializeTriggerExpression(String s)
    {
        if (s == null)
        {
            Log.e("TriggerExpressionCodec", "SerializeTriggerExpression was null. ");
            return null;
        }
        String as[] = s.split(" ");
        if (as.length != 2)
        {
            Log.e("TriggerExpressionCodec", (new StringBuilder()).append("Trigger expression is not properly formatted: ").append(s).toString());
            return null;
        }
        s = as[0];
        String s1 = as[1];
        SimpleTriggerExpression simpletriggerexpression;
        try
        {
            simpletriggerexpression = new SimpleTriggerExpression(SimpleTriggerExpression.TriggerOperator.fromString(s), Double.parseDouble(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TriggerExpressionCodec", (new StringBuilder()).append("Trigger expression has a malformed threshold value: ").append(s1).toString());
            return null;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Log.e("TriggerExpressionCodec", (new StringBuilder()).append("Trigger expression has a malformed operator value: ").append(s).toString());
            return null;
        }
        return simpletriggerexpression;
    }
}
