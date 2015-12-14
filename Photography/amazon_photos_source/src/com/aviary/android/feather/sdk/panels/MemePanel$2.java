// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.text.Editable;
import android.view.View;
import com.aviary.android.feather.library.graphics.drawable.EditableDrawable;
import com.aviary.android.feather.sdk.widget.AviaryButton;
import com.aviary.android.feather.sdk.widget.DrawableHighlightView;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            MemePanel

class TextWatcher extends TextWatcher
{

    final MemePanel this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        EditableDrawable editabledrawable;
label0:
        {
            j = 0;
            i = 0;
            mLogger.info("onTextChanged", new Object[] {
                this.view
            });
            if (this.view != null && (this.view.getContent() instanceof EditableDrawable))
            {
                editabledrawable = (EditableDrawable)this.view.getContent();
                if (editabledrawable.isEditing())
                {
                    break label0;
                }
            }
            return;
        }
        editabledrawable.setText(charsequence.toString());
        if (!this.view.equals(topHv)) goto _L2; else goto _L1
_L1:
        editTopButton.setText(charsequence);
        View view = clearButtonTop;
        if (charsequence == null || charsequence.length() <= 0)
        {
            i = 4;
        }
        view.setVisibility(i);
_L4:
        if (this.view.forceUpdate())
        {
            mImageView.invalidate(this.view.getInvalidationRect());
        }
        MemePanel.access$000(MemePanel.this);
        return;
_L2:
        if (this.view.equals(bottomHv))
        {
            editBottomButton.setText(charsequence);
            View view1 = clearButtonBottom;
            if (charsequence != null && charsequence.length() > 0)
            {
                i = j;
            } else
            {
                i = 4;
            }
            view1.setVisibility(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    uch()
    {
        this$0 = MemePanel.this;
        super(MemePanel.this);
    }
}
