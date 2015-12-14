// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.wantu.activity.guide.GuideViewAcitivity;

public class bik
    implements android.content.DialogInterface.OnClickListener
{

    final GuideViewAcitivity a;

    public bik(GuideViewAcitivity guideviewacitivity)
    {
        a = guideviewacitivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = a;
        StringBuilder stringbuilder = (new StringBuilder()).append("isNeedGotoGuideView_");
        apq.c();
        dialoginterface = dialoginterface.getSharedPreferences(stringbuilder.append(apq.a).toString(), 0).edit();
        dialoginterface.putBoolean("isGotoGuideView", true);
        dialoginterface.commit();
        a.finish();
    }
}
