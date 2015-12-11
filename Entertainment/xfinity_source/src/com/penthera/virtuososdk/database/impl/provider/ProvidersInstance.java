// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProvidersInstance
{

    private static final String LOG_TAG = com/penthera/virtuososdk/database/impl/provider/ProvidersInstance.getName();
    private static Lock iLock = new ReentrantLock();
    private String iAuthority;
    private ContentResolver resolver;

    public ProvidersInstance(ContentResolver contentresolver, String s)
    {
        resolver = contentresolver;
        iAuthority = s;
    }

    private void addProvider(ContentValues contentvalues, String s)
    {
        try
        {
            resolver.insert(Provider.ProviderColumns.CONTENT_URI(s), contentvalues);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentValues contentvalues)
        {
            removeProvider(s);
        }
    }

    private void remove(String s, String s1)
    {
        try
        {
            iLock.lock();
        }
        catch (Exception exception)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Lock Failed in provider remove", exception);
        }
        resolver.delete(Provider.ProviderColumns.CONTENT_URI(s1), "provider=?", new String[] {
            s
        });
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
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "remove(provider): delete issue ", s);
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

    public List addProvider(String s)
    {
        List list = getProviders();
        if (list.contains(s)) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("provider", s);
        if (list.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        s = list.iterator();
_L4:
        if (s.hasNext()) goto _L3; else goto _L2
_L2:
        return getProviders();
_L3:
        addProvider(contentvalues, (String)s.next());
          goto _L4
        addProvider(contentvalues, iAuthority);
          goto _L2
    }

    public List getProviders()
    {
        Cursor cursor;
        Cursor cursor1;
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj = Provider.ProviderColumns.CONTENT_URI(iAuthority);
        cursor1 = null;
        cursor = null;
        obj = resolver.query(((android.net.Uri) (obj)), new String[] {
            "provider"
        }, null, null, null);
        if (obj == null) goto _L2; else goto _L1
_L1:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        if (!((Cursor) (obj)).moveToNext()) goto _L2; else goto _L3
_L3:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        int i = ((Cursor) (obj)).getColumnIndex("provider");
_L4:
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        arraylist.add(((Cursor) (obj)).getString(i));
        cursor = ((Cursor) (obj));
        cursor1 = ((Cursor) (obj));
        boolean flag = ((Cursor) (obj)).moveToNext();
        if (flag) goto _L4; else goto _L2
_L2:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
_L6:
        return arraylist;
        Exception exception1;
        exception1;
        cursor1 = cursor;
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "Providers get exception: ", exception1);
        if (cursor == null) goto _L6; else goto _L5
_L5:
        cursor.close();
        return arraylist;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    public void removeProvider(String s)
    {
        Object obj;
        if (s == null)
        {
            return;
        }
        boolean flag;
        try
        {
            iLock.lock();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "Lock Failed in provider removeProvider", ((Throwable) (obj)));
        }
        resolver.delete(Provider.ProviderColumns.CONTENT_URI(iAuthority), "provider=?", new String[] {
            s
        });
        obj = getProviders().iterator();
_L1:
        flag = ((Iterator) (obj)).hasNext();
        if (!flag)
        {
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
        }
        String s1 = (String)((Iterator) (obj)).next();
        if (!s1.equals(iAuthority))
        {
            remove(s, s1);
        }
          goto _L1
        s;
        com.penthera.virtuososdk.utility.CommonUtil.Log.e(LOG_TAG, "removeProvider(provider): delete issue in current auth", s);
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
        catch (Exception exception) { }
        throw s;
    }

}
