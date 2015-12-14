// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdButton

class <init>
    implements android.widget.ctoryImpl
{

    final TAdButton this$0;

    public View makeView()
    {
        ImageView imageview = new ImageView(TAdButton.access$400(TAdButton.this));
        imageview.setBackgroundColor(0);
        imageview.setScaleType(android.widget._CROP);
        imageview.setLayoutParams(new android.widget.init>(-1, -1));
        return imageview;
    }

    private ()
    {
        this$0 = TAdButton.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
