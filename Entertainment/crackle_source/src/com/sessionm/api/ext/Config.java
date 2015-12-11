// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api.ext;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import java.util.Map;

public class Config
{

    public static com.sessionm.core.ServerType SERVER_TYPE_CUSTOM;
    public static com.sessionm.core.ServerType SERVER_TYPE_DEVELOPMENT;
    public static com.sessionm.core.ServerType SERVER_TYPE_JAPAN;
    public static com.sessionm.core.ServerType SERVER_TYPE_PRODUCTION;
    private static final Config instance = new Config();
    private Map transitionButtonMap;
    private Map transitionMessageMap;
    private BitmapDrawable transitionViewErrorIcon;
    private AnimationDrawable transitionViewLoader;
    private String transitionViewTitle;

    private Config()
    {
    }

    private com.sessionm.core.Config getConfig()
    {
        return com.sessionm.core.Config.h();
    }

    public static Config getInstance()
    {
        return instance;
    }

    public com.sessionm.core.ServerType getServerType()
    {
        return getConfig().getServerType();
    }

    public Map getTransitionButtonMap()
    {
        return transitionButtonMap;
    }

    public Map getTransitionMessageMap()
    {
        return transitionMessageMap;
    }

    public BitmapDrawable getTransitionViewErrorIcon()
    {
        return transitionViewErrorIcon;
    }

    public AnimationDrawable getTransitionViewLoader()
    {
        return transitionViewLoader;
    }

    public String getTransitionViewTitle()
    {
        return transitionViewTitle;
    }

    public void setServerType(com.sessionm.core.ServerType servertype)
    {
        getConfig().setServerType(servertype, new String[0]);
    }

    public transient void setServerType(com.sessionm.core.ServerType servertype, String as[])
    {
        getConfig().setServerType(servertype, as);
    }

    public void setTransitionButtonMap(Map map)
    {
        transitionButtonMap = map;
    }

    public void setTransitionMessageMap(Map map)
    {
        transitionMessageMap = map;
    }

    public void setTransitionViewErrorIcon(BitmapDrawable bitmapdrawable)
    {
        transitionViewErrorIcon = bitmapdrawable;
    }

    public void setTransitionViewLoader(AnimationDrawable animationdrawable)
    {
        transitionViewLoader = animationdrawable;
    }

    public void setTransitionViewTitle(String s)
    {
        transitionViewTitle = s;
    }

    static 
    {
        SERVER_TYPE_DEVELOPMENT = com.sessionm.core.ServerType.ar;
        SERVER_TYPE_PRODUCTION = com.sessionm.core.ServerType.ap;
        SERVER_TYPE_JAPAN = com.sessionm.core.ServerType.as;
        SERVER_TYPE_CUSTOM = com.sessionm.core.ServerType.at;
    }
}
