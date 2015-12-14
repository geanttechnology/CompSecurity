// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googledrive;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.socialin.android.dialog.g;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import java.io.File;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.googledrive:
//            BaseDriveActivity

public class OpenGoogleDriveActivity extends BaseDriveActivity
{

    private static final String f[] = {
        "image/jpg", "image/jpeg", "image/png", "image/gif", "image/JPG", "image/JPEG", "image/PNG", "image/GIF"
    };
    boolean c;
    boolean d;
    DriveId e;
    private g g;
    private Intent h;

    public OpenGoogleDriveActivity()
    {
        c = false;
        d = true;
        h = new Intent();
    }

    static g a(OpenGoogleDriveActivity opengoogledriveactivity)
    {
        return opengoogledriveactivity.g;
    }

    static String[] a()
    {
        return f;
    }

    static void b(OpenGoogleDriveActivity opengoogledriveactivity)
    {
        PendingResult pendingresult = Drive.DriveApi.getFile(opengoogledriveactivity.a, opengoogledriveactivity.e).open(opengoogledriveactivity.a, 0x10000000, null);
        if (opengoogledriveactivity.d)
        {
            pendingresult.setResultCallback(opengoogledriveactivity. new ResultCallback() {

                private OpenGoogleDriveActivity a;

                public final void onResult(Result result)
                {
                    result = ((com.google.android.gms.drive.DriveApi.DriveContentsResult)result).getDriveContents();
                    if (result != null)
                    {
                        result = result.getInputStream();
                        String s1 = (new StringBuilder("PicsArt_")).append(System.currentTimeMillis()).toString();
                        result = FileUtils.a((new StringBuilder()).append(a.getString(0x7f0808fb)).append("/").append(a.getString(0x7f08096a)).toString(), s1, result).getPath();
                        OpenGoogleDriveActivity.c(a).putExtra("path", result);
                        m.b(a, OpenGoogleDriveActivity.a(a));
                        a.setResult(-1, OpenGoogleDriveActivity.c(a));
                        a.finish();
                    }
                }

            
            {
                a = OpenGoogleDriveActivity.this;
                super();
            }
            });
        }
        opengoogledriveactivity.d = false;
    }

    static Intent c(OpenGoogleDriveActivity opengoogledriveactivity)
    {
        return opengoogledriveactivity.h;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            if (i == 40)
            {
                if (!s.a(this))
                {
                    Utils.c(this, "Connection failed");
                    c = false;
                    setResult(0);
                    finish();
                    return;
                } else
                {
                    c = true;
                    (new Handler()).postDelayed(new Runnable() {

                        private OpenGoogleDriveActivity a;

                        public final void run()
                        {
                            m.a(a, OpenGoogleDriveActivity.a(a), true);
                        }

            
            {
                a = OpenGoogleDriveActivity.this;
                super();
            }
                    }, 100L);
                    a.registerConnectionCallbacks(new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks(intent) {

                        private Intent a;
                        private OpenGoogleDriveActivity b;

                        public final void onConnected(Bundle bundle)
                        {
                            bundle = b;
                            bundle.e = (DriveId)a.getParcelableExtra("response_drive_id");
                            bundle.d = true;
                            (bundle. new Thread() {

                                private OpenGoogleDriveActivity a;

                                public final void run()
                                {
                                    if (a.d)
                                    {
                                        OpenGoogleDriveActivity.b(a);
                                    }
                                }

            
            {
                a = OpenGoogleDriveActivity.this;
                super();
            }
                            }).start();
                        }

                        public final void onConnectionSuspended(int k)
                        {
                        }

            
            {
                b = OpenGoogleDriveActivity.this;
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
            c = false;
            a.disconnect();
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
        g = new g(this);
        g.setMessage(getString(0x7f0803d8));
        g.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private OpenGoogleDriveActivity a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.setResult(0);
                a.finish();
            }

            
            {
                a = OpenGoogleDriveActivity.this;
                super();
            }
        });
        (new Handler()).postDelayed(new Runnable() {

            private OpenGoogleDriveActivity a;

            public final void run()
            {
                m.a(a, OpenGoogleDriveActivity.a(a), true);
            }

            
            {
                a = OpenGoogleDriveActivity.this;
                super();
            }
        }, 100L);
        a.registerConnectionCallbacks(new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks() {

            private OpenGoogleDriveActivity a;

            public final void onConnected(Bundle bundle1)
            {
                if (!a.c)
                {
                    bundle1 = Drive.DriveApi.newOpenFileActivityBuilder().setMimeType(OpenGoogleDriveActivity.a()).setActivityTitle(a.getString(0x7f080322)).build(a.a);
                    try
                    {
                        m.b(a, OpenGoogleDriveActivity.a(a));
                        a.startIntentSenderForResult(bundle1, 40, null, 0, 0, 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Bundle bundle1)
                    {
                        Log.w("UNABLE", "Unable to send intent", bundle1);
                    }
                    a.c = true;
                }
            }

            public final void onConnectionSuspended(int i)
            {
            }

            
            {
                a = OpenGoogleDriveActivity.this;
                super();
            }
        });
    }

}
