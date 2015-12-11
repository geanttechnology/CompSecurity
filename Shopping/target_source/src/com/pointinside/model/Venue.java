// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.content.Context;
import android.location.Location;
import com.google.b.f;
import com.pointinside.feeds.VenueEntity;
import com.pointinside.feeds.ZoneEntity;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.VenueCacheIOException;
import com.pointinside.net.requestor.RequestorFactory;
import com.pointinside.net.requestor.SingleVenueFeedRequestor;
import com.pointinside.net.url.FeedsURLBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.pointinside.model:
//            Cachable, VenueFactory, Zone, Place, 
//            CacheController

public abstract class Venue
    implements Cachable
{
    private static class Empty extends Full
    {

        private final String id;

        public File getCacheFile(File file)
        {
            String as[] = file.list(new FilenameFilter() {

                final Empty this$0;

                public boolean accept(File file, String s)
                {
                    file = getUUID().toLowerCase();
                    if (s.length() > 32)
                    {
                        String s1 = s.substring(0, 32);
                        s = s.substring(32, s.length());
                        if (s1.equals(file) || s.equals(file))
                        {
                            return true;
                        }
                    }
                    return false;
                }

            
            {
                this$0 = Empty.this;
                super();
            }
            });
            if (as != null && as.length > 0)
            {
                return new File(file, as[0]);
            } else
            {
                return null;
            }
        }

        public Zone getCurrentZone()
        {
            LogUtils.logE(Venue.TAG, "Venue.Empty#getCurrentZone not implemented");
            return null;
        }

        public Location getLocation()
        {
            LogUtils.logW(Venue.TAG, "Venue.Empty#getLocation not implemented");
            return null;
        }

        public String getUUID()
        {
            return id;
        }

        public Zone nextZone()
        {
            LogUtils.logE(Venue.TAG, "Venue.Empty#nextZone not implemented");
            return null;
        }

        Place placeNear(Zone zone, int i, int j)
        {
            LogUtils.logE(Venue.TAG, "Venue.Empty#placeNear not implemented");
            return null;
        }

        public Zone previousZone()
        {
            LogUtils.logE(Venue.TAG, "Venue.Empty#previousZone not implemented");
            return null;
        }

        public Zone setZoneByUUID(String s)
        {
            LogUtils.logE(Venue.TAG, "Venue.Empty#getZoneByUUID not implemented");
            return null;
        }

        protected Empty(String s)
        {
            super(null, new com.pointinside.feeds.ZoneImageEntity.ImageType[0]);
            id = s;
        }
    }

    private static class Full extends Venue
    {

        private VenueEntity mEntity;
        private final List mPlaces = new LinkedList();
        private ZoneIterator mZoneIter;
        private List mZones;

        public int cacheSize()
        {
            return 5;
        }

        public Zone findZoneByUUID(String s)
        {
            for (Iterator iterator = mZones.iterator(); iterator.hasNext();)
            {
                Zone zone = (Zone)iterator.next();
                if (zone.getUUID().equals(s))
                {
                    return zone;
                }
            }

            return null;
        }

        public List getAllZones()
        {
            return mZones;
        }

        public File getCacheFile(File file)
        {
            String s = mEntity.storeId.toLowerCase();
            String s1 = mEntity.id.toLowerCase();
            return new File(file, (new StringBuilder()).append(s1).append(s).toString());
        }

        public InputStream getContentAsStream(Context context)
        {
            context = new f();
            try
            {
                context = new ByteArrayInputStream(context.b(mEntity).getBytes("UTF-8"));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                LogUtils.logE(Venue.TAG, (new StringBuilder()).append("Could not create stream from venue:").append(mEntity.id).toString());
                return null;
            }
            return context;
        }

        public Zone getCurrentZone()
        {
            return mZoneIter.getCurrent();
        }

        VenueEntity getEntity()
        {
            return mEntity;
        }

        transient List getFullZones(List list, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        {
            ArrayList arraylist = new ArrayList();
            for (list = list.iterator(); list.hasNext(); arraylist.add(Zone.newFull(this, (ZoneEntity)list.next(), aimagetype))) { }
            Collections.sort(arraylist);
            return arraylist;
        }

        public Location getLocation()
        {
            Location location = new Location(mEntity.id);
            location.setLongitude(mEntity.longitude);
            location.setLatitude(mEntity.latitude);
            return location;
        }

        public String getName()
        {
            return mEntity.name;
        }

        public String getPhoneNumber()
        {
            return mEntity.phone;
        }

        public String getUUID()
        {
            return mEntity.id;
        }

        public Zone nextZone()
        {
            return mZoneIter.next();
        }

        transient void overrideImageType(com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        {
            mZones = getFullZones(mEntity.zones, aimagetype);
            mZoneIter = new ZoneIterator(mZones);
        }

        Place placeNear(Zone zone, int i, int j)
        {
            if (mPlaces.size() > 0)
            {
                return (Place)mPlaces.get(0);
            } else
            {
                return null;
            }
        }

        public Zone previousZone()
        {
            return mZoneIter.previous();
        }

        public Venue read(File file)
            throws IOException
        {
            Object obj;
            File file1;
            f f1;
            f1 = new f();
            obj = null;
            Object obj1 = null;
            file1 = getCacheFile(file);
            file = obj1;
            Object obj2 = CacheController.getReader(file1);
            file = ((File) (obj2));
            obj = obj2;
            String s = ((BufferedReader) (obj2)).readLine();
            IOException ioexception;
            StringBuilder stringbuilder;
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
            return newFull((VenueEntity)f1.a(s, com/pointinside/feeds/VenueEntity), new com.pointinside.feeds.ZoneImageEntity.ImageType[0]);
            ioexception;
            obj = file;
            s = Venue.TAG;
            obj = file;
            stringbuilder = (new StringBuilder()).append("Could not read cache for venue: ");
            if (file1 == null) goto _L2; else goto _L1
_L1:
            obj = file;
            obj2 = file1.toString();
_L3:
            obj = file;
            LogUtils.logW(s, stringbuilder.append(((String) (obj2))).toString(), ioexception);
            obj = file;
            throw ioexception;
            file;
            try
            {
                ((BufferedReader) (obj)).close();
            }
            catch (Exception exception) { }
            throw file;
_L2:
            obj = file;
            obj2 = getUUID();
              goto _L3
        }

        public volatile Object read(File file)
            throws IOException
        {
            return read(file);
        }

        public Zone setZoneByUUID(String s)
        {
            mZoneIter.gotoFirst();
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_19;
            }
            mZoneIter.moveToUUID(s);
            s = mZoneIter.getCurrent();
            return s;
            s;
            LogUtils.logW(Venue.TAG, s.getMessage(), s);
            return null;
        }

        public List tryUpdate(File file)
            throws IOException
        {
            Object obj;
            long l;
            if (file != null && file.exists())
            {
                l = file.lastModified();
            } else
            {
                l = 0L;
            }
            file = new LinkedList();
            obj = new FeedsURLBuilder(getUUID());
            obj.modifiedSince = Long.valueOf(l);
            obj = (VenueEntity)RequestorFactory.newSingleVenueRequestor(((FeedsURLBuilder) (obj))).fetchEntry();
            if (obj != null)
            {
                file.add(Venue.newFull(((VenueEntity) (obj)), new com.pointinside.feeds.ZoneImageEntity.ImageType[0]));
            }
            return file;
        }

        protected transient Full(VenueEntity venueentity, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        {
            mZones = new ArrayList();
            if (venueentity != null)
            {
                mEntity = venueentity;
                overrideImageType(aimagetype);
            }
        }
    }

    private static class Shallow extends Full
    {

        VenueFactory mFactory;

        private Venue getFullVenue(String s)
        {
            Object obj = null;
            try
            {
                s = mFactory.getVenueById(s, new com.pointinside.feeds.ZoneImageEntity.ImageType[0]);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = obj;
            }
            if (s == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid venue identifier: ").append(getUUID()).toString());
            } else
            {
                return s;
            }
        }

        public Zone getCurrentZone()
        {
            return updateDelegate(getFullVenue(getUUID())).getCurrentZone();
        }

        public Zone nextZone()
        {
            return updateDelegate(getFullVenue(getUUID())).nextZone();
        }

        public Zone previousZone()
        {
            return updateDelegate(getFullVenue(getUUID())).previousZone();
        }

        public Zone setZoneByUUID(String s)
        {
            return updateDelegate(getFullVenue(getUUID())).setZoneByUUID(s);
        }

        protected Shallow(VenueFactory venuefactory, VenueEntity venueentity)
        {
            super(venueentity, new com.pointinside.feeds.ZoneImageEntity.ImageType[0]);
            mFactory = venuefactory;
        }
    }

    private static class ZoneIterator
    {

        private Move mLastMove;
        private List mList;
        private ListIterator mListIter;

        private Zone getCurrent()
        {
            static class _cls1
            {

                static final int $SwitchMap$com$pointinside$model$Venue$ZoneIterator$Move[];

                static 
                {
                    $SwitchMap$com$pointinside$model$Venue$ZoneIterator$Move = new int[ZoneIterator.Move.values().length];
                    try
                    {
                        $SwitchMap$com$pointinside$model$Venue$ZoneIterator$Move[ZoneIterator.Move.NEXT.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$pointinside$model$Venue$ZoneIterator$Move[ZoneIterator.Move.PREV.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            Zone zone1;
            switch (_cls1..SwitchMap.com.pointinside.model.Venue.ZoneIterator.Move[mLastMove.ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                Zone zone = (Zone)mListIter.previous();
                mLastMove = Move.PREV;
                return zone;

            case 2: // '\002'
                zone1 = (Zone)mListIter.next();
                break;
            }
            mLastMove = Move.NEXT;
            return zone1;
        }

        private void gotoFirst()
        {
            mLastMove = Move.PREV;
            mListIter = mList.listIterator();
        }

        private void gotoLast()
        {
            mLastMove = Move.NEXT;
            mListIter = mList.listIterator(mList.size());
        }

        private void moveToUUID(String s)
            throws IllegalArgumentException
        {
            gotoFirst();
            for (; mListIter.hasNext() && !getCurrent().getUUID().equals(s); next()) { }
            if (!getCurrent().getUUID().equals(s))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("UUID: ").append(s).append(" not found in venue").toString());
            } else
            {
                return;
            }
        }

        private Zone next()
        {
            if (mLastMove == Move.PREV)
            {
                mListIter.next();
            }
            if (!mListIter.hasNext())
            {
                gotoFirst();
            }
            mLastMove = Move.NEXT;
            return (Zone)mListIter.next();
        }

        private Zone previous()
        {
            if (mLastMove == Move.NEXT)
            {
                mListIter.previous();
            }
            if (!mListIter.hasPrevious())
            {
                gotoLast();
            }
            mLastMove = Move.PREV;
            return (Zone)mListIter.previous();
        }






        private ZoneIterator(List list)
        {
            mList = list;
            mListIter = mList.listIterator();
            mLastMove = Move.PREV;
        }

    }

    private static final class ZoneIterator.Move extends Enum
    {

        private static final ZoneIterator.Move $VALUES[];
        public static final ZoneIterator.Move NEXT;
        public static final ZoneIterator.Move PREV;

        public static ZoneIterator.Move valueOf(String s)
        {
            return (ZoneIterator.Move)Enum.valueOf(com/pointinside/model/Venue$ZoneIterator$Move, s);
        }

        public static ZoneIterator.Move[] values()
        {
            return (ZoneIterator.Move[])$VALUES.clone();
        }

        static 
        {
            NEXT = new ZoneIterator.Move("NEXT", 0);
            PREV = new ZoneIterator.Move("PREV", 1);
            $VALUES = (new ZoneIterator.Move[] {
                NEXT, PREV
            });
        }

        private ZoneIterator.Move(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/pointinside/model/Venue.getSimpleName();
    private Venue mDelegate;

    public Venue()
    {
    }

    public static Venue newEmpty(String s)
    {
        if (s != null)
        {
            return new Empty(s);
        } else
        {
            return null;
        }
    }

    public static transient Venue newFull(VenueEntity venueentity, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        if (venueentity != null)
        {
            return new Full(venueentity, aimagetype);
        } else
        {
            return null;
        }
    }

    public static Venue newShallow(VenueFactory venuefactory, VenueEntity venueentity)
    {
        if (venueentity != null)
        {
            return new Shallow(venuefactory, venueentity);
        } else
        {
            return null;
        }
    }

    public Zone findZoneByUUID(String s)
    {
        return mDelegate.findZoneByUUID(s);
    }

    public List getAllZones()
    {
        return mDelegate.getAllZones();
    }

    public Zone getCurrentZone()
    {
        return mDelegate.getCurrentZone();
    }

    VenueEntity getEntity()
    {
        return mDelegate.getEntity();
    }

    public Location getLocation()
    {
        return mDelegate.getLocation();
    }

    public String getName()
    {
        return mDelegate.getName();
    }

    public String getPhoneNumber()
    {
        return mDelegate.getPhoneNumber();
    }

    public String getUUID()
    {
        return mDelegate.getUUID();
    }

    public Zone nextZone()
    {
        return mDelegate.nextZone();
    }

    transient void overrideImageType(com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        mDelegate.overrideImageType(aimagetype);
    }

    Place placeNear(Zone zone, int i, int j)
    {
        return mDelegate.placeNear(zone, i, j);
    }

    public Zone previousZone()
    {
        return mDelegate.previousZone();
    }

    public Zone setZoneByUUID(String s)
    {
        return mDelegate.setZoneByUUID(s);
    }

    protected Venue updateDelegate(Venue venue)
    {
        mDelegate = venue;
        return mDelegate;
    }


}
