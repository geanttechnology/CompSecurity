.class Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;
.super Landroid/os/AsyncTask;
.source "SeeAllList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SeeAllList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "AddtoPlayList"
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
.field isNewOrOld:I

.field pd:Landroid/app/ProgressDialog;

.field final synthetic this$0:Lcom/livemixtapes/profile/SeeAllList;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/profile/SeeAllList;I)V
    .locals 0
    .param p2, "isNeworOld"    # I

    .prologue
    .line 376
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 377
    iput p2, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->isNewOrOld:I

    .line 378
    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 390
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 391
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 392
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "id"

    const/4 v5, 0x1

    aget-object v5, p1, v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 393
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "tracks"

    const/4 v5, 0x2

    aget-object v5, p1, v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 394
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v4, 0x0

    aget-object v4, p1, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 395
    const-string v4, "?auth="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 394
    invoke-virtual {v0, v3, v2}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .line 396
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 6
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 401
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 402
    iget-object v4, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v4}, Landroid/app/ProgressDialog;->dismiss()V

    .line 403
    if-eqz p1, :cond_1

    .line 404
    const/4 v4, 0x1

    sput-boolean v4, Lcom/livemixtapes/Mixtape;->shouldClearPlayListMode:Z

    .line 406
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v3

    .line 407
    .local v3, "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v1, 0x0

    .line 408
    .local v1, "isFound":Z
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v4

    iget-object v4, v4, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lt v0, v4, :cond_2

    .line 421
    :goto_1
    if-nez v1, :cond_0

    .line 422
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v4

    iget-object v4, v4, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 424
    :cond_0
    iget-object v4, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-virtual {v4}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v4

    check-cast v4, Lcom/livemixtapes/ui/BaseActivity;

    invoke-virtual {v4}, Lcom/livemixtapes/ui/BaseActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v4

    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-virtual {v4, v5}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/FragmentTransaction;->commit()I

    .line 432
    .end local v0    # "i":I
    .end local v1    # "isFound":Z
    .end local v3    # "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_1
    return-void

    .line 409
    .restart local v0    # "i":I
    .restart local v1    # "isFound":Z
    .restart local v3    # "playlistResponse":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_2
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v4

    iget-object v4, v4, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    .line 410
    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 412
    .local v2, "playlistObj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v4, "playlist_id"

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 413
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 414
    const-string v5, "playlist_id"

    invoke-interface {v3, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 415
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 414
    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    .line 415
    if-eqz v4, :cond_3

    .line 416
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v4

    iget-object v4, v4, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v4, v0, v3}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 417
    const/4 v1, 0x1

    .line 418
    goto :goto_1

    .line 408
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 382
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 383
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->pd:Landroid/app/ProgressDialog;

    .line 384
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 385
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 386
    return-void
.end method
