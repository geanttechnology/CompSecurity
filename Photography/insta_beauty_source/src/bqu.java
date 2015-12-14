// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.fotoable.onLineImage.ImageButtonOnLine;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.view.TPipListScrollView;

public class bqu extends ArrayAdapter
{

    final TPipListScrollView a;
    private LayoutInflater b;

    public bqu(TPipListScrollView tpiplistscrollview, Context context, TDFSceneInfo atdfsceneinfo[])
    {
        a = tpiplistscrollview;
        super(context, 0x7f03004a, atdfsceneinfo);
        b = (LayoutInflater)getContext().getSystemService("layout_inflater");
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj = view;
        TDFSceneInfo tdfsceneinfo = (TDFSceneInfo)getItem(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        obj = view;
        view = b.inflate(0x7f03004a, viewgroup, false);
        obj = view;
        ImageButtonOnLine imagebuttononline = (ImageButtonOnLine)view.findViewById(0x7f0d01c1);
        obj = view;
        imagebuttononline.setTag(tdfsceneinfo);
        obj = view;
        viewgroup = new bqv(this, null);
        obj = view;
        viewgroup.a = imagebuttononline;
        obj = view;
        view.setTag(viewgroup);
_L7:
        if (tdfsceneinfo.getResType() != EResType.ONLINE) goto _L4; else goto _L3
_L3:
        ((bqv) (viewgroup)).a.setImageBitmapFromUrl(tdfsceneinfo.icon);
_L11:
        if (TPipListScrollView.access$100(a) != i) goto _L6; else goto _L5
_L5:
        ((bqv) (viewgroup)).a.setSelected(true);
_L13:
        return view;
_L2:
        obj = view;
        viewgroup = (bqv)view.getTag();
        obj = view;
        ((bqv) (viewgroup)).a.setImageBitmap(null);
        obj = view;
        ((bqv) (viewgroup)).a.setSelected(false);
        obj = view;
        ((bqv) (viewgroup)).a.setTag(tdfsceneinfo);
          goto _L7
_L4:
        if (tdfsceneinfo.getResType() != EResType.NETWORK) goto _L9; else goto _L8
_L8:
        int j = tdfsceneinfo.icon.lastIndexOf("/");
        obj = tdfsceneinfo.icon.substring(j + 1);
        obj = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, ((String) (obj)));
_L12:
        if (obj == null) goto _L11; else goto _L10
_L10:
        ((bqv) (viewgroup)).a.setImageBitmap(((android.graphics.Bitmap) (obj)));
          goto _L11
        obj;
        viewgroup = view;
_L14:
        ((Exception) (obj)).printStackTrace();
        return viewgroup;
_L9:
        obj = tdfsceneinfo.getIconBitmap();
          goto _L12
_L6:
        ((bqv) (viewgroup)).a.setSelected(false);
          goto _L13
        view;
        viewgroup = ((ViewGroup) (obj));
        obj = view;
          goto _L14
    }
}
