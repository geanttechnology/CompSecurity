// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ad, b, d

public abstract class ab
{

    private static final ab a = b();

    public ab()
    {
    }

    public static ab a()
    {
        return a;
    }

    private static ab b()
    {
        Object obj = Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(com/google/android/youtube/player/internal/ab);
        obj = (ab)((Class) (obj)).newInstance();
        return ((ab) (obj));
        Object obj1;
        obj1;
        try
        {
            throw new IllegalStateException(((Throwable) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return new ad();
        }
        obj1;
        throw new IllegalStateException(((Throwable) (obj1)));
    }

    public abstract YouTubeThumbnailLoader a(b b1, YouTubeThumbnailView youtubethumbnailview);

    public abstract b a(Context context, String s, t.a a1, t.b b1);

    public abstract d a(Activity activity, b b1);

}
