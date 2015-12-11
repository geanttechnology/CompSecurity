// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentValues;
import com.bestbuy.android.api.lib.models.blueshirt.StoreAppointment;
import java.util.List;

public class fq
{

    public static void a(StoreAppointment storeappointment)
    {
        fo fo1 = fo.a();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("appointment_id", storeappointment.getAppointmentId());
        contentvalues.put("store_id", storeappointment.getStoreId());
        contentvalues.put("store_name", storeappointment.getStoreName());
        contentvalues.put("store_address", storeappointment.getStoreAddress());
        contentvalues.put("store_city", storeappointment.getStoreCity());
        contentvalues.put("store_opentime", storeappointment.getStoreOpenTime());
        contentvalues.put("appointment_time", Long.valueOf(storeappointment.getAppointmentTime()));
        contentvalues.put("reminder_time", Long.valueOf(storeappointment.getReminderTime()));
        contentvalues.put("survey_shown", Boolean.valueOf(false));
        if (fo1 != null)
        {
            fo1.a("store_appointment_time", contentvalues);
        }
    }

    public static void a(String s)
    {
        fo fo1 = fo.a();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("survey_shown", Boolean.valueOf(true));
        if (s.isEmpty())
        {
            fo1.a("store_appointment_time", contentvalues, null, null);
            return;
        } else
        {
            fo1.a("store_appointment_time", contentvalues, (new StringBuilder("appointment_id")).append("=?").toString(), new String[] {
                s
            });
            return;
        }
    }

    public static void a(String s, long l)
    {
        fo fo1 = fo.a();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("appointment_time", Long.valueOf(l));
        fo1.a("store_appointment_time", contentvalues, (new StringBuilder("appointment_id")).append("=?").toString(), new String[] {
            s
        });
    }

    public static boolean a(long l)
    {
        Object obj = fo.a();
        String s = (new StringBuilder("survey_shown")).append("=?").toString();
        ((fo) (obj)).a("store_appointment_time", null, null, null, "appointment_time");
        obj = ((fo) (obj)).a("store_appointment_time", null, s, new String[] {
            "0"
        }, "appointment_time");
        if (((List) (obj)).size() > 0)
        {
            long l1 = ((ContentValues)((List) (obj)).get(0)).getAsLong("appointment_time").longValue();
            obj = ((ContentValues)((List) (obj)).get(0)).getAsString("appointment_id");
            long l2 = l1 + 0x48190800L;
            if (l > 0xa4cb80L + l1 && l < l2)
            {
                a("");
                return true;
            }
            if (l > l2)
            {
                a(((String) (obj)));
                return false;
            }
        }
        return false;
    }

    public static void b(String s)
    {
        fo.a().a("store_appointment_time", (new StringBuilder("appointment_id")).append("=?").toString(), new String[] {
            s
        });
    }
}
