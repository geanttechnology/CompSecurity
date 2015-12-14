// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.text.Editable;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            c, d

class a extends j
{

    final c a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        if (com.cyberlink.beautycircle.controller.fragment.c.e(a).getText().length() <= 0 && c.a(a) == null)
        {
            com.cyberlink.beautycircle.controller.fragment.c.e(a).post(new Runnable() {

                final c._cls4 a;

                public void run()
                {
                    if (c.f(a.a) != null)
                    {
                        c.f(a.a).a(a.a, true);
                    }
                }

            
            {
                a = c._cls4.this;
                super();
            }
            });
        }
        if (c.a(a) != null && !c.g(a)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        c.a(a, true);
        obj = AccountManager.b();
        if (obj == null)
        {
            c.a(a, false);
            DialogUtils.a(c.c(a), m.bc_write_post_message_must_sign_in);
            return null;
        }
        void1 = NetworkFile.a(c.a(a), com.perfectcorp.utility.eUtils.CompressSetting.PostPhoto);
        if (void1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        c.a(a, false);
        if (c.f(a) != null)
        {
            c.f(a).b(a);
            return null;
        }
        if (true) goto _L1; else goto _L3
_L3:
        e.a(new Object[] {
            "Uploading photo; ", a
        });
        obj = (com.cyberlink.beautycircle.model.network.orkFile.UploadFileResult)NetworkFile.a(((String) (obj)), com.cyberlink.beautycircle.model.network.orkFile.FileType.Photo, ((h) (void1)).e, ((h) (void1)).c, ((h) (void1)).f.toString(), ((h) (void1)).a).d();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        c.a(a, ((com.cyberlink.beautycircle.model.network.orkFile.UploadFileResult) (obj)).fileId);
        c.b(a, ((h) (void1)).f.toString());
        c.a(a, false);
        if (c.f(a) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        c.f(a).a(a, true);
        return null;
        void1;
        e.e(new Object[] {
            (new StringBuilder()).append("Uploading photo exception, ").append(void1).toString()
        });
        void1.printStackTrace();
        c.a(a, false);
        if (c.f(a) != null)
        {
            c.f(a).b(a);
            return null;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    _cls1.a(c c1)
    {
        a = c1;
        super();
    }
}
