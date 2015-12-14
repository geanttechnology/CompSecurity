// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.socialin.android.ads.SocialinAdManager;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.constants.c;
import com.socialin.android.d;
import com.socialin.android.photo.exif.ExifTool;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.activity:
//            BaseActivity, d, FolderChooserActivity

public class SaveToSdCardDialogActivity extends BaseActivity
{

    private static final String MYME_MP4_VIDEO = "videoMP4";
    public static final String TAG = (new StringBuilder()).append(com/socialin/android/activity/SaveToSdCardDialogActivity.getSimpleName()).append(" - ").toString();
    private static final String TAG_GIF_KEY_PATH = "gifPath";
    private static final String TAG_VID_KEY_PATH = "vidPath";
    private final int REQUEST_CHOOSE_FOLDER = 12;
    private android.graphics.Bitmap.CompressFormat compressFormat;
    private ArrayList dirNameAdapterList;
    private Spinner dirNamesSpinner;
    private String fileAbsolutePath;
    private String fileExtension;
    private String fileName;
    private EditText fileNameEditText;
    private Spinner imageFormatSpinner;
    private Uri imageUri;
    private boolean isGifFile;
    private boolean isMP4Video;
    private boolean isReturnResult;
    private boolean isVideoFile;
    private String subFolderName;

    public SaveToSdCardDialogActivity()
    {
        fileNameEditText = null;
        dirNamesSpinner = null;
        imageFormatSpinner = null;
        imageUri = null;
        fileAbsolutePath = null;
        fileName = null;
        subFolderName = null;
        fileExtension = null;
        compressFormat = android.graphics.Bitmap.CompressFormat.JPEG;
        dirNameAdapterList = new ArrayList();
        isReturnResult = false;
        isGifFile = false;
        isVideoFile = false;
        isMP4Video = false;
    }

    private void done(String s, String s1)
    {
        if (isReturnResult && !isVideoFile && !isGifFile && (imageUri == null || compressFormat != null))
        {
            finishActivity(s, s1, compressFormat);
            return;
        } else
        {
            doSaveToSDCard(s, s1);
            return;
        }
    }

    private void finishActivity(String s, String s1, android.graphics.Bitmap.CompressFormat compressformat)
    {
        Intent intent = new Intent();
        intent.putExtra("selectedFolderName", s);
        intent.putExtra("selectedFileName", s1);
        intent.putExtra("fileExtension", fileExtension);
        intent.putExtra("dstPath", (new StringBuilder()).append(s).append("/").append(s1).append(fileExtension).toString());
        intent.putExtra("format", compressformat);
        setResult(-1, intent);
        finish();
    }

    private void init()
    {
        fileNameEditText = (EditText)findViewById(0x7f1007bd);
        fileName = (new StringBuilder()).append(getString(0x7f0808fc)).append("_").append((new SimpleDateFormat("MM-dd-hh.mm.ss")).format(new Date()).toString()).toString();
        fileNameEditText.setText(fileName);
        fileNameEditText.setSelectAllOnFocus(true);
        Object obj;
        if (isGifFile)
        {
            obj = c.b;
        } else
        if (isVideoFile)
        {
            if (isMP4Video)
            {
                obj = c.d;
            } else
            {
                obj = c.c;
            }
        } else
        {
            obj = c.a;
        }
        obj = new ArrayAdapter(this, ((String []) (obj))) {

            public final View getView(int i, View view, ViewGroup viewgroup)
            {
                return super.getView(i, null, viewgroup);
            }

            public final int getViewTypeCount()
            {
                return 1;
            }

        };
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x7f03024f);
        imageFormatSpinner = (Spinner)findViewById(0x7f1007c1);
        imageFormatSpinner.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        fileExtension = imageUri.getLastPathSegment().substring(imageUri.getLastPathSegment().lastIndexOf("."));
_L2:
        if (".jpg".equalsIgnoreCase(fileExtension) || ".jpeg".equalsIgnoreCase(fileExtension))
        {
            imageFormatSpinner.setSelection(1);
        }
        dirNamesSpinner = (Spinner)findViewById(0x7f1007c0);
        (new File(subFolderName)).mkdirs();
        obj = new com.socialin.android.activity.d(this);
        dirNamesSpinner.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        findViewById(0x7f1007bf).setOnClickListener(new android.view.View.OnClickListener() {

            private SaveToSdCardDialogActivity a;

            public final void onClick(View view)
            {
                view = new Intent(a.getApplicationContext(), com/socialin/android/activity/FolderChooserActivity);
                view.putExtra("actionName", a.getString(0x7f080606));
                view.putExtra("currentPath", (String)a.dirNameAdapterList.get(0));
                a.startActivityForResult(view, 12);
            }

            
            {
                a = SaveToSdCardDialogActivity.this;
                super();
            }
        });
        findViewById(0x7f1007c3).setOnClickListener(new android.view.View.OnClickListener() {

            final SaveToSdCardDialogActivity a;

            public final void onClick(View view)
            {
                view = a.fileNameEditText.getText().toString();
                String s = (String)a.dirNamesSpinner.getSelectedItem();
                Object obj1 = (String)a.imageFormatSpinner.getSelectedItem();
                if (!TextUtils.isEmpty(view))
                {
                    if (((String) (obj1)).equals("PNG"))
                    {
                        a.compressFormat = android.graphics.Bitmap.CompressFormat.PNG;
                        a.fileExtension = ".png";
                    } else
                    if (((String) (obj1)).equals("JPEG"))
                    {
                        a.compressFormat = android.graphics.Bitmap.CompressFormat.JPEG;
                        a.fileExtension = ".jpg";
                    } else
                    if (((String) (obj1)).equals("GIF"))
                    {
                        a.compressFormat = null;
                        a.fileExtension = ".gif";
                    } else
                    if (((String) (obj1)).equals("WEBM"))
                    {
                        a.compressFormat = null;
                        a.fileExtension = ".webm";
                    } else
                    if (((String) (obj1)).equals("MP4"))
                    {
                        a.compressFormat = null;
                        a.fileExtension = ".mp4";
                    }
                    obj1 = new File((new StringBuilder()).append(s).append("/").append(view).append(a.fileExtension).toString());
                    AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExportImageEvent("sdcard", "bin"));
                    (new StringBuilder("SAVED FILE ****************** ")).append(obj1);
                    if (((File) (obj1)).exists())
                    {
                        obj1 = (new android.app.AlertDialog.Builder(a)).create();
                        ((AlertDialog) (obj1)).setMessage(a.getText(0x7f080475));
                        ((AlertDialog) (obj1)).setButton(-1, a.getString(0x7f080311), new android.content.DialogInterface.OnClickListener(this, s, view) {

                            private String a;
                            private String b;
                            private _cls3 c;

                            public final void onClick(DialogInterface dialoginterface, int i)
                            {
                                c.a.done(a, b);
                            }

            
            {
                c = _pcls3;
                a = s;
                b = s1;
                super();
            }
                        });
                        ((AlertDialog) (obj1)).setButton(-2, a.getString(0x7f080295), new android.content.DialogInterface.OnClickListener() {

                            public final void onClick(DialogInterface dialoginterface, int i)
                            {
                            }

                        });
                        ((AlertDialog) (obj1)).show();
                        return;
                    } else
                    {
                        a.done(s, view);
                        return;
                    }
                } else
                {
                    Utils.c(a, a.getString(0x7f080571));
                    return;
                }
            }

            
            {
                a = SaveToSdCardDialogActivity.this;
                super();
            }
        });
        findViewById(0x7f1007c2).setOnClickListener(new android.view.View.OnClickListener() {

            private SaveToSdCardDialogActivity a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = SaveToSdCardDialogActivity.this;
                super();
            }
        });
        return;
        Exception exception;
        exception;
        if (fileExtension == null)
        {
            fileExtension = ".jpg";
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void trackExport(String s)
    {
        int j = 0;
        new JSONObject();
        EditingData editingdata = EditingData.a(fileAbsolutePath);
        String s1;
        int i;
        if (!fileAbsolutePath.isEmpty())
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(fileAbsolutePath, options);
            i = options.outHeight;
            j = options.outWidth;
        } else
        {
            i = 0;
        }
        s1 = "";
        if (fileExtension == null) goto _L2; else goto _L1
_L1:
        if (!fileExtension.equalsIgnoreCase(".jpeg") && !fileExtension.equalsIgnoreCase(".jpg")) goto _L4; else goto _L3
_L3:
        s1 = "jpg";
_L6:
        AnalyticUtils.trackImageExport(this, s, editingdata, s1, i, j, com.picsart.studio.utils.c.a(this, null));
        return;
_L4:
        if (fileExtension.equalsIgnoreCase(".png"))
        {
            s1 = "png";
        } else
        if (fileExtension.equalsIgnoreCase(".gif"))
        {
            s1 = "gif";
        } else
        if (fileExtension.equalsIgnoreCase(".webm"))
        {
            s1 = "webm";
        } else
        if (fileExtension.equalsIgnoreCase(".mp4"))
        {
            s1 = "mp4";
        }
        continue; /* Loop/switch isn't completed */
_L2:
        s1 = "jpg";
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void doSaveToSDCard(String s, String s1)
    {
        findViewById(0x7f1003fe).setVisibility(0);
        if (w.a(this))
        {
            d.b(TAG, new Object[] {
                "SD card installed performing save - ", fileAbsolutePath
            });
            (new Thread(s1, s) {

                final SaveToSdCardDialogActivity a;
                private String b;
                private String c;

                public final void run()
                {
                    Object obj = null;
                    String s2 = (new StringBuilder()).append(b).append(a.fileExtension).toString();
                    if (a.isGifFile)
                    {
                        obj = new File(a.fileAbsolutePath);
                        File file = new File((new StringBuilder()).append(c).append("/temp").append(s2).toString());
                        FileUtils.b(((File) (obj)), file);
                        obj = new File((new StringBuilder()).append(c).append("/").append(s2).toString());
                        FileUtils.b(file, ((File) (obj)));
                        if (android.os.Build.VERSION.SDK_INT >= 19)
                        {
                            a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse((new StringBuilder("file://")).append(obj).toString())));
                        } else
                        {
                            a.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse((new StringBuilder("file://")).append(c).append(obj).toString())));
                        }
                        file.delete();
                    } else
                    if (a.isVideoFile)
                    {
                        obj = new File(a.fileAbsolutePath);
                        File file1 = new File((new StringBuilder()).append(c).append("/temp").append(s2).toString());
                        FileUtils.b(((File) (obj)), file1);
                        obj = new File((new StringBuilder()).append(c).append("/").append(s2).toString());
                        FileUtils.b(file1, ((File) (obj)));
                        file1.delete();
                    } else
                    {
                        Bitmap bitmap = com.socialin.android.util.c.a(a.fileAbsolutePath);
                        if (bitmap != null)
                        {
                            File file2 = w.a(c, s2, bitmap, a, a.compressFormat, true);
                            if (android.graphics.Bitmap.CompressFormat.JPEG.equals(a.compressFormat))
                            {
                                String s3 = m.c(a.fileAbsolutePath);
                                if (s3 != null && file2 != null)
                                {
                                    ExifTool.a(file2.getAbsolutePath(), ExifTool.b(a.fileAbsolutePath));
                                    ExifTool.a(file2.getAbsolutePath(), "Exif.Photo.UserComment", s3);
                                    if (SocialinV3.getInstance().isRegistered())
                                    {
                                        obj = String.valueOf(SocialinV3.getInstance().getUser().id);
                                    }
                                    if (obj != null && ExifTool.a(file2.getAbsolutePath(), "Exif.Image.Artist") == null)
                                    {
                                        ExifTool.a(file2.getAbsolutePath(), "Exif.Image.Artist", ((String) (obj)));
                                    }
                                }
                            }
                            bitmap.recycle();
                            obj = file2;
                        } else
                        {
                            Utils.a(a, 0x7f0804ab);
                            a.finish();
                            obj = null;
                        }
                    }
                    if (obj != null)
                    {
                        Utils.a(a, c);
                        a.finishActivity(c, s2, a.compressFormat);
                        a.trackExport("local");
                        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.ExportImageSdEvent("sdcard_done", "bin"));
                        return;
                    } else
                    {
                        Utils.a(a, 0x7f0804a0);
                        a.runOnUiThread(new Runnable(this) {

                            private _cls5 a;

                            public final void run()
                            {
                                View view = a.a.findViewById(0x7f1003fe);
                                if (view != null)
                                {
                                    view.setVisibility(8);
                                }
                            }

            
            {
                a = _pcls5;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                a = SaveToSdCardDialogActivity.this;
                b = s;
                c = s1;
                super();
            }
            }).start();
            SocialinAdManager.a(com.socialin.android.ads.SocialinAdManager.PicsArtInterstitialType.EXPORT);
            return;
        } else
        {
            Utils.a(this, 0x7f0805a0);
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && i == 12)
        {
            dirNameAdapterList.clear();
            dirNameAdapterList.add(intent.getStringExtra("path"));
            intent = new com.socialin.android.activity.d(this);
            dirNamesSpinner.setAdapter(intent);
            dirNamesSpinner.invalidate();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03019a);
        bundle = m.a(this);
        if (bundle != null)
        {
            bundle.setText(0x7f08059d);
        }
        bundle = getIntent();
        if (bundle.getData() != null)
        {
            imageUri = bundle.getData();
            fileAbsolutePath = imageUri.getPath();
        }
        if (bundle.hasExtra("fileName"))
        {
            fileName = bundle.getStringExtra("fileName");
            d.b("onCreate() - fileName:", new Object[] {
                fileName
            });
        }
        if (bundle.hasExtra("videoMP4"))
        {
            isMP4Video = bundle.getExtras().getBoolean("videoMP4");
        }
        if (bundle.hasExtra("gifPath"))
        {
            isGifFile = bundle.getBooleanExtra("gifPath", false);
        }
        if (bundle.hasExtra("vidPath"))
        {
            isVideoFile = bundle.getBooleanExtra("vidPath", false);
        }
        if (bundle.hasExtra("subFolderName"))
        {
            subFolderName = bundle.getStringExtra("subFolderName");
            if (subFolderName != null && !subFolderName.startsWith("/"))
            {
                if (isVideoFile && !isGifFile)
                {
                    subFolderName = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)).append(File.separator).append(subFolderName).toString();
                } else
                {
                    subFolderName = (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)).append(File.separator).append(subFolderName).toString();
                }
            }
            d.b("onCreate() - subFolderName:", new Object[] {
                subFolderName
            });
        }
        if (bundle.hasExtra("extension"))
        {
            fileExtension = bundle.getStringExtra("extension");
        }
        if (bundle.hasExtra("isReturnResult"))
        {
            isReturnResult = bundle.getBooleanExtra("isReturnResult", false);
        }
        d.b("onCreate() - subFolderName:", new Object[] {
            subFolderName
        });
        dirNameAdapterList.add(subFolderName);
        init();
    }










/*
    static android.graphics.Bitmap.CompressFormat access$402(SaveToSdCardDialogActivity savetosdcarddialogactivity, android.graphics.Bitmap.CompressFormat compressformat)
    {
        savetosdcarddialogactivity.compressFormat = compressformat;
        return compressformat;
    }

*/



/*
    static String access$502(SaveToSdCardDialogActivity savetosdcarddialogactivity, String s)
    {
        savetosdcarddialogactivity.fileExtension = s;
        return s;
    }

*/




}
