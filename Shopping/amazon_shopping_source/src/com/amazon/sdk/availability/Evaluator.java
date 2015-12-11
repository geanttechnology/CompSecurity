// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Logger, StringUtil

public class Evaluator
{
    public static class And extends Operation
    {

        boolean checkArguments()
        {
            return 1 < arguments.length();
        }

        boolean evaluateImpl()
            throws JSONException, ParseException
        {
            boolean flag = true;
            int j = arguments.length();
            int i = 0;
            do
            {
label0:
                {
                    boolean flag1 = flag;
                    if (i < j)
                    {
                        flag &= evaluate(arguments.getJSONObject(i));
                        if (flag)
                        {
                            break label0;
                        }
                        flag1 = flag;
                    }
                    return flag1;
                }
                i++;
            } while (true);
        }

        And(JSONArray jsonarray, JSONObject jsonobject)
        {
            super(jsonarray, "and", jsonobject);
        }
    }

    public static class Eq extends Operation
    {

        private String evaluateValue(JSONObject jsonobject, JSONObject jsonobject1)
            throws ParseException
        {
            String s = (String)jsonobject.keys().next();
            Logger.v((new StringBuilder()).append("Value Node is ").append(s).toString());
            if ("fetchKey".equals(s) || "metadataKey".equals(s))
            {
                jsonobject = jsonobject.optString(s);
                if (StringUtil.isEmpty(jsonobject))
                {
                    throw new ParseException("Syntax error, empty keyname for fetchKey");
                } else
                {
                    jsonobject = jsonobject1.optString(jsonobject);
                    Logger.v((new StringBuilder()).append("Value Operation fetchKey returning ").append(jsonobject).toString());
                    return jsonobject;
                }
            }
            if ("constant".equals(s))
            {
                jsonobject = jsonobject.optString(s);
                Logger.v((new StringBuilder()).append("Value Operation constant returning ").append(jsonobject).toString());
                return jsonobject;
            } else
            {
                throw new ParseException((new StringBuilder()).append("Syntax error, unknown value statement ").append(s).toString());
            }
        }

        boolean checkArguments()
        {
            return 1 < arguments.length();
        }

        boolean evaluateImpl()
            throws JSONException, ParseException
        {
            boolean flag = true;
            String s = evaluateValue(arguments.getJSONObject(0), data);
            int j = arguments.length();
            int i = 1;
            do
            {
label0:
                {
                    boolean flag1 = flag;
                    if (i < j)
                    {
                        flag &= s.equals(evaluateValue(arguments.getJSONObject(i), data));
                        if (flag)
                        {
                            break label0;
                        }
                        flag1 = flag;
                    }
                    return flag1;
                }
                i++;
            } while (true);
        }

        Eq(JSONArray jsonarray, JSONObject jsonobject)
        {
            super(jsonarray, "eq", jsonobject);
        }
    }

    public static class Not extends Operation
    {

        boolean checkArguments()
        {
            return 1 == arguments.length();
        }

        boolean evaluateImpl()
            throws JSONException, ParseException
        {
            boolean flag = false;
            if (!evaluate(arguments.getJSONObject(0)))
            {
                flag = true;
            }
            return flag;
        }

        Not(JSONArray jsonarray, JSONObject jsonobject)
        {
            super(jsonarray, "not", jsonobject);
        }
    }

    public static abstract class Operation
    {

        protected final JSONArray arguments;
        protected final JSONObject data;
        private final String opName;

        public static Operation fromJson(JSONObject jsonobject, JSONObject jsonobject1)
            throws JSONException, ParseException
        {
            if (jsonobject == null)
            {
                throw new JSONException("expression may not be null");
            }
            Iterator iterator = jsonobject.keys();
            String s = (String)iterator.next();
            jsonobject = jsonobject.getJSONArray(s);
            Logger.v((new StringBuilder()).append("Node is ").append(s).toString());
            if (iterator.hasNext())
            {
                throw new ParseException("Syntax error in rules, current level has more than one outer object.");
            } else
            {
                return fromKeywordAndArgs(s, jsonobject, jsonobject1);
            }
        }

        public static Operation fromKeywordAndArgs(String s, JSONArray jsonarray, JSONObject jsonobject)
            throws ParseException
        {
            if ("and".equals(s))
            {
                return new And(jsonarray, jsonobject);
            }
            if ("or".equals(s))
            {
                return new Or(jsonarray, jsonobject);
            }
            if ("not".equals(s))
            {
                return new Not(jsonarray, jsonobject);
            }
            if ("eq".equals(s))
            {
                return new Eq(jsonarray, jsonobject);
            } else
            {
                throw new ParseException((new StringBuilder()).append("Unknown keyword ").append(s).append(" detected.").toString());
            }
        }

        abstract boolean checkArguments();

        boolean evaluate(JSONObject jsonobject)
            throws JSONException, ParseException
        {
            return fromJson(jsonobject, data).evaluateOp();
        }

        abstract boolean evaluateImpl()
            throws JSONException, ParseException;

        boolean evaluateOp()
            throws ParseException
        {
            if (!checkArguments())
            {
                throw new ParseException((new StringBuilder()).append("Incorrect number of arguments for ").append(opName).append("(").append(arguments.length()).append(")").toString());
            }
            StringBuilder stringbuilder;
            int i;
            boolean flag;
            try
            {
                flag = evaluateImpl();
                stringbuilder = new StringBuilder();
                stringbuilder.append("operation ").append(opName).append(" with arguments ");
            }
            catch (JSONException jsonexception)
            {
                throw new ParseException((new StringBuilder()).append("Could not get value for ").append(opName).append(" while evaluating.").toString(), jsonexception);
            }
            i = 0;
            if (i >= arguments.length())
            {
                break; /* Loop/switch isn't completed */
            }
            stringbuilder.append(arguments.get(i)).append(", ");
            i++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_91;
_L1:
            stringbuilder.append(" returning ").append(flag);
            Logger.v(stringbuilder.toString());
            return flag;
        }

        protected Operation(JSONArray jsonarray, String s, JSONObject jsonobject)
        {
            arguments = jsonarray;
            opName = s;
            data = jsonobject;
        }
    }

    public static class Or extends Operation
    {

        boolean checkArguments()
        {
            return 1 < arguments.length();
        }

        boolean evaluateImpl()
            throws JSONException, ParseException
        {
            boolean flag = false;
            int j = arguments.length();
            int i = 0;
            do
            {
label0:
                {
                    boolean flag1 = flag;
                    if (i < j)
                    {
                        flag |= evaluate(arguments.getJSONObject(i));
                        if (!flag)
                        {
                            break label0;
                        }
                        flag1 = flag;
                    }
                    return flag1;
                }
                i++;
            } while (true);
        }

        Or(JSONArray jsonarray, JSONObject jsonobject)
        {
            super(jsonarray, "or", jsonobject);
        }
    }

    public static class ParseException extends Exception
    {

        public ParseException(String s)
        {
            super(s);
        }

        public ParseException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    private final JSONObject rules;

    public Evaluator(JSONObject jsonobject)
    {
        Object obj = null;
        try
        {
            jsonobject = cleanup(jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Logger.e("JSON error in rules", jsonobject);
            jsonobject = obj;
        }
        rules = jsonobject;
    }

    static Object cleanup(Object obj)
        throws JSONException
    {
        Object obj1;
        if (obj instanceof JSONObject)
        {
            obj1 = cleanup((JSONObject)obj);
        } else
        {
            obj1 = obj;
            if (obj instanceof JSONArray)
            {
                return cleanup((JSONArray)obj);
            }
        }
        return obj1;
    }

    static JSONArray cleanup(JSONArray jsonarray)
        throws JSONException
    {
        for (int i = 0; i < jsonarray.length(); i++)
        {
            cleanup(jsonarray.get(i));
        }

        return jsonarray;
    }

    static JSONObject cleanup(JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject != null)
        {
            jsonobject.remove("__type");
            Iterator iterator = jsonobject.keys();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                Object obj;
                if ("eq".equals(s))
                {
                    obj = fixupEq(cleanup(jsonobject.getJSONArray(s)));
                    jsonobject.put(s, obj);
                } else
                {
                    obj = jsonobject.get(s);
                }
                cleanup(obj);
            }
        }
        return jsonobject;
    }

    private boolean evaluate(JSONObject jsonobject, JSONObject jsonobject1)
        throws JSONException, ParseException
    {
        return Operation.fromJson(jsonobject, jsonobject1).evaluate(jsonobject);
    }

    static JSONArray fixupEq(JSONArray jsonarray)
        throws JSONException
    {
        if (1 != jsonarray.length())
        {
            return jsonarray;
        }
        JSONArray jsonarray1 = new JSONArray();
        jsonarray = jsonarray.getJSONObject(0);
        JSONObject jsonobject;
        for (Iterator iterator = jsonarray.keys(); iterator.hasNext(); jsonarray1.put(jsonobject))
        {
            jsonobject = new JSONObject();
            String s = (String)iterator.next();
            jsonobject.put(s, jsonarray.get(s));
        }

        return jsonarray1;
    }

    public boolean evaluate(JSONObject jsonobject)
    {
        boolean flag;
        try
        {
            flag = evaluate(rules, jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Logger.w("Syntax error in rules", jsonobject);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Logger.w("JSON error in rules", jsonobject);
            return false;
        }
        return flag;
    }
}
