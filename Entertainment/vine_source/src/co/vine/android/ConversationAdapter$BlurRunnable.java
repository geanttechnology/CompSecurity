// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v8.renderscript.RenderScript;
import android.widget.ImageView;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RsBlur;

// Referenced classes of package co.vine.android:
//            ConversationAdapter

public class imageView
    implements Runnable
{

    private final Bitmap bitmap;
    private final ImageView imageView;
    private boolean setImage;
    final ConversationAdapter this$0;

    public void run()
    {
        if (ConversationAdapter.access$1300(ConversationAdapter.this) == null)
        {
            ConversationAdapter.access$1302(ConversationAdapter.this, RecordConfigUtils.createDefaultSizeBitmap());
        }
        if (ConversationAdapter.access$1400(ConversationAdapter.this) == null)
        {
            ConversationAdapter.access$1402(ConversationAdapter.this, new RsBlur(RenderScript.create(ConversationAdapter.access$000(ConversationAdapter.this)), ConversationAdapter.access$1300(ConversationAdapter.this), 25F));
        }
        if (setImage)
        {
            imageView.setImageBitmap(ConversationAdapter.access$1300(ConversationAdapter.this));
            return;
        } else
        {
            ConversationAdapter.access$1400(ConversationAdapter.this).execute(bitmap, ConversationAdapter.access$1300(ConversationAdapter.this), 6);
            setImage = true;
            ConversationAdapter.access$1500(ConversationAdapter.this).post(this);
            return;
        }
    }

    public (Bitmap bitmap1, ImageView imageview)
    {
        this$0 = ConversationAdapter.this;
        super();
        bitmap = bitmap1;
        imageView = imageview;
    }
}
