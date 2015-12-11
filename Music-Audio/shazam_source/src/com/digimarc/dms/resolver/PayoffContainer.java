// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.graphics.PointF;
import com.digimarc.dms.imagereader.Payload;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digimarc.dms.resolver:
//            StandardPayoff, Payoff

class PayoffContainer
{
    public static final class PayoffResult extends Enum
    {

        private static final PayoffResult $VALUES[];
        public static final PayoffResult DefaultPayoff;
        public static final PayoffResult NetworkError;
        public static final PayoffResult Resolved;
        public static final PayoffResult Unresolved;

        public static PayoffResult valueOf(String s)
        {
            return (PayoffResult)Enum.valueOf(com/digimarc/dms/resolver/PayoffContainer$PayoffResult, s);
        }

        public static PayoffResult[] values()
        {
            return (PayoffResult[])$VALUES.clone();
        }

        static 
        {
            Unresolved = new PayoffResult("Unresolved", 0);
            Resolved = new PayoffResult("Resolved", 1);
            NetworkError = new PayoffResult("NetworkError", 2);
            DefaultPayoff = new PayoffResult("DefaultPayoff", 3);
            $VALUES = (new PayoffResult[] {
                Unresolved, Resolved, NetworkError, DefaultPayoff
            });
        }

        private PayoffResult(String s, int i)
        {
            super(s, i);
        }
    }


    private static final float DEFAULT_FOCAL_X = 0.5F;
    private static final float DEFAULT_FOCAL_Y = 0.5F;
    private static final String DEFAULT_REDIRECT = "Default";
    private static final String TAG = "DiscoverPayoff";
    private Payload mPayload;
    private int mResolveTime;
    private Payoff mStandardPayoff;
    private String msResult;

    public PayoffContainer(Payload payload, String s, Payoff payoff, int i)
    {
        mPayload = payload;
        msResult = s;
        mStandardPayoff = payoff;
        mResolveTime = i;
    }

    private static boolean isFieldEmpty(String s)
    {
        if (s != null)
        {
            return s.equals("null");
        } else
        {
            return true;
        }
    }

    public static PayoffContainer parsePayoffJson(String s, Payload payload, int i)
    {
label0:
        {
            boolean flag = false;
            if (s == null)
            {
                return new PayoffContainer(payload, PayoffResult.NetworkError.toString(), null, i);
            }
            Object obj;
            JSONObject jsonobject;
            try
            {
                jsonobject = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return new PayoffContainer(payload, PayoffResult.NetworkError.toString(), null, i);
            }
            s = jsonobject.optString("Result", null);
            obj = jsonobject.optJSONArray("Payoffs");
            if (s == null || obj == null)
            {
                return null;
            }
            if (((JSONArray) (obj)).length() != 0)
            {
                flag = true;
            }
            if (s.equals("Unresolved"))
            {
                if (!flag)
                {
                    break label0;
                }
                s = "Default";
            }
            String s1;
            String s2;
            String s3;
            JSONObject jsonobject1;
            try
            {
                jsonobject1 = (JSONObject)((JSONArray) (obj)).get(0);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            s3 = jsonobject1.optString("Description", null);
            obj = jsonobject1.optString("Title");
            if (isFieldEmpty(((String) (obj))))
            {
                obj = s3;
            }
            s1 = jsonobject1.optString("Subtitle");
            s2 = jsonobject1.optString("Image");
            if (isFieldEmpty(s1))
            {
                s1 = "";
            }
            if (isFieldEmpty(s2))
            {
                s2 = "";
            }
            obj = new StandardPayoff(new Payoff(((String) (obj)), s1, s2, new PointF(0.5F, 0.5F)), jsonobject1.optString("Content", null), jsonobject1.optString("ActionType", null), s3, jsonobject1.optString("ActionToken", null));
            obj.mCorrelationKey = jsonobject.optString("ServiceId", null);
            if (isFieldEmpty(((StandardPayoff) (obj)).mCorrelationKey))
            {
                obj.mCorrelationKey = payload.getCpmPath();
            }
            return new PayoffContainer(payload, s, ((Payoff) (obj)), i);
        }
        return new PayoffContainer(payload, s, null, i);
    }

    public Payload getPayload()
    {
        return mPayload;
    }

    public String getResult()
    {
        return msResult;
    }

    public PayoffResult getResultEnum()
    {
        if (msResult.toUpperCase().equals("UNRESOLVED"))
        {
            return PayoffResult.Unresolved;
        }
        if (msResult.toUpperCase().equals("RESOLVED"))
        {
            return PayoffResult.Resolved;
        }
        if (msResult.toUpperCase().equals("NETWORKERROR"))
        {
            return PayoffResult.NetworkError;
        }
        if (msResult.toUpperCase().equals("Default".toUpperCase()))
        {
            return PayoffResult.DefaultPayoff;
        } else
        {
            return null;
        }
    }

    public StandardPayoff getStandardPayoff()
    {
        return (StandardPayoff)mStandardPayoff;
    }

    public int getTime()
    {
        return mResolveTime;
    }
}
