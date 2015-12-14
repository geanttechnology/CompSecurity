.class Lcom/livemixtapes/ProfileFragment$LoadDownloadData;
.super Landroid/os/AsyncTask;
.source "ProfileFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/ProfileFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LoadDownloadData"
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

.field final synthetic this$0:Lcom/livemixtapes/ProfileFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ProfileFragment;)V
    .locals 0

    .prologue
    .line 302
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/ProfileFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 316
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 317
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "https://api.livemixtapes.com/api/mixtape/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x0

    aget-object v3, p1, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/ProfileFragment;

    iget-object v3, v3, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-virtual {v0, v2, v3}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 318
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 4
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 323
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 324
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 325
    if-eqz p1, :cond_0

    .line 326
    iget-object v1, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/ProfileFragment;

    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/ProfileFragment;

    iget-object v2, v0, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v0

    const-string v3, "mixtape"

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    invoke-virtual {v1, v2, v0}, Lcom/livemixtapes/ProfileFragment;->showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V

    .line 327
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 308
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 309
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/ProfileFragment;

    iget-object v1, v1, Lcom/livemixtapes/ProfileFragment;->activity:Lcom/livemixtapes/ProfileActivity;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    .line 310
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 311
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 312
    return-void
.end method
