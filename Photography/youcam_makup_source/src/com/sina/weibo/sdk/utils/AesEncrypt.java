// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import java.io.PrintStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            LogUtil, Base64, MD5

public class AesEncrypt
{

    public AesEncrypt()
    {
    }

    public static String Decrypt(String s)
    {
        Cipher cipher;
        try
        {
            s = deBase64(s);
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, generateKey("Stark"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.e("Decrypt", s.getMessage());
            return null;
        }
        s = new String(cipher.doFinal(s), "utf-8");
        return s;
        s;
        LogUtil.e("Decrypt", s.getMessage());
        return null;
    }

    public static String Encrypt(String s)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, generateKey("Stark"));
            s = enBase64(cipher.doFinal(s.getBytes("utf-8")));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.e("Encrypt", s.getMessage());
            return null;
        }
        return s;
    }

    private static byte[] deBase64(String s)
    {
        return Base64.decode(s.getBytes());
    }

    private static String enBase64(byte abyte0[])
    {
        return new String(Base64.encode(abyte0));
    }

    protected static Key generateKey(String s)
    {
        try
        {
            s = MD5.hexdigest(s).substring(2, 18);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtil.e("generateKey", s.getMessage());
            return null;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        LogUtil.v("Decrypt", "Key\u4E3A\u7A7Anull");
        return null;
        if (s.length() == 16)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        LogUtil.v("Decrypt", "Key\u957F\u5EA6\u4E0D\u662F16\u4F4D");
        return null;
        s = new SecretKeySpec(s.getBytes("utf-8"), "AES");
        return s;
    }

    public static void main(String args[])
    {
        args = Decrypt("u7FFIamNkcuNHMwmAa+VaIrn96etbed19m6VA0iWPoJB8tcFkKkLIgLCScynfkClC9/IRHmXbKa4+ySqhnIjK7P3TgRj0n9KGsLQIVxiT/h2HWmUZj9Bum4EJuSjfSJBVjf/78GWl4zw2EQBOTZyF/9En8JLeLv1YO1tzDwKP3+5S8nnmvV26sjHFAhyRNifFZqUAxMoO1j02c48G/C7vYisBIahWr+vGRmlpxliexdbmR3CKKTSmTmT7jGWVhv5dP5DPcYKEpchtuRnR/rrjI0Nhj3Jcz8gPCegdi+sC+nLij0IjxFf1N5xvyl8CTkbLAF/QjyHq2Y0UU1pOq+oyy88TWp/rym9+vLP5NTT+VObXbduol8UQg0PeRVuTsx4iHHROb4i+Pc5DEVAWsX6Cnn2z7B9gKph0y6JLIddzmUqyeBTzZ3rJEAW/h4JrN9X8nI3HES88cHdQn9YXP7XQrlP6qhy7Z7TKpPda44tWJhR4kZLxflu9pMkCwr2upkDquCgqdgCmeD6vzBd80U0AZphXxFw6GGrFTbkYYbRcmBfrlg5ypEyXoaDujnS15s/6y8Wkmfge/6T6L5t+CHgarkSuNUl0yrZ32R8P9wMDMKs+nzy50pkRugEUFbG8C202SN7DyexqBguwEN4QFqZh2j9vs5kpdfzNYVIxfnuivbriWvNZvRmesdrxnvmaYJH0ssWD5XzJrOeUdzJvqqzjXh8kCw90NuaIMh+5eF2c8MrP81Jh+82kdlmrD0fybdOPap5RRIe/UAIqcOIChbyjO6iDQ6G/ChShzHGwbxxQsQ22tdmOC+tJq4kAqk5Y9uPtyEV7r38nyBsfiyDWMgweIxnCfvDxIe5frXIE+OKziNGeUXuJf6FYc1Kex/ASjdE");
        System.out.println((new StringBuilder("\u89E3\u5BC6\u540E\u7684\u5B57\u4E32\u662F\uFF1A")).append(args).toString());
    }
}
