// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.RenderView;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package com.inmobi.rendering.mraid:
//            n, a

class f
    implements com.inmobi.rendering.biAdActivity.a
{

    final Context a;
    final int b;
    final String c;
    final String d;
    final String e;
    final String f;
    final n g;

    public void a(int i, Intent intent)
    {
        Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, n.a(), (new StringBuilder()).append("Result code: ").append(i).toString());
        i = com.inmobi.rendering.mraid.a.a(a);
        if (b != i) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, n.a(), "User cancelled the create calendar event");
_L12:
        return;
_L2:
        Object obj;
        obj = new ContentValues();
        intent = c;
        i = -1;
        intent.hashCode();
        JVM INSTR lookupswitch 3: default 108
    //                   -1320822226: 280
    //                   -804109473: 294
    //                   476588369: 308;
           goto _L3 _L4 _L5 _L6
_L3:
        i;
        JVM INSTR tableswitch 0 2: default 136
    //                   0 322
    //                   1 335
    //                   2 348;
           goto _L7 _L8 _L9 _L10
_L7:
        intent = a.getContentResolver();
        intent.update(ContentUris.withAppendedId(android.provider.ndarContract.Events.CONTENT_URI, com.inmobi.rendering.mraid.a.a(a)), ((ContentValues) (obj)), null, null);
        if (d == null || "".equals(d)) goto _L12; else goto _L11
_L11:
        if (!d.startsWith("+")) goto _L14; else goto _L13
_L13:
        i = Integer.parseInt(d.substring(1)) / 60000;
_L15:
        i = -i;
        intent.delete(android.provider.ndarContract.Reminders.CONTENT_URI, "event_id=?", new String[] {
            (new StringBuilder()).append(com.inmobi.rendering.mraid.a.a(a)).append("").toString()
        });
        NumberFormatException numberformatexception;
        int j;
        if (i < 0)
        {
            n.a(g).a(f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
            return;
        } else
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("event_id", Integer.valueOf(com.inmobi.rendering.mraid.a.a(a)));
            contentvalues.put("method", Integer.valueOf(1));
            contentvalues.put("minutes", Integer.valueOf(i));
            intent.insert(android.provider.ndarContract.Reminders.CONTENT_URI, contentvalues);
            return;
        }
_L4:
        if (intent.equals("tentative"))
        {
            i = 0;
        }
          goto _L3
_L5:
        if (intent.equals("confirmed"))
        {
            i = 1;
        }
          goto _L3
_L6:
        if (intent.equals("cancelled"))
        {
            i = 2;
        }
          goto _L3
_L8:
        ((ContentValues) (obj)).put("eventStatus", Integer.valueOf(0));
          goto _L7
_L9:
        ((ContentValues) (obj)).put("eventStatus", Integer.valueOf(1));
          goto _L7
_L10:
        ((ContentValues) (obj)).put("eventStatus", Integer.valueOf(2));
          goto _L7
_L14:
        i = Integer.parseInt(d) / 60000;
          goto _L15
        numberformatexception;
        numberformatexception = com.inmobi.rendering.mraid.a.b(d);
        if (numberformatexception == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, n.a(), (new StringBuilder()).append("Invalid reminder date provided. date string: ").append(d).toString());
            return;
        }
        j = (int)(numberformatexception.getTimeInMillis() - com.inmobi.rendering.mraid.a.b(e).getTimeInMillis()) / 60000;
        i = j;
        if (j <= 0) goto _L15; else goto _L16
_L16:
        n.a(g).a(f, "Reminder format is incorrect. Reminder can be set only before the event starts", "createCalendarEvent");
        return;
          goto _L3
    }

    (n n1, Context context, int i, String s, String s1, String s2, String s3)
    {
        g = n1;
        a = context;
        b = i;
        c = s;
        d = s1;
        e = s2;
        f = s3;
        super();
    }
}
