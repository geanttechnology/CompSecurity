// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import org.roboguice.shaded.goole.common.base.Equivalence;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            MapMakerInternalMap

static abstract class <init> extends Enum
{

    private static final WEAK $VALUES[];
    public static final WEAK SOFT;
    public static final WEAK STRONG;
    public static final WEAK WEAK;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(org/roboguice/shaded/goole/common/collect/MapMakerInternalMap$Strength, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    abstract Equivalence defaultEquivalence();

    abstract rence referenceValue(Entry entry, Entry entry1, Object obj);

    static 
    {
        STRONG = new MapMakerInternalMap.Strength("STRONG", 0) {

            Equivalence defaultEquivalence()
            {
                return Equivalence.equals();
            }

            MapMakerInternalMap.ValueReference referenceValue(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, Object obj)
            {
                return new MapMakerInternalMap.StrongValueReference(obj);
            }

        };
        SOFT = new MapMakerInternalMap.Strength("SOFT", 1) {

            Equivalence defaultEquivalence()
            {
                return Equivalence.identity();
            }

            MapMakerInternalMap.ValueReference referenceValue(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, Object obj)
            {
                return new MapMakerInternalMap.SoftValueReference(segment.valueReferenceQueue, obj, referenceentry);
            }

        };
        WEAK = new MapMakerInternalMap.Strength("WEAK", 2) {

            Equivalence defaultEquivalence()
            {
                return Equivalence.identity();
            }

            MapMakerInternalMap.ValueReference referenceValue(MapMakerInternalMap.Segment segment, MapMakerInternalMap.ReferenceEntry referenceentry, Object obj)
            {
                return new MapMakerInternalMap.WeakValueReference(segment.valueReferenceQueue, obj, referenceentry);
            }

        };
        $VALUES = (new .VALUES[] {
            STRONG, SOFT, WEAK
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    _cls3(String s, int i, _cls3 _pcls3)
    {
        this(s, i);
    }
}
