// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.support.v4.f.a;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat, PlaybackStateCompat, h, g

static final class a
    implements a
{

    private final Object a;
    private final ken b;
    private PendingIntent c;

    public final void a()
    {
        ((MediaSession)a).setActive(true);
    }

    public final void a(int i)
    {
        ((MediaSession)a).setFlags(i);
    }

    public final void a(PendingIntent pendingintent)
    {
        c = pendingintent;
        ((MediaSession)a).setMediaButtonReceiver(pendingintent);
    }

    public final void a(MediaMetadataCompat mediametadatacompat)
    {
        Object obj1 = a;
        if (mediametadatacompat.c == null && android.os. >= 21) goto _L2; else goto _L1
_L1:
        mediametadatacompat = ((MediaMetadataCompat) (mediametadatacompat.c));
_L26:
        ((MediaSession)obj1).setMetadata((MediaMetadata)mediametadatacompat);
        return;
_L2:
        android.media. ;
        Iterator iterator;
         = new android.media.();
        iterator = mediametadatacompat.b.keySet().iterator();
_L24:
        Object obj;
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        obj = (Integer)MediaMetadataCompat.a.get(s);
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((Integer) (obj)).intValue();
        JVM INSTR tableswitch 0 3: default 136
    //                   0 139
    //                   1 487
    //                   2 163
    //                   3 185;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        long l = mediametadatacompat.a(s);
        ((android.media.)).putLong(s, l);
        break; /* Loop/switch isn't completed */
_L6:
        obj = mediametadatacompat.c(s);
        ((android.media.)).putBitmap(s, ((android.graphics.Bitmap) (obj)));
        break; /* Loop/switch isn't completed */
_L7:
        obj = mediametadatacompat.b(s);
        if (((RatingCompat) (obj)).c == null && android.os. >= 21) goto _L9; else goto _L8
_L8:
        obj = ((RatingCompat) (obj)).c;
_L17:
        ((android.media.)).putRating(s, (Rating)obj);
        break; /* Loop/switch isn't completed */
_L9:
        if (!((RatingCompat) (obj)).a()) goto _L11; else goto _L10
_L10:
        ((RatingCompat) (obj)).a;
        JVM INSTR tableswitch 1 6: default 280
    //                   1 285
    //                   2 328
    //                   3 366
    //                   4 366
    //                   5 366
    //                   6 435;
           goto _L12 _L13 _L14 _L15 _L15 _L15 _L16
_L12:
        obj = null;
          goto _L17
_L13:
        boolean flag;
        if (((RatingCompat) (obj)).a == 1 && ((RatingCompat) (obj)).b == 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.c = Rating.newHeartRating(flag);
_L18:
        obj = ((RatingCompat) (obj)).c;
          goto _L17
_L14:
        boolean flag1;
        if (((RatingCompat) (obj)).a == 2 && ((RatingCompat) (obj)).b == 1.0F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj.c = Rating.newThumbRating(flag1);
          goto _L18
_L15:
        int i = ((RatingCompat) (obj)).a;
        ((RatingCompat) (obj)).a;
        JVM INSTR tableswitch 3 5: default 404
    //                   3 420
    //                   4 420
    //                   5 420;
           goto _L19 _L20 _L20 _L20
_L19:
        float f = -1F;
_L22:
        obj.c = Rating.newStarRating(i, f);
          goto _L18
_L20:
        if (!((RatingCompat) (obj)).a()) goto _L19; else goto _L21
_L21:
        f = ((RatingCompat) (obj)).b;
          goto _L22
_L16:
        float f1;
        if (((RatingCompat) (obj)).a != 6 || !((RatingCompat) (obj)).a())
        {
            f1 = -1F;
        } else
        {
            f1 = ((RatingCompat) (obj)).b;
        }
        obj.c = Rating.newPercentageRating(f1);
          goto _L12
_L11:
        obj.c = Rating.newUnratedRating(((RatingCompat) (obj)).a);
          goto _L18
_L5:
        CharSequence charsequence = mediametadatacompat.b.getCharSequence(s);
        ((android.media.)).putText(s, charsequence);
        if (true) goto _L24; else goto _L23
_L23:
        mediametadatacompat.c = ((android.media.)).build();
        mediametadatacompat = ((MediaMetadataCompat) (mediametadatacompat.c));
        if (true) goto _L26; else goto _L25
_L25:
    }

    public final void a(PlaybackStateCompat playbackstatecompat)
    {
        Object obj1 = a;
        if (playbackstatecompat.k != null || android.os. < 21)
        {
            playbackstatecompat = ((PlaybackStateCompat) (playbackstatecompat.k));
        } else
        {
            Object obj = null;
            if (playbackstatecompat.h != null)
            {
                ArrayList arraylist = new ArrayList(playbackstatecompat.h.size());
                Iterator iterator = playbackstatecompat.h.iterator();
                do
                {
                    obj = arraylist;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    obj = (ustomAction)iterator.next();
                    if (((ustomAction) (obj)).e != null || android.os. < 21)
                    {
                        obj = ((ustomAction) (obj)).e;
                    } else
                    {
                        Object obj2 = ((ustomAction) (obj)).a;
                        CharSequence charsequence = ((ustomAction) (obj)).b;
                        int i = ((ustomAction) (obj)).c;
                        Bundle bundle = ((ustomAction) (obj)).d;
                        obj2 = new android.media.session.ction.Builder(((String) (obj2)), charsequence, i);
                        ((android.media.session.ction.Builder) (obj2)).setExtras(bundle);
                        obj.e = ((android.media.session.ction.Builder) (obj2)).build();
                        obj = ((ustomAction) (obj)).e;
                    }
                    arraylist.add(obj);
                } while (true);
            }
            if (android.os. >= 22)
            {
                playbackstatecompat.k = android.support.v4.media.session.h.a(playbackstatecompat.a, playbackstatecompat.b, playbackstatecompat.c, playbackstatecompat.d, playbackstatecompat.e, playbackstatecompat.f, playbackstatecompat.g, ((List) (obj)), playbackstatecompat.i, playbackstatecompat.j);
            } else
            {
                playbackstatecompat.k = android.support.v4.media.session.g.a(playbackstatecompat.a, playbackstatecompat.b, playbackstatecompat.c, playbackstatecompat.d, playbackstatecompat.e, playbackstatecompat.f, playbackstatecompat.g, ((List) (obj)), playbackstatecompat.i);
            }
            playbackstatecompat = ((PlaybackStateCompat) (playbackstatecompat.k));
        }
        ((MediaSession)obj1).setPlaybackState((PlaybackState)playbackstatecompat);
    }

    public final ken b()
    {
        return b;
    }

    public ken(Context context, String s)
    {
        a = new MediaSession(context, s);
        b = new ken(((MediaSession)a).getSessionToken());
    }
}
