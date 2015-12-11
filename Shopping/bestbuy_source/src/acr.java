// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class acr extends acl
{

    private static ov e;
    private static CountDownLatch f = new CountDownLatch(1);
    private static boolean g;

    protected acr(Context context, aek aek1, aem aem)
    {
        super(context, aek1, aem);
    }

    public static acr a(String s, Context context)
    {
        xt xt1;
        xt1 = new xt();
        a(s, context, ((aek) (xt1)));
        acr;
        JVM INSTR monitorenter ;
        if (e == null)
        {
            e = new ov(context);
            (new AsyncTask() {

                protected transient Void a(Void avoid[])
                {
                    try
                    {
                        acr.f().a();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        acr.a(true);
                        acr.a(null);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        acr.a(null);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        acr.a(null);
                    }
                    acr.g().countDown();
                    return null;
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            }).execute(new Void[0]);
        }
        acr;
        JVM INSTR monitorexit ;
        return new acr(context, xt1, new afy(239));
        s;
        acr;
        JVM INSTR monitorexit ;
        throw s;
    }

    static ov a(ov ov1)
    {
        e = ov1;
        return ov1;
    }

    static boolean a(boolean flag)
    {
        g = flag;
        return flag;
    }

    static ov f()
    {
        return e;
    }

    static CountDownLatch g()
    {
        return f;
    }

    protected void b(Context context)
    {
        super.b(context);
        if (g)
        {
            a(24, d(context));
            return;
        }
        context = e();
        long l;
        if (context.b())
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        a(28, l);
        context = context.a();
        if (context != null)
        {
            try
            {
                a(26, 5L);
                a(24, context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        return;
    }

    acs e()
    {
        int i = 0;
        acr;
        JVM INSTR monitorenter ;
        acs acs1;
        if (f.await(2L, TimeUnit.SECONDS))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        acs1 = new acs(this, null, false);
        acr;
        JVM INSTR monitorexit ;
        return acs1;
        Object obj;
        obj;
        obj = new acs(this, null, false);
        acr;
        JVM INSTR monitorexit ;
        return ((acs) (obj));
        obj;
        acr;
        JVM INSTR monitorexit ;
        throw obj;
        if (e != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = new acs(this, null, false);
        acr;
        JVM INSTR monitorexit ;
        return ((acs) (obj));
        ow ow1 = e.b();
        acr;
        JVM INSTR monitorexit ;
        String s;
label0:
        {
            s = ow1.a();
            if (s == null || !s.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"))
            {
                break label0;
            }
            byte abyte0[] = new byte[16];
            int j = 0;
            int k;
            for (; i < s.length(); i = k + 2)
            {
label1:
                {
                    if (i != 8 && i != 13 && i != 18)
                    {
                        k = i;
                        if (i != 23)
                        {
                            break label1;
                        }
                    }
                    k = i + 1;
                }
                abyte0[j] = (byte)((Character.digit(s.charAt(k), 16) << 4) + Character.digit(s.charAt(k + 1), 16));
                j++;
            }

            s = c.a(abyte0, true);
        }
        return new acs(this, s, ow1.b());
    }

}
