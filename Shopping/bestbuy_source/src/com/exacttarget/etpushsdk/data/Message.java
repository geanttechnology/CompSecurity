// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.data;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.exacttarget.etpushsdk.data:
//            Attribute

public class Message
    implements Serializable
{

    public static final Integer a = Integer.valueOf(0);
    public static final Integer b = Integer.valueOf(1);
    public static final Integer c = Integer.valueOf(2);
    public static final Integer d = Integer.valueOf(3);
    public static final Integer e = Integer.valueOf(4);
    public static final Integer f = Integer.valueOf(5);
    public static final Integer g = Integer.valueOf(0);
    public static final Integer h = Integer.valueOf(1);
    public static final Integer i = Integer.valueOf(2);
    public static final Integer j = Integer.valueOf(3);
    private Date A;
    private Date B;
    private Integer C;
    private Integer D;
    private Integer E;
    private ArrayList F;
    private String G;
    private String H;
    private Boolean I;
    private String J;
    private String K;
    private String L;
    private String M;
    private Boolean N;
    private Boolean O;
    private Boolean P;
    private Integer Q;
    private Integer R;
    private Long S;
    private Integer k;
    private int l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private Date s;
    private Date t;
    private Integer u;
    private Integer v;
    private Integer w;
    private Integer x;
    private Boolean y;
    private Integer z;

    public Message()
    {
        k = Integer.valueOf(0);
        l = 2;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = new Date(System.currentTimeMillis() - 1000L);
        t = null;
        u = null;
        v = null;
        w = Integer.valueOf(-1);
        x = Integer.valueOf(-1);
        y = Boolean.TRUE;
        z = Integer.valueOf(-1);
        A = new Date(System.currentTimeMillis() - 1000L);
        B = null;
        C = Integer.valueOf(0);
        D = Integer.valueOf(0);
        E = Integer.valueOf(0);
        F = null;
        H = null;
        I = Boolean.FALSE;
        N = Boolean.FALSE;
        O = Boolean.FALSE;
        P = Boolean.FALSE;
        R = Integer.valueOf(0);
        S = Long.valueOf(0L);
    }

    public Message(JSONObject jsonobject)
    {
        int i1 = 0;
        super();
        k = Integer.valueOf(0);
        l = 2;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = new Date(System.currentTimeMillis() - 1000L);
        t = null;
        u = null;
        v = null;
        w = Integer.valueOf(-1);
        x = Integer.valueOf(-1);
        y = Boolean.TRUE;
        z = Integer.valueOf(-1);
        A = new Date(System.currentTimeMillis() - 1000L);
        B = null;
        C = Integer.valueOf(0);
        D = Integer.valueOf(0);
        E = Integer.valueOf(0);
        F = null;
        H = null;
        I = Boolean.FALSE;
        N = Boolean.FALSE;
        O = Boolean.FALSE;
        P = Boolean.FALSE;
        R = Integer.valueOf(0);
        S = Long.valueOf(0L);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
        if (jsonobject.has("id"))
        {
            setId(jsonobject.getString("id"));
        }
        if (jsonobject.has("alert"))
        {
            setAlert(jsonobject.getString("alert"));
        }
        if (jsonobject.has("sound"))
        {
            setSound(jsonobject.getString("sound"));
        }
        if (jsonobject.has("badge"))
        {
            setBadge(jsonobject.getString("badge"));
        }
        if (jsonobject.has("startDateUtc"))
        {
            setStartDate(simpledateformat.parse(jsonobject.getString("startDateUtc")));
        }
        if (jsonobject.has("endDateUtc"))
        {
            setEndDate(simpledateformat.parse(jsonobject.getString("endDateUtc")));
        }
        if (jsonobject.has("messageType"))
        {
            setMessageType(Integer.valueOf(jsonobject.getInt("messageType")));
        }
        if (jsonobject.has("contentType"))
        {
            setContentType(Integer.valueOf(jsonobject.getInt("contentType")));
        }
        if (jsonobject.has("subject"))
        {
            setSubject(jsonobject.getString("subject"));
        }
        if (jsonobject.has("url"))
        {
            setUrl(jsonobject.getString("url"));
        }
        if (jsonobject.has("pageId"))
        {
            setPageId(String.valueOf(jsonobject.getInt("pageId")));
        }
        if (jsonobject.has("messageType"))
        {
            setMessageType(Integer.valueOf(jsonobject.getInt("messageType")));
        }
        if (jsonobject.has("contentType"))
        {
            setContentType(Integer.valueOf(jsonobject.getInt("contentType")));
        }
        if (jsonobject.has("messageObjectPerPeriod"))
        {
            setMessagesPerPeriod(Integer.valueOf(jsonobject.getInt("messageObjectPerPeriod")));
        }
        if (jsonobject.has("numberOfPeriods"))
        {
            setNumberOfPeriods(Integer.valueOf(jsonobject.getInt("numberOfPeriods")));
        }
        if (jsonobject.has("periodType"))
        {
            setPeriodType(Integer.valueOf(jsonobject.getInt("periodType")));
        }
        if (jsonobject.has("isRollingPeriod"))
        {
            setIsRollingPeriod(Boolean.valueOf(jsonobject.getBoolean("isRollingPeriod")));
        }
        if (jsonobject.has("messageLimit"))
        {
            setMessageLimit(Integer.valueOf(jsonobject.getInt("messageLimit")));
        }
        if (jsonobject.has("keys"))
        {
            jsonobject = jsonobject.getJSONArray("keys");
            ArrayList arraylist = new ArrayList();
            for (; i1 < jsonobject.length(); i1++)
            {
                JSONObject jsonobject1 = jsonobject.getJSONObject(i1);
                Attribute attribute = new Attribute();
                attribute.setKey(jsonobject1.getString("key"));
                attribute.setValue(jsonobject1.getString("value"));
                arraylist.add(attribute);
            }

            setKeys(arraylist);
        }
    }

    public String getAlert()
    {
        return n;
    }

    public String getBadge()
    {
        return p;
    }

    public String getCategory()
    {
        return r;
    }

    public Integer getContentType()
    {
        return v;
    }

    public String getCustom()
    {
        if (H == null)
        {
            return G;
        } else
        {
            return H;
        }
    }

    public String getCustomObj()
    {
        return H;
    }

    public Date getEndDate()
    {
        return t;
    }

    public Long getEntryTime()
    {
        return S;
    }

    public Boolean getEphemeralMessage()
    {
        return O;
    }

    public Boolean getHasEntered()
    {
        return P;
    }

    public String getId()
    {
        return m;
    }

    public Boolean getIsRollingPeriod()
    {
        return y;
    }

    public ArrayList getKeys()
    {
        return F;
    }

    public Date getLastShownDate()
    {
        return B;
    }

    public Integer getLoiterSeconds()
    {
        return R;
    }

    public Boolean getMessageDeleted()
    {
        return N;
    }

    public Integer getMessageLimit()
    {
        return z;
    }

    public Integer getMessageType()
    {
        return u;
    }

    public Integer getMessagesPerPeriod()
    {
        return w;
    }

    public Integer getMinTripped()
    {
        return E;
    }

    public Date getNextAllowedShow()
    {
        return A;
    }

    public Integer getNotifyId()
    {
        return Q;
    }

    public Integer getNumberOfPeriods()
    {
        return x;
    }

    public String getOpenDirect()
    {
        return q;
    }

    public String getPageId()
    {
        return M;
    }

    public Integer getPeriodShowCount()
    {
        return D;
    }

    public Integer getPeriodType()
    {
        return k;
    }

    public int getProximity()
    {
        return l;
    }

    public Boolean getRead()
    {
        return I;
    }

    public Integer getShowCount()
    {
        return C;
    }

    public String getSiteId()
    {
        return J;
    }

    public String getSound()
    {
        return o;
    }

    public Date getStartDate()
    {
        return s;
    }

    public String getSubject()
    {
        if (K == null && n == null)
        {
            return "A new message";
        }
        if (K == null)
        {
            return n;
        } else
        {
            return K;
        }
    }

    public String getUrl()
    {
        return L;
    }

    public void setAlert(String s1)
    {
        n = s1;
    }

    public void setBadge(String s1)
    {
        p = s1;
    }

    public void setCategory(String s1)
    {
        r = s1;
    }

    public void setContentType(Integer integer)
    {
        v = integer;
    }

    public void setCustom(String s1)
    {
        G = s1;
    }

    public void setCustomObj(String s1)
    {
        H = s1;
    }

    public void setEndDate(Date date)
    {
        t = date;
    }

    public void setEntryTime(Long long1)
    {
        S = long1;
    }

    public void setEphemeralMessage(Boolean boolean1)
    {
        O = boolean1;
    }

    public void setHasEntered(Boolean boolean1)
    {
        P = boolean1;
    }

    public void setId(String s1)
    {
        m = s1;
    }

    public void setIsRollingPeriod(Boolean boolean1)
    {
        y = boolean1;
    }

    public void setKeys(ArrayList arraylist)
    {
        F = arraylist;
    }

    public void setLastShownDate(Date date)
    {
        B = date;
    }

    public void setLoiterSeconds(Integer integer)
    {
        R = integer;
    }

    public void setMessageDeleted(Boolean boolean1)
    {
        N = boolean1;
    }

    public void setMessageLimit(Integer integer)
    {
        z = integer;
    }

    public void setMessageType(Integer integer)
    {
        u = integer;
    }

    public void setMessagesPerPeriod(Integer integer)
    {
        w = integer;
    }

    public void setMinTripped(Integer integer)
    {
        E = integer;
    }

    public void setNextAllowedShow(Date date)
    {
        A = date;
    }

    public void setNotifyId(Integer integer)
    {
        Q = integer;
    }

    public void setNumberOfPeriods(Integer integer)
    {
        x = integer;
    }

    public void setOpenDirect(String s1)
    {
        q = s1;
    }

    public void setPageId(String s1)
    {
        M = s1;
    }

    public void setPeriodShowCount(Integer integer)
    {
        D = integer;
    }

    public void setPeriodType(Integer integer)
    {
        k = integer;
    }

    public void setProximity(int i1)
    {
        l = i1;
    }

    public void setRead(Boolean boolean1)
    {
        I = boolean1;
    }

    public void setShowCount(Integer integer)
    {
        C = integer;
    }

    public void setSiteId(String s1)
    {
        J = s1;
    }

    public void setSound(String s1)
    {
        o = s1;
    }

    public void setStartDate(Date date)
    {
        s = date;
    }

    public void setSubject(String s1)
    {
        K = s1;
    }

    public void setUrl(String s1)
    {
        L = s1;
    }

}
