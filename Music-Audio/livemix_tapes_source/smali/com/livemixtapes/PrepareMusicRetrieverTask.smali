.class public Lcom/livemixtapes/PrepareMusicRetrieverTask;
.super Landroid/os/AsyncTask;
.source "PrepareMusicRetrieverTask.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field mListener:Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;

.field mRetriever:Lcom/livemixtapes/MusicRetriever;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/MusicRetriever;Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;)V
    .locals 0
    .param p1, "retriever"    # Lcom/livemixtapes/MusicRetriever;
    .param p2, "listener"    # Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/livemixtapes/PrepareMusicRetrieverTask;->mRetriever:Lcom/livemixtapes/MusicRetriever;

    .line 29
    iput-object p2, p0, Lcom/livemixtapes/PrepareMusicRetrieverTask;->mListener:Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;

    .line 30
    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/PrepareMusicRetrieverTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 1
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/livemixtapes/PrepareMusicRetrieverTask;->mRetriever:Lcom/livemixtapes/MusicRetriever;

    invoke-virtual {v0}, Lcom/livemixtapes/MusicRetriever;->prepare()V

    .line 34
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/PrepareMusicRetrieverTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/livemixtapes/PrepareMusicRetrieverTask;->mListener:Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;

    invoke-interface {v0}, Lcom/livemixtapes/PrepareMusicRetrieverTask$MusicRetrieverPreparedListener;->onMusicRetrieverPrepared()V

    .line 39
    return-void
.end method
