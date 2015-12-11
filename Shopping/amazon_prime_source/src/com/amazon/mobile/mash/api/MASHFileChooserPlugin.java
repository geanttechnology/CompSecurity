// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.error.OpenFileChooserError;
import com.amazon.mobile.mash.util.MASHFileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.FileHelper;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCordovaPlugin

public class MASHFileChooserPlugin extends MASHCordovaPlugin
{

    public static final String SERVICE_NAME = "MASHFileChooser";
    private CallbackContext mCallback;
    private String mCameraFilePath;
    private int mMaxFileSize;

    public MASHFileChooserPlugin()
    {
    }

    private boolean checkFileSizeAndExistence(Uri uri)
    {
        int i;
        try
        {
            i = getFileSize(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            mCallback.error(OpenFileChooserError.FILE_NOT_FOUND.toJSONObject());
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            mCallback.error(MASHError.UNKNOWN.toJSONObejct());
            return false;
        }
        if (mMaxFileSize > 0 && mMaxFileSize < i)
        {
            mCallback.error(OpenFileChooserError.FILE_SIZE_EXCEEDED.toJSONObject());
            return false;
        } else
        {
            return true;
        }
    }

    private Intent createCamcorderIntent(int i)
    {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        if (i > 0)
        {
            intent.putExtra("android.intent.extra.durationLimit", i);
        }
        return intent;
    }

    private Intent createCameraIntent()
        throws IOException
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        file = new File((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append("browser-photos").toString());
        if (!file.mkdirs() && !file.isDirectory())
        {
            throw new IOException();
        } else
        {
            mCameraFilePath = (new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append(System.currentTimeMillis()).append(".jpg").toString();
            intent.putExtra("output", Uri.fromFile(new File(mCameraFilePath)));
            return intent;
        }
    }

    private Intent createChooserIntent(String s, boolean flag, int i)
        throws IOException
    {
        Intent intent = null;
        if (!"image/*".equals(s)) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        intent = createCameraIntent();
_L6:
        return intent;
_L4:
        s = createChooserIntent(new Intent[] {
            createCameraIntent()
        });
        s.putExtra("android.intent.extra.INTENT", createOpenableIntent("image/*"));
        return s;
_L2:
        if ("video/*".equals(s))
        {
            if (flag)
            {
                return createCamcorderIntent(i);
            } else
            {
                s = createChooserIntent(new Intent[] {
                    createCamcorderIntent(i)
                });
                s.putExtra("android.intent.extra.INTENT", createOpenableIntent("video/*"));
                return s;
            }
        }
        if ("audio/*".equals(s))
        {
            if (flag)
            {
                return createSoundRecorderIntent();
            } else
            {
                s = createChooserIntent(new Intent[] {
                    createSoundRecorderIntent()
                });
                s.putExtra("android.intent.extra.INTENT", createOpenableIntent("audio/*"));
                return s;
            }
        }
        if ("*/*".equals(s))
        {
            return createDefaultOpenableIntent(i);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private transient Intent createChooserIntent(Intent aintent[])
    {
        Intent intent = new Intent("android.intent.action.CHOOSER");
        intent.putExtra("android.intent.extra.INITIAL_INTENTS", aintent);
        return intent;
    }

    private Intent createDefaultOpenableIntent(int i)
        throws IOException
    {
        Intent intent = createChooserIntent(new Intent[] {
            createCameraIntent(), createCamcorderIntent(i), createSoundRecorderIntent()
        });
        intent.putExtra("android.intent.extra.INTENT", createOpenableIntent("*/*"));
        return intent;
    }

    private Intent createOpenableIntent(String s)
    {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(s);
        return intent;
    }

    private Intent createSoundRecorderIntent()
    {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    private int getFileSize(Uri uri)
        throws IOException
    {
        return (int)((FileInputStream)FileHelper.getInputStreamFromUriString(uri.toString(), cordova)).getChannel().size();
    }

    private boolean mimeTypeNotSupported(String s)
    {
        return !"image/*".equals(s) && !"audio/*".equals(s) && !"video/*".equals(s) && !"*/*".equals(s);
    }

    private void startActivityForResult(Intent intent, int i)
    {
        try
        {
            cordova.startActivityForResult(this, intent, 10004);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            mCallback.error(OpenFileChooserError.CANNOT_OPEN_CAPTURE_MECHANISM.toJSONObject());
        }
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("OpenFileChooser".equals(s))
        {
            openFileChooser(jsonarray, callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }

    void handlePickFileResult(int i, Intent intent)
    {
        if (i == 0)
        {
            mCallback.error(MASHError.USER_CANCELLED.toJSONObejct());
        } else
        {
            Uri uri;
            Uri uri1;
            if (intent == null || i != -1)
            {
                uri = null;
            } else
            {
                uri = intent.getData();
            }
            uri1 = uri;
            if (uri == null)
            {
                uri1 = uri;
                if (intent == null)
                {
                    uri1 = uri;
                    if (i == -1)
                    {
                        uri1 = uri;
                        if (mCameraFilePath != null)
                        {
                            intent = new File(mCameraFilePath);
                            uri1 = uri;
                            if (intent.exists())
                            {
                                uri1 = Uri.fromFile(intent);
                                cordova.getActivity().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri1));
                            }
                        }
                    }
                }
            }
            if (uri1 == null)
            {
                mCallback.error(MASHError.UNKNOWN.toJSONObejct());
                return;
            }
            if (checkFileSizeAndExistence(uri1))
            {
                intent = MASHFileUtil.getFilePath(cordova.getActivity(), uri1);
                mCallback.success(intent);
                return;
            }
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 10004)
        {
            handlePickFileResult(j, intent);
        }
    }

    void openFileChooser(JSONArray jsonarray, final CallbackContext mimeType)
        throws JSONException
    {
        mCallback = mimeType;
        mCameraFilePath = null;
        mimeType = jsonarray.getString(0);
        final boolean capture = jsonarray.getBoolean(1);
        mMaxFileSize = jsonarray.getInt(2);
        runOnUiThread(new Runnable() {

            final MASHFileChooserPlugin this$0;
            final boolean val$capture;
            final int val$duration;
            final String val$mimeType;

            public void run()
            {
                if (mimeTypeNotSupported(mimeType))
                {
                    mCallback.error(OpenFileChooserError.MIME_TYPE_NOT_SUPPORTED.toJSONObject());
                    return;
                }
                Object obj = createChooserIntent(mimeType, capture, duration);
                if (obj == null)
                {
                    try
                    {
                        mCallback.error(MASHError.UNKNOWN.toJSONObejct());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        mCallback.error(MASHError.PERMISSION_DENIED.toJSONObejct());
                    }
                    return;
                }
                startActivityForResult(((Intent) (obj)), duration);
                return;
            }

            
            {
                this$0 = MASHFileChooserPlugin.this;
                mimeType = s;
                capture = flag;
                duration = i;
                super();
            }
        });
    }




}
