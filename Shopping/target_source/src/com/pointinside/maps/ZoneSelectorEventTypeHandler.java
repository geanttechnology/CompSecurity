// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.sun.jna.ptr.IntByReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.maps:
//            EventTypeHandler, PIMap, PIMGLZonePickerEntry, PIMGL

class ZoneSelectorEventTypeHandler extends EventTypeHandler
{

    private final boolean mAnimated;
    private final Zone mFocusedZone;
    private final boolean mInteractive;
    private final List mZones;

    protected ZoneSelectorEventTypeHandler(PIMap pimap, List list, Zone zone, boolean flag, boolean flag1)
    {
        super(pimap);
        mZones = list;
        mFocusedZone = zone;
        mAnimated = flag;
        mInteractive = flag1;
    }

    public void execute()
    {
        int j = mZones.size();
        Object obj = map.getZonePickerEntryRef();
        PIMGLZonePickerEntry.ByReference byreference = ((PIMGLZonePickerEntry.ByReference) (obj));
        if (obj == null)
        {
            byreference = new PIMGLZonePickerEntry.ByReference();
            PIMGLZonePickerEntry apimglzonepickerentry[] = (PIMGLZonePickerEntry[])byreference.castToArray(j);
            Iterator iterator = mZones.iterator();
            int i = 0;
            while (iterator.hasNext()) 
            {
                Object obj2 = ((Zone)iterator.next()).getUUID();
                obj2 = (PIMGLZonePickerEntry)map.mZoneUUIDToZonePickerEntryMap.get(obj2);
                if (obj2 != null)
                {
                    apimglzonepickerentry[i].mZoneRef = ((PIMGLZonePickerEntry) (obj2)).mZoneRef;
                    apimglzonepickerentry[i].mName = ((PIMGLZonePickerEntry) (obj2)).mName;
                    apimglzonepickerentry[i].mUserdata = ((PIMGLZonePickerEntry) (obj2)).mUserdata;
                    i++;
                } else
                {
                    throw new IllegalStateException("Invalid zone found in the list");
                }
            }
            map.setZonePickerEntryRef(byreference);
        }
        apimglzonepickerentry = null;
        if (mFocusedZone != null)
        {
            apimglzonepickerentry = mFocusedZone.getUUID();
            apimglzonepickerentry = map.getZoneRefFromUUID(apimglzonepickerentry);
        }
        Object obj1 = apimglzonepickerentry;
        if (apimglzonepickerentry == null)
        {
            apimglzonepickerentry = ((Zone)map.getCurrentVenue().getAllZones().get(0)).getUUID();
            obj1 = map.getZoneRefFromUUID(apimglzonepickerentry);
        }
        apimglzonepickerentry = (IntByReference)map.mActionRefMap.get(PIMap.EventHandlerActions.STATIC_ZONE_SELECTOR);
        if (apimglzonepickerentry != null)
        {
            PIMGL.zonePicker_show(map.getPIMGLContext(), byreference, j, ((IntByReference) (obj1)), mInteractive, mAnimated, apimglzonepickerentry.getPointer());
        }
    }

    public void execute(IntByReference intbyreference)
    {
    }
}
