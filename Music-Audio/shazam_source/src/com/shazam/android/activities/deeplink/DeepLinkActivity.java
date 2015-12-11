// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.shazam.android.activities.DetailsActivity;
import com.shazam.android.activities.MusicDetailsV3Activity;
import com.shazam.android.activities.artist.ArtistProfileActivity;
import com.shazam.android.activities.deeplink.a.a;
import com.shazam.android.activities.deeplink.a.b;
import com.shazam.android.activities.deeplink.a.c;
import com.shazam.android.activities.modules.DiscographyActivity;
import com.shazam.android.activities.search.SearchActivity;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.k.f.j;
import com.shazam.b.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class DeepLinkActivity extends BaseAppCompatActivity
{

    private static final Map a;
    private static final Map b = d.a("track", new a(com/shazam/android/activities/MusicDetailsV3Activity), "search", new a(com/shazam/android/activities/search/SearchActivity));

    public DeepLinkActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        Uri uri;
        super.onCreate(bundle);
        uri = getIntent().getData().buildUpon().appendQueryParameter("launchedfromdeeplink", "true").build();
        bundle = uri.getPath();
        obj = a.entrySet().iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        if (!Pattern.matches((String)entry.getKey(), bundle)) goto _L4; else goto _L3
_L3:
        obj = (b)entry.getValue();
_L5:
        bundle = ((Bundle) (obj));
        if (obj == null)
        {
            if (!"shazam".equals(uri.getScheme()))
            {
                break MISSING_BLOCK_LABEL_195;
            }
            bundle = b.entrySet().iterator();
            do
            {
                if (!bundle.hasNext())
                {
                    break MISSING_BLOCK_LABEL_195;
                }
                obj = (java.util.Map.Entry)bundle.next();
            } while (!((String)((java.util.Map.Entry) (obj)).getKey()).equals(uri.getHost()));
            bundle = (b)((java.util.Map.Entry) (obj)).getValue();
        }
_L6:
        if (bundle == null)
        {
            bundle = b.a;
        }
        bundle.a(uri, this);
        finish();
        return;
_L2:
        obj = null;
          goto _L5
        bundle = null;
          goto _L6
    }

    static 
    {
        a a1 = new a(com/shazam/android/activities/DetailsActivity);
        a a2 = new a(com/shazam/android/activities/modules/DiscographyActivity);
        a a3 = new a(com/shazam/android/activities/artist/ArtistProfileActivity);
        a a4 = new a(com/shazam/android/activities/MusicDetailsV3Activity);
        a a5 = new a(com/shazam/android/activities/MusicDetailsV3Activity);
        c c1 = new c(new j());
        HashMap hashmap = new HashMap(6);
        hashmap.put("/discover/artist/\\d+/album/\\d+", a1);
        hashmap.put("/discover/artist/\\d+", a2);
        hashmap.put("/artist/\\d+/?.*", a3);
        hashmap.put("/discover/track/\\d+", a4);
        hashmap.put("/track/\\d+(/.+)?", a5);
        hashmap.put("/myshazam", c1);
        a = hashmap;
    }
}
