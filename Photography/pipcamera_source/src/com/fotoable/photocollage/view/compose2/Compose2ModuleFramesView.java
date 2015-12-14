// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.service.collage.FixComposeResourceManager;
import com.fotoable.photocollage.view.compose2.frames.FixFramePagerAdapter;
import com.fotoable.photocollage.view.compose2.frames.FixFramesScrollPageView;
import com.fotoable.photocollage.view.compose2.indicate.CirclePageIndicator;
import com.fotoable.shareinstagram.ImageView_Color;
import com.wantu.model.res.TResInfo;
import java.util.List;
import mg;
import mh;
import mi;

public class Compose2ModuleFramesView extends FrameLayout
    implements mi
{

    FixFramePagerAdapter adapter;
    mg callback;
    CirclePageIndicator circlePageIndicator1;
    com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType composeType;
    FixComposeResourceManager fixComposeManager;
    FixFramesScrollPageView fixFramesSelectorPageView;
    ImageView_Color img1_1;
    ImageView_Color img3_4;
    TPhotoCollageComposeInfo lastRectComposeInfo;
    TPhotoCollageComposeInfo lastSquareComposeInfo;
    List mComposeInfoList;
    int photoCount;
    FrameLayout tab1_1;
    FrameLayout tab4_3;

    public Compose2ModuleFramesView(Context context)
    {
        super(context);
        fixComposeManager = new FixComposeResourceManager();
        composeType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300b0, this, true);
        initView();
    }

    public Compose2ModuleFramesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        fixComposeManager = new FixComposeResourceManager();
        composeType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300b0, this, true);
        initView();
    }

    public Compose2ModuleFramesView(Context context, AttributeSet attributeset, com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype)
    {
        super(context, attributeset);
        fixComposeManager = new FixComposeResourceManager();
        composeType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        composeType = fixcomposetype;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300b0, this, true);
        initView();
    }

    private void initView()
    {
        img1_1 = (ImageView_Color)findViewById(0x7f0c02bc);
        img3_4 = (ImageView_Color)findViewById(0x7f0c02be);
        tab1_1 = (FrameLayout)findViewById(0x7f0c02bb);
        tab4_3 = (FrameLayout)findViewById(0x7f0c02bd);
        setImageStyle(composeType);
        tab1_1.setOnClickListener(new android.view.View.OnClickListener() {

            final Compose2ModuleFramesView a;

            public void onClick(View view)
            {
                if (a.composeType == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11)
                {
                    return;
                }
                a.tab1_1.setEnabled(false);
                a.tab4_3.setEnabled(false);
                a.composeType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
                a.setImageStyle(a.composeType);
                if (a.lastSquareComposeInfo == null)
                {
                    a.lastSquareComposeInfo = mh.a(a.composeType, a.photoCount);
                }
                a.changeAdapter(a.composeType, a.lastSquareComposeInfo);
                if (a.callback != null)
                {
                    a.callback.a(a.composeType, a.lastSquareComposeInfo);
                }
                a.tab1_1.setEnabled(true);
                a.tab4_3.setEnabled(true);
            }

            
            {
                a = Compose2ModuleFramesView.this;
                super();
            }
        });
        tab4_3.setOnClickListener(new android.view.View.OnClickListener() {

            final Compose2ModuleFramesView a;

            public void onClick(View view)
            {
                if (a.composeType == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43)
                {
                    return;
                }
                a.tab1_1.setEnabled(false);
                a.tab4_3.setEnabled(false);
                a.composeType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43;
                a.setImageStyle(a.composeType);
                if (a.lastRectComposeInfo == null)
                {
                    a.lastRectComposeInfo = mh.a(a.composeType, a.photoCount);
                }
                a.changeAdapter(a.composeType, a.lastRectComposeInfo);
                if (a.callback != null)
                {
                    a.callback.a(a.composeType, a.lastRectComposeInfo);
                }
                a.tab1_1.setEnabled(true);
                a.tab4_3.setEnabled(true);
            }

            
            {
                a = Compose2ModuleFramesView.this;
                super();
            }
        });
        fixFramesSelectorPageView = (FixFramesScrollPageView)findViewById(0x7f0c02c0);
        circlePageIndicator1 = (CirclePageIndicator)findViewById(0x7f0c02b1);
    }

    private void setImageStyle(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype)
    {
        if (fixcomposetype == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11)
        {
            img1_1.setSelected(true);
            img3_4.setSelected(false);
            return;
        } else
        {
            img1_1.setSelected(false);
            img3_4.setSelected(true);
            return;
        }
    }

    public void changeAdapter(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, TPhotoCollageComposeInfo tphotocollagecomposeinfo)
    {
        mComposeInfoList = fixComposeManager.a(fixcomposetype, photoCount);
        if (adapter != null)
        {
            adapter.a();
        }
        float f;
        int i;
        if (fixcomposetype == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11)
        {
            f = 1.0F;
        } else
        {
            f = 0.75F;
        }
        adapter = new FixFramePagerAdapter(f);
        adapter.a(mComposeInfoList);
        adapter.a(this);
        i = adapter.a(tphotocollagecomposeinfo);
        fixFramesSelectorPageView.setDataAdapter(adapter);
        circlePageIndicator1.setViewPager(fixFramesSelectorPageView.getPager());
        circlePageIndicator1.setCentered(true);
        fixFramesSelectorPageView.setSelectedPageIndex(i);
    }

    public void clear()
    {
        if (adapter != null)
        {
            adapter.a();
        }
        lastRectComposeInfo = null;
        lastSquareComposeInfo = null;
    }

    public com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType getComposeType()
    {
        return composeType;
    }

    public TPhotoCollageComposeInfo getDefaultComposeInfo()
    {
        if (mComposeInfoList != null && mComposeInfoList.size() > 0)
        {
            return (TPhotoCollageComposeInfo)mComposeInfoList.get(0);
        } else
        {
            return null;
        }
    }

    public TPhotoCollageComposeInfo getLastComposeInfo(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype)
    {
        if (fixcomposetype == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11)
        {
            return lastSquareComposeInfo;
        } else
        {
            return lastRectComposeInfo;
        }
    }

    public void resItemSelected(TResInfo tresinfo)
    {
        if (tresinfo != null && (tresinfo instanceof TPhotoCollageComposeInfo))
        {
            tresinfo = (TPhotoCollageComposeInfo)tresinfo;
            if (tresinfo.getAspectRatio() > 1.0F)
            {
                lastRectComposeInfo = tresinfo;
            } else
            {
                lastSquareComposeInfo = tresinfo;
            }
            if (callback != null)
            {
                callback.a(composeType, tresinfo);
            }
        }
    }

    public void setComposeItem(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, TPhotoCollageComposeInfo tphotocollagecomposeinfo)
    {
        setImageStyle(fixcomposetype);
        composeType = fixcomposetype;
        changeAdapter(composeType, tphotocollagecomposeinfo);
    }

    public void setOnModuleClickListener(mg mg1)
    {
        callback = mg1;
    }

    public void setPhotosCount(int i, com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, boolean flag)
    {
        photoCount = i;
        setImageStyle(fixcomposetype);
        switch1_4_3(fixcomposetype, flag);
    }

    public void switch1_4_3(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype, boolean flag)
    {
        composeType = fixcomposetype;
        if (lastRectComposeInfo == null)
        {
            lastRectComposeInfo = mh.a(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_43, photoCount);
        }
        if (lastSquareComposeInfo == null)
        {
            lastSquareComposeInfo = mh.a(com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11, photoCount);
        }
        if (composeType == com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11)
        {
            changeAdapter(fixcomposetype, lastSquareComposeInfo);
            if (flag && callback != null)
            {
                callback.a(fixcomposetype, lastSquareComposeInfo);
            }
        } else
        {
            changeAdapter(fixcomposetype, lastRectComposeInfo);
            if (flag && callback != null)
            {
                callback.a(fixcomposetype, lastRectComposeInfo);
                return;
            }
        }
    }

}
