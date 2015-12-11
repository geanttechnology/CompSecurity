.class public abstract enum Lcom/amazon/mShop/sso/IdentityType;
.super Ljava/lang/Enum;
.source "IdentityType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/sso/IdentityType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/sso/IdentityType;

.field public static final enum CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

.field public static final enum DISTRIBUTED_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

.field public static final enum NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 48
    new-instance v0, Lcom/amazon/mShop/sso/IdentityType$1;

    const-string/jumbo v1, "DISTRIBUTED_SSO_TYPE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/sso/IdentityType$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/sso/IdentityType;->DISTRIBUTED_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    .line 450
    new-instance v0, Lcom/amazon/mShop/sso/IdentityType$2;

    const-string/jumbo v1, "CENTRAL_SSO_TYPE"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/sso/IdentityType$2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    .line 653
    new-instance v0, Lcom/amazon/mShop/sso/IdentityType$3;

    const-string/jumbo v1, "NON_SSO_TYPE"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/sso/IdentityType$3;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    .line 35
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/sso/IdentityType;

    sget-object v1, Lcom/amazon/mShop/sso/IdentityType;->DISTRIBUTED_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/sso/IdentityType;->$VALUES:[Lcom/amazon/mShop/sso/IdentityType;

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
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/amazon/mShop/sso/IdentityType$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/amazon/mShop/sso/IdentityType$1;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/sso/IdentityType;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/sso/IdentityType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 35
    const-class v0, Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/sso/IdentityType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/sso/IdentityType;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->$VALUES:[Lcom/amazon/mShop/sso/IdentityType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/sso/IdentityType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/sso/IdentityType;

    return-object v0
.end method


# virtual methods
.method public abstract handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V
.end method

.method public abstract handleSSOInit(Landroid/content/Context;)V
.end method

.method public abstract handleSSOLogin(Landroid/app/Activity;)V
.end method

.method public abstract handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V
.end method

.method public abstract handleSSOLogin(Landroid/content/Context;Ljava/lang/String;I)V
.end method

.method public abstract handleSSOLogout(Lcom/amazon/mShop/AmazonActivity;)V
.end method
