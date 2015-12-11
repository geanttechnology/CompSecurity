// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.wishabi.flipp.app.FlippApplication;
import com.wishabi.flipp.b.p;
import com.wishabi.flipp.b.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.wishabi.flipp.content:
//            c, i

public class a
{

    public static final String a = com/wishabi/flipp/content/a.getSimpleName();

    public a()
    {
    }

    public static boolean a(c c1, boolean flag, p p)
    {
        if (c1 == null)
        {
            return false;
        } else
        {
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(c1);
            return a(arraylist, flag, p, false);
        }
    }

    public static boolean a(ArrayList arraylist, boolean flag, p p, boolean flag1)
    {
        if (arraylist == null)
        {
            return false;
        }
        if (flag)
        {
            q q1;
            Iterator iterator;
            if (flag1)
            {
                q1 = q.d;
            } else
            {
                q1 = q.c;
            }
            iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                c c1 = (c)iterator.next();
                if (!c1.q)
                {
                    com.wishabi.flipp.b.a.a.a(c1, q1, p);
                }
            } while (true);
        }
        arraylist = a(arraylist);
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return a(((int []) (arraylist)), "clipped", Integer.valueOf(j));
    }

    public static boolean a(int ai[])
    {
        return a(ai, "sent", Integer.valueOf(1));
    }

    private static boolean a(int ai[], String s, Object obj)
    {
        Object obj1;
        ArrayList arraylist;
        HashSet hashset = null;
        if (ai == null || ai.length == 0)
        {
            return false;
        }
        if (TextUtils.isEmpty(s) || obj == null)
        {
            return false;
        }
        obj1 = FlippApplication.b();
        if (obj1 != null)
        {
            obj1 = ((Context) (obj1)).getContentResolver().query(i.t, new String[] {
                "_id"
            }, null, null, null);
            if (obj1 == null)
            {
                hashset = new HashSet();
            } else
            {
                int j = ((Cursor) (obj1)).getColumnIndex("_id");
                hashset = new HashSet(((Cursor) (obj1)).getCount());
                for (boolean flag = ((Cursor) (obj1)).moveToFirst(); flag; flag = ((Cursor) (obj1)).moveToNext())
                {
                    hashset.add(Integer.valueOf(((Cursor) (obj1)).getInt(j)));
                }

                ((Cursor) (obj1)).close();
            }
        }
        if (hashset == null)
        {
            return false;
        }
        obj1 = FlippApplication.b();
        if (obj1 == null)
        {
            return false;
        }
        obj1 = ((Context) (obj1)).getContentResolver();
        arraylist = new ArrayList();
        int l = ai.length;
        int k = 0;
        while (k < l) 
        {
            int i1 = ai[k];
            if (hashset.contains(Integer.valueOf(i1)))
            {
                arraylist.add(ContentProviderOperation.newUpdate(i.t).withSelection("_id = ?", new String[] {
                    Integer.toString(i1)
                }).withValue(s, obj).build());
            } else
            {
                arraylist.add(ContentProviderOperation.newInsert(i.t).withValue("_id", Integer.valueOf(i1)).withValue(s, obj).build());
            }
            k++;
        }
        ((ContentResolver) (obj1)).applyBatch("com.wishabi.flipp.models.User", arraylist);
        return true;
        ai;
_L2:
        ai.printStackTrace();
        return false;
        ai;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static int[] a(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return null;
        }
        int ai[] = new int[arraylist.size()];
        int k = arraylist.size();
        for (int j = 0; j < k; j++)
        {
            ai[j] = ((c)arraylist.get(j)).a;
        }

        return ai;
    }

}
