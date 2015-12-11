// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import java.util.List;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            Brand, Hardware, Manufacturer, ModelName, 
//            MatchBase

public class Rules
{

    private List actions;
    private Brand brand;
    private Hardware hardware;
    private Manufacturer manufacturer;
    private String maxDMSDKVersion;
    private String maxOSVersion;
    private String minDMSDKVersion;
    private String minOSVersion;
    private ModelName modelName;
    private String ruleName;

    public Rules()
    {
    }

    public List getActions()
    {
        return actions;
    }

    public MatchBase getBrand()
    {
        return brand;
    }

    public MatchBase getHardware()
    {
        return hardware;
    }

    public MatchBase getManufacturer()
    {
        return manufacturer;
    }

    public String getMaxDMSDKVersion()
    {
        return maxDMSDKVersion;
    }

    public String getMaxOSVersion()
    {
        return maxOSVersion;
    }

    public String getMinDMSDKVersion()
    {
        return minDMSDKVersion;
    }

    public String getMinOSVersion()
    {
        return minOSVersion;
    }

    public ModelName getModelName()
    {
        return modelName;
    }

    public String getRuleName()
    {
        return ruleName;
    }

    public void setActions(List list)
    {
        actions = list;
    }

    public void setBrand(Brand brand1)
    {
        brand = brand1;
    }

    public void setHardware(Hardware hardware1)
    {
        hardware = hardware1;
    }

    public void setManufacturer(Manufacturer manufacturer1)
    {
        manufacturer = manufacturer1;
    }

    public void setMaxDMSDKVersion(String s)
    {
        maxDMSDKVersion = s;
    }

    public void setMaxOSVersion(String s)
    {
        maxOSVersion = s;
    }

    public void setMinDMSDKVersion(String s)
    {
        minDMSDKVersion = s;
    }

    public void setMinOSVersion(String s)
    {
        minOSVersion = s;
    }

    public void setModelName(ModelName modelname)
    {
        modelName = modelname;
    }

    public void setRuleName(String s)
    {
        ruleName = s;
    }
}
