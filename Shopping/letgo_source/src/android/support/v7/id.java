// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Intent;
import android.text.TextUtils;

// Referenced classes of package android.support.v7:
//            aqo

public class id
{

    public id()
    {
    }

    public Intent a(String s, String s1)
    {
        Intent intent;
        aqo.a("login type %s", new Object[] {
            s
        });
        intent = new Intent();
        if (!"posting".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        intent.setAction("com.abtnprojects.ambatana.location.action.NAV_POSTING");
_L4:
        if (!TextUtils.isEmpty(s1))
        {
            intent.putExtra("product_id", s1);
        }
        return intent;
_L2:
        if ("view-profile".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_SELF_PROFILE");
        } else
        if ("edit-profile".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_EDIT_PROFILE");
        } else
        if ("messages".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_MESSAGES");
        } else
        if ("contact".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_CONTACT");
        } else
        if ("question".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_QUESTION");
        } else
        if ("offer".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_OFFER");
        } else
        if ("favourite".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_FAV");
        } else
        if ("report-fraud".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.NAV_FRAUD");
        } else
        if ("list".equalsIgnoreCase(s))
        {
            intent.setAction("com.abtnprojects.ambatana.location.action.VIEW_LIST");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
