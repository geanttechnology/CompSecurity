// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.os.IBinder;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, b

public final class android.support.v4.media.session.c
{
    static interface a
    {
    }

    static final class b
        implements a
    {

        private final Object a;

        public b(Context context, MediaSessionCompat mediasessioncompat)
        {
            a = new MediaController(context, (android.media.session.MediaSession.Token)mediasessioncompat.b().a);
        }
    }

    static final class c
        implements a
    {

        private MediaSessionCompat.Token a;
        private android.support.v4.media.session.b b;

        public c(MediaSessionCompat.Token token)
        {
            a = token;
            b = android.support.v4.media.session.b.a.a((IBinder)token.a);
        }
    }


    private final a a;
    private final MediaSessionCompat.Token b;

    public android.support.v4.media.session.c(Context context, MediaSessionCompat mediasessioncompat)
    {
        if (mediasessioncompat == null)
        {
            throw new IllegalArgumentException("session must not be null");
        }
        b = mediasessioncompat.b();
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            a = new b(context, mediasessioncompat);
            return;
        } else
        {
            a = new c(b);
            return;
        }
    }
}
