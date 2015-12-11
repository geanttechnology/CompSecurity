.class public interface abstract Lcom/amazon/avod/clickstream/PageInfo;
.super Ljava/lang/Object;
.source "PageInfo.java"


# virtual methods
.method public abstract getPageType()Lcom/amazon/avod/clickstream/PageType;
.end method

.method public abstract getPageTypeID()Ljava/lang/String;
.end method

.method public abstract getPageTypeIDSource()Lcom/amazon/avod/clickstream/PageTypeIDSource;
.end method

.method public abstract getReportableData()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSubPageType()Lcom/amazon/avod/clickstream/SubPageType;
.end method
