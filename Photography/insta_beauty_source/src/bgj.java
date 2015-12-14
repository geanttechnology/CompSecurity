// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.BitmapFactory;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class bgj
{

    bib a;
    protected Object b;
    protected bge c;
    protected Boolean d;
    int e;
    int f;
    protected int g;
    int h;
    String i;
    private ces j;

    public bgj()
    {
        i = "TDownloadAssistent";
        j = new ces();
    }

    private void c(String s)
    {
        byte abyte0[] = j.a(s, new bgk(this));
        if (abyte0 != null)
        {
            a(s, abyte0);
        }
    }

    public Boolean a()
    {
        return d;
    }

    protected ArrayList a(String s)
    {
        return null;
    }

    public void a(bge bge1)
    {
        c = bge1;
        d = Boolean.valueOf(true);
        if (a == null)
        {
            return;
        } else
        {
            a(b(a));
            return;
        }
    }

    public void a(bib bib)
    {
        a = bib;
    }

    public void a(Exception exception)
    {
        Log.v(i, "download iamge Failed");
        d = Boolean.valueOf(false);
        if (c != null)
        {
            c.filterDownloadFailed(0, null);
        }
    }

    public void a(String s, cem cem)
    {
        c(s);
    }

    public void a(String s, byte abyte0[])
    {
        abyte0 = BitmapFactory.decodeStream(new ByteArrayInputStream(abyte0));
        if (abyte0 == null)
        {
            Log.v("onImageRequestSuccess bitmap", "bitmap is null");
            d = Boolean.valueOf(false);
            if (c != null)
            {
                c.filterDownloadFailed(0, null);
            }
        } else
        {
            Log.v("onImageRequestSuccess bitmap", "bitmap is not null");
            Log.v(i, s);
            if (s != null)
            {
                s = s.substring(s.lastIndexOf("/") + 1);
                Log.v(i, s);
                FileManager.getInstance().saveOnlineBitmapRes(b(), s, abyte0);
            }
            Log.v(i, "download iamge success");
            e = e + 1;
            h = h + 0;
            if (e == f)
            {
                c();
                d = Boolean.valueOf(false);
                e = 0;
                g = 0;
                h = 0;
                f = 0;
                return;
            }
        }
    }

    protected void a(List list)
    {
        e = 0;
        f = list.size();
        for (int k = 0; k < list.size(); k++)
        {
            a((String)list.get(k), ((cem) (null)));
        }

    }

    protected abstract EOnlineResType b();

    protected Object b(String s)
    {
        return null;
    }

    protected List b(bib bib)
    {
        return null;
    }

    protected Object c(bib bib)
    {
        return null;
    }

    protected void c()
    {
        if (a != null)
        {
            Object obj = c(a);
            if (c != null)
            {
                c.filterDownloadFinished(obj);
                return;
            }
        }
    }
}
