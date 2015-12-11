// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public final class chh
{

    private final chs a;

    public chh(chs chs1)
    {
        a = chs1;
    }

    private String a()
    {
        return a.b;
    }

    public final HttpPost a(cgm cgm1)
    {
        HttpPost httppost = new HttpPost(String.valueOf(a()).concat("get_screen"));
        cgm1 = a.a(new BasicNameValuePair[] {
            new BasicNameValuePair("pairing_code", cgm1.toString())
        });
        try
        {
            httppost.setEntity(new UrlEncodedFormEntity(cgm1));
        }
        // Misplaced declaration of an exception variable
        catch (cgm cgm1)
        {
            return httppost;
        }
        return httppost;
    }

    public final HttpPost a(Collection collection)
    {
        HttpPost httppost = new HttpPost(String.valueOf(a()).concat("get_screen_availability"));
        collection = a.a(new BasicNameValuePair[] {
            new BasicNameValuePair("lounge_token", TextUtils.join(",", collection))
        });
        try
        {
            httppost.setEntity(new UrlEncodedFormEntity(collection));
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return httppost;
        }
        return httppost;
    }

    public final HttpPost b(Collection collection)
    {
        HttpPost httppost = new HttpPost(String.valueOf(a()).concat("get_lounge_token_batch"));
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(new BasicNameValuePair("screen_ids", TextUtils.join(",", collection)));
        try
        {
            httppost.setEntity(new UrlEncodedFormEntity(arraylist));
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return httppost;
        }
        return httppost;
    }
}
