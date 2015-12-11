// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.text.TextUtils;
import android.util.Log;
import com.flurry.android.responses.AppCloudError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;

// Referenced classes of package com.flurry.android:
//            AppCloudResponse, ac, FlurryWalletHandler, AppCloudValueUpdateHandler, 
//            gf, FlurryWalletInfo, AppCloudUser, bf, 
//            AppCloudObject, bd

final class bv
{

    private HashMap Y;
    private boolean dM;
    private long dN;
    private String mCollectionName;
    private String mId;

    bv(String s)
    {
        mId = null;
        mCollectionName = null;
        dM = false;
        dN = 30000L;
        Y = new HashMap();
        mId = s;
        mCollectionName = null;
    }

    bv(String s, String s1)
    {
        mId = null;
        mCollectionName = null;
        dM = false;
        dN = 30000L;
        Y = new HashMap();
        mId = s;
        mCollectionName = s1;
    }

    private long a(int l)
    {
        if (l == 0)
        {
            return 0L;
        } else
        {
            return dN;
        }
    }

    static boolean a(bv bv1, AppCloudResponse appcloudresponse, String s)
    {
        if (appcloudresponse != null && !appcloudresponse.isSuccessful() && appcloudresponse.getResponseMessage().equals("invalid user session"))
        {
            if (bv1.Y.containsKey(s))
            {
                for (bv1 = ((ac)bv1.Y.get(s)).bT.iterator(); bv1.hasNext();)
                {
                    appcloudresponse = ((AppCloudResponse) (bv1.next()));
                    if (appcloudresponse instanceof FlurryWalletHandler)
                    {
                        ((FlurryWalletHandler)appcloudresponse).onError(new AppCloudError(405, "Session not valid, user has to relogin!"));
                    } else
                    if (appcloudresponse instanceof AppCloudValueUpdateHandler)
                    {
                        ((AppCloudValueUpdateHandler)appcloudresponse).onError(new AppCloudError(405, "Session not valid, user has to relogin!"));
                    } else
                    {
                        Log.e("ObserverItem", "CALLBACK ERROR!");
                    }
                }

            }
            return false;
        } else
        {
            return true;
        }
    }

    private void an()
    {
        for (Iterator iterator = Y.entrySet().iterator(); iterator.hasNext(); j((String)((java.util.Map.Entry)iterator.next()).getKey())) { }
    }

    private void ao()
    {
        for (Iterator iterator = Y.entrySet().iterator(); iterator.hasNext(); i((String)((java.util.Map.Entry)iterator.next()).getKey())) { }
    }

    private void i(String s)
    {
        if (((ac)Y.get(s)).bS == null)
        {
            return;
        }
        ac ac1 = (ac)Y.get(s);
        if (ac1 == null)
        {
            Log.e("ObserverItem", "stopTimerForKey ERROR, info == null");
            return;
        }
        if (ac1.bS != null)
        {
            ac1.bS.cancel();
            ac1.bS = null;
        }
        Y.put(s, ac1);
    }

    private void j(String s)
    {
        a(s, Long.valueOf(a(0)));
    }

    protected final void a(String s, Long long1)
    {
        i(s);
        if (!dM)
        {
            return;
        }
        ac ac1 = (ac)Y.get(s);
        if (ac1 == null)
        {
            Log.e("ObserverItem", "scheduleTimerForKey ERROR, info == null");
            return;
        } else
        {
            ac1.bS = new Timer();
            gf gf1 = new gf(this, s);
            Log.i("ObserverItem", "schedule");
            ac1.bS.schedule(gf1, long1.longValue());
            Y.put(s, ac1);
            return;
        }
    }

    public final boolean a(Object obj)
    {
        Iterator iterator = Y.entrySet().iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            List list = ((ac)((java.util.Map.Entry)iterator.next()).getValue()).bT;
            if (list.contains(obj))
            {
                list.remove(obj);
                if (list.size() == 0)
                {
                    iterator.remove();
                }
                flag = true;
            }
        } while (true);
        return flag;
    }

    public final void al()
    {
        dM = true;
        an();
    }

    public final void am()
    {
        dM = false;
        ao();
    }

    protected final void b(String s, Object obj)
    {
        if (!Y.containsKey(s)) goto _L2; else goto _L1
_L1:
        ac ac1 = (ac)Y.get(s);
        if (ac1 != null) goto _L4; else goto _L3
_L3:
        Log.e("ObserverItem", "addObserverForKey ERROR, info == null");
_L9:
        return;
_L4:
        ac1.bT.add(obj);
        Y.put(s, ac1);
_L7:
        if (dM)
        {
            j(s);
            return;
        }
          goto _L5
_L2:
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(obj);
        Y.put(s, new ac(linkedlist));
        if (true) goto _L7; else goto _L6
_L6:
_L5:
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final void b(String s, String s1)
    {
        if (Y.containsKey(s))
        {
            for (Iterator iterator = ((ac)Y.get(s)).bT.iterator(); iterator.hasNext();)
            {
                Object obj = iterator.next();
                if (obj instanceof FlurryWalletHandler)
                {
                    obj = (FlurryWalletHandler)obj;
                    FlurryWalletInfo flurrywalletinfo = new FlurryWalletInfo();
                    flurrywalletinfo.iv = s;
                    flurrywalletinfo.iw = Float.parseFloat(s1);
                    ((FlurryWalletHandler) (obj)).onValueUpdated(flurrywalletinfo);
                } else
                if (obj instanceof AppCloudValueUpdateHandler)
                {
                    ((AppCloudValueUpdateHandler)obj).onValueUpdated(s);
                } else
                {
                    Log.e("ObserverItem", "CALLBACK ERROR!");
                }
            }

        }
    }

    public final boolean isAutoSyncEnabled()
    {
        return dM;
    }

    protected final void k(String s)
    {
        Object obj = (ac)Y.get(s);
        if (obj == null)
        {
            Log.e("ObserverItem", "addObserverForKey ERROR, info == null");
            return;
        }
        obj.G = ((ac) (obj)).G + 1;
        long l = a(((ac) (obj)).G);
        Y.put(s, obj);
        if (TextUtils.isEmpty(mCollectionName))
        {
            obj = new AppCloudUser();
            ((AppCloudUser) (obj)).setId(mId);
            try
            {
                ((AppCloudUser) (obj)).getObjectOrUser(new bf(this, s, l));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
        obj = AppCloudObject.create(mCollectionName);
        ((AppCloudObject) (obj)).setId(mId);
        try
        {
            ((AppCloudObject) (obj)).getObjectOrUser(new bd(this, s, l));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected final boolean removeObserverForKey(String s)
    {
        if (!Y.containsKey(s))
        {
            return false;
        } else
        {
            i(s);
            Y.remove(s);
            return true;
        }
    }

    public final int size()
    {
        return Y.size();
    }

    final void start()
    {
        if (dM)
        {
            an();
        }
    }

    final void stop()
    {
        ao();
    }
}
