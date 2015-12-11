// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.bean;


// Referenced classes of package com.igexin.sdk.bean:
//            BaseBean

public class NotificationBean extends BaseBean
{

    private String banner_url;
    private String banner_url_src;
    private String content;
    private boolean is_noclear;
    private boolean is_noring;
    private boolean is_novibrate;
    private String logo;
    private String title;
    private String url_logo;
    private String url_logo_src;

    public NotificationBean()
    {
        is_noclear = false;
        is_novibrate = false;
        is_noring = false;
        logo = null;
        url_logo = null;
        banner_url = null;
        url_logo_src = null;
        banner_url_src = null;
    }

    public String getBanner_url()
    {
        return banner_url;
    }

    public String getBanner_url_src()
    {
        return banner_url_src;
    }

    public String getContent()
    {
        return content;
    }

    public String getLogo()
    {
        if (logo == null)
        {
            return "";
        } else
        {
            return logo;
        }
    }

    public String getTitle()
    {
        return title;
    }

    public String getUrl_logo()
    {
        return url_logo;
    }

    public String getUrl_logo_src()
    {
        return url_logo_src;
    }

    public boolean isIs_noclear()
    {
        return is_noclear;
    }

    public boolean isIs_noring()
    {
        return is_noring;
    }

    public boolean isIs_novibrate()
    {
        return is_novibrate;
    }

    public void setBanner_url(String s)
    {
        banner_url = s;
    }

    public void setBanner_url_src(String s)
    {
        banner_url_src = s;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setIs_noclear(boolean flag)
    {
        is_noclear = flag;
    }

    public void setIs_noring(boolean flag)
    {
        is_noring = flag;
    }

    public void setIs_novibrate(boolean flag)
    {
        is_novibrate = flag;
    }

    public void setLogo(String s)
    {
        logo = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setUrl_logo(String s)
    {
        url_logo = s;
    }

    public void setUrl_logo_src(String s)
    {
        url_logo_src = s;
    }
}
