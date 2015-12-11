// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.CameraPreviewSurfaceView;
import com.poshmark.ui.customviews.CameraViewportRectView;
import com.poshmark.utils.ImageUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, CameraFiltersFragment, GestureTester

public class CameraPreviewFragment extends PMFragment
{
    class PMCameraInfo
    {

        int cameraId;
        android.hardware.Camera.CameraInfo info;
        final CameraPreviewFragment this$0;

        PMCameraInfo(int i, android.hardware.Camera.CameraInfo camerainfo)
        {
            this$0 = CameraPreviewFragment.this;
            super();
            cameraId = i;
            info = camerainfo;
        }
    }

    static final class STATE extends Enum
    {

        private static final STATE $VALUES[];
        public static final STATE INIT;
        public static final STATE PICK_IMAGE_NO_CAMERA_PRESENT;

        public static STATE valueOf(String s)
        {
            return (STATE)Enum.valueOf(com/poshmark/ui/fragments/CameraPreviewFragment$STATE, s);
        }

        public static STATE[] values()
        {
            return (STATE[])$VALUES.clone();
        }

        static 
        {
            INIT = new STATE("INIT", 0);
            PICK_IMAGE_NO_CAMERA_PRESENT = new STATE("PICK_IMAGE_NO_CAMERA_PRESENT", 1);
            $VALUES = (new STATE[] {
                INIT, PICK_IMAGE_NO_CAMERA_PRESENT
            });
        }

        private STATE(String s, int i)
        {
            super(s, i);
        }
    }


    public static int CREATE_COVERSHOT = 1;
    public static int CREATE_THUMBNAIL = 0;
    int BACK_CAMERA;
    int CREATION_MODE;
    int CROP_IMAGE;
    int FILTER_IMAGE;
    int FRONT_CAMERA;
    int PICK_IMAGE;
    int PICK_IMAGE_NO_CAMERA_PRESENT;
    boolean bIsFirstCovershot;
    Map cameraList;
    String currentFlashMode;
    PMCameraInfo currentSelectedCamera;
    RelativeLayout loadingBitmapProgressBarLayout;
    android.hardware.Camera.AutoFocusCallback mAutoFocusCallback;
    Camera mCamera;
    private android.hardware.Camera.PictureCallback pictureCallback;
    boolean pictureTaken;
    CameraPreviewSurfaceView preview;
    int screenHeight;
    int screenWidth;
    STATE state;
    private android.view.SurfaceHolder.Callback surfaceCallback;
    SurfaceHolder surfaceHolder;
    CameraViewportRectView viewportOverlay;

    public CameraPreviewFragment()
    {
        PICK_IMAGE = 2;
        CROP_IMAGE = 3;
        FILTER_IMAGE = 4;
        PICK_IMAGE_NO_CAMERA_PRESENT = 5;
        state = STATE.INIT;
        FRONT_CAMERA = 1;
        BACK_CAMERA = 0;
        cameraList = new HashMap();
        currentFlashMode = "off";
        CREATION_MODE = CREATE_THUMBNAIL;
        bIsFirstCovershot = false;
        pictureTaken = false;
        mAutoFocusCallback = new android.hardware.Camera.AutoFocusCallback() {

            final CameraPreviewFragment this$0;

            public void onAutoFocus(boolean flag, Camera camera)
            {
                mCamera.takePicture(null, null, pictureCallback);
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        };
        surfaceCallback = new android.view.SurfaceHolder.Callback() {

            final CameraPreviewFragment this$0;

            public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
            {
                if (mCamera != null)
                {
                    setupCameraPreviewDisplay(surfaceholder);
                    mCamera.startPreview();
                }
            }

            public void surfaceCreated(SurfaceHolder surfaceholder)
            {
                setupButtonHandlers();
            }

            public void surfaceDestroyed(SurfaceHolder surfaceholder)
            {
                releaseCamera();
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        };
        pictureCallback = new android.hardware.Camera.PictureCallback() {

            final CameraPreviewFragment this$0;

            private Rect getClipRect(int i, int j)
            {
                Rect rect = new Rect();
                int k = preview.getSurfaceViewHeight();
                int l = preview.getSurfaceViewWidth();
                getActivity().getWindowManager().getDefaultDisplay().getWidth();
                getActivity().getWindowManager().getDefaultDisplay().getHeight();
                int i1 = viewportOverlay.getViewPortTop();
                int j1 = viewportOverlay.getViewportLeft();
                int k1 = k - (viewportOverlay.getViewPortTop() + viewportOverlay.getViewportHeight());
                int l1 = l - (viewportOverlay.getViewportLeft() + viewportOverlay.getViewportWidth());
                float f;
                float f1;
                float f2;
                float f3;
                if (i <= j)
                {
                    f2 = (float)viewportOverlay.getViewportWidth() / (float)l;
                    f3 = (float)viewportOverlay.getViewportHeight() / (float)k;
                    if (currentSelectedCamera.info.orientation == 180)
                    {
                        f = Math.abs((float)l1 / (float)l);
                        f1 = Math.abs((float)k1 / (float)k);
                    } else
                    {
                        f = Math.abs((float)j1 / (float)l);
                        f1 = Math.abs((float)i1 / (float)k);
                    }
                } else
                {
                    f3 = (float)viewportOverlay.getViewportWidth() / (float)l;
                    f2 = (float)viewportOverlay.getViewportHeight() / (float)k;
                    if (currentSelectedCamera.info.orientation == 90)
                    {
                        f = Math.abs((float)i1 / (float)k);
                        f1 = Math.abs((float)l1 / (float)l);
                    } else
                    {
                        f = Math.abs((float)k1 / (float)k);
                        f1 = Math.abs((float)j1 / (float)l);
                    }
                }
                rect.left = (int)((float)i * f);
                rect.top = (int)((float)j * f1);
                rect.right = (int)((float)i * f2);
                rect.bottom = (int)((float)j * f3);
                return rect;
            }

            public void onPictureTaken(byte abyte0[], Camera camera)
            {
                Object obj;
                camera = new android.graphics.BitmapFactory.Options();
                camera.inJustDecodeBounds = true;
                BitmapFactoryInstrumentation.decodeByteArray(abyte0, 0, abyte0.length, camera);
                int i = ((android.graphics.BitmapFactory.Options) (camera)).outHeight;
                camera = getClipRect(((android.graphics.BitmapFactory.Options) (camera)).outWidth, i);
                obj = new Matrix();
                if (CREATION_MODE != CameraPreviewFragment.CREATE_THUMBNAIL) goto _L2; else goto _L1
_L1:
                ((Matrix) (obj)).postScale(100F / (float)((Rect) (camera)).right, 100F / (float)((Rect) (camera)).bottom);
_L11:
                if (currentSelectedCamera.cameraId != FRONT_CAMERA) goto _L4; else goto _L3
_L3:
                ((Matrix) (obj)).postRotate(360 - currentSelectedCamera.info.orientation);
                ((Matrix) (obj)).postScale(1.0F, -1F);
_L9:
                android.graphics.BitmapFactory.Options options;
                options = new android.graphics.BitmapFactory.Options();
                options.inMutable = true;
                abyte0 = BitmapRegionDecoder.newInstance(abyte0, 0, abyte0.length, false);
                if (abyte0 == null) goto _L6; else goto _L5
_L5:
                try
                {
                    Rect rect = new Rect(camera);
                    rect.right = ((Rect) (camera)).left + ((Rect) (camera)).right;
                    rect.bottom = ((Rect) (camera)).top + ((Rect) (camera)).bottom;
                    abyte0 = abyte0.decodeRegion(rect, options);
                    obj = Bitmap.createBitmap(abyte0, 0, 0, ((Rect) (camera)).right, ((Rect) (camera)).bottom, ((Matrix) (obj)), true);
                    camera = ImageUtils.saveBitmapToDisk(((Bitmap) (obj)));
                    abyte0.recycle();
                    ((Bitmap) (obj)).recycle();
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    finishActivityWithResult(0, null);
                    return;
                }
                if (camera == null) goto _L6; else goto _L7
_L7:
                if (CREATION_MODE == CameraPreviewFragment.CREATE_COVERSHOT && bIsFirstCovershot)
                {
                    fireCameraFiltersActivity(camera);
                    return;
                }
                  goto _L8
_L2:
                if (CREATION_MODE == CameraPreviewFragment.CREATE_COVERSHOT)
                {
                    ((Matrix) (obj)).postScale(1024F / (float)((Rect) (camera)).right, 1024F / (float)((Rect) (camera)).bottom);
                }
                continue; /* Loop/switch isn't completed */
_L4:
                ((Matrix) (obj)).postRotate(currentSelectedCamera.info.orientation);
                  goto _L9
_L8:
                abyte0 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("IMAGE_FILE_URI", camera);
                abyte0.putExtras(bundle);
                finishActivityWithResult(-1, abyte0);
_L6:
                return;
                if (true) goto _L11; else goto _L10
_L10:
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        };
    }

    private Bitmap doBitmapTransformations(Bitmap bitmap, Rect rect, Matrix matrix, boolean flag)
    {
        Canvas canvas;
        RectF rectf;
        android.graphics.Bitmap.Config config;
        int i = rect.right;
        i = rect.bottom;
        canvas = new Canvas();
        new Rect(0, 0, rect.right, rect.bottom);
        rectf = new RectF(0.0F, 0.0F, rect.right, rect.bottom);
        rect = android.graphics.Bitmap.Config.ARGB_8888;
        config = bitmap.getConfig();
        if (config == null) goto _L2; else goto _L1
_L1:
        static class _cls9
        {

            static final int $SwitchMap$android$graphics$Bitmap$Config[];
            static final int $SwitchMap$com$poshmark$ui$fragments$CameraPreviewFragment$STATE[];

            static 
            {
                $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Bitmap.Config.values().length];
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$poshmark$ui$fragments$CameraPreviewFragment$STATE = new int[STATE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CameraPreviewFragment$STATE[STATE.INIT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls9..SwitchMap.android.graphics.Bitmap.Config[config.ordinal()];
        JVM INSTR tableswitch 1 2: default 108
    //                   1 243
    //                   2 250;
           goto _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_250;
_L3:
        rect = android.graphics.Bitmap.Config.ARGB_8888;
_L2:
        RectF rectf1;
        boolean flag1;
        int j;
        int k;
        if (!matrix.rectStaysRect())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        rectf1 = new RectF();
        matrix.mapRect(rectf1, rectf);
        j = Math.round(rectf1.width());
        k = Math.round(rectf1.height());
        if (flag1)
        {
            rect = android.graphics.Bitmap.Config.ARGB_8888;
        }
        Bitmap.createBitmap(j, k, rect);
        canvas.translate(-rectf1.left, -rectf1.top);
        canvas.concat(matrix);
        rect = new Paint();
        rect.setFilterBitmap(flag);
        if (flag1)
        {
            rect.setAntiAlias(true);
        }
        canvas.setBitmap(bitmap);
        canvas.drawBitmap(bitmap, null, rectf, rect);
        return bitmap;
_L4:
        rect = android.graphics.Bitmap.Config.RGB_565;
          goto _L2
        rect = android.graphics.Bitmap.Config.ALPHA_8;
          goto _L2
    }

    private void fireCameraFiltersActivity(Uri uri)
    {
        Intent intent = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/CameraFiltersFragment);
        Bundle bundle = new Bundle();
        bundle.putParcelable("FILE", uri);
        intent.putExtra("FRAGMENT_DATA", bundle);
        startActivityForResult(intent, FILTER_IMAGE);
    }

    private android.hardware.Camera.Size getBestPictureSize(android.hardware.Camera.Parameters parameters, android.hardware.Camera.Size size)
    {
        Object obj = null;
        int i = 0x7fffffff;
        int k = size.height;
        int l = size.width;
        Iterator iterator = parameters.getSupportedPictureSizes().iterator();
        parameters = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            size = (android.hardware.Camera.Size)iterator.next();
            int j = Math.abs(k * l - size.height * size.width);
            if (j <= i)
            {
                parameters = size;
                i = j;
            }
        } while (true);
        return parameters;
    }

    private android.hardware.Camera.Size getBestPreviewSize(int i, int j, android.hardware.Camera.Parameters parameters)
    {
        android.hardware.Camera.Size size2;
        size2 = null;
        Iterator iterator = parameters.getSupportedPreviewSizes().iterator();
        do
        {
label0:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)iterator.next();
                Iterator iterator1 = parameters.getSupportedPictureSizes().iterator();
                android.hardware.Camera.Size size = size2;
                do
                {
                    size2 = size;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    size2 = (android.hardware.Camera.Size)iterator1.next();
                    if (size2.width == size1.width && size2.height == size1.height)
                    {
                        if (size == null)
                        {
                            size = size1;
                        } else
                        if (size.height < size1.height || size.width < size1.width)
                        {
                            size = size1;
                        }
                    }
                } while (true);
            }
        } while (true);
        return size2;
    }

    private android.hardware.Camera.Size getBestPreviewSizeII(int i, int j, android.hardware.Camera.Parameters parameters)
    {
        Object obj = null;
        Iterator iterator = parameters.getSupportedPreviewSizes().iterator();
        parameters = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            android.hardware.Camera.Size size = (android.hardware.Camera.Size)iterator.next();
            if (size.width <= i && size.height <= j)
            {
                if (parameters == null)
                {
                    parameters = size;
                } else
                {
                    int k = ((android.hardware.Camera.Size) (parameters)).width;
                    int l = ((android.hardware.Camera.Size) (parameters)).height;
                    if (size.width * size.height > k * l)
                    {
                        parameters = size;
                    }
                }
            }
        } while (true);
        return parameters;
    }

    private void getBitmapFromPickerAction(Intent intent, Uri uri)
    {
        Object obj;
        loadingBitmapProgressBarLayout.setVisibility(0);
        obj = null;
        intent = obj;
        if (uri == null) goto _L2; else goto _L1
_L1:
        if (!uri.toString().startsWith("file:")) goto _L4; else goto _L3
_L3:
        intent = uri.getPath();
_L2:
        if (intent != null && !intent.startsWith("http"))
        {
            cropImage(intent);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        intent = obj;
        if (cursor != null)
        {
            intent = obj;
            if (cursor.moveToFirst())
            {
                int i = cursor.getColumnIndex("_data");
                intent = obj;
                if (i != -1)
                {
                    intent = cursor.getString(i);
                }
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        intent = new com.poshmark.utils.ImageUtils.BitmapDownloader(this);
        Uri auri[] = new Uri[1];
        auri[0] = uri;
        if (!(intent instanceof AsyncTask))
        {
            intent.execute(auri);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)intent, auri);
            return;
        }
    }

    private android.hardware.Camera.Size getLargestPictureSize(android.hardware.Camera.Parameters parameters)
    {
        Object obj = null;
        Iterator iterator = parameters.getSupportedPictureSizes().iterator();
        parameters = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            android.hardware.Camera.Size size = (android.hardware.Camera.Size)iterator.next();
            if (parameters == null)
            {
                parameters = size;
            } else
            {
                int i = ((android.hardware.Camera.Size) (parameters)).width;
                int j = ((android.hardware.Camera.Size) (parameters)).height;
                if (size.width * size.height > i * j)
                {
                    parameters = size;
                }
            }
        } while (true);
        return parameters;
    }

    private android.hardware.Camera.Size getSmallestPictureSize(android.hardware.Camera.Parameters parameters)
    {
        Object obj = null;
        Iterator iterator = parameters.getSupportedPictureSizes().iterator();
        parameters = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            android.hardware.Camera.Size size = (android.hardware.Camera.Size)iterator.next();
            if (parameters == null)
            {
                parameters = size;
            } else
            {
                int i = ((android.hardware.Camera.Size) (parameters)).width;
                int j = ((android.hardware.Camera.Size) (parameters)).height;
                if (size.width * size.height < i * j)
                {
                    parameters = size;
                }
            }
        } while (true);
        return parameters;
    }

    private void releaseCamera()
    {
        if (mCamera != null)
        {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    private void setupButtonHandlers()
    {
        Object obj = getView();
        ImageButton imagebutton = (ImageButton)((View) (obj)).findViewById(0x7f0c0095);
        ImageButton imagebutton1 = (ImageButton)((View) (obj)).findViewById(0x7f0c0094);
        ImageButton imagebutton2 = (ImageButton)((View) (obj)).findViewById(0x7f0c0093);
        ImageButton imagebutton3 = (ImageButton)((View) (obj)).findViewById(0x7f0c0092);
        if (cameraList.size() > 1)
        {
            imagebutton3.setVisibility(0);
        } else
        {
            imagebutton3.setVisibility(4);
        }
        obj = (Button)((View) (obj)).findViewById(0x7f0c0091);
        if (currentSelectedCamera.cameraId == BACK_CAMERA && getActivity().getPackageManager().hasSystemFeature("android.hardware.camera.flash"))
        {
            ((Button) (obj)).setVisibility(0);
        } else
        {
            ((Button) (obj)).setVisibility(8);
        }
        imagebutton1.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraPreviewFragment this$0;

            public void onClick(View view)
            {
                if (!pictureTaken)
                {
                    pictureTaken = true;
                    if (mCamera != null)
                    {
                        mCamera.autoFocus(mAutoFocusCallback);
                    }
                }
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        });
        imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraPreviewFragment this$0;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.GET_CONTENT", null);
                view.setType("image/*");
                startActivityForResult(view, PICK_IMAGE);
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        });
        imagebutton2.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraPreviewFragment this$0;

            public void onClick(View view)
            {
                finishActivityWithResult(0, null);
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        });
        imagebutton3.setOnClickListener(new android.view.View.OnClickListener() {

            final CameraPreviewFragment this$0;

            public void onClick(View view)
            {
                releaseCamera();
                switchCamera();
                setupCameraPreviewAttributes();
                setupCameraPreviewDisplay(surfaceHolder);
                mCamera.startPreview();
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        });
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final CameraPreviewFragment this$0;

            public void onClick(View view)
            {
                android.hardware.Camera.Parameters parameters;
                view = (Button)view;
                parameters = mCamera.getParameters();
                if (!currentFlashMode.equals("auto")) goto _L2; else goto _L1
_L1:
                currentFlashMode = "off";
                parameters.setFlashMode(currentFlashMode);
                view.setText(getString(0x7f0601db));
_L4:
                mCamera.setParameters(parameters);
                return;
_L2:
                if (currentFlashMode.equals("off"))
                {
                    currentFlashMode = "on";
                    parameters.setFlashMode(currentFlashMode);
                    view.setText(getString(0x7f0601e2));
                } else
                if (currentFlashMode.equals("on"))
                {
                    currentFlashMode = "auto";
                    parameters.setFlashMode(currentFlashMode);
                    view.setText(getString(0x7f06004d));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = CameraPreviewFragment.this;
                super();
            }
        });
    }

    private void setupCameraFlash(String s)
    {
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        List list = parameters.getSupportedFlashModes();
        if (list != null && list.contains(s))
        {
            parameters.setFlashMode(s);
            mCamera.setParameters(parameters);
        }
    }

    private void setupCameraPreviewAttributes()
    {
        if (mCamera != null)
        {
            int i = setOrientation();
            android.hardware.Camera.Parameters parameters = mCamera.getParameters();
            parameters.set("jpeg-quality", 100);
            android.hardware.Camera.Size size;
            android.hardware.Camera.Size size1;
            if (i == 90 || i == 270)
            {
                size = getBestPreviewSizeII(screenHeight, screenWidth, parameters);
            } else
            {
                size = getBestPreviewSizeII(screenWidth, screenHeight, parameters);
            }
            size1 = getBestPictureSize(parameters, size);
            parameters.setPreviewSize(size.width, size.height);
            parameters.setPictureSize(size1.width, size1.height);
            setupCameraFlash("off");
            mCamera.setParameters(parameters);
            if (i == 90 || i == 270)
            {
                i = (int)(((float)screenWidth / (float)size.height) * (float)size.width);
            } else
            {
                i = (int)(((float)screenWidth / (float)size.width) * (float)size.height);
            }
            preview.setScaledDimensions(screenWidth, i);
        }
    }

    private void setupCameraPreviewDisplay(SurfaceHolder surfaceholder)
    {
        try
        {
            mCamera.setPreviewDisplay(surfaceholder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SurfaceHolder surfaceholder)
        {
            surfaceholder.printStackTrace();
        }
        mCamera.release();
        mCamera = null;
    }

    private void switchCamera()
    {
        Button button;
        if (currentSelectedCamera.cameraId == FRONT_CAMERA)
        {
            currentSelectedCamera = (PMCameraInfo)cameraList.get(Integer.valueOf(BACK_CAMERA));
            mCamera = Camera.open(BACK_CAMERA);
        } else
        {
            currentSelectedCamera = (PMCameraInfo)cameraList.get(Integer.valueOf(FRONT_CAMERA));
            mCamera = Camera.open(FRONT_CAMERA);
        }
        button = (Button)getView().findViewById(0x7f0c0091);
        if (getActivity().getPackageManager().hasSystemFeature("android.hardware.camera.flash"))
        {
            if (currentSelectedCamera.cameraId == BACK_CAMERA)
            {
                button.setVisibility(0);
                return;
            } else
            {
                button.setVisibility(8);
                return;
            }
        } else
        {
            button.setVisibility(8);
            return;
        }
    }

    public void cropImage(String s)
    {
        loadingBitmapProgressBarLayout.setVisibility(8);
        Intent intent = new Intent((PMActivity)getActivity(), com/poshmark/ui/PMContainerActivity);
        intent.putExtra("FRAGMENT", com/poshmark/ui/fragments/GestureTester);
        Bundle bundle = new Bundle();
        bundle.putString("FILE", s);
        bundle.putInt("CREATION_MODE", CREATION_MODE);
        intent.putExtra("FRAGMENT_DATA", bundle);
        startActivityForResult(intent, CROP_IMAGE);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        screenWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        screenHeight = getActivity().getWindowManager().getDefaultDisplay().getHeight();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        pictureTaken = false;
        if (j != -1) goto _L2; else goto _L1
_L1:
        if (i != PICK_IMAGE && i != PICK_IMAGE_NO_CAMERA_PRESENT) goto _L4; else goto _L3
_L3:
        if (intent != null)
        {
            getBitmapFromPickerAction(intent, intent.getData());
        }
_L6:
        return;
_L4:
        if (i == CROP_IMAGE)
        {
            intent = intent.getData();
            if (CREATION_MODE == CREATE_COVERSHOT && bIsFirstCovershot)
            {
                fireCameraFiltersActivity(intent);
                return;
            } else
            {
                Intent intent1 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelable("IMAGE_FILE_URI", intent);
                intent1.putExtras(bundle);
                finishActivityWithResult(-1, intent1);
                return;
            }
        }
        if (i == FILTER_IMAGE)
        {
            intent = intent.getExtras();
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            finishActivityWithResult(-1, intent2);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (state == STATE.PICK_IMAGE_NO_CAMERA_PRESENT)
        {
            finishActivityWithResult(0, null);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            state = (STATE)bundle.getSerializable("State");
        }
        bShouldHideActionBar = true;
        hideActionBar(true);
        bundle = getArguments();
        if (bundle != null)
        {
            CREATION_MODE = bundle.getInt("CREATION_MODE");
            bIsFirstCovershot = bundle.getBoolean("IS_FIRST_IMAGE", false);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03001e, viewgroup, false);
        loadingBitmapProgressBarLayout = (RelativeLayout)layoutinflater.findViewById(0x7f0c0096);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        releaseCamera();
        ((FrameLayout)getView()).removeView(preview);
        preview = null;
    }

    public void onResume()
    {
        super.onResume();
        if (preview == null)
        {
            preview = new CameraPreviewSurfaceView(getActivity(), null);
            ((FrameLayout)getView()).addView(preview, 0);
            setupCameras();
            surfaceHolder = preview.getHolder();
            surfaceHolder.addCallback(surfaceCallback);
            setupCameraPreviewAttributes();
            viewportOverlay = (CameraViewportRectView)getView().findViewById(0x7f0c0090);
            getActivity().getWindow().setFlags(1024, 1024);
        }
        _cls9..SwitchMap.com.poshmark.ui.fragments.CameraPreviewFragment.STATE[state.ordinal()];
        JVM INSTR tableswitch 1 1: default 136
    //                   1 137;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (mCamera == null)
        {
            state = STATE.PICK_IMAGE_NO_CAMERA_PRESENT;
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_NO_CAMERA_PRESENT);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("State", state);
    }

    public int setOrientation()
    {
        int i;
        int j;
        j = ((WindowManager)getActivity().getSystemService("window")).getDefaultDisplay().getRotation();
        i = 0;
        j;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 105
    //                   1 110
    //                   2 116
    //                   3 123;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_123;
_L6:
        if (currentSelectedCamera.info.facing == 1)
        {
            i = (360 - (currentSelectedCamera.info.orientation + i) % 360) % 360;
        } else
        {
            i = ((currentSelectedCamera.info.orientation - i) + 360) % 360;
        }
        mCamera.setDisplayOrientation(i);
        return i;
_L2:
        i = 0;
          goto _L6
_L3:
        i = 90;
          goto _L6
_L4:
        i = 180;
          goto _L6
        i = 270;
          goto _L6
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "camera_screen";
    }

    public void setupCameras()
    {
        int i;
        Object obj;
        PMCameraInfo pmcamerainfo;
        int j;
        try
        {
            j = Camera.getNumberOfCameras();
        }
        catch (Exception exception)
        {
            return;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i, ((android.hardware.Camera.CameraInfo) (obj)));
        if (((android.hardware.Camera.CameraInfo) (obj)).facing == FRONT_CAMERA)
        {
            pmcamerainfo = new PMCameraInfo(i, ((android.hardware.Camera.CameraInfo) (obj)));
            cameraList.put(Integer.valueOf(FRONT_CAMERA), pmcamerainfo);
        }
        if (((android.hardware.Camera.CameraInfo) (obj)).facing == BACK_CAMERA)
        {
            obj = new PMCameraInfo(i, ((android.hardware.Camera.CameraInfo) (obj)));
            cameraList.put(Integer.valueOf(BACK_CAMERA), obj);
        }
        break MISSING_BLOCK_LABEL_241;
        if (cameraList.containsKey(Integer.valueOf(BACK_CAMERA)))
        {
            currentSelectedCamera = (PMCameraInfo)cameraList.get(Integer.valueOf(BACK_CAMERA));
            mCamera = Camera.open(currentSelectedCamera.cameraId);
            setupCameraFlash(currentFlashMode);
            return;
        }
        if (cameraList.containsKey(Integer.valueOf(FRONT_CAMERA)))
        {
            currentSelectedCamera = (PMCameraInfo)cameraList.get(Integer.valueOf(FRONT_CAMERA));
            mCamera = Camera.open(currentSelectedCamera.cameraId);
            setupCameraFlash(currentFlashMode);
            return;
        }
        break; /* Loop/switch isn't completed */
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }








}
