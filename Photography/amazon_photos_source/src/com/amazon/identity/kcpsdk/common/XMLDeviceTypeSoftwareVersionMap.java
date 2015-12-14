// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            XMLEntity, XMLElement, SoftwareInfo, XMLAttribute

public class XMLDeviceTypeSoftwareVersionMap extends XMLEntity
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/XMLDeviceTypeSoftwareVersionMap.getName();
    private final Map mDeviceTypeSoftwareVersionMap;

    public XMLDeviceTypeSoftwareVersionMap(Map map)
    {
        mDeviceTypeSoftwareVersionMap = map;
    }

    void toXML(Element element)
    {
        if (mDeviceTypeSoftwareVersionMap == null || mDeviceTypeSoftwareVersionMap.size() == 0)
        {
            return;
        }
        XMLElement xmlelement = new XMLElement("deviceTypeSoftwareVersionMap", new XMLEntity[0]);
        for (Iterator iterator = mDeviceTypeSoftwareVersionMap.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            SoftwareInfo softwareinfo = (SoftwareInfo)entry.getValue();
            if (softwareinfo != null && softwareinfo.getSoftwareVersion() != null && softwareinfo.getSoftwareComponentId() != null && entry.getKey() != null)
            {
                xmlelement.addNewChild(new XMLElement("entry", new XMLEntity[] {
                    new XMLAttribute("deviceType", (String)entry.getKey()), new XMLAttribute("version", ((SoftwareInfo)entry.getValue()).getSoftwareVersion().toString()), new XMLAttribute("softwareComponentId", ((SoftwareInfo)entry.getValue()).getSoftwareComponentId())
                }));
            } else
            {
                MAPLog.formattedWarning(TAG, "Skipping version for entry %s - version not present", new Object[] {
                    entry.getKey()
                });
            }
        }

        xmlelement.toXML(element);
    }

}
