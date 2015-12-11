.class public interface abstract Lcom/comcast/playerplatform/analytics/java/util/FileIo$FileReadListener;
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
    name = "FileReadListener"
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
.method public abstract onItemsRead(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation
.end method
