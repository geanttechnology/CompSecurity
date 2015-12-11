// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class caw
    implements crb
{

    private bzl a;
    private final crb b;

    public caw(bzl bzl1, crb crb1)
    {
        a = (bzl)b.a(bzl1);
        b = (crb)b.a(crb1);
    }

    private List a(Uri uri)
    {
        ArrayList arraylist = new ArrayList();
        Uri uri1;
        do
        {
            bhw bhw1;
            crb crb1;
label0:
            {
                bhw1 = bhw.a();
                crb1 = b;
                int i = a.b;
                b.a(uri);
                if (uri.getQueryParameter("start-index") != null)
                {
                    uri1 = uri;
                    if (uri.getQueryParameter("max-results") != null)
                    {
                        break label0;
                    }
                }
                uri = uri.buildUpon();
                bzl.a(uri, 1, i);
                uri1 = uri.build();
            }
            crb1.a(bzi.a(uri1), bhw1);
            uri = (cpv)bhw1.get();
            arraylist.addAll(((cpv) (uri)).c);
            uri1 = ((cpv) (uri)).b;
            if (((cpv) (uri)).a <= arraylist.size())
            {
                break;
            }
            uri = uri1;
        } while (uri1 != null);
        return arraylist;
    }

    public final void a(Object obj, bhv bhv1)
    {
        String s = (String)obj;
        b.b();
        b.a(s);
        obj = String.valueOf("https://gdata.youtube.com/feeds/api/playlists/");
        String s1 = String.valueOf(s);
        if (s1.length() != 0)
        {
            obj = ((String) (obj)).concat(s1);
        } else
        {
            obj = new String(((String) (obj)));
        }
        obj = Uri.parse(((String) (obj)));
        try
        {
            bhv1.a(s, a(((Uri) (obj))));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            bhv1.a(s, ((Exception) (obj)));
        }
    }
}
