// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import java.util.List;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            Rules

public class CameraSettingsKB
{

    private String docType;
    private String kbVersion;
    private String platform;
    private Rules ruleUsed;
    private List rules;

    public CameraSettingsKB()
    {
        ruleUsed = null;
    }

    public String getDocType()
    {
        return docType;
    }

    public String getKbVersion()
    {
        return kbVersion;
    }

    public String getPlatform()
    {
        return platform;
    }

    public Rules getRuleUsed()
    {
        return ruleUsed;
    }

    public List getRules()
    {
        return rules;
    }

    public void setDocType(String s)
    {
        docType = s;
    }

    public void setKbVersion(String s)
    {
        kbVersion = s;
    }

    public void setPlatform(String s)
    {
        platform = s;
    }

    public void setRuleUsed(Rules rules1)
    {
        ruleUsed = rules1;
    }

    public void setRules(List list)
    {
        rules = list;
    }
}
