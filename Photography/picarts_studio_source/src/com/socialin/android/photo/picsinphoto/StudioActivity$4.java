// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.content.Intent;
import com.picsart.studio.editor.activity.EditorActivity;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            StudioActivity

final class e
    implements Runnable
{

    private String a;
    private int b;
    private HashMap c;
    private String d;
    private boolean e;
    private StudioActivity f;

    public final void run()
    {
        Intent intent = new Intent(f, com/picsart/studio/editor/activity/EditorActivity);
        intent.putExtra("path", a);
        intent.putExtra("degree", b);
        intent.putExtra("bufferData", c);
        intent.putExtra("origin", d);
        if (e)
        {
            intent.setAction("action.photo.for.collage");
        }
        f.startActivityForResult(intent, 0);
        f.finish();
    }

    (StudioActivity studioactivity, String s, int i, HashMap hashmap, String s1, boolean flag)
    {
        f = studioactivity;
        a = s;
        b = i;
        c = hashmap;
        d = s1;
        e = flag;
        super();
    }
}
