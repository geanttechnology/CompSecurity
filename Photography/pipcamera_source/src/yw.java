// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.crashlytics.android.Crashlytics;
import com.fotoable.onLineImage.ImageButtonOnLine;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.view.TPipStyleListScrollView;

public class yw extends ArrayAdapter
{

    final TPipStyleListScrollView a;
    private LayoutInflater b;

    public yw(TPipStyleListScrollView tpipstylelistscrollview, Context context, TDFSceneInfo atdfsceneinfo[])
    {
        a = tpipstylelistscrollview;
        super(context, 0x7f030077, atdfsceneinfo);
        b = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = b.inflate(0x7f030077, viewgroup, false);
        obj = view;
        ImageButtonOnLine imagebuttononline = (ImageButtonOnLine)view.findViewById(0x7f0c0101);
        obj = view;
        imagebuttononline.setTag(tdfsceneinfo);
        obj = view;
        viewgroup = new yx(this, null);
        obj = view;
        viewgroup.a = imagebuttononline;
        obj = view;
        view.setTag(viewgroup);
        obj = viewgroup;
_L7:
        if (tdfsceneinfo.getResType() != EResType.ONLINE) goto _L4; else goto _L3
_L3:
        ((yx) (obj)).a.setImageBitmapFromUrl(tdfsceneinfo.icon);
_L13:
        if (TPipStyleListScrollView.access$100(a) != i) goto _L6; else goto _L5
_L5:
        ((yx) (obj)).a.setSelected(true);
_L15:
        return view;
_L2:
        obj = view;
        viewgroup = (yx)view.getTag();
        obj = view;
        ((yx) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((yx) (viewgroup)).a.setSelected(false);
        obj = view;
        ((yx) (viewgroup)).a.setTag(tdfsceneinfo);
        obj = viewgroup;
          goto _L7
_L4:
        if (tdfsceneinfo.getResType() != EResType.NETWORK) goto _L9; else goto _L8
_L8:
        int j = tdfsceneinfo.icon.lastIndexOf("/");
        viewgroup = tdfsceneinfo.icon.substring(j + 1);
        if (tdfsceneinfo.folderName == null || tdfsceneinfo.folderName.length() <= 0) goto _L11; else goto _L10
_L10:
        viewgroup = FileManager.getInstance().getPipFileCache().a();
        viewgroup = (new StringBuilder()).append(viewgroup).append("/").append(tdfsceneinfo.folderName).append("/").append(tdfsceneinfo.icon).toString();
        viewgroup = FileManager.getInstance().getBitmapByFilePath(viewgroup);
_L14:
        if (viewgroup == null) goto _L13; else goto _L12
_L12:
        ((yx) (obj)).a.setImageBitmap(viewgroup);
          goto _L13
        obj;
        viewgroup = view;
_L16:
        ((Exception) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return viewgroup;
_L11:
        viewgroup = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, viewgroup);
          goto _L14
_L9:
        viewgroup = tdfsceneinfo.getIconBitmap();
          goto _L14
_L6:
        ((yx) (obj)).a.setSelected(false);
          goto _L15
        view;
        viewgroup = ((ViewGroup) (obj));
        obj = view;
          goto _L16
    }
}
