// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.os.AsyncTask;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// Referenced classes of package co.vine.android:
//            ContactEntry

public class SortContactsTask extends AsyncTask
{

    public SortContactsTask()
    {
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Cursor[])aobj);
    }

    protected final transient ArrayList doInBackground(Cursor acursor[])
    {
        acursor = acursor[0];
        try
        {
            acursor = prepareEntries(acursor);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor acursor[])
        {
            SLog.e("Failed to prepare entries, cursor closed?", acursor);
            return new ArrayList();
        }
        return acursor;
    }

    protected ArrayList prepareEntries(Cursor cursor)
    {
        SLog.d("Sorting contacts.");
        ArrayList arraylist = new ArrayList(cursor.getCount());
        while (cursor.moveToNext()) 
        {
            Object obj = null;
            if (!arraylist.isEmpty())
            {
                obj = (ContactEntry)arraylist.get(arraylist.size() - 1);
            }
            String s = cursor.getString(3);
            byte byte0;
            int i;
            if (obj != null && ((ContactEntry) (obj)).contactId == cursor.getLong(0))
            {
                i = ((ContactEntry) (obj)).typeFlag;
                String s1;
                if ("vnd.android.cursor.item/email_v2".equals(s))
                {
                    byte0 = 1;
                } else
                {
                    byte0 = 2;
                }
                obj.typeFlag = byte0 | i;
            } else
            {
                obj = new ContactEntry(cursor);
                arraylist.add(obj);
            }
            obj = ((ContactEntry) (obj)).valueMimeMap;
            s1 = cursor.getString(4);
            if ("vnd.android.cursor.item/email_v2".equals(s))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if ("vnd.android.cursor.item/phone_v2".equals(s))
            {
                i = 2;
            } else
            {
                i = 0;
            }
            ((HashMap) (obj)).put(s1, Integer.valueOf(byte0 | i));
        }
        Collections.sort(arraylist);
        SLog.d("Sorting contacts complete.");
        return arraylist;
    }
}
