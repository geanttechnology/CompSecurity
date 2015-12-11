// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.j;
import com.smule.android.f.k;
import com.smule.android.f.p;
import com.smule.android.network.a.t;
import com.smule.android.network.a.u;
import com.smule.android.network.a.v;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.a;
import com.smule.android.network.core.o;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.ResourceV2;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.SoundfontV2;
import com.smule.android.network.models.StoreSectionV2;
import com.smule.android.network.models.b;
import com.smule.android.network.models.d;
import com.smule.android.network.models.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.android.network.managers:
//            LocalizationManager, am, i, al

public class ak
{

    private static final String b = com/smule/android/network/managers/ak.getName();
    private static boolean d = false;
    private static ak e = null;
    public long a;
    private AtomicBoolean c;
    private t f;
    private e g;
    private Context h;
    private Map i;
    private Map j;
    private Map k;
    private Map l;
    private Map m;
    private Map n;
    private Map o;
    private Map p;
    private Map q;
    private StoreSectionV2 r;
    private boolean s;
    private boolean t;
    private boolean u;
    private String v;
    private AtomicBoolean w;
    private long x;
    private am y;
    private al z;

    private ak()
    {
        c = new AtomicBoolean(false);
        i = new HashMap();
        j = new HashMap();
        k = new HashMap();
        l = new HashMap();
        m = new HashMap();
        n = new HashMap();
        o = new HashMap();
        p = new HashMap();
        q = new HashMap();
        s = false;
        t = false;
        u = false;
        a = 0x36ee80L;
        w = new AtomicBoolean(false);
        x = 0L;
        g = new e();
        g.songs = new ArrayList();
        g.soundfonts = new ArrayList();
        g.listings = new ArrayList();
        g.storeSections = new ArrayList();
        v();
    }

    public static ak a()
    {
        com/smule/android/network/managers/ak;
        JVM INSTR monitorenter ;
        ak ak1;
        if (e == null)
        {
            aa.a(b, "getInstance() - creating new StoreManager instance");
            e = new ak();
        }
        ak1 = e;
        com/smule/android/network/managers/ak;
        JVM INSTR monitorexit ;
        return ak1;
        Exception exception;
        exception;
        throw exception;
    }

    static StoreSectionV2 a(ak ak1, StoreSectionV2 storesectionv2)
    {
        ak1.r = storesectionv2;
        return storesectionv2;
    }

    private void a(JsonNode jsonnode)
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        g = (e)com.smule.android.f.e.a(jsonnode, com/smule/android/network/models/e);
        i.clear();
        j.clear();
        k.clear();
        SongV2 songv2;
        for (Iterator iterator = g.songs.iterator(); iterator.hasNext(); c(songv2))
        {
            songv2 = (SongV2)iterator.next();
            i.put(songv2.songId, songv2);
            b(songv2);
        }

        break MISSING_BLOCK_LABEL_110;
        jsonnode;
        throw jsonnode;
        o.clear();
        SoundfontV2 soundfontv2;
        for (Iterator iterator1 = g.soundfonts.iterator(); iterator1.hasNext(); o.put(soundfontv2.soundfontId, soundfontv2))
        {
            soundfontv2 = (SoundfontV2)iterator1.next();
        }

        Object obj;
        m.clear();
        n.clear();
        obj = g.listings.iterator();
_L3:
        Object obj1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_542;
        }
        obj1 = (ListingV2)((Iterator) (obj)).next();
        StoreSectionV2 storesectionv2;
        boolean flag;
        if (((ListingV2) (obj1)).price == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1.isFree = flag;
        if (!((ListingV2) (obj1)).productType.equals("SONG")) goto _L2; else goto _L1
_L1:
        obj1.song = a(((ListingV2) (obj1)).productId);
_L5:
        n.put(((ListingV2) (obj1)).listingId, obj1);
        if (m.containsKey(((ListingV2) (obj1)).productId))
        {
            break MISSING_BLOCK_LABEL_335;
        }
        m.put(((ListingV2) (obj1)).productId, obj1);
          goto _L3
_L2:
        if (!((ListingV2) (obj1)).productType.equals("SOUNDFONT")) goto _L5; else goto _L4
_L4:
        obj1.soundfont = d(((ListingV2) (obj1)).productId);
          goto _L5
label0:
        {
            if (!((ListingV2)m.get(((ListingV2) (obj1)).productId)).modes.isEmpty())
            {
                break label0;
            }
            aa.a(b, (new StringBuilder()).append("Filtering listing ").append(((ListingV2)m.get(((ListingV2) (obj1)).productId)).listingId).append(" in classic mode in favor of join mode listing ").append(((ListingV2) (obj1)).listingId).toString());
            n.remove(((ListingV2)m.get(((ListingV2) (obj1)).productId)).listingId);
            m.put(((ListingV2) (obj1)).productId, obj1);
        }
          goto _L3
        aa.a(b, (new StringBuilder()).append("Filtering listing ").append(((ListingV2) (obj1)).listingId).append(" in classic mode in favor of join mode listing ").append(((ListingV2)m.get(((ListingV2) (obj1)).productId)).listingId).toString());
        n.remove(((ListingV2) (obj1)).listingId);
          goto _L3
        l.clear();
        g.storeSections = new ArrayList();
        obj1 = jsonnode.get("storeSections").iterator();
_L13:
        if (!((Iterator) (obj1)).hasNext()) goto _L7; else goto _L6
_L6:
        jsonnode = (JsonNode)((Iterator) (obj1)).next();
        storesectionv2 = (StoreSectionV2)com.smule.android.f.e.a(jsonnode.get("section"), com/smule/android/network/models/StoreSectionV2);
        storesectionv2.order = i1;
        storesectionv2.listings = new ArrayList(storesectionv2.listingIds.size());
        obj = storesectionv2.listingIds.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s1 = (String)((Iterator) (obj)).next();
            if (n.containsKey(s1))
            {
                storesectionv2.listings.add(n.get(s1));
            }
        } while (true);
        l.put(storesectionv2.sectionId, storesectionv2);
        jsonnode = jsonnode.get("parentSectionId");
        if (jsonnode == null) goto _L9; else goto _L8
_L8:
        jsonnode = jsonnode.asText();
_L14:
        if (jsonnode == null)
        {
            break MISSING_BLOCK_LABEL_933;
        }
        obj = (StoreSectionV2)l.get(jsonnode);
_L15:
        if (obj != null) goto _L11; else goto _L10
_L10:
        g.storeSections.add(storesectionv2);
        aa.a(b, (new StringBuilder()).append("Section added ").append(storesectionv2.sectionId).append(" listings ").append(storesectionv2.listings.size()).toString());
          goto _L12
_L11:
        ((StoreSectionV2) (obj)).subSections.add(storesectionv2);
        aa.a(b, (new StringBuilder()).append(jsonnode).append(": Subsection added ").append(storesectionv2.sectionId).append(" listings ").append(storesectionv2.listings.size()).toString());
          goto _L12
_L7:
        u = true;
        this;
        JVM INSTR monitorexit ;
        return;
_L12:
        i1++;
          goto _L13
_L9:
        jsonnode = null;
          goto _L14
        obj = null;
          goto _L15
    }

    static void a(ak ak1)
    {
        ak1.r();
    }

    static void a(ak ak1, JsonNode jsonnode)
    {
        ak1.a(jsonnode);
    }

    static void a(ak ak1, String s1)
    {
        ak1.l(s1);
    }

    static void a(ak ak1, boolean flag, String s1, boolean flag1, long l1)
    {
        ak1.a(flag, s1, flag1, l1);
    }

    private void a(String s1, String s2)
    {
        android.content.SharedPreferences.Editor editor = h.getSharedPreferences("STORE_SETTINGS", 0).edit();
        editor.putString((new StringBuilder()).append("song_response_").append(s1).toString(), s2);
        com.smule.android.f.p.a(editor);
    }

    private void a(Set set)
    {
        Object obj = new HashSet();
        ((Set) (obj)).addAll(set);
        if (obj == null || ((Set) (obj)).size() == 0)
        {
            aa.a(b, "refreshOwnedSongsSection - getMySongsUids returned no UIDs; aborting refresh of owned songs section");
        }
        set = new ArrayList();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s1 = (String)((Iterator) (obj)).next();
            SongV2 songv2 = a(s1);
            if (songv2 != null)
            {
                ListingV2 listingv2 = f(songv2.songId);
                if (listingv2 == null)
                {
                    aa.b(b, (new StringBuilder()).append("Couldn't find listings for entitlement, creating it: ").append(s1).toString());
                    set.add(new ListingV2(songv2));
                } else
                {
                    set.add(listingv2);
                }
                aa.c(b, (new StringBuilder()).append("refreshOwnedSongsSection - adding ").append(songv2.title).toString());
            } else
            {
                aa.b(b, (new StringBuilder()).append("Couldn't find song for entitlement!").append(s1).toString());
            }
        }

        r.listings = set;
        if (r.listings != null && r.listings.size() > 0)
        {
            Collections.sort(r.listings, new b());
            r.listingIds = ListingV2.a(r.listings);
        }
    }

    private void a(boolean flag, String s1, boolean flag1, long l1)
    {
        if (!flag1) goto _L2; else goto _L1
_L1:
        q();
        if (s1 != null)
        {
            n(s1);
        }
        x = System.currentTimeMillis();
        if (flag)
        {
            com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", new Object[] {
                "ACTION", "SONGBOOK_SYNCED_ACTION"
            });
            d = true;
        }
_L4:
        int i1 = Math.round((float)(System.currentTimeMillis() - l1) / 1000F);
        aa.c(b, (new StringBuilder()).append("snapshot finished after ").append(i1).append(" seconds, success=").append(Boolean.valueOf(flag1)).toString());
        return;
_L2:
        if (!c.get())
        {
            com.smule.android.network.core.b.d().p();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(ak ak1, boolean flag)
    {
        ak1.s = flag;
        return flag;
    }

    public static SongV2 b(String s1)
    {
        s1 = (JsonNode)com.smule.android.f.e.a().readValue(s1, com/fasterxml/jackson/databind/JsonNode);
        s1 = (SongV2)com.smule.android.f.e.a().treeToValue(s1, com/smule/android/network/models/SongV2);
        return (SongV2)com.smule.android.network.managers.LocalizationManager.a().a("store", s1);
    }

    static AtomicBoolean b(ak ak1)
    {
        return ak1.w;
    }

    private void b(SongV2 songv2)
    {
        if (!j.containsKey(songv2.artist))
        {
            j.put(songv2.artist, new ArrayList());
        }
        ((List)j.get(songv2.artist)).add(songv2);
    }

    private void b(String s1, String s2)
    {
        android.content.SharedPreferences.Editor editor = h.getSharedPreferences("STORE_SETTINGS", 0).edit();
        editor.putString((new StringBuilder()).append("song_signature_").append(s1).toString(), s2);
        com.smule.android.f.p.a(editor);
    }

    public static ListingV2 c(String s1)
    {
        s1 = (JsonNode)com.smule.android.f.e.a().readValue(s1, com/fasterxml/jackson/databind/JsonNode);
        s1 = (ListingV2)com.smule.android.f.e.a().treeToValue(s1, com/smule/android/network/models/ListingV2);
        return (ListingV2)com.smule.android.network.managers.LocalizationManager.a().a("store", s1);
    }

    static void c(ak ak1)
    {
        ak1.m();
    }

    private void c(SongV2 songv2)
    {
        if (!k.containsKey(songv2.genre))
        {
            k.put(songv2.genre, new ArrayList());
        }
        ((List)k.get(songv2.genre)).add(songv2);
    }

    static al d(ak ak1)
    {
        return ak1.z;
    }

    private SongV2 d(SongV2 songv2)
    {
        String s1 = m(songv2.songId);
        if (s1 != null)
        {
            aa.a(b, (new StringBuilder()).append("Restoring song ").append(songv2.songId).append(" from saved json").toString());
            songv2.a((SongV2)com.smule.android.f.e.a((new o(s1)).j.get("song"), com/smule/android/network/models/SongV2));
            return songv2;
        } else
        {
            return null;
        }
    }

    static StoreSectionV2 e(ak ak1)
    {
        return ak1.t();
    }

    public static void j(String s1)
    {
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", new Object[] {
            "ACTION", "PRODUCT_UPDATED_ACTION", "UID", s1
        });
    }

    static String l()
    {
        return b;
    }

    private void l(String s1)
    {
        if (s1 == null)
        {
            aa.a(b, "saveStore - called with null responseBody");
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = h.getSharedPreferences("STORE_SETTINGS", 0).edit();
            editor.putString("store_response", s1);
            com.smule.android.f.p.a(editor);
            return;
        }
    }

    private String m(String s1)
    {
        return h.getSharedPreferences("STORE_SETTINGS", 0).getString((new StringBuilder()).append("song_response_").append(s1).toString(), null);
    }

    private void m()
    {
        long l1 = System.currentTimeMillis();
        boolean flag = false;
        o o1 = f.a(y.a(), o());
        aa.a(b, (new StringBuilder()).append("Fetching store snapshot ").append(o1.b).append(" Etag ").append(o1.l).append(" old etag ").append(v).toString());
        if (o1.b == 304 || v != null && v.equals(o1.l))
        {
            if (!d)
            {
                flag = true;
            }
            a(flag, ((String) (null)), true, l1);
        } else
        if (o1.b == 0)
        {
            aa.c(b, "new snapshot available, beginning sync.");
            com.smule.android.network.managers.LocalizationManager.a().a("store", new Runnable(o1, l1) {

                final o a;
                final long b;
                final ak c;

                public void run()
                {
                    com.smule.android.network.managers.ak.a(c, a.j.get("store"));
                    com.smule.android.network.managers.ak.a(c, a.h);
                    com.smule.android.network.managers.ak.a(c, true, a.l, true, b);
                }

            
            {
                c = ak.this;
                a = o1;
                b = l1;
                super();
            }
            });
            return;
        }
    }

    private String n()
    {
        return h.getSharedPreferences("STORE_SETTINGS", 0).getString("store_response", null);
    }

    private void n(String s1)
    {
        android.content.SharedPreferences.Editor editor = h.getSharedPreferences("STORE_SETTINGS", 0).edit();
        editor.putString("store_signature", s1);
        com.smule.android.f.p.a(editor);
        v = s1;
    }

    private String o()
    {
        v = h.getSharedPreferences("STORE_SETTINGS", 0).getString("store_signature", null);
        return v;
    }

    private String o(String s1)
    {
        return h.getSharedPreferences("STORE_SETTINGS", 0).getString((new StringBuilder()).append("song_signature_").append(s1).toString(), null);
    }

    private void p()
    {
        SharedPreferences sharedpreferences = h.getSharedPreferences("STORE_SETTINGS", 0);
        c.set(sharedpreferences.getBoolean("STORE_SETTINGS", false));
    }

    private void q()
    {
        android.content.SharedPreferences.Editor editor = h.getSharedPreferences("STORE_SETTINGS", 0).edit();
        editor.putBoolean("STORE_SETTINGS", true);
        com.smule.android.f.p.a(editor);
        c.set(true);
    }

    private void r()
    {
        if (s)
        {
            return;
        } else
        {
            s = true;
            (new Thread(new Runnable() {

                final ak a;

                public void run()
                {
                    if (com.smule.android.network.managers.ak.d(a) != null && com.smule.android.network.managers.ak.d(a).b())
                    {
                        com.smule.android.network.managers.ak.a(a, com.smule.android.network.managers.ak.e(a));
                    }
                    com.smule.android.network.managers.ak.a(a, false);
                    a.i();
                }

            
            {
                a = ak.this;
                super();
            }
            })).start();
            return;
        }
    }

    private void s()
    {
        a(com.smule.android.network.managers.i.a().c());
    }

    private StoreSectionV2 t()
    {
        aa.c(b, "create mySongs section");
        Set set = com.smule.android.network.managers.i.a().c();
        if (set == null || set.size() == 0)
        {
            aa.a(b, "createOwnedSongsSection - getMySongsUids returned no UIDs; aborting creation of owned songs section");
        }
        StoreSectionV2 storesectionv2 = new StoreSectionV2();
        int i1 = h.getResources().getIdentifier("my_songs", "string", h.getPackageName());
        if (i1 == 0)
        {
            storesectionv2.displayName = "My Songs";
        } else
        {
            storesectionv2.displayName = h.getString(i1);
        }
        if (z != null)
        {
            storesectionv2.order = z.c();
        } else
        {
            storesectionv2.order = -1;
        }
        storesectionv2.sectionId = "my_songs";
        r = storesectionv2;
        a(set);
        return storesectionv2;
    }

    private StoreSectionV2 u()
    {
        aa.a(b, "mySongs begin");
        StoreSectionV2 storesectionv2 = new StoreSectionV2();
        Iterator iterator;
        if (r == null)
        {
            aa.b(b, "Unexpected mOwnedSongs is null, creating it");
            r = t();
        } else
        {
            s();
        }
        storesectionv2.displayName = r.displayName;
        storesectionv2.listings = new ArrayList(r.listings);
        storesectionv2.order = r.order;
        storesectionv2.sectionId = r.sectionId;
        iterator = com.smule.android.network.core.b.d().i().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            if (!com.smule.android.network.managers.i.a().c(((String) (obj))))
            {
                SongV2 songv2 = a(((String) (obj)));
                if (songv2 != null)
                {
                    obj = f(((String) (obj)));
                    if (obj == null)
                    {
                        storesectionv2.listings.add(new ListingV2(songv2));
                    } else
                    {
                        storesectionv2.listings.add(obj);
                    }
                } else
                {
                    aa.b(b, (new StringBuilder()).append("Failed to find product for progressed song ").append(((String) (obj))).toString());
                }
            }
        } while (true);
        Collections.sort(storesectionv2.listings, new Comparator() {

            final ak a;

            public int a(ListingV2 listingv2, ListingV2 listingv2_1)
            {
                return listingv2.song.title.compareTo(listingv2_1.song.title);
            }

            public int compare(Object obj1, Object obj2)
            {
                return a((ListingV2)obj1, (ListingV2)obj2);
            }

            
            {
                a = ak.this;
                super();
            }
        });
        aa.a(b, (new StringBuilder()).append("mySongs done ").append(storesectionv2.listings).toString());
        return storesectionv2;
    }

    private void v()
    {
        Object obj = new ObjectMapper();
        q = new HashMap();
        p = new HashMap();
        try
        {
            Object obj1 = com.smule.android.network.core.b.d().e();
            int i1 = ((Context) (obj1)).getResources().getIdentifier("product_uid_map", "raw", ((Context) (obj1)).getPackageName());
            Object obj2;
            for (obj = ((ObjectMapper) (obj)).readTree(((Context) (obj1)).getResources().openRawResource(i1)).fields(); ((Iterator) (obj)).hasNext(); q.put(obj2, obj1))
            {
                obj2 = (java.util.Map.Entry)((Iterator) (obj)).next();
                obj1 = (String)((java.util.Map.Entry) (obj2)).getKey();
                obj2 = ((JsonNode)((java.util.Map.Entry) (obj2)).getValue()).textValue();
                p.put(obj1, obj2);
            }

        }
        catch (Exception exception)
        {
            aa.b(b, "Failed to read product_uid_map.json", exception);
        }
    }

    public SongV2 a(SongV2 songv2)
    {
        Object obj1 = null;
        if (songv2.eTag == null || songv2.eTag.length() == 0)
        {
            d(songv2);
        }
        o o1 = f.b(songv2.songId, o(songv2.songId));
        Object obj;
        if (o1.b == 304)
        {
            obj = songv2;
        } else
        {
            obj = obj1;
            if (o1.b != 0)
            {
                com.smule.android.network.core.b.a(o1);
                obj = obj1;
            }
        }
        obj1 = o1.b();
        if (obj1 != null)
        {
            obj = (SongV2)com.smule.android.f.e.a(((JsonNode) (obj1)).get("song"), com/smule/android/network/models/SongV2);
            obj1 = new HashSet();
            for (Iterator iterator = ((SongV2) (obj)).resources.iterator(); iterator.hasNext();)
            {
                ResourceV2 resourcev2 = (ResourceV2)iterator.next();
                if (((Set) (obj1)).contains(resourcev2.uid))
                {
                    iterator.remove();
                } else
                {
                    ((Set) (obj1)).add(resourcev2.uid);
                }
            }

            obj1 = a(((SongV2) (obj)).songId);
            if (obj1 != null)
            {
                ((SongV2) (obj1)).a(((SongV2) (obj)));
                obj = obj1;
            } else
            {
                aa.b(b, (new StringBuilder()).append("No existing product found for the song download ").append(songv2.songId).toString());
            }
            b(songv2.songId, o1.l);
            a(songv2.songId, o1.h);
        }
        return (SongV2)com.smule.android.network.managers.LocalizationManager.a().a("store", obj);
    }

    public SongV2 a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        SongV2 songv2_1 = (SongV2)com.smule.android.network.managers.LocalizationManager.a().a("store", i.get(s1));
        if (songv2_1 == null) goto _L2; else goto _L1
_L1:
        s1 = (SongV2)com.smule.android.network.managers.LocalizationManager.a().a("store", songv2_1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        SongV2 songv2;
        songv2 = songv2_1;
        if (songv2_1 != null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        songv2 = new SongV2();
        songv2.songId = s1;
        songv2_1 = d(songv2);
        songv2 = songv2_1;
        if (songv2_1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        i.put(s1, songv2_1);
        b(songv2_1);
        c(songv2_1);
        songv2 = songv2_1;
        s1 = (SongV2)com.smule.android.network.managers.LocalizationManager.a().a("store", songv2);
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public void a(Context context, boolean flag, am am1, al al1)
    {
        aa.a(b, (new StringBuilder()).append("initStore started - shallow init is: ").append(flag).toString());
        if (am1 == null)
        {
            throw new RuntimeException("init - StoreManagerRequiredMethodsDelegate cannot be null, as it is REQUIRED");
        }
        y = am1;
        if (al1 != null)
        {
            z = al1;
        }
        long l1 = System.currentTimeMillis();
        h = context;
        f = com.smule.android.network.a.t.a();
        aa.a(b, (new StringBuilder()).append("readProductUidMap() finished at: ").append(System.currentTimeMillis() - l1).toString());
        p();
        aa.a(b, (new StringBuilder()).append("readFirstSyncComplete() finished at: ").append(System.currentTimeMillis() - l1).toString());
        if (z != null && !c.get())
        {
            context = z.d();
            if (context != null)
            {
                l(context);
            }
        }
        if (!flag)
        {
            c();
            aa.a(b, (new StringBuilder()).append("deepInitStore() finished at: ").append(System.currentTimeMillis() - l1).toString());
        }
        j();
        aa.a(b, (new StringBuilder()).append("addBundledContent() finished at: ").append(System.currentTimeMillis() - l1).toString());
        l1 = Math.round((float)(System.currentTimeMillis() - l1) / 1000F);
        aa.a(b, (new StringBuilder()).append("initStore ended, duration = ").append(l1).toString());
    }

    public void a(j j1, boolean flag, am am1, al al1)
    {
        j1.a("StoreManager.loadStore", null, new k(flag, am1, al1) {

            final boolean a;
            final am b;
            final al c;
            final ak d;

            static k a(_cls2 _pcls2)
            {
                return _pcls2.h;
            }

            public void a(j j2)
            {
                (new Thread(new Runnable(this, j2) {

                    final j a;
                    final _cls2 b;

                    public void run()
                    {
                        com.smule.android.network.managers.ak.a().a(com.smule.android.network.core.b.d().e(), b.a, b.b, b.c);
                        a.b(com.smule.android.network.managers._cls2.a(b));
                    }

            
            {
                b = _pcls2;
                a = j1;
                super();
            }
                })).start();
            }

            
            {
                d = ak.this;
                a = flag;
                b = am1;
                c = al1;
                super();
            }
        }).a();
    }

    public void a(Runnable runnable)
    {
        if (!f())
        {
            if (runnable != null)
            {
                runnable.run();
            }
            return;
        } else
        {
            com.smule.android.network.core.b.a(new Runnable(runnable) {

                final Runnable a;
                final ak b;

                public void run()
                {
                    if (com.smule.android.network.managers.ak.b(b).getAndSet(true))
                    {
                        if (a != null)
                        {
                            a.run();
                        }
                    } else
                    {
                        ak.c(b);
                        com.smule.android.network.managers.ak.b(b).set(false);
                        if (a != null)
                        {
                            a.run();
                            return;
                        }
                    }
                }

            
            {
                b = ak.this;
                a = runnable;
                super();
            }
            });
            return;
        }
    }

    public void a(String s1, String s2, String s3, Integer integer, v v1, u u1, NetworkResponseCallback networkresponsecallback, 
            String s4)
    {
        com.smule.android.network.core.b.a(new Runnable(networkresponsecallback, s1, s2, s3, integer, v1, u1, s4) {

            final NetworkResponseCallback a;
            final String b;
            final String c;
            final String d;
            final Integer e;
            final v f;
            final u g;
            final String h;
            final ak i;

            public void run()
            {
                com.smule.android.network.core.a.a(a, com.smule.android.network.a.t.a(b, c, d, e, f, g, h));
            }

            
            {
                i = ak.this;
                a = networkresponsecallback;
                b = s1;
                c = s2;
                d = s3;
                e = integer;
                f = v1;
                g = u1;
                h = s4;
                super();
            }
        });
    }

    public void b()
    {
        Observer observer = new Observer() {

            final ak a;

            public void update(Observable observable, Object obj)
            {
                observable = (String)((Map)obj).get("ACTION");
                if ("PRODUCTS_LOADED_ACTION".equals(observable))
                {
                    aa.c(ak.l(), "Products Downloaded.");
                    com.smule.android.network.managers.ak.a(a);
                } else
                {
                    if ("ENTITLEMENTS_UPDATED_ACTION".equals(observable))
                    {
                        aa.c(ak.l(), "Entitlements Updated.");
                        com.smule.android.network.managers.ak.a(a);
                        return;
                    }
                    if ("SONGBOOK_SYNCED_ACTION".equals(observable))
                    {
                        aa.c(ak.l(), "Songbook sync completed");
                        com.smule.android.network.managers.ak.a(a);
                        return;
                    }
                }
            }

            
            {
                a = ak.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", observer);
    }

    public void c()
    {
        if (t)
        {
            aa.a(b, "deepInitStore - already in progress; ignoring duplicate call");
            return;
        }
        if (u)
        {
            aa.e(b, "deepInitStore - already completed; ignoring call");
            return;
        }
        t = true;
        Object obj = n();
        if (obj != null)
        {
            obj = new o(((String) (obj)));
            if (((o) (obj)).b == 0 && ((o) (obj)).j != null)
            {
                a(((o) (obj)).j.get("store"));
            }
        }
        t = false;
        i();
    }

    public SoundfontV2 d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = (SoundfontV2)com.smule.android.network.managers.LocalizationManager.a().a("store", o.get(s1));
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    public List d()
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        arraylist = new ArrayList(g.storeSections);
        if (z != null && z.a())
        {
            arraylist.add(u());
        }
        if (z == null || !z.b()) goto _L2; else goto _L1
_L1:
        if (r != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        r = t();
_L3:
        if (r.listings.size() > 0)
        {
            arraylist.add(r);
        }
_L2:
        Collections.sort(arraylist, new d());
        this;
        JVM INSTR monitorexit ;
        return arraylist;
        s();
          goto _L3
        Exception exception;
        exception;
        throw exception;
    }

    public StoreSectionV2 e(String s1)
    {
        Iterator iterator = (new ArrayList(g.storeSections)).iterator();
_L2:
        StoreSectionV2 storesectionv2;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        storesectionv2 = (StoreSectionV2)iterator.next();
        iterator1 = storesectionv2.listings.iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((ListingV2)iterator1.next()).listingId.equals(s1)) goto _L4; else goto _L3
_L3:
        return storesectionv2;
        return null;
    }

    public List e()
    {
        HashMap hashmap = new HashMap();
        this;
        JVM INSTR monitorenter ;
        hashmap.putAll(n);
        this;
        JVM INSTR monitorexit ;
        return new ArrayList(hashmap.values());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ListingV2 f(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ListingV2 listingv2;
        if (m == null || m.size() == 0)
        {
            aa.b(b, "findListingsByProductUid - mListingsByProduct is empty; was the StoreManager not initialized properly?");
        }
        listingv2 = (ListingV2)m.get(s1);
        if (listingv2 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return listingv2;
_L2:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        ListingV2 listingv2_1 = (ListingV2)m.get(s1);
        listingv2 = listingv2_1;
        if (listingv2_1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        aa.b(b, (new StringBuilder()).append("findListingByProductUid - returning null ListingV2 for product id: ").append(s1).toString());
        listingv2 = null;
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public boolean f()
    {
        return x + a < System.currentTimeMillis();
    }

    public List g(String s1)
    {
        return (List)j.get(s1);
    }

    public void g()
    {
        a(((Runnable) (null)));
    }

    public List h(String s1)
    {
        return (List)k.get(s1);
    }

    public void h()
    {
        d = false;
        com.smule.android.network.core.b.a(new Runnable() {

            final ak a;

            public void run()
            {
                com.smule.android.network.managers.ak.b(a).getAndSet(true);
                ak.c(a);
                com.smule.android.network.managers.ak.b(a).getAndSet(false);
            }

            
            {
                a = ak.this;
                super();
            }
        });
    }

    public ListingV2 i(String s1)
    {
        return (ListingV2)n.get(s1);
    }

    public void i()
    {
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", new Object[] {
            "ACTION", "PRODUCTS_SORTED_ACTION"
        });
    }

    public boolean j()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = com.smule.android.network.core.b.d().j().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj1 = (String)iterator.next();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        Object obj2 = ((JsonNode)com.smule.android.f.e.a().readValue(((String) (obj1)), com/fasterxml/jackson/databind/JsonNode)).get("data");
        if (obj2 == null) goto _L4; else goto _L5
_L5:
        obj2 = ((JsonNode) (obj2)).get("song");
        if (obj2 == null) goto _L4; else goto _L6
_L6:
        SongV2 songv2;
        obj2 = b(((JsonNode) (obj2)).toString());
        songv2 = a(((SongV2) (obj2)).songId);
        if (songv2 == null) goto _L8; else goto _L7
_L7:
        if (songv2.resources.size() != 0) goto _L4; else goto _L8
_L8:
        a(((SongV2) (obj2)).songId, ((String) (obj1)));
        i.put(((SongV2) (obj2)).songId, obj2);
        g.songs.add(obj2);
          goto _L4
        IOException ioexception;
        ioexception;
        Log.e(b, (new StringBuilder()).append("Error parsing json response from bundled content: ").append(((String) (obj1))).toString(), ioexception);
          goto _L4
        Object obj;
        obj;
        aa.b(b, (new StringBuilder()).append("Error parsing bundled content! ").append(obj).toString(), ((Throwable) (obj)));
        boolean flag = false;
_L11:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj = com.smule.android.network.core.b.d().l().iterator();
_L9:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_348;
            }
            obj1 = c((String)((Iterator) (obj)).next());
        } while ((ListingV2)n.get(((ListingV2) (obj1)).listingId) != null);
        if (((ListingV2) (obj1)).price == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1.isFree = flag;
        obj1.song = a(((ListingV2) (obj1)).productId);
        n.put(((ListingV2) (obj1)).listingId, obj1);
        m.put(((ListingV2) (obj1)).productId, obj1);
          goto _L9
        obj;
        throw obj;
        flag = true;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public int k()
    {
        return i.size() + o.size();
    }

    public String k(String s1)
    {
        String s2 = (String)p.get(s1);
        if (s2 == null)
        {
            return s1;
        } else
        {
            return s2;
        }
    }

}
