// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.post;

import com.shazam.android.ad.e;
import com.shazam.l.n.a;

// Referenced classes of package com.shazam.android.activities.post:
//            PostEditorActivity

private final class <init> extends e
{

    final PostEditorActivity a;

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        com.shazam.android.activities.post.PostEditorActivity.a(a).g = charsequence.toString();
    }

    private (PostEditorActivity posteditoractivity)
    {
        a = posteditoractivity;
        super();
    }

    a(PostEditorActivity posteditoractivity, byte byte0)
    {
        this(posteditoractivity);
    }
}
