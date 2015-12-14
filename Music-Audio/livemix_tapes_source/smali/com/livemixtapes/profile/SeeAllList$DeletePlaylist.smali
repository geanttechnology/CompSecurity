.class Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;
.super Landroid/os/AsyncTask;
.source "SeeAllList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SeeAllList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DeletePlaylist"
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
.field pd:Landroid/app/ProgressDialog;

.field final synthetic this$0:Lcom/livemixtapes/profile/SeeAllList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SeeAllList;)V
    .locals 0

    .prologue
    .line 435
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 448
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 449
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 450
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "id"

    const/4 v5, 0x0

    aget-object v5, p1, v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 451
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/playlist/delete?auth="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 452
    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 451
    invoke-virtual {v0, v3, v2}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .line 453
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 458
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 459
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 460
    if-eqz p1, :cond_0

    .line 462
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v1

    const-string v2, "playlists"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 463
    .local v0, "playlistResponse":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 464
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 465
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 466
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v2

    iget-object v2, v2, Lcom/livemixtapes/User$UserData;->playlists:Ljava/util/List;

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 467
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SeeAllList;->adapter:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    invoke-virtual {v1}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->notifyDataSetChanged()V

    .line 469
    .end local v0    # "playlistResponse":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 440
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 441
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->pd:Landroid/app/ProgressDialog;

    .line 442
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 443
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 444
    return-void
.end method
