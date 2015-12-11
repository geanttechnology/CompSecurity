// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


public final class ObjectID extends Enum
{
    private static class SwigNext
    {

        private static int next = 0;



/*
        static int access$002(int i)
        {
            next = i;
            return i;
        }

*/


/*
        static int access$008()
        {
            int i = next;
            next = i + 1;
            return i;
        }

*/

        private SwigNext()
        {
        }
    }


    private static final ObjectID $VALUES[];
    public static final ObjectID BARCODE;
    public static final ObjectID DEEP_LEARNING;
    public static final ObjectID IMGMATCHOBJ;
    public static final ObjectID LOGO;
    public static final ObjectID NUM_OBJECTS;
    public static final ObjectID TEXT;
    public static final ObjectID TEXTCANVAS;
    public static final ObjectID TWOD_BARCODE;
    public static final ObjectID UNSPECIFIED_OBJECT;
    private final int swigValue;

    private ObjectID(String s, int i)
    {
        super(s, i);
        swigValue = int i = 
// JavaClassFileOutputException: get_constant: invalid tag

    private ObjectID(String s, int i, int j)
    {
        Enum(s, i);
        swigValue = j;
        SwigNext.next = j + 1;
    }

    private ObjectID(String s, int i, ObjectID objectid)
    {
        Enum(s, i);
        swigValue = objectid.swigValue;
        SwigNext.next = swigValue + 1;
    }

    public static ObjectID swigToEnum(int i)
    {
        ObjectID aobjectid[] = (ObjectID[])com/a9/vs/mobile/library/impl/jni/ObjectID.getEnumConstants();
        if (i >= aobjectid.length || i < 0 || aobjectid[i].swigValue != i) goto _L2; else goto _L1
_L1:
        ObjectID objectid = aobjectid[i];
_L4:
        return objectid;
_L2:
        int k = aobjectid.length;
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= k)
                {
                    break label1;
                }
                ObjectID objectid1 = aobjectid[j];
                objectid = objectid1;
                if (objectid1.swigValue == i)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/a9/vs/mobile/library/impl/jni/ObjectID).append(" with value ").append(i).toString());
    }

    public static ObjectID valueOf(String s)
    {
        return (ObjectID)Enum.valueOf(com/a9/vs/mobile/library/impl/jni/ObjectID, s);
    }

    public static ObjectID[] values()
    {
        return (ObjectID[])$VALUES.clone();
    }

    public final int swigValue()
    {
        return swigValue;
    }

    static 
    {
        IMGMATCHOBJ = new ObjectID("IMGMATCHOBJ", 0, 0);
        BARCODE = new ObjectID("BARCODE", 1);
        TWOD_BARCODE = new ObjectID("TWOD_BARCODE", 2);
        TEXT = new ObjectID("TEXT", 3);
        TEXTCANVAS = new ObjectID("TEXTCANVAS", 4);
        LOGO = new ObjectID("LOGO", 5);
        DEEP_LEARNING = new ObjectID("DEEP_LEARNING", 6);
        UNSPECIFIED_OBJECT = new ObjectID("UNSPECIFIED_OBJECT", 7);
        NUM_OBJECTS = new ObjectID("NUM_OBJECTS", 8);
        $VALUES = (new ObjectID[] {
            IMGMATCHOBJ, BARCODE, TWOD_BARCODE, TEXT, TEXTCANVAS, LOGO, DEEP_LEARNING, UNSPECIFIED_OBJECT, NUM_OBJECTS
        });
    }
}
