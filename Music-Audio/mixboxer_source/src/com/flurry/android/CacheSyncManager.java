// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.flurry.android.caching.CachingManager;
import com.flurry.android.caching.ObjectData;
import com.flurry.android.caching.ObjectOperationData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            gn, FlurryAppCloud, at, az, 
//            dc, av, AppCloudResponse, AppCloudResponseHandler, 
//            bc, be, bg

public class CacheSyncManager
{

    private static HashMap i = new HashMap();
    private az f;
    private at g;
    private dc h;

    CacheSyncManager()
    {
        f = null;
        g = null;
        h = null;
        g = (at)FlurryAppCloud.a(gn.iI);
        f = (az)FlurryAppCloud.a(gn.iJ);
        h = (dc)FlurryAppCloud.a(gn.iK);
    }

    static at a(CacheSyncManager cachesyncmanager)
    {
        return cachesyncmanager.g;
    }

    static az b(CacheSyncManager cachesyncmanager)
    {
        return cachesyncmanager.f;
    }

    static HashMap b()
    {
        return i;
    }

    static dc c(CacheSyncManager cachesyncmanager)
    {
        return cachesyncmanager.h;
    }

    final void a()
    {
        g = (at)FlurryAppCloud.a(gn.iI);
        f = (az)FlurryAppCloud.a(gn.iJ);
        h = (dc)FlurryAppCloud.a(gn.iK);
    }

    public boolean checkIfDeleted(String s)
    {
        return h.contains(s) && h.r(s) == 2;
    }

    public at getPendingData()
    {
        return g;
    }

    public az getServerData()
    {
        return f;
    }

    public boolean hasRegisteredObjects()
    {
        return !h.isEmpty();
    }

    public void registerDirtyObject(String s, AppCloudResponseHandler appcloudresponsehandler, int j)
    {
        int k = j;
        j;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 47
    //                   2 47
    //                   3 36
    //                   4 180;
           goto _L1 _L2 _L2 _L1 _L3
_L2:
        break MISSING_BLOCK_LABEL_47;
_L1:
        Log.e("CacheSyncManager", "Register Object - STATE_UP_TO_DATE or default");
        k = j;
_L5:
        if (appcloudresponsehandler != null)
        {
            i.put(s, appcloudresponsehandler);
        }
        appcloudresponsehandler = h;
        Log.d("CacheDirtyOperationsDB", (new StringBuilder()).append("--- Insert in ").append(((dc) (appcloudresponsehandler)).cE).append(" : ---").toString());
        if (appcloudresponsehandler.contains(s))
        {
            appcloudresponsehandler.s(s);
        }
        SQLiteDatabase sqlitedatabase = ((dc) (appcloudresponsehandler)).cD.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("objectsId", s);
        contentvalues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        contentvalues.put("value", Integer.valueOf(k));
        sqlitedatabase.insert(((dc) (appcloudresponsehandler)).cE, null, contentvalues);
        synchronize();
        return;
_L3:
        k = j;
        if (h.contains(s))
        {
            int l = h.r(s);
            if (l == 2)
            {
                try
                {
                    appcloudresponsehandler.handleResponse(new AppCloudResponse(new JSONObject("{code:\"400\",note:\"Object is already deleted, new one has to be created.\"}")));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                }
                return;
            }
            k = j;
            if (l == 1)
            {
                k = 1;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void synchronize()
    {
_L2:
        return;
        if (h != null && !h.isEmpty())
        {
            Object obj1 = h;
            HashMap hashmap = new HashMap();
            obj1 = ((dc) (obj1)).cD.getReadableDatabase().query(((dc) (obj1)).cE, null, null, null, null, null, null);
            if (((Cursor) (obj1)).moveToFirst())
            {
                int j = ((Cursor) (obj1)).getColumnIndex("objectsId");
                int i1 = ((Cursor) (obj1)).getColumnIndex("value");
                do
                {
                    hashmap.put(((Cursor) (obj1)).getString(j), Integer.valueOf(((Cursor) (obj1)).getInt(i1)));
                } while (((Cursor) (obj1)).moveToNext());
            }
            ((Cursor) (obj1)).close();
            Iterator iterator = hashmap.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Object obj3 = (String)entry.getKey();
                switch (((Integer)entry.getValue()).intValue())
                {
                case 3: // '\003'
                default:
                    Log.e("CacheSyncManager", "ERROR - STATE_UP_TO_DATE or default");
                    break;

                case 1: // '\001'
                    boolean flag = g.isUserObject(((String) (obj3)));
                    Object obj2 = g.getObjectById(((String) (obj3)));
                    ObjectOperationData objectoperationdata;
                    if (flag || obj2 == null)
                    {
                        Log.i("CacheSyncManager", "create user");
                        objectoperationdata = new ObjectOperationData(null);
                    } else
                    {
                        Log.i("CacheSyncManager", "create object");
                        objectoperationdata = new ObjectOperationData(null, ((ObjectData) (obj2)).getCollectionName());
                    }
                    if (obj2 != null)
                    {
                        obj2 = ((ObjectData) (obj2)).getKeyValues();
                        for (int k = 0; k < ((Vector) (obj2)).size(); k++)
                        {
                            objectoperationdata.addKeyValue(((NameValuePair)((Vector) (obj2)).get(k)).getName(), ((NameValuePair)((Vector) (obj2)).get(k)).getValue());
                        }

                    }
                    FlurryAppCloud.C().saveOrCreateOperation(objectoperationdata, new bc(this, ((String) (obj3)), flag));
                    break;

                case 4: // '\004'
                    boolean flag1 = g.isUserObject(((String) (obj3)));
                    obj3 = g.getObjectById(((String) (obj3)));
                    String s = ((ObjectData) (obj3)).getId();
                    ObjectOperationData objectoperationdata1;
                    if (flag1)
                    {
                        objectoperationdata1 = new ObjectOperationData(s);
                    } else
                    {
                        objectoperationdata1 = new ObjectOperationData(s, ((ObjectData) (obj3)).getCollectionName());
                    }
                    obj3 = ((ObjectData) (obj3)).getKeyValues();
                    for (int l = 0; l < ((Vector) (obj3)).size(); l++)
                    {
                        objectoperationdata1.addKeyValue(((NameValuePair)((Vector) (obj3)).get(l)).getName(), ((NameValuePair)((Vector) (obj3)).get(l)).getValue());
                    }

                    FlurryAppCloud.C().saveOrCreateOperation(objectoperationdata1, new be(this, s, ((Vector) (obj3))));
                    break;

                case 2: // '\002'
                    Log.i("CacheSyncManager", "STATE_DELETED");
                    ObjectData objectdata = g.getObjectById(((String) (obj3)));
                    Object obj = objectdata;
                    if (objectdata == null)
                    {
                        ObjectData objectdata1 = f.getObjectById(((String) (obj3)));
                        obj = objectdata1;
                        if (objectdata1 == null)
                        {
                            Log.e("CacheSyncManager", "ERROR! on delete.., no data for ID");
                            obj = objectdata1;
                        }
                    }
                    if (obj != null && ((ObjectData) (obj)).isObject())
                    {
                        obj = new ObjectOperationData(((String) (obj3)), ((ObjectData) (obj)).getCollectionName());
                    } else
                    {
                        obj = new ObjectOperationData(((String) (obj3)));
                    }
                    FlurryAppCloud.C().deleteOperation(((ObjectOperationData) (obj)), new bg(this, ((String) (obj3))));
                    break;
                }
            } while (true);
        }
          goto _L1
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void toStringAndPrint()
    {
        Log.i("CacheSyncManager", "============PENDING DATA==================");
        g.aI();
        Log.i("CacheSyncManager", "============SERVER DATA==================");
        f.aI();
        Log.i("CacheSyncManager", "============Registered Dirty Objects==================");
        h.readAll();
    }

}
