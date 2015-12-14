.class Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;
.super Landroid/os/AsyncTask;
.source "SelectedPlayList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SelectedPlayList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ReorderOrDeleteTracks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# instance fields
.field isReorderOrDelete:I

.field pd:Landroid/app/ProgressDialog;

.field final synthetic this$0:Lcom/livemixtapes/profile/SelectedPlayList;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList;I)V
    .locals 0
    .param p2, "isReorderOrDelete"    # I

    .prologue
    .line 389
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 388
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 390
    iput p2, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->isReorderOrDelete:I

    .line 391
    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 8
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 404
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 405
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 406
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "id"

    sget-object v5, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    const-string v6, "playlist_id"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 408
    iget v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->isReorderOrDelete:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 410
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "tracks"

    aget-object v5, p1, v7

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 411
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/playlist/reorder?auth="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 412
    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 411
    invoke-virtual {v0, v3, v2}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .line 427
    .local v1, "json":Lorg/json/JSONObject;
    :goto_0
    return-object v1

    .line 414
    .end local v1    # "json":Lorg/json/JSONObject;
    :cond_0
    iget v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->isReorderOrDelete:I

    const/4 v4, 0x2

    if-ne v3, v4, :cond_1

    .line 416
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "track"

    aget-object v5, p1, v7

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 417
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/playlist/deletetrack?auth="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 418
    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 417
    invoke-virtual {v0, v3, v2}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .line 419
    .restart local v1    # "json":Lorg/json/JSONObject;
    goto :goto_0

    .line 422
    .end local v1    # "json":Lorg/json/JSONObject;
    :cond_1
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "name"

    aget-object v5, p1, v7

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 423
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/playlist/rename?auth="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 424
    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 423
    invoke-virtual {v0, v3, v2}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .restart local v1    # "json":Lorg/json/JSONObject;
    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 5
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    const/4 v4, 0x3

    .line 432
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 433
    iget v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->isReorderOrDelete:I

    if-eq v3, v4, :cond_0

    .line 434
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v3}, Landroid/app/ProgressDialog;->dismiss()V

    .line 435
    :cond_0
    if-eqz p1, :cond_1

    .line 437
    iget v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->isReorderOrDelete:I

    if-eq v3, v4, :cond_4

    .line 440
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v2

    .line 442
    .local v2, "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v3

    iget-object v3, v3, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-lt v0, v3, :cond_2

    .line 462
    .end local v0    # "i":I
    .end local v2    # "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_1
    :goto_1
    return-void

    .line 443
    .restart local v0    # "i":I
    .restart local v2    # "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_2
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v3

    iget-object v3, v3, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    .line 444
    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 446
    .local v1, "playlistObj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v3, "playlist_id"

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 447
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 448
    const-string v4, "playlist_id"

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 449
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 448
    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    .line 449
    if-eqz v3, :cond_3

    .line 450
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v3

    iget-object v3, v3, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v3, v0, v2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 442
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 458
    .end local v0    # "i":I
    .end local v1    # "playlistObj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v2    # "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_4
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v2

    .line 459
    .restart local v2    # "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v4

    const-string v3, "playlists"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    iput-object v3, v4, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    goto :goto_1
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 395
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 396
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SelectedPlayList;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->pd:Landroid/app/ProgressDialog;

    .line 397
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 398
    iget v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->isReorderOrDelete:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    .line 399
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 400
    :cond_0
    return-void
.end method
