.class Lcom/livemixtapes/CommentsActivity$JSONParse;
.super Landroid/os/AsyncTask;
.source "CommentsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/CommentsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "JSONParse"
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
.field final synthetic this$0:Lcom/livemixtapes/CommentsActivity;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/CommentsActivity;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/CommentsActivity;Lcom/livemixtapes/CommentsActivity$JSONParse;)V
    .locals 0

    .prologue
    .line 212
    invoke-direct {p0, p1}, Lcom/livemixtapes/CommentsActivity$JSONParse;-><init>(Lcom/livemixtapes/CommentsActivity;)V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/CommentsActivity$JSONParse;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 223
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 225
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v3, Ljava/lang/StringBuilder;

    # getter for: Lcom/livemixtapes/CommentsActivity;->url:Ljava/lang/String;
    invoke-static {}, Lcom/livemixtapes/CommentsActivity;->access$2()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v4, v4, Lcom/livemixtapes/CommentsActivity;->mixtapeId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 226
    .local v2, "loadUrl":Ljava/lang/String;
    aget-object v3, p1, v5

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 227
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&before="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    aget-object v4, p1, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 229
    :cond_0
    iget-object v3, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-virtual {v0, v2, v3}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 230
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/CommentsActivity$JSONParse;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 235
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-virtual {v2}, Lcom/livemixtapes/CommentsActivity;->hideProgressBar()V

    .line 236
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v3, 0x0

    iput-boolean v3, v2, Lcom/livemixtapes/CommentsActivity;->flag_loading:Z

    .line 238
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "comments"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 239
    .local v0, "subList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 240
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 241
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v3, v3, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    .line 242
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    .line 241
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    .line 243
    .local v1, "tempMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    const-string v2, "timestamp"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, v3, Lcom/livemixtapes/CommentsActivity;->lastSavedCommentTimestamp:Ljava/lang/String;

    .line 245
    .end local v1    # "tempMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x2

    if-gt v2, v3, :cond_1

    .line 246
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/livemixtapes/CommentsActivity;->stop_loading:Z

    .line 248
    :cond_1
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->adapter:Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;

    invoke-virtual {v2}, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->notifyDataSetChanged()V

    .line 249
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 216
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 217
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/livemixtapes/CommentsActivity;->flag_loading:Z

    .line 218
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$JSONParse;->this$0:Lcom/livemixtapes/CommentsActivity;

    const-string v1, "Loading..."

    invoke-virtual {v0, v1}, Lcom/livemixtapes/CommentsActivity;->showProgressBar(Ljava/lang/String;)V

    .line 219
    return-void
.end method
