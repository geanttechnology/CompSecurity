.class public Lcom/livemixtapes/App;
.super Landroid/app/Application;
.source "App.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/App$OnLayoutMeasureListener;,
        Lcom/livemixtapes/App$ScalableStateListDrawable;
    }
.end annotation


# static fields
.field public static final AREA:I

.field public static final AREA_INCHES:F

.field public static final AREA_RATIO:F

.field public static DefaultTape:Ljava/lang/String; = null

.field public static final HEIGHT:I

.field public static final HEIGHT_INCHES:F

.field public static final HEIGHT_RATIO:F

.field public static final STANDARD_AREA:I = 0xd0200

.field public static final STANDARD_AREA_INCHES:F = 7.948737f

.field public static final STANDARD_DPI:F = 320.0f

.field public static final STANDARD_HEIGHT:I = 0x4a0

.field public static final STANDARD_HEIGHT_INCHES:F = 3.6053154f

.field public static final STANDARD_WIDTH:I = 0x2d0

.field public static final STANDARD_WIDTH_INCHES:F = 2.2047272f

.field public static final STANDARD_XDPI:F = 326.571f

.field public static final STANDARD_YDPI:F = 328.404f

.field public static final WIDTH:I

.field public static final WIDTH_INCHES:F

.field public static final WIDTH_RATIO:F

.field public static context:Landroid/content/Context;

.field public static defaultBackground:I

.field public static didLoad:Ljava/lang/Boolean;

.field public static isUnzipping:Z

.field public static lastUpdateAll:J

.field public static lastUpdateToday:J

.field public static lastUpdateUnreleased:J

.field public static lastUpdateWeek:J

.field public static final metrics:Landroid/util/DisplayMetrics;

.field public static top_allCount:J

.field public static top_dayCount:J

.field public static top_unreleasedCount:J

.field public static top_weekCount:J

.field public static viewStyle:Ljava/lang/String;


# instance fields
.field public currentActivity:Lcom/livemixtapes/ui/BaseActivity;

.field private mTracker:Lcom/google/android/gms/analytics/Tracker;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v2, 0x0

    const-wide/16 v0, 0x0

    .line 67
    sput-wide v0, Lcom/livemixtapes/App;->lastUpdateAll:J

    .line 68
    sput-wide v0, Lcom/livemixtapes/App;->lastUpdateToday:J

    .line 69
    sput-wide v0, Lcom/livemixtapes/App;->lastUpdateWeek:J

    .line 70
    sput-wide v0, Lcom/livemixtapes/App;->lastUpdateUnreleased:J

    .line 72
    sput-wide v0, Lcom/livemixtapes/App;->top_weekCount:J

    .line 73
    sput-wide v0, Lcom/livemixtapes/App;->top_dayCount:J

    .line 74
    sput-wide v0, Lcom/livemixtapes/App;->top_unreleasedCount:J

    .line 75
    sput-wide v0, Lcom/livemixtapes/App;->top_allCount:J

    .line 77
    const-string v0, "grid"

    sput-object v0, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    .line 79
    sput-boolean v2, Lcom/livemixtapes/App;->isUnzipping:Z

    .line 88
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    .line 90
    const-string v0, "{\"mixtape\":{\"id\":\"1\",\"site\":\"main\",\"state\":\"live\",\"date\":\"1970-01-01T04:00:00Z\",\"releasedate\":\"1970-01-01T00:00:00Z\",\"releaseseconds\":0,\"featured\":\"0\",\"title\":\"The Title Stays In Harlem\",\"artist\":\"\",\"DJ\":\"Diplomat Records\",\"score\":\"133\",\"votes\":\"167\",\"views\":\"80240\",\"sharetext\":\"[Mixtape] The Title Stays In Harlem :: #GetItLIVE! http://livemixtap.es/1 @LiveMixtapes\",\"sharecover\":true,\"url\":\"http://www.livemixtapes.com//mixtapes/1/_the_title_stays_in_.html\",\"cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"thumbnail\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"tracks\":[{\"track_id\":\"9\",\"track_number\":\"1\",\"track_title\":\"Intro\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"154\",\"track_duration\":\"154\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/9/jim_jones_intro.html\",\"track_sharetext\":\"[Audio] Jim Jones - Intro http://www.livemixtapes.com/download/mp3/9/jim_jones_intro.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - Intro | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/01%20Intro.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/9\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"8\",\"track_number\":\"2\",\"track_title\":\"Get Em Daddy Remix\",\"track_artist\":\"Cam\'ron\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"275\",\"track_duration\":\"275\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/8/camron_get_em_daddy.html\",\"track_sharetext\":\"[Audio] Cam\'ron - Get Em Daddy Remix http://www.livemixtapes.com/download/mp3/8/camron_get_em_daddy.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam\'ron - Get Em Daddy Remix | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/02%20Get%20Em%20Daddy%20Remix.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/8\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"19\",\"track_number\":\"3\",\"track_title\":\"It\'s Nothing\",\"track_artist\":\"Cam\'ron Featuring Juelz Santana\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"246\",\"track_duration\":\"246\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/19/camron_featuring_ju.html\",\"track_sharetext\":\"[Audio] Cam\'ron Featuring Juelz Santana - It\'s Nothing http://www.livemixtapes.com/download/mp3/19/camron_featuring_ju.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam\'ron Featuring Juelz Santana - It\'s Nothing | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/03%20It\'s%20Nothing%20Featuring%20Juelz%20Sant.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/19\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"17\",\"track_number\":\"4\",\"track_title\":\"Love My Life\",\"track_artist\":\"Cam\'ron Featuring Nicole Wray\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"239\",\"track_duration\":\"239\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/17/camron_featuring_ni.html\",\"track_sharetext\":\"[Audio] Cam\'ron Featuring Nicole Wray - Love My Life http://www.livemixtapes.com/download/mp3/17/camron_featuring_ni.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam\'ron Featuring Nicole Wray - Love My Life | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/04%20Love%20My%20Life%20Featuring%20Nicole%20Wra.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/17\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"20\",\"track_number\":\"5\",\"track_title\":\"Freestyle\",\"track_artist\":\"Hell Rell\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"117\",\"track_duration\":\"117\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/20/hell_rell_freestyle.html\",\"track_sharetext\":\"[Audio] Hell Rell - Freestyle http://www.livemixtapes.com/download/mp3/20/hell_rell_freestyle.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Hell Rell - Freestyle | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/05%20Freestyle.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/20\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"4\",\"track_number\":\"6\",\"track_title\":\"Big Song\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"252\",\"track_duration\":\"252\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/4/jim_jones_big_song.html\",\"track_sharetext\":\"[Audio] Jim Jones - Big Song http://www.livemixtapes.com/download/mp3/4/jim_jones_big_song.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - Big Song | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/06%20Big%20Song.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/4\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"18\",\"track_number\":\"7\",\"track_title\":\"Murder Murder\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"90\",\"track_duration\":\"90\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/18/jim_jones_murder_mur.html\",\"track_sharetext\":\"[Audio] Jim Jones - Murder Murder http://www.livemixtapes.com/download/mp3/18/jim_jones_murder_mur.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - Murder Murder | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/07%20Murder%20Murder.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/18\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"7\",\"track_number\":\"8\",\"track_title\":\"What You Want To Talk About\",\"track_artist\":\"40 Cal Featuring A-Mafia\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"257\",\"track_duration\":\"257\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/7/40_cal_featuring_am.html\",\"track_sharetext\":\"[Audio] 40 Cal Featuring A-Mafia - What You Want To Talk About http://www.livemixtapes.com/download/mp3/7/40_cal_featuring_am.html | @LiveMixtapes\",\"track_radio_sharetext\":\"40 Cal Featuring A-Mafia - What You Want To Talk About | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/08%20What%20You%20Want%20To%20Talk%20About%20Featu.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/7\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"2\",\"track_number\":\"9\",\"track_title\":\"Pushin\'\",\"track_artist\":\"J.R Writer & 40 Cal.\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"186\",\"track_duration\":\"186\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/2/jr_writer_40_cal.html\",\"track_sharetext\":\"[Audio] J.R Writer & 40 Cal. - Pushin\' http://www.livemixtapes.com/download/mp3/2/jr_writer_40_cal.html | @LiveMixtapes\",\"track_radio_sharetext\":\"J.R Writer & 40 Cal. - Pushin\' | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/09%20J.R%20Writer%20&%2040%20Cal.%20-%20Pushin\'.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/2\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"14\",\"track_number\":\"10\",\"track_title\":\"Best Of Both Hoods\",\"track_artist\":\"Juelz Santana Featuring Young Jeezy\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"205\",\"track_duration\":\"205\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/14/juelz_santana_featur.html\",\"track_sharetext\":\"[Audio] Juelz Santana Featuring Young Jeezy - Best Of Both Hoods http://www.livemixtapes.com/download/mp3/14/juelz_santana_featur.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Juelz Santana Featuring Young Jeezy - Best Of Both Hoods | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/10%20Best%20Of%20Both%20Hoods%20Featuring%20Youn.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/14\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"22\",\"track_number\":\"11\",\"track_title\":\"Mesmerized\",\"track_artist\":\"JR Writer Featuring CL Smooth\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"192\",\"track_duration\":\"192\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/22/jr_writer_featuring_.html\",\"track_sharetext\":\"[Audio] JR Writer Featuring CL Smooth - Mesmerized http://www.livemixtapes.com/download/mp3/22/jr_writer_featuring_.html | @LiveMixtapes\",\"track_radio_sharetext\":\"JR Writer Featuring CL Smooth - Mesmerized | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/11%20JR%20Writer%20Featuring%20CL%20Smooth%20-%20M.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/22\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"6\",\"track_number\":\"12\",\"track_title\":\"From Bottom To Top\",\"track_artist\":\"Juelz Santana\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"218\",\"track_duration\":\"218\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/6/juelz_santana_from_b.html\",\"track_sharetext\":\"[Audio] Juelz Santana - From Bottom To Top http://www.livemixtapes.com/download/mp3/6/juelz_santana_from_b.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Juelz Santana - From Bottom To Top | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/12%20From%20Bottom%20To%20Top.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/6\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"12\",\"track_number\":\"13\",\"track_title\":\"Mariah Remix\",\"track_artist\":\"Cam\'ron Featuring Juelz & Mariah Carey\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"163\",\"track_duration\":\"163\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/12/camron_featuring_ju.html\",\"track_sharetext\":\"[Audio] Cam\'ron Featuring Juelz & Mariah Carey - Mariah Remix http://www.livemixtapes.com/download/mp3/12/camron_featuring_ju.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam\'ron Featuring Juelz & Mariah Carey - Mariah Remix | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/13%20Mariah%20Remix%20Featuring%20Juelz%20&%20Ma.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/12\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"15\",\"track_number\":\"14\",\"track_title\":\"I Aint Wit It\",\"track_artist\":\"Jha Jha Featuring Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"178\",\"track_duration\":\"178\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/15/jha_jha_featuring_ji.html\",\"track_sharetext\":\"[Audio] Jha Jha Featuring Jim Jones - I Aint Wit It http://www.livemixtapes.com/download/mp3/15/jha_jha_featuring_ji.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jha Jha Featuring Jim Jones - I Aint Wit It | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/14%20I%20Aint%20Wit%20It%20Featuring%20Jim%20Jones.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/15\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"21\",\"track_number\":\"15\",\"track_title\":\"Dipset The Realist\",\"track_artist\":\"Hell Rell\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"200\",\"track_duration\":\"200\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/21/hell_rell_dipset_the.html\",\"track_sharetext\":\"[Audio] Hell Rell - Dipset The Realist http://www.livemixtapes.com/download/mp3/21/hell_rell_dipset_the.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Hell Rell - Dipset The Realist | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/15%20Dipset%20The%20Realist.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/21\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"16\",\"track_number\":\"16\",\"track_title\":\"Go Go Go\",\"track_artist\":\"40 Cal Featuring Bezell & Peedi Crack\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"188\",\"track_duration\":\"188\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/16/40_cal_featuring_bez.html\",\"track_sharetext\":\"[Audio] 40 Cal Featuring Bezell & Peedi Crack - Go Go Go http://www.livemixtapes.com/download/mp3/16/40_cal_featuring_bez.html | @LiveMixtapes\",\"track_radio_sharetext\":\"40 Cal Featuring Bezell & Peedi Crack - Go Go Go | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/16%20Go%20Go%20Go%20Featuring%20Bezell%20&%20Peedi.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/16\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"5\",\"track_number\":\"17\",\"track_title\":\"Line Of Fire\",\"track_artist\":\"Hell Rell Featuring J.R. Writer\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"279\",\"track_duration\":\"279\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/5/hell_rell_featuring_.html\",\"track_sharetext\":\"[Audio] Hell Rell Featuring J.R. Writer - Line Of Fire http://www.livemixtapes.com/download/mp3/5/hell_rell_featuring_.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Hell Rell Featuring J.R. Writer - Line Of Fire | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/17%20Line%20Of%20Fire%20Featuring%20J.R.%20Write.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/5\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"13\",\"track_number\":\"18\",\"track_title\":\"3 Pots On A Stove\",\"track_artist\":\"Chubby Baby Featuring Hell Rell & J.R. Writer\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"252\",\"track_duration\":\"252\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/13/chubby_baby_featurin.html\",\"track_sharetext\":\"[Audio] Chubby Baby Featuring Hell Rell & J.R. Writer - 3 Pots On A Stove http://www.livemixtapes.com/download/mp3/13/chubby_baby_featurin.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Chubby Baby Featuring Hell Rell & J.R. Writer - 3 Pots On A Stove | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/18%203%20Pots%20On%20A%20Stove%20Featuring%20Hell.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/13\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"1\",\"track_number\":\"19\",\"track_title\":\"G\'s Up Remix\",\"track_artist\":\"Jim Jones\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"277\",\"track_duration\":\"277\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/1/jim_jones_gs_up_rem.html\",\"track_sharetext\":\"[Audio] Jim Jones - G\'s Up Remix http://www.livemixtapes.com/download/mp3/1/jim_jones_gs_up_rem.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Jim Jones - G\'s Up Remix | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/19%20G\'s%20Up%20Remix.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/1\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"23\",\"track_number\":\"20\",\"track_title\":\"Freestyle\",\"track_artist\":\"40 Cal\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"117\",\"track_duration\":\"117\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/23/40_cal_freestyle.html\",\"track_sharetext\":\"[Audio] 40 Cal - Freestyle http://www.livemixtapes.com/download/mp3/23/40_cal_freestyle.html | @LiveMixtapes\",\"track_radio_sharetext\":\"40 Cal - Freestyle | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/20%20Freestyle.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/23\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"3\",\"track_number\":\"21\",\"track_title\":\"Do Your Thing\",\"track_artist\":\"Cam\'ron\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"213\",\"track_duration\":\"213\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/3/camron_do_your_thin.html\",\"track_sharetext\":\"[Audio] Cam\'ron - Do Your Thing http://www.livemixtapes.com/download/mp3/3/camron_do_your_thin.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Cam\'ron - Do Your Thing | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/21%20Do%20Your%20Thing.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/3\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"11\",\"track_number\":\"22\",\"track_title\":\"How To Make A Girl Feel\",\"track_artist\":\"Juelz Santana Featuring Tierra Marie\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"100\",\"track_duration\":\"100\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/11/juelz_santana_featur.html\",\"track_sharetext\":\"[Audio] Juelz Santana Featuring Tierra Marie - How To Make A Girl Feel http://www.livemixtapes.com/download/mp3/11/juelz_santana_featur.html | @LiveMixtapes\",\"track_radio_sharetext\":\"Juelz Santana Featuring Tierra Marie - How To Make A Girl Feel | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/22%20How%20To%20Make%20A%20Girl%20Feel%20Featuring.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/11\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"},{\"track_id\":\"10\",\"track_number\":\"23\",\"track_title\":\"Freestyle\",\"track_artist\":\"J.R. Writer\",\"track_album\":\"1\",\"track_mixtape_id\":\"1\",\"track_mixtape_cover\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/cover.jpg\",\"track_mixtape_thumb\":\"http://images.livemixtapes.com/artists/dukedagod/titlestaysharlem/tn_cover.jpg\",\"track_length\":\"191\",\"track_duration\":\"191\",\"track_shareurl\":\"http://www.livemixtapes.com/download/mp3/10/jr_writer_freestyl.html\",\"track_sharetext\":\"[Audio] J.R. Writer - Freestyle http://www.livemixtapes.com/download/mp3/10/jr_writer_freestyl.html | @LiveMixtapes\",\"track_radio_sharetext\":\"J.R. Writer - Freestyle | http://lmtradio.com/\",\"track_sharecover\":true,\"track_url\":\"http://cdn-streams.livemixtapes.com/dukedagod/titlestaysharlem/23%20JR%20Writer%20-%20Freestyle.mp4.m3u8\",\"download_url\":\"http://mobile.livemixtapes.com/download/10\",\"track_streamtype\":\"hls\",\"track_filesize\":\"0\"}]}}"

    sput-object v0, Lcom/livemixtapes/App;->DefaultTape:Ljava/lang/String;

    .line 93
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    .line 94
    sget-object v0, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    iget v0, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    sput v0, Lcom/livemixtapes/App;->WIDTH:I

    .line 95
    sget-object v0, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    sput v0, Lcom/livemixtapes/App;->HEIGHT:I

    .line 96
    sget v0, Lcom/livemixtapes/App;->WIDTH:I

    sget v1, Lcom/livemixtapes/App;->HEIGHT:I

    mul-int/2addr v0, v1

    sput v0, Lcom/livemixtapes/App;->AREA:I

    .line 98
    sget-object v0, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    iget v0, v0, Landroid/util/DisplayMetrics;->densityDpi:I

    int-to-float v6, v0

    .line 99
    .local v6, "densityDpi":F
    const v0, 0x3dcccccd    # 0.1f

    mul-float v9, v6, v0

    .line 100
    .local v9, "tolerance":F
    sub-float v8, v6, v9

    .line 101
    .local v8, "minDpi":F
    add-float v7, v6, v9

    .line 102
    .local v7, "maxDpi":F
    sget-object v0, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    iget v10, v0, Landroid/util/DisplayMetrics;->xdpi:F

    .line 103
    .local v10, "xdpi":F
    sget-object v0, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    iget v11, v0, Landroid/util/DisplayMetrics;->ydpi:F

    .line 105
    .local v11, "ydpi":F
    float-to-double v0, v10

    float-to-double v2, v8

    float-to-double v4, v7

    invoke-static/range {v0 .. v5}, Lcom/livemixtapes/App;->inBounds(DDD)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    float-to-double v0, v11

    float-to-double v2, v8

    float-to-double v4, v7

    invoke-static/range {v0 .. v5}, Lcom/livemixtapes/App;->inBounds(DDD)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    .line 106
    :cond_0
    move v11, v6

    move v10, v6

    .line 109
    :cond_1
    sget v0, Lcom/livemixtapes/App;->WIDTH:I

    int-to-float v0, v0

    div-float/2addr v0, v10

    sput v0, Lcom/livemixtapes/App;->WIDTH_INCHES:F

    .line 110
    sget v0, Lcom/livemixtapes/App;->HEIGHT:I

    int-to-float v0, v0

    div-float/2addr v0, v11

    sput v0, Lcom/livemixtapes/App;->HEIGHT_INCHES:F

    .line 111
    sget v0, Lcom/livemixtapes/App;->WIDTH_INCHES:F

    sget v1, Lcom/livemixtapes/App;->HEIGHT_INCHES:F

    mul-float/2addr v0, v1

    sput v0, Lcom/livemixtapes/App;->AREA_INCHES:F

    .line 113
    sget v0, Lcom/livemixtapes/App;->WIDTH_INCHES:F

    const v1, 0x400d1a40

    div-float/2addr v0, v1

    sput v0, Lcom/livemixtapes/App;->WIDTH_RATIO:F

    .line 114
    sget v0, Lcom/livemixtapes/App;->HEIGHT_INCHES:F

    const v1, 0x4066bd7d

    div-float/2addr v0, v1

    sput v0, Lcom/livemixtapes/App;->HEIGHT_RATIO:F

    .line 115
    sget v0, Lcom/livemixtapes/App;->AREA_INCHES:F

    const v1, 0x40fe5c0e

    div-float/2addr v0, v1

    sput v0, Lcom/livemixtapes/App;->AREA_RATIO:F

    .line 116
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 86
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/App;->currentActivity:Lcom/livemixtapes/ui/BaseActivity;

    .line 40
    return-void
.end method

.method private static getName(Landroid/view/View;)Ljava/lang/String;
    .locals 3
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 200
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "anonymous("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 203
    .local v0, "name":Ljava/lang/String;
    :try_start_0
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {p0}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 208
    :goto_0
    return-object v0

    .line 204
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static inBounds(DDD)Ljava/lang/Boolean;
    .locals 1
    .param p0, "value"    # D
    .param p2, "min"    # D
    .param p4, "max"    # D

    .prologue
    .line 301
    cmpl-double v0, p0, p2

    if-ltz v0, :cond_0

    cmpg-double v0, p0, p4

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public static scaleView(Landroid/view/View;)V
    .locals 1
    .param p0, "view"    # Landroid/view/View;

    .prologue
    .line 162
    sget v0, Lcom/livemixtapes/App;->WIDTH_RATIO:F

    invoke-static {p0, v0}, Lcom/livemixtapes/App;->scaleView(Landroid/view/View;F)V

    .line 163
    return-void
.end method

.method public static scaleView(Landroid/view/View;F)V
    .locals 7
    .param p0, "view"    # Landroid/view/View;
    .param p1, "ratio"    # F

    .prologue
    .line 166
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 168
    .local v1, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v3, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    if-lez v3, :cond_0

    .line 169
    iget v3, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 172
    :cond_0
    iget v3, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-lez v3, :cond_1

    .line 173
    iget v3, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    iput v3, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 176
    :cond_1
    instance-of v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v3, :cond_2

    move-object v0, v1

    .line 177
    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 179
    .local v0, "marginParams":Landroid/view/ViewGroup$MarginLayoutParams;
    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    iput v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 180
    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    iput v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 181
    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    iput v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 182
    iget v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    iput v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 186
    .end local v0    # "marginParams":Landroid/view/ViewGroup$MarginLayoutParams;
    :cond_2
    invoke-virtual {p0}, Landroid/view/View;->getPaddingLeft()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    .line 187
    invoke-virtual {p0}, Landroid/view/View;->getPaddingTop()I

    move-result v4

    int-to-float v4, v4

    mul-float/2addr v4, p1

    float-to-int v4, v4

    .line 188
    invoke-virtual {p0}, Landroid/view/View;->getPaddingRight()I

    move-result v5

    int-to-float v5, v5

    mul-float/2addr v5, p1

    float-to-int v5, v5

    .line 189
    invoke-virtual {p0}, Landroid/view/View;->getPaddingBottom()I

    move-result v6

    int-to-float v6, v6

    mul-float/2addr v6, p1

    float-to-int v6, v6

    .line 185
    invoke-virtual {p0, v3, v4, v5, v6}, Landroid/view/View;->setPadding(IIII)V

    .line 192
    instance-of v3, p0, Landroid/widget/TextView;

    if-eqz v3, :cond_3

    move-object v2, p0

    .line 193
    check-cast v2, Landroid/widget/TextView;

    .line 194
    .local v2, "v":Landroid/widget/TextView;
    const/4 v3, 0x0

    invoke-virtual {v2}, Landroid/widget/TextView;->getTextSize()F

    move-result v4

    mul-float/2addr v4, p1

    invoke-virtual {v2, v3, v4}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 195
    invoke-virtual {v2}, Landroid/widget/TextView;->getCompoundDrawablePadding()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v3, p1

    float-to-int v3, v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setCompoundDrawablePadding(I)V

    .line 197
    .end local v2    # "v":Landroid/widget/TextView;
    :cond_3
    return-void
.end method

.method public static scaleViewGroup(Landroid/view/ViewGroup;)V
    .locals 4
    .param p0, "group"    # Landroid/view/ViewGroup;

    .prologue
    .line 144
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    .line 147
    .local v0, "count":I
    invoke-static {p0}, Lcom/livemixtapes/App;->scaleView(Landroid/view/View;)V

    .line 149
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v0, :cond_0

    .line 159
    return-void

    .line 150
    :cond_0
    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 152
    .local v2, "view":Landroid/view/View;
    instance-of v3, v2, Landroid/view/ViewGroup;

    if-eqz v3, :cond_1

    .line 153
    check-cast v2, Landroid/view/ViewGroup;

    .end local v2    # "view":Landroid/view/View;
    invoke-static {v2}, Lcom/livemixtapes/App;->scaleViewGroup(Landroid/view/ViewGroup;)V

    .line 149
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 156
    .restart local v2    # "view":Landroid/view/View;
    :cond_1
    invoke-virtual {p0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-static {v3}, Lcom/livemixtapes/App;->scaleView(Landroid/view/View;)V

    goto :goto_1
.end method

.method public static showNotification(Ljava/lang/String;Landroid/widget/ImageView;)V
    .locals 15
    .param p0, "title"    # Ljava/lang/String;
    .param p1, "cover"    # Landroid/widget/ImageView;

    .prologue
    .line 350
    new-instance v0, Landroid/widget/RemoteViews;

    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v12}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v12

    .line 351
    const v13, 0x7f03002c

    .line 350
    invoke-direct {v0, v12, v13}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 353
    .local v0, "bigView":Landroid/widget/RemoteViews;
    const v12, 0x7f0800d1

    invoke-virtual {v0, v12, p0}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 355
    invoke-virtual/range {p1 .. p1}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    check-cast v2, Landroid/graphics/drawable/BitmapDrawable;

    .line 356
    .local v2, "drawable":Landroid/graphics/drawable/BitmapDrawable;
    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 360
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    new-instance v7, Landroid/app/Notification$Builder;

    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-direct {v7, v12}, Landroid/app/Notification$Builder;-><init>(Landroid/content/Context;)V

    .line 363
    .local v7, "mNotifyBuilder":Landroid/app/Notification$Builder;
    const-string v12, "LiveMixTapes"

    invoke-virtual {v7, v12}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v12

    .line 364
    const-string v13, "Please swipe down for more options"

    invoke-virtual {v12, v13}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    move-result-object v12

    .line 365
    const v13, 0x7f02005b

    invoke-virtual {v12, v13}, Landroid/app/Notification$Builder;->setSmallIcon(I)Landroid/app/Notification$Builder;

    move-result-object v12

    .line 366
    const/4 v13, -0x2

    invoke-virtual {v12, v13}, Landroid/app/Notification$Builder;->setPriority(I)Landroid/app/Notification$Builder;

    move-result-object v12

    const/4 v13, 0x1

    invoke-virtual {v12, v13}, Landroid/app/Notification$Builder;->setOngoing(Z)Landroid/app/Notification$Builder;

    move-result-object v12

    .line 368
    invoke-virtual {v12, v0}, Landroid/app/Notification$Builder;->setContent(Landroid/widget/RemoteViews;)Landroid/app/Notification$Builder;

    move-result-object v12

    invoke-virtual {v12}, Landroid/app/Notification$Builder;->build()Landroid/app/Notification;

    move-result-object v3

    .line 372
    .local v3, "foregroundNote":Landroid/app/Notification;
    iput-object v0, v3, Landroid/app/Notification;->bigContentView:Landroid/widget/RemoteViews;

    .line 374
    new-instance v4, Landroid/content/Intent;

    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-class v13, Lcom/livemixtapes/CallbackActivity;

    invoke-direct {v4, v12, v13}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 375
    .local v4, "i1":Landroid/content/Intent;
    const-string v12, "which"

    const/4 v13, 0x1

    invoke-virtual {v4, v12, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 376
    const/4 v12, 0x1

    invoke-virtual {v4, v12}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v12

    invoke-virtual {v4, v12}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 378
    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const/4 v13, 0x0

    .line 379
    const/high16 v14, 0x8000000

    .line 378
    invoke-static {v12, v13, v4, v14}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v9

    .line 381
    .local v9, "pendingIntent1":Landroid/app/PendingIntent;
    new-instance v5, Landroid/content/Intent;

    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-class v13, Lcom/livemixtapes/CallbackActivity;

    invoke-direct {v5, v12, v13}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 382
    .local v5, "i2":Landroid/content/Intent;
    const-string v12, "which"

    const/4 v13, 0x2

    invoke-virtual {v5, v12, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 383
    const/4 v12, 0x1

    invoke-virtual {v5, v12}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v12

    invoke-virtual {v5, v12}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 384
    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const/4 v13, 0x0

    .line 385
    const/high16 v14, 0x8000000

    .line 384
    invoke-static {v12, v13, v5, v14}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v10

    .line 387
    .local v10, "pendingIntent2":Landroid/app/PendingIntent;
    new-instance v6, Landroid/content/Intent;

    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-class v13, Lcom/livemixtapes/CallbackActivity;

    invoke-direct {v6, v12, v13}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 388
    .local v6, "i3":Landroid/content/Intent;
    const-string v12, "which"

    const/4 v13, 0x3

    invoke-virtual {v6, v12, v13}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 389
    const/4 v12, 0x1

    invoke-virtual {v6, v12}, Landroid/content/Intent;->toUri(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v12

    invoke-virtual {v6, v12}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 390
    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const/4 v13, 0x0

    .line 391
    const/high16 v14, 0x8000000

    .line 390
    invoke-static {v12, v13, v6, v14}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v11

    .line 393
    .local v11, "pendingIntent3":Landroid/app/PendingIntent;
    const v12, 0x7f0800d3

    invoke-virtual {v0, v12, v9}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 394
    const v12, 0x7f0800d4

    invoke-virtual {v0, v12, v10}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 395
    const v12, 0x7f0800d2

    invoke-virtual {v0, v12, v11}, Landroid/widget/RemoteViews;->setOnClickPendingIntent(ILandroid/app/PendingIntent;)V

    .line 397
    sget-object v12, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v13, "notification"

    invoke-virtual {v12, v13}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/app/NotificationManager;

    .line 399
    .local v8, "mNotifyManager":Landroid/app/NotificationManager;
    return-void
.end method


# virtual methods
.method public dpToPx(F)F
    .locals 2
    .param p1, "value"    # F

    .prologue
    .line 268
    const/4 v0, 0x1

    sget-object v1, Lcom/livemixtapes/App;->metrics:Landroid/util/DisplayMetrics;

    invoke-static {v0, p1, v1}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    return v0
.end method

.method public declared-synchronized getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;
    .locals 2

    .prologue
    .line 402
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/livemixtapes/App;->mTracker:Lcom/google/android/gms/analytics/Tracker;

    if-nez v1, :cond_0

    .line 403
    invoke-static {p0}, Lcom/google/android/gms/analytics/GoogleAnalytics;->getInstance(Landroid/content/Context;)Lcom/google/android/gms/analytics/GoogleAnalytics;

    move-result-object v0

    .line 405
    .local v0, "analytics":Lcom/google/android/gms/analytics/GoogleAnalytics;
    const/high16 v1, 0x7f060000

    invoke-virtual {v0, v1}, Lcom/google/android/gms/analytics/GoogleAnalytics;->newTracker(I)Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/App;->mTracker:Lcom/google/android/gms/analytics/Tracker;

    .line 407
    .end local v0    # "analytics":Lcom/google/android/gms/analytics/GoogleAnalytics;
    :cond_0
    iget-object v1, p0, Lcom/livemixtapes/App;->mTracker:Lcom/google/android/gms/analytics/Tracker;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 402
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public onCreate()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 120
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 121
    invoke-static {p0}, Lorg/acra/ACRA;->init(Landroid/app/Application;)V

    .line 122
    invoke-virtual {p0}, Lcom/livemixtapes/App;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sput-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    .line 124
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    .line 125
    sget-object v2, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->theme:I

    .line 126
    const/4 v3, 0x1

    new-array v3, v3, [I

    const v4, 0x1010031

    aput v4, v3, v5

    .line 124
    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources$Theme;->obtainStyledAttributes(I[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 129
    .local v0, "array":Landroid/content/res/TypedArray;
    const v1, 0xff00ff

    invoke-virtual {v0, v5, v1}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    sput v1, Lcom/livemixtapes/App;->defaultBackground:I

    .line 131
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 141
    return-void
.end method

.method public setCornerRadii(Landroid/graphics/drawable/Drawable;FFFF)V
    .locals 2
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "topLeftRadius"    # F
    .param p3, "topRightRadius"    # F
    .param p4, "bottomRightRadius"    # F
    .param p5, "bottomLeftRadius"    # F

    .prologue
    .line 252
    invoke-virtual {p0, p2}, Lcom/livemixtapes/App;->dpToPx(F)F

    move-result p2

    .line 253
    invoke-virtual {p0, p3}, Lcom/livemixtapes/App;->dpToPx(F)F

    move-result p3

    .line 254
    invoke-virtual {p0, p4}, Lcom/livemixtapes/App;->dpToPx(F)F

    move-result p4

    .line 255
    invoke-virtual {p0, p5}, Lcom/livemixtapes/App;->dpToPx(F)F

    move-result p5

    .line 257
    check-cast p1, Landroid/graphics/drawable/GradientDrawable;

    .line 258
    .end local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    const/16 v0, 0x8

    new-array v0, v0, [F

    const/4 v1, 0x0

    .line 259
    aput p2, v0, v1

    const/4 v1, 0x1

    aput p2, v0, v1

    const/4 v1, 0x2

    .line 260
    aput p3, v0, v1

    const/4 v1, 0x3

    aput p3, v0, v1

    const/4 v1, 0x4

    .line 261
    aput p4, v0, v1

    const/4 v1, 0x5

    aput p4, v0, v1

    const/4 v1, 0x6

    .line 262
    aput p5, v0, v1

    const/4 v1, 0x7

    aput p5, v0, v1

    .line 257
    invoke-virtual {p1, v0}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadii([F)V

    .line 265
    return-void
.end method

.method public setCornerRadii(Landroid/view/View;FFFF)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "topLeftRadius"    # F
    .param p3, "topRightRadius"    # F
    .param p4, "bottomRightRadius"    # F
    .param p5, "bottomLeftRadius"    # F

    .prologue
    .line 245
    .line 246
    invoke-virtual {p1}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    move-object v0, p0

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    .line 245
    invoke-virtual/range {v0 .. v5}, Lcom/livemixtapes/App;->setCornerRadii(Landroid/graphics/drawable/Drawable;FFFF)V

    .line 249
    return-void
.end method

.method public setCornerRadius(Landroid/graphics/drawable/Drawable;F)V
    .locals 1
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p2, "radius"    # F

    .prologue
    .line 241
    check-cast p1, Landroid/graphics/drawable/GradientDrawable;

    .end local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p0, p2}, Lcom/livemixtapes/App;->dpToPx(F)F

    move-result v0

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V

    .line 242
    return-void
.end method

.method public setCornerRadius(Landroid/view/View;F)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "radius"    # F

    .prologue
    .line 237
    invoke-virtual {p1}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0, p2}, Lcom/livemixtapes/App;->setCornerRadius(Landroid/graphics/drawable/Drawable;F)V

    .line 238
    return-void
.end method
