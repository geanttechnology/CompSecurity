// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

// Referenced classes of package com.medialets.advertising:
//            ae, a, y, AdView

final class aa
{

    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    aa()
    {
    }

    public static ae a(Vector vector, AdView adview)
    {
        float f1 = 0.0F;
        Vector vector1 = new Vector();
        if (vector.size() <= 0)
        {
            return null;
        }
        int k = vector.size();
        for (int i = 0; i < k; i++)
        {
            if (a((ae)vector.get(i), adview))
            {
                vector1.add(vector.get(i));
            }
        }

        if (vector1.size() <= 0)
        {
            return null;
        }
        if (vector1.size() == 1)
        {
            return (ae)vector1.get(0);
        }
        vector = new float[vector1.size()];
        int l = vector1.size();
        int j = 0;
        k = 0;
        float f = 0.0F;
        while (j < l) 
        {
            adview = (ae)vector1.get(j);
            if (adview.t() == 0.0F)
            {
                vector[k] = 1.0F;
            } else
            {
                vector[k] = adview.t();
            }
            f += vector[k];
            k++;
            j++;
        }
        adview = new Random();
        float f2 = 100F / f;
        float f3 = adview.nextFloat();
        j = 0;
        f = f1;
        for (; j < vector.length; j++)
        {
            f += vector[j] * f2;
            if (f3 * 100F < f)
            {
                return (ae)vector1.get(j);
            }
        }

        return (ae)vector1.get(0);
    }

    public static String a(List list)
    {
        int j = list.size();
        if (j == 0)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append((String)list.get(i));
            if (i != j - 1)
            {
                stringbuffer.append(",");
            }
        }

        return stringbuffer.toString();
    }

    public static Date a(String s, SimpleDateFormat simpledateformat)
    {
        if (s == null || s.equals(""))
        {
            return new Date();
        }
        try
        {
            s = simpledateformat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.medialets.advertising.a.a((new StringBuilder()).append("Error parsing date: ").append(s.toString()).toString());
            return null;
        }
        return s;
    }

    public static List a(String s)
    {
        if (s == null || s.equals(""))
        {
            return new ArrayList();
        } else
        {
            return Arrays.asList(s.split(","));
        }
    }

    public static void a(InputStream inputstream, RandomAccessFile randomaccessfile)
        throws IOException, NullPointerException
    {
        a(inputstream, randomaccessfile, 8192);
    }

    public static void a(InputStream inputstream, RandomAccessFile randomaccessfile, int i)
        throws IOException, NullPointerException
    {
        a(Channels.newChannel(inputstream), ((WritableByteChannel) (randomaccessfile.getChannel())), 8192);
        if (inputstream != null)
        {
            inputstream.close();
        }
        if (randomaccessfile != null)
        {
            randomaccessfile.close();
        }
        return;
        Exception exception;
        exception;
        if (inputstream != null)
        {
            inputstream.close();
        }
        if (randomaccessfile != null)
        {
            randomaccessfile.close();
        }
        throw exception;
    }

    public static void a(RandomAccessFile randomaccessfile, OutputStream outputstream)
        throws IOException, NullPointerException
    {
        a(((ReadableByteChannel) (randomaccessfile.getChannel())), Channels.newChannel(outputstream), 8192);
        if (randomaccessfile != null)
        {
            randomaccessfile.close();
        }
        if (outputstream != null)
        {
            outputstream.close();
        }
        return;
        Exception exception;
        exception;
        if (randomaccessfile != null)
        {
            randomaccessfile.close();
        }
        if (outputstream != null)
        {
            outputstream.close();
        }
        throw exception;
    }

    private static void a(ReadableByteChannel readablebytechannel, WritableByteChannel writablebytechannel, int i)
        throws IOException, NullPointerException
    {
        if (readablebytechannel == null || writablebytechannel == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        Object obj;
        for (obj = ByteBuffer.allocateDirect(i); readablebytechannel.read(((ByteBuffer) (obj))) != -1; ((ByteBuffer) (obj)).compact())
        {
            ((ByteBuffer) (obj)).flip();
            writablebytechannel.write(((ByteBuffer) (obj)));
        }

        break MISSING_BLOCK_LABEL_68;
        obj;
        if (readablebytechannel == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        readablebytechannel.close();
        if (writablebytechannel != null)
        {
            try
            {
                writablebytechannel.close();
            }
            // Misplaced declaration of an exception variable
            catch (ReadableByteChannel readablebytechannel)
            {
                com.medialets.advertising.a.c((new StringBuilder()).append("Problem closing resources:").append(readablebytechannel.toString()).toString());
            }
        }
        throw obj;
        ((ByteBuffer) (obj)).flip();
        for (; ((ByteBuffer) (obj)).hasRemaining(); writablebytechannel.write(((ByteBuffer) (obj)))) { }
        if (readablebytechannel != null)
        {
            try
            {
                readablebytechannel.close();
            }
            // Misplaced declaration of an exception variable
            catch (ReadableByteChannel readablebytechannel)
            {
                com.medialets.advertising.a.c((new StringBuilder()).append("Problem closing resources:").append(readablebytechannel.toString()).toString());
                return;
            }
        }
        if (writablebytechannel == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        writablebytechannel.close();
    }

    public static boolean a(int i)
    {
        return i != 0;
    }

    public static boolean a(ae ae1, AdView adview)
    {
        Object obj;
        Object obj1;
        int i = ae1.r();
        boolean flag;
        if (y.a() < i)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            return false;
        }
        obj1 = a(ae1.n());
        obj = adview.getSlotName();
        if (((List) (obj1)).size() <= 0 || obj == null) goto _L2; else goto _L1
_L1:
        obj1 = ((List) (obj1)).iterator();
_L6:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        if (!((String)((Iterator) (obj1)).next()).equals(obj)) goto _L6; else goto _L5
_L5:
        boolean flag1 = true;
_L15:
        if (!flag1)
        {
            return false;
        }
_L2:
        obj = a(ae1.o());
        obj1 = a(adview.getSlotKeywords());
        if (((List) (obj)).size() <= 0 || ((List) (obj1)).size() <= 0) goto _L8; else goto _L7
_L7:
        Iterator iterator = ((List) (obj)).iterator();
_L12:
        if (!iterator.hasNext()) goto _L10; else goto _L9
_L9:
        if (!((List) (obj1)).contains((String)iterator.next())) goto _L12; else goto _L11
_L11:
        flag1 = true;
_L13:
        if (!flag1)
        {
            return false;
        }
_L8:
label0:
        {
            ae1 = a(ae1.p());
            adview = a(adview.getBlockedKeywords());
            if (ae1.size() <= 0 || ((List) (obj1)).size() <= 0)
            {
                break label0;
            }
            ae1 = ae1.iterator();
            do
            {
                if (!ae1.hasNext())
                {
                    break label0;
                }
            } while (!((List) (obj1)).contains((String)ae1.next()));
            return false;
        }
label1:
        {
            if (adview.size() <= 0 || ((List) (obj)).size() <= 0)
            {
                break label1;
            }
            ae1 = adview.iterator();
            do
            {
                if (!ae1.hasNext())
                {
                    break label1;
                }
            } while (!((List) (obj)).contains((String)ae1.next()));
            return false;
        }
        return true;
_L10:
        flag1 = false;
        if (true) goto _L13; else goto _L4
_L4:
        flag1 = false;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public static boolean a(String s, String s1, boolean flag)
    {
        boolean flag1 = false;
        if (s == null || s1 == null)
        {
            flag = flag1;
            if (s == null)
            {
                flag = flag1;
                if (s1 == null)
                {
                    flag = true;
                }
            }
        } else
        {
            flag = flag1;
            if (s1.length() <= s.length())
            {
                return s.regionMatches(true, 0, s1, 0, s1.length());
            }
        }
        return flag;
    }

    public static int b(String s)
    {
        if (s == null || s.equals(""))
        {
            return 0;
        } else
        {
            return Integer.parseInt(s);
        }
    }

    public static float c(String s)
    {
        if (s == null || s.equals(""))
        {
            return 0.0F;
        } else
        {
            return Float.parseFloat(s);
        }
    }

}
