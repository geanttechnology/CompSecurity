// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK.libcore;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class RawHeaders
{

    private static final Comparator FIELD_NAME_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((String)obj, (String)obj1);
        }

        public int compare(String s, String s1)
        {
            if (s == s1)
            {
                return 0;
            }
            if (s == null)
            {
                return -1;
            }
            if (s1 == null)
            {
                return 1;
            } else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(s, s1);
            }
        }

    };
    private int httpMinorVersion;
    private final List namesAndValues = new ArrayList(20);
    private String requestLine;
    private int responseCode;
    private String responseMessage;
    private String statusLine;

    public RawHeaders()
    {
        httpMinorVersion = 1;
        responseCode = -1;
    }

    private void addLenient(String s, String s1)
    {
        namesAndValues.add(s);
        namesAndValues.add(s1.trim());
    }

    public static RawHeaders fromMultimap(Map map, boolean flag)
        throws IOException
    {
        if (!flag)
        {
            throw new UnsupportedOperationException();
        }
        RawHeaders rawheaders = new RawHeaders();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (List)((java.util.Map.Entry) (obj)).getValue();
            if (s != null)
            {
                obj = ((List) (obj)).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    rawheaders.addLenient(s, (String)((Iterator) (obj)).next());
                }
            } else
            if (!((List) (obj)).isEmpty())
            {
                rawheaders.setStatusLine((String)((List) (obj)).get(((List) (obj)).size() - 1));
            }
        } while (true);
        return rawheaders;
    }

    public void addLine(String s)
    {
        int i = s.indexOf(":");
        if (i == -1)
        {
            addLenient("", s);
            return;
        } else
        {
            addLenient(s.substring(0, i), s.substring(i + 1));
            return;
        }
    }

    public String getFieldName(int i)
    {
        i *= 2;
        if (i < 0 || i >= namesAndValues.size())
        {
            return null;
        } else
        {
            return (String)namesAndValues.get(i);
        }
    }

    public String getStatusLine()
    {
        return statusLine;
    }

    public String getValue(int i)
    {
        i = i * 2 + 1;
        if (i < 0 || i >= namesAndValues.size())
        {
            return null;
        } else
        {
            return (String)namesAndValues.get(i);
        }
    }

    public int length()
    {
        return namesAndValues.size() / 2;
    }

    public void setStatusLine(String s)
        throws IOException
    {
        if (responseMessage != null)
        {
            throw new IllegalStateException("statusLine is already set");
        }
        boolean flag;
        if (s.length() > 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!s.startsWith("HTTP/1.") || s.length() < 12 || s.charAt(8) != ' ' || flag && s.charAt(12) != ' ')
        {
            throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
        }
        int i = s.charAt(7) - 48;
        if (i < 0 || i > 9)
        {
            throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
        }
        Object obj;
        int j;
        try
        {
            j = Integer.parseInt(s.substring(9, 12));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ProtocolException((new StringBuilder()).append("Unexpected status line: ").append(s).toString());
        }
        if (flag)
        {
            obj = s.substring(13);
        } else
        {
            obj = "";
        }
        responseMessage = ((String) (obj));
        responseCode = j;
        statusLine = s;
        httpMinorVersion = i;
    }

    public Map toMultimap(boolean flag)
    {
        TreeMap treemap;
        treemap = new TreeMap(FIELD_NAME_COMPARATOR);
        for (int i = 0; i < namesAndValues.size(); i += 2)
        {
            String s = (String)namesAndValues.get(i);
            String s1 = (String)namesAndValues.get(i + 1);
            ArrayList arraylist = new ArrayList();
            List list = (List)treemap.get(s);
            if (list != null)
            {
                arraylist.addAll(list);
            }
            arraylist.add(s1);
            treemap.put(s, Collections.unmodifiableList(arraylist));
        }

        if (!flag || statusLine == null) goto _L2; else goto _L1
_L1:
        treemap.put(null, Collections.unmodifiableList(Collections.singletonList(statusLine)));
_L4:
        return Collections.unmodifiableMap(treemap);
_L2:
        if (requestLine != null)
        {
            treemap.put(null, Collections.unmodifiableList(Collections.singletonList(requestLine)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
