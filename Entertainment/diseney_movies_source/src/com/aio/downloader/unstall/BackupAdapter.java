// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            Info

public class BackupAdapter extends BaseAdapter
{
    class ViewHold
    {

        ImageView icon;
        TextView name;
        final BackupAdapter this$0;
        TextView tv_uninstall;
        TextView tv_uninstall_size;
        TextView tv_uninstall_version;
        View view_up;

        ViewHold()
        {
            this$0 = BackupAdapter.this;
            super();
        }
    }


    private final String BACKUP = "backup";
    private String appVersion;
    private Context context;
    private LayoutInflater inflate;
    private List infos;
    private ProgressDialog pd;
    private Typeface typeFace;
    private Typeface typeFace2;

    public BackupAdapter(Context context1, List list)
    {
        typeFace = null;
        typeFace2 = null;
        inflate = LayoutInflater.from(context1);
        infos = list;
        context = context1;
        try
        {
            typeFace = Typeface.createFromAsset(context1.getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(context1.getAssets(), "Roboto-Condensed.ttf");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return;
        }
    }

    public int getCount()
    {
        return infos.size();
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public Object getItem(int i)
    {
        return infos.get(i);
    }

    public long getItemId(int i)
    {
        return (long)(i + 1);
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        long l;
        float f;
        MyAppInfo myappinfo;
        if (view == null)
        {
            view = inflate.inflate(0x7f0300b7, null);
            viewgroup = new ViewHold();
            viewgroup.name = (TextView)view.findViewById(0x7f0703de);
            viewgroup.icon = (ImageView)view.findViewById(0x7f0702bc);
            viewgroup.tv_uninstall = (TextView)view.findViewById(0x7f0703e2);
            viewgroup.tv_uninstall_size = (TextView)view.findViewById(0x7f0703e0);
            viewgroup.tv_uninstall_version = (TextView)view.findViewById(0x7f0703df);
            viewgroup.view_up = view.findViewById(0x7f0702f8);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHold)view.getTag();
        }
        if (position == 0)
        {
            ((ViewHold) (viewgroup)).view_up.setVisibility(0);
        } else
        {
            ((ViewHold) (viewgroup)).view_up.setVisibility(8);
        }
        ((ViewHold) (viewgroup)).name.setTypeface(typeFace);
        ((ViewHold) (viewgroup)).tv_uninstall_size.setTypeface(typeFace2);
        ((ViewHold) (viewgroup)).tv_uninstall_version.setTypeface(typeFace2);
        ((ViewHold) (viewgroup)).tv_uninstall.setText("BackUp");
        ((ViewHold) (viewgroup)).name.setText(((Info)infos.get(position)).getName());
        ((ViewHold) (viewgroup)).icon.setImageDrawable(((Info)infos.get(position)).getIcon());
        myappinfo = new MyAppInfo(context);
        l = (new File(context.getPackageManager().getPackageInfo(((Info)infos.get(position)).getPackagename(), 0).applicationInfo.publicSourceDir)).length() / 1024L;
        f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
        if (l < 1024L)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        try
        {
            ((ViewHold) (viewgroup)).tv_uninstall_size.setText((new StringBuilder(String.valueOf(f))).append("MB").toString());
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        try
        {
            appVersion = myappinfo.getAppVersion(((Info)infos.get(position)).getPackagename());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        ((ViewHold) (viewgroup)).tv_uninstall_version.setText((new StringBuilder("Version:")).append(appVersion).toString());
        ((ViewHold) (viewgroup)).tv_uninstall.setOnClickListener(new android.view.View.OnClickListener() {

            private File apkFile;
            private File backupFile;
            final BackupAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = ((Info)infos.get(position)).getPackagename();
                apkFile = new File((new StringBuilder("/data/app/")).append(view1).append("-1.apk").toString());
                try
                {
                    if (!apkFile.exists())
                    {
                        apkFile = new File((new StringBuilder("/data/app/")).append(view1).append("-2.apk").toString());
                        if (!apkFile.exists())
                        {
                            Toast.makeText(context, "This app does not support backup.", 0).show();
                        }
                    }
                }
                catch (Exception exception1) { }
                backupFile = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIO_BACKUPAPP").append(File.separator).append(view1).append(".apk").toString());
                (new AsyncTask() {

                    final _cls1 this$1;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        Myutils.copyfile(apkFile, backupFile, Boolean.valueOf(false));
                        return null;
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                        pd.dismiss();
                        if (apkFile.exists())
                        {
                            Toast.makeText(context, "Backup successfully", 0).show();
                        }
                        void1 = new Intent("backup");
                        context.sendBroadcast(void1);
                    }

                    protected void onPreExecute()
                    {
                        super.onPreExecute();
                        pd = ProgressDialog.show(context, "", "Waitting for backup...", true);
                        pd.setCancelable(true);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).execute(new Void[0]);
            }




            
            {
                this$0 = BackupAdapter.this;
                position = i;
                super();
            }
        });
        return view;
        ((ViewHold) (viewgroup)).tv_uninstall_size.setText((new StringBuilder(String.valueOf(l))).append("KB").toString());
        break MISSING_BLOCK_LABEL_322;
    }




}
