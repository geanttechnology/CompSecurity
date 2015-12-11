// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.bean;

import java.util.List;

// Referenced classes of package com.igexin.sdk.bean:
//            BaseBean

public class PopupBean extends BaseBean
{

    private List buttons;
    private String content;
    private String imageUrl;
    private String img_src;
    private String title;

    public PopupBean()
    {
        img_src = null;
    }

    public List getButtons()
    {
        return buttons;
    }

    public String getContent()
    {
        return content;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getImg_src()
    {
        return img_src;
    }

    public String getTitle()
    {
        return title;
    }

    public void setButtons(List list)
    {
        buttons = list;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setImg_src(String s)
    {
        img_src = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
