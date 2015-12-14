// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.b;

// Referenced classes of package com.google.android.youtube.player:
//            YouTubeInitializationResult

public final class YouTubeThumbnailView extends ImageView
{

    private b a;

    public YouTubeThumbnailView(Context context)
    {
        this(context, null);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static b a(YouTubeThumbnailView youtubethumbnailview)
    {
        return youtubethumbnailview.a;
    }

    static b b(YouTubeThumbnailView youtubethumbnailview)
    {
        youtubethumbnailview.a = null;
        return null;
    }

    public final void initialize(String s, OnInitializedListener oninitializedlistener)
    {
        com.google.android.youtube.player.internal.t.a a1 = new com.google.android.youtube.player.internal.t.a(oninitializedlistener) {

            final OnInitializedListener a;
            final YouTubeThumbnailView b;

            public final void a()
            {
                if (YouTubeThumbnailView.a(b) != null)
                {
                    YouTubeThumbnailView youtubethumbnailview = b;
                    YouTubeThumbnailLoader youtubethumbnailloader = ab.a().a(YouTubeThumbnailView.a(b), youtubethumbnailview);
                    a.onInitializationSuccess(youtubethumbnailview, youtubethumbnailloader);
                    com.google.android.youtube.player.YouTubeThumbnailView.b(b);
                }
            }

            public final void b()
            {
                com.google.android.youtube.player.YouTubeThumbnailView.b(b);
            }

            
            {
                b = YouTubeThumbnailView.this;
                a = oninitializedlistener;
                super();
            }

            private class OnInitializedListener
            {

                public abstract void onInitializationFailure(YouTubeThumbnailView youtubethumbnailview, YouTubeInitializationResult youtubeinitializationresult);

                public abstract void onInitializationSuccess(YouTubeThumbnailView youtubethumbnailview, YouTubeThumbnailLoader youtubethumbnailloader);
            }

        };
        oninitializedlistener = new com.google.android.youtube.player.internal.t.b(oninitializedlistener) {

            final OnInitializedListener a;
            final YouTubeThumbnailView b;

            public final void a(YouTubeInitializationResult youtubeinitializationresult)
            {
                a.onInitializationFailure(b, youtubeinitializationresult);
                com.google.android.youtube.player.YouTubeThumbnailView.b(b);
            }

            
            {
                b = YouTubeThumbnailView.this;
                a = oninitializedlistener;
                super();
            }
        };
        a = ab.a().a(getContext(), s, a1, oninitializedlistener);
        a.e();
    }
}
