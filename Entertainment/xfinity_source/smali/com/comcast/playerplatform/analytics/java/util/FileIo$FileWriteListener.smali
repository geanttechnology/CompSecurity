.class public interface abstract Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileWriteListener;
.super Ljava/lang/Object;
.source "FileIo.java"

# interfaces
.implements Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileError;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/util/FileIo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "FileWriteListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileError;"
    }
.end annotation


# virtual methods
.method public abstract onItemsWritten()V
.end method
