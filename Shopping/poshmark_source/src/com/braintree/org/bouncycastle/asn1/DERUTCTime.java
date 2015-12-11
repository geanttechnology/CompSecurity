// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintree.org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

// Referenced classes of package com.braintree.org.bouncycastle.asn1:
//            ASN1Object, ASN1TaggedObject, ASN1OctetString, DEROutputStream, 
//            DERObject

public class DERUTCTime extends ASN1Object
{

    String time;

    public DERUTCTime(String s)
    {
        time = s;
        try
        {
            getDate();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid date string: ").append(s.getMessage()).toString());
        }
    }

    public DERUTCTime(Date date)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyMMddHHmmss'Z'");
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "Z"));
        time = simpledateformat.format(date);
    }

    DERUTCTime(byte abyte0[])
    {
        char ac[] = new char[abyte0.length];
        for (int i = 0; i != ac.length; i++)
        {
            ac[i] = (char)(abyte0[i] & 0xff);
        }

        time = new String(ac);
    }

    public static DERUTCTime getInstance(ASN1TaggedObject asn1taggedobject, boolean flag)
    {
        asn1taggedobject = asn1taggedobject.getObject();
        if (flag || (asn1taggedobject instanceof DERUTCTime))
        {
            return getInstance(asn1taggedobject);
        } else
        {
            return new DERUTCTime(((ASN1OctetString)asn1taggedobject).getOctets());
        }
    }

    public static DERUTCTime getInstance(Object obj)
    {
        if (obj == null || (obj instanceof DERUTCTime))
        {
            return (DERUTCTime)obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal object in getInstance: ").append(obj.getClass().getName()).toString());
        }
    }

    private byte[] getOctets()
    {
        char ac[] = time.toCharArray();
        byte abyte0[] = new byte[ac.length];
        for (int i = 0; i != ac.length; i++)
        {
            abyte0[i] = (byte)ac[i];
        }

        return abyte0;
    }

    boolean asn1Equals(DERObject derobject)
    {
        if (!(derobject instanceof DERUTCTime))
        {
            return false;
        } else
        {
            return time.equals(((DERUTCTime)derobject).time);
        }
    }

    void encode(DEROutputStream deroutputstream)
        throws IOException
    {
        deroutputstream.writeEncoded(23, getOctets());
    }

    public Date getAdjustedDate()
        throws ParseException
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpledateformat.parse(getAdjustedTime());
    }

    public String getAdjustedTime()
    {
        String s = getTime();
        if (s.charAt(0) < '5')
        {
            return (new StringBuilder()).append("20").append(s).toString();
        } else
        {
            return (new StringBuilder()).append("19").append(s).toString();
        }
    }

    public Date getDate()
        throws ParseException
    {
        return (new SimpleDateFormat("yyMMddHHmmssz")).parse(getTime());
    }

    public String getTime()
    {
        if (time.indexOf('-') < 0 && time.indexOf('+') < 0)
        {
            if (time.length() == 11)
            {
                return (new StringBuilder()).append(time.substring(0, 10)).append("00GMT+00:00").toString();
            } else
            {
                return (new StringBuilder()).append(time.substring(0, 12)).append("GMT+00:00").toString();
            }
        }
        int j = time.indexOf('-');
        int i = j;
        if (j < 0)
        {
            i = time.indexOf('+');
        }
        String s1 = time;
        String s = s1;
        if (i == time.length() - 3)
        {
            s = (new StringBuilder()).append(s1).append("00").toString();
        }
        if (i == 10)
        {
            return (new StringBuilder()).append(s.substring(0, 10)).append("00GMT").append(s.substring(10, 13)).append(":").append(s.substring(13, 15)).toString();
        } else
        {
            return (new StringBuilder()).append(s.substring(0, 12)).append("GMT").append(s.substring(12, 15)).append(":").append(s.substring(15, 17)).toString();
        }
    }

    public int hashCode()
    {
        return time.hashCode();
    }

    public String toString()
    {
        return time;
    }
}
