// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class ack
    implements abh
{

    protected MotionEvent a;
    protected DisplayMetrics b;
    protected aek c;
    private aem d;

    protected ack(Context context, aek aek1, aem aem1)
    {
        c = aek1;
        d = aem1;
        try
        {
            b = context.getResources().getDisplayMetrics();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            b = new DisplayMetrics();
        }
        b.density = 1.0F;
    }

    private String a(Context context, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        c(context);
_L1:
        context = b();
        this;
        JVM INSTR monitorexit ;
        if (context.length != 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        context = Integer.toString(5);
        return context;
        b(context);
          goto _L1
        context;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw context;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return Integer.toString(7);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return Integer.toString(7);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return Integer.toString(3);
        }
        context = a(((byte []) (context)), s);
        return context;
    }

    private void a()
    {
        d.a();
    }

    private byte[] b()
    {
        return d.b();
    }

    public String a(Context context)
    {
        return a(context, ((String) (null)), false);
    }

    public String a(Context context, String s)
    {
        return a(context, s, true);
    }

    String a(byte abyte0[], String s)
    {
        byte abyte1[] = abyte0;
        if (abyte0.length > 239)
        {
            a();
            a(20, 1L);
            abyte1 = b();
        }
        if (abyte1.length < 239)
        {
            abyte0 = new byte[239 - abyte1.length];
            (new SecureRandom()).nextBytes(abyte0);
            abyte0 = ByteBuffer.allocate(240).put((byte)abyte1.length).put(abyte1).put(abyte0).array();
        } else
        {
            abyte0 = ByteBuffer.allocate(240).put((byte)abyte1.length).put(abyte1).array();
        }
        abyte1 = MessageDigest.getInstance("MD5");
        abyte1.update(abyte0);
        abyte1 = abyte1.digest();
        abyte0 = ByteBuffer.allocate(256).put(abyte1).put(abyte0).array();
        abyte1 = new byte[256];
        (new zi()).a(abyte0, abyte1);
        if (s != null && s.length() > 0)
        {
            a(s, abyte1);
        }
        return c.a(abyte1, true);
    }

    public void a(int i, int j, int k)
    {
        if (a != null)
        {
            a.recycle();
        }
        a = MotionEvent.obtain(0L, k, 1, (float)i * b.density, (float)j * b.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
    }

    protected void a(int i, long l)
    {
        d.a(i, l);
    }

    protected void a(int i, String s)
    {
        d.a(i, s);
    }

    public void a(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            if (a != null)
            {
                a.recycle();
            }
            a = MotionEvent.obtain(motionevent);
        }
    }

    void a(String s, byte abyte0[])
    {
        String s1 = s;
        if (s.length() > 32)
        {
            s1 = s.substring(0, 32);
        }
        (new agq(s1.getBytes("UTF-8"))).a(abyte0);
    }

    protected abstract void b(Context context);

    protected abstract void c(Context context);
}
