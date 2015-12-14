// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.fragment.i;
import com.picsart.studio.editor.history.EditorAction;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.activity:
//            StandaloneCropToolActivity

final class a
    implements c
{

    private StandaloneCropToolActivity a;

    public final void a(i i)
    {
        a.a();
    }

    public final void a(i i, Bitmap bitmap, EditorAction editoraction)
    {
        i = a;
        if (!FileUtils.a())
        {
            Utils.c(i, i.getString(0x7f080479));
            return;
        } else
        {
            bitmap = w.a(((StandaloneCropToolActivity) (i)).a, ((StandaloneCropToolActivity) (i)).b, bitmap, i);
            editoraction = new Intent();
            editoraction.putExtra("hasChanges", true);
            editoraction.putExtra("bufferData", bitmap);
            i.setResult(-1, editoraction);
            i.finish();
            return;
        }
    }

    (StandaloneCropToolActivity standalonecroptoolactivity)
    {
        a = standalonecroptoolactivity;
        super();
    }
}
