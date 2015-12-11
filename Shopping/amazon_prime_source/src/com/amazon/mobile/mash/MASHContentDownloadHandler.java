// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.widget.Toast;
import com.amazon.mobile.mash.util.MASHDebug;
import java.io.File;

// Referenced classes of package com.amazon.mobile.mash:
//            MASHWebView

public class MASHContentDownloadHandler
    implements DownloadListener
{

    public static final String MIME_TYPE_PDF = "application/pdf";
    private MASHWebView mMASHWebView;

    public MASHContentDownloadHandler(MASHWebView mashwebview)
    {
        mMASHWebView = mashwebview;
    }

    private boolean canLaunchPdfReader(Activity activity, Uri uri)
    {
        String s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        uri = new File((new StringBuilder()).append(s).append(File.separator).append(uri.getLastPathSegment()).toString());
        uri = getPdfReaderIntent(Uri.parse((new StringBuilder()).append("file://").append(uri.getAbsolutePath()).toString()));
        return activity.getPackageManager().resolveActivity(uri, 0) != null;
    }

    private void clearBlankPage(Activity activity)
    {
        if (mMASHWebView.copyBackForwardList().getSize() == 0)
        {
            activity.finish();
        }
    }

    private void deleteFile(String s)
    {
        String s1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        s = new File((new StringBuilder()).append(s1).append(File.separator).append(s).toString());
        if (s.exists() && !s.delete() && MASHDebug.isEnabled())
        {
            Log.v("MASH", "can not delete existed file");
        }
    }

    private void downloadAndOpenFile(final Activity activity, final Uri receiver)
    {
        final DownloadManager downloadManager = (DownloadManager)activity.getSystemService("download");
        android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(receiver);
        final ProgressDialog progress;
        final long queryId;
        try
        {
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, receiver.getLastPathSegment());
        }
        // Misplaced declaration of an exception variable
        catch (final Uri receiver)
        {
            Toast.makeText(activity, R.string.mash_download_file_error, 0).show();
            clearBlankPage(activity);
            return;
        }
        progress = new ProgressDialog(activity);
        progress.setMessage(activity.getString(R.string.mash_download_file));
        progress.show();
        deleteFile(receiver.getLastPathSegment());
        queryId = downloadManager.enqueue(request);
        receiver = new BroadcastReceiver() {

            final MASHContentDownloadHandler this$0;
            final Activity val$activity;
            final DownloadManager val$downloadManager;
            final ProgressDialog val$progress;
            final long val$queryId;

            public void onReceive(Context context, Intent intent)
            {
                progress.dismiss();
                activity.unregisterReceiver(this);
                if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction()))
                {
                    context = downloadManager.query((new android.app.DownloadManager.Query()).setFilterById(new long[] {
                        queryId
                    }));
                    if (context.moveToFirst())
                    {
                        if (context.getInt(context.getColumnIndex("status")) == 8)
                        {
                            intent = context.getString(context.getColumnIndex("local_uri"));
                            String s = context.getString(context.getColumnIndex("media_type"));
                            downloadSuccessful(activity, Uri.parse(intent), s);
                        } else
                        {
                            Toast.makeText(activity, R.string.mash_download_file_error_try_again, 0).show();
                        }
                    }
                    context.close();
                    clearBlankPage(activity);
                }
            }

            
            {
                this$0 = MASHContentDownloadHandler.this;
                progress = progressdialog;
                activity = activity1;
                downloadManager = downloadmanager;
                queryId = l;
                super();
            }
        };
        activity.registerReceiver(receiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        progress.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final MASHContentDownloadHandler this$0;
            final Activity val$activity;
            final DownloadManager val$downloadManager;
            final long val$queryId;
            final BroadcastReceiver val$receiver;

            public void onCancel(DialogInterface dialoginterface)
            {
                downloadManager.remove(new long[] {
                    queryId
                });
                activity.unregisterReceiver(receiver);
                clearBlankPage(activity);
            }

            
            {
                this$0 = MASHContentDownloadHandler.this;
                downloadManager = downloadmanager;
                queryId = l;
                activity = activity1;
                receiver = broadcastreceiver;
                super();
            }
        });
    }

    private void downloadSuccessful(Activity activity, Uri uri, String s)
    {
        if ("application/pdf".equalsIgnoreCase(s))
        {
            activity.startActivityForResult(getPdfReaderIntent(uri), 0);
        }
    }

    private Intent getPdfReaderIntent(Uri uri)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/pdf");
        intent.addFlags(0x4000000);
        intent.addFlags(0x10000000);
        modifyIntentWithActivityClearTaskFlag(intent);
        return intent;
    }

    private void modifyIntentWithActivityClearTaskFlag(Intent intent)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            intent.addFlags(32768);
        }
    }

    public void onDownloadStart(String s, final String activity, String s1, String s2, long l)
    {
label0:
        {
            activity = mMASHWebView.getActivity();
            s = Uri.parse(s);
            if (activity != null && "application/pdf".equalsIgnoreCase(s2))
            {
                if (canLaunchPdfReader(activity, s))
                {
                    break label0;
                }
                s = new android.app.AlertDialog.Builder(activity);
                s.setMessage(R.string.mash_need_install_pdf);
                s.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final MASHContentDownloadHandler this$0;
                    final Activity val$activity;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        clearBlankPage(activity);
                    }

            
            {
                this$0 = MASHContentDownloadHandler.this;
                activity = activity1;
                super();
            }
                });
                s.create().show();
            }
            return;
        }
        downloadAndOpenFile(activity, s);
    }


}
