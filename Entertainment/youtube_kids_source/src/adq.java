// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import java.io.IOException;

public class adq extends ado
    implements android.view.TextureView.SurfaceTextureListener
{

    private static final String TAG = adq.getSimpleName();

    public adq(Context context, Camera camera, int i)
    {
        super(context, camera, i);
    }

    protected View createPreviewView(Context context)
    {
        context = new TextureView(context);
        context.setSurfaceTextureListener(this);
        return context;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        Camera camera;
        camera = getCamera();
        if (camera == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        onPreviewCreated();
        camera.setPreviewTexture(surfacetexture);
        camera.startPreview();
        return;
        surfacetexture;
        Log.e(TAG, "Error setting preview texture.");
        return;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        onPreviewDestroyed();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    protected void startPreview()
    {
        Camera camera;
        camera = getCamera();
        if (camera == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        camera.setPreviewTexture(((TextureView)getPreviewView()).getSurfaceTexture());
        camera.startPreview();
        return;
        IOException ioexception;
        ioexception;
        Log.e(TAG, "Error setting camera preview texture.");
        return;
    }

}
