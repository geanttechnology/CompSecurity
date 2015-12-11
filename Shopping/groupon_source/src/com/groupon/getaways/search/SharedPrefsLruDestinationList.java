// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.content.SharedPreferences;
import com.groupon.models.hotel.Destination;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class SharedPrefsLruDestinationList extends ArrayList
{

    private static final String DESTINATIONS_COUNT = "destinationsCount";
    private static final String DESTINATION_ID = "destinationId_";
    private static final String DESTINATION_LAT = "destinationLat_";
    private static final String DESTINATION_LNG = "destinationLng_";
    private static final String DESTINATION_NAME = "destinationName_";
    private static final String KEY_PREFERENCES_VERSION = "destinationsVersion";
    private static final int MAX_ENTRIES = 7;
    private static final int PREFERENCES_VERSION = 1;
    private final Map lruCache = new LinkedHashMap(7, 0.75F, true) {

        final SharedPrefsLruDestinationList this$0;

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > 7;
        }

            
            {
                this$0 = SharedPrefsLruDestinationList.this;
                super(i, f, flag);
            }
    };
    private final SharedPreferences sharedPrefs;

    public SharedPrefsLruDestinationList(SharedPreferences sharedpreferences)
    {
        sharedPrefs = sharedpreferences;
        loadDestinations();
    }

    private void loadDestinations()
    {
        if (sharedPrefs.getInt("destinationsVersion", 0) != 1)
        {
            android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putInt("destinationsVersion", 1);
            editor.putInt("destinationsCount", 0);
            editor.apply();
        } else
        {
            int j = sharedPrefs.getInt("destinationsCount", 0);
            if (j > 0)
            {
                for (int i = 0; i < j; i++)
                {
                    Destination destination = new Destination();
                    destination.name = sharedPrefs.getString((new StringBuilder()).append("destinationName_").append(i).toString(), "");
                    destination.uuid = sharedPrefs.getString((new StringBuilder()).append("destinationId_").append(i).toString(), "");
                    destination.lat = Double.longBitsToDouble(sharedPrefs.getLong((new StringBuilder()).append("destinationLat_").append(i).toString(), 0L));
                    destination.lng = Double.longBitsToDouble(sharedPrefs.getLong((new StringBuilder()).append("destinationLng_").append(i).toString(), 0L));
                    lruCache.put(destination.uuid, destination);
                }

                refreshDestinations();
                return;
            }
        }
    }

    private void refreshDestinations()
    {
        super.clear();
        for (ListIterator listiterator = (new ArrayList(lruCache.entrySet())).listIterator(lruCache.size()); listiterator.hasPrevious(); super.add(((java.util.Map.Entry)listiterator.previous()).getValue())) { }
    }

    private void saveDestinations()
    {
        android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("destinationsCount", super.size());
        ArrayList arraylist = new ArrayList(this);
        Collections.reverse(arraylist);
        for (int i = 0; i < arraylist.size(); i++)
        {
            Destination destination = (Destination)arraylist.get(i);
            editor.putString((new StringBuilder()).append("destinationId_").append(i).toString(), destination.uuid);
            editor.putString((new StringBuilder()).append("destinationName_").append(i).toString(), destination.name);
            editor.putLong((new StringBuilder()).append("destinationLat_").append(i).toString(), Double.doubleToRawLongBits(destination.lat));
            editor.putLong((new StringBuilder()).append("destinationLng_").append(i).toString(), Double.doubleToRawLongBits(destination.lng));
        }

        editor.apply();
    }

    public void add(int i, Destination destination)
    {
        throw new UnsupportedOperationException("Insertion for a given index is not supported because of LRU policy");
    }

    public volatile void add(int i, Object obj)
    {
        add(i, (Destination)obj);
    }

    public boolean add(Destination destination)
    {
        if (lruCache.containsKey(destination.uuid))
        {
            if (!((Destination)lruCache.get(destination.uuid)).name.equals(destination.name))
            {
                lruCache.put(destination.uuid, destination);
            }
        } else
        {
            lruCache.put(destination.uuid, destination);
        }
        refreshDestinations();
        saveDestinations();
        return true;
    }

    public volatile boolean add(Object obj)
    {
        return add((Destination)obj);
    }

    public boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException("Insertion for a given index is not supported because of LRU policy");
    }

    public boolean addAll(Collection collection)
    {
        if (collection.isEmpty())
        {
            return false;
        }
        Destination destination;
        for (collection = collection.iterator(); collection.hasNext(); lruCache.put(destination.uuid, destination))
        {
            destination = (Destination)collection.next();
        }

        refreshDestinations();
        saveDestinations();
        return true;
    }

    public void clear()
    {
        super.clear();
        lruCache.clear();
        saveDestinations();
    }

    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    public Iterator iterator()
    {
        return Collections.unmodifiableList(this).iterator();
    }

    public ListIterator listIterator()
    {
        return Collections.unmodifiableList(this).listIterator();
    }

    public ListIterator listIterator(int i)
    {
        return Collections.unmodifiableList(this).listIterator(i);
    }

    public Destination remove(int i)
    {
        Destination destination = (Destination)super.remove(i);
        lruCache.remove(destination.uuid);
        saveDestinations();
        return destination;
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public boolean remove(Object obj)
    {
        if ((obj instanceof Destination) && super.remove(obj))
        {
            lruCache.remove(((Destination)obj).uuid);
            saveDestinations();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean removeAll(Collection collection)
    {
        boolean flag = false;
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Destination destination = (Destination)iterator1.next();
            if (collection.contains(destination))
            {
                lruCache.remove(destination.uuid);
                iterator1.remove();
                flag = true;
            }
        } while (true);
        return flag;
    }

    public boolean retainAll(Collection collection)
    {
        boolean flag = false;
        Iterator iterator1 = iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Destination destination = (Destination)iterator1.next();
            if (!collection.contains(destination))
            {
                lruCache.remove(destination.uuid);
                iterator1.remove();
                flag = true;
            }
        } while (true);
        return flag;
    }

    public Destination set(int i, Destination destination)
    {
        throw new UnsupportedOperationException("Modification for a given index is not supported because of LRU policy");
    }

    public volatile Object set(int i, Object obj)
    {
        return set(i, (Destination)obj);
    }
}
