// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.sdk;

import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.MobileTrackingLogger;
import com.groupon.tracking.mobile.events.MobileEvent;
import com.groupon.tracking.mobile.internal.LogClient;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.tracking.mobile.sdk:
//            InfoFunctor, ExceptionFunctor

public class Logger extends MobileTrackingLogger
{

    public static final String LOGGING_ENABLED = "LOGGING_ENABLED";
    public static final float NULL_FLOAT = 0F;
    public static final int NULL_INT = 0;
    public static final EncodedNSTField NULL_NST_FIELD = null;
    public static final String NULL_STRING = "";
    private LogClient client;
    boolean enabled;
    private ExceptionFunctor exceptionFunctor;
    private InfoFunctor infoFunctor;
    private boolean shouldScheduleUpload;

    public Logger()
    {
        this(true);
    }

    public Logger(boolean flag)
    {
        shouldScheduleUpload = flag;
    }

    public transient String encodeAsCSV(String as[])
    {
        return join(",", Arrays.asList(as));
    }

    public String encodeAsJsonObject(HashMap hashmap)
    {
        JSONObject jsonobject = new JSONObject();
        if (hashmap != null)
        {
            hashmap = hashmap.entrySet().iterator();
            try
            {
                while (hashmap.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)hashmap.next();
                    jsonobject.accumulate((String)entry.getKey(), entry.getValue());
                }
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap)
            {
                Ln.e((new StringBuilder()).append("Invalid name-value pairs to encode in JsonObject: ").append(hashmap).toString(), new Object[0]);
            }
        }
        return jsonobject.toString();
    }

    public void forceLogRotate()
    {
        if (enabled)
        {
            client.forceRotateLog();
        }
    }

    public void info(String s)
    {
        if (infoFunctor != null)
        {
            infoFunctor.logInfo(s);
        }
    }

    public String join(String s, Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            return "";
        }
        collection = collection.iterator();
        StringBuilder stringbuilder = new StringBuilder(Strings.toString(collection.next()));
        Object obj;
        for (; collection.hasNext(); stringbuilder.append(s).append(Strings.toString(obj)))
        {
            obj = collection.next();
        }

        return stringbuilder.toString();
    }

    public void log(MobileEvent mobileevent)
    {
        info((new StringBuilder()).append("TRACKING ").append(mobileevent.toString()).toString());
        if (!enabled)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        client.write(mobileevent.pack(), shouldScheduleUpload);
        return;
        mobileevent;
        log(((Exception) (mobileevent)));
        return;
    }

    public void log(Exception exception)
    {
        if (exceptionFunctor != null)
        {
            exceptionFunctor.logException(exception);
        }
    }

}
