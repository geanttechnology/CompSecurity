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
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, m, a, j, 
//            s

class n extends j
{

    private int a;

    private n()
    {
        a = 2;
    }

    n(NetworkManager._cls1 _pcls1)
    {
        this();
    }

    private void a(int i, String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "Unknow reason";
        }
        if (e.a)
        {
            Globals.b((new StringBuilder()).append("Network Fail: ").append(i).append(" ").append(s2).toString());
        }
        b(i);
        e.e(new Object[] {
            (new StringBuilder()).append("Network Fail: ").append(i).append(" ").append(s2).toString()
        });
    }

    protected volatile Object a(Object obj)
    {
        return a((u)obj);
    }

    protected String a(u u1)
    {
        if (!c()) goto _L2; else goto _L1
_L1:
        u1 = u.i;
        u1.a = ((x) (u1)).a - 1L;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
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
        int l;
        int i1;
        long l1;
        long l2;
        long l3;
        long l4;
        obj5 = null;
        s1 = null;
        obj6 = null;
        i1 = -1;
        l4 = -1L;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        Object obj7 = u1.a();
        if (obj7 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        Object obj3 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
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
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        Object obj4 = new StringBuilder();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = (HttpURLConnection)(new URL(((String) (obj7)))).openConnection();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setConnectTimeout(30000);
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setReadTimeout(30000);
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        System.setProperty("http.maxConnections", "10");
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        if (!c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
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
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setRequestMethod("POST");
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setRequestProperty("User-Agent", Key.Init.a.k);
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj7 = new com.cyberlink.beautycircle.model.network.j(((String) (obj7)));
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        if (!u1.h.equals("application/x-www-form-urlencoded")) goto _L7; else goto _L6
_L6:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setDoOutput(true);
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        Object obj8 = u1.b();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        Object obj9 = new DataOutputStream(((HttpURLConnection) (obj3)).getOutputStream());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((DataOutputStream) (obj9)).writeBytes(((String) (obj8)));
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((DataOutputStream) (obj9)).flush();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((DataOutputStream) (obj9)).close();
_L9:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        if (!e.a)
        {
            break MISSING_BLOCK_LABEL_1318;
        }
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        e.b(new Object[] {
            (new StringBuilder()).append("[WebRequest] POST URL:").append(u1.c()).toString()
        });
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        i1 = ((HttpURLConnection) (obj3)).getResponseCode();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        l4 = ((com.cyberlink.beautycircle.model.network.j) (obj7)).a();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        if (!c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3.a = ((x) (obj3)).a - 1L;
        obj = null;
        if (e.a || i1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i1, l4));
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
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        e.e(new Object[] {
            (new StringBuilder()).append("UnknownHostException :").append(((UnknownHostException) (obj3)).getMessage()).toString()
        });
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
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
        continue; /* Loop/switch isn't completed */
_L7:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj9 = (new StringBuilder()).append("====").append(Long.toHexString(System.currentTimeMillis())).append("====").toString();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setRequestProperty("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(((String) (obj9))).toString());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((HttpURLConnection) (obj3)).setDoOutput(true);
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj8 = new DataOutputStream(((HttpURLConnection) (obj3)).getOutputStream());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        u1.a(new PrintWriter(((java.io.OutputStream) (obj8))), ((java.io.OutputStream) (obj8)), ((String) (obj9)));
        if (true) goto _L9; else goto _L8
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
        int j1;
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
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        e.e(new Object[] {
            (new StringBuilder()).append("UnknownHostException :").append(((UnknownHostException) (obj3)).getMessage()).toString()
        });
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(NetworkManager.NetworkErrorCode.b.a(), NetworkManager.NetworkErrorCode.b.toString());
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
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
        continue; /* Loop/switch isn't completed */
_L8:
        if (i1 < 400 || i1 >= 600)
        {
            break MISSING_BLOCK_LABEL_3815;
        }
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        e.d(new Object[] {
            (new StringBuilder()).append("[WebRequest] Post Fail:").append(i1).toString()
        });
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj4 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj4.a = ((x) (obj4)).a - 1L;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj7 = ((HttpURLConnection) (obj3)).getResponseMessage();
        if (i1 != 420) goto _L11; else goto _L10
_L10:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        j1 = a - 1;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a = j1;
        if (j1 < 0)
        {
            break MISSING_BLOCK_LABEL_2980;
        }
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        Thread.sleep(3000L);
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = a(u1);
        obj = obj3;
        if (e.a || i1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i1, l4));
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
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        AccountManager.a(false, true, Globals.c()).d();
_L16:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        if (Globals.d == null) goto _L13; else goto _L12
_L12:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = Globals.d.getResources().getString(m.bc_dialog_title_error);
_L17:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        if (Globals.d == null) goto _L15; else goto _L14
_L14:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj4 = (new StringBuilder()).append(Globals.d.getResources().getString(m.bc_dialog_message_token_expired)).append(s.a(i1)).toString();
_L18:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj4 = (new StringBuilder()).append(((String) (obj4))).append(", (retry: 2)").toString();
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        DialogUtils.a(Globals.d, ((String) (obj3)), ((String) (obj4)), new Runnable(((String) (obj3))) {

            final String a;
            final n b;

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
                b = n.this;
                a = s1;
                super();
            }
        });
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3;
        JVM INSTR monitorenter ;
        obj3.wait();
        obj3;
        JVM INSTR monitorexit ;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(i1, ((String) (obj7)));
_L19:
        obj = null;
        if (e.a || i1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i1, l4));
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
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((CancellationException) (obj3)).printStackTrace();
          goto _L16
        obj2;
        i = l;
        l1 = l3;
        obj = obj1;
        ((InterruptedException) (obj2)).printStackTrace();
        i = l;
        l1 = l3;
        obj = obj1;
        a(true);
        if (e.a || l != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), l, l3));
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
        obj3;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        ((ExecutionException) (obj3)).printStackTrace();
          goto _L16
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
_L13:
        obj3 = "";
          goto _L17
_L15:
        obj4 = "";
          goto _L18
        obj4;
        obj3;
        JVM INSTR monitorexit ;
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        throw obj4;
_L11:
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        a(i1, ((String) (obj7)));
          goto _L19
        k = i1;
        l2 = l4;
        obj2 = obj6;
        l = i1;
        l3 = l4;
        obj1 = obj5;
        i = i1;
        l1 = l4;
        obj = s1;
        obj3 = ((HttpURLConnection) (obj3)).getInputStream();
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        obj5 = new BufferedReader(new InputStreamReader(((InputStream) (obj3)), "utf-8"));
_L21:
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        s1 = ((BufferedReader) (obj5)).readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        if (c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        ((StringBuilder) (obj4)).append(s1);
        if (true) goto _L21; else goto _L20
_L20:
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        ((com.cyberlink.beautycircle.model.network.j) (obj7)).b();
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        ((BufferedReader) (obj5)).close();
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        if (!c())
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        a(com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.a(), com.cyberlink.beautycircle.model.network.NetworkManager.NetworkErrorCode.e.toString());
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        obj4 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        obj4.a = ((x) (obj4)).a - 1L;
        obj = null;
        if (e.a || i1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i1, l4));
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
        if (true) goto _L4; else goto _L22
_L22:
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        obj5 = u.i;
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        obj5.a = ((x) (obj5)).a - 1L;
        k = i1;
        l2 = l4;
        obj2 = obj3;
        l = i1;
        l3 = l4;
        obj1 = obj3;
        i = i1;
        l1 = l4;
        obj = obj3;
        obj4 = ((StringBuilder) (obj4)).toString();
        obj = obj4;
        if (e.a || i1 != 200)
        {
            NetworkManager.f().add(new com.cyberlink.beautycircle.model.network.m(Uri.parse(u1.c()), i1, l4));
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
                return ((String) (obj));
            }
            return ((String) (obj));
        }
        if (true) goto _L4; else goto _L23
_L23:
    }
}
