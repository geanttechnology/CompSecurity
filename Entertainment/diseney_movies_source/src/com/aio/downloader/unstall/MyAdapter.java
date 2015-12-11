// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.utils.MyAppInfo;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            ViewHold, Info

public class MyAdapter extends BaseAdapter
{

    private String appVersion;
    private Context context;
    private LayoutInflater inflate;
    private List infos;
    private Typeface typeFace;
    private Typeface typeFace2;

    public MyAdapter(Context context1, List list)
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
        ((ViewHold) (viewgroup)).name.setText(((Info)infos.get(position)).getName());
        ((ViewHold) (viewgroup)).icon.setImageDrawable(((Info)infos.get(position)).getIcon());
        myappinfo = new MyAppInfo(context);
        l = (new File(context.getPackageManager().getPackageInfo(((Info)infos.get(position)).getPackagename(), 0).applicationInfo.publicSourceDir)).length() / 1024L;
        f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
        if (l < 1024L)
        {
            break MISSING_BLOCK_LABEL_404;
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

            final MyAdapter this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                view1 = new Intent("android.intent.action.DELETE", Uri.parse((new StringBuilder("package:")).append(((Info)infos.get(position)).getPackagename()).toString()));
                inflate.getContext().startActivity(view1);
            }

            
            {
                this$0 = MyAdapter.this;
                position = i;
                super();
            }
        });
        return view;
        ((ViewHold) (viewgroup)).tv_uninstall_size.setText((new StringBuilder(String.valueOf(l))).append("KB").toString());
        break MISSING_BLOCK_LABEL_312;
    }


}
