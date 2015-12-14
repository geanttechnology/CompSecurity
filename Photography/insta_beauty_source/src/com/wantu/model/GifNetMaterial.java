// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model;

import boz;
import java.io.InputStream;
import java.io.Serializable;
import org.json.JSONObject;

public class GifNetMaterial
    implements Serializable
{

    private static final long serialVersionUID = 0x742e60b41e8a17d0L;
    private String alias;
    private String classfication;
    private int displayMode;
    private String id;
    private String localGifUrl;
    private String localIconUrl;
    private String name;
    private String netGifUrl;
    private String netIconUrl;
    private String publishtime;
    private boolean repeatable;

    public GifNetMaterial()
    {
        displayMode = 0;
        repeatable = false;
    }

    private String getAliasSubItem(String s)
    {
        String as[] = alias.split(";");
        for (int i = 0; i < as.length; i++)
        {
            String s1 = as[i];
            if (!s1.startsWith((new StringBuilder()).append(s).append("-").toString()))
            {
                continue;
            }
            String as1[] = s1.split("-");
            if (as1.length >= 2)
            {
                return as1[1];
            }
        }

        return null;
    }

    private void stringToObject(String s)
    {
        s = (new JSONObject(s)).getJSONObject("materials");
        id = s.getString("id");
        name = s.getString("name");
        alias = s.getString("alias");
        if (s.has("classfication"))
        {
            classfication = s.getString("classfication");
        }
        if (s.has("netIconUrl"))
        {
            netIconUrl = s.getString("netIconUrl");
        }
        if (s.has("localIconUrl"))
        {
            localIconUrl = s.getString("localIconUrl");
        }
        if (s.has("netGifUrl"))
        {
            netGifUrl = s.getString("netGifUrl");
        }
        if (s.has("localGifUrl"))
        {
            localGifUrl = s.getString("localGifUrl");
        }
        if (s.has("publishtime"))
        {
            publishtime = s.getString("publishtime");
        }
    }

    public void Load(InputStream inputstream)
    {
        stringToObject(boz.b(inputstream));
    }

    public void Load(String s)
    {
        stringToObject(boz.b(s));
    }

    public String getAlias()
    {
        return alias;
    }

    public String getClassfication()
    {
        return classfication;
    }

    public int getDisplayMode()
    {
        if (alias == null)
        {
            return displayMode;
        }
        String s = getAliasSubItem("rt");
        if (s != null)
        {
            try
            {
                displayMode = Integer.parseInt(s);
            }
            catch (Exception exception) { }
        }
        return displayMode;
    }

    public String getId()
    {
        return id;
    }

    public String getLocalGifUrl()
    {
        return localGifUrl;
    }

    public String getLocalIconUrl()
    {
        return localIconUrl;
    }

    public String getName()
    {
        return name;
    }

    public String getNetGifUrl()
    {
        return netGifUrl;
    }

    public String getNetIconUrl()
    {
        return netIconUrl;
    }

    public String getPublishtime()
    {
        return publishtime;
    }

    public boolean getRepeatable()
    {
        String s;
        if (alias == null)
        {
            return repeatable;
        }
        s = getAliasSubItem("r");
        if (s == null) goto _L2; else goto _L1
_L1:
        int i = Integer.parseInt(s);
        if (i != 0) goto _L4; else goto _L3
_L3:
        try
        {
            repeatable = false;
        }
        catch (Exception exception) { }
_L2:
        return repeatable;
_L4:
        if (i != 1) goto _L2; else goto _L5
_L5:
        repeatable = true;
          goto _L2
    }

    public void save(String s)
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("id", id);
        jsonobject.put("name", name);
        jsonobject.put("alias", alias);
        if (classfication != null)
        {
            jsonobject.put("classfication", classfication);
        }
        jsonobject.put("netIconUrl", netIconUrl);
        jsonobject.put("localIconUrl", localIconUrl);
        jsonobject.put("netGifUrl", netGifUrl);
        jsonobject.put("localGifUrl", localGifUrl);
        if (publishtime != null)
        {
            jsonobject.put("publishtime", publishtime);
        }
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("materials", jsonobject);
        boz.a(s, jsonobject1.toString(), false);
    }

    public void setAlias(String s)
    {
        alias = s;
    }

    public void setClassfication(String s)
    {
        classfication = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setLocalGifUrl(String s)
    {
        localGifUrl = s;
    }

    public void setLocalIconUrl(String s)
    {
        localIconUrl = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setNetGifUrl(String s)
    {
        netGifUrl = s;
    }

    public void setNetIconUrl(String s)
    {
        netIconUrl = s;
    }

    public void setPublishtime(String s)
    {
        publishtime = s;
    }
}
