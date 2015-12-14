.class Lcom/livemixtapes/CommentsActivity$PostComment;
.super Landroid/os/AsyncTask;
.source "CommentsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/CommentsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PostComment"
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
    .line 169
    iput-object p1, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/CommentsActivity;Lcom/livemixtapes/CommentsActivity$PostComment;)V
    .locals 0

    .prologue
    .line 169
    invoke-direct {p0, p1}, Lcom/livemixtapes/CommentsActivity$PostComment;-><init>(Lcom/livemixtapes/CommentsActivity;)V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/CommentsActivity$PostComment;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    .line 180
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 181
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 182
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "album_id"

    iget-object v5, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v5, v5, Lcom/livemixtapes/CommentsActivity;->mixtapeId:Ljava/lang/String;

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 183
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "comment_text"

    const/4 v5, 0x0

    aget-object v5, p1, v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 184
    new-instance v3, Lorg/apache/http/message/BasicNameValuePair;

    const-string v4, "auth"

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 185
    const-string v3, "https://api.livemixtapes.com/api/comments/add"

    invoke-virtual {v0, v3, v2}, Lcom/livemixtapes/library/JSONParser;->postData(Ljava/lang/String;Ljava/util/List;)Lorg/json/JSONObject;

    move-result-object v1

    .line 187
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/CommentsActivity$PostComment;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 192
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    invoke-virtual {v2}, Lcom/livemixtapes/CommentsActivity;->hideProgressBar()V

    .line 193
    if-eqz p1, :cond_2

    .line 194
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->commentsEditText:Landroid/widget/EditText;

    const-string v3, ""

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 195
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 197
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v2

    const-string v3, "comments"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 198
    .local v0, "subList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 199
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 200
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    .line 201
    iget-object v3, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v3, v3, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    .line 202
    .local v1, "tempMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    const-string v2, "timestamp"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, v3, Lcom/livemixtapes/CommentsActivity;->lastSavedCommentTimestamp:Ljava/lang/String;

    .line 204
    .end local v1    # "tempMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x2

    if-gt v2, v3, :cond_1

    .line 205
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v3, 0x1

    iput-boolean v3, v2, Lcom/livemixtapes/CommentsActivity;->stop_loading:Z

    .line 207
    :cond_1
    iget-object v2, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    iget-object v2, v2, Lcom/livemixtapes/CommentsActivity;->adapter:Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;

    invoke-virtual {v2}, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->notifyDataSetChanged()V

    .line 209
    .end local v0    # "subList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :cond_2
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 173
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 174
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/livemixtapes/CommentsActivity;->flag_loading:Z

    .line 175
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$PostComment;->this$0:Lcom/livemixtapes/CommentsActivity;

    const-string v1, "Posting..."

    invoke-virtual {v0, v1}, Lcom/livemixtapes/CommentsActivity;->showProgressBar(Ljava/lang/String;)V

    .line 176
    return-void
.end method
