// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.groupon.fragment:
//            PoGCoachmarkDialog

class val.resources extends ClickableSpan
{

    final PoGCoachmarkDialog this$0;
    final Resources val$resources;

    public void onClick(View view)
    {
        view = new PoGCoachmarkDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("type", alogType.DOLLAR);
        view.setArguments(bundle);
        view.setCancelable(false);
        view.show(getFragmentManager(), alogType.DOLLAR.toString());
        dismiss();
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(val$resources.getColor(0x7f0e00b9));
        textpaint.setUnderlineText(false);
    }

    alogType()
    {
        this$0 = final_pogcoachmarkdialog;
        val$resources = Resources.this;
        super();
    }
}
