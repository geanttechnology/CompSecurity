// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.activity.WritePostActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.FileMetadata;
import com.cyberlink.beautycircle.model.PostBase;
import com.cyberlink.beautycircle.model.SubPost;
import com.cyberlink.beautycircle.model.Tags;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.ac;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import com.rockerhieu.emojicon.EmojiconEditText;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            d

public class c
{

    private final WritePostActivity a;
    private View b;
    private boolean c;
    private Long d;
    private boolean e;
    private String f;
    private Uri g;
    private boolean h;
    private Long i;
    private String j;
    private ac k;
    private View l;
    private View m;
    private TextView n;
    private View o;
    private EmojiconEditText p;
    private View q;
    private View r;
    private View s;
    private android.view.View.OnClickListener t;
    private android.view.View.OnClickListener u;
    private android.view.View.OnClickListener v;
    private com.perfectcorp.utility.j w;
    private d x;

    public c(WritePostActivity writepostactivity, boolean flag)
    {
        c = false;
        d = null;
        e = false;
        f = null;
        g = null;
        h = false;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                c.c(a).a(a, c.a(a), c.b(a).b());
            }

            
            {
                a = c.this;
                super();
            }
        };
        u = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                c.a(a, com.perfectcorp.utility.h.a(c.c(a)));
                c.c(a).a(a, c.d(a));
            }

            
            {
                a = c.this;
                super();
            }
        };
        v = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                c.a(a, null);
                c.a(a, true, false);
            }

            
            {
                a = c.this;
                super();
            }
        };
        w = null;
        x = null;
        a = writepostactivity;
        e = flag;
    }

    static Uri a(c c1)
    {
        return c1.g;
    }

    static Uri a(c c1, Uri uri)
    {
        c1.g = uri;
        return uri;
    }

    static Long a(c c1, Long long1)
    {
        c1.i = long1;
        return long1;
    }

    static String a(c c1, String s1)
    {
        c1.f = s1;
        return s1;
    }

    static void a(c c1, boolean flag, boolean flag1)
    {
        c1.a(flag, flag1);
    }

    private void a(boolean flag, boolean flag1)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = ImageUtils.a(Globals.n(), g);
        if (bitmap != null) goto _L4; else goto _L3
_L3:
        DialogUtils.a(a, m.bc_write_post_message_open_photo_fail);
_L6:
        return;
_L4:
        if (bitmap.getWidth() <= 100 || bitmap.getHeight() <= 100)
        {
            DialogUtils.a(a, m.bc_write_post_message_photo_too_small);
            return;
        }
        k.a(g);
        q.setVisibility(0);
        o.setVisibility(0);
        p.setVisibility(0);
        r.setVisibility(0);
        m.setVisibility(8);
        s.setVisibility(0);
        if (c)
        {
            o.setVisibility(8);
            s.setVisibility(8);
            q.setEnabled(false);
            if (p.length() > 0)
            {
                p.setEnabled(false);
                p.setBackgroundResource(0);
            } else
            {
                p.setVisibility(8);
            }
        }
        if (x != null)
        {
            x.a(this, flag1);
            x.a(this);
        }
        if (!flag1)
        {
            c();
        }
        h = false;
        i = null;
        j = null;
        k.a(new ArrayList());
        return;
_L2:
        if (flag)
        {
            l.setVisibility(8);
        } else
        {
            q.setVisibility(8);
            o.setVisibility(8);
            p.setVisibility(8);
            p.getText().clear();
            r.setVisibility(8);
            m.setVisibility(0);
            s.setVisibility(8);
        }
        if (x != null)
        {
            x.a(this, true);
            x.c(this);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(c c1, boolean flag)
    {
        c1.h = flag;
        return flag;
    }

    static ac b(c c1)
    {
        return c1.k;
    }

    static String b(c c1, String s1)
    {
        c1.j = s1;
        return s1;
    }

    static WritePostActivity c(c c1)
    {
        return c1.a;
    }

    static String d(c c1)
    {
        return c1.f;
    }

    static EmojiconEditText e(c c1)
    {
        return c1.p;
    }

    static d f(c c1)
    {
        return c1.x;
    }

    static boolean g(c c1)
    {
        return c1.h;
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(k.bc_fragment_create_photo_post, viewgroup, false);
        k = new ac(layoutinflater, false, true, false);
        l = layoutinflater.findViewById(j.write_post_add_photo_layout);
        q = layoutinflater.findViewById(j.tag_points_container);
        if (q != null)
        {
            q.setVisibility(8);
            q.setOnClickListener(t);
        }
        m = layoutinflater.findViewById(j.write_post_add_photo);
        if (m != null)
        {
            m.setVisibility(0);
            m.setOnClickListener(u);
        }
        n = (TextView)layoutinflater.findViewById(j.write_post_add_photo_required);
        if (!e)
        {
            n.setVisibility(8);
        } else
        {
            n.setVisibility(0);
        }
        s = layoutinflater.findViewById(j.write_post_tag_products_tip);
        o = layoutinflater.findViewById(j.delete_image_btn);
        if (o != null)
        {
            o.setVisibility(8);
            o.setOnClickListener(v);
        }
        r = layoutinflater.findViewById(j.write_post_separator);
        p = (EmojiconEditText)layoutinflater.findViewById(j.write_post_text);
        a(false, false);
        b = layoutinflater;
        return layoutinflater;
    }

    public SubPost a(boolean flag)
    {
        if (!flag && i == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "mFileId == null"
            });
            return null;
        }
        Object obj = new com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile();
        obj.fileId = i;
        obj.metadata = j;
        if (flag)
        {
            obj.fileType = "Photo";
            obj.fileUri = d();
        }
        SubPost subpost = new SubPost();
        subpost.subPostId = d;
        subpost.content = p.getText().toString();
        subpost.attachments = new com.cyberlink.beautycircle.model.PostBase.PostAttachments();
        subpost.attachments.files = new ArrayList();
        subpost.attachments.files.add(obj);
        ArrayList arraylist = k.b();
        obj = arraylist;
        if (arraylist == null)
        {
            obj = new ArrayList();
        }
        subpost.tags = new Tags();
        subpost.tags.productTags = ((ArrayList) (obj));
        return subpost;
    }

    public void a()
    {
        n.setVisibility(0);
    }

    public void a(int i1, int j1, Intent intent)
    {
        com.perfectcorp.utility.e.c(new Object[] {
            "requestCode: ", String.valueOf(i1), ", resultCode: ", String.valueOf(j1), ", data: ", intent
        });
        if (i1 != 48138) goto _L2; else goto _L1
_L1:
        if (j1 != -1) goto _L4; else goto _L3
_L3:
        g = com.perfectcorp.utility.h.a(intent.getData());
        a(false, false);
_L6:
        return;
_L4:
        com.perfectcorp.utility.e.a(new Object[] {
            "User canceled PickFromGallery"
        });
        return;
_L2:
        if (i1 == 48139)
        {
            if (j1 == -1)
            {
                MediaScannerConnection.scanFile(a, new String[] {
                    f.toString()
                }, null, null);
                g = Uri.fromFile(new File(f));
                a(false, false);
                return;
            } else
            {
                com.perfectcorp.utility.e.a(new Object[] {
                    "User canceled PickFromCamera"
                });
                return;
            }
        }
        if (i1 != 48143) goto _L6; else goto _L5
_L5:
        if (j1 != -1) goto _L8; else goto _L7
_L7:
        if (intent == null) goto _L10; else goto _L9
_L9:
        View view;
        intent = Model.a(com/cyberlink/beautycircle/model/Tags$ProductTag, new JSONArray(intent.getStringExtra("ProductTags")));
        k.a(intent);
        view = s;
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        break MISSING_BLOCK_LABEL_220;
_L11:
        try
        {
            view.setVisibility(i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.perfectcorp.utility.e.b(new Object[] {
                intent
            });
        }
        return;
        if (intent.isEmpty())
        {
            break MISSING_BLOCK_LABEL_307;
        }
        i1 = 8;
          goto _L11
_L10:
        com.perfectcorp.utility.e.e(new Object[] {
            "Results OK but data is null"
        });
        if (e.a)
        {
            DialogUtils.a(a, "Oops", "Results OK but data is null", null);
            return;
        }
          goto _L6
_L8:
        com.perfectcorp.utility.e.a(new Object[] {
            "User canceled tag products"
        });
        return;
        i1 = 0;
          goto _L11
    }

    public void a(Uri uri, boolean flag)
    {
        if (uri == null)
        {
            return;
        } else
        {
            g = com.perfectcorp.utility.h.a(uri);
            a(false, flag);
            return;
        }
    }

    public void a(d d1)
    {
        x = d1;
    }

    public void a(String s1)
    {
        if (s1 == null || s1.isEmpty())
        {
            return;
        } else
        {
            a(Uri.parse(s1), false);
            return;
        }
    }

    public boolean a(PostBase postbase, boolean flag)
    {
        if (postbase != null && postbase.attachments != null && postbase.attachments.files != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        Object obj1;
        Iterator iterator;
        if (postbase instanceof SubPost)
        {
            d = ((SubPost)postbase).subPostId;
        }
        c = flag;
        iterator = postbase.attachments.files.iterator();
        obj = null;
        obj1 = null;
_L5:
        com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile postattachmentfile;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_302;
        }
        postattachmentfile = (com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile)iterator.next();
        if (!"Photo".equals(postattachmentfile.fileType)) goto _L4; else goto _L3
_L3:
        if (postattachmentfile == null)
        {
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
            obj = postattachmentfile;
        }
_L7:
        p.setText(postbase.content);
        obj1 = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).b();
        if (obj1 != null && ((FileMetadata) (obj1)).originalUrl != null)
        {
            a(((FileMetadata) (obj1)).originalUrl, true);
            x.a(this, true);
        } else
        if (((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).fileUri != null)
        {
            if (((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).fileId != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a(((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).fileUri, flag);
        }
        i = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).fileId;
        j = ((com.cyberlink.beautycircle.model.PostBase.PostAttachmentFile) (obj)).metadata;
        if (postbase.tags != null && postbase.tags.productTags != null)
        {
            k.a(postbase.tags.productTags);
        }
        return true;
_L4:
        if ("PostCover".equals(postattachmentfile.fileType))
        {
            obj1 = postattachmentfile;
        } else
        if ("PostCoverOri".equals(postattachmentfile.fileType))
        {
            obj = postattachmentfile;
        }
          goto _L5
        if (obj1 == null) goto _L1; else goto _L6
_L6:
        obj = obj1;
          goto _L7
        postattachmentfile = null;
          goto _L3
    }

    public View b()
    {
        return b;
    }

    public void b(String s1)
    {
        p.setText(s1);
    }

    public com.perfectcorp.utility.j c()
    {
        this;
        JVM INSTR monitorenter ;
        com.perfectcorp.utility.j j1;
        w = (new com.perfectcorp.utility.j() {

            final c a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                if (com.cyberlink.beautycircle.controller.fragment.c.e(a).getText().length() <= 0 && c.a(a) == null)
                {
                    com.cyberlink.beautycircle.controller.fragment.c.e(a).post(new Runnable(this) {

                        final _cls4 a;

                        public void run()
                        {
                            if (c.f(a.a) != null)
                            {
                                c.f(a.a).a(a.a, true);
                            }
                        }

            
            {
                a = _pcls4;
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
                void1 = NetworkFile.a(c.a(a), com.perfectcorp.utility.ImageUtils.CompressSetting.PostPhoto);
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
                com.perfectcorp.utility.e.a(new Object[] {
                    "Uploading photo; ", a
                });
                obj = (com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult)NetworkFile.a(((String) (obj)), com.cyberlink.beautycircle.model.network.NetworkFile.FileType.Photo, ((com.cyberlink.beautycircle.model.network.h) (void1)).e, ((com.cyberlink.beautycircle.model.network.h) (void1)).c, ((com.cyberlink.beautycircle.model.network.h) (void1)).f.toString(), ((com.cyberlink.beautycircle.model.network.h) (void1)).a).d();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_234;
                }
                c.a(a, ((com.cyberlink.beautycircle.model.network.NetworkFile.UploadFileResult) (obj)).fileId);
                c.b(a, ((com.cyberlink.beautycircle.model.network.h) (void1)).f.toString());
                c.a(a, false);
                if (c.f(a) == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                c.f(a).a(a, true);
                return null;
                void1;
                com.perfectcorp.utility.e.e(new Object[] {
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

            
            {
                a = c.this;
                super();
            }
        }).d(null);
        j1 = w;
        this;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        throw exception;
    }

    public Uri d()
    {
        return g;
    }

    public boolean e()
    {
        int i1 = p.getText().length();
        boolean flag;
        if (p.getText().length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.perfectcorp.utility.e.e(new Object[] {
            Integer.valueOf(i1), ", ", Boolean.valueOf(flag)
        });
        return p.getText().length() > 0;
    }
}
