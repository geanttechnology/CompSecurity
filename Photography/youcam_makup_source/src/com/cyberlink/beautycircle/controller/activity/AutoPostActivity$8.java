// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CompletePost;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a extends j
{

    final AutoPostActivity a;

    protected Boolean a(Void void1)
    {
        int i;
        int k;
        boolean flag;
        k = com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).size();
        i = AutoPostActivity.m(a);
        flag = false;
_L3:
        if (i < com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).size() && !AutoPostActivity.l(a)) goto _L2; else goto _L1
_L1:
        return Boolean.valueOf(flag);
_L2:
        AutoPostActivity.a(a, i);
        AutoPostActivity.n(a);
        AutoPostActivity.a(a, com.cyberlink.beautycircle.controller.activity.AutoPostActivity.h(a), k);
        void1 = (Uri)com.cyberlink.beautycircle.controller.activity.AutoPostActivity.j(a).get(i);
        if (void1 == null)
        {
            Globals.b("Photo url is null");
        } else
        {
label0:
            {
                void1 = ImageUtils.a(Globals.n(), void1);
                if (void1 != null && void1.getWidth() >= 160 && void1.getHeight() >= 160)
                {
                    break label0;
                }
                Globals.b("The bitmap is invalid");
            }
        }
_L4:
        i++;
          goto _L3
label1:
        {
            AutoPostActivity.a(a, void1);
            if (!AutoPostActivity.l(a))
            {
                break label1;
            }
            AutoPostActivity.o(a);
        }
          goto _L1
        Object obj;
label2:
        {
            obj = NetworkFile.a(void1, com.perfectcorp.utility.Setting.PostPhoto);
            if (obj != null)
            {
                break label2;
            }
            Globals.b("Upload file is null");
        }
          goto _L4
label3:
        {
            if (!AutoPostActivity.l(a))
            {
                break label3;
            }
            AutoPostActivity.o(a);
        }
          goto _L1
        void1 = AccountManager.b();
        void1 = (com.cyberlink.beautycircle.model.network.ileResult)NetworkFile.a(void1, com.cyberlink.beautycircle.model.network.e.Photo, ((h) (obj)).e, ((h) (obj)).c, ((h) (obj)).f.toString(), ((h) (obj)).a).d();
        if (void1 == null)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        void1 = ((com.cyberlink.beautycircle.model.network.ileResult) (void1)).fileId;
_L5:
        if (!AutoPostActivity.l(a))
        {
            break MISSING_BLOCK_LABEL_330;
        }
        AutoPostActivity.o(a);
          goto _L1
        void1;
        void1.printStackTrace();
        void1 = null;
          goto _L5
        void1;
        void1.printStackTrace();
        void1 = null;
          goto _L5
        void1;
        void1.printStackTrace();
        void1 = null;
          goto _L5
label4:
        {
            if (void1 != null)
            {
                break label4;
            }
            Globals.b("Upload file failed.");
        }
          goto _L4
label5:
        {
            com.cyberlink.beautycircle.model.mentFile mentfile = new com.cyberlink.beautycircle.model.mentFile();
            mentfile.fileId = void1;
            mentfile.metadata = ((h) (obj)).f.toString();
            void1 = AutoPostActivity.a(a, mentfile);
            obj = AccountManager.b();
            if (obj != null)
            {
                break label5;
            }
            Globals.b("Upload file failed.");
            AutoPostActivity.o(a);
        }
          goto _L1
        try
        {
            void1 = (com.cyberlink.beautycircle.model.network.ostsResult)NetworkPost.a(((String) (obj)), "native_posting", ((CompletePost) (void1)).mainPost, ((CompletePost) (void1)).subPosts).d();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            void1 = null;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            void1 = null;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            void1 = null;
        }
        if (void1 == null)
        {
            Globals.b("Create post failed.");
        } else
        {
            Globals.b("Create post success.");
            flag = true;
        }
          goto _L4
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    sult(AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
