.class public final enum Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;
.super Ljava/lang/Enum;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil$Config;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "BUILD_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

.field private static final synthetic ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

.field public static final enum ESilver:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 34
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    const-string v1, "ESilver"

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->ESilver:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    .line 35
    new-instance v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    const-string v1, "EGold"

    invoke-direct {v0, v1, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    .line 33
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->ESilver:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->EGold:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;->ENUM$VALUES:[Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    array-length v1, v0

    new-array v2, v1, [Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
