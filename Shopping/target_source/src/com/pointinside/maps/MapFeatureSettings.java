// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.maps.model.FeatureStyle;
import com.pointinside.model.Zone;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.util.Map;

// Referenced classes of package com.pointinside.maps:
//            PIMapError, PIMap, PIMGLFeatureAttrs, PIMGL, 
//            PIMGLColor

public final class MapFeatureSettings
{

    private final PIMap mMap;

    MapFeatureSettings(PIMap pimap)
    {
        mMap = pimap;
    }

    private IntByReference getZoneRef(Zone zone)
        throws PIMapError
    {
        zone = (IntByReference)mMap.mZoneUUIDToZoneRefMap.get(zone.getUUID());
        if (zone == null)
        {
            throw PIMapError.generateError(PIMapError.Kind.MAP_FEATURE, "Coundn't set feature style. Zone hasn't been loaded on map yet");
        } else
        {
            return zone;
        }
    }

    private void setStyle(String s, Zone zone, FeatureStyle featurestyle, boolean flag)
        throws PIMapError
    {
        if (s == null || zone == null || featurestyle == null)
        {
            throwErrorWithIllegalArgument("Either featureID, zone or featureStyle is null");
        }
        zone = getZoneRef(zone);
        float f;
        int i;
        if (flag)
        {
            f = 2.0F;
        } else
        {
            f = 0.0F;
        }
        featurestyle = new PIMGLFeatureAttrs(featurestyle);
        i = PIMGL.zone_setFeatureAttrs(mMap.getPIMGLContext(), zone, s, featurestyle, f, 0, false, Pointer.NULL);
        if (i > 0)
        {
            throw PIMapError.generateError(PIMapError.Kind.MAP_FEATURE, "Could not set feature style.", i);
        } else
        {
            return;
        }
    }

    private void throwErrorWithIllegalArgument(String s)
        throws PIMapError
    {
        throw PIMapError.generateError(PIMapError.Kind.MAP_FEATURE, s, new IllegalArgumentException());
    }

    public FeatureStyle getFeatureStyle(String s, Zone zone)
        throws PIMapError
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        if (zone == null || s == null)
        {
            throwErrorWithIllegalArgument("Either featureID and zone is null");
        }
        zone = getZoneRef(zone);
        PIMGLFeatureAttrs pimglfeatureattrs = new PIMGLFeatureAttrs();
        int i = PIMGL.zone_getFeatureAttrs(pimglcontext, zone, s, pimglfeatureattrs);
        if (i != 0)
        {
            throw PIMapError.generateError(PIMapError.Kind.MAP_FEATURE, "Coundn't get feature style. ", i);
        } else
        {
            return (new FeatureStyle()).visibilty(pimglfeatureattrs.mVisible).tintColor(pimglfeatureattrs.mColor.getColor()).strokeColor(pimglfeatureattrs.mColor.getColor()).fillColor(pimglfeatureattrs.mColor.getColor());
        }
    }

    public boolean hasFeatureStyle(String s, Zone zone)
        throws PIMapError
    {
        if (zone == null || s == null)
        {
            throwErrorWithIllegalArgument("Either featureID and zone is null");
        }
        int i = PIMGL.zone_hasFeature(mMap.getPIMGLContext(), getZoneRef(zone), s);
        switch (i)
        {
        default:
            throw PIMapError.generateError(PIMapError.Kind.MAP_FEATURE, "Coundn't check for feature style. ", i);

        case 0: // '\0'
            return true;

        case 4: // '\004'
            return false;
        }
    }

    public void setFeatureStyle(String s, Zone zone, FeatureStyle featurestyle)
        throws PIMapError
    {
        setStyle(s, zone, featurestyle, false);
    }

    public void setFeatureStyleAnimated(String s, Zone zone, FeatureStyle featurestyle)
        throws PIMapError
    {
        setStyle(s, zone, featurestyle, true);
    }
}
