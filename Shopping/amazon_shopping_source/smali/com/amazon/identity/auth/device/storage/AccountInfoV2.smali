.class public Lcom/amazon/identity/auth/device/storage/AccountInfoV2;
.super Ljava/lang/Object;
.source "AccountInfoV2.java"


# instance fields
.field public final accountData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final directedId:Ljava/lang/String;

.field public final displayName:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenDisplayName"    # Ljava/lang/String;

    .prologue
    .line 19
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 20
    return-void
.end method

.method constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenDisplayName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p3, "givenTokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->directedId:Ljava/lang/String;

    .line 25
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->displayName:Ljava/lang/String;

    .line 27
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/AccountInfoV2;->accountData:Ljava/util/Map;

    .line 28
    return-void
.end method
