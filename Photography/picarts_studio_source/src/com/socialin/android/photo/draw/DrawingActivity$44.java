// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatDialog;
import android.widget.Toast;
import com.socialin.android.brushlib.camera.CameraPreviewContainer;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a extends AsyncTask
{

    private boolean a;
    private DrawingActivity b;

    protected final Object doInBackground(Object aobj[])
    {
        return Boolean.valueOf(DrawingActivity.B(b).a());
    }

    protected final void onPostExecute(Object obj)
    {
        if (((Boolean)obj).booleanValue())
        {
            DrawingActivity.d(b, true);
            DrawingActivity.ag(b);
            DrawingActivity.a(b, eraPanelState.OPENED);
            DrawingActivity.b(b).setCameraDrawingOn(a);
        } else
        {
            DrawingActivity.ab(b);
            Toast.makeText(b, b.getString(0x7f08025e), 0).show();
        }
        DrawingActivity.t(b).dismiss();
    }

    eraPanelState(DrawingActivity drawingactivity, boolean flag)
    {
        b = drawingactivity;
        a = flag;
        super();
    }
}
