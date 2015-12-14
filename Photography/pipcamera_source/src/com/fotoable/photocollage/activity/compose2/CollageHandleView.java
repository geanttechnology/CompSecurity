// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fotoable.photocollage.model.res.collage.TPhotoCollageComposeInfo;
import com.fotoable.photocollage.view.compose2.Compose2ModuleBgView;
import com.fotoable.photocollage.view.compose2.Compose2ModuleCornorView;
import com.fotoable.photocollage.view.compose2.Compose2ModuleFramesView;
import java.util.ArrayList;
import java.util.List;
import lc;
import ld;
import le;
import lf;
import lg;

// Referenced classes of package com.fotoable.photocollage.activity.compose2:
//            ComposePhotoesActivity2

public class CollageHandleView extends FrameLayout
{

    private TextView btnBackground;
    Button btnClsoeHandleView;
    private TextView btnEffects;
    private TextView btnStyles;
    private com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType composeModuleType;
    private FrameLayout handViewContainer;
    boolean isHasBK;
    boolean isHasShape;
    TPhotoCollageComposeInfo lastComposeInfo;
    float lastInfoEdge;
    float lastInfoRadius;
    List mBitmapList;
    private Context mContext;
    public lg mListener;
    private Compose2ModuleBgView moduleBgSelectorView;
    private Compose2ModuleCornorView moduleCornorSelectorView;
    private Compose2ModuleFramesView moduleFrameSelectorView;
    int photoCount;

    public CollageHandleView(Context context)
    {
        super(context);
        composeModuleType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        mBitmapList = new ArrayList();
        mContext = context;
        init();
    }

    public CollageHandleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        composeModuleType = com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType.COMPOSE_11;
        mBitmapList = new ArrayList();
        mContext = context;
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03009f, this, true);
        handViewContainer = (FrameLayout)findViewById(0x7f0c027c);
        moduleFrameSelectorView = (Compose2ModuleFramesView)findViewById(0x7f0c027d);
        moduleFrameSelectorView.setOnModuleClickListener((ComposePhotoesActivity2)mContext);
        moduleCornorSelectorView = (Compose2ModuleCornorView)findViewById(0x7f0c027e);
        moduleCornorSelectorView.setOnCornorChangeListener((ComposePhotoesActivity2)mContext);
        moduleBgSelectorView = (Compose2ModuleBgView)findViewById(0x7f0c027f);
        moduleBgSelectorView.setOnBgChangeListener((ComposePhotoesActivity2)mContext);
        btnStyles = (TextView)findViewById(0x7f0c0278);
        btnStyles.setTextColor(0xff007aff);
        btnStyles.setOnClickListener(new lf(this));
        btnEffects = (TextView)findViewById(0x7f0c0279);
        btnEffects.setOnClickListener(new le(this));
        btnBackground = (TextView)findViewById(0x7f0c027a);
        btnBackground.setOnClickListener(new ld(this));
        btnClsoeHandleView = (Button)findViewById(0x7f0c027b);
        btnClsoeHandleView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final CollageHandleView a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0 || motionevent.getAction() == 2)
                {
                    a.btnClsoeHandleView.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
                } else
                {
                    a.btnClsoeHandleView.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                }
                return false;
            }

            
            {
                a = CollageHandleView.this;
                super();
            }
        });
        btnClsoeHandleView.setOnClickListener(new lc(this));
    }

    public void setBK(boolean flag)
    {
        isHasBK = flag;
    }

    public void setCornorInfo()
    {
        moduleCornorSelectorView.setRadius(lastInfoRadius);
        moduleCornorSelectorView.setEdge(lastInfoEdge);
        moduleCornorSelectorView.setIsBK(isHasBK);
        moduleCornorSelectorView.setIsShadow(isHasShape);
    }

    public void setData(int i, com.fotoable.photocollage.service.collage.FixComposeResourceManager.FixComposeType fixcomposetype)
    {
        photoCount = i;
        moduleFrameSelectorView.setPhotosCount(photoCount, fixcomposetype, false);
        TPhotoCollageComposeInfo tphotocollagecomposeinfo = moduleFrameSelectorView.getLastComposeInfo(composeModuleType);
        fixcomposetype = tphotocollagecomposeinfo;
        if (tphotocollagecomposeinfo == null)
        {
            fixcomposetype = moduleFrameSelectorView.getDefaultComposeInfo();
        }
        lastInfoEdge = fixcomposetype.getDefaultEdge();
        lastInfoRadius = fixcomposetype.getRoundRadius();
        if (moduleCornorSelectorView != null && moduleCornorSelectorView.getVisibility() == 0)
        {
            setCornorInfo();
        }
    }

    public void setEdge(float f)
    {
        lastInfoEdge = f;
    }

    public void setListener(lg lg)
    {
        mListener = lg;
    }

    public void setRadius(float f)
    {
        lastInfoRadius = f;
    }

    public void setShadow(boolean flag)
    {
        isHasShape = flag;
    }






}
