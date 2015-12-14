.class Lcom/livemixtapes/WorldFragment$LoadDownloadData;
.super Landroid/os/AsyncTask;
.source "WorldFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/WorldFragment;
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

.field final synthetic this$0:Lcom/livemixtapes/WorldFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/WorldFragment;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/WorldFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 4
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    .line 162
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 163
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

    iget-object v3, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v3, v3, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-virtual {v0, v2, v3}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 164
    .local v1, "json":Lorg/json/JSONObject;
    return-object v1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 6
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 169
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 170
    iget-object v4, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v4}, Landroid/app/ProgressDialog;->dismiss()V

    .line 171
    if-eqz p1, :cond_0

    .line 174
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v4

    const-string v5, "mixtape"

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/HashMap;

    .line 175
    .local v3, "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v4, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v4, v4, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-virtual {v4}, Lcom/livemixtapes/WorldActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 176
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/Mixtape;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtape;-><init>()V

    .line 177
    .local v2, "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 178
    .local v0, "extras":Landroid/os/Bundle;
    const-string v4, "mixtapeData"

    invoke-virtual {v0, v4, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 179
    const-string v4, "backScreenTitle"

    const-string v5, "News"

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    invoke-virtual {v2, v0}, Lcom/livemixtapes/Mixtape;->setArguments(Landroid/os/Bundle;)V

    .line 181
    const v4, 0x7f0800cc

    const-string v5, "MIXTAPE"

    invoke-virtual {v1, v4, v2, v5}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 182
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 184
    .end local v0    # "extras":Landroid/os/Bundle;
    .end local v1    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    .end local v2    # "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    .end local v3    # "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_0
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 154
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 155
    new-instance v0, Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v1, v1, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-direct {v0, v1}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    .line 156
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    const-string v1, "Loading.."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 157
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->pd:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 158
    return-void
.end method
