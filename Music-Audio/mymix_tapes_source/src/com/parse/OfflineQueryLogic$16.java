// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Comparator;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseException, ParseGeoPoint, ParseObject

class val.keys
    implements Comparator
{

    final OfflineQueryLogic this$0;
    final String val$keys[];
    final String val$nearSphereKey;
    final ParseGeoPoint val$nearSphereValue;

    public int compare(ParseObject parseobject, ParseObject parseobject1)
    {
        if (val$nearSphereKey != null)
        {
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
            if (d != d1)
            {
                return d - d1 <= 0.0D ? -1 : 1;
            }
        }
        String as[] = val$keys;
        int k = as.length;
        String s;
        for (int i = 0; i < k; i++)
        {
            Object obj = as[i];
            boolean flag = false;
            s = ((String) (obj));
            if (((String) (obj)).startsWith("-"))
            {
                flag = true;
                s = ((String) (obj)).substring(1);
            }
            Object obj1;
            int j;
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
            if (j != 0)
            {
                i = j;
                if (flag)
                {
                    i = -j;
                }
                return i;
            }
        }

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
        val$keys = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
