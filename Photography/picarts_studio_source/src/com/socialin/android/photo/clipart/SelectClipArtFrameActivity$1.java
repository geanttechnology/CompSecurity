// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import com.socialin.android.photo.textart.TextPreview;

// Referenced classes of package com.socialin.android.photo.clipart:
//            SelectClipArtFrameActivity

final class b
    implements Runnable
{

    private TextPreview a;
    private String b;

    public final void run()
    {
        a.append(b);
    }

    (TextPreview textpreview, String s)
    {
        a = textpreview;
        b = s;
        super();
    }
}
