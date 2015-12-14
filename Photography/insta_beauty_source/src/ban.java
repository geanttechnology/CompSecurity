// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.NewPhotoShareActivity;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.compose.MagComposeFragement;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;

class ban
    implements Runnable
{

    final String a;
    final bal b;

    ban(bal bal1, String s)
    {
        b = bal1;
        a = s;
        super();
    }

    public void run()
    {
        if (b.c.mActivity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        b.c.mActivity.b();
        Log.v(MagComposeFragement.access$300(b.c), (new StringBuilder()).append(MagComposeFragement.access$300(b.c)).append("write ResultImage end").toString());
        if (b.a != null && !b.a.isRecycled())
        {
            b.a.recycle();
        }
        if (a.equals("")) goto _L1; else goto _L3
_L3:
        b.c.mActivity.k;
        JVM INSTR tableswitch 13 14: default 148
    //                   13 262
    //                   14 287;
           goto _L4 _L5 _L6
_L4:
        Intent intent = new Intent(b.c.mActivity, com/fotoable/fotobeauty/NewPhotoShareActivity);
        intent.putExtra("image_file_path", a);
        if (b.c.mActivity.d().isShouldFirst())
        {
            String s = b.c.mActivity.d().getShareTag();
            if (s != null && s.length() > 0)
            {
                intent.putExtra("share_tag", s);
            }
        }
        b.c.startActivity(intent);
        b.c.getActivity().overridePendingTransition(0x7f040009, 0);
        return;
_L5:
        FlurryAgent.logEvent("PhotoSave_QuickSnap");
        Log.e(MagComposeFragement.access$300(b.c), "flurry photosave_quickSnap");
        continue; /* Loop/switch isn't completed */
_L6:
        FlurryAgent.logEvent("PhotoSave_Collage");
        Log.e(MagComposeFragement.access$300(b.c), "flurry PhotoSave_Collage");
        if (true) goto _L4; else goto _L7
_L7:
    }
}
