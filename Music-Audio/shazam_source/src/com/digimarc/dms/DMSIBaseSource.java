// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSIBase

public abstract class DMSIBaseSource extends DMSIBase
{

    private String configOptionsJSON;
    private String sourceName;
    private String sourceType;

    public DMSIBaseSource()
    {
    }

    public boolean attachToDMS()
    {
        return true;
    }

    public void detachFromDMS()
    {
    }

    public String getConfigOptionsJSON()
    {
        return configOptionsJSON;
    }

    public String getSourceName()
    {
        return sourceName;
    }

    public String getSourceType()
    {
        return sourceType;
    }

    public void setConfigOptionsJSON(String s)
    {
        configOptionsJSON = s;
    }

    public void setSourceName(String s)
    {
        sourceName = s;
    }

    public void setSourceType(String s)
    {
        sourceType = s;
    }

    public void start()
    {
    }

    public void stop()
    {
    }
}
