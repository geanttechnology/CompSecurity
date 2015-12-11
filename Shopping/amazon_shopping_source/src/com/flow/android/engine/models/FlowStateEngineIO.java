// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.models;


public class FlowStateEngineIO
{

    private String application;
    private String clientDeviceID;
    private String clientSessionID;
    private String clientVersion;
    private String errorReportingServer;
    private String imgServer;
    private boolean isDataCollectionDisabled;
    private boolean printToScreen;
    private String secret;
    private String textServer;
    private boolean useLogFile;
    private String username;

    public FlowStateEngineIO()
    {
    }

    public String getApplication()
    {
        return application;
    }

    public String getClientDeviceID()
    {
        return clientDeviceID;
    }

    public String getClientSessionID()
    {
        return clientSessionID;
    }

    public String getClientVersion()
    {
        return clientVersion;
    }

    public String getErrorReportingServer()
    {
        return errorReportingServer;
    }

    public String getImgServer()
    {
        return imgServer;
    }

    public String getSecret()
    {
        return secret;
    }

    public String getTextServer()
    {
        return textServer;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isDataCollectionDisabled()
    {
        return isDataCollectionDisabled;
    }

    public boolean isPrintToScreen()
    {
        return printToScreen;
    }

    public boolean isUseLogFile()
    {
        return useLogFile;
    }

    public void setApplication(String s)
    {
        application = s;
    }

    public void setClientDeviceID(String s)
    {
        clientDeviceID = s;
    }

    public void setClientSessionID(String s)
    {
        clientSessionID = s;
    }

    public void setClientVersion(String s)
    {
        clientVersion = s;
    }

    public void setDataCollectionDisabled(boolean flag)
    {
        isDataCollectionDisabled = flag;
    }

    public void setErrorReportingServer(String s)
    {
        errorReportingServer = s;
    }

    public void setImgServer(String s)
    {
        imgServer = s;
    }

    public void setPrintToScreen(boolean flag)
    {
        printToScreen = flag;
    }

    public void setSecret(String s)
    {
        secret = s;
    }

    public void setTextServer(String s)
    {
        textServer = s;
    }

    public void setUseLogFile(boolean flag)
    {
        useLogFile = flag;
    }

    public void setUsername(String s)
    {
        username = s;
    }
}
