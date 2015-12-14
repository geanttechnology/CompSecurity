// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.nostra13.universalimageloader.core.f;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            Post, FileMetadata

public class BCTileImage extends Model
{

    public static final int MAX_TILE_DISCOVER_IMAGE_COUNT = 5;
    private static int a = 0;
    private static int b = 0;
    private static String c = null;
    private static j d = null;
    public ArrayList imageList;
    public Long mTimeStamp;

    public BCTileImage()
    {
    }

    public static Bitmap a(BCTileImage bctileimage)
    {
        if (bctileimage == null || bctileimage.imageList == null)
        {
            e.f(new Object[] {
                "No BC tile image"
            });
            return null;
        }
        bctileimage = bctileimage.imageList;
        if (bctileimage.size() == 0)
        {
            e.f(new Object[] {
                "There is no invalid BC tile image"
            });
            return null;
        }
        if (bctileimage.size() != b)
        {
            a = 0;
        }
        b = bctileimage.size();
        com.nostra13.universalimageloader.core.d d1;
        if (bctileimage.size() == 1)
        {
            a = 0;
        } else
        if (bctileimage.size() == 2)
        {
            a++;
            a %= 2;
        } else
        {
            int i;
            do
            {
                i = (int)(Math.random() * (double)bctileimage.size());
            } while (i == a);
            a = i;
        }
        bctileimage = (String)bctileimage.get(a);
        d1 = (new com.nostra13.universalimageloader.core.e()).a(android.graphics.Bitmap.Config.ARGB_8888).b(false).c(false).d(true).a();
        e.f(new Object[] {
            (new StringBuilder()).append("BC tile image path :'").append(bctileimage).append("'").toString()
        });
        return f.b().a(bctileimage, d1);
    }

    public static void a()
    {
        Globals.D().edit().remove("KEY_BC_TILE_IMAGE").remove("KEY_BC_TILE_IAMGE_FROM_DISCOVER").commit();
    }

    public static void a(Post post)
    {
        if (post == null)
        {
            return;
        } else
        {
            (new j(post) {

                final Post a;

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

                protected Void a(Void void1)
                {
                    String s;
                    SharedPreferences sharedpreferences;
                    try
                    {
                        void1 = BCTileImage.c(a);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1)
                    {
                        void1.printStackTrace();
                        return null;
                    }
                    if (void1 != null)
                    {
                        break MISSING_BLOCK_LABEL_27;
                    }
                    e.b(new Object[] {
                        "Can't find photo."
                    });
                    return null;
                    s = void1.toString();
                    sharedpreferences = Globals.D();
                    void1 = sharedpreferences.getString("KEY_BC_TILE_IMAGE", "");
                    if (!void1.isEmpty()) goto _L2; else goto _L1
_L1:
                    void1 = new BCTileImage();
_L3:
                    if (((BCTileImage) (void1)).imageList == null)
                    {
                        void1.imageList = new ArrayList();
                    }
                    if (((BCTileImage) (void1)).imageList.contains(s))
                    {
                        break MISSING_BLOCK_LABEL_195;
                    }
                    if (((BCTileImage) (void1)).imageList.size() == 4)
                    {
                        ((BCTileImage) (void1)).imageList.remove(0);
                    }
                    ((BCTileImage) (void1)).imageList.add(s);
                    e.b(new Object[] {
                        (new StringBuilder()).append("Add photo :").append(s).toString()
                    });
_L4:
                    sharedpreferences.edit().putString("KEY_BC_TILE_IMAGE", void1.toString()).commit();
                    return null;
_L2:
                    void1 = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, void1);
                      goto _L3
                    e.b(new Object[] {
                        "The photo already is in image list."
                    });
                      goto _L4
                }

            
            {
                a = post;
                super();
            }
            }).d(null);
            return;
        }
    }

    public static void a(ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() == 0)
        {
            return;
        }
        if (d != null)
        {
            d.a(true);
            d = null;
        }
        d = (new j(arraylist) {

            final ArrayList a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                Iterator iterator;
                void1 = new BCTileImage();
                void1.imageList = new ArrayList();
                iterator = a.iterator();
_L4:
                Uri uri;
                if (!iterator.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
                uri = BCTileImage.c((Post)iterator.next());
                if (uri != null) goto _L2; else goto _L1
_L1:
                try
                {
                    e.b(new Object[] {
                        "Can't find photo."
                    });
                    continue; /* Loop/switch isn't completed */
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
_L5:
                return null;
_L2:
                ((BCTileImage) (void1)).imageList.add(uri.toString());
                if (((BCTileImage) (void1)).imageList.size() <= 5) goto _L4; else goto _L3
_L3:
                Globals.D().edit().putString("KEY_BC_TILE_IAMGE_FROM_DISCOVER", void1.toString()).commit();
                  goto _L5
                if (true) goto _L4; else goto _L6
_L6:
            }

            
            {
                a = arraylist;
                super();
            }
        }).d(null);
    }

    public static BCTileImage b()
    {
        Object obj;
        String s;
        Object obj1;
        SharedPreferences sharedpreferences;
        s = "KEY_BC_TILE_IMAGE";
        sharedpreferences = Globals.D();
        obj1 = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, sharedpreferences.getString("KEY_BC_TILE_IMAGE", ""));
        obj = obj1;
        if (obj1 == null)
        {
            s = "KEY_BC_TILE_IAMGE_FROM_DISCOVER";
            obj = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, sharedpreferences.getString("KEY_BC_TILE_IAMGE_FROM_DISCOVER", ""));
        }
        obj1 = obj;
        if (obj != null) goto _L2; else goto _L1
_L1:
        BCTileImage bctileimage;
        long l;
        obj = "KEY_BC_TILE_IAMGE_FROM_SERVER";
        bctileimage = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, sharedpreferences.getString("KEY_BC_TILE_IAMGE_FROM_SERVER", ""));
        l = System.currentTimeMillis();
        obj1 = bctileimage;
        s = ((String) (obj));
        if (bctileimage == null) goto _L2; else goto _L3
_L3:
        obj1 = bctileimage;
        s = ((String) (obj));
        if (bctileimage.mTimeStamp.longValue() + 0xf731400L >= l) goto _L2; else goto _L4
_L4:
        obj1 = null;
        s = ((String) (obj));
        obj = obj1;
_L7:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        try
        {
            obj1 = (BCTileImage)NetworkPost.a().d();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        obj1.mTimeStamp = Long.valueOf(System.currentTimeMillis());
        sharedpreferences.edit().putString("KEY_BC_TILE_IAMGE_FROM_SERVER", ((BCTileImage) (obj1)).toString()).commit();
        obj = obj1;
_L5:
        if (obj == null)
        {
            obj = new BCTileImage();
            s = null;
        }
        if (s == null || c == null || !c.equals(s))
        {
            c = s;
            a = 0;
        }
        return ((BCTileImage) (obj));
        obj;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj;
        obj = obj1;
        if (true) goto _L5; else goto _L2
_L2:
        obj = obj1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void b(Post post)
    {
        if (post == null)
        {
            return;
        } else
        {
            (new j(post) {

                final Post a;

                protected volatile Object a(Object obj)
                {
                    return a((Void)obj);
                }

                protected Void a(Void void1)
                {
                    String s;
                    SharedPreferences sharedpreferences;
                    int i;
                    try
                    {
                        void1 = BCTileImage.c(a);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1)
                    {
                        void1.printStackTrace();
                        return null;
                    }
                    if (void1 != null)
                    {
                        break MISSING_BLOCK_LABEL_27;
                    }
                    e.b(new Object[] {
                        "Can't find photo."
                    });
                    return null;
                    s = void1.toString();
                    sharedpreferences = Globals.D();
                    void1 = sharedpreferences.getString("KEY_BC_TILE_IMAGE", "");
                    if (!void1.isEmpty())
                    {
                        break MISSING_BLOCK_LABEL_132;
                    }
                    void1 = new BCTileImage();
_L1:
                    if (((BCTileImage) (void1)).imageList == null || !((BCTileImage) (void1)).imageList.contains(s))
                    {
                        break MISSING_BLOCK_LABEL_145;
                    }
                    i = ((BCTileImage) (void1)).imageList.indexOf(s);
                    ((BCTileImage) (void1)).imageList.remove(i);
                    sharedpreferences.edit().putString("KEY_BC_TILE_IMAGE", void1.toString()).commit();
                    return null;
                    void1 = (BCTileImage)Model.a(com/cyberlink/beautycircle/model/BCTileImage, void1);
                      goto _L1
                    return null;
                }

            
            {
                a = post;
                super();
            }
            }).d(null);
            return;
        }
    }

    static Uri c(Post post)
    {
        return d(post);
    }

    private static Uri d(Post post)
    {
        if (post == null || post.attachments == null || post.attachments.files == null || post.attachments.files.size() <= 0)
        {
            return null;
        }
        PostBase.PostAttachmentFile postattachmentfile2 = post.attachments.c();
        PostBase.PostAttachmentFile postattachmentfile1 = post.attachments.d();
        PostBase.PostAttachmentFile postattachmentfile = postattachmentfile2;
        if (postattachmentfile2 == null)
        {
            postattachmentfile = postattachmentfile1;
        }
        post = post.d();
        if (post == null && postattachmentfile != null)
        {
            post = postattachmentfile.b();
        } else
        if (post != null && postattachmentfile1 != null)
        {
            post = postattachmentfile1.b();
        } else
        {
            post = null;
        }
        if (post != null)
        {
            return ((FileMetadata) (post)).originalUrl;
        } else
        {
            return null;
        }
    }

}
