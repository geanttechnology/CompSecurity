// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            al, q

static final class t>
{

    ArrayList a;

    final t> a()
    {
        return (t>)a.get(0);
    }

    final a a(int j)
    {
        return (a)a.get(j);
    }

    final boolean a(a a1)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        a a2;
        a a3;
        boolean flag;
        int j;
        for (j = 0; j >= a1..size();)
        {
            break MISSING_BLOCK_LABEL_5117;
        }

        a2 = new <init>();
        a3 = a1.(j);
        if (a3 == null)
        {
            flag = false;
        } else
        {
            a2.a = a3.("uuid", "");
            a2.b = a3.("title", "");
            a2.c = a3.("ad_campaign_id");
            a2.d = a3.("ad_id");
            a2.e = a3.("ad_group_id");
            a2.f = a3.("cpcv_bid");
            a2.g = a3.("net_earnings");
            a2.h = a3.("expires");
            a2.i = a3.("enable_in_app_store", false);
            a2.j = a3.("video_events_on_replays", false);
            a2.k = a3.("test_ad", false);
            a2.l = a3.("fullscreen", false);
            a2.m = a3.("house_ad", false);
            a2.n = a3.("contracted", false);
            a2.o = new <init>();
            a a4 = a2.o;
            a a5 = a3.("limits");
            if (a5 == null)
            {
                flag = false;
            } else
            {
                a4.a = a5.("daily_play_cap");
                a4.b = a5.("custom_play_cap");
                a4.c = a5.("custom_play_cap_period");
                a4.d = a5.("total_play_cap");
                a4.e = a5.("monthly_play_cap");
                a4.f = a5.("weekly_play_cap");
                a4.g = a5.("volatile_expiration");
                a4.h = a5.("volatile_play_cap");
                flag = true;
            }
            if (!flag)
            {
                flag = false;
            } else
            {
                a2.p = new ();
                  = a2.p;
                 6 = a3.("third_party_tracking");
                if (6 == null)
                {
                    flag = false;
                } else
                {
                    .a = 6.("replay");
                    .b = 6.("card_shown");
                    .c = 6.("html5_interaction");
                    .d = 6.("cancel");
                    .e = 6.("download");
                    .f = 6.("skip");
                    .g = 6.("info");
                    .h = 6.("midpoint");
                    .i = 6.("card_dissolved");
                    .j = 6.("start");
                    .k = 6.("third_quartile");
                    .l = 6.("complete");
                    .m = 6.("continue");
                    .n = 6.("in_video_engagement");
                    .o = 6.("reward_v4vc");
                    .p = 6.("first_quartile");
                    .q = 6.("v4iap");
                    .r = 6.("video_expanded");
                    .s = 6.("sound_mute");
                    .t = 6.("sound_unmute");
                    .u = 6.("video_paused");
                    .v = 6.("video_resumed");
                    .w = 6.("native_start");
                    .x = 6.("native_first_quartile");
                    .y = 6.("native_midpoint");
                    .z = 6.("native_third_quartile");
                    .A = 6.("native_complete");
                    .B = 6.("native_overlay_click");
                    .C.put("replay", .a);
                    .C.put("card_shown", .b);
                    .C.put("html5_interaction", .c);
                    .C.put("cancel", .d);
                    .C.put("download", .e);
                    .C.put("skip", .f);
                    .C.put("info", .g);
                    .C.put("midpoint", .h);
                    .C.put("card_dissolved", .i);
                    .C.put("start", .j);
                    .C.put("third_quartile", .k);
                    .C.put("complete", .l);
                    .C.put("continue", .m);
                    .C.put("in_video_engagement", .n);
                    .C.put("reward_v4vc", .o);
                    .C.put("first_quartile", .p);
                    .C.put("v4iap", .q);
                    .C.put("video_expanded", .r);
                    .C.put("sound_mute", .s);
                    .C.put("sound_unmute", .t);
                    .C.put("video_paused", .u);
                    .C.put("video_resumed", .v);
                    .C.put("native_start", .w);
                    .C.put("native_first_quartile", .x);
                    .C.put("native_midpoint", .y);
                    .C.put("native_third_quartile", .z);
                    .C.put("native_complete", .A);
                    .C.put("native_overlay_click", .B);
                    flag = true;
                }
                if (!flag)
                {
                    flag = false;
                } else
                {
                    a2.q = new <init>();
                     1 = a2.q;
                     7 = a3.("in_app_browser");
                    if (7 == null)
                    {
                        flag = false;
                    } else
                    {
                        1.a = 7.("tiny_glow_image", "");
                        1.b = 7.("tiny_glow_image_last_modified;", "");
                        1.c = 7.("background_bar_image", "");
                        1.d = 7.("background_bar_image_last_modified", "");
                        1.e = 7.("background_tile_image", "");
                        1.f = 7.("background_tile_image_last_modified", "");
                        1.g = 7.("background_color", "");
                        1.h = new <init>();
                        if (!1.h.a(7.("logo")))
                        {
                            flag = false;
                        } else
                        {
                            1.h = new <init>();
                            if (!1.h.a(7.("logo")))
                            {
                                flag = false;
                            } else
                            {
                                1.i = new <init>();
                                if (!1.i.a(7.("stop")))
                                {
                                    flag = false;
                                } else
                                {
                                    1.j = new <init>();
                                    if (!1.j.a(7.("back")))
                                    {
                                        flag = false;
                                    } else
                                    {
                                        1.k = new <init>();
                                        if (!1.k.a(7.("close")))
                                        {
                                            flag = false;
                                        } else
                                        {
                                            1.l = new <init>();
                                            if (!1.l.a(7.("forward")))
                                            {
                                                flag = false;
                                            } else
                                            {
                                                1.m = new <init>();
                                                if (!1.m.a(7.("reload")))
                                                {
                                                    flag = false;
                                                } else
                                                {
                                                    flag = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!flag)
                    {
                        flag = false;
                    } else
                    {
label0:
                        {
                            a2.v = new <init>();
                            Object obj1 = a2.v;
                             2 = a3.("native");
                            if (2 == null)
                            {
                                flag = false;
                            } else
                            {
                                obj1.a = 2.("enabled", false);
                                obj1.c = 2.("poster_image", "");
                                obj1.d = 2.("advertiser_name", "");
                                obj1.e = 2.("description", "");
                                obj1.f = 2.("title", "");
                                obj1.g = 2.("thumb_image", "");
                                obj1.h = 2.("poster_image_last_modified", "");
                                obj1.i = 2.("thumb_image_last_modified", "");
                                obj1.k = new <init>();
                                if (!((<init>) (obj1)).k.a(2.("mute")))
                                {
                                    flag = false;
                                } else
                                {
                                    obj1.b = ((b) (obj1)).k.f;
                                    obj1.l = new <init>();
                                    if (!((<init>) (obj1)).l.a(2.("unmute")))
                                    {
                                        flag = false;
                                    } else
                                    {
                                        obj1.j = new <init>();
                                        obj1 = ((<init>) (obj1)).j;
                                        2 = 2.("overlay");
                                        if (2 == null)
                                        {
                                            flag = false;
                                        } else
                                        {
                                            obj1.a = 2.("enabled", false);
                                            if (!(() (obj1)).a)
                                            {
                                                flag = true;
                                            } else
                                            {
                                                obj1.b = 2.("in_app", false);
                                                obj1.c = 2.("click_action_type", "");
                                                obj1.e = 2.("click_action", "");
                                                obj1.d = 2.("label", "");
                                                flag = true;
                                            }
                                        }
                                        if (!flag)
                                        {
                                            flag = false;
                                        } else
                                        {
                                            flag = true;
                                        }
                                    }
                                }
                            }
                            if (flag)
                            {
                                break label0;
                            }
                            flag = false;
                        }
                    }
                }
            }
        }
_L4:
        if (!flag) goto _L1; else goto _L3
_L3:
        a.add(a2);
        j++;
          goto _L2
        a2.r = new <init>();
        Object obj2 = a2.r;
         3 = a3.("v4vc");
        if (3 == null)
        {
            flag = false;
        } else
        {
            obj2.a = 3.("enabled", false);
            if (!(() (obj2)).a)
            {
                break MISSING_BLOCK_LABEL_2902;
            }
            obj2.b = new <init>();
            Object obj4 = ((<init>) (obj2)).b;
             9 = 3.("pre_popup");
            obj4.a = 9.("background_image", "");
            obj4.b = 9.("background_image_last_modified", "");
            obj4.c = new <init>();
            if (!((<init>) (obj4)).c.a(9.("background_logo")))
            {
                flag = false;
            } else
            {
                obj4.d = new <init>();
                obj4 = ((<init>) (obj4)).d;
                9 = 9.("dialog");
                obj4.a = 9.("scale");
                obj4.b = 9.("label_reward", "");
                obj4.c = 9.("width");
                obj4.d = 9.("height");
                obj4.e = 9.("image", "");
                obj4.f = 9.("image_last_modified", "");
                obj4.g = 9.("label", "");
                obj4.h = 9.("label_rgba", "");
                obj4.i = 9.("label_shadow_rgba", "");
                obj4.j = 9.("label_fraction", "");
                obj4.k = 9.("label_html", "");
                obj4.l = new <init>();
                if (!((<init>) (obj4)).l.a(9.("logo")))
                {
                    flag = false;
                } else
                {
                    obj4.m = new <init>();
                    if (!((<init>) (obj4)).m.a(9.("option_yes")))
                    {
                        flag = false;
                    } else
                    {
                        obj4.n = new <init>();
                        if (!((<init>) (obj4)).n.a(9.("option_no")))
                        {
                            flag = false;
                        } else
                        {
                            flag = true;
                        }
                    }
                }
                if (!flag)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
            }
            if (!flag)
            {
                flag = false;
            } else
            {
                obj2.c = new <init>();
                obj2 = ((<init>) (obj2)).c;
                3 = 3.("post_popup");
                obj2.a = 3.("background_image", "");
                obj2.b = 3.("background_image_last_modified", "");
                obj2.c = new <init>();
                if (!((<init>) (obj2)).c.a(3.("background_logo")))
                {
                    flag = false;
                } else
                {
                    obj2.d = new <init>();
                    obj2 = ((<init>) (obj2)).d;
                    3 = 3.("dialog");
                    obj2.a = 3.("scale");
                    obj2.b = 3.("label_reward", "");
                    obj2.c = 3.("width");
                    obj2.d = 3.("height");
                    obj2.e = 3.("image", "");
                    obj2.f = 3.("image_last_modified", "");
                    obj2.g = 3.("label", "");
                    obj2.h = 3.("label_rgba", "");
                    obj2.i = 3.("label_shadow_rgba", "");
                    obj2.j = 3.("label_fraction", "");
                    obj2.k = 3.("label_html", "");
                    obj2.l = new <init>();
                    if (!((<init>) (obj2)).l.a(3.("logo")))
                    {
                        flag = false;
                    } else
                    {
                        obj2.m = new <init>();
                        if (!((<init>) (obj2)).m.a(3.("option_done")))
                        {
                            flag = false;
                        } else
                        {
                            flag = true;
                        }
                    }
                    if (!flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                }
                if (flag)
                {
                    break MISSING_BLOCK_LABEL_2902;
                }
                flag = false;
            }
        }
_L5:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_2908;
        }
        flag = false;
          goto _L4
        flag = true;
          goto _L5
        Object obj;
        Object obj3;
        a2.s = new <init>();
        obj = a2.s;
        obj3 = a3.("ad_tracking");
        if (obj3 != null)
        {
            obj.a = ((a) (obj3)).("replay", null);
            obj.b = ((b) (obj3)).("card_shown", null);
            obj.c = ((c) (obj3)).("html5_interaction", null);
            obj.d = ((d) (obj3)).("cancel", null);
            obj.e = ((e) (obj3)).("download", null);
            obj.f = ((f) (obj3)).("skip", null);
            obj.g = ((g) (obj3)).("info", null);
            obj.h = ((h) (obj3)).("custom_event", null);
            obj.i = ((i) (obj3)).("midpoint", null);
            obj.j = ((j) (obj3)).("card_dissolved", null);
            obj.k = ((k) (obj3)).("start", null);
            obj.l = ((l) (obj3)).("third_quartile", null);
            obj.m = ((m) (obj3)).("complete", null);
            obj.n = ((n) (obj3)).("continue", null);
            obj.o = ((o) (obj3)).("in_video_engagement", null);
            obj.p = ((p) (obj3)).("reward_v4vc", null);
            obj.r = ((r) (obj3)).("first_quartile", null);
            obj.q = ((q) (obj3)).("v4iap", null);
            obj.s = ((s) (obj3)).("video_expanded", null);
            obj.t = ((t) (obj3)).("sound_mute", null);
            obj.u = ((u) (obj3)).("sound_unmute", null);
            obj.v = ((v) (obj3)).("video_paused", null);
            obj.w = ((w) (obj3)).("video_resumed", null);
            obj.x = ((x) (obj3)).("native_start", null);
            obj.y = ((y) (obj3)).("native_first_quartile", null);
            obj.z = ((z) (obj3)).("native_midpoint", null);
            obj.A = ((A) (obj3)).("native_third_quartile", null);
            obj.B = ((B) (obj3)).("native_complete", null);
            obj.C = ((C) (obj3)).("native_overlay_click", null);
            (() (obj)).D.("replay", (() (obj)).a);
            ((a) (obj)).D.("card_shown", (() (obj)).b);
            ((b) (obj)).D.("html5_interaction", (() (obj)).c);
            ((c) (obj)).D.("cancel", (() (obj)).d);
            ((d) (obj)).D.("download", (() (obj)).e);
            ((e) (obj)).D.("skip", (() (obj)).f);
            ((f) (obj)).D.("info", (() (obj)).g);
            ((g) (obj)).D.("custom_event", (() (obj)).h);
            ((h) (obj)).D.("midpoint", (() (obj)).i);
            ((i) (obj)).D.("card_dissolved", (() (obj)).j);
            ((j) (obj)).D.("start", (() (obj)).k);
            ((k) (obj)).D.("third_quartile", (() (obj)).l);
            ((l) (obj)).D.("complete", (() (obj)).m);
            ((m) (obj)).D.("continue", (() (obj)).n);
            ((n) (obj)).D.("in_video_engagement", (() (obj)).o);
            ((o) (obj)).D.("reward_v4vc", (() (obj)).p);
            ((p) (obj)).D.("first_quartile", (() (obj)).r);
            ((r) (obj)).D.("v4iap", (() (obj)).q);
            ((q) (obj)).D.("video_expanded", (() (obj)).s);
            ((s) (obj)).D.("sound_mute", (() (obj)).t);
            ((t) (obj)).D.("sound_unmute", (() (obj)).u);
            ((u) (obj)).D.("video_paused", (() (obj)).v);
            ((v) (obj)).D.("video_resumed", (() (obj)).w);
            ((w) (obj)).D.("native_start", (() (obj)).x);
            ((x) (obj)).D.("native_first_quartile", (() (obj)).y);
            ((y) (obj)).D.("native_midpoint", (() (obj)).z);
            ((z) (obj)).D.("native_third_quartile", (() (obj)).A);
            ((A) (obj)).D.("native_complete", (() (obj)).B);
            ((B) (obj)).D.("native_overlay_click", (() (obj)).C);
        }
        a2.t = new <init>();
        obj3 = a2.t;
        obj = a3.("companion_ad");
        if (obj != null) goto _L7; else goto _L6
_L6:
        flag = false;
_L8:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_4573;
        }
        flag = false;
          goto _L4
_L7:
        obj3.d = ((d) (obj)).("enabled", false);
        if (!(() (obj3)).d)
        {
            break MISSING_BLOCK_LABEL_4567;
        }
        obj3.a = ((a) (obj)).("uuid", "");
        obj3.b = ((b) (obj)).("ad_id");
        obj3.c = ((c) (obj)).("ad_campaign_id");
        obj3.e = ((e) (obj)).("dissolve", false);
        obj3.f = ((f) (obj)).("enable_in_app_store", false);
        obj3.g = ((g) (obj)).("dissolve_delay");
        obj3.h = new ();
         10 = (() (obj3)).h;
         13 = ((h) (obj)).("static");
        if (13 == null)
        {
            flag = false;
        } else
        {
label1:
            {
                10.a = 13.("enabled", false);
                if (!10.a)
                {
                    break label1;
                }
                10.b = 13.("width");
                10.c = 13.("height");
                10.d = 13.("background_image", "");
                10.e = 13.("background_image_last_modified", "");
                if (q.b != null)
                {
                    10.d = q.b;
                }
                10.h = new <init>();
                if (!10.h.a(13.("replay")))
                {
                    flag = false;
                } else
                {
                    10.i = new <init>();
                    if (!10.i.a(13.("continue")))
                    {
                        flag = false;
                    } else
                    {
                        10.g = new <init>();
                        if (!10.g.a(13.("download")))
                        {
                            flag = false;
                        } else
                        {
                            10.f = new <init>();
                            if (10.f.a(13.("info")))
                            {
                                break label1;
                            }
                            flag = false;
                        }
                    }
                }
            }
        }
_L9:
        if (!flag)
        {
            flag = false;
        } else
        {
            obj3.i = new <init>();
            obj3 = ((<init>) (obj3)).i;
            obj = ((i) (obj)).("html5");
            if (obj == null)
            {
                flag = false;
            } else
            {
                obj3.a = ((a) (obj)).("enabled", false);
                obj3.b = ((b) (obj)).("load_timeout");
                obj3.c = ((c) (obj)).("load_timeout_enabled", false);
                obj3.d = ((d) (obj)).("load_spinner_enabled", false);
                obj3.e = ((e) (obj)).("background_color", "");
                obj3.g = ((g) (obj)).("html5_tag", "");
                obj3.f = new <init>();
                 11 = ((<init>) (obj3)).f;
                 14 = ((f) (obj)).("mraid_js");
                if (14 == null)
                {
                    flag = false;
                } else
                {
                    11.a = 14.("enabled", false);
                    if (!11.a)
                    {
                        flag = true;
                    } else
                    {
                        11.b = 14.("url", "");
                        11.c = 14.("last_modified", "");
                        flag = true;
                    }
                }
                if (!flag)
                {
                    flag = false;
                } else
                {
                    obj3.h = new <init>();
                    if (!((<init>) (obj3)).h.a(((a) (obj)).("background_logo")))
                    {
                        flag = false;
                    } else
                    {
                        obj3.i = new <init>();
                        if (!((<init>) (obj3)).i.a(((a) (obj)).("replay")))
                        {
                            flag = false;
                        } else
                        {
                            obj3.j = new <init>();
                            if (!((<init>) (obj3)).j.a(((a) (obj)).("close")))
                            {
                                flag = false;
                            } else
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
            if (flag)
            {
                break MISSING_BLOCK_LABEL_4567;
            }
            flag = false;
        }
          goto _L8
        flag = true;
          goto _L9
        flag = true;
          goto _L8
        a2.u = new <init>();
         4 = a2.u;
         8 = a3.("video");
        if (8 == null)
        {
            flag = false;
        } else
        {
label2:
            {
                4.a = 8.("enabled", false);
                if (!4.a)
                {
                    break label2;
                }
                4.b = 8.("width");
                4.c = 8.("height");
                4.d = 8.("url", "");
                4.e = 8.("last_modified", "");
                4.f = 8.("video_frame_rate", "");
                4.g = 8.("audio_channels", "");
                4.h = 8.("audio_codec", "");
                4.i = 8.("audio_sample_rate", "");
                4.j = 8.("video_codec", "");
                4.k = 8.("duration");
                4.l = new <init>();
                if (!4.l.a(8.("skip_video")))
                {
                    flag = false;
                } else
                {
                    4.m = new <init>();
                    if (!4.m.a(8.("in_video_engagement")))
                    {
                        flag = false;
                    } else
                    {
                        4.o = new <init>();
                         12 = 4.o;
                         15 = 8.("haptic");
                        if (15 == null)
                        {
                            flag = false;
                        } else
                        {
                            12.a = 15.("enabled", false);
                            12.b = 15.("file_url", "");
                            12.c = 15.("last_modified", "");
                            flag = true;
                        }
                        if (!flag)
                        {
                            flag = false;
                        } else
                        {
                            4.n = new <init>();
                            if (4.n.a(8.("in_video_engagement").("image_overlay")))
                            {
                                break label2;
                            }
                            flag = false;
                        }
                    }
                }
            }
        }
_L10:
        if (!flag)
        {
            flag = false;
        } else
        {
            a2.w = new ();
             5 = a2.w;
            a3 = a3.("v4iap");
            if (a3 == null)
            {
                flag = false;
            } else
            {
                5.c = a3.("enabled", false);
                if (!5.c)
                {
                    flag = true;
                } else
                {
                    5.a = (String)a3.("product_ids").get(0);
                    5.b = a3.("in_progress", "");
                    flag = true;
                }
            }
            if (!flag)
            {
                flag = false;
            } else
            {
                flag = true;
            }
        }
          goto _L4
        flag = true;
          goto _L10
        return true;
          goto _L2
    }

    ()
    {
        a = new ArrayList();
    }
}
