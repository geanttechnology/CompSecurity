// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.helpshift.c.a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            HSAddIssueFragment, l

class a extends Handler
{

    final a a;

    public void handleMessage(Message message)
    {
        try
        {
            HSAddIssueFragment.b(a.a).a(a.a.b, HSAddIssueFragment.q(a.a), HSAddIssueFragment.r(a.a), HSAddIssueFragment.s(a.a));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.d("HelpShiftDebug", "Something really foul has happened", message);
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/helpshift/HSAddIssueFragment$9

/* anonymous class */
    class HSAddIssueFragment._cls9 extends Handler
    {

        final HSAddIssueFragment a;

        public void handleMessage(Message message)
        {
            try
            {
                message = (JSONObject)((HashMap)message.obj).get("response");
                HSAddIssueFragment.b(a).g(message.get("id").toString());
                HSAddIssueFragment.b(a).d(new HSAddIssueFragment._cls9._cls1(this), HSAddIssueFragment.q(a));
                HSAddIssueFragment.b(a).p();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.d("HelpShiftDebug", message.getMessage(), message);
            }
        }

            
            {
                a = hsaddissuefragment;
                super();
            }
    }

}
