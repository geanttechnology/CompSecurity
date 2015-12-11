.class public interface abstract Lcom/xfinity/playerlib/model/consumable/SortableVideo;
.super Ljava/lang/Object;
.source "SortableVideo.java"


# virtual methods
.method public abstract getLanguageCodes()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;
.end method

.method public abstract getProviderCode()Ljava/lang/String;
.end method

.method public abstract getVideoId()J
.end method
