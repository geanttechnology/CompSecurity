// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.data;


public class DynamicConfig
{

    private String downloadUrl;
    private boolean isEncrypt;
    private String masterAppID;
    private String masterPkgName;
    private String masterServiceAction;

    public DynamicConfig()
    {
    }

    public String getDownloadUrl()
    {
        return downloadUrl;
    }

    public String getMasterAppID()
    {
        return masterAppID;
    }

    public String getMasterPkgName()
    {
        return masterPkgName;
    }

    public String getMasterServiceAction()
    {
        return masterServiceAction;
    }

    public boolean isEncrypt()
    {
        return isEncrypt;
    }

    public void setDownloadUrl(String s)
    {
        downloadUrl = s;
    }

    public void setEncrypt(boolean flag)
    {
        isEncrypt = flag;
    }

    public void setMasterAppID(String s)
    {
        masterAppID = s;
    }

    public void setMasterPkgName(String s)
    {
        masterPkgName = s;
    }

    public void setMasterServiceAction(String s)
    {
        masterServiceAction = s;
    }
}
