// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.io.IOException;

public class ael extends ado
    implements android.view.SurfaceHolder.Callback
{

    private static final String TAG = ael.getSimpleName();

    public ael(Context context, Camera camera, int i)
    {
        super(context, camera, i);
    }

    protected View createPreviewView(Context context)
    {
        context = new SurfaceView(context);
        context.getHolder().addCallback(this);
        return context;
    }

    protected void startPreview()
    {
        Camera camera;
        camera = getCamera();
        if (camera == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        camera.setPreviewDisplay(((SurfaceView)getPreviewView()).getHolder());
        camera.startPreview();
        return;
        IOException ioexception;
        ioexception;
        Log.e(TAG, "Error setting preview surface.");
        return;
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Camera camera;
        camera = getCamera();
        if (camera == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        onPreviewCreated();
        camera.setPreviewDisplay(surfaceholder);
        camera.startPreview();
        return;
        surfaceholder;
        Log.e(TAG, "Error setting preview surface.");
        return;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        onPreviewDestroyed();
    }

}
