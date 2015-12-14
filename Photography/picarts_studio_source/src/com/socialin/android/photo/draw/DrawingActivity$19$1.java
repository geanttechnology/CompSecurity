// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.socialin.android.brushlib.project.Project;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.dialog.CancelDialogActivity;
import com.socialin.android.videogenerator.ActionCollector;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private boolean a;
    private b b;

    public final void run()
    {
        b.b.a();
        DrawingActivity.M(b.b);
        if (!a)
        {
            DrawingActivity.e(b.b);
        }
    }

    stCode(stCode stcode, boolean flag)
    {
        b = stcode;
        a = flag;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$19

/* anonymous class */
    final class DrawingActivity._cls19
        implements android.view.View.OnClickListener
    {

        final DrawingActivity a;

        public final void onClick(View view)
        {
label0:
            {
                view = a.getSharedPreferences("socialin", 0);
                if (ActionCollector.a().b() == 2 || view.getBoolean("dontShowDialogAgain", false))
                {
                    DrawingActivity.K(a);
                    if (DrawingActivity.L(a))
                    {
                        boolean flag = DrawingActivity.c(a);
                        DrawingActivity.d(a);
                        com.socialin.android.photo.draw.DrawingActivity.a(a, new DrawingActivity._cls19._cls1(this, flag));
                    } else
                    {
                        a.a();
                        DrawingActivity.M(a);
                    }
                }
                if (!DrawingActivity.N(a))
                {
                    view = new Intent(a, com/socialin/android/dialog/CancelDialogActivity);
                    view.putExtra("showSaveProject", DrawingActivity.b(a).c.k.isDraft());
                    view.putExtra("showExport", false);
                    view.putExtra("showTitle", true);
                    view.putExtra("showEdit", false);
                    view.putExtra("drawingActivityActionDone", true);
                    view.putExtra("showCheckbox", true);
                    if (a.a)
                    {
                        view.putExtra("showExportVideo", true);
                        view.putExtra("showExportGif", true);
                    }
                    if (DrawingActivity.b(a).c.k.isDraft() || a.a)
                    {
                        break label0;
                    }
                    a.a();
                    DrawingActivity.M(a);
                }
                return;
            }
            a.startActivityForResult(view, DrawingActivity.RequestCode.CANCEL_CONFIRM.toInt());
        }

            
            {
                a = drawingactivity;
                super();
            }
    }

}
