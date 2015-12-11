// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.a.a.a.a;
import com.smule.android.network.core.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.smule.android.d:
//            s, r, q, u, 
//            i, p, m, n, 
//            o, k, l, e, 
//            t

public class j
{

    boolean a;
    String b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    String h;
    Context i;
    a j;
    ServiceConnection k;
    int l;
    String m;
    String n;
    m o;

    public j(Context context, String s1)
    {
        a = false;
        b = "IabHelper";
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = "";
        n = null;
        i = context.getApplicationContext();
        n = s1;
        c("IAB helper created.");
    }

    public static String a(int i1)
    {
        String as[] = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String as1[] = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i1 <= -1000)
        {
            int j1 = -1000 - i1;
            if (j1 >= 0 && j1 < as1.length)
            {
                return as1[j1];
            } else
            {
                return (new StringBuilder()).append(String.valueOf(i1)).append(":Unknown IAB Helper Error").toString();
            }
        }
        if (i1 < 0 || i1 >= as.length)
        {
            return (new StringBuilder()).append(String.valueOf(i1)).append(":Unknown").toString();
        } else
        {
            return as[i1];
        }
    }

    private void d()
    {
        if (d)
        {
            throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
        } else
        {
            return;
        }
    }

    int a(Intent intent)
    {
        intent = ((Intent) (intent.getExtras().get("RESPONSE_CODE")));
        if (intent == null)
        {
            d("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (intent instanceof Integer)
        {
            return ((Integer)intent).intValue();
        }
        if (intent instanceof Long)
        {
            return (int)((Long)intent).longValue();
        } else
        {
            d("Unexpected type for intent response code.");
            d(intent.getClass().getName());
            throw new RuntimeException((new StringBuilder()).append("Unexpected type for intent response code: ").append(intent.getClass().getName()).toString());
        }
    }

    int a(Bundle bundle)
    {
        bundle = ((Bundle) (bundle.get("RESPONSE_CODE")));
        if (bundle == null)
        {
            c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (bundle instanceof Integer)
        {
            return ((Integer)bundle).intValue();
        }
        if (bundle instanceof Long)
        {
            return (int)((Long)bundle).longValue();
        } else
        {
            d("Unexpected type for bundle response code.");
            d(bundle.getClass().getName());
            throw new RuntimeException((new StringBuilder()).append("Unexpected type for bundle response code: ").append(bundle.getClass().getName()).toString());
        }
    }

    int a(q q1, String s1)
    {
_L2:
        boolean flag;
        do
        {
            c((new StringBuilder()).append("Calling getPurchases with continuation token: ").append(((String) (obj))).toString());
            obj = j.a(3, i.getPackageName(), s1, ((String) (obj)));
            int i1 = a(((Bundle) (obj)));
            c((new StringBuilder()).append("Owned items response: ").append(String.valueOf(i1)).toString());
            if (i1 != 0)
            {
                c((new StringBuilder()).append("getPurchases() failed: ").append(a(i1)).toString());
                return i1;
            }
            if (!((Bundle) (obj)).containsKey("INAPP_PURCHASE_ITEM_LIST") || !((Bundle) (obj)).containsKey("INAPP_PURCHASE_DATA_LIST") || !((Bundle) (obj)).containsKey("INAPP_DATA_SIGNATURE_LIST"))
            {
                d("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
            ArrayList arraylist = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList arraylist1 = ((Bundle) (obj)).getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList arraylist2 = ((Bundle) (obj)).getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            i1 = 0;
            while (i1 < arraylist1.size()) 
            {
                String s2 = (String)arraylist1.get(i1);
                Object obj1 = (String)arraylist2.get(i1);
                String s3 = (String)arraylist.get(i1);
                if (com.smule.android.d.s.a(n, s2, ((String) (obj1))))
                {
                    c((new StringBuilder()).append("Sku is owned: ").append(s3).toString());
                    obj1 = new r(s1, s2, ((String) (obj1)));
                    if (TextUtils.isEmpty(((r) (obj1)).g()))
                    {
                        e("BUG: empty/null token!");
                        c((new StringBuilder()).append("Purchase data: ").append(s2).toString());
                    }
                    q1.a(((r) (obj1)));
                } else
                {
                    e("Purchase signature verification **FAILED**. Not adding item.");
                    c((new StringBuilder()).append("   Purchase data: ").append(s2).toString());
                    c((new StringBuilder()).append("   Signature: ").append(((String) (obj1))).toString());
                    flag = true;
                }
                i1++;
            }
            obj = ((Bundle) (obj)).getString("INAPP_CONTINUATION_TOKEN");
            c((new StringBuilder()).append("Continuation token: ").append(((String) (obj))).toString());
        } while (!TextUtils.isEmpty(((CharSequence) (obj))));
        char c1 = flag1;
        if (flag)
        {
            c1 = '\uFC15';
        }
        return c1;
        boolean flag1 = false;
        c((new StringBuilder()).append("Querying owned items, item type: ").append(s1).toString());
        c((new StringBuilder()).append("Package name: ").append(i.getPackageName()).toString());
        Object obj = null;
        if (j == null)
        {
            return -1003;
        }
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    int a(String s1, q q1, List list)
    {
        c("Querying SKU details.");
        Object obj = new ArrayList();
        ((ArrayList) (obj)).addAll(q1.b(s1));
        if (list != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                String s2 = (String)list.next();
                if (!((ArrayList) (obj)).contains(s2))
                {
                    ((ArrayList) (obj)).add(s2);
                }
            } while (true);
        }
        if (((ArrayList) (obj)).size() == 0)
        {
            c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        list = new ArrayList();
        int k1 = ((ArrayList) (obj)).size() / 20;
        int l1 = ((ArrayList) (obj)).size() % 20;
        for (int i1 = 0; i1 < k1; i1++)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = ((ArrayList) (obj)).subList(i1 * 20, i1 * 20 + 20).iterator(); iterator.hasNext(); arraylist.add((String)iterator.next())) { }
            list.add(arraylist);
        }

        if (l1 != 0)
        {
            ArrayList arraylist1 = new ArrayList();
            for (obj = ((ArrayList) (obj)).subList(k1 * 20, k1 * 20 + l1).iterator(); ((Iterator) (obj)).hasNext(); arraylist1.add((String)((Iterator) (obj)).next())) { }
            list.add(arraylist1);
            for (list = list.iterator(); list.hasNext();)
            {
                Object obj1 = (ArrayList)list.next();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", ((ArrayList) (obj1)));
                obj1 = j.a(3, i.getPackageName(), s1, bundle);
                if (!((Bundle) (obj1)).containsKey("DETAILS_LIST"))
                {
                    int j1 = a(((Bundle) (obj1)));
                    if (j1 != 0)
                    {
                        c((new StringBuilder()).append("getSkuDetails() failed: ").append(a(j1)).toString());
                        return j1;
                    } else
                    {
                        d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        return -1002;
                    }
                }
                obj1 = ((Bundle) (obj1)).getStringArrayList("DETAILS_LIST").iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    u u1 = new u(s1, (String)((Iterator) (obj1)).next());
                    c((new StringBuilder()).append("Got sku details: ").append(u1).toString());
                    q1.a(u1);
                }
            }

        }
        return 0;
    }

    public q a(boolean flag, List list)
    {
        return a(flag, list, ((List) (null)));
    }

    public q a(boolean flag, List list, List list1)
    {
        d();
        a("queryInventory");
        int i1;
        try
        {
            list1 = new q();
            i1 = a(((q) (list1)), "inapp");
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new i(-1001, "Remote exception while refreshing inventory.", list);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new i(-1002, "Error parsing JSON response while refreshing inventory.", list);
        }
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        throw new i(i1, "Error refreshing inventory (querying owned items).");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        i1 = a("inapp", ((q) (list1)), list);
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        throw new i(i1, "Error refreshing inventory (querying prices of items).");
        int j1;
        if (!e)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        j1 = a(((q) (list1)), "subs");
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        throw new i(j1, "Error refreshing inventory (querying owned subscriptions).");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        j1 = a("subs", ((q) (list1)), list);
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        throw new i(j1, "Error refreshing inventory (querying prices of subscriptions).");
        return list1;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (!f) goto _L2; else goto _L1
_L1:
        c("Async operation in progress, will delay disposing");
        g = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        c("Disposing.");
        c = false;
        if (k != null)
        {
            c("Unbinding from service.");
            if (i != null)
            {
                i.unbindService(k);
            }
        }
        d = true;
        i = null;
        k = null;
        j = null;
        o = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void a(Activity activity, String s1, int i1, m m1)
    {
        a(activity, s1, i1, m1, "");
    }

    public void a(Activity activity, String s1, int i1, m m1, String s2)
    {
        a(activity, s1, "subs", i1, m1, s2);
    }

    public void a(Activity activity, String s1, String s2, int i1, m m1, String s3)
    {
        d();
        a("launchPurchaseFlow");
        b("launchPurchaseFlow");
        if (!s2.equals("subs") || e) goto _L2; else goto _L1
_L1:
        activity = new p(-1009, "Subscriptions are not available.");
        c();
        if (m1 != null)
        {
            m1.a(activity, null);
        }
_L4:
        return;
_L2:
        int j1;
        c((new StringBuilder()).append("Constructing buy intent for ").append(s1).append(", item type: ").append(s2).toString());
        s3 = j.a(3, i.getPackageName(), s1, s2, s3);
        j1 = a(((Bundle) (s3)));
        if (j1 == 0)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        d((new StringBuilder()).append("Unable to buy item, Error response: ").append(a(j1)).toString());
        c();
        activity = new p(j1, "Unable to buy item");
        if (m1 != null)
        {
            try
            {
                m1.a(activity, null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                d((new StringBuilder()).append("SendIntentException while launching purchase flow for sku ").append(s1).toString());
                activity.printStackTrace();
                c();
                activity = new p(-1004, "Failed to send intent.");
                if (m1 != null)
                {
                    m1.a(activity, null);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                d((new StringBuilder()).append("RemoteException while launching purchase flow for sku ").append(s1).toString());
                activity.printStackTrace();
                c();
                activity = new p(-1001, "Remote exception while starting purchase flow");
                if (m1 != null)
                {
                    m1.a(activity, null);
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        s3 = (PendingIntent)s3.getParcelable("BUY_INTENT");
        c((new StringBuilder()).append("Launching buy intent for ").append(s1).append(". Request code: ").append(i1).toString());
        l = i1;
        o = m1;
        m = s2;
        activity.startIntentSenderForResult(s3.getIntentSender(), i1, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(n n1)
    {
        Intent intent;
        d();
        if (c)
        {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        c("Starting in-app billing setup.");
        k = new ServiceConnection(n1) {

            final n a;
            final j b;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                if (!b.d) goto _L2; else goto _L1
_L1:
                return;
_L2:
                b.c("Billing service connected.");
                b.j = com.a.a.a.b.a(ibinder);
                componentname = b.i.getPackageName();
                int i1;
                b.c("Checking for in-app billing 3 support.");
                i1 = b.j.a(3, componentname, "inapp");
                if (i1 != 0)
                {
                    try
                    {
                        if (a != null)
                        {
                            a.a(new p(i1, "Error checking for billing v3 support."));
                        }
                        b.e = false;
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ComponentName componentname) { }
                    if (a != null)
                    {
                        a.a(new p(-1001, "RemoteException while setting up in-app billing."));
                    }
                    componentname.printStackTrace();
                    return;
                }
                b.c((new StringBuilder()).append("In-app billing version 3 supported for ").append(componentname).toString());
                i1 = b.j.a(3, componentname, "subs");
                if (i1 != 0)
                {
                    break MISSING_BLOCK_LABEL_240;
                }
                b.c("Subscriptions AVAILABLE.");
                b.e = true;
_L4:
                b.c = true;
                if (a == null) goto _L1; else goto _L3
_L3:
                a.a(new p(0, "Setup successful."));
                return;
                b.c((new StringBuilder()).append("Subscriptions NOT AVAILABLE. Response: ").append(i1).toString());
                  goto _L4
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                b.c("Billing service disconnected.");
            }

            
            {
                b = j.this;
                a = n1;
                super();
            }
        };
        intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (i != null) goto _L2; else goto _L1
_L1:
        c("mContext is NULL.");
_L8:
        List list = i.getPackageManager().queryIntentServices(intent, 0);
        if (list == null || list.isEmpty()) goto _L4; else goto _L3
_L3:
        i.bindService(intent, k, 1);
_L6:
        return;
_L2:
        if (i.getPackageManager() == null)
        {
            c("mContext.getPackageManager() is NULL.");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (n1 == null) goto _L6; else goto _L5
_L5:
        n1.a(new p(3, "Billing service unavailable on device."));
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(o o1)
    {
        a(true, ((List) (null)), o1);
    }

    void a(r r1)
    {
        Object obj;
        String s1;
        d();
        a("consume");
        if (!r1.a.equals("inapp"))
        {
            throw new i(-1010, (new StringBuilder()).append("Items of type '").append(r1.a).append("' can't be consumed.").toString());
        }
        try
        {
            obj = r1.g();
            s1 = r1.c();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new i(-1001, (new StringBuilder()).append("Remote exception while consuming. PurchaseInfo: ").append(r1).toString(), ((Exception) (obj)));
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (!((String) (obj)).equals(""))
        {
            break MISSING_BLOCK_LABEL_191;
        }
        d((new StringBuilder()).append("Can't consume ").append(s1).append(". No token.").toString());
        throw new i(-1007, (new StringBuilder()).append("PurchaseInfo is missing token for sku: ").append(s1).append(" ").append(r1).toString());
        int i1;
        c((new StringBuilder()).append("Consuming sku: ").append(s1).append(", token: ").append(((String) (obj))).toString());
        i1 = j.b(3, i.getPackageName(), ((String) (obj)));
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        c((new StringBuilder()).append("Successfully consumed sku: ").append(s1).toString());
        return;
        c((new StringBuilder()).append("Error consuming consuming sku ").append(s1).append(". ").append(a(i1)).toString());
        throw new i(i1, (new StringBuilder()).append("Error consuming sku ").append(s1).toString());
    }

    public void a(r r1, k k1)
    {
        d();
        a("consume");
        ArrayList arraylist = new ArrayList();
        arraylist.add(r1);
        a(((List) (arraylist)), k1, ((l) (null)));
    }

    void a(String s1)
    {
        if (!c)
        {
            d((new StringBuilder()).append("Illegal state for operation (").append(s1).append("): IAB helper is not set up.").toString());
            throw new IllegalStateException((new StringBuilder()).append("IAB helper is not set up. Can't perform operation: ").append(s1).toString());
        } else
        {
            return;
        }
    }

    void a(List list, k k1, l l1)
    {
        Handler handler = new Handler();
        b("consume");
        (new Thread(new Runnable(list, k1, handler, l1) {

            final List a;
            final k b;
            final Handler c;
            final l d;
            final j e;

            public void run()
            {
                ArrayList arraylist = new ArrayList();
                for (Iterator iterator = a.iterator(); iterator.hasNext();)
                {
                    r r1 = (r)iterator.next();
                    try
                    {
                        e.a(r1);
                        arraylist.add(new p(0, (new StringBuilder()).append("Successful consume of sku ").append(r1.c()).toString()));
                    }
                    catch (i i1)
                    {
                        arraylist.add(i1.a());
                    }
                }

                e.c();
                if (!e.d && b != null)
                {
                    c.post(new Runnable(this, arraylist) {

                        final List a;
                        final _cls4 b;

                        public void run()
                        {
                            b.b.a((r)b.a.get(0), (p)a.get(0));
                        }

            
            {
                b = _pcls4;
                a = list;
                super();
            }
                    });
                }
                if (!e.d && d != null)
                {
                    c.post(new Runnable(this, arraylist) {

                        final List a;
                        final _cls4 b;

                        public void run()
                        {
                            b.d.a(b.a, a);
                        }

            
            {
                b = _pcls4;
                a = list;
                super();
            }
                    });
                }
            }

            
            {
                e = j.this;
                a = list;
                b = k1;
                c = handler;
                d = l1;
                super();
            }
        })).start();
    }

    public void a(boolean flag, String s1)
    {
        d();
        a = flag;
        b = s1;
    }

    public void a(boolean flag, List list, o o1)
    {
        Handler handler = new Handler();
        d();
        a("queryInventory");
        b("refresh inventory");
        (new Thread(new Runnable(flag, list, o1, handler) {

            final boolean a;
            final List b;
            final o c;
            final Handler d;
            final j e;

            public void run()
            {
                q q1;
                p p1;
                p1 = new p(0, "Inventory refresh successful.");
                q1 = null;
                q q2 = e.a(a, b);
                q1 = q2;
_L2:
                e.c();
                if (!e.d && c != null)
                {
                    d.post(new Runnable(this, p1, q1) {

                        final p a;
                        final q b;
                        final _cls3 c;

                        public void run()
                        {
                            c.c.a(a, b);
                        }

            
            {
                c = _pcls3;
                a = p1;
                b = q1;
                super();
            }
                    });
                }
                return;
                i i1;
                i1;
                i1 = i1.a();
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                e = j.this;
                a = flag;
                b = list;
                c = o1;
                d = handler;
                super();
            }
        })).start();
    }

    public boolean a(int i1, int j1, Intent intent)
    {
        Object obj;
        String s1;
        if (i1 != l)
        {
            return false;
        }
        d();
        a("handleActivityResult");
        c();
        if (intent == null)
        {
            d("Null data in IAB activity result.");
            intent = new p(-1002, "Null data in IAB result");
            if (o != null)
            {
                o.a(intent, null);
            }
            return true;
        }
        i1 = a(intent);
        obj = intent.getStringExtra("INAPP_PURCHASE_DATA");
        s1 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (j1 != -1 || i1 != 0) goto _L2; else goto _L1
_L1:
        c("Successful resultcode from purchase activity.");
        c((new StringBuilder()).append("Purchase data: ").append(((String) (obj))).toString());
        c((new StringBuilder()).append("Data signature: ").append(s1).toString());
        c((new StringBuilder()).append("Extras: ").append(intent.getExtras()).toString());
        c((new StringBuilder()).append("Expected item type: ").append(m).toString());
        if (obj == null || s1 == null)
        {
            d("BUG: either purchaseData or dataSignature is null.");
            c((new StringBuilder()).append("Extras: ").append(intent.getExtras().toString()).toString());
            intent = new p(-1008, "IAB returned null purchaseData or dataSignature");
            if (o != null)
            {
                o.a(intent, null);
            }
            return true;
        }
        String s2;
        intent = new r(m, ((String) (obj)), s1);
        s2 = intent.c();
        if (com.smule.android.d.s.a(n, ((String) (obj)), s1)) goto _L4; else goto _L3
_L3:
        d((new StringBuilder()).append("Purchase signature verification FAILED for sku ").append(s2).toString());
        obj = new p(-1003, (new StringBuilder()).append("Signature verification failed for sku ").append(s2).toString());
        if (o != null)
        {
            o.a(((p) (obj)), intent);
        }
          goto _L5
_L4:
        try
        {
            com.smule.android.network.core.b.a(new Runnable(intent, ((String) (obj)), s1) {

                final r a;
                final String b;
                final String c;
                final j d;

                public void run()
                {
                    com.smule.android.d.t.a(com.smule.android.d.e.a(a.e()), a.c(), a.b(), a.d(), b, c);
                }

            
            {
                d = j.this;
                a = r1;
                b = s1;
                c = s2;
                super();
            }
            });
            c("Purchase signature successfully verified.");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            d("Failed to parse purchase data.");
            intent.printStackTrace();
            intent = new p(-1002, "Failed to parse purchase data.");
            if (o != null)
            {
                o.a(intent, null);
            }
            return true;
        }
        if (o != null)
        {
            o.a(new p(0, "Success"), intent);
        }
_L6:
        return true;
_L2:
        if (j1 == -1)
        {
            c((new StringBuilder()).append("Result code was OK but in-app billing response was not OK: ").append(a(i1)).toString());
            if (o != null)
            {
                intent = new p(i1, "Problem purchashing item.");
                o.a(intent, null);
            }
        } else
        if (j1 == 0)
        {
            c((new StringBuilder()).append("Purchase canceled - Response: ").append(a(i1)).toString());
            intent = new p(-1005, "User canceled.");
            if (o != null)
            {
                o.a(intent, null);
            }
        } else
        {
            d((new StringBuilder()).append("Purchase failed. Result code: ").append(Integer.toString(j1)).append(". Response: ").append(a(i1)).toString());
            intent = new p(-1006, "Unknown purchase response.");
            if (o != null)
            {
                o.a(intent, null);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        return true;
    }

    void b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (f)
        {
            throw new IllegalStateException((new StringBuilder()).append("Can't start async operation (").append(s1).append(") because another async operation(").append(h).append(") is in progress.").toString());
        }
        break MISSING_BLOCK_LABEL_61;
        s1;
        this;
        JVM INSTR monitorexit ;
        throw s1;
        h = s1;
        f = true;
        c((new StringBuilder()).append("Starting async operation: ").append(s1).toString());
        this;
        JVM INSTR monitorexit ;
    }

    public boolean b()
    {
        d();
        return e;
    }

    void c()
    {
        this;
        JVM INSTR monitorenter ;
        c((new StringBuilder()).append("Ending async operation: ").append(h).toString());
        h = "";
        f = false;
        if (g)
        {
            g = false;
            a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void c(String s1)
    {
        if (a)
        {
            Log.d(b, s1);
        }
    }

    void d(String s1)
    {
        Log.e(b, (new StringBuilder()).append("In-app billing error: ").append(s1).toString());
    }

    void e(String s1)
    {
        Log.w(b, (new StringBuilder()).append("In-app billing warning: ").append(s1).toString());
    }
}
