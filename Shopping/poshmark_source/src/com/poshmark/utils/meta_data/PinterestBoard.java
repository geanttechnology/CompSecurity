// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import java.util.HashMap;
import java.util.Map;

public class PinterestBoard
{

    public String board_id;
    public boolean enabled;
    public String image_url;
    public String name;

    public PinterestBoard()
    {
    }

    public Map getBoardHash()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("board_id", board_id);
        hashmap.put("name", name);
        String s;
        if (enabled)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        hashmap.put("enabled", s);
        return hashmap;
    }

    public String getDisplay()
    {
        return name;
    }

    public String getId()
    {
        return board_id;
    }

    public String getImage_url()
    {
        return image_url;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setBoard_id(String s)
    {
        board_id = s;
    }

    public void setEnabled(boolean flag)
    {
        enabled = flag;
    }

    public void setImage_url(String s)
    {
        image_url = s;
    }

    public void setName(String s)
    {
        name = s;
    }
}
