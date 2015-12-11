// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RegistryInstance
{

    private static final String LOG_TAG = com/penthera/virtuososdk/database/impl/provider/RegistryInstance.getName();
    protected static Lock iLock = new ReentrantLock();
    protected String iAuthority;
    protected ContentResolver resolver;

    public RegistryInstance(ContentResolver contentresolver, String s)
    {
        resolver = contentresolver;
        iAuthority = s;
    }

    private List queue(String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        s = get(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        s = s.split(",");
        j = s.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return arraylist;
_L3:
        String s1 = s[i];
        if (s1 != null && s1.trim().length() > 0)
        {
            arraylist.add(s1);
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void saveErrorQueue(String s, List list, boolean flag)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        saveQueue((new StringBuilder(String.valueOf(s1))).append("errorQueue").toString(), list, flag);
    }

    private void savePendingQueue(String s, List list, boolean flag)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        saveQueue((new StringBuilder(String.valueOf(s1))).append("pendingQueue").toString(), list, flag);
    }

    private void saveQueue(String s, List list, boolean flag)
    {
        List list1;
        StringBuffer stringbuffer;
        int i;
        int j;
        stringbuffer = new StringBuffer();
        list1 = null;
        if (!flag)
        {
            list1 = queue(s);
        }
        j = list.size();
        i = 0;
_L2:
        String s1;
        if (i >= j)
        {
            set(s, stringbuffer.toString());
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("queue[")).append(s).append("]: ").append(stringbuffer.toString()).toString());
            return;
        }
        s1 = (String)list.get(i);
        if (list1 == null || list1.contains(s1))
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        stringbuffer.append(s1);
        if (i + 1 < j)
        {
            stringbuffer.append(",");
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public List errorQueue(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return queue((new StringBuilder(String.valueOf(s1))).append("errorQueue").toString());
    }

    public String get(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = Uri.parse((new StringBuilder()).append(Registry.RegistryColumns.CONTENT_URI(iAuthority)).append("/name/").append(s).toString());
        obj = null;
        s = null;
        obj2 = null;
        obj3 = null;
        Cursor cursor = resolver.query(((Uri) (obj1)), new String[] {
            "name", "value"
        }, null, null, null);
        obj1 = obj3;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj1 = obj3;
        s = cursor;
        obj = cursor;
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        s = cursor;
        obj = cursor;
        obj1 = cursor.getString(cursor.getColumnIndex("value"));
        obj = obj1;
        if (cursor != null)
        {
            cursor.close();
            obj = obj1;
        }
_L2:
        return ((String) (obj));
        Exception exception;
        exception;
        obj = s;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Registry get exception: ", exception);
        obj = obj2;
        if (s == null) goto _L2; else goto _L1
_L1:
        s.close();
        return null;
        s;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw s;
    }

    public Bundle getBundle()
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        Bundle bundle;
        obj = Registry.RegistryColumns.CONTENT_URI(iAuthority);
        cursor1 = null;
        cursor = null;
        bundle = new Bundle();
        obj = resolver.query(((Uri) (obj)), new String[] {
            "name", "value"
        }, null, null, null);
        if (obj == null) goto _L2; else goto _L1
_L1:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        ((Cursor) (obj)).moveToFirst();
_L7:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        boolean flag = ((Cursor) (obj)).isAfterLast();
        if (!flag) goto _L3; else goto _L2
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L5:
        return bundle;
_L3:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        bundle.putString(((Cursor) (obj)).getString(0), ((Cursor) (obj)).getString(1));
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        ((Cursor) (obj)).moveToNext();
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        cursor1 = cursor;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Registry getBundle exception: ", exception1);
        if (cursor == null) goto _L5; else goto _L4
_L4:
        cursor.close();
        return bundle;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public List pendingQueue(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return queue((new StringBuilder(String.valueOf(s1))).append("pendingQueue").toString());
    }

    public void removeOverrideValues(Bundle bundle)
    {
        Bundle bundle1;
        bundle1 = getBundle();
        bundle = bundle.keySet().iterator();
_L1:
        String s;
        do
        {
            if (!bundle.hasNext())
            {
                return;
            }
            s = (String)bundle.next();
        } while (bundle1.getString(s) == null);
        Exception exception1;
        try
        {
            iLock.lock();
        }
        catch (Exception exception3)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Lock Failed in registry removeOverrideValues", exception3);
        }
        s = (new StringBuilder("name='")).append(s).append("'").toString();
        resolver.delete(Registry.RegistryColumns.CONTENT_URI(iAuthority), s, null);
        try
        {
            iLock.unlock();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception1) { }
          goto _L1
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "removeOverrideValues(): delete issue ", illegalargumentexception);
        try
        {
            iLock.unlock();
        }
        catch (Exception exception2) { }
          goto _L1
        bundle;
        try
        {
            iLock.unlock();
        }
        catch (Exception exception) { }
        throw bundle;
    }

    public void saveErrorQueue(String s, List list)
    {
        saveErrorQueue(s, list, true);
    }

    public void savePendingQueue(String s, List list)
    {
        savePendingQueue(s, list, true);
    }

    public void savePendingQueueNoAdd(String s, List list)
    {
        savePendingQueue(s, list, false);
    }

    public void set(String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name", s);
        contentvalues.put("value", s1);
        try
        {
            iLock.lock();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Lock Failed in registry set", s1);
        }
        s = (new StringBuilder("name='")).append(s).append("'").toString();
        resolver.update(Registry.RegistryColumns.CONTENT_URI(iAuthority), contentvalues, s, null);
        try
        {
            iLock.unlock();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        s;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "set(): update issue ", s);
        try
        {
            iLock.unlock();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        s;
        try
        {
            iLock.unlock();
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        throw s;
    }

    public List unqueuedQueue(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return queue((new StringBuilder(String.valueOf(s1))).append("unqueued").toString());
    }

    public void updateRegistry(Bundle bundle)
    {
        Bundle bundle1 = getBundle();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            String s = (String)iterator.next();
            String s1 = bundle.get(s).toString();
            String s2 = bundle1.getString(s);
            if (s2 == null || !s2.equals(s1))
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Setting registry for ")).append(s).append(" with ").append(s1).toString());
                set(s, s1);
            } else
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Not replacing ")).append(s2).append(" in registry for ").append(s).append(" with ").append(s1).toString());
            }
        } while (true);
    }

}
