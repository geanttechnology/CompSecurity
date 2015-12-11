.class public abstract enum Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
.super Ljava/lang/Enum;
.source "SSOUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/sso/SSOUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4409
    name = "AuthPool"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/sso/SSOUtil$AuthPool;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

.field public static final enum Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

.field public static final enum AmazonCN:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

.field public static final enum AmazonJP:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 222
    new-instance v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool$1;

    const-string/jumbo v1, "Amazon"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    .line 243
    new-instance v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool$2;

    const-string/jumbo v1, "AmazonCN"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool$2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->AmazonCN:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    .line 256
    new-instance v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool$3;

    const-string/jumbo v1, "AmazonJP"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool$3;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->AmazonJP:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    .line 218
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->AmazonCN:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->AmazonJP:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->$VALUES:[Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 218
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/amazon/mShop/sso/SSOUtil$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/amazon/mShop/sso/SSOUtil$1;

    .prologue
    .line 218
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static getAllLocalesList()Ljava/util/List;
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
    .line 270
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 271
    .local v0, "localeList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getLocaleList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 272
    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->AmazonCN:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getLocaleList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 273
    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->AmazonJP:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getLocaleList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 274
    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 218
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
    .locals 1

    .prologue
    .line 218
    sget-object v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->$VALUES:[Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v0}, [Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    return-object v0
.end method


# virtual methods
.method public abstract getLocaleList()Ljava/util/List;
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
