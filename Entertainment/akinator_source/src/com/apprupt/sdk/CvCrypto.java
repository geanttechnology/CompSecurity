// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvBase64

class CvCrypto
{

    private static final byte DEFAULT_KEY[] = "JZbZbQQxDEMrEmBdtlSOfKj/EsLZfAQIktkxTT1S6zv2rpvkVxbZTKPdpmRsY8yus/c+nfP6U3p6jexoU47TtLTfmutdz6lX7h0jae7BZLUW1YpDatlHpu+0M+KOaSfp4lGydy5tvI10DnsyI2+5+Yz1VtAsnGCGB0tHEd/wFgu8ZM9zt9zEM/s9srWLihdOncFeJ1WHNM5grUkm3zMRgzbOIfaD368v08ssVqyHytXJrhul4Jq1K6X6bL+lxj7PGtTmcEX9EAz7aVY7c2bevTTm0r0I+gJ6PCjiCU1VqOau1zOH1qjx6CyDKMMxeVWoM5p97Hx9zpkMF2CacJGNgp53vtc6PBjt2iIp+MB2uKJ4j3+aL8zmNVbPNyduFTdNGj7HXd/dV1LmGARXYPfdtXu8wZ3PhXA7aFYMP7oPvWX3ztlm2+aKfvaMjg7MIq7A5/3IZe81R6jPemMOeQ49PT9+8HQwg5JcovtVMT/cwddhJXHBvfI8KslBt3usMUou/p+wsPiS3MJZ3phpngMXACIo2Ba2g1/wNFr30zNeUs19KIshneccj3uGexpcmQ8z3YpnAnqeL3Hgd8XWgyYGkxg0hm/yEaCgLZ+GvXgeLw234mNCsn9s3KI9bNEqKXUZcS4A/qaCsPAO3KtfgLG7KDvF7Dzwx+M1yFD7jIXPwJ8wa/CDdKy0rnncquXqTtpboKd4YnLR9IbPt53NBhS99C3gcG64q2NSboQD/92bRwxFFK0XoFVam3FWA/cCgNRje4CLdI8FMHeB0J6MDEoig5lO95WAukiHjZNl9ManrS5yGhN370nrPVV+9wDpeW2ftQTB7I2zGow1csFv6MJk7hN5oXaXNbkKOBSox40DHCKlX0R1Hozs8rVEUUwBYxBeEEThw232nKIRSE868p6ZYKxw1l4gWxtH9QlBIG7O3YrCWQbQ7HzMM7D0AksN70K3jcO5QwnGwUPEH3n3DdtRcP26nBXor1oXrxj7Y16EwuakOzWHGIqncDYbmkHpeIONhbAWKCIun7BNu2/JcOfCBCDrY+PDImBFt6xz9ULUeVdRfA3G8vO5HZ15MYu2+kAVG96ZHdzxUdPQwwPv4UpiMD7kjhyO4B8eSDzpg5G2ICq6ELeZb9j5yhgddJMXLnJgBs7CLJDYfyumoIrDVevN5kZTyqcHEcYuCKZT+VAV+3K8Xhz5uWJYGODw6yjUKUFAhbwOq42OYA9EAiDBnwPhqSCbRdC0Y3yVjHjUQzxQAl9zf40fCB8JA1bZB+w0P7X3jeGebyMVOAwBcnfdGozmftgVqO0GCASwwbMh1WD40vQ7BbV77Zu6VyoAnopjvg9QnXJaB6ssEWZkSgA1Ens/5z7G+GHuCx8BW7jg9kR+5jFe9aVzo3s/swtbBAbAQ6xPxj4cd6wofFBZoYcX+jAB48NYWNB4uvA3lOPu+4GHXKBJ0BuBmp250aXbsSMTj2780JuGfCnnN4tNU1KH78Bh6aZ5FNY8BllQG58evGwor40aK4hm9EIg71WIup1i2nExkORAn7L3zcHYG9i63xDxnunoFmGY9E6vZEg/UAU1C3swvxa0VyBSmQlNiNWsq7EOcCnRCxh06xcg9Ni2e741bXPgm8Q70khlNFp5Y7aYxSlEPb9nNjYK1tMwD9wLp6CVv3FaArQc9ZG9nnKjg9BC73vhDSy+831beciFYSoq4tiDofKZtI4cyJ33wEPHt5OY8SGH7XOw3eDbHw==".getBytes();

    CvCrypto()
    {
    }

    static byte[] decode(String s)
    {
        return decode(s, null);
    }

    static byte[] decode(String s, byte abyte0[])
    {
        byte abyte1[];
label0:
        {
            if (abyte0 != null)
            {
                abyte1 = abyte0;
                if (abyte0.length != 0)
                {
                    break label0;
                }
            }
            abyte1 = DEFAULT_KEY;
        }
        s = CvBase64.urlDecode(s);
        if (s == null)
        {
            return null;
        } else
        {
            return obfuscate(s, abyte1);
        }
    }

    static String encode(byte abyte0[])
    {
        return encode(abyte0, null);
    }

    static String encode(byte abyte0[], byte abyte1[])
    {
        byte abyte2[];
label0:
        {
            if (abyte1 != null)
            {
                abyte2 = abyte1;
                if (abyte1.length != 0)
                {
                    break label0;
                }
            }
            abyte2 = DEFAULT_KEY;
        }
        return CvBase64.urlEncode(obfuscate(abyte0, abyte2));
    }

    private static byte[] obfuscate(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length];
        int i = 0;
        for (int j = 0; j < abyte0.length;)
        {
            int k = i;
            if (i >= abyte1.length)
            {
                k = 0;
            }
            abyte2[j] = (byte)(abyte0[j] ^ abyte1[k]);
            j++;
            i = k + 1;
        }

        return abyte2;
    }

}
