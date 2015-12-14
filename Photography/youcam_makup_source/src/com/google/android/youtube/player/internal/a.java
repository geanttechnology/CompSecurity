// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ac

public abstract class a
    implements YouTubeThumbnailLoader
{

    private final YouTubeThumbnailView a;
    private com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener b;
    private boolean c;
    private boolean d;

    public a(YouTubeThumbnailView youtubethumbnailview)
    {
        a = (YouTubeThumbnailView)ac.a(youtubethumbnailview, "thumbnailView cannot be null");
    }

    private void h()
    {
        if (!a())
        {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        } else
        {
            return;
        }
    }

    public final void a(Bitmap bitmap, String s)
    {
        if (a())
        {
            a.setImageBitmap(bitmap);
            if (b != null)
            {
                b.onThumbnailLoaded(a, s);
            }
        }
    }

    public abstract void a(String s);

    public abstract void a(String s, int i);

    protected boolean a()
    {
        return !d;
    }

    public abstract void b();

    public final void b(String s)
    {
        if (a() && b != null)
        {
            try
            {
                s = com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason.valueOf(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = com.google.android.youtube.player.YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
            }
            b.onThumbnailError(a, s);
        }
    }

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract boolean f();

    public final void first()
    {
        h();
        if (!c)
        {
            throw new IllegalStateException("Must call setPlaylist first");
        } else
        {
            d();
            return;
        }
    }

    public abstract void g();

    public final boolean hasNext()
    {
        h();
        return e();
    }

    public final boolean hasPrevious()
    {
        h();
        return f();
    }

    public final void next()
    {
        h();
        if (!c)
        {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        if (!e())
        {
            throw new NoSuchElementException("Called next at end of playlist");
        } else
        {
            b();
            return;
        }
    }

    public final void previous()
    {
        h();
        if (!c)
        {
            throw new IllegalStateException("Must call setPlaylist first");
        }
        if (!f())
        {
            throw new NoSuchElementException("Called previous at start of playlist");
        } else
        {
            c();
            return;
        }
    }

    public final void release()
    {
        if (a())
        {
            d = true;
            b = null;
            g();
        }
    }

    public final void setOnThumbnailLoadedListener(com.google.android.youtube.player.YouTubeThumbnailLoader.OnThumbnailLoadedListener onthumbnailloadedlistener)
    {
        h();
        b = onthumbnailloadedlistener;
    }

    public final void setPlaylist(String s)
    {
        setPlaylist(s, 0);
    }

    public final void setPlaylist(String s, int i)
    {
        h();
        c = true;
        a(s, i);
    }

    public final void setVideo(String s)
    {
        h();
        c = false;
        a(s);
    }
}
