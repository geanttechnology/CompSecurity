// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.media.MediaScannerConnection;
import android.view.View;
import android.widget.Toast;
import com.bitstrips.imoji.util.FileUtil;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ShareImageDialogFragment

class this._cls0
    implements android.view.ragment._cls3
{

    final ShareImageDialogFragment this$0;

    public void onClick(View view)
    {
        addToRecents();
        filePath = fileUtil.saveImoji(filePath);
        MediaScannerConnection.scanFile(getActivity(), new String[] {
            filePath
        }, new String[] {
            "image/png"
        }, null);
        Toast.makeText(getActivity(), 0x7f0600d7, 1).show();
        dismiss();
    }

    ()
    {
        this$0 = ShareImageDialogFragment.this;
        super();
    }
}
