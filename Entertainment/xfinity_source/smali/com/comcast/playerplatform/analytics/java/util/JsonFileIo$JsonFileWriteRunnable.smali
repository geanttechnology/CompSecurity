.class public Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;
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
    name = "JsonFileWriteRunnable"
.end annotation


# instance fields
.field final items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end field

.field final listener:Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener",
            "<TT;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 87
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>.JsonFileWriteRunnable;"
    :try_start_0
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;->this$0:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;->items:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->saveItems(Ljava/util/List;)V

    .line 88
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;->listener:Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;

    invoke-interface {v1}, Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;->onItemsWritten()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 92
    :goto_0
    return-void

    .line 89
    :catch_0
    move-exception v0

    .line 90
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;->listener:Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;

    invoke-interface {v1, v0}, Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;->onError(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
