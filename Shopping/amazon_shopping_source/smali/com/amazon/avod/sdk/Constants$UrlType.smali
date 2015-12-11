.class public final enum Lcom/amazon/avod/sdk/Constants$UrlType;
.super Ljava/lang/Enum;
.source "Constants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/Constants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "UrlType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/sdk/Constants$UrlType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/sdk/Constants$UrlType;

.field public static final enum CONTENT:Lcom/amazon/avod/sdk/Constants$UrlType;

.field public static final enum TRAILER:Lcom/amazon/avod/sdk/Constants$UrlType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 108
    new-instance v0, Lcom/amazon/avod/sdk/Constants$UrlType;

    const-string/jumbo v1, "TRAILER"

    invoke-direct {v0, v1, v2}, Lcom/amazon/avod/sdk/Constants$UrlType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/avod/sdk/Constants$UrlType;->TRAILER:Lcom/amazon/avod/sdk/Constants$UrlType;

    .line 110
    new-instance v0, Lcom/amazon/avod/sdk/Constants$UrlType;

    const-string/jumbo v1, "CONTENT"

    invoke-direct {v0, v1, v3}, Lcom/amazon/avod/sdk/Constants$UrlType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/avod/sdk/Constants$UrlType;->CONTENT:Lcom/amazon/avod/sdk/Constants$UrlType;

    .line 107
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/avod/sdk/Constants$UrlType;

    sget-object v1, Lcom/amazon/avod/sdk/Constants$UrlType;->TRAILER:Lcom/amazon/avod/sdk/Constants$UrlType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/avod/sdk/Constants$UrlType;->CONTENT:Lcom/amazon/avod/sdk/Constants$UrlType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/avod/sdk/Constants$UrlType;->$VALUES:[Lcom/amazon/avod/sdk/Constants$UrlType;

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
    .line 107
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/sdk/Constants$UrlType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 107
    const-class v0, Lcom/amazon/avod/sdk/Constants$UrlType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/Constants$UrlType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/sdk/Constants$UrlType;
    .locals 1

    .prologue
    .line 107
    sget-object v0, Lcom/amazon/avod/sdk/Constants$UrlType;->$VALUES:[Lcom/amazon/avod/sdk/Constants$UrlType;

    invoke-virtual {v0}, [Lcom/amazon/avod/sdk/Constants$UrlType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/sdk/Constants$UrlType;

    return-object v0
.end method
