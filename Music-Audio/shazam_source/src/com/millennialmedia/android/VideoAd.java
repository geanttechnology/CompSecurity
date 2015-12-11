// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Externalizable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            r, VideoImage, VideoLogEvent, al, 
//            a, MMActivity, w, v, 
//            ab

class VideoAd extends r
    implements Parcelable, Externalizable
{
    private static final class a
        implements FilenameFilter
    {

        private WeakReference a;

        public final boolean accept(File file, String s1)
        {
            file = (VideoAd)a.get();
            if (file != null)
            {
                file = ((r) (file)).a;
                if (file == null)
                {
                    return false;
                } else
                {
                    return s1.startsWith(file);
                }
            } else
            {
                return false;
            }
        }

        public a(VideoAd videoad)
        {
            a = new WeakReference(videoad);
        }
    }

    private static final class b extends a.b
    {

        boolean a;
        private WeakReference b;
        private WeakReference c;

        final void a()
        {
            if (!a)
            {
                Context context = (Context)c.get();
                if (context != null)
                {
                    VideoAd videoad = (VideoAd)b.get();
                    if (videoad != null && com.millennialmedia.android.a.g(context, (new StringBuilder()).append(VideoAd.a(videoad)).append("video.dat").toString()))
                    {
                        String.format("VideoAd video file %s was deleted.", new Object[] {
                            VideoAd.a(videoad)
                        });
                        al.a();
                    }
                }
            }
            super.a();
        }

        final boolean a(r r1)
        {
            if (r1 != null && (r1 instanceof VideoAd))
            {
                VideoAd videoad = (VideoAd)r1;
                VideoAd videoad1 = (VideoAd)b.get();
                if (videoad1 != null && VideoAd.a(videoad).equals(VideoAd.a(videoad1)))
                {
                    a = true;
                }
            }
            return super.a(r1);
        }

        public b(Context context, VideoAd videoad)
        {
            a = false;
            b = new WeakReference(videoad);
            c = new WeakReference(context);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new VideoAd(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new VideoAd[i1];
        }

    };
    private String A;
    boolean h;
    boolean i;
    String j;
    String k;
    String l;
    String m;
    boolean n;
    boolean o;
    String p[];
    String q[];
    long r;
    long s;
    long t;
    String u[];
    String v[];
    String w[];
    boolean x;
    ArrayList y;
    ArrayList z;

    public VideoAd()
    {
        y = new ArrayList();
        z = new ArrayList();
    }

    VideoAd(Parcel parcel)
    {
        super(parcel);
        y = new ArrayList();
        z = new ArrayList();
        try
        {
            p = new String[parcel.readInt()];
            parcel.readStringArray(p);
            q = new String[parcel.readInt()];
            parcel.readStringArray(q);
            boolean aflag[] = new boolean[5];
            parcel.readBooleanArray(aflag);
            h = aflag[0];
            n = aflag[1];
            o = aflag[2];
            x = aflag[3];
            i = aflag[4];
            j = parcel.readString();
            k = parcel.readString();
            l = parcel.readString();
            m = parcel.readString();
            A = parcel.readString();
            r = parcel.readLong();
            s = parcel.readLong();
            t = parcel.readLong();
            y = parcel.readArrayList(com/millennialmedia/android/VideoImage.getClassLoader());
            z = parcel.readArrayList(com/millennialmedia/android/VideoLogEvent.getClassLoader());
            u = new String[parcel.readInt()];
            parcel.readStringArray(u);
            v = new String[parcel.readInt()];
            parcel.readStringArray(v);
            w = new String[parcel.readInt()];
            parcel.readStringArray(w);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            al.a("VideoAd", "Exception with videoad parcel creation: ", parcel);
        }
    }

    VideoAd(String s1)
    {
        y = new ArrayList();
        z = new ArrayList();
        if (s1 != null)
        {
            try
            {
                s1 = new JSONObject(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                al.a("VideoAd", "VideoAd json exception: ", s1);
                s1 = null;
            }
            if (s1 != null)
            {
                s1 = s1.optJSONObject("video");
                if (s1 != null)
                {
                    a(s1);
                }
            }
        }
    }

    static String a(VideoAd videoad)
    {
        return videoad.A;
    }

    static void a(Context context, String s1, x.a a1)
    {
label0:
        {
            if (s1 != null)
            {
                VideoAd videoad = (VideoAd)com.millennialmedia.android.a.f(context, s1);
                if (videoad == null || !videoad.a(context, ((ab) (null)), false))
                {
                    break label0;
                }
                a1.c();
                String.format("mmvideo: attempting to play video %s", new Object[] {
                    s1
                });
                al.a();
                videoad.a(context, a1.e);
            }
            return;
        }
        String.format("mmvideo: Ad %s cannot be shown at this time.", new Object[] {
            s1
        });
        al.d();
    }

    static boolean a(String s1, String s2)
    {
        boolean flag = com.millennialmedia.android.a.a(s1, (new StringBuilder()).append(s2).append("video.dat").toString());
        String.format((new StringBuilder("Caching completed successfully (")).append(s2).append("video.dat)? %b").toString(), new Object[] {
            Boolean.valueOf(flag)
        });
        al.a();
        return flag;
    }

    static boolean b(String s1)
    {
        return com.millennialmedia.android.a.b((new StringBuilder()).append(s1).append("video.dat").toString());
    }

    static Uri c(String s1)
    {
        return Uri.fromFile(com.millennialmedia.android.a.a((new StringBuilder()).append(s1).append("video.dat").toString()));
    }

    final void a(Context context, long l1)
    {
        Intent intent = new Intent();
        intent.putExtra("videoId", super.a);
        if (l1 != -4L)
        {
            intent.putExtra("internalId", l1);
        }
        intent.setData(Uri.parse((new StringBuilder()).append(com.millennialmedia.android.a.a(Boolean.valueOf(false)).getAbsolutePath()).append(File.separator).append(A).append("video.dat").toString()));
        intent.setClass(context, com/millennialmedia/android/MMActivity);
        intent.putExtra("class", "com.millennialmedia.android.CachedVideoPlayerActivity");
        au.b.b(context, intent);
    }

    protected final void a(JSONObject jsonobject)
    {
        boolean flag = false;
        super.a(jsonobject);
        Object obj = jsonobject.optJSONArray("startActivity");
        k = jsonobject.optString("overlayURL", null);
        l = jsonobject.optString("endURL", null);
        m = jsonobject.optString("cacheMissURL", null);
        A = jsonobject.optString("videoFileId", null);
        if (obj != null)
        {
            p = new String[((JSONArray) (obj)).length()];
            for (int i1 = 0; i1 < ((JSONArray) (obj)).length(); i1++)
            {
                p[i1] = ((JSONArray) (obj)).optString(i1);
            }

        } else
        {
            p = new String[0];
        }
        obj = jsonobject.optJSONArray("endActivity");
        if (obj != null)
        {
            q = new String[((JSONArray) (obj)).length()];
            for (int j1 = 0; j1 < ((JSONArray) (obj)).length(); j1++)
            {
                q[j1] = ((JSONArray) (obj)).optString(j1);
            }

        } else
        {
            q = new String[0];
        }
        obj = jsonobject.optJSONArray("cacheComplete");
        if (obj != null)
        {
            u = new String[((JSONArray) (obj)).length()];
            for (int k1 = 0; k1 < ((JSONArray) (obj)).length(); k1++)
            {
                u[k1] = ((JSONArray) (obj)).optString(k1);
            }

        } else
        {
            u = new String[0];
        }
        obj = jsonobject.optJSONArray("cacheFailed");
        if (obj != null)
        {
            v = new String[((JSONArray) (obj)).length()];
            for (int l1 = 0; l1 < ((JSONArray) (obj)).length(); l1++)
            {
                v[l1] = ((JSONArray) (obj)).optString(l1);
            }

        } else
        {
            v = new String[0];
        }
        obj = jsonobject.optJSONArray("videoError");
        if (obj != null)
        {
            w = new String[((JSONArray) (obj)).length()];
            for (int i2 = 0; i2 < ((JSONArray) (obj)).length(); i2++)
            {
                w[i2] = ((JSONArray) (obj)).optString(i2);
            }

        } else
        {
            w = new String[0];
        }
        h = jsonobject.optBoolean("showVideoPlayerControls");
        o = jsonobject.optBoolean("showCountdownHUD");
        x = jsonobject.optBoolean("reloadOverlayOnRestart");
        obj = jsonobject.optJSONObject("onCompletion");
        if (obj != null)
        {
            j = ((JSONObject) (obj)).optString("url", null);
            n = ((JSONObject) (obj)).optBoolean("stayInPlayer");
        }
        r = (long)(jsonobject.optDouble("duration", 0.0D) * 1000D);
        s = jsonobject.optLong("contentLength");
        t = jsonobject.optLong("closeAfterDelay");
        obj = jsonobject.optJSONArray("buttons");
        if (obj != null)
        {
            for (int j2 = 0; j2 < ((JSONArray) (obj)).length(); j2++)
            {
                Object obj2 = ((JSONArray) (obj)).optJSONObject(j2);
                if (obj2 != null)
                {
                    obj2 = new VideoImage(((JSONObject) (obj2)));
                    y.add(obj2);
                }
            }

        }
        jsonobject = jsonobject.optJSONArray("log");
        if (jsonobject != null)
        {
            for (int k2 = ((flag) ? 1 : 0); k2 < jsonobject.length(); k2++)
            {
                Object obj1 = jsonobject.optJSONObject(k2);
                if (obj1 != null)
                {
                    obj1 = new VideoLogEvent(((JSONObject) (obj1)));
                    z.add(obj1);
                }
            }

        }
    }

    final boolean a(Context context)
    {
        boolean flag;
        boolean flag1 = com.millennialmedia.android.a.a(e, (new StringBuilder()).append(A).append("video.dat").toString());
        flag = flag1;
        if (flag1)
        {
            int i1 = 0;
            flag = flag1;
            do
            {
                if (i1 >= y.size())
                {
                    break;
                }
                VideoImage videoimage = (VideoImage)y.get(i1);
                flag = com.millennialmedia.android.a.a(videoimage.a, (new StringBuilder()).append(super.a).append(videoimage.a()).toString(), context);
                if (!flag)
                {
                    break;
                }
                i1++;
            } while (true);
        }
        if (flag) goto _L2; else goto _L1
_L1:
        if (g)
        {
            b(context);
        }
        com.millennialmedia.android.w.a(v);
_L4:
        String.format("Caching completed successfully? %b", new Object[] {
            Boolean.valueOf(flag)
        });
        al.a();
        return flag;
_L2:
        if (flag)
        {
            if (b != null && b.length() > 0)
            {
                com.millennialmedia.android.a.a(context, b);
            }
            com.millennialmedia.android.w.a(u);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final boolean a(Context context, ab ab1, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (a() || !c(context) || !com.millennialmedia.android.v.a(context).a(ab1.f, d)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (a() || !c(context))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    final void b(Context context)
    {
        super.b(context);
        com.millennialmedia.android.a.a(context, 2, new b(context, this));
        com.millennialmedia.android.a.b(context, b);
        String.format("Ad %s was deleted.", new Object[] {
            super.a
        });
        al.a();
    }

    final int c()
    {
        return 1;
    }

    final boolean c(Context context)
    {
label0:
        {
label1:
            {
                int i1 = y.size();
                context = com.millennialmedia.android.a.f(context);
                Object obj = com.millennialmedia.android.a.a(Boolean.valueOf(false));
                if (context == null || obj == null)
                {
                    break label0;
                }
                String as[] = context.list(new a(this));
                VideoImage videoimage;
                boolean flag;
                if (as != null && as.length >= i1 + 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag || obj == null)
                {
                    break label1;
                }
                if (!(new File(((File) (obj)), (new StringBuilder()).append(A).append("video.dat").toString())).exists())
                {
                    return false;
                }
                obj = y.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label1;
                    }
                    videoimage = (VideoImage)((Iterator) (obj)).next();
                } while ((new File(context, (new StringBuilder()).append(super.a).append(videoimage.a()).toString())).exists());
                return false;
            }
            return flag;
        }
        return false;
    }

    final String d()
    {
        return "Video";
    }

    public int describeContents()
    {
        return 0;
    }

    public void readExternal(ObjectInput objectinput)
    {
        boolean flag = false;
        super.readExternal(objectinput);
        h = objectinput.readBoolean();
        j = (String)objectinput.readObject();
        k = (String)objectinput.readObject();
        l = (String)objectinput.readObject();
        m = (String)objectinput.readObject();
        A = (String)objectinput.readObject();
        n = objectinput.readBoolean();
        o = objectinput.readBoolean();
        x = objectinput.readBoolean();
        int l2 = objectinput.readInt();
        p = new String[l2];
        for (int i1 = 0; i1 < l2; i1++)
        {
            p[i1] = (String)objectinput.readObject();
        }

        l2 = objectinput.readInt();
        q = new String[l2];
        for (int j1 = 0; j1 < l2; j1++)
        {
            q[j1] = (String)objectinput.readObject();
        }

        r = objectinput.readLong();
        i = objectinput.readBoolean();
        s = objectinput.readLong();
        t = objectinput.readLong();
        l2 = objectinput.readInt();
        u = new String[l2];
        for (int k1 = 0; k1 < l2; k1++)
        {
            u[k1] = (String)objectinput.readObject();
        }

        l2 = objectinput.readInt();
        v = new String[l2];
        for (int l1 = 0; l1 < l2; l1++)
        {
            v[l1] = (String)objectinput.readObject();
        }

        l2 = objectinput.readInt();
        w = new String[l2];
        for (int i2 = 0; i2 < l2; i2++)
        {
            w[i2] = (String)objectinput.readObject();
        }

        y.clear();
        l2 = objectinput.readInt();
        for (int j2 = 0; j2 < l2; j2++)
        {
            VideoImage videoimage = (VideoImage)objectinput.readObject();
            y.add(videoimage);
        }

        z.clear();
        l2 = objectinput.readInt();
        for (int k2 = ((flag) ? 1 : 0); k2 < l2; k2++)
        {
            VideoLogEvent videologevent = (VideoLogEvent)objectinput.readObject();
            z.add(videologevent);
        }

    }

    public void writeExternal(ObjectOutput objectoutput)
    {
        boolean flag = false;
        super.writeExternal(objectoutput);
        objectoutput.writeBoolean(h);
        objectoutput.writeObject(j);
        objectoutput.writeObject(k);
        objectoutput.writeObject(l);
        objectoutput.writeObject(m);
        objectoutput.writeObject(A);
        objectoutput.writeBoolean(n);
        objectoutput.writeBoolean(o);
        objectoutput.writeBoolean(x);
        objectoutput.writeInt(p.length);
        String as[] = p;
        int j2 = as.length;
        for (int i1 = 0; i1 < j2; i1++)
        {
            objectoutput.writeObject(as[i1]);
        }

        objectoutput.writeInt(q.length);
        as = q;
        j2 = as.length;
        for (int j1 = 0; j1 < j2; j1++)
        {
            objectoutput.writeObject(as[j1]);
        }

        objectoutput.writeLong(r);
        objectoutput.writeBoolean(i);
        objectoutput.writeLong(s);
        objectoutput.writeLong(t);
        objectoutput.writeInt(u.length);
        as = u;
        j2 = as.length;
        for (int k1 = 0; k1 < j2; k1++)
        {
            objectoutput.writeObject(as[k1]);
        }

        objectoutput.writeInt(v.length);
        as = v;
        j2 = as.length;
        for (int l1 = 0; l1 < j2; l1++)
        {
            objectoutput.writeObject(as[l1]);
        }

        objectoutput.writeInt(w.length);
        as = w;
        j2 = as.length;
        for (int i2 = ((flag) ? 1 : 0); i2 < j2; i2++)
        {
            objectoutput.writeObject(as[i2]);
        }

        objectoutput.writeInt(y.size());
        for (Iterator iterator = y.iterator(); iterator.hasNext(); objectoutput.writeObject((VideoImage)iterator.next())) { }
        objectoutput.writeInt(z.size());
        for (Iterator iterator1 = z.iterator(); iterator1.hasNext(); objectoutput.writeObject((VideoLogEvent)iterator1.next())) { }
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        super.writeToParcel(parcel, i1);
        parcel.writeInt(p.length);
        parcel.writeStringArray(p);
        parcel.writeInt(q.length);
        parcel.writeStringArray(q);
        parcel.writeBooleanArray(new boolean[] {
            h, n, o, x, i
        });
        parcel.writeString(j);
        parcel.writeString(l);
        parcel.writeString(k);
        parcel.writeString(m);
        parcel.writeString(A);
        parcel.writeLong(r);
        parcel.writeLong(s);
        parcel.writeLong(t);
        parcel.writeList(y);
        parcel.writeList(z);
        parcel.writeInt(u.length);
        parcel.writeStringArray(u);
        parcel.writeInt(v.length);
        parcel.writeStringArray(v);
        parcel.writeInt(w.length);
        parcel.writeStringArray(w);
    }

}
