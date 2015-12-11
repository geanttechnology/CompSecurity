.class public Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static bundle:Landroid/os/Bundle;

.field static retryCount:I

.field static toast:Landroid/widget/Toast;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 86
    const/4 v0, 0x0

    sput v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->retryCount:I

    .line 1507
    const/4 v0, 0x0

    sput-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toast:Landroid/widget/Toast;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1460
    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 84
    invoke-static {p0, p1, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseMyPlaylist(Landroid/content/Context;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic access$100(Landroid/content/Context;Ljava/lang/String;ZZ)V
    .locals 0

    .prologue
    .line 84
    invoke-static {p0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseMySubsPlaylist(Landroid/content/Context;Ljava/lang/String;ZZ)V

    return-void
.end method

.method public static addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    .locals 2

    .prologue
    .line 1317
    :try_start_0
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "divider"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1318
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;

    invoke-direct {v0, p1, p2}, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;-><init>(Lorg/json/JSONObject;Landroid/content/Context;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1339
    :goto_0
    return-void

    .line 1319
    :cond_0
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "dj"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1320
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;

    invoke-direct {v0, p2, p1}, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;-><init>(Landroid/content/Context;Lorg/json/JSONObject;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1337
    :catch_0
    move-exception v0

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;-><init>()V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1321
    :cond_1
    :try_start_1
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "more"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1322
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;

    invoke-direct {v0, p2, p1}, Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;-><init>(Landroid/content/Context;Lorg/json/JSONObject;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1323
    :cond_2
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "music"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1324
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    invoke-direct {v0, p2, p1, p3, p4}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;-><init>(Landroid/content/Context;Lorg/json/JSONObject;II)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1325
    :cond_3
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "playlist"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1326
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;

    invoke-direct {v0, p2, p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;-><init>(Landroid/content/Context;Lorg/json/JSONObject;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1327
    :cond_4
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "vector"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1328
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/VectorVectorItem;

    invoke-direct {v0, p1}, Lcom/mixerbox/mixerbox3b/classes/VectorVectorItem;-><init>(Lorg/json/JSONObject;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1329
    :cond_5
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "general"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1330
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;

    invoke-direct {v0, p2, p1}, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;-><init>(Landroid/content/Context;Lorg/json/JSONObject;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 1331
    :cond_6
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "dj_info"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 1332
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem;

    invoke-direct {v0, p2, p1}, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem;-><init>(Landroid/content/Context;Lorg/json/JSONObject;)V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 1334
    :cond_7
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;-><init>()V

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public static addSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;ZLjava/lang/String;)V
    .locals 9

    .prologue
    .line 826
    invoke-static {p1, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->addSongUrl(Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;)Ljava/lang/String;

    move-result-object v7

    .line 827
    const/4 v8, 0x0

    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;

    move-object v1, p0

    move-object v2, p4

    move-object v3, p0

    move-object v4, p1

    move v5, p3

    move-object v6, p2

    invoke-direct/range {v0 .. v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$14;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/classes/SongItem;)V

    invoke-static {v7, v8, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 853
    return-void
.end method

.method public static addSongToNewPlaylist(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V
    .locals 3

    .prologue
    .line 994
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->createPlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 995
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;

    invoke-direct {v2, p0, p0, p2, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$19;-><init>(Landroid/content/Context;Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 1010
    return-void
.end method

.method public static createPlaylist(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 956
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->createPlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 957
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;

    invoke-direct {v2, p0, p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$18;-><init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 991
    return-void
.end method

.method public static createPopupMenu(Landroid/content/Context;Landroid/view/View;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V
    .locals 10

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x2

    const/4 v7, 0x3

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1275
    new-instance v1, Landroid/widget/PopupMenu;

    invoke-direct {v1, p0, p1}, Landroid/widget/PopupMenu;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 1277
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getDefaultAddedPlaylistId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 1278
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getDefaultAddedPlaylistId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 1279
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getDefaultAddedPlaylistName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    move-object v0, p0

    .line 1280
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1281
    invoke-virtual {v1}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v4, 0x7f08014e

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v3, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v5, v5, v5, v2}, Landroid/view/Menu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 1290
    :cond_0
    :goto_0
    invoke-virtual {v1}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080061

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v5, v6, v6, v2}, Landroid/view/Menu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-object v0, p0

    .line 1292
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-eq v0, v9, :cond_1

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    if-eq v0, v7, :cond_1

    const-string v0, "PLAYLISTHISTORYID"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1295
    invoke-virtual {v1}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080093

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v5, v8, v8, v2}, Landroid/view/Menu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    :cond_1
    move-object v0, p0

    .line 1297
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-eq v0, v9, :cond_2

    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/16 v2, 0x9

    if-ne v0, v2, :cond_3

    :cond_2
    const-string v0, "PLAYLISTHISTORYID"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1300
    :cond_3
    invoke-virtual {v1}, Landroid/widget/PopupMenu;->getMenu()Landroid/view/Menu;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v5, v7, v7, v2}, Landroid/view/Menu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    .line 1303
    :cond_4
    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;

    invoke-direct {v0, p0, p2, p3, p4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$25;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V

    invoke-virtual {v1, v0}, Landroid/widget/PopupMenu;->setOnMenuItemClickListener(Landroid/widget/PopupMenu$OnMenuItemClickListener;)V

    .line 1311
    invoke-virtual {v1}, Landroid/widget/PopupMenu;->show()V

    .line 1313
    return-void

    .line 1286
    :cond_5
    const-string v0, ""

    const-string v2, ""

    invoke-static {p0, v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putDefaultAddedPlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method static finishFetchInitData(Landroid/content/Context;)V
    .locals 4

    .prologue
    .line 134
    const-string v0, "FINISH FETCH"

    .line 136
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 137
    sget-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->bundle:Landroid/os/Bundle;

    if-nez v1, :cond_0

    .line 138
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    sput-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->bundle:Landroid/os/Bundle;

    .line 139
    :cond_0
    sget-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->bundle:Landroid/os/Bundle;

    const-string v2, "isLogIn"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 140
    sget-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 141
    const-class v1, Lcom/mixerbox/mixerbox3b/LoginBridge;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 142
    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 143
    check-cast p0, Landroid/app/Activity;

    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 145
    return-void
.end method

.method public static getArtistAlbums(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1072
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0x9

    if-lt v0, v1, :cond_0

    .line 1110
    :goto_0
    return-void

    .line 1074
    :cond_0
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getArtistAlbumUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1075
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$22;

    invoke-direct {v2, p0, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$22;-><init>(Landroid/content/Context;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0
.end method

.method public static getAuthLoginInfo(Landroid/content/Context;Lcom/facebook/Session;)V
    .locals 3

    .prologue
    .line 95
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 96
    invoke-virtual {p1}, Lcom/facebook/Session;->getAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getAuthLoginUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 98
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;

    invoke-direct {v2, p0, p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$1;-><init>(Landroid/content/Context;Landroid/content/Context;Lcom/facebook/Session;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 131
    return-void
.end method

.method public static getBitmapFromURL(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 3

    .prologue
    .line 1472
    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 1473
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 1474
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoInput(Z)V

    .line 1475
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    .line 1476
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    .line 1477
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-direct {v2, v1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 1478
    invoke-static {v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 1479
    invoke-virtual {v2}, Ljava/io/BufferedInputStream;->close()V

    .line 1480
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1483
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getDJs(Landroid/content/Context;)V
    .locals 3

    .prologue
    .line 426
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 429
    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getDJsUrl(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 430
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$7;

    invoke-direct {v2, p0, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$7;-><init>(Landroid/content/Context;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 465
    return-void
.end method

.method public static getFollower(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V
    .locals 3

    .prologue
    .line 623
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getFollowerUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 624
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;

    invoke-direct {v2, p0, p2, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$12;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 648
    return-void
.end method

.method public static getPlaylistItem(Lorg/json/JSONObject;Ljava/lang/String;I)Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;
    .locals 10

    .prologue
    .line 1113
    const-string v1, ""

    .line 1114
    const-string v2, ""

    .line 1115
    const-string v3, ""

    .line 1116
    const-string v4, ""

    .line 1117
    const-string v5, ""

    .line 1118
    const-string v6, ""

    .line 1119
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 1121
    if-eqz p0, :cond_8

    .line 1123
    :try_start_0
    const-string v7, "_id"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    const-string v7, "_id"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 1124
    const-string v7, "_id"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1125
    :cond_0
    const-string v7, "name"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    const-string v7, "name"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 1126
    const-string v7, "name"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1127
    :cond_1
    const-string v7, "owner"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v7, "owner"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 1128
    const-string v7, "owner"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1129
    :cond_2
    const-string v7, "ownerName"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    const-string v7, "ownerName"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 1130
    const-string v7, "ownerName"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 1131
    :cond_3
    const-string v7, "itemCount"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    const-string v7, "itemCount"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 1132
    const-string v7, "itemCount"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1133
    :cond_4
    const-string v7, "subsCnt"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    const-string v7, "subsCnt"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_5

    .line 1134
    const-string v7, "subsCnt"

    invoke-virtual {p0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 1135
    :cond_5
    invoke-virtual {p0, p1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    invoke-virtual {p0, p1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_7

    .line 1136
    invoke-virtual {p0, p1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    move-object v7, p1

    .line 1137
    :goto_0
    :try_start_1
    const-string v8, "isAlbum"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_6

    .line 1138
    const-string v8, "isAlbum"

    invoke-virtual {p0, v8}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v8

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    :cond_6
    move-object v8, v0

    .line 1143
    :goto_1
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    move v8, p2

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    return-object v0

    .line 1139
    :catch_0
    move-exception v7

    move-object v8, v7

    move-object v7, p1

    .line 1140
    :goto_2
    invoke-virtual {v8}, Lorg/json/JSONException;->printStackTrace()V

    move-object v8, v0

    goto :goto_1

    .line 1139
    :catch_1
    move-exception v8

    goto :goto_2

    :cond_7
    move-object v7, p1

    goto :goto_0

    :cond_8
    move-object v8, v0

    move-object v7, p1

    goto :goto_1
.end method

.method public static getSongArray(Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/SongFragment;)Ljava/util/ArrayList;
    .locals 11

    .prologue
    .line 1189
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 1190
    if-nez p0, :cond_0

    move-object v0, v8

    .line 1214
    :goto_0
    return-object v0

    .line 1193
    :cond_0
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1194
    const-string v1, "getVector"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    move-object v0, v8

    .line 1195
    goto :goto_0

    .line 1196
    :cond_1
    const-string v1, "getVector"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 1197
    const-string v0, "items"

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    move-object v0, v8

    .line 1198
    goto :goto_0

    .line 1199
    :cond_2
    const-string v0, "items"

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v10

    .line 1200
    invoke-virtual {v10}, Lorg/json/JSONArray;->length()I

    move-result v0

    add-int/lit8 v5, v0, -0x1

    :goto_1
    if-ltz v5, :cond_5

    .line 1201
    invoke-virtual {v10, v5}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1202
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const-string v1, ""

    const-string v2, ""

    const-string v3, ""

    const-string v4, ""

    const/4 v6, 0x1

    const-string v7, ""

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1200
    :goto_2
    add-int/lit8 v5, v5, -0x1

    goto :goto_1

    .line 1205
    :cond_3
    invoke-virtual {v10, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 1206
    invoke-static {v0, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongItem(Lorg/json/JSONObject;I)Lcom/mixerbox/mixerbox3b/classes/SongItem;

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 1211
    :catch_0
    move-exception v0

    .line 1212
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    :cond_4
    :goto_3
    move-object v0, v8

    .line 1214
    goto :goto_0

    .line 1208
    :cond_5
    :try_start_1
    const-string v0, "subsCnt"

    invoke-virtual {v9, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    if-eqz p1, :cond_4

    .line 1209
    iget-object v0, p1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "subsCnt"

    invoke-virtual {v9, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->putSubsCount(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3
.end method

.method public static getSongItem(Lorg/json/JSONObject;I)Lcom/mixerbox/mixerbox3b/classes/SongItem;
    .locals 9

    .prologue
    const/4 v0, 0x1

    .line 1147
    const-string v5, ""

    .line 1148
    const-string v2, ""

    .line 1149
    const-string v3, "0"

    .line 1150
    const-string v4, ""

    .line 1151
    const-string v7, ""

    .line 1154
    :try_start_0
    const-string v1, "source"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    const-string v1, "source"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v6, "soundcloud"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1155
    const-string v1, "_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 1156
    const-string v1, "_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1157
    :cond_0
    const-string v1, "thumbnail"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "thumbnail"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 1158
    const-string v1, "thumbnail"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 1159
    :cond_1
    const-string v1, "title"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "title"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 1160
    const-string v1, "title"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1161
    :cond_2
    const-string v1, "duration"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string v1, "duration"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 1162
    const-string v1, "duration"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1163
    :cond_3
    const-string v1, "trackId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    const-string v1, "trackId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_b

    .line 1164
    const-string v1, "trackId"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    move-object v1, v5

    .line 1176
    :goto_0
    :try_start_1
    const-string v5, "source"

    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v5

    if-eqz v5, :cond_8

    move v6, v0

    .line 1185
    :goto_1
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    move v5, p1

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    return-object v0

    .line 1166
    :cond_4
    :try_start_2
    const-string v1, "_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 1167
    const-string v1, "_id"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1168
    :cond_5
    const-string v1, "tt"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    const-string v1, "tt"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 1169
    const-string v1, "tt"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1170
    :cond_6
    const-string v1, "tm"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    const-string v1, "tm"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_7

    .line 1171
    const-string v1, "tm"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1172
    :cond_7
    const-string v1, "f"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    const-string v1, "f"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_b

    .line 1173
    const-string v1, "f"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v4

    move-object v1, v5

    goto :goto_0

    .line 1178
    :cond_8
    :try_start_3
    const-string v5, "source"

    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "youtube"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    move v6, v0

    .line 1179
    goto :goto_1

    .line 1180
    :cond_9
    const-string v5, "source"

    invoke-virtual {p0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "soundcloud"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    move-result v5

    if-eqz v5, :cond_a

    .line 1181
    const/4 v0, 0x3

    :cond_a
    move v6, v0

    .line 1184
    goto/16 :goto_1

    .line 1182
    :catch_0
    move-exception v1

    move-object v8, v1

    move-object v1, v5

    move-object v5, v8

    .line 1183
    :goto_2
    invoke-virtual {v5}, Lorg/json/JSONException;->printStackTrace()V

    move v6, v0

    goto/16 :goto_1

    .line 1182
    :catch_1
    move-exception v5

    goto :goto_2

    :cond_b
    move-object v1, v5

    goto/16 :goto_0
.end method

.method public static getSongTime(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    const/16 v3, 0xa

    .line 1401
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 1408
    const/16 v0, 0xe10

    if-lt v1, v0, :cond_1

    .line 1409
    rem-int/lit16 v0, v1, 0xe10

    div-int/lit8 v0, v0, 0x3c

    if-ge v0, v3, :cond_0

    .line 1410
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    div-int/lit16 v2, v1, 0xe10

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":0"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    rem-int/lit16 v2, v1, 0xe10

    div-int/lit8 v2, v2, 0x3c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1420
    :goto_0
    rem-int/lit8 v2, v1, 0x3c

    if-ge v2, v3, :cond_3

    .line 1421
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":0"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    rem-int/lit8 v1, v1, 0x3c

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1425
    :goto_1
    return-object v0

    .line 1403
    :catch_0
    move-exception v0

    const-string v0, "0:00"

    goto :goto_1

    .line 1412
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    div-int/lit16 v2, v1, 0xe10

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    rem-int/lit16 v2, v1, 0xe10

    div-int/lit8 v2, v2, 0x3c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1414
    :cond_1
    div-int/lit8 v0, v1, 0x3c

    if-ge v0, v3, :cond_2

    .line 1415
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "0"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    div-int/lit8 v2, v1, 0x3c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1417
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    div-int/lit8 v2, v1, 0x3c

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1423
    :cond_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    rem-int/lit8 v1, v1, 0x3c

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public static getSubsInfo(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V
    .locals 3

    .prologue
    .line 592
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSubsInfoUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 593
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$11;

    invoke-direct {v2, p0, p2, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$11;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 620
    return-void
.end method

.method public static getVector(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8

    .prologue
    .line 468
    const/4 v0, 0x0

    invoke-static {p1, v0, p3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getVectorUrl(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 469
    const/4 v7, 0x0

    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;

    move-object v1, p0

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p0

    invoke-direct/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$8;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V

    invoke-static {v6, v7, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 522
    return-void
.end method

.method public static laterLoginInit(Landroid/content/Context;Lcom/facebook/Session;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 90
    sput-object p2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->bundle:Landroid/os/Bundle;

    .line 91
    invoke-static {p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getAuthLoginInfo(Landroid/content/Context;Lcom/facebook/Session;)V

    .line 92
    return-void
.end method

.method public static loadDBSong(Landroid/content/Context;Ljava/lang/String;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 11

    .prologue
    .line 695
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    move-object v0, p0

    .line 697
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSong(Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 698
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v9

    .line 699
    invoke-interface {v8}, Landroid/database/Cursor;->moveToLast()Z

    .line 700
    const/4 v5, 0x0

    :goto_0
    if-ge v5, v9, :cond_0

    move-object v0, p0

    .line 701
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v10, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v1, 0x0

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-interface {v8, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    invoke-interface {v8, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x6

    invoke-interface {v8, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    const/4 v7, 0x7

    invoke-interface {v8, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 703
    invoke-interface {v8}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 700
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 705
    :cond_0
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 707
    if-eqz p3, :cond_1

    .line 708
    invoke-virtual {p3}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->loadContent()V

    .line 710
    :cond_1
    if-eqz p2, :cond_2

    move-object v0, p0

    .line 711
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_3

    .line 724
    :cond_2
    :goto_1
    return-void

    :cond_3
    move-object v0, p0

    .line 713
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v2, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    move-object v0, p0

    .line 714
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 715
    if-eqz p3, :cond_4

    move-object v0, p0

    .line 716
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    :goto_2
    move-object v0, p0

    .line 721
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 722
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_1

    :cond_4
    move-object v0, p0

    .line 717
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_5

    move-object v0, p0

    .line 718
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    goto :goto_2

    :cond_5
    move-object v0, p0

    .line 720
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    goto :goto_2
.end method

.method public static loadJSONFromAsset(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 1488
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    .line 1491
    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v1

    .line 1492
    new-array v1, v1, [B

    .line 1493
    invoke-virtual {v0, v1}, Ljava/io/InputStream;->read([B)I

    .line 1494
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 1495
    new-instance v0, Ljava/lang/String;

    const-string v2, "UTF-8"

    invoke-direct {v0, v1, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1500
    :goto_0
    return-object v0

    .line 1496
    :catch_0
    move-exception v0

    .line 1497
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 1498
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static loadMP3Song(Landroid/content/Context;ZLcom/mixerbox/mixerbox3b/fragments/SongFragment;Ljava/lang/String;Landroid/net/Uri;)V
    .locals 12

    .prologue
    .line 652
    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    .line 653
    const/4 v7, 0x0

    .line 655
    const/4 v1, 0x5

    :try_start_0
    new-array v3, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "album_id"

    aput-object v2, v3, v1

    const/4 v1, 0x1

    const-string v2, "title"

    aput-object v2, v3, v1

    const/4 v1, 0x2

    const-string v2, "duration"

    aput-object v2, v3, v1

    const/4 v1, 0x3

    const-string v2, "_data"

    aput-object v2, v3, v1

    const/4 v1, 0x4

    const-string v2, "artist"

    aput-object v2, v3, v1

    .line 657
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v2, p4

    move-object v4, p3

    invoke-virtual/range {v1 .. v6}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v9

    .line 658
    :try_start_1
    invoke-interface {v9}, Landroid/database/Cursor;->getCount()I

    move-result v10

    .line 659
    if-lez v10, :cond_0

    .line 660
    invoke-interface {v9}, Landroid/database/Cursor;->moveToFirst()Z

    .line 661
    const/4 v6, 0x0

    :goto_0
    if-ge v6, v10, :cond_0

    .line 662
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v11, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    const/4 v2, 0x0

    invoke-interface {v9, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v4, 0x4

    invoke-interface {v9, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/4 v4, 0x1

    invoke-interface {v9, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x2

    invoke-interface {v9, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    div-int/lit16 v4, v4, 0x3e8

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x3

    invoke-interface {v9, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v7, 0x2

    const-string v8, ""

    invoke-direct/range {v1 .. v8}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    invoke-virtual {v11, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 665
    invoke-interface {v9}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 661
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 670
    :cond_0
    if-eqz v9, :cond_1

    .line 671
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 676
    :cond_1
    :goto_1
    if-eqz p2, :cond_2

    .line 677
    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->loadContent()V

    .line 679
    :cond_2
    if-eqz p1, :cond_3

    move-object v1, p0

    .line 680
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_5

    .line 691
    :cond_3
    :goto_2
    return-void

    .line 670
    :catch_0
    move-exception v1

    move-object v1, v7

    :goto_3
    if-eqz v1, :cond_1

    .line 671
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 670
    :catchall_0
    move-exception v1

    move-object v9, v7

    :goto_4
    if-eqz v9, :cond_4

    .line 671
    invoke-interface {v9}, Landroid/database/Cursor;->close()V

    .line 672
    :cond_4
    throw v1

    :cond_5
    move-object v1, p0

    .line 682
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v3, Ljava/util/ArrayList;

    move-object v2, p0

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-direct {v3, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v3, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    move-object v1, p0

    .line 683
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v2, p0

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 684
    if-eqz p2, :cond_6

    move-object v1, p0

    .line 685
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v2, p0

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v2}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v2, v2, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    :goto_5
    move-object v1, p0

    .line 688
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x0

    iput v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 689
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_2

    :cond_6
    move-object v1, p0

    .line 687
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x0

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    goto :goto_5

    .line 670
    :catchall_1
    move-exception v1

    goto :goto_4

    :catch_1
    move-exception v1

    move-object v1, v9

    goto :goto_3
.end method

.method public static loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V
    .locals 9

    .prologue
    .line 728
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSongUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 729
    const/4 v8, 0x0

    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;

    move-object v1, p0

    move-object v2, p0

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$13;-><init>(Landroid/content/Context;Landroid/content/Context;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    invoke-static {v7, v8, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 737
    return-void
.end method

.method public static logMsg(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1504
    return-void
.end method

.method public static makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;
    .locals 6

    .prologue
    const/16 v5, 0x21

    const/4 v4, 0x0

    .line 1438
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 1439
    new-instance v1, Landroid/text/style/StyleSpan;

    const/4 v2, 0x1

    invoke-direct {v1, v2}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1440
    new-instance v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$ClickableString;

    invoke-direct {v1, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$ClickableString;-><init>(Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;)V

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1441
    new-instance v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$NoUnderlineSpan;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$NoUnderlineSpan;-><init>()V

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1442
    new-instance v1, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f060019

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {v1, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 1444
    return-object v0
.end method

.method public static makeLinksFocusable(Landroid/widget/TextView;)V
    .locals 1

    .prologue
    .line 1429
    invoke-virtual {p0}, Landroid/widget/TextView;->getMovementMethod()Landroid/text/method/MovementMethod;

    move-result-object v0

    .line 1430
    if-eqz v0, :cond_0

    instance-of v0, v0, Landroid/text/method/LinkMovementMethod;

    if-nez v0, :cond_1

    .line 1431
    :cond_0
    invoke-virtual {p0}, Landroid/widget/TextView;->getLinksClickable()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1432
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 1435
    :cond_1
    return-void
.end method

.method public static parseDBMyPlaylists(Landroid/content/Context;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 360
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_1

    move-object v0, p0

    .line 361
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getMyPlaylist()Landroid/database/Cursor;

    move-result-object v1

    .line 362
    invoke-interface {v1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 363
    invoke-interface {v1}, Landroid/database/Cursor;->moveToLast()Z

    .line 364
    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_0

    .line 366
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 367
    invoke-interface {v1, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 368
    const/4 v4, 0x2

    invoke-interface {v1, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->createPlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 369
    const/4 v5, 0x0

    new-instance v6, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;

    invoke-direct {v6, p0, p0, v3, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$6;-><init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;I)V

    invoke-static {v4, v5, v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 418
    invoke-interface {v1}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 364
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 420
    :cond_0
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 421
    invoke-static {p0, v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMyPlaylist(Landroid/content/Context;Z)V

    .line 423
    :cond_1
    return-void
.end method

.method public static parseDBMySubs(Landroid/content/Context;)V
    .locals 14

    .prologue
    .line 317
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_2

    move-object v0, p0

    .line 318
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getShouldAddPlaylist()Landroid/database/Cursor;

    move-result-object v11

    .line 319
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v0

    .line 320
    invoke-interface {v11}, Landroid/database/Cursor;->moveToLast()Z

    .line 321
    add-int/lit8 v0, v0, -0x1

    move v10, v0

    :goto_0
    if-ltz v10, :cond_1

    .line 322
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v12

    move-object v0, p0

    .line 323
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 324
    const/4 v9, 0x0

    .line 325
    const/16 v0, 0x9

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 326
    const/4 v9, 0x1

    :cond_0
    move-object v0, p0

    .line 327
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v13, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const/4 v1, 0x1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x5

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x6

    invoke-interface {v11, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x7

    invoke-interface {v11, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x8

    invoke-interface {v11, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 330
    const/4 v0, 0x1

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 331
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->subsPlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 332
    const/4 v2, 0x0

    new-instance v3, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;

    invoke-direct {v3, p0, v0, v12, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$5;-><init>(Landroid/content/Context;Ljava/lang/String;ILandroid/content/Context;)V

    invoke-static {v1, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 352
    invoke-interface {v11}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 321
    add-int/lit8 v0, v10, -0x1

    move v10, v0

    goto :goto_0

    .line 354
    :cond_1
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 355
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->reloadMySubsPlaylist(Landroid/content/Context;ZZ)V

    .line 357
    :cond_2
    return-void
.end method

.method private static parseMyPlaylist(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 15

    .prologue
    .line 225
    if-eqz p1, :cond_4

    .line 226
    invoke-static/range {p0 .. p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putAuthLoginResponse(Landroid/content/Context;Ljava/lang/String;)V

    move-object v1, p0

    .line 227
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    .line 228
    new-instance v1, Lorg/json/JSONObject;

    move-object/from16 v0, p1

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 229
    const-string v2, "authLoginV2"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 230
    const-string v2, "data"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 231
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 232
    const-string v2, "playlists"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v14

    .line 234
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xf

    if-lt v1, v2, :cond_0

    .line 235
    const-string v1, "coverhq"

    move-object v11, v1

    .line 238
    :goto_0
    invoke-virtual {v14}, Lorg/json/JSONArray;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v12, v1

    :goto_1
    if-ltz v12, :cond_2

    .line 239
    invoke-virtual {v14, v12}, Lorg/json/JSONArray;->isNull(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 240
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, ""

    const-string v3, ""

    const-string v4, ""

    const-string v5, ""

    const-string v6, ""

    const-string v7, ""

    const-string v8, ""

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 238
    :goto_2
    add-int/lit8 v1, v12, -0x1

    move v12, v1

    goto :goto_1

    .line 237
    :cond_0
    const-string v1, "cover"

    move-object v11, v1

    goto :goto_0

    .line 243
    :cond_1
    invoke-virtual {v14, v12}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    .line 244
    const/4 v1, 0x1

    invoke-static {v2, v11, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getPlaylistItem(Lorg/json/JSONObject;Ljava/lang/String;I)Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    move-result-object v1

    invoke-virtual {v13, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v1, p0

    .line 245
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    const-string v3, "_id"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    :cond_2
    move-object v1, p0

    .line 247
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, v13}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    .line 251
    :goto_3
    const-string v8, ""

    .line 253
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://i.ytimg.com/vi/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getLastHistory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/mqdefault.jpg"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    :goto_4
    move-object v1, p0

    .line 256
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v11, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "PLAYLISTHISTORYID"

    move-object v3, p0

    check-cast v3, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080111

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    const-string v5, ""

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object v6, p0

    check-cast v6, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v6, v6, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v9, "PLAYLISTHISTORYID"

    invoke-virtual {v6, v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSongCount(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const/4 v9, 0x6

    const/4 v10, 0x0

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v11, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v1, p0

    .line 260
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/MainPage;->checkMP3CountAndLoad()V

    .line 261
    if-eqz p2, :cond_5

    move-object v1, p0

    .line 262
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setPlaylists(Z)V

    move-object v1, p0

    .line 263
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v1, :cond_3

    .line 264
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 271
    :cond_3
    :goto_5
    return-void

    :cond_4
    move-object v1, p0

    .line 249
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    goto/16 :goto_3

    :cond_5
    move-object v1, p0

    .line 266
    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    if-eqz v1, :cond_3

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-eqz v1, :cond_6

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/4 v2, 0x5

    if-eq v1, v2, :cond_6

    move-object v1, p0

    check-cast v1, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/4 v2, 0x4

    if-ne v1, v2, :cond_3

    .line 269
    :cond_6
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto :goto_5

    :catch_0
    move-exception v1

    goto/16 :goto_4
.end method

.method private static parseMySubsPlaylist(Landroid/content/Context;Ljava/lang/String;ZZ)V
    .locals 6

    .prologue
    .line 275
    if-eqz p1, :cond_5

    .line 276
    invoke-static {p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putAuthLoginResponse(Landroid/content/Context;Ljava/lang/String;)V

    .line 277
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 278
    const-string v1, "authLoginV2"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 279
    const-string v1, "data"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 280
    if-eqz p3, :cond_0

    move-object v0, p0

    .line 281
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    move-object v0, p0

    .line 282
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 284
    :cond_0
    const-string v0, "subs_playlists"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 286
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xf

    if-lt v0, v1, :cond_1

    .line 287
    const-string v0, "coverhq"

    move-object v1, v0

    .line 290
    :goto_0
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v2, v0

    :goto_1
    if-ltz v2, :cond_2

    .line 291
    invoke-virtual {v3, v2}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v4

    move-object v0, p0

    .line 292
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    const/4 v5, 0x2

    invoke-static {v4, v1, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getPlaylistItem(Lorg/json/JSONObject;Ljava/lang/String;I)Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v0, p0

    .line 293
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v5, "_id"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 290
    add-int/lit8 v0, v2, -0x1

    move v2, v0

    goto :goto_1

    .line 289
    :cond_1
    const-string v0, "cover"

    move-object v1, v0

    goto :goto_0

    .line 296
    :cond_2
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$4;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$4;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 306
    :goto_2
    if-eqz p2, :cond_6

    move-object v0, p0

    .line 307
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_3

    move-object v0, p0

    .line 308
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    .line 309
    :cond_3
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setPlaylists(Z)V

    .line 314
    :cond_4
    :goto_3
    return-void

    :cond_5
    move-object v0, p0

    .line 304
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    goto :goto_2

    :cond_6
    move-object v0, p0

    .line 311
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    if-eqz v0, :cond_4

    .line 312
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto :goto_3
.end method

.method public static performSongAction(Landroid/content/Context;ILcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 1342
    packed-switch p1, :pswitch_data_0

    .line 1391
    :goto_0
    return-void

    .line 1344
    :pswitch_0
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getDefaultAddedPlaylistId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 1345
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getDefaultAddedPlaylistName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    move-object v0, p0

    .line 1346
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_0

    .line 1347
    invoke-static {p0, v1, p2, v8, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;ZLjava/lang/String;)V

    goto :goto_0

    .line 1350
    :cond_0
    const-string v0, "action:music_add_local"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    move-object v0, p0

    .line 1351
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongOrder()I

    move-result v5

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v6

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v7

    invoke-virtual/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addSong(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 1352
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080077

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v8}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 1353
    check-cast p0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto :goto_0

    .line 1357
    :pswitch_1
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;

    invoke-direct {v0, p0, p2}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V

    .line 1358
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AddToPlaylistDialog;->show()Landroid/app/AlertDialog;

    move-result-object v0

    .line 1359
    invoke-virtual {v0}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    goto :goto_0

    .line 1362
    :pswitch_2
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1363
    const-string v1, "f"

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1364
    const-string v1, "id"

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1365
    const-string v1, "playlist"

    invoke-interface {v0, v1, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1366
    const-string v1, "t"

    const-string v2, "yt"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1367
    const-string v1, "action:music_share"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    move-object v0, p0

    .line 1371
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_1

    .line 1372
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://www.mixerbox.com/music/0/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1378
    :goto_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800ba

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800b8

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1380
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800b9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1381
    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.SEND"

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1382
    const-string v4, "text/plain"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 1383
    const-string v4, "android.intent.extra.SUBJECT"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1384
    const-string v4, "android.intent.extra.TEXT"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1385
    const/4 v0, 0x0

    invoke-static {v3, v0}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    :cond_1
    move-object v0, p0

    .line 1373
    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    const/4 v1, 0x5

    if-eq v0, v1, :cond_2

    .line 1374
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://www.mixerbox.com/music/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 1376
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://www.mixerbox.com/music/0/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 1388
    :pswitch_3
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    const/4 v2, 0x2

    move-object v1, p0

    move-object v3, p3

    move-object v4, p2

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;-><init>(Landroid/content/Context;ILjava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;I)V

    .line 1390
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->show()Landroid/app/AlertDialog;

    goto/16 :goto_0

    .line 1342
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static reloadMyPlaylist(Landroid/content/Context;Z)V
    .locals 3

    .prologue
    .line 193
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 194
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFacebookToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getAuthLoginUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 195
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;

    invoke-direct {v2, p0, p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$2;-><init>(Landroid/content/Context;Landroid/content/Context;Z)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 206
    return-void
.end method

.method public static reloadMySubsPlaylist(Landroid/content/Context;ZZ)V
    .locals 3

    .prologue
    .line 209
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 210
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFacebookToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getAuthLoginUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 211
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;

    invoke-direct {v2, p0, p0, p1, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$3;-><init>(Landroid/content/Context;Landroid/content/Context;ZZ)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 222
    return-void
.end method

.method public static removePlaylist(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 906
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->removePlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 907
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$16;

    invoke-direct {v2, p0, p0, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$16;-><init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 924
    return-void
.end method

.method public static removeSong(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;I)V
    .locals 3

    .prologue
    .line 856
    invoke-static {p1, p2, p3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->removeSongUrl(Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;I)Ljava/lang/String;

    move-result-object v0

    .line 857
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;

    invoke-direct {v2, p0, p0, p1, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$15;-><init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 903
    return-void
.end method

.method public static renamePlaylist(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 927
    invoke-static {p1, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->renamePlaylistUrl(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 928
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$17;

    invoke-direct {v2, p0, p0, p1, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$17;-><init>(Landroid/content/Context;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 953
    return-void
.end method

.method public static saveAuthLoginInfo(Landroid/content/Context;)V
    .locals 8

    .prologue
    .line 148
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getAuthLoginResponse(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 150
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 151
    const-string v2, "authLoginV2"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 152
    const-string v2, "data"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 154
    const-string v4, ""

    .line 155
    const-string v3, ""

    .line 156
    const-string v2, ""

    .line 157
    const-string v1, ""

    .line 159
    const-string v7, "user"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    const-string v7, "user"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 160
    const-string v7, "user"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    .line 161
    const-string v7, "_id"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    const-string v7, "_id"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 162
    const-string v4, "_id"

    invoke-virtual {v6, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 163
    :cond_0
    const-string v7, "locale"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    const-string v7, "locale"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 164
    const-string v3, "locale"

    invoke-virtual {v6, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 165
    :cond_1
    const-string v7, "name"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    const-string v7, "name"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_2

    .line 166
    const-string v2, "name"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 167
    :cond_2
    const-string v7, "fb"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    const-string v7, "fb"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_3

    .line 168
    const-string v1, "fb"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v6, "id"

    invoke-virtual {v1, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 171
    :cond_3
    invoke-static {p0, v4, v2, v3, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putAuthLoginInfo(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    .line 174
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    .line 175
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    .line 176
    move-object v0, p0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    move-object v1, v0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    .line 178
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHasAddFromDB(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 179
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseDBMyPlaylists(Landroid/content/Context;)V

    .line 180
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseDBMySubs(Landroid/content/Context;)V

    .line 181
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHasAddFromDB(Landroid/content/Context;)V

    .line 190
    :goto_0
    return-void

    .line 183
    :cond_4
    const/4 v1, 0x0

    invoke-static {p0, v5, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseMyPlaylist(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 184
    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {p0, v5, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->parseMySubsPlaylist(Landroid/content/Context;Ljava/lang/String;ZZ)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 187
    :catch_0
    move-exception v1

    .line 188
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public static sendCohortListening(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1259
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 1260
    invoke-static {v0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getCohortListeningUrl(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$24;

    invoke-direct {v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$24;-><init>()V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 1271
    return-void
.end method

.method public static sendCohortRegister(Landroid/content/Context;Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 1218
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1220
    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putLocale(Landroid/content/Context;Ljava/lang/String;)V

    .line 1222
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 1223
    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1224
    const-string v0, "phone"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 1225
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    .line 1226
    if-eqz v0, :cond_1

    .line 1227
    const-string v2, " "

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1228
    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putUUID(Landroid/content/Context;Ljava/lang/String;)V

    .line 1240
    :cond_0
    :goto_0
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 1241
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, v2, Landroid/content/pm/PackageInfo;->versionCode:I

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v0, v1, p1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getCohortRegisterUrl(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$23;

    invoke-direct {v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$23;-><init>()V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1256
    :goto_1
    return-void

    .line 1230
    :cond_1
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1231
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 1232
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v2}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1233
    const-string v2, " "

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1234
    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putUUID(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 1256
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public static setSearch(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V
    .locals 3

    .prologue
    .line 525
    const-string v0, ""

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSearchUrl(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    .line 526
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;

    invoke-direct {v2, p0, p2, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$9;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 559
    return-void
.end method

.method public static setSearchCategory(Landroid/content/Context;Ljava/lang/String;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 562
    const/4 v0, 0x0

    invoke-static {p3, p1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSearchUrl(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    .line 563
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$10;

    invoke-direct {v2, p0, p2, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$10;-><init>(Landroid/content/Context;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 589
    return-void
.end method

.method public static subsPlaylist(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 3

    .prologue
    .line 1013
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->subsPlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1014
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;

    invoke-direct {v2, p0, p1, p2, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$20;-><init>(Landroid/content/Context;Ljava/lang/String;ZLandroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 1038
    return-void
.end method

.method public static toastMsg(Landroid/content/Context;Ljava/lang/String;I)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1526
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toast:Landroid/widget/Toast;

    if-eqz v0, :cond_0

    .line 1527
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toast:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->cancel()V

    .line 1528
    :cond_0
    invoke-static {p0, p1, p2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 1529
    sput-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toast:Landroid/widget/Toast;

    const/16 v1, 0x10

    invoke-virtual {v0, v1, v2, v2}, Landroid/widget/Toast;->setGravity(III)V

    .line 1530
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toast:Landroid/widget/Toast;

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 1531
    return-void
.end method

.method public static unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1042
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->unsubsPlaylistUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1043
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$21;

    invoke-direct {v2, p0, p1, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$21;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 1069
    return-void
.end method
