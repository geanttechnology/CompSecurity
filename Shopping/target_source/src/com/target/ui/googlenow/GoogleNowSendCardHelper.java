// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.content.Context;
import com.google.a.a.e;
import com.target.mothership.common.params.GoogleNowSendCardParams;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.list.interfaces.ListDetail;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.ui.helper.h.a;
import com.target.ui.util.ae;
import com.target.ui.util.q;
import java.util.List;

// Referenced classes of package com.target.ui.googlenow:
//            GoogleNowIntentHandler, a

public class GoogleNowSendCardHelper
    implements com.target.ui.helper.h.a.a
{
    private class a
        implements com.target.ui.helper.j.a.d
    {

        final GoogleNowSendCardHelper this$0;

        public void a(com.target.mothership.model.list.interfaces.a.a a1)
        {
            q.a("GoogleNowSendCardHelper", "Error encountered while fetching full lists");
        }

        public void a(List list)
        {
            com.target.ui.googlenow.GoogleNowSendCardHelper.a(GoogleNowSendCardHelper.this, list);
        }

        private a()
        {
            this$0 = GoogleNowSendCardHelper.this;
            super();
        }

    }


    public static final String TAG = "GoogleNowSendCardHelper";
    private String mAuthCode;
    private Context mContext;
    private com.target.ui.helper.h.a mGoogleNowDataHelper;
    private com.target.ui.helper.j.a mListDataHelper;

    public GoogleNowSendCardHelper(Context context)
    {
        mContext = context.getApplicationContext();
        d();
        mGoogleNowDataHelper = new com.target.ui.helper.h.a(this);
    }

    private void a(Context context)
    {
        new GoogleNowIntentHandler(context);
        com.target.ui.googlenow.GoogleNowIntentHandler.a(context);
    }

    static void a(GoogleNowSendCardHelper googlenowsendcardhelper, List list)
    {
        googlenowsendcardhelper.a(list);
    }

    private void a(List list)
    {
        Object obj = null;
        String s;
        Store store;
        if (!list.isEmpty())
        {
            list = (ListDetail)list.get(0);
        } else
        {
            list = null;
        }
        store = (Store)ae.a(mContext).d();
        s = obj;
        if (store != null)
        {
            s = obj;
            if (store.getStoreId() != null)
            {
                s = store.getStoreId().a();
            }
        }
        if (list == null || list.getListItems() == null || list.getListItems().size() == 0 || s == null)
        {
            q.a("GoogleNowSendCardHelper", "No lists found or no store, abort sending google now card");
            return;
        }
        list = new GoogleNowSendCardParams(e(), store.getStoreId(), list);
        if (mAuthCode != null)
        {
            mGoogleNowDataHelper.a(list, mAuthCode);
            return;
        } else
        {
            mGoogleNowDataHelper.a(list);
            return;
        }
    }

    private void d()
    {
        mListDataHelper = new com.target.ui.helper.j.a();
    }

    private String e()
    {
        return android.provider.Settings.Secure.getString(mContext.getContentResolver(), "android_id");
    }

    private void f()
    {
        com.target.ui.googlenow.a.a(mContext);
    }

    public void a()
    {
        mListDataHelper.a(new a());
    }

    public void a(x x1)
    {
        q.a("GoogleNowSendCardHelper", "Google now card send failure");
        if (x1.b().equals(z.UNAUTHORIZED))
        {
            a(mContext);
        }
        q.a("GoogleNowSendCardHelper", "Google now card send failure");
    }

    public void a(String s)
    {
        mAuthCode = s;
        mListDataHelper.a(new a());
    }

    public void a(Void void1)
    {
        q.d("GoogleNowSendCardHelper", "Google now card successfully sent");
    }

    public void b()
    {
        f();
        com.target.ui.googlenow.a.a(mContext, c());
    }

    public void b(x x1)
    {
        q.a("GoogleNowSendCardHelper", "Google now card send failure for auth code scenario");
    }

    public void b(String s)
    {
        mGoogleNowDataHelper.a(s);
    }

    public void b(Void void1)
    {
        q.d("GoogleNowSendCardHelper", "Google now card successfully sent for auth code scenario");
    }

    public int c()
    {
        return mGoogleNowDataHelper.a();
    }

    public void c(x x1)
    {
        q.a("GoogleNowSendCardHelper", "Google now token couldn't be revoked by the server, send-card process can't proceed");
    }

    public void c(Void void1)
    {
        a(mContext);
    }
}
