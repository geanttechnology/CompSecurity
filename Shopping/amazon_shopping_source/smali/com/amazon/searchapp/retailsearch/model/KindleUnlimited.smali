.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/KindleUnlimited;
.super Ljava/lang/Object;
.source "KindleUnlimited.java"


# virtual methods
.method public abstract getBadge()Lcom/amazon/searchapp/retailsearch/model/StyledText;
.end method

.method public abstract getIsSubscribed()Z
.end method

.method public abstract getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
.end method

.method public abstract getMessages()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getPrice()Ljava/lang/String;
.end method
