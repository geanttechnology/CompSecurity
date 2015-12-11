.class public Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileReadRunnable;
.super Ljava/lang/Object;
.source "JsonFileIo.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "JsonFileReadRunnable"
.end annotation


# instance fields
.field final listener:Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 54
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileReadRunnable;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>.JsonFileReadRunnable;"
    :try_start_0
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileReadRunnable;->this$0:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    invoke-virtual {v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->loadItems()Ljava/util/List;

    move-result-object v1

    .line 55
    .local v1, "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileReadRunnable;->listener:Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;

    invoke-interface {v2, v1}, Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;->onItemsRead(Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 59
    .end local v1    # "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :goto_0
    return-void

    .line 56
    :catch_0
    move-exception v0

    .line 57
    .local v0, "e":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileReadRunnable;->listener:Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;

    invoke-interface {v2, v0}, Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;->onError(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
