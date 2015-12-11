.class Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable$1;
.super Ljava/lang/Object;
.source "JsonFileIo.java"

# interfaces
.implements Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener",
        "<TT;>;"
    }
.end annotation


# virtual methods
.method public onError(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 74
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable$1;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable.1;"
    return-void
.end method

.method public onItemsWritten()V
    .locals 0

    .prologue
    .line 73
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable$1;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable.1;"
    return-void
.end method
