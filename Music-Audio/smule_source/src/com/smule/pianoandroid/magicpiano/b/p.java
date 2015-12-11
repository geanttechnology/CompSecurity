// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.b;

import android.content.Context;
import android.os.AsyncTask;
import com.smule.android.c.aa;
import com.smule.android.f.n;
import com.smule.android.network.a.r;
import com.smule.android.network.core.s;
import com.smule.android.network.managers.ak;
import com.smule.android.network.models.ResourceV2;
import com.smule.android.network.models.SongV2;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.data.db.a;
import com.smule.pianoandroid.magicpiano.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano.b:
//            q

public class p extends AsyncTask
    implements s
{

    private static final String b = com/smule/pianoandroid/magicpiano/b/p.getName();
    private static HashSet f;
    public q a;
    private Context c;
    private SongV2 d;
    private i e;
    private String g;
    private long h;
    private long i;

    public p(Context context, SongV2 songv2, q q1, i j)
    {
        h = 0L;
        i = 0L;
        c = context;
        d = songv2;
        a = q1;
        e = j;
    }

    public p(Context context, String s1, q q1, i j)
    {
        h = 0L;
        i = 0L;
        c = context;
        g = s1;
        a = q1;
        e = j;
    }

    private boolean a(SongV2 songv2)
    {
        Iterator iterator1;
        if (d.resourceFilePaths == null)
        {
            d.resourceFilePaths = new HashMap();
        }
        for (Iterator iterator = d.resources.iterator(); iterator.hasNext();)
        {
            ResourceV2 resourcev2 = (ResourceV2)iterator.next();
            i = i + resourcev2.size;
        }

        if (i > 0L)
        {
            (new File((new StringBuilder()).append(n.b(c)).append("/cache/").append(songv2.songId).toString())).mkdirs();
        }
        iterator1 = songv2.resources.iterator();
_L8:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        ResourceV2 resourcev2_1 = (ResourceV2)iterator1.next();
        if (resourcev2_1.role != null) goto _L4; else goto _L3
_L3:
        boolean flag1;
        aa.b("SongDownloadTask", (new StringBuilder()).append("Resource:").append(resourcev2_1.uid).append(" for song: ").append(songv2.title).append(" has no role!").toString());
        flag1 = false;
_L6:
        return flag1;
_L4:
        if (f.contains(resourcev2_1.role) && !d.resourceFilePaths.containsKey(resourcev2_1.role))
        {
            if (a.b.contains(songv2.songId))
            {
                File file = n.a(c, (new StringBuilder()).append(songv2.songId).append(".mid").toString());
                if (file != null && file.exists())
                {
                    d.resourceFilePaths.put(resourcev2_1.role, file.getAbsolutePath());
                }
                file = r.a(resourcev2_1.url, (new StringBuilder()).append("/cache/").append(d.songId).append("/").append(resourcev2_1.uid).toString(), c, songv2, this);
                if (file != null)
                {
                    d.resourceFilePaths.put(resourcev2_1.role, file.getAbsolutePath());
                }
            } else
            {
                File file1 = r.a(resourcev2_1.url, (new StringBuilder()).append("/cache/").append(d.songId).append("/").append(resourcev2_1.uid).toString(), c, songv2, this);
                if (file1 != null)
                {
                    d.resourceFilePaths.put(resourcev2_1.role, file1.getAbsolutePath());
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        boolean flag;
        if (d.resourceFilePaths != null && d.resourceFilePaths.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        if (!flag) goto _L6; else goto _L5
_L5:
        PianoCoreBridge.setFileLastAccessedTime((new StringBuilder()).append(n.b(c)).append("/cache/").append(d.songId).toString(), (int)System.currentTimeMillis() / 1000);
        (new File((new StringBuilder()).append(n.b(c)).append("/cache/").append(d.songId).toString())).setLastModified(System.currentTimeMillis());
        return flag;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void b()
    {
        publishProgress(new Long[] {
            Long.valueOf(100L)
        });
    }

    protected transient Boolean a(Void avoid[])
    {
        if (d == null && g != null)
        {
            d = ak.a().a(g);
        }
        if (d != null)
        {
            avoid = ak.a().a(d);
            if (avoid == null)
            {
                if (d.resources == null || d.resources.size() == 0)
                {
                    return Boolean.valueOf(false);
                }
            } else
            {
                d.a(avoid);
            }
            if (isCancelled())
            {
                return Boolean.valueOf(false);
            }
            if (!a(d))
            {
                return Boolean.valueOf(false);
            }
            b();
            if (d.a())
            {
                d.eTag = d.newEtag;
                d.newEtag = null;
            }
            if (isCancelled())
            {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }

    public void a()
    {
        publishProgress(new Long[] {
            Long.valueOf((h * 100L) / i)
        });
    }

    public void a(long l)
    {
    }

    protected void a(Boolean boolean1)
    {
        if (a != null)
        {
            q q1 = a;
            if (boolean1.booleanValue())
            {
                boolean1 = d;
            } else
            {
                boolean1 = null;
            }
            q1.a(boolean1);
        }
    }

    protected transient void a(Long along[])
    {
        super.onProgressUpdate(along);
        if (along != null && along.length > 0 && e != null)
        {
            e.a(along[0].longValue());
            return;
        } else
        {
            aa.b(b, (new StringBuilder()).append("------------- Download progress=").append(along).append(" dialog ").append(e).toString());
            return;
        }
    }

    public void b(long l)
    {
        h = h + l;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }

    protected void onProgressUpdate(Object aobj[])
    {
        a((Long[])aobj);
    }

    static 
    {
        f = new HashSet();
        f.add("main");
        f.add("accomp");
        f.add("vocal_only");
    }
}
