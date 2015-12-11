// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.jg;
import android.support.v7.ji;
import android.support.v7.jn;
import android.support.v7.jw;
import android.support.v7.jx;
import android.support.v7.kb;
import android.util.Pair;
import com.facebook.d;
import com.facebook.f;
import com.facebook.i;
import com.facebook.k;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            d, e

public final class h
{

    private static ji a(int j, int l, Intent intent)
    {
        intent = jx.b(intent);
        if (intent == null)
        {
            return null;
        } else
        {
            return ji.a(intent, j);
        }
    }

    static android.support.v7.jw.a a(UUID uuid, SharePhoto sharephoto)
    {
        return b(uuid, sharephoto);
    }

    public static Pair a(String s)
    {
        Object obj = null;
        int j = s.indexOf(':');
        String s2 = obj;
        String s1 = s;
        if (j != -1)
        {
            s2 = obj;
            s1 = s;
            if (s.length() > j + 1)
            {
                s2 = s.substring(0, j);
                s1 = s.substring(j + 1);
            }
        }
        return new Pair(s2, s1);
    }

    public static e a(f f1)
    {
        return new e(f1, f1) {

            final f a;

            public void a(ji ji1)
            {
                h.b(a);
            }

            public void a(ji ji1, Bundle bundle)
            {
label0:
                {
                    if (bundle != null)
                    {
                        ji1 = h.a(bundle);
                        if (ji1 != null && !"post".equalsIgnoreCase(ji1))
                        {
                            break label0;
                        }
                        ji1 = h.b(bundle);
                        h.a(a, ji1);
                    }
                    return;
                }
                if ("cancel".equalsIgnoreCase(ji1))
                {
                    h.b(a);
                    return;
                } else
                {
                    h.a(a, new com.facebook.h("UnknownError"));
                    return;
                }
            }

            public void a(ji ji1, com.facebook.h h1)
            {
                h.a(a, h1);
            }

            
            {
                a = f2;
                super(f1);
            }
        };
    }

    public static String a(Bundle bundle)
    {
        if (bundle.containsKey("completionGesture"))
        {
            return bundle.getString("completionGesture");
        } else
        {
            return bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
        }
    }

    public static String a(ShareVideoContent sharevideocontent, UUID uuid)
    {
        if (sharevideocontent == null || sharevideocontent.d() == null)
        {
            return null;
        } else
        {
            sharevideocontent = jw.a(uuid, sharevideocontent.d().b());
            uuid = new ArrayList(1);
            uuid.add(sharevideocontent);
            jw.a(uuid);
            return sharevideocontent.a();
        }
    }

    public static List a(SharePhotoContent sharephotocontent, UUID uuid)
    {
label0:
        {
            if (sharephotocontent != null)
            {
                sharephotocontent = sharephotocontent.a();
                if (sharephotocontent != null)
                {
                    break label0;
                }
            }
            return null;
        }
        sharephotocontent = kb.a(sharephotocontent, new android.support.v7.kb.d(uuid) {

            final UUID a;

            public android.support.v7.jw.a a(SharePhoto sharephoto)
            {
                return h.a(a, sharephoto);
            }

            public volatile Object a(Object obj)
            {
                return a((SharePhoto)obj);
            }

            
            {
                a = uuid;
                super();
            }
        });
        uuid = kb.a(sharephotocontent, new android.support.v7.kb.d() {

            public volatile Object a(Object obj)
            {
                return a((android.support.v7.jw.a)obj);
            }

            public String a(android.support.v7.jw.a a1)
            {
                return a1.a();
            }

        });
        jw.a(sharephotocontent);
        return uuid;
    }

    public static JSONArray a(JSONArray jsonarray, boolean flag)
        throws JSONException
    {
        JSONArray jsonarray1 = new JSONArray();
        int j = 0;
        while (j < jsonarray.length()) 
        {
            Object obj1 = jsonarray.get(j);
            Object obj;
            if (obj1 instanceof JSONArray)
            {
                obj = a((JSONArray)obj1, flag);
            } else
            {
                obj = obj1;
                if (obj1 instanceof JSONObject)
                {
                    obj = a((JSONObject)obj1, flag);
                }
            }
            jsonarray1.put(obj);
            j++;
        }
        return jsonarray1;
    }

    public static JSONObject a(ShareOpenGraphContent shareopengraphcontent)
        throws JSONException
    {
        return d.a(shareopengraphcontent.a(), new d.a() {

            public JSONObject a(SharePhoto sharephoto)
            {
                sharephoto = sharephoto.c();
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("url", sharephoto.toString());
                }
                // Misplaced declaration of an exception variable
                catch (SharePhoto sharephoto)
                {
                    throw new com.facebook.h("Unable to attach images", sharephoto);
                }
                return jsonobject;
            }

        });
    }

    public static JSONObject a(UUID uuid, ShareOpenGraphContent shareopengraphcontent)
        throws JSONException
    {
        Object obj = shareopengraphcontent.a();
        ArrayList arraylist = new ArrayList();
        obj = d.a(((com.facebook.share.model.ShareOpenGraphAction) (obj)), new d.a(uuid, arraylist) {

            final UUID a;
            final ArrayList b;

            public JSONObject a(SharePhoto sharephoto)
            {
                Object obj1 = h.a(a, sharephoto);
                if (obj1 != null) goto _L2; else goto _L1
_L1:
                obj1 = null;
_L4:
                return ((JSONObject) (obj1));
_L2:
                b.add(obj1);
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("url", ((android.support.v7.jw.a) (obj1)).a());
                }
                // Misplaced declaration of an exception variable
                catch (SharePhoto sharephoto)
                {
                    throw new com.facebook.h("Unable to attach images", sharephoto);
                }
                obj1 = jsonobject;
                if (!sharephoto.d()) goto _L4; else goto _L3
_L3:
                jsonobject.put("user_generated", true);
                return jsonobject;
            }

            
            {
                a = uuid;
                b = arraylist;
                super();
            }
        });
        jw.a(arraylist);
        if (shareopengraphcontent.j() != null && kb.a(((JSONObject) (obj)).optString("place")))
        {
            ((JSONObject) (obj)).put("place", shareopengraphcontent.j());
        }
        if (shareopengraphcontent.i() != null)
        {
            uuid = ((JSONObject) (obj)).optJSONArray("tags");
            if (uuid == null)
            {
                uuid = new HashSet();
            } else
            {
                uuid = kb.b(uuid);
            }
            for (shareopengraphcontent = shareopengraphcontent.i().iterator(); shareopengraphcontent.hasNext(); uuid.add((String)shareopengraphcontent.next())) { }
            ((JSONObject) (obj)).put("tags", new ArrayList(uuid));
        }
        return ((JSONObject) (obj));
    }

    public static JSONObject a(JSONObject jsonobject, boolean flag)
    {
        Object obj;
        JSONObject jsonobject1;
        JSONObject jsonobject2;
        String s;
        String s1;
        Object obj1;
        int j;
        if (jsonobject == null)
        {
            return null;
        }
        JSONArray jsonarray;
        try
        {
            jsonobject1 = new JSONObject();
            jsonobject2 = new JSONObject();
            jsonarray = jsonobject.names();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new com.facebook.h("Failed to create json object from share content");
        }
        j = 0;
_L6:
        if (j >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_237;
        }
        s = jsonarray.getString(j);
        obj = jsonobject.get(s);
        if (!(obj instanceof JSONObject)) goto _L2; else goto _L1
_L1:
        obj = a((JSONObject)obj, true);
_L4:
        obj1 = a(s);
        s1 = (String)((Pair) (obj1)).first;
        obj1 = (String)((Pair) (obj1)).second;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (s1.equals("fbsdk"))
        {
            jsonobject1.put(s, obj);
            break MISSING_BLOCK_LABEL_260;
        }
        break MISSING_BLOCK_LABEL_150;
_L2:
        if (!(obj instanceof JSONArray)) goto _L4; else goto _L3
_L3:
        obj = a((JSONArray)obj, true);
          goto _L4
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        if (!s1.equals("og"))
        {
            break MISSING_BLOCK_LABEL_187;
        }
        jsonobject1.put(((String) (obj1)), obj);
        break MISSING_BLOCK_LABEL_260;
        jsonobject2.put(((String) (obj1)), obj);
        break MISSING_BLOCK_LABEL_260;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (s1.equals("fb"))
        {
            jsonobject1.put(s, obj);
            break MISSING_BLOCK_LABEL_260;
        }
        jsonobject1.put(((String) (obj1)), obj);
        break MISSING_BLOCK_LABEL_260;
        if (jsonobject2.length() > 0)
        {
            jsonobject1.put("data", jsonobject2);
        }
        return jsonobject1;
        j++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void a(int j)
    {
        jn.a(j, new android.support.v7.jn.a(j) {

            final int a;

            public boolean a(int l, Intent intent)
            {
                return h.a(a, l, intent, h.a(null));
            }

            
            {
                a = j;
                super();
            }
        });
    }

    public static void a(int j, d d1, f f1)
    {
        if (!(d1 instanceof jn))
        {
            throw new com.facebook.h("Unexpected CallbackManager, please use the provided Factory.");
        } else
        {
            ((jn)d1).b(j, new android.support.v7.jn.a(j, f1) {

                final int a;
                final f b;

                public boolean a(int l, Intent intent)
                {
                    return h.a(a, l, intent, h.a(b));
                }

            
            {
                a = j;
                b = f1;
                super();
            }
            });
            return;
        }
    }

    static void a(f f1, com.facebook.h h1)
    {
        a("error", h1.getMessage());
        if (f1 != null)
        {
            f1.onError(h1);
        }
    }

    static void a(f f1, String s)
    {
        a("succeeded", ((String) (null)));
        if (f1 != null)
        {
            f1.onSuccess(new android.support.v7.ke.a(s));
        }
    }

    private static void a(String s, String s1)
    {
        jg jg1 = jg.b(k.f());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_outcome", s);
        if (s1 != null)
        {
            bundle.putString("error_message", s1);
        }
        jg1.a("fb_share_dialog_result", null, bundle);
    }

    public static boolean a(int j, int l, Intent intent, e e1)
    {
        boolean flag = true;
        ji ji1 = a(j, l, intent);
        if (ji1 == null)
        {
            flag = false;
        } else
        {
            jw.a(ji1.c());
            if (e1 != null)
            {
                com.facebook.h h1 = jx.a(jx.g(intent));
                if (h1 != null)
                {
                    if (h1 instanceof i)
                    {
                        e1.a(ji1);
                        return true;
                    } else
                    {
                        e1.a(ji1, h1);
                        return true;
                    }
                } else
                {
                    e1.a(ji1, jx.e(intent));
                    return true;
                }
            }
        }
        return flag;
    }

    private static android.support.v7.jw.a b(UUID uuid, SharePhoto sharephoto)
    {
        android.graphics.Bitmap bitmap = sharephoto.b();
        Uri uri = sharephoto.c();
        sharephoto = null;
        if (bitmap != null)
        {
            sharephoto = jw.a(uuid, bitmap);
        } else
        if (uri != null)
        {
            return jw.a(uuid, uri);
        }
        return sharephoto;
    }

    public static String b(Bundle bundle)
    {
        if (bundle.containsKey("postId"))
        {
            return bundle.getString("postId");
        }
        if (bundle.containsKey("com.facebook.platform.extra.POST_ID"))
        {
            return bundle.getString("com.facebook.platform.extra.POST_ID");
        } else
        {
            return bundle.getString("post_id");
        }
    }

    static void b(f f1)
    {
        a("cancelled", ((String) (null)));
        if (f1 != null)
        {
            f1.onCancel();
        }
    }
}
