// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;


// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            MapMakerInternalMap

static abstract class <init> extends Enum
{

    private static final factories $VALUES[];
    public static final factories STRONG;
    public static final factories STRONG_EVICTABLE;
    public static final factories STRONG_EXPIRABLE;
    public static final factories STRONG_EXPIRABLE_EVICTABLE;
    public static final factories WEAK;
    public static final factories WEAK_EVICTABLE;
    public static final factories WEAK_EXPIRABLE;
    public static final factories WEAK_EXPIRABLE_EVICTABLE;
    static final factories factories[][];

    static <init> getFactory(<init> <init>1, boolean flag, boolean flag1)
    {
        byte byte0 = 0;
        boolean flag2;
        if (flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag1)
        {
            byte0 = 2;
        }
        return factories[<init>1.nal()][flag2 | byte0];
    }

    public static nal valueOf(String s)
    {
        return (nal)Enum.valueOf(org/roboguice/shaded/goole/common/collect/MapMakerInternalMap$EntryFactory, s);
    }

    public static nal[] values()
    {
        return (nal[])$VALUES.clone();
    }

    y copyEntry(y y, y y1, y y2)
    {
        return newEntry(y, y1.getKey(), y1.getHash(), y2);
    }

    void copyEvictableEntry(y y, y y1)
    {
        MapMakerInternalMap.connectEvictables(y.getPreviousEvictable(), y1);
        MapMakerInternalMap.connectEvictables(y1, y.getNextEvictable());
        MapMakerInternalMap.nullifyEvictable(y);
    }

    void copyExpirableEntry(y y, y y1)
    {
        y1.setExpirationTime(y.getExpirationTime());
        MapMakerInternalMap.connectExpirables(y.getPreviousExpirable(), y1);
        MapMakerInternalMap.connectExpirables(y1, y.getNextExpirable());
        MapMakerInternalMap.nullifyExpirable(y);
    }

    abstract y newEntry(y y, Object obj, int i, y y1);

    static 
    {
        STRONG = new MapMakerInternalMap.EntryFactory("STRONG", 0) {

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.StrongEntry(obj, i, referenceentry);
            }

        };
        STRONG_EXPIRABLE = new MapMakerInternalMap.EntryFactory("STRONG_EXPIRABLE", 1) {

            MapMakerInternalMap.ReferenceEntry copyEntry(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, MapMakerInternalMap.ReferenceEntry referenceentry1)
            {
                segment = copyEntry(segment, referenceentry, referenceentry1);
                copyExpirableEntry(referenceentry, segment);
                return segment;
            }

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.StrongExpirableEntry(obj, i, referenceentry);
            }

        };
        STRONG_EVICTABLE = new MapMakerInternalMap.EntryFactory("STRONG_EVICTABLE", 2) {

            MapMakerInternalMap.ReferenceEntry copyEntry(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, MapMakerInternalMap.ReferenceEntry referenceentry1)
            {
                segment = copyEntry(segment, referenceentry, referenceentry1);
                copyEvictableEntry(referenceentry, segment);
                return segment;
            }

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.StrongEvictableEntry(obj, i, referenceentry);
            }

        };
        STRONG_EXPIRABLE_EVICTABLE = new MapMakerInternalMap.EntryFactory("STRONG_EXPIRABLE_EVICTABLE", 3) {

            MapMakerInternalMap.ReferenceEntry copyEntry(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, MapMakerInternalMap.ReferenceEntry referenceentry1)
            {
                segment = copyEntry(segment, referenceentry, referenceentry1);
                copyExpirableEntry(referenceentry, segment);
                copyEvictableEntry(referenceentry, segment);
                return segment;
            }

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.StrongExpirableEvictableEntry(obj, i, referenceentry);
            }

        };
        WEAK = new MapMakerInternalMap.EntryFactory("WEAK", 4) {

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.WeakEntry(segment.keyReferenceQueue, obj, i, referenceentry);
            }

        };
        WEAK_EXPIRABLE = new MapMakerInternalMap.EntryFactory("WEAK_EXPIRABLE", 5) {

            MapMakerInternalMap.ReferenceEntry copyEntry(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, MapMakerInternalMap.ReferenceEntry referenceentry1)
            {
                segment = copyEntry(segment, referenceentry, referenceentry1);
                copyExpirableEntry(referenceentry, segment);
                return segment;
            }

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.WeakExpirableEntry(segment.keyReferenceQueue, obj, i, referenceentry);
            }

        };
        WEAK_EVICTABLE = new MapMakerInternalMap.EntryFactory("WEAK_EVICTABLE", 6) {

            MapMakerInternalMap.ReferenceEntry copyEntry(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, MapMakerInternalMap.ReferenceEntry referenceentry1)
            {
                segment = copyEntry(segment, referenceentry, referenceentry1);
                copyEvictableEntry(referenceentry, segment);
                return segment;
            }

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.WeakEvictableEntry(segment.keyReferenceQueue, obj, i, referenceentry);
            }

        };
        WEAK_EXPIRABLE_EVICTABLE = new MapMakerInternalMap.EntryFactory("WEAK_EXPIRABLE_EVICTABLE", 7) {

            MapMakerInternalMap.ReferenceEntry copyEntry(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, MapMakerInternalMap.ReferenceEntry referenceentry1)
            {
                segment = copyEntry(segment, referenceentry, referenceentry1);
                copyExpirableEntry(referenceentry, segment);
                copyEvictableEntry(referenceentry, segment);
                return segment;
            }

            MapMakerInternalMap.ReferenceEntry newEntry(MapMakerInternalMap.Segment segment, Object obj, int i, MapMakerInternalMap.ReferenceEntry referenceentry)
            {
                return new MapMakerInternalMap.WeakExpirableEvictableEntry(segment.keyReferenceQueue, obj, i, referenceentry);
            }

        };
        $VALUES = (new .VALUES[] {
            STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE, WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE
        });
        y y = STRONG;
        y y1 = STRONG_EXPIRABLE;
        y y2 = STRONG_EVICTABLE;
        y y3 = STRONG_EXPIRABLE_EVICTABLE;
        y y4 = WEAK;
        y y5 = WEAK_EXPIRABLE;
        y y6 = WEAK_EVICTABLE;
        y y7 = WEAK_EXPIRABLE_EVICTABLE;
        factories = (new factories[][] {
            new factories[] {
                y, y1, y2, y3
            }, new factories[0], new factories[] {
                y4, y5, y6, y7
            }
        });
    }

    private _cls8(String s, int i)
    {
        super(s, i);
    }

    _cls8(String s, int i, _cls8 _pcls8)
    {
        this(s, i);
    }
}
