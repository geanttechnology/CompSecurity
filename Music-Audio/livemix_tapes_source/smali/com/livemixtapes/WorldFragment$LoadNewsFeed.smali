.class Lcom/livemixtapes/WorldFragment$LoadNewsFeed;
.super Landroid/os/AsyncTask;
.source "WorldFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/WorldFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LoadNewsFeed"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/WorldFragment;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/WorldFragment;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/WorldFragment;Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)V
    .locals 0

    .prologue
    .line 187
    invoke-direct {p0, p1}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;-><init>(Lcom/livemixtapes/WorldFragment;)V

    return-void
.end method

.method static synthetic access$3(Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)Lcom/livemixtapes/WorldFragment;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    .line 197
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 199
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    sget-object v2, Lcom/livemixtapes/WorldFragment;->url:Ljava/lang/String;

    iget-object v3, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v3, v3, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-virtual {v0, v2, v3}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 200
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 205
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v0, v0, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-virtual {v0}, Lcom/livemixtapes/WorldActivity;->hideProgressBar()V

    .line 207
    if-nez p1, :cond_0

    .line 230
    :goto_0
    return-void

    .line 210
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v1, v0, Lcom/livemixtapes/WorldFragment;->newsList:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v0

    const-string v2, "news"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 212
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v0, v0, Lcom/livemixtapes/WorldFragment;->newsList:Ljava/util/ArrayList;

    .line 213
    new-instance v1, Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;

    invoke-direct {v1, p0}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed$1;-><init>(Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)V

    .line 212
    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 229
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v0, v0, Lcom/livemixtapes/WorldFragment;->adapter:Lcom/livemixtapes/WorldFragment$NewsListAdapter;

    invoke-virtual {v0}, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 191
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 192
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v0, v0, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    const-string v1, "Loading..."

    invoke-virtual {v0, v1}, Lcom/livemixtapes/WorldActivity;->showProgressBar(Ljava/lang/String;)V

    .line 193
    return-void
.end method
