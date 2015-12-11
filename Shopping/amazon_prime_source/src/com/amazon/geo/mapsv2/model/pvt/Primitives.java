// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model.pvt;

import com.amazon.geo.mapsv2.CameraUpdate;
import com.amazon.geo.mapsv2.LocationSource;
import com.amazon.geo.mapsv2.internal.ICameraUpdateDelegate;
import com.amazon.geo.mapsv2.internal.ILocationSourcePrimitive;
import com.amazon.geo.mapsv2.model.BitmapDescriptor;
import com.amazon.geo.mapsv2.model.CameraPosition;
import com.amazon.geo.mapsv2.model.CircleOptions;
import com.amazon.geo.mapsv2.model.GroundOverlayOptions;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.LatLngBounds;
import com.amazon.geo.mapsv2.model.MarkerOptions;
import com.amazon.geo.mapsv2.model.PolygonOptions;
import com.amazon.geo.mapsv2.model.PolylineOptions;
import com.amazon.geo.mapsv2.model.Tile;
import com.amazon.geo.mapsv2.model.TileOverlayOptions;
import com.amazon.geo.mapsv2.model.TileProvider;
import com.amazon.geo.mapsv2.model.UrlTileProvider;
import com.amazon.geo.mapsv2.model.VisibleRegion;
import com.amazon.geo.mapsv2.model.internal.IBitmapDescriptorDelegate;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.ICircleOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngBoundsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IMarkerOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IPolygonOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IPolylineOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ITileOverlayOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ITilePrimitive;
import com.amazon.geo.mapsv2.model.internal.ITileProviderPrimitive;
import com.amazon.geo.mapsv2.model.internal.IVisibleRegionPrimitive;
import com.amazon.geo.mapsv2.pvt.InternalPrimitiveFactory;
import com.amazon.geo.mapsv2.pvt.LocationSourcePrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2.model.pvt:
//            CameraPositionPrimitive, CircleOptionsPrimitive, GroundOverlayOptionsPrimitive, LatLngBoundsPrimitive, 
//            LatLngPrimitive, MarkerOptionsPrimitive, PolygonOptionsPrimitive, PolylineOptionsPrimitive, 
//            TileOverlayOptionsPrimitive, TilePrimitive, UrlTileProviderPrimitive, TileProviderPrimitive, 
//            VisibleRegionPrimitive

public final class Primitives
{

    private static InternalPrimitiveFactory sInternalPrimitives;

    private Primitives()
    {
    }

    public static ILocationSourcePrimitive create(LocationSource locationsource)
    {
        if (locationsource == null)
        {
            return null;
        } else
        {
            return new LocationSourcePrimitive(locationsource);
        }
    }

    public static CameraPosition create(ICameraPositionPrimitive icamerapositionprimitive)
    {
        if (icamerapositionprimitive == null)
        {
            return null;
        } else
        {
            return new CameraPosition(create(icamerapositionprimitive.getTarget()), icamerapositionprimitive.getZoom(), icamerapositionprimitive.getTilt(), icamerapositionprimitive.getBearing());
        }
    }

    public static LatLng create(ILatLngPrimitive ilatlngprimitive)
    {
        if (ilatlngprimitive == null)
        {
            return null;
        } else
        {
            return new LatLng(ilatlngprimitive.getLatitude(), ilatlngprimitive.getLongitude());
        }
    }

    public static LatLngBounds create(ILatLngBoundsPrimitive ilatlngboundsprimitive)
    {
        if (ilatlngboundsprimitive == null)
        {
            return null;
        } else
        {
            return new LatLngBounds(create(ilatlngboundsprimitive.getSouthwest()), create(ilatlngboundsprimitive.getNortheast()));
        }
    }

    public static VisibleRegion create(IVisibleRegionPrimitive ivisibleregionprimitive)
    {
        if (ivisibleregionprimitive == null)
        {
            return null;
        } else
        {
            return new VisibleRegion(create(ivisibleregionprimitive.getNearLeft()), create(ivisibleregionprimitive.getNearRight()), create(ivisibleregionprimitive.getFarLeft()), create(ivisibleregionprimitive.getFarRight()), create(ivisibleregionprimitive.getLatLngBounds()));
        }
    }

    public static ICameraPositionPrimitive create(CameraPosition cameraposition)
    {
        if (cameraposition == null)
        {
            return null;
        } else
        {
            return new CameraPositionPrimitive(cameraposition);
        }
    }

    public static ICircleOptionsPrimitive create(CircleOptions circleoptions)
    {
        if (circleoptions == null)
        {
            return null;
        } else
        {
            return new CircleOptionsPrimitive(circleoptions);
        }
    }

    public static IGroundOverlayOptionsPrimitive create(GroundOverlayOptions groundoverlayoptions)
    {
        if (groundoverlayoptions == null)
        {
            return null;
        } else
        {
            return new GroundOverlayOptionsPrimitive(groundoverlayoptions);
        }
    }

    public static ILatLngBoundsPrimitive create(LatLngBounds latlngbounds)
    {
        if (latlngbounds == null)
        {
            return null;
        } else
        {
            return new LatLngBoundsPrimitive(latlngbounds);
        }
    }

    public static ILatLngPrimitive create(LatLng latlng)
    {
        if (latlng == null)
        {
            return null;
        } else
        {
            return new LatLngPrimitive(latlng);
        }
    }

    public static IMarkerOptionsPrimitive create(MarkerOptions markeroptions)
    {
        if (markeroptions == null)
        {
            return null;
        } else
        {
            return new MarkerOptionsPrimitive(markeroptions);
        }
    }

    public static IPolygonOptionsPrimitive create(PolygonOptions polygonoptions)
    {
        if (polygonoptions == null)
        {
            return null;
        } else
        {
            return new PolygonOptionsPrimitive(polygonoptions);
        }
    }

    public static IPolylineOptionsPrimitive create(PolylineOptions polylineoptions)
    {
        if (polylineoptions == null)
        {
            return null;
        } else
        {
            return new PolylineOptionsPrimitive(polylineoptions);
        }
    }

    public static ITileOverlayOptionsPrimitive create(TileOverlayOptions tileoverlayoptions)
    {
        if (tileoverlayoptions == null)
        {
            return null;
        } else
        {
            return new TileOverlayOptionsPrimitive(tileoverlayoptions);
        }
    }

    public static ITilePrimitive create(Tile tile)
    {
        if (tile == null)
        {
            return null;
        } else
        {
            return new TilePrimitive(tile);
        }
    }

    public static ITileProviderPrimitive create(TileProvider tileprovider)
    {
        if (tileprovider != null) goto _L2; else goto _L1
_L1:
        ITileProviderPrimitive itileproviderprimitive = null;
_L4:
        return itileproviderprimitive;
_L2:
        ITileProviderPrimitive itileproviderprimitive1;
        if (sInternalPrimitives == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itileproviderprimitive1 = sInternalPrimitives.create(tileprovider);
        itileproviderprimitive = itileproviderprimitive1;
        if (itileproviderprimitive1 != null) goto _L4; else goto _L3
_L3:
        if (tileprovider instanceof UrlTileProvider)
        {
            return new UrlTileProviderPrimitive((UrlTileProvider)tileprovider);
        } else
        {
            return new TileProviderPrimitive(tileprovider);
        }
    }

    public static IVisibleRegionPrimitive create(VisibleRegion visibleregion)
    {
        if (visibleregion == null)
        {
            return null;
        } else
        {
            return new VisibleRegionPrimitive(visibleregion);
        }
    }

    public static List create(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        do
        {
            list = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(create((LatLngBounds)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient ILatLngPrimitive[] createArrayLatLngDelegate(LatLng alatlng[])
    {
        if (alatlng != null) goto _L2; else goto _L1
_L1:
        ILatLngPrimitive ailatlngprimitive[] = null;
_L4:
        return ailatlngprimitive;
_L2:
        ILatLngPrimitive ailatlngprimitive1[] = new ILatLngPrimitive[alatlng.length];
        int i = 0;
        do
        {
            ailatlngprimitive = ailatlngprimitive1;
            if (i >= alatlng.length)
            {
                continue;
            }
            ailatlngprimitive1[i] = create(alatlng[i]);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static List createListLatLng(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            list = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(create((ILatLngPrimitive)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static List createListLatLngDelegate(Iterable iterable)
    {
        if (iterable != null) goto _L2; else goto _L1
_L1:
        iterable = null;
_L4:
        return iterable;
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = iterable.iterator();
        do
        {
            iterable = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(create((LatLng)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static List createListListLatLng(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            list = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(createListLatLng((List)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static List createListListLatLngDelegate(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L4:
        return list;
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            list = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(createListLatLngDelegate((List)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void setInternalPrimitives(InternalPrimitiveFactory internalprimitivefactory)
    {
        sInternalPrimitives = internalprimitivefactory;
    }

    public static ICameraUpdateDelegate unwrap(CameraUpdate cameraupdate)
    {
        if (cameraupdate == null)
        {
            return null;
        } else
        {
            return (ICameraUpdateDelegate)com/amazon/geo/mapsv2/internal/ICameraUpdateDelegate.cast(cameraupdate.id());
        }
    }

    public static IBitmapDescriptorDelegate unwrap(BitmapDescriptor bitmapdescriptor)
    {
        if (bitmapdescriptor == null)
        {
            return null;
        } else
        {
            return (IBitmapDescriptorDelegate)com/amazon/geo/mapsv2/model/internal/IBitmapDescriptorDelegate.cast(bitmapdescriptor.id());
        }
    }
}
