// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package jumiomobile:
//            ar, ab, aq, as

public class ap extends AsyncTask
{

    private final String a;
    private final Timer b;
    private ar c;
    private int d;

    public ap(String s)
    {
        this(s, 5000);
    }

    public ap(String s, int i)
    {
        a = s;
        b = new Timer("TimoutTaskKiller");
        d = i;
    }

    static int a(ap ap1)
    {
        return ap1.d;
    }

    static Timer b(ap ap1)
    {
        return ap1.b;
    }

    protected void a(byte abyte0[])
    {
        super.onPostExecute(abyte0);
        if (c != null)
        {
            ar ar1 = c;
            int i;
            if (abyte0 != null)
            {
                i = abyte0.length;
            } else
            {
                i = -1;
            }
            ar1.a(i);
        }
        if (b != null)
        {
            ab.d("DownloadTask", "killing timer");
            b.cancel();
            b.purge();
        }
    }

    protected transient void a(Integer ainteger[])
    {
        super.onProgressUpdate(ainteger);
        if (c != null)
        {
            c.a(ainteger[0].intValue());
        }
    }

    public byte[] a()
    {
        byte abyte0[];
        try
        {
            if (a == null)
            {
                throw new IllegalStateException("no Url was specified!");
            }
            abyte0 = (byte[])execute(new String[] {
                a
            }).get();
        }
        catch (InterruptedException interruptedexception)
        {
            return null;
        }
        catch (ExecutionException executionexception)
        {
            return null;
        }
        catch (CancellationException cancellationexception)
        {
            return null;
        }
        return abyte0;
    }

    protected transient byte[] a(String as1[])
    {
        Object obj = null;
        Object obj1;
        int j;
        System.currentTimeMillis();
        as1 = new URL(as1[0]);
        obj1 = (HttpURLConnection)as1.openConnection();
        ((HttpURLConnection) (obj1)).setDoInput(true);
        ((HttpURLConnection) (obj1)).connect();
        j = ((HttpURLConnection) (obj1)).getContentLength();
        if (((HttpURLConnection) (obj1)).getResponseCode() == 200)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        ab.a((new StringBuilder("Requesting file ")).append(as1.toString()).append(" returned ").append(((HttpURLConnection) (obj1)).getResponseCode()).toString());
        return null;
        as1 = ((HttpURLConnection) (obj1)).getInputStream();
        obj = as1;
        as1 = ((String []) (obj));
        byte abyte0[] = new byte[1024];
        as1 = ((String []) (obj));
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i = 0;
_L2:
        as1 = ((String []) (obj));
        int k = ((InputStream) (obj)).read(abyte0);
        if (k <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        as1 = ((String []) (obj));
        bytearrayoutputstream.write(abyte0, 0, k);
        i += k;
        as1 = ((String []) (obj));
        publishProgress(new Integer[] {
            Integer.valueOf((i * 100) / j)
        });
        if (true) goto _L2; else goto _L1
        abyte0;
_L8:
        as1 = ((String []) (obj));
        ab.a("DownloadTask", abyte0);
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as1[])
            {
                ab.a(getClass().getSimpleName(), as1);
            }
        }
_L3:
        return null;
_L1:
        as1 = ((String []) (obj));
        abyte0 = bytearrayoutputstream.toByteArray();
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as1[])
            {
                ab.a(getClass().getSimpleName(), as1);
                return abyte0;
            }
            return abyte0;
        } else
        {
            return abyte0;
        }
        abyte0;
        obj = null;
_L6:
        as1 = ((String []) (obj));
        ab.a(getClass().getSimpleName(), abyte0);
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String as1[])
            {
                ab.a(getClass().getSimpleName(), as1);
            }
        }
          goto _L3
        as1;
_L5:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ab.a(getClass().getSimpleName(), ((Throwable) (obj)));
            }
        }
        throw as1;
        abyte0;
        obj = as1;
        as1 = abyte0;
        if (true) goto _L5; else goto _L4
_L4:
        abyte0;
          goto _L6
        abyte0;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void b(byte abyte0[])
    {
        super.onCancelled(abyte0);
    }

    public boolean b()
    {
        Exception aexception[] = new Exception[1];
        boolean flag;
        try
        {
            flag = ((Boolean)(new aq(this, aexception)).execute(new String[] {
                a
            }).get()).booleanValue();
        }
        catch (Exception exception)
        {
            ab.a(jumiomobile/ap.getSimpleName(), exception);
            aexception[0] = exception;
            flag = false;
        }
        if (aexception[0] != null)
        {
            throw new Exception(aexception[0]);
        } else
        {
            return flag;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled(Object obj)
    {
        b((byte[])obj);
    }

    protected void onPostExecute(Object obj)
    {
        a((byte[])obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        b.schedule(new as(this, this), d);
        ab.d("DownloadTask", (new StringBuilder("started timer at ")).append(d).append(" s").toString());
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Integer[])aobj);
    }
}
