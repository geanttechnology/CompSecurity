// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.utility:
//            t, u, h, v, 
//            d

public class s
{

    private final Object a = new Object();
    private boolean b;
    private List c;
    private BlockingQueue d;

    public s()
    {
        b = false;
        d = new LinkedBlockingQueue();
        c = new ArrayList();
        (new Thread(new Runnable() {

            final s a;

            public void run()
            {
                Thread.currentThread().setName("Update Sticker Shop List");
                for (; !s.a(a); s.b(a)) { }
            }

            
            {
                a = s.this;
                super();
            }
        })).start();
    }

    public static s a()
    {
        return t.a();
    }

    private void a(String s1, boolean flag)
    {
        Log.d("StickerHelper", (new StringBuilder()).append("[notifyListener] In : CallbackType = ").append(s1).toString());
        s s2 = a();
        s2;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((u)iterator.next()).a(s1, flag)) { }
        break MISSING_BLOCK_LABEL_77;
        s1;
        s2;
        JVM INSTR monitorexit ;
        throw s1;
        s2;
        JVM INSTR monitorexit ;
    }

    private void a(List list, String s1)
    {
_L2:
        return;
        if (list == null || list.size() == 0) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject();
        i = 0;
_L4:
        String s2;
        StickerPackObj stickerpackobj;
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = (new StringBuilder()).append("StickerPack_").append(i).toString();
        stickerpackobj = (StickerPackObj)list.get(i);
        if (stickerpackobj != null)
        {
            try
            {
                jsonobject.put(s2, stickerpackobj.t());
            }
            // Misplaced declaration of an exception variable
            catch (List list)
            {
                list.printStackTrace();
                return;
            }
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        g.a().a(s1, jsonobject.toString());
        if (s1.equals("Top"))
        {
            long l1 = (new Date()).getTime();
            g.a().d(l1);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    static boolean a(s s1)
    {
        return s1.b;
    }

    private List b(String s1)
    {
        s1 = h.a(h.b(s1), false, false);
        if (s1 != null)
        {
            return s1;
        } else
        {
            return new ArrayList();
        }
    }

    static void b(s s1)
    {
        s1.d();
    }

    private void d()
    {
        if (d.isEmpty())
        {
            synchronized (a)
            {
                a.wait();
            }
        }
        try
        {
            obj = (v)d.peek();
            boolean flag = a(v.a(((v) (obj))), v.b(((v) (obj))));
            d.remove();
            a(v.a(((v) (obj))), flag);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_84;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List a(String s1)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        s1 = g.a().e(s1);
        if (!s1.equals("")) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        StickerPackObj stickerpackobj;
        int i;
        int j;
        try
        {
            s1 = new JSONObject(s1);
            j = s1.length();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            arraylist.clear();
            return arraylist;
        }
        i = 0;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        stickerpackobj = new StickerPackObj(new JSONObject(s1.getString((new StringBuilder()).append("StickerPack_").append(i).toString())));
        if (stickerpackobj == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        arraylist.add(stickerpackobj);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_108;
_L4:
        break MISSING_BLOCK_LABEL_45;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void a(u u1)
    {
        s s1 = a();
        s1;
        JVM INSTR monitorenter ;
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        c.add(u1);
        s1;
        JVM INSTR monitorexit ;
        return;
        u1;
        s1;
        JVM INSTR monitorexit ;
        throw u1;
    }

    public void a(v v1)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            if (v.a((v)iterator.next()).equals(v.a(v1)))
            {
                return;
            }
        }

        d.add(v1);
        synchronized (a)
        {
            a.notify();
        }
        return;
        exception;
        v1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a(String s1, Activity activity)
    {
        Log.v("StickerHelper", (new StringBuilder()).append("updateStickerShopList ").append(s1).toString());
        String s3 = g.a().e();
        Object obj = new ArrayList();
        ((List) (obj)).add(new BasicNameValuePair("token", s3));
        ((List) (obj)).add(new BasicNameValuePair("pageIndex", String.valueOf(1)));
        ((List) (obj)).add(new BasicNameValuePair("pageSize", String.valueOf(50)));
        String s2;
        Object obj1;
        String s4;
        if (s1.equals("Top"))
        {
            s2 = "pack.topV2";
        } else
        if (s1.equals("New"))
        {
            s2 = "pack.newV2";
        } else
        {
            s2 = "pack.newV2";
        }
        activity = new l(activity);
        obj = activity.a("sticker", s2, ((List) (obj)));
        obj1 = (String)((Pair) (obj)).first;
        s4 = (String)((Pair) (obj)).second;
        obj = new ArrayList();
        boolean flag;
        if (obj1 != null && ((String) (obj1)).equals("200"))
        {
            int i = com.cyberlink.you.utility.d.a(s4);
            int k = com.cyberlink.you.utility.d.b(s4);
            int j = com.cyberlink.you.utility.d.a(i, 50);
            if (i != -1 && k != -1)
            {
                if (i != k)
                {
                    obj1 = b(s4);
                    ((List) (obj)).addAll(((java.util.Collection) (obj1)));
                    ((List) (obj1)).clear();
                    i = 2;
                    while (i <= j) 
                    {
                        obj1 = new ArrayList();
                        ((List) (obj1)).add(new BasicNameValuePair("token", s3));
                        ((List) (obj1)).add(new BasicNameValuePair("pageIndex", String.valueOf(i)));
                        ((List) (obj1)).add(new BasicNameValuePair("pageSize", String.valueOf(50)));
                        Object obj2 = activity.a("sticker", s2, ((List) (obj1)));
                        obj1 = (String)((Pair) (obj2)).first;
                        obj2 = (String)((Pair) (obj2)).second;
                        if (obj1 != null && ((String) (obj1)).equals("200"))
                        {
                            obj1 = b(((String) (obj2)));
                            ((List) (obj)).addAll(((java.util.Collection) (obj1)));
                            ((List) (obj1)).clear();
                        } else
                        {
                            Log.d("StickerHelper", (new StringBuilder()).append("statuscode = ").append(((String) (obj1))).toString());
                        }
                        i++;
                    }
                }
            } else
            {
                Log.d("StickerHelper", (new StringBuilder()).append("totalSize = ").append(i).append(" resultsSize ").append(k).toString());
            }
            flag = true;
        } else
        {
            Log.d("StickerHelper", (new StringBuilder()).append("statuscode = ").append(((String) (obj1))).toString());
            flag = false;
        }
        activity.b();
        if (flag)
        {
            a(((List) (obj)), s1);
        }
        return flag;
    }

    public void b(u u1)
    {
        s s1 = a();
        s1;
        JVM INSTR monitorenter ;
        if (u1 == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        c.remove(u1);
        s1;
        JVM INSTR monitorexit ;
        return;
        u1;
        s1;
        JVM INSTR monitorexit ;
        throw u1;
    }

    public boolean b()
    {
        long l1 = g.a().x();
        long l2 = (new Date()).getTime();
        boolean flag = false;
        if (l1 <= 0L || l2 - l1 >= 0x1b77400L)
        {
            g.a().c(l2);
            flag = true;
        }
        Log.d("StickerHelper", (new StringBuilder()).append("[checkLastStickerCheckDateExpire] bExpired = ").append(flag).toString());
        return flag;
    }

    public boolean c()
    {
        long l1 = g.a().y();
        long l2 = (new Date()).getTime();
        boolean flag = false;
        if (l1 <= 0L || l2 - l1 >= 0x5265c00L)
        {
            flag = true;
        }
        Log.d("StickerHelper", (new StringBuilder()).append("[checkTopLastStickerCheckDateExpire] bExpired = ").append(flag).toString());
        return flag;
    }
}
