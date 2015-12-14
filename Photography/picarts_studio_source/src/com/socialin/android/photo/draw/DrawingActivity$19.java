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
    implements android.view.r
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
                    com.socialin.android.photo.draw.DrawingActivity.a(a, new Runnable(flag) {

                        private boolean a;
                        private DrawingActivity._cls19 b;

                        public final void run()
                        {
                            b.a.a();
                            DrawingActivity.M(b.a);
                            if (!a)
                            {
                                DrawingActivity.e(b.a);
                            }
                        }

            
            {
                b = DrawingActivity._cls19.this;
                a = flag;
                super();
            }
                    });
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
        a.startActivityForResult(view, uestCode.CANCEL_CONFIRM.toInt());
    }

    _cls1.a(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
