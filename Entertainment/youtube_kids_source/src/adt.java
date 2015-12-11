// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class adt
    implements android.view.View.OnClickListener
{

    final ads this$0;
    final aei val$recording;

    adt(ads ads1, aei aei)
    {
        this$0 = ads1;
        val$recording = aei;
        super();
    }

    public final void onClick(View view)
    {
        view = ((View) (view.getTag(0x7f100017)));
        if (view != null && (view instanceof Integer))
        {
            int i = ((Integer)view).intValue();
            ads.access$002(ads.this, i);
            ads.this.notifyDataSetChanged();
        }
        ads.access$100(ads.this).playRecording(val$recording);
    }
}
