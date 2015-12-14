// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.d;
import com.socialin.android.dialog.i;
import java.util.List;

// Referenced classes of package com.picsart.studio:
//            DrawingGalleryActivity, c

final class a extends i
{

    final Project a;
    final DrawingGalleryActivity b;

    public final String a()
    {
        if (a.isDraft())
        {
            return "";
        } else
        {
            return a.getDisplayName();
        }
    }

    public final void a(String s)
    {
        (new AsyncTask(s) {

            private String a;
            private DrawingGalleryActivity._cls5 b;

            private transient Void a()
            {
                try
                {
                    Project project = com.socialin.android.brushlib.project.a.a(b.a, a);
                    DrawingGalleryActivity.h(b.b).add(DrawingGalleryActivity.h(b.b).indexOf(b.a), project);
                }
                catch (Exception exception)
                {
                    d.b(com.picsart.studio.DrawingGalleryActivity.a(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                    });
                    cancel(false);
                }
                return null;
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onCancelled(Object obj)
            {
                Toast.makeText(b.b, 0x7f08009a, 0).show();
            }

            protected final void onPostExecute(Object obj)
            {
                Toast.makeText(b.b, 0x7f080127, 0).show();
                com.picsart.studio.DrawingGalleryActivity.d(b.b).notifyDataSetChanged();
            }

            
            {
                b = DrawingGalleryActivity._cls5.this;
                a = s;
                super();
            }
        }).execute(new Void[0]);
    }

    t(DrawingGalleryActivity drawinggalleryactivity, Context context, Project project)
    {
        b = drawinggalleryactivity;
        a = project;
        super(context);
    }
}
