// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.event;

import com.exacttarget.etpushsdk.data.AnalyticItem;
import com.exacttarget.etpushsdk.util.k;
import com.exacttarget.etpushsdk.util.m;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.event:
//            IEventFactory

public class AnalyticItemEvent extends ArrayList
    implements IEventFactory
{

    private static final String TAG = "~!AnalyticItemEvent";
    private static final long serialVersionUID = 1L;
    private List databaseIds;

    public AnalyticItemEvent()
    {
    }

    public AnalyticItemEvent fromJson(String s)
    {
        SimpleDateFormat simpledateformat;
        JSONArray jsonarray;
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        jsonarray = new JSONArray(s);
        Object obj = this;
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int i;
        i = 0;
        s = simpledateformat;
_L4:
        obj = this;
        if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
        JSONObject jsonobject;
        AnalyticItem analyticitem;
        jsonobject = jsonarray.optJSONObject(i);
        analyticitem = new AnalyticItem();
        analyticitem.setEtAppId("etAppId");
        analyticitem.setDeviceId("deviceId");
        analyticitem.setEventDate(s.parse(jsonobject.getString("eventDate")));
_L5:
        analyticitem.setValue(Integer.valueOf(jsonobject.getInt("value")));
        analyticitem.setObjectIds(k.a(jsonobject.getJSONArray("objectIds")));
        analyticitem.setAnalyticTypes(k.a(jsonobject.getJSONArray("analyticTypes")));
        add(analyticitem);
        i++;
          goto _L4
        obj;
        obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        analyticitem.setEventDate(((DateFormat) (obj)).parse(jsonobject.getString("eventDate")));
        s = ((String) (obj));
          goto _L5
        obj;
_L7:
        ((ParseException) (obj)).printStackTrace();
          goto _L5
        s;
        m.c("~!AnalyticItemEvent", s.getMessage(), s);
        obj = null;
_L2:
        return ((AnalyticItemEvent) (obj));
        obj;
_L6:
        ((JSONException) (obj)).printStackTrace();
          goto _L5
        obj;
        ((JSONException) (obj)).printStackTrace();
          goto _L5
        Object obj1;
        obj1;
        s = ((String) (obj));
        obj = obj1;
          goto _L6
        obj1;
        s = ((String) (obj));
        obj = obj1;
          goto _L7
    }

    public volatile Object fromJson(String s)
    {
        return fromJson(s);
    }

    public List getDatabaseIds()
    {
        return databaseIds;
    }

    public void setDatabaseIds(AnalyticItemEvent analyticitemevent, List list)
    {
        analyticitemevent.setDatabaseIds(list);
    }

    public volatile void setDatabaseIds(Object obj, List list)
    {
        setDatabaseIds((AnalyticItemEvent)obj, list);
    }

    public void setDatabaseIds(List list)
    {
        databaseIds = list;
    }
}
