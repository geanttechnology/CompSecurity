// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;


class BrowserInfo
{

    String m_browserPluginCount;
    String m_browserPlugins;
    String m_browserPluginsFromJS;
    String m_browserPluginsFromJSHash;
    String m_browserStringFromJS;
    int m_mimeTypeCount;
    String m_mimeTypes;
    String m_mimeTypesHash;

    BrowserInfo()
    {
        m_browserPlugins = null;
        m_browserPluginCount = "0";
        m_browserPluginsFromJS = null;
        m_browserPluginsFromJSHash = null;
        m_browserStringFromJS = null;
        m_mimeTypeCount = 0;
        m_mimeTypes = null;
        m_mimeTypesHash = null;
    }

    public String getBrowserPluginCount()
    {
        return m_browserPluginCount;
    }

    public String getBrowserPlugins()
    {
        return m_browserPlugins;
    }

    public String getBrowserPluginsFromJSHash()
    {
        return m_browserPluginsFromJSHash;
    }

    public int getMimeTypeCount()
    {
        return m_mimeTypeCount;
    }

    public String getMimeTypesHash()
    {
        return m_mimeTypesHash;
    }
}
