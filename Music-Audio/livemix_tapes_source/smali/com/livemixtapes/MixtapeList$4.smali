.class Lcom/livemixtapes/MixtapeList$4;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "MixtapeList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MixtapeList;->loadNextPage()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/MixtapeList;

.field private final synthetic val$dialog:Landroid/app/ProgressDialog;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MixtapeList;Landroid/app/ProgressDialog;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MixtapeList$4;->this$0:Lcom/livemixtapes/MixtapeList;

    iput-object p2, p0, Lcom/livemixtapes/MixtapeList$4;->val$dialog:Landroid/app/ProgressDialog;

    .line 130
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method


# virtual methods
.method protected always()V
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$4;->val$dialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$4;->val$dialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 159
    :cond_0
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 152
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 151
    aput-object p1, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    .line 147
    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 133
    aput-object p1, v3, v4

    const/4 v4, 0x1

    aput-object p2, v3, v4

    const/4 v4, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 135
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 136
    .local v1, "jObj":Lorg/json/JSONObject;
    const-string v3, "mixtapes"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/json/JSONArray;

    invoke-static {v3}, Lcom/livemixtapes/JsonToMap;->toList(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    .line 137
    .local v2, "mixTapeList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 139
    iget-object v3, p0, Lcom/livemixtapes/MixtapeList$4;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v3, v3, Lcom/livemixtapes/MixtapeList;->mixtapeList:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 140
    iget-object v3, p0, Lcom/livemixtapes/MixtapeList$4;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v3, v3, Lcom/livemixtapes/MixtapeList;->adapter:Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;

    invoke-virtual {v3}, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->notifyDataSetChanged()V

    .line 142
    :cond_0
    const-string v3, "Nithin"

    invoke-virtual {v2}, Ljava/util/ArrayList;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    .end local v1    # "jObj":Lorg/json/JSONObject;
    .end local v2    # "mixTapeList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;>;"
    :goto_0
    return-void

    .line 143
    :catch_0
    move-exception v0

    .line 145
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method
