// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseGeoPoint, ParseObject

class val.keys
    implements Comparator
{

    final OfflineQueryLogic this$0;
    final List val$keys;
    final String val$nearSphereKey;
    final ParseGeoPoint val$nearSphereValue;

    public int compare(ParseObject parseobject, ParseObject parseobject1)
    {
        if (val$nearSphereKey == null) goto _L2; else goto _L1
_L1:
        int i;
        double d;
        double d1;
        ParseGeoPoint parsegeopoint;
        ParseGeoPoint parsegeopoint1;
        try
        {
            parsegeopoint = (ParseGeoPoint)OfflineQueryLogic.access$200(OfflineQueryLogic.this, parseobject, val$nearSphereKey);
            parsegeopoint1 = (ParseGeoPoint)OfflineQueryLogic.access$200(OfflineQueryLogic.this, parseobject1, val$nearSphereKey);
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            throw new RuntimeException(parseobject);
        }
        d = parsegeopoint.distanceInRadiansTo(val$nearSphereValue);
        d1 = parsegeopoint1.distanceInRadiansTo(val$nearSphereValue);
        if (d == d1) goto _L2; else goto _L3
_L3:
        if (d - d1 <= 0.0D) goto _L5; else goto _L4
_L4:
        i = 1;
_L7:
        return i;
_L5:
        return -1;
_L2:
        Iterator iterator = val$keys.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            String s = (String)iterator.next();
            Object obj;
            Object obj1;
            boolean flag;
            int j;
            if (s.startsWith("-"))
            {
                s = s.substring(1);
                flag = true;
            } else
            {
                flag = false;
            }
            try
            {
                obj = OfflineQueryLogic.access$200(OfflineQueryLogic.this, parseobject, s);
                obj1 = OfflineQueryLogic.access$200(OfflineQueryLogic.this, parseobject1, s);
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject parseobject)
            {
                throw new RuntimeException(parseobject);
            }
            try
            {
                j = OfflineQueryLogic.access$000(obj, obj1);
            }
            // Misplaced declaration of an exception variable
            catch (ParseObject parseobject)
            {
                throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[] {
                    s
                }), parseobject);
            }
        } while (j == 0);
        i = j;
        if (flag)
        {
            return -j;
        }
        if (true) goto _L7; else goto _L6
_L6:
        return 0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ParseObject)obj, (ParseObject)obj1);
    }

    ion()
    {
        this$0 = final_offlinequerylogic;
        val$nearSphereKey = s;
        val$nearSphereValue = parsegeopoint;
        val$keys = List.this;
        super();
    }
}
