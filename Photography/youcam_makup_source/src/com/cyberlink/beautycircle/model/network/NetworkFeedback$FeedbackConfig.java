// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import java.io.Serializable;
import java.util.List;

public class bNeedLog
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    public String apiUri;
    public String appversion;
    public List attachmentPath;
    public boolean bNeedLog;
    public String hwid;
    public String phoneid;
    public String product;
    public String sr;
    public String umaid;
    public String version;
    public String versionUpgradeHistory;

    public ()
    {
        bNeedLog = true;
    }
}
