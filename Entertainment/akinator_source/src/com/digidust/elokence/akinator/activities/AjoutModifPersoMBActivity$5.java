// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AjoutModifPersoMBActivity

class this._cls0
    implements android.content.ner
{

    final AjoutModifPersoMBActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, 3);
_L4:
        dialoginterface.dismiss();
        return;
_L2:
        if (i == 1)
        {
            Intent intent1 = new Intent("android.intent.action.GET_CONTENT", null);
            intent1.setType("image/*");
            intent1.putExtra("return-data", true);
            startActivityForResult(intent1, 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = AjoutModifPersoMBActivity.this;
        super();
    }
}
