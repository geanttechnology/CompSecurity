// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.x;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a extends j
{

    final Uri a;
    final ShareInActivity b;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        e.b(new Object[] {
            "Enter"
        });
        String s = AccountManager.b();
        if (s == null)
        {
            DialogUtils.a(b, m.bc_write_post_message_must_sign_in);
            b(0x80000001);
            return null;
        }
        if (c())
        {
            e.b(new Object[] {
                "The promise task is cancelled."
            });
            return null;
        }
        e.b(new Object[] {
            "Get account token"
        });
        if (a == null)
        {
            void1 = ((x)ShareInActivity.o(b).get(ShareInActivity.l(b))).c;
        } else
        {
            void1 = ImageUtils.a(Globals.n(), a);
        }
        void1 = NetworkFile.a(void1, com.perfectcorp.utility.Setting.PostPhoto);
        if (void1 == null)
        {
            b.l();
            ShareInActivity.a(b, m.bc_write_post_message_create_post_fail, null);
            b(0x80000001);
            return null;
        }
        if (c())
        {
            e.b(new Object[] {
                "The promise task is cancelled."
            });
            return null;
        }
        ((h) (void1)).f.redirectUrl = ShareInActivity.z(b);
        e.b(new Object[] {
            "Create upload post cover ori task"
        });
        ShareInActivity.a(b, NetworkFile.a(s, com.cyberlink.beautycircle.model.network.e.Photo, ((h) (void1)).e, ((h) (void1)).c, ((h) (void1)).f.toString(), ((h) (void1)).a));
        if (ShareInActivity.A(b) != null)
        {
            ShareInActivity.A(b).a(new com.perfectcorp.utility.m(void1) {

                final h a;
                final ShareInActivity._cls10 b;

                public void a()
                {
                    e.b(new Object[] {
                        "The upload post coverOri is cancelled."
                    });
                }

                public void a(int i)
                {
                    e.e(new Object[] {
                        Integer.valueOf(i)
                    });
                    if (ShareInActivity.A(b.b) != null)
                    {
                        ShareInActivity.A(b.b).a(true);
                        ShareInActivity.a(b.b, null);
                    }
                    b.b.l();
                    ShareInActivity.a(b.b, m.bc_write_post_message_create_post_fail, Integer.valueOf(i));
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult uploadfileresult)
                {
                    if (uploadfileresult == null || uploadfileresult.fileId == null)
                    {
                        b(0x80000001);
                    } else
                    {
                        e.b(new Object[] {
                            "Upload CoverOri finish: ", uploadfileresult.fileId
                        });
                        if (!c())
                        {
                            ShareInActivity.a(b.b, new com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile());
                            ShareInActivity.B(b.b).fileId = uploadfileresult.fileId;
                            ShareInActivity.B(b.b).metadata = a.f.toString();
                            ShareInActivity.a(b.b, null);
                        }
                        if (ShareInActivity.A(b.b) != null)
                        {
                            ShareInActivity.a(b.b, null);
                            return;
                        }
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)obj);
                }

            
            {
                b = ShareInActivity._cls10.this;
                a = h1;
                super();
            }
            });
        }
        e.b(new Object[] {
            "Leave."
        });
        return null;
    }

    public void a()
    {
        e.b(new Object[] {
            "Cancel upload promise task"
        });
        ShareInActivity.C(b);
    }

    public void a(int i)
    {
        e.e(new Object[] {
            Integer.valueOf(i)
        });
        b.l();
        ShareInActivity.a(b, m.bc_write_post_message_create_post_fail, null);
    }

    _cls1.a(ShareInActivity shareinactivity, Uri uri)
    {
        b = shareinactivity;
        a = uri;
        super();
    }
}
