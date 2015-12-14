.class Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;
.super Landroid/os/AsyncTask;
.source "SeeAllList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SeeAllList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LoadMixtapeData"
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
    .line 316
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 329
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 330
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "https://api.livemixtapes.com/api/mixtape/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 331
    const/4 v3, 0x0

    aget-object v3, p1, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-virtual {v3}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v3

    .line 330
    invoke-virtual {v0, v2, v3}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 332
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 337
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 338
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 339
    if-eqz p1, :cond_0

    .line 340
    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v2, v0, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    .line 341
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v0

    .line 342
    const-string v3, "mixtape"

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 340
    invoke-virtual {v1, v2, v0}, Lcom/livemixtapes/profile/SeeAllList;->showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V

    .line 343
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 321
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 322
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SeeAllList;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->pd:Landroid/app/ProgressDialog;

    .line 323
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 324
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 325
    return-void
.end method
