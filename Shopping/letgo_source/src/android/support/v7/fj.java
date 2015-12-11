// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.chat.Conversation;
import com.abtnprojects.ambatana.models.chat.ConversationsEntity;
import com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity;
import java.lang.ref.WeakReference;
import java.util.List;

// Referenced classes of package android.support.v7:
//            dg, iv, aqo

public class fj extends AsyncTask
{

    private final String a;
    private final CountryCurrencyInfo b;
    private final WeakReference c;
    private final String d;
    private final String e;
    private final String f;

    public fj(String s, CountryCurrencyInfo countrycurrencyinfo, MessagesActivity messagesactivity, String s1, String s2, String s3)
    {
        a = s;
        b = countrycurrencyinfo;
        c = new WeakReference(messagesactivity);
        d = s1;
        e = s2;
        f = s3;
    }

    protected transient Conversation a(Void avoid[])
    {
        if (c == null)
        {
            avoid = null;
        } else
        {
            avoid = (MessagesActivity)c.get();
        }
        if (avoid != null)
        {
            com.abtnprojects.ambatana.models.chat.ApiConversation apiconversation = (new dg(a)).a(e, f, 0, 1000);
            avoid = (new ConversationsEntity(iv.a(avoid, 0x7f080001), b, avoid)).transform(apiconversation, d);
            int i;
            if (avoid == null)
            {
                i = 0;
            } else
            if (avoid.getMessages() == null)
            {
                i = 0;
            } else
            {
                i = avoid.getMessages().size();
            }
            aqo.a((new StringBuilder()).append("Messages size : ").append(i).toString(), new Object[0]);
            return avoid;
        } else
        {
            return null;
        }
    }

    protected void a(Conversation conversation)
    {
        MessagesActivity messagesactivity;
        if (c == null)
        {
            messagesactivity = null;
        } else
        {
            messagesactivity = (MessagesActivity)c.get();
        }
        if (messagesactivity != null)
        {
            messagesactivity.a(conversation);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Conversation)obj);
    }
}
