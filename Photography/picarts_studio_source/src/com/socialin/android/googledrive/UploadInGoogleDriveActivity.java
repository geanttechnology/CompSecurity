// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.socialin.android.dialog.g;
import com.socialin.android.util.Utils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googledrive:
//            BaseDriveActivity, a

public class UploadInGoogleDriveActivity extends BaseDriveActivity
{

    private static final String c = com/socialin/android/googledrive/UploadInGoogleDriveActivity.getSimpleName();
    private static boolean d = false;
    private String e;
    private g f;
    private DriveFile g;
    private byte h[];

    public UploadInGoogleDriveActivity()
    {
    }

    static g a(UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        return uploadingoogledriveactivity.f;
    }

    private void a(Intent intent)
    {
        intent = (DriveId)intent.getParcelableExtra("response_drive_id");
        g = Drive.DriveApi.getFile(a, intent);
        (new a(b, this) {

            private UploadInGoogleDriveActivity a;

            protected final Object a(Object aobj[])
            {
                aobj = (String[])aobj;
                com.google.android.gms.drive.DriveApi.DriveContentsResult drivecontentsresult = (com.google.android.gms.drive.DriveApi.DriveContentsResult)UploadInGoogleDriveActivity.c(a).open(a.a, 0x20000000, null).await();
                if (!drivecontentsresult.getStatus().isSuccess())
                {
                    UploadInGoogleDriveActivity.b();
                    return drivecontentsresult.getStatus();
                } else
                {
                    UploadInGoogleDriveActivity.a(a, ((String) (aobj[0])), drivecontentsresult.getDriveContents());
                    return null;
                }
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Status)obj;
                if (obj != null && ((Status) (obj)).isSuccess())
                {
                    UploadInGoogleDriveActivity.d(a);
                }
            }

            
            {
                a = UploadInGoogleDriveActivity.this;
                super(s, context);
            }
        }).execute(new String[] {
            e
        });
    }

    static void a(UploadInGoogleDriveActivity uploadingoogledriveactivity, Intent intent)
    {
        uploadingoogledriveactivity.a(intent);
    }

    static void a(UploadInGoogleDriveActivity uploadingoogledriveactivity, com.google.android.gms.drive.DriveApi.DriveContentsResult drivecontentsresult, String s)
    {
        s = (new com.google.android.gms.drive.MetadataChangeSet.Builder()).setMimeType("image/jpeg").setTitle(s).setStarred(true).build();
        drivecontentsresult = Drive.DriveApi.newCreateFileActivityBuilder().setInitialMetadata(s).setInitialDriveContents(drivecontentsresult.getDriveContents()).setActivityTitle("Upload to Drive").build(uploadingoogledriveactivity.a);
        try
        {
            m.b(uploadingoogledriveactivity, uploadingoogledriveactivity.f);
            uploadingoogledriveactivity.startIntentSenderForResult(drivecontentsresult, 40, null, 0, 0, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UploadInGoogleDriveActivity uploadingoogledriveactivity)
        {
            Log.e(c, "Unable to start create file activity", uploadingoogledriveactivity);
        }
    }

    static void a(UploadInGoogleDriveActivity uploadingoogledriveactivity, String s, DriveContents drivecontents)
    {
        try
        {
            uploadingoogledriveactivity.h = a(new File(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(c, "Failed to read file", s);
        }
        s = drivecontents.getOutputStream();
        s.write(uploadingoogledriveactivity.h);
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(c, "Error closing Contents output stream", s);
        }
_L2:
        drivecontents.commit(uploadingoogledriveactivity.a, null).setResultCallback(uploadingoogledriveactivity. new ResultCallback() {

            private UploadInGoogleDriveActivity a;

            public final void onResult(Result result)
            {
                result = (Status)result;
                if (result != null && result.isSuccess())
                {
                    UploadInGoogleDriveActivity.d(a);
                }
            }

            
            {
                a = UploadInGoogleDriveActivity.this;
                super();
            }
        });
        return;
        IOException ioexception;
        ioexception;
        Log.e(c, "Failed to write", ioexception);
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(c, "Error closing Contents output stream", s);
        }
        if (true) goto _L2; else goto _L1
_L1:
        uploadingoogledriveactivity;
        try
        {
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(c, "Error closing Contents output stream", s);
        }
        throw uploadingoogledriveactivity;
    }

    static boolean a()
    {
        return d;
    }

    static boolean a(boolean flag)
    {
        d = flag;
        return flag;
    }

    private static byte[] a(File file)
    {
        file = new RandomAccessFile(file, "r");
        long l = file.length();
        int i;
        i = (int)l;
        if ((long)i == l)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        throw new IOException("File size >= 2 GB");
        Exception exception;
        exception;
        file.close();
        throw exception;
        byte abyte0[];
        abyte0 = new byte[i];
        file.readFully(abyte0);
        file.close();
        return abyte0;
    }

    static String b()
    {
        return c;
    }

    static void b(UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        uploadingoogledriveactivity.e = uploadingoogledriveactivity.getIntent().getStringExtra("path");
        String s = uploadingoogledriveactivity.e.substring(uploadingoogledriveactivity.e.lastIndexOf(File.separator) + 1);
        Drive.DriveApi.newDriveContents(uploadingoogledriveactivity.a).setResultCallback(uploadingoogledriveactivity. new ResultCallback(s) {

            private String a;
            private UploadInGoogleDriveActivity b;

            public final void onResult(Result result)
            {
                result = (com.google.android.gms.drive.DriveApi.DriveContentsResult)result;
                if (!result.getStatus().isSuccess())
                {
                    Toast.makeText(b, result.getStatus().toString(), 1).show();
                    return;
                } else
                {
                    UploadInGoogleDriveActivity.a(b, result, a);
                    return;
                }
            }

            
            {
                b = UploadInGoogleDriveActivity.this;
                a = s;
                super();
            }
        });
    }

    static DriveFile c(UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        return uploadingoogledriveactivity.g;
    }

    static void d(UploadInGoogleDriveActivity uploadingoogledriveactivity)
    {
        Utils.c(uploadingoogledriveactivity, "Your file is being uploading in: My Drive");
        m.b(uploadingoogledriveactivity, uploadingoogledriveactivity.f);
        uploadingoogledriveactivity.a.disconnect();
        d = false;
        uploadingoogledriveactivity.setResult(-1);
        uploadingoogledriveactivity.finish();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            if (i == 40)
            {
                (new Handler()).postDelayed(new Runnable() {

                    private UploadInGoogleDriveActivity a;

                    public final void run()
                    {
                        m.a(a, UploadInGoogleDriveActivity.a(a), true);
                    }

            
            {
                a = UploadInGoogleDriveActivity.this;
                super();
            }
                }, 0L);
                if (a.isConnected())
                {
                    a(intent);
                    return;
                } else
                {
                    a.registerConnectionCallbacks(new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks(intent) {

                        private Intent a;
                        private UploadInGoogleDriveActivity b;

                        public final void onConnected(Bundle bundle)
                        {
                            UploadInGoogleDriveActivity.a(b, a);
                        }

                        public final void onConnectionSuspended(int k)
                        {
                        }

            
            {
                b = UploadInGoogleDriveActivity.this;
                a = intent;
                super();
            }
                    });
                    return;
                }
            } else
            {
                super.onActivityResult(i, j, intent);
                return;
            }
        } else
        {
            d = false;
            setResult(0);
            finish();
            return;
        }
    }

    public void onConnectionSuspended(int i)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = new g(this);
        f.setMessage(getString(0x7f080679));
        f.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private UploadInGoogleDriveActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                UploadInGoogleDriveActivity.a(false);
                a.setResult(0);
                a.finish();
            }

            
            {
                a = UploadInGoogleDriveActivity.this;
                super();
            }
        });
        (new Handler()).postDelayed(new Runnable() {

            private UploadInGoogleDriveActivity a;

            public final void run()
            {
                m.a(a, UploadInGoogleDriveActivity.a(a), true);
            }

            
            {
                a = UploadInGoogleDriveActivity.this;
                super();
            }
        }, 0L);
        a.registerConnectionCallbacks(new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks() {

            private UploadInGoogleDriveActivity a;

            public final void onConnected(Bundle bundle1)
            {
                if (!UploadInGoogleDriveActivity.a())
                {
                    UploadInGoogleDriveActivity.b(a);
                    UploadInGoogleDriveActivity.a(true);
                }
            }

            public final void onConnectionSuspended(int i)
            {
            }

            
            {
                a = UploadInGoogleDriveActivity.this;
                super();
            }
        });
    }

}
