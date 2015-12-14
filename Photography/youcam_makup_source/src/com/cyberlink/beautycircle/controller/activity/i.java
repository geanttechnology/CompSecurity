// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.cyberlink.beautycircle.g;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostCommentActivity

class i extends ClickableSpan
{

    String c;
    final PostCommentActivity d;

    public i(PostCommentActivity postcommentactivity, String s)
    {
        d = postcommentactivity;
        super();
        c = s;
    }

    public void onClick(View view)
    {
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(d.getResources().getColor(g.bc_color_main_style_hightlight));
        textpaint.setUnderlineText(false);
    }
}
