.class final enum Lcom/amazon/mShop/sso/SSOUtil$AuthPool$3;
.super Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
.source "SSOUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 256
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;-><init>(Ljava/lang/String;ILcom/amazon/mShop/sso/SSOUtil$1;)V

    return-void
.end method


# virtual methods
.method public getLocaleList()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 260
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 261
    .local v0, "localeList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v1, "ja_JP"

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 262
    return-object v0
.end method
