// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;

// Referenced classes of package com.amazon.device.ads:
//            be, co, cn, bm

class bc
{

    private static final bc e = new bc(new be());
    private static final String f = com/amazon/device/ads/bc.getSimpleName();
    private static final BigInteger g = new BigInteger("22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097");
    private static final BigInteger h = new BigInteger("5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777");
    final bm a;
    final Properties b = new Properties();
    boolean c;
    final cn d;

    private bc(bm bm)
    {
        c = false;
        new co();
        d = co.a(f);
        a = bm;
    }

    public static bc a()
    {
        return e;
    }

    public final Boolean a(String s, Boolean boolean1)
    {
        String s1;
        if (c)
        {
            if ((s1 = b.getProperty(s)) != null)
            {
                boolean flag;
                try
                {
                    flag = Boolean.parseBoolean(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    d.d("Unable to parse boolean debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return boolean1;
                }
                return Boolean.valueOf(flag);
            }
        }
        return boolean1;
    }

    public final Integer a(String s, Integer integer)
    {
        String s1;
        if (c)
        {
            if ((s1 = b.getProperty(s)) != null)
            {
                int i;
                try
                {
                    i = Integer.parseInt(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    d.d("Unable to parse integer debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return integer;
                }
                return Integer.valueOf(i);
            }
        }
        return integer;
    }

    public final Long a(String s)
    {
        String s1;
        if (c)
        {
            if ((s1 = b.getProperty(s)) != null)
            {
                long l;
                try
                {
                    l = Long.parseLong(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    d.d("Unable to parse long debug property - property: %s, value: %s", new Object[] {
                        s, s1
                    });
                    return null;
                }
                return Long.valueOf(l);
            }
        }
        return null;
    }

    public final String a(String s, String s1)
    {
        if (!c)
        {
            return s1;
        } else
        {
            return b.getProperty(s, s1);
        }
    }

    final byte[] a(byte abyte0[])
    {
        try
        {
            Object obj = new RSAPrivateKeySpec(g, h);
            obj = KeyFactory.getInstance("RSA").generatePrivate(((java.security.spec.KeySpec) (obj)));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, ((java.security.Key) (obj)));
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            d.b((new StringBuilder("Exception ")).append(abyte0).append(" trying to decrypt debug file").toString(), null);
            return null;
        }
        return abyte0;
    }

    public final boolean b(String s)
    {
        if (!c)
        {
            return false;
        } else
        {
            return b.containsKey(s);
        }
    }

}
