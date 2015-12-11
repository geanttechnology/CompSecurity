// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class azc
    implements azb
{

    public DisplayMetrics a;
    public bbb b;
    private bbc c;

    protected azc(Context context, bbb bbb1, bbc bbc1)
    {
        b = bbb1;
        c = bbc1;
        try
        {
            a = context.getResources().getDisplayMetrics();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            a = new DisplayMetrics();
        }
        a.density = 1.0F;
    }

    private String a(Context context, String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        b();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        a();
_L1:
        byte abyte0[] = c();
        this;
        JVM INSTR monitorexit ;
        if (abyte0.length != 0)
        {
            break MISSING_BLOCK_LABEL_55;
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
        context = abyte0;
        if (abyte0.length > 239)
        {
            b();
            a(20, 1L);
            context = c();
        }
        if (context.length >= 239)
        {
            break MISSING_BLOCK_LABEL_256;
        }
        abyte0 = new byte[239 - context.length];
        (new SecureRandom()).nextBytes(abyte0);
        context = ByteBuffer.allocate(240).put((byte)context.length).put(context).put(abyte0).array();
_L2:
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        messagedigest.update(context);
        messagedigest = messagedigest.digest();
        context = ByteBuffer.allocate(256).put(messagedigest).put(context).array();
        messagedigest = new byte[256];
        (new ayn()).a(context, messagedigest);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        context = s;
        if (s.length() > 32)
        {
            context = s.substring(0, 32);
        }
        (new bbq(context.getBytes("UTF-8"))).a(messagedigest);
        return b.a(messagedigest, true);
        context = ByteBuffer.allocate(240).put((byte)context.length).put(context).array();
          goto _L2
    }

    private void b()
    {
        c.a();
    }

    private byte[] c()
    {
        return c.b();
    }

    public final String a(Context context)
    {
        return a(context, null, false);
    }

    protected abstract void a();

    protected final void a(int i, long l)
    {
        c.a(i, l);
    }

    protected final void a(int i, String s)
    {
        c.a(i, s);
    }

    protected abstract void b(Context context);
}
