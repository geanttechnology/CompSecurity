.class Lcom/livemixtapes/Mixtapes$LoadDownloadData;
.super Landroid/os/AsyncTask;
.source "Mixtapes.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/Mixtapes;
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

.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;)V
    .locals 0

    .prologue
    .line 865
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 879
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 880
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

    iget-object v3, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v3, v3, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-virtual {v0, v2, v3}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 881
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 3
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 886
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 888
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 890
    if-eqz p1, :cond_0

    .line 891
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v1

    const-string v2, "mixtape"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 892
    .local v0, "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->this$0:Lcom/livemixtapes/Mixtapes;

    const/4 v2, 0x0

    # invokes: Lcom/livemixtapes/Mixtapes;->loadMixtapeFragment(Ljava/util/HashMap;I)V
    invoke-static {v1, v0, v2}, Lcom/livemixtapes/Mixtapes;->access$7(Lcom/livemixtapes/Mixtapes;Ljava/util/HashMap;I)V

    .line 894
    .end local v0    # "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 871
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 872
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v1, v1, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    .line 873
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 874
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 875
    return-void
.end method
