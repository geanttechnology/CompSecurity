// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import com.flurry.android.FlurryAppCloudRequestManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.flurry.android.caching:
//            m, ObjectOperationData, k, h, 
//            g, j, i, f, 
//            e

final class b
{

    private m dk;
    private String dl;
    private Object dm;

    b()
    {
        dm = new Object();
    }

    static m a(b b1)
    {
        return b1.dk;
    }

    static String a(b b1, String s)
    {
        b1.dl = s;
        return s;
    }

    private m b(ObjectOperationData objectoperationdata)
    {
        dk = new m();
        ArrayList arraylist;
        String s1;
        arraylist = new ArrayList(objectoperationdata.getKeyValues());
        dl = objectoperationdata.getId();
        s1 = objectoperationdata.getCollectionName();
        String s = "v1/";
        if (objectoperationdata.getExecutorType() != ObjectData.ExecutorType.USER) goto _L2; else goto _L1
_L1:
        FlurryAppCloudRequestManager.fInternalApi = true;
        s = (new StringBuilder()).append("v1/").append("user").toString();
_L6:
        if (dl != null) goto _L4; else goto _L3
_L3:
        FlurryAppCloudRequestManager.Post(s, arraylist, new k(this));
_L7:
        synchronized (dm)
        {
            dm.wait(30000L);
        }
_L8:
        return dk;
_L2:
        if (objectoperationdata.getExecutorType() != ObjectData.ExecutorType.OBJECT) goto _L6; else goto _L5
_L5:
        s = (new StringBuilder()).append("v1/").append("object/").append(s1).toString();
          goto _L6
_L4:
        try
        {
            FlurryAppCloudRequestManager.Put((new StringBuilder()).append(s).append("/").append(dl).toString(), arraylist, new h(this));
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
          goto _L7
        exception;
        objectoperationdata;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
          goto _L8
    }

    static Object b(b b1)
    {
        return b1.dm;
    }

    private m c(ObjectOperationData objectoperationdata)
    {
        dk = new m();
        dl = objectoperationdata.getId();
        String s1 = objectoperationdata.getCollectionName();
        String s = "v1/";
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.USER)
        {
            FlurryAppCloudRequestManager.fInternalApi = true;
            s = (new StringBuilder()).append("v1/").append("user").toString();
        } else
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.OBJECT)
        {
            s = (new StringBuilder()).append("v1/").append("object/").append(s1).toString();
        }
        try
        {
            FlurryAppCloudRequestManager.Delete((new StringBuilder()).append(s).append("/").append(dl).toString(), new g(this));
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        synchronized (dm)
        {
            dm.wait(30000L);
        }
_L2:
        return dk;
        exception;
        objectoperationdata;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private m d(ObjectOperationData objectoperationdata)
    {
        dk = new m();
        dl = objectoperationdata.getId();
        String s1 = objectoperationdata.getCollectionName();
        String s = "v1/";
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.USER)
        {
            FlurryAppCloudRequestManager.fInternalApi = true;
            s = (new StringBuilder()).append("v1/").append("user").toString();
        } else
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.OBJECT)
        {
            s = (new StringBuilder()).append("v1/").append("object/").append(s1).toString();
        }
        try
        {
            FlurryAppCloudRequestManager.Get((new StringBuilder()).append(s).append("/").append(dl).toString(), null, new j(this));
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        synchronized (dm)
        {
            dm.wait(30000L);
        }
_L2:
        return dk;
        exception;
        objectoperationdata;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private m e(ObjectOperationData objectoperationdata)
    {
        dk = new m();
        String s = ((NameValuePair)objectoperationdata.getKeyValues().get(0)).getName();
        String s2 = ((NameValuePair)objectoperationdata.getKeyValues().get(0)).getValue();
        dl = objectoperationdata.getId();
        String s1 = objectoperationdata.getCollectionName();
        ArrayList arraylist = new ArrayList();
        if (s != null && !s.equals(""))
        {
            arraylist.add(new BasicNameValuePair(s, (new StringBuilder()).append("increment:").append(s2).toString()));
        }
        s = "";
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.USER)
        {
            FlurryAppCloudRequestManager.fInternalApi = true;
            s = (new StringBuilder()).append("").append("user").toString();
        } else
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.OBJECT)
        {
            s = (new StringBuilder()).append("").append("object/").append(s1).toString();
        }
        try
        {
            FlurryAppCloudRequestManager.Put((new StringBuilder()).append(s).append("/").append(dl).toString(), arraylist, new i(this));
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        synchronized (dm)
        {
            dm.wait(30000L);
        }
_L2:
        return dk;
        exception;
        objectoperationdata;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private m f(ObjectOperationData objectoperationdata)
    {
        dk = new m();
        String s = ((NameValuePair)objectoperationdata.getKeyValues().get(0)).getName();
        String s2 = ((NameValuePair)objectoperationdata.getKeyValues().get(0)).getValue();
        dl = objectoperationdata.getId();
        String s1 = objectoperationdata.getCollectionName();
        ArrayList arraylist = new ArrayList();
        if (s != null && !s.equals(""))
        {
            arraylist.add(new BasicNameValuePair(s, (new StringBuilder()).append("decrement:").append(s2).toString()));
        }
        s = "";
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.USER)
        {
            FlurryAppCloudRequestManager.fInternalApi = true;
            s = (new StringBuilder()).append("").append("user").toString();
        } else
        if (objectoperationdata.getExecutorType() == ObjectData.ExecutorType.OBJECT)
        {
            s = (new StringBuilder()).append("").append("object/").append(s1).toString();
        }
        try
        {
            FlurryAppCloudRequestManager.Put((new StringBuilder()).append(s).append("/").append(dl).toString(), arraylist, new f(this));
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        synchronized (dm)
        {
            dm.wait(30000L);
        }
_L2:
        return dk;
        exception;
        objectoperationdata;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private m g(ObjectOperationData objectoperationdata)
    {
        dk = new m();
        objectoperationdata = objectoperationdata.getSearchURL();
        Log.d("Trestle", (new StringBuilder()).append("Search url ").append(objectoperationdata).toString());
        try
        {
            FlurryAppCloudRequestManager.Get(objectoperationdata, null, new e(this));
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        synchronized (dm)
        {
            dm.wait(30000L);
        }
_L2:
        return dk;
        exception;
        objectoperationdata;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (ObjectOperationData objectoperationdata)
        {
            objectoperationdata.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final m a(ObjectOperationData objectoperationdata)
    {
        switch (objectoperationdata.getOperationType())
        {
        default:
            return null;

        case 1: // '\001'
            return b(objectoperationdata);

        case 2: // '\002'
            return d(objectoperationdata);

        case 4: // '\004'
            return c(objectoperationdata);

        case 8: // '\b'
            return g(objectoperationdata);

        case 16: // '\020'
            return e(objectoperationdata);

        case 32: // ' '
            return f(objectoperationdata);
        }
    }
}
