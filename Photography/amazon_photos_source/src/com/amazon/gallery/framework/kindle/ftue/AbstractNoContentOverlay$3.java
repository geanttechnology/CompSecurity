// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            AbstractNoContentOverlay

class val.viewDescriptor
    implements Runnable
{

    final AbstractNoContentOverlay this$0;
    final boolean val$finalized;
    final ViewDescriptor val$viewDescriptor;

    public void run()
    {
label0:
        {
            synchronized (AbstractNoContentOverlay.this)
            {
                if (attached)
                {
                    break label0;
                }
            }
            return;
        }
        if (val$finalized)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        hide();
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        return;
        exception;
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        throw exception;
        if (val$viewDescriptor.getCollectionType() != com.amazon.gallery.framework.gallery.view.pe.TAG && val$viewDescriptor.getCollectionType() != com.amazon.gallery.framework.gallery.view.pe.CUSTOM_DATA_SET)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        hide();
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        return;
        if (val$viewDescriptor.getMediaProperty() != CommonMediaProperty.CAMERA) goto _L2; else goto _L1
_L1:
        nextContentMode = com.amazon.gallery.framework.kindle.ui.e.CAMERA;
_L3:
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        return;
_L2:
label1:
        {
            if (val$viewDescriptor.getCollectionType() != com.amazon.gallery.framework.gallery.view.pe.EVERYTHING)
            {
                break label1;
            }
            nextContentMode = com.amazon.gallery.framework.kindle.ui.e.ALL;
        }
          goto _L3
label2:
        {
            if (val$viewDescriptor.getMediaType() != MediaType.VIDEO)
            {
                break label2;
            }
            nextContentMode = com.amazon.gallery.framework.kindle.ui.e.VIDEOS;
        }
          goto _L3
label3:
        {
            if (val$viewDescriptor.getTag() == null || val$viewDescriptor.getTag().getType() != TagType.ALBUM)
            {
                break label3;
            }
            nextContentMode = com.amazon.gallery.framework.kindle.ui.e.ALBUM;
        }
          goto _L3
label4:
        {
            if (val$viewDescriptor.getTag() == null || val$viewDescriptor.getTag().getType() != TagType.FOLDER)
            {
                break label4;
            }
            nextContentMode = com.amazon.gallery.framework.kindle.ui.e.CLOUD;
        }
          goto _L3
        nextContentMode = com.amazon.gallery.framework.kindle.ui.e.DEVICE;
          goto _L3
    }

    ype()
    {
        this$0 = final_abstractnocontentoverlay;
        val$finalized = flag;
        val$viewDescriptor = ViewDescriptor.this;
        super();
    }
}
