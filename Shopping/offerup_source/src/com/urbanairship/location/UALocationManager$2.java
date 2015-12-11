// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;


// Referenced classes of package com.urbanairship.location:
//            UALocationManager

class this._cls0
    implements com.urbanairship.PreferenceChangeListener
{

    final UALocationManager this$0;

    public void onPreferenceChange(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   56233632: 97
    //                   283482798: 83
    //                   375109006: 69;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_97;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            UALocationManager.access$200(UALocationManager.this);
            break;
        }
        break MISSING_BLOCK_LABEL_118;
_L4:
        if (s.equals("com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED"))
        {
            byte0 = 0;
        }
          goto _L5
_L3:
        if (s.equals("com.urbanairship.location.LOCATION_UPDATES_ENABLED"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("com.urbanairship.location.LOCATION_OPTIONS"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    eChangeListener()
    {
        this$0 = UALocationManager.this;
        super();
    }
}
