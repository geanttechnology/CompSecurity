// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.util.HttpRequest;
import org.json.JSONObject;

// Referenced classes of package org.acra.sender:
//            ReportSender, ReportSenderException

public class HttpSender
    implements ReportSender
{
    public static final class Method extends Enum
    {

        private static final Method $VALUES[];
        public static final Method POST;
        public static final Method PUT;

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(org/acra/sender/HttpSender$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])$VALUES.clone();
        }

        static 
        {
            POST = new Method("POST", 0);
            PUT = new Method("PUT", 1);
            $VALUES = (new Method[] {
                POST, PUT
            });
        }

        private Method(String s, int i)
        {
            super(s, i);
        }
    }

    public static abstract class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type FORM;
        public static final Type JSON;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(org/acra/sender/HttpSender$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        public abstract String getContentType();

        static 
        {
            FORM = new Type("FORM", 0) {

                public String getContentType()
                {
                    return "application/x-www-form-urlencoded";
                }

            };
            JSON = new Type("JSON", 1) {

                public String getContentType()
                {
                    return "application/json";
                }

            };
            $VALUES = (new Type[] {
                FORM, JSON
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }

    }


    private final Uri mFormUri;
    private final Map mMapping;
    private final Method mMethod;
    private final Type mType;

    public HttpSender(Method method, Type type, String s, Map map)
    {
        mMethod = method;
        mFormUri = Uri.parse(s);
        mMapping = map;
        mType = type;
    }

    public HttpSender(Method method, Type type, Map map)
    {
        mMethod = method;
        mFormUri = null;
        mMapping = map;
        mType = type;
    }

    private Map remap(Map map)
    {
        ReportField areportfield1[] = ACRA.getConfig().customReportContent();
        ReportField areportfield[] = areportfield1;
        if (areportfield1.length == 0)
        {
            areportfield = ACRAConstants.DEFAULT_REPORT_FIELDS;
        }
        HashMap hashmap = new HashMap(map.size());
        int j = areportfield.length;
        int i = 0;
        while (i < j) 
        {
            ReportField reportfield = areportfield[i];
            if (mMapping == null || mMapping.get(reportfield) == null)
            {
                hashmap.put(reportfield.toString(), map.get(reportfield));
            } else
            {
                hashmap.put(mMapping.get(reportfield), map.get(reportfield));
            }
            i++;
        }
        return hashmap;
    }

    public void send(CrashReportData crashreportdata)
        throws ReportSenderException
    {
        Object obj = null;
        if (mFormUri != null) goto _L2; else goto _L1
_L1:
        URL url = new URL(ACRA.getConfig().formUri());
_L12:
        Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Connect to ").append(url.toString()).toString());
        if (!ACRAConfiguration.isNull(ACRA.getConfig().formUriBasicAuthLogin())) goto _L4; else goto _L3
_L3:
        String s = null;
_L13:
        if (!ACRAConfiguration.isNull(ACRA.getConfig().formUriBasicAuthPassword())) goto _L6; else goto _L5
_L5:
        HttpRequest httprequest;
        httprequest = new HttpRequest();
        httprequest.setConnectionTimeOut(ACRA.getConfig().connectionTimeout());
        httprequest.setSocketTimeOut(ACRA.getConfig().socketTimeout());
        httprequest.setMaxNrRetries(ACRA.getConfig().maxNumberOfRequestRetries());
        httprequest.setLogin(s);
        httprequest.setPassword(((String) (obj)));
        httprequest.setHeaders(ACRA.getConfig().getHttpHeaders());
        static class _cls1
        {

            static final int $SwitchMap$org$acra$sender$HttpSender$Method[];
            static final int $SwitchMap$org$acra$sender$HttpSender$Type[];

            static 
            {
                $SwitchMap$org$acra$sender$HttpSender$Method = new int[Method.values().length];
                try
                {
                    $SwitchMap$org$acra$sender$HttpSender$Method[Method.POST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$acra$sender$HttpSender$Method[Method.PUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$org$acra$sender$HttpSender$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$org$acra$sender$HttpSender$Type[Type.JSON.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$acra$sender$HttpSender$Type[Type.FORM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.acra.sender.HttpSender.Type[mType.ordinal()];
        JVM INSTR tableswitch 1 1: default 459
    //                   1 390;
           goto _L7 _L8
_L7:
        s = HttpRequest.getParamsAsFormString(remap(crashreportdata));
_L14:
        obj = url;
        _cls1..SwitchMap.org.acra.sender.HttpSender.Method[mMethod.ordinal()];
        JVM INSTR tableswitch 1 2: default 462
    //                   1 442
    //                   2 401;
           goto _L9 _L10 _L11
_L9:
        throw new UnsupportedOperationException((new StringBuilder()).append("Unknown method: ").append(mMethod.name()).toString());
_L2:
        try
        {
            url = new URL(mFormUri.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CrashReportData crashreportdata)
        {
            throw new ReportSenderException((new StringBuilder()).append("Error while sending ").append(ACRA.getConfig().reportType()).append(" report via Http ").append(mMethod.name()).toString(), crashreportdata);
        }
        // Misplaced declaration of an exception variable
        catch (CrashReportData crashreportdata)
        {
            throw new ReportSenderException((new StringBuilder()).append("Error while sending ").append(ACRA.getConfig().reportType()).append(" report via Http ").append(mMethod.name()).toString(), crashreportdata);
        }
          goto _L12
_L4:
        s = ACRA.getConfig().formUriBasicAuthLogin();
          goto _L13
_L6:
        obj = ACRA.getConfig().formUriBasicAuthPassword();
          goto _L5
_L8:
        s = crashreportdata.toJSON().toString();
          goto _L14
_L11:
        obj = new URL((new StringBuilder()).append(url.toString()).append('/').append(crashreportdata.getProperty(ReportField.REPORT_ID)).toString());
_L10:
        httprequest.send(((URL) (obj)), mMethod, s, mType);
        return;
          goto _L12
    }
}
