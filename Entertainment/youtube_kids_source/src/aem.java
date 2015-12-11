// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class aem
{

    private static final String TAG = aem.getSimpleName();
    private Activity activity;
    private Camera camera;
    private int cameraFacingDirection;
    private int cameraId;
    private ado cameraPreview;
    private boolean isFrontCameraAvailable;
    private MediaRecorder mediaRecorder;
    private boolean recording;
    private aei singAlongRecording;
    private String videoId;

    public aem(Activity activity1)
    {
        cameraFacingDirection = 1;
        getFirstAvailableCamera(cameraFacingDirection);
        if (camera == null)
        {
            cameraFacingDirection = 0;
            getFirstAvailableCamera(cameraFacingDirection);
            isFrontCameraAvailable = false;
        } else
        {
            isFrontCameraAvailable = true;
        }
        activity = activity1;
        cameraPreview = createCameraPreview();
        recording = false;
    }

    private ado createCameraPreview()
    {
        Object obj;
        if (!a.b())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        obj = TAG;
        obj = new ael(activity, camera, cameraId);
        return ((ado) (obj));
        Exception exception;
        exception;
        String s = TAG;
        return new adq(activity, camera, cameraId);
    }

    private void getFirstAvailableCamera(int i)
    {
        ArrayList arraylist;
        int j;
        boolean flag = false;
        arraylist = new ArrayList();
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        int k = 0;
        do
        {
            j = ((flag) ? 1 : 0);
            if (k >= Camera.getNumberOfCameras())
            {
                break;
            }
            Camera.getCameraInfo(k, camerainfo);
            if (camerainfo.facing == i)
            {
                arraylist.add(Integer.valueOf(k));
            }
            k++;
        } while (true);
          goto _L1
_L3:
        j++;
_L1:
        if (j >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((Integer)arraylist.get(j)).intValue();
        try
        {
            camera = Camera.open(i);
        }
        catch (RuntimeException runtimeexception)
        {
            Log.e(TAG, "Unable to open camera, in use by another process or disabled.");
        }
        if (camera == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        cameraId = i;
        break; /* Loop/switch isn't completed */
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void prepareRecorder()
    {
        mediaRecorder = new MediaRecorder();
        camera.unlock();
        mediaRecorder.setCamera(camera);
        mediaRecorder.setAudioSource(5);
        mediaRecorder.setVideoSource(1);
        CamcorderProfile camcorderprofile;
        if (CamcorderProfile.hasProfile(cameraId, 4))
        {
            camcorderprofile = CamcorderProfile.get(cameraId, 4);
        } else
        {
            camcorderprofile = CamcorderProfile.get(cameraId, 0);
        }
        mediaRecorder.setProfile(camcorderprofile);
        mediaRecorder.setOutputFile(singAlongRecording.getRecordingPath());
        mediaRecorder.setOrientationHint(cameraPreview.getCameraOrientation());
        try
        {
            mediaRecorder.prepare();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e(TAG, "Prepare called after the recorder has been started.");
            return;
        }
        catch (IOException ioexception)
        {
            Log.e(TAG, "Failure preparing video recorder.");
        }
    }

    private void releaseCamera()
    {
        if (camera != null)
        {
            camera.stopPreview();
            cameraPreview.setCamera(null, 0);
            camera.release();
            camera = null;
            cameraId = 0;
        }
    }

    public void deleteRecording()
    {
        if (singAlongRecording != null)
        {
            singAlongRecording.deleteOutputFiles();
            singAlongRecording = null;
        }
    }

    public void flipCamera()
    {
        int i = 1;
        if (isFrontCameraAvailable)
        {
            releaseCamera();
            if (cameraFacingDirection == 1)
            {
                i = 0;
            }
            cameraFacingDirection = i;
            getFirstAvailableCamera(cameraFacingDirection);
            cameraPreview.setCamera(camera, cameraId);
        }
    }

    public View getCameraPreview()
    {
        return cameraPreview.getPreviewView();
    }

    public aei getSingAlongRecording()
    {
        return singAlongRecording;
    }

    public boolean hasValidRecording()
    {
        return singAlongRecording != null && singAlongRecording.isValidRecording();
    }

    public void onActivityPause()
    {
        if (recording)
        {
            stopRecording();
        }
        releaseCamera();
    }

    public void onActivityResume()
    {
        if (camera == null)
        {
            getFirstAvailableCamera(cameraFacingDirection);
        }
        cameraPreview.setCamera(camera, cameraId);
    }

    public void setVideoId(String s)
    {
        videoId = s;
    }

    public void startRecording()
    {
        if (!recording)
        {
            singAlongRecording = new aei(videoId, new Date(), activity.getApplicationContext().getExternalFilesDir(null));
            prepareRecorder();
            mediaRecorder.start();
            recording = true;
        }
    }

    public void stopRecording()
    {
        if (recording)
        {
            try
            {
                mediaRecorder.stop();
            }
            catch (RuntimeException runtimeexception)
            {
                deleteRecording();
                Log.e(TAG, "Stopped recording too quickly after start.");
            }
            recording = false;
            mediaRecorder.reset();
            mediaRecorder.release();
            camera.lock();
        }
    }

}
