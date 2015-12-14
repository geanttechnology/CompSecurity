// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.content.res.Resources;
import android.net.Uri;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import com.perfectcorp.utility.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, m, a, j, 
//            s

class l extends j
{

    private int a;

    private l()
    {
        a = 2;
    }

    l(NetworkManager._cls1 _pcls1)
    {
        this();
    }

    private void a(int i, String s1)
    {
        if (e.a)
        {
            Globals.b((new StringBuilder()).append("Network Fail: ").append(i).append(" ").append(s1).toString());
        }
        e.e(new Object[] {
            Integer.valueOf(i), " ", s1
        });
        b(i);
    }

    protected volatile Object a(Object obj)
    {
        return a((u)obj);
    }

    protected String a(u u1)
    {
        if (!c()) goto _L2; else goto _L1
_L1:
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        u1 = u.i;
        u1.a = ((x) (u1)).a - 1L;
        u1 = null;
_L4:
        return u1;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj5;
        String s1;
        Object obj6;
        int i;
        int k;
        int i1;
        int j1;
        long l1;
        long l2;
        long l3;
        long l4;
        obj5 = null;
        s1 = null;
        obj6 = null;
        j1 = -1;
        l4 = -1L;
        if (u1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        Object obj3 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3.a = ((x) (obj3)).a - 1L;
        obj = null;
        if (e.a);
        NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), -1, -1L));
        u1 = ((u) (obj));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        Object obj7 = u1.c();
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        Object obj4 = new StringBuilder();
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = new URL(((String) (obj7)));
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        e.b(new Object[] {
            (new StringBuilder()).append("[WebRequest] GET URL:").append(((URL) (obj3)).toString()).toString()
        });
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = (HttpURLConnection)((URL) (obj3)).openConnection();
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        if (!c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3.a = ((x) (obj3)).a - 1L;
        obj = null;
        if (e.a);
        NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), -1, -1L));
        u1 = ((u) (obj));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
            return null;
        }
        if (true) goto _L4; else goto _L5
_L5:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setRequestMethod("GET");
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setRequestProperty("User-Agent", Key.Init.a.k);
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj7 = new com.cyberlink.beautycircle.model.network.j(((String) (obj7)));
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        j1 = ((HttpURLConnection) (obj3)).getResponseCode();
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        l4 = ((com.cyberlink.beautycircle.model.network.j) (obj7)).a();
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        if (!c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3.a = ((x) (obj3)).a - 1L;
        obj = null;
        if (e.a || j1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), j1, l4));
        }
        u1 = ((u) (obj));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
            return null;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (j1 < 400 || j1 >= 600)
        {
            break MISSING_BLOCK_LABEL_2562;
        }
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        e.b(new Object[] {
            (new StringBuilder()).append("[WebRequest] GET fail:").append(j1).toString()
        });
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj4 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj4.a = ((x) (obj4)).a - 1L;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj7 = ((HttpURLConnection) (obj3)).getResponseMessage();
        if (j1 != 420) goto _L8; else goto _L7
_L7:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        int k1 = a - 1;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        a = k1;
        if (k1 < 0)
        {
            break MISSING_BLOCK_LABEL_1620;
        }
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        Thread.sleep(3000L);
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = a(u1);
        obj = obj3;
        if (e.a || j1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), j1, l4));
        }
        u1 = ((u) (obj));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
            return ((String) (obj));
        }
        continue; /* Loop/switch isn't completed */
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        AccountManager.a(false, true, Globals.c()).d();
_L13:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        if (Globals.d == null) goto _L10; else goto _L9
_L9:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = Globals.d.getResources().getString(m.bc_dialog_title_error);
_L14:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        if (Globals.d == null) goto _L12; else goto _L11
_L11:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj4 = (new StringBuilder()).append(Globals.d.getResources().getString(m.bc_dialog_message_token_expired)).append(s.a(j1)).toString();
_L15:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj4 = (new StringBuilder()).append(((String) (obj4))).append(", (retry: 2)").toString();
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        DialogUtils.a(Globals.d, ((String) (obj3)), ((String) (obj4)), new Runnable(((String) (obj7))) {

            final String a;
            final l b;

            public void run()
            {
                synchronized (a)
                {
                    a.notify();
                }
                return;
                exception;
                s2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = l.this;
                a = s1;
                super();
            }
        });
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj7;
        JVM INSTR monitorenter ;
        obj7.wait();
        obj7;
        JVM INSTR monitorexit ;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        a(j1, ((String) (obj7)));
_L16:
        obj = null;
        if (e.a || j1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), j1, l4));
        }
        u1 = ((u) (obj));
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
            return null;
        }
        continue; /* Loop/switch isn't completed */
        obj3;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        ((CancellationException) (obj3)).printStackTrace();
          goto _L13
        obj1;
        i = k;
        l1 = l2;
        obj = obj2;
        ((IOException) (obj1)).printStackTrace();
        i = k;
        l1 = l2;
        obj = obj2;
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        if (e.a || k != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), k, l2));
        }
        if (obj2 != null)
        {
            try
            {
                ((InputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        u1 = u.i;
        u1.a = ((x) (u1)).a - 1L;
        return null;
        obj3;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        ((ExecutionException) (obj3)).printStackTrace();
          goto _L13
        obj2;
        i = i1;
        l1 = l3;
        obj = obj1;
        ((InterruptedException) (obj2)).printStackTrace();
        i = i1;
        l1 = l3;
        obj = obj1;
        a(true);
        if (e.a || i1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i1, l3));
        }
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_2258;
_L10:
        obj3 = "";
          goto _L14
_L12:
        obj4 = "";
          goto _L15
        obj3;
        obj7;
        JVM INSTR monitorexit ;
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        throw obj3;
        obj1;
        if (e.a || i != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i, l1));
        }
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
            }
        }
        throw obj1;
_L8:
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        a(j1, ((String) (obj7)));
          goto _L16
        k = j1;
        l2 = l4;
        obj2 = obj6;
        i1 = j1;
        l3 = l4;
        obj1 = obj5;
        i = j1;
        l1 = l4;
        obj = s1;
        obj3 = ((HttpURLConnection) (obj3)).getInputStream();
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj5 = new BufferedReader(new InputStreamReader(((InputStream) (obj3)), "utf-8"));
_L18:
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        s1 = ((BufferedReader) (obj5)).readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        if (c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        ((StringBuilder) (obj4)).append(s1);
        if (true) goto _L18; else goto _L17
_L17:
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        ((com.cyberlink.beautycircle.model.network.j) (obj7)).b();
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        ((BufferedReader) (obj5)).close();
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        if (!c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj4 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj4.a = ((x) (obj4)).a - 1L;
        obj = null;
        if (e.a || j1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), j1, l4));
        }
        u1 = ((u) (obj));
        if (obj3 != null)
        {
            try
            {
                ((InputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
                return null;
            }
            return null;
        }
        if (true) goto _L4; else goto _L19
_L19:
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj4 = ((StringBuilder) (obj4)).toString();
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        if (((String) (obj4)).length() != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        a(NetworkManager.NetworkErrorCode.d.a(), NetworkManager.NetworkErrorCode.d.toString());
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj4 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj4.a = ((x) (obj4)).a - 1L;
        obj = null;
        if (e.a || j1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), j1, l4));
        }
        u1 = ((u) (obj));
        if (obj3 != null)
        {
            try
            {
                ((InputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
                return null;
            }
            return null;
        }
        if (true) goto _L4; else goto _L20
_L20:
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj5 = u.i;
        k = j1;
        l2 = l4;
        obj2 = obj3;
        i1 = j1;
        l3 = l4;
        obj1 = obj3;
        i = j1;
        l1 = l4;
        obj = obj3;
        obj5.a = ((x) (obj5)).a - 1L;
        if (e.a || j1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), j1, l4));
        }
        u1 = ((u) (obj4));
        if (obj3 != null)
        {
            try
            {
                ((InputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (u u1)
            {
                u1.printStackTrace();
                return ((String) (obj4));
            }
            return ((String) (obj4));
        }
        if (true) goto _L4; else goto _L21
_L21:
    }
}
