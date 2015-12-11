// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.LFrameLayout;
import com.aio.downloader.views.LImageButton;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.unstall:
//            Info

public class MyAppAdapter extends BaseAdapter
{
    class Mya1 extends AsyncTask
    {

        final MyAppAdapter this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            avoid = publicTools.getUrl(url);
            Log.e("gak", (new StringBuilder(String.valueOf(url))).append("=====================jsonData=").append(avoid).toString());
            if (avoid != null) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            list = new ArrayList();
            avoid = new JSONObject(avoid);
            if (avoid.getInt("status") != 1) goto _L1; else goto _L3
_L3:
            model = new DownloadMovieItem();
            avoid = avoid.getJSONObject("pdt");
            model.setId(avoid.getString("id"));
            model.setSerial(avoid.getInt("serial"));
_L5:
            return list;
            avoid;
            avoid.printStackTrace();
            if (true) goto _L5; else goto _L4
_L4:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            super.onPostExecute(arraylist);
            MobclickAgent.onEvent(context, "share");
            if (arraylist != null)
            {
                arraylist = (new StringBuilder("Share: http://android.downloadatoz.com/apps/")).append(model.getId()).append(",").append(model.getSerial()).append(".html").toString();
                Log.e("location", arraylist);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", arraylist);
                context.startActivity(Intent.createChooser(intent, "AIO Downloaded").addFlags(0x10000000));
                return;
            } else
            {
                arraylist = (new StringBuilder("Share: http://android.downloadatoz.com/search.php?q=")).append(myididididid).toString();
                Log.e("location", arraylist);
                Intent intent1 = new Intent("android.intent.action.SEND");
                intent1.setType("text/plain");
                intent1.putExtra("android.intent.extra.TEXT", arraylist);
                context.startActivity(Intent.createChooser(intent1, "AIO Downloaded"));
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        Mya1()
        {
            this$0 = MyAppAdapter.this;
            super();
        }
    }

    class ViewHolder
    {

        ImageView icon;
        LImageButton myapp_bt;
        TextView name;
        final MyAppAdapter this$0;
        TextView tv_uninstall_size;
        TextView tv_uninstall_version;
        View view_up;

        ViewHolder()
        {
            this$0 = MyAppAdapter.this;
            super();
        }
    }


    private String appVersion;
    private Context context;
    private LayoutInflater inflate;
    private List infos;
    private ArrayList list;
    private PopupWindow mWindow;
    private DownloadMovieItem model;
    private String myididididid;
    private Typeface typeFace;
    private Typeface typeFace2;
    private String url;

    public MyAppAdapter(Context context1, List list1)
    {
        typeFace = null;
        typeFace2 = null;
        url = null;
        myididididid = null;
        inflate = LayoutInflater.from(context1);
        infos = list1;
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

    private String backupApplication(String s, String s1)
    {
        if (s != null && s.length() != 0 && s1 != null && s1.length() != 0) goto _L2; else goto _L1
_L1:
        s1 = "illegal parameters";
_L5:
        return s1;
_L2:
        byte abyte0[];
        Object obj2;
        FileInputStream fileinputstream;
        int i;
        obj2 = new File((new StringBuilder("/data/app/")).append(s).append("-1.apk").toString());
        Object obj = obj2;
        if (!((File) (obj2)).exists())
        {
            obj2 = (new StringBuilder("/data/app/")).append(s).append("-2.apk").toString();
            s = new File(((String) (obj2)));
            obj = s;
            if (!s.exists())
            {
                return (new StringBuilder(String.valueOf(obj2))).append(" doesn't exist!").toString();
            }
        }
        try
        {
            fileinputstream = new FileInputStream(((File) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return s.getMessage();
        }
        i = s1.lastIndexOf('/');
        if (i != -1)
        {
            (new File(s1.substring(0, i))).mkdirs();
        }
        abyte0 = new byte[1024];
        s = null;
        obj2 = null;
        s1 = new FileOutputStream(s1);
_L3:
        i = fileinputstream.read(abyte0, 0, abyte0.length);
        Object obj1;
        if (i == -1)
        {
            if (s1 != null)
            {
                try
                {
                    s1.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return s.getMessage();
                }
            }
            if (fileinputstream != null)
            {
                try
                {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return s.getMessage();
                }
            }
            return "success";
        }
        s1.write(abyte0, 0, i);
          goto _L3
        obj1;
_L8:
        s = s1;
        ((IOException) (obj1)).printStackTrace();
        s = s1;
        obj1 = ((IOException) (obj1)).getMessage();
        s = ((String) (obj1));
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return s.getMessage();
            }
        }
        s1 = s;
        if (fileinputstream == null) goto _L5; else goto _L4
_L4:
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return s.getMessage();
        }
        return s;
        s1;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return s.getMessage();
            }
        }
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return s.getMessage();
            }
        }
        throw s1;
        obj1;
        s = s1;
        s1 = ((String) (obj1));
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        s1 = ((String) (obj2));
          goto _L8
    }

    public static int dip2px(Context context1, float f)
    {
        return (int)(f * context1.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void popuWindow(final String myPackageNmae)
    {
        View view = LayoutInflater.from(context).inflate(0x7f03009b, null);
        LFrameLayout lframelayout = (LFrameLayout)view.findViewById(0x7f07035c);
        LFrameLayout lframelayout1 = (LFrameLayout)view.findViewById(0x7f07035d);
        LFrameLayout lframelayout2 = (LFrameLayout)view.findViewById(0x7f07035e);
        LFrameLayout lframelayout3 = (LFrameLayout)view.findViewById(0x7f07035f);
        LFrameLayout lframelayout4 = (LFrameLayout)view.findViewById(0x7f070360);
        lframelayout.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppAdapter this$0;
            private final String val$myPackageNmae;

            public void onClick(View view1)
            {
                view1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse((new StringBuilder("package:")).append(myPackageNmae).toString()));
                context.startActivity(view1);
                mWindow.dismiss();
            }

            
            {
                this$0 = MyAppAdapter.this;
                myPackageNmae = s;
                super();
            }
        });
        lframelayout1.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppAdapter this$0;
            private final String val$myPackageNmae;

            public void onClick(View view1)
            {
                try
                {
                    view1 = context.getPackageManager().getLaunchIntentForPackage(myPackageNmae);
                    view1.addFlags(0x10000000);
                    context.startActivity(view1);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    Toast.makeText(context, "This program is protected", 0).show();
                }
                mWindow.dismiss();
            }

            
            {
                this$0 = MyAppAdapter.this;
                myPackageNmae = s;
                super();
            }
        });
        lframelayout2.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppAdapter this$0;
            private final String val$myPackageNmae;

            public void onClick(View view1)
            {
                view1 = new Intent("android.intent.action.DELETE", Uri.parse((new StringBuilder("package:")).append(myPackageNmae).toString()));
                inflate.getContext().startActivity(view1);
                mWindow.dismiss();
            }

            
            {
                this$0 = MyAppAdapter.this;
                myPackageNmae = s;
                super();
            }
        });
        lframelayout3.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppAdapter this$0;

            public void onClick(View view1)
            {
            }

            
            {
                this$0 = MyAppAdapter.this;
                super();
            }
        });
        lframelayout4.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppAdapter this$0;
            private final String val$myPackageNmae;

            public void onClick(View view1)
            {
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(myPackageNmae).toString();
                myididididid = myPackageNmae;
                (new Mya1()).execute(new Void[0]);
                mWindow.dismiss();
            }

            
            {
                this$0 = MyAppAdapter.this;
                myPackageNmae = s;
                super();
            }
        });
        mWindow = new PopupWindow(view);
        mWindow.setWidth(-2);
        mWindow.setHeight(-2);
        mWindow.setFocusable(true);
        myPackageNmae = new ColorDrawable(0);
        mWindow.setBackgroundDrawable(myPackageNmae);
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        long l;
        float f;
        MyAppInfo myappinfo;
        final String myPackageNmae;
        if (view == null)
        {
            view = inflate.inflate(0x7f030080, null);
            viewgroup = new ViewHolder();
            viewgroup.name = (TextView)view.findViewById(0x7f0702fa);
            viewgroup.icon = (ImageView)view.findViewById(0x7f0702f9);
            viewgroup.tv_uninstall_size = (TextView)view.findViewById(0x7f0702fd);
            viewgroup.tv_uninstall_version = (TextView)view.findViewById(0x7f0702fc);
            viewgroup.myapp_bt = (LImageButton)view.findViewById(0x7f0702fb);
            viewgroup.view_up = view.findViewById(0x7f0702f8);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        if (i == 0)
        {
            ((ViewHolder) (viewgroup)).view_up.setVisibility(0);
        } else
        {
            ((ViewHolder) (viewgroup)).view_up.setVisibility(8);
        }
        ((ViewHolder) (viewgroup)).name.setTypeface(typeFace);
        ((ViewHolder) (viewgroup)).tv_uninstall_size.setTypeface(typeFace2);
        ((ViewHolder) (viewgroup)).tv_uninstall_version.setTypeface(typeFace2);
        ((ViewHolder) (viewgroup)).name.setText(((Info)infos.get(i)).getName());
        ((ViewHolder) (viewgroup)).icon.setImageDrawable(((Info)infos.get(i)).getIcon());
        myappinfo = new MyAppInfo(context);
        l = (new File(context.getPackageManager().getPackageInfo(((Info)infos.get(i)).getPackagename(), 0).applicationInfo.publicSourceDir)).length() / 1024L;
        f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
        if (l < 1024L)
        {
            break MISSING_BLOCK_LABEL_433;
        }
        try
        {
            ((ViewHolder) (viewgroup)).tv_uninstall_size.setText((new StringBuilder(String.valueOf(f))).append("MB").toString());
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        myPackageNmae = ((Info)infos.get(i)).getPackagename();
        try
        {
            appVersion = myappinfo.getAppVersion(((Info)infos.get(i)).getPackagename());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        ((ViewHolder) (viewgroup)).tv_uninstall_version.setText((new StringBuilder("Version:")).append(appVersion).toString());
        ((ViewHolder) (viewgroup)).myapp_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppAdapter this$0;
            private final String val$myPackageNmae;

            public void onClick(View view1)
            {
                WindowManager windowmanager = (WindowManager)context.getSystemService("window");
                windowmanager.getDefaultDisplay().getWidth();
                int j = windowmanager.getDefaultDisplay().getHeight();
                int ai[] = new int[2];
                view1.getLocationOnScreen(ai);
                popuWindow(myPackageNmae);
                if (j / 2 < ai[1])
                {
                    int k = MyAppAdapter.dip2px(context, 200F);
                    mWindow.showAtLocation(view1, 0, ai[0], ai[1] - k);
                    return;
                } else
                {
                    mWindow.showAtLocation(view1, 0, ai[0], ai[1] - mWindow.getHeight());
                    return;
                }
            }

            
            {
                this$0 = MyAppAdapter.this;
                myPackageNmae = s;
                super();
            }
        });
        return view;
        ((ViewHolder) (viewgroup)).tv_uninstall_size.setText((new StringBuilder(String.valueOf(l))).append("KB").toString());
        break MISSING_BLOCK_LABEL_321;
    }












}
