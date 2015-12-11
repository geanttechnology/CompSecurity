// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.suggestions;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.f.e;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.managers.RecommendationManager;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.i;
import com.smule.android.network.managers.x;
import com.smule.android.network.managers.y;
import com.smule.android.network.models.SongV2;
import com.smule.android.network.models.StoreSectionV2;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.data.model.GameReward;
import com.smule.pianoandroid.data.model.LevelConfig;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.utils.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.magicpiano.suggestions:
//            a

public class c
{

    static final String a = com/smule/pianoandroid/magicpiano/suggestions/c.getName();
    private static c f;
    ArrayList b;
    ArrayList c;
    ArrayList d;
    int e;
    private Context g;
    private String h;
    private List i;
    private List j;
    private String k;

    public c()
    {
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        e = 0;
        i = new ArrayList();
        j = new ArrayList();
    }

    public static c a()
    {
        com/smule/pianoandroid/magicpiano/suggestions/c;
        JVM INSTR monitorenter ;
        c c1;
        if (f == null)
        {
            f = new c();
        }
        c1 = f;
        com/smule/pianoandroid/magicpiano/suggestions/c;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    static String a(c c1, String s)
    {
        c1.k = s;
        return s;
    }

    static List a(c c1, List list)
    {
        c1.i = list;
        return list;
    }

    private void a(int l, LinkedHashSet linkedhashset)
    {
        Iterator iterator = b.iterator();
label0:
        do
        {
label1:
            {
                if (iterator.hasNext())
                {
                    Object obj = (com.smule.pianoandroid.magicpiano.suggestions.a)iterator.next();
                    if (!((com.smule.pianoandroid.magicpiano.suggestions.a) (obj)).a(l).booleanValue())
                    {
                        continue;
                    }
                    String s;
                    for (obj = ((com.smule.pianoandroid.magicpiano.suggestions.a) (obj)).b.iterator(); !((Iterator) (obj)).hasNext(); linkedhashset.add(s))
                    {
                        continue label0;
                    }

                    s = (String)((Iterator) (obj)).next();
                    if (linkedhashset.size() < e)
                    {
                        break label1;
                    }
                }
                return;
            }
        } while (true);
    }

    static void a(c c1)
    {
        c1.g();
    }

    private void a(String s, LinkedHashSet linkedhashset)
    {
        aa.a(a, (new StringBuilder()).append("Last song: ").append(s).append(" ServerUid: ").append(k).append(" Similar songs: ").append(j).toString());
        if (s == null || !s.equals(k)) goto _L2; else goto _L1
_L1:
        s = j.iterator();
_L6:
        if (!s.hasNext()) goto _L2; else goto _L3
_L3:
        String s1 = (String)s.next();
        if (linkedhashset.size() < e) goto _L4; else goto _L2
_L2:
        return;
_L4:
        if (ak.a().f(s1) != null)
        {
            linkedhashset.add(s1);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(LinkedHashSet linkedhashset)
    {
        Iterator iterator = d.iterator();
        do
        {
            String s;
label0:
            {
                if (iterator.hasNext())
                {
                    s = (String)iterator.next();
                    if (linkedhashset.size() < e)
                    {
                        break label0;
                    }
                }
                return;
            }
            if (ak.a().f(s) != null && b(s).booleanValue())
            {
                linkedhashset.add(s);
            }
        } while (true);
    }

    private void a(LinkedHashSet linkedhashset, String s)
    {
        aa.c(a, (new StringBuilder()).append(s).append(": ").append(linkedhashset).toString());
    }

    static Context b(c c1)
    {
        return c1.g;
    }

    private Boolean b(String s)
    {
        if (h != null && h.compareTo(s) == 0)
        {
            return Boolean.valueOf(false);
        }
        if (com.smule.android.network.managers.i.a().c(s))
        {
            return Boolean.valueOf(false);
        }
        if (c.contains(s))
        {
            return Boolean.valueOf(false);
        }
        if (com.smule.pianoandroid.e.c.a().b(s) != null)
        {
            return Boolean.valueOf(false);
        }
        if (com.smule.pianoandroid.magicpiano.a.g.a().b(s))
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(true);
        }
    }

    static List b(c c1, List list)
    {
        c1.j = list;
        return list;
    }

    private void b(String s, LinkedHashSet linkedhashset)
    {
        SongV2 songv2_1;
label0:
        {
            Object obj;
            if (s != null)
            {
                obj = s;
                if (!s.isEmpty())
                {
                    break label0;
                }
            }
            obj = z.a().b().getString("SONG_SELECTED", null);
            if (!com.smule.pianoandroid.magicpiano.c.a.a().e() || obj == null || ((String) (obj)).isEmpty())
            {
                obj = "_twinkle_twinkle_bundled";
            }
        }
        s = ak.a().a(((String) (obj)));
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = ak.a().g(((SongV2) (s)).artist);
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L5
_L5:
        songv2_1 = (SongV2)((Iterator) (obj)).next();
        if (!b(songv2_1.songId).booleanValue() || linkedhashset.contains(songv2_1.songId)) goto _L7; else goto _L6
_L6:
        if (linkedhashset.size() < e) goto _L9; else goto _L8
_L8:
        a(linkedhashset, "Appended Related (artist) Songs");
_L2:
        return;
_L9:
        linkedhashset.add(songv2_1.songId);
          goto _L7
_L4:
        a(linkedhashset, "Appended Related (artist) Songs");
        s = ak.a().h(((SongV2) (s)).genre);
        if (s == null) goto _L2; else goto _L10
_L10:
        s = s.iterator();
_L13:
        if (!s.hasNext()) goto _L2; else goto _L11
_L11:
        SongV2 songv2 = (SongV2)s.next();
        if (!b(songv2.songId).booleanValue() || linkedhashset.contains(songv2.songId)) goto _L13; else goto _L12
_L12:
        if (linkedhashset.size() >= e) goto _L2; else goto _L14
_L14:
        linkedhashset.add(songv2.songId);
          goto _L13
    }

    private void b(LinkedHashSet linkedhashset)
    {
        Iterator iterator = i.iterator();
        do
        {
            String s;
label0:
            {
                if (iterator.hasNext())
                {
                    s = (String)iterator.next();
                    if (linkedhashset.size() < e)
                    {
                        break label0;
                    }
                }
                return;
            }
            if (ak.a().f(s) != null)
            {
                linkedhashset.add(s);
            }
        } while (true);
    }

    static List c(c c1)
    {
        return c1.i;
    }

    private void c(String s)
    {
        if ((h == null || s.compareTo(h) != 0) && (h != null || !s.equals(z.a().b().getString("SONG_SELECTED", null))))
        {
            h = s;
            aa.a(a, (new StringBuilder()).append("LastSong persisted to ").append(s).toString());
            if (!c.contains(s) && !s.equals(z.a().b().getString("SONG_SELECTED", null)))
            {
                RecommendationManager.a().a(s, new SuggestionManager._cls5(s));
                return;
            }
        }
    }

    static List d(c c1)
    {
        return c1.j;
    }

    private void f()
    {
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        Object obj;
        d = (ArrayList)com.smule.android.network.managers.a.a().a("piandroid.suggestions", "popularSongs", new ArrayList());
        obj = com.smule.android.network.managers.a.a().a("piandroid.suggestions", "songsForDay", "{}");
        obj = (JsonNode)com.smule.android.f.e.a().readValue(((String) (obj)), com/fasterxml/jackson/databind/JsonNode);
        if (obj == null) goto _L2; else goto _L1
_L1:
        JsonNode jsonnode;
        for (obj = ((JsonNode) (obj)).iterator(); ((Iterator) (obj)).hasNext(); b.add(new com.smule.pianoandroid.magicpiano.suggestions.a(jsonnode)))
        {
            jsonnode = (JsonNode)((Iterator) (obj)).next();
        }

          goto _L2
        Object obj1;
        obj1;
        aa.b(a, "JSONParseException thrown parsing suggestions JSON");
_L5:
        return;
_L2:
        obj1 = com.smule.android.network.managers.a.a().a("piandroid.suggestions", "suggestionConfig", "{}");
        obj1 = (JsonNode)com.smule.android.f.e.a().readValue(((String) (obj1)), com/fasterxml/jackson/databind/JsonNode);
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((JsonNode) (obj1)).has("sectionLength"))
        {
            break MISSING_BLOCK_LABEL_273;
        }
        e = ((JsonNode) (obj1)).get("sectionLength").asInt();
_L3:
        if (((JsonNode) (obj1)).has("ignoreList"))
        {
            obj1 = ((JsonNode) (obj1)).get("ignoreList").iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                JsonNode jsonnode1 = (JsonNode)((Iterator) (obj1)).next();
                c.add(jsonnode1.asText());
            }
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        aa.b(a, "JSONMappingException thrown parsing suggestions JSON");
        return;
        aa.a(a, "no section length specified, section will be empty");
          goto _L3
        obj1;
        aa.b(a, "IOException thrown parsing suggestions JSON");
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void g()
    {
        f();
        h();
    }

    private void h()
    {
        for (Iterator iterator = com.smule.pianoandroid.e.c.a().e().iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((LevelConfig)iterator.next()).rewards.iterator();
            while (iterator1.hasNext()) 
            {
                GameReward gamereward = (GameReward)iterator1.next();
                if (gamereward.getRewardType().equals(com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT))
                {
                    c.add(gamereward.value);
                }
            }
        }

    }

    private void i()
    {
        Object obj = g.getSharedPreferences("magic_piano_prefs", 0);
        h = ((SharedPreferences) (obj)).getString("LAST_PLAYED_SONG", null);
        if (h != null)
        {
            Log.d(a, (new StringBuilder()).append("reading cached last song played: ").append(h).toString());
        }
        k = ((SharedPreferences) (obj)).getString("SERVER_SUGGESTION_UID", null);
        if (!TextUtils.isEmpty(k))
        {
            String s = ((SharedPreferences) (obj)).getString("SERVER_SUGGESTED_SONGS", null);
            if (!TextUtils.isEmpty(s))
            {
                aa.a(a, (new StringBuilder()).append("Reading cached server similiar songs ").append(s).toString());
                j = Arrays.asList(TextUtils.split(s, ","));
            }
        }
        obj = ((SharedPreferences) (obj)).getString("SERVER_DEMOGRAPHIC_SONGS", null);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            aa.a(a, (new StringBuilder()).append("Reading cached server demographic songs ").append(((String) (obj))).toString());
            i = Arrays.asList(TextUtils.split(((String) (obj)), ","));
        }
    }

    public void a(Context context)
    {
        g = context;
        i();
        context = new Observer() {

            final c a;

            public void update(Observable observable, Object obj)
            {
                observable = (String)((Map)obj).get("ACTION");
                if ("ENTITLEMENTS_UPDATED_ACTION".equals(observable) || "PRODUCTS_SORTED_ACTION".equals(observable))
                {
                    a.c();
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("SONGBOOK_UPDATED_EVENT", context);
        context = new Observer() {

            final c a;

            public void update(Observable observable, Object obj)
            {
                com.smule.pianoandroid.magicpiano.suggestions.c.a(a);
            }

            
            {
                a = c.this;
                super();
            }
        };
        com.smule.android.f.h.a().a("APP_SETTINGS_LOADED_EVENT", context);
    }

    public void a(String s)
    {
        c(s);
    }

    public void a(boolean flag)
    {
        RecommendationManager.a().a(new SuggestionManager._cls4(flag));
    }

    public void b()
    {
        Long long1;
        boolean flag;
label0:
        {
            long1 = Long.valueOf(g.getSharedPreferences("magic_piano_prefs", 0).getLong("SERVER_DEMOGRAPHIC_TIMESTAMP", -1L));
            boolean flag1 = z.a().b().getBoolean("ONBOARDING_REPORTED", false);
            flag = flag1;
            if (flag1)
            {
                break label0;
            }
            if (com.smule.pianoandroid.magicpiano.a.g.a().d().size() <= 2)
            {
                flag = flag1;
                if (com.smule.android.network.managers.i.a().c().size() <= 2)
                {
                    break label0;
                }
            }
            p.a(z.a().b().edit().putBoolean("ONBOARDING_REPORTED", true));
            flag = true;
        }
        String s = z.a().b().getString("SONG_SELECTED", null);
        if (flag)
        {
            if (long1.longValue() + 0x5265c00L < System.currentTimeMillis())
            {
                a(true);
            }
        } else
        if (com.smule.pianoandroid.magicpiano.c.a.a().e())
        {
            if (s != null && !s.isEmpty())
            {
                RecommendationManager.a().a(s, new SuggestionManager._cls3(long1));
                return;
            }
            if (long1.longValue() + 0x5265c00L < System.currentTimeMillis())
            {
                a(true);
                return;
            }
        } else
        {
            a(false);
            return;
        }
    }

    public void c()
    {
    }

    public StoreSectionV2 d()
    {
        StoreSectionV2 storesectionv2 = new StoreSectionV2();
        storesectionv2.displayName = MagicApplication.getContext().getString(0x7f0c0285);
        storesectionv2.order = -2;
        storesectionv2.sectionId = "suggested";
        storesectionv2.listings = new ArrayList();
        for (Iterator iterator = e().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            com.smule.android.network.models.ListingV2 listingv2 = ak.a().f(s);
            if (listingv2 != null)
            {
                storesectionv2.listings.add(listingv2);
            } else
            {
                aa.b(a, (new StringBuilder()).append("no listing found for suggested song: ").append(s).toString());
            }
        }

        return storesectionv2;
    }

    public List e()
    {
        LinkedHashSet linkedhashset;
        int l = n.a(UserManager.n().j().longValue());
        linkedhashset = new LinkedHashSet();
        a(l, linkedhashset);
        a(linkedhashset, "Appended Install Day Songs");
        if (linkedhashset.size() >= e) goto _L2; else goto _L1
_L1:
        if (h != null) goto _L4; else goto _L3
_L3:
        b(linkedhashset);
        a(linkedhashset, "Appended Server Demographic Songs (/v2/rec/songs)");
_L2:
        if (linkedhashset.size() < e)
        {
            a(linkedhashset);
            a(linkedhashset, "Appended Popular songs");
        }
        if (linkedhashset.size() < e)
        {
            b(h, linkedhashset);
            a(linkedhashset, "Appended Related (artist and genre) Songs");
        }
        return new ArrayList(linkedhashset);
_L4:
        if (!c.contains(h) && !h.equals(z.a().b().getString("SONG_SELECTED", null)))
        {
            a(h, linkedhashset);
            a(linkedhashset, "Appended Server Similar Songs (/v2/rec/song/similar)");
        }
        if (true) goto _L2; else goto _L5
_L5:
    }


    // Unreferenced inner class com/smule/pianoandroid/magicpiano/suggestions/SuggestionManager$3

/* anonymous class */
    class SuggestionManager._cls3
        implements com.smule.android.network.managers.RecommendationManager.RecommedationSelectCallback
    {

        final Long a;
        final c b;

        public void handleResponse(x x1)
        {
            p.a(z.a().b().edit().putBoolean("ONBOARDING_REPORTED", x1.a()));
            if (x1.a() || a.longValue() + 0x5265c00L < System.currentTimeMillis())
            {
                com.smule.pianoandroid.magicpiano.suggestions.c.a().a(true);
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((x)obj);
        }

            
            {
                b = c.this;
                a = long1;
                super();
            }
    }


    // Unreferenced inner class com/smule/pianoandroid/magicpiano/suggestions/SuggestionManager$4

/* anonymous class */
    class SuggestionManager._cls4
        implements com.smule.android.network.managers.RecommendationManager.GetRecommendedDemographicSongsCallback
    {

        final boolean a;
        final c b;

        public void handleResponse(y y1)
        {
            if (y1.a())
            {
                com.smule.pianoandroid.magicpiano.suggestions.c.a(b, y1.mSongs);
                ak.a().i();
                y1 = c.b(b).getSharedPreferences("magic_piano_prefs", 0).edit();
                y1.putString("SERVER_DEMOGRAPHIC_SONGS", TextUtils.join(",", c.c(b)));
                if (a)
                {
                    y1.putLong("SERVER_DEMOGRAPHIC_TIMESTAMP", System.currentTimeMillis());
                }
                p.a(y1);
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((y)obj);
        }

            
            {
                b = c.this;
                a = flag;
                super();
            }
    }


    // Unreferenced inner class com/smule/pianoandroid/magicpiano/suggestions/SuggestionManager$5

/* anonymous class */
    class SuggestionManager._cls5
        implements com.smule.android.network.managers.RecommendationManager.GetRecommendedSongsBySongCallback
    {

        final String a;
        final c b;

        public void handleResponse(y y1)
        {
            if (y1.a())
            {
                aa.a(com.smule.pianoandroid.magicpiano.suggestions.c.a, (new StringBuilder()).append("Saving server songs ").append(y1.mSongs).toString());
                c.b(b, y1.mSongs);
                com.smule.pianoandroid.magicpiano.suggestions.c.a(b, a);
                ak.a().i();
                y1 = c.b(b).getSharedPreferences("magic_piano_prefs", 0).edit();
                y1.putString("LAST_PLAYED_SONG", a);
                y1.putString("SERVER_SUGGESTION_UID", a);
                y1.putString("SERVER_SUGGESTED_SONGS", TextUtils.join(",", c.d(b)));
                p.a(y1);
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((y)obj);
        }

            
            {
                b = c.this;
                a = s;
                super();
            }
    }

}
